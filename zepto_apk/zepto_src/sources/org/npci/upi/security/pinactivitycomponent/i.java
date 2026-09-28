package org.npci.upi.security.pinactivitycomponent;

import in.org.npci.commonlibrary.Data;
import in.org.npci.commonlibrary.Message;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private in.org.npci.commonlibrary.b f57535a;

    /* renamed from: b, reason: collision with root package name */
    private String f57536b;

    /* renamed from: c, reason: collision with root package name */
    private String f57537c = "NPCI-LITE";

    /* renamed from: d, reason: collision with root package name */
    private g f57538d;

    public i(in.org.npci.commonlibrary.b bVar, g gVar, String str) {
        this.f57535a = bVar;
        this.f57536b = str;
        this.f57538d = gVar;
    }

    private Message a(String str, String str2, String str3, String str4, String str5, String str6, Boolean bool) {
        Data data;
        StringBuilder sb;
        Message messageA = null;
        try {
            if (bool.booleanValue()) {
                messageA = this.f57535a.a(this.f57537c, str4, str5, str, str6, Boolean.TRUE);
                messageA.setType(str2);
                messageA.setSubType(str3);
                data = messageA.getData();
                sb = new StringBuilder("2.3.lite-v1.8|");
                sb.append(messageA.getData().getEncryptedBase64String());
            } else {
                messageA = this.f57535a.a(this.f57536b, str4, str5, str, str6, Boolean.FALSE);
                messageA.setType(str2);
                messageA.setSubType(str3);
                data = messageA.getData();
                sb = new StringBuilder("2.3-v1.8|");
                sb.append(messageA.getData().getEncryptedBase64String());
            }
            data.setEncryptedBase64String(sb.toString());
            return messageA;
        } catch (Exception unused) {
            q.a("CommonLibrary", "Exception while encrypting data");
            return messageA;
        }
    }

    public Message a(String str, String str2, String str3, JSONObject jSONObject, Boolean bool) throws JSONException {
        Message messageA = null;
        try {
            jSONObject.getString(CLConstants.OUTPUT_CRED_TYPE);
            String string = jSONObject.getString(CLConstants.SALT_FIELD_TXN_ID);
            String string2 = jSONObject.getString(CLConstants.SALT_FIELD_CREDENTIAL);
            String string3 = jSONObject.getString(CLConstants.SALT_FIELD_APP_ID);
            String string4 = jSONObject.getString(CLConstants.SALT_FIELD_DEVICE_ID);
            String string5 = jSONObject.getString("mobileNumber");
            g gVar = this.f57538d;
            q.b("DBH in encryptor", gVar == null ? "null" : gVar.toString());
            String strA = this.f57538d.a(string3, string4, string5);
            q.b("K0 in encryptor", strA);
            Matcher matcher = Pattern.compile("\\{([^}]*)\\}").matcher(str);
            StringBuffer stringBuffer = new StringBuffer();
            if (matcher.find()) {
                messageA = a(android.support.v4.media.a.k(1, 1, matcher.group()), str2, str3, string, string2, strA, bool);
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(messageA.getData().getEncryptedBase64String().replaceAll(StringUtils.LF, "")));
            }
            if (stringBuffer.length() > 0) {
                matcher.appendTail(stringBuffer);
            }
            if (messageA != null) {
                String string6 = stringBuffer.toString();
                q.b("CommonLibrary", "Encrypted Data: " + string6);
                messageA.getData().setEncryptedBase64String(string6);
            }
            return messageA;
        } catch (JSONException unused) {
            q.a("CommonLibrary", "JSONException while reading Salt");
            return null;
        }
    }

    private String a(String str, String str2) {
        String strA = null;
        try {
            strA = this.f57535a.a(str, str2);
            return "2.3-v1.8|" + strA;
        } catch (Exception unused) {
            q.a("CommonLibrary", "Exception while encrypting data");
            return strA;
        }
    }

    public String a(JSONObject jSONObject, String str) throws JSONException {
        try {
            String string = jSONObject.getString(CLConstants.SALT_FIELD_APP_ID);
            String string2 = jSONObject.getString(CLConstants.SALT_FIELD_DEVICE_ID);
            String string3 = jSONObject.getString("mobileNumber");
            g gVar = this.f57538d;
            q.b("DBH in encryptor", gVar == null ? "null" : gVar.toString());
            String strA = this.f57538d.a(string, string2, string3);
            q.b("K0 in encryptor", strA);
            return a(str, strA);
        } catch (JSONException unused) {
            q.a("CommonLibrary", "JSONException while reading Salt");
            return null;
        }
    }
}
