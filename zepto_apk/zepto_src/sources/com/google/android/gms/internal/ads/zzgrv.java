package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzgrv extends AbstractCollection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzgrt f33129a;

    public zzgrv(zzgrt zzgrtVar) {
        this.f33129a = zzgrtVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.f33129a.d();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f33129a.b(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        zzgrt zzgrtVar = this.f33129a;
        zzgrtVar.getClass();
        return new zzgrd(zzgrtVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.f33129a.f33128e;
    }
}
