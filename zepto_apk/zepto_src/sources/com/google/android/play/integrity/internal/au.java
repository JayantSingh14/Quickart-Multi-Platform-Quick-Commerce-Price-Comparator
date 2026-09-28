package com.google.android.play.integrity.internal;

import java.util.Iterator;

/* loaded from: classes4.dex */
final class au extends as {

    /* renamed from: e, reason: collision with root package name */
    public static final Object[] f42181e;

    /* renamed from: f, reason: collision with root package name */
    public static final au f42182f;

    /* renamed from: c, reason: collision with root package name */
    public final transient Object[] f42183c;

    /* renamed from: d, reason: collision with root package name */
    public final transient Object[] f42184d;

    static {
        Object[] objArr = new Object[0];
        f42181e = objArr;
        f42182f = new au(objArr, objArr);
    }

    public au(Object[] objArr, Object[] objArr2) {
        this.f42183c = objArr;
        this.f42184d = objArr2;
    }

    @Override // com.google.android.play.integrity.internal.ao
    public final void b(Object[] objArr) {
        System.arraycopy(this.f42183c, 0, objArr, 0, 0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        int length = this.f42184d.length;
        return false;
    }

    @Override // com.google.android.play.integrity.internal.ao
    public final int d() {
        return 0;
    }

    @Override // com.google.android.play.integrity.internal.ao
    public final int f() {
        return 0;
    }

    @Override // com.google.android.play.integrity.internal.ao
    /* renamed from: g */
    public final av iterator() {
        ar arVar = this.f42178b;
        if (arVar == null) {
            aw awVar = ar.f42177b;
            arVar = at.f42179d;
            this.f42178b = arVar;
        }
        return arVar.listIterator(0);
    }

    @Override // com.google.android.play.integrity.internal.as, java.util.Collection, java.util.Set
    public final int hashCode() {
        return 0;
    }

    @Override // com.google.android.play.integrity.internal.ao
    public final Object[] i() {
        return this.f42183c;
    }

    @Override // com.google.android.play.integrity.internal.as, com.google.android.play.integrity.internal.ao, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        ar arVar = this.f42178b;
        if (arVar == null) {
            aw awVar = ar.f42177b;
            arVar = at.f42179d;
            this.f42178b = arVar;
        }
        return arVar.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 0;
    }

    @Override // com.google.android.play.integrity.internal.as
    public final void k() {
    }
}
