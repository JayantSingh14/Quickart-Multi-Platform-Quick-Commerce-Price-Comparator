package com.google.android.gms.internal.ads;

import android.util.Log;
import java.util.Locale;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzarw {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f24246a = Log.isLoggable("Volley", 2);

    /* renamed from: b, reason: collision with root package name */
    public static final String f24247b = zzarw.class.getName();

    public static void a(String str, Object... objArr) {
        if (f24246a) {
            Log.v("Volley", d(str, objArr));
        }
    }

    public static void b(String str, Object... objArr) {
        Log.d("Volley", d(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e("Volley", d(str, objArr));
    }

    public static String d(String str, Object... objArr) {
        String strS;
        String str2 = String.format(Locale.US, str, objArr);
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i2 = 2;
        while (true) {
            if (i2 >= stackTrace.length) {
                strS = "<unknown>";
                break;
            }
            if (!stackTrace[i2].getClassName().equals(f24247b)) {
                String className = stackTrace[i2].getClassName();
                String strSubstring = className.substring(className.lastIndexOf(46) + 1);
                String strSubstring2 = strSubstring.substring(strSubstring.lastIndexOf(36) + 1);
                String methodName = stackTrace[i2].getMethodName();
                strS = android.support.v4.media.b.s(new StringBuilder(androidx.fragment.app.e.g(1, strSubstring2) + String.valueOf(methodName).length()), strSubstring2, CLConstants.DOT_SALT_DELIMETER, methodName);
                break;
            }
            i2++;
        }
        Locale locale = Locale.US;
        long id = Thread.currentThread().getId();
        StringBuilder sb = new StringBuilder("[");
        sb.append(id);
        sb.append("] ");
        sb.append(strS);
        return android.support.v4.media.b.r(sb, ": ", str2);
    }
}
