package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.logging.Logging;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
class SafeLoggingExecutor implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f20749a;

    public static class SafeLoggingRunnable implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final Runnable f20750a;

        public SafeLoggingRunnable(Runnable runnable) {
            this.f20750a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.f20750a.run();
            } catch (Exception e2) {
                Logging.c("Executor", "Background execution failure.", e2);
            }
        }
    }

    public SafeLoggingExecutor(ExecutorService executorService) {
        this.f20749a = executorService;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f20749a.execute(new SafeLoggingRunnable(runnable));
    }
}
