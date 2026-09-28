package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;

@Metadata
/* loaded from: classes3.dex */
public final class TestCoroutineScopeKt$createTestCoroutineScope$ownExceptionHandler$1 extends AbstractCoroutineContextElement implements TestCoroutineScopeExceptionHandler {
    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(CoroutineContext coroutineContext, Throwable th) {
        throw null;
    }
}
