package io.sentry.android.core;

import io.sentry.DataCategory;
import io.sentry.HubAdapter;
import io.sentry.IConnectionStatusProvider;
import io.sentry.SendCachedEnvelopeFireAndForgetIntegration;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.transport.RateLimiter;

/* loaded from: classes.dex */
public final /* synthetic */ class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f52354a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f52355b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SentryOptions f52356c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f52357d;

    public /* synthetic */ m(Object obj, SentryOptions sentryOptions, Object obj2, int i2) {
        this.f52354a = i2;
        this.f52355b = obj;
        this.f52356c = sentryOptions;
        this.f52357d = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f52354a) {
            case 0:
                SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) this.f52356c;
                SendCachedEnvelopeIntegration sendCachedEnvelopeIntegration = (SendCachedEnvelopeIntegration) this.f52355b;
                sendCachedEnvelopeIntegration.getClass();
                try {
                    if (sendCachedEnvelopeIntegration.f52192i.get()) {
                        sentryAndroidOptions.getLogger().c(SentryLevel.INFO, "SendCachedEnvelopeIntegration, not trying to send after closing.", new Object[0]);
                        return;
                    }
                    boolean andSet = sendCachedEnvelopeIntegration.f52191h.getAndSet(true);
                    HubAdapter hubAdapter = (HubAdapter) this.f52357d;
                    if (!andSet) {
                        IConnectionStatusProvider connectionStatusProvider = sentryAndroidOptions.getConnectionStatusProvider();
                        sendCachedEnvelopeIntegration.f52187d = connectionStatusProvider;
                        connectionStatusProvider.c(sendCachedEnvelopeIntegration);
                        sendCachedEnvelopeIntegration.f52190g = sendCachedEnvelopeIntegration.f52184a.a(hubAdapter, sentryAndroidOptions);
                    }
                    IConnectionStatusProvider iConnectionStatusProvider = sendCachedEnvelopeIntegration.f52187d;
                    if (iConnectionStatusProvider != null && iConnectionStatusProvider.b() == IConnectionStatusProvider.ConnectionStatus.DISCONNECTED) {
                        sentryAndroidOptions.getLogger().c(SentryLevel.INFO, "SendCachedEnvelopeIntegration, no connection.", new Object[0]);
                        return;
                    }
                    RateLimiter rateLimiterO = hubAdapter.o();
                    if (rateLimiterO != null && rateLimiterO.b(DataCategory.All)) {
                        sentryAndroidOptions.getLogger().c(SentryLevel.INFO, "SendCachedEnvelopeIntegration, rate limiting active.", new Object[0]);
                        return;
                    }
                    SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForget sendFireAndForget = sendCachedEnvelopeIntegration.f52190g;
                    if (sendFireAndForget == null) {
                        sentryAndroidOptions.getLogger().c(SentryLevel.ERROR, "SendCachedEnvelopeIntegration factory is null.", new Object[0]);
                        return;
                    } else {
                        sendFireAndForget.c1();
                        return;
                    }
                } catch (Throwable th) {
                    sentryAndroidOptions.getLogger().b(SentryLevel.ERROR, "Failed trying to send cached events.", th);
                    return;
                }
            default:
                EnvelopeFileObserverIntegration envelopeFileObserverIntegration = (EnvelopeFileObserverIntegration) this.f52355b;
                SentryOptions sentryOptions = this.f52356c;
                String str = (String) this.f52357d;
                synchronized (envelopeFileObserverIntegration.f52141d) {
                    try {
                        if (!envelopeFileObserverIntegration.f52140c) {
                            envelopeFileObserverIntegration.b(sentryOptions, str);
                        }
                    } finally {
                    }
                }
                return;
        }
    }
}
