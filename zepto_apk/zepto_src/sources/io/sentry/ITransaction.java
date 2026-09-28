package io.sentry;

import io.sentry.protocol.SentryId;

/* loaded from: classes3.dex */
public interface ITransaction extends ISpan {
    void a(SpanStatus spanStatus, boolean z, Hint hint);

    SentryId e();

    String getName();

    Span m();

    void n();
}
