package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes4.dex */
class zzgrp implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f33117a;

    /* renamed from: b, reason: collision with root package name */
    public final Collection f33118b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzgrq f33119c;

    public zzgrp(zzgrq zzgrqVar) {
        this.f33119c = zzgrqVar;
        Collection collection = zzgrqVar.f33121b;
        this.f33118b = collection;
        this.f33117a = collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    public final void a() {
        zzgrq zzgrqVar = this.f33119c;
        zzgrqVar.b();
        if (zzgrqVar.f33121b != this.f33118b) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        a();
        return this.f33117a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        a();
        return this.f33117a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f33117a.remove();
        zzgrq zzgrqVar = this.f33119c;
        zzgrt zzgrtVar = zzgrqVar.f33124e;
        zzgrtVar.f33128e--;
        zzgrqVar.zzb();
    }

    public zzgrp(zzgrs zzgrsVar, ListIterator listIterator) {
        this.f33119c = zzgrsVar;
        this.f33118b = zzgrsVar.f33121b;
        this.f33117a = listIterator;
    }
}
