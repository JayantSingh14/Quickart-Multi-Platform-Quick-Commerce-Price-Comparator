package com.google.android.gms.internal.pal;

import java.util.logging.Level;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
final class zzace extends zzach {

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f37377d;

    /* renamed from: e, reason: collision with root package name */
    public final int f37378e;

    /* renamed from: f, reason: collision with root package name */
    public int f37379f;

    public zzace(byte[] bArr, int i2) {
        int length = bArr.length;
        if (((length - i2) | i2) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i2)));
        }
        this.f37377d = bArr;
        this.f37379f = 0;
        this.f37378e = i2;
    }

    @Override // com.google.android.gms.internal.pal.zzach
    public final void c(byte b2) throws zzacf {
        try {
            byte[] bArr = this.f37377d;
            int i2 = this.f37379f;
            this.f37379f = i2 + 1;
            bArr[i2] = b2;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzacf(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f37379f), Integer.valueOf(this.f37378e), 1), e2);
        }
    }

    @Override // com.google.android.gms.internal.pal.zzach
    public final void d(int i2, boolean z) throws zzacf {
        o(i2 << 3);
        c(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.pal.zzach
    public final void e(int i2, zzaby zzabyVar) throws zzacf {
        o((i2 << 3) | 2);
        o(zzabyVar.f());
        zzabyVar.n(this);
    }

    @Override // com.google.android.gms.internal.pal.zzach
    public final void f(int i2, int i3) throws zzacf {
        o((i2 << 3) | 5);
        g(i3);
    }

    @Override // com.google.android.gms.internal.pal.zzach
    public final void g(int i2) throws zzacf {
        try {
            byte[] bArr = this.f37377d;
            int i3 = this.f37379f;
            int i4 = i3 + 1;
            this.f37379f = i4;
            bArr[i3] = (byte) (i2 & 255);
            int i5 = i3 + 2;
            this.f37379f = i5;
            bArr[i4] = (byte) ((i2 >> 8) & 255);
            int i6 = i3 + 3;
            this.f37379f = i6;
            bArr[i5] = (byte) ((i2 >> 16) & 255);
            this.f37379f = i3 + 4;
            bArr[i6] = (byte) ((i2 >> 24) & 255);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzacf(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f37379f), Integer.valueOf(this.f37378e), 1), e2);
        }
    }

    @Override // com.google.android.gms.internal.pal.zzach
    public final void h(int i2, long j2) throws zzacf {
        o((i2 << 3) | 1);
        i(j2);
    }

    @Override // com.google.android.gms.internal.pal.zzach
    public final void i(long j2) throws zzacf {
        try {
            byte[] bArr = this.f37377d;
            int i2 = this.f37379f;
            int i3 = i2 + 1;
            this.f37379f = i3;
            bArr[i2] = (byte) (((int) j2) & 255);
            int i4 = i2 + 2;
            this.f37379f = i4;
            bArr[i3] = (byte) (((int) (j2 >> 8)) & 255);
            int i5 = i2 + 3;
            this.f37379f = i5;
            bArr[i4] = (byte) (((int) (j2 >> 16)) & 255);
            int i6 = i2 + 4;
            this.f37379f = i6;
            bArr[i5] = (byte) (((int) (j2 >> 24)) & 255);
            int i7 = i2 + 5;
            this.f37379f = i7;
            bArr[i6] = (byte) (((int) (j2 >> 32)) & 255);
            int i8 = i2 + 6;
            this.f37379f = i8;
            bArr[i7] = (byte) (((int) (j2 >> 40)) & 255);
            int i9 = i2 + 7;
            this.f37379f = i9;
            bArr[i8] = (byte) (((int) (j2 >> 48)) & 255);
            this.f37379f = i2 + 8;
            bArr[i9] = (byte) (((int) (j2 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzacf(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f37379f), Integer.valueOf(this.f37378e), 1), e2);
        }
    }

    @Override // com.google.android.gms.internal.pal.zzach
    public final void j(int i2, int i3) throws zzacf {
        o(i2 << 3);
        k(i3);
    }

    @Override // com.google.android.gms.internal.pal.zzach
    public final void k(int i2) throws zzacf {
        if (i2 >= 0) {
            o(i2);
        } else {
            q(i2);
        }
    }

    @Override // com.google.android.gms.internal.pal.zzach
    public final void l(int i2, String str) throws zzacf {
        o((i2 << 3) | 2);
        int i3 = this.f37379f;
        try {
            int iA = zzach.a(str.length() * 3);
            int iA2 = zzach.a(str.length());
            int i4 = this.f37378e;
            byte[] bArr = this.f37377d;
            if (iA2 != iA) {
                o(zzafx.c(str));
                int i5 = this.f37379f;
                this.f37379f = zzafx.b(str, bArr, i5, i4 - i5);
            } else {
                int i6 = i3 + iA2;
                this.f37379f = i6;
                int iB = zzafx.b(str, bArr, i6, i4 - i6);
                this.f37379f = i3;
                o((iB - i3) - iA2);
                this.f37379f = iB;
            }
        } catch (zzafw e2) {
            this.f37379f = i3;
            zzach.f37380b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e2);
            byte[] bytes = str.getBytes(zzadg.f37410a);
            try {
                int length = bytes.length;
                o(length);
                v(length, bytes);
            } catch (IndexOutOfBoundsException e3) {
                throw new zzacf(e3);
            }
        } catch (IndexOutOfBoundsException e4) {
            throw new zzacf(e4);
        }
    }

    @Override // com.google.android.gms.internal.pal.zzach
    public final void m(int i2, int i3) throws zzacf {
        o((i2 << 3) | i3);
    }

    @Override // com.google.android.gms.internal.pal.zzach
    public final void n(int i2, int i3) throws zzacf {
        o(i2 << 3);
        o(i3);
    }

    @Override // com.google.android.gms.internal.pal.zzach
    public final void o(int i2) throws zzacf {
        while (true) {
            int i3 = i2 & (-128);
            byte[] bArr = this.f37377d;
            if (i3 == 0) {
                int i4 = this.f37379f;
                this.f37379f = i4 + 1;
                bArr[i4] = (byte) i2;
                return;
            } else {
                try {
                    int i5 = this.f37379f;
                    this.f37379f = i5 + 1;
                    bArr[i5] = (byte) ((i2 & WKSRecord.Service.LOCUS_CON) | 128);
                    i2 >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zzacf(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f37379f), Integer.valueOf(this.f37378e), 1), e2);
                }
            }
            throw new zzacf(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f37379f), Integer.valueOf(this.f37378e), 1), e2);
        }
    }

    @Override // com.google.android.gms.internal.pal.zzach
    public final void p(int i2, long j2) throws zzacf {
        o(i2 << 3);
        q(j2);
    }

    @Override // com.google.android.gms.internal.pal.zzach
    public final void q(long j2) throws zzacf {
        boolean z = zzach.f37381c;
        int i2 = this.f37378e;
        byte[] bArr = this.f37377d;
        if (!z || i2 - this.f37379f < 10) {
            while ((j2 & (-128)) != 0) {
                try {
                    int i3 = this.f37379f;
                    this.f37379f = i3 + 1;
                    bArr[i3] = (byte) ((((int) j2) & WKSRecord.Service.LOCUS_CON) | 128);
                    j2 >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zzacf(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f37379f), Integer.valueOf(i2), 1), e2);
                }
            }
            int i4 = this.f37379f;
            this.f37379f = i4 + 1;
            bArr[i4] = (byte) j2;
            return;
        }
        while ((j2 & (-128)) != 0) {
            int i5 = this.f37379f;
            this.f37379f = i5 + 1;
            long j3 = i5;
            zzafs.f37500c.d(bArr, zzafs.f37503f + j3, (byte) ((((int) j2) & WKSRecord.Service.LOCUS_CON) | 128));
            j2 >>>= 7;
        }
        int i6 = this.f37379f;
        this.f37379f = i6 + 1;
        zzafs.f37500c.d(bArr, zzafs.f37503f + i6, (byte) j2);
    }

    public final void v(int i2, byte[] bArr) {
        try {
            System.arraycopy(bArr, 0, this.f37377d, this.f37379f, i2);
            this.f37379f += i2;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzacf(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f37379f), Integer.valueOf(this.f37378e), Integer.valueOf(i2)), e2);
        }
    }
}
