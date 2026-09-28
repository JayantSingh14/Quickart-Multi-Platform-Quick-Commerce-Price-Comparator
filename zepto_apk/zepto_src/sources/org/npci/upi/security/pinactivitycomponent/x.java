package org.npci.upi.security.pinactivitycomponent;

import android.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    private String f57671a = a("MS03LTItNA==");

    /* renamed from: b, reason: collision with root package name */
    private b f57672b;

    public x(b bVar) {
        this.f57672b = bVar;
    }

    private String a(String str) {
        String string = "";
        for (String str2 : new String(Base64.decode(str, -1)).split("-")) {
            StringBuilder sbW = android.support.v4.media.b.w(string);
            sbW.append(this.f57672b.b(str2));
            string = sbW.toString();
        }
        return new String(Base64.decode(string, -1));
    }

    private void b(JSONObject jSONObject) {
    }

    public String a(JSONObject jSONObject) {
        try {
            b(jSONObject);
            q.b("Common Library", "Salt Format: " + this.f57671a);
            String str = this.f57671a;
            q.b("Common Library", "Temp Salt Format: " + str);
            if (str == null || str.isEmpty()) {
                return null;
            }
            Matcher matcher = Pattern.compile("\\[([^\\]]*)\\]").matcher(str);
            StringBuffer stringBuffer = new StringBuffer(1000);
            while (matcher.find()) {
                String strGroup = matcher.group();
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(jSONObject.optString(strGroup.substring(1, strGroup.length() - 1))));
            }
            matcher.appendTail(stringBuffer);
            String string = stringBuffer.toString();
            q.b("Common Library", "Output Salt: " + string);
            return string;
        } catch (JSONException unused) {
            q.a("CommonLibrary", "JSONException while building Salt");
            return null;
        }
    }
}
