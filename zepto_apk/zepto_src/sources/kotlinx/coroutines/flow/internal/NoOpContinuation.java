package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

@Metadata
/* loaded from: classes.dex */
final class NoOpContinuation implements Continuation<Object> {

    /* renamed from: a, reason: collision with root package name */
    public static final NoOpContinuation f55039a = new NoOpContinuation();

    /* renamed from: b, reason: collision with root package name */
    public static final EmptyCoroutineContext f55040b = EmptyCoroutineContext.f53685a;

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return f55040b;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
    }
}
