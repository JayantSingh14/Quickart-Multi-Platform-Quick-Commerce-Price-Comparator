package io.sentry;

import io.sentry.Scope;
import io.sentry.Stack;
import io.sentry.clientreport.DiscardReason;
import io.sentry.clientreport.IClientReportRecorder;
import io.sentry.hints.SessionEndHint;
import io.sentry.hints.SessionStartHint;
import io.sentry.metrics.MetricsApi;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import io.sentry.transport.RateLimiter;
import io.sentry.util.ExceptionUtils;
import io.sentry.util.HintUtils;
import io.sentry.util.Objects;
import io.sentry.util.Pair;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class Hub implements IHub, MetricsApi.IMetricsInterface {

    /* renamed from: a, reason: collision with root package name */
    public final SentryOptions f51652a;

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f51653b;

    /* renamed from: c, reason: collision with root package name */
    public final Stack f51654c;

    /* renamed from: d, reason: collision with root package name */
    public final TracesSampler f51655d;

    /* renamed from: e, reason: collision with root package name */
    public final Map f51656e = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: f, reason: collision with root package name */
    public final TransactionPerformanceCollector f51657f;

    public Hub(SentryOptions sentryOptions, Stack stack) {
        Objects.b(sentryOptions, "SentryOptions is required.");
        if (sentryOptions.getDsn() == null || sentryOptions.getDsn().isEmpty()) {
            throw new IllegalArgumentException("Hub requires a DSN to be instantiated. Considering using the NoOpHub if no DSN is available.");
        }
        this.f51652a = sentryOptions;
        this.f51655d = new TracesSampler(sentryOptions);
        this.f51654c = stack;
        SentryId sentryId = SentryId.f52907b;
        this.f51657f = sentryOptions.getTransactionPerformanceCollector();
        this.f51653b = true;
    }

    @Override // io.sentry.IHub
    public final SentryId A(SentryEvent sentryEvent, Hint hint) {
        SentryId sentryId = SentryId.f52907b;
        if (!this.f51653b) {
            this.f51652a.getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'captureEvent' call is a no-op.", new Object[0]);
            return sentryId;
        }
        try {
            a(sentryEvent);
            Stack.StackItem stackItemA = this.f51654c.a();
            return stackItemA.f51940b.e(sentryEvent, stackItemA.f51941c, hint);
        } catch (Throwable th) {
            this.f51652a.getLogger().b(SentryLevel.ERROR, "Error while capturing event with id: " + sentryEvent.f51791a, th);
            return sentryId;
        }
    }

    @Override // io.sentry.IHub
    public final ITransaction B(TransactionContext transactionContext, TransactionOptions transactionOptions) {
        boolean z = this.f51653b;
        NoOpTransaction noOpTransaction = NoOpTransaction.f51714a;
        if (!z) {
            this.f51652a.getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'startTransaction' returns a no-op.", new Object[0]);
            return noOpTransaction;
        }
        if (!this.f51652a.getInstrumenter().equals(transactionContext.b())) {
            this.f51652a.getLogger().c(SentryLevel.DEBUG, "Returning no-op for instrumenter %s as the SDK has been configured to use instrumenter %s", transactionContext.b(), this.f51652a.getInstrumenter());
            return noOpTransaction;
        }
        if (!this.f51652a.isTracingEnabled()) {
            this.f51652a.getLogger().c(SentryLevel.INFO, "Tracing is disabled and this 'startTransaction' returns a no-op.", new Object[0]);
            return noOpTransaction;
        }
        TracesSamplingDecision tracesSamplingDecisionA = this.f51655d.a(new SamplingContext(transactionContext));
        transactionContext.f51924d = tracesSamplingDecisionA;
        SentryTracer sentryTracer = new SentryTracer(transactionContext, this, transactionOptions, this.f51657f);
        if (tracesSamplingDecisionA.d().booleanValue() && tracesSamplingDecisionA.b().booleanValue()) {
            ITransactionProfiler transactionProfiler = this.f51652a.getTransactionProfiler();
            if (!transactionProfiler.isRunning()) {
                transactionProfiler.start();
                transactionProfiler.a(sentryTracer);
                return sentryTracer;
            }
            if (transactionOptions.b()) {
                transactionProfiler.a(sentryTracer);
            }
        }
        return sentryTracer;
    }

    @Override // io.sentry.IHub
    public final Boolean C() {
        SentryCrashLastRunState sentryCrashLastRunState = SentryCrashLastRunState.f51808d;
        String cacheDirPath = this.f51652a.getCacheDirPath();
        boolean zIsEnableAutoSessionTracking = this.f51652a.isEnableAutoSessionTracking();
        synchronized (sentryCrashLastRunState.f51811c) {
            try {
                if (sentryCrashLastRunState.f51809a) {
                    return sentryCrashLastRunState.f51810b;
                }
                if (cacheDirPath == null) {
                    return null;
                }
                boolean z = true;
                sentryCrashLastRunState.f51809a = true;
                File file = new File(cacheDirPath, "last_crash");
                File file2 = new File(cacheDirPath, ".sentry-native/last_crash");
                if (!file.exists()) {
                    if (!file2.exists()) {
                        z = false;
                    } else if (!zIsEnableAutoSessionTracking) {
                        file2.delete();
                    }
                    Boolean boolValueOf = Boolean.valueOf(z);
                    sentryCrashLastRunState.f51810b = boolValueOf;
                    return boolValueOf;
                }
                file.delete();
                Boolean boolValueOf2 = Boolean.valueOf(z);
                sentryCrashLastRunState.f51810b = boolValueOf2;
                return boolValueOf2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.sentry.IHub
    public final SentryId E(Throwable th, Hint hint) {
        SentryId sentryId = SentryId.f52907b;
        if (!this.f51653b) {
            this.f51652a.getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'captureException' call is a no-op.", new Object[0]);
            return sentryId;
        }
        try {
            Stack.StackItem stackItemA = this.f51654c.a();
            SentryEvent sentryEvent = new SentryEvent(th);
            a(sentryEvent);
            return stackItemA.f51940b.e(sentryEvent, stackItemA.f51941c, hint);
        } catch (Throwable th2) {
            this.f51652a.getLogger().b(SentryLevel.ERROR, "Error while capturing exception: " + th.getMessage(), th2);
            return sentryId;
        }
    }

    @Override // io.sentry.IHub
    public final SentryId F(SentryEnvelope sentryEnvelope, Hint hint) {
        SentryId sentryIdD;
        SentryId sentryId = SentryId.f52907b;
        if (!this.f51653b) {
            this.f51652a.getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'captureEnvelope' call is a no-op.", new Object[0]);
            return sentryId;
        }
        try {
            sentryIdD = this.f51654c.a().f51940b.d(sentryEnvelope, hint);
        } catch (Throwable th) {
            this.f51652a.getLogger().b(SentryLevel.ERROR, "Error while capturing envelope.", th);
        }
        return sentryIdD != null ? sentryIdD : sentryId;
    }

    @Override // io.sentry.IHub
    public final SentryId G(SentryTransaction sentryTransaction, TraceContext traceContext, Hint hint, ProfilingTraceData profilingTraceData) {
        SentryTransaction sentryTransaction2;
        SentryId sentryId = SentryId.f52907b;
        if (!this.f51653b) {
            this.f51652a.getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'captureTransaction' call is a no-op.", new Object[0]);
            return sentryId;
        }
        if (sentryTransaction.r == null) {
            this.f51652a.getLogger().c(SentryLevel.WARNING, "Transaction: %s is not finished and this 'captureTransaction' call is a no-op.", sentryTransaction.f51791a);
            return sentryId;
        }
        Boolean bool = Boolean.TRUE;
        SpanContext spanContextA = sentryTransaction.f51792b.a();
        TracesSamplingDecision tracesSamplingDecision = spanContextA == null ? null : spanContextA.f51924d;
        if (!bool.equals(Boolean.valueOf(tracesSamplingDecision != null ? tracesSamplingDecision.d().booleanValue() : false))) {
            this.f51652a.getLogger().c(SentryLevel.DEBUG, "Transaction %s was dropped due to sampling decision.", sentryTransaction.f51791a);
            if (this.f51652a.getBackpressureMonitor().a() > 0) {
                IClientReportRecorder clientReportRecorder = this.f51652a.getClientReportRecorder();
                DiscardReason discardReason = DiscardReason.BACKPRESSURE;
                clientReportRecorder.a(discardReason, DataCategory.Transaction);
                this.f51652a.getClientReportRecorder().c(discardReason, DataCategory.Span, sentryTransaction.s.size() + 1);
                return sentryId;
            }
            IClientReportRecorder clientReportRecorder2 = this.f51652a.getClientReportRecorder();
            DiscardReason discardReason2 = DiscardReason.SAMPLE_RATE;
            clientReportRecorder2.a(discardReason2, DataCategory.Transaction);
            this.f51652a.getClientReportRecorder().c(discardReason2, DataCategory.Span, sentryTransaction.s.size() + 1);
            return sentryId;
        }
        try {
            Stack.StackItem stackItemA = this.f51654c.a();
            sentryTransaction2 = sentryTransaction;
            try {
                return stackItemA.f51940b.h(sentryTransaction2, traceContext, stackItemA.f51941c, hint, profilingTraceData);
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                this.f51652a.getLogger().b(SentryLevel.ERROR, "Error while capturing transaction with id: " + sentryTransaction2.f51791a, th2);
                return sentryId;
            }
        } catch (Throwable th3) {
            th = th3;
            sentryTransaction2 = sentryTransaction;
        }
    }

    public final void a(SentryEvent sentryEvent) {
        ISpan iSpan;
        if (!this.f51652a.isTracingEnabled() || sentryEvent.a() == null) {
            return;
        }
        Pair pair = (Pair) this.f51656e.get(ExceptionUtils.a(sentryEvent.a()));
        if (pair != null) {
            WeakReference weakReference = (WeakReference) pair.a();
            Contexts contexts = sentryEvent.f51792b;
            if (contexts.a() == null && (iSpan = (ISpan) weakReference.get()) != null) {
                contexts.c(iSpan.o());
            }
            String str = (String) pair.b();
            if (sentryEvent.v != null || str == null) {
                return;
            }
            sentryEvent.v = str;
        }
    }

    @Override // io.sentry.IHub
    public final void b(Breadcrumb breadcrumb, Hint hint) {
        if (this.f51653b) {
            this.f51654c.a().f51941c.b(breadcrumb, hint);
        } else {
            this.f51652a.getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'addBreadcrumb' call is a no-op.", new Object[0]);
        }
    }

    @Override // io.sentry.IHub
    public final boolean i() {
        return this.f51654c.a().f51940b.f51805b.i();
    }

    @Override // io.sentry.IHub
    public final boolean isEnabled() {
        return this.f51653b;
    }

    @Override // io.sentry.IHub
    public final ITransaction j() {
        if (this.f51653b) {
            return this.f51654c.a().f51941c.j();
        }
        this.f51652a.getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'getTransaction' call is a no-op.", new Object[0]);
        return null;
    }

    @Override // io.sentry.IHub
    public final void l() {
        if (!this.f51653b) {
            this.f51652a.getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'endSession' call is a no-op.", new Object[0]);
            return;
        }
        Stack.StackItem stackItemA = this.f51654c.a();
        Session sessionL = stackItemA.f51941c.l();
        if (sessionL != null) {
            stackItemA.f51940b.g(sessionL, HintUtils.a(new SessionEndHint()));
        }
    }

    @Override // io.sentry.IHub
    public final void n(boolean z) {
        if (!this.f51653b) {
            this.f51652a.getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'close' call is a no-op.", new Object[0]);
            return;
        }
        try {
            for (Integration integration : this.f51652a.getIntegrations()) {
                if (integration instanceof Closeable) {
                    try {
                        ((Closeable) integration).close();
                    } catch (IOException e2) {
                        this.f51652a.getLogger().c(SentryLevel.WARNING, "Failed to close the integration {}.", integration, e2);
                    }
                }
            }
            if (this.f51653b) {
                try {
                    this.f51654c.a().f51941c.clear();
                } catch (Throwable th) {
                    this.f51652a.getLogger().b(SentryLevel.ERROR, "Error in the 'configureScope' callback.", th);
                }
            } else {
                this.f51652a.getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'configureScope' call is a no-op.", new Object[0]);
            }
            this.f51652a.getTransactionProfiler().close();
            this.f51652a.getTransactionPerformanceCollector().close();
            ISentryExecutorService executorService = this.f51652a.getExecutorService();
            if (z) {
                executorService.submit(new in.juspay.hypernfc.b(18, this, executorService));
            } else {
                executorService.b(this.f51652a.getShutdownTimeoutMillis());
            }
            this.f51654c.a().f51940b.i(z);
        } catch (Throwable th2) {
            this.f51652a.getLogger().b(SentryLevel.ERROR, "Error while closing the Hub.", th2);
        }
        this.f51653b = false;
    }

    @Override // io.sentry.IHub
    public final RateLimiter o() {
        return this.f51654c.a().f51940b.f51805b.o();
    }

    @Override // io.sentry.IHub
    public final void p() {
        if (!this.f51653b) {
            this.f51652a.getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'startSession' call is a no-op.", new Object[0]);
            return;
        }
        Stack.StackItem stackItemA = this.f51654c.a();
        Scope.SessionPair sessionPairP = stackItemA.f51941c.p();
        if (sessionPairP == null) {
            this.f51652a.getLogger().c(SentryLevel.WARNING, "Session could not be started.", new Object[0]);
            return;
        }
        if (sessionPairP.f51772a != null) {
            stackItemA.f51940b.g(sessionPairP.f51772a, HintUtils.a(new SessionEndHint()));
        }
        stackItemA.f51940b.g(sessionPairP.f51773b, HintUtils.a(new SessionStartHint()));
    }

    @Override // io.sentry.IHub
    public final void v(long j2) {
        if (!this.f51653b) {
            this.f51652a.getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'flush' call is a no-op.", new Object[0]);
            return;
        }
        try {
            this.f51654c.a().f51940b.j(j2);
        } catch (Throwable th) {
            this.f51652a.getLogger().b(SentryLevel.ERROR, "Error in the 'client.flush'.", th);
        }
    }

    @Override // io.sentry.IHub
    public final void w(ScopeCallback scopeCallback) {
        if (!this.f51653b) {
            this.f51652a.getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'configureScope' call is a no-op.", new Object[0]);
            return;
        }
        try {
            scopeCallback.h(this.f51654c.a().f51941c);
        } catch (Throwable th) {
            this.f51652a.getLogger().b(SentryLevel.ERROR, "Error in the 'configureScope' callback.", th);
        }
    }

    @Override // io.sentry.IHub
    public final SentryId x(SentryReplayEvent sentryReplayEvent, Hint hint) {
        SentryId sentryId = SentryId.f52907b;
        if (!this.f51653b) {
            this.f51652a.getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'captureReplay' call is a no-op.", new Object[0]);
            return sentryId;
        }
        try {
            Stack.StackItem stackItemA = this.f51654c.a();
            return stackItemA.f51940b.f(sentryReplayEvent, stackItemA.f51941c, hint);
        } catch (Throwable th) {
            this.f51652a.getLogger().b(SentryLevel.ERROR, "Error while capturing replay", th);
            return sentryId;
        }
    }

    @Override // io.sentry.IHub
    public final SentryOptions y() {
        return this.f51654c.a().f51939a;
    }

    @Override // io.sentry.IHub
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final IHub m67clone() {
        if (!this.f51653b) {
            this.f51652a.getLogger().c(SentryLevel.WARNING, "Disabled Hub cloned.", new Object[0]);
        }
        SentryOptions sentryOptions = this.f51652a;
        Stack stack = this.f51654c;
        Stack stack2 = new Stack(stack.f51938b, new Stack.StackItem((Stack.StackItem) stack.f51937a.getLast()));
        Iterator itDescendingIterator = stack.f51937a.descendingIterator();
        if (itDescendingIterator.hasNext()) {
            itDescendingIterator.next();
        }
        while (itDescendingIterator.hasNext()) {
            stack2.f51937a.push(new Stack.StackItem((Stack.StackItem) itDescendingIterator.next()));
        }
        return new Hub(sentryOptions, stack2);
    }
}
