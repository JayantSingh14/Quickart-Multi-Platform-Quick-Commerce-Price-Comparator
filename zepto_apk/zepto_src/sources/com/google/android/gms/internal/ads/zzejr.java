package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzejr implements zzejg {

    /* renamed from: a, reason: collision with root package name */
    public final zzcsq f29479a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdua f29480b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfik f29481c;

    /* renamed from: d, reason: collision with root package name */
    public final Executor f29482d;

    /* renamed from: e, reason: collision with root package name */
    public final VersionInfoParcel f29483e;

    /* renamed from: f, reason: collision with root package name */
    public final zzbnq f29484f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f29485g = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Z9)).booleanValue();

    /* renamed from: h, reason: collision with root package name */
    public final zzeif f29486h;

    /* renamed from: i, reason: collision with root package name */
    public final zzdwy f29487i;

    /* renamed from: j, reason: collision with root package name */
    public final zzdxe f29488j;

    public zzejr(zzcsq zzcsqVar, Executor executor, zzdua zzduaVar, zzfik zzfikVar, VersionInfoParcel versionInfoParcel, zzbnq zzbnqVar, zzeif zzeifVar, zzdwy zzdwyVar, zzdxe zzdxeVar) {
        this.f29479a = zzcsqVar;
        this.f29482d = executor;
        this.f29480b = zzduaVar;
        this.f29481c = zzfikVar;
        this.f29483e = versionInfoParcel;
        this.f29484f = zzbnqVar;
        this.f29486h = zzeifVar;
        this.f29487i = zzdwyVar;
        this.f29488j = zzdxeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzejg
    public final ListenableFuture a(final zzfic zzficVar, final zzfhr zzfhrVar) {
        final zzdue zzdueVar = new zzdue();
        ListenableFuture listenableFuture = zzgyq.f33377b;
        zzgxu zzgxuVar = new zzgxu(zzfhrVar, zzficVar, zzdueVar) { // from class: com.google.android.gms.internal.ads.zzejp

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ zzfhr f29477b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ zzfic f29478c;

            @Override // com.google.android.gms.internal.ads.zzgxu
            public final ListenableFuture zza(Object obj) throws zzcjg {
                zzejr zzejrVar = this.f29476a;
                zzejrVar.getClass();
                zzbgb zzbgbVar = zzbgk.C2;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                boolean zBooleanValue = ((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue();
                zzdwy zzdwyVar = zzejrVar.f29487i;
                if (zBooleanValue) {
                    zzdwyVar.f28716e.putLong("rendering-webview-creation-start", com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis());
                }
                zzfic zzficVar2 = this.f29478c;
                zzfib zzfibVar = zzficVar2.f31194b;
                zzfik zzfikVar = zzejrVar.f29481c;
                final zzfhr zzfhrVar2 = this.f29477b;
                final zzcir zzcirVarA = zzejrVar.f29480b.a(zzfikVar.f31218f, zzfhrVar2, zzfibVar.f31190b);
                zzcirVarA.Z(zzfhrVar2.W);
                zzbgi zzbgiVar = zzbdVar.f21153c;
                if (((Boolean) zzbgiVar.a(zzbgbVar)).booleanValue()) {
                    zzdwyVar.f28716e.putLong("rendering-webview-creation-end", com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis());
                }
                zzcdt zzcdtVar = new zzcdt();
                zzcwa zzcwaVar = new zzcwa(zzficVar2, zzfhrVar2, null);
                VersionInfoParcel versionInfoParcel = zzejrVar.f29483e;
                zzbnq zzbnqVar = zzejrVar.f29484f;
                boolean z = zzejrVar.f29485g;
                zzdjw zzdjwVar = new zzdjw(new zzejt(versionInfoParcel, zzcdtVar, zzfhrVar2, zzcirVarA, zzfikVar, z, zzbnqVar, zzejrVar.f29486h, zzejrVar.f29488j), zzcirVarA);
                zzcso zzcsoVar = new zzcso(zzfhrVar2.a0);
                zzcsq zzcsqVar = zzejrVar.f29479a;
                final zzcsn zzcsnVarA = zzcsqVar.a(zzcwaVar, zzdjwVar, zzcsoVar);
                if (((Boolean) zzbgiVar.a(zzbgbVar)).booleanValue()) {
                    zzdwyVar.f28716e.putLong("rendering-ad-component-creation-end", com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis());
                }
                zzcsnVarA.h().a(zzcirVarA, false, true != z ? null : zzbnqVar, zzdwyVar.f28716e);
                zzcdtVar.b(zzcsnVarA);
                zzcsnVarA.c().t0(new zzdbe() { // from class: com.google.android.gms.internal.ads.zzejn
                    @Override // com.google.android.gms.internal.ads.zzdbe
                    public final /* synthetic */ void f() {
                        zzcir zzcirVar = zzcirVarA;
                        if (zzcirVar.e0() != null) {
                            zzcirVar.e0().u0();
                        }
                    }
                }, zzcdo.f25988g);
                zzfhw zzfhwVar = zzfhrVar2.s;
                String strA = zzfhwVar.f31179a;
                if (((Boolean) zzbgiVar.a(zzbgk.Y5)).booleanValue() && ((zzeiz) ((zzcmw) zzcsnVarA).v.zzb()).a()) {
                    strA = zzcki.a(strA, zzcki.b(zzfhrVar2));
                }
                zzcsnVarA.h();
                return zzgym.i(zzdtz.b(zzcirVarA, zzfhwVar.f31180b, strA, zzdwyVar.f28716e, ((zzcmy) zzcsqVar).zzd()), new zzgpr() { // from class: com.google.android.gms.internal.ads.zzejo
                    @Override // com.google.android.gms.internal.ads.zzgpr
                    public final /* synthetic */ Object apply(Object obj2) {
                        zzfhr zzfhrVar3 = zzfhrVar2;
                        zzcir zzcirVar = zzcirVarA;
                        if (zzfhrVar3.M) {
                            zzcirVar.p();
                        }
                        zzcirVar.B0();
                        zzcirVar.onPause();
                        return zzcsnVarA.g();
                    }
                }, zzejrVar.f29482d);
            }
        };
        Executor executor = this.f29482d;
        ListenableFuture listenableFutureH = zzgym.h(listenableFuture, zzgxuVar, executor);
        ((zzgxf) listenableFutureH).q(new zzejq(), executor);
        return listenableFutureH;
    }

    @Override // com.google.android.gms.internal.ads.zzejg
    public final boolean b(zzfic zzficVar, zzfhr zzfhrVar) {
        zzfhw zzfhwVar = zzfhrVar.s;
        return (zzfhwVar == null || zzfhwVar.f31179a == null) ? false : true;
    }
}
