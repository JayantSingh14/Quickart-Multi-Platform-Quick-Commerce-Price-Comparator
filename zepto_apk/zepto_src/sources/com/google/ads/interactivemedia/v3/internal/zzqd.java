package com.google.ads.interactivemedia.v3.internal;

import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
final class zzqd extends zzqf {
    private final transient zzqf zza;

    public zzqd(zzqf zzqfVar) {
        this.zza = zzqfVar;
    }

    private final int zzo(int i2) {
        return (this.zza.size() - 1) - i2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqf, com.google.ads.interactivemedia.v3.internal.zzqb, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.contains(obj);
    }

    @Override // java.util.List
    public final Object get(int i2) {
        zzpd.zza(i2, this.zza.size(), "index");
        return this.zza.get(zzo(i2));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqf, java.util.List
    public final int indexOf(@CheckForNull Object obj) {
        int iLastIndexOf = this.zza.lastIndexOf(obj);
        if (iLastIndexOf >= 0) {
            return zzo(iLastIndexOf);
        }
        return -1;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqf, java.util.List
    public final int lastIndexOf(@CheckForNull Object obj) {
        int iIndexOf = this.zza.indexOf(obj);
        if (iIndexOf >= 0) {
            return zzo(iIndexOf);
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqb
    public final boolean zzf() {
        return this.zza.zzf();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqf
    public final zzqf zzh() {
        return this.zza;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqf, java.util.List
    /* renamed from: zzi */
    public final zzqf subList(int i2, int i3) {
        zzpd.zzf(i2, i3, this.zza.size());
        zzqf zzqfVar = this.zza;
        return zzqfVar.subList(zzqfVar.size() - i3, this.zza.size() - i2).zzh();
    }
}
