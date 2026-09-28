package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: classes3.dex */
final class zzabt extends zzabw {
    private final byte[] zzb;
    private final int zzc;
    private int zzd;

    public zzabt(byte[] bArr, int i2, int i3) {
        super(null);
        int length = bArr.length;
        if (((length - i3) | i3) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i3)));
        }
        this.zzb = bArr;
        this.zzd = 0;
        this.zzc = i3;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabw
    public final int zza() {
        return this.zzc - this.zzd;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabw
    public final void zzb(byte b2) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i2 = this.zzd;
            this.zzd = i2 + 1;
            bArr[i2] = b2;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzabu(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e2);
        }
    }

    public final void zzc(byte[] bArr, int i2, int i3) throws IOException {
        try {
            System.arraycopy(bArr, i2, this.zzb, this.zzd, i3);
            this.zzd += i3;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzabu(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), Integer.valueOf(i3)), e2);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabw
    public final void zzd(int i2, boolean z) throws IOException {
        zzq(i2 << 3);
        zzb(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabw
    public final void zze(int i2, zzabn zzabnVar) throws IOException {
        zzq((i2 << 3) | 2);
        zzq(zzabnVar.zzd());
        zzabnVar.zzn(this);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabw
    public final void zzf(int i2, int i3) throws IOException {
        zzq((i2 << 3) | 5);
        zzg(i3);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabw
    public final void zzg(int i2) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i3 = this.zzd;
            int i4 = i3 + 1;
            this.zzd = i4;
            bArr[i3] = (byte) (i2 & 255);
            int i5 = i3 + 2;
            this.zzd = i5;
            bArr[i4] = (byte) ((i2 >> 8) & 255);
            int i6 = i3 + 3;
            this.zzd = i6;
            bArr[i5] = (byte) ((i2 >> 16) & 255);
            this.zzd = i3 + 4;
            bArr[i6] = (byte) ((i2 >> 24) & 255);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzabu(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e2);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabw
    public final void zzh(int i2, long j2) throws IOException {
        zzq((i2 << 3) | 1);
        zzi(j2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabw
    public final void zzi(long j2) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i2 = this.zzd;
            int i3 = i2 + 1;
            this.zzd = i3;
            bArr[i2] = (byte) (((int) j2) & 255);
            int i4 = i2 + 2;
            this.zzd = i4;
            bArr[i3] = (byte) (((int) (j2 >> 8)) & 255);
            int i5 = i2 + 3;
            this.zzd = i5;
            bArr[i4] = (byte) (((int) (j2 >> 16)) & 255);
            int i6 = i2 + 4;
            this.zzd = i6;
            bArr[i5] = (byte) (((int) (j2 >> 24)) & 255);
            int i7 = i2 + 5;
            this.zzd = i7;
            bArr[i6] = (byte) (((int) (j2 >> 32)) & 255);
            int i8 = i2 + 6;
            this.zzd = i8;
            bArr[i7] = (byte) (((int) (j2 >> 40)) & 255);
            int i9 = i2 + 7;
            this.zzd = i9;
            bArr[i8] = (byte) (((int) (j2 >> 48)) & 255);
            this.zzd = i2 + 8;
            bArr[i9] = (byte) (((int) (j2 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzabu(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e2);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabw
    public final void zzj(int i2, int i3) throws IOException {
        zzq(i2 << 3);
        zzk(i3);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabw
    public final void zzk(int i2) throws IOException {
        if (i2 >= 0) {
            zzq(i2);
        } else {
            zzs(i2);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabw
    public final void zzl(byte[] bArr, int i2, int i3) throws IOException {
        zzc(bArr, 0, i3);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabw
    public final void zzm(int i2, String str) throws IOException {
        zzq((i2 << 3) | 2);
        zzn(str);
    }

    public final void zzn(String str) throws IOException {
        int i2 = this.zzd;
        try {
            int iZzw = zzabw.zzw(str.length() * 3);
            int iZzw2 = zzabw.zzw(str.length());
            if (iZzw2 != iZzw) {
                zzq(zzafz.zze(str));
                byte[] bArr = this.zzb;
                int i3 = this.zzd;
                this.zzd = zzafz.zzd(str, bArr, i3, this.zzc - i3);
                return;
            }
            int i4 = i2 + iZzw2;
            this.zzd = i4;
            int iZzd = zzafz.zzd(str, this.zzb, i4, this.zzc - i4);
            this.zzd = i2;
            zzq((iZzd - i2) - iZzw2);
            this.zzd = iZzd;
        } catch (zzafy e2) {
            this.zzd = i2;
            zzA(str, e2);
        } catch (IndexOutOfBoundsException e3) {
            throw new zzabu(e3);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabw
    public final void zzo(int i2, int i3) throws IOException {
        zzq((i2 << 3) | i3);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabw
    public final void zzp(int i2, int i3) throws IOException {
        zzq(i2 << 3);
        zzq(i3);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabw
    public final void zzq(int i2) throws IOException {
        while ((i2 & (-128)) != 0) {
            try {
                byte[] bArr = this.zzb;
                int i3 = this.zzd;
                this.zzd = i3 + 1;
                bArr[i3] = (byte) ((i2 | 128) & 255);
                i2 >>>= 7;
            } catch (IndexOutOfBoundsException e2) {
                throw new zzabu(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e2);
            }
        }
        byte[] bArr2 = this.zzb;
        int i4 = this.zzd;
        this.zzd = i4 + 1;
        bArr2[i4] = (byte) i2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabw
    public final void zzr(int i2, long j2) throws IOException {
        zzq(i2 << 3);
        zzs(j2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabw
    public final void zzs(long j2) throws IOException {
        if (!zzabw.zzc || this.zzc - this.zzd < 10) {
            while ((j2 & (-128)) != 0) {
                try {
                    byte[] bArr = this.zzb;
                    int i2 = this.zzd;
                    this.zzd = i2 + 1;
                    bArr[i2] = (byte) ((((int) j2) | 128) & 255);
                    j2 >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zzabu(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e2);
                }
            }
            byte[] bArr2 = this.zzb;
            int i3 = this.zzd;
            this.zzd = i3 + 1;
            bArr2[i3] = (byte) j2;
            return;
        }
        while (true) {
            int i4 = (int) j2;
            if ((j2 & (-128)) == 0) {
                byte[] bArr3 = this.zzb;
                int i5 = this.zzd;
                this.zzd = i5 + 1;
                zzafu.zzn(bArr3, i5, (byte) i4);
                return;
            }
            byte[] bArr4 = this.zzb;
            int i6 = this.zzd;
            this.zzd = i6 + 1;
            zzafu.zzn(bArr4, i6, (byte) ((i4 | 128) & 255));
            j2 >>>= 7;
        }
    }
}
