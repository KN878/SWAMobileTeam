package com.swa.swamobileteam.utils.cryptoManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyProperties;
import android.support.annotation.RequiresApi;
import android.util.Base64;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Calendar;

import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.x500.X500Principal;

import timber.log.BuildConfig;
import timber.log.Timber;

public class KeyStorage {

    private static final String AndroidKeyStore = "AndroidKeyStore";
    private static final String KEY_STORE = "/rsa_storage";
    private static final String KEY_ALIAS = "alias";
    private static final String KEY_ALIAS_RSA = "alias_rsa";
    private static final String ENCRYPTED_KEY = "aes_key";
    private static final String RSA = "RSA";
    private static final String PASSWORD = BuildConfig.APPLICATION_ID;

    private KeyStore keyStore;
    private Context context;
    private SharedPreferences preferences;

    public KeyStorage(Context context, SharedPreferences preferences) {
        this.context = context;
        this.preferences = preferences;
    }

    public void initAndroidKeyStore() {
        try {
            if (!VersionChecker.lowerThanJB()) {
                keyStore = KeyStore.getInstance(AndroidKeyStore);
                keyStore.load(null);
            } else {
                keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                String path = context.getFilesDir().getPath() + KEY_STORE;
                try (FileInputStream fis = new FileInputStream(path)) {
                    keyStore.load(fis, PASSWORD.toCharArray());
                } catch (FileNotFoundException e) {
                    keyStore.load(null, PASSWORD.toCharArray());
                }
            }
        } catch (Exception e) {
            Timber.e(e);
        }
    }

    public void generateKey() {
        try {
            if (!VersionChecker.lowerThanMarshmallow()) {
                if (!keyStore.containsAlias(KEY_ALIAS)) {
                    generateKeyPostM();
                }
            } else {
                if (!keyStore.containsAlias(KEY_ALIAS_RSA)) {
                    generateKeyPreM();
                }
            }
        } catch (Exception e) {
            Timber.e(e);
        }
    }

    public Key getKey() {
        try {
            if (!VersionChecker.lowerThanMarshmallow()) {
                return keyStore.getKey(KEY_ALIAS, null);
            } else {
                return getKeyFromPreferences();
            }
        } catch (Exception e) {
            Timber.e(e);
        }
        return null;
    }

    public void deleteKey() {
        try {
            if (!VersionChecker.lowerThanMarshmallow()) {
                keyStore.deleteEntry(KEY_ALIAS);
            } else {
                keyStore.deleteEntry(KEY_ALIAS_RSA);
                preferences.edit().remove(ENCRYPTED_KEY).apply();
            }
        } catch (Exception e) {
            Timber.e(e);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void generateKeyPostM() throws NoSuchProviderException,
            NoSuchAlgorithmException,
            InvalidAlgorithmParameterException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, AndroidKeyStore);
        keyGenerator.init(new KeyGenParameterSpec.Builder(KEY_ALIAS,
                KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
                .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
                .setRandomizedEncryptionRequired(false)
                .build());
        keyGenerator.generateKey();
    }

    private void generateKeyPreM() throws Exception {
        generateRSA();
        byte[] key = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(key);
        byte[] encryptedKey = Encrypter.rsaEncrypt(key, keyStore);
        String encryptedKeyB64 = Base64.encodeToString(encryptedKey, Base64.DEFAULT);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(ENCRYPTED_KEY, encryptedKeyB64);
        editor.commit();
    }

    private void generateRSA() throws NoSuchProviderException,
            NoSuchAlgorithmException,
            InvalidAlgorithmParameterException,
            KeyStoreException,
            IOException,
            CertificateException {
        if (!VersionChecker.lowerThanJB()) {
            generateRSAPostJB();
        } else {
            generateRSAPreJB();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    private void generateRSAPostJB() throws NoSuchProviderException,
            NoSuchAlgorithmException,
            InvalidAlgorithmParameterException {
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        end.add(Calendar.YEAR, 30);

        KeyPairGeneratorSpec spec = new KeyPairGeneratorSpec.Builder(context)
                .setAlias(KEY_ALIAS_RSA)
                .setSubject(new X500Principal("CN=" + KEY_ALIAS_RSA))
                .setSerialNumber(BigInteger.TEN)
                .setStartDate(start.getTime())
                .setEndDate(end.getTime())
                .build();
        KeyPairGenerator kpg = KeyPairGenerator.getInstance(KeyProperties.KEY_ALGORITHM_RSA,
                AndroidKeyStore);
        kpg.initialize(spec);
        kpg.generateKeyPair();
    }

    private void generateRSAPreJB() throws KeyStoreException,
            CertificateException,
            NoSuchAlgorithmException,
            IOException {
        //generating key
        KeyPairGenerator kpg = KeyPairGenerator.getInstance(RSA);
        kpg.initialize(2048);
        KeyPair keyPair = kpg.generateKeyPair();
        //generating X509 certificate
        CertificateGenerator certGen = new CertificateGenerator();
        Certificate[] certChain = new Certificate[1];
        certChain[0] = certGen.generateCertificate(keyPair);
        //saving key
        keyStore.setKeyEntry(KEY_ALIAS_RSA, keyPair.getPrivate(), PASSWORD.toCharArray(), certChain);
        String path = context.getFilesDir().getPath() + KEY_STORE;
        try (FileOutputStream fos = new FileOutputStream(path)) {
            keyStore.store(fos, PASSWORD.toCharArray());
            fos.close();
        }
    }

    private Key getKeyFromPreferences() throws Exception {
        String enryptedKeyB64 = preferences.getString(ENCRYPTED_KEY, null);
        byte[] encryptedKey = Base64.decode(enryptedKeyB64, Base64.DEFAULT);
        byte[] key = Encrypter.rsaDecrypt(encryptedKey, keyStore);
        return new SecretKeySpec(key, "AES");
    }

}
