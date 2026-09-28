package io.sentry.hints;

import io.sentry.protocol.SentryId;

/* loaded from: classes.dex */
public interface DiskFlushNotification {
    boolean b(SentryId sentryId);

    void c(SentryId sentryId);

    void d();
}
