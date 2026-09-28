package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzgve extends zzgtn {

    /* renamed from: i, reason: collision with root package name */
    public static final Object[] f33248i;

    /* renamed from: j, reason: collision with root package name */
    public static final zzgve f33249j;

    /* renamed from: d, reason: collision with root package name */
    public final transient Object[] f33250d;

    /* renamed from: e, reason: collision with root package name */
    public final transient int f33251e;

    /* renamed from: f, reason: collision with root package name */
    public final transient Object[] f33252f;

    /* renamed from: g, reason: collision with root package name */
    public final transient int f33253g;

    /* renamed from: h, reason: collision with root package name */
    public final transient int f33254h;

    static {
        Object[] objArr = new Object[0];
        f33248i = objArr;
        f33249j = new zzgve(objArr, 0, objArr, 0, 0);
    }

    public zzgve(Object[] objArr, int i2, Object[] objArr2, int i3, int i4) {
        this.f33250d = objArr;
        this.f33251e = i2;
        this.f33252f = objArr2;
        this.f33253g = i3;
        this.f33254h = i4;
    }

    @Override // com.google.android.gms.internal.ads.zzgsz
    /* renamed from: b */
    public final zzgvr iterator() {
        return i().listIterator(0);
    }

    @Override // com.google.android.gms.internal.ads.zzgsz, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj != null) {
            Object[] objArr = this.f33252f;
            if (objArr.length != 0) {
                int iB = zzgsw.b(obj);
                while (true) {
                    int i2 = iB & this.f33253g;
                    Object obj2 = objArr[i2];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    iB = i2 + 1;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzgsz
    public final Object[] d() {
        return this.f33250d;
    }

    @Override // com.google.android.gms.internal.ads.zzgsz
    public final int f() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzgsz
    public final int g() {
        return this.f33254h;
    }

    @Override // com.google.android.gms.internal.ads.zzgtn, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f33251e;
    }

    @Override // com.google.android.gms.internal.ads.zzgtn, com.google.android.gms.internal.ads.zzgsz, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return i().listIterator(0);
    }

    @Override // com.google.android.gms.internal.ads.zzgsz
    public final boolean j() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzgsz
    public final int k(int i2, Object[] objArr) {
        Object[] objArr2 = this.f33250d;
        int i3 = this.f33254h;
        System.arraycopy(objArr2, 0, objArr, i2, i3);
        return i2 + i3;
    }

    @Override // com.google.android.gms.internal.ads.zzgtn
    public final zzgtd r() {
        return zzgtd.t(this.f33254h, this.f33250d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f33254h;
    }
}
