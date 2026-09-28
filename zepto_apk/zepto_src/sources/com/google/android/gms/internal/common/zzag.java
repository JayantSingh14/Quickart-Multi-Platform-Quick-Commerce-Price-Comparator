package com.google.android.gms.internal.common;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzag extends zzah {

    /* renamed from: c, reason: collision with root package name */
    public final transient int f36484c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f36485d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzah f36486e;

    public zzag(zzah zzahVar, int i2, int i3) {
        Objects.requireNonNull(zzahVar);
        this.f36486e = zzahVar;
        this.f36484c = i2;
        this.f36485d = i3;
    }

    @Override // com.google.android.gms.internal.common.zzac
    public final Object[] d() {
        return this.f36486e.d();
    }

    @Override // com.google.android.gms.internal.common.zzac
    public final int f() {
        return this.f36486e.f() + this.f36484c;
    }

    @Override // com.google.android.gms.internal.common.zzac
    public final int g() {
        return this.f36486e.f() + this.f36484c + this.f36485d;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        zzr.a(i2, this.f36485d);
        return this.f36486e.get(i2 + this.f36484c);
    }

    @Override // com.google.android.gms.internal.common.zzac
    public final boolean j() {
        return true;
    }

    @Override // com.google.android.gms.internal.common.zzah, java.util.List
    /* renamed from: n */
    public final zzah subList(int i2, int i3) {
        zzr.c(i2, i3, this.f36485d);
        int i4 = this.f36484c;
        return this.f36486e.subList(i2 + i4, i3 + i4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f36485d;
    }
}
