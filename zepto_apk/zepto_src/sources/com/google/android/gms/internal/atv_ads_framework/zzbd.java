package com.google.android.gms.internal.atv_ads_framework;

/* loaded from: classes4.dex */
final class zzbd extends zzbe {

    /* renamed from: c, reason: collision with root package name */
    public final transient int f36042c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f36043d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzbe f36044e;

    public zzbd(zzbe zzbeVar, int i2, int i3) {
        this.f36044e = zzbeVar;
        this.f36042c = i2;
        this.f36043d = i3;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbb
    public final int d() {
        return this.f36044e.f() + this.f36042c + this.f36043d;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbb
    public final int f() {
        return this.f36044e.f() + this.f36042c;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        zzaq.a(i2, this.f36043d);
        return this.f36044e.get(i2 + this.f36042c);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbb
    public final boolean j() {
        return true;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbb
    public final Object[] k() {
        return this.f36044e.k();
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbe, java.util.List
    /* renamed from: m */
    public final zzbe subList(int i2, int i3) {
        zzaq.c(i2, i3, this.f36043d);
        int i4 = this.f36042c;
        return this.f36044e.subList(i2 + i4, i3 + i4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f36043d;
    }
}
