package com.google.android.gms.internal.common;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzaj extends zzah {

    /* renamed from: e, reason: collision with root package name */
    public static final zzah f36488e = new zzaj(new Object[0], 0);

    /* renamed from: c, reason: collision with root package name */
    public final transient Object[] f36489c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f36490d;

    public zzaj(Object[] objArr, int i2) {
        this.f36489c = objArr;
        this.f36490d = i2;
    }

    @Override // com.google.android.gms.internal.common.zzac
    public final Object[] d() {
        return this.f36489c;
    }

    @Override // com.google.android.gms.internal.common.zzac
    public final int f() {
        return 0;
    }

    @Override // com.google.android.gms.internal.common.zzac
    public final int g() {
        return this.f36490d;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        zzr.a(i2, this.f36490d);
        Object obj = this.f36489c[i2];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // com.google.android.gms.internal.common.zzac
    public final boolean j() {
        return false;
    }

    @Override // com.google.android.gms.internal.common.zzah, com.google.android.gms.internal.common.zzac
    public final void k(Object[] objArr) {
        System.arraycopy(this.f36489c, 0, objArr, 0, this.f36490d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f36490d;
    }
}
