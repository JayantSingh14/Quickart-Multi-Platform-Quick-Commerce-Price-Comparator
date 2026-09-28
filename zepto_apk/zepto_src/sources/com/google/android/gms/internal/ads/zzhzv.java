package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes4.dex */
final class zzhzv extends zzhzs {

    /* renamed from: g, reason: collision with root package name */
    public final OutputStream f34602g;

    public zzhzv(OutputStream outputStream, int i2) {
        super(i2);
        this.f34602g = outputStream;
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void A(long j2) {
        G(8);
        F(j2);
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void B(String str) throws IOException {
        try {
            int length = str.length() * 3;
            int iB = zzhzw.b(length);
            int i2 = iB + length;
            int i3 = this.f34597e;
            if (i2 > i3) {
                byte[] bArr = new byte[length];
                int iC = zzidr.c(str, bArr, 0, length);
                x(iC);
                I(0, bArr, iC);
                return;
            }
            if (i2 > i3 - this.f34598f) {
                H();
            }
            int iB2 = zzhzw.b(str.length());
            int i4 = this.f34598f;
            byte[] bArr2 = this.f34596d;
            try {
                try {
                    if (iB2 == iB) {
                        int i5 = i4 + iB2;
                        this.f34598f = i5;
                        int iC2 = zzidr.c(str, bArr2, i5, i3 - i5);
                        this.f34598f = i4;
                        C((iC2 - i4) - iB2);
                        this.f34598f = iC2;
                    } else {
                        int iB3 = zzidr.b(str);
                        C(iB3);
                        this.f34598f = zzidr.c(str, bArr2, this.f34598f, iB3);
                    }
                } catch (zzidq e2) {
                    this.f34598f = i4;
                    throw e2;
                }
            } catch (ArrayIndexOutOfBoundsException e3) {
                throw new zzhzu(e3);
            }
        } catch (zzidq e4) {
            f(str, e4);
        }
    }

    public final void G(int i2) {
        if (this.f34597e - this.f34598f < i2) {
            H();
        }
    }

    public final void H() {
        this.f34602g.write(this.f34596d, 0, this.f34598f);
        this.f34598f = 0;
    }

    public final void I(int i2, byte[] bArr, int i3) throws IOException {
        int i4 = this.f34598f;
        int i5 = this.f34597e;
        int i6 = i5 - i4;
        byte[] bArr2 = this.f34596d;
        if (i6 >= i3) {
            System.arraycopy(bArr, i2, bArr2, i4, i3);
            this.f34598f += i3;
            return;
        }
        System.arraycopy(bArr, i2, bArr2, i4, i6);
        int i7 = i2 + i6;
        this.f34598f = i5;
        H();
        int i8 = i3 - i6;
        if (i8 > i5) {
            this.f34602g.write(bArr, i7, i8);
        } else {
            System.arraycopy(bArr, i7, bArr2, 0, i8);
            this.f34598f = i8;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhzc
    public final void a(int i2, byte[] bArr, int i3) throws IOException {
        I(i2, bArr, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void g(int i2, int i3) {
        x((i2 << 3) | i3);
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void h(int i2, int i3) {
        G(20);
        C(i2 << 3);
        if (i3 >= 0) {
            C(i3);
        } else {
            D(i3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void i(int i2, int i3) {
        G(20);
        C(i2 << 3);
        C(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void j(int i2, int i3) {
        G(14);
        C((i2 << 3) | 5);
        E(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void k(int i2, long j2) {
        G(20);
        C(i2 << 3);
        D(j2);
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void m(int i2, long j2) {
        G(18);
        C((i2 << 3) | 1);
        F(j2);
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void n(int i2, boolean z) {
        G(11);
        C(i2 << 3);
        int i3 = this.f34598f;
        this.f34596d[i3] = z ? (byte) 1 : (byte) 0;
        this.f34598f = i3 + 1;
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void o(int i2, String str) throws IOException {
        x((i2 << 3) | 2);
        B(str);
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void p(int i2, zzhzl zzhzlVar) {
        x((i2 << 3) | 2);
        q(zzhzlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void q(zzhzl zzhzlVar) {
        x(zzhzlVar.i());
        zzhzlVar.q(this);
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void r(int i2, byte[] bArr) throws IOException {
        x(i2);
        I(0, bArr, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void s(int i2, zzicc zziccVar) {
        x(11);
        i(2, i2);
        x(26);
        u(zziccVar);
        x(12);
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void t(int i2, zzhzl zzhzlVar) {
        x(11);
        i(2, i2);
        p(3, zzhzlVar);
        x(12);
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void u(zzicc zziccVar) {
        x(zziccVar.d());
        zziccVar.c(this);
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void v(byte b2) {
        if (this.f34598f == this.f34597e) {
            H();
        }
        int i2 = this.f34598f;
        this.f34596d[i2] = b2;
        this.f34598f = i2 + 1;
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void w(int i2) {
        if (i2 >= 0) {
            x(i2);
        } else {
            z(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void x(int i2) {
        G(5);
        C(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void y(int i2) {
        G(4);
        E(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhzw
    public final void z(long j2) {
        G(10);
        D(j2);
    }
}
