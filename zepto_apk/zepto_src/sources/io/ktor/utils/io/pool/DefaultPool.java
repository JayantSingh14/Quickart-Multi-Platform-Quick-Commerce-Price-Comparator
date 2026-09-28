package io.ktor.utils.io.pool;

import android.support.v4.media.b;
import io.ktor.utils.io.pool.ObjectPool;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class DefaultPool<T> implements ObjectPool<T> {

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f51369e;

    /* renamed from: a, reason: collision with root package name */
    public final int f51370a;

    /* renamed from: b, reason: collision with root package name */
    public final int f51371b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicReferenceArray f51372c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f51373d;
    private volatile long top;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {
    }

    static {
        AtomicLongFieldUpdater atomicLongFieldUpdaterNewUpdater = AtomicLongFieldUpdater.newUpdater(DefaultPool.class, DefaultPool$Companion$Top$1.f51374c.getName());
        Intrinsics.checkNotNullExpressionValue(atomicLongFieldUpdaterNewUpdater, "newUpdater(Owner::class.java, p.name)");
        f51369e = atomicLongFieldUpdaterNewUpdater;
    }

    public DefaultPool(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException(b.f(i2, "capacity should be positive but it is ").toString());
        }
        if (i2 > 536870911) {
            throw new IllegalArgumentException(b.f(i2, "capacity should be less or equal to 536870911 but it is ").toString());
        }
        int iHighestOneBit = Integer.highestOneBit((i2 * 4) - 1) * 2;
        this.f51370a = iHighestOneBit;
        this.f51371b = Integer.numberOfLeadingZeros(iHighestOneBit) + 1;
        int i3 = iHighestOneBit + 1;
        this.f51372c = new AtomicReferenceArray(i3);
        this.f51373d = new int[i3];
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final void G1(Object instance) {
        long j2;
        long j3;
        Intrinsics.checkNotNullParameter(instance, "instance");
        s(instance);
        int iIdentityHashCode = ((System.identityHashCode(instance) * (-1640531527)) >>> this.f51371b) + 1;
        for (int i2 = 0; i2 < 8; i2++) {
            AtomicReferenceArray atomicReferenceArray = this.f51372c;
            while (!atomicReferenceArray.compareAndSet(iIdentityHashCode, null, instance)) {
                if (atomicReferenceArray.get(iIdentityHashCode) != null) {
                    iIdentityHashCode--;
                    if (iIdentityHashCode == 0) {
                        iIdentityHashCode = this.f51370a;
                    }
                }
            }
            if (iIdentityHashCode <= 0) {
                throw new IllegalArgumentException("index should be positive");
            }
            do {
                j2 = this.top;
                j3 = ((((j2 >> 32) & 4294967295L) + 1) << 32) | iIdentityHashCode;
                this.f51373d[iIdentityHashCode] = (int) (4294967295L & j2);
            } while (!f51369e.compareAndSet(this, j2, j3));
            return;
        }
        e(instance);
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final Object S0() {
        Object objC;
        Object objR = r();
        return (objR == null || (objC = c(objR)) == null) ? l() : objC;
    }

    public Object c(Object instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
        return instance;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ObjectPool.DefaultImpls.a(this);
    }

    @Override // io.ktor.utils.io.pool.ObjectPool
    public final void dispose() {
        while (true) {
            Object objR = r();
            if (objR == null) {
                return;
            } else {
                e(objR);
            }
        }
    }

    public void e(Object instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
    }

    public abstract Object l();

    public final Object r() {
        long j2;
        int i2;
        DefaultPool<T> defaultPool;
        long j3;
        do {
            j2 = this.top;
            if (j2 != 0) {
                j3 = ((j2 >> 32) & 4294967295L) + 1;
                i2 = (int) (4294967295L & j2);
                if (i2 != 0) {
                    defaultPool = this;
                }
            }
            i2 = 0;
            defaultPool = this;
            break;
        } while (!f51369e.compareAndSet(defaultPool, j2, (j3 << 32) | this.f51373d[i2]));
        if (i2 == 0) {
            return null;
        }
        return defaultPool.f51372c.getAndSet(i2, null);
    }

    public void s(Object instance) {
        Intrinsics.checkNotNullParameter(instance, "instance");
    }
}
