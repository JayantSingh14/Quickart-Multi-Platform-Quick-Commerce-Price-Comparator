package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzbqw implements zzbnn {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f25441a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbrq f25442b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzbqu f25443c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzbrr f25444d;

    public zzbqw(zzbrr zzbrrVar, long j2, zzbrq zzbrqVar, zzbqu zzbquVar) {
        this.f25441a = j2;
        this.f25442b = zzbrqVar;
        this.f25443c = zzbquVar;
        Objects.requireNonNull(zzbrrVar);
        this.f25444d = zzbrrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbnn
    public final void a(Object obj, Map map) {
        long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.C.f21687k.currentTimeMillis() - this.f25441a;
        StringBuilder sb = new StringBuilder(String.valueOf(jCurrentTimeMillis).length() + 42);
        sb.append("onGmsg /jsLoaded. JsLoaded latency is ");
        sb.append(jCurrentTimeMillis);
        sb.append(" ms.");
        com.google.android.gms.ads.internal.util.zze.k(sb.toString());
        com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > /jsLoaded handler: Trying to acquire lock");
        zzbrr zzbrrVar = this.f25444d;
        synchronized (zzbrrVar.f25488a) {
            com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > /jsLoaded handler: Lock acquired");
            zzbrq zzbrqVar = this.f25442b;
            if (zzbrqVar.f25998b.get() != -1 && zzbrqVar.f25998b.get() != 1) {
                zzbrrVar.f25496i = 0;
                zzbqu zzbquVar = this.f25443c;
                zzbquVar.A0("/log", zzbnm.f25343g);
                zzbquVar.A0("/result", zzbnm.o);
                zzbrqVar.f25997a.b(zzbquVar);
                zzbrrVar.f25495h = zzbrqVar;
                com.google.android.gms.ads.internal.util.zze.k("Successfully loaded JS Engine.");
                com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > /jsLoaded handler: Lock released");
                return;
            }
            com.google.android.gms.ads.internal.util.zze.k("loadJavascriptEngine > /jsLoaded handler: Lock released, the promise is already settled");
        }
    }
}
