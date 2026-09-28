package com.google.ads.interactivemedia.v3.internal;

import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
final class zzpu extends zzpx {
    final /* synthetic */ zzpy zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzpu(zzpy zzpyVar) {
        super(zzpyVar);
        this.zza = zzpyVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(@CheckForNull Object obj) {
        zzpy zzpyVar = this.zza;
        int iZzc = zzpz.zzc(obj);
        int iZzc2 = zzpyVar.zzc(obj, iZzc);
        if (iZzc2 == -1) {
            return false;
        }
        this.zza.zzl(iZzc2, iZzc);
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzpx
    public final Object zza(int i2) {
        return this.zza.zza[i2];
    }
}
