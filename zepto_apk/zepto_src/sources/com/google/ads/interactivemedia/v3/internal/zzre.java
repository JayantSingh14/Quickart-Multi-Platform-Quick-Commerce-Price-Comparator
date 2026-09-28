package com.google.ads.interactivemedia.v3.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
final class zzre extends zzqo {
    static final zzre zzc;
    final transient zzqf zzd;

    static {
        int i2 = zzqf.zzd;
        zzc = new zzre(zzqx.zza, zzqu.zza);
    }

    public zzre(zzqf zzqfVar, Comparator comparator) {
        super(comparator);
        this.zzd = zzqfVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqo, java.util.NavigableSet
    @CheckForNull
    public final Object ceiling(Object obj) {
        zzqf zzqfVar = this.zzd;
        int iZzv = zzv(obj, true);
        if (iZzv == zzqfVar.size()) {
            return null;
        }
        return this.zzd.get(iZzv);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqb, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        if (obj != null) {
            try {
                if (Collections.binarySearch(this.zzd, obj, ((zzqo) this).zza) >= 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        if (collection instanceof zzqt) {
            collection = ((zzqt) collection).zza();
        }
        if (!zzrk.zza(((zzqo) this).zza, collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        zzrm zzrmVarListIterator = this.zzd.listIterator(0);
        Iterator it = collection.iterator();
        if (!zzrmVarListIterator.hasNext()) {
            return false;
        }
        Object next = it.next();
        E next2 = zzrmVarListIterator.next();
        while (true) {
            try {
                int iCompare = ((zzqo) this).zza.compare(next2, next);
                if (iCompare >= 0) {
                    if (iCompare != 0) {
                        break;
                    }
                    if (!it.hasNext()) {
                        return true;
                    }
                    next = it.next();
                } else {
                    if (!zzrmVarListIterator.hasNext()) {
                        return false;
                    }
                    next2 = zzrmVarListIterator.next();
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqk, java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (this.zzd.size() != set.size()) {
            return false;
        }
        if (isEmpty()) {
            return true;
        }
        if (!zzrk.zza(((zzqo) this).zza, set)) {
            return containsAll(set);
        }
        Iterator it = set.iterator();
        try {
            zzrm zzrmVarListIterator = this.zzd.listIterator(0);
            while (zzrmVarListIterator.hasNext()) {
                E next = zzrmVarListIterator.next();
                Object next2 = it.next();
                if (next2 == null || ((zzqo) this).zza.compare(next, next2) != 0) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NoSuchElementException unused) {
            return false;
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqo, java.util.SortedSet
    public final Object first() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.zzd.get(0);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqo, java.util.NavigableSet
    @CheckForNull
    public final Object floor(Object obj) {
        int iZzu = zzu(obj, true) - 1;
        if (iZzu == -1) {
            return null;
        }
        return this.zzd.get(iZzu);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqo, java.util.NavigableSet
    @CheckForNull
    public final Object higher(Object obj) {
        zzqf zzqfVar = this.zzd;
        int iZzv = zzv(obj, false);
        if (iZzv == zzqfVar.size()) {
            return null;
        }
        return this.zzd.get(iZzv);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqo, com.google.ads.interactivemedia.v3.internal.zzqk, com.google.ads.interactivemedia.v3.internal.zzqb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.zzd.listIterator(0);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqo, java.util.SortedSet
    public final Object last() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.zzd.get(r0.size() - 1);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqo, java.util.NavigableSet
    @CheckForNull
    public final Object lower(Object obj) {
        int iZzu = zzu(obj, false) - 1;
        if (iZzu == -1) {
            return null;
        }
        return this.zzd.get(iZzu);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzd.size();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqb
    public final int zza(Object[] objArr, int i2) {
        return this.zzd.zza(objArr, 0);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqb
    public final int zzb() {
        return this.zzd.zzb();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqb
    public final int zzc() {
        return this.zzd.zzc();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqk, com.google.ads.interactivemedia.v3.internal.zzqb
    public final zzqf zzd() {
        return this.zzd;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqo, com.google.ads.interactivemedia.v3.internal.zzqk, com.google.ads.interactivemedia.v3.internal.zzqb
    /* renamed from: zze */
    public final zzrl iterator() {
        return this.zzd.listIterator(0);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqb
    public final boolean zzf() {
        return this.zzd.zzf();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqb
    @CheckForNull
    public final Object[] zzg() {
        return this.zzd.zzg();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqo
    public final zzqo zzh() {
        Comparator comparatorReverseOrder = Collections.reverseOrder(((zzqo) this).zza);
        return isEmpty() ? zzqo.zzs(comparatorReverseOrder) : new zzre(this.zzd.zzh(), comparatorReverseOrder);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqo
    public final zzqo zzo(Object obj, boolean z) {
        return zzw(0, zzu(obj, z));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqo
    public final zzqo zzq(Object obj, boolean z, Object obj2, boolean z2) {
        return zzr(obj, z).zzo(obj2, z2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqo
    public final zzqo zzr(Object obj, boolean z) {
        return zzw(zzv(obj, z), this.zzd.size());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqo, java.util.NavigableSet
    /* renamed from: zzt */
    public final zzrl descendingIterator() {
        return this.zzd.zzh().listIterator(0);
    }

    public final int zzu(Object obj, boolean z) {
        obj.getClass();
        int iBinarySearch = Collections.binarySearch(this.zzd, obj, ((zzqo) this).zza);
        return iBinarySearch >= 0 ? z ? iBinarySearch + 1 : iBinarySearch : ~iBinarySearch;
    }

    public final int zzv(Object obj, boolean z) {
        obj.getClass();
        int iBinarySearch = Collections.binarySearch(this.zzd, obj, ((zzqo) this).zza);
        return iBinarySearch >= 0 ? z ? iBinarySearch : iBinarySearch + 1 : ~iBinarySearch;
    }

    public final zzre zzw(int i2, int i3) {
        if (i2 == 0) {
            if (i3 == this.zzd.size()) {
                return this;
            }
            i2 = 0;
        }
        if (i2 >= i3) {
            return zzqo.zzs(((zzqo) this).zza);
        }
        zzqf zzqfVar = this.zzd;
        return new zzre(zzqfVar.subList(i2, i3), ((zzqo) this).zza);
    }
}
