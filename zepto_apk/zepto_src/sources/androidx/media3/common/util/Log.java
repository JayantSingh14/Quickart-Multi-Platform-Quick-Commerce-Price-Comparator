package androidx.media3.common.util;

import android.text.TextUtils;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.UnknownHostException;
import org.apache.commons.lang3.StringUtils;

@UnstableApi
/* loaded from: classes3.dex */
public final class Log {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f5700a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f5701b = Logger.f5702a;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface LogLevel {
    }

    public interface Logger {

        /* renamed from: a, reason: collision with root package name */
        public static final Logger f5702a = new AnonymousClass1();

        /* renamed from: androidx.media3.common.util.Log$Logger$1, reason: invalid class name */
        public class AnonymousClass1 implements Logger {
        }
    }

    public static String a(String str, Throwable th) {
        String strF = f(th);
        if (TextUtils.isEmpty(strF)) {
            return str;
        }
        StringBuilder sbX = android.support.v4.media.b.x(str, "\n  ");
        sbX.append(strF.replace(StringUtils.LF, "\n  "));
        sbX.append('\n');
        return sbX.toString();
    }

    public static void b(String str, String str2) {
        synchronized (f5700a) {
            android.util.Log.d(str, a(str2, null));
        }
    }

    public static void c(String str, String str2, Exception exc) {
        synchronized (f5700a) {
            android.util.Log.d(str, a(str2, exc));
        }
    }

    public static void d(String str, String str2) {
        synchronized (f5700a) {
            android.util.Log.e(str, a(str2, null));
        }
    }

    public static void e(String str, String str2, Throwable th) {
        synchronized (f5700a) {
            android.util.Log.e(str, a(str2, th));
        }
    }

    public static String f(Throwable th) {
        boolean z;
        if (th == null) {
            return null;
        }
        synchronized (f5700a) {
            Throwable cause = th;
            while (true) {
                if (cause == null) {
                    z = false;
                    break;
                }
                try {
                    if (cause instanceof UnknownHostException) {
                        z = true;
                        break;
                    }
                    cause = cause.getCause();
                } finally {
                }
            }
            if (z) {
                return "UnknownHostException (no network)";
            }
            return android.util.Log.getStackTraceString(th).trim().replace("\t", "    ");
        }
    }

    public static void g(String str, String str2) {
        synchronized (f5700a) {
            android.util.Log.i(str, a(str2, null));
        }
    }

    public static void h(String str, String str2) {
        synchronized (f5700a) {
            android.util.Log.w(str, a(str2, null));
        }
    }

    public static void i(String str, String str2, Throwable th) {
        synchronized (f5700a) {
            android.util.Log.w(str, a(str2, th));
        }
    }
}
