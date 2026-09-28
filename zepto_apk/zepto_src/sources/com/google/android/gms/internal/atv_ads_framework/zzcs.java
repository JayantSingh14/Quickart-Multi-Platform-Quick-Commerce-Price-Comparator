package com.google.android.gms.internal.atv_ads_framework;

import java.util.logging.Level;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
final class zzcs extends zzcv {

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f36098d;

    /* renamed from: e, reason: collision with root package name */
    public final int f36099e;

    /* renamed from: f, reason: collision with root package name */
    public int f36100f;

    public zzcs(byte[] bArr, int i2) {
        int length = bArr.length;
        if (((length - i2) | i2) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i2)));
        }
        this.f36098d = bArr;
        this.f36100f = 0;
        this.f36099e = i2;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcv
    public final void a(byte b2) throws zzct {
        try {
            byte[] bArr = this.f36098d;
            int i2 = this.f36100f;
            this.f36100f = i2 + 1;
            bArr[i2] = b2;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzct(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f36100f), Integer.valueOf(this.f36099e), 1), e2);
        }
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcv
    public final void b(int i2, boolean z) throws zzct {
        m(i2 << 3);
        a(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcv
    public final void c(int i2, zzcn zzcnVar) throws zzct {
        m((i2 << 3) | 2);
        m(zzcnVar.f());
        zzcnVar.k(this);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcv
    public final void d(int i2, int i3) throws zzct {
        m((i2 << 3) | 5);
        e(i3);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcv
    public final void e(int i2) throws zzct {
        try {
            byte[] bArr = this.f36098d;
            int i3 = this.f36100f;
            int i4 = i3 + 1;
            this.f36100f = i4;
            bArr[i3] = (byte) (i2 & 255);
            int i5 = i3 + 2;
            this.f36100f = i5;
            bArr[i4] = (byte) ((i2 >> 8) & 255);
            int i6 = i3 + 3;
            this.f36100f = i6;
            bArr[i5] = (byte) ((i2 >> 16) & 255);
            this.f36100f = i3 + 4;
            bArr[i6] = (byte) ((i2 >> 24) & 255);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzct(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f36100f), Integer.valueOf(this.f36099e), 1), e2);
        }
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcv
    public final void f(int i2, long j2) throws zzct {
        m((i2 << 3) | 1);
        g(j2);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcv
    public final void g(long j2) throws zzct {
        try {
            byte[] bArr = this.f36098d;
            int i2 = this.f36100f;
            int i3 = i2 + 1;
            this.f36100f = i3;
            bArr[i2] = (byte) (((int) j2) & 255);
            int i4 = i2 + 2;
            this.f36100f = i4;
            bArr[i3] = (byte) (((int) (j2 >> 8)) & 255);
            int i5 = i2 + 3;
            this.f36100f = i5;
            bArr[i4] = (byte) (((int) (j2 >> 16)) & 255);
            int i6 = i2 + 4;
            this.f36100f = i6;
            bArr[i5] = (byte) (((int) (j2 >> 24)) & 255);
            int i7 = i2 + 5;
            this.f36100f = i7;
            bArr[i6] = (byte) (((int) (j2 >> 32)) & 255);
            int i8 = i2 + 6;
            this.f36100f = i8;
            bArr[i7] = (byte) (((int) (j2 >> 40)) & 255);
            int i9 = i2 + 7;
            this.f36100f = i9;
            bArr[i8] = (byte) (((int) (j2 >> 48)) & 255);
            this.f36100f = i2 + 8;
            bArr[i9] = (byte) (((int) (j2 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzct(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f36100f), Integer.valueOf(this.f36099e), 1), e2);
        }
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcv
    public final void h(int i2, int i3) throws zzct {
        m(i2 << 3);
        i(i3);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcv
    public final void i(int i2) throws zzct {
        if (i2 >= 0) {
            m(i2);
        } else {
            o(i2);
        }
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcv
    public final void j(int i2, String str) throws zzct {
        m((i2 << 3) | 2);
        int i3 = this.f36100f;
        try {
            int iS = zzcv.s(str.length() * 3);
            int iS2 = zzcv.s(str.length());
            int i4 = this.f36099e;
            byte[] bArr = this.f36098d;
            if (iS2 != iS) {
                m(zzgd.c(str));
                int i5 = this.f36100f;
                this.f36100f = zzgd.b(str, bArr, i5, i4 - i5);
            } else {
                int i6 = i3 + iS2;
                this.f36100f = i6;
                int iB = zzgd.b(str, bArr, i6, i4 - i6);
                this.f36100f = i3;
                m((iB - i3) - iS2);
                this.f36100f = iB;
            }
        } catch (zzgc e2) {
            this.f36100f = i3;
            zzcv.f36101b.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e2);
            byte[] bytes = str.getBytes(zzdp.f36125a);
            try {
                int length = bytes.length;
                m(length);
                u(length, bytes);
            } catch (IndexOutOfBoundsException e3) {
                throw new zzct(e3);
            }
        } catch (IndexOutOfBoundsException e4) {
            throw new zzct(e4);
        }
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcv
    public final void k(int i2, int i3) throws zzct {
        m((i2 << 3) | i3);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcv
    public final void l(int i2, int i3) throws zzct {
        m(i2 << 3);
        m(i3);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcv
    public final void m(int i2) throws zzct {
        while (true) {
            int i3 = i2 & (-128);
            byte[] bArr = this.f36098d;
            if (i3 == 0) {
                int i4 = this.f36100f;
                this.f36100f = i4 + 1;
                bArr[i4] = (byte) i2;
                return;
            } else {
                try {
                    int i5 = this.f36100f;
                    this.f36100f = i5 + 1;
                    bArr[i5] = (byte) ((i2 & WKSRecord.Service.LOCUS_CON) | 128);
                    i2 >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zzct(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f36100f), Integer.valueOf(this.f36099e), 1), e2);
                }
            }
            throw new zzct(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f36100f), Integer.valueOf(this.f36099e), 1), e2);
        }
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcv
    public final void n(int i2, long j2) throws zzct {
        m(i2 << 3);
        o(j2);
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzcv
    public final void o(long j2) throws zzct {
        boolean z = zzcv.f36102c;
        int i2 = this.f36099e;
        byte[] bArr = this.f36098d;
        if (!z || i2 - this.f36100f < 10) {
            while ((j2 & (-128)) != 0) {
                try {
                    int i3 = this.f36100f;
                    this.f36100f = i3 + 1;
                    bArr[i3] = (byte) ((((int) j2) & WKSRecord.Service.LOCUS_CON) | 128);
                    j2 >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zzct(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f36100f), Integer.valueOf(i2), 1), e2);
                }
            }
            int i4 = this.f36100f;
            this.f36100f = i4 + 1;
            bArr[i4] = (byte) j2;
            return;
        }
        while ((j2 & (-128)) != 0) {
            int i5 = this.f36100f;
            this.f36100f = i5 + 1;
            long j3 = i5;
            zzfz.f36212c.d(bArr, zzfz.f36215f + j3, (byte) ((((int) j2) & WKSRecord.Service.LOCUS_CON) | 128));
            j2 >>>= 7;
        }
        int i6 = this.f36100f;
        this.f36100f = i6 + 1;
        zzfz.f36212c.d(bArr, zzfz.f36215f + i6, (byte) j2);
    }

    public final void u(int i2, byte[] bArr) {
        try {
            System.arraycopy(bArr, 0, this.f36098d, this.f36100f, i2);
            this.f36100f += i2;
        } catch (IndexOutOfBoundsException e2) {
            throw new zzct(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f36100f), Integer.valueOf(this.f36099e), Integer.valueOf(i2)), e2);
        }
    }
}
