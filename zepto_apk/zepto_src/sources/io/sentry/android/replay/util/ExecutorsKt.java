package io.sentry.android.replay.util;

import androidx.media3.common.util.e;
import in.juspay.hypernfc.b;
import io.sentry.ISentryExecutorService;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.replay.c;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: classes3.dex */
public final class ExecutorsKt {
    public static final void a(ScheduledExecutorService scheduledExecutorService, SentryOptions options) {
        Intrinsics.checkNotNullParameter(scheduledExecutorService, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        synchronized (scheduledExecutorService) {
            if (!scheduledExecutorService.isShutdown()) {
                scheduledExecutorService.shutdown();
            }
            try {
            } catch (InterruptedException unused) {
                scheduledExecutorService.shutdownNow();
                Thread.currentThread().interrupt();
            }
            if (scheduledExecutorService.awaitTermination(options.getShutdownTimeoutMillis(), TimeUnit.MILLISECONDS)) {
                Unit unit = Unit.f53572a;
            } else {
                scheduledExecutorService.shutdownNow();
                Unit unit2 = Unit.f53572a;
            }
        }
    }

    public static final void b(ISentryExecutorService iSentryExecutorService, SentryOptions options, c task) {
        Intrinsics.checkNotNullParameter(iSentryExecutorService, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter("ReplayIntegration.finalize_previous_replay", "taskName");
        Intrinsics.checkNotNullParameter(task, "task");
        try {
            iSentryExecutorService.submit(new b(23, task, options));
        } catch (Throwable th) {
            options.getLogger().b(SentryLevel.ERROR, "Failed to submit task ReplayIntegration.finalize_previous_replay to executor", th);
        }
    }

    public static final void c(ExecutorService executorService, SentryOptions options, String taskName, Runnable task) {
        Intrinsics.checkNotNullParameter(executorService, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(taskName, "taskName");
        Intrinsics.checkNotNullParameter(task, "task");
        String name = Thread.currentThread().getName();
        Intrinsics.checkNotNullExpressionValue(name, "currentThread().name");
        if (StringsKt.O(name, "SentryReplayIntegration", false)) {
            task.run();
            return;
        }
        try {
            executorService.submit(new e(task, options, taskName, 24));
        } catch (Throwable th) {
            options.getLogger().b(SentryLevel.ERROR, android.support.v4.media.b.D("Failed to submit task ", taskName, " to executor"), th);
        }
    }
}
