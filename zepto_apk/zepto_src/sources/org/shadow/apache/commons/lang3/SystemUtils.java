package org.shadow.apache.commons.lang3;

/* loaded from: classes5.dex */
public class SystemUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final String f57725a;

    /* renamed from: b, reason: collision with root package name */
    public static final JavaVersion f57726b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f57727c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f57728d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f57729e;

    /* JADX WARN: Removed duplicated region for block: B:34:0x00e0  */
    static {
        /*
            Method dump skipped, instructions count: 648
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.shadow.apache.commons.lang3.SystemUtils.<clinit>():void");
    }

    public static void a(String str) {
        String str2 = f57725a;
        if (str2 == null) {
            return;
        }
        str2.startsWith(str);
    }

    public static void b(String str) {
        String str2;
        String str3 = f57728d;
        if (str3 == null || (str2 = f57729e) == null || !str3.startsWith("Mac OS X") || StringUtils.a(str2)) {
            return;
        }
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = str2.split("\\.");
        for (int i2 = 0; i2 < Math.min(strArrSplit.length, strArrSplit2.length) && strArrSplit[i2].equals(strArrSplit2[i2]); i2++) {
        }
    }

    public static void c(String str) {
        e(f57728d, str);
    }

    public static String d(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            System.err.println("Caught a SecurityException reading the system property '" + str + "'; the SystemUtils property value will default to null.");
            return null;
        }
    }

    public static boolean e(String str, String str2) {
        if (str == null) {
            return false;
        }
        return str.startsWith(str2);
    }
}
