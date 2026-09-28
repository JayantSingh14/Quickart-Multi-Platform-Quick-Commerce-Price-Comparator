package com.google.android.gms.internal.ads;

import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.lang3.CharUtils;

/* loaded from: classes4.dex */
public final class zzer {

    /* renamed from: d, reason: collision with root package name */
    public static final char[] f30140d = {CharUtils.CR, '\n'};

    /* renamed from: e, reason: collision with root package name */
    public static final char[] f30141e = {'\n'};

    /* renamed from: f, reason: collision with root package name */
    public static final zzgtn f30142f = zzgtn.t(5, StandardCharsets.US_ASCII, StandardCharsets.UTF_8, StandardCharsets.UTF_16, StandardCharsets.UTF_16BE, StandardCharsets.UTF_16LE);

    /* renamed from: g, reason: collision with root package name */
    public static final AtomicBoolean f30143g = new AtomicBoolean();

    /* renamed from: a, reason: collision with root package name */
    public byte[] f30144a;

    /* renamed from: b, reason: collision with root package name */
    public int f30145b;

    /* renamed from: c, reason: collision with root package name */
    public int f30146c;

    public zzer(byte[] bArr, int i2) {
        this.f30144a = bArr;
        this.f30146c = i2;
    }

    public static int u(Charset charset) {
        zzgqa.e(f30142f.contains(charset), "Unsupported charset: %s", charset);
        return (charset.equals(StandardCharsets.UTF_8) || charset.equals(StandardCharsets.US_ASCII)) ? 1 : 2;
    }

    public static boolean w(byte b2) {
        return (b2 & 192) == 128;
    }

    public static int x(int i2, int i3, int i4, int i5) {
        return zzgwx.c((byte) 0, zzgxb.a(((i2 & 7) << 2) | ((i3 & 48) >> 4)), zzgxb.a(((i4 & 60) >> 2) | ((i3 & 15) << 4)), zzgxb.a((i5 & 63) | ((i4 & 3) << 6)));
    }

    public final void A(int i2) {
        byte[] bArr = this.f30144a;
        if (i2 > bArr.length) {
            this.f30144a = Arrays.copyOf(bArr, i2);
        }
    }

    public final int B() {
        return Math.max(this.f30146c - this.f30145b, 0);
    }

    public final void C(int i2) {
        boolean z = false;
        if (i2 >= 0 && i2 <= this.f30144a.length) {
            z = true;
        }
        zzgqa.a(z);
        this.f30146c = i2;
    }

    public final int D() {
        return this.f30145b;
    }

    public final void E(int i2) {
        boolean z = false;
        if (i2 >= 0 && i2 <= this.f30146c) {
            z = true;
        }
        zzgqa.a(z);
        this.f30145b = i2;
    }

    public final byte[] F() {
        return this.f30144a;
    }

    public final void G(int i2) {
        E(this.f30145b + i2);
    }

    public final void H(int i2, byte[] bArr, int i3) {
        v(i3);
        System.arraycopy(this.f30144a, this.f30145b, bArr, i2, i3);
        this.f30145b += i3;
    }

    public final int I() {
        v(1);
        return this.f30144a[this.f30145b] & 255;
    }

    public final int J() {
        if (B() >= 4) {
            this.f30145b -= 4;
            return b();
        }
        int i2 = this.f30145b;
        int i3 = this.f30146c;
        throw new IndexOutOfBoundsException(androidx.fragment.app.e.n(i2, i3, "position=", ", limit=", new StringBuilder(String.valueOf(i2).length() + 17 + String.valueOf(i3).length())));
    }

    public final int K() {
        v(1);
        byte[] bArr = this.f30144a;
        int i2 = this.f30145b;
        this.f30145b = i2 + 1;
        return bArr[i2] & 255;
    }

    public final int L() {
        v(2);
        byte[] bArr = this.f30144a;
        int i2 = this.f30145b;
        int i3 = i2 + 1;
        this.f30145b = i3;
        int i4 = bArr[i2] & 255;
        this.f30145b = i2 + 2;
        return (bArr[i3] & 255) | (i4 << 8);
    }

