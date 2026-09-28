package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzbrb implements zzcdv {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbrq f25458a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzfne f25459b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzbrr f25460c;

    public zzbrb(zzbrr zzbrrVar, zzbrq zzbrqVar, zzfne zzfneVar) {
        this.f25458a = zzbrqVar;
        this.f25459b = zzfneVar;
        Objects.requireNonNull(zzbrrVar);
        this.f25460c = zzbrrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcdv
    public final void zza() {
        zzfnr zzfnrVar;
        com.google.android.gms.ads.internal.util.zze.k("loadNewJavascriptEngine (failure): Trying to acquire lock");
        zzbrr zzbrrVar = this.f25460c;
        synchronized (zzbrrVar.f25488a) {
            try {
                com.google.android.gms.ads.internal.util.zze.k("loadNewJavascriptEngine (failure): Lock acquired");
                zzbrrVar.f25496i = 1;
                com.google.android.gms.ads.internal.util.zze.k("Failed loading new engine. Marking new engine destroyable.");
                this.f25458a.f();
                if (((Boolean) zzbid.f25134d.c()).booleanValue() && (zzfnrVar = zzbrrVar.f25492e) != null) {
                    zzfne zzfneVar = this.f25459b;
                    zzfneVar.b("Failed loading new engine");
                    zzfneVar.a(false);
                    zzfnrVar.b(zzfneVar.zzm());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        com.google.android.gms.ads.internal.util.zze.k("loadNewJavascriptEngine (failure): Lock released");
    }
}
