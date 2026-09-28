package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;

/* loaded from: classes4.dex */
final class zzgvk extends zzgvj implements SortedSet {
    @Override // java.util.SortedSet
    public final Comparator comparator() {
        return ((SortedSet) this.f33140a).comparator();
    }

    @Override // java.util.SortedSet
    public final Object first() {
        Iterator it = this.f33140a.iterator();
        it.getClass();
        zzgqb zzgqbVar = this.f33141b;
        zzgqbVar.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            if (zzgqbVar.zza(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.SortedSet
    public final SortedSet headSet(Object obj) {
        return new zzgvk(((SortedSet) this.f33140a).headSet(obj), this.f33141b);
    }

    @Override // java.util.SortedSet
    public final Object last() {
        SortedSet sortedSetHeadSet = (SortedSet) this.f33140a;
        while (true) {
            Object objLast = sortedSetHeadSet.last();
            if (this.f33141b.zza(objLast)) {
                return objLast;
            }
            sortedSetHeadSet = sortedSetHeadSet.headSet(objLast);
        }
    }

    @Override // java.util.SortedSet
    public final SortedSet subSet(Object obj, Object obj2) {
        return new zzgvk(((SortedSet) this.f33140a).subSet(obj, obj2), this.f33141b);
    }

    @Override // java.util.SortedSet
    public final SortedSet tailSet(Object obj) {
        return new zzgvk(((SortedSet) this.f33140a).tailSet(obj), this.f33141b);
    }
}
