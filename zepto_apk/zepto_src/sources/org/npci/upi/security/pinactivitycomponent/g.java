package org.npci.upi.security.pinactivitycomponent;

import android.content.Context;
import android.content.SharedPreferences;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import in.juspay.hypersdk.core.Constants;
import java.io.IOException;
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
import java.security.cert.CertificateException;
import java.security.spec.MGF1ParameterSpec;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import javax.security.auth.x500.X500Principal;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: classes5.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final SharedPreferences f57532a;

    /* renamed from: b, reason: collision with root package name */
    private Context f57533b;

    public g(Context context) {
        this.f57532a = context.getSharedPreferences("Data", 0);
        this.f57533b = context;
    }

    public String a(String str, String str2) {
        try {
            return this.f57532a.getString(str, str2);
        } catch (Exception e2) {
            q.a("Error", e2);
            return null;
        }
    }

    public int b(y yVar) {
        return 1;
    }

    public void c() {
        SharedPreferences.Editor editorEdit = this.f57532a.edit();
        editorEdit.clear();
        editorEdit.commit();
    }

    public String a(String str, String str2, String str3) {
        return a().get(0).b();
    }

    public String b() {
        return a().get(0).c();
    }

    public List<y> a() throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        ArrayList arrayList = new ArrayList();
        try {
            String string = this.f57532a.getString(CLConstants.SHARED_PREFERENCE_ITEM_ID, "");
            String string2 = this.f57532a.getString(CLConstants.SHARED_PREFERENCE_ITEM_K0, "");
            String string3 = this.f57532a.getString(CLConstants.SHARED_PREFERENCE_ITEM_DATE, "");
            String string4 = this.f57532a.getString(CLConstants.SHARED_PREFERENCE_ITEM_TOKEN, "");
            String string5 = this.f57532a.getString(CLConstants.SHARED_PREFERENCE_ITEM_DATAKEY, "");
            byte[] bArrDecode = Base64.decode(this.f57532a.getString("random", ""), 2);
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            if (keyStore.containsAlias(CLConstants.KEYSTORE_ALIAS)) {
                byte[] bArrA = a(((KeyStore.PrivateKeyEntry) keyStore.getEntry(CLConstants.KEYSTORE_ALIAS, null)).getPrivateKey(), string5);
                f fVar = new f();
                int iIntValue = Integer.valueOf(new String(fVar.b(Base64.decode(string, 2), bArrA, bArrDecode))).intValue();
                String str = new String(fVar.b(Base64.decode(string2, 2), bArrA, bArrDecode));
                String str2 = new String(fVar.b(Base64.decode(string4, 2), bArrA, bArrDecode));
                String str3 = new String(fVar.b(Base64.decode(string3, 2), bArrA, bArrDecode));
                y yVar = new y();
                yVar.a(iIntValue);
                yVar.a(str);
                yVar.b(str2);
                yVar.c(str3);
                arrayList.add(yVar);
                return arrayList;
            }
        } catch (Exception e2) {
            q.a("error", e2);
        }
        return arrayList;
    }

    public void b(String str, String str2) {
        SharedPreferences.Editor editorEdit = this.f57532a.edit();
        editorEdit.putString(str, str2);
        editorEdit.commit();
    }

    public void a(y yVar) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, InvalidKeyException, KeyStoreException, CertificateException, NoSuchProviderException, InvalidAlgorithmParameterException {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            byte[] bArrDoFinal = null;
            keyStore.load(null);
            if (!keyStore.containsAlias(CLConstants.KEYSTORE_ALIAS)) {
                Calendar calendar = Calendar.getInstance();
                Calendar calendar2 = Calendar.getInstance();
                calendar2.add(1, 999);
                calendar.add(2, -1);
                KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(Constants.ALG_RSA, "AndroidKeyStore");
                keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(CLConstants.KEYSTORE_ALIAS, 3).setDigests(MessageDigestAlgorithms.SHA_256).setEncryptionPaddings("OAEPPadding").setKeySize(2048).setKeyValidityStart(calendar.getTime()).setKeyValidityEnd(calendar2.getTime()).setCertificateSubject(new X500Principal(CLConstants.CERTIFICATE_SUBJECT)).setCertificateSerialNumber(BigInteger.ONE).build());
                keyPairGenerator.generateKeyPair();
            }
            KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry(CLConstants.KEYSTORE_ALIAS, null);
            privateKeyEntry.getPrivateKey();
            PublicKey publicKey = privateKeyEntry.getCertificate().getPublicKey();
            KeyGenerator keyGenerator = KeyGenerator.getInstance(CLConstants.AES_KEY_VAULT_KEY);
            keyGenerator.init(256);
            byte[] encoded = keyGenerator.generateKey().getEncoded();
            try {
                Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPwithSHA-256andMGF1Padding");
                cipher.init(1, publicKey, new OAEPParameterSpec(MessageDigestAlgorithms.SHA_256, "MGF1", MGF1ParameterSpec.SHA1, PSource.PSpecified.DEFAULT));
                bArrDoFinal = cipher.doFinal(encoded);
            } catch (Exception unused) {
                q.a("CommonLibrary", "Exception while encrypting data");
            }
            String strEncodeToString = Base64.encodeToString(bArrDoFinal, 2);
            f fVar = new f();
            byte[] bArrB = fVar.b();
            String strEncodeToString2 = Base64.encodeToString(bArrB, 2);
            String strEncodeToString3 = Base64.encodeToString(fVar.a(String.valueOf(yVar.a()).getBytes(), encoded, bArrB), 2);
            String strEncodeToString4 = Base64.encodeToString(fVar.a(String.valueOf(yVar.b()).getBytes(), encoded, bArrB), 2);
            String strEncodeToString5 = Base64.encodeToString(fVar.a(String.valueOf(yVar.d()).getBytes(), encoded, bArrB), 2);
            String strEncodeToString6 = Base64.encodeToString(fVar.a(String.valueOf(yVar.c()).getBytes(), encoded, bArrB), 2);
            SharedPreferences.Editor editorEdit = this.f57532a.edit();
            editorEdit.putString(CLConstants.SHARED_PREFERENCE_ITEM_ID, strEncodeToString3);
            editorEdit.putString(CLConstants.SHARED_PREFERENCE_ITEM_K0, strEncodeToString4);
            editorEdit.putString(CLConstants.SHARED_PREFERENCE_ITEM_DATE, strEncodeToString5);
            editorEdit.putString(CLConstants.SHARED_PREFERENCE_ITEM_TOKEN, strEncodeToString6);
            editorEdit.putString(CLConstants.SHARED_PREFERENCE_ITEM_DATAKEY, strEncodeToString);
            editorEdit.putString("random", strEncodeToString2);
            editorEdit.commit();
        } catch (Exception e2) {
            q.a("Error", e2);
        }
    }

    public byte[] a(PrivateKey privateKey, String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] bArrDecode = Base64.decode(str, 2);
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPwithSHA-256andMGF1Padding");
            cipher.init(2, privateKey, new OAEPParameterSpec(MessageDigestAlgorithms.SHA_256, "MGF1", MGF1ParameterSpec.SHA1, PSource.PSpecified.DEFAULT));
            return cipher.doFinal(bArrDecode);
        } catch (Exception unused) {
            q.a("CommonLibrary", "Exception while encrypting data");
            return null;
        }
    }
}
