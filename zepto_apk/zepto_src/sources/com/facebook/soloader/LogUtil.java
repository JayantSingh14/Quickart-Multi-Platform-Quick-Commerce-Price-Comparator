package com.facebook.soloader;

import android.os.Build;
import android.util.Log;

/* loaded from: classes.dex */
public class LogUtil {
    public static void a(String str) {
        if (b(3, "SoLoader")) {
            Log.d("SoLoader", str);
        }
    }

    public static boolean b(int i2, String str) {
        return (Build.VERSION.SDK_INT > 25 || str.length() <= 23) ? Log.isLoggable(str, i2) : Log.isLoggable(str.substring(0, 23), i2);
    }

    public static void c(String str, String str2) {
        if (b(2, str)) {
            Log.v(str, str2);
        }
    }
}
