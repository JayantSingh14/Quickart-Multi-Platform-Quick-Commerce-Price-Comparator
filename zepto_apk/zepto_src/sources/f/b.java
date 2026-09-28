package f;

import android.content.Context;
import android.security.KeyPairGeneratorSpec;
import android.util.Base64;
import in.juspay.hypersdk.core.Constants;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.util.Calendar;
import java.util.HashSet;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.x500.X500Principal;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public static b f48353b;

    /* renamed from: a, reason: collision with root package name */
    public final SecretKeySpec f48354a;

    public b(Context context) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, InvalidKeyException, KeyStoreException, CertificateException, NoSuchProviderException, InvalidAlgorithmParameterException {
        byte[] bArrDoFinal;
        if (context == null) {
            throw new IllegalArgumentException("Context can not be null");
        }
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        if (!keyStore.containsAlias("LWA_KEYSTORE_ALIAS")) {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(1, 30);
            KeyPairGeneratorSpec keyPairGeneratorSpecBuild = new KeyPairGeneratorSpec.Builder(context).setAlias("LWA_KEYSTORE_ALIAS").setSubject(new X500Principal("CN=LWA_KEYSTORE_ALIAS")).setSerialNumber(BigInteger.TEN).setKeySize(2048).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(Constants.ALG_RSA, "AndroidKeyStore");
            keyPairGenerator.initialize(keyPairGeneratorSpecBuild);
            keyPairGenerator.generateKeyPair();
        }
        String string = context.getSharedPreferences("com.amazon.lwa.LWASharedPreferences", 0).getString("com.amazon.lwa.encryption.key", null);
        if (string != null) {
            PrivateKey privateKey = (PrivateKey) keyStore.getKey("LWA_KEYSTORE_ALIAS", null);
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithMD5AndMGF1Padding");
            cipher.init(2, privateKey);
            HashSet hashSet = g.f48361b;
            bArrDoFinal = cipher.doFinal(Base64.decode(string, 2));
        } else {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(CLConstants.AES_KEY_VAULT_KEY);
            keyGenerator.init(256);
            byte[] encoded = keyGenerator.generateKey().getEncoded();
            PublicKey publicKey = keyStore.getCertificate("LWA_KEYSTORE_ALIAS").getPublicKey();
            Cipher cipher2 = Cipher.getInstance("RSA/ECB/OAEPWithMD5AndMGF1Padding");
            cipher2.init(1, publicKey);
            byte[] bArrDoFinal2 = cipher2.doFinal(encoded);
            HashSet hashSet2 = g.f48361b;
            context.getSharedPreferences("com.amazon.lwa.LWASharedPreferences", 0).edit().putString("com.amazon.lwa.encryption.key", bArrDoFinal2 != null ? Base64.encodeToString(bArrDoFinal2, 2) : null).commit();
            bArrDoFinal = encoded;
        }
        if (bArrDoFinal == null) {
            throw new IllegalArgumentException("Encryption key is null!");
        }
        this.f48354a = new SecretKeySpec(bArrDoFinal, CLConstants.AES_KEY_VAULT_KEY);
    }

    public final String a(String str) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        String strSubstring = str.substring(7);
        HashSet hashSet = g.f48361b;
        byte[] bArrDecode = strSubstring == null ? null : Base64.decode(strSubstring, 2);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArrDecode, 0, 16);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, this.f48354a, ivParameterSpec);
        byte[] bArrDoFinal = cipher.doFinal(bArrDecode, 16, bArrDecode.length - 16);
        if (bArrDoFinal != null) {
            try {
                return new String(bArrDoFinal, "utf-8");
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return null;
    }

    public final String b(String str) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
        byte[] bytes;
        if (str == null) {
            throw new IllegalArgumentException("The data to be encrypted is null!");
        }
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        HashSet hashSet = g.f48361b;
        try {
            bytes = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e2) {
            e2.toString();
            bytes = null;
        }
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, this.f48354a, ivParameterSpec);
        byte[] bArrDoFinal = cipher.doFinal(bytes, 0, bytes.length);
        byte[] bArr2 = new byte[bArrDoFinal.length + 16];
        System.arraycopy(bArr, 0, bArr2, 0, 16);
        System.arraycopy(bArrDoFinal, 0, bArr2, 16, bArrDoFinal.length);
        return "AES_00|" + Base64.encodeToString(bArr2, 2);
    }
}
