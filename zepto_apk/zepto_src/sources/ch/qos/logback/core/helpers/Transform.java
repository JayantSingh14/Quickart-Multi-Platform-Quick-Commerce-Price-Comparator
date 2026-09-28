package ch.qos.logback.core.helpers;

import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class Transform {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f13485a = Pattern.compile("[\u0000-\b\u000b\f\u000e-\u001f<>&'\"]");

    public static String a(String str) {
        if (str == null || str.length() == 0 || !f13485a.matcher(str).find()) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        for (int i2 = 0; i2 < stringBuffer.length(); i2++) {
            char cCharAt = stringBuffer.charAt(i2);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\r') {
                if (cCharAt == '\"') {
                    stringBuffer.replace(i2, i2 + 1, "&quot;");
                } else if (cCharAt == '<') {
                    stringBuffer.replace(i2, i2 + 1, "&lt;");
                } else if (cCharAt == '>') {
                    stringBuffer.replace(i2, i2 + 1, "&gt;");
                } else if (cCharAt == '&') {
                    stringBuffer.replace(i2, i2 + 1, "&amp;");
                } else if (cCharAt == '\'') {
                    stringBuffer.replace(i2, i2 + 1, "&#39;");
                } else if (cCharAt < ' ') {
                    stringBuffer.replace(i2, i2 + 1, "�");
                }
            }
        }
        return stringBuffer.toString();
    }
}
