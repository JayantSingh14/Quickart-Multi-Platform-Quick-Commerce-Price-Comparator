package com.google.ads.interactivemedia.v3.internal;

import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
final class zzqe extends zzqf {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzqf zzc;

    public zzqe(zzqf zzqfVar, int i2, int i3) {
        this.zzc = zzqfVar;
        this.zza = i2;
        this.zzb = i3;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        zzpd.zza(i2, this.zzb, "index");
        return this.zzc.get(i2 + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqb
    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqb
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqb
    public final boolean zzf() {
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqb
    @CheckForNull
    public final Object[] zzg() {
        return this.zzc.zzg();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqf, java.util.List
    /* renamed from: zzi */
    public final zzqf subList(int i2, int i3) {
        zzpd.zzf(i2, i3, this.zzb);
        int i4 = this.zza;
        return this.zzc.subList(i2 + i4, i3 + i4);
    }
}
