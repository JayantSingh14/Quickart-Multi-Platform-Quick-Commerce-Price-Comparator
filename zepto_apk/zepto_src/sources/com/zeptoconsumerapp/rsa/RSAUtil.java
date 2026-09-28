package com.zeptoconsumerapp.rsa;

import android.util.Base64;
import in.juspay.hypersdk.core.Constants;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.lang3.StringUtils;

@Metadata
/* loaded from: classes4.dex */
public final class RSAUtil {
    public static String a(String base64Key) {
        Intrinsics.checkNotNullParameter(base64Key, "base64Key");
        byte[] bArrDecode = Base64.decode(base64Key, 0);
        Intrinsics.c(bArrDecode);
        return StringsKt.e0("\n            -----BEGIN PUBLIC KEY-----\n            " + CollectionsKt.E(StringsKt.l(64, new Regex("\\s").replace(StringsKt.K(StringsKt.K(new String(bArrDecode, Charsets.UTF_8), "-----BEGIN PUBLIC KEY-----", ""), "-----END PUBLIC KEY-----", ""), "")), StringUtils.LF, null, null, null, 62) + "\n            -----END PUBLIC KEY-----\n        ");
    }

    public static String b(PrivateKey privateKey, String encryptedB64) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Intrinsics.checkNotNullParameter(privateKey, "privateKey");
        Intrinsics.checkNotNullParameter(encryptedB64, "encryptedB64");
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        cipher.init(2, privateKey, new OAEPParameterSpec(MessageDigestAlgorithms.SHA_256, "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT));
        byte[] bArrDoFinal = cipher.doFinal(Base64.decode(encryptedB64, 0));
        Intrinsics.c(bArrDoFinal);
        return new String(bArrDoFinal, Charsets.UTF_8);
    }

    public static String c(PublicKey publicKey, String plainText) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Intrinsics.checkNotNullParameter(publicKey, "publicKey");
        Intrinsics.checkNotNullParameter(plainText, "plainText");
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        cipher.init(1, publicKey, new OAEPParameterSpec(MessageDigestAlgorithms.SHA_256, "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT));
        byte[] bytes = plainText.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        String strEncodeToString = Base64.encodeToString(cipher.doFinal(bytes), 2);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }

    public static PrivateKey d(String pem) throws InvalidKeySpecException {
        Intrinsics.checkNotNullParameter(pem, "pem");
        PrivateKey privateKeyGeneratePrivate = KeyFactory.getInstance(Constants.ALG_RSA).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(new Regex("\\s").replace(StringsKt.K(StringsKt.K(pem, "-----BEGIN PRIVATE KEY-----", ""), "-----END PRIVATE KEY-----", ""), ""), 0)));
        Intrinsics.checkNotNullExpressionValue(privateKeyGeneratePrivate, "generatePrivate(...)");
        return privateKeyGeneratePrivate;
    }

    public static PublicKey e(String pem) throws InvalidKeySpecException {
        Intrinsics.checkNotNullParameter(pem, "pem");
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(Constants.ALG_RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(new Regex("\\s").replace(StringsKt.K(StringsKt.K(pem, "-----BEGIN PUBLIC KEY-----", ""), "-----END PUBLIC KEY-----", ""), ""), 0)));
        Intrinsics.checkNotNullExpressionValue(publicKeyGeneratePublic, "generatePublic(...)");
        return publicKeyGeneratePublic;
    }
}
