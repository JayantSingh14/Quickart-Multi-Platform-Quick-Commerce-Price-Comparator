package com.facebook.imagepipeline.memory;

import android.support.v4.media.b;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.annotation.VisibleForTesting;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.logging.FLog;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.Pool;
import com.facebook.infer.annotation.Nullsafe;
import com.google.android.gms.common.api.Api;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import javax.annotation.concurrent.NotThreadSafe;

@Nullsafe
/* loaded from: classes.dex */
public abstract class BasePool<V> implements Pool<V> {

    /* renamed from: a, reason: collision with root package name */
    public final Class f17982a = getClass();

    /* renamed from: b, reason: collision with root package name */
    public final MemoryTrimmableRegistry f17983b;

    /* renamed from: c, reason: collision with root package name */
    public final PoolParams f17984c;

    /* renamed from: d, reason: collision with root package name */
    public final SparseArray f17985d;

    /* renamed from: e, reason: collision with root package name */
    public final Set f17986e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f17987f;

    /* renamed from: g, reason: collision with root package name */
    public final Counter f17988g;

    /* renamed from: h, reason: collision with root package name */
    public final Counter f17989h;

    /* renamed from: i, reason: collision with root package name */
    public final PoolStatsTracker f17990i;

    @NotThreadSafe
    @VisibleForTesting
    public static class Counter {

        /* renamed from: a, reason: collision with root package name */
        public int f17991a;

        /* renamed from: b, reason: collision with root package name */
        public int f17992b;

