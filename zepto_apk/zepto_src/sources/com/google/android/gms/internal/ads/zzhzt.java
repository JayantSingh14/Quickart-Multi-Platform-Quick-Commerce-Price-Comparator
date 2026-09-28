package com.google.android.gms.internal.ads;

import java.util.Locale;

/* loaded from: classes4.dex */
final class zzhzt extends zzhzw {

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f34599d;

    /* renamed from: e, reason: collision with root package name */
    public final int f34600e;

    /* renamed from: f, reason: collision with root package name */
    public int f34601f;

    public zzhzt(byte[] bArr, int i2) {
        int length = bArr.length;
        if (((length - i2) | i2) < 0) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException(android.support.v4.media.b.d(length, i2, "Array range is invalid. Buffer.length=", ", offset=0, length="));
        }
        this.f34599d = bArr;
        this.f34601f = 0;
        this.f34600e = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void A(long j2) throws zzhzu {
        int i2 = this.f34601f;
        try {
            byte[] bArr = this.f34599d;
            bArr[i2] = (byte) j2;
            bArr[i2 + 1] = (byte) (j2 >> 8);
            bArr[i2 + 2] = (byte) (j2 >> 16);
            bArr[i2 + 3] = (byte) (j2 >> 24);
            bArr[i2 + 4] = (byte) (j2 >> 32);
            bArr[i2 + 5] = (byte) (j2 >> 40);
            bArr[i2 + 6] = (byte) (j2 >> 48);
            bArr[i2 + 7] = (byte) (j2 >> 56);
            this.f34601f = i2 + 8;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzhzu(i2, this.f34600e, 8, e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void B(String str) throws zzhzu {
        int i2 = this.f34601f;
        try {
            int iB = zzhzw.b(str.length() * 3);
            int iB2 = zzhzw.b(str.length());
            int i3 = this.f34600e;
            byte[] bArr = this.f34599d;
            if (iB2 != iB) {
                x(zzidr.b(str));
                int i4 = this.f34601f;
                this.f34601f = zzidr.c(str, bArr, i4, i3 - i4);
            } else {
                int i5 = i2 + iB2;
                this.f34601f = i5;
                int iC = zzidr.c(str, bArr, i5, i3 - i5);
                this.f34601f = i2;
                x((iC - i2) - iB2);
                this.f34601f = iC;
            }
        } catch (zzidq e2) {
            this.f34601f = i2;
            f(str, e2);
        } catch (IndexOutOfBoundsException e3) {
            throw new zzhzu(e3);
        }
    }

    public final void C(int i2, byte[] bArr, int i3) throws zzhzu {
        try {
            System.arraycopy(bArr, i2, this.f34599d, this.f34601f, i3);
            this.f34601f += i3;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzhzu(this.f34601f, this.f34600e, i3, e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhzc
    public final void a(int i2, byte[] bArr, int i3) throws zzhzu {
        C(i2, bArr, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void g(int i2, int i3) throws zzhzu {
        x((i2 << 3) | i3);
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void h(int i2, int i3) throws zzhzu {
        x(i2 << 3);
        w(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void i(int i2, int i3) throws zzhzu {
        x(i2 << 3);
        x(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void j(int i2, int i3) throws zzhzu {
        x((i2 << 3) | 5);
        y(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void k(int i2, long j2) throws zzhzu {
        x(i2 << 3);
        z(j2);
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final int l() {
        return this.f34600e - this.f34601f;
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void m(int i2, long j2) throws zzhzu {
        x((i2 << 3) | 1);
        A(j2);
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void n(int i2, boolean z) throws zzhzu {
        x(i2 << 3);
        v(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void o(int i2, String str) throws zzhzu {
        x((i2 << 3) | 2);
        B(str);
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void p(int i2, zzhzl zzhzlVar) throws zzhzu {
        x((i2 << 3) | 2);
        q(zzhzlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void q(zzhzl zzhzlVar) throws zzhzu {
        x(zzhzlVar.i());
        zzhzlVar.q(this);
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void r(int i2, byte[] bArr) throws zzhzu {
        x(i2);
        C(0, bArr, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void s(int i2, zzicc zziccVar) throws zzhzu {
        x(11);
        i(2, i2);
        x(26);
        u(zziccVar);
        x(12);
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void t(int i2, zzhzl zzhzlVar) throws zzhzu {
        x(11);
        i(2, i2);
        p(3, zzhzlVar);
        x(12);
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void u(zzicc zziccVar) throws zzhzu {
        x(zziccVar.d());
        zziccVar.c(this);
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void v(byte b2) throws zzhzu {
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i2 = this.f34601f;
        try {
            int i3 = i2 + 1;
            try {
                this.f34599d[i2] = b2;
                this.f34601f = i3;
            } catch (IndexOutOfBoundsException e2) {
                indexOutOfBoundsException = e2;
                i2 = i3;
                throw new zzhzu(i2, this.f34600e, 1, indexOutOfBoundsException);
            }
        } catch (IndexOutOfBoundsException e3) {
            indexOutOfBoundsException = e3;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void w(int i2) throws zzhzu {
        if (i2 >= 0) {
            x(i2);
        } else {
            z(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void x(int i2) throws zzhzu {
        int i3;
        int i4 = this.f34601f;
        while (true) {
            int i5 = i2 & (-128);
            byte[] bArr = this.f34599d;
            if (i5 == 0) {
                i3 = i4 + 1;
                bArr[i4] = (byte) i2;
                this.f34601f = i3;
                return;
            } else {
                i3 = i4 + 1;
                try {
                    bArr[i4] = (byte) (i2 | 128);
                    i2 >>>= 7;
                    i4 = i3;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zzhzu(i3, this.f34600e, 1, e2);
                }
            }
            throw new zzhzu(i3, this.f34600e, 1, e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void y(int i2) throws zzhzu {
        int i3 = this.f34601f;
        try {
            byte[] bArr = this.f34599d;
            bArr[i3] = (byte) i2;
            bArr[i3 + 1] = (byte) (i2 >> 8);
            bArr[i3 + 2] = (byte) (i2 >> 16);
            bArr[i3 + 3] = (byte) (i2 >> 24);
            this.f34601f = i3 + 4;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzhzu(i3, this.f34600e, 4, e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void z(long j2) throws zzhzu {
        int i2;
        int i3 = this.f34601f;
        boolean z = zzhzw.f34604c;
        int i4 = this.f34600e;
        byte[] bArr = this.f34599d;
        if (!z || i4 - i3 < 10) {
            long j3 = j2;
            while ((j3 & (-128)) != 0) {
                i2 = i3 + 1;
                try {
                    bArr[i3] = (byte) (((int) j3) | 128);
                    j3 >>>= 7;
                    i3 = i2;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zzhzu(i2, i4, 1, e2);
                }
            }
            i2 = i3 + 1;
            bArr[i3] = (byte) j3;
        } else {
            long j4 = j2;
            while ((j4 & (-128)) != 0) {
                zzidm.l(bArr, i3, (byte) (((int) j4) | 128));
                j4 >>>= 7;
                i3++;
            }
            i2 = i3 + 1;
            zzidm.l(bArr, i3, (byte) j4);
        }
        this.f34601f = i2;
    }
}
