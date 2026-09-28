package io.sentry;

import coil3.network.internal.UtilsKt;
import io.sentry.SentryOptions;
import java.io.Closeable;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.concurrent.RejectedExecutionException;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class SpotlightIntegration implements Integration, SentryOptions.BeforeEnvelopeCallback, Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public SentryOptions f51934a;

    /* renamed from: b, reason: collision with root package name */
    public ILogger f51935b = NoOpLogger.f51707a;

    /* renamed from: c, reason: collision with root package name */
    public ISentryExecutorService f51936c = NoOpSentryExecutorService.f51711a;

    public static void b(HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.getInputStream().close();
        } catch (IOException unused) {
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public static HttpURLConnection c(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) URI.create(str).toURL().openConnection();
        httpURLConnection.setReadTimeout(1000);
        httpURLConnection.setConnectTimeout(1000);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty(UtilsKt.CONTENT_TYPE, "application/x-sentry-envelope");
        httpURLConnection.setRequestProperty("Accept", "application/json");
        httpURLConnection.setRequestProperty("Connection", "close");
        httpURLConnection.connect();
        return httpURLConnection;
    }

    @Override // io.sentry.SentryOptions.BeforeEnvelopeCallback
    public final void a(SentryEnvelope sentryEnvelope) {
        try {
            this.f51936c.submit(new in.juspay.hypernfc.b(20, this, sentryEnvelope));
        } catch (RejectedExecutionException e2) {
            this.f51935b.b(SentryLevel.WARNING, "Spotlight envelope submission rejected.", e2);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f51936c.b(0L);
        SentryOptions sentryOptions = this.f51934a;
        if (sentryOptions == null || sentryOptions.getBeforeEnvelopeCallback() != this) {
            return;
        }
        this.f51934a.setBeforeEnvelopeCallback(null);
    }

    @Override // io.sentry.Integration
    public final void l(SentryOptions sentryOptions) {
        this.f51934a = sentryOptions;
        this.f51935b = sentryOptions.getLogger();
        if (sentryOptions.getBeforeEnvelopeCallback() != null || !sentryOptions.isEnableSpotlight()) {
            this.f51935b.c(SentryLevel.DEBUG, "SpotlightIntegration is not enabled. BeforeEnvelopeCallback is already set or spotlight is not enabled.", new Object[0]);
            return;
        }
        this.f51936c = new SentryExecutorService();
        sentryOptions.setBeforeEnvelopeCallback(this);
        this.f51935b.c(SentryLevel.DEBUG, "SpotlightIntegration enabled.", new Object[0]);
    }
}
