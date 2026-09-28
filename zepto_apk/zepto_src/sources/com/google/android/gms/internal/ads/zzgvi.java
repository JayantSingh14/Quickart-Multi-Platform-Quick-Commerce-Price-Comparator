package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzgvi extends zzgvm {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzgtn f33258a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzgtn f33259b;

    public zzgvi(zzgtn zzgtnVar, zzgtn zzgtnVar2) {
        this.f33258a = zzgtnVar;
        this.f33259b = zzgtnVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzgvm, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: b */
    public final zzgvr iterator() {
        return new zzgvh(this, this.f33258a, this.f33259b);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f33258a.contains(obj) && this.f33259b.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        return this.f33258a.containsAll(collection) && this.f33259b.containsAll(collection);
    }

    @Override // com.google.android.gms.internal.ads.zzgvm
    public final int d() {
        return Math.min(this.f33258a.size(), this.f33259b.size());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return Collections.disjoint(this.f33259b, this.f33258a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        Iterator<E> it = this.f33258a.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (this.f33259b.contains(it.next())) {
                i2++;
            }
        }
        return i2;
    }
}
