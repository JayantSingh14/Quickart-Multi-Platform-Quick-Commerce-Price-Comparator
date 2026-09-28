package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class AFj1dSDK {

    @NotNull
    public static final AFj1dSDK INSTANCE = new AFj1dSDK();

    private AFj1dSDK() {
    }

    @JvmStatic
    public static final void getMediationNetwork(@NotNull ScheduledExecutorService scheduledExecutorService, @NotNull Runnable runnable, long j2, @NotNull TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(scheduledExecutorService, "");
        Intrinsics.checkNotNullParameter(runnable, "");
        Intrinsics.checkNotNullParameter(timeUnit, "");
        try {
            scheduledExecutorService.schedule(runnable, j2, timeUnit);
        } catch (RejectedExecutionException e2) {
            AFLogger.afErrorLog("scheduleJob failed with RejectedExecutionException Exception", e2);
        } catch (Throwable th) {
            AFLogger.afErrorLog("scheduleJob failed with Exception", th);
        }
    }
}
