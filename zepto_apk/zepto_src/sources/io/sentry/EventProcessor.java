package io.sentry;

import io.sentry.protocol.SentryTransaction;

/* loaded from: classes.dex */
public interface EventProcessor {
    default SentryReplayEvent a(SentryReplayEvent sentryReplayEvent, Hint hint) {
        return sentryReplayEvent;
    }

    default SentryEvent b(SentryEvent sentryEvent, Hint hint) {
        return sentryEvent;
    }

    default SentryTransaction c(SentryTransaction sentryTransaction, Hint hint) {
        return sentryTransaction;
    }
}
