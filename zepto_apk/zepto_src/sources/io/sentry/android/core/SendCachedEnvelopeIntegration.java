package io.sentry.android.core;

import io.sentry.HubAdapter;
import io.sentry.IConnectionStatusProvider;
import io.sentry.ILogger;
import io.sentry.Integration;
import io.sentry.SendCachedEnvelopeFireAndForgetIntegration;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.util.IntegrationUtils;
import io.sentry.util.LazyEvaluator;
import io.sentry.util.Objects;
import java.io.Closeable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
final class SendCachedEnvelopeIntegration implements Integration, IConnectionStatusProvider.IConnectionStatusObserver, Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForgetFactory f52184a;

    /* renamed from: b, reason: collision with root package name */
    public final LazyEvaluator f52185b;

    /* renamed from: d, reason: collision with root package name */
    public IConnectionStatusProvider f52187d;

    /* renamed from: e, reason: collision with root package name */
    public HubAdapter f52188e;

    /* renamed from: f, reason: collision with root package name */
    public SentryAndroidOptions f52189f;

    /* renamed from: g, reason: collision with root package name */
    public SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForget f52190g;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f52186c = new AtomicBoolean(false);

    /* renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f52191h = new AtomicBoolean(false);

    /* renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f52192i = new AtomicBoolean(false);

    public SendCachedEnvelopeIntegration(SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForgetFactory sendFireAndForgetFactory, LazyEvaluator lazyEvaluator) {
        this.f52184a = sendFireAndForgetFactory;
        this.f52185b = lazyEvaluator;
    }

    @Override // io.sentry.IConnectionStatusProvider.IConnectionStatusObserver
    public final void a(IConnectionStatusProvider.ConnectionStatus connectionStatus) {
        SentryAndroidOptions sentryAndroidOptions;
        HubAdapter hubAdapter = this.f52188e;
        if (hubAdapter == null || (sentryAndroidOptions = this.f52189f) == null) {
            return;
        }
        b(hubAdapter, sentryAndroidOptions);
    }

    public final synchronized void b(HubAdapter hubAdapter, SentryAndroidOptions sentryAndroidOptions) {
        try {
            try {
                Future futureSubmit = sentryAndroidOptions.getExecutorService().submit(new m(this, sentryAndroidOptions, hubAdapter, 0));
                if (((Boolean) this.f52185b.a()).booleanValue() && this.f52186c.compareAndSet(false, true)) {
                    sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "Startup Crash marker exists, blocking flush.", new Object[0]);
                    try {
                        futureSubmit.get(sentryAndroidOptions.getStartupCrashFlushTimeoutMillis(), TimeUnit.MILLISECONDS);
                    } catch (TimeoutException unused) {
                        sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "Synchronous send timed out, continuing in the background.", new Object[0]);
                    }
                }
                sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "SendCachedEnvelopeIntegration installed.", new Object[0]);
            } catch (Throwable th) {
                throw th;
            }
        } catch (RejectedExecutionException e2) {
            sentryAndroidOptions.getLogger().b(SentryLevel.ERROR, "Failed to call the executor. Cached events will not be sent. Did you call Sentry.close()?", e2);
        } catch (Throwable th2) {
            sentryAndroidOptions.getLogger().b(SentryLevel.ERROR, "Failed to call the executor. Cached events will not be sent", th2);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f52192i.set(true);
        IConnectionStatusProvider iConnectionStatusProvider = this.f52187d;
        if (iConnectionStatusProvider != null) {
            iConnectionStatusProvider.d(this);
        }
    }

    @Override // io.sentry.Integration
    public final void l(SentryOptions sentryOptions) {
        HubAdapter hubAdapter = HubAdapter.f51658a;
        this.f52188e = hubAdapter;
        SentryAndroidOptions sentryAndroidOptions = sentryOptions instanceof SentryAndroidOptions ? (SentryAndroidOptions) sentryOptions : null;
        Objects.b(sentryAndroidOptions, "SentryAndroidOptions is required");
        this.f52189f = sentryAndroidOptions;
        String cacheDirPath = sentryOptions.getCacheDirPath();
        ILogger logger = sentryOptions.getLogger();
        this.f52184a.getClass();
        if (!SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForgetFactory.b(cacheDirPath, logger)) {
            sentryOptions.getLogger().c(SentryLevel.ERROR, "No cache dir path is defined in options.", new Object[0]);
        } else {
            IntegrationUtils.a("SendCachedEnvelope");
            b(hubAdapter, this.f52189f);
        }
    }
}
