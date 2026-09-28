package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzll {

    /* renamed from: a, reason: collision with root package name */
    public final zzwg f35109a;

    /* renamed from: b, reason: collision with root package name */
    public final long f35110b;

    /* renamed from: c, reason: collision with root package name */
    public final long f35111c;

    /* renamed from: d, reason: collision with root package name */
    public final long f35112d;

    /* renamed from: e, reason: collision with root package name */
    public final long f35113e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f35114f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f35115g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f35116h;

    public zzll(zzwg zzwgVar, long j2, long j3, long j4, long j5, boolean z, boolean z2, boolean z3) {
        zzgqa.a(!z3 || z);
        zzgqa.a(!z2 || z);
        this.f35109a = zzwgVar;
        this.f35110b = j2;
        this.f35111c = j3;
        this.f35112d = j4;
        this.f35113e = j5;
        this.f35114f = z;
        this.f35115g = z2;
        this.f35116h = z3;
    }

    public final zzll a(long j2) {
        if (j2 == this.f35110b) {
            return this;
        }
        return new zzll(this.f35109a, j2, this.f35111c, this.f35112d, this.f35113e, this.f35114f, this.f35115g, this.f35116h);
    }

    public final zzll b(long j2) {
        if (j2 == this.f35111c) {
            return this;
        }
        return new zzll(this.f35109a, this.f35110b, j2, this.f35112d, this.f35113e, this.f35114f, this.f35115g, this.f35116h);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzll.class == obj.getClass()) {
            zzll zzllVar = (zzll) obj;
            if (this.f35110b == zzllVar.f35110b && this.f35111c == zzllVar.f35111c && this.f35112d == zzllVar.f35112d && this.f35113e == zzllVar.f35113e && this.f35114f == zzllVar.f35114f && this.f35115g == zzllVar.f35115g && this.f35116h == zzllVar.f35116h && Objects.equals(this.f35109a, zzllVar.f35109a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((((((this.f35109a.hashCode() + 527) * 31) + ((int) this.f35110b)) * 31) + ((int) this.f35111c)) * 31) + ((int) this.f35112d)) * 31) + ((int) this.f35113e)) * 29791) + (this.f35114f ? 1 : 0)) * 31) + (this.f35115g ? 1 : 0)) * 31) + (this.f35116h ? 1 : 0);
    }
}
