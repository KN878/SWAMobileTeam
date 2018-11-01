package com.swa.swamobileteam.utils.cryptoManager;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;

import timber.log.BuildConfig;
import timber.log.Timber;

public class Encrypter {

    private static final String AES_MODE_POST_MARSHMALLOW = "AES/GCM/NoPadding";
    private static final String AES_MODE_PRE_MARSHMALLOW = "AES/ECB/PKCS5Padding";
    private static final int TAG_LENGTH = 128;
    private static final String RSA_MODE = "RSA/NONE/PKCS1Padding";
    private static final String IV = "8eR6y1G4A52h";
    private static final String UTF_8 = "UTF-8";
    private static final String KEY_ALIAS = "alias_rsa";
    private static final String PASSWORD = BuildConfig.APPLICATION_ID;

    public Encrypter() {
    }

    static byte[] rsaEncrypt(byte[] secret, KeyStore keyStore) throws Exception {
        //get RSA key from KeyStore depending on API version
        KeyStore.PrivateKeyEntry privateKeyEntry;
        if (!VersionChecker.lowerThanJB()) {
            privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry(KEY_ALIAS, null);
        } else {
            KeyStore.ProtectionParameter protParam = new KeyStore.PasswordProtection(PASSWORD.toCharArray());
            privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry(KEY_ALIAS, protParam);
        }

        // Encrypt the text
        Cipher inputCipher = Cipher.getInstance(RSA_MODE);
        inputCipher.init(Cipher.ENCRYPT_MODE, privateKeyEntry.getCertificate().getPublicKey());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        CipherOutputStream cipherOutputStream = new CipherOutputStream(outputStream, inputCipher);
        cipherOutputStream.write(secret);
        cipherOutputStream.close();
        byte[] result = outputStream.toByteArray();
        outputStream.close();
        return result;
    }

    static byte[] rsaDecrypt(byte[] encrypted, KeyStore keyStore) throws Exception {
        //get RSA key from KeyStore depending on API version
        KeyStore.PrivateKeyEntry privateKeyEntry;
        if (!VersionChecker.lowerThanJB()) {
            privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry(KEY_ALIAS, null);
        } else {
            KeyStore.ProtectionParameter protParam = new KeyStore.PasswordProtection(PASSWORD.toCharArray());
            privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry(KEY_ALIAS, protParam);
        }

        //Decrypt the text
        Cipher output = Cipher.getInstance(RSA_MODE);
        output.init(Cipher.DECRYPT_MODE, privateKeyEntry.getPrivateKey());
        CipherInputStream cipherInputStream = new CipherInputStream(
                new ByteArrayInputStream(encrypted), output);
        ArrayList<Byte> values = new ArrayList<>();

        int nextByte;
        while ((nextByte = cipherInputStream.read()) != -1) {
            values.add((byte) nextByte);
        }
        byte[] bytes = new byte[values.size()];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = values.get(i);
        }
        cipherInputStream.close();
        return bytes;
    }

    public String encrypt(String data, Key key) {
        try {
            if (!VersionChecker.lowerThanMarshmallow()) {
                return encryptAES23(data, key);
            } else {
                return encryptAES(data, key);
            }
        } catch (Exception e) {
            Timber.e(e);
        }
        return "-1";
    }

    public String decrypt(String encrypted, Key key) {
        try {
            if (!VersionChecker.lowerThanMarshmallow()) {
                return decryptAES23(encrypted, key);
            } else {
                return decryptAES(encrypted, key);
            }
        } catch (Exception e) {
            Timber.e(e);
        }
        return "-1";
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private String encryptAES23(String data, Key key) throws NoSuchPaddingException,
            NoSuchAlgorithmException,
            InvalidAlgorithmParameterException,
            InvalidKeyException,
            BadPaddingException,
            IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(AES_MODE_POST_MARSHMALLOW);
        cipher.init(Cipher.ENCRYPT_MODE, key, new GCMParameterSpec(TAG_LENGTH, IV.getBytes()));
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.encodeToString(encryptedData, Base64.DEFAULT);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private String decryptAES23(String encrypted, Key key) throws NoSuchPaddingException,
            NoSuchAlgorithmException,
            InvalidAlgorithmParameterException,
            InvalidKeyException,
            BadPaddingException,
            IllegalBlockSizeException,
            UnsupportedEncodingException {
        Cipher cipher = Cipher.getInstance(AES_MODE_POST_MARSHMALLOW);
        cipher.init(Cipher.DECRYPT_MODE, key, new GCMParameterSpec(TAG_LENGTH, IV.getBytes()));
        byte[] decryptedData = cipher.doFinal(Base64.decode(encrypted, Base64.DEFAULT));
        return new String(decryptedData, UTF_8);
    }

    private String encryptAES(String data, Key key) throws BadPaddingException,
            IllegalBlockSizeException,
            InvalidKeyException,
            NoSuchPaddingException,
            NoSuchAlgorithmException {
        Cipher cipher = Cipher.getInstance(AES_MODE_PRE_MARSHMALLOW);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.encodeToString(encryptedData, Base64.DEFAULT);
    }

    private String decryptAES(String encrypted, Key key) throws NoSuchPaddingException,
            NoSuchAlgorithmException,
            InvalidKeyException,
            BadPaddingException,
            IllegalBlockSizeException,
            UnsupportedEncodingException {
        Cipher cipher = Cipher.getInstance(AES_MODE_PRE_MARSHMALLOW);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedData = cipher.doFinal(Base64.decode(encrypted, Base64.DEFAULT));
        return new String(decryptedData, UTF_8);
    }

}
