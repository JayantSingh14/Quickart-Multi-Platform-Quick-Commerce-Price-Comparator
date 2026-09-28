package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzzd implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f35953a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f35954b;

    public zzzd(zzv zzvVar, int i2) {
        this.f35953a = 1 == (zzvVar.f35683e & 1);
        this.f35954b = zzmk.a(i2, false);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        zzzd zzzdVar = (zzzd) obj;
        return zzgsq.f33167a.d(this.f35954b, zzzdVar.f35954b).d(this.f35953a, zzzdVar.f35953a).e();
    }
}
