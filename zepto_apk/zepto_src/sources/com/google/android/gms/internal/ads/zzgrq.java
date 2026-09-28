package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes4.dex */
class zzgrq extends AbstractCollection {

    /* renamed from: a, reason: collision with root package name */
    public final Object f33120a;

    /* renamed from: b, reason: collision with root package name */
    public Collection f33121b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgrs f33122c;

    /* renamed from: d, reason: collision with root package name */
    public final Collection f33123d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzgrt f33124e;

    public zzgrq(zzgrt zzgrtVar, Object obj, List list, zzgrs zzgrsVar) {
        Objects.requireNonNull(zzgrtVar);
        this.f33124e = zzgrtVar;
        this.f33120a = obj;
        this.f33121b = list;
        this.f33122c = zzgrsVar;
        this.f33123d = zzgrsVar == null ? null : zzgrsVar.f33121b;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        b();
        boolean zIsEmpty = this.f33121b.isEmpty();
        boolean zAdd = this.f33121b.add(obj);
        if (zAdd) {
            this.f33124e.f33128e++;
            if (zIsEmpty) {
                d();
                return true;
            }
        }
        return zAdd;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zAddAll = this.f33121b.addAll(collection);
        if (!zAddAll) {
            return zAddAll;
        }
        this.f33124e.f33128e += this.f33121b.size() - size;
        if (size != 0) {
            return zAddAll;
        }
        d();
        return true;
    }

    public final void b() {
        Collection collection;
        zzgrs zzgrsVar = this.f33122c;
        if (zzgrsVar != null) {
            zzgrsVar.b();
            if (zzgrsVar.f33121b != this.f33123d) {
                throw new ConcurrentModificationException();
            }
        } else {
            if (!this.f33121b.isEmpty() || (collection = (Collection) this.f33124e.f33127d.get(this.f33120a)) == null) {
                return;
            }
            this.f33121b = collection;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        int size = size();
        if (size == 0) {
            return;
        }
        this.f33121b.clear();
        this.f33124e.f33128e -= size;
        zzb();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        b();
        return this.f33121b.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean containsAll(Collection collection) {
        b();
        return this.f33121b.containsAll(collection);
    }

    public final void d() {
        zzgrs zzgrsVar = this.f33122c;
        if (zzgrsVar != null) {
            zzgrsVar.d();
        } else {
            this.f33124e.f33127d.put(this.f33120a, this.f33121b);
        }
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        b();
        return this.f33121b.equals(obj);
    }

    @Override // java.util.Collection
    public final int hashCode() {
        b();
        return this.f33121b.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        b();
        return new zzgrp(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        b();
        boolean zRemove = this.f33121b.remove(obj);
        if (zRemove) {
            zzgrt zzgrtVar = this.f33124e;
            zzgrtVar.f33128e--;
            zzb();
        }
        return zRemove;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zRemoveAll = this.f33121b.removeAll(collection);
        if (zRemoveAll) {
            this.f33124e.f33128e += this.f33121b.size() - size;
            zzb();
        }
        return zRemoveAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        int size = size();
        boolean zRetainAll = this.f33121b.retainAll(collection);
        if (zRetainAll) {
            this.f33124e.f33128e += this.f33121b.size() - size;
            zzb();
        }
        return zRetainAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        b();
        return this.f33121b.size();
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        b();
        return this.f33121b.toString();
    }

    public final void zzb() {
        zzgrs zzgrsVar = this.f33122c;
        if (zzgrsVar != null) {
            zzgrsVar.zzb();
        } else if (this.f33121b.isEmpty()) {
            this.f33124e.f33127d.remove(this.f33120a);
        }
    }
}
