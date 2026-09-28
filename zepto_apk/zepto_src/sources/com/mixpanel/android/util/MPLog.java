package com.mixpanel.android.util;

import android.util.Log;

/* loaded from: classes.dex */
public class MPLog {

    /* renamed from: a, reason: collision with root package name */
    public static int f46096a = 5;

    public static void a(String str, String str2) {
        if (d(3)) {
            Log.d(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (d(6)) {
            Log.e(str, str2);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        if (d(6)) {
            Log.e(str, str2, th);
        }
    }

    public static boolean d(int i2) {
        return f46096a <= i2;
    }

    public static void e(String str, String str2) {
        if (d(2)) {
            Log.v(str, str2);
        }
    }

    public static void f(String str, String str2) {
        if (d(5)) {
            Log.w(str, str2);
        }
    }
}
