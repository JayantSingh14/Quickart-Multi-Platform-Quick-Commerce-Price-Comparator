package io.sentry.hints;

import io.sentry.ILogger;
import io.sentry.SentryLevel;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public abstract class BlockingFlushHint implements DiskFlushNotification, Flushable {

    /* renamed from: a, reason: collision with root package name */
    public final CountDownLatch f52745a = new CountDownLatch(1);

    /* renamed from: b, reason: collision with root package name */
    public final long f52746b;

    /* renamed from: c, reason: collision with root package name */
    public final ILogger f52747c;

    public BlockingFlushHint(long j2, ILogger iLogger) {
        this.f52746b = j2;
        this.f52747c = iLogger;
    }

    @Override // io.sentry.hints.DiskFlushNotification
    public final void d() {
        this.f52745a.countDown();
    }

    @Override // io.sentry.hints.Flushable
    public final boolean g() {
        try {
            return this.f52745a.await(this.f52746b, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            this.f52747c.b(SentryLevel.ERROR, "Exception while awaiting for flush in BlockingFlushHint", e2);
            return false;
        }
    }
}
