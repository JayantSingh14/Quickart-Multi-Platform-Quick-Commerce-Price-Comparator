package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;

/* loaded from: classes4.dex */
class zzgrs extends zzgrq implements List {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzgrt f33126f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgrs(zzgrt zzgrtVar, Object obj, List list, zzgrs zzgrsVar) {
        super(zzgrtVar, obj, list, zzgrsVar);
        Objects.requireNonNull(zzgrtVar);
        this.f33126f = zzgrtVar;
    }

    @Override // java.util.List
    public final void add(int i2, Object obj) {
        b();
        boolean zIsEmpty = this.f33121b.isEmpty();
        ((List) this.f33121b).add(i2, obj);
        this.f33126f.f33128e++;
        if (zIsEmpty) {
            d();
        }
    }

    @Override // java.util.List
    public final boolean addAll(int i2, Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zAddAll = ((List) this.f33121b).addAll(i2, collection);
        if (!zAddAll) {
            return zAddAll;
        }
        this.f33126f.f33128e += this.f33121b.size() - size;
        if (size != 0) {
            return zAddAll;
        }
        d();
        return true;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        b();
        return ((List) this.f33121b).get(i2);
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        b();
        return ((List) this.f33121b).indexOf(obj);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        b();
        return ((List) this.f33121b).lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        b();
        return new zzgrr(this);
    }

    @Override // java.util.List
    public final Object remove(int i2) {
        b();
        Object objRemove = ((List) this.f33121b).remove(i2);
        zzgrt zzgrtVar = this.f33126f;
        zzgrtVar.f33128e--;
        zzb();
        return objRemove;
    }

    @Override // java.util.List
    public final Object set(int i2, Object obj) {
        b();
        return ((List) this.f33121b).set(i2, obj);
    }

    @Override // java.util.List
    public final List subList(int i2, int i3) {
        b();
        List listSubList = ((List) this.f33121b).subList(i2, i3);
        zzgrs zzgrsVar = this.f33122c;
        if (zzgrsVar == null) {
            zzgrsVar = this;
        }
        zzgrt zzgrtVar = this.f33126f;
        zzgrtVar.getClass();
        boolean z = listSubList instanceof RandomAccess;
        Object obj = this.f33120a;
        return z ? new zzgrm(zzgrtVar, obj, listSubList, zzgrsVar) : new zzgrs(zzgrtVar, obj, listSubList, zzgrsVar);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i2) {
        b();
        return new zzgrr(this, i2);
    }
}
