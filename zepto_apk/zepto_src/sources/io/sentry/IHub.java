package io.sentry;

import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import io.sentry.transport.RateLimiter;

/* loaded from: classes.dex */
public interface IHub {
    SentryId A(SentryEvent sentryEvent, Hint hint);

    ITransaction B(TransactionContext transactionContext, TransactionOptions transactionOptions);

    Boolean C();

    default SentryId D(Throwable th) {
        return E(th, new Hint());
    }

    SentryId E(Throwable th, Hint hint);

    SentryId F(SentryEnvelope sentryEnvelope, Hint hint);

    SentryId G(SentryTransaction sentryTransaction, TraceContext traceContext, Hint hint, ProfilingTraceData profilingTraceData);

    void b(Breadcrumb breadcrumb, Hint hint);

    /* renamed from: clone */
    IHub m68clone();

    boolean i();

    boolean isEnabled();

    ITransaction j();

    void l();

    void n(boolean z);

    RateLimiter o();

    void p();

    void v(long j2);

    void w(ScopeCallback scopeCallback);

    SentryId x(SentryReplayEvent sentryReplayEvent, Hint hint);

    SentryOptions y();

    default SentryId z(SentryEnvelope sentryEnvelope) {
        return F(sentryEnvelope, new Hint());
    }
}
