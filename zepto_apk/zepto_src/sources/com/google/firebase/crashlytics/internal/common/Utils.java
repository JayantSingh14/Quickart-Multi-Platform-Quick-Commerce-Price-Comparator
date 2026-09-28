package com.google.firebase.crashlytics.internal.common;

import android.os.Looper;
import androidx.media3.exoplayer.analytics.l;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.Logger;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes4.dex */
public final class Utils {

    /* renamed from: a, reason: collision with root package name */
    public static final ExecutorService f43842a;

    static {
        ExecutorService executorServiceUnconfigurableExecutorService = Executors.unconfigurableExecutorService(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.google.firebase.crashlytics.internal.common.ExecutorUtils.1

            /* renamed from: a */
            public final /* synthetic */ AtomicLong f43816a;

            /* renamed from: com.google.firebase.crashlytics.internal.common.ExecutorUtils$1$1 */
            class C00471 extends BackgroundPriorityRunnable {

                /* renamed from: a */
                public final /* synthetic */ Runnable f43817a;

                public C00471(Runnable runnable) {
                    runnable = runnable;
                }

                @Override // com.google.firebase.crashlytics.internal.common.BackgroundPriorityRunnable
                public final void a() {
                    runnable.run();
                }
            }

            public AnonymousClass1(AtomicLong atomicLong) {
                atomicLong = atomicLong;
            }

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread threadNewThread = Executors.defaultThreadFactory().newThread(new BackgroundPriorityRunnable() { // from class: com.google.firebase.crashlytics.internal.common.ExecutorUtils.1.1

                    /* renamed from: a */
                    public final /* synthetic */ Runnable f43817a;

                    public C00471(Runnable runnable2) {
                        runnable = runnable2;
                    }

                    @Override // com.google.firebase.crashlytics.internal.common.BackgroundPriorityRunnable
                    public final void a() {
                        runnable.run();
                    }
                });
                threadNewThread.setName("awaitEvenIfOnMainThread task continuation executor" + atomicLong.getAndIncrement());
                return threadNewThread;
            }
        }, new ThreadPoolExecutor.DiscardPolicy()));
        TimeUnit timeUnit = TimeUnit.SECONDS;
        Runtime.getRuntime().addShutdownHook(new Thread(new BackgroundPriorityRunnable() { // from class: com.google.firebase.crashlytics.internal.common.ExecutorUtils.2

            /* renamed from: a */
            public final /* synthetic */ ExecutorService f43818a;

            public AnonymousClass2(ExecutorService executorServiceUnconfigurableExecutorService2) {
                TimeUnit timeUnit2 = TimeUnit.SECONDS;
                executorService = executorServiceUnconfigurableExecutorService2;
            }

            @Override // com.google.firebase.crashlytics.internal.common.BackgroundPriorityRunnable
            public final void a() {
                Logger logger = Logger.f43705a;
                ExecutorService executorService = executorService;
                try {
                    logger.b("Executing shutdown hook for awaitEvenIfOnMainThread task continuation executor", null);
                    executorService.shutdown();
                    if (executorService.awaitTermination(2L, TimeUnit.SECONDS)) {
                        return;
                    }
                    logger.b("awaitEvenIfOnMainThread task continuation executor did not shut down in the allocated time. Requesting immediate shutdown.", null);
                    executorService.shutdownNow();
                } catch (InterruptedException unused) {
                    Locale locale = Locale.US;
                    logger.b("Interrupted while waiting for awaitEvenIfOnMainThread task continuation executor to shut down. Requesting immediate shutdown.", null);
                    executorService.shutdownNow();
                }
            }
        }, "Crashlytics Shutdown Hook for awaitEvenIfOnMainThread task continuation executor"));
        f43842a = executorServiceUnconfigurableExecutorService2;
    }

    public static void a(Task task) throws InterruptedException, TimeoutException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        task.h(f43842a, new l(countDownLatch, 15));
        if (Looper.getMainLooper() == Looper.myLooper()) {
            countDownLatch.await(3000L, TimeUnit.MILLISECONDS);
        } else {
            countDownLatch.await(4000L, TimeUnit.MILLISECONDS);
        }
        if (task.p()) {
            task.l();
        } else {
            if (task.n()) {
                throw new CancellationException("Task is already canceled");
            }
            if (!task.o()) {
                throw new TimeoutException();
            }
            throw new IllegalStateException(task.k());
        }
    }
}
