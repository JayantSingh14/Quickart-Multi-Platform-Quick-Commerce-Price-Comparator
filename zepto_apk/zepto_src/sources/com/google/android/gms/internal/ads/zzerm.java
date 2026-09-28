package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONException;

/* loaded from: classes4.dex */
public final class zzerm implements zzerf {

    /* renamed from: a, reason: collision with root package name */
    public final zzfij f30166a;

    /* renamed from: b, reason: collision with root package name */
    public final zzclg f30167b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f30168c;

    /* renamed from: d, reason: collision with root package name */
    public final zzerc f30169d;

    /* renamed from: e, reason: collision with root package name */
    public final zzfnr f30170e;

    /* renamed from: f, reason: collision with root package name */
    public zzcvz f30171f;

    public zzerm(zzclg zzclgVar, Context context, zzerc zzercVar, zzfij zzfijVar) {
        this.f30167b = zzclgVar;
        this.f30168c = context;
        this.f30169d = zzercVar;
        this.f30166a = zzfijVar;
        this.f30170e = zzclgVar.z();
        zzfijVar.r = zzercVar.f30153b;
    }

    public final boolean a(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzerd zzerdVar, zzere zzereVar) throws JSONException {
        zzbgb zzbgbVar = zzbgk.O2;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            com.google.android.gms.ads.internal.client.zzbb.a();
        }
        com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
        com.google.android.gms.ads.internal.util.zzs zzsVar = zztVar.f21679c;
        Context context = this.f30168c;
        boolean zH = com.google.android.gms.ads.internal.util.zzs.h(context);
        zzclg zzclgVar = this.f30167b;
        if (zH && zzmVar.s == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.c("Failed to load the ad because app ID is missing.");
            zzclgVar.g().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzerl
                @Override // java.lang.Runnable
                public final void run() {
                    ((zzerb) this.f30165a.f30169d.f30154c).m0(zzfjm.d(4, null, null));
                }
            });
            return false;
        }
        if (str == null) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.c("Ad unit ID should not be null for NativeAdLoader.");
            zzclgVar.g().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzerk
                @Override // java.lang.Runnable
                public final void run() {
                    ((zzerb) this.f30164a.f30169d.f30154c).m0(zzfjm.d(6, null, null));
                }
            });
            return false;
        }
        boolean z = zzmVar.f21259f;
        zzfjh.b(context, z);
        if (((Boolean) zzbdVar.f21153c.a(zzbgk.aa)).booleanValue() && z) {
            zzclgVar.y().b(true);
        }
        Long lValueOf = Long.valueOf(zztVar.f21687k.currentTimeMillis());
        Bundle bundleA = zzdwo.a(new Pair("api-call", lValueOf), new Pair("dynamite-enter", lValueOf));
        zzfij zzfijVar = this.f30166a;
        zzfijVar.f31200a = zzmVar;
        zzfijVar.t = bundleA;
        zzfijVar.f31212m = ((zzerg) zzerdVar).f30155a;
        zzfik zzfikVarA = zzfijVar.a();
        zzfne zzfneVarE = zzfne.e(context, zzfnn.b(zzfikVarA), 8, zzmVar);
        zzerc zzercVar = this.f30169d;
        zzeqp zzeqpVar = zzercVar.f30153b;
        com.google.android.gms.ads.internal.client.zzco zzcoVar = zzfikVarA.o;
        if (zzcoVar != null) {
            zzeqpVar.m(zzcoVar);
        }
        zzdlu zzdluVarR = zzclgVar.r();
        zzczs zzczsVar = new zzczs();
        zzczsVar.f27511a = context;
        zzczsVar.f27512b = zzfikVarA;
        ((zzcms) zzdluVarR).f26550e = new zzczt(zzczsVar);
        zzdgj zzdgjVar = new zzdgj();
        zzdgjVar.b(zzeqpVar, zzclgVar.g());
        zzcms zzcmsVar = (zzcms) zzdluVarR;
        zzcmsVar.f26549d = new zzdgk(zzdgjVar);
        zzcmsVar.f26551f = new zzdlq(zzercVar.f30152a, zzeqpVar.j());
        zzfno zzfnoVar = null;
        zzcmsVar.f26552g = new zzcsz(null);
        zzdlv zzdlvVarZzh = zzcmsVar.zzh();
        if (((Boolean) zzbid.f25133c.c()).booleanValue()) {
            zzfnoVar = (zzfno) ((zzcmt) zzdlvVarZzh).f26557e.zzb();
            zzfnoVar.i(8);
            zzfnoVar.c(zzmVar.p);
            zzfnoVar.d(zzmVar.f21266m);
        }
        zzfno zzfnoVar2 = zzfnoVar;
        ((zzfjj) ((zzcmv) zzclgVar).P.zzb()).a(1);
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        ScheduledExecutorService scheduledExecutorServiceH = zzclgVar.h();
        zzcwo zzcwoVarA = zzdlvVarZzh.a();
        zzfmb zzfmbVarC = zzcwoVarA.c(zzcwoVarA.b());
        zzcvz zzcvzVar = new zzcvz(zzgywVar, scheduledExecutorServiceH, zzfmbVarC);
        this.f30171f = zzcvzVar;
        zzfmbVarC.q(new zzgyk(zzfmbVarC, new zzcvt(zzcvzVar, new zzerj(this, zzereVar, zzfnoVar2, zzfneVarE, zzdlvVarZzh))), zzgywVar);
        return true;
    }
}
