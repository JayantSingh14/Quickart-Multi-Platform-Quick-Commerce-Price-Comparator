package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;

@Metadata
/* loaded from: classes3.dex */
public final class NonCancellable extends AbstractCoroutineContextElement implements Job {

    /* renamed from: a, reason: collision with root package name */
    public static final NonCancellable f54154a = new NonCancellable(Job.Key.f54121a);

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle D(boolean z, boolean z2, Function1 function1) {
        return NonDisposableHandle.f54155a;
    }

    @Override // kotlinx.coroutines.Job
    public final CancellationException O() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // kotlinx.coroutines.Job
    public final ChildHandle T(JobSupport jobSupport) {
        return NonDisposableHandle.f54155a;
    }

    @Override // kotlinx.coroutines.Job
    public final Object T0(Continuation continuation) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // kotlinx.coroutines.Job
    public final boolean a() {
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public final void e(CancellationException cancellationException) {
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCancelled() {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle j0(Function1 function1) {
        return NonDisposableHandle.f54155a;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean start() {
        return false;
    }

    public final String toString() {
        return "NonCancellable";
    }
}
