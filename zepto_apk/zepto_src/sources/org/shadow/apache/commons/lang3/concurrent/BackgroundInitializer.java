package org.shadow.apache.commons.lang3.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: classes5.dex */
public abstract class BackgroundInitializer<T> implements ConcurrentInitializer<T> {

    /* renamed from: a, reason: collision with root package name */
    public ExecutorService f57748a;

    /* renamed from: b, reason: collision with root package name */
    public ExecutorService f57749b;

    /* renamed from: c, reason: collision with root package name */
    public Future f57750c;

    public class InitializationTask implements Callable<T> {

        /* renamed from: a, reason: collision with root package name */
        public final ExecutorService f57751a;

        public InitializationTask(ExecutorService executorService) {
            this.f57751a = executorService;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            ExecutorService executorService = this.f57751a;
            try {
                return BackgroundInitializer.this.d();
            } finally {
                if (executorService != null) {
                    executorService.shutdown();
                }
            }
        }
    }

    public final Object a() throws ConcurrentException {
        ConcurrentException concurrentException;
        try {
            return b().get();
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            ConcurrentUtils.a(e2);
            throw new ConcurrentException(e2);
        } catch (ExecutionException e3) {
            if (e3.getCause() == null) {
                concurrentException = null;
            } else {
                if (e3.getCause() instanceof RuntimeException) {
                    throw ((RuntimeException) e3.getCause());
                }
                if (e3.getCause() instanceof Error) {
                    throw ((Error) e3.getCause());
                }
                String message = e3.getMessage();
                Throwable cause = e3.getCause();
                ConcurrentUtils.a(cause);
                concurrentException = new ConcurrentException(message, cause);
            }
            if (concurrentException == null) {
                return null;
            }
            throw concurrentException;
        }
    }

    public final synchronized Future b() {
        Future future;
        future = this.f57750c;
        if (future == null) {
            throw new IllegalStateException("start() must be called first!");
        }
        return future;
    }

    public int c() {
        return 1;
    }

    public abstract Object d();

    public final synchronized void e(ExecutorService executorService) {
        synchronized (this) {
        }
        if (this.f57750c != null) {
            throw new IllegalStateException("Cannot set ExecutorService after start()!");
        }
        this.f57748a = executorService;
    }
}
