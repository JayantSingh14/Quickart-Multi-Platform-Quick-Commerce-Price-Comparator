package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class ConcurrentLinkedListNode<N extends ConcurrentLinkedListNode<N>> {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f55063a = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, "_next$volatile");

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f55064b = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, "_prev$volatile");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;

    public ConcurrentLinkedListNode(Segment segment) {
        this._prev$volatile = segment;
    }

    public final void a() {
        f55064b.set(this, null);
    }

    public final ConcurrentLinkedListNode c() {
        Object obj = f55063a.get(this);
        if (obj == ConcurrentLinkedListKt.f55062a) {
            return null;
        }
        return (ConcurrentLinkedListNode) obj;
    }

    public abstract boolean d();

    public final void e() {
        Object obj;
        ConcurrentLinkedListNode concurrentLinkedListNodeC;
        if (c() == null) {
            return;
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f55064b;
            ConcurrentLinkedListNode concurrentLinkedListNode = (ConcurrentLinkedListNode) atomicReferenceFieldUpdater.get(this);
            while (concurrentLinkedListNode != null && concurrentLinkedListNode.d()) {
                concurrentLinkedListNode = (ConcurrentLinkedListNode) atomicReferenceFieldUpdater.get(concurrentLinkedListNode);
            }
            ConcurrentLinkedListNode concurrentLinkedListNodeC2 = c();
            Intrinsics.c(concurrentLinkedListNodeC2);
            while (concurrentLinkedListNodeC2.d() && (concurrentLinkedListNodeC = concurrentLinkedListNodeC2.c()) != null) {
                concurrentLinkedListNodeC2 = concurrentLinkedListNodeC;
            }
            do {
                obj = atomicReferenceFieldUpdater.get(concurrentLinkedListNodeC2);
            } while (!com.google.android.gms.internal.pal.a.u(atomicReferenceFieldUpdater, concurrentLinkedListNodeC2, obj, ((ConcurrentLinkedListNode) obj) == null ? null : concurrentLinkedListNode));
            if (concurrentLinkedListNode != null) {
                f55063a.set(concurrentLinkedListNode, concurrentLinkedListNodeC2);
            }
            if (!concurrentLinkedListNodeC2.d() || concurrentLinkedListNodeC2.c() == null) {
                if (concurrentLinkedListNode == null || !concurrentLinkedListNode.d()) {
                    return;
                }
            }
        }
    }
}
