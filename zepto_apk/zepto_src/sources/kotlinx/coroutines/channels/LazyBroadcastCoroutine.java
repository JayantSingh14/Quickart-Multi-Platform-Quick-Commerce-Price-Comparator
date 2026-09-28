package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.intrinsics.CancellableKt;

@Metadata
/* loaded from: classes3.dex */
final class LazyBroadcastCoroutine<E> extends BroadcastCoroutine<E> {
    @Override // kotlinx.coroutines.JobSupport
    public final void g0() {
        CancellableKt.a(null, this);
    }
}
