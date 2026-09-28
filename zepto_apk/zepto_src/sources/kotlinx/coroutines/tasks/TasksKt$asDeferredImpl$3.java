package kotlinx.coroutines.tasks;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.JobSupport;

@Metadata
/* loaded from: classes3.dex */
public final class TasksKt$asDeferredImpl$3 implements Deferred<Object> {
    @Override // kotlinx.coroutines.Job
    public final DisposableHandle D(boolean z, boolean z2, Function1 function1) {
        throw null;
    }

    @Override // kotlinx.coroutines.Job
    public final CancellationException O() {
        throw null;
    }

    @Override // kotlinx.coroutines.Job
    public final ChildHandle T(JobSupport jobSupport) {
        throw null;
    }

    @Override // kotlinx.coroutines.Job
    public final Object T0(Continuation continuation) {
        throw null;
    }

    @Override // kotlinx.coroutines.Deferred
    public final Object V(Continuation continuation) {
        throw null;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean a() {
        throw null;
    }

    @Override // kotlinx.coroutines.Job
    public final void e(CancellationException cancellationException) {
        throw null;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final Object fold(Object obj, Function2 function2) {
        throw null;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        throw null;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key getKey() {
        throw null;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCancelled() {
        throw null;
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle j0(Function1 function1) {
        throw null;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        throw null;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext coroutineContext) {
        throw null;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean start() {
        throw null;
    }

    @Override // kotlinx.coroutines.Deferred
    public final Object x() {
        throw null;
    }
}
