package kotlinx.coroutines.future;

import kotlin.Metadata;
import kotlinx.coroutines.JobNode;

@Metadata
/* loaded from: classes3.dex */
final class CancelFutureOnCompletion extends JobNode {
    @Override // kotlinx.coroutines.JobNode
    public final boolean l() {
        return false;
    }

    @Override // kotlinx.coroutines.JobNode
    public final void m(Throwable th) {
        if (th != null) {
            throw null;
        }
    }
}
