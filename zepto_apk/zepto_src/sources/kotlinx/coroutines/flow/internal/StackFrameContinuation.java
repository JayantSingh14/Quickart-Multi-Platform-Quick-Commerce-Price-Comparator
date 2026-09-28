package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

@Metadata
/* loaded from: classes3.dex */
final class StackFrameContinuation<T> implements Continuation<T>, CoroutineStackFrame {

    /* renamed from: a, reason: collision with root package name */
    public final Continuation f55053a;

    /* renamed from: b, reason: collision with root package name */
    public final CoroutineContext f55054b;

    public StackFrameContinuation(Continuation continuation, CoroutineContext coroutineContext) {
        this.f55053a = continuation;
        this.f55054b = coroutineContext;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation continuation = this.f55053a;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.f55054b;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        this.f55053a.resumeWith(obj);
    }
}
