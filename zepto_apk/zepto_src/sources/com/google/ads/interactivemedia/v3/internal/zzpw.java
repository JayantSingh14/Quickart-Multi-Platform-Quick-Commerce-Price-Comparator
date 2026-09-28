package com.google.ads.interactivemedia.v3.internal;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
final class zzpw implements Iterator {
    final /* synthetic */ zzpx zza;
    private int zzb;
    private int zzc = -1;
    private int zzd;
    private int zze;

    public zzpw(zzpx zzpxVar) {
        this.zza = zzpxVar;
        this.zzb = zzpxVar.zzb.zzi;
        zzpy zzpyVar = zzpxVar.zzb;
        this.zzd = zzpyVar.zzd;
        this.zze = zzpyVar.zzc;
    }

    private final void zza() {
        if (this.zza.zzb.zzd != this.zzd) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        zza();
        return this.zzb != -2 && this.zze > 0;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object objZza = this.zza.zza(this.zzb);
        this.zzc = this.zzb;
        this.zzb = this.zza.zzb.zzl[this.zzb];
        this.zze--;
        return objZza;
    }

    @Override // java.util.Iterator
    public final void remove() {
        zza();
        zzpd.zzg(this.zzc != -1, "no calls to next() since the last call to remove()");
        int i2 = this.zzc;
        zzpy zzpyVar = this.zza.zzb;
        zzpyVar.zzl(i2, zzpz.zzc(zzpyVar.zza[i2]));
        zzpx zzpxVar = this.zza;
        int i3 = this.zzb;
        zzpy zzpyVar2 = zzpxVar.zzb;
        if (i3 == zzpyVar2.zzc) {
            this.zzb = this.zzc;
        }
        this.zzc = -1;
        this.zzd = zzpyVar2.zzd;
    }
}
