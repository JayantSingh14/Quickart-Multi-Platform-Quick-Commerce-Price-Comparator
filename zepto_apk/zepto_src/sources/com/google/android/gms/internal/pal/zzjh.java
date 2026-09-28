package com.google.android.gms.internal.pal;

import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzjh extends zzjd {

    /* renamed from: c, reason: collision with root package name */
    public final transient zzjc f37839c;

    /* renamed from: d, reason: collision with root package name */
    public final transient zziz f37840d;

    public zzjh(zzjc zzjcVar, zziz zzizVar) {
        this.f37839c = zzjcVar;
        this.f37840d = zzizVar;
    }

    @Override // com.google.android.gms.internal.pal.zziw
    public final int b(Object[] objArr) {
        return this.f37840d.b(objArr);
    }

    @Override // com.google.android.gms.internal.pal.zziw, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f37839c.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.pal.zziw
    /* renamed from: g */
    public final zzjl iterator() {
        return this.f37840d.listIterator(0);
    }

    @Override // com.google.android.gms.internal.pal.zzjd, com.google.android.gms.internal.pal.zziw, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.f37840d.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f37839c.size();
    }
}
