package com.amazon.apay.instrumentation.encryptor;

import android.util.Base64;
import in.juspay.hypersdk.core.Constants;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f15032a;

    public a(String clientId) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        this.f15032a = clientId;
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object, java.util.Map] */
    public final Map a(String dataToBeEncrypted) throws Exception {
        Intrinsics.checkNotNullParameter(dataToBeEncrypted, "dataToBeEncrypted");
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(CLConstants.AES_KEY_VAULT_KEY);
            keyGenerator.init(256);
            SecretKey secretKeyGenerateKey = keyGenerator.generateKey();
            Intrinsics.checkNotNullExpressionValue(secretKeyGenerateKey, "keyGenerator.generateKey()");
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKeyGenerateKey.getEncoded(), CLConstants.AES_KEY_VAULT_KEY);
            byte[] bArr = new byte[cipher.getBlockSize()];
            new SecureRandom().nextBytes(bArr);
            cipher.init(1, secretKeySpec, new IvParameterSpec(bArr));
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            byte[] bytes = dataToBeEncrypted.getBytes(UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            byte[] cipherText = cipher.doFinal(bytes);
            byte[] encoded = secretKeyGenerateKey.getEncoded();
            Intrinsics.checkNotNullExpressionValue(encoded, "sessionKey.encoded");
            Object obj = com.amazon.apay.instrumentation.constants.a.f15031a.get(this.f15032a);
            Intrinsics.c(obj);
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            byte[] bytes2 = ((String) obj).getBytes(UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
            byte[] bArrDecode = Base64.decode(bytes2, 2);
            Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(publicKey.toByteA…s.UTF_8), Base64.NO_WRAP)");
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(Constants.ALG_RSA).generatePublic(new X509EncodedKeySpec(bArrDecode));
            Intrinsics.checkNotNullExpressionValue(publicKeyGeneratePublic, "kf.generatePublic(X509publicKey)");
            try {
                Cipher cipher2 = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
                cipher2.init(1, publicKeyGeneratePublic);
                byte[] cipherTextInBytes = cipher2.doFinal(encoded);
                Intrinsics.checkNotNullExpressionValue(cipherTextInBytes, "cipherTextInBytes");
                Intrinsics.checkNotNullExpressionValue(cipherText, "cipherText");
                return b(cipherTextInBytes, cipherText, bArr);
            } catch (Exception e2) {
                throw new Exception("Exception occured while encrypting session key using RSA encryption algorithm.", e2);
            }
        } catch (Exception e3) {
            throw new Exception("Exception occured while encrypting data using AES encryption algorithm.", e3);
        }
    }

    public final Map b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArrEncode = Base64.encode(bArr2, 11);
        Intrinsics.checkNotNullExpressionValue(bArrEncode, "encode(cipherText, Base6…ADDING or Base64.NO_WRAP)");
        Charset charset = Charsets.UTF_8;
        String str = new String(bArrEncode, charset);
        byte[] bArrEncode2 = Base64.encode(bArr3, 11);
        Intrinsics.checkNotNullExpressionValue(bArrEncode2, "encode(initializationVec…ADDING or Base64.NO_WRAP)");
        String str2 = new String(bArrEncode2, charset);
        byte[] bArrEncode3 = Base64.encode(bArr, 11);
        Intrinsics.checkNotNullExpressionValue(bArrEncode3, "encode(encryptedSessionK…ADDING or Base64.NO_WRAP)");
        return MapsKt.h(new Pair("encryptedData", str), new Pair("iv", str2), new Pair("encryptedSessionKey", new String(bArrEncode3, charset)), new Pair("clientId", this.f15032a));
    }
}