        public final void a(int i2) {
            int i3;
            int i4 = this.f17992b;
            if (i4 < i2 || (i3 = this.f17991a) <= 0) {
                FLog.v("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i2), Integer.valueOf(this.f17992b), Integer.valueOf(this.f17991a));
            } else {
                this.f17991a = i3 - 1;
                this.f17992b = i4 - i2;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class InvalidSizeException extends RuntimeException {
        public InvalidSizeException(Integer num) {
            super("Invalid size: " + num.toString());
        }
    }

    /* loaded from: classes3.dex */
    public static class InvalidValueException extends RuntimeException {
    }

    /* loaded from: classes3.dex */
    public static class PoolSizeViolationException extends RuntimeException {
        /* JADX WARN: Illegal instructions before constructor call */
        public PoolSizeViolationException(int i2, int i3, int i4, int i5) {
            StringBuilder sbT = b.t(i2, i3, "Pool hard cap violation? Hard cap = ", " Used size = ", " Free size = ");
            sbT.append(i4);
            sbT.append(" Request size = ");
            sbT.append(i5);
            super(sbT.toString());
        }
    }

    /* loaded from: classes3.dex */
    public static class SizeTooLargeException extends InvalidSizeException {
    }

    public BasePool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        memoryTrimmableRegistry.getClass();
        this.f17983b = memoryTrimmableRegistry;
        poolParams.getClass();
        this.f17984c = poolParams;
        poolStatsTracker.getClass();
        this.f17990i = poolStatsTracker;
        SparseArray sparseArray = new SparseArray();
        this.f17985d = sparseArray;
        SparseIntArray sparseIntArray = new SparseIntArray(0);
        synchronized (this) {
            try {
                sparseArray.clear();
                SparseIntArray sparseIntArray2 = poolParams.f18059c;
                if (sparseIntArray2 != null) {
                    for (int i2 = 0; i2 < sparseIntArray2.size(); i2++) {
                        int iKeyAt = sparseIntArray2.keyAt(i2);
                        int iValueAt = sparseIntArray2.valueAt(i2);
                        int i3 = sparseIntArray.get(iKeyAt, 0);
                        SparseArray sparseArray2 = this.f17985d;
                        int iK = k(iKeyAt);
                        this.f17984c.getClass();
                        sparseArray2.put(iKeyAt, new Bucket(iK, iValueAt, i3));
                    }
                    this.f17987f = false;
                } else {
                    this.f17987f = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f17986e = Collections.newSetFromMap(new IdentityHashMap());
        this.f17989h = new Counter();
        this.f17988g = new Counter();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00bb  */
    @Override // com.facebook.common.memory.Pool, com.facebook.common.references.ResourceReleaser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.Object r8) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.memory.BasePool.a(java.lang.Object):void");
    }

    public abstract Object e(int i2);

    public final synchronized boolean f(int i2) {
        PoolParams poolParams = this.f17984c;
        int i3 = poolParams.f18057a;
        int i4 = this.f17988g.f17992b;
        if (i2 > i3 - i4) {
            this.f17990i.getClass();
            return false;
        }
        int i5 = poolParams.f18058b;
        if (i2 > i5 - (i4 + this.f17989h.f17992b)) {
            q(i5 - i2);
        }
        if (i2 <= i3 - (this.f17988g.f17992b + this.f17989h.f17992b)) {
            return true;
        }
        this.f17990i.getClass();
        return false;
    }

    public abstract void g(Object obj);

    @Override // com.facebook.common.memory.Pool
    public final Object get(int i2) throws Throwable {
        Object objE;
        Object objL;
        synchronized (this) {
            try {
                Preconditions.e(!m() || this.f17989h.f17992b == 0);
            } finally {
            }
        }
        int i3 = i(i2);
        synchronized (this) {
            try {
                Bucket bucketH = h(i3);
                if (bucketH != null && (objL = l(bucketH)) != null) {
                    Preconditions.e(this.f17986e.add(objL));
                    int iJ = j(objL);
                    int iK = k(iJ);
                    Counter counter = this.f17988g;
                    counter.f17991a++;
                    counter.f17992b += iK;
                    this.f17989h.a(iK);
                    this.f17990i.getClass();
                    o();
                    if (FLog.f17086a.a(2)) {
                        FLog.j(this.f17982a, "get (reuse) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(objL)), Integer.valueOf(iJ));
                    }
                    return objL;
                }
                int iK2 = k(i3);
                if (!f(iK2)) {
                    throw new PoolSizeViolationException(this.f17984c.f18057a, this.f17988g.f17992b, this.f17989h.f17992b, iK2);
                }
                Counter counter2 = this.f17988g;
                counter2.f17991a++;
                counter2.f17992b += iK2;
                if (bucketH != null) {
                    bucketH.f18005d++;
                }
                try {
                    objE = e(i3);
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f17988g.a(iK2);
                        Bucket bucketH2 = h(i3);
                        if (bucketH2 != null) {
                            Preconditions.e(bucketH2.f18005d > 0);
                            bucketH2.f18005d--;
                        }
                        Throwables.b(th);
                        objE = null;
                    }
                }
                synchronized (this) {
                    try {
                        Preconditions.e(this.f17986e.add(objE));
                        synchronized (this) {
                            if (m()) {
                                q(this.f17984c.f18058b);
                            }
                        }
                        return objE;
                    } finally {
                    }
                }
                this.f17990i.getClass();
                o();
                if (FLog.f17086a.a(2)) {
                    FLog.j(this.f17982a, "get (alloc) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(objE)), Integer.valueOf(i3));
                }
                return objE;
            } finally {
            }
        }
    }

    public final synchronized Bucket h(int i2) {
        try {
            Bucket bucket = (Bucket) this.f17985d.get(i2);
            if (bucket == null && this.f17987f) {
                if (FLog.f17086a.a(2)) {
                    FLog.l(this.f17982a, "creating new bucket %s", Integer.valueOf(i2));
                }
                Bucket bucketP = p(i2);
                this.f17985d.put(i2, bucketP);
                return bucketP;
            }
            return bucket;
        } finally {
        }
    }

    public abstract int i(int i2);

    public abstract int j(Object obj);

    public abstract int k(int i2);

    public synchronized Object l(Bucket bucket) {
        Object objB;
        objB = bucket.b();
        if (objB != null) {
            bucket.f18005d++;
        }
        return objB;
    }

    public final synchronized boolean m() {
        boolean z;
        z = this.f17988g.f17992b + this.f17989h.f17992b > this.f17984c.f18058b;
        if (z) {
            this.f17990i.getClass();
        }
        return z;
    }

    public boolean n(Object obj) {
        obj.getClass();
        return true;
    }

    public final void o() {
        if (FLog.f17086a.a(2)) {
            Counter counter = this.f17988g;
            Integer numValueOf = Integer.valueOf(counter.f17991a);
            Integer numValueOf2 = Integer.valueOf(counter.f17992b);
            Counter counter2 = this.f17989h;
            Integer numValueOf3 = Integer.valueOf(counter2.f17991a);
            Integer numValueOf4 = Integer.valueOf(counter2.f17992b);
            Class cls = this.f17982a;
            if (FLog.f17086a.a(2)) {
                FLogDefaultLoggingDelegate.b(2, cls.getSimpleName(), String.format(null, "Used = (%d, %d); Free = (%d, %d)", numValueOf, numValueOf2, numValueOf3, numValueOf4));
            }
        }
    }

    public Bucket p(int i2) {
        int iK = k(i2);
        this.f17984c.getClass();
        return new Bucket(iK, Api.BaseClientBuilder.API_PRIORITY_OTHER, 0);
    }

    public final synchronized void q(int i2) {
        try {
            int i3 = this.f17988g.f17992b;
            int i4 = this.f17989h.f17992b;
            int iMin = Math.min((i3 + i4) - i2, i4);
            if (iMin <= 0) {
                return;
            }
            if (FLog.f17086a.a(2)) {
                FLog.k(this.f17982a, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i2), Integer.valueOf(this.f17988g.f17992b + this.f17989h.f17992b), Integer.valueOf(iMin));
            }
            o();
            for (int i5 = 0; i5 < this.f17985d.size() && iMin > 0; i5++) {
                Bucket bucket = (Bucket) this.f17985d.valueAt(i5);
                bucket.getClass();
                while (iMin > 0) {
                    Object objB = bucket.b();
                    if (objB == null) {
                        break;
                    }
                    g(objB);
                    int i6 = bucket.f18002a;
                    iMin -= i6;
                    this.f17989h.a(i6);
                }
            }
            o();
            if (FLog.f17086a.a(2)) {
                FLog.j(this.f17982a, "trimToSize: TargetSize = %d; Final Size = %d", Integer.valueOf(i2), Integer.valueOf(this.f17988g.f17992b + this.f17989h.f17992b));
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
