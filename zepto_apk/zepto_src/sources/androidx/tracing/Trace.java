package androidx.tracing;

import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes.dex */
public final class Trace {

    /* renamed from: a, reason: collision with root package name */
    public static long f12001a;

    /* renamed from: b, reason: collision with root package name */
    public static Method f12002b;

    /* renamed from: c, reason: collision with root package name */
    public static Method f12003c;

    /* renamed from: d, reason: collision with root package name */
    public static Method f12004d;

    /* renamed from: e, reason: collision with root package name */
    public static Method f12005e;

    public static void a(int i2, String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 29) {
            TraceApi29Impl.a(i2, g(str));
            return;
        }
        String strG = g(str);
        try {
            if (f12003c == null) {
                f12003c = android.os.Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
            }
            f12003c.invoke(null, Long.valueOf(f12001a), strG, Integer.valueOf(i2));
        } catch (Exception e2) {
            d("asyncTraceBegin", e2);
        }
    }

    public static void b(String str) {
        android.os.Trace.beginSection(g(str));
    }

    public static void c(int i2, String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT >= 29) {
            TraceApi29Impl.b(i2, g(str));
            return;
        }
        String strG = g(str);
        try {
            if (f12004d == null) {
                f12004d = android.os.Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
            }
            f12004d.invoke(null, Long.valueOf(f12001a), strG, Integer.valueOf(i2));
        } catch (Exception e2) {
            d("asyncTraceEnd", e2);
        }
    }

    public static void d(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    public static boolean e() {
        if (Build.VERSION.SDK_INT >= 29) {
            return TraceApi29Impl.c();
        }
        try {
            if (f12002b == null) {
                f12001a = android.os.Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f12002b = android.os.Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f12002b.invoke(null, Long.valueOf(f12001a))).booleanValue();
        } catch (Exception e2) {
            d("isTagEnabled", e2);
            return false;
        }
    }

    public static void f(int i2, String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            TraceApi29Impl.d(i2, g(str));
            return;
        }
        String strG = g(str);
        try {
            if (f12005e == null) {
                f12005e = android.os.Trace.class.getMethod("traceCounter", Long.TYPE, String.class, Integer.TYPE);
            }
            f12005e.invoke(null, Long.valueOf(f12001a), strG, Integer.valueOf(i2));
        } catch (Exception e2) {
            d("traceCounter", e2);
        }
    }

    public static String g(String str) {
        return str.length() <= 127 ? str : str.substring(0, WKSRecord.Service.LOCUS_CON);
    }
}
