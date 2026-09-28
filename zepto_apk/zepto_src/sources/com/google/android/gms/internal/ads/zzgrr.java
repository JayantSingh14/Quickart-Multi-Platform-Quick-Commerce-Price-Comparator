package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.ListIterator;

/* loaded from: classes4.dex */
final class zzgrr extends zzgrp implements ListIterator {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzgrs f33125d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgrr(zzgrs zzgrsVar) {
        super(zzgrsVar);
        this.f33125d = zzgrsVar;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        zzgrs zzgrsVar = this.f33125d;
        boolean zIsEmpty = zzgrsVar.isEmpty();
        a();
        ((ListIterator) this.f33117a).add(obj);
        zzgrsVar.f33126f.f33128e++;
        if (zIsEmpty) {
            zzgrsVar.d();
        }
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        a();
        return ((ListIterator) this.f33117a).hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        a();
        return ((ListIterator) this.f33117a).nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        a();
        return ((ListIterator) this.f33117a).previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        a();
        return ((ListIterator) this.f33117a).previousIndex();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        a();
        ((ListIterator) this.f33117a).set(obj);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzgrr(zzgrs zzgrsVar, int i2) {
        super(zzgrsVar, ((List) zzgrsVar.f33121b).listIterator(i2));
        this.f33125d = zzgrsVar;
    }
}
