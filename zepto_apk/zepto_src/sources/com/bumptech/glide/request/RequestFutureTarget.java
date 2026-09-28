package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.transition.Transition;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes3.dex */
public class RequestFutureTarget<R> implements FutureTarget<R>, RequestListener<R> {

    /* renamed from: a, reason: collision with root package name */
    public Object f16455a;

    /* renamed from: b, reason: collision with root package name */
    public SingleRequest f16456b;

    @VisibleForTesting
    public static class Waiter {
    }

    @Override // com.bumptech.glide.request.RequestListener
    public final synchronized boolean b(Object obj) {
        this.f16455a = obj;
        throw null;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void c(SingleRequest singleRequest) throws Throwable {
        singleRequest.a(0, 0);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        synchronized (this) {
            synchronized (this) {
            }
            return false;
        }
        return false;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final synchronized void d() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public final void e() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void f(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public final synchronized void g(Object obj, Transition transition) {
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        try {
            l(null);
            throw null;
        } catch (TimeoutException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public final synchronized Request getRequest() {
        return this.f16456b;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public final synchronized boolean h(GlideException glideException) {
        throw null;
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public final void i() {
    }

    @Override // java.util.concurrent.Future
    public final synchronized boolean isCancelled() {
        return true;
    }

    @Override // java.util.concurrent.Future
    public final synchronized boolean isDone() {
        return true;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final synchronized void j(SingleRequest singleRequest) {
        this.f16456b = singleRequest;
    }

    public final synchronized Object l(Long l2) {
        throw new CancellationException();
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public final void onDestroy() {
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j2, TimeUnit timeUnit) {
        l(Long.valueOf(timeUnit.toMillis(j2)));
        throw null;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void k() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void a(SingleRequest singleRequest) {
    }
}
