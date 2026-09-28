package com.google.ads.interactivemedia.v3.internal;

import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
final class zzpv extends zzpx {
    final /* synthetic */ zzpy zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzpv(zzpy zzpyVar) {
        super(zzpyVar);
        this.zza = zzpyVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(@CheckForNull Object obj) {
        zzpy zzpyVar = this.zza;
        int iZzc = zzpz.zzc(obj);
        int iZzd = zzpyVar.zzd(obj, iZzc);
        if (iZzd == -1) {
            return false;
        }
        this.zza.zzm(iZzd, iZzc);
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzpx
    public final Object zza(int i2) {
        return this.zza.zzb[i2];
    }
}