    public final int M() {
        v(2);
        byte[] bArr = this.f30144a;
        int i2 = this.f30145b;
        int i3 = i2 + 1;
        this.f30145b = i3;
        int i4 = bArr[i2] & 255;
        this.f30145b = i2 + 2;
        return ((bArr[i3] & 255) << 8) | i4;
    }

    public final short N() {
        v(2);
        byte[] bArr = this.f30144a;
        int i2 = this.f30145b;
        int i3 = i2 + 1;
        this.f30145b = i3;
        int i4 = bArr[i2] & 255;
        this.f30145b = i2 + 2;
        return (short) ((bArr[i3] & 255) | (i4 << 8));
    }

    public final int O() {
        v(3);
        byte[] bArr = this.f30144a;
        int i2 = this.f30145b;
        int i3 = i2 + 1;
        this.f30145b = i3;
        int i4 = bArr[i2] & 255;
        int i5 = i2 + 2;
        this.f30145b = i5;
        int i6 = bArr[i3] & 255;
        this.f30145b = i2 + 3;
        return (bArr[i5] & 255) | (i4 << 16) | (i6 << 8);
    }

    public final long P() {
        v(4);
        byte[] bArr = this.f30144a;
        int i2 = this.f30145b;
        int i3 = i2 + 1;
        this.f30145b = i3;
        long j2 = bArr[i2];
        int i4 = i2 + 2;
        this.f30145b = i4;
        long j3 = bArr[i3];
        this.f30145b = i2 + 3;
        long j4 = bArr[i4];
        this.f30145b = i2 + 4;
        return (bArr[r3] & 255) | ((j2 & 255) << 24) | ((j3 & 255) << 16) | ((j4 & 255) << 8);
    }

    public final long a() {
        v(4);
        byte[] bArr = this.f30144a;
        int i2 = this.f30145b;
        int i3 = i2 + 1;
        this.f30145b = i3;
        long j2 = bArr[i2];
        int i4 = i2 + 2;
        this.f30145b = i4;
        long j3 = bArr[i3];
        this.f30145b = i2 + 3;
        long j4 = bArr[i4];
        this.f30145b = i2 + 4;
        return ((bArr[r3] & 255) << 24) | (255 & j2) | ((j3 & 255) << 8) | ((j4 & 255) << 16);
    }

    public final int b() {
        v(4);
        byte[] bArr = this.f30144a;
        int i2 = this.f30145b;
        int i3 = i2 + 1;
        this.f30145b = i3;
        int i4 = bArr[i2] & 255;
        int i5 = i2 + 2;
        this.f30145b = i5;
        int i6 = bArr[i3] & 255;
        int i7 = i2 + 3;
        this.f30145b = i7;
        int i8 = bArr[i5] & 255;
        this.f30145b = i2 + 4;
        return (bArr[i7] & 255) | (i4 << 24) | (i6 << 16) | (i8 << 8);
    }

    public final int c() {
        v(4);
        byte[] bArr = this.f30144a;
        int i2 = this.f30145b;
        int i3 = i2 + 1;
        this.f30145b = i3;
        int i4 = bArr[i2] & 255;
        int i5 = i2 + 2;
        this.f30145b = i5;
        int i6 = bArr[i3] & 255;
        int i7 = i2 + 3;
        this.f30145b = i7;
        int i8 = bArr[i5] & 255;
        this.f30145b = i2 + 4;
        return ((bArr[i7] & 255) << 24) | (i6 << 8) | i4 | (i8 << 16);
    }

