package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.AbstractTransformFuture;
import com.google.common.util.concurrent.ImmediateFuture;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes4.dex */
public final class Futures extends GwtFuturesCatchingSpecialization {

    /* renamed from: com.google.common.util.concurrent.Futures$1, reason: invalid class name */
    class AnonymousClass1 implements Future<Object> {
        @Override // java.util.concurrent.Future
        public final boolean cancel(boolean z) {
            throw null;
        }

        @Override // java.util.concurrent.Future
        public final Object get() {
            throw null;
        }

        @Override // java.util.concurrent.Future
        public final boolean isCancelled() {
            throw null;
        }

        @Override // java.util.concurrent.Future
        public final boolean isDone() {
            throw null;
        }

        @Override // java.util.concurrent.Future
        public final Object get(long j2, TimeUnit timeUnit) {
            throw null;
        }
    }

    public static final class CallbackListener<V> implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final ListenableFuture f43449a;

        /* renamed from: b, reason: collision with root package name */
        public final FutureCallback f43450b;

        public CallbackListener(ListenableFuture listenableFuture, FutureCallback futureCallback) {
            this.f43449a = listenableFuture;
            this.f43450b = futureCallback;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            Throwable thA;
            ListenableFuture listenableFuture = this.f43449a;
            boolean z = listenableFuture instanceof InternalFutureFailureAccess;
            FutureCallback futureCallback = this.f43450b;
            if (z && (thA = ((InternalFutureFailureAccess) listenableFuture).a()) != null) {
                futureCallback.onFailure(thA);
                return;
            }
            try {
                futureCallback.onSuccess(Futures.b(listenableFuture));
            } catch (ExecutionException e2) {
                futureCallback.onFailure(e2.getCause());
            } catch (Throwable th) {
                futureCallback.onFailure(th);
            }
        }

        public final String toString() {
            MoreObjects.ToStringHelper toStringHelperB = MoreObjects.b(this);
            toStringHelperB.c(this.f43450b);
            return toStringHelperB.toString();
        }
    }

    @GwtCompatible
    public static final class FutureCombiner<V> {

        /* renamed from: com.google.common.util.concurrent.Futures$FutureCombiner$1, reason: invalid class name */
        class AnonymousClass1 implements Callable<Void> {
            @Override // java.util.concurrent.Callable
            public final Void call() {
                throw null;
            }
        }
    }

    public static final class InCompletionOrderFuture<T> extends AbstractFuture<T> {
        @Override // com.google.common.util.concurrent.AbstractFuture
        public final void c() {
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean cancel(boolean z) {
            if (super.cancel(z)) {
                throw null;
            }
            return false;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public final String l() {
            return null;
        }
    }

    public static final class InCompletionOrderState<T> {
    }

    public static final class NonCancellationPropagatingFuture<V> extends AbstractFuture.TrustedFuture<V> implements Runnable {
        @Override // com.google.common.util.concurrent.AbstractFuture
        public final void c() {
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public final String l() {
            return null;
        }

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    public static void a(ListenableFuture listenableFuture, FutureCallback futureCallback, Executor executor) {
        listenableFuture.q(new CallbackListener(listenableFuture, futureCallback), executor);
    }

    public static Object b(Future future) {
        Preconditions.o(future.isDone(), "Future was expected to be done: %s", future);
        return Uninterruptibles.a(future);
    }

    public static ListenableFuture c(Throwable th) {
        ImmediateFuture.ImmediateFailedFuture immediateFailedFuture = new ImmediateFuture.ImmediateFailedFuture();
        immediateFailedFuture.o(th);
        return immediateFailedFuture;
    }

    public static ListenableFuture d(Object obj) {
        return obj == null ? ImmediateFuture.f43453b : new ImmediateFuture(obj);
    }

    public static ListenableFuture e() {
        return ImmediateFuture.f43453b;
    }

    public static ListenableFuture f(ListenableFuture listenableFuture, com.google.common.cache.a aVar) {
        Executor executor = DirectExecutor.f43436a;
        int i2 = AbstractTransformFuture.f43422j;
        AbstractTransformFuture.TransformFuture transformFuture = new AbstractTransformFuture.TransformFuture();
        transformFuture.f43423h = listenableFuture;
        transformFuture.f43424i = aVar;
        listenableFuture.q(transformFuture, executor);
        return transformFuture;
    }
}
