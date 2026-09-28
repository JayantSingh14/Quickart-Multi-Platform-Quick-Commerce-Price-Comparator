package io.sentry;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class SentryExecutorService implements ISentryExecutorService {

    /* renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f51833a = Executors.newSingleThreadScheduledExecutor(new SentryExecutorServiceThreadFactory());

    public static final class SentryExecutorServiceThreadFactory implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public int f51834a;

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            StringBuilder sb = new StringBuilder("SentryExecutorServiceThreadFactory-");
            int i2 = this.f51834a;
            this.f51834a = i2 + 1;
            sb.append(i2);
            Thread thread = new Thread(runnable, sb.toString());
            thread.setDaemon(true);
            return thread;
        }
    }

    @Override // io.sentry.ISentryExecutorService
    public final Future a(long j2, Runnable runnable) {
        return this.f51833a.schedule(runnable, j2, TimeUnit.MILLISECONDS);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002e A[Catch: all -> 0x0020, DONT_GENERATE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000b, B:7:0x0010, B:9:0x001a, B:13:0x0022, B:14:0x002e), top: B:18:0x0003, inners: #1 }] */
    @Override // io.sentry.ISentryExecutorService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(long r4) {
        /*
            r3 = this;
            java.util.concurrent.ScheduledExecutorService r0 = r3.f51833a
            monitor-enter(r0)
            java.util.concurrent.ScheduledExecutorService r1 = r3.f51833a     // Catch: java.lang.Throwable -> L20
            boolean r1 = r1.isShutdown()     // Catch: java.lang.Throwable -> L20
            if (r1 != 0) goto L2e
            java.util.concurrent.ScheduledExecutorService r1 = r3.f51833a     // Catch: java.lang.Throwable -> L20
            r1.shutdown()     // Catch: java.lang.Throwable -> L20
            java.util.concurrent.ScheduledExecutorService r1 = r3.f51833a     // Catch: java.lang.Throwable -> L20 java.lang.InterruptedException -> L22
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L20 java.lang.InterruptedException -> L22
            boolean r4 = r1.awaitTermination(r4, r2)     // Catch: java.lang.Throwable -> L20 java.lang.InterruptedException -> L22
            if (r4 != 0) goto L2e
            java.util.concurrent.ScheduledExecutorService r4 = r3.f51833a     // Catch: java.lang.Throwable -> L20 java.lang.InterruptedException -> L22
            r4.shutdownNow()     // Catch: java.lang.Throwable -> L20 java.lang.InterruptedException -> L22
            goto L2e
        L20:
            r4 = move-exception
            goto L30
        L22:
            java.util.concurrent.ScheduledExecutorService r4 = r3.f51833a     // Catch: java.lang.Throwable -> L20
            r4.shutdownNow()     // Catch: java.lang.Throwable -> L20
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L20
            r4.interrupt()     // Catch: java.lang.Throwable -> L20
        L2e:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L20
            return
        L30:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L20
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.SentryExecutorService.b(long):void");
    }

    @Override // io.sentry.ISentryExecutorService
    public final boolean isClosed() {
        boolean zIsShutdown;
        synchronized (this.f51833a) {
            zIsShutdown = this.f51833a.isShutdown();
        }
        return zIsShutdown;
    }

    @Override // io.sentry.ISentryExecutorService
    public final Future submit(Runnable runnable) {
        return this.f51833a.submit(runnable);
    }
}
