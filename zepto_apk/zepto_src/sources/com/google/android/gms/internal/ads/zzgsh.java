package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzgsh extends AbstractSet {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzgsk f33150a;

    public /* synthetic */ zzgsh(zzgsk zzgskVar) {
        this.f33150a = zzgskVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f33150a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f33150a.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        zzgsk zzgskVar = this.f33150a;
        Map mapE = zzgskVar.e();
        return mapE != null ? mapE.keySet().iterator() : new zzgsc(zzgskVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        zzgsk zzgskVar = this.f33150a;
        Map mapE = zzgskVar.e();
        return mapE != null ? mapE.keySet().remove(obj) : zzgskVar.j(obj) != zzgsk.f33155j;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f33150a.size();
    }
}
