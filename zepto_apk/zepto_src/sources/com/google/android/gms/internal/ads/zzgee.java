package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzgee {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f32376a = new byte[256];

    public zzgee(byte[] bArr) {
        for (int i2 = 0; i2 < 256; i2++) {
            this.f32376a[i2] = (byte) i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < 256; i4++) {
            byte[] bArr2 = this.f32376a;
            byte b2 = bArr2[i4];
            i3 = (i3 + b2 + bArr[i4 % bArr.length]) & 255;
            bArr2[i4] = bArr2[i3];
            bArr2[i3] = b2;
        }
    }
}
