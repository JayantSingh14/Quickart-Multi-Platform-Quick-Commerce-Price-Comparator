package com.google.android.gms.internal.ads;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import java.util.HashSet;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import org.json.JSONException;

/* loaded from: classes4.dex */
public final class zzfef implements zzerf {

    /* renamed from: a, reason: collision with root package name */
    public final Context f30941a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f30942b;

    /* renamed from: c, reason: collision with root package name */
    public final zzclg f30943c;

    /* renamed from: d, reason: collision with root package name */
    public final zzeqp f30944d;

    /* renamed from: e, reason: collision with root package name */
    public final zzeqt f30945e;

    /* renamed from: f, reason: collision with root package name */
    public final FrameLayout f30946f;

    /* renamed from: g, reason: collision with root package name */
    public zzbhf f30947g;

    /* renamed from: h, reason: collision with root package name */
    public final zzddl f30948h;

    /* renamed from: i, reason: collision with root package name */
    public final zzfnr f30949i;

    /* renamed from: j, reason: collision with root package name */
    public final zzdfq f30950j;

    /* renamed from: k, reason: collision with root package name */
    public final zzfij f30951k;

    /* renamed from: l, reason: collision with root package name */
    public zzfmb f30952l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f30953m;
    public com.google.android.gms.ads.internal.client.zze n;
    public zzere o;

    public zzfef(Context context, Executor executor, com.google.android.gms.ads.internal.client.zzr zzrVar, zzclg zzclgVar, zzeqp zzeqpVar, zzeqt zzeqtVar, zzfij zzfijVar, zzdfq zzdfqVar) {
        this.f30941a = context;
        this.f30942b = executor;
        this.f30943c = zzclgVar;
        this.f30944d = zzeqpVar;
        this.f30945e = zzeqtVar;
        this.f30951k = zzfijVar;
        this.f30948h = zzclgVar.i();
        this.f30949i = zzclgVar.z();
        this.f30946f = new FrameLayout(context);
        this.f30950j = zzdfqVar;
        zzfijVar.f31201b = zzrVar;
        this.f30953m = true;
        this.n = null;
        this.o = null;
    }

