package kotlinx.coroutines.android;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;

@Metadata
/* loaded from: classes.dex */
public abstract class HandlerDispatcher extends MainCoroutineDispatcher implements Delay {
    public DisposableHandle b(long j2, Runnable runnable, CoroutineContext coroutineContext) {
        return Delay.DefaultImpls.a(j2, runnable, coroutineContext);
    }
}
