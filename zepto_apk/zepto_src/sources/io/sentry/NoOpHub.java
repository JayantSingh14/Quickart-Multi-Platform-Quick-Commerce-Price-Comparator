package io.sentry;

import io.sentry.metrics.NoopMetricsAggregator;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import io.sentry.transport.RateLimiter;

/* loaded from: classes.dex */
public final class NoOpHub implements IHub {

    /* renamed from: b, reason: collision with root package name */
    public static final NoOpHub f51705b = new NoOpHub();

    /* renamed from: a, reason: collision with root package name */
    public final SentryOptions f51706a = SentryOptions.empty();

    public NoOpHub() {
        NoopMetricsAggregator noopMetricsAggregator = NoopMetricsAggregator.f52786a;
    }

    @Override // io.sentry.IHub
    public final SentryId A(SentryEvent sentryEvent, Hint hint) {
        return SentryId.f52907b;
    }

    @Override // io.sentry.IHub
    public final ITransaction B(TransactionContext transactionContext, TransactionOptions transactionOptions) {
        return NoOpTransaction.f51714a;
    }

    @Override // io.sentry.IHub
    public final Boolean C() {
        return null;
    }

    @Override // io.sentry.IHub
    public final SentryId E(Throwable th, Hint hint) {
        return SentryId.f52907b;
    }

    @Override // io.sentry.IHub
    public final SentryId F(SentryEnvelope sentryEnvelope, Hint hint) {
        return SentryId.f52907b;
    }

    @Override // io.sentry.IHub
    public final SentryId G(SentryTransaction sentryTransaction, TraceContext traceContext, Hint hint, ProfilingTraceData profilingTraceData) {
        return SentryId.f52907b;
    }

    @Override // io.sentry.IHub
    public final void b(Breadcrumb breadcrumb, Hint hint) {
    }

    @Override // io.sentry.IHub
    /* renamed from: clone */
    public final IHub m68clone() {
        return f51705b;
    }

    @Override // io.sentry.IHub
    public final boolean i() {
        return true;
    }

    @Override // io.sentry.IHub
    public final boolean isEnabled() {
        return false;
    }

    @Override // io.sentry.IHub
    public final ITransaction j() {
        return null;
    }

    @Override // io.sentry.IHub
    public final void l() {
    }

    @Override // io.sentry.IHub
    public final void n(boolean z) {
    }

    @Override // io.sentry.IHub
    public final RateLimiter o() {
        return null;
    }

    @Override // io.sentry.IHub
    public final void p() {
    }

    @Override // io.sentry.IHub
    public final void v(long j2) {
    }

    @Override // io.sentry.IHub
    public final void w(ScopeCallback scopeCallback) {
    }

    @Override // io.sentry.IHub
    public final SentryId x(SentryReplayEvent sentryReplayEvent, Hint hint) {
        return SentryId.f52907b;
    }

    @Override // io.sentry.IHub
    public final SentryOptions y() {
        return this.f51706a;
    }

    /* renamed from: clone, reason: collision with other method in class */
    public final Object m69clone() {
        return f51705b;
    }
}
