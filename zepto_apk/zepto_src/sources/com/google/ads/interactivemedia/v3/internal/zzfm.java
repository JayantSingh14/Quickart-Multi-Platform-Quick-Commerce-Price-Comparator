package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
public final class zzfm {
    private final byte[] zza = new byte[256];
    private int zzb;
    private int zzc;

    public zzfm(byte[] bArr) {
        for (int i2 = 0; i2 < 256; i2++) {
            this.zza[i2] = (byte) i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < 256; i4++) {
            byte[] bArr2 = this.zza;
            byte b2 = bArr2[i4];
            i3 = (i3 + b2 + bArr[i4 % bArr.length]) & 255;
            bArr2[i4] = bArr2[i3];
            bArr2[i3] = b2;
        }
        this.zzb = 0;
        this.zzc = 0;
    }

    public final void zza(byte[] bArr) {
        int i2 = this.zzb;
        int i3 = this.zzc;
        for (int i4 = 0; i4 < 256; i4++) {
            byte[] bArr2 = this.zza;
            i2 = (i2 + 1) & 255;
            byte b2 = bArr2[i2];
            i3 = (i3 + b2) & 255;
            bArr2[i2] = bArr2[i3];
            bArr2[i3] = b2;
            bArr[i4] = (byte) (bArr2[(bArr2[i2] + b2) & 255] ^ bArr[i4]);
        }
        this.zzb = i2;
        this.zzc = i3;
    }
}
