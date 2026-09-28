package com.google.android.gms.internal.maps;

/* loaded from: classes4.dex */
final class zzay extends zzaz {

    /* renamed from: c, reason: collision with root package name */
    public final transient int f36718c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f36719d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzaz f36720e;

    public zzay(zzaz zzazVar, int i2, int i3) {
        this.f36720e = zzazVar;
        this.f36718c = i2;
        this.f36719d = i3;
    }

    @Override // com.google.android.gms.internal.maps.zzaw
    public final int d() {
        return this.f36720e.f() + this.f36718c + this.f36719d;
    }

    @Override // com.google.android.gms.internal.maps.zzaw
    public final int f() {
        return this.f36720e.f() + this.f36718c;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        zzas.a(i2, this.f36719d);
        return this.f36720e.get(i2 + this.f36718c);
    }

    @Override // com.google.android.gms.internal.maps.zzaw
    public final Object[] i() {
        return this.f36720e.i();
    }

    @Override // com.google.android.gms.internal.maps.zzaz, java.util.List
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public final zzaz subList(int i2, int i3) {
        zzas.b(i2, i3, this.f36719d);
        int i4 = this.f36718c;
        return this.f36720e.subList(i2 + i4, i3 + i4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f36719d;
    }
}
