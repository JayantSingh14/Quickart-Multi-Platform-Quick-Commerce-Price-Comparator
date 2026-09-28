package com.google.firebase.concurrent;

import android.annotation.SuppressLint;
import androidx.concurrent.futures.AbstractResolvableFuture;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes4.dex */
class DelegatingScheduledFuture<V> extends AbstractResolvableFuture<V> implements ScheduledFuture<V> {

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f43631i = 0;

    /* renamed from: h, reason: collision with root package name */
    public final ScheduledFuture f43632h;

    /* renamed from: com.google.firebase.concurrent.DelegatingScheduledFuture$1, reason: invalid class name */
    class AnonymousClass1 implements Completer<Object> {
        public AnonymousClass1() {
        }

        public final void a(Object obj) {
            int i2 = DelegatingScheduledFuture.f43631i;
            DelegatingScheduledFuture.this.l(obj);
        }

        public final void b(Exception exc) {
            int i2 = DelegatingScheduledFuture.f43631i;
            DelegatingScheduledFuture.this.n(exc);
        }
    }

    public interface Completer<T> {
    }

    public interface Resolver<T> {
        ScheduledFuture a(AnonymousClass1 anonymousClass1);
    }

    public DelegatingScheduledFuture(Resolver resolver) {
        this.f43632h = resolver.a(new AnonymousClass1());
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public final void b() {
        this.f43632h.cancel(p());
    }

    @Override // java.lang.Comparable
    public final int compareTo(Delayed delayed) {
        return this.f43632h.compareTo(delayed);
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return this.f43632h.getDelay(timeUnit);
    }
}
