package io.sentry;

import io.sentry.transport.ITransport;
import io.sentry.transport.NoOpTransport;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class NoOpTransportFactory implements ITransportFactory {

    /* renamed from: a, reason: collision with root package name */
    public static final NoOpTransportFactory f51717a = new NoOpTransportFactory();

    @Override // io.sentry.ITransportFactory
    public final ITransport a(SentryOptions sentryOptions, RequestDetails requestDetails) {
        return NoOpTransport.f53098a;
    }
}
