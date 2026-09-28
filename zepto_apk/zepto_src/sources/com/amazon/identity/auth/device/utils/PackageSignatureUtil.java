package com.amazon.identity.auth.device.utils;

import android.annotation.SuppressLint;
import android.content.pm.Signature;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

@SuppressLint({"PackageManagerGetSignatures"})
/* loaded from: classes3.dex */
public class PackageSignatureUtil {
    public static String a(Signature signature, int i2) throws IOException, CertificateException {
        String str;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(signature.toByteArray());
        Certificate certificateGenerateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream);
        byteArrayInputStream.close();
        byte[] encoded = certificateGenerateCertificate.getEncoded();
        if (i2 == 1) {
            str = MessageDigestAlgorithms.MD5;
        } else {
            if (i2 != 2) {
                throw null;
            }
            str = MessageDigestAlgorithms.SHA_256;
        }
        byte[] bArrDigest = MessageDigest.getInstance(str).digest(encoded);
        if (bArrDigest == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArrDigest) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString();
    }
}
