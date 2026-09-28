package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzhzf extends zzhzj {

    /* renamed from: d, reason: collision with root package name */
    public final int f34548d;

    /* renamed from: e, reason: collision with root package name */
    public final int f34549e;

    public zzhzf(byte[] bArr, int i2, int i3) {
        super(bArr);
        zzhzl.d(i2, i2 + i3, bArr.length);
        this.f34548d = i2;
        this.f34549e = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzhzj
    public final int B() {
        return this.f34548d;
    }

    @Override // com.google.android.gms.internal.ads.zzhzj, com.google.android.gms.internal.ads.zzhzl
    public final byte f(int i2) {
        zzhzl.b(i2, this.f34549e);
        return this.f34550c[this.f34548d + i2];
    }

    @Override // com.google.android.gms.internal.ads.zzhzj, com.google.android.gms.internal.ads.zzhzl
    public final byte g(int i2) {
        return this.f34550c[this.f34548d + i2];
    }

    @Override // com.google.android.gms.internal.ads.zzhzj, com.google.android.gms.internal.ads.zzhzl
    public final int i() {
        return this.f34549e;
    }

    @Override // com.google.android.gms.internal.ads.zzhzj, com.google.android.gms.internal.ads.zzhzl
    public final void k(byte[] bArr, int i2, int i3, int i4) {
        System.arraycopy(this.f34550c, this.f34548d + i2, bArr, i3, i4);
    }
}
