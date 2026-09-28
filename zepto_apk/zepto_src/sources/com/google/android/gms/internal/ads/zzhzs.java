package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
abstract class zzhzs extends zzhzw {

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f34596d;

    /* renamed from: e, reason: collision with root package name */
    public final int f34597e;

    /* renamed from: f, reason: collision with root package name */
    public int f34598f;

    public zzhzs(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }
        byte[] bArr = new byte[Math.max(i2, 20)];
        this.f34596d = bArr;
        this.f34597e = bArr.length;
    }

    public final void C(int i2) {
        boolean z = zzhzw.f34604c;
        byte[] bArr = this.f34596d;
        if (z) {
            while ((i2 & (-128)) != 0) {
                int i3 = this.f34598f;
                this.f34598f = i3 + 1;
                zzidm.l(bArr, i3, (byte) (i2 | 128));
                i2 >>>= 7;
            }
            int i4 = this.f34598f;
            this.f34598f = i4 + 1;
            zzidm.l(bArr, i4, (byte) i2);
            return;
        }
        while ((i2 & (-128)) != 0) {
            int i5 = this.f34598f;
            this.f34598f = i5 + 1;
            bArr[i5] = (byte) (i2 | 128);
            i2 >>>= 7;
        }
        int i6 = this.f34598f;
        this.f34598f = i6 + 1;
        bArr[i6] = (byte) i2;
    }

    public final void D(long j2) {
        boolean z = zzhzw.f34604c;
        byte[] bArr = this.f34596d;
        if (z) {
            while (true) {
                int i2 = (int) j2;
                if ((j2 & (-128)) == 0) {
                    int i3 = this.f34598f;
                    this.f34598f = i3 + 1;
                    zzidm.l(bArr, i3, (byte) i2);
                    return;
                } else {
                    int i4 = this.f34598f;
                    this.f34598f = i4 + 1;
                    zzidm.l(bArr, i4, (byte) (i2 | 128));
                    j2 >>>= 7;
                }
            }
        } else {
            while (true) {
                int i5 = (int) j2;
                if ((j2 & (-128)) == 0) {
                    int i6 = this.f34598f;
                    this.f34598f = i6 + 1;
                    bArr[i6] = (byte) i5;
                    return;
                } else {
                    int i7 = this.f34598f;
                    this.f34598f = i7 + 1;
                    bArr[i7] = (byte) (i5 | 128);
                    j2 >>>= 7;
                }
            }
        }
    }

    public final void E(int i2) {
        int i3 = this.f34598f;
        byte[] bArr = this.f34596d;
        bArr[i3] = (byte) i2;
        bArr[i3 + 1] = (byte) (i2 >> 8);
        bArr[i3 + 2] = (byte) (i2 >> 16);
        bArr[i3 + 3] = (byte) (i2 >> 24);
        this.f34598f = i3 + 4;
    }

    public final void F(long j2) {
        int i2 = this.f34598f;
        byte[] bArr = this.f34596d;
        bArr[i2] = (byte) j2;
        bArr[i2 + 1] = (byte) (j2 >> 8);
        bArr[i2 + 2] = (byte) (j2 >> 16);
        bArr[i2 + 3] = (byte) (j2 >> 24);
        bArr[i2 + 4] = (byte) (j2 >> 32);
        bArr[i2 + 5] = (byte) (j2 >> 40);
        bArr[i2 + 6] = (byte) (j2 >> 48);
        bArr[i2 + 7] = (byte) (j2 >> 56);
        this.f34598f = i2 + 8;
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final int l() {
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
    }
}
