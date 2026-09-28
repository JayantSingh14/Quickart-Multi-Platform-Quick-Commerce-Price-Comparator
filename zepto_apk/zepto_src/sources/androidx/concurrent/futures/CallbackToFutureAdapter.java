package androidx.concurrent.futures;

import android.support.v4.media.b;
import androidx.concurrent.futures.AbstractResolvableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class CallbackToFutureAdapter {

    public static final class Completer<T> {

        /* renamed from: a, reason: collision with root package name */
        public Object f1638a;

        /* renamed from: b, reason: collision with root package name */
        public SafeFuture f1639b;

        /* renamed from: c, reason: collision with root package name */
        public ResolvableFuture f1640c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f1641d;

        public final void a(Object obj) {
            this.f1641d = true;
            SafeFuture safeFuture = this.f1639b;
            if (safeFuture == null || !safeFuture.f1643b.l(obj)) {
                return;
            }
            this.f1638a = null;
            this.f1639b = null;
            this.f1640c = null;
        }

        public final void b() {
            this.f1641d = true;
            SafeFuture safeFuture = this.f1639b;
            if (safeFuture == null || !safeFuture.f1643b.cancel(true)) {
                return;
            }
            this.f1638a = null;
            this.f1639b = null;
            this.f1640c = null;
        }

        public final void c(Throwable th) {
            this.f1641d = true;
            SafeFuture safeFuture = this.f1639b;
            if (safeFuture == null || !safeFuture.f1643b.n(th)) {
                return;
            }
            this.f1638a = null;
            this.f1639b = null;
            this.f1640c = null;
        }

        public final void finalize() {
            ResolvableFuture resolvableFuture;
            SafeFuture safeFuture = this.f1639b;
            if (safeFuture != null) {
                AbstractResolvableFuture abstractResolvableFuture = safeFuture.f1643b;
                if (!abstractResolvableFuture.isDone()) {
                    abstractResolvableFuture.n(new FutureGarbageCollectedException("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.f1638a));
                }
            }
            if (this.f1641d || (resolvableFuture = this.f1640c) == null) {
                return;
            }
            resolvableFuture.l(null);
        }
    }

    public static final class FutureGarbageCollectedException extends Throwable {
        @Override // java.lang.Throwable
        public final synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    public interface Resolver<T> {
        Object a(Completer completer);
    }

    public static final class SafeFuture<T> implements ListenableFuture<T> {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference f1642a;

        /* renamed from: b, reason: collision with root package name */
        public final AbstractResolvableFuture f1643b = new AbstractResolvableFuture<T>() { // from class: androidx.concurrent.futures.CallbackToFutureAdapter.SafeFuture.1
            @Override // androidx.concurrent.futures.AbstractResolvableFuture
            public final String h() {
                Completer completer = (Completer) SafeFuture.this.f1642a.get();
                return completer == null ? "Completer object has been garbage collected, future will fail soon" : b.q(new StringBuilder("tag=["), completer.f1638a, "]");
            }
        };

        public SafeFuture(Completer completer) {
            this.f1642a = new WeakReference(completer);
        }

        @Override // java.util.concurrent.Future
        public final boolean cancel(boolean z) {
            Completer completer = (Completer) this.f1642a.get();
            boolean zCancel = this.f1643b.cancel(z);
            if (zCancel && completer != null) {
                completer.f1638a = null;
                completer.f1639b = null;
                completer.f1640c.l(null);
            }
            return zCancel;
        }

        @Override // java.util.concurrent.Future
        public final Object get() {
            return this.f1643b.get();
        }

        @Override // java.util.concurrent.Future
        public final boolean isCancelled() {
            return this.f1643b.f1618a instanceof AbstractResolvableFuture.Cancellation;
        }

        @Override // java.util.concurrent.Future
        public final boolean isDone() {
            return this.f1643b.isDone();
        }

        @Override // com.google.common.util.concurrent.ListenableFuture
        public final void q(Runnable runnable, Executor executor) {
            this.f1643b.q(runnable, executor);
        }

        public final String toString() {
            return this.f1643b.toString();
        }

        @Override // java.util.concurrent.Future
        public final Object get(long j2, TimeUnit timeUnit) {
            return this.f1643b.get(j2, timeUnit);
        }
    }

    public static ListenableFuture a(Resolver resolver) {
        Completer completer = new Completer();
        completer.f1640c = new ResolvableFuture();
        SafeFuture safeFuture = new SafeFuture(completer);
        completer.f1639b = safeFuture;
        completer.f1638a = resolver.getClass();
        try {
            Object objA = resolver.a(completer);
            if (objA != null) {
                completer.f1638a = objA;
                return safeFuture;
            }
        } catch (Exception e2) {
            safeFuture.f1643b.n(e2);
        }
        return safeFuture;
    }
}
