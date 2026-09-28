package io.sentry.transport;

import io.sentry.SentryEnvelope;
import io.sentry.clientreport.DiscardReason;
import io.sentry.transport.AsyncHttpTransport;
import io.sentry.util.HintUtils;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements HintUtils.SentryNullableConsumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AsyncHttpTransport.EnvelopeSender f53120a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SentryEnvelope f53121b;

    public /* synthetic */ b(AsyncHttpTransport.EnvelopeSender envelopeSender, SentryEnvelope sentryEnvelope) {
        this.f53120a = envelopeSender;
        this.f53121b = sentryEnvelope;
    }

    public final void a() {
        AsyncHttpTransport.this.f53080c.getClientReportRecorder().b(DiscardReason.NETWORK_ERROR, this.f53121b);
    }
}