    public final boolean a(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzerd zzerdVar, zzere zzereVar) throws JSONException {
        zzcuh zzcuhVarZzh;
        Executor executor = this.f30942b;
        if (str == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.c("Ad unit ID should not be null for banner ad.");
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfed
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzfef zzfefVar = this.f30939a;
                    zzfefVar.getClass();
                    zzfefVar.f30944d.m0(zzfjm.d(6, null, null));
                }
            });
            return false;
        }
        boolean zB = b();
        zzfij zzfijVar = this.f30951k;
        if (!zB) {
            zzbgb zzbgbVar = zzbgk.O2;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
            if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                com.google.android.gms.ads.internal.client.zzbb.a();
            }
            zzbgb zzbgbVar2 = zzbgk.aa;
            zzbgi zzbgiVar = zzbdVar.f21153c;
            boolean zBooleanValue = ((Boolean) zzbgiVar.a(zzbgbVar2)).booleanValue();
            zzclg zzclgVar = this.f30943c;
            if (zBooleanValue && zzmVar.f21259f) {
                zzclgVar.y().b(true);
            }
            Bundle bundleA = zzdwo.a(new Pair("api-call", Long.valueOf(zzmVar.z)), new Pair("dynamite-enter", Long.valueOf(com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis())));
            zzfijVar.f31202c = str;
            zzfijVar.f31200a = zzmVar;
            zzfijVar.t = bundleA;
            zzfik zzfikVarA = zzfijVar.a();
            int iB = zzfnn.b(zzfikVarA);
            Context context = this.f30941a;
            zzfne zzfneVarE = zzfne.e(context, iB, 3, zzmVar);
            boolean zBooleanValue2 = ((Boolean) zzbiq.f25207e.c()).booleanValue();
            zzeqp zzeqpVar = this.f30944d;
            zzfno zzfnoVarC = null;
            if (!zBooleanValue2 || !zzfijVar.f31201b.f21291k) {
                boolean zBooleanValue3 = ((Boolean) zzbgiVar.a(zzbgk.g9)).booleanValue();
                FrameLayout frameLayout = this.f30946f;
                zzdfq zzdfqVar = this.f30950j;
                zzddl zzddlVar = this.f30948h;
                if (zBooleanValue3) {
                    zzcug zzcugVarL = zzclgVar.l();
                    zzczs zzczsVar = new zzczs();
                    zzczsVar.f27511a = context;
                    zzczsVar.f27512b = zzfikVarA;
                    ((zzcnc) zzcugVarL).f26641e = new zzczt(zzczsVar);
                    zzdgj zzdgjVar = new zzdgj();
                    zzdgjVar.d(zzeqpVar, executor);
                    zzdgjVar.b(zzeqpVar, executor);
                    zzcnc zzcncVar = (zzcnc) zzcugVarL;
                    zzcncVar.f26640d = new zzdgk(zzdgjVar);
                    zzcncVar.f26642f = new zzeow(this.f30947g);
                    zzcncVar.f26646j = new zzdlq(zzdnw.f28057h, null);
                    zzcncVar.f26643g = new zzcvc(zzddlVar, zzdfqVar);
                    zzcncVar.f26645i = new zzcsz(frameLayout);
                    zzcuhVarZzh = zzcncVar.zzh();
                } else {
                    zzcug zzcugVarL2 = zzclgVar.l();
                    zzczs zzczsVar2 = new zzczs();
                    zzczsVar2.f27511a = context;
                    zzczsVar2.f27512b = zzfikVarA;
                    ((zzcnc) zzcugVarL2).f26641e = new zzczt(zzczsVar2);
                    zzdgj zzdgjVar2 = new zzdgj();
                    zzdgjVar2.d(zzeqpVar, executor);
                    zzdij zzdijVar = new zzdij(zzeqpVar, executor);
                    HashSet hashSet = zzdgjVar2.f27724c;
                    hashSet.add(zzdijVar);
                    hashSet.add(new zzdij(this.f30945e, executor));
                    zzdgjVar2.c(zzeqpVar, executor);
                    zzdgjVar2.f27727f.add(new zzdij(zzeqpVar, executor));
                    zzdgjVar2.f27726e.add(new zzdij(zzeqpVar, executor));
                    zzdgjVar2.f27729h.add(new zzdij(zzeqpVar, executor));
                    zzdgjVar2.a(zzeqpVar, executor);
                    zzdgjVar2.b(zzeqpVar, executor);
                    zzdgjVar2.f27734m.add(new zzdij(zzeqpVar, executor));
                    zzcnc zzcncVar2 = (zzcnc) zzcugVarL2;
                    zzcncVar2.f26640d = new zzdgk(zzdgjVar2);
                    zzcncVar2.f26642f = new zzeow(this.f30947g);
                    zzcncVar2.f26646j = new zzdlq(zzdnw.f28057h, null);
                    zzcncVar2.f26643g = new zzcvc(zzddlVar, zzdfqVar);
                    zzcncVar2.f26645i = new zzcsz(frameLayout);
                    zzcuhVarZzh = zzcncVar2.zzh();
                }
                if (((Boolean) zzbid.f25133c.c()).booleanValue()) {
                    zzfnoVarC = zzcuhVarZzh.c();
                    zzfnoVarC.i(3);
                    zzfnoVarC.c(zzmVar.p);
                    zzfnoVarC.d(zzmVar.f21266m);
                }
                this.o = zzereVar;
                zzcwo zzcwoVarB = zzcuhVarZzh.b();
                zzfmb zzfmbVarC = zzcwoVarB.c(zzcwoVarB.b());
                this.f30952l = zzfmbVarC;
                zzfmbVarC.q(new zzgyk(zzfmbVarC, new zzfeb(this, zzfnoVarC, zzfneVarE, zzcuhVarZzh)), executor);
                return true;
            }
            if (zzeqpVar != null) {
                zzeqpVar.m0(zzfjm.d(7, null, null));
            }
        } else if (!zzfijVar.p) {
            this.f30953m = true;
            return false;
        }
        return false;
    }

    public final boolean b() {
        zzfmb zzfmbVar = this.f30952l;
        return (zzfmbVar == null || zzfmbVar.f31386c.isDone()) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c() {
        synchronized (this) {
            try {
                zzfmb zzfmbVar = this.f30952l;
                if (zzfmbVar != null && zzfmbVar.f31386c.isDone()) {
                    try {
                        zzctc zzctcVar = (zzctc) this.f30952l.f31386c.get();
                        this.f30952l = null;
                        FrameLayout frameLayout = this.f30946f;
                        frameLayout.removeAllViews();
                        zzctcVar.getClass();
                        ViewParent parent = zzctcVar.c().getParent();
                        if (parent instanceof ViewGroup) {
                            String str = zzctcVar.f27232f.f27543a;
                            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 78);
                            sb.append("Banner view provided from ");
                            sb.append(str);
                            sb.append(" already has a parent view. Removing its old parent.");
                            String string = sb.toString();
                            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                            com.google.android.gms.ads.internal.util.client.zzo.f(string);
                            ((ViewGroup) parent).removeView(zzctcVar.c());
                        }
                        zzbgb zzbgbVar = zzbgk.g9;
                        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                            zzdea zzdeaVar = zzctcVar.f27233g.f27693a;
                            zzeqp zzeqpVar = this.f30944d;
                            zzdfb zzdfbVar = zzdeaVar.f27665a;
                            zzdfbVar.f27694b = zzeqpVar;
                            zzdfbVar.f27695c = this.f30945e;
                        }
                        frameLayout.addView(zzctcVar.c());
                        zzere zzereVar = this.o;
                        if (zzereVar != null) {
                            zzereVar.a(zzctcVar);
                        }
                        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                            Executor executor = this.f30942b;
                            final zzeqp zzeqpVar2 = this.f30944d;
                            Objects.requireNonNull(zzeqpVar2);
                            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfee
                                @Override // java.lang.Runnable
                                public final /* synthetic */ void run() {
                                    zzeqpVar2.zzg();
                                }
                            });
                        }
                        if (zzctcVar.i() >= 0) {
                            this.f30953m = false;
                            zzddl zzddlVar = this.f30948h;
                            zzddlVar.w0(zzctcVar.i());
                            zzddlVar.x0(zzctcVar.h());
                        } else {
                            this.f30953m = true;
                            this.f30948h.w0(zzctcVar.h());
                        }
                    } catch (InterruptedException e2) {
                        e = e2;
                        e();
                        com.google.android.gms.ads.internal.util.zze.l("Error occurred while refreshing the ad. Making a new ad request.", e);
                        this.f30953m = true;
                        this.f30948h.zzc();
                    } catch (ExecutionException e3) {
                        e = e3;
                        e();
                        com.google.android.gms.ads.internal.util.zze.l("Error occurred while refreshing the ad. Making a new ad request.", e);
                        this.f30953m = true;
                        this.f30948h.zzc();
                    }
                } else if (this.f30952l != null) {
                    com.google.android.gms.ads.internal.util.zze.k("Show timer went off but there is an ongoing ad request.");
                    this.f30953m = true;
                } else {
                    com.google.android.gms.ads.internal.util.zze.k("No ad request was in progress or an ad was cached when show timer went off. Hence requesting a new ad.");
                    this.f30953m = true;
                    this.f30948h.zzc();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean d() {
        Object parent = this.f30946f.getParent();
        if (!(parent instanceof View)) {
            return false;
        }
        View view = (View) parent;
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
        Context context = view.getContext();
        Context applicationContext = context.getApplicationContext();
        KeyguardManager keyguardManager = null;
        PowerManager powerManager = applicationContext != null ? (PowerManager) applicationContext.getSystemService("power") : null;
        Object systemService = context.getSystemService("keyguard");
        if (systemService != null && (systemService instanceof KeyguardManager)) {
            keyguardManager = (KeyguardManager) systemService;
        }
        return com.google.android.gms.ads.internal.util.zzs.r(view, powerManager, keyguardManager);
    }

    public final void e() {
        this.f30952l = null;
        final com.google.android.gms.ads.internal.client.zze zzeVar = this.n;
        this.n = null;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.g9)).booleanValue() && zzeVar != null) {
            this.f30942b.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfec
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.f30937a.f30944d.m0(zzeVar);
                }
            });
        }
        zzere zzereVar = this.o;
        if (zzereVar != null) {
            zzereVar.zza();
        }
    }
}
