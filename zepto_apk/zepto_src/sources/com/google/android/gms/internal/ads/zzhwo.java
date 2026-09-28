package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzhwo implements zzhmn {

    /* renamed from: a, reason: collision with root package name */
    public final zzhmr f34425a;

    /* renamed from: b, reason: collision with root package name */
    public final zzhms f34426b;

    public /* synthetic */ zzhwo(zzhmr zzhmrVar, zzhms zzhmsVar) {
        this.f34425a = zzhmrVar;
        this.f34426b = zzhmsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhmn
    public final byte[] a(int i2, byte[] bArr) {
        return bArr.length <= 64 ? this.f34425a.a(i2, bArr) : this.f34426b.a(i2, bArr);
    }
}
