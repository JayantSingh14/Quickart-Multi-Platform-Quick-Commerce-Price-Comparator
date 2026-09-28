package com.scottyab.rootbeer.util;

import android.util.Log;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class QLog {

    /* renamed from: a, reason: collision with root package name */
    public static int f46708a = 5;

    public static void a(Serializable serializable) {
        if (f46708a > 0) {
            Log.e("RootBeer", b() + String.valueOf(serializable));
            Log.e("QLog", b() + String.valueOf(serializable));
        }
    }

    public static String b() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        String methodName = stackTrace[2].getMethodName();
        String className = stackTrace[2].getClassName();
        int lineNumber = stackTrace[2].getLineNumber();
        return className.substring(className.lastIndexOf(46) + 1) + ": " + methodName + "() [" + lineNumber + "] - ";
    }

    public static void c(String str) {
        if (f46708a > 4) {
            Log.v("RootBeer", b() + String.valueOf(str));
        }
    }
}
