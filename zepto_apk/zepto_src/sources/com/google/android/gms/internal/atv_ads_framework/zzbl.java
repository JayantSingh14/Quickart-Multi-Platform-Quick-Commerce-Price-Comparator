package com.google.android.gms.internal.atv_ads_framework;

/* loaded from: classes4.dex */
final class zzbl extends zzbe {

    /* renamed from: e, reason: collision with root package name */
    public static final zzbe f36058e = new zzbl(new Object[0], 0);

    /* renamed from: c, reason: collision with root package name */
    public final transient Object[] f36059c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f36060d;

    public zzbl(Object[] objArr, int i2) {
        this.f36059c = objArr;
        this.f36060d = i2;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbe, com.google.android.gms.internal.atv_ads_framework.zzbb
    public final int b(Object[] objArr) {
        Object[] objArr2 = this.f36059c;
        int i2 = this.f36060d;
        System.arraycopy(objArr2, 0, objArr, 0, i2);
        return i2;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbb
    public final int d() {
        return this.f36060d;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbb
    public final int f() {
        return 0;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        zzaq.a(i2, this.f36060d);
        Object obj = this.f36059c[i2];
        obj.getClass();
        return obj;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbb
    public final boolean j() {
        return false;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbb
    public final Object[] k() {
        return this.f36059c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f36060d;
    }
}
