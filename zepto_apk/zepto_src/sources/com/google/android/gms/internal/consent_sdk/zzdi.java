package com.google.android.gms.internal.consent_sdk;

import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzdi extends zzdf {

    /* renamed from: h, reason: collision with root package name */
    public static final Object[] f36557h;

    /* renamed from: i, reason: collision with root package name */
    public static final zzdi f36558i;

    /* renamed from: c, reason: collision with root package name */
    public final transient Object[] f36559c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f36560d;

    /* renamed from: e, reason: collision with root package name */
    public final transient Object[] f36561e;

    /* renamed from: f, reason: collision with root package name */
    public final transient int f36562f;

    /* renamed from: g, reason: collision with root package name */
    public final transient int f36563g;

    static {
        Object[] objArr = new Object[0];
        f36557h = objArr;
        f36558i = new zzdi(objArr, 0, objArr, 0, 0);
    }

    public zzdi(Object[] objArr, int i2, Object[] objArr2, int i3, int i4) {
        this.f36559c = objArr;
        this.f36560d = i2;
        this.f36561e = objArr2;
        this.f36562f = i3;
        this.f36563g = i4;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdb
    public final void b(Object[] objArr) {
        System.arraycopy(this.f36559c, 0, objArr, 0, this.f36563g);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        Object[] objArr = this.f36561e;
        if (objArr.length == 0) {
            return false;
        }
        int iRotateLeft = (int) (Integer.rotateLeft((int) (obj.hashCode() * (-862048943)), 15) * 461845907);
        while (true) {
            int i2 = iRotateLeft & this.f36562f;
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

    @Override // com.google.android.gms.internal.consent_sdk.zzdb
    public final int d() {
        return this.f36563g;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdb
    public final int f() {
        return 0;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdb
    /* renamed from: g */
    public final zzdk iterator() {
        zzde zzdhVar = this.f36551b;
        if (zzdhVar == null) {
            zzdl zzdlVar = zzde.f36550b;
            int i2 = this.f36563g;
            zzdhVar = i2 == 0 ? zzdh.f36554e : new zzdh(this.f36559c, i2);
            this.f36551b = zzdhVar;
        }
        return zzdhVar.listIterator(0);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdf, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f36560d;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdb
    public final Object[] i() {
        return this.f36559c;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdf, com.google.android.gms.internal.consent_sdk.zzdb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        zzde zzdhVar = this.f36551b;
        if (zzdhVar == null) {
            zzdl zzdlVar = zzde.f36550b;
            int i2 = this.f36563g;
            zzdhVar = i2 == 0 ? zzdh.f36554e : new zzdh(this.f36559c, i2);
            this.f36551b = zzdhVar;
        }
        return zzdhVar.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f36563g;
    }
}
