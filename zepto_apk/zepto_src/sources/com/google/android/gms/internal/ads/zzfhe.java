package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import org.json.JSONException;

/* loaded from: classes4.dex */
public final class zzfhe implements zzerf {

    /* renamed from: a, reason: collision with root package name */
    public final Context f31097a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f31098b;

    /* renamed from: c, reason: collision with root package name */
    public final zzclg f31099c;

    /* renamed from: d, reason: collision with root package name */
    public final zzfgv f31100d;

    /* renamed from: e, reason: collision with root package name */
    public final zzffj f31101e;

    /* renamed from: f, reason: collision with root package name */
    public final zzfid f31102f;

    /* renamed from: g, reason: collision with root package name */
    public final zzfnr f31103g;

    /* renamed from: h, reason: collision with root package name */
    public final zzfij f31104h;

    /* renamed from: i, reason: collision with root package name */
    public ListenableFuture f31105i;

    public zzfhe(Context context, Executor executor, zzclg zzclgVar, zzffj zzffjVar, zzfgv zzfgvVar, zzfij zzfijVar, zzfid zzfidVar) {
        this.f31097a = context;
        this.f31098b = executor;
        this.f31099c = zzclgVar;
        this.f31101e = zzffjVar;
        this.f31100d = zzfgvVar;
        this.f31104h = zzfijVar;
        this.f31102f = zzfidVar;
        this.f31103g = zzclgVar.z();
    }

    public final boolean a(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzerd zzerdVar, zzere zzereVar) throws JSONException {
        zzfno zzfnoVarZzd;
        zzbzt zzbztVar = new zzbzt(zzmVar, str);
        Executor executor = this.f31098b;
        String str2 = zzbztVar.f25780b;
        if (str2 == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.c("Ad unit ID should not be null for rewarded video ad.");
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfhc
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzfhe zzfheVar = this.f31095a;
                    zzfheVar.getClass();
                    zzfheVar.f31100d.m0(zzfjm.d(6, null, null));
                }
            });
            return false;
        }
        ListenableFuture listenableFuture = this.f31105i;
        if (listenableFuture != null && !listenableFuture.isDone()) {
            return false;
        }
        zzbgb zzbgbVar = zzbgk.O2;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            com.google.android.gms.ads.internal.client.zzbb.a();
        }
        boolean zBooleanValue = ((Boolean) zzbid.f25133c.c()).booleanValue();
        zzffj zzffjVar = this.f31101e;
        com.google.android.gms.ads.internal.client.zzm zzmVar2 = zzbztVar.f25779a;
        if (!zBooleanValue || zzffjVar.zzd() == null) {
            zzfnoVarZzd = null;
        } else {
            zzfnoVarZzd = ((zzcnz) ((zzdtj) zzffjVar.zzd())).zzd();
            zzfnoVarZzd.i(5);
            zzfnoVarZzd.c(zzmVar2.p);
            zzfnoVarZzd.d(zzmVar2.f21266m);
        }
        boolean z = zzmVar2.f21259f;
        Context context = this.f31097a;
        zzfjh.b(context, z);
        if (((Boolean) zzbdVar.f21153c.a(zzbgk.aa)).booleanValue() && z) {
            this.f31099c.y().b(true);
        }
        Bundle bundleA = zzdwo.a(new Pair("api-call", Long.valueOf(zzmVar2.z)), new Pair("dynamite-enter", Long.valueOf(com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis())));
        zzfij zzfijVar = this.f31104h;
        zzfijVar.f31202c = str2;
        zzfijVar.f31201b = new com.google.android.gms.ads.internal.client.zzr("reward_mb", 0, 0, true, 0, 0, null, false, false, false, false, false, false, false, false);
        zzfijVar.f31200a = zzmVar2;
        zzfijVar.t = bundleA;
        zzfik zzfikVarA = zzfijVar.a();
        zzfne zzfneVarE = zzfne.e(context, zzfnn.b(zzfikVarA), 5, zzmVar2);
        zzfhd zzfhdVar = new zzfhd();
        zzfhdVar.f31096a = zzfikVarA;
        ListenableFuture listenableFutureA = zzffjVar.a(new zzffk(zzfhdVar, null), new zzffi() { // from class: com.google.android.gms.internal.ads.zzfhb
            @Override // com.google.android.gms.internal.ads.zzffi
            public final /* synthetic */ zzczq a(zzffh zzffhVar) {
                return this.f31094a.b(zzffhVar);
            }
        });
        this.f31105i = listenableFutureA;
        listenableFutureA.q(new zzgyk(listenableFutureA, new zzfha(this, zzereVar, zzfnoVarZzd, zzfneVarE, zzfhdVar)), executor);
        return true;
    }

    public final zzdti b(zzffh zzffhVar) {
        zzdti zzdtiVarS = this.f31099c.s();
        zzczs zzczsVar = new zzczs();
        zzczsVar.f27511a = this.f31097a;
        zzczsVar.f27512b = ((zzfhd) zzffhVar).f31096a;
        zzczsVar.f27514d = this.f31102f;
        ((zzcny) zzdtiVarS).f26767e = new zzczt(zzczsVar);
        ((zzcny) zzdtiVarS).f26766d = new zzdgk(new zzdgj());
        return zzdtiVarS;
    }
}
