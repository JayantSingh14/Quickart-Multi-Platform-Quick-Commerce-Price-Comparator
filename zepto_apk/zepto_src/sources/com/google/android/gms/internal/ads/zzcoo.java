package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsClient;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzcoo extends com.google.android.gms.ads.internal.client.zzda {

    /* renamed from: a, reason: collision with root package name */
    public final Context f26820a;

    /* renamed from: b, reason: collision with root package name */
    public final VersionInfoParcel f26821b;

    /* renamed from: c, reason: collision with root package name */
    public final zzduu f26822c;

    /* renamed from: d, reason: collision with root package name */
    public final zzeji f26823d;

    /* renamed from: e, reason: collision with root package name */
    public final zzepk f26824e;

    /* renamed from: f, reason: collision with root package name */
    public final zzdzp f26825f;

    /* renamed from: g, reason: collision with root package name */
    public final zzcbw f26826g;

    /* renamed from: h, reason: collision with root package name */
    public final zzduz f26827h;

    /* renamed from: i, reason: collision with root package name */
    public final zzeak f26828i;

    /* renamed from: j, reason: collision with root package name */
    public final zzbje f26829j;

    /* renamed from: k, reason: collision with root package name */
    public final zzfnr f26830k;

    /* renamed from: l, reason: collision with root package name */
    public final zzfjg f26831l;

    /* renamed from: m, reason: collision with root package name */
    public final zzcxv f26832m;
    public final zzdxe n;
    public boolean o = false;
    public final Long p = Long.valueOf(com.google.android.gms.ads.internal.zzt.C.f21687k.elapsedRealtime());

    public zzcoo(Context context, VersionInfoParcel versionInfoParcel, zzduu zzduuVar, zzeji zzejiVar, zzepk zzepkVar, zzdzp zzdzpVar, zzcbw zzcbwVar, zzduz zzduzVar, zzeak zzeakVar, zzbje zzbjeVar, zzfnr zzfnrVar, zzfjg zzfjgVar, zzcxv zzcxvVar, zzdxe zzdxeVar) {
        this.f26820a = context;
        this.f26821b = versionInfoParcel;
        this.f26822c = zzduuVar;
        this.f26823d = zzejiVar;
        this.f26824e = zzepkVar;
        this.f26825f = zzdzpVar;
        this.f26826g = zzcbwVar;
        this.f26827h = zzduzVar;
        this.f26828i = zzeakVar;
        this.f26829j = zzbjeVar;
        this.f26830k = zzfnrVar;
        this.f26831l = zzfjgVar;
        this.f26832m = zzcxvVar;
        this.n = zzdxeVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final synchronized void B0(boolean z) {
        com.google.android.gms.ads.internal.util.zzaa zzaaVar = com.google.android.gms.ads.internal.zzt.C.f21685i;
        synchronized (zzaaVar) {
            zzaaVar.f21456a = z;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void H2(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.c("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) ObjectWrapper.z0(iObjectWrapper);
        if (context == null) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.c("Context is null. Failed to open debug menu.");
        } else {
            com.google.android.gms.ads.internal.util.zzat zzatVar = new com.google.android.gms.ads.internal.util.zzat(context);
            zzatVar.f21489d = str;
            zzatVar.f21490e = this.f26821b.f21400a;
            zzatVar.b();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void I2(com.google.android.gms.ads.internal.client.zzfv zzfvVar) {
        zzcbw zzcbwVar = this.f26826g;
        Context context = this.f26820a;
        zzcbwVar.getClass();
        zzcbp zzcbpVarA = zzcbx.b(context).a();
        zzcbpVarA.f25845b.a(-1, zzcbpVarA.f25844a.currentTimeMillis());
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.N0)).booleanValue() && zzcbwVar.a(context) && zzcbw.g(context)) {
            synchronized (zzcbwVar.f25871i) {
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void T1(IObjectWrapper iObjectWrapper, String str) throws JSONException {
        String strQ;
        Runnable runnable;
        Context context = this.f26820a;
        zzbgk.a(context);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.O4)).booleanValue()) {
            try {
                com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
                strQ = com.google.android.gms.ads.internal.util.zzs.Q(context);
            } catch (RemoteException | RuntimeException e2) {
                com.google.android.gms.ads.internal.zzt.C.f21684h.d("NonagonMobileAdsSettingManager_AppId", e2);
            }
        } else {
            strQ = "";
        }
        boolean z = true;
        String str2 = true == TextUtils.isEmpty(strQ) ? str : strQ;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        zzbgb zzbgbVar = zzbgk.H4;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        boolean zBooleanValue = ((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue();
        zzbgb zzbgbVar2 = zzbgk.n1;
        zzbgi zzbgiVar = zzbdVar.f21153c;
        boolean zBooleanValue2 = zBooleanValue | ((Boolean) zzbgiVar.a(zzbgbVar2)).booleanValue();
        if (((Boolean) zzbgiVar.a(zzbgbVar2)).booleanValue()) {
            final Runnable runnable2 = (Runnable) ObjectWrapper.z0(iObjectWrapper);
            runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzcol
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzgyw zzgywVar = zzcdo.f25987f;
                    final zzcoo zzcooVar = this.f26815a;
                    final Runnable runnable3 = runnable2;
                    ((zzcdn) zzgywVar).execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcom
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzfir zzfirVar;
                            zzcoo zzcooVar2 = zzcooVar;
                            zzcooVar2.getClass();
                            Preconditions.checkMainThread("Adapters must be initialized on the main thread.");
                            HashMap map = com.google.android.gms.ads.internal.zzt.C.f21684h.g().i().f25909c;
                            if (map.isEmpty()) {
                                return;
                            }
                            Runnable runnable4 = runnable3;
                            if (runnable4 != null) {
                                try {
                                    runnable4.run();
                                } catch (Throwable th) {
                                    int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                                    com.google.android.gms.ads.internal.util.client.zzo.g("Could not initialize rewarded ads.", th);
                                    return;
                                }
                            }
                            if (((zzbsz) zzcooVar2.f26822c.f28608a.f31269c.get()) != null) {
                                HashMap map2 = new HashMap();
                                Iterator it = map.values().iterator();
                                while (it.hasNext()) {
                                    for (zzbss zzbssVar : ((zzbst) it.next()).f25537a) {
                                        String str3 = zzbssVar.f25535b;
                                        for (String str4 : zzbssVar.f25534a) {
                                            if (!map2.containsKey(str4)) {
                                                map2.put(str4, new ArrayList());
                                            }
                                            if (str3 != null) {
                                                ((List) map2.get(str4)).add(str3);
                                            }
                                        }
                                    }
                                }
                                JSONObject jSONObject = new JSONObject();
                                for (Map.Entry entry : map2.entrySet()) {
                                    String str5 = (String) entry.getKey();
                                    try {
                                        zzejj zzejjVarA = zzcooVar2.f26823d.a(str5, jSONObject);
                                        if (zzejjVarA != null) {
                                            zzfji zzfjiVar = (zzfji) zzejjVarA.f29463b;
                                            boolean zA = zzfjiVar.a();
                                            zzbtc zzbtcVar = zzfjiVar.f31270a;
                                            if (!zA) {
                                                try {
                                                    if (zzbtcVar.y()) {
                                                        try {
                                                            zzbtcVar.g4(new ObjectWrapper(zzcooVar2.f26820a), (zzekw) zzejjVarA.f29464c, (List) entry.getValue());
                                                            StringBuilder sb = new StringBuilder(String.valueOf(str5).length() + 45);
                                                            sb.append("Initialized rewarded video mediation adapter ");
                                                            sb.append(str5);
                                                            String string = sb.toString();
                                                            int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                                                            com.google.android.gms.ads.internal.util.client.zzo.a(string);
                                                        } finally {
                                                        }
                                                    }
                                                } finally {
                                                }
                                            }
                                        }
                                    } catch (zzfir e3) {
                                        String strS = android.support.v4.media.b.s(new StringBuilder(String.valueOf(str5).length() + 56), "Failed to initialize rewarded video mediation adapter \"", str5, "\"");
                                        int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
                                        com.google.android.gms.ads.internal.util.client.zzo.g(strS, e3);
                                    }
                                }
                            }
                        }
                    });
                }
            };
        } else {
            runnable = null;
            z = zBooleanValue2;
        }
        Runnable runnable3 = runnable;
        if (z) {
            com.google.android.gms.ads.internal.zzt.C.f21688l.a(this.f26820a, this.f26821b, true, null, str2, null, runnable3, this.f26830k, this.n, this.p, this.f26828i.f());
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void Y0(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Ba)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.C.f21684h.f25937g = str;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void d5(zzbsz zzbszVar) {
        this.f26831l.b(zzbszVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void g0(boolean z) throws IOException, RemoteException {
        try {
            Context context = this.f26820a;
            zzfzg.a(context).b(z);
            if (z) {
                return;
            }
            try {
                if (context.getSharedPreferences("query_info_shared_prefs", 0).edit().clear().commit()) {
                } else {
                    throw new IOException("Failed to remove query_info_shared_prefs");
                }
            } catch (IOException e2) {
                com.google.android.gms.ads.internal.zzt.C.f21684h.d("clearStorageOnGpidPubDisable_scar", e2);
            }
        } catch (IOException e3) {
            throw new RemoteException(e3.getMessage());
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final synchronized void j() {
        zzbgb zzbgbVar = zzbgk.N2;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            zzbrw zzbrwVar = com.google.android.gms.ads.internal.zzt.C.r;
            synchronized (zzbrwVar.f25499a) {
                try {
                    zzbsf zzbsfVar = zzbrwVar.f25501c;
                    if (zzbsfVar != null) {
                        zzbrr zzbrrVar = zzbsfVar.f25508a;
                        zzbrq zzbrqVar = zzbrrVar.f25495h;
                        if (zzbrqVar != null) {
                            zzbrqVar.f();
                            zzbrrVar.f25495h = null;
                        }
                        zzbrwVar.f25501c = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (((Boolean) zzbdVar.f21153c.a(zzbgk.O2)).booleanValue()) {
                com.google.android.gms.ads.internal.client.zzbb.f21141g.f21144c = true;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final synchronized void o0(float f2) {
        com.google.android.gms.ads.internal.util.zzaa zzaaVar = com.google.android.gms.ads.internal.zzt.C.f21685i;
        synchronized (zzaaVar) {
            zzaaVar.f21457b = f2;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final synchronized void ra(String str) {
        Context context = this.f26820a;
        zzbgk.a(context);
        if (!TextUtils.isEmpty(str)) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.H4)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.C.f21688l.a(context, this.f26821b, true, null, str, null, null, this.f26830k, null, null, this.f26828i.f());
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void t2(com.google.android.gms.ads.internal.client.zzdn zzdnVar) {
        this.f26828i.e(zzdnVar, zzeaj.f28930b);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void u0(String str) {
        this.f26824e.b(str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void v2(zzbpt zzbptVar) {
        zzdzp zzdzpVar = this.f26825f;
        zzdzpVar.getClass();
        zzdzpVar.f28850e.f25992a.q(new zzdzo(zzdzpVar, zzbptVar), zzdzpVar.f28855j);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final synchronized void zze() {
        if (this.o) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Mobile ads is initialized already.");
            return;
        }
        zzbgb zzbgbVar = zzbgk.O2;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            com.google.android.gms.ads.internal.client.zzbb.a();
        }
        Context context = this.f26820a;
        zzbgk.a(context);
        VersionInfoParcel versionInfoParcel = this.f26821b;
        zzdxe zzdxeVar = this.n;
        com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
        zztVar.f21684h.b(context, versionInfoParcel, zzdxeVar);
        this.f26832m.b();
        zztVar.f21686j.a(context);
        this.o = true;
        this.f26825f.a();
        final zzepk zzepkVar = this.f26824e;
        zzepkVar.getClass();
        com.google.android.gms.ads.internal.util.zzj zzjVarG = zztVar.f21684h.g();
        zzjVarG.f21582c.add(new Runnable() { // from class: com.google.android.gms.internal.ads.zzepj
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                final zzepk zzepkVar2 = zzepkVar;
                zzepkVar2.getClass();
                zzepkVar2.f30036f.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzepi
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzepkVar2.c();
                    }
                });
            }
        });
        zzepkVar.f30036f.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeph
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzepkVar.c();
            }
        });
        if (((Boolean) zzbdVar.f21153c.a(zzbgk.J4)).booleanValue()) {
            final zzduz zzduzVar = this.f26827h;
            if (!zzduzVar.f28620f.getAndSet(true)) {
                com.google.android.gms.ads.internal.util.zzj zzjVarG2 = zztVar.f21684h.g();
                zzjVarG2.f21582c.add(new zzduw(zzduzVar));
            }
            zzduzVar.f28617c.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzduy
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzduzVar.a();
                }
            });
        }
        this.f26828i.a();
        if (((Boolean) zzbdVar.f21153c.a(zzbgk.pa)).booleanValue()) {
            ((zzcdn) zzcdo.f25982a).execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcon
                @Override // java.lang.Runnable
                public final void run() {
                    boolean z;
                    String str;
                    zzcoo zzcooVar = this.f26819a;
                    zzcooVar.getClass();
                    com.google.android.gms.ads.internal.zzt zztVar2 = com.google.android.gms.ads.internal.zzt.C;
                    com.google.android.gms.ads.internal.util.zzj zzjVarG3 = zztVar2.f21684h.g();
                    zzjVarG3.d();
                    synchronized (zzjVarG3.f21580a) {
                        z = zzjVarG3.y;
                    }
                    if (z) {
                        com.google.android.gms.ads.internal.util.zzj zzjVarG4 = zztVar2.f21684h.g();
                        zzjVarG4.d();
                        synchronized (zzjVarG4.f21580a) {
                            str = zzjVarG4.z;
                        }
                        if (zztVar2.o.b(zzcooVar.f26820a, str, zzcooVar.f26821b.f21400a)) {
                            return;
                        }
                        zztVar2.f21684h.g().a(false);
                        zztVar2.f21684h.g().b("");
                    }
                }
            });
        }
        if (((Boolean) zzbdVar.f21153c.a(zzbgk.cc)).booleanValue()) {
            ((zzcdn) zzcdo.f25982a).execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcok
                @Override // java.lang.Runnable
                public final void run() {
                    zzcoo zzcooVar = this.f26814a;
                    zzcooVar.getClass();
                    zzbxz zzbxzVar = new zzbxz();
                    zzbje zzbjeVar = zzcooVar.f26829j;
                    zzbjeVar.getClass();
                    try {
                        zzbjf zzbjfVar = (zzbjf) com.google.android.gms.ads.internal.util.client.zzs.a(zzbjeVar.f25230a, "com.google.android.gms.ads.flags.FlagRetrieverSupplierProxy", zzbjd.f25229a);
                        Parcel parcelG = zzbjfVar.g();
                        zzbcd.e(parcelG, zzbxzVar);
                        zzbjfVar.j1(1, parcelG);
                    } catch (RemoteException e2) {
                        com.google.android.gms.ads.internal.util.client.zzo.f("Error calling setFlagsAccessedBeforeInitializedListener: ".concat(String.valueOf(e2.getMessage())));
                    } catch (com.google.android.gms.ads.internal.util.client.zzr e3) {
                        com.google.android.gms.ads.internal.util.client.zzo.f("Could not load com.google.android.gms.ads.flags.FlagRetrieverSupplierProxy:".concat(String.valueOf(e3.getMessage())));
                    }
                }
            });
        }
        if (((Boolean) zzbdVar.f21153c.a(zzbgk.D3)).booleanValue()) {
            ((zzcdn) zzcdo.f25982a).execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcoi
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzfjp.a(this.f26812a.f26820a, true);
                }
            });
        }
        if (((Boolean) zzbdVar.f21153c.a(zzbgk.o5)).booleanValue()) {
            if (((Boolean) zzbdVar.f21153c.a(zzbgk.p5)).booleanValue()) {
                ((zzcdn) zzcdo.f25982a).execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcoj
                    @Override // java.lang.Runnable
                    public final void run() {
                        String strA;
                        zzcoo zzcooVar = this.f26813a;
                        zzcooVar.getClass();
                        zzbhj zzbhjVar = com.google.android.gms.ads.internal.zzt.C.n;
                        if (zzbhjVar.f25058b.getAndSet(true)) {
                            return;
                        }
                        Context context2 = zzcooVar.f26820a;
                        zzbhjVar.f25059c = context2;
                        zzbhjVar.f25060d = zzcooVar.n;
                        if (zzbhjVar.f25062f != null || context2 == null || (strA = CustomTabsClient.a(context2, null)) == null || strA.equals(context2.getPackageName())) {
                            return;
                        }
                        zzbhjVar.f1351a = context2.getApplicationContext();
                        Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
                        if (!TextUtils.isEmpty(strA)) {
                            intent.setPackage(strA);
                        }
                        context2.bindService(intent, zzbhjVar, 33);
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final synchronized float zzk() {
        return com.google.android.gms.ads.internal.zzt.C.f21685i.a();
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final synchronized boolean zzl() {
        boolean z;
        com.google.android.gms.ads.internal.util.zzaa zzaaVar = com.google.android.gms.ads.internal.zzt.C.f21685i;
        synchronized (zzaaVar) {
            z = zzaaVar.f21456a;
        }
        return z;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final String zzm() {
        return this.f26821b.f21400a;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final List zzq() {
        return this.f26825f.b();
    }

    @Override // com.google.android.gms.ads.internal.client.zzdb
    public final void zzs() {
        this.f26825f.q = false;
    }
}
