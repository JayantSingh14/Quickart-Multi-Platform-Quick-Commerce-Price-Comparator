package io.sentry;

import io.sentry.transport.AsyncHttpTransport;
import io.sentry.transport.ITransport;
import io.sentry.transport.RateLimiter;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class AsyncHttpTransportFactory implements ITransportFactory {
    @Override // io.sentry.ITransportFactory
    public final ITransport a(SentryOptions sentryOptions, RequestDetails requestDetails) {
        return new AsyncHttpTransport(sentryOptions, new RateLimiter(sentryOptions), sentryOptions.getTransportGate(), requestDetails);
    }
}
