package ch.qos.logback.core.joran.util.beans;

import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class BeanUtil {
    public static String a(Method method) {
        String name = method.getName();
        String strB = b(name, "get");
        if (strB == null) {
            strB = b(name, "set");
        }
        if (strB == null) {
            strB = b(name, "is");
        }
        if (strB == null) {
            strB = b(name, "add");
        }
        return c(strB);
    }

    public static String b(String str, String str2) {
        if (str.startsWith(str2)) {
            return str.substring(str2.length());
        }
        return null;
    }

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        if (str.isEmpty() || (str.length() > 1 && Character.isUpperCase(str.charAt(1)) && Character.isUpperCase(str.charAt(0)))) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }
}
