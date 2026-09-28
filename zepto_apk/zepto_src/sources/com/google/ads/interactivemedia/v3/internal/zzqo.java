package com.google.ads.interactivemedia.v3.internal;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
public abstract class zzqo extends zzqk implements NavigableSet, zzrj {
    final transient Comparator zza;

    @CheckForNull
    transient zzqo zzb;

    public zzqo(Comparator comparator) {
        this.zza = comparator;
    }

    public static zzre zzs(Comparator comparator) {
        if (zzqu.zza.equals(comparator)) {
            return zzre.zzc;
        }
        int i2 = zzqf.zzd;
        return new zzre(zzqx.zza, comparator);
    }

    @CheckForNull
    @Deprecated
    public final void addFirst(Object obj) {
        throw new UnsupportedOperationException();
    }

    @CheckForNull
    @Deprecated
    public final void addLast(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public Object ceiling(Object obj) {
        obj.getClass();
        return zzqp.zza(zzr(obj, true), null);
    }

    @Override // java.util.SortedSet, com.google.ads.interactivemedia.v3.internal.zzrj
    public final Comparator comparator() {
        return this.zza;
    }

    @Override // java.util.SortedSet
    public Object first() {
        return iterator().next();
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public Object floor(Object obj) {
        obj.getClass();
        return zzqr.zza(zzo(obj, true).descendingIterator(), null);
    }

    public final Object getFirst() {
        return first();
    }

    public final Object getLast() {
        return last();
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public final /* synthetic */ SortedSet headSet(Object obj) {
        obj.getClass();
        return zzo(obj, false);
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public Object higher(Object obj) {
        obj.getClass();
        return zzqp.zza(zzr(obj, false), null);
    }

    @Override // java.util.SortedSet
    public Object last() {
        return descendingIterator().next();
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public Object lower(Object obj) {
        obj.getClass();
        return zzqr.zza(zzo(obj, false).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    @Deprecated
    public final Object pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    @Deprecated
    public final Object pollLast() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Object removeFirst() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Object removeLast() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public final /* bridge */ /* synthetic */ SortedSet subSet(Object obj, Object obj2) {
        return subSet(obj, true, obj2, false);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public final /* synthetic */ SortedSet tailSet(Object obj) {
        obj.getClass();
        return zzr(obj, true);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqk, com.google.ads.interactivemedia.v3.internal.zzqb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zze */
    public abstract zzrl iterator();

    public abstract zzqo zzh();

    @Override // java.util.NavigableSet
    /* renamed from: zzn, reason: merged with bridge method [inline-methods] */
    public final zzqo descendingSet() {
        zzqo zzqoVar = this.zzb;
        if (zzqoVar != null) {
            return zzqoVar;
        }
        zzqo zzqoVarZzh = zzh();
        this.zzb = zzqoVarZzh;
        zzqoVarZzh.zzb = this;
        return zzqoVarZzh;
    }

    public abstract zzqo zzo(Object obj, boolean z);

    @Override // java.util.NavigableSet
    /* renamed from: zzp, reason: merged with bridge method [inline-methods] */
    public final zzqo subSet(Object obj, boolean z, Object obj2, boolean z2) {
        obj.getClass();
        obj2.getClass();
        zzpd.zzc(this.zza.compare(obj, obj2) <= 0);
        return zzq(obj, z, obj2, z2);
    }

    public abstract zzqo zzq(Object obj, boolean z, Object obj2, boolean z2);

    public abstract zzqo zzr(Object obj, boolean z);

    @Override // java.util.NavigableSet
    /* renamed from: zzt, reason: merged with bridge method [inline-methods] */
    public abstract zzrl descendingIterator();

    @Override // java.util.NavigableSet
    public final /* synthetic */ NavigableSet headSet(Object obj, boolean z) {
        obj.getClass();
        return zzo(obj, z);
    }

    @Override // java.util.NavigableSet
    public final /* synthetic */ NavigableSet tailSet(Object obj, boolean z) {
        obj.getClass();
        return zzr(obj, z);
    }
}
