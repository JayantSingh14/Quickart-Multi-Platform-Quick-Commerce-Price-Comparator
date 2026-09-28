package com.google.ads.interactivemedia.v3.internal;

import java.util.Objects;

/* loaded from: classes3.dex */
final class zzrb extends zzqf {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    public zzrb(Object[] objArr, int i2, int i3) {
        this.zza = objArr;
        this.zzb = i2;
        this.zzc = i3;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        zzpd.zza(i2, this.zzc, "index");
        Object obj = this.zza[i2 + i2 + this.zzb];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqb
    public final boolean zzf() {
        return true;
    }
}
