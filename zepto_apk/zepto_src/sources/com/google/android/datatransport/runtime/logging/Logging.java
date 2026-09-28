package com.google.android.datatransport.runtime.logging;

import android.os.Build;
import android.util.Log;

/* loaded from: classes3.dex */
public final class Logging {
    public static void a(String str, String str2, Object obj) {
        String strD = d(str);
        if (Log.isLoggable(strD, 3)) {
            Log.d(strD, String.format(str2, obj));
        }
    }

    public static void b(String str, String str2, Object... objArr) {
        String strD = d(str);
        if (Log.isLoggable(strD, 3)) {
            Log.d(strD, String.format(str2, objArr));
        }
    }

    public static void c(String str, String str2, Exception exc) {
        String strD = d(str);
        if (Log.isLoggable(strD, 6)) {
            Log.e(strD, str2, exc);
        }
    }

    public static String d(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            return "TRuntime.".concat(str);
        }
        String strConcat = "TRuntime.".concat(str);
        return strConcat.length() > 23 ? strConcat.substring(0, 23) : strConcat;
    }
}
