package io.sentry.transport;

import io.sentry.Hint;
import io.sentry.SentryEnvelope;

/* loaded from: classes3.dex */
public final class StdoutTransport implements ITransport {
    @Override // io.sentry.transport.ITransport
    public final void M(SentryEnvelope sentryEnvelope, Hint hint) {
        try {
            throw null;
        } catch (Throwable unused) {
        }
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
        System.out.println("Flushing");
    }
}
