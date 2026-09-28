package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes4.dex */
final class zzguc extends AbstractSequentialList implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractCollection f33221a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgpr f33222b;

    /* JADX WARN: Multi-variable type inference failed */
    public zzguc(List list, zzgpr zzgprVar) {
        list.getClass();
        this.f33221a = (AbstractCollection) list;
        this.f33222b = zzgprVar;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.AbstractCollection, java.util.List] */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.f33221a.isEmpty();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.AbstractCollection, java.util.List] */
    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i2) {
        return new zzgub(this, this.f33221a.listIterator(i2));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.AbstractCollection, java.util.List] */
    @Override // java.util.AbstractList
    public final void removeRange(int i2, int i3) {
        this.f33221a.subList(i2, i3).clear();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.AbstractCollection, java.util.List] */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f33221a.size();
    }
}
