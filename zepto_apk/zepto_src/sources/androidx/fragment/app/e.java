package androidx.fragment.app;

import android.content.res.TypedArray;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzll;
import com.google.android.gms.measurement.internal.zzpf;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract /* synthetic */ class e {
    public static void A(StringBuilder sb, String str, long j2, String str2) {
        sb.append(str);
        sb.append(j2);
        sb.append(str2);
    }

    public static int B(int i2, int i3, int i4) {
        return zzll.w(i2) + i3 + i4;
    }

    public static int C(int i2, int i3, String str) {
        return str.length() + i2 + i3;
    }

    public static String D(String str, String str2, String str3, String str4) {
        return str + str2 + str3 + str4;
    }

    public static int a(int i2, int i3) {
        return String.valueOf(i2).length() + i3;
    }

    public static int b(int i2, int i3, int i4) {
        int i5 = i2 / i3;
        return i5 + i5 + i4;
    }

    public static int c(int i2, int i3, int i4, int i5) {
        return zzll.w(i2) + i3 + i4 + i5;
    }

    public static int d(int i2, int i3, int i4, int i5, int i6) {
        return Math.max(((i2 * i3) / i4) + i5, i6);
    }

    public static int e(int i2, int i3, String str) {
        return (str.hashCode() + i2) * i3;
    }

    public static int f(int i2, int i3, List list) {
        return (list.hashCode() + i2) * i3;
    }

    public static int g(int i2, String str) {
        return String.valueOf(str).length() + i2;
    }

    public static long h(int i2, long j2, long j3, long j4) {
        return Long.rotateLeft(j2 * j3, i2) * j4;
    }

    public static Bundle i(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(str, str2);
        return bundle;
    }

    public static Integer j(int i2, Integer num, String str, String str2, HashMap map) {
        map.put(num, str);
        Integer numValueOf = Integer.valueOf(i2);
        map.put(numValueOf, str2);
        return numValueOf;
    }

    public static Object k(int i2, List list) {
        return list.get(list.size() - i2);
    }

    public static String l(char c2, String str, String str2) {
        return str + str2 + c2;
    }

    public static String m(int i2, int i3, String str) {
        StringBuilder sb = new StringBuilder(i2);
        sb.append(str);
        sb.append(i3);
        return sb.toString();
    }

    public static String n(int i2, int i3, String str, String str2, StringBuilder sb) {
        sb.append(str);
        sb.append(i2);
        sb.append(str2);
        sb.append(i3);
        return sb.toString();
    }

    public static String o(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    public static String p(String str, String str2, String str3, String str4) {
        return str + str2 + str3 + str4;
    }

    public static String q(String str, Type type) {
        return str + type;
    }

    public static String r(StringBuilder sb, int i2, String str) {
        sb.append(str);
        sb.append(i2);
        return sb.toString();
    }

    public static String s(StringBuilder sb, String str) {
        return str + ((Object) sb);
    }

    public static String t(StringBuilder sb, String str, char c2) {
        sb.append(str);
        sb.append(c2);
        return sb.toString();
    }

    public static String u(StringBuilder sb, String str, int i2, String str2) {
        sb.append(str);
        sb.append(i2);
        sb.append(str2);
        return sb.toString();
    }

    public static StringBuilder v(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        sb.append(str5);
        return sb;
    }

    public static void w(int i2, int i3, String str, String str2, StringBuilder sb) {
        sb.append(str);
        sb.append(i2);
        sb.append(str2);
        sb.append(i3);
    }

    public static void x(int i2, Integer num, String str, String str2, HashMap map) {
        map.put(str, num);
        map.put(str2, Integer.valueOf(i2));
    }

    public static void y(zzpf zzpfVar) {
        zzpfVar.c().g();
        zzpfVar.k0();
    }

    public static /* synthetic */ void z(AutoCloseable autoCloseable) throws Exception {
        boolean zIsTerminated;
        if (autoCloseable instanceof AutoCloseable) {
            autoCloseable.close();
            return;
        }
        if (!(autoCloseable instanceof ExecutorService)) {
            if (autoCloseable instanceof TypedArray) {
                ((TypedArray) autoCloseable).recycle();
                return;
            } else if (autoCloseable instanceof MediaMetadataRetriever) {
                ((MediaMetadataRetriever) autoCloseable).release();
                return;
            } else {
                if (!(autoCloseable instanceof MediaDrm)) {
                    throw new IllegalArgumentException();
                }
                ((MediaDrm) autoCloseable).release();
                return;
            }
        }
        ExecutorService executorService = (ExecutorService) autoCloseable;
        if (executorService == ForkJoinPool.commonPool() || (zIsTerminated = executorService.isTerminated())) {
            return;
        }
        executorService.shutdown();
        boolean z = false;
        while (!zIsTerminated) {
            try {
                zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
            } catch (InterruptedException unused) {
                if (!z) {
                    executorService.shutdownNow();
                    z = true;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }
}
