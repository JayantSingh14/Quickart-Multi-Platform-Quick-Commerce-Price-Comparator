package io.sentry;

import io.sentry.SendCachedEnvelopeFireAndForgetIntegration;
import io.sentry.util.Objects;
import java.io.File;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class SendFireAndForgetEnvelopeSender implements SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForgetFactory {

    /* renamed from: a, reason: collision with root package name */
    public final io.sentry.android.core.f f51775a;

    public SendFireAndForgetEnvelopeSender(io.sentry.android.core.f fVar) {
        this.f51775a = fVar;
    }

    @Override // io.sentry.SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForgetFactory
    public final h a(HubAdapter hubAdapter, SentryOptions sentryOptions) {
        Objects.b(hubAdapter, "Hub is required");
        Objects.b(sentryOptions, "SentryOptions is required");
        String cacheDirPath = this.f51775a.f52253a.getCacheDirPath();
        if (cacheDirPath == null || !SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForgetFactory.b(cacheDirPath, sentryOptions.getLogger())) {
            sentryOptions.getLogger().c(SentryLevel.ERROR, "No cache dir path is defined in options.", new Object[0]);
            return null;
        }
        return new h(sentryOptions.getLogger(), cacheDirPath, new EnvelopeSender(hubAdapter, sentryOptions.getSerializer(), sentryOptions.getLogger(), sentryOptions.getFlushTimeoutMillis(), sentryOptions.getMaxQueueSize()), new File(cacheDirPath));
    }
}
