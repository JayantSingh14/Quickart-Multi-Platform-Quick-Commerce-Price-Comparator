package com.google.android.gms.internal.measurement;

import android.support.v4.media.b;
import java.util.Locale;
import java.util.logging.Level;

/* loaded from: classes.dex */
final class zzlj extends zzll {

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f37076d;

    /* renamed from: e, reason: collision with root package name */
    public final int f37077e;

    /* renamed from: f, reason: collision with root package name */
    public int f37078f;

    public zzlj(byte[] bArr, int i2) {
        int length = bArr.length;
        if (((length - i2) | i2) < 0) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException(b.d(length, i2, "Array range is invalid. Buffer.length=", ", offset=0, length="));
        }
        this.f37076d = bArr;
        this.f37078f = 0;
        this.f37077e = i2;
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void d(int i2, int i3) {
        q((i2 << 3) | i3);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void e(int i2, int i3) throws zzlk {
        q(i2 << 3);
        p(i3);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void f(int i2, int i3) {
        q(i2 << 3);
        q(i3);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void g(int i2, int i3) throws zzlk {
        q((i2 << 3) | 5);
        r(i3);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void h(int i2, long j2) throws zzlk {
        q(i2 << 3);
        s(j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void i(int i2, long j2) throws zzlk {
        q((i2 << 3) | 1);
        t(j2);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void j(int i2, boolean z) throws zzlk {
        q(i2 << 3);
        o(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void k(int i2, String str) throws zzlk {
        q((i2 << 3) | 2);
        u(str);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void l(int i2, zzlg zzlgVar) {
        q((i2 << 3) | 2);
        m(zzlgVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void m(zzlg zzlgVar) {
        q(zzlgVar.f());
        zzlgVar.i(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void n(zznl zznlVar) {
        q(zznlVar.a());
        zznlVar.d(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void o(byte b2) throws zzlk {
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i2 = this.f37078f;
        try {
            int i3 = i2 + 1;
            try {
                this.f37076d[i2] = b2;
                this.f37078f = i3;
            } catch (IndexOutOfBoundsException e2) {
                indexOutOfBoundsException = e2;
                i2 = i3;
                throw new zzlk(i2, this.f37077e, 1, indexOutOfBoundsException);
            }
        } catch (IndexOutOfBoundsException e3) {
            indexOutOfBoundsException = e3;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void p(int i2) throws zzlk {
        if (i2 >= 0) {
            q(i2);
        } else {
            s(i2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void q(int i2) {
        int i3;
        int i4 = this.f37078f;
        while (true) {
            int i5 = i2 & (-128);
            byte[] bArr = this.f37076d;
            if (i5 == 0) {
                i3 = i4 + 1;
                bArr[i4] = (byte) i2;
                this.f37078f = i3;
                return;
            } else {
                i3 = i4 + 1;
                try {
                    bArr[i4] = (byte) (i2 | 128);
                    i2 >>>= 7;
                    i4 = i3;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zzlk(i3, this.f37077e, 1, e2);
                }
            }
            throw new zzlk(i3, this.f37077e, 1, e2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void r(int i2) throws zzlk {
        int i3 = this.f37078f;
        try {
            byte[] bArr = this.f37076d;
            bArr[i3] = (byte) i2;
            bArr[i3 + 1] = (byte) (i2 >> 8);
            bArr[i3 + 2] = (byte) (i2 >> 16);
            bArr[i3 + 3] = (byte) (i2 >> 24);
            this.f37078f = i3 + 4;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzlk(i3, this.f37077e, 4, e2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void s(long j2) throws zzlk {
        int i2;
        int i3 = this.f37078f;
        boolean z = zzll.f37080c;
        int i4 = this.f37077e;
        byte[] bArr = this.f37076d;
        if (!z || i4 - i3 < 10) {
            long j3 = j2;
            while ((j3 & (-128)) != 0) {
                i2 = i3 + 1;
                try {
                    bArr[i3] = (byte) (((int) j3) | 128);
                    j3 >>>= 7;
                    i3 = i2;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zzlk(i2, i4, 1, e2);
                }
            }
            i2 = i3 + 1;
            bArr[i3] = (byte) j3;
        } else {
            long j4 = j2;
            while ((j4 & (-128)) != 0) {
                zzoo.f37196c.a(bArr, zzoo.f37199f + i3, (byte) (((int) j4) | 128));
                j4 >>>= 7;
                i3++;
            }
            i2 = i3 + 1;
            zzoo.f37196c.a(bArr, zzoo.f37199f + i3, (byte) j4);
        }
        this.f37078f = i2;
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void t(long j2) throws zzlk {
        int i2 = this.f37078f;
        try {
            byte[] bArr = this.f37076d;
            bArr[i2] = (byte) j2;
            bArr[i2 + 1] = (byte) (j2 >> 8);
            bArr[i2 + 2] = (byte) (j2 >> 16);
            bArr[i2 + 3] = (byte) (j2 >> 24);
            bArr[i2 + 4] = (byte) (j2 >> 32);
            bArr[i2 + 5] = (byte) (j2 >> 40);
            bArr[i2 + 6] = (byte) (j2 >> 48);
            bArr[i2 + 7] = (byte) (j2 >> 56);
            this.f37078f = i2 + 8;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzlk(i2, this.f37077e, 8, e2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final void u(String str) throws zzlk {
        int i2 = this.f37078f;
        try {
            int iW = zzll.w(str.length() * 3);
            int iW2 = zzll.w(str.length());
            int i3 = this.f37077e;
            byte[] bArr = this.f37076d;
            if (iW2 != iW) {
                q(zzor.b(str));
                int i4 = this.f37078f;
                this.f37078f = zzor.c(str, bArr, i4, i3 - i4);
            } else {
                int i5 = i2 + iW2;
                this.f37078f = i5;
                int iC = zzor.c(str, bArr, i5, i3 - i5);
                this.f37078f = i2;
                q((iC - i2) - iW2);
                this.f37078f = iC;
            }
        } catch (zzoq e2) {
            this.f37078f = i2;
            zzll.f37079b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e2);
            byte[] bytes = str.getBytes(zzmo.f37112a);
            try {
                int length = bytes.length;
                q(length);
                x(length, bytes);
            } catch (IndexOutOfBoundsException e3) {
                throw new zzlk(e3);
            }
        } catch (IndexOutOfBoundsException e4) {
            throw new zzlk(e4);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    public final int v() {
        return this.f37077e - this.f37078f;
    }

    public final void x(int i2, byte[] bArr) {
        try {
            System.arraycopy(bArr, 0, this.f37076d, this.f37078f, i2);
            this.f37078f += i2;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzlk(this.f37078f, this.f37077e, i2, e2);
        }
    }
}
