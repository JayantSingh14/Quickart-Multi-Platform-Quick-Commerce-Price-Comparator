package io.sentry;

import io.sentry.util.Objects;
import io.sentry.util.SentryRandom;

/* loaded from: classes.dex */
final class TracesSampler {

    /* renamed from: a, reason: collision with root package name */
    public final SentryOptions f51957a;

    public TracesSampler(SentryOptions sentryOptions) {
        Objects.b(sentryOptions, "options are required");
        this.f51957a = sentryOptions;
    }

    public final TracesSamplingDecision a(SamplingContext samplingContext) {
        Double dA;
        Double dA2;
        TracesSamplingDecision tracesSamplingDecision = samplingContext.a().f51924d;
        if (tracesSamplingDecision != null) {
            return tracesSamplingDecision;
        }
        SentryOptions sentryOptions = this.f51957a;
        if (sentryOptions.getProfilesSampler() != null) {
            try {
                dA = sentryOptions.getProfilesSampler().a();
            } catch (Throwable th) {
                sentryOptions.getLogger().b(SentryLevel.ERROR, "Error in the 'ProfilesSamplerCallback' callback.", th);
            }
        } else {
            dA = null;
        }
        if (dA == null) {
            dA = sentryOptions.getProfilesSampleRate();
        }
        Boolean boolValueOf = Boolean.valueOf(dA != null && b(dA));
        if (sentryOptions.getTracesSampler() != null) {
            try {
                dA2 = sentryOptions.getTracesSampler().a();
            } catch (Throwable th2) {
                sentryOptions.getLogger().b(SentryLevel.ERROR, "Error in the 'TracesSamplerCallback' callback.", th2);
                dA2 = null;
            }
            if (dA2 != null) {
                return new TracesSamplingDecision(Boolean.valueOf(b(dA2)), dA2, boolValueOf, dA);
            }
        }
        TracesSamplingDecision tracesSamplingDecisionC = samplingContext.a().c();
        if (tracesSamplingDecisionC != null) {
            return tracesSamplingDecisionC;
        }
        Double tracesSampleRate = sentryOptions.getTracesSampleRate();
        Double dValueOf = Boolean.TRUE.equals(sentryOptions.getEnableTracing()) ? Double.valueOf(1.0d) : null;
        if (tracesSampleRate == null) {
            tracesSampleRate = dValueOf;
        }
        Double dValueOf2 = tracesSampleRate == null ? null : Double.valueOf(tracesSampleRate.doubleValue() / Math.pow(2.0d, sentryOptions.getBackpressureMonitor().a()));
        if (dValueOf2 != null) {
            return new TracesSamplingDecision(Boolean.valueOf(b(dValueOf2)), dValueOf2, boolValueOf, dA);
        }
        Boolean bool = Boolean.FALSE;
        return new TracesSamplingDecision(bool, null, bool, null);
    }

    public final boolean b(Double d2) {
        return d2.doubleValue() >= SentryRandom.a().b();
    }
}
