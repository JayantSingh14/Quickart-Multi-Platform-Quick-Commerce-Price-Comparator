package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class AFc1oSDK extends ThreadPoolExecutor {

    @NotNull
    private final Queue<Runnable> AFAdRevenueData;

    public /* synthetic */ AFc1oSDK(int i2, int i3, long j2, TimeUnit timeUnit, BlockingQueue blockingQueue, Queue queue, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, i3, j2, timeUnit, blockingQueue, (i4 & 32) != 0 ? new LinkedList() : queue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCurrencyIso4217Code(Queue queue, Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        Intrinsics.checkNotNullParameter(queue, "");
        Intrinsics.checkNotNullParameter(runnable, "");
        Intrinsics.checkNotNullParameter(threadPoolExecutor, "");
        queue.add(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void afterExecute(@NotNull Runnable runnable, @Nullable Throwable th) {
        Intrinsics.checkNotNullParameter(runnable, "");
        super.afterExecute(runnable, th);
        Intrinsics.checkNotNullParameter(runnable, "");
        if (th != null) {
            AFg1gSDK.e$default(AFLogger.INSTANCE, AFg1cSDK.AF_EXECUTOR, "Error while executing task: " + runnable, th, true, true, true, false, 64, null);
            return;
        }
        synchronized (this) {
            try {
                int size = this.AFAdRevenueData.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Runnable runnablePoll = this.AFAdRevenueData.poll();
                    if (runnablePoll != null) {
                        execute(runnablePoll);
                    }
                }
                Unit unit = Unit.f53572a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private AFc1oSDK(int i2, int i3, long j2, @NotNull TimeUnit timeUnit, @NotNull BlockingQueue<Runnable> blockingQueue, @NotNull final Queue<Runnable> queue) {
        super(i2, i3, j2, timeUnit, blockingQueue, new RejectedExecutionHandler() { // from class: com.appsflyer.internal.h
            @Override // java.util.concurrent.RejectedExecutionHandler
            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                AFc1oSDK.getCurrencyIso4217Code(queue, runnable, threadPoolExecutor);
            }
        });
        Intrinsics.checkNotNullParameter(timeUnit, "");
        Intrinsics.checkNotNullParameter(blockingQueue, "");
        Intrinsics.checkNotNullParameter(queue, "");
        this.AFAdRevenueData = queue;
    }
}
