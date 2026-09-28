package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzgnq extends zzgos {

    /* renamed from: a, reason: collision with root package name */
    public String f32997a;

    /* renamed from: b, reason: collision with root package name */
    public String f32998b;

    @Override // com.google.android.gms.internal.ads.zzgos
    public final zzgos a(String str) {
        this.f32997a = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgos
    public final zzgos b(String str) {
        this.f32998b = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgos
    public final zzgot c() {
        return new zzgnr(this.f32997a, this.f32998b);
    }
}
