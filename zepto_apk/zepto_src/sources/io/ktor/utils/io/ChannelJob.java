package io.ktor.utils.io;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupport;

@Metadata
/* loaded from: classes.dex */
final class ChannelJob implements ReaderJob, WriterJob, Job {

    /* renamed from: a, reason: collision with root package name */
    public final Job f51096a;

    /* renamed from: b, reason: collision with root package name */
    public final ByteBufferChannel f51097b;

    public ChannelJob(Job delegate, ByteBufferChannel channel) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.f51096a = delegate;
        this.f51097b = channel;
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle D(boolean z, boolean z2, Function1 handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        return ((JobSupport) this.f51096a).D(z, z2, handler);
    }

    @Override // kotlinx.coroutines.Job
    public final CancellationException O() {
        return this.f51096a.O();
    }

    @Override // kotlinx.coroutines.Job
    public final ChildHandle T(JobSupport child) {
        Intrinsics.checkNotNullParameter(child, "child");
        return ((JobSupport) this.f51096a).T(child);
    }

    @Override // kotlinx.coroutines.Job
    public final Object T0(Continuation continuation) {
        return ((JobSupport) this.f51096a).T0(continuation);
    }

    @Override // kotlinx.coroutines.Job
    public final boolean a() {
        return this.f51096a.a();
    }

    @Override // kotlinx.coroutines.Job
    public final void e(CancellationException cancellationException) {
        ((JobSupport) this.f51096a).e(cancellationException);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final Object fold(Object obj, Function2 operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        JobSupport jobSupport = (JobSupport) this.f51096a;
        Intrinsics.checkNotNullParameter(operation, "operation");
        return operation.invoke(obj, jobSupport);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.f51096a.get(key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key getKey() {
        return Job.Key.f54121a;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCancelled() {
        return this.f51096a.isCancelled();
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle j0(Function1 handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        return ((JobSupport) this.f51096a).j0(handler);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.f51096a.minusKey(key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.f51096a.plus(context);
    }

    @Override // kotlinx.coroutines.Job
    public final boolean start() {
        return this.f51096a.start();
    }

    @Override // io.ktor.utils.io.WriterJob
    public final ByteChannel t0() {
        return this.f51097b;
    }

    public final String toString() {
        return "ChannelJob[" + this.f51096a + ']';
    }
}
