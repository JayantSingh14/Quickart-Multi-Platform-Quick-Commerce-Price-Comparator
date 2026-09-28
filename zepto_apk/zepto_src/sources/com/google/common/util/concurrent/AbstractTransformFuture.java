package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.FluentFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes4.dex */
abstract class AbstractTransformFuture<I, O, F, T> extends FluentFuture.TrustedFuture<O> implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f43422j = 0;

    /* renamed from: h, reason: collision with root package name */
    public ListenableFuture f43423h;

    /* renamed from: i, reason: collision with root package name */
    public Function f43424i;

    public static final class AsyncTransformFuture<I, O> extends AbstractTransformFuture<I, O, AsyncFunction<? super I, ? extends O>, ListenableFuture<? extends O>> {
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        public final Object r(Function function, Object obj) {
            AsyncFunction asyncFunction = (AsyncFunction) function;
            ListenableFuture listenableFutureApply = asyncFunction.apply(obj);
            if (listenableFutureApply != null) {
                return listenableFutureApply;
            }
            throw new NullPointerException(Strings.a("AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", asyncFunction));
        }

        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        public final void s(Object obj) {
            p((ListenableFuture) obj);
        }
    }

    public static final class TransformFuture<I, O> extends AbstractTransformFuture<I, O, Function<? super I, ? extends O>, O> {
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        public final Object r(Function function, Object obj) {
            return function.apply(obj);
        }

        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        public final void s(Object obj) {
            n(obj);
        }
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void c() {
        k(this.f43423h);
        this.f43423h = null;
        this.f43424i = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final String l() {
        String str;
        ListenableFuture listenableFuture = this.f43423h;
        Function function = this.f43424i;
        String strL = super.l();
        if (listenableFuture != null) {
            str = "inputFuture=[" + listenableFuture + "], ";
        } else {
            str = "";
        }
        if (function == null) {
            if (strL != null) {
                return android.support.v4.media.b.k(str, strL);
            }
            return null;
        }
        return str + "function=[" + function + "]";
    }

    public abstract Object r(Function function, Object obj);

    @Override // java.lang.Runnable
    public final void run() {
        ListenableFuture listenableFuture = this.f43423h;
        Function function = this.f43424i;
        if (((this.f43392a instanceof AbstractFuture.Cancellation) | (listenableFuture == null)) || (function == null)) {
            return;
        }
        this.f43423h = null;
        if (listenableFuture.isCancelled()) {
            p(listenableFuture);
            return;
        }
        try {
            try {
                Object objR = r(function, Futures.b(listenableFuture));
                this.f43424i = null;
                s(objR);
            } catch (Throwable th) {
                try {
                    Platform.a(th);
                    o(th);
                } finally {
                    this.f43424i = null;
                }
            }
        } catch (Error e2) {
            o(e2);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (ExecutionException e3) {
            o(e3.getCause());
        } catch (Exception e4) {
            o(e4);
        }
    }

    public abstract void s(Object obj);
}
