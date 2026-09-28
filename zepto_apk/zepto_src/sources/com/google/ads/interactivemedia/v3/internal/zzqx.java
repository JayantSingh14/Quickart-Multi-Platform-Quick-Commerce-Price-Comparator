package com.google.ads.interactivemedia.v3.internal;

import java.util.Objects;

/* loaded from: classes3.dex */
final class zzqx extends zzqf {
    static final zzqf zza = new zzqx(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    public zzqx(Object[] objArr, int i2) {
        this.zzb = objArr;
        this.zzc = i2;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        zzpd.zza(i2, this.zzc, "index");
        Object obj = this.zzb[i2];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqf, com.google.ads.interactivemedia.v3.internal.zzqb
    public final int zza(Object[] objArr, int i2) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqb
    public final int zzb() {
        return this.zzc;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqb
    public final int zzc() {
        return 0;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqb
    public final boolean zzf() {
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqb
    public final Object[] zzg() {
        return this.zzb;
    }
}
