package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public final class zzfez implements zzffj {

    /* renamed from: a, reason: collision with root package name */
    public zzczr f30995a;

    @Override // com.google.android.gms.internal.ads.zzffj
    public final /* bridge */ /* synthetic */ ListenableFuture a(zzffk zzffkVar, zzffi zzffiVar) {
        return b(zzffkVar, zzffiVar, null);
    }

    public final synchronized ListenableFuture b(zzffk zzffkVar, zzffi zzffiVar, zzczr zzczrVar) {
        zzcwo zzcwoVarZza;
        try {
            if (zzczrVar != null) {
                this.f30995a = zzczrVar;
            } else {
                this.f30995a = (zzczr) zzffiVar.a(zzffkVar.f31012b).zzh();
            }
            zzcwoVarZza = this.f30995a.zza();
        } catch (Throwable th) {
            throw th;
        }
        return zzcwoVarZza.c(zzcwoVarZza.b());
    }

    @Override // com.google.android.gms.internal.ads.zzffj
    public final Object zzd() {
        zzczr zzczrVar;
        synchronized (this) {
            zzczrVar = this.f30995a;
        }
        return zzczrVar;
    }
}
