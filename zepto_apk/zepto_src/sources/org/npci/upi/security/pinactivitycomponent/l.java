package org.npci.upi.security.pinactivitycomponent;

import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private static ResultReceiver f57540a;

    /* renamed from: b, reason: collision with root package name */
    private String f57541b;

    /* renamed from: c, reason: collision with root package name */
    private String f57542c;

    /* renamed from: d, reason: collision with root package name */
    private JSONObject f57543d;

    /* renamed from: e, reason: collision with root package name */
    private JSONObject f57544e;

    /* renamed from: f, reason: collision with root package name */
    private JSONObject f57545f;

    /* renamed from: g, reason: collision with root package name */
    private JSONArray f57546g;

    /* renamed from: h, reason: collision with root package name */
    private JSONArray f57547h;

    /* renamed from: i, reason: collision with root package name */
    private JSONArray f57548i;

    /* renamed from: j, reason: collision with root package name */
    private Locale f57549j;

    /* renamed from: k, reason: collision with root package name */
    private in.org.npci.commonlibrary.b f57550k;

    /* renamed from: l, reason: collision with root package name */
    private String f57551l;

    /* renamed from: m, reason: collision with root package name */
    private g f57552m;
    private JSONArray n;

    private void f() {
        JSONArray jSONArray = new JSONArray();
        this.n = jSONArray;
        jSONArray.put("setMpin");
        this.n.put("pay");
        this.n.put("collect");
        this.n.put("reqBalChk");
        this.n.put("reqBalEnq");
        this.n.put("changeMpin");
        this.n.put(CLConstants.CRED_TYPE_MANDATE);
        this.n.put(CLConstants.CRED_TYPE_BINDING);
    }

    public String a() {
        return this.f57541b;
    }

    public Locale b() {
        return this.f57549j;
    }

    public in.org.npci.commonlibrary.b c() {
        return this.f57550k;
    }

    public g d() {
        return this.f57552m;
    }

    public ResultReceiver e() {
        return f57540a;
    }

    private void a(Context context, String str, String str2, String str3) throws in.org.npci.commonlibrary.c {
        String strOptString = this.f57545f.optString("txnAmount");
        String strOptString2 = this.f57545f.optString(CLConstants.SALT_FIELD_APP_ID);
        String strOptString3 = this.f57545f.optString(CLConstants.SALT_FIELD_DEVICE_ID);
        String strOptString4 = this.f57545f.optString("mobileNumber");
        String strOptString5 = this.f57545f.optString(CLConstants.SALT_FIELD_PAYER_ADDR);
        String strOptString6 = this.f57545f.optString(CLConstants.SALT_FIELD_PAYEE_ADDR);
        String strOptString7 = this.f57545f.optString(CLConstants.SALT_FIELD_ACCOUNT_REF_ID);
        String strOptString8 = this.f57545f.optString(CLConstants.SALT_FIELD_LITE_ACC_NUMBER);
        String strOptString9 = this.f57545f.optString(CLConstants.SALT_FIELD_TXN_TIMESTAMP);
        String strOptString10 = this.f57545f.optString("random");
        try {
            StringBuilder sb = new StringBuilder(150);
            if (str != null && !str.isEmpty()) {
                sb.append(str);
                sb.append(CLConstants.SALT_DELIMETER);
            }
            if (str2 != null && !str2.isEmpty()) {
                sb.append(str2);
                sb.append(CLConstants.SALT_DELIMETER);
            }
            if (strOptString2 != null && !strOptString2.isEmpty()) {
                sb.append(strOptString2);
                sb.append(CLConstants.SALT_DELIMETER);
            }
            if (strOptString4 != null && !strOptString4.isEmpty()) {
                sb.append(strOptString4);
                sb.append(CLConstants.SALT_DELIMETER);
            }
            if (strOptString3 != null && !strOptString3.isEmpty()) {
                sb.append(strOptString3);
                sb.append(CLConstants.SALT_DELIMETER);
            }
            if (strOptString5 != null && !strOptString5.isEmpty()) {
                sb.append(strOptString5);
                sb.append(CLConstants.SALT_DELIMETER);
            }
            if (strOptString6 != null && !strOptString6.isEmpty()) {
                sb.append(strOptString6);
                sb.append(CLConstants.SALT_DELIMETER);
            }
            if (strOptString != null && !strOptString.isEmpty()) {
                sb.append(strOptString);
                sb.append(CLConstants.SALT_DELIMETER);
            }
            if (strOptString7 != null && !strOptString7.isEmpty()) {
                sb.append(strOptString7);
                sb.append(CLConstants.SALT_DELIMETER);
            }
            if (strOptString8 != null && !strOptString8.isEmpty()) {
                sb.append(strOptString8);
                sb.append(CLConstants.SALT_DELIMETER);
            }
            if (strOptString9 != null && !strOptString9.isEmpty()) {
                sb.append(strOptString9);
                sb.append(CLConstants.SALT_DELIMETER);
            }
            int iLastIndexOf = sb.lastIndexOf(CLConstants.SALT_DELIMETER);
            if (iLastIndexOf != -1 && iLastIndexOf == sb.length() - 1) {
                sb.deleteCharAt(iLastIndexOf);
            }
            String strB = this.f57552m.b();
            q.b("CL Trust Token", strB);
            q.b("CL Trust Param Message", sb.toString());
            this.f57550k.a(str3, sb.toString(), strB, strOptString10);
        } catch (Exception unused) {
            throw new in.org.npci.commonlibrary.c(in.org.npci.commonlibrary.d.TRUST_NOT_VALID);
        }
    }

    public void a(Bundle bundle, Context context) throws c, JSONException, in.org.npci.commonlibrary.c {
        this.f57552m = new g(context);
        try {
            f();
            try {
                String string = bundle.getString(CLConstants.INPUT_CODE);
                this.f57541b = string;
                if (string == null || string.isEmpty()) {
                    throw new c(context, CLConstants.ERROR_CODE_MISSING, CLConstants.ERROR_MSG_CODE_MISSING);
                }
                q.b("Common Library", this.f57541b);
                try {
                    String string2 = bundle.getString(CLConstants.INPUT_XML_PAYLOAD);
                    this.f57542c = string2;
                    if (string2 == null || string2.isEmpty()) {
                        throw new c(context, CLConstants.ERROR_XML_PAYLOAD_MISSING, CLConstants.ERROR_MSG_XML_PAYLOAD_MISSING);
                    }
                    q.b("Common Library", this.f57542c);
                    this.f57550k = new in.org.npci.commonlibrary.b(this.f57542c);
                    try {
                        String string3 = bundle.getString(CLConstants.INPUT_CONTROLS);
                        if (string3 == null || string3.isEmpty()) {
                            q.b("Common Library", "Controls is not received. Setting MPIN as default. ");
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("type", CLConstants.CREDTYPE_PIN);
                            jSONObject.put(CLConstants.FIELD_SUBTYPE, CLConstants.CREDTYPE_MPIN);
                            jSONObject.put(CLConstants.FIELD_DTYPE, CLConstants.CRED_DTYPE);
                            jSONObject.put(CLConstants.FIELD_DLENGTH, 6);
                            JSONArray jSONArray = new JSONArray();
                            jSONArray.put(jSONObject);
                            JSONObject jSONObject2 = new JSONObject();
                            this.f57543d = jSONObject2;
                            jSONObject2.put(CLConstants.FIELD_CRED_ALLOWED, jSONArray);
                        } else {
                            q.b("Common Library", "Controls received: ".concat(string3));
                            if (string3.contains(CLConstants.CREDTYPE_AADHAAR) && string3.contains(CLConstants.CREDTYPE_ATMPIN)) {
                                throw new c(context, CLConstants.ERROR_INVALID_CONTROLS_COMBO, CLConstants.ERROR_MSG_INVALID_CONTROLS_COMBO);
                            }
                            this.f57543d = new JSONObject(string3);
                        }
                        try {
                            String string4 = bundle.getString(CLConstants.INPUT_CONFIGURATION);
                            if (string4 == null || string4.isEmpty()) {
                                q.b("Common Library", "Configuration is not received");
                            } else {
                                q.b("Common Library", "Configuration received: ".concat(string4));
                                this.f57544e = new JSONObject(string4);
                            }
                            try {
                                String string5 = bundle.getString(CLConstants.INPUT_SALT);
                                JSONObject jSONObject3 = new JSONObject(string5);
                                if (string5 == null || string5.isEmpty()) {
                                    throw new c(context, CLConstants.ERROR_SALT_MISSING, CLConstants.ERROR_MSG_SALT_MISSING);
                                }
                                if (!jSONObject3.has(CLConstants.OUTPUT_CRED_TYPE)) {
                                    throw new c(context, CLConstants.ERROR_MISSING_CREDTYPE, CLConstants.ERROR_MSG_MISSING_CREDTYPE);
                                }
                                if (!(jSONObject3.get(CLConstants.OUTPUT_CRED_TYPE) instanceof JSONArray)) {
                                    throw new c(context, CLConstants.ERROR_CREDTYPE_TRANSAC_ARRAY, CLConstants.ERROR_MSG_CREDTYPE_TRANSAC_ARRAY);
                                }
                                JSONArray jSONArray2 = jSONObject3.getJSONArray(CLConstants.OUTPUT_CRED_TYPE);
                                this.f57548i = jSONArray2;
                                if (jSONArray2.length() < 1) {
                                    throw new c(context, CLConstants.ERROR_MISSING_CREDTYPE, CLConstants.ERROR_MSG_MISSING_CREDTYPE);
                                }
                                if (this.f57548i.length() > 2) {
                                    throw new c(context, CLConstants.ERROR_MISSING_CREDTYPE, CLConstants.ERROR_MSG_MISSING_CREDTYPE);
                                }
                                Boolean bool = Boolean.TRUE;
                                for (int i2 = 0; i2 < this.f57548i.length(); i2++) {
                                    int i3 = 0;
                                    while (true) {
                                        if (i3 >= this.n.length()) {
                                            break;
                                        }
                                        if (this.f57548i.getString(i2).equals(this.n.getString(i3))) {
                                            bool = Boolean.TRUE;
                                            break;
                                        } else {
                                            bool = Boolean.FALSE;
                                            i3++;
                                        }
                                    }
                                }
                                if (!bool.booleanValue()) {
                                    throw new c(context, CLConstants.ERROR_INVALID_CREDTYPE, CLConstants.ERROR_MSG_INVALID_CREDTYPE);
                                }
                                Boolean bool2 = Boolean.FALSE;
                                for (int i4 = 0; i4 < this.f57548i.length(); i4++) {
                                    if (this.f57548i.getString(i4).equals("reqBalChk")) {
                                        bool2 = Boolean.TRUE;
                                    }
                                }
                                if (bool2.booleanValue()) {
                                    Boolean bool3 = Boolean.FALSE;
                                    for (int i5 = 0; i5 < this.f57548i.length(); i5++) {
                                        if (this.f57548i.getString(i5).equals("pay") || this.f57548i.getString(i5).equals("collect")) {
                                            bool3 = Boolean.TRUE;
                                        }
                                    }
                                    if (!bool3.booleanValue()) {
                                        throw new c(context, CLConstants.ERROR_INVALID_CREDTYPE_COMBO, CLConstants.ERROR_MSG_INVALID_CREDTYPE_COMBO);
                                    }
                                }
                                if (!jSONObject3.has(CLConstants.SALT_FIELD_TXN_ID)) {
                                    throw new c(context, CLConstants.ERROR_TXN_ID_MISSING, CLConstants.ERROR_MSG_TXN_ID_MISSING);
                                }
                                if (!(jSONObject3.get(CLConstants.SALT_FIELD_TXN_ID) instanceof JSONArray)) {
                                    throw new c(context, CLConstants.ERROR_CREDTYPE_TRANSAC_ARRAY, CLConstants.ERROR_MSG_CREDTYPE_TRANSAC_ARRAY);
                                }
                                JSONArray jSONArray3 = jSONObject3.getJSONArray(CLConstants.SALT_FIELD_TXN_ID);
                                this.f57547h = jSONArray3;
                                if (jSONArray3.length() != this.f57548i.length()) {
                                    throw new c(context, CLConstants.ERROR_TRANSAC_ID_COUNT_SAME_AS_CREDTYPE, CLConstants.ERROR_MSG_TRANSAC_ID_COUNT_SAME_AS_CREDTYPE);
                                }
                                if (this.f57547h.length() > 1 && this.f57547h.length() <= 2 && this.f57547h.getString(0).equals(this.f57547h.getString(1))) {
                                    throw new c(context, CLConstants.ERROR_SAME_TRANSAC_ID, CLConstants.ERROR_MSG_SAME_TRANSAC_ID);
                                }
                                q.b("Common Library", string5);
                                this.f57545f = new JSONObject(string5);
                                try {
                                    String string6 = bundle.getString(CLConstants.INPUT_TRUST);
                                    this.f57551l = string6;
                                    if (string6 == null || string6.isEmpty()) {
                                        throw new c(context, CLConstants.ERROR_TRUST_MISSING, CLConstants.ERROR_MSG_TRUST_MISSING);
                                    }
                                    JSONObject jSONObject4 = new JSONObject(this.f57551l);
                                    q.b("Common Library", this.f57551l);
                                    for (int i6 = 0; i6 < this.f57548i.length(); i6++) {
                                        a(context, this.f57548i.getString(i6), this.f57547h.getString(i6), jSONObject4.getString(this.f57548i.getString(i6)));
                                    }
                                    try {
                                        String string7 = bundle.getString(CLConstants.INPUT_PAY_INFO);
                                        if (string7 == null || string7.isEmpty()) {
                                            q.b("Common Library", "Pay Info not received");
                                        } else {
                                            q.b("Common Library", "Pay Info Received" + string7);
                                            this.f57546g = new JSONArray(string7);
                                        }
                                        try {
                                            String string8 = bundle.getString(CLConstants.INPUT_LANGUAGE_PREFERENCE);
                                            this.f57549j = new Locale((string8 == null || string8.isEmpty()) ? CLConstants.DEFAULT_LANGUAGE_PREFERENCE : string8);
                                            q.b("Common Library", string8);
                                        } catch (Exception unused) {
                                            throw new c(context, CLConstants.ERROR_LOCALE_PARSE, CLConstants.ERROR_MSG_LOCALE_PARSE);
                                        }
                                    } catch (Exception unused2) {
                                        throw new c(context, CLConstants.ERROR_PAY_INFO_PARSE, CLConstants.ERROR_MSG_PAY_INFO_PARSE);
                                    }
                                } catch (in.org.npci.commonlibrary.c e2) {
                                    throw e2;
                                } catch (c e3) {
                                    throw e3;
                                } catch (Exception e4) {
                                    throw new c(context, CLConstants.ERROR_TRUST_NOT_VALID, CLConstants.ERROR_MSG_TRUST_NOT_VALID, e4);
                                }
                            } catch (c e5) {
                                throw e5;
                            } catch (Exception e6) {
                                throw new c(context, CLConstants.ERROR_SALT_PARSE, CLConstants.ERROR_MSG_SALT_PARSE, e6);
                            }
                        } catch (Exception e7) {
                            throw new c(context, CLConstants.ERROR_CONFIG_PARSE, CLConstants.ERROR_MSG_CONFIG_PARSE, e7);
                        }
                    } catch (c e8) {
                        throw e8;
                    } catch (Exception e9) {
                        throw new c(context, CLConstants.ERROR_CONTROLS_PARSE, CLConstants.ERROR_MSG_CONTROLS_PARSE, e9);
                    }
                } catch (in.org.npci.commonlibrary.c e10) {
                    q.a("CommonLibraryException", e10.getMessage());
                    throw new c(context, CLConstants.ERROR_XMLPAYLOAD_VALIDATE, CLConstants.ERROR_MSG_XMLPAYLOAD_VALIDATE, e10);
                } catch (c e11) {
                    throw e11;
                } catch (Exception e12) {
                    throw new c(context, CLConstants.ERROR_XML_PAYLOAD_PARSE, CLConstants.ERROR_MSG_XML_PAYLOAD_PARSE, e12);
                }
            } catch (c e13) {
                throw e13;
            } catch (Exception e14) {
                throw new c(context, CLConstants.ERROR_CODE_PARSE, CLConstants.ERROR_MSG_CODE_PARSE, e14);
            }
        } catch (Exception e15) {
            throw new c(context, CLConstants.ERROR_CODE_PARSE, CLConstants.ERROR_MSG_CODE_PARSE, e15);
        }
    }

    public static void a(CLServerResultReceiver cLServerResultReceiver) {
        f57540a = cLServerResultReceiver;
    }
}
