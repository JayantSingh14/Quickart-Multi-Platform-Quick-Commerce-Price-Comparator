package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class GlideExecutor implements ExecutorService {

    /* renamed from: b, reason: collision with root package name */
    public static final long f16113b = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: c, reason: collision with root package name */
    public static volatile int f16114c;

    /* renamed from: a, reason: collision with root package name */
    public final ThreadPoolExecutor f16115a;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f16116a;

        /* renamed from: b, reason: collision with root package name */
        public int f16117b;

        /* renamed from: c, reason: collision with root package name */
        public int f16118c;

        /* renamed from: d, reason: collision with root package name */
        public final UncaughtThrowableStrategy f16119d = UncaughtThrowableStrategy.f16127b;

        /* renamed from: e, reason: collision with root package name */
        public String f16120e;

        public Builder(boolean z) {
            this.f16116a = z;
        }

        public final GlideExecutor a() {
            if (!TextUtils.isEmpty(this.f16120e)) {
                return new GlideExecutor(new ThreadPoolExecutor(this.f16117b, this.f16118c, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new DefaultThreadFactory(this.f16120e, this.f16116a)));
            }
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.f16120e);
        }
    }

    public static final class DefaultThreadFactory implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public final String f16121a;

        /* renamed from: b, reason: collision with root package name */
        public final UncaughtThrowableStrategy f16122b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f16123c;

        /* renamed from: d, reason: collision with root package name */
        public int f16124d;

        public DefaultThreadFactory(String str, boolean z) {
            UncaughtThrowableStrategy uncaughtThrowableStrategy = UncaughtThrowableStrategy.f16127b;
            this.f16121a = str;
            this.f16122b = uncaughtThrowableStrategy;
            this.f16123c = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-" + this.f16121a + "-thread-" + this.f16124d) { // from class: com.bumptech.glide.load.engine.executor.GlideExecutor.DefaultThreadFactory.1
                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() throws SecurityException, IllegalArgumentException {
                    Process.setThreadPriority(9);
                    if (DefaultThreadFactory.this.f16123c) {
                        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                    }
                    try {
                        super.run();
                    } catch (Throwable th) {
                        if (Log.isLoggable("GlideExecutor", 6)) {
                            Log.e("GlideExecutor", "Request threw uncaught throwable", th);
                        }
                    }
                }
            };
            this.f16124d = this.f16124d + 1;
            return thread;
        }
    }

    public interface UncaughtThrowableStrategy {

        /* renamed from: a, reason: collision with root package name */
        public static final UncaughtThrowableStrategy f16126a = null;

        /* renamed from: b, reason: collision with root package name */
        public static final UncaughtThrowableStrategy f16127b = new AnonymousClass2();

        /* renamed from: com.bumptech.glide.load.engine.executor.GlideExecutor$UncaughtThrowableStrategy$1, reason: invalid class name */
        public class AnonymousClass1 implements UncaughtThrowableStrategy {
        }

        /* renamed from: com.bumptech.glide.load.engine.executor.GlideExecutor$UncaughtThrowableStrategy$2, reason: invalid class name */
        public class AnonymousClass2 implements UncaughtThrowableStrategy {
        }

        /* renamed from: com.bumptech.glide.load.engine.executor.GlideExecutor$UncaughtThrowableStrategy$3, reason: invalid class name */
        public class AnonymousClass3 implements UncaughtThrowableStrategy {
        }
    }

    public GlideExecutor(ThreadPoolExecutor threadPoolExecutor) {
        this.f16115a = threadPoolExecutor;
    }

    public static GlideExecutor a() {
        return new GlideExecutor(new ThreadPoolExecutor(0, Api.BaseClientBuilder.API_PRIORITY_OTHER, f16113b, TimeUnit.MILLISECONDS, new SynchronousQueue(), new DefaultThreadFactory("source-unlimited", false)));
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long j2, TimeUnit timeUnit) {
        return this.f16115a.awaitTermination(j2, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f16115a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public final List invokeAll(Collection collection) {
        return this.f16115a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public final Object invokeAny(Collection collection) {
        return this.f16115a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        return this.f16115a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        return this.f16115a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        this.f16115a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final List shutdownNow() {
        return this.f16115a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public final Future submit(Runnable runnable) {
        return this.f16115a.submit(runnable);
    }

    public final String toString() {
        return this.f16115a.toString();
    }

    @Override // java.util.concurrent.ExecutorService
    public final List invokeAll(Collection collection, long j2, TimeUnit timeUnit) {
        return this.f16115a.invokeAll(collection, j2, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public final Object invokeAny(Collection collection, long j2, TimeUnit timeUnit) {
        return this.f16115a.invokeAny(collection, j2, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public final Future submit(Runnable runnable, Object obj) {
        return this.f16115a.submit(runnable, obj);
    }

    @Override // java.util.concurrent.ExecutorService
    public final Future submit(Callable callable) {
        return this.f16115a.submit(callable);
    }
}
