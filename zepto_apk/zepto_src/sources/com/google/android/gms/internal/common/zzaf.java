package com.google.android.gms.internal.common;

/* loaded from: classes4.dex */
final class zzaf extends zzah {

    /* renamed from: c, reason: collision with root package name */
    public final transient zzah f36483c;

    public zzaf(zzah zzahVar) {
        this.f36483c = zzahVar;
    }

    @Override // com.google.android.gms.internal.common.zzah, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return this.f36483c.contains(obj);
    }

    @Override // java.util.List
    public final Object get(int i2) {
        zzah zzahVar = this.f36483c;
        zzr.a(i2, zzahVar.size());
        return zzahVar.get((zzahVar.size() - 1) - i2);
    }

    @Override // com.google.android.gms.internal.common.zzah, java.util.List
    public final int indexOf(Object obj) {
        int iLastIndexOf = this.f36483c.lastIndexOf(obj);
        if (iLastIndexOf >= 0) {
            return (r0.size() - 1) - iLastIndexOf;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.common.zzac
    public final boolean j() {
        return this.f36483c.j();
    }

    @Override // com.google.android.gms.internal.common.zzah, java.util.List
    public final int lastIndexOf(Object obj) {
        int iIndexOf = this.f36483c.indexOf(obj);
        if (iIndexOf >= 0) {
            return (r0.size() - 1) - iIndexOf;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.common.zzah
    public final zzah m() {
        return this.f36483c;
    }

    @Override // com.google.android.gms.internal.common.zzah, java.util.List
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public final zzah subList(int i2, int i3) {
        zzah zzahVar = this.f36483c;
        zzr.c(i2, i3, zzahVar.size());
        return zzahVar.subList(zzahVar.size() - i3, zzahVar.size() - i2).m();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f36483c.size();
    }
}
