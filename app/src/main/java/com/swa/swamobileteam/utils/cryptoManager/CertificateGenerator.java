package com.swa.swamobileteam.utils.cryptoManager;

import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.cert.X509CertificateHolder;
import org.spongycastle.cert.X509v3CertificateBuilder;
import org.spongycastle.cert.jcajce.JcaX509CertificateConverter;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.operator.ContentSigner;
import org.spongycastle.operator.OperatorCreationException;
import org.spongycastle.operator.jcajce.JcaContentSignerBuilder;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import timber.log.Timber;

public class CertificateGenerator {

    static {
        Security.insertProviderAt(new BouncyCastleProvider(), 1);
    }

    public X509Certificate generateCertificate(KeyPair keyPair) {
        Calendar start = new GregorianCalendar();
        Calendar end = new GregorianCalendar();
        end.add(Calendar.YEAR, 200);
        X509v3CertificateBuilder certBuilder = new X509v3CertificateBuilder(
                new X500Name("CN=localhost"),
                new BigInteger(10, new Random()),
                start.getTime(),
                end.getTime(),
                new X500Name("CN=localhost"),
                SubjectPublicKeyInfo.getInstance(keyPair.getPublic().getEncoded()));
        PrivateKey signingKey = keyPair.getPrivate();
        X509Certificate certChain = null;
        try {
            ContentSigner signer = new JcaContentSignerBuilder("SHA1WithRSAEncryption").
                    setProvider(new BouncyCastleProvider()).build(signingKey);
            X509CertificateHolder holder = certBuilder.build(signer);

            certChain = new JcaX509CertificateConverter().setProvider(new BouncyCastleProvider())
                    .getCertificate(holder);
        } catch (GeneralSecurityException | OperatorCreationException e) {
            Timber.e(e);
        }

        return certChain;
    }
}
