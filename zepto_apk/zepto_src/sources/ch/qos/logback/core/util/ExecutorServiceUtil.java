package ch.qos.logback.core.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class ExecutorServiceUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadFactory f13805a = new ThreadFactory() { // from class: ch.qos.logback.core.util.ExecutorServiceUtil.1

        /* renamed from: a, reason: collision with root package name */
        public final ThreadFactory f13806a = Executors.defaultThreadFactory();

        /* renamed from: b, reason: collision with root package name */
        public final AtomicInteger f13807b = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread threadNewThread = this.f13806a.newThread(runnable);
            if (!threadNewThread.isDaemon()) {
                threadNewThread.setDaemon(true);
            }
            threadNewThread.setName("logback-" + this.f13807b.getAndIncrement());
            return threadNewThread;
        }
    };

    public static ScheduledThreadPoolExecutor a() {
        return new ScheduledThreadPoolExecutor(8, f13805a);
    }

    public static void b(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        scheduledThreadPoolExecutor.shutdownNow();
    }
}
