package com.google.android.gms.internal.fido;

/* loaded from: classes4.dex */
final class zzas extends zzat {

    /* renamed from: c, reason: collision with root package name */
    public final transient int f36581c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f36582d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzat f36583e;

    public zzas(zzat zzatVar, int i2, int i3) {
        this.f36583e = zzatVar;
        this.f36581c = i2;
        this.f36582d = i3;
    }

    @Override // com.google.android.gms.internal.fido.zzaq
    public final int d() {
        return this.f36583e.f() + this.f36581c + this.f36582d;
    }

    @Override // com.google.android.gms.internal.fido.zzaq
    public final int f() {
        return this.f36583e.f() + this.f36581c;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        zzam.a(i2, this.f36582d);
        return this.f36583e.get(i2 + this.f36581c);
    }

    @Override // com.google.android.gms.internal.fido.zzaq
    public final Object[] i() {
        return this.f36583e.i();
    }

    @Override // com.google.android.gms.internal.fido.zzat, java.util.List
    /* renamed from: j */
    public final zzat subList(int i2, int i3) {
        zzam.b(i2, i3, this.f36582d);
        int i4 = this.f36581c;
        return this.f36583e.subList(i2 + i4, i3 + i4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f36582d;
    }
}
