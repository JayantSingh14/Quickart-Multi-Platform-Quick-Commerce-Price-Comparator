package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
final class ResumeAwaitOnCompletion<T> extends JobNode {

    /* renamed from: e, reason: collision with root package name */
    public final CancellableContinuationImpl f54156e;

    public ResumeAwaitOnCompletion(CancellableContinuationImpl cancellableContinuationImpl) {
        this.f54156e = cancellableContinuationImpl;
    }

    @Override // kotlinx.coroutines.JobNode
    public final boolean l() {
        return false;
    }

    @Override // kotlinx.coroutines.JobNode
    public final void m(Throwable th) {
        Object obj = JobSupport.f54125a.get(k());
        boolean z = obj instanceof CompletedExceptionally;
        CancellableContinuationImpl cancellableContinuationImpl = this.f54156e;
        if (z) {
            Result.Companion companion = Result.f53538b;
            cancellableContinuationImpl.resumeWith(ResultKt.a(((CompletedExceptionally) obj).f54073a));
        } else {
            Result.Companion companion2 = Result.f53538b;
            cancellableContinuationImpl.resumeWith(JobSupportKt.a(obj));
        }
    }
}
