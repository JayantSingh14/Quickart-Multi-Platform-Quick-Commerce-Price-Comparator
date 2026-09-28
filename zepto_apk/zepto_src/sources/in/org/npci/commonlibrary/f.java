package in.org.npci.commonlibrary;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.MGF1ParameterSpec;
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
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.npci.upi.security.pinactivitycomponent.q;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    Cipher f49202a = Cipher.getInstance("AES/GCM/NoPadding");

    /* renamed from: b, reason: collision with root package name */
    byte[] f49203b = new byte[32];

    /* renamed from: c, reason: collision with root package name */
    byte[] f49204c = new byte[16];

    public String a(String str, PublicKey publicKey) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] bArrDoFinal;
        byte[] bytes = str.getBytes();
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPwithSHA-256andMGF1Padding");
            cipher.init(1, publicKey, new OAEPParameterSpec(MessageDigestAlgorithms.SHA_256, "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT));
            bArrDoFinal = cipher.doFinal(bytes);
        } catch (Exception e2) {
            q.a("commonLibrary", e2);
            bArrDoFinal = null;
        }
        return a.b(bArrDoFinal, 2);
    }

    public byte[] b() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[Cipher.getInstance("AES/GCM/NoPadding").getBlockSize()];
        secureRandom.nextBytes(bArr);
        return bArr;
    }

    public SecretKey a() throws NoSuchAlgorithmException {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(CLConstants.AES_KEY_VAULT_KEY);
            keyGenerator.init(256);
            return keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException e2) {
            q.a("commonLibrary", e2);
            return null;
        }
    }

    public byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, CLConstants.AES_KEY_VAULT_KEY);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(2, secretKeySpec, new GCMParameterSpec(128, bArr3));
        return cipher.doFinal(bArr);
    }

    public byte[] a(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) Integer.parseInt(str.substring(i3, i3 + 2), 16);
        }
        return bArr;
    }

    public byte[] a(String str, String str2) throws NoSuchAlgorithmException {
        byte[] bArrA = a.a(str2, 2);
        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
        messageDigest.update(bArrA);
        return messageDigest.digest(str.getBytes("UTF-8"));
    }

    public byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, CLConstants.AES_KEY_VAULT_KEY);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(1, secretKeySpec, new GCMParameterSpec(128, bArr3));
        return cipher.doFinal(bArr);
    }
}
