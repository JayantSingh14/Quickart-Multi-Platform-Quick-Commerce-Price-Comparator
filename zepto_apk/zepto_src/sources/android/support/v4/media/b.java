package android.support.v4.media;

import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract /* synthetic */ class b {
    public static void A(String str, String str2, String str3) {
        Log.w(str3, str + str2);
    }

    public static void B(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
    }

    public static String C(String str, String str2) {
        return str + str2;
    }

    public static String D(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static double a(double d2, double d3, double d4, double d5) {
        return (d2 * d3 * d4) + d5;
    }

    public static int b(int i2, int i3, int i4, int i5) {
        return i2 + i3 + i4 + i5;
    }

    public static Object c(int i2, ArrayList arrayList) {
        return arrayList.get(arrayList.size() - i2);
    }

    public static String d(int i2, int i3, String str, String str2) {
        return str + i2 + str2 + i3;
    }

    public static String e(int i2, int i3, String str, String str2, String str3) {
        return str + i2 + str2 + i3 + str3;
    }

    public static String f(int i2, String str) {
        return str + i2;
    }

    public static String g(int i2, String str, String str2) {
        return str + i2 + str2;
    }

    public static String h(int i2, String str, String str2, String str3) {
        return str + i2 + str2 + str3;
    }

    public static String i(long j2, String str) {
        return str + j2;
    }

    public static String j(Object obj, String str) {
        return str + obj;
    }

    public static String k(String str, String str2) {
        return str + str2;
    }

    public static String l(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String m(String str, String str2, String str3, String str4, String str5) {
        return str + str2 + str3 + str4 + str5;
    }

    public static String n(StringBuilder sb, int i2, char c2) {
        sb.append(i2);
        sb.append(c2);
        return sb.toString();
    }

    public static String o(StringBuilder sb, int i2, String str) {
        sb.append(i2);
        sb.append(str);
        return sb.toString();
    }

    public static String p(StringBuilder sb, long j2, String str) {
        sb.append(j2);
        sb.append(str);
        return sb.toString();
    }

    public static String q(StringBuilder sb, Object obj, String str) {
        sb.append(obj);
        sb.append(str);
        return sb.toString();
    }

    public static String r(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String s(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    public static StringBuilder t(int i2, int i3, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i2);
        sb.append(str2);
        sb.append(i3);
        sb.append(str3);
        return sb;
    }

    public static StringBuilder u(int i2, String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i2);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder v(long j2, String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(j2);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder w(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static StringBuilder x(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder y(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    public static void z(int i2, HashMap map, String str, int i3, String str2) {
        map.put(str, Integer.valueOf(i2));
        map.put(str2, Integer.valueOf(i3));
    }
}
