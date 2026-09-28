package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzbmr implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzcir f25322a;

    public zzbmr(zzcir zzcirVar) {
        this.f25322a = zzcirVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
        com.google.android.gms.ads.internal.zzt.C.f21684h.d("DefaultGmsgHandlers.attributionReportingManager", th);
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        String str = (String) obj;
        zzcir zzcirVar = this.f25322a;
        new com.google.android.gms.ads.internal.util.zzbt(zzcirVar.getContext(), zzcirVar.zzs().f21400a, str, zzcirVar.v() != null ? zzcirVar.v().x0 : null).b();
    }
}
