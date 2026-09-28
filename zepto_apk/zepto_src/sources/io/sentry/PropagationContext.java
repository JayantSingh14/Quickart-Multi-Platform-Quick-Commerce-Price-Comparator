package io.sentry;

import io.sentry.protocol.SentryId;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public final class PropagationContext {

    /* renamed from: a, reason: collision with root package name */
    public final SentryId f51748a;

    /* renamed from: b, reason: collision with root package name */
    public final SpanId f51749b;

    /* renamed from: c, reason: collision with root package name */
    public Baggage f51750c;

    public PropagationContext() {
        this(new SentryId(), new SpanId(), null);
    }

    public PropagationContext(SentryId sentryId, SpanId spanId, Baggage baggage) {
        this.f51748a = sentryId;
        this.f51749b = spanId;
        this.f51750c = baggage;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public PropagationContext(PropagationContext propagationContext) {
        SentryId sentryId = propagationContext.f51748a;
        SpanId spanId = propagationContext.f51749b;
        Baggage baggage = propagationContext.f51750c;
        this(sentryId, spanId, baggage != null ? new Baggage(baggage) : null);
    }
}
