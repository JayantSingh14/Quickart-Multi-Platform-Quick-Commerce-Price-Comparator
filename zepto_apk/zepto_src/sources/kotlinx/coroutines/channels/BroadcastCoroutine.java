package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
class BroadcastCoroutine<E> extends AbstractCoroutine<Unit> implements ProducerScope<E>, BroadcastChannel<E> {
    @Override // kotlinx.coroutines.channels.ProducerScope
    public final SendChannel b() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean d(Throwable th) {
        throw null;
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public final void e(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(B(), null, this);
        }
        JobSupport.o0(this, cancellationException);
        throw null;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final void h(Function1 function1) {
        throw null;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final Object i(Object obj) {
        throw null;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final Object o(Object obj, Continuation continuation) {
        throw null;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean p() {
        throw null;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public final void w0(boolean z, Throwable th) {
        throw null;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    public final void x0(Object obj) {
        throw null;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void y(CancellationException cancellationException) {
        JobSupport.o0(this, cancellationException);
        throw null;
    }
}
