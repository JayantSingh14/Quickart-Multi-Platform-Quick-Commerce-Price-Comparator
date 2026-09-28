package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzfuk extends zzfuh {

    /* renamed from: a, reason: collision with root package name */
    public final String f31883a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f31884b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f31885c;

    /* renamed from: d, reason: collision with root package name */
    public final long f31886d;

    /* renamed from: e, reason: collision with root package name */
    public final long f31887e;

    public /* synthetic */ zzfuk(String str, boolean z, boolean z2, long j2, long j3) {
        this.f31883a = str;
        this.f31884b = z;
        this.f31885c = z2;
        this.f31886d = j2;
        this.f31887e = j3;
    }

    @Override // com.google.android.gms.internal.ads.zzfuh
    public final String a() {
        return this.f31883a;
    }

    @Override // com.google.android.gms.internal.ads.zzfuh
    public final boolean b() {
        return this.f31884b;
    }

    @Override // com.google.android.gms.internal.ads.zzfuh
    public final boolean c() {
        return this.f31885c;
    }

    @Override // com.google.android.gms.internal.ads.zzfuh
    public final long d() {
        return this.f31886d;
    }

    @Override // com.google.android.gms.internal.ads.zzfuh
    public final long e() {
        return this.f31887e;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfuh)) {
            return false;
        }
        zzfuh zzfuhVar = (zzfuh) obj;
        return this.f31883a.equals(zzfuhVar.a()) && this.f31884b == zzfuhVar.b() && this.f31885c == zzfuhVar.c() && this.f31886d == zzfuhVar.d() && this.f31887e == zzfuhVar.e();
    }

    public final int hashCode() {
        return ((((((((((((this.f31883a.hashCode() ^ 1000003) * 1000003) ^ (true != this.f31884b ? 1237 : 1231)) * 1000003) ^ (true != this.f31885c ? 1237 : 1231)) * 1000003) ^ 1237) * 1000003) ^ ((int) this.f31886d)) * 1000003) ^ 1237) * 1000003) ^ ((int) this.f31887e);
    }

    public final String toString() {
        boolean z = this.f31884b;
        int length = String.valueOf(z).length();
        boolean z2 = this.f31885c;
        int length2 = String.valueOf(z2).length();
        long j2 = this.f31886d;
        int length3 = String.valueOf(j2).length();
        long j3 = this.f31887e;
        int length4 = String.valueOf(j3).length();
        String str = this.f31883a;
        StringBuilder sb = new StringBuilder(str.length() + 56 + length + 32 + length2 + 57 + length3 + 61 + length4 + 1);
        sb.append("AdShield2Options{clientVersion=");
        sb.append(str);
        sb.append(", shouldGetAdvertisingId=");
        sb.append(z);
        sb.append(", isGooglePlayServicesAvailable=");
        sb.append(z2);
        sb.append(", enableQuerySignalsTimeout=false, querySignalsTimeoutMs=");
        sb.append(j2);
        sb.append(", enableQuerySignalsCache=false, querySignalsCacheTtlSeconds=");
        sb.append(j3);
        sb.append("}");
        return sb.toString();
    }
}
