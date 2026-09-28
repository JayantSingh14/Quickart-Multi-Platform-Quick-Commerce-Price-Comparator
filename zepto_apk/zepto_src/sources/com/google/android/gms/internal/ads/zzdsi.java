package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes4.dex */
final class zzdsi implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzfhr f28417a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzfhu f28418b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzcra f28419c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzdsp f28420d;

    public zzdsi(zzdsp zzdspVar, zzfhr zzfhrVar, zzfhu zzfhuVar, zzcra zzcraVar) {
        this.f28417a = zzfhrVar;
        this.f28418b = zzfhuVar;
        this.f28419c = zzcraVar;
        this.f28420d = zzdspVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zzb(Object obj) {
        zzcir zzcirVar = (zzcir) obj;
        zzfhr zzfhrVar = this.f28417a;
        zzcirVar.U(zzfhrVar, this.f28418b);
        zzcjc zzcjcVarE0 = zzcirVar.e0();
        zzbgb zzbgbVar = zzbgk.lb;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue() && zzcjcVarE0 != null) {
            zzdsp zzdspVar = this.f28420d;
            zzehu zzehuVar = zzdspVar.f28456i;
            zzfpi zzfpiVar = zzdspVar.f28457j;
            zzcra zzcraVar = this.f28419c;
            zzcjcVarE0.l0(zzcraVar, zzehuVar, zzfpiVar);
            zzcjcVarE0.m0(zzcraVar, zzdspVar.f28456i, zzdspVar.f28451d);
        }
        if (!((Boolean) zzbdVar.f21153c.a(zzbgk.he)).booleanValue() || zzcjcVarE0 == null) {
            return;
        }
        zzcbw zzcbwVar = com.google.android.gms.ads.internal.zzt.C.y;
        zzcjn zzcjnVar = zzcjcVarE0.f26369a;
        if (zzcbwVar.a(zzcjnVar.getContext())) {
            zzcjcVarE0.c("/logScionEvent");
            new HashMap();
            zzcjcVarE0.b("/logScionEvent", new zzbnt(zzcjnVar.getContext(), zzfhrVar.w0));
        }
    }
}
