package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.intrinsics.CancellableKt;

@Metadata
/* loaded from: classes3.dex */
final class LazyDeferredCoroutine<T> extends DeferredCoroutine<T> {
    @Override // kotlinx.coroutines.JobSupport
    public final void g0() {
        CancellableKt.a(null, this);
    }
}
