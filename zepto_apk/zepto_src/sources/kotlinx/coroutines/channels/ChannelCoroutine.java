package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.selects.SelectClause1;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class ChannelCoroutine<E> extends AbstractCoroutine<Unit> implements Channel<E> {

    /* renamed from: d, reason: collision with root package name */
    public final BufferedChannel f54251d;

    public ChannelCoroutine(CoroutineContext coroutineContext, BufferedChannel bufferedChannel, boolean z, boolean z2) {
        super(coroutineContext, z, z2);
        this.f54251d = bufferedChannel;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean d(Throwable th) {
        return this.f54251d.s(false, th);
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public final void e(CancellationException cancellationException) {
        if (isCancelled()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(B(), null, this);
        }
        y(cancellationException);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object g(ContinuationImpl continuationImpl) throws Throwable {
        BufferedChannel bufferedChannel = this.f54251d;
        bufferedChannel.getClass();
        Object objL = BufferedChannel.L(bufferedChannel, continuationImpl);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        return objL;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final void h(Function1 function1) {
        this.f54251d.h(function1);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object i(Object obj) {
        return this.f54251d.i(obj);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final ChannelIterator iterator() {
        BufferedChannel bufferedChannel = this.f54251d;
        bufferedChannel.getClass();
        return new BufferedChannel.BufferedChannelIterator();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final SelectClause1 j() {
        return this.f54251d.j();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final SelectClause1 k() {
        return this.f54251d.k();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object m() {
        return this.f54251d.m();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object o(Object obj, Continuation continuation) {
        return this.f54251d.o(obj, continuation);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean p() {
        return this.f54251d.p();
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void y(CancellationException cancellationException) {
        CancellationException cancellationExceptionO0 = JobSupport.o0(this, cancellationException);
        this.f54251d.r(cancellationExceptionO0);
        w(cancellationExceptionO0);
    }

    public final ChannelCoroutine b() {
        return this;
    }
}