    public final long d() {
        v(8);
        byte[] bArr = this.f30144a;
        int i2 = this.f30145b;
        int i3 = i2 + 1;
        this.f30145b = i3;
        long j2 = bArr[i2];
        int i4 = i2 + 2;
        this.f30145b = i4;
        long j3 = bArr[i3];
        int i5 = i2 + 3;
        this.f30145b = i5;
        long j4 = bArr[i4];
        int i6 = i2 + 4;
        this.f30145b = i6;
        long j5 = bArr[i5];
        int i7 = i2 + 5;
        this.f30145b = i7;
        long j6 = bArr[i6];
        int i8 = i2 + 6;
        this.f30145b = i8;
        long j7 = bArr[i7];
        this.f30145b = i2 + 7;
        long j8 = bArr[i8];
        this.f30145b = i2 + 8;
        return ((j8 & 255) << 8) | ((j2 & 255) << 56) | ((j3 & 255) << 48) | ((j4 & 255) << 40) | ((j5 & 255) << 32) | ((j6 & 255) << 24) | ((j7 & 255) << 16) | (bArr[r4] & 255);
    }

    public final long e() {
        v(8);
        byte[] bArr = this.f30144a;
        int i2 = this.f30145b;
        int i3 = i2 + 1;
        this.f30145b = i3;
        long j2 = bArr[i2];
        int i4 = i2 + 2;
        this.f30145b = i4;
        long j3 = bArr[i3];
        int i5 = i2 + 3;
        this.f30145b = i5;
        long j4 = bArr[i4];
        int i6 = i2 + 4;
        this.f30145b = i6;
        long j5 = bArr[i5];
        int i7 = i2 + 5;
        this.f30145b = i7;
        long j6 = bArr[i6];
        int i8 = i2 + 6;
        this.f30145b = i8;
        long j7 = bArr[i7];
        this.f30145b = i2 + 7;
        long j8 = bArr[i8];
        this.f30145b = i2 + 8;
        return ((j8 & 255) << 48) | (j2 & 255) | ((j3 & 255) << 8) | ((j4 & 255) << 16) | ((j5 & 255) << 24) | ((j6 & 255) << 32) | ((j7 & 255) << 40) | ((bArr[r4] & 255) << 56);
    }

    public final int f() {
        v(4);
        byte[] bArr = this.f30144a;
        int i2 = this.f30145b;
        int i3 = i2 + 1;
        this.f30145b = i3;
        int i4 = bArr[i2] & 255;
        this.f30145b = i2 + 2;
        int i5 = bArr[i3] & 255;
        this.f30145b = i2 + 4;
        return (i4 << 8) | i5;
    }

    public final int g() {
        return (K() << 21) | (K() << 14) | (K() << 7) | K();
    }

