package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeoutException;

/* loaded from: classes4.dex */
final class zzbqz implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbrq f25449a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbqu f25450b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList f25451c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f25452d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzbrr f25453e;

    public zzbqz(long j2, zzbqu zzbquVar, zzbrq zzbrqVar, zzbrr zzbrrVar, ArrayList arrayList) {
        this.f25449a = zzbrqVar;
        this.f25450b = zzbquVar;
        this.f25451c = arrayList;
        this.f25452d = j2;
        Objects.requireNonNull(zzbrrVar);
        this.f25453e = zzbrrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String string;
        com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > ADMOB_UI_HANDLER.postDelayed: Trying to acquire lock");
        zzbrr zzbrrVar = this.f25453e;
        synchronized (zzbrrVar.f25488a) {
            try {
                com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > ADMOB_UI_HANDLER.postDelayed: Lock acquired");
                zzbrq zzbrqVar = this.f25449a;
                if (zzbrqVar.f25998b.get() != -1 && zzbrqVar.f25998b.get() != 1) {
                    zzbgb zzbgbVar = zzbgk.w8;
                    com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                    if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                        zzbrqVar.c("SdkJavascriptFactory.loadJavascriptEngine.Runnable", new TimeoutException("Unable to fully load JS engine."));
                    } else {
                        zzbrqVar.b();
                    }
                    zzgyw zzgywVar = zzcdo.f25987f;
                    final zzbqu zzbquVar = this.f25450b;
                    ((zzcdn) zzgywVar).execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbqy
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            zzbquVar.zzj();
                        }
                    });
                    String strValueOf = String.valueOf(zzbdVar.f21153c.a(zzbgk.f25015e));
                    int i2 = zzbrqVar.f25998b.get();
                    int i3 = zzbrrVar.f25496i;
                    ArrayList arrayList = this.f25451c;
                    if (arrayList.isEmpty()) {
                        string = ". Still waiting for the engine to be loaded";
                    } else {
                        String strValueOf2 = String.valueOf(arrayList.get(0));
                        StringBuilder sb = new StringBuilder(strValueOf2.length() + 88);
                        sb.append(". While waiting for the /jsLoaded gmsg, observed the loadNewJavascriptEngine latency is ");
                        sb.append(strValueOf2);
                        string = sb.toString();
                    }
                    long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis() - this.f25452d;
                    StringBuilder sb2 = new StringBuilder(strValueOf.length() + 107 + String.valueOf(i2).length() + 36 + String.valueOf(i3).length() + string.length() + 39 + String.valueOf(jCurrentTimeMillis).length() + 26);
                    sb2.append("Could not finish the full JS engine loading in ");
                    sb2.append(strValueOf);
                    sb2.append(" ms. JS engine session reference status(fullLoadTimeout) is ");
                    sb2.append(i2);
                    sb2.append(". Update status(fullLoadTimeout) is ");
                    sb2.append(i3);
                    sb2.append(string);
                    sb2.append(" ms. Total latency(fullLoadTimeout) is ");
                    sb2.append(jCurrentTimeMillis);
                    sb2.append(" ms at timeout. Rejecting.");
                    com.google.android.gms.ads.internal.util.zze.k(sb2.toString());
                    com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > ADMOB_UI_HANDLER.postDelayed: Lock released");
                    return;
                }
                com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > ADMOB_UI_HANDLER.postDelayed: Lock released, the promise is already settled");
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
