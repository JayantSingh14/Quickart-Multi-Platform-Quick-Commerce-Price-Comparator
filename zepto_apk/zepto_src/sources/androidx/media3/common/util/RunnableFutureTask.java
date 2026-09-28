package androidx.media3.common.util;

import java.lang.Exception;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;

@UnstableApi
/* loaded from: classes3.dex */
public abstract class RunnableFutureTask<R, E extends Exception> implements RunnableFuture<R> {

    /* renamed from: a, reason: collision with root package name */
    public Exception f5726a;

    /* renamed from: b, reason: collision with root package name */
    public Object f5727b;

    /* renamed from: c, reason: collision with root package name */
    public Thread f5728c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f5729d;

    public void a() {
    }

    public abstract Object b();

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
        return this.f5729d;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        throw null;
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        throw null;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j2, TimeUnit timeUnit) {
        TimeUnit.MILLISECONDS.convert(j2, timeUnit);
        throw null;
    }
}
