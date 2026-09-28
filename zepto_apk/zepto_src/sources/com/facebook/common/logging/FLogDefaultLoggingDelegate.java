package com.facebook.common.logging;

import android.support.v4.media.b;
import android.util.Log;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes.dex */
public class FLogDefaultLoggingDelegate implements LoggingDelegate {

    /* renamed from: a, reason: collision with root package name */
    public static final FLogDefaultLoggingDelegate f17087a = new FLogDefaultLoggingDelegate();

    public static void b(int i2, String str, String str2) {
        Log.println(i2, "unknown:" + str, str2);
    }

    public static void c(int i2, String str, String str2, Throwable th) {
        String strC = b.C("unknown:", str);
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append('\n');
        sb.append(th == null ? "" : Log.getStackTraceString(th));
        Log.println(i2, strC, sb.toString());
    }

    public final boolean a(int i2) {
        return 5 <= i2;
    }
}
