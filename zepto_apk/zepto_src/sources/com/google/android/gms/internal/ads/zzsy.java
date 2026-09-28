package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class zzsy extends zzcp {

    /* renamed from: i, reason: collision with root package name */
    public int f35558i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f35559j;

    /* renamed from: k, reason: collision with root package name */
    public int f35560k;

    /* renamed from: l, reason: collision with root package name */
    public long f35561l;
    public byte[] n;
    public byte[] q;

    /* renamed from: m, reason: collision with root package name */
    public int f35562m = 0;
    public int o = 0;
    public int p = 0;

    public zzsy() {
        byte[] bArr = zzfj.f31255b;
        this.n = bArr;
        this.q = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void b(ByteBuffer byteBuffer) {
        int iLimit;
        int i2;
        int iPosition;
        while (byteBuffer.hasRemaining() && !this.f26859g.hasRemaining()) {
            if (this.f35560k != 0) {
                zzgqa.f(this.o < this.n.length);
                int iLimit2 = byteBuffer.limit();
                int iPosition2 = byteBuffer.position() + 1;
                while (true) {
                    if (iPosition2 >= byteBuffer.limit()) {
                        iLimit = byteBuffer.limit();
                        break;
                    }
                    if (Math.abs((byteBuffer.get(iPosition2) << 8) | (byteBuffer.get(iPosition2 - 1) & 255)) > 1024) {
                        int i3 = this.f35558i;
                        iLimit = (iPosition2 / i3) * i3;
                        break;
                    }
                    iPosition2 += 2;
                }
                int iPosition3 = iLimit - byteBuffer.position();
                int i4 = this.o;
                int i5 = this.p;
                int i6 = i4 + i5;
                int length = this.n.length;
                if (i6 < length) {
                    i2 = length - i6;
                } else {
                    i6 = i5 - (length - i4);
                    i2 = i4 - i6;
                }
                int iMin = Math.min(iPosition3, i2);
                byteBuffer.limit(byteBuffer.position() + iMin);
                byteBuffer.get(this.n, i6, iMin);
                int i7 = this.p + iMin;
                this.p = i7;
                zzgqa.f(i7 <= this.n.length);
                boolean z = iLimit < iLimit2 && iPosition3 < i2;
                i(z);
                if (z) {
                    this.f35560k = 0;
                    this.f35562m = 0;
                }
                byteBuffer.limit(iLimit2);
            } else {
                int iLimit3 = byteBuffer.limit();
                byteBuffer.limit(Math.min(iLimit3, byteBuffer.position() + this.n.length));
                int iLimit4 = byteBuffer.limit() - 1;
                while (true) {
                    if (iLimit4 < byteBuffer.position()) {
                        iPosition = byteBuffer.position();
                        break;
                    }
                    if (Math.abs((byteBuffer.get(iLimit4) << 8) | (byteBuffer.get(iLimit4 - 1) & 255)) > 1024) {
                        int i8 = this.f35558i;
                        iPosition = ((iLimit4 / i8) * i8) + i8;
                        break;
                    }
                    iLimit4 -= 2;
                }
                if (iPosition == byteBuffer.position()) {
                    this.f35560k = 1;
                } else {
                    byteBuffer.limit(Math.min(iPosition, byteBuffer.capacity()));
                    d(byteBuffer.remaining()).put(byteBuffer).flip();
                }
                byteBuffer.limit(iLimit3);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final zzcl e(zzcl zzclVar) throws zzcn {
        if (zzclVar.f26487c == 2) {
            return zzclVar.f26485a == -1 ? zzcl.f26484e : zzclVar;
        }
        throw new zzcn("Unhandled input format:", zzclVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final void f() {
        if (this.p > 0) {
            i(true);
            this.f35562m = 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final void g() {
        if (zzc()) {
            int i2 = this.f26854b.f26486b;
            int i3 = i2 + i2;
            this.f35558i = i3;
            int i4 = ((((int) ((100000 * r0.f26485a) / 1000000)) / 2) / i3) * i3;
            int i5 = i4 + i4;
            if (this.n.length != i5) {
                this.n = new byte[i5];
                this.q = new byte[i5];
            }
        }
        this.f35560k = 0;
        this.f35561l = 0L;
        this.f35562m = 0;
        this.o = 0;
        this.p = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final void h() {
        this.f35559j = false;
        byte[] bArr = zzfj.f31255b;
        this.n = bArr;
        this.q = bArr;
    }

    public final void i(boolean z) {
        int i2;
        int length;
        int i3 = this.p;
        int length2 = this.n.length;
        if (i3 != length2) {
            if (!z) {
                return;
            } else {
                z = true;
            }
        }
        if (this.f35562m == 0) {
            if (z) {
                k(i3, 3);
                length = i3;
            } else {
                zzgqa.f(i3 >= (length2 >> 1));
                length = this.n.length >> 1;
                k(length, 0);
            }
            i2 = length;
        } else {
            int i4 = length2 >> 1;
            int i5 = i3 - i4;
            if (z) {
                int iJ = j(i5) + (this.n.length >> 1);
                k(iJ, 2);
                int i6 = i4 + i5;
                i2 = iJ;
                length = i6;
            } else {
                int iJ2 = j(i5);
                k(iJ2, 1);
                i2 = iJ2;
                length = i5;
            }
        }
        if (length % this.f35558i != 0) {
            throw new IllegalStateException(zzgqr.b("bytesConsumed is not aligned to frame size: %s", Integer.valueOf(length)));
        }
        zzgqa.f(i3 >= i2);
        this.p -= length;
        int i7 = this.o + length;
        this.o = i7;
        this.o = i7 % this.n.length;
        this.f35562m = (i2 / this.f35558i) + this.f35562m;
        this.f35561l += (length - i2) / r2;
    }

    public final int j(int i2) {
        int length = ((((int) ((2000000 * this.f26854b.f26485a) / 1000000)) - this.f35562m) * this.f35558i) - (this.n.length >> 1);
        zzgqa.f(length >= 0);
        int iMin = (int) Math.min((i2 * 0.2f) + 0.5f, length);
        int i3 = this.f35558i;
        return (iMin / i3) * i3;
    }

    public final void k(int i2, int i3) {
        int i4;
        if (i2 == 0) {
            return;
        }
        zzgqa.a(this.p >= i2);
        if (i3 == 2) {
            int i5 = this.o;
            int i6 = this.p;
            int i7 = i5 + i6;
            byte[] bArr = this.n;
            int length = bArr.length;
            if (i7 <= length) {
                System.arraycopy(bArr, i7 - i2, this.q, 0, i2);
            } else {
                int i8 = i6 - (length - i5);
                if (i8 >= i2) {
                    System.arraycopy(bArr, i8 - i2, this.q, 0, i2);
                } else {
                    int i9 = i2 - i8;
                    System.arraycopy(bArr, length - i9, this.q, 0, i9);
                    System.arraycopy(this.n, 0, this.q, i9, i8);
                }
            }
        } else {
            int i10 = this.o;
            int i11 = i10 + i2;
            byte[] bArr2 = this.n;
            int length2 = bArr2.length;
            if (i11 <= length2) {
                System.arraycopy(bArr2, i10, this.q, 0, i2);
            } else {
                int i12 = length2 - i10;
                System.arraycopy(bArr2, i10, this.q, 0, i12);
                System.arraycopy(this.n, 0, this.q, i12, i2 - i12);
            }
        }
        zzgqa.c("sizeToOutput is not aligned to frame size: %s", i2, i2 % this.f35558i == 0);
        zzgqa.f(this.o < this.n.length);
        byte[] bArr3 = this.q;
        zzgqa.c("byteOutput size is not aligned to frame size %s", i2, i2 % this.f35558i == 0);
        if (i3 != 3) {
            for (int i13 = 0; i13 < i2; i13 += 2) {
                int i14 = i13 + 1;
                int i15 = (bArr3[i14] << 8) | (bArr3[i13] & 255);
                if (i3 == 0) {
                    i4 = ((((i13 * 1000) / (i2 - 1)) * (-90)) / 1000) + 100;
                } else {
                    i4 = 10;
                    if (i3 == 2) {
                        i4 = 10 + (((90000 * i13) / (i2 - 1)) / 1000);
                    }
                }
                int i16 = (i15 * i4) / 100;
                if (i16 >= 32767) {
                    bArr3[i13] = -1;
                    bArr3[i14] = 127;
                } else if (i16 <= -32768) {
                    bArr3[i13] = 0;
                    bArr3[i14] = -128;
                } else {
                    bArr3[i13] = (byte) (i16 & 255);
                    bArr3[i14] = (byte) (i16 >> 8);
                }
            }
        }
        d(i2).put(bArr3, 0, i2).flip();
    }

    @Override // com.google.android.gms.internal.ads.zzcp, com.google.android.gms.internal.ads.zzco
    public final boolean zzc() {
        return super.zzc() && this.f35559j;
    }
}
