package androidx.work;

import android.util.Log;
import androidx.annotation.RestrictTo;

@RestrictTo
/* loaded from: classes.dex */
public abstract class Logger {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f12533a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static volatile LogcatLogger f12534b;

    public static class LogcatLogger extends Logger {

        /* renamed from: c, reason: collision with root package name */
        public final int f12535c;

        public LogcatLogger(int i2) {
            this.f12535c = i2;
        }

        @Override // androidx.work.Logger
        public final void a(String str, String str2) {
            if (this.f12535c <= 3) {
                Log.d(str, str2);
            }
        }

        @Override // androidx.work.Logger
        public final void b(String str, String str2, Throwable th) {
            if (this.f12535c <= 3) {
                Log.d(str, str2, th);
            }
        }

        @Override // androidx.work.Logger
        public final void c(String str, String str2) {
            if (this.f12535c <= 6) {
                Log.e(str, str2);
            }
        }

        @Override // androidx.work.Logger
        public final void d(String str, String str2, Throwable th) {
            if (this.f12535c <= 6) {
                Log.e(str, str2, th);
            }
        }

        @Override // androidx.work.Logger
        public final void f(String str, String str2) {
            if (this.f12535c <= 4) {
                Log.i(str, str2);
            }
        }

        @Override // androidx.work.Logger
        public final void h(String str, String str2) {
            if (this.f12535c <= 5) {
                Log.w(str, str2);
            }
        }

        @Override // androidx.work.Logger
        public final void i(String str, String str2, RuntimeException runtimeException) {
            if (this.f12535c <= 5) {
                Log.w(str, str2, runtimeException);
            }
        }
    }

    public static Logger e() {
        LogcatLogger logcatLogger;
        synchronized (f12533a) {
            try {
                if (f12534b == null) {
                    f12534b = new LogcatLogger(3);
                }
                logcatLogger = f12534b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return logcatLogger;
    }

    public static String g(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(23);
        sb.append("WM-");
        if (length >= 20) {
            sb.append(str.substring(0, 20));
        } else {
            sb.append(str);
        }
        return sb.toString();
    }

    public abstract void a(String str, String str2);

    public abstract void b(String str, String str2, Throwable th);

    public abstract void c(String str, String str2);

    public abstract void d(String str, String str2, Throwable th);

    public abstract void f(String str, String str2);

    public abstract void h(String str, String str2);

    public abstract void i(String str, String str2, RuntimeException runtimeException);
}
