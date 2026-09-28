package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata
/* loaded from: classes.dex */
final class CompletableDeferredImpl<T> extends JobSupport implements CompletableDeferred<T> {
    @Override // kotlinx.coroutines.Deferred
    public final Object V(Continuation continuation) throws Throwable {
        Object objV = v((ContinuationImpl) continuation);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        return objV;
    }

    @Override // kotlinx.coroutines.CompletableDeferred
    public final boolean c(Throwable th) {
        return Y(new CompletedExceptionally(false, th));
    }
}
