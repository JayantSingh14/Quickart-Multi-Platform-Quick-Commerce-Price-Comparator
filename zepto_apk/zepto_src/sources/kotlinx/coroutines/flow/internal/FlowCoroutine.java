package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlinx.coroutines.internal.ScopeCoroutine;

@Metadata
/* loaded from: classes.dex */
final class FlowCoroutine<T> extends ScopeCoroutine<T> {
    @Override // kotlinx.coroutines.JobSupport
    public final boolean C(Throwable th) {
        if (th instanceof ChildCancelledException) {
            return true;
        }
        return w(th);
    }
}
