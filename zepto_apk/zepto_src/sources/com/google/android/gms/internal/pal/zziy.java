package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
final class zziy extends zziz {

    /* renamed from: c, reason: collision with root package name */
    public final transient int f37818c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f37819d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zziz f37820e;

    public zziy(zziz zzizVar, int i2, int i3) {
        this.f37820e = zzizVar;
        this.f37818c = i2;
        this.f37819d = i3;
    }

    @Override // com.google.android.gms.internal.pal.zziw
    public final int d() {
        return this.f37820e.f() + this.f37818c + this.f37819d;
    }

    @Override // com.google.android.gms.internal.pal.zziw
    public final int f() {
        return this.f37820e.f() + this.f37818c;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        zzip.a(i2, this.f37819d);
        return this.f37820e.get(i2 + this.f37818c);
    }

    @Override // com.google.android.gms.internal.pal.zziw
    public final Object[] i() {
        return this.f37820e.i();
    }

    @Override // com.google.android.gms.internal.pal.zziz, java.util.List
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public final zziz subList(int i2, int i3) {
        zzip.c(i2, i3, this.f37819d);
        int i4 = this.f37818c;
        return this.f37820e.subList(i2 + i4, i3 + i4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f37819d;
    }
}
