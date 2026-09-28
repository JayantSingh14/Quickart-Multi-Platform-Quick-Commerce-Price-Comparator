package in.juspay.hyper.core;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes4.dex */
public final class ExecutorManager {

    @Nullable
    private static String logsThreadId;

    @Nullable
    private static String trackerThreadId;

    @NotNull
    public static final ExecutorManager INSTANCE = new ExecutorManager();
    private static final ExecutorService logsPool = Executors.newSingleThreadExecutor();
    private static final ExecutorService sharedPool = Executors.newFixedThreadPool(4);
    private static final ExecutorService sdkTrackerPool = Executors.newSingleThreadExecutor();
    private static final ExecutorService logSessioniserPool = Executors.newSingleThreadExecutor();
    private static final ExecutorService logPusherPool = Executors.newSingleThreadExecutor();

    @NotNull
    private static final ThreadPoolExecutor processQueuePool = new ThreadPoolExecutor(0, 1, 5, TimeUnit.SECONDS, new LinkedBlockingQueue());

    private ExecutorManager() {
    }

    @JvmStatic
    @NotNull
    public static final <V> Future<V> doAsync(@NotNull Callable<V> callable) {
        Intrinsics.checkNotNullParameter(callable, "callable");
        Future<V> futureSubmit = sharedPool.submit(callable);
        Intrinsics.checkNotNullExpressionValue(futureSubmit, "sharedPool.submit(callable)");
        return futureSubmit;
    }

    @JvmStatic
    public static final void postOnMainThread(long j2, @NotNull Runnable task) {
        Intrinsics.checkNotNullParameter(task, "task");
        new Handler(Looper.getMainLooper()).postDelayed(task, j2);
    }

    @JvmStatic
    public static final void runOnBackgroundThread(@Nullable Runnable runnable) {
        sharedPool.execute(runnable);
    }

    @JvmStatic
    public static final void runOnLogPusherThread(@Nullable Runnable runnable) {
        logPusherPool.execute(runnable);
    }

    @JvmStatic
    public static final void runOnLogSessioniserThread(@Nullable Runnable runnable) {
        logSessioniserPool.execute(runnable);
    }

    @JvmStatic
    public static final void runOnLogsPool(@NotNull Runnable task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (Intrinsics.b(logsThreadId, String.valueOf(Thread.currentThread().getId()))) {
            task.run();
        } else {
            logsPool.execute(task);
        }
    }

    @JvmStatic
    public static final void runOnMainThread(@NotNull Runnable task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (Intrinsics.b(Looper.myLooper(), Looper.getMainLooper())) {
            task.run();
        } else {
            new Handler(Looper.getMainLooper()).post(task);
        }
    }

    @JvmStatic
    public static final void runOnProcessQueuePool(@NotNull Runnable task) {
        Intrinsics.checkNotNullParameter(task, "task");
        processQueuePool.execute(task);
    }

    @JvmStatic
    public static final void runOnSdkTrackerPool(@NotNull Runnable task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (Intrinsics.b(trackerThreadId, String.valueOf(Thread.currentThread().getId()))) {
            task.run();
        } else {
            sdkTrackerPool.execute(task);
        }
    }

    @JvmStatic
    public static final void setLogsThreadId(long j2) {
        logsThreadId = String.valueOf(j2);
    }

    @JvmStatic
    public static final void setTrackerThreadId(long j2) {
        trackerThreadId = String.valueOf(j2);
    }
}
