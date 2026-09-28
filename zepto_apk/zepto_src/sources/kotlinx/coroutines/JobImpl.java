package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;

@Metadata
@PublishedApi
/* loaded from: classes.dex */
public class JobImpl extends JobSupport implements CompletableJob {

    /* renamed from: c, reason: collision with root package name */
    public final boolean f54123c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JobImpl(Job job) {
        super(true);
        boolean z = true;
        S(job);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = JobSupport.f54126b;
        ChildHandle childHandle = (ChildHandle) atomicReferenceFieldUpdater.get(this);
        ChildHandleNode childHandleNode = childHandle instanceof ChildHandleNode ? (ChildHandleNode) childHandle : null;
        if (childHandleNode == null) {
            z = false;
            break;
        }
        JobSupport jobSupportK = childHandleNode.k();
        while (!jobSupportK.K()) {
            ChildHandle childHandle2 = (ChildHandle) atomicReferenceFieldUpdater.get(jobSupportK);
            ChildHandleNode childHandleNode2 = childHandle2 instanceof ChildHandleNode ? (ChildHandleNode) childHandle2 : null;
            if (childHandleNode2 == null) {
                z = false;
                break;
            }
            jobSupportK = childHandleNode2.k();
        }
        this.f54123c = z;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final boolean K() {
        return this.f54123c;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final boolean L() {
        return true;
    }

    @Override // kotlinx.coroutines.CompletableJob
    public final boolean c(Throwable th) {
        return Y(new CompletedExceptionally(false, th));
    }

    @Override // kotlinx.coroutines.CompletableJob
    public final boolean complete() {
        return Y(Unit.f53572a);
    }
}
