package io.sentry.transport;

import io.sentry.Hint;
import io.sentry.SentryEnvelope;
import java.io.Closeable;

/* loaded from: classes.dex */
public interface ITransport extends Closeable {
    void M(SentryEnvelope sentryEnvelope, Hint hint);

    default boolean i() {
        return true;
    }

    void n(boolean z);

    RateLimiter o();

    void v(long j2);
}
