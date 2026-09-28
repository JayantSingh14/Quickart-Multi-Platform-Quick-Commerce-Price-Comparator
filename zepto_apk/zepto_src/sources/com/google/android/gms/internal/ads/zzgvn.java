package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;

/* loaded from: classes4.dex */
public final class zzgvn {
    public static zzgvm a(zzgtn zzgtnVar, zzgtn zzgtnVar2) {
        zzgqa.h(zzgtnVar, "set1");
        zzgqa.h(zzgtnVar2, "set2");
        return new zzgvi(zzgtnVar, zzgtnVar2);
    }

    public static Set b(Set set, zzgqb zzgqbVar) {
        if (!(set instanceof SortedSet)) {
            if (!(set instanceof zzgvj)) {
                set.getClass();
                return new zzgvj(set, zzgqbVar);
            }
            zzgvj zzgvjVar = (zzgvj) set;
            zzgqb zzgqbVar2 = zzgvjVar.f33141b;
            zzgqbVar2.getClass();
            return new zzgvj(zzgvjVar.f33140a, new zzgqc(Arrays.asList(zzgqbVar2, zzgqbVar)));
        }
        Set set2 = (SortedSet) set;
        if (!(set2 instanceof zzgvj)) {
            set2.getClass();
            return new zzgvk(set2, zzgqbVar);
        }
        zzgvj zzgvjVar2 = (zzgvj) set2;
        zzgqb zzgqbVar3 = zzgvjVar2.f33141b;
        zzgqbVar3.getClass();
        return new zzgvk((SortedSet) zzgvjVar2.f33140a, new zzgqc(Arrays.asList(zzgqbVar3, zzgqbVar)));
    }

    public static int c(Set set) {
        Iterator it = set.iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }

    public static boolean d(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (set.size() == set2.size()) {
                return set.containsAll(set2);
            }
            return false;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static boolean e(Set set, Collection collection) {
        collection.getClass();
        if (collection instanceof zzguu) {
            collection = ((zzguu) collection).zza();
        }
        boolean zRemove = false;
        if (!(collection instanceof Set) || collection.size() <= set.size()) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                zRemove |= set.remove(it.next());
            }
            return zRemove;
        }
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            if (collection.contains(it2.next())) {
                it2.remove();
                zRemove = true;
            }
        }
        return zRemove;
    }
}
