package com.google.android.gms.internal.consent_sdk;

/* loaded from: classes4.dex */
final class zzdd extends zzde {

    /* renamed from: c, reason: collision with root package name */
    public final transient int f36547c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f36548d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzde f36549e;

    public zzdd(zzde zzdeVar, int i2, int i3) {
        this.f36549e = zzdeVar;
        this.f36547c = i2;
        this.f36548d = i3;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdb
    public final int d() {
        return this.f36549e.f() + this.f36547c + this.f36548d;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdb
    public final int f() {
        return this.f36549e.f() + this.f36547c;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        zzcx.a(i2, this.f36548d);
        return this.f36549e.get(i2 + this.f36547c);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdb
    public final Object[] i() {
        return this.f36549e.i();
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzde, java.util.List
    /* renamed from: j */
    public final zzde subList(int i2, int i3) {
        zzcx.b(i2, i3, this.f36548d);
        int i4 = this.f36547c;
        return this.f36549e.subList(i2 + i4, i3 + i4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f36548d;
    }
}
