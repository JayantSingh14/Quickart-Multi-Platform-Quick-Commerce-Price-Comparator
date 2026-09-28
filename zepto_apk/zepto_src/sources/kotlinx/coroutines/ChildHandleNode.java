package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
final class ChildHandleNode extends JobNode implements ChildHandle {

    /* renamed from: e, reason: collision with root package name */
    public final JobSupport f54066e;

    public ChildHandleNode(JobSupport jobSupport) {
        this.f54066e = jobSupport;
    }

    @Override // kotlinx.coroutines.ChildHandle
    public final boolean b(Throwable th) {
        return k().C(th);
    }

    @Override // kotlinx.coroutines.JobNode
    public final boolean l() {
        return true;
    }

    @Override // kotlinx.coroutines.JobNode
    public final void m(Throwable th) {
        this.f54066e.w(k());
    }
}
