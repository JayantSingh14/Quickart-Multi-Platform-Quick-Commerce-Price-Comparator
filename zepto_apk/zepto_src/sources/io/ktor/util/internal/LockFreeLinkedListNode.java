package io.ktor.util.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public class LockFreeLinkedListNode {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f50564a = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next");

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f50565b = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev");

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f50566c = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef");

    @NotNull
    volatile /* synthetic */ Object _next = this;

    @NotNull
    volatile /* synthetic */ Object _prev = this;

    @NotNull
    private volatile /* synthetic */ Object _removedRef = null;

    @Metadata
    @SourceDebugExtension
    public static abstract class AbstractAtomicDesc extends AtomicDesc {

        @Metadata
        public static final class PrepareOp extends OpDescriptor {
            @Override // io.ktor.util.internal.OpDescriptor
            public final Object a(LockFreeLinkedListNode lockFreeLinkedListNode) {
                throw null;
            }
        }
    }

    @Metadata
    public static class AddLastDesc<T extends LockFreeLinkedListNode> extends AbstractAtomicDesc {

        @NotNull
        private volatile /* synthetic */ Object _affectedNode;

        static {
            AtomicReferenceFieldUpdater.newUpdater(AddLastDesc.class, Object.class, "_affectedNode");
        }
    }

    @Metadata
    @PublishedApi
    public static abstract class CondAddOp extends AtomicOp<LockFreeLinkedListNode> {
        @Override // io.ktor.util.internal.AtomicOp
        public final void b(LockFreeLinkedListNode affected) {
            Intrinsics.checkNotNullParameter(affected, "affected");
        }
    }

    @Metadata
    public static class RemoveFirstDesc<T> extends AbstractAtomicDesc {

        @NotNull
        private volatile /* synthetic */ Object _affectedNode;

        @NotNull
        private volatile /* synthetic */ Object _originalNext;

        static {
            AtomicReferenceFieldUpdater.newUpdater(RemoveFirstDesc.class, Object.class, "_affectedNode");
            AtomicReferenceFieldUpdater.newUpdater(RemoveFirstDesc.class, Object.class, "_originalNext");
        }
    }

    public final Object a() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).a(this);
        }
    }

    public final LockFreeLinkedListNode c() {
        return LockFreeLinkedListKt.a(a());
    }

    public final LockFreeLinkedListNode d() {
        LockFreeLinkedListNode lockFreeLinkedListNodeC;
        while (true) {
            Object obj = this._prev;
            if (obj instanceof Removed) {
                return ((Removed) obj).f50567a;
            }
            if (obj == this) {
                lockFreeLinkedListNodeC = this;
                while (!(lockFreeLinkedListNodeC instanceof LockFreeLinkedListHead)) {
                    lockFreeLinkedListNodeC = lockFreeLinkedListNodeC.c();
                    if (lockFreeLinkedListNodeC == this) {
                        throw new IllegalStateException("Cannot loop to this while looking for list head");
                    }
                }
            } else {
                Intrinsics.d(obj, "null cannot be cast to non-null type io.ktor.util.internal.LockFreeLinkedListNode{ io.ktor.util.internal.LockFreeLinkedListKt.Node }");
                lockFreeLinkedListNodeC = (LockFreeLinkedListNode) obj;
            }
            Removed removed = (Removed) lockFreeLinkedListNodeC._removedRef;
            if (removed == null) {
                removed = new Removed(lockFreeLinkedListNodeC);
                f50566c.lazySet(lockFreeLinkedListNodeC, removed);
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f50565b;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, removed)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
            return (LockFreeLinkedListNode) obj;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005b, code lost:
    
        r6.d();
        r3 = io.ktor.util.internal.LockFreeLinkedListNode.f50564a;
        r0 = ((io.ktor.util.internal.Removed) r0).f50567a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0068, code lost:
    
        if (r3.compareAndSet(r8, r6, r0) == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006f, code lost:
    
        if (r3.get(r8) == r6) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00af, code lost:
    
        r0.d();
        r5 = io.ktor.util.internal.LockFreeLinkedListNode.f50564a;
        r1 = ((io.ktor.util.internal.Removed) r1).f50567a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00bc, code lost:
    
        if (r5.compareAndSet(r4, r0, r1) == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00c3, code lost:
    
        if (r5.get(r4) == r0) goto L120;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void dispose() {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.internal.LockFreeLinkedListNode.dispose():void");
    }

    public final String toString() {
        return Reflection.a(getClass()).i() + '@' + hashCode();
    }
}
