package io.sentry.cache;

import io.sentry.Hint;
import io.sentry.SentryEnvelope;

/* loaded from: classes.dex */
public interface IEnvelopeCache extends Iterable<SentryEnvelope> {
    void v0(SentryEnvelope sentryEnvelope, Hint hint);

    void x(SentryEnvelope sentryEnvelope);
}
