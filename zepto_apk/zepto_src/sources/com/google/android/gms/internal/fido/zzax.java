package com.google.android.gms.internal.fido;

import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzax extends zzau {

    /* renamed from: h, reason: collision with root package name */
    public static final Object[] f36591h;

    /* renamed from: i, reason: collision with root package name */
    public static final zzax f36592i;

    /* renamed from: c, reason: collision with root package name */
    public final transient Object[] f36593c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f36594d;

    /* renamed from: e, reason: collision with root package name */
    public final transient Object[] f36595e;

    /* renamed from: f, reason: collision with root package name */
    public final transient int f36596f;

    /* renamed from: g, reason: collision with root package name */
    public final transient int f36597g;

    static {
        Object[] objArr = new Object[0];
        f36591h = objArr;
        f36592i = new zzax(objArr, 0, objArr, 0, 0);
    }

    public zzax(Object[] objArr, int i2, Object[] objArr2, int i3, int i4) {
        this.f36593c = objArr;
        this.f36594d = i2;
        this.f36595e = objArr2;
        this.f36596f = i3;
        this.f36597g = i4;
    }

    @Override // com.google.android.gms.internal.fido.zzaq
    public final void b(Object[] objArr) {
        System.arraycopy(this.f36593c, 0, objArr, 0, this.f36597g);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        Object[] objArr = this.f36595e;
        if (objArr.length == 0) {
            return false;
        }
        int iRotateLeft = (int) (Integer.rotateLeft((int) (obj.hashCode() * (-862048943)), 15) * 461845907);
        while (true) {
            int i2 = iRotateLeft & this.f36596f;
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

    @Override // com.google.android.gms.internal.fido.zzaq
    public final int d() {
        return this.f36597g;
    }

    @Override // com.google.android.gms.internal.fido.zzaq
    public final int f() {
        return 0;
    }

    @Override // com.google.android.gms.internal.fido.zzaq
    /* renamed from: g */
    public final zzaz iterator() {
        zzat zzawVar = this.f36585b;
        if (zzawVar == null) {
            zzba zzbaVar = zzat.f36584b;
            int i2 = this.f36597g;
            zzawVar = i2 == 0 ? zzaw.f36588e : new zzaw(this.f36593c, i2);
            this.f36585b = zzawVar;
        }
        return zzawVar.listIterator(0);
    }

    @Override // com.google.android.gms.internal.fido.zzau, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f36594d;
    }

    @Override // com.google.android.gms.internal.fido.zzaq
    public final Object[] i() {
        return this.f36593c;
    }

    @Override // com.google.android.gms.internal.fido.zzau, com.google.android.gms.internal.fido.zzaq, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        zzat zzawVar = this.f36585b;
        if (zzawVar == null) {
            zzba zzbaVar = zzat.f36584b;
            int i2 = this.f36597g;
            zzawVar = i2 == 0 ? zzaw.f36588e : new zzaw(this.f36593c, i2);
            this.f36585b = zzawVar;
        }
        return zzawVar.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f36597g;
    }
}
