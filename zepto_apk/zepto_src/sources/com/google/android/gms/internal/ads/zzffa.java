package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public final class zzffa implements zzffj {

    /* renamed from: a, reason: collision with root package name */
    public final zzfez f31000a;

    /* renamed from: b, reason: collision with root package name */
    public zzczr f31001b;

    public zzffa(zzfez zzfezVar) {
        this.f31000a = zzfezVar;
    }

    @Override // com.google.android.gms.internal.ads.zzffj
    public final /* bridge */ /* synthetic */ ListenableFuture a(zzffk zzffkVar, zzffi zzffiVar) {
        return b(zzffkVar, zzffiVar, null);
    }

    public final synchronized ListenableFuture b(zzffk zzffkVar, zzffi zzffiVar, zzczr zzczrVar) {
        zzbza zzbzaVar;
        this.f31001b = zzczrVar;
        if (zzczrVar == null || (zzbzaVar = zzffkVar.f31011a) == null) {
            return this.f31000a.b(zzffkVar, zzffiVar, zzczrVar);
        }
        zzcwo zzcwoVarZza = zzczrVar.zza();
        return zzcwoVarZza.c(zzcwoVarZza.a(zzgym.a(zzbzaVar)));
    }

    @Override // com.google.android.gms.internal.ads.zzffj
    public final Object zzd() {
        zzczr zzczrVar;
        synchronized (this) {
            zzczrVar = this.f31001b;
        }
        return zzczrVar;
    }
}
