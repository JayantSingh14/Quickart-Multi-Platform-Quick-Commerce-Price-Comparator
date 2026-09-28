package io.sentry.backpressure;

import io.sentry.HubAdapter;
import io.sentry.ISentryExecutorService;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;

/* loaded from: classes3.dex */
public final class BackpressureMonitor implements IBackpressureMonitor, Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final SentryOptions f52666a;

    /* renamed from: b, reason: collision with root package name */
    public int f52667b = 0;

    public BackpressureMonitor(SentryOptions sentryOptions) {
        this.f52666a = sentryOptions;
    }

    @Override // io.sentry.backpressure.IBackpressureMonitor
    public final int a() {
        return this.f52667b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zI = HubAdapter.f51658a.i();
        SentryOptions sentryOptions = this.f52666a;
        if (zI) {
            if (this.f52667b > 0) {
                sentryOptions.getLogger().c(SentryLevel.DEBUG, "Health check positive, reverting to normal sampling.", new Object[0]);
            }
            this.f52667b = 0;
        } else {
            int i2 = this.f52667b;
            if (i2 < 10) {
                this.f52667b = i2 + 1;
                sentryOptions.getLogger().c(SentryLevel.DEBUG, "Health check negative, downsampling with a factor of %d", Integer.valueOf(this.f52667b));
            }
        }
        ISentryExecutorService executorService = sentryOptions.getExecutorService();
        if (executorService.isClosed()) {
            return;
        }
        executorService.a(10000, this);
    }

    @Override // io.sentry.backpressure.IBackpressureMonitor
    public final void start() {
        ISentryExecutorService executorService = this.f52666a.getExecutorService();
        if (executorService.isClosed()) {
            return;
        }
        executorService.a(500, this);
    }
}
