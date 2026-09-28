package io.sentry.transport;

import io.sentry.Hint;
import io.sentry.SentryEnvelope;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes3.dex */
public final class NoOpTransport implements ITransport {

    /* renamed from: a, reason: collision with root package name */
    public static final NoOpTransport f53098a = new NoOpTransport();

    @Override // io.sentry.transport.ITransport
    public final void M(SentryEnvelope sentryEnvelope, Hint hint) {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // io.sentry.transport.ITransport
    public final void n(boolean z) {
    }

    @Override // io.sentry.transport.ITransport
    public final RateLimiter o() {
        return null;
    }

    @Override // io.sentry.transport.ITransport
    public final void v(long j2) {
    }
}
