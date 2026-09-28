package androidx.media3.common.util;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.errorprone.annotations.CheckReturnValue;
import java.nio.charset.Charset;
import java.util.Arrays;
import org.apache.commons.lang3.CharUtils;
import org.xbill.DNS.Message;

@CheckReturnValue
@UnstableApi
/* loaded from: classes3.dex */
public final class ParsableByteArray {

    /* renamed from: d, reason: collision with root package name */
    public static final char[] f5720d = {CharUtils.CR, '\n'};

    /* renamed from: e, reason: collision with root package name */
    public static final char[] f5721e = {'\n'};

    /* renamed from: f, reason: collision with root package name */
    public static final ImmutableSet f5722f = ImmutableSet.n(5, Charsets.f42258a, Charsets.f42260c, Charsets.f42263f, Charsets.f42261d, Charsets.f42262e);

    /* renamed from: a, reason: collision with root package name */
    public byte[] f5723a;

    /* renamed from: b, reason: collision with root package name */
    public int f5724b;

    /* renamed from: c, reason: collision with root package name */
    public int f5725c;

    public ParsableByteArray() {
        this.f5723a = Util.f5749f;
    }

    public final int A() {
        byte[] bArr = this.f5723a;
        int i2 = this.f5724b;
        int i3 = i2 + 1;
        this.f5724b = i3;
        int i4 = (bArr[i2] & 255) << 16;
        int i5 = i2 + 2;
        this.f5724b = i5;
        int i6 = ((bArr[i3] & 255) << 8) | i4;
        this.f5724b = i2 + 3;
        return (bArr[i5] & 255) | i6;
    }

    public final int B() {
        int iJ = j();
        if (iJ >= 0) {
            return iJ;
        }
        throw new IllegalStateException(android.support.v4.media.b.f(iJ, "Top bit not zero: "));
    }

    public final long C() {
        long jR = r();
        if (jR >= 0) {
            return jR;
        }
        throw new IllegalStateException(android.support.v4.media.b.i(jR, "Top bit not zero: "));
    }

    public final int D() {
        byte[] bArr = this.f5723a;
        int i2 = this.f5724b;
        int i3 = i2 + 1;
        this.f5724b = i3;
        int i4 = (bArr[i2] & 255) << 8;
        this.f5724b = i2 + 2;
        return (bArr[i3] & 255) | i4;
    }

    public final long E() {
        int i2;
        int i3;
        long j2 = this.f5723a[this.f5724b];
        int i4 = 7;
        while (true) {
            if (i4 < 0) {
                break;
            }
            if (((1 << i4) & j2) != 0) {
                i4--;
            } else if (i4 < 6) {
                j2 &= r6 - 1;
                i3 = 7 - i4;
            } else if (i4 == 7) {
                i3 = 1;
            }
        }
        i3 = 0;
        if (i3 == 0) {
            throw new NumberFormatException(android.support.v4.media.b.i(j2, "Invalid UTF-8 sequence first byte: "));
        }
        for (i2 = 1; i2 < i3; i2++) {
            if ((this.f5723a[this.f5724b + i2] & 192) != 128) {
                throw new NumberFormatException(android.support.v4.media.b.i(j2, "Invalid UTF-8 sequence continuation byte: "));
            }
            j2 = (j2 << 6) | (r3 & 63);
        }
        this.f5724b += i3;
        return j2;
    }

    public final Charset F() {
        if (a() >= 3) {
            byte[] bArr = this.f5723a;
            int i2 = this.f5724b;
            if (bArr[i2] == -17 && bArr[i2 + 1] == -69 && bArr[i2 + 2] == -65) {
                this.f5724b = i2 + 3;
                return Charsets.f42260c;
            }
        }
        if (a() < 2) {
            return null;
        }
        byte[] bArr2 = this.f5723a;
        int i3 = this.f5724b;
        byte b2 = bArr2[i3];
        if (b2 == -2 && bArr2[i3 + 1] == -1) {
            this.f5724b = i3 + 2;
            return Charsets.f42261d;
        }
        if (b2 != -1 || bArr2[i3 + 1] != -2) {
            return null;
        }
        this.f5724b = i3 + 2;
        return Charsets.f42262e;
    }

    public final void G(int i2) {
        byte[] bArr = this.f5723a;
        if (bArr.length < i2) {
            bArr = new byte[i2];
        }
        H(i2, bArr);
    }

    public final void H(int i2, byte[] bArr) {
        this.f5723a = bArr;
        this.f5725c = i2;
        this.f5724b = 0;
    }

    public final void I(int i2) {
        Assertions.a(i2 >= 0 && i2 <= this.f5723a.length);
        this.f5725c = i2;
    }

