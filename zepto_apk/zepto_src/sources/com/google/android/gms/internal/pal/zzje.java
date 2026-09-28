package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
final class zzje extends zziz {

    /* renamed from: e, reason: collision with root package name */
    public static final zziz f37832e = new zzje(new Object[0], 0);

    /* renamed from: c, reason: collision with root package name */
    public final transient Object[] f37833c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f37834d;

    public zzje(Object[] objArr, int i2) {
        this.f37833c = objArr;
        this.f37834d = i2;
    }

    @Override // com.google.android.gms.internal.pal.zziz, com.google.android.gms.internal.pal.zziw
    public final int b(Object[] objArr) {
        Object[] objArr2 = this.f37833c;
        int i2 = this.f37834d;
        System.arraycopy(objArr2, 0, objArr, 0, i2);
        return i2;
    }

    @Override // com.google.android.gms.internal.pal.zziw
    public final int d() {
        return this.f37834d;
    }

    @Override // com.google.android.gms.internal.pal.zziw
    public final int f() {
        return 0;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        zzip.a(i2, this.f37834d);
        Object obj = this.f37833c[i2];
        obj.getClass();
        return obj;
    }

    @Override // com.google.android.gms.internal.pal.zziw
    public final Object[] i() {
        return this.f37833c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f37834d;
    }
}
