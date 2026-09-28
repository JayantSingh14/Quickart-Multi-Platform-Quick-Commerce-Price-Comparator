package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class LockFreeTaskQueueCore<E> {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f55091e = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, Object.class, "_next$volatile");

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f55092f = AtomicLongFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, "_state$volatile");

    /* renamed from: g, reason: collision with root package name */
    public static final Symbol f55093g = new Symbol("REMOVE_FROZEN");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final int f55094a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f55095b;

    /* renamed from: c, reason: collision with root package name */
    public final int f55096c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f55097d;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class Placeholder {

        /* renamed from: a, reason: collision with root package name */
        public final int f55098a;

        public Placeholder(int i2) {
            this.f55098a = i2;
        }
    }

    public LockFreeTaskQueueCore(int i2, boolean z) {
        this.f55094a = i2;
        this.f55095b = z;
        int i3 = i2 - 1;
        this.f55096c = i3;
        this.f55097d = new AtomicReferenceArray(i2);
        if (i3 > 1073741823) {
            throw new IllegalStateException("Check failed.");
        }
        if ((i2 & i3) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final int a(Runnable runnable) {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f55092f;
            long j2 = atomicLongFieldUpdater.get(this);
            if ((3458764513820540928L & j2) != 0) {
                return (2305843009213693952L & j2) != 0 ? 2 : 1;
            }
            int i2 = (int) (1073741823 & j2);
            int i3 = (int) ((1152921503533105152L & j2) >> 30);
            int i4 = this.f55096c;
            if (((i3 + 2) & i4) == (i2 & i4)) {
                return 1;
            }
            AtomicReferenceArray atomicReferenceArray = this.f55097d;
            if (!this.f55095b && atomicReferenceArray.get(i3 & i4) != null) {
                int i5 = this.f55094a;
                if (i5 < 1024 || ((i3 - i2) & 1073741823) > (i5 >> 1)) {
                    return 1;
                }
            } else if (atomicLongFieldUpdater.compareAndSet(this, j2, ((-1152921503533105153L) & j2) | (((i3 + 1) & 1073741823) << 30))) {
                atomicReferenceArray.set(i3 & i4, runnable);
                LockFreeTaskQueueCore<E> lockFreeTaskQueueCoreC = this;
                while ((atomicLongFieldUpdater.get(lockFreeTaskQueueCoreC) & 1152921504606846976L) != 0) {
                    lockFreeTaskQueueCoreC = lockFreeTaskQueueCoreC.c();
                    AtomicReferenceArray atomicReferenceArray2 = lockFreeTaskQueueCoreC.f55097d;
                    int i6 = lockFreeTaskQueueCoreC.f55096c & i3;
                    Object obj = atomicReferenceArray2.get(i6);
                    if ((obj instanceof Placeholder) && ((Placeholder) obj).f55098a == i3) {
                        atomicReferenceArray2.set(i6, runnable);
                    } else {
                        lockFreeTaskQueueCoreC = null;
                    }
                    if (lockFreeTaskQueueCoreC == null) {
                        return 0;
                    }
                }
                return 0;
            }
        }
    }

    public final boolean b() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j2;
        do {
            atomicLongFieldUpdater = f55092f;
            j2 = atomicLongFieldUpdater.get(this);
            if ((j2 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j2) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j2, 2305843009213693952L | j2));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final LockFreeTaskQueueCore c() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j2;
        LockFreeTaskQueueCore<E> lockFreeTaskQueueCore;
        while (true) {
            atomicLongFieldUpdater = f55092f;
            j2 = atomicLongFieldUpdater.get(this);
            if ((j2 & 1152921504606846976L) != 0) {
                lockFreeTaskQueueCore = this;
                break;
            }
            long j3 = 1152921504606846976L | j2;
            lockFreeTaskQueueCore = this;
            if (atomicLongFieldUpdater.compareAndSet(lockFreeTaskQueueCore, j2, j3)) {
                j2 = j3;
                break;
            }
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f55091e;
            LockFreeTaskQueueCore lockFreeTaskQueueCore2 = (LockFreeTaskQueueCore) atomicReferenceFieldUpdater.get(this);
            if (lockFreeTaskQueueCore2 != null) {
                return lockFreeTaskQueueCore2;
            }
            LockFreeTaskQueueCore lockFreeTaskQueueCore3 = new LockFreeTaskQueueCore(lockFreeTaskQueueCore.f55094a * 2, lockFreeTaskQueueCore.f55095b);
            int i2 = (int) (1073741823 & j2);
            int i3 = (int) ((1152921503533105152L & j2) >> 30);
            while (true) {
                int i4 = lockFreeTaskQueueCore.f55096c;
                int i5 = i2 & i4;
                if (i5 == (i4 & i3)) {
                    break;
                }
                Object placeholder = lockFreeTaskQueueCore.f55097d.get(i5);
                if (placeholder == null) {
                    placeholder = new Placeholder(i2);
                }
                lockFreeTaskQueueCore3.f55097d.set(lockFreeTaskQueueCore3.f55096c & i2, placeholder);
                i2++;
            }
            atomicLongFieldUpdater.set(lockFreeTaskQueueCore3, (-1152921504606846977L) & j2);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, lockFreeTaskQueueCore3) && atomicReferenceFieldUpdater.get(this) == null) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0040, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d() {
        /*
            r30 = this;
            r1 = r30
        L2:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.f55092f
            long r2 = r0.get(r1)
            r6 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r4 = r2 & r6
            r8 = 0
            int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r4 == 0) goto L15
            kotlinx.coroutines.internal.Symbol r0 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.f55093g
            return r0
        L15:
            r10 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r4 = r2 & r10
            int r4 = (int) r4
            r12 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r12 = r12 & r2
            r5 = 30
            long r12 = r12 >> r5
            int r5 = (int) r12
            int r12 = r1.f55096c
            r5 = r5 & r12
            r12 = r12 & r4
            r13 = 0
            if (r5 != r12) goto L2d
            goto L40
        L2d:
            java.util.concurrent.atomic.AtomicReferenceArray r14 = r1.f55097d
            java.lang.Object r15 = r14.get(r12)
            boolean r5 = r1.f55095b
            if (r15 != 0) goto L3a
            if (r5 == 0) goto L2
            goto L40
        L3a:
            r16 = r6
            boolean r6 = r15 instanceof kotlinx.coroutines.internal.LockFreeTaskQueueCore.Placeholder
            if (r6 == 0) goto L41
        L40:
            return r13
        L41:
            int r4 = r4 + 1
            r6 = 1073741823(0x3fffffff, float:1.9999999)
            r4 = r4 & r6
            r6 = -1073741824(0xffffffffc0000000, double:NaN)
            long r18 = r2 & r6
            r20 = r6
            long r6 = (long) r4
            long r18 = r18 | r6
            r28 = r18
            r18 = r5
            r4 = r28
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L61
            r14.set(r12, r13)
            return r15
        L61:
            r1 = r30
            if (r18 == 0) goto L2
        L65:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = kotlinx.coroutines.internal.LockFreeTaskQueueCore.f55092f
            long r24 = r0.get(r1)
            long r2 = r24 & r10
            int r2 = (int) r2
            long r3 = r24 & r16
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 == 0) goto L7a
            kotlinx.coroutines.internal.LockFreeTaskQueueCore r0 = r1.c()
            r1 = r0
            goto L93
        L7a:
            long r3 = r24 & r20
            long r26 = r3 | r6
            r22 = r0
            r23 = r1
            boolean r0 = r22.compareAndSet(r23, r24, r26)
            r1 = r23
            if (r0 == 0) goto L65
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r1.f55097d
            int r1 = r1.f55096c
            r1 = r1 & r2
            r0.set(r1, r13)
            r1 = r13
        L93:
            if (r1 != 0) goto L65
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeTaskQueueCore.d():java.lang.Object");
    }
}
