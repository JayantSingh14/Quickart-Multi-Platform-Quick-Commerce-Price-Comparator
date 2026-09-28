package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.InternalCoroutinesApi;

@InternalCoroutinesApi
@Metadata
/* loaded from: classes.dex */
public interface SelectInstance<R> {
    void c(Object obj);

    void d(DisposableHandle disposableHandle);

    boolean e(Object obj, Object obj2);

    CoroutineContext getContext();
}
