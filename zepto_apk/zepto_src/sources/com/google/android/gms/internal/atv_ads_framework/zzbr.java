package com.google.android.gms.internal.atv_ads_framework;

import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzbr extends zzbi {

    /* renamed from: h, reason: collision with root package name */
    public static final Object[] f36074h;

    /* renamed from: i, reason: collision with root package name */
    public static final zzbr f36075i;

    /* renamed from: c, reason: collision with root package name */
    public final transient Object[] f36076c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f36077d;

    /* renamed from: e, reason: collision with root package name */
    public final transient Object[] f36078e;

    /* renamed from: f, reason: collision with root package name */
    public final transient int f36079f;

    /* renamed from: g, reason: collision with root package name */
    public final transient int f36080g;

    static {
        Object[] objArr = new Object[0];
        f36074h = objArr;
        f36075i = new zzbr(objArr, 0, objArr, 0, 0);
    }

    public zzbr(Object[] objArr, int i2, Object[] objArr2, int i3, int i4) {
        this.f36076c = objArr;
        this.f36077d = i2;
        this.f36078e = objArr2;
        this.f36079f = i3;
        this.f36080g = i4;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbb
    public final int b(Object[] objArr) {
        Object[] objArr2 = this.f36076c;
        int i2 = this.f36080g;
        System.arraycopy(objArr2, 0, objArr, 0, i2);
        return i2;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbb, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj != null) {
            Object[] objArr = this.f36078e;
            if (objArr.length != 0) {
                int iA = zzba.a(obj.hashCode());
                while (true) {
                    int i2 = iA & this.f36079f;
                    Object obj2 = objArr[i2];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    iA = i2 + 1;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbb
    public final int d() {
        return this.f36080g;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbb
    public final int f() {
        return 0;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbi, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f36077d;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbb
    /* renamed from: i */
    public final zzbu iterator() {
        return g().listIterator(0);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbi, com.google.android.gms.internal.atv_ads_framework.zzbb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return g().listIterator(0);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbb
    public final Object[] k() {
        return this.f36076c;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbi
    public final zzbe n() {
        return zzbe.n(this.f36080g, this.f36076c);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f36080g;
    }
}
