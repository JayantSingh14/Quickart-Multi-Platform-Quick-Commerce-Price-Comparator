package org.npci.upi.security.pinactivitycomponent;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyInfo;
import android.util.Base64;
import in.juspay.hypersdk.core.Constants;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.MGF1ParameterSpec;
import java.util.Calendar;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.x500.X500Principal;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: classes5.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    Cipher f57529a = Cipher.getInstance("AES/GCM/NoPadding");

    /* renamed from: b, reason: collision with root package name */
    byte[] f57530b = new byte[32];

    /* renamed from: c, reason: collision with root package name */
    byte[] f57531c = new byte[16];

    public static String c(String str, String str2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        String[] strArrSplit = str.split(CLConstants.DELIMITER_REGEX);
        byte[] bArrDecode = Base64.decode(strArrSplit[0], 2);
        byte[] bArrDecode2 = Base64.decode(str2, 2);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(2, new SecretKeySpec(bArrDecode2, CLConstants.AES_KEY_VAULT_KEY), new GCMParameterSpec(128, Base64.decode(strArrSplit[1], 2)));
        return new String(cipher.doFinal(bArrDecode));
    }

    public Boolean a(String str, String str2, PublicKey publicKey) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, UnsupportedEncodingException {
        byte[] bytes = str.getBytes("UTF8");
        byte[] bArrDecode = Base64.decode(str2, 2);
        Signature signature = Signature.getInstance("SHA512withRSA/PSS");
        signature.initVerify(publicKey);
        signature.update(bytes);
        return Boolean.valueOf(signature.verify(bArrDecode));
    }

    public String b(String str, String str2) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] bytes = str.getBytes();
        byte[] bArrDecode = Base64.decode(str2, 2);
        byte[] bArrB = b();
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(1, new SecretKeySpec(bArrDecode, CLConstants.AES_KEY_VAULT_KEY), new GCMParameterSpec(128, bArrB));
        return Base64.encodeToString(cipher.doFinal(bytes), 2) + CLConstants.SALT_DELIMETER + Base64.encodeToString(bArrB, 2);
    }

    public String a(String str, Boolean bool) throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(1, 999);
        calendar.add(2, -1);
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(Constants.ALG_RSA, "AndroidKeyStore");
        KeyGenParameterSpec.Builder builder = new KeyGenParameterSpec.Builder(str, 12);
        if (Build.VERSION.SDK_INT >= 30) {
            builder.setUserAuthenticationParameters(15, 3);
        } else {
            builder.setUserAuthenticationValidityDurationSeconds(15);
        }
        keyPairGenerator.initialize(builder.setKeySize(2048).setKeyValidityStart(calendar.getTime()).setKeyValidityEnd(calendar2.getTime()).setDigests(MessageDigestAlgorithms.SHA_512).setUserAuthenticationRequired(bool.booleanValue()).setSignaturePaddings("PSS").setCertificateSubject(new X500Principal(CLConstants.CERTIFICATE_SUBJECT)).setCertificateSerialNumber(BigInteger.ONE).build());
        KeyPair keyPairGenKeyPair = keyPairGenerator.genKeyPair();
        PrivateKey privateKey = keyPairGenKeyPair.getPrivate();
        if (((KeyInfo) KeyFactory.getInstance(privateKey.getAlgorithm(), "AndroidKeyStore").getKeySpec(privateKey, KeyInfo.class)).isInsideSecureHardware()) {
            return Base64.encodeToString(keyPairGenKeyPair.getPublic().getEncoded(), 2);
        }
        throw new InvalidKeySpecException("TEE is unavailable");
    }

    public SecretKey b(String str) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(CLConstants.AES_KEY_VAULT_KEY, "AndroidKeyStore");
            keyGenerator.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes("GCM").setUserAuthenticationRequired(false).setEncryptionPaddings("NoPadding").build());
            return keyGenerator.generateKey();
        } catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException e2) {
            throw new RuntimeException("Failed to create symmetric key ", e2);
        }
    }

    public byte[] c(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) Integer.parseInt(str.substring(i3, i3 + 2), 16);
        }
        return bArr;
    }

    public String a(String str, PublicKey publicKey) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] bArrDoFinal;
        byte[] bytes = str.getBytes();
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPwithSHA-256andMGF1Padding");
            cipher.init(1, publicKey, new OAEPParameterSpec(MessageDigestAlgorithms.SHA_256, "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT));
            bArrDoFinal = cipher.doFinal(bytes);
        } catch (Exception unused) {
            q.a("CommonLibrary", "Exception while encrypting data");
            bArrDoFinal = null;
        }
        return Base64.encodeToString(bArrDoFinal, 2);
    }

    public byte[] b() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[Cipher.getInstance("AES/GCM/NoPadding").getBlockSize()];
        secureRandom.nextBytes(bArr);
        return bArr;
    }

    public String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            sb.append(String.format("%02x", Integer.valueOf(b2 & 255)));
        }
        return sb.toString();
    }

    public byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, CLConstants.AES_KEY_VAULT_KEY);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(2, secretKeySpec, new GCMParameterSpec(128, bArr3));
        return cipher.doFinal(bArr);
    }

    public SecretKey a() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(CLConstants.AES_KEY_VAULT_KEY);
        keyGenerator.init(256);
        return keyGenerator.generateKey();
    }

    public byte[] a(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            messageDigest.update(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e2) {
            q.a("CommonLibrary", e2);
        }
        return messageDigest.digest();
    }

    public byte[] a(String str, String str2) throws NoSuchAlgorithmException {
        byte[] bArrDecode = Base64.decode(str2, 2);
        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
        messageDigest.update(bArrDecode);
        return messageDigest.digest(str.getBytes("UTF-8"));
    }

    public byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, CLConstants.AES_KEY_VAULT_KEY);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(1, secretKeySpec, new GCMParameterSpec(128, bArr3));
        return cipher.doFinal(bArr);
    }
}
