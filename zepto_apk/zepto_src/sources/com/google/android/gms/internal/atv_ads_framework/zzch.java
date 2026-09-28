package com.google.android.gms.internal.atv_ads_framework;

import android.support.v4.media.b;

/* loaded from: classes4.dex */
final class zzch extends zzck {

    /* renamed from: d, reason: collision with root package name */
    public final int f36093d;

    public zzch(byte[] bArr) {
        super(bArr);
        zzcn.n(bArr.length);
        this.f36093d = 47;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzck, com.google.android.gms.internal.atv_ads_framework.zzcn
    public final byte b(int i2) {
        int i3 = this.f36093d;
        if (((i3 - (i2 + 1)) | i2) >= 0) {
            return this.f36094c[i2];
        }
        if (i2 < 0) {
            throw new ArrayIndexOutOfBoundsException(b.f(i2, "Index < 0: "));
        }
        throw new ArrayIndexOutOfBoundsException(b.d(i2, i3, "Index > length: ", ", "));
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzck, com.google.android.gms.internal.atv_ads_framework.zzcn
    public final byte d(int i2) {
        return this.f36094c[i2];
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzck, com.google.android.gms.internal.atv_ads_framework.zzcn
    public final int f() {
        return this.f36093d;
    }
}
