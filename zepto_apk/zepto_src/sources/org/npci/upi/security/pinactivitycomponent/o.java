package org.npci.upi.security.pinactivitycomponent;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.security.keystore.UserNotAuthenticatedException;
import android.util.Base64;
import in.org.npci.commonlibrary.Message;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class o {

    /* renamed from: b, reason: collision with root package name */
    private JSONObject f57555b;

    /* renamed from: c, reason: collision with root package name */
    private Context f57556c;

    /* renamed from: d, reason: collision with root package name */
    private Activity f57557d;

    /* renamed from: e, reason: collision with root package name */
    private b f57558e;

    /* renamed from: g, reason: collision with root package name */
    private JSONArray f57560g;

    /* renamed from: h, reason: collision with root package name */
    private String f57561h;

    /* renamed from: i, reason: collision with root package name */
    private JSONObject f57562i;

    /* renamed from: j, reason: collision with root package name */
    private String f57563j;

    /* renamed from: k, reason: collision with root package name */
    private JSONObject f57564k;

    /* renamed from: l, reason: collision with root package name */
    private JSONObject f57565l;

    /* renamed from: m, reason: collision with root package name */
    private float f57566m;
    private z p;
    private String r;
    private KeyguardManager s;
    private String t;
    private Boolean n = Boolean.FALSE;
    private String o = "SHA512withRSA/PSS";
    private String q = null;

    /* renamed from: a, reason: collision with root package name */
    HashMap<String, String> f57554a = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private f f57559f = new f();

    public o(Context context, JSONObject jSONObject, JSONArray jSONArray, JSONObject jSONObject2) {
        this.f57556c = context;
        this.f57555b = jSONObject;
        this.f57560g = jSONArray;
        this.f57562i = jSONObject2;
        this.f57557d = (Activity) context;
    }

    private Boolean a(JSONObject jSONObject) throws JSONException {
        try {
            return this.f57559f.a(jSONObject.getString(CLConstants.RISK_RULES_FIELD), jSONObject.getString("signature"), in.org.npci.commonlibrary.e.a(new String(Base64.decode("c2lnbmVyLmNydA==", 2))).getPublicKey());
        } catch (Exception unused) {
            return Boolean.FALSE;
        }
    }

    private String f() throws JSONException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        String strA = this.p.a(CLConstants.AES_KEY_VAULT_KEY);
        JSONObject jSONObject = new JSONObject(this.f57565l.toString());
        jSONObject.put(CLConstants.CLIENT_RISK_RULES, Base64.encodeToString(this.f57564k.toString().getBytes("UTF-8"), 2));
        return this.f57559f.b(jSONObject.toString(), strA);
    }

    private String g() throws JSONException {
        String strS = android.support.v4.media.b.s(new StringBuilder(), this.r, CLConstants.SALT_DELIMETER, Base64.encodeToString(this.f57565l.toString().getBytes("UTF-8"), 2));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("signature", a(strS, this.t, CLConstants.FIELD_LITE_PAY_FLOW.intValue()));
        jSONObject.put(CLConstants.DYNAMIC_DATA_FIELD, strS);
        jSONObject.put(CLConstants.DEVICE_CERTIFICATE_FIELD, this.f57563j);
        return Base64.encodeToString(jSONObject.toString().getBytes("UTF8"), 2);
    }

    private void h() throws Exception {
        if (!this.f57556c.getPackageName().equals(this.f57555b.optString(CLConstants.SALT_FIELD_APP_ID))) {
            throw new Exception();
        }
    }

    private boolean i() throws CertificateNotYetValidException, CertificateExpiredException {
        try {
            String strA = this.p.a(CLConstants.DEVICE_CERTIFICATE_VAULT_KEY);
            this.f57563j = strA;
            c(strA).checkValidity();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean j() throws JSONException, NumberFormatException {
        if (a(this.f57565l).booleanValue()) {
            JSONObject jSONObject = new JSONObject(new String(Base64.decode(this.f57565l.getString(CLConstants.RISK_RULES_FIELD), 2), "UTF-8"));
            this.f57566m = Float.parseFloat(this.f57555b.getString("txnAmount"));
            float f2 = Float.parseFloat(jSONObject.getString(CLConstants.LITE_TRANSACTION_LIMIT_FIELD));
            float f3 = Float.parseFloat(jSONObject.getString(CLConstants.ACCOUNT_BALANCE_FIELD));
            String string = jSONObject.getString(CLConstants.LITE_ACCOUNT_STATUS);
            if (this.n.booleanValue()) {
                boolean z = Boolean.parseBoolean(jSONObject.getString(CLConstants.ENABLE_OFFLINE_TXN));
                float f4 = Float.parseFloat(jSONObject.getString(CLConstants.OFFLINE_TRANSACTION_LIMIT_FIELD));
                int i2 = Integer.parseInt(this.f57564k.getString(CLConstants.OFFLINE_TRANSACTION_COUNTER_FIELD));
                int i3 = Integer.parseInt(jSONObject.getString(CLConstants.MAX_OFFLINE_TRANSACTION_COUNTER_FIELD));
                float f5 = Float.parseFloat(this.f57564k.getString(CLConstants.CUMULATIVE_OFFLINE_TRANSACTION_AMOUNT_FIELD));
                float f6 = Float.parseFloat(jSONObject.getString(CLConstants.CUMULATIVE_OFFLINE_TRANSACTION_AMOUNT_LIMIT_FIELD));
                float f7 = this.f57566m;
                if ((f5 + f7 <= f6) & (f7 <= f2) & (f7 <= f3) & (f7 <= f4) & (i2 < i3) & z & string.equals("A")) {
                    return true;
                }
            } else {
                float f8 = this.f57566m;
                if (((f8 <= f2) & (f8 <= f3)) && string.equals("A")) {
                    return true;
                }
                if ((this.f57566m == f3) & string.equals("A") & this.f57555b.getString(CLConstants.SALT_FIELD_PAYER_ADDR).equals(this.f57555b.getString(CLConstants.SALT_FIELD_PAYEE_ADDR))) {
                    return true;
                }
            }
        }
        return false;
    }

    private void k() throws JSONException {
        JSONObject jSONObject;
        String strValueOf;
        boolean zBooleanValue = this.n.booleanValue();
        String str = CLConstants.APPLICATION_TRANSACTION_COUNTER_FIELD;
        if (zBooleanValue) {
            JSONObject jSONObject2 = this.f57564k;
            jSONObject2.put(CLConstants.APPLICATION_TRANSACTION_COUNTER_FIELD, String.valueOf(Integer.parseInt(jSONObject2.getString(CLConstants.APPLICATION_TRANSACTION_COUNTER_FIELD)) + 1));
            JSONObject jSONObject3 = this.f57564k;
            jSONObject3.put(CLConstants.OFFLINE_TRANSACTION_COUNTER_FIELD, String.valueOf(Integer.parseInt(jSONObject3.getString(CLConstants.OFFLINE_TRANSACTION_COUNTER_FIELD)) + 1));
            jSONObject = this.f57564k;
            str = CLConstants.CUMULATIVE_OFFLINE_TRANSACTION_AMOUNT_FIELD;
            strValueOf = String.format("%.2f", Float.valueOf(Float.parseFloat(jSONObject.getString(CLConstants.CUMULATIVE_OFFLINE_TRANSACTION_AMOUNT_FIELD)) + this.f57566m));
        } else {
            jSONObject = this.f57564k;
            strValueOf = String.valueOf(Integer.parseInt(jSONObject.getString(CLConstants.APPLICATION_TRANSACTION_COUNTER_FIELD)) + 1);
        }
        jSONObject.put(str, strValueOf);
        this.p.a(this.f57564k.toString(), CLConstants.CLIENT_RISK_RULES_VAULT_KEY);
    }

    public String b() {
        String strEncodeToString = Base64.encodeToString(this.f57559f.a().getEncoded(), 2);
        this.p.a(strEncodeToString, CLConstants.AES_KEY_VAULT_KEY);
        return strEncodeToString;
    }

    public String c() throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        return Base64.encodeToString(keyStore.getCertificateChain(this.t)[0].getEncoded(), 2);
    }

    public void d() {
        a(this.f57561h);
    }

    public void e() {
        String strA = a(CLConstants.FIELD_LITE_PAY_FLOW.intValue());
        if (strA != null) {
            k();
            if (this.n.booleanValue()) {
                this.q = g();
            }
            b("false");
            a(new String[]{strA});
        }
    }

    private String a(int i2) throws JSONException, NoSuchPaddingException, NoSuchAlgorithmException, SignatureException, InvalidKeyException, IOException, KeyStoreException, CertificateException, InvalidAlgorithmParameterException {
        String string = this.f57555b.getString("txnAmount");
        String str = (String) this.f57555b.getJSONArray(CLConstants.SALT_FIELD_TXN_ID).get(0);
        String string2 = this.f57555b.getString(CLConstants.SALT_FIELD_TXN_TIMESTAMP);
        String string3 = this.f57555b.getString(CLConstants.SALT_FIELD_LITE_ACC_NUMBER);
        String string4 = this.f57555b.getString(CLConstants.SALT_FIELD_PAYEE_ADDR);
        String string5 = this.f57555b.getString(CLConstants.SALT_FIELD_APP_ID);
        String string6 = this.f57555b.getString("mobileNumber");
        String string7 = this.f57555b.getString(CLConstants.SALT_FIELD_DEVICE_ID);
        String strF = f();
        StringBuilder sbV = androidx.fragment.app.e.v("1.0|", string, CLConstants.SALT_DELIMETER, str, CLConstants.SALT_DELIMETER);
        android.support.v4.media.b.B(sbV, string2, CLConstants.SALT_DELIMETER, string3, CLConstants.SALT_DELIMETER);
        android.support.v4.media.b.B(sbV, string4, CLConstants.SALT_DELIMETER, string5, CLConstants.SALT_DELIMETER);
        this.r = android.support.v4.media.b.s(sbV, string6, CLConstants.SALT_DELIMETER, string7);
        String strA = a(Base64.encodeToString((this.r + CLConstants.SALT_DELIMETER + strF).getBytes("UTF-8"), 2), this.t, i2);
        if (strA == null) {
            return strA;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("riskParams", strF);
        jSONObject.put("signature", strA);
        return Base64.encodeToString(jSONObject.toString().getBytes("UTF-8"), 2);
    }

    private void b(int i2) {
        KeyguardManager keyguardManager = (KeyguardManager) this.f57556c.getSystemService("keyguard");
        this.s = keyguardManager;
        Intent intentCreateConfirmDeviceCredentialIntent = keyguardManager.createConfirmDeviceCredentialIntent(null, null);
        if (intentCreateConfirmDeviceCredentialIntent != null) {
            this.f57557d.startActivityForResult(intentCreateConfirmDeviceCredentialIntent, i2);
        }
    }

    private static X509Certificate c(String str) throws Throwable {
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(str.getBytes());
            try {
                X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream2);
                byteArrayInputStream2.close();
                return x509Certificate;
            } catch (Throwable th) {
                th = th;
                byteArrayInputStream = byteArrayInputStream2;
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void b(Boolean bool) {
        h();
        a();
        String strA = a(bool);
        a(new String[]{b() + CLConstants.DOT_SALT_DELIMETER + strA + CLConstants.DOT_SALT_DELIMETER + c()});
    }

    private void b(String str) throws JSONException {
        JSONArray jSONArray;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(CLConstants.SALT_FIELD_TXN_ID, (String) this.f57555b.getJSONArray(CLConstants.SALT_FIELD_TXN_ID).get(0));
        jSONObject.put("txnAmount", this.f57555b.getString("txnAmount"));
        jSONObject.put("isCredit", str);
        try {
            jSONArray = new JSONArray(this.p.a(CLConstants.PENDING_TXN_VAULT_KEY));
        } catch (Exception unused) {
            jSONArray = new JSONArray();
        }
        jSONArray.put(jSONObject);
        this.p.a(jSONArray.toString(), CLConstants.PENDING_TXN_VAULT_KEY);
    }

    public String a(Boolean bool) {
        return this.f57559f.a(this.t, bool);
    }

    private String a(String str, String str2, int i2) throws NoSuchAlgorithmException, SignatureException, IOException, InvalidKeyException, KeyStoreException, CertificateException {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            PrivateKey privateKey = (PrivateKey) keyStore.getKey(str2, null);
            Signature signature = Signature.getInstance(this.o);
            signature.initSign(privateKey);
            signature.update(str.getBytes("UTF8"));
            return Base64.encodeToString(signature.sign(), 2);
        } catch (UserNotAuthenticatedException unused) {
            b(i2);
            return null;
        }
    }

    public void a() throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        String strEncodeToString = Base64.encodeToString(this.f57559f.a(this.f57555b.getString(CLConstants.SALT_FIELD_DEVICE_ID) + this.f57555b.getString("mobileNumber") + this.f57555b.getString(CLConstants.SALT_FIELD_ACCOUNT_REF_ID)), 2);
        this.t = strEncodeToString;
        this.p = z.a(strEncodeToString, this.f57556c);
        try {
            this.f57564k = new JSONObject(this.p.a(CLConstants.CLIENT_RISK_RULES_VAULT_KEY));
        } catch (JSONException unused) {
            this.f57564k = new JSONObject(CLConstants.LITE_DEFAULT_CLIENT_RISKRULES);
        }
        this.p.a();
        this.p.a(this.f57564k.toString(), CLConstants.CLIENT_RISK_RULES_VAULT_KEY);
    }

    public void a(String str) {
        try {
            this.f57561h = str;
            String strA = a(CLConstants.FIELD_LOAD_MONEY_FLOW.intValue());
            if (strA != null) {
                k();
                b("true");
                a(new String[]{str, strA});
            }
        } catch (Exception unused) {
            ((GetCredential) this.f57556c).showError(CLConstants.ERROR_TECHNICAL_ERROR);
        }
    }

    public void a(String[] strArr) throws JSONException {
        for (int i2 = 0; i2 < strArr.length; i2++) {
            String strOptString = ((JSONObject) this.f57560g.get(i2)).optString(CLConstants.FIELD_SUBTYPE, "");
            String strOptString2 = ((JSONObject) this.f57560g.get(i2)).optString("type", "");
            Boolean bool = Boolean.TRUE;
            if (strOptString.equals(CLConstants.CREDTYPE_MPIN)) {
                bool = Boolean.FALSE;
            }
            Boolean bool2 = bool;
            this.f57555b.put(CLConstants.SALT_FIELD_CREDENTIAL, strArr[i2]);
            JSONObject jSONObject = new JSONObject(this.f57555b.toString());
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = this.f57555b.getJSONArray(CLConstants.OUTPUT_CRED_TYPE);
            for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                jSONObject.put(CLConstants.SALT_FIELD_TXN_ID, this.f57555b.getJSONArray(CLConstants.SALT_FIELD_TXN_ID).get(i3));
                jSONObject.put(CLConstants.OUTPUT_CRED_TYPE, this.f57555b.getJSONArray(CLConstants.OUTPUT_CRED_TYPE).get(i3));
                b bVarG = ((GetCredential) this.f57556c).getCredBlockBuilder().g();
                this.f57558e = bVarG;
                jSONArray.put(bVarG.a().a(jSONObject));
                Message messageA = this.f57558e.b().a(jSONArray.getString(i3), strOptString2, strOptString, jSONObject, bool2);
                if (this.n.booleanValue()) {
                    messageA.getData().setOda(this.q);
                }
                jSONObject2.put(jSONArray2.getString(i3), m.a(messageA));
            }
            this.f57554a.put(strOptString, jSONObject2.toString());
        }
        Boolean boolValueOf = Boolean.FALSE;
        JSONObject jSONObject3 = this.f57562i;
        if (jSONObject3 != null) {
            boolValueOf = Boolean.valueOf(Boolean.parseBoolean(jSONObject3.optString(CLConstants.FIELD_GET_DEVICE_DETAILS, "false")));
        }
        if (boolValueOf.booleanValue()) {
            this.f57554a.put(CLConstants.OUTPUT_CRED_DEV_DET_TAG, this.f57558e.b().a(this.f57555b, new h(this.f57556c).a()));
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable(CLConstants.OUTPUT_CRED_CREDBLOCK_TAG, this.f57554a);
        this.f57558e.c().send(1, bundle);
        ((GetCredential) this.f57556c).finish();
    }

    public boolean a(Integer num) throws JSONException, CertificateException {
        JSONObject jSONObject = this.f57562i;
        if (jSONObject != null) {
            this.n = Boolean.valueOf(Boolean.parseBoolean(jSONObject.optString(CLConstants.FIELD_IS_AUTH_OFFLINE, "false")));
        }
        String strEncodeToString = Base64.encodeToString(this.f57559f.a(android.support.v4.media.b.l(this.f57555b.getString(CLConstants.SALT_FIELD_DEVICE_ID), this.f57555b.getString("mobileNumber"), this.f57555b.getString(CLConstants.SALT_FIELD_ACCOUNT_REF_ID))), 2);
        this.t = strEncodeToString;
        z zVarA = z.a(strEncodeToString, this.f57556c);
        this.p = zVarA;
        if (!zVarA.a(CLConstants.PENDING_TXN_VAULT_KEY).equals("")) {
            throw new IllegalStateException("Pending transaction for Sync");
        }
        this.f57564k = new JSONObject(this.p.a(CLConstants.CLIENT_RISK_RULES_VAULT_KEY));
        this.f57565l = new JSONObject(this.p.a(CLConstants.SERVER_RISK_PARAMS_VAULT_KEY));
        if (!i()) {
            throw new CertificateException("Device Certificate Expired");
        }
        if (num.equals(CLConstants.FIELD_LOAD_MONEY_FLOW) || j()) {
            return true;
        }
        throw new IllegalArgumentException("Lite validation Failed");
    }
}
