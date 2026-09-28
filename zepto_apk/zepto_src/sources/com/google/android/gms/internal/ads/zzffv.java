package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import java.util.HashSet;
import java.util.concurrent.Executor;
import org.json.JSONException;

/* loaded from: classes4.dex */
public final class zzffv implements zzerf {

    /* renamed from: a, reason: collision with root package name */
    public final Context f31032a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f31033b;

    /* renamed from: c, reason: collision with root package name */
    public final zzclg f31034c;

    /* renamed from: d, reason: collision with root package name */
    public final zzeqp f31035d;

    /* renamed from: e, reason: collision with root package name */
    public final zzfgv f31036e;

    /* renamed from: f, reason: collision with root package name */
    public zzbhf f31037f;

    /* renamed from: g, reason: collision with root package name */
    public final zzfnr f31038g;

    /* renamed from: h, reason: collision with root package name */
    public final zzfij f31039h;

    /* renamed from: i, reason: collision with root package name */
    public zzfmb f31040i;

    public zzffv(Context context, Executor executor, zzclg zzclgVar, zzeqp zzeqpVar, zzfgv zzfgvVar, zzfij zzfijVar) {
        this.f31032a = context;
        this.f31033b = executor;
        this.f31034c = zzclgVar;
        this.f31035d = zzeqpVar;
        this.f31039h = zzfijVar;
        this.f31036e = zzfgvVar;
        this.f31038g = zzclgVar.z();
    }

    public final boolean a(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzerd zzerdVar, zzere zzereVar) throws JSONException {
        zzdkz zzdkzVarZzh;
        zzfno zzfnoVarC;
        Executor executor = this.f31033b;
        if (str == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.c("Ad unit ID should not be null for interstitial ad.");
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzffu
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzffv zzffvVar = this.f31031a;
                    zzffvVar.getClass();
                    zzffvVar.f31035d.m0(zzfjm.d(6, null, null));
                }
            });
            return false;
        }
        if (b()) {
            return false;
        }
        zzbgb zzbgbVar = zzbgk.O2;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            com.google.android.gms.ads.internal.client.zzbb.a();
        }
        zzbgb zzbgbVar2 = zzbgk.aa;
        zzbgi zzbgiVar = zzbdVar.f21153c;
        boolean zBooleanValue = ((Boolean) zzbgiVar.a(zzbgbVar2)).booleanValue();
        zzclg zzclgVar = this.f31034c;
        if (zBooleanValue && zzmVar.f21259f) {
            zzclgVar.y().b(true);
        }
        Bundle bundleA = zzdwo.a(new Pair("api-call", Long.valueOf(zzmVar.z)), new Pair("dynamite-enter", Long.valueOf(com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis())));
        zzfij zzfijVar = this.f31039h;
        zzfijVar.f31202c = str;
        zzfijVar.f31201b = ((zzffo) zzerdVar).f31019a;
        zzfijVar.f31200a = zzmVar;
        zzfijVar.t = bundleA;
        zzfik zzfikVarA = zzfijVar.a();
        int iB = zzfnn.b(zzfikVarA);
        Context context = this.f31032a;
        zzfne zzfneVarE = zzfne.e(context, iB, 4, zzmVar);
        boolean zBooleanValue2 = ((Boolean) zzbgiVar.a(zzbgk.i9)).booleanValue();
        zzeqp zzeqpVar = this.f31035d;
        if (zBooleanValue2) {
            zzdky zzdkyVarP = zzclgVar.p();
            zzczs zzczsVar = new zzczs();
            zzczsVar.f27511a = context;
            zzczsVar.f27512b = zzfikVarA;
            ((zzcnn) zzdkyVarP).f26721e = new zzczt(zzczsVar);
            zzdgj zzdgjVar = new zzdgj();
            zzdgjVar.d(zzeqpVar, executor);
            zzdgjVar.b(zzeqpVar, executor);
            zzcnn zzcnnVar = (zzcnn) zzdkyVarP;
            zzcnnVar.f26720d = new zzdgk(zzdgjVar);
            zzcnnVar.f26722f = new zzeow(this.f31037f);
            zzdkzVarZzh = zzcnnVar.zzh();
        } else {
            zzdgj zzdgjVar2 = new zzdgj();
            HashSet hashSet = zzdgjVar2.f27729h;
            HashSet hashSet2 = zzdgjVar2.f27726e;
            zzfgv zzfgvVar = this.f31036e;
            if (zzfgvVar != null) {
                hashSet2.add(new zzdij(zzfgvVar, executor));
                hashSet.add(new zzdij(zzfgvVar, executor));
                zzdgjVar2.a(zzfgvVar, executor);
            }
            zzdky zzdkyVarP2 = zzclgVar.p();
            zzczs zzczsVar2 = new zzczs();
            zzczsVar2.f27511a = context;
            zzczsVar2.f27512b = zzfikVarA;
            ((zzcnn) zzdkyVarP2).f26721e = new zzczt(zzczsVar2);
            zzdgjVar2.d(zzeqpVar, executor);
            hashSet2.add(new zzdij(zzeqpVar, executor));
            hashSet.add(new zzdij(zzeqpVar, executor));
            zzdgjVar2.a(zzeqpVar, executor);
            zzdgjVar2.f27724c.add(new zzdij(zzeqpVar, executor));
            zzdgjVar2.c(zzeqpVar, executor);
            zzdgjVar2.b(zzeqpVar, executor);
            zzdgjVar2.f27734m.add(new zzdij(zzeqpVar, executor));
            zzdgjVar2.f27733l.add(new zzdij(zzeqpVar, executor));
            zzcnn zzcnnVar2 = (zzcnn) zzdkyVarP2;
            zzcnnVar2.f26720d = new zzdgk(zzdgjVar2);
            zzcnnVar2.f26722f = new zzeow(this.f31037f);
            zzdkzVarZzh = zzcnnVar2.zzh();
        }
        zzdkz zzdkzVar = zzdkzVarZzh;
        if (((Boolean) zzbid.f25133c.c()).booleanValue()) {
            zzfnoVarC = zzdkzVar.c();
            zzfnoVarC.i(4);
            zzfnoVarC.c(zzmVar.p);
            zzfnoVarC.d(zzmVar.f21266m);
        } else {
            zzfnoVarC = null;
        }
        zzfno zzfnoVar = zzfnoVarC;
        zzcwo zzcwoVarB = zzdkzVar.b();
        zzfmb zzfmbVarC = zzcwoVarB.c(zzcwoVarB.b());
        this.f31040i = zzfmbVarC;
        zzfmbVarC.q(new zzgyk(zzfmbVarC, new zzfft(this, zzereVar, zzfnoVar, zzfneVarE, zzdkzVar)), executor);
        return true;
    }

    public final boolean b() {
        zzfmb zzfmbVar = this.f31040i;
        return (zzfmbVar == null || zzfmbVar.f31386c.isDone()) ? false : true;
    }
}
