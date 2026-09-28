package org.xbill.DNS;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.BiConsumer;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: classes5.dex */
class TimeoutCompletableFuture<T> extends CompletableFuture<T> {

    @Generated
    private static final Logger log = LoggerFactory.b(TimeoutCompletableFuture.class);
    private static final Method orTimeoutMethod;

    public static final class TimeoutScheduler {
        private static final ScheduledThreadPoolExecutor executor;

        static {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new b0());
            executor = scheduledThreadPoolExecutor;
            scheduledThreadPoolExecutor.setRemoveOnCancelPolicy(true);
        }

        private TimeoutScheduler() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Thread lambda$static$0(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            thread.setName("dnsjava AsyncSemaphoreTimeoutScheduler");
            return thread;
        }
    }

    static {
        Method method = null;
        if (!System.getProperty("java.version").startsWith("1.")) {
            try {
                method = CompletableFuture.class.getMethod("orTimeout", Long.TYPE, TimeUnit.class);
            } catch (NoSuchMethodException e2) {
                log.t("CompletableFuture.orTimeout method not found in Java 9+, using custom implementation", e2);
            }
        }
        orTimeoutMethod = method;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$orTimeout$0(CompletableFuture completableFuture) {
        if (completableFuture.isDone()) {
            return;
        }
        completableFuture.completeExceptionally(new TimeoutException());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$orTimeout$1(ScheduledFuture scheduledFuture, Object obj, Throwable th) {
        if (th != null || scheduledFuture.isDone()) {
            return;
        }
        scheduledFuture.cancel(false);
    }

    private static <T> CompletableFuture<T> orTimeout(CompletableFuture<T> completableFuture, long j2, TimeUnit timeUnit) {
        completableFuture.whenComplete((BiConsumer) new t(TimeoutScheduler.executor.schedule(new a0(completableFuture, 0), j2, timeUnit), 1));
        return completableFuture;
    }

    public CompletableFuture<T> compatTimeout(long j2, TimeUnit timeUnit) {
        return compatTimeout(this, j2, timeUnit);
    }

    public static <T> CompletableFuture<T> compatTimeout(CompletableFuture<T> completableFuture, long j2, TimeUnit timeUnit) {
        Method method = orTimeoutMethod;
        if (method == null) {
            return orTimeout(completableFuture, j2, timeUnit);
        }
        try {
            return (CompletableFuture) method.invoke(completableFuture, Long.valueOf(j2), timeUnit);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return orTimeout(completableFuture, j2, timeUnit);
        }
    }
}
