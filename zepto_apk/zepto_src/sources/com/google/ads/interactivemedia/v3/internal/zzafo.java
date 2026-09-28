package com.google.ads.interactivemedia.v3.internal;

import java.util.Iterator;

/* loaded from: classes3.dex */
final class zzafo implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzafp zzb;

    public zzafo(zzafp zzafpVar) {
        this.zzb = zzafpVar;
        this.zza = zzafpVar.zza.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
