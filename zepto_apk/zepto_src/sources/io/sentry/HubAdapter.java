package io.sentry;

import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import io.sentry.transport.RateLimiter;

/* loaded from: classes.dex */
public final class HubAdapter implements IHub {

    /* renamed from: a, reason: collision with root package name */
    public static final HubAdapter f51658a = new HubAdapter();

    @Override // io.sentry.IHub
    public final SentryId A(SentryEvent sentryEvent, Hint hint) {
        return Sentry.d().A(sentryEvent, hint);
    }

    @Override // io.sentry.IHub
    public final ITransaction B(TransactionContext transactionContext, TransactionOptions transactionOptions) {
        return Sentry.d().B(transactionContext, transactionOptions);
    }

    @Override // io.sentry.IHub
    public final Boolean C() {
        return Sentry.d().C();
    }

    @Override // io.sentry.IHub
    public final SentryId E(Throwable th, Hint hint) {
        return Sentry.d().E(th, hint);
    }

    @Override // io.sentry.IHub
    public final SentryId F(SentryEnvelope sentryEnvelope, Hint hint) {
        return Sentry.d().F(sentryEnvelope, hint);
    }

    @Override // io.sentry.IHub
    public final SentryId G(SentryTransaction sentryTransaction, TraceContext traceContext, Hint hint, ProfilingTraceData profilingTraceData) {
        return Sentry.d().G(sentryTransaction, traceContext, hint, profilingTraceData);
    }

    public final void a(Breadcrumb breadcrumb) {
        b(breadcrumb, new Hint());
    }

    @Override // io.sentry.IHub
    public final void b(Breadcrumb breadcrumb, Hint hint) {
        Sentry.d().b(breadcrumb, hint);
    }

    @Override // io.sentry.IHub
    public final boolean i() {
        return Sentry.d().i();
    }

    @Override // io.sentry.IHub
    public final boolean isEnabled() {
        return Sentry.d().isEnabled();
    }

    @Override // io.sentry.IHub
    public final ITransaction j() {
        return Sentry.d().j();
    }

    @Override // io.sentry.IHub
    public final void l() {
        Sentry.d().l();
    }

    @Override // io.sentry.IHub
    public final void n(boolean z) {
        Sentry.b();
    }

    @Override // io.sentry.IHub
    public final RateLimiter o() {
        return Sentry.d().o();
    }

    @Override // io.sentry.IHub
    public final void p() {
        Sentry.d().p();
    }

    @Override // io.sentry.IHub
    public final void v(long j2) {
        Sentry.d().v(j2);
    }

    @Override // io.sentry.IHub
    public final void w(ScopeCallback scopeCallback) {
        Sentry.c(scopeCallback);
    }

    @Override // io.sentry.IHub
    public final SentryId x(SentryReplayEvent sentryReplayEvent, Hint hint) {
        return Sentry.d().x(sentryReplayEvent, hint);
    }

    @Override // io.sentry.IHub
    public final SentryOptions y() {
        return Sentry.d().y();
    }

    @Override // io.sentry.IHub
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final IHub m68clone() {
        return Sentry.d().m68clone();
    }
}
