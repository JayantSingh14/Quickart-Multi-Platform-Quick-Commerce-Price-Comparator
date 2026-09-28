package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.InternalCoroutinesApi;

@InternalCoroutinesApi
@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class LockFreeLinkedListNode {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f55087a = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next$volatile");

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f55088b = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev$volatile");

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f55089c = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef$volatile");
    private volatile /* synthetic */ Object _next$volatile = this;
    private volatile /* synthetic */ Object _prev$volatile = this;
    private volatile /* synthetic */ Object _removedRef$volatile;

    public final boolean d(LockFreeLinkedListNode lockFreeLinkedListNode, int i2) {
        while (true) {
            LockFreeLinkedListNode lockFreeLinkedListNodeF = f();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f55088b;
            if (lockFreeLinkedListNodeF == null) {
                Object obj = atomicReferenceFieldUpdater.get(this);
                while (true) {
                    lockFreeLinkedListNodeF = (LockFreeLinkedListNode) obj;
                    if (!lockFreeLinkedListNodeF.i()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(lockFreeLinkedListNodeF);
                }
            }
            if (lockFreeLinkedListNodeF instanceof ListClosed) {
                return (((ListClosed) lockFreeLinkedListNodeF).f55086d & i2) == 0 && lockFreeLinkedListNodeF.d(lockFreeLinkedListNode, i2);
            }
            atomicReferenceFieldUpdater.set(lockFreeLinkedListNode, lockFreeLinkedListNodeF);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f55087a;
            atomicReferenceFieldUpdater2.set(lockFreeLinkedListNode, this);
            while (!atomicReferenceFieldUpdater2.compareAndSet(lockFreeLinkedListNodeF, this, lockFreeLinkedListNode)) {
                if (atomicReferenceFieldUpdater2.get(lockFreeLinkedListNodeF) != this) {
                    break;
                }
            }
            lockFreeLinkedListNode.g(this);
            return true;
        }
    }

    public final void e(int i2) {
        d(new ListClosed(i2), i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:
    
        r6 = ((kotlinx.coroutines.internal.Removed) r6).f55102a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
    
        if (r5.compareAndSet(r4, r3, r6) == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0041, code lost:
    
        if (r5.get(r4) == r3) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlinx.coroutines.internal.LockFreeLinkedListNode f() {
        /*
            r9 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kotlinx.coroutines.internal.LockFreeLinkedListNode.f55088b
            java.lang.Object r1 = r0.get(r9)
            kotlinx.coroutines.internal.LockFreeLinkedListNode r1 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r1
            r2 = 0
            r3 = r1
        La:
            r4 = r2
        Lb:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = kotlinx.coroutines.internal.LockFreeLinkedListNode.f55087a
            java.lang.Object r6 = r5.get(r3)
            if (r6 != r9) goto L24
            if (r1 != r3) goto L16
            return r3
        L16:
            boolean r2 = r0.compareAndSet(r9, r1, r3)
            if (r2 == 0) goto L1d
            return r3
        L1d:
            java.lang.Object r2 = r0.get(r9)
            if (r2 == r1) goto L16
            goto L0
        L24:
            boolean r7 = r9.i()
            if (r7 == 0) goto L2b
            return r2
        L2b:
            boolean r7 = r6 instanceof kotlinx.coroutines.internal.Removed
            if (r7 == 0) goto L4b
            if (r4 == 0) goto L44
            kotlinx.coroutines.internal.Removed r6 = (kotlinx.coroutines.internal.Removed) r6
            kotlinx.coroutines.internal.LockFreeLinkedListNode r6 = r6.f55102a
        L35:
            boolean r7 = r5.compareAndSet(r4, r3, r6)
            if (r7 == 0) goto L3d
            r3 = r4
            goto La
        L3d:
            java.lang.Object r7 = r5.get(r4)
            if (r7 == r3) goto L35
            goto L0
        L44:
            java.lang.Object r3 = r0.get(r3)
            kotlinx.coroutines.internal.LockFreeLinkedListNode r3 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r3
            goto Lb
        L4b:
            java.lang.String r4 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode"
            kotlin.jvm.internal.Intrinsics.d(r6, r4)
            r4 = r6
            kotlinx.coroutines.internal.LockFreeLinkedListNode r4 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r4
            r8 = r4
            r4 = r3
            r3 = r8
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeLinkedListNode.f():kotlinx.coroutines.internal.LockFreeLinkedListNode");
    }

    public final void g(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f55088b;
            LockFreeLinkedListNode lockFreeLinkedListNode2 = (LockFreeLinkedListNode) atomicReferenceFieldUpdater.get(lockFreeLinkedListNode);
            if (f55087a.get(this) != lockFreeLinkedListNode) {
                return;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(lockFreeLinkedListNode, lockFreeLinkedListNode2, this)) {
                if (atomicReferenceFieldUpdater.get(lockFreeLinkedListNode) != lockFreeLinkedListNode2) {
                    break;
                }
            }
            if (i()) {
                lockFreeLinkedListNode.f();
                return;
            }
            return;
        }
    }

    public final LockFreeLinkedListNode h() {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        Object obj = f55087a.get(this);
        Removed removed = obj instanceof Removed ? (Removed) obj : null;
        if (removed != null && (lockFreeLinkedListNode = removed.f55102a) != null) {
            return lockFreeLinkedListNode;
        }
        Intrinsics.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        return (LockFreeLinkedListNode) obj;
    }

    public boolean i() {
        return f55087a.get(this) instanceof Removed;
    }

    public final void j() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f55087a;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof Removed) {
                LockFreeLinkedListNode lockFreeLinkedListNode = ((Removed) obj).f55102a;
                return;
            }
            if (obj == this) {
                return;
            }
            Intrinsics.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
            LockFreeLinkedListNode lockFreeLinkedListNode2 = (LockFreeLinkedListNode) obj;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f55089c;
            Removed removed = (Removed) atomicReferenceFieldUpdater2.get(lockFreeLinkedListNode2);
            if (removed == null) {
                removed = new Removed(lockFreeLinkedListNode2);
                atomicReferenceFieldUpdater2.set(lockFreeLinkedListNode2, removed);
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, removed)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
            lockFreeLinkedListNode2.f();
            return;
        }
    }

    public String toString() {
        return new PropertyReference0Impl(this) { // from class: kotlinx.coroutines.internal.LockFreeLinkedListNode.toString.1
            @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
            public final Object get() {
                return this.receiver.getClass().getSimpleName();
            }
        } + '@' + DebugStringsKt.a(this);
    }
}
