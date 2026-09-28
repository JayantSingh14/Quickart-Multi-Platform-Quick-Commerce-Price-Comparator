package io.sentry;

import com.google.android.gms.common.Scopes;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.TransactionNameSource;
import io.sentry.util.Objects;

/* loaded from: classes3.dex */
public final class TransactionContext extends SpanContext {
    public static final TransactionNameSource p = TransactionNameSource.CUSTOM;

    /* renamed from: k, reason: collision with root package name */
    public String f51962k;

    /* renamed from: l, reason: collision with root package name */
    public TransactionNameSource f51963l;

    /* renamed from: m, reason: collision with root package name */
    public TracesSamplingDecision f51964m;
    public Baggage n;
    public Instrumenter o;

    public TransactionContext(String str, TransactionNameSource transactionNameSource, String str2, TracesSamplingDecision tracesSamplingDecision) {
        super(new SentryId(), new SpanId(), str2, null, null);
        this.o = Instrumenter.SENTRY;
        Objects.b(str, "name is required");
        this.f51962k = str;
        this.f51963l = transactionNameSource;
        this.f51924d = tracesSamplingDecision;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static io.sentry.TransactionContext a(io.sentry.PropagationContext r8) throws java.lang.NumberFormatException {
        /*
            r8.getClass()
            io.sentry.Baggage r0 = r8.f51750c
            r1 = 0
            if (r0 == 0) goto L39
            r2 = 0
            r0.f51552b = r2
            java.lang.String r3 = "sentry-sample_rate"
            java.lang.String r3 = r0.b(r3)
            if (r3 == 0) goto L26
            double r3 = java.lang.Double.parseDouble(r3)     // Catch: java.lang.NumberFormatException -> L26
            java.lang.Double r5 = java.lang.Double.valueOf(r3)     // Catch: java.lang.NumberFormatException -> L26
            boolean r5 = io.sentry.util.SampleRateUtils.a(r2, r5)     // Catch: java.lang.NumberFormatException -> L26
            if (r5 == 0) goto L26
            java.lang.Double r3 = java.lang.Double.valueOf(r3)     // Catch: java.lang.NumberFormatException -> L26
            goto L27
        L26:
            r3 = r1
        L27:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            if (r3 == 0) goto L33
            io.sentry.TracesSamplingDecision r1 = new io.sentry.TracesSamplingDecision
            r1.<init>(r3, r2)
            goto L39
        L33:
            io.sentry.TracesSamplingDecision r3 = new io.sentry.TracesSamplingDecision
            r3.<init>(r1, r2)
            r1 = r3
        L39:
            io.sentry.TransactionContext r2 = new io.sentry.TransactionContext
            io.sentry.protocol.SentryId r3 = r8.f51748a
            io.sentry.SpanId r4 = r8.f51749b
            r6 = 0
            java.lang.String r5 = "default"
            r7 = 0
            r2.<init>(r3, r4, r5, r6, r7)
            io.sentry.Instrumenter r8 = io.sentry.Instrumenter.SENTRY
            r2.o = r8
            java.lang.String r8 = "<unlabeled transaction>"
            r2.f51962k = r8
            r2.f51964m = r1
            io.sentry.protocol.TransactionNameSource r8 = io.sentry.TransactionContext.p
            r2.f51963l = r8
            r2.n = r0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.TransactionContext.a(io.sentry.PropagationContext):io.sentry.TransactionContext");
    }

    public final Instrumenter b() {
        return this.o;
    }

    public final TracesSamplingDecision c() {
        return this.f51964m;
    }

    public TransactionContext(String str, TransactionNameSource transactionNameSource, String str2) {
        this(str, transactionNameSource, str2, null);
    }

    public TransactionContext() {
        this("app.launch", TransactionNameSource.CUSTOM, Scopes.PROFILE, null);
    }
}
