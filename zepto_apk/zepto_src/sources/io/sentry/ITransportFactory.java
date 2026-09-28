package io.sentry;

import io.sentry.transport.ITransport;

/* loaded from: classes.dex */
public interface ITransportFactory {
    ITransport a(SentryOptions sentryOptions, RequestDetails requestDetails);
}
