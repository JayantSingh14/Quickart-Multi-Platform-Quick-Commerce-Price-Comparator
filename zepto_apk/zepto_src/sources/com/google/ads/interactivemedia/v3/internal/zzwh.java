package com.google.ads.interactivemedia.v3.internal;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
abstract class zzwh implements Iterator {
    zzwi zza;
    zzwi zzb = null;
    int zzc;
    final /* synthetic */ zzwj zzd;

    public zzwh(zzwj zzwjVar) {
        this.zzd = zzwjVar;
        this.zza = zzwjVar.zzd.zzd;
        this.zzc = zzwjVar.zzc;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza != this.zzd.zzd;
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzwi zzwiVar = this.zzb;
        if (zzwiVar == null) {
            throw new IllegalStateException();
        }
        this.zzd.zze(zzwiVar, true);
        this.zzb = null;
        this.zzc = this.zzd.zzc;
    }

    public final zzwi zza() {
        zzwj zzwjVar = this.zzd;
        zzwi zzwiVar = this.zza;
        if (zzwiVar == zzwjVar.zzd) {
            throw new NoSuchElementException();
        }
        if (zzwjVar.zzc != this.zzc) {
            throw new ConcurrentModificationException();
        }
        this.zza = zzwiVar.zzd;
        this.zzb = zzwiVar;
        return zzwiVar;
    }
}
