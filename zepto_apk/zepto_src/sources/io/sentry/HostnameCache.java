package io.sentry;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
final class HostnameCache {

    /* renamed from: g, reason: collision with root package name */
    public static final long f51642g = TimeUnit.HOURS.toMillis(5);

    /* renamed from: h, reason: collision with root package name */
    public static final long f51643h = TimeUnit.SECONDS.toMillis(1);

    /* renamed from: i, reason: collision with root package name */
    public static HostnameCache f51644i;

    /* renamed from: a, reason: collision with root package name */
    public final long f51645a;

    /* renamed from: b, reason: collision with root package name */
    public volatile String f51646b;

    /* renamed from: c, reason: collision with root package name */
    public volatile long f51647c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f51648d;

    /* renamed from: e, reason: collision with root package name */
    public final c f51649e;

    /* renamed from: f, reason: collision with root package name */
    public final ExecutorService f51650f;

    public static final class HostnameCacheThreadFactory implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public int f51651a;

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            StringBuilder sb = new StringBuilder("SentryHostnameCache-");
            int i2 = this.f51651a;
            this.f51651a = i2 + 1;
            sb.append(i2);
            Thread thread = new Thread(runnable, sb.toString());
            thread.setDaemon(true);
            return thread;
        }
    }

    public HostnameCache() throws ExecutionException, InterruptedException, TimeoutException {
        c cVar = new c(0);
        this.f51648d = new AtomicBoolean(false);
        this.f51650f = Executors.newSingleThreadExecutor(new HostnameCacheThreadFactory());
        this.f51645a = f51642g;
        this.f51649e = cVar;
        d();
    }

    public static HostnameCache c() {
        if (f51644i == null) {
            f51644i = new HostnameCache();
        }
        return f51644i;
    }

    public final void a() {
        this.f51650f.shutdown();
    }

    public final String b() throws ExecutionException, InterruptedException, TimeoutException {
        if (this.f51647c < System.currentTimeMillis() && this.f51648d.compareAndSet(false, true)) {
            d();
        }
        return this.f51646b;
    }

    public final void d() throws ExecutionException, InterruptedException, TimeoutException {
        try {
            this.f51650f.submit(new d(this, 0)).get(f51643h, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            this.f51647c = TimeUnit.SECONDS.toMillis(1L) + System.currentTimeMillis();
        } catch (RuntimeException | ExecutionException | TimeoutException unused2) {
            this.f51647c = TimeUnit.SECONDS.toMillis(1L) + System.currentTimeMillis();
        }
    }
}
