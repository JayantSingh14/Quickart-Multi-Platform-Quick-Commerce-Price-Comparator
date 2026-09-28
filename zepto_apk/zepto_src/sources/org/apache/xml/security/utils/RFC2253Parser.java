package org.apache.xml.security.utils;

import android.support.v4.media.a;
import java.io.IOException;
import java.io.StringReader;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes5.dex */
public class RFC2253Parser {

    /* renamed from: a, reason: collision with root package name */
    static boolean f57355a = true;

    /* renamed from: b, reason: collision with root package name */
    static int f57356b;

    private static int a(String str, int i2, int i3) {
        int i4 = 0;
        while (i2 < i3) {
            if (str.charAt(i2) == '\"') {
                i4++;
            }
            i2++;
        }
        return i4;
    }

    public static String b(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        int i3 = 0;
        int iA = 0;
        while (true) {
            int iIndexOf = str.indexOf("+", i2);
            if (iIndexOf < 0) {
                stringBuffer.append(c(g(str.substring(i3))));
                return stringBuffer.toString();
            }
            iA += a(str, i2, iIndexOf);
            if (iIndexOf > 0 && str.charAt(iIndexOf - 1) != '\\' && iA % 2 != 1) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(c(g(str.substring(i3, iIndexOf))));
                stringBuffer2.append("+");
                stringBuffer.append(stringBuffer2.toString());
                i3 = iIndexOf + 1;
                iA = 0;
            }
            i2 = iIndexOf + 1;
        }
    }

    public static String c(String str) {
        int iIndexOf = str.indexOf("=");
        if (iIndexOf == -1) {
            return str;
        }
        if (iIndexOf > 0 && str.charAt(iIndexOf - 1) == '\\') {
            return str;
        }
        String strD = d(str.substring(0, iIndexOf));
        String strE = (strD.charAt(0) < '0' || strD.charAt(0) > '9') ? e(str.substring(iIndexOf + 1)) : str.substring(iIndexOf + 1);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(strD);
        stringBuffer.append("=");
        stringBuffer.append(strE);
        return stringBuffer.toString();
    }

    public static String d(String str) {
        String strTrim = str.toUpperCase().trim();
        return strTrim.startsWith("OID") ? strTrim.substring(3) : strTrim;
    }

    public static String e(String str) throws IOException {
        String strG = g(str);
        if (strG.startsWith("\"")) {
            StringBuffer stringBuffer = new StringBuffer();
            StringReader stringReader = new StringReader(a.k(1, 1, strG));
            while (true) {
                int i2 = stringReader.read();
                if (i2 <= -1) {
                    break;
                }
                char c2 = (char) i2;
                if (c2 == ',' || c2 == '=' || c2 == '+' || c2 == '<' || c2 == '>' || c2 == '#' || c2 == ';') {
                    stringBuffer.append('\\');
                }
                stringBuffer.append(c2);
            }
            strG = g(stringBuffer.toString());
        }
        return f57355a ? strG.startsWith("#") ? "\\".concat(strG) : strG : strG.startsWith("\\#") ? strG.substring(1) : strG;
    }

    public static String f(String str) {
        return a(str, ";", ",");
    }

    public static String g(String str) {
        String strTrim = str.trim();
        int length = strTrim.length() + str.indexOf(strTrim);
        return (str.length() <= length || !strTrim.endsWith("\\") || strTrim.endsWith("\\\\") || str.charAt(length) != ' ') ? strTrim : strTrim.concat(StringUtils.SPACE);
    }

    public static String a(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        try {
            String strF = f(str);
            StringBuffer stringBuffer = new StringBuffer();
            int i2 = 0;
            int i3 = 0;
            int iA = 0;
            while (true) {
                int iIndexOf = strF.indexOf(",", i2);
                if (iIndexOf < 0) {
                    stringBuffer.append(b(g(strF.substring(i3))));
                    return stringBuffer.toString();
                }
                iA += a(strF, i2, iIndexOf);
                if (iIndexOf > 0 && strF.charAt(iIndexOf - 1) != '\\' && iA % 2 != 1) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append(b(strF.substring(i3, iIndexOf).trim()));
                    stringBuffer2.append(",");
                    stringBuffer.append(stringBuffer2.toString());
                    i3 = iIndexOf + 1;
                    iA = 0;
                }
                i2 = iIndexOf + 1;
            }
        } catch (IOException unused) {
            return str;
        }
    }

    public static String a(String str, String str2, String str3) {
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        int i3 = 0;
        int iA = 0;
        while (true) {
            int iIndexOf = str.indexOf(str2, i2);
            if (iIndexOf < 0) {
                stringBuffer.append(g(str.substring(i3)));
                return stringBuffer.toString();
            }
            iA += a(str, i2, iIndexOf);
            if (iIndexOf > 0 && str.charAt(iIndexOf - 1) != '\\' && iA % 2 != 1) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(g(str.substring(i3, iIndexOf)));
                stringBuffer2.append(str3);
                stringBuffer.append(stringBuffer2.toString());
                i3 = iIndexOf + 1;
                iA = 0;
            }
            i2 = iIndexOf + 1;
        }
    }
}
