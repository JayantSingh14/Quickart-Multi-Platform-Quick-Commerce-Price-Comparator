package com.google.android.gms.internal.maps;

/* loaded from: classes4.dex */
final class zzbc extends zzaz {

    /* renamed from: e, reason: collision with root package name */
    public static final zzaz f36726e = new zzbc(new Object[0], 0);

    /* renamed from: c, reason: collision with root package name */
    public final transient Object[] f36727c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f36728d;

    public zzbc(Object[] objArr, int i2) {
        this.f36727c = objArr;
        this.f36728d = i2;
    }

    @Override // com.google.android.gms.internal.maps.zzaz, com.google.android.gms.internal.maps.zzaw
    public final void b(Object[] objArr) {
        System.arraycopy(this.f36727c, 0, objArr, 0, this.f36728d);
    }

    @Override // com.google.android.gms.internal.maps.zzaw
    public final int d() {
        return this.f36728d;
    }

    @Override // com.google.android.gms.internal.maps.zzaw
    public final int f() {
        return 0;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        zzas.a(i2, this.f36728d);
        Object obj = this.f36727c[i2];
        obj.getClass();
        return obj;
    }

    @Override // com.google.android.gms.internal.maps.zzaw
    public final Object[] i() {
        return this.f36727c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f36728d;
    }
}
