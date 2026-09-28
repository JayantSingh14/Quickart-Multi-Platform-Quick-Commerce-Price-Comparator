package io.sentry;

import io.sentry.protocol.Contexts;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.TransactionNameSource;
import io.sentry.protocol.User;
import io.sentry.util.SampleRateUtils;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Experimental
/* loaded from: classes3.dex */
public final class Baggage {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f51551a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f51552b;

    /* renamed from: c, reason: collision with root package name */
    public final ILogger f51553c;

    @ApiStatus.Internal
    public static final class DSCKeys {

        /* renamed from: a, reason: collision with root package name */
        public static final List f51554a = Arrays.asList("sentry-trace_id", "sentry-public_key", "sentry-release", "sentry-user_id", "sentry-environment", "sentry-user_segment", "sentry-transaction", "sentry-sample_rate", "sentry-sampled", "sentry-replay_id");
    }

    public Baggage(ILogger iLogger) {
        this(new HashMap(), true, iLogger);
    }

    public static Baggage a(SentryEvent sentryEvent, SentryOptions sentryOptions) {
        Baggage baggage = new Baggage(sentryOptions.getLogger());
        Contexts contexts = sentryEvent.f51792b;
        SpanContext spanContextA = contexts.a();
        baggage.d("sentry-trace_id", spanContextA != null ? spanContextA.f51921a.toString() : null);
        baggage.d("sentry-public_key", sentryOptions.retrieveParsedDsn().f51611b);
        baggage.d("sentry-release", sentryEvent.f51796f);
        baggage.d("sentry-environment", sentryEvent.f51797g);
        User user = sentryEvent.f51799i;
        baggage.d("sentry-user_segment", user != null ? c(user) : null);
        baggage.d("sentry-transaction", sentryEvent.v);
        baggage.d("sentry-sample_rate", null);
        baggage.d("sentry-sampled", null);
        Object obj = contexts.get("replay_id");
        if (obj != null && !obj.toString().equals(SentryId.f52907b.toString())) {
            baggage.d("sentry-replay_id", obj.toString());
            contexts.remove("replay_id");
        }
        baggage.f51552b = false;
        return baggage;
    }

    public static String c(User user) {
        String str = user.f52962d;
        if (str != null) {
            return str;
        }
        ConcurrentHashMap concurrentHashMap = user.f52966h;
        if (concurrentHashMap != null) {
            return (String) concurrentHashMap.get("segment");
        }
        return null;
    }

    public final String b(String str) {
        return (String) this.f51551a.get(str);
    }

    public final void d(String str, String str2) {
        if (this.f51552b) {
            this.f51551a.put(str, str2);
        }
    }

    public final void e(IScope iScope, SentryOptions sentryOptions) {
        PropagationContext propagationContextA = iScope.A();
        User userT = iScope.t();
        SentryId sentryIdZ = iScope.z();
        d("sentry-trace_id", propagationContextA.f51748a.toString());
        d("sentry-public_key", sentryOptions.retrieveParsedDsn().f51611b);
        d("sentry-release", sentryOptions.getRelease());
        d("sentry-environment", sentryOptions.getEnvironment());
        if (!SentryId.f52907b.equals(sentryIdZ)) {
            d("sentry-replay_id", sentryIdZ.toString());
        }
        d("sentry-user_segment", userT != null ? c(userT) : null);
        d("sentry-transaction", null);
        d("sentry-sample_rate", null);
        d("sentry-sampled", null);
    }

    public final void f(SentryTracer sentryTracer, User user, SentryId sentryId, SentryOptions sentryOptions, TracesSamplingDecision tracesSamplingDecision) {
        d("sentry-trace_id", sentryTracer.f51876b.f51911c.f51921a.toString());
        d("sentry-public_key", sentryOptions.retrieveParsedDsn().f51611b);
        d("sentry-release", sentryOptions.getRelease());
        d("sentry-environment", sentryOptions.getEnvironment());
        d("sentry-user_segment", user != null ? c(user) : null);
        TransactionNameSource transactionNameSource = sentryTracer.n;
        d("sentry-transaction", (transactionNameSource == null || TransactionNameSource.URL.equals(transactionNameSource)) ? null : sentryTracer.f51879e);
        if (sentryId != null && !SentryId.f52907b.equals(sentryId)) {
            d("sentry-replay_id", sentryId.toString());
        }
        Double d2 = tracesSamplingDecision == null ? null : tracesSamplingDecision.f51959b;
        d("sentry-sample_rate", !SampleRateUtils.a(false, d2) ? null : new DecimalFormat("#.################", DecimalFormatSymbols.getInstance(Locale.ROOT)).format(d2));
        Boolean bool = tracesSamplingDecision == null ? null : tracesSamplingDecision.f51958a;
        d("sentry-sampled", bool != null ? bool.toString() : null);
    }

    public final TraceContext g() {
        String strB = b("sentry-trace_id");
        String strB2 = b("sentry-replay_id");
        String strB3 = b("sentry-public_key");
        if (strB == null || strB3 == null) {
            return null;
        }
        TraceContext traceContext = new TraceContext(new SentryId(strB), strB3, b("sentry-release"), b("sentry-environment"), b("sentry-user_id"), b("sentry-user_segment"), b("sentry-transaction"), b("sentry-sample_rate"), b("sentry-sampled"), strB2 != null ? new SentryId(strB2) : null);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Map.Entry entry : this.f51551a.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (!DSCKeys.f51554a.contains(str) && str2 != null) {
                concurrentHashMap.put(str.replaceFirst("sentry-", ""), str2);
            }
        }
        traceContext.f51954k = concurrentHashMap;
        return traceContext;
    }

    public Baggage(Baggage baggage) {
        this(baggage.f51551a, baggage.f51552b, baggage.f51553c);
    }

    public Baggage(HashMap map, boolean z, ILogger iLogger) {
        this.f51551a = map;
        this.f51553c = iLogger;
        this.f51552b = z;
    }
}
