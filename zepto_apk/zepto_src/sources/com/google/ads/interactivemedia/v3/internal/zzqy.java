package com.google.ads.interactivemedia.v3.internal;

import java.util.AbstractMap;
import java.util.Objects;

/* loaded from: classes3.dex */
final class zzqy extends zzqf {
    final /* synthetic */ zzqz zza;

    public zzqy(zzqz zzqzVar) {
        this.zza = zzqzVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i2) {
        zzpd.zza(i2, this.zza.zzc, "index");
        int i3 = i2 + i2;
        Object obj = this.zza.zzb[i3];
        Objects.requireNonNull(obj);
        Object obj2 = this.zza.zzb[i3 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.zzc;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqb
    public final boolean zzf() {
        return true;
    }
}
