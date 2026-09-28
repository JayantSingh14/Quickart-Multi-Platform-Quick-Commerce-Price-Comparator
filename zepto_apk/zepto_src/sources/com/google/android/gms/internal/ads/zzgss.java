package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes4.dex */
public abstract class zzgss extends zzgsu implements Collection {
    public boolean add(Object obj) {
        return d().add(obj);
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        return d().addAll(collection);
    }

    @Override // com.google.android.gms.internal.ads.zzgsu
    public /* bridge */ /* synthetic */ Object b() {
        throw null;
    }

    @Override // java.util.Collection
    public final void clear() {
        d().clear();
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        return d().contains(obj);
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        return d().containsAll(collection);
    }

    public abstract Collection d();

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return d().isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return d().iterator();
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        return d().remove(obj);
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        return d().removeAll(collection);
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        return d().retainAll(collection);
    }

    @Override // java.util.Collection
    public final int size() {
        return d().size();
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return d().toArray();
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return d().toArray(objArr);
    }
}
