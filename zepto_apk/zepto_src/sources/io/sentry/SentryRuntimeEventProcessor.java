package io.sentry;

import io.sentry.protocol.Contexts;
import io.sentry.protocol.SentryRuntime;
import io.sentry.protocol.SentryTransaction;

/* loaded from: classes3.dex */
final class SentryRuntimeEventProcessor implements EventProcessor {

    /* renamed from: a, reason: collision with root package name */
    public final String f51870a;

    /* renamed from: b, reason: collision with root package name */
    public final String f51871b;

    public SentryRuntimeEventProcessor() {
        String property = System.getProperty("java.version");
        String property2 = System.getProperty("java.vendor");
        this.f51870a = property;
        this.f51871b = property2;
    }

    @Override // io.sentry.EventProcessor
    public final SentryEvent b(SentryEvent sentryEvent, Hint hint) {
        d(sentryEvent);
        return sentryEvent;
    }

    @Override // io.sentry.EventProcessor
    public final SentryTransaction c(SentryTransaction sentryTransaction, Hint hint) {
        d(sentryTransaction);
        return sentryTransaction;
    }

    public final void d(SentryBaseEvent sentryBaseEvent) {
        Contexts contexts = sentryBaseEvent.f51792b;
        if (((SentryRuntime) contexts.d(SentryRuntime.class, "runtime")) == null) {
            contexts.put("runtime", new SentryRuntime());
        }
        SentryRuntime sentryRuntime = (SentryRuntime) contexts.d(SentryRuntime.class, "runtime");
        if (sentryRuntime != null && sentryRuntime.f52912a == null && sentryRuntime.f52913b == null) {
            sentryRuntime.f52912a = this.f51871b;
            sentryRuntime.f52913b = this.f51870a;
        }
    }
}
