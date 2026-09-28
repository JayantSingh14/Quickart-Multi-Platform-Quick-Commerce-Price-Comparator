package com.google.ads.interactivemedia.v3.internal;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

@Deprecated
/* loaded from: classes3.dex */
public final class zzafp extends AbstractList implements RandomAccess, zzadh {
    private final zzadh zza;

    public zzafp(zzadh zzadhVar) {
        this.zza = zzadhVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i2) {
        return ((zzadg) this.zza).get(i2);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new zzafo(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i2) {
        return new zzafn(this, i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzadh
    public final zzadh zze() {
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzadh
    public final Object zzf(int i2) {
        return this.zza.zzf(i2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzadh
    public final List zzh() {
        return this.zza.zzh();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzadh
    public final void zzi(zzabn zzabnVar) {
        throw new UnsupportedOperationException();
    }
}
