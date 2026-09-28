package io.sentry;

import io.sentry.SendCachedEnvelopeFireAndForgetIntegration;
import io.sentry.util.Objects;
import java.io.File;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class SendFireAndForgetOutboxSender implements SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForgetFactory {

    /* renamed from: a, reason: collision with root package name */
    public final io.sentry.android.core.f f51776a;

    public SendFireAndForgetOutboxSender(io.sentry.android.core.f fVar) {
        this.f51776a = fVar;
    }

    @Override // io.sentry.SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForgetFactory
    public final h a(HubAdapter hubAdapter, SentryOptions sentryOptions) {
        Objects.b(hubAdapter, "Hub is required");
        Objects.b(sentryOptions, "SentryOptions is required");
        String outboxPath = this.f51776a.f52253a.getOutboxPath();
        if (outboxPath == null || !SendCachedEnvelopeFireAndForgetIntegration.SendFireAndForgetFactory.b(outboxPath, sentryOptions.getLogger())) {
            sentryOptions.getLogger().c(SentryLevel.ERROR, "No outbox dir path is defined in options.", new Object[0]);
            return null;
        }
        return new h(sentryOptions.getLogger(), outboxPath, new OutboxSender(hubAdapter, sentryOptions.getEnvelopeReader(), sentryOptions.getSerializer(), sentryOptions.getLogger(), sentryOptions.getFlushTimeoutMillis(), sentryOptions.getMaxQueueSize()), new File(outboxPath));
    }
}
