package com.google.ads.interactivemedia.v3.internal;

import java.util.AbstractMap;

/* loaded from: classes3.dex */
final class zzql extends zzqf {
    final /* synthetic */ zzqm zza;

    public zzql(zzqm zzqmVar) {
        this.zza = zzqmVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i2) {
        return new AbstractMap.SimpleImmutableEntry(this.zza.zza.zzc.zzd.get(i2), this.zza.zza.zzd.get(i2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.zza.size();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqb
    public final boolean zzf() {
        return true;
    }
}
