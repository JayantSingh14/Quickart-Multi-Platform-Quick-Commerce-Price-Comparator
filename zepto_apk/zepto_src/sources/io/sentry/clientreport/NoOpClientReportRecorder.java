package io.sentry.clientreport;

import io.sentry.DataCategory;
import io.sentry.SentryEnvelope;
import io.sentry.SentryEnvelopeItem;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes3.dex */
public final class NoOpClientReportRecorder implements IClientReportRecorder {
    @Override // io.sentry.clientreport.IClientReportRecorder
    public final void a(DiscardReason discardReason, DataCategory dataCategory) {
    }

    @Override // io.sentry.clientreport.IClientReportRecorder
    public final void b(DiscardReason discardReason, SentryEnvelope sentryEnvelope) {
    }

    @Override // io.sentry.clientreport.IClientReportRecorder
    public final void c(DiscardReason discardReason, DataCategory dataCategory, long j2) {
    }

    @Override // io.sentry.clientreport.IClientReportRecorder
    public final void d(DiscardReason discardReason, SentryEnvelopeItem sentryEnvelopeItem) {
    }

    @Override // io.sentry.clientreport.IClientReportRecorder
    public final SentryEnvelope e(SentryEnvelope sentryEnvelope) {
        return sentryEnvelope;
    }
}
