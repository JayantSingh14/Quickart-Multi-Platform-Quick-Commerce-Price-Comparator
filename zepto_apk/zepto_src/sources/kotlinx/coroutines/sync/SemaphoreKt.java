package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.SystemPropsKt;

@Metadata
/* loaded from: classes.dex */
public final class SemaphoreKt {

    /* renamed from: a, reason: collision with root package name */
    public static final int f55248a = SystemPropsKt.d(100, 12, "kotlinx.coroutines.semaphore.maxSpinCycles");

    /* renamed from: b, reason: collision with root package name */
    public static final Symbol f55249b = new Symbol("PERMIT");

    /* renamed from: c, reason: collision with root package name */
    public static final Symbol f55250c = new Symbol("TAKEN");

    /* renamed from: d, reason: collision with root package name */
    public static final Symbol f55251d = new Symbol("BROKEN");

    /* renamed from: e, reason: collision with root package name */
    public static final Symbol f55252e = new Symbol("CANCELLED");

    /* renamed from: f, reason: collision with root package name */
    public static final int f55253f = SystemPropsKt.d(16, 12, "kotlinx.coroutines.semaphore.segmentSize");

    public static Semaphore a(int i2) {
        return new SemaphoreImpl(i2, 0);
    }
}
