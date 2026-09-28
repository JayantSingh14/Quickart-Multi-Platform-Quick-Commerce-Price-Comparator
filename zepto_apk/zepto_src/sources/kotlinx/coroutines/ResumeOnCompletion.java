package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;

@Metadata
/* loaded from: classes.dex */
final class ResumeOnCompletion extends JobNode {

    /* renamed from: e, reason: collision with root package name */
    public final CancellableContinuationImpl f54157e;

    public ResumeOnCompletion(CancellableContinuationImpl cancellableContinuationImpl) {
        this.f54157e = cancellableContinuationImpl;
    }

    @Override // kotlinx.coroutines.JobNode
    public final boolean l() {
        return false;
    }

    @Override // kotlinx.coroutines.JobNode
    public final void m(Throwable th) {
        Result.Companion companion = Result.f53538b;
        this.f54157e.resumeWith(Unit.f53572a);
    }
}
