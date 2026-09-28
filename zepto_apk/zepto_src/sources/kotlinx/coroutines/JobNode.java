package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

@Metadata
/* loaded from: classes.dex */
public abstract class JobNode extends LockFreeLinkedListNode implements DisposableHandle, Incomplete {

    /* renamed from: d, reason: collision with root package name */
    public JobSupport f54124d;

    @Override // kotlinx.coroutines.Incomplete
    public final boolean a() {
        return true;
    }

    @Override // kotlinx.coroutines.Incomplete
    public final NodeList c() {
        return null;
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public final void dispose() {
        JobSupport jobSupportK = k();
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = JobSupport.f54125a;
            Object obj = atomicReferenceFieldUpdater.get(jobSupportK);
            if (!(obj instanceof JobNode)) {
                if (!(obj instanceof Incomplete) || ((Incomplete) obj).c() == null) {
                    return;
                }
                j();
                return;
            }
            if (obj != this) {
                return;
            }
            Empty empty = JobSupportKt.f54152g;
            while (!atomicReferenceFieldUpdater.compareAndSet(jobSupportK, obj, empty)) {
                if (atomicReferenceFieldUpdater.get(jobSupportK) != obj) {
                    break;
                }
            }
            return;
        }
    }

    public Job getParent() {
        return k();
    }

    public final JobSupport k() {
        JobSupport jobSupport = this.f54124d;
        if (jobSupport != null) {
            return jobSupport;
        }
        Intrinsics.h("job");
        throw null;
    }

    public abstract boolean l();

    public abstract void m(Throwable th);

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public final String toString() {
        return getClass().getSimpleName() + '@' + DebugStringsKt.a(this) + "[job@" + DebugStringsKt.a(k()) + ']';
    }
}
