package com.google.ads.interactivemedia.v3.internal;

import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
final class zzabd extends zzabf {
    final /* synthetic */ zzabn zza;
    private int zzb = 0;
    private final int zzc;

    public zzabd(zzabn zzabnVar) {
        this.zza = zzabnVar;
        this.zzc = zzabnVar.zzd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabh
    public final byte zza() {
        int i2 = this.zzb;
        if (i2 >= this.zzc) {
            throw new NoSuchElementException();
        }
        this.zzb = i2 + 1;
        return this.zza.zzb(i2);
    }
}
