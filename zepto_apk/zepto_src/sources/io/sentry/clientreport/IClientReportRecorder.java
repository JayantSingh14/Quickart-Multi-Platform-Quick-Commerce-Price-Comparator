package io.sentry.clientreport;

import io.sentry.DataCategory;
import io.sentry.SentryEnvelope;
import io.sentry.SentryEnvelopeItem;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public interface IClientReportRecorder {
    void a(DiscardReason discardReason, DataCategory dataCategory);

    void b(DiscardReason discardReason, SentryEnvelope sentryEnvelope);

    void c(DiscardReason discardReason, DataCategory dataCategory, long j2);

    void d(DiscardReason discardReason, SentryEnvelopeItem sentryEnvelopeItem);

    SentryEnvelope e(SentryEnvelope sentryEnvelope);
}
