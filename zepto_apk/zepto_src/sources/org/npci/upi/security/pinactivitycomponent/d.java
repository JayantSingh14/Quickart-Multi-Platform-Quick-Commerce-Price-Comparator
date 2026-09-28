package org.npci.upi.security.pinactivitycomponent;

import android.content.Context;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyInfo;
import android.util.Base64;
import androidx.appcompat.app.AppCompatActivity;
import in.juspay.hypersdk.core.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.crypto.KeyGenerator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class d extends AppCompatActivity {

    /* renamed from: a, reason: collision with root package name */
    private Context f57509a;

    /* renamed from: c, reason: collision with root package name */
    private g f57511c;

    /* renamed from: f, reason: collision with root package name */
    private z f57514f;

    /* renamed from: g, reason: collision with root package name */
    private JSONObject f57515g;

    /* renamed from: b, reason: collision with root package name */
    private String f57510b = "";

    /* renamed from: e, reason: collision with root package name */
    private String f57513e = "";

    /* renamed from: d, reason: collision with root package name */
    private f f57512d = new f();

    public d(Context context) {
        this.f57511c = null;
        this.f57509a = context;
        this.f57511c = new g(context);
    }

    private Boolean a(String str) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return this.f57512d.a(jSONObject.getString(CLConstants.RISK_RULES_FIELD), jSONObject.getString("signature"), in.org.npci.commonlibrary.e.a(new String(Base64.decode("c2lnbmVyLmNydA==", 2))).getPublicKey());
        } catch (Exception unused) {
            return Boolean.FALSE;
        }
    }

    private static boolean d() {
        return e() || f() || g();
    }

    private static boolean e() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    private static boolean f() {
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        for (int i2 = 0; i2 < 10; i2++) {
            if (new File(strArr[i2]).exists()) {
                return true;
            }
        }
        return false;
    }

    private static boolean g() {
        Process processExec = null;
        try {
            processExec = Runtime.getRuntime().exec(new String[]{"/system/xbin/which", "su"});
            String line = new BufferedReader(new InputStreamReader(processExec.getInputStream())).readLine();
            processExec.destroy();
            return line != null;
        } catch (Throwable unused) {
            if (processExec != null) {
                processExec.destroy();
            }
            return false;
        }
    }

    private static boolean h() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(Constants.ALG_RSA, "AndroidKeyStore");
            keyPairGenerator.initialize(new KeyGenParameterSpec.Builder("demo_key", 1).build());
            PrivateKey privateKey = keyPairGenerator.generateKeyPair().getPrivate();
            return ((KeyInfo) KeyFactory.getInstance(privateKey.getAlgorithm(), "AndroidKeyStore").getKeySpec(privateKey, KeyInfo.class)).isInsideSecureHardware();
        } catch (Exception unused) {
            return false;
        }
    }

    private void i() {
        this.f57514f.a("", CLConstants.PENDING_TXN_VAULT_KEY);
    }

    public String b() throws NoSuchAlgorithmException {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(CLConstants.AES_KEY_VAULT_KEY);
            keyGenerator.init(256);
            return this.f57512d.a(keyGenerator.generateKey().getEncoded());
        } catch (Exception unused) {
            q.a("Challenge", "Exception while generating Token");
            return null;
        }
    }

    public String c(String str, String str2, String str3) {
        try {
            z zVarA = z.a(Base64.encodeToString(this.f57512d.a(android.support.v4.media.b.l(str2, str, str3)), 2), this.f57509a);
            this.f57514f = zVarA;
            String strA = zVarA.a(CLConstants.SERVER_RISK_PARAMS_VAULT_KEY);
            if (a(strA).booleanValue()) {
                String strOptString = new JSONObject(new String(Base64.decode(new JSONObject(strA).getString(CLConstants.RISK_RULES_FIELD), 2), "UTF-8")).optString(CLConstants.ACCOUNT_BALANCE_FIELD, "");
                String strA2 = this.f57514f.a(CLConstants.PENDING_TXN_VAULT_KEY);
                if (strA2.equals("")) {
                    return String.format("%.2f", Float.valueOf(Float.parseFloat(strOptString)));
                }
                JSONArray jSONArray = new JSONArray(strA2);
                float f2 = 0.0f;
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    if (jSONArray.getJSONObject(i2).getString("isCredit").equals("false")) {
                        f2 += Float.parseFloat(jSONArray.getJSONObject(i2).getString("txnAmount"));
                    }
                }
                return String.format("%.2f", Float.valueOf(Float.parseFloat(strOptString) - f2));
            }
        } catch (Exception unused) {
        }
        return "";
    }

    private void b(String str) throws Exception {
        String strA = this.f57514f.a(CLConstants.SERVER_RISK_PARAMS_VAULT_KEY);
        String strA2 = this.f57514f.a(CLConstants.CLIENT_RISK_RULES_VAULT_KEY);
        if (strA.equals("")) {
            this.f57514f.a(str, CLConstants.SERVER_RISK_PARAMS_VAULT_KEY);
            if (strA2.equals("")) {
                this.f57514f.a(CLConstants.LITE_DEFAULT_CLIENT_RISKRULES, CLConstants.CLIENT_RISK_RULES_VAULT_KEY);
            }
            i();
            return;
        }
        if (!a(strA).booleanValue()) {
            throw new Exception("Could not update State");
        }
        Date date = new Date(Long.parseLong(new JSONObject(new String(Base64.decode(new JSONObject(strA).getString(CLConstants.RISK_RULES_FIELD), 2), "UTF-8")).getString("timestamp")));
        this.f57515g = new JSONObject(new String(Base64.decode(new JSONObject(str).getString(CLConstants.RISK_RULES_FIELD), 2), "UTF-8"));
        if (!new Date(Long.parseLong(this.f57515g.getString("timestamp"))).after(date)) {
            throw new Exception("Could not update State");
        }
        this.f57514f.a(str, CLConstants.SERVER_RISK_PARAMS_VAULT_KEY);
        if (strA2.equals("")) {
            strA2 = CLConstants.LITE_DEFAULT_CLIENT_RISKRULES;
        }
        JSONObject jSONObject = new JSONObject(strA2);
        jSONObject.put(CLConstants.OFFLINE_TRANSACTION_COUNTER_FIELD, "0");
        jSONObject.put(CLConstants.CUMULATIVE_OFFLINE_TRANSACTION_AMOUNT_FIELD, "0");
        this.f57514f.a(jSONObject.toString(), CLConstants.CLIENT_RISK_RULES_VAULT_KEY);
        i();
    }

    public String a() throws NoSuchAlgorithmException {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(CLConstants.AES_KEY_VAULT_KEY);
            keyGenerator.init(256);
            return this.f57512d.a(keyGenerator.generateKey().getEncoded());
        } catch (Exception unused) {
            q.a("Challenge", "Exception while generating K0");
            return null;
        }
    }

    public String a(String str, String str2) {
        String strA;
        String strA2 = "";
        String str3 = new SimpleDateFormat("dd/MM/yyyy").format((java.util.Date) new Date(System.currentTimeMillis()));
        try {
            this.f57510b = b();
            strA = a();
        } catch (Exception unused) {
            q.a("Challenge", "Exception while generating token and k0 in getChallenge");
            strA = "";
        }
        try {
            f fVar = new f();
            if (str.equalsIgnoreCase(CLConstants.MODE_INITIAL)) {
                this.f57511c.c();
                if (this.f57511c.a().size() > 0) {
                    this.f57511c.b(new y(strA, this.f57510b, str3));
                } else {
                    this.f57511c.a(new y(strA, this.f57510b, str3));
                }
                strA2 = fVar.a(this.f57510b + CLConstants.SALT_DELIMETER + strA + CLConstants.SALT_DELIMETER + str2, in.org.npci.commonlibrary.i.a());
                q.b("K0 in Challenge", strA);
                q.b("token in Challenge", this.f57510b);
            } else {
                String strB = this.f57511c.a().get(0).b();
                String str4 = this.f57510b + CLConstants.SALT_DELIMETER + strA + CLConstants.SALT_DELIMETER + str2;
                q.b("K0 in Challenge", strA);
                q.b("token in Challenge", this.f57510b);
                byte[] bArrB = fVar.b();
                String strEncodeToString = Base64.encodeToString(bArrB, 2);
                strA2 = Base64.encodeToString(fVar.a(str4.getBytes(), fVar.c(strB), bArrB), 2) + CLConstants.SALT_DELIMETER + strEncodeToString;
                this.f57511c.c();
                this.f57511c.a(new y(strA, this.f57510b, str3));
            }
        } catch (Exception unused2) {
            q.a("Challenge", "Exception while handling database calls in getChallenge");
        }
        return android.support.v4.media.b.C("2.3-v1.8|", strA2);
    }

    public boolean b(String str, String str2, String str3) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        String strEncodeToString = Base64.encodeToString(this.f57512d.a(android.support.v4.media.b.l(str2, str, str3)), 2);
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            keyStore.deleteEntry(strEncodeToString);
            z zVarA = z.a(strEncodeToString, this.f57509a);
            this.f57514f = zVarA;
            zVarA.a();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public String a(String str, String str2, String str3) throws JSONException, NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        String strEncodeToString;
        KeyStore keyStore;
        try {
            strEncodeToString = Base64.encodeToString(this.f57512d.a(android.support.v4.media.b.l(str2, str, str3)), 2);
            keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
        } catch (Exception unused) {
        }
        if (!keyStore.containsAlias(strEncodeToString)) {
            return "{\"status\":\"NO_BIND\"}";
        }
        z zVarA = z.a(strEncodeToString, this.f57509a);
        this.f57514f = zVarA;
        if (!zVarA.a(CLConstants.SERVER_RISK_PARAMS_VAULT_KEY).equals("")) {
            String str4 = this.f57514f.a(CLConstants.PENDING_TXN_VAULT_KEY).equals("") ? "false" : "true";
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(CLConstants.OTP_STATUS, "BOUND");
            jSONObject.put("syncRequired", str4);
            return jSONObject.toString();
        }
        return "{\"status\":\"NO_BIND\"}";
    }

    public boolean c() {
        return (d() ^ true) & h();
    }

    public boolean b(String str, String str2, String str3, String str4) {
        try {
            z zVarA = z.a(Base64.encodeToString(this.f57512d.a(android.support.v4.media.b.l(str2, str, str3)), 2), this.f57509a);
            this.f57514f = zVarA;
            String strC = f.c(str4, zVarA.a(CLConstants.AES_KEY_VAULT_KEY));
            if (a(strC).booleanValue()) {
                b(strC);
                if (!this.f57515g.getString(CLConstants.LITE_ACCOUNT_STATUS).equals("DA")) {
                    return true;
                }
                b(str, str2, str3);
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public boolean a(String str, String str2, String str3, String str4) {
        try {
            if (new in.org.npci.commonlibrary.a.b().a(str4)) {
                List<in.org.npci.commonlibrary.j> listB = new in.org.npci.commonlibrary.h(str4).b();
                z zVarA = z.a(Base64.encodeToString(this.f57512d.a(str2 + str + str3), 2), this.f57509a);
                this.f57514f = zVarA;
                String strA = zVarA.a(CLConstants.AES_KEY_VAULT_KEY);
                if (listB.size() != 0) {
                    for (int i2 = 0; i2 < listB.size(); i2++) {
                        in.org.npci.commonlibrary.j jVar = listB.get(i2);
                        if (jVar.a().equals(CLConstants.STATE_FIELD)) {
                            b(f.c(jVar.b(), strA));
                        } else if (jVar.a().equals(CLConstants.XML_DEVICE_CERTIFICATE_FIELD)) {
                            this.f57514f.a(f.c(jVar.b(), strA), CLConstants.DEVICE_CERTIFICATE_VAULT_KEY);
                        }
                    }
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public boolean a(String str, String str2, String str3, String str4, String str5) {
        q.b("hmac", str4);
        return b(str4, str, str2, str3, str5);
    }

    private boolean b(String str, String str2, String str3, String str4, String str5) {
        String localizedMessage;
        try {
            String strB = this.f57511c.b();
            q.b("Token in CL", strB);
            String strEncodeToString = Base64.encodeToString(this.f57512d.b(Base64.decode(str, 0), this.f57512d.c(strB), Base64.decode(str5, 2)), 0);
            String str6 = str2 + CLConstants.SALT_DELIMETER + str3 + CLConstants.SALT_DELIMETER + str4;
            q.b("CL Hmac Msg", str6);
            String strEncodeToString2 = Base64.encodeToString(this.f57512d.a(str6, str5), 0);
            q.b("CL Hash", strEncodeToString2);
            return strEncodeToString2.equalsIgnoreCase(strEncodeToString);
        } catch (NoSuchAlgorithmException e2) {
            localizedMessage = "" + e2.getLocalizedMessage();
            q.a("validateHMAC", localizedMessage);
            return false;
        } catch (Exception e3) {
            localizedMessage = e3.getLocalizedMessage();
            q.a("validateHMAC", localizedMessage);
            return false;
        }
    }
}
