package org.npci.upi.security.pinactivitycomponent;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
class z {

    /* renamed from: b, reason: collision with root package name */
    private static z f57677b;

    /* renamed from: d, reason: collision with root package name */
    private static String f57678d;

    /* renamed from: e, reason: collision with root package name */
    private Context f57681e;

    /* renamed from: f, reason: collision with root package name */
    private SecretKey f57682f;

    /* renamed from: c, reason: collision with root package name */
    private String f57680c = "AES/GCM/NoPadding";

    /* renamed from: a, reason: collision with root package name */
    f f57679a = new f();

    private z(String str, Context context) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, InvalidKeyException, KeyStoreException, CertificateException {
        f57678d = str;
        this.f57681e = context;
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            this.f57682f = (SecretKey) keyStore.getKey(str + CLConstants.SHARED_PREFERENCE_VAULT_KEY_ALIAS, null);
            Cipher.getInstance(this.f57680c).init(1, this.f57682f);
        } catch (InvalidKeyException unused) {
            a();
        }
    }

    public String a(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            SharedPreferences sharedPreferences = this.f57681e.getSharedPreferences(CLConstants.SHARED_PREFERENCE_VAULT, 0);
            String string = sharedPreferences.getString(f57678d, null);
            String string2 = sharedPreferences.getString(f57678d + CLConstants.INITIALIZATION_VECTOR_VAULT_SUFFIX, null);
            if (string != null) {
                byte[] bArrDecode = Base64.decode(string, 2);
                byte[] bArrDecode2 = Base64.decode(string2, 2);
                Cipher cipher = Cipher.getInstance(this.f57680c);
                cipher.init(2, this.f57682f, new GCMParameterSpec(128, bArrDecode2));
                return new JSONObject(new String(cipher.doFinal(bArrDecode), "UTF-8")).optString(str, "");
            }
        } catch (Exception e2) {
            q.a("Vault getFromVault", e2);
        }
        return "";
    }

    public static z a(String str, Context context) {
        if ((f57677b == null) | (true ^ str.equals(f57678d))) {
            f57677b = new z(str, context);
        }
        return f57677b;
    }

    public void a() throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        this.f57682f = this.f57679a.b(f57678d + CLConstants.SHARED_PREFERENCE_VAULT_KEY_ALIAS);
        Cipher cipher = Cipher.getInstance(this.f57680c);
        cipher.init(1, this.f57682f);
        byte[] iv = cipher.getIV();
        byte[] bArrDoFinal = cipher.doFinal("{}".getBytes("UTF-8"));
        SharedPreferences sharedPreferences = this.f57681e.getSharedPreferences(CLConstants.SHARED_PREFERENCE_VAULT, 0);
        sharedPreferences.edit().putString(f57678d, Base64.encodeToString(bArrDoFinal, 2)).apply();
        sharedPreferences.edit().putString(android.support.v4.media.b.r(new StringBuilder(), f57678d, CLConstants.INITIALIZATION_VECTOR_VAULT_SUFFIX), Base64.encodeToString(iv, 2)).apply();
    }

    public synchronized void a(String str, String str2) {
        String str3;
        JSONObject jSONObject;
        try {
            SharedPreferences sharedPreferences = this.f57681e.getSharedPreferences(CLConstants.SHARED_PREFERENCE_VAULT, 0);
            String string = sharedPreferences.getString(f57678d, null);
            String string2 = sharedPreferences.getString(f57678d + CLConstants.INITIALIZATION_VECTOR_VAULT_SUFFIX, null);
            if (string != null) {
                byte[] bArrDecode = Base64.decode(string, 2);
                byte[] bArrDecode2 = Base64.decode(string2, 2);
                Cipher cipher = Cipher.getInstance(this.f57680c);
                cipher.init(2, this.f57682f, new GCMParameterSpec(128, bArrDecode2));
                str3 = new String(cipher.doFinal(bArrDecode), "UTF-8");
            } else {
                str3 = "{}";
            }
            try {
                jSONObject = new JSONObject(str3);
            } catch (JSONException unused) {
                jSONObject = new JSONObject();
            }
            jSONObject.put(str2, str);
            byte[] bytes = jSONObject.toString().getBytes("UTF-8");
            Cipher cipher2 = Cipher.getInstance(this.f57680c);
            cipher2.init(1, this.f57682f);
            byte[] iv = cipher2.getIV();
            sharedPreferences.edit().putString(f57678d, Base64.encodeToString(cipher2.doFinal(bytes), 2)).apply();
            sharedPreferences.edit().putString(f57678d + CLConstants.INITIALIZATION_VECTOR_VAULT_SUFFIX, Base64.encodeToString(iv, 2)).apply();
        } catch (Throwable th) {
            throw th;
        }
    }
}
