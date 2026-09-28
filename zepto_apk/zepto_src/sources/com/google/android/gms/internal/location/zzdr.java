package com.google.android.gms.internal.location;

/* loaded from: classes4.dex */
final class zzdr extends zzds {

    /* renamed from: c, reason: collision with root package name */
    public final transient int f36698c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f36699d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzds f36700e;

    public zzdr(zzds zzdsVar, int i2, int i3) {
        this.f36700e = zzdsVar;
        this.f36698c = i2;
        this.f36699d = i3;
    }

    @Override // com.google.android.gms.internal.location.zzdp
    public final int d() {
        return this.f36700e.f() + this.f36698c + this.f36699d;
    }

    @Override // com.google.android.gms.internal.location.zzdp
    public final int f() {
        return this.f36700e.f() + this.f36698c;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        zzdm.a(i2, this.f36699d);
        return this.f36700e.get(i2 + this.f36698c);
    }

    @Override // com.google.android.gms.internal.location.zzdp
    public final boolean j() {
        return true;
    }

    @Override // com.google.android.gms.internal.location.zzdp
    public final Object[] k() {
        return this.f36700e.k();
    }

    @Override // com.google.android.gms.internal.location.zzds, java.util.List
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public final zzds subList(int i2, int i3) {
        zzdm.b(i2, i3, this.f36699d);
        int i4 = this.f36698c;
        return this.f36700e.subList(i2 + i4, i3 + i4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f36699d;
    }
}
