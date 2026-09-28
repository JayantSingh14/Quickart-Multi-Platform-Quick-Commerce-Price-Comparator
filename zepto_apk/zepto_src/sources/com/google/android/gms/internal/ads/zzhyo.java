package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import org.apache.commons.lang3.ClassUtils;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
public final class zzhyo implements Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final StringReader f34510a;

    /* renamed from: h, reason: collision with root package name */
    public long f34517h;

    /* renamed from: i, reason: collision with root package name */
    public int f34518i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f34519j;

    /* renamed from: l, reason: collision with root package name */
    public String[] f34521l;

    /* renamed from: m, reason: collision with root package name */
    public int[] f34522m;

    /* renamed from: b, reason: collision with root package name */
    public final char[] f34511b = new char[1024];

    /* renamed from: c, reason: collision with root package name */
    public int f34512c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f34513d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f34514e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f34515f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f34516g = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f34520k = 1;

    static {
        new zzhyn();
    }

    public zzhyo(StringReader stringReader) {
        int[] iArr = new int[32];
        this.f34519j = iArr;
        iArr[0] = 6;
        this.f34521l = new String[32];
        this.f34522m = new int[32];
        this.f34510a = stringReader;
    }

    public final boolean A(int i2) throws IOException {
        int i3;
        int i4 = this.f34515f;
        int i5 = this.f34512c;
        this.f34515f = i4 - i5;
        int i6 = this.f34513d;
        char[] cArr = this.f34511b;
        if (i6 != i5) {
            int i7 = i6 - i5;
            this.f34513d = i7;
            System.arraycopy(cArr, i5, cArr, 0, i7);
        } else {
            this.f34513d = 0;
        }
        this.f34512c = 0;
        do {
            int i8 = this.f34513d;
            int i9 = this.f34510a.read(cArr, i8, 1024 - i8);
            if (i9 == -1) {
                return false;
            }
            i3 = this.f34513d + i9;
            this.f34513d = i3;
            if (this.f34514e == 0 && this.f34515f == 0 && i3 > 0 && cArr[0] == 65279) {
                this.f34512c++;
                this.f34515f = 1;
                i2++;
            }
        } while (i3 < i2);
        return true;
    }

    public final int D(boolean z) throws IOException {
        int i2 = this.f34512c;
        int i3 = this.f34513d;
        while (true) {
            if (i2 == i3) {
                this.f34512c = i2;
                if (!A(1)) {
                    if (z) {
                        throw new EOFException("End of input".concat(c()));
                    }
                    return -1;
                }
                i2 = this.f34512c;
                i3 = this.f34513d;
            }
            int i4 = i2 + 1;
            char c2 = this.f34511b[i2];
            if (c2 == '\n') {
                this.f34514e++;
                this.f34515f = i4;
            } else if (c2 != ' ' && c2 != '\r' && c2 != '\t') {
                if (c2 != '/') {
                    if (c2 != '#') {
                        this.f34512c = i4;
                        return c2;
                    }
                    this.f34512c = i4;
                    N();
                    throw null;
                }
                this.f34512c = i4;
                if (i4 == i3) {
                    this.f34512c = i2;
                    boolean zA = A(2);
                    this.f34512c++;
                    if (!zA) {
                        return 47;
                    }
                }
                N();
                throw null;
            }
            i2 = i4;
        }
    }

    public final void N() throws zzhyr {
        O("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
        throw null;
    }

    public final void O(String str) throws zzhyr {
        String strC = c();
        throw new zzhyr(android.support.v4.media.b.s(new StringBuilder(str.length() + strC.length() + 79), str, strC, "\nSee https://github.com/google/gson/blob/main/Troubleshooting.md#malformed-json"));
    }

    public final IllegalStateException T(String str) throws IOException {
        int iE = e();
        String strA = zzhyp.a(e());
        String strC = c();
        int iC = androidx.fragment.app.e.C(str.length() + 18, strC.length(), strA);
        String strConcat = "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat(iE == 9 ? "adapter-not-null-safe" : "unexpected-json-structure");
        StringBuilder sb = new StringBuilder(strConcat.length() + iC + 5);
        android.support.v4.media.b.B(sb, "Expected ", str, " but was ", strA);
        return new IllegalStateException(android.support.v4.media.b.s(sb, strC, "\nSee ", strConcat));
    }

    /* JADX WARN: Code restructure failed: missing block: B:139:0x01b4, code lost:
    
        if (l(r15) == false) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x01b8, code lost:
    
        r3 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x01b9, code lost:
    
        if (r10 != r3) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x01bb, code lost:
    
        if (r11 == false) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x01c1, code lost:
    
        if (r1 != Long.MIN_VALUE) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x01c3, code lost:
    
        if (r19 == 0) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x01c5, code lost:
    
        r7 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x01c7, code lost:
    
        r6 = 2;
        r10 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x01ca, code lost:
    
        r7 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x01ce, code lost:
    
        if (r1 != 0) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x01d0, code lost:
    
        if (r7 != 0) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x01d3, code lost:
    
        if (r7 == 0) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x01d6, code lost:
    
        r1 = -r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x01d7, code lost:
    
        r26.f34517h = r1;
        r26.f34512c += r4;
        r7 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x01e0, code lost:
    
        r26.f34516g = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x01e3, code lost:
    
        r6 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x01e4, code lost:
    
        if (r10 == r6) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x01e7, code lost:
    
        if (r10 == 4) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x01ea, code lost:
    
        if (r10 != 7) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x01ec, code lost:
    
        r26.f34518i = r4;
        r7 = 16;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0219 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x022e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:207:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 670
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhyo.a():int");
    }

    public final String b() throws IOException {
        String str;
        int iA = this.f34516g;
        if (iA == 0) {
            iA = a();
        }
        if (iA == 10) {
            str = s();
        } else if (iA == 8) {
            str = r('\'');
        } else if (iA == 9) {
            str = r('\"');
        } else if (iA == 11) {
            str = null;
        } else if (iA == 15) {
            str = Long.toString(this.f34517h);
        } else {
            if (iA != 16) {
                throw T("a string");
            }
            str = new String(this.f34511b, this.f34512c, this.f34518i);
            this.f34512c += this.f34518i;
        }
        this.f34516g = 0;
        int[] iArr = this.f34522m;
        int i2 = this.f34520k - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public final String c() {
        int i2 = this.f34514e + 1;
        int i3 = this.f34512c - this.f34515f;
        StringBuilder sb = new StringBuilder("$");
        for (int i4 = 0; i4 < this.f34520k; i4++) {
            int i5 = this.f34519j[i4];
            switch (i5) {
                case 1:
                case 2:
                    int i6 = this.f34522m[i4];
                    sb.append('[');
                    sb.append(i6);
                    sb.append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                    String str = this.f34521l[i4];
                    if (str != null) {
                        sb.append(str);
                        break;
                    } else {
                        break;
                    }
                case 6:
                case 7:
                case 8:
                    break;
                default:
                    throw new AssertionError(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(i5).length() + 21), i5, "Unknown scope value: "));
            }
        }
        int i7 = i3 + 1;
        String string = sb.toString();
        int length = String.valueOf(i2).length();
        int length2 = String.valueOf(i7).length();
        StringBuilder sb2 = new StringBuilder(string.length() + length2 + length + 17 + 6);
        androidx.fragment.app.e.w(i2, i7, " at line ", " column ", sb2);
        return android.support.v4.media.b.r(sb2, " path ", string);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f34516g = 0;
        this.f34519j[0] = 8;
        this.f34520k = 1;
        this.f34510a.close();
    }

    public final int e() throws IOException {
        int iA = this.f34516g;
        if (iA == 0) {
            iA = a();
        }
        switch (iA) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
            case 9:
            case 10:
            case 11:
                return 6;
            case 12:
            case 13:
            case 14:
                return 5;
            case 15:
            case 16:
                return 7;
            default:
                return 10;
        }
    }

    public final boolean l(char c2) throws zzhyr {
        if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ') {
            return false;
        }
        if (c2 != '#') {
            if (c2 == ',') {
                return false;
            }
            if (c2 != '/' && c2 != '=') {
                if (c2 == '{' || c2 == '}' || c2 == ':') {
                    return false;
                }
                if (c2 != ';') {
                    switch (c2) {
                        case WKSRecord.Service.MIT_DOV /* 91 */:
                        case WKSRecord.Service.DCP /* 93 */:
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        N();
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x0112, code lost:
    
        r4 = r2 - r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0114, code lost:
    
        if (r1 != null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0116, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max(r4 + r4, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0122, code lost:
    
        r1.append(r5, r3, r4);
        r11.f34512c = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String r(char r12) throws com.google.android.gms.internal.ads.zzhyr {
        /*
            Method dump skipped, instructions count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhyo.r(char):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0049, code lost:
    
        N();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x004c, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x005a, code lost:
    
        r0 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String s() throws com.google.android.gms.internal.ads.zzhyr {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
            r2 = r0
            r3 = r1
        L4:
            int r4 = r7.f34512c
            int r4 = r4 + r2
            int r5 = r7.f34513d
            char[] r6 = r7.f34511b
            if (r4 >= r5) goto L4d
            char r4 = r6[r4]
            r5 = 9
            if (r4 == r5) goto L5a
            r5 = 10
            if (r4 == r5) goto L5a
            r5 = 12
            if (r4 == r5) goto L5a
            r5 = 13
            if (r4 == r5) goto L5a
            r5 = 32
            if (r4 == r5) goto L5a
            r5 = 35
            if (r4 == r5) goto L49
            r5 = 44
            if (r4 == r5) goto L5a
            r5 = 47
            if (r4 == r5) goto L49
            r5 = 61
            if (r4 == r5) goto L49
            r5 = 123(0x7b, float:1.72E-43)
            if (r4 == r5) goto L5a
            r5 = 125(0x7d, float:1.75E-43)
            if (r4 == r5) goto L5a
            r5 = 58
            if (r4 == r5) goto L5a
            r5 = 59
            if (r4 == r5) goto L49
            switch(r4) {
                case 91: goto L5a;
                case 92: goto L49;
                case 93: goto L5a;
                default: goto L46;
            }
        L46:
            int r2 = r2 + 1
            goto L4
        L49:
            r7.N()
            throw r1
        L4d:
            r4 = 1024(0x400, float:1.435E-42)
            if (r2 >= r4) goto L5c
            int r4 = r2 + 1
            boolean r4 = r7.A(r4)
            if (r4 == 0) goto L5a
            goto L4
        L5a:
            r0 = r2
            goto L7a
        L5c:
            if (r3 != 0) goto L69
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r4 = 16
            int r4 = java.lang.Math.max(r2, r4)
            r3.<init>(r4)
        L69:
            int r4 = r7.f34512c
            r3.append(r6, r4, r2)
            int r4 = r7.f34512c
            int r4 = r4 + r2
            r7.f34512c = r4
            r2 = 1
            boolean r2 = r7.A(r2)
            if (r2 != 0) goto L93
        L7a:
            if (r3 != 0) goto L84
            java.lang.String r1 = new java.lang.String
            int r2 = r7.f34512c
            r1.<init>(r6, r2, r0)
            goto L8d
        L84:
            int r1 = r7.f34512c
            r3.append(r6, r1, r0)
            java.lang.String r1 = r3.toString()
        L8d:
            int r2 = r7.f34512c
            int r2 = r2 + r0
            r7.f34512c = r2
            return r1
        L93:
            r2 = r0
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhyo.s():java.lang.String");
    }

    public final String toString() {
        return "zzhyo".concat(c());
    }

    public final void x(int i2) throws zzhyr {
        int i3 = this.f34520k;
        if (i3 - 1 >= 1280) {
            String strC = c();
            throw new zzhyr(android.support.v4.media.b.r(new StringBuilder(strC.length() + 26), "Nesting limit 1280 reached", strC));
        }
        int[] iArr = this.f34519j;
        if (i3 == iArr.length) {
            int i4 = i3 + i3;
            this.f34519j = Arrays.copyOf(iArr, i4);
            this.f34522m = Arrays.copyOf(this.f34522m, i4);
            this.f34521l = (String[]) Arrays.copyOf(this.f34521l, i4);
        }
        int[] iArr2 = this.f34519j;
        int i5 = this.f34520k;
        this.f34520k = i5 + 1;
        iArr2[i5] = i2;
    }
}
