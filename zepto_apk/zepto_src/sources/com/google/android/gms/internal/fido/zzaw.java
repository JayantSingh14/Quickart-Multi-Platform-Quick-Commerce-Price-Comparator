package com.google.android.gms.internal.fido;

/* loaded from: classes4.dex */
final class zzaw extends zzat {

    /* renamed from: e, reason: collision with root package name */
    public static final zzat f36588e = new zzaw(new Object[0], 0);

    /* renamed from: c, reason: collision with root package name */
    public final transient Object[] f36589c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f36590d;

    public zzaw(Object[] objArr, int i2) {
        this.f36589c = objArr;
        this.f36590d = i2;
    }

    @Override // com.google.android.gms.internal.fido.zzat, com.google.android.gms.internal.fido.zzaq
    public final void b(Object[] objArr) {
        System.arraycopy(this.f36589c, 0, objArr, 0, this.f36590d);
    }

    @Override // com.google.android.gms.internal.fido.zzaq
    public final int d() {
        return this.f36590d;
    }

    @Override // com.google.android.gms.internal.fido.zzaq
    public final int f() {
        return 0;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        zzam.a(i2, this.f36590d);
        Object obj = this.f36589c[i2];
        obj.getClass();
        return obj;
    }

    @Override // com.google.android.gms.internal.fido.zzaq
    public final Object[] i() {
        return this.f36589c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f36590d;
    }
}
