package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CompletionStateKt;

@Metadata
/* loaded from: classes.dex */
public class ScopeCoroutine<T> extends AbstractCoroutine<T> implements CoroutineStackFrame {

    /* renamed from: d, reason: collision with root package name */
    public final Continuation f55103d;

    public ScopeCoroutine(Continuation continuation, CoroutineContext coroutineContext) {
        super(coroutineContext, true, true);
        this.f55103d = continuation;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final boolean X() {
        return true;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation continuation = this.f55103d;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlinx.coroutines.JobSupport
    public void t(Object obj) {
        DispatchedContinuationKt.a(CompletionStateKt.a(obj), IntrinsicsKt.b(this.f55103d));
    }

    @Override // kotlinx.coroutines.JobSupport
    public void u(Object obj) {
        this.f55103d.resumeWith(CompletionStateKt.a(obj));
    }
}
