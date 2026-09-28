package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzekg implements zzejg {

    /* renamed from: a, reason: collision with root package name */
    public final zzcuh f29529a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f29530b;

    /* renamed from: c, reason: collision with root package name */
    public final zzdua f29531c;

    /* renamed from: d, reason: collision with root package name */
    public final zzfik f29532d;

    /* renamed from: e, reason: collision with root package name */
    public final Executor f29533e;

    /* renamed from: f, reason: collision with root package name */
    public final zzgpr f29534f;

    /* renamed from: g, reason: collision with root package name */
    public final zzdwy f29535g;

    public zzekg(zzcuh zzcuhVar, Context context, Executor executor, zzdua zzduaVar, zzfik zzfikVar, zzgpr zzgprVar, zzdwy zzdwyVar) {
        this.f29530b = context;
        this.f29529a = zzcuhVar;
        this.f29533e = executor;
        this.f29531c = zzduaVar;
        this.f29532d = zzfikVar;
        this.f29534f = zzgprVar;
        this.f29535g = zzdwyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzejg
    public final ListenableFuture a(final zzfic zzficVar, final zzfhr zzfhrVar) {
        return zzgym.h(zzgyq.f33377b, new zzgxu() { // from class: com.google.android.gms.internal.ads.zzekf
            @Override // com.google.android.gms.internal.ads.zzgxu
            public final ListenableFuture zza(Object obj) throws zzcjg {
                final zzekg zzekgVar = this.f29526a;
                zzekgVar.getClass();
                zzbgb zzbgbVar = zzbgk.C2;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                boolean zBooleanValue = ((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue();
                zzdwy zzdwyVar = zzekgVar.f29535g;
                if (zBooleanValue) {
                    zzdwyVar.f28716e.putLong("rendering-webview-creation-start", com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis());
                }
                zzfhr zzfhrVar2 = zzfhrVar;
                Context context = zzekgVar.f29530b;
                com.google.android.gms.ads.internal.client.zzr zzrVarA = zzfiq.a(context, zzfhrVar2.u);
                zzfic zzficVar2 = zzficVar;
                final zzcir zzcirVarA = zzekgVar.f29531c.a(zzrVarA, zzfhrVar2, zzficVar2.f31194b.f31190b);
                zzcirVarA.Z(zzfhrVar2.W);
                zzbgb zzbgbVar2 = zzbgk.P8;
                zzbgi zzbgiVar = zzbdVar.f21153c;
                View viewA = (((Boolean) zzbgiVar.a(zzbgbVar2)).booleanValue() && zzfhrVar2.g0) ? zzcuw.a(context, zzcirVarA.x(), zzfhrVar2) : new zzdud(context, zzcirVarA.x(), (com.google.android.gms.ads.internal.util.zzat) zzekgVar.f29534f.apply(zzfhrVar2));
                if (((Boolean) zzbgiVar.a(zzbgbVar)).booleanValue()) {
                    zzdwyVar.f28716e.putLong("rendering-webview-creation-end", com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis());
                }
                zzcwa zzcwaVar = new zzcwa(zzficVar2, zzfhrVar2, null);
                zzctj zzctjVar = new zzctj(viewA, zzcirVarA, new zzcvi() { // from class: com.google.android.gms.internal.ads.zzekb
                    @Override // com.google.android.gms.internal.ads.zzcvi
                    public final /* synthetic */ com.google.android.gms.ads.internal.client.zzed zza() {
                        return zzcirVarA.zzh();
                    }
                }, zzrVarA.f21289i ? new zzfhs(-3, 0, true) : new zzfhs(zzrVarA.f21285e, zzrVarA.f21282b, false));
                zzcuh zzcuhVar = zzekgVar.f29529a;
                final zzctd zzctdVarD = zzcuhVar.d(zzcwaVar, zzctjVar);
                if (((Boolean) zzbgiVar.a(zzbgbVar)).booleanValue()) {
                    zzdwyVar.f28716e.putLong("rendering-ad-component-creation-end", com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis());
                }
                zzctdVarD.h().a(zzcirVarA, false, null, zzdwyVar.f28716e);
                zzdbc zzdbcVarC = zzctdVarD.c();
                zzdbe zzdbeVar = new zzdbe() { // from class: com.google.android.gms.internal.ads.zzekc
                    @Override // com.google.android.gms.internal.ads.zzdbe
                    public final /* synthetic */ void f() {
                        zzcir zzcirVar = zzcirVarA;
                        if (zzcirVar.e0() != null) {
                            zzcirVar.e0().u0();
                        }
                    }
                };
                zzgyw zzgywVar = zzcdo.f25988g;
                zzdbcVarC.t0(zzdbeVar, zzgywVar);
                zzfhw zzfhwVar = zzfhrVar2.s;
                String strA = zzfhwVar.f31179a;
                if (((Boolean) zzbgiVar.a(zzbgk.Y5)).booleanValue() && ((zzeiz) ((zzcnb) zzctdVarD).x.zzb()).a()) {
                    strA = zzcki.a(strA, zzcki.b(zzfhrVar2));
                }
                zzctdVarD.h();
                zzcdt zzcdtVarB = zzdtz.b(zzcirVarA, zzfhwVar.f31180b, strA, zzdwyVar.f28716e, zzcuhVar.c());
                zzgzf zzgzfVar = zzcdtVarB.f25992a;
                boolean z = zzfhrVar2.M;
                Executor executor = zzekgVar.f29533e;
                if (z) {
                    zzgzfVar.q(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeka
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            zzcirVarA.p();
                        }
                    }, executor);
                }
                zzgzfVar.q(new Runnable() { // from class: com.google.android.gms.internal.ads.zzekd
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzekg zzekgVar2 = zzekgVar;
                        zzekgVar2.getClass();
                        zzcir zzcirVar = zzcirVarA;
                        zzcirVar.B0();
                        zzcjx zzcjxVarZzh = zzcirVar.zzh();
                        com.google.android.gms.ads.internal.client.zzga zzgaVar = zzekgVar2.f29532d.f31213a;
                        if (zzgaVar != null && zzcjxVarZzh != null) {
                            zzcjxVarZzh.Yb(zzgaVar);
                        }
                        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.E1)).booleanValue() || zzcirVar.isAttachedToWindow()) {
                            return;
                        }
                        zzcirVar.onPause();
                        zzcirVar.d0();
                    }
                }, executor);
                return zzgym.i(zzcdtVarB, new zzgpr() { // from class: com.google.android.gms.internal.ads.zzeke
                    @Override // com.google.android.gms.internal.ads.zzgpr
                    public final /* synthetic */ Object apply(Object obj2) {
                        return zzctdVarD.g();
                    }
                }, zzgywVar);
            }
        }, this.f29533e);
    }

    @Override // com.google.android.gms.internal.ads.zzejg
    public final boolean b(zzfic zzficVar, zzfhr zzfhrVar) {
        zzfhw zzfhwVar = zzfhrVar.s;
        return (zzfhwVar == null || zzfhwVar.f31179a == null) ? false : true;
    }
}
