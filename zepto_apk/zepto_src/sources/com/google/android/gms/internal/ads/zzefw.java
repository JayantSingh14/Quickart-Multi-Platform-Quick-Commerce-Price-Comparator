package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzefw extends zzbym {

    /* renamed from: a, reason: collision with root package name */
    public final Context f29244a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgyw f29245b;

    /* renamed from: c, reason: collision with root package name */
    public final zzege f29246c;

    /* renamed from: d, reason: collision with root package name */
    public final zzclg f29247d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayDeque f29248e;

    /* renamed from: f, reason: collision with root package name */
    public final zzfnr f29249f;

    public zzefw(Context context, zzgyw zzgywVar, zzbzi zzbziVar, zzclg zzclgVar, zzege zzegeVar, ArrayDeque arrayDeque, zzfnr zzfnrVar) {
        zzbgk.a(context);
        this.f29244a = context;
        this.f29245b = zzgywVar;
        this.f29246c = zzegeVar;
        this.f29247d = zzclgVar;
        this.f29248e = arrayDeque;
        this.f29249f = zzfnrVar;
    }

    public static zzfmb bc(zzfmb zzfmbVar, zzfmu zzfmuVar, zzbsf zzbsfVar, zzfno zzfnoVar, zzfne zzfneVar) {
        zzbsj zzbsjVarA = zzbsfVar.a("AFMA_getAdDictionary", zzbsc.f25504a, zzefq.f29233a);
        zzfnn.a(zzfmbVar, zzfneVar);
        zzfmb zzfmbVarD = zzfmuVar.a(zzfmbVar, zzfmo.BUILD_URL).b(zzbsjVarA).d();
        if (!((Boolean) zzbid.f25133c.c()).booleanValue()) {
            return zzfmbVarD;
        }
        zzgye zzgyeVarS = zzgye.s(zzfmbVarD);
        zzfnl zzfnlVar = new zzfnl(zzfnoVar, zzfneVar);
        zzgyeVarS.q(new zzgyk(zzgyeVarS, zzfnlVar), zzcdo.f25988g);
        return zzfmbVarD;
    }

    @Override // com.google.android.gms.internal.ads.zzbyn
    public final void Ea(zzbza zzbzaVar, zzbyr zzbyrVar) {
        Bundle bundle;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.z2)).booleanValue() && (bundle = zzbzaVar.f25732m) != null) {
            bundle.putLong("service-connected", com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis());
        }
        cc(ac(zzbzaVar, Binder.getCallingUid()), zzbyrVar, zzbzaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbyn
    public final void I9(zzbza zzbzaVar, zzbyr zzbyrVar) {
        cc(Yb(zzbzaVar, Binder.getCallingUid()), zzbyrVar, zzbzaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbyn
    public final void Vb(String str, zzbyr zzbyrVar) {
        cc(Zb(str), zzbyrVar, null);
    }

    public final zzfmb Xb(final zzbza zzbzaVar, int i2) {
        zzefr zzefrVarDc;
        zzfmb zzfmbVarD;
        zzbrw zzbrwVar = com.google.android.gms.ads.internal.zzt.C.r;
        VersionInfoParcel versionInfoParcelB = VersionInfoParcel.b();
        Context context = this.f29244a;
        zzbsf zzbsfVarA = zzbrwVar.a(context, versionInfoParcelB, this.f29249f);
        zzfaz zzfazVarA = this.f29247d.A(zzbzaVar, i2);
        zzbry zzbryVar = zzeft.f29238d;
        zzbrz zzbrzVar = zzbsc.f25504a;
        zzbsj zzbsjVarA = zzbsfVarA.a("google.afma.response.normalize", zzbryVar, zzbsb.f25503a);
        if (((Boolean) zzbir.f25210a.c()).booleanValue()) {
            zzefrVarDc = dc(zzbzaVar.f25727h);
            if (zzefrVarDc == null) {
                com.google.android.gms.ads.internal.util.zze.k("Request contained a PoolKey but no matching parameters were found.");
            }
        } else {
            String str = zzbzaVar.f25729j;
            if (str != null && !str.isEmpty()) {
                com.google.android.gms.ads.internal.util.zze.k("Request contained a PoolKey but split request is disabled.");
            }
            zzefrVarDc = null;
        }
        zzfne zzfneVarF = zzefrVarDc == null ? zzfne.f(9, context) : zzefrVarDc.f29237d;
        zzfno zzfnoVarC = zzfazVarA.c();
        zzfnoVarC.b(zzbzaVar.f25720a.getStringArrayList("ad_types"));
        zzegd zzegdVar = new zzegd(zzbzaVar.f25726g, zzfnoVarC, zzfneVarF);
        zzega zzegaVar = new zzega(context, zzbzaVar.f25721b.f21400a, null);
        zzfmu zzfmuVarB = zzfazVarA.b();
        zzfne zzfneVarF2 = zzfne.f(11, context);
        zzfmo zzfmoVar = zzfmo.PRE_PROCESS;
        zzfmo zzfmoVar2 = zzfmo.HTTP;
        if (zzefrVarDc == null) {
            final zzfmb zzfmbVarD2 = zzfmuVarB.a(zzgym.a(zzbzaVar.f25720a), zzfmo.GMS_SIGNALS).b(new zzefk(zzfazVarA, zzbzaVar)).a(zzefl.f29222a).d();
            final zzfmb zzfmbVarBc = bc(zzfmbVarD2, zzfmuVarB, zzbsfVarA, zzfnoVarC, zzfneVarF);
            zzfne zzfneVarF3 = zzfne.f(10, context);
            final zzfmb zzfmbVarD3 = new zzfmd(zzfmuVarB, zzfmoVar2, Arrays.asList(zzfmbVarBc, zzfmbVarD2)).a(new Callable() { // from class: com.google.android.gms.internal.ads.zzefp
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Bundle bundle;
                    zzbzc zzbzcVar = (zzbzc) zzfmbVarBc.f31386c.get();
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.z2)).booleanValue() && (bundle = zzbzaVar.f25732m) != null) {
                        bundle.putLong("get-ad-dictionary-sdkcore-start", zzbzcVar.f25742j);
                        bundle.putLong("get-ad-dictionary-sdkcore-end", zzbzcVar.f25743k);
                    }
                    return new zzegc((JSONObject) zzfmbVarD2.f31386c.get(), zzbzcVar);
                }
            }).a(zzegdVar).a(new zzfnm(zzfneVarF3)).a(zzegaVar).d();
            zzfnn.c(zzfmbVarD3, zzfnoVarC, zzfneVarF3, false);
            zzfnn.a(zzfmbVarD3, zzfneVarF2);
            zzfmbVarD = new zzfmd(zzfmuVarB, zzfmoVar, Arrays.asList(zzfmbVarD2, zzfmbVarBc, zzfmbVarD3)).a(new Callable() { // from class: com.google.android.gms.internal.ads.zzefi
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Bundle bundle;
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.z2)).booleanValue() && (bundle = zzbzaVar.f25732m) != null) {
                        bundle.putLong("http-response-ready", com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis());
                    }
                    return new zzeft((zzefz) zzfmbVarD3.f31386c.get(), (JSONObject) zzfmbVarD2.f31386c.get(), (zzbzc) zzfmbVarBc.f31386c.get());
                }
            }).b(zzbsjVarA).d();
        } else {
            zzegc zzegcVar = new zzegc(zzefrVarDc.f29235b, zzefrVarDc.f29234a);
            zzfne zzfneVarF4 = zzfne.f(10, context);
            final zzfmb zzfmbVarD4 = zzfmuVarB.a(zzgym.a(zzegcVar), zzfmoVar2).a(zzegdVar).a(new zzfnm(zzfneVarF4)).a(zzegaVar).d();
            zzfnn.c(zzfmbVarD4, zzfnoVarC, zzfneVarF4, false);
            final ListenableFuture listenableFutureA = zzgym.a(zzefrVarDc);
            zzfnn.a(zzfmbVarD4, zzfneVarF2);
            zzfmbVarD = new zzfmd(zzfmuVarB, zzfmoVar, Arrays.asList(zzfmbVarD4, listenableFutureA)).a(new Callable() { // from class: com.google.android.gms.internal.ads.zzefj
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    zzefz zzefzVar = (zzefz) zzfmbVarD4.f31386c.get();
                    Object obj = ((zzgyq) listenableFutureA).f33379a;
                    return new zzeft(zzefzVar, ((zzefr) obj).f29235b, ((zzefr) obj).f29234a);
                }
            }).b(zzbsjVarA).d();
        }
        zzfnn.c(zzfmbVarD, zzfnoVarC, zzfneVarF2, false);
        return zzfmbVarD;
    }

    public final ListenableFuture Yb(final zzbza zzbzaVar, int i2) {
        if (!((Boolean) zzbir.f25210a.c()).booleanValue()) {
            return zzgym.b(new Exception("Split request is disabled."));
        }
        zzfkg zzfkgVar = zzbzaVar.f25728i;
        if (zzfkgVar == null) {
            return zzgym.b(new Exception("Pool configuration missing from request."));
        }
        if (zzfkgVar.f31310d == 0 || zzfkgVar.f31311e == 0) {
            return zzgym.b(new Exception("Caching is disabled."));
        }
        zzbrw zzbrwVar = com.google.android.gms.ads.internal.zzt.C.r;
        VersionInfoParcel versionInfoParcelB = VersionInfoParcel.b();
        zzfnr zzfnrVar = this.f29249f;
        Context context = this.f29244a;
        zzbsf zzbsfVarA = zzbrwVar.a(context, versionInfoParcelB, zzfnrVar);
        zzfaz zzfazVarA = this.f29247d.A(zzbzaVar, i2);
        zzfmu zzfmuVarB = zzfazVarA.b();
        final zzfmb zzfmbVarD = zzfmuVarB.a(zzgym.a(zzbzaVar.f25720a), zzfmo.GMS_SIGNALS).b(new zzefk(zzfazVarA, zzbzaVar)).a(zzefl.f29222a).d();
        zzfno zzfnoVarC = zzfazVarA.c();
        final zzfne zzfneVarF = zzfne.f(9, context);
        final zzfmb zzfmbVarBc = bc(zzfmbVarD, zzfmuVarB, zzbsfVarA, zzfnoVarC, zzfneVarF);
        return new zzfmd(zzfmuVarB, zzfmo.GET_URL_AND_CACHE_KEY, Arrays.asList(zzfmbVarD, zzfmbVarBc)).a(new Callable() { // from class: com.google.android.gms.internal.ads.zzefm
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzefw zzefwVar = this.f29223a;
                zzfmb zzfmbVar = zzfmbVarBc;
                zzfmb zzfmbVar2 = zzfmbVarD;
                zzbza zzbzaVar2 = zzbzaVar;
                zzfne zzfneVar = zzfneVarF;
                zzefwVar.getClass();
                String str = ((zzbzc) zzfmbVar.f31386c.get()).f25741i;
                zzefr zzefrVar = new zzefr((zzbzc) zzfmbVar.f31386c.get(), (JSONObject) zzfmbVar2.f31386c.get(), zzbzaVar2.f25727h, zzfneVar);
                synchronized (zzefwVar) {
                    synchronized (zzefwVar) {
                        int iIntValue = ((Long) zzbir.f25211b.c()).intValue();
                        while (true) {
                            ArrayDeque arrayDeque = zzefwVar.f29248e;
                            if (arrayDeque.size() >= iIntValue) {
                                arrayDeque.removeFirst();
                            }
                        }
                    }
                    return new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
                }
                zzefwVar.f29248e.addLast(zzefrVar);
                return new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
            }
        }).d();
    }

    public final ListenableFuture Zb(String str) {
        if (((Boolean) zzbir.f25210a.c()).booleanValue()) {
            return dc(str) == null ? zzgym.b(new Exception("URL to be removed not found for cache key: ".concat(String.valueOf(str)))) : zzgym.a(new zzefg());
        }
        return zzgym.b(new Exception("Split request is disabled."));
    }

    public final ListenableFuture ac(final zzbza zzbzaVar, int i2) {
        zzbrw zzbrwVar = com.google.android.gms.ads.internal.zzt.C.r;
        VersionInfoParcel versionInfoParcelB = VersionInfoParcel.b();
        Context context = this.f29244a;
        zzbsf zzbsfVarA = zzbrwVar.a(context, versionInfoParcelB, this.f29249f);
        if (!((Boolean) zzbix.f25222a.c()).booleanValue()) {
            return zzgym.b(new Exception("Signal collection disabled."));
        }
        zzfaz zzfazVarA = this.f29247d.A(zzbzaVar, i2);
        zzcmu zzcmuVar = (zzcmu) zzfazVarA;
        zzcmv zzcmvVar = zzcmuVar.f26567b;
        zzijf zzijfVar = zzcmvVar.S0;
        Context context2 = zzcmvVar.f26577b.f26510b;
        zzijo.a(context2);
        new zzccp();
        new zzccq();
        Object objZzb = zzijfVar.zzb();
        zzfbc zzfbcVarD = zzcmuVar.d();
        new zzbfu();
        zzgyw zzgywVar = zzcdo.f25982a;
        zzijo.a(zzgywVar);
        ArrayList arrayList = zzcmuVar.f26566a.f30832a.f25724e;
        zzijo.a(arrayList);
        zzfbw zzfbwVar = new zzfbw(zzgywVar, arrayList);
        zzija zzijaVarB = zzijf.b(zzcmuVar.f26569d);
        zzija zzijaVarB2 = zzijf.b(zzcmuVar.f26570e);
        zzijf.b(zzcmuVar.f26571f);
        zzija zzijaVarB3 = zzijf.b(zzcmuVar.f26572g);
        zzija zzijaVarB4 = zzijf.b(zzcmuVar.f26573h);
        zzijf.b(zzcmuVar.f26574i);
        zzija zzijaVarB5 = zzijf.b(zzcmuVar.f26575j);
        zzfno zzfnoVar = (zzfno) zzcmuVar.f26568c.zzb();
        zzdxe zzdxeVar = (zzdxe) zzcmvVar.f26587l.zzb();
        HashSet hashSet = new HashSet();
        hashSet.add((zzfbp) objZzb);
        hashSet.add(zzfbcVarD);
        hashSet.add(zzfbwVar);
        zzbgb zzbgbVar = zzbgk.x6;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            hashSet.add((zzezx) zzijaVarB.zzb());
        }
        zzbgb zzbgbVar2 = zzbgk.y6;
        zzbgi zzbgiVar = zzbdVar.f21153c;
        if (((Boolean) zzbgiVar.a(zzbgbVar2)).booleanValue()) {
            hashSet.add((zzezx) zzijaVarB2.zzb());
        }
        if (((Boolean) zzbgiVar.a(zzbgk.A6)).booleanValue()) {
            hashSet.add((zzezx) zzijaVarB3.zzb());
        }
        if (((Boolean) zzbgiVar.a(zzbgk.B6)).booleanValue()) {
            hashSet.add((zzezx) zzijaVarB4.zzb());
        }
        if (((Boolean) zzbgiVar.a(zzbgk.F3)).booleanValue()) {
            hashSet.add((zzezx) zzijaVarB5.zzb());
        }
        final zzfaa zzfaaVar = new zzfaa(context2, zzgywVar, hashSet, zzfnoVar, zzdxeVar);
        zzbsj zzbsjVarA = zzbsfVarA.a("google.afma.request.getSignals", zzbsc.f25504a, zzbsb.f25503a);
        zzfne zzfneVarF = zzfne.f(22, context);
        zzfmu zzfmuVarB = zzfazVarA.b();
        zzfmo zzfmoVar = zzfmo.GET_SIGNALS;
        Bundle bundle = zzbzaVar.f25720a;
        zzfml zzfmlVarB = zzfmuVarB.a(zzgym.a(bundle), zzfmoVar).a(new zzfnm(zzfneVarF)).b(new zzgxu() { // from class: com.google.android.gms.internal.ads.zzefn
            @Override // com.google.android.gms.internal.ads.zzgxu
            public final ListenableFuture zza(Object obj) throws JSONException {
                return zzfaaVar.a(com.google.android.gms.ads.internal.client.zzbb.f21141g.f21142a.m((Bundle) obj), zzbzaVar.f25732m, false);
            }
        });
        zzfmo zzfmoVar2 = zzfmo.JS_SIGNALS;
        zzfmb zzfmbVarD = zzfmlVarB.f31403f.a(zzfmlVarB.d(), zzfmoVar2).b(zzbsjVarA).d();
        zzfno zzfnoVarC = zzfazVarA.c();
        zzfnoVarC.b(bundle.getStringArrayList("ad_types"));
        zzfnoVarC.d(bundle.getBundle("extras"));
        zzfnn.c(zzfmbVarD, zzfnoVarC, zzfneVarF, true);
        if (((Boolean) zzbik.f25184j.c()).booleanValue()) {
            final zzege zzegeVar = this.f29246c;
            Objects.requireNonNull(zzegeVar);
            zzfmbVarD.q(new Runnable() { // from class: com.google.android.gms.internal.ads.zzefu
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzegeVar.a();
                }
            }, this.f29245b);
        }
        return zzfmbVarD;
    }

    public final void cc(ListenableFuture listenableFuture, zzbyr zzbyrVar, zzbza zzbzaVar) {
        ListenableFuture listenableFutureH = zzgym.h(listenableFuture, new zzefo(), zzcdo.f25982a);
        zzefh zzefhVar = new zzefh(this, zzbzaVar, zzbyrVar);
        zzgyw zzgywVar = zzcdo.f25988g;
        ((zzgxf) listenableFutureH).q(new zzgyk(listenableFutureH, zzefhVar), zzgywVar);
    }

    public final synchronized zzefr dc(String str) {
        Iterator it = this.f29248e.iterator();
        while (it.hasNext()) {
            zzefr zzefrVar = (zzefr) it.next();
            if (zzefrVar.f29236c.equals(str)) {
                it.remove();
                return zzefrVar;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbyn
    public final void r3(zzbza zzbzaVar, zzbyr zzbyrVar) {
        Bundle bundle;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.z2)).booleanValue() && (bundle = zzbzaVar.f25732m) != null) {
            bundle.putLong("service-connected", com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis());
        }
        zzfmb zzfmbVarXb = Xb(zzbzaVar, Binder.getCallingUid());
        cc(zzfmbVarXb, zzbyrVar, zzbzaVar);
        if (((Boolean) zzbik.f25183i.c()).booleanValue()) {
            final zzege zzegeVar = this.f29246c;
            Objects.requireNonNull(zzegeVar);
            zzfmbVarXb.q(new Runnable() { // from class: com.google.android.gms.internal.ads.zzefv
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzegeVar.a();
                }
            }, this.f29245b);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbyn
    public final void zzi(String str) throws RemoteException {
        Binder.getCallingUid();
        zzbgb zzbgbVar = zzbgk.f1if;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            String str2 = (String) zzbdVar.f21153c.a(zzbgk.jf);
            if (str2.isEmpty()) {
                return;
            }
            zzgqj zzgqjVar = new zzgqj(zzgqp.a(new zzgpl(',')), str2);
            com.google.android.gms.ads.internal.util.zze.k("AdRequestServiceImpl: Preconnecting");
            Iterator it = zzgqjVar.iterator();
            while (it.hasNext()) {
                String str3 = (String) it.next();
                Context context = this.f29244a;
                zzega zzegaVar = new zzega(context, str, "HEAD");
                HashMap map = new HashMap();
                map.put("User-Agent", com.google.android.gms.ads.internal.zzt.C.f21679c.E(context, str));
                try {
                    zzefz zzefzVarZza = zzegaVar.zza(new zzefy(str3, 30000, map, new byte[0], ""));
                    if (zzefzVarZza.f29260a != 200) {
                        int i2 = zzefzVarZza.f29260a;
                        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 32);
                        sb.append("Unexpected preconnect response: ");
                        sb.append(i2);
                        throw new RemoteException(sb.toString());
                    }
                } catch (Exception e2) {
                    throw new RemoteException(e2.getMessage());
                }
            }
        }
    }
}
