package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import java.util.Set;

/* loaded from: classes4.dex */
class zzgsa extends AbstractCollection {

    /* renamed from: a, reason: collision with root package name */
    public final Set f33140a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgqb f33141b;

    public zzgsa(Set set, zzgqb zzgqbVar) {
        this.f33140a = set;
        this.f33141b = zzgqbVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        zzgqa.a(this.f33141b.zza(obj));
        return this.f33140a.add(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            zzgqa.a(this.f33141b.zza(it.next()));
        }
        return this.f33140a.addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        Set set = this.f33140a;
        boolean z = set instanceof RandomAccess;
        zzgqb zzgqbVar = this.f33141b;
        if (!z || !(set instanceof List)) {
            Iterator it = set.iterator();
            zzgqbVar.getClass();
            while (it.hasNext()) {
                if (zzgqbVar.zza(it.next())) {
                    it.remove();
                }
            }
            return;
        }
        List list = (List) set;
        zzgqbVar.getClass();
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            Object obj = list.get(i3);
            if (!zzgqbVar.zza(obj)) {
                if (i3 > i2) {
                    try {
                        list.set(i2, obj);
                    } catch (IllegalArgumentException unused) {
                        zzgtr.b(list, zzgqbVar, i2, i3);
                        return;
                    } catch (UnsupportedOperationException unused2) {
                        zzgtr.b(list, zzgqbVar, i2, i3);
                        return;
                    }
                }
                i2++;
            }
        }
        list.subList(i2, list.size()).clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        boolean zContains;
        Set set = this.f33140a;
        set.getClass();
        try {
            zContains = set.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            zContains = false;
        }
        if (zContains) {
            return this.f33141b.zza(obj);
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        Iterator it = this.f33140a.iterator();
        zzgqb zzgqbVar = this.f33141b;
        zzgqa.h(zzgqbVar, "predicate");
        int i2 = 0;
        while (it.hasNext()) {
            if (zzgqbVar.zza(it.next())) {
                return i2 == -1;
            }
            i2++;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        Iterator it = this.f33140a.iterator();
        it.getClass();
        zzgqb zzgqbVar = this.f33141b;
        zzgqbVar.getClass();
        return new zzgts(it, zzgqbVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        return contains(obj) && this.f33140a.remove(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        Iterator it = this.f33140a.iterator();
        boolean z = false;
        while (it.hasNext()) {
            Object next = it.next();
            if (this.f33141b.zza(next) && collection.contains(next)) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        Iterator it = this.f33140a.iterator();
        boolean z = false;
        while (it.hasNext()) {
            Object next = it.next();
            if (this.f33141b.zza(next) && !collection.contains(next)) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        Iterator it = this.f33140a.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (this.f33141b.zza(it.next())) {
                i2++;
            }
        }
        return i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return zzgud.a((zzgvr) iterator()).toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return zzgud.a((zzgvr) iterator()).toArray(objArr);
    }
}
