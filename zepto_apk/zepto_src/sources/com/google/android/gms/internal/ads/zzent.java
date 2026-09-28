package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzent implements zzejg {

    /* renamed from: a, reason: collision with root package name */
    public final Context f29902a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdua f29903b;

    /* renamed from: c, reason: collision with root package name */
    public final zzdtj f29904c;

    /* renamed from: d, reason: collision with root package name */
    public final zzfik f29905d;

    /* renamed from: e, reason: collision with root package name */
    public final Executor f29906e;

    /* renamed from: f, reason: collision with root package name */
    public final VersionInfoParcel f29907f;

    /* renamed from: g, reason: collision with root package name */
    public final zzbnq f29908g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f29909h = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Z9)).booleanValue();

    /* renamed from: i, reason: collision with root package name */
    public final zzeif f29910i;

    /* renamed from: j, reason: collision with root package name */
    public final zzdwy f29911j;

    /* renamed from: k, reason: collision with root package name */
    public final zzdxe f29912k;

    public zzent(Context context, VersionInfoParcel versionInfoParcel, zzfik zzfikVar, Executor executor, zzdtj zzdtjVar, zzdua zzduaVar, zzbnq zzbnqVar, zzeif zzeifVar, zzdwy zzdwyVar, zzdxe zzdxeVar) {
        this.f29902a = context;
        this.f29905d = zzfikVar;
        this.f29904c = zzdtjVar;
        this.f29906e = executor;
        this.f29907f = versionInfoParcel;
        this.f29903b = zzduaVar;
        this.f29908g = zzbnqVar;
        this.f29910i = zzeifVar;
        this.f29911j = zzdwyVar;
        this.f29912k = zzdxeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzejg
    public final ListenableFuture a(final zzfic zzficVar, final zzfhr zzfhrVar) {
        final zzdue zzdueVar = new zzdue();
        ListenableFuture listenableFuture = zzgyq.f33377b;
        zzgxu zzgxuVar = new zzgxu(zzfhrVar, zzficVar, zzdueVar) { // from class: com.google.android.gms.internal.ads.zzens

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ zzfhr f29900b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ zzfic f29901c;

            @Override // com.google.android.gms.internal.ads.zzgxu
            public final ListenableFuture zza(Object obj) throws zzcjg {
                zzent zzentVar = this.f29899a;
                zzentVar.getClass();
                zzbgb zzbgbVar = zzbgk.C2;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                boolean zBooleanValue = ((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue();
                zzdwy zzdwyVar = zzentVar.f29911j;
                if (zBooleanValue) {
                    zzdwyVar.f28716e.putLong("rendering-webview-creation-start", com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis());
                }
                zzfic zzficVar2 = this.f29901c;
                zzfib zzfibVar = zzficVar2.f31194b;
                zzfik zzfikVar = zzentVar.f29905d;
                final zzfhr zzfhrVar2 = this.f29900b;
                zzdua zzduaVar = zzentVar.f29903b;
                final zzcir zzcirVarA = zzduaVar.a(zzfikVar.f31218f, zzfhrVar2, zzfibVar.f31190b);
                zzcirVarA.Z(zzfhrVar2.W);
                zzbgi zzbgiVar = zzbdVar.f21153c;
                if (((Boolean) zzbgiVar.a(zzbgbVar)).booleanValue()) {
                    zzdwyVar.f28716e.putLong("rendering-webview-creation-end", com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis());
                }
                zzcdt zzcdtVar = new zzcdt();
                zzcwa zzcwaVar = new zzcwa(zzficVar2, zzfhrVar2, null);
                VersionInfoParcel versionInfoParcel = zzentVar.f29907f;
                zzbnq zzbnqVar = zzentVar.f29908g;
                Context context = zzentVar.f29902a;
                boolean z = zzentVar.f29909h;
                zzeif zzeifVar = zzentVar.f29910i;
                zzdwy zzdwyVar2 = zzentVar.f29911j;
                zzdtg zzdtgVar = new zzdtg(new zzenp(context, zzduaVar, zzfikVar, versionInfoParcel, zzfhrVar2, zzcdtVar, zzcirVarA, zzbnqVar, z, zzeifVar, zzdwyVar2, zzentVar.f29912k), zzcirVarA);
                zzdtj zzdtjVar = zzentVar.f29904c;
                final zzdtf zzdtfVarA = zzdtjVar.a(zzcwaVar, zzdtgVar);
                zzcdtVar.b(zzdtfVarA);
                if (((Boolean) zzbgiVar.a(zzbgbVar)).booleanValue()) {
                    zzdwyVar2.f28716e.putLong("rendering-ad-component-creation-end", com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis());
                }
                zzcirVarA.k0("/reward", new zzbog(zzdtfVarA.i()));
                zzdtfVarA.c().t0(new zzdbe() { // from class: com.google.android.gms.internal.ads.zzenq
                    @Override // com.google.android.gms.internal.ads.zzdbe
                    public final /* synthetic */ void f() {
                        zzcir zzcirVar = zzcirVarA;
                        if (zzcirVar.e0() != null) {
                            zzcirVar.e0().u0();
                        }
                    }
                }, zzcdo.f25988g);
                zzdtz zzdtzVarJ = zzdtfVarA.j();
                if (true != z) {
                    zzbnqVar = null;
                }
                zzdtzVarJ.a(zzcirVarA, true, zzbnqVar, zzdwyVar2.f28716e);
                zzfhw zzfhwVar = zzfhrVar2.s;
                String strA = zzfhwVar.f31179a;
                if (((Boolean) zzbgiVar.a(zzbgk.Y5)).booleanValue() && ((zzeiz) ((zzcnx) zzdtfVarA).u.zzb()).a()) {
                    strA = zzcki.a(strA, zzcki.b(zzfhrVar2));
                }
                zzdtfVarA.j();
                return zzgym.i(zzdtz.b(zzcirVarA, zzfhwVar.f31180b, strA, zzdwyVar2.f28716e, ((zzcnz) zzdtjVar).zzd()), new zzgpr() { // from class: com.google.android.gms.internal.ads.zzenr
                    @Override // com.google.android.gms.internal.ads.zzgpr
                    public final /* synthetic */ Object apply(Object obj2) {
                        zzfhr zzfhrVar3 = zzfhrVar2;
                        zzcir zzcirVar = zzcirVarA;
                        if (zzfhrVar3.M) {
                            zzcirVar.p();
                        }
                        zzcirVar.B0();
                        zzcirVar.onPause();
                        return zzdtfVarA.g();
                    }
                }, zzentVar.f29906e);
            }
        };
        Executor executor = this.f29906e;
        ListenableFuture listenableFutureH = zzgym.h(listenableFuture, zzgxuVar, executor);
        ((zzgxf) listenableFutureH).q(new zzenm(), executor);
        return listenableFutureH;
    }

    @Override // com.google.android.gms.internal.ads.zzejg
    public final boolean b(zzfic zzficVar, zzfhr zzfhrVar) {
        zzfhw zzfhwVar = zzfhrVar.s;
        return (zzfhwVar == null || zzfhwVar.f31179a == null) ? false : true;
    }
}