    public final int h() {
        int iB = b();
        if (iB >= 0) {
            return iB;
        }
        throw new IllegalStateException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(iB).length() + 18), iB, "Top bit not zero: "));
    }

    public final int i() {
        int iC = c();
        if (iC >= 0) {
            return iC;
        }
        throw new IllegalStateException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(iC).length() + 18), iC, "Top bit not zero: "));
    }

    public final long j() {
        long jD = d();
        if (jD >= 0) {
            return jD;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(jD).length() + 18);
        sb.append("Top bit not zero: ");
        sb.append(jD);
        throw new IllegalStateException(sb.toString());
    }

    public final String k(int i2, Charset charset) {
        v(i2);
        byte[] bArr = this.f30144a;
        int i3 = this.f30145b;
        String str = new String(bArr, i3, i2, charset);
        this.f30145b = i3 + i2;
        return str;
    }

    public final String l(int i2) {
        v(i2);
        if (i2 == 0) {
            return "";
        }
        int i3 = this.f30145b;
        int i4 = (i3 + i2) - 1;
        int i5 = (i4 >= this.f30146c || this.f30144a[i4] != 0) ? i2 : i2 - 1;
        byte[] bArr = this.f30144a;
        String str = zzfj.f31254a;
        String str2 = new String(bArr, i3, i5, StandardCharsets.UTF_8);
        this.f30145b += i2;
        return str2;
    }

    public final String m() {
        if (B() == 0) {
            return null;
        }
        int i2 = this.f30145b;
        while (i2 < this.f30146c && this.f30144a[i2] != 0) {
            i2++;
        }
        byte[] bArr = this.f30144a;
        int i3 = this.f30145b;
        String str = zzfj.f31254a;
        String str2 = new String(bArr, i3, i2 - i3, StandardCharsets.UTF_8);
        this.f30145b = i2;
        if (i2 < this.f30146c) {
            this.f30145b = i2 + 1;
        }
        return str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String n(java.nio.charset.Charset r8) {
        /*
            r7 = this;
            r0 = 1
            com.google.android.gms.internal.ads.zzgtn r1 = com.google.android.gms.internal.ads.zzer.f30142f
            boolean r1 = r1.contains(r8)
            java.lang.String r2 = "Unsupported charset: %s"
            com.google.android.gms.internal.ads.zzgqa.e(r1, r2, r8)
            int r1 = r7.B()
            if (r1 != 0) goto L14
            r8 = 0
            return r8
        L14:
            java.nio.charset.Charset r1 = java.nio.charset.StandardCharsets.US_ASCII
            boolean r2 = r8.equals(r1)
            if (r2 != 0) goto L1f
            r7.q()
        L1f:
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.UTF_8
            boolean r2 = r8.equals(r2)
            if (r2 != 0) goto L2d
            boolean r1 = r8.equals(r1)
            if (r1 == 0) goto L2f
        L2d:
            r2 = r0
            goto L59
        L2f:
            java.nio.charset.Charset r1 = java.nio.charset.StandardCharsets.UTF_16
            boolean r1 = r8.equals(r1)
            r2 = 2
            if (r1 != 0) goto L59
            java.nio.charset.Charset r1 = java.nio.charset.StandardCharsets.UTF_16LE
            boolean r1 = r8.equals(r1)
            if (r1 != 0) goto L59
            java.nio.charset.Charset r1 = java.nio.charset.StandardCharsets.UTF_16BE
            boolean r1 = r8.equals(r1)
            if (r1 == 0) goto L49
            goto L59
        L49:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r8 = java.lang.String.valueOf(r8)
            java.lang.String r1 = "Unsupported charset: "
            java.lang.String r8 = r1.concat(r8)
            r0.<init>(r8)
            throw r0
        L59:
            int r1 = r7.f30145b
        L5b:
            int r3 = r7.f30146c
            int r4 = r2 + (-1)
            int r4 = r3 - r4
            r5 = 13
            if (r1 >= r4) goto Lbe
            java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8
            boolean r3 = r8.equals(r3)
            r4 = 10
            if (r3 != 0) goto L77
            java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.US_ASCII
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L82
        L77:
            byte[] r3 = r7.f30144a
            r3 = r3[r1]
            java.lang.String r6 = com.google.android.gms.internal.ads.zzfj.f31254a
            if (r3 == r4) goto Lbf
            if (r3 != r5) goto L82
            goto Lbf
        L82:
            java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_16
            boolean r3 = r8.equals(r3)
            if (r3 != 0) goto L92
            java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_16BE
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto La3
        L92:
            byte[] r3 = r7.f30144a
            r6 = r3[r1]
            if (r6 != 0) goto La3
            int r6 = r1 + 1
            r3 = r3[r6]
            java.lang.String r6 = com.google.android.gms.internal.ads.zzfj.f31254a
            if (r3 == r4) goto Lbf
            if (r3 != r5) goto La3
            goto Lbf
        La3:
            java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_16LE
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto Lbc
            int r3 = r1 + 1
            byte[] r6 = r7.f30144a
            r3 = r6[r3]
            if (r3 != 0) goto Lbc
            r3 = r6[r1]
            java.lang.String r6 = com.google.android.gms.internal.ads.zzfj.f31254a
            if (r3 == r4) goto Lbf
            if (r3 != r5) goto Lbc
            goto Lbf
        Lbc:
            int r1 = r1 + r2
            goto L5b
        Lbe:
            r1 = r3
        Lbf:
            int r0 = r7.f30145b
            int r1 = r1 - r0
            java.lang.String r0 = r7.k(r1, r8)
            int r1 = r7.f30145b
            int r2 = r7.f30146c
            if (r1 == r2) goto Ld9
            char[] r1 = com.google.android.gms.internal.ads.zzer.f30140d
            char r1 = r7.s(r8, r1)
            if (r1 != r5) goto Ld9
            char[] r1 = com.google.android.gms.internal.ads.zzer.f30141e
            r7.s(r8, r1)
        Ld9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzer.n(java.nio.charset.Charset):java.lang.String");
    }

    public final long o() {
        int i2;
        v(1);
        long j2 = this.f30144a[this.f30145b];
        int i3 = 7;
        while (true) {
            i2 = 0;
            if (i3 < 0) {
                break;
            }
            if (((1 << i3) & j2) != 0) {
                i3--;
            } else if (i3 < 6) {
                j2 &= r7 - 1;
                i2 = 7 - i3;
            } else if (i3 == 7) {
                i2 = 1;
            }
        }
        if (i2 == 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(j2).length() + 35);
            sb.append("Invalid UTF-8 sequence first byte: ");
            sb.append(j2);
            throw new NumberFormatException(sb.toString());
        }
        v(i2);
        for (int i4 = 1; i4 < i2; i4++) {
            if ((this.f30144a[this.f30145b + i4] & 192) != 128) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(j2).length() + 42);
                sb2.append("Invalid UTF-8 sequence continuation byte: ");
                sb2.append(j2);
                throw new NumberFormatException(sb2.toString());
            }
            j2 = (j2 << 6) | (r3 & 63);
        }
        this.f30145b += i2;
        return j2;
    }

    public final long p() {
        long j2 = 0;
        for (int i2 = 0; i2 < 9; i2++) {
            if (this.f30145b == this.f30146c) {
                throw new IllegalStateException("Attempting to read a byte over the limit.");
            }
            long jK = K();
            j2 |= (127 & jK) << (i2 * 7);
            if ((jK & 128) == 0) {
                return j2;
            }
        }
        return j2;
    }

    public final Charset q() {
        if (B() >= 3) {
            byte[] bArr = this.f30144a;
            int i2 = this.f30145b;
            if (bArr[i2] == -17 && bArr[i2 + 1] == -69 && bArr[i2 + 2] == -65) {
                this.f30145b = i2 + 3;
                return StandardCharsets.UTF_8;
            }
        }
        if (B() < 2) {
            return null;
        }
        byte[] bArr2 = this.f30144a;
        int i3 = this.f30145b;
        byte b2 = bArr2[i3];
        if (b2 == -2) {
            if (bArr2[i3 + 1] != -1) {
                return null;
            }
            this.f30145b = i3 + 2;
            return StandardCharsets.UTF_16BE;
        }
        if (b2 != -1 || bArr2[i3 + 1] != -2) {
            return null;
        }
        this.f30145b = i3 + 2;
        return StandardCharsets.UTF_16LE;
    }

    public final char r(int i2, ByteOrder byteOrder) {
        byte b2;
        byte b3;
        v(2);
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            byte[] bArr = this.f30144a;
            int i3 = this.f30145b + i2;
            b2 = bArr[i3];
            b3 = bArr[i3 + 1];
        } else {
            byte[] bArr2 = this.f30144a;
            int i4 = this.f30145b + i2;
            b2 = bArr2[i4 + 1];
            b3 = bArr2[i4];
        }
        return (char) ((b2 << 8) | (b3 & 255));
    }

    public final char s(Charset charset, char[] cArr) {
        int iT;
        if (B() >= u(charset) && (iT = t(charset)) != 0) {
            if (!Character.isSupplementaryCodePoint(i)) {
                long j2 = i;
                char c2 = (char) j2;
                zzgqa.d(j2, "Out of range: %s", ((long) c2) == j2);
                for (char c3 : cArr) {
                    if (c3 == c2) {
                        this.f30145b = zzgwx.a(iT & 255) + this.f30145b;
                        return c2;
                    }
                }
            }
        }
        return (char) 0;
    }

    public final int t(Charset charset) {
        int codePoint;
        int i2;
        int iX;
        zzgqa.e(f30142f.contains(charset), "Unsupported charset: %s", charset);
        if (B() < u(charset)) {
            int i3 = this.f30145b;
            int i4 = this.f30146c;
            throw new IndexOutOfBoundsException(androidx.fragment.app.e.n(i3, i4, "position=", ", limit=", new StringBuilder(String.valueOf(i3).length() + 17 + String.valueOf(i4).length())));
        }
        int i5 = 1;
        if (charset.equals(StandardCharsets.US_ASCII)) {
            byte b2 = this.f30144a[this.f30145b];
            if ((b2 & 128) == 0) {
                codePoint = b2 & 255;
                return (codePoint << 8) | i5;
            }
            return 0;
        }
        if (charset.equals(StandardCharsets.UTF_8)) {
            byte b3 = this.f30144a[this.f30145b];
            if ((b3 & 128) == 0) {
                i2 = 1;
            } else if ((b3 & 224) == 192 && B() >= 2 && w(this.f30144a[this.f30145b + 1])) {
                i2 = 2;
            } else {
                if ((this.f30144a[this.f30145b] & 240) == 224 && B() >= 3) {
                    byte[] bArr = this.f30144a;
                    int i6 = this.f30145b;
                    if (w(bArr[i6 + 1]) && w(bArr[i6 + 2])) {
                        i2 = 3;
                    }
                }
                if ((this.f30144a[this.f30145b] & 248) == 240 && B() >= 4) {
                    byte[] bArr2 = this.f30144a;
                    int i7 = this.f30145b;
                    if (w(bArr2[i7 + 1]) && w(bArr2[i7 + 2]) && w(bArr2[i7 + 3])) {
                        i2 = 4;
                    }
                }
                i2 = 0;
            }
            if (i2 == 1) {
                iX = this.f30144a[this.f30145b] & 255;
            } else if (i2 == 2) {
                byte[] bArr3 = this.f30144a;
                int i8 = this.f30145b;
                iX = x(0, 0, bArr3[i8], bArr3[i8 + 1]);
            } else {
                if (i2 != 3) {
                    if (i2 == 4) {
                        byte[] bArr4 = this.f30144a;
                        int i9 = this.f30145b;
                        iX = x(bArr4[i9], bArr4[i9 + 1], bArr4[i9 + 2], bArr4[i9 + 3]);
                    }
                    return 0;
                }
                byte[] bArr5 = this.f30144a;
                int i10 = this.f30145b;
                iX = x(0, bArr5[i10] & 15, bArr5[i10 + 1], bArr5[i10 + 2]);
            }
            i5 = i2;
            codePoint = iX;
        } else {
            ByteOrder byteOrder = charset.equals(StandardCharsets.UTF_16LE) ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;
            char cR = r(0, byteOrder);
            if (!Character.isHighSurrogate(cR) || B() < 4) {
                codePoint = cR;
                i5 = 2;
            } else {
                codePoint = Character.toCodePoint(cR, r(2, byteOrder));
                i5 = 4;
            }
        }
        return (codePoint << 8) | i5;
    }

    public final void v(int i2) {
        if (!f30143g.get() || B() >= i2) {
            return;
        }
        int iB = B();
        throw new IndexOutOfBoundsException(androidx.fragment.app.e.n(i2, iB, "bytesNeeded= ", ", bytesLeft=", new StringBuilder(String.valueOf(i2).length() + 25 + String.valueOf(iB).length())));
    }

    public final void y(int i2) {
        byte[] bArr = this.f30144a;
        if (bArr.length < i2) {
            bArr = new byte[i2];
        }
        z(i2, bArr);
    }

    public final void z(int i2, byte[] bArr) {
        this.f30144a = bArr;
        this.f30146c = i2;
        this.f30145b = 0;
    }

    public zzer() {
        this.f30144a = zzfj.f31255b;
    }

    public zzer(int i2) {
        this.f30144a = new byte[i2];
        this.f30146c = i2;
    }

    public zzer(byte[] bArr) {
        this.f30144a = bArr;
        this.f30146c = bArr.length;
    }
}