    public final void J(int i2) {
        Assertions.a(i2 >= 0 && i2 <= this.f5725c);
        this.f5724b = i2;
    }

    public final void K(int i2) {
        J(this.f5724b + i2);
    }

    public final int a() {
        return this.f5725c - this.f5724b;
    }

    public final int b() {
        return this.f5723a.length;
    }

    public final void c(int i2) {
        byte[] bArr = this.f5723a;
        if (i2 > bArr.length) {
            this.f5723a = Arrays.copyOf(bArr, i2);
        }
    }

    public final byte[] d() {
        return this.f5723a;
    }

    public final int e() {
        return this.f5724b;
    }

    public final char f(Charset charset) {
        Assertions.b(f5722f.contains(charset), "Unsupported charset: " + charset);
        return (char) (g(charset) >> 16);
    }

    public final int g(Charset charset) {
        byte b2;
        int i2;
        byte b3;
        byte b4;
        if ((charset.equals(Charsets.f42260c) || charset.equals(Charsets.f42258a)) && a() >= 1) {
            long j2 = this.f5723a[this.f5724b] & 255;
            char c2 = (char) j2;
            Preconditions.c(j2, "Out of range: %s", ((long) c2) == j2);
            b2 = (byte) c2;
            i2 = 1;
        } else {
            i2 = 2;
            if ((charset.equals(Charsets.f42263f) || charset.equals(Charsets.f42261d)) && a() >= 2) {
                byte[] bArr = this.f5723a;
                int i3 = this.f5724b;
                b3 = bArr[i3];
                b4 = bArr[i3 + 1];
            } else {
                if (!charset.equals(Charsets.f42262e) || a() < 2) {
                    return 0;
                }
                byte[] bArr2 = this.f5723a;
                int i4 = this.f5724b;
                b3 = bArr2[i4 + 1];
                b4 = bArr2[i4];
            }
            b2 = (byte) ((char) ((b4 & 255) | (b3 << 8)));
        }
        long j3 = b2;
        char c3 = (char) j3;
        Preconditions.c(j3, "Out of range: %s", ((long) c3) == j3);
        return (c3 << 16) + i2;
    }

    public final void h(int i2, byte[] bArr, int i3) {
        System.arraycopy(this.f5723a, this.f5724b, bArr, i2, i3);
        this.f5724b += i3;
    }

    public final char i(Charset charset, char[] cArr) {
        int iG = g(charset);
        if (iG != 0) {
            char c2 = (char) (iG >> 16);
            for (char c3 : cArr) {
                if (c3 == c2) {
                    this.f5724b += iG & Message.MAXLENGTH;
                    return c2;
                }
            }
        }
        return (char) 0;
    }

