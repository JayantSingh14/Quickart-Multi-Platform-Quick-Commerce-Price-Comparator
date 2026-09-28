package com.google.android.play.integrity.internal;

import java.util.Objects;

/* loaded from: classes4.dex */
final class at extends ar {

    /* renamed from: d, reason: collision with root package name */
    public static final ar f42179d = new at(new Object[0]);

    /* renamed from: c, reason: collision with root package name */
    public final transient Object[] f42180c;

    public at(Object[] objArr) {
        this.f42180c = objArr;
    }

    @Override // com.google.android.play.integrity.internal.ar, com.google.android.play.integrity.internal.ao
    public final void b(Object[] objArr) {
        System.arraycopy(this.f42180c, 0, objArr, 0, 0);
    }

    @Override // com.google.android.play.integrity.internal.ao
    public final int d() {
        return 0;
    }

    @Override // com.google.android.play.integrity.internal.ao
    public final int f() {
        return 0;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        al.a(i2, 0);
        Object obj = this.f42180c[i2];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // com.google.android.play.integrity.internal.ao
    public final Object[] i() {
        return this.f42180c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return 0;
    }
}
