package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzbrr {

    /* renamed from: a, reason: collision with root package name */
    public final Object f25488a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f25489b;

    /* renamed from: c, reason: collision with root package name */
    public final String f25490c;

    /* renamed from: d, reason: collision with root package name */
    public final VersionInfoParcel f25491d;

    /* renamed from: e, reason: collision with root package name */
    public final zzfnr f25492e;

    /* renamed from: f, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.util.zzbc f25493f;

    /* renamed from: g, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.util.zzbc f25494g;

    /* renamed from: h, reason: collision with root package name */
    public zzbrq f25495h;

    /* renamed from: i, reason: collision with root package name */
    public int f25496i;

    public zzbrr(Context context, VersionInfoParcel versionInfoParcel, String str, zzfnr zzfnrVar) {
        com.google.android.gms.ads.internal.util.zzbc zzbcVar = zzbsf.f25506b;
        com.google.android.gms.ads.internal.util.zzbc zzbcVar2 = zzbsf.f25507c;
        this.f25488a = new Object();
        this.f25496i = 1;
        this.f25490c = str;
        this.f25489b = context.getApplicationContext();
        this.f25491d = versionInfoParcel;
        this.f25492e = zzfnrVar;
        this.f25493f = zzbcVar;
        this.f25494g = zzbcVar2;
    }

    public final zzbrq a() {
        zzfne zzfneVarF = zzfne.f(6, this.f25489b);
        zzfneVarF.zza();
        final zzbrq zzbrqVar = new zzbrq(this.f25494g);
        com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > Before UI_THREAD_EXECUTOR");
        ((zzcdn) zzcdo.f25987f).execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbrh
            @Override // java.lang.Runnable
            public final void run() {
                zzbrq zzbrqVar2 = zzbrqVar;
                zzbrr zzbrrVar = this.f25474a;
                zzbrrVar.getClass();
                long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis();
                ArrayList arrayList = new ArrayList();
                try {
                    com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > Before createJavascriptEngine");
                    Context context = zzbrrVar.f25489b;
                    VersionInfoParcel versionInfoParcel = zzbrrVar.f25491d;
                    final zzbqu zzbquVar = new zzbqu();
                    zzcir zzcirVarA = zzcjh.a(context, versionInfoParcel, null, null, null, new zzbfj(), null, new zzclb(0, 0, 0), null, null, null, null, null, "", false, false);
                    zzbquVar.f25440a = zzcirVarA;
                    zzcirVarA.x().setWillNotDraw(true);
                    com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > After createJavascriptEngine");
                    com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > Before setting new engine loaded listener");
                    final zzbrf zzbrfVar = new zzbrf(jCurrentTimeMillis, zzbquVar, zzbrqVar2, zzbrrVar, arrayList);
                    zzcir zzcirVar = zzbquVar.f25440a;
                    if (zzcirVar != null) {
                        zzcirVar.e0().f26376h = new zzcko() { // from class: com.google.android.gms.internal.ads.zzbqo
                            @Override // com.google.android.gms.internal.ads.zzcko
                            public final void zza() {
                                zzbrf zzbrfVar2 = (zzbrf) zzbrfVar;
                                long jCurrentTimeMillis2 = com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis();
                                final long j2 = zzbrfVar2.f25466c;
                                Long lValueOf = Long.valueOf(jCurrentTimeMillis2 - j2);
                                final ArrayList arrayList2 = zzbrfVar2.f25465b;
                                arrayList2.add(lValueOf);
                                String strValueOf = String.valueOf(arrayList2.get(0));
                                StringBuilder sb = new StringBuilder(strValueOf.length() + 52);
                                sb.append("LoadNewJavascriptEngine(onEngLoaded) latency is ");
                                sb.append(strValueOf);
                                sb.append(" ms.");
                                com.google.android.gms.ads.internal.util.zze.k(sb.toString());
                                com.google.android.gms.ads.internal.util.zzf zzfVar = com.google.android.gms.ads.internal.util.zzs.f21608l;
                                final zzbrq zzbrqVar3 = zzbrfVar2.f25467d;
                                final zzbqu zzbquVar2 = zzbrfVar2.f25468e;
                                final zzbrr zzbrrVar2 = zzbrfVar2.f25464a;
                                zzfVar.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbrg
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        zzbrr zzbrrVar3 = zzbrrVar2;
                                        zzbrq zzbrqVar4 = zzbrqVar3;
                                        final zzbqu zzbquVar3 = zzbquVar2;
                                        ArrayList arrayList3 = arrayList2;
                                        long j3 = j2;
                                        zzbrrVar3.getClass();
                                        com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Trying to acquire lock");
                                        synchronized (zzbrrVar3.f25488a) {
                                            try {
                                                com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Lock acquired");
                                                if (zzbrqVar4.f25998b.get() != -1 && zzbrqVar4.f25998b.get() != 1) {
                                                    zzbgb zzbgbVar = zzbgk.w8;
                                                    com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                                                    if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                                                        zzbrqVar4.c("SdkJavascriptFactory.loadJavascriptEngine.setLoadedListener", new TimeoutException("Unable to receive /jsLoaded GMSG."));
                                                    } else {
                                                        zzbrqVar4.b();
                                                    }
                                                    ((zzcdn) zzcdo.f25987f).execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbrc
                                                        @Override // java.lang.Runnable
                                                        public final /* synthetic */ void run() {
                                                            zzbquVar3.zzj();
                                                        }
                                                    });
                                                    String strValueOf2 = String.valueOf(zzbdVar.f21153c.a(zzbgk.f25014d));
                                                    int i2 = zzbrqVar4.f25998b.get();
                                                    int i3 = zzbrrVar3.f25496i;
                                                    String strValueOf3 = String.valueOf(arrayList3.get(0));
                                                    long jCurrentTimeMillis3 = com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis() - j3;
                                                    StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 94 + String.valueOf(i2).length() + 39 + String.valueOf(i3).length() + 57 + strValueOf3.length() + 42 + String.valueOf(jCurrentTimeMillis3).length() + 15);
                                                    sb2.append("Could not receive /jsLoaded in ");
                                                    sb2.append(strValueOf2);
                                                    sb2.append(" ms. JS engine session reference status(onEngLoadedTimeout) is ");
                                                    sb2.append(i2);
                                                    sb2.append(". Update status(onEngLoadedTimeout) is ");
                                                    sb2.append(i3);
                                                    sb2.append(". LoadNewJavascriptEngine(onEngLoadedTimeout) latency is ");
                                                    sb2.append(strValueOf3);
                                                    sb2.append(" ms. Total latency(onEngLoadedTimeout) is ");
                                                    sb2.append(jCurrentTimeMillis3);
                                                    sb2.append(" ms. Rejecting.");
                                                    com.google.android.gms.ads.internal.util.zze.k(sb2.toString());
                                                    com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Lock released");
                                                    return;
                                                }
                                                com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Lock released, the promise is already settled");
                                            } catch (Throwable th) {
                                                throw th;
                                            }
                                        }
                                    }
                                }, ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.f25014d)).intValue());
                            }
                        };
                    }
                    com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > Before registering GmsgHandler for /jsLoaded");
                    zzbquVar.A0("/jsLoaded", new zzbqw(zzbrrVar, jCurrentTimeMillis, zzbrqVar2, zzbquVar));
                    com.google.android.gms.ads.internal.util.zzbv zzbvVar = new com.google.android.gms.ads.internal.util.zzbv();
                    zzbqx zzbqxVar = new zzbqx(zzbrrVar, zzbquVar, zzbvVar);
                    zzbvVar.f21547a = zzbqxVar;
                    com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > Before registering GmsgHandler for /requestReload");
                    if (!((Boolean) zzbik.f25178d.c()).booleanValue() || TextUtils.equals(zzbrrVar.f25489b.getPackageName(), "com.google.android.gms")) {
                        zzbquVar.A0("/requestReload", zzbqxVar);
                    }
                    final String str = zzbrrVar.f25490c;
                    com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > javascriptPath: ".concat(String.valueOf(str)));
                    if (str.endsWith(".js")) {
                        com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > Before newEngine.loadJavascript");
                        com.google.android.gms.ads.internal.util.zze.k("loadJavascript on adWebView from path: ".concat(str));
                        final String str2 = "<!DOCTYPE html><html><head><script src=\"" + str + "\"></script></head><body></body></html>";
                        zzbqu.h(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbqp
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                zzcir zzcirVar2 = zzbquVar.f25440a;
                                if (zzcirVar2 != null) {
                                    zzcirVar2.loadData(str2, "text/html", "UTF-8");
                                }
                            }
                        });
                        com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > After newEngine.loadJavascript");
                    } else if (str.startsWith("<html>")) {
                        com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > Before newEngine.loadHtml");
                        com.google.android.gms.ads.internal.util.zze.k("loadHtml on adWebView from html");
                        zzbqu.h(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbqq
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                zzcir zzcirVar2 = zzbquVar.f25440a;
                                if (zzcirVar2 != null) {
                                    zzcirVar2.loadData(str, "text/html", "UTF-8");
                                }
                            }
                        });
                        com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > After newEngine.loadHtml");
                    } else {
                        com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > Before newEngine.loadHtmlWrapper");
                        com.google.android.gms.ads.internal.util.zze.k("loadHtmlWrapper on adWebView from path: ".concat(str));
                        zzbqu.h(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbqr
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                zzcir zzcirVar2 = zzbquVar.f25440a;
                                if (zzcirVar2 != null) {
                                    zzcirVar2.loadUrl(str);
                                }
                            }
                        });
                        com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > After newEngine.loadHtmlWrapper");
                    }
                    com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > Before calling ADMOB_UI_HANDLER.postDelayed");
                    com.google.android.gms.ads.internal.util.zzs.f21608l.postDelayed(new zzbqz(jCurrentTimeMillis, zzbquVar, zzbrqVar2, zzbrrVar, arrayList), ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.f25015e)).intValue());
                } catch (Throwable th) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.d("Error creating webview.", th);
                    zzbgb zzbgbVar = zzbgk.w8;
                    com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                    if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                        zzbrqVar2.c("SdkJavascriptFactory.loadJavascriptEngine.createJavascriptEngine", th);
                        return;
                    }
                    if (((Boolean) zzbdVar.f21153c.a(zzbgk.y8)).booleanValue()) {
                        com.google.android.gms.ads.internal.zzt.C.f21684h.e("SdkJavascriptFactory.loadJavascriptEngine", th);
                        zzbrqVar2.b();
                    } else {
                        com.google.android.gms.ads.internal.zzt.C.f21684h.d("SdkJavascriptFactory.loadJavascriptEngine", th);
                        zzbrqVar2.b();
                    }
                }
            }
        });
        com.google.android.gms.ads.internal.util.zze.k("loadNewJavascriptEngine: Promise created");
        zzbrqVar.a(new zzbra(this, zzbrqVar, zzfneVarF), new zzbrb(this, zzbrqVar, zzfneVarF));
        return zzbrqVar;
    }

    public final zzbrl b() {
        com.google.android.gms.ads.internal.util.zze.k("getEngine: Trying to acquire lock");
        Object obj = this.f25488a;
        synchronized (obj) {
            try {
                com.google.android.gms.ads.internal.util.zze.k("getEngine: Lock acquired");
                com.google.android.gms.ads.internal.util.zze.k("refreshIfDestroyed: Trying to acquire lock");
                synchronized (obj) {
                    try {
                        com.google.android.gms.ads.internal.util.zze.k("refreshIfDestroyed: Lock acquired");
                        zzbrq zzbrqVar = this.f25495h;
                        if (zzbrqVar != null && this.f25496i == 0) {
                            zzbrqVar.a(new zzcdx() { // from class: com.google.android.gms.internal.ads.zzbrd
                                @Override // com.google.android.gms.internal.ads.zzcdx
                                public final /* synthetic */ void zza(Object obj2) {
                                    zzbrr zzbrrVar = this.f25462a;
                                    zzbrrVar.getClass();
                                    if (((zzbqm) obj2).zzk()) {
                                        zzbrrVar.f25496i = 1;
                                    }
                                }
                            }, zzbre.f25463a);
                        }
                    } finally {
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        com.google.android.gms.ads.internal.util.zze.k("refreshIfDestroyed: Lock released");
        zzbrq zzbrqVar2 = this.f25495h;
        if (zzbrqVar2 != null && zzbrqVar2.f25998b.get() != -1) {
            int i2 = this.f25496i;
            if (i2 == 0) {
                com.google.android.gms.ads.internal.util.zze.k("getEngine (NO_UPDATE): Lock released");
                return this.f25495h.d();
            }
            if (i2 != 1) {
                com.google.android.gms.ads.internal.util.zze.k("getEngine (UPDATING): Lock released");
                return this.f25495h.d();
            }
            this.f25496i = 2;
            a();
            com.google.android.gms.ads.internal.util.zze.k("getEngine (PENDING_UPDATE): Lock released");
            return this.f25495h.d();
        }
        this.f25496i = 2;
        this.f25495h = a();
        com.google.android.gms.ads.internal.util.zze.k("getEngine (NULL or REJECTED): Lock released");
        return this.f25495h.d();
    }
}
