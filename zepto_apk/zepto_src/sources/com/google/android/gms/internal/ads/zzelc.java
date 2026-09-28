package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzelc implements zzejg {

    /* renamed from: a, reason: collision with root package name */
    public final Context f29608a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdua f29609b;

    /* renamed from: c, reason: collision with root package name */
    public final zzdkz f29610c;

    /* renamed from: d, reason: collision with root package name */
    public final zzfik f29611d;

    /* renamed from: e, reason: collision with root package name */
    public final Executor f29612e;

    /* renamed from: f, reason: collision with root package name */
    public final VersionInfoParcel f29613f;

    /* renamed from: g, reason: collision with root package name */
    public final zzbnq f29614g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f29615h = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Z9)).booleanValue();

    /* renamed from: i, reason: collision with root package name */
    public final zzeif f29616i;

    /* renamed from: j, reason: collision with root package name */
    public final zzdwy f29617j;

    /* renamed from: k, reason: collision with root package name */
    public final zzdxe f29618k;

    public zzelc(Context context, VersionInfoParcel versionInfoParcel, zzfik zzfikVar, Executor executor, zzdkz zzdkzVar, zzdua zzduaVar, zzbnq zzbnqVar, zzeif zzeifVar, zzdwy zzdwyVar, zzdxe zzdxeVar) {
        this.f29608a = context;
        this.f29611d = zzfikVar;
        this.f29610c = zzdkzVar;
        this.f29612e = executor;
        this.f29613f = versionInfoParcel;
        this.f29609b = zzduaVar;
        this.f29614g = zzbnqVar;
        this.f29616i = zzeifVar;
        this.f29617j = zzdwyVar;
        this.f29618k = zzdxeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzejg
    public final ListenableFuture a(final zzfic zzficVar, final zzfhr zzfhrVar) {
        final zzdue zzdueVar = new zzdue();
        ListenableFuture listenableFuture = zzgyq.f33377b;
        zzgxu zzgxuVar = new zzgxu(zzfhrVar, zzficVar, zzdueVar) { // from class: com.google.android.gms.internal.ads.zzekz

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ zzfhr f29593b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ zzfic f29594c;

            @Override // com.google.android.gms.internal.ads.zzgxu
            public final ListenableFuture zza(Object obj) throws zzcjg {
                zzelc zzelcVar = this.f29592a;
                zzelcVar.getClass();
                zzbgb zzbgbVar = zzbgk.C2;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                boolean zBooleanValue = ((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue();
                zzdwy zzdwyVar = zzelcVar.f29617j;
                if (zBooleanValue) {
                    zzdwyVar.f28716e.putLong("rendering-webview-creation-start", com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis());
                }
                zzfic zzficVar2 = this.f29594c;
                zzfib zzfibVar = zzficVar2.f31194b;
                zzfik zzfikVar = zzelcVar.f29611d;
                final zzfhr zzfhrVar2 = this.f29593b;
                final zzcir zzcirVarA = zzelcVar.f29609b.a(zzfikVar.f31218f, zzfhrVar2, zzfibVar.f31190b);
                zzcirVarA.Z(zzfhrVar2.W);
                zzbgi zzbgiVar = zzbdVar.f21153c;
                if (((Boolean) zzbgiVar.a(zzbgbVar)).booleanValue()) {
                    zzdwyVar.f28716e.putLong("rendering-webview-creation-end", com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis());
                }
                zzcdt zzcdtVar = new zzcdt();
                zzcwa zzcwaVar = new zzcwa(zzficVar2, zzfhrVar2, null);
                VersionInfoParcel versionInfoParcel = zzelcVar.f29613f;
                zzbnq zzbnqVar = zzelcVar.f29614g;
                Context context = zzelcVar.f29608a;
                boolean z = zzelcVar.f29615h;
                zzdjw zzdjwVar = new zzdjw(new zzela(context, versionInfoParcel, zzcdtVar, zzfhrVar2, zzcirVarA, zzfikVar, z, zzbnqVar, zzelcVar.f29616i, zzelcVar.f29618k), zzcirVarA);
                zzdkz zzdkzVar = zzelcVar.f29610c;
                final zzdjt zzdjtVarD = zzdkzVar.d(zzcwaVar, zzdjwVar);
                zzcdtVar.b(zzdjtVarD);
                if (((Boolean) zzbgiVar.a(zzbgbVar)).booleanValue()) {
                    zzdwyVar.f28716e.putLong("rendering-ad-component-creation-end", com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis());
                }
                zzdjtVarD.c().t0(new zzdbe() { // from class: com.google.android.gms.internal.ads.zzekx
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
                if (((Boolean) zzbgiVar.a(zzbgk.Y5)).booleanValue() && ((zzeiz) ((zzcnm) zzdjtVarD).u.zzb()).a()) {
                    strA = zzcki.a(strA, zzcki.b(zzfhrVar2));
                }
                zzdtz zzdtzVarI = zzdjtVarD.i();
                if (true != z) {
                    zzbnqVar = null;
                }
                zzdtzVarI.a(zzcirVarA, true, zzbnqVar, zzdwyVar.f28716e);
                zzdjtVarD.i();
                return zzgym.i(zzdtz.b(zzcirVarA, zzfhwVar.f31180b, strA, zzdwyVar.f28716e, zzdkzVar.c()), new zzgpr() { // from class: com.google.android.gms.internal.ads.zzeky
                    @Override // com.google.android.gms.internal.ads.zzgpr
                    public final /* synthetic */ Object apply(Object obj2) {
                        zzfhr zzfhrVar3 = zzfhrVar2;
                        zzcir zzcirVar = zzcirVarA;
                        if (zzfhrVar3.M) {
                            zzcirVar.p();
                        }
                        zzcirVar.B0();
                        zzcirVar.onPause();
                        return zzdjtVarD.g();
                    }
                }, zzelcVar.f29612e);
            }
        };
        Executor executor = this.f29612e;
        ListenableFuture listenableFutureH = zzgym.h(listenableFuture, zzgxuVar, executor);
        ((zzgxf) listenableFutureH).q(new zzelb(), executor);
        return listenableFutureH;
    }

    @Override // com.google.android.gms.internal.ads.zzejg
    public final boolean b(zzfic zzficVar, zzfhr zzfhrVar) {
        zzfhw zzfhwVar = zzfhrVar.s;
        return (zzfhwVar == null || zzfhwVar.f31179a == null) ? false : true;
    }
}
