package com.google.android.gms.internal.consent_sdk;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzdh extends zzde {

    /* renamed from: e, reason: collision with root package name */
    public static final zzde f36554e = new zzdh(new Object[0], 0);

    /* renamed from: c, reason: collision with root package name */
    public final transient Object[] f36555c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f36556d;

    public zzdh(Object[] objArr, int i2) {
        this.f36555c = objArr;
        this.f36556d = i2;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzde, com.google.android.gms.internal.consent_sdk.zzdb
    public final void b(Object[] objArr) {
        System.arraycopy(this.f36555c, 0, objArr, 0, this.f36556d);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdb
    public final int d() {
        return this.f36556d;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdb
    public final int f() {
        return 0;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        zzcx.a(i2, this.f36556d);
        Object obj = this.f36555c[i2];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdb
    public final Object[] i() {
        return this.f36555c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f36556d;
    }
}
