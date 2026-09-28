package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata
/* loaded from: classes.dex */
final class InvokeOnCancelling extends JobNode {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f54118f = AtomicIntegerFieldUpdater.newUpdater(InvokeOnCancelling.class, "_invoked$volatile");
    private volatile /* synthetic */ int _invoked$volatile = 0;

    /* renamed from: e, reason: collision with root package name */
    public final Function1 f54119e;

    public InvokeOnCancelling(Function1 function1) {
        this.f54119e = function1;
    }

    @Override // kotlinx.coroutines.JobNode
    public final boolean l() {
        return true;
    }

    @Override // kotlinx.coroutines.JobNode
    public final void m(Throwable th) {
        if (f54118f.compareAndSet(this, 0, 1)) {
            this.f54119e.invoke(th);
        }
    }
}
