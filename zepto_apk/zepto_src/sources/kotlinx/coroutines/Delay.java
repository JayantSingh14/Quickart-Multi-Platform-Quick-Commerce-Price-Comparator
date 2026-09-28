package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;

@InternalCoroutinesApi
@Metadata
/* loaded from: classes.dex */
public interface Delay {

    @Metadata
    @SourceDebugExtension
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static DisposableHandle a(long j2, Runnable runnable, CoroutineContext coroutineContext) {
            return DefaultExecutorKt.f54086a.b(j2, runnable, coroutineContext);
        }
    }

    void A(long j2, CancellableContinuationImpl cancellableContinuationImpl);

    DisposableHandle b(long j2, Runnable runnable, CoroutineContext coroutineContext);
}
