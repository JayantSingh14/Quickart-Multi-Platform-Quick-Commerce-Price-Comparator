package com.google.android.gms.internal.maps;

import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzbd extends zzba {

    /* renamed from: i, reason: collision with root package name */
    public static final Object[] f36729i;

    /* renamed from: j, reason: collision with root package name */
    public static final zzbd f36730j;

    /* renamed from: d, reason: collision with root package name */
    public final transient Object[] f36731d;

    /* renamed from: e, reason: collision with root package name */
    public final transient int f36732e;

    /* renamed from: f, reason: collision with root package name */
    public final transient Object[] f36733f;

    /* renamed from: g, reason: collision with root package name */
    public final transient int f36734g;

    /* renamed from: h, reason: collision with root package name */
    public final transient int f36735h;

    static {
        Object[] objArr = new Object[0];
        f36729i = objArr;
        f36730j = new zzbd(objArr, 0, objArr, 0, 0);
    }

    public zzbd(Object[] objArr, int i2, Object[] objArr2, int i3, int i4) {
        this.f36731d = objArr;
        this.f36732e = i2;
        this.f36733f = objArr2;
        this.f36734g = i3;
        this.f36735h = i4;
    }

    @Override // com.google.android.gms.internal.maps.zzaw
    public final void b(Object[] objArr) {
        System.arraycopy(this.f36731d, 0, objArr, 0, this.f36735h);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        Object[] objArr = this.f36733f;
        if (objArr.length == 0) {
            return false;
        }
        int iRotateLeft = (int) (Integer.rotateLeft((int) (obj.hashCode() * (-862048943)), 15) * 461845907);
        while (true) {
            int i2 = iRotateLeft & this.f36734g;
            Object obj2 = objArr[i2];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            iRotateLeft = i2 + 1;
        }
    }

    @Override // com.google.android.gms.internal.maps.zzaw
    public final int d() {
        return this.f36735h;
    }

    @Override // com.google.android.gms.internal.maps.zzaw
    public final int f() {
        return 0;
    }

    @Override // com.google.android.gms.internal.maps.zzaw
    /* renamed from: g */
    public final zzbf iterator() {
        zzaz zzbcVar = this.f36723b;
        if (zzbcVar == null) {
            zzbg zzbgVar = zzaz.f36721b;
            int i2 = this.f36735h;
            zzbcVar = i2 == 0 ? zzbc.f36726e : new zzbc(this.f36731d, i2);
            this.f36723b = zzbcVar;
        }
        return zzbcVar.listIterator(0);
    }

    @Override // com.google.android.gms.internal.maps.zzba, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f36732e;
    }

    @Override // com.google.android.gms.internal.maps.zzaw
    public final Object[] i() {
        return this.f36731d;
    }

    @Override // com.google.android.gms.internal.maps.zzba, com.google.android.gms.internal.maps.zzaw, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        zzaz zzbcVar = this.f36723b;
        if (zzbcVar == null) {
            zzbg zzbgVar = zzaz.f36721b;
            int i2 = this.f36735h;
            zzbcVar = i2 == 0 ? zzbc.f36726e : new zzbc(this.f36731d, i2);
            this.f36723b = zzbcVar;
        }
        return zzbcVar.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f36735h;
    }
}
