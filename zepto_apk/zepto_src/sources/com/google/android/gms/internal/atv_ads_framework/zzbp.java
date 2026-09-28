package com.google.android.gms.internal.atv_ads_framework;

/* loaded from: classes4.dex */
final class zzbp extends zzbe {

    /* renamed from: c, reason: collision with root package name */
    public final transient Object[] f36067c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f36068d;

    /* renamed from: e, reason: collision with root package name */
    public final transient int f36069e;

    public zzbp(Object[] objArr, int i2, int i3) {
        this.f36067c = objArr;
        this.f36068d = i2;
        this.f36069e = i3;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        zzaq.a(i2, this.f36069e);
        Object obj = this.f36067c[i2 + i2 + this.f36068d];
        obj.getClass();
        return obj;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbb
    public final boolean j() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f36069e;
    }
}
