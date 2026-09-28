package com.google.android.gms.internal.location;

/* loaded from: classes4.dex */
final class zzdt extends zzds {

    /* renamed from: e, reason: collision with root package name */
    public static final zzds f36702e = new zzdt(new Object[0], 0);

    /* renamed from: c, reason: collision with root package name */
    public final transient Object[] f36703c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f36704d;

    public zzdt(Object[] objArr, int i2) {
        this.f36703c = objArr;
        this.f36704d = i2;
    }

    @Override // com.google.android.gms.internal.location.zzds, com.google.android.gms.internal.location.zzdp
    public final void b(Object[] objArr) {
        System.arraycopy(this.f36703c, 0, objArr, 0, this.f36704d);
    }

    @Override // com.google.android.gms.internal.location.zzdp
    public final int d() {
        return this.f36704d;
    }

    @Override // com.google.android.gms.internal.location.zzdp
    public final int f() {
        return 0;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        zzdm.a(i2, this.f36704d);
        Object obj = this.f36703c[i2];
        obj.getClass();
        return obj;
    }

    @Override // com.google.android.gms.internal.location.zzdp
    public final boolean j() {
        return false;
    }

    @Override // com.google.android.gms.internal.location.zzdp
    public final Object[] k() {
        return this.f36703c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f36704d;
    }
}
