package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzbra implements zzcdx {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbrq f25455a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzfne f25456b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzbrr f25457c;

    public zzbra(zzbrr zzbrrVar, zzbrq zzbrqVar, zzfne zzfneVar) {
        this.f25455a = zzbrqVar;
        this.f25456b = zzfneVar;
        Objects.requireNonNull(zzbrrVar);
        this.f25457c = zzbrrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcdx
    public final /* synthetic */ void zza(Object obj) {
        zzfnr zzfnrVar;
        com.google.android.gms.ads.internal.util.zze.k("loadNewJavascriptEngine (success): Trying to acquire lock");
        zzbrr zzbrrVar = this.f25457c;
        synchronized (zzbrrVar.f25488a) {
            try {
                com.google.android.gms.ads.internal.util.zze.k("loadNewJavascriptEngine (success): Lock acquired");
                zzbrrVar.f25496i = 0;
                zzbrq zzbrqVar = zzbrrVar.f25495h;
                if (zzbrqVar != null && this.f25455a != zzbrqVar) {
                    com.google.android.gms.ads.internal.util.zze.k("New JS engine is loaded, marking previous one as destroyable.");
                    zzbrrVar.f25495h.f();
                }
                zzbrrVar.f25495h = this.f25455a;
                if (((Boolean) zzbid.f25134d.c()).booleanValue() && (zzfnrVar = zzbrrVar.f25492e) != null) {
                    zzfne zzfneVar = this.f25456b;
                    zzfneVar.a(true);
                    zzfnrVar.b(zzfneVar.zzm());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        com.google.android.gms.ads.internal.util.zze.k("loadNewJavascriptEngine (success): Lock released");
    }
}
