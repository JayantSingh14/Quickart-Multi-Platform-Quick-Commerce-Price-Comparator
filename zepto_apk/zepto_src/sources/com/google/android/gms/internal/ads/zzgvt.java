package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes4.dex */
final class zzgvt {

    /* renamed from: a, reason: collision with root package name */
    public final String f33262a;

    /* renamed from: b, reason: collision with root package name */
    public final char[] f33263b;

    /* renamed from: c, reason: collision with root package name */
    public final int f33264c;

    /* renamed from: d, reason: collision with root package name */
    public final int f33265d;

    /* renamed from: e, reason: collision with root package name */
    public final int f33266e;

    /* renamed from: f, reason: collision with root package name */
    public final int f33267f;

    /* renamed from: g, reason: collision with root package name */
    public final byte[] f33268g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean[] f33269h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f33270i;

    /* JADX WARN: Illegal instructions before constructor call */
    public zzgvt(String str, char[] cArr) {
        byte[] bArr = new byte[128];
        Arrays.fill(bArr, (byte) -1);
        for (int i2 = 0; i2 < cArr.length; i2++) {
            char c2 = cArr[i2];
            if (!(c2 < 128)) {
                throw new IllegalArgumentException(zzgqr.b("Non-ASCII character: %s", Character.valueOf(c2)));
            }
            if (!(bArr[c2] == -1)) {
                throw new IllegalArgumentException(zzgqr.b("Duplicate character: %s", Character.valueOf(c2)));
            }
            bArr[c2] = (byte) i2;
        }
        this(str, cArr, bArr, false);
    }

    public final int a(char c2) throws zzgvw {
        if (c2 > 127) {
            throw new zzgvw("Unrecognized character: 0x".concat(String.valueOf(Integer.toHexString(c2))));
        }
        byte b2 = this.f33268g[c2];
        if (b2 != -1) {
            return b2;
        }
        if (c2 <= ' ' || c2 == 127) {
            throw new zzgvw("Unrecognized character: 0x".concat(String.valueOf(Integer.toHexString(c2))));
        }
        throw new zzgvw(androidx.fragment.app.e.t(new StringBuilder(String.valueOf(c2).length() + 24), "Unrecognized character: ", c2));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgvt)) {
            return false;
        }
        zzgvt zzgvtVar = (zzgvt) obj;
        return this.f33270i == zzgvtVar.f33270i && Arrays.equals(this.f33263b, zzgvtVar.f33263b);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f33263b) + (true != this.f33270i ? 1237 : 1231);
    }

    public final String toString() {
        return this.f33262a;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0067 A[LOOP:0: B:19:0x0063->B:21:0x0067, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzgvt(java.lang.String r5, char[] r6, byte[] r7, boolean r8) {
        /*
            r4 = this;
            r4.<init>()
            r4.f33262a = r5
            r6.getClass()
            r4.f33263b = r6
            int r5 = r6.length     // Catch: java.lang.ArithmeticException -> L7b
            java.math.RoundingMode r0 = java.math.RoundingMode.UNNECESSARY     // Catch: java.lang.ArithmeticException -> L7b
            if (r5 <= 0) goto L7d
            int[] r1 = com.google.android.gms.internal.ads.zzgwp.f33295a     // Catch: java.lang.ArithmeticException -> L7b
            int r0 = r0.ordinal()     // Catch: java.lang.ArithmeticException -> L7b
            r0 = r1[r0]     // Catch: java.lang.ArithmeticException -> L7b
            r1 = 1
            r2 = 0
            switch(r0) {
                case 1: goto L3a;
                case 2: goto L45;
                case 3: goto L45;
                case 4: goto L31;
                case 5: goto L31;
                case 6: goto L22;
                case 7: goto L22;
                case 8: goto L22;
                default: goto L1c;
            }     // Catch: java.lang.ArithmeticException -> L7b
        L1c:
            java.lang.AssertionError r5 = new java.lang.AssertionError     // Catch: java.lang.ArithmeticException -> L7b
            r5.<init>()     // Catch: java.lang.ArithmeticException -> L7b
            throw r5     // Catch: java.lang.ArithmeticException -> L7b
        L22:
            int r0 = java.lang.Integer.numberOfLeadingZeros(r5)     // Catch: java.lang.ArithmeticException -> L7b
            r3 = -1257966797(0xffffffffb504f333, float:-4.9527733E-7)
            int r3 = r3 >>> r0
            int r0 = 31 - r0
            int r3 = r3 - r5
            int r3 = r3 >>> 31
            int r0 = r0 + r3
            goto L4b
        L31:
            int r0 = r5 + (-1)
            int r0 = java.lang.Integer.numberOfLeadingZeros(r0)     // Catch: java.lang.ArithmeticException -> L7b
            int r0 = 32 - r0
            goto L4b
        L3a:
            int r0 = r5 + (-1)
            r0 = r0 & r5
            if (r0 != 0) goto L41
            r0 = r1
            goto L42
        L41:
            r0 = r2
        L42:
            com.google.android.gms.internal.ads.zzgwt.b(r0)     // Catch: java.lang.ArithmeticException -> L7b
        L45:
            int r0 = java.lang.Integer.numberOfLeadingZeros(r5)     // Catch: java.lang.ArithmeticException -> L7b
            int r0 = 31 - r0
        L4b:
            r4.f33265d = r0     // Catch: java.lang.ArithmeticException -> L7b
            int r6 = java.lang.Integer.numberOfTrailingZeros(r0)
            int r3 = 3 - r6
            int r3 = r1 << r3
            r4.f33266e = r3
            int r6 = r0 >> r6
            r4.f33267f = r6
            int r5 = r5 + (-1)
            r4.f33264c = r5
            r4.f33268g = r7
            boolean[] r5 = new boolean[r3]
        L63:
            int r6 = r4.f33267f
            if (r2 >= r6) goto L76
            int r6 = r2 * 8
            int r7 = r4.f33265d
            java.math.RoundingMode r0 = java.math.RoundingMode.CEILING
            int r6 = com.google.android.gms.internal.ads.zzgwq.a(r6, r7)
            r5[r6] = r1
            int r2 = r2 + 1
            goto L63
        L76:
            r4.f33269h = r5
            r4.f33270i = r8
            return
        L7b:
            r5 = move-exception
            goto L85
        L7d:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch: java.lang.ArithmeticException -> L7b
            java.lang.String r7 = "x (0) must be > 0"
            r5.<init>(r7)     // Catch: java.lang.ArithmeticException -> L7b
            throw r5     // Catch: java.lang.ArithmeticException -> L7b
        L85:
            int r6 = r6.length
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = java.lang.String.valueOf(r6)
            int r8 = r8.length()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r8 = r8 + 24
            r0.<init>(r8)
            java.lang.String r8 = "Illegal alphabet length "
            java.lang.String r6 = androidx.fragment.app.e.r(r0, r6, r8)
            r7.<init>(r6, r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgvt.<init>(java.lang.String, char[], byte[], boolean):void");
    }
}
