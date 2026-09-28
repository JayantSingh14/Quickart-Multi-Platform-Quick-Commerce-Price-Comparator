package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata
/* loaded from: classes.dex */
class DeferredCoroutine<T> extends AbstractCoroutine<T> implements Deferred<T> {
    @Override // kotlinx.coroutines.Deferred
    public final Object V(Continuation continuation) throws Throwable {
        Object objV = v((ContinuationImpl) continuation);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        return objV;
    }
}
