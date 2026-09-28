package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlinx.coroutines.internal.SystemPropsKt;

@Metadata
/* loaded from: classes.dex */
public final class TasksKt {

    /* renamed from: a, reason: collision with root package name */
    public static final String f55158a;

    /* renamed from: b, reason: collision with root package name */
    public static final long f55159b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f55160c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f55161d;

    /* renamed from: e, reason: collision with root package name */
    public static final long f55162e;

    /* renamed from: f, reason: collision with root package name */
    public static final NanoTimeSource f55163f;

    static {
        String strC = SystemPropsKt.c("kotlinx.coroutines.scheduler.default.name");
        if (strC == null) {
            strC = "DefaultDispatcher";
        }
        f55158a = strC;
        f55159b = SystemPropsKt.b(100000L, 1L, Long.MAX_VALUE, "kotlinx.coroutines.scheduler.resolution.ns");
        int iA = SystemPropsKt.a();
        if (iA < 2) {
            iA = 2;
        }
        f55160c = SystemPropsKt.d(iA, 8, "kotlinx.coroutines.scheduler.core.pool.size");
        f55161d = SystemPropsKt.d(2097150, 4, "kotlinx.coroutines.scheduler.max.pool.size");
        f55162e = TimeUnit.SECONDS.toNanos(SystemPropsKt.b(60L, 1L, Long.MAX_VALUE, "kotlinx.coroutines.scheduler.keep.alive.sec"));
        f55163f = NanoTimeSource.f55153a;
    }
}
