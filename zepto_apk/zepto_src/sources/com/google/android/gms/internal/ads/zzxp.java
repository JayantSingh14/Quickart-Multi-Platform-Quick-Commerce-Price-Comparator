package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzxp implements zzaag {

    /* renamed from: a, reason: collision with root package name */
    public long f35855a;

    /* renamed from: b, reason: collision with root package name */
    public long f35856b;

    /* renamed from: c, reason: collision with root package name */
    public zzaaf f35857c;

    /* renamed from: d, reason: collision with root package name */
    public zzxp f35858d;

    public zzxp(long j2) {
        zzgqa.f(this.f35857c == null);
        this.f35855a = j2;
        this.f35856b = j2 + 65536;
    }

    @Override // com.google.android.gms.internal.ads.zzaag
    public final zzaaf zzd() {
        zzaaf zzaafVar = this.f35857c;
        zzaafVar.getClass();
        return zzaafVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaag
    public final zzaag zze() {
        zzxp zzxpVar = this.f35858d;
        if (zzxpVar == null || zzxpVar.f35857c == null) {
            return null;
        }
        return zzxpVar;
    }
}
