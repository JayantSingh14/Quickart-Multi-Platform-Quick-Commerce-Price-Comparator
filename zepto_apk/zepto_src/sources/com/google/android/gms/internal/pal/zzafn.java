package com.google.android.gms.internal.pal;

import java.util.AbstractList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
public final class zzafn extends AbstractList implements RandomAccess, zzadn {

    /* renamed from: a, reason: collision with root package name */
    public final zzadm f37496a;

    public zzafn(zzadm zzadmVar) {
        this.f37496a = zzadmVar;
    }

    @Override // com.google.android.gms.internal.pal.zzadn
    public final void V(zzaby zzabyVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i2) {
        return this.f37496a.get(i2);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new zzafm(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i2) {
        return new zzafl(this, i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f37496a.size();
    }

    @Override // com.google.android.gms.internal.pal.zzadn
    public final zzadn zze() {
        return this;
    }

    @Override // com.google.android.gms.internal.pal.zzadn
    public final Object zzf(int i2) {
        return this.f37496a.f37426b.get(i2);
    }

    @Override // com.google.android.gms.internal.pal.zzadn
    public final List zzh() {
        return Collections.unmodifiableList(this.f37496a.f37426b);
    }
}
