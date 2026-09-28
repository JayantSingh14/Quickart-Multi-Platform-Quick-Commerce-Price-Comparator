package io.sentry.backpressure;

/* loaded from: classes.dex */
public final class NoOpBackpressureMonitor implements IBackpressureMonitor {

    /* renamed from: a, reason: collision with root package name */
    public static final NoOpBackpressureMonitor f52668a = new NoOpBackpressureMonitor();

    @Override // io.sentry.backpressure.IBackpressureMonitor
    public final int a() {
        return 0;
    }

    @Override // io.sentry.backpressure.IBackpressureMonitor
    public final void start() {
    }
}
