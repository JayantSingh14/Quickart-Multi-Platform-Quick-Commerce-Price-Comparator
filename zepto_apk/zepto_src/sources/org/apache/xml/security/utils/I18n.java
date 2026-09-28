package org.apache.xml.security.utils;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.xml.security.Init;

/* loaded from: classes5.dex */
public class I18n {

    /* renamed from: a, reason: collision with root package name */
    static String f57338a = null;

    /* renamed from: b, reason: collision with root package name */
    static String f57339b = null;

    /* renamed from: c, reason: collision with root package name */
    static ResourceBundle f57340c = null;

    /* renamed from: d, reason: collision with root package name */
    static boolean f57341d = false;

    /* renamed from: e, reason: collision with root package name */
    static String f57342e;

    /* renamed from: f, reason: collision with root package name */
    static String f57343f;

    private I18n() {
    }

    public static String a(String str) {
        return b(str);
    }

    public static String b(String str) {
        try {
            return f57340c.getString(str);
        } catch (Throwable unused) {
            if (!Init.a()) {
                return "You must initialize the xml-security library correctly before you use it. Call the static method \"org.apache.xml.security.Init.init();\" to do that before you use any functionality from that library.";
            }
            StringBuffer stringBuffer = new StringBuffer("No message with ID \"");
            stringBuffer.append(str);
            stringBuffer.append("\" found in resource bundle \"org/apache/xml/security/resource/xmlsecurity\"");
            return stringBuffer.toString();
        }
    }

    public static String a(String str, Exception exc) {
        try {
            return MessageFormat.format(f57340c.getString(str), exc.getMessage());
        } catch (Throwable unused) {
            if (!Init.a()) {
                return "You must initialize the xml-security library correctly before you use it. Call the static method \"org.apache.xml.security.Init.init();\" to do that before you use any functionality from that library.";
            }
            StringBuffer stringBuffer = new StringBuffer("No message with ID \"");
            stringBuffer.append(str);
            stringBuffer.append("\" found in resource bundle \"org/apache/xml/security/resource/xmlsecurity\". Original Exception was a ");
            stringBuffer.append(exc.getClass().getName());
            stringBuffer.append(" and message ");
            stringBuffer.append(exc.getMessage());
            return stringBuffer.toString();
        }
    }

    public static String b(String str, Object[] objArr) {
        try {
            return MessageFormat.format(f57340c.getString(str), objArr);
        } catch (Throwable unused) {
            if (!Init.a()) {
                return "You must initialize the xml-security library correctly before you use it. Call the static method \"org.apache.xml.security.Init.init();\" to do that before you use any functionality from that library.";
            }
            StringBuffer stringBuffer = new StringBuffer("No message with ID \"");
            stringBuffer.append(str);
            stringBuffer.append("\" found in resource bundle \"org/apache/xml/security/resource/xmlsecurity\"");
            return stringBuffer.toString();
        }
    }

    public static String a(String str, Object[] objArr) {
        return b(str, objArr);
    }

    public static void b(String str, String str2) {
        if (f57341d && str.equals(f57342e) && str2.equals(f57343f)) {
            return;
        }
        if (str == null || str2 == null || str.length() <= 0 || str2.length() <= 0) {
            f57343f = f57339b;
            f57342e = f57338a;
        } else {
            f57342e = str;
            f57343f = str2;
        }
        f57340c = ResourceBundle.getBundle("org/apache/xml/security/resource/xmlsecurity", new Locale(f57342e, f57343f));
    }

    public static void a(String str, String str2) {
        f57338a = str;
        if (str == null) {
            f57338a = Locale.getDefault().getLanguage();
        }
        f57339b = str2;
        if (str2 == null) {
            f57339b = Locale.getDefault().getCountry();
        }
        b(f57338a, f57339b);
    }
}