    public final int j() {
        byte[] bArr = this.f5723a;
        int i2 = this.f5724b;
        int i3 = i2 + 1;
        this.f5724b = i3;
        int i4 = (bArr[i2] & 255) << 24;
        int i5 = i2 + 2;
        this.f5724b = i5;
        int i6 = ((bArr[i3] & 255) << 16) | i4;
        int i7 = i2 + 3;
        this.f5724b = i7;
        int i8 = i6 | ((bArr[i5] & 255) << 8);
        this.f5724b = i2 + 4;
        return (bArr[i7] & 255) | i8;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String k(java.nio.charset.Charset r5) {
        /*
            r4 = this;
            com.google.common.collect.ImmutableSet r0 = androidx.media3.common.util.ParsableByteArray.f5722f
            boolean r0 = r0.contains(r5)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Unsupported charset: "
            r1.<init>(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            androidx.media3.common.util.Assertions.b(r0, r1)
            int r0 = r4.a()
            if (r0 != 0) goto L1f
            r5 = 0
            return r5
        L1f:
            java.nio.charset.Charset r0 = com.google.common.base.Charsets.f42258a
            boolean r1 = r5.equals(r0)
            if (r1 != 0) goto L2a
            r4.F()
        L2a:
            java.nio.charset.Charset r1 = com.google.common.base.Charsets.f42260c
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L66
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L39
            goto L66
        L39:
            java.nio.charset.Charset r0 = com.google.common.base.Charsets.f42263f
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L64
            java.nio.charset.Charset r0 = com.google.common.base.Charsets.f42262e
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L64
            java.nio.charset.Charset r0 = com.google.common.base.Charsets.f42261d
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L52
            goto L64
        L52:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r2)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r0.<init>(r5)
            throw r0
        L64:
            r0 = 2
            goto L67
        L66:
            r0 = 1
        L67:
            int r1 = r4.f5724b
        L69:
            int r2 = r4.f5725c
            int r3 = r0 + (-1)
            int r3 = r2 - r3
            if (r1 >= r3) goto Lc8
            java.nio.charset.Charset r2 = com.google.common.base.Charsets.f42260c
            boolean r2 = r5.equals(r2)
            if (r2 != 0) goto L81
            java.nio.charset.Charset r2 = com.google.common.base.Charsets.f42258a
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L8c
        L81:
            byte[] r2 = r4.f5723a
            r2 = r2[r1]
            boolean r2 = androidx.media3.common.util.Util.Q(r2)
            if (r2 == 0) goto L8c
            goto Lc9
        L8c:
            java.nio.charset.Charset r2 = com.google.common.base.Charsets.f42263f
            boolean r2 = r5.equals(r2)
            if (r2 != 0) goto L9c
            java.nio.charset.Charset r2 = com.google.common.base.Charsets.f42261d
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto Lad
        L9c:
            byte[] r2 = r4.f5723a
            r3 = r2[r1]
            if (r3 != 0) goto Lad
            int r3 = r1 + 1
            r2 = r2[r3]
            boolean r2 = androidx.media3.common.util.Util.Q(r2)
            if (r2 == 0) goto Lad
            goto Lc9
        Lad:
            java.nio.charset.Charset r2 = com.google.common.base.Charsets.f42262e
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto Lc6
            byte[] r2 = r4.f5723a
            int r3 = r1 + 1
            r3 = r2[r3]
            if (r3 != 0) goto Lc6
            r2 = r2[r1]
            boolean r2 = androidx.media3.common.util.Util.Q(r2)
            if (r2 == 0) goto Lc6
            goto Lc9
        Lc6:
            int r1 = r1 + r0
            goto L69
        Lc8:
            r1 = r2
        Lc9:
            int r0 = r4.f5724b
            int r1 = r1 - r0
            java.lang.String r0 = r4.v(r1, r5)
            int r1 = r4.f5724b
            int r2 = r4.f5725c
            if (r1 != r2) goto Ld7
            goto Le6
        Ld7:
            char[] r1 = androidx.media3.common.util.ParsableByteArray.f5720d
            char r1 = r4.i(r5, r1)
            r2 = 13
            if (r1 != r2) goto Le6
            char[] r1 = androidx.media3.common.util.ParsableByteArray.f5721e
            r4.i(r5, r1)
        Le6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.util.ParsableByteArray.k(java.nio.charset.Charset):java.lang.String");
    }

    public final int l() {
        byte[] bArr = this.f5723a;
        int i2 = this.f5724b;
        int i3 = i2 + 1;
        this.f5724b = i3;
        int i4 = bArr[i2] & 255;
        int i5 = i2 + 2;
        this.f5724b = i5;
        int i6 = ((bArr[i3] & 255) << 8) | i4;
        int i7 = i2 + 3;
        this.f5724b = i7;
        int i8 = i6 | ((bArr[i5] & 255) << 16);
        this.f5724b = i2 + 4;
        return ((bArr[i7] & 255) << 24) | i8;
    }

    public final long m() {
        byte[] bArr = this.f5723a;
        int i2 = this.f5724b;
        this.f5724b = i2 + 1;
        this.f5724b = i2 + 2;
        this.f5724b = i2 + 3;
        long j2 = (bArr[i2] & 255) | ((bArr[r2] & 255) << 8) | ((bArr[r7] & 255) << 16);
        this.f5724b = i2 + 4;
        long j3 = j2 | ((bArr[r8] & 255) << 24);
        this.f5724b = i2 + 5;
        long j4 = j3 | ((bArr[r7] & 255) << 32);
        this.f5724b = i2 + 6;
        long j5 = j4 | ((bArr[r8] & 255) << 40);
        this.f5724b = i2 + 7;
        long j6 = j5 | ((bArr[r7] & 255) << 48);
        this.f5724b = i2 + 8;
        return ((bArr[r8] & 255) << 56) | j6;
    }

    public final short n() {
        byte[] bArr = this.f5723a;
        int i2 = this.f5724b;
        int i3 = i2 + 1;
        this.f5724b = i3;
        int i4 = bArr[i2] & 255;
        this.f5724b = i2 + 2;
        return (short) (((bArr[i3] & 255) << 8) | i4);
    }

    public final long o() {
        byte[] bArr = this.f5723a;
        int i2 = this.f5724b;
        this.f5724b = i2 + 1;
        this.f5724b = i2 + 2;
        this.f5724b = i2 + 3;
        long j2 = (bArr[i2] & 255) | ((bArr[r2] & 255) << 8) | ((bArr[r7] & 255) << 16);
        this.f5724b = i2 + 4;
        return ((bArr[r4] & 255) << 24) | j2;
    }

    public final int p() {
        int iL = l();
        if (iL >= 0) {
            return iL;
        }
        throw new IllegalStateException(android.support.v4.media.b.f(iL, "Top bit not zero: "));
    }

    public final int q() {
        byte[] bArr = this.f5723a;
        int i2 = this.f5724b;
        int i3 = i2 + 1;
        this.f5724b = i3;
        int i4 = bArr[i2] & 255;
        this.f5724b = i2 + 2;
        return ((bArr[i3] & 255) << 8) | i4;
    }

    public final long r() {
        byte[] bArr = this.f5723a;
        int i2 = this.f5724b;
        this.f5724b = i2 + 1;
        this.f5724b = i2 + 2;
        this.f5724b = i2 + 3;
        long j2 = ((bArr[i2] & 255) << 56) | ((bArr[r2] & 255) << 48) | ((bArr[r7] & 255) << 40);
        this.f5724b = i2 + 4;
        long j3 = j2 | ((bArr[r4] & 255) << 32);
        this.f5724b = i2 + 5;
        long j4 = j3 | ((bArr[r7] & 255) << 24);
        this.f5724b = i2 + 6;
        long j5 = j4 | ((bArr[r4] & 255) << 16);
        this.f5724b = i2 + 7;
        long j6 = j5 | ((bArr[r7] & 255) << 8);
        this.f5724b = i2 + 8;
        return (bArr[r4] & 255) | j6;
    }

    public final String s() {
        if (a() == 0) {
            return null;
        }
        int i2 = this.f5724b;
        while (i2 < this.f5725c && this.f5723a[i2] != 0) {
            i2++;
        }
        byte[] bArr = this.f5723a;
        int i3 = this.f5724b;
        int i4 = Util.f5744a;
        String str = new String(bArr, i3, i2 - i3, Charsets.f42260c);
        this.f5724b = i2;
        if (i2 < this.f5725c) {
            this.f5724b = i2 + 1;
        }
        return str;
    }

    public final String t(int i2) {
        if (i2 == 0) {
            return "";
        }
        int i3 = this.f5724b;
        int i4 = (i3 + i2) - 1;
        int i5 = (i4 >= this.f5725c || this.f5723a[i4] != 0) ? i2 : i2 - 1;
        byte[] bArr = this.f5723a;
        int i6 = Util.f5744a;
        String str = new String(bArr, i3, i5, Charsets.f42260c);
        this.f5724b += i2;
        return str;
    }

    public final short u() {
        byte[] bArr = this.f5723a;
        int i2 = this.f5724b;
        int i3 = i2 + 1;
        this.f5724b = i3;
        int i4 = (bArr[i2] & 255) << 8;
        this.f5724b = i2 + 2;
        return (short) ((bArr[i3] & 255) | i4);
    }

    public final String v(int i2, Charset charset) {
        String str = new String(this.f5723a, this.f5724b, i2, charset);
        this.f5724b += i2;
        return str;
    }

    public final int w() {
        return (x() << 21) | (x() << 14) | (x() << 7) | x();
    }

    public final int x() {
        byte[] bArr = this.f5723a;
        int i2 = this.f5724b;
        this.f5724b = i2 + 1;
        return bArr[i2] & 255;
    }

    public final int y() {
        byte[] bArr = this.f5723a;
        int i2 = this.f5724b;
        int i3 = i2 + 1;
        this.f5724b = i3;
        int i4 = (bArr[i2] & 255) << 8;
        this.f5724b = i2 + 2;
        int i5 = (bArr[i3] & 255) | i4;
        this.f5724b = i2 + 4;
        return i5;
    }

    public final long z() {
        byte[] bArr = this.f5723a;
        int i2 = this.f5724b;
        this.f5724b = i2 + 1;
        this.f5724b = i2 + 2;
        this.f5724b = i2 + 3;
        long j2 = ((bArr[i2] & 255) << 24) | ((bArr[r2] & 255) << 16) | ((bArr[r7] & 255) << 8);
        this.f5724b = i2 + 4;
        return (bArr[r4] & 255) | j2;
    }

    public ParsableByteArray(int i2) {
        this.f5723a = new byte[i2];
        this.f5725c = i2;
    }

    public ParsableByteArray(byte[] bArr) {
        this.f5723a = bArr;
        this.f5725c = bArr.length;
    }

    public ParsableByteArray(byte[] bArr, int i2) {
        this.f5723a = bArr;
        this.f5725c = i2;
    }
}
