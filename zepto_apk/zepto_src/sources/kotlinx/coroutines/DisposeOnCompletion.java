package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
final class DisposeOnCompletion extends JobNode {

    /* renamed from: e, reason: collision with root package name */
    public final DisposableHandle f54095e;

    public DisposeOnCompletion(DisposableHandle disposableHandle) {
        this.f54095e = disposableHandle;
    }

    @Override // kotlinx.coroutines.JobNode
    public final boolean l() {
        return false;
    }

    @Override // kotlinx.coroutines.JobNode
    public final void m(Throwable th) {
        this.f54095e.dispose();
    }
}
