package io.sentry;

/* loaded from: classes3.dex */
public final class TracesSamplingDecision {

    /* renamed from: a, reason: collision with root package name */
    public final Boolean f51958a;

    /* renamed from: b, reason: collision with root package name */
    public final Double f51959b;

    /* renamed from: c, reason: collision with root package name */
    public final Boolean f51960c;

    /* renamed from: d, reason: collision with root package name */
    public final Double f51961d;

    public TracesSamplingDecision() {
        this(null, Boolean.TRUE);
    }

    public final Double a() {
        return this.f51961d;
    }

    public final Boolean b() {
        return this.f51960c;
    }

    public final Double c() {
        return this.f51959b;
    }

    public final Boolean d() {
        return this.f51958a;
    }

    public TracesSamplingDecision(Double d2, Boolean bool) {
        this(bool, d2, Boolean.FALSE, null);
    }

    public TracesSamplingDecision(Boolean bool, Double d2, Boolean bool2, Double d3) {
        this.f51958a = bool;
        this.f51959b = d2;
        this.f51960c = Boolean.valueOf(bool.booleanValue() && bool2.booleanValue());
        this.f51961d = d3;
    }
}
