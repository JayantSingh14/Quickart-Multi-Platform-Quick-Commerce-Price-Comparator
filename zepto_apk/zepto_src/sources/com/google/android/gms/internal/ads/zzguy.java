package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzguy extends zzgtd {

    /* renamed from: e, reason: collision with root package name */
    public static final zzgtd f33232e = new zzguy(new Object[0], 0);

    /* renamed from: c, reason: collision with root package name */
    public final transient Object[] f33233c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f33234d;

    public zzguy(Object[] objArr, int i2) {
        this.f33233c = objArr;
        this.f33234d = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzgsz
    public final Object[] d() {
        return this.f33233c;
    }

    @Override // com.google.android.gms.internal.ads.zzgsz
    public final int f() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzgsz
    public final int g() {
        return this.f33234d;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        zzgqa.i(i2, this.f33234d);
        Object obj = this.f33233c[i2];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // com.google.android.gms.internal.ads.zzgsz
    public final boolean j() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzgtd, com.google.android.gms.internal.ads.zzgsz
    public final int k(int i2, Object[] objArr) {
        Object[] objArr2 = this.f33233c;
        int i3 = this.f33234d;
        System.arraycopy(objArr2, 0, objArr, i2, i3);
        return i2 + i3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f33234d;
    }
}
