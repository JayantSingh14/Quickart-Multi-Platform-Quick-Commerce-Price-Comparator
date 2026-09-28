package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzfuj extends zzfug {

    /* renamed from: a, reason: collision with root package name */
    public String f31877a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f31878b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f31879c;

    /* renamed from: d, reason: collision with root package name */
    public long f31880d;

    /* renamed from: e, reason: collision with root package name */
    public long f31881e;

    /* renamed from: f, reason: collision with root package name */
    public byte f31882f;

    public final zzfuh a() {
        String str;
        if (this.f31882f == 63 && (str = this.f31877a) != null) {
            return new zzfuk(str, this.f31878b, this.f31879c, this.f31880d, this.f31881e);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f31877a == null) {
            sb.append(" clientVersion");
        }
        if ((this.f31882f & 1) == 0) {
            sb.append(" shouldGetAdvertisingId");
        }
        if ((this.f31882f & 2) == 0) {
            sb.append(" isGooglePlayServicesAvailable");
        }
        if ((this.f31882f & 4) == 0) {
            sb.append(" enableQuerySignalsTimeout");
        }
        if ((this.f31882f & 8) == 0) {
            sb.append(" querySignalsTimeoutMs");
        }
        if ((this.f31882f & 16) == 0) {
            sb.append(" enableQuerySignalsCache");
        }
        if ((this.f31882f & 32) == 0) {
            sb.append(" querySignalsCacheTtlSeconds");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
