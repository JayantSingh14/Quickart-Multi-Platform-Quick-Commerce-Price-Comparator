package com.google.android.gms.internal.pal;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import org.apache.commons.lang3.ClassUtils;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
public final class zzabc implements Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final StringReader f37328a;

    /* renamed from: h, reason: collision with root package name */
    public long f37335h;

    /* renamed from: i, reason: collision with root package name */
    public int f37336i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f37337j;

    /* renamed from: l, reason: collision with root package name */
    public String[] f37339l;

    /* renamed from: m, reason: collision with root package name */
    public int[] f37340m;

    /* renamed from: b, reason: collision with root package name */
    public final char[] f37329b = new char[1024];

    /* renamed from: c, reason: collision with root package name */
    public int f37330c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f37331d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f37332e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f37333f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f37334g = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f37338k = 1;

    static {
        new zzabb();
    }

    public zzabc(StringReader stringReader) {
        int[] iArr = new int[32];
        this.f37337j = iArr;
        iArr[0] = 6;
        this.f37339l = new String[32];
        this.f37340m = new int[32];
        this.f37328a = stringReader;
    }

    public final void A(int i2) {
        int i3 = this.f37338k;
        int[] iArr = this.f37337j;
        if (i3 == iArr.length) {
            int i4 = i3 + i3;
            this.f37337j = Arrays.copyOf(iArr, i4);
            this.f37340m = Arrays.copyOf(this.f37340m, i4);
            this.f37339l = (String[]) Arrays.copyOf(this.f37339l, i4);
        }
        int[] iArr2 = this.f37337j;
        int i5 = this.f37338k;
        this.f37338k = i5 + 1;
        iArr2[i5] = i2;
    }

    public final boolean D(int i2) throws IOException {
        int i3;
        int i4 = this.f37333f;
        int i5 = this.f37330c;
        this.f37333f = i4 - i5;
        int i6 = this.f37331d;
        char[] cArr = this.f37329b;
        if (i6 != i5) {
            int i7 = i6 - i5;
            this.f37331d = i7;
            System.arraycopy(cArr, i5, cArr, 0, i7);
        } else {
            this.f37331d = 0;
        }
        this.f37330c = 0;
        do {
            int i8 = this.f37331d;
            int i9 = this.f37328a.read(cArr, i8, 1024 - i8);
            if (i9 == -1) {
                return false;
            }
            i3 = this.f37331d + i9;
            this.f37331d = i3;
            if (this.f37332e == 0 && this.f37333f == 0 && i3 > 0 && cArr[0] == 65279) {
                this.f37330c++;
                this.f37333f = 1;
                i2++;
            }
        } while (i3 < i2);
        return true;
    }

    public final boolean N(char c2) throws zzabf {
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
        r("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:141:0x01b4, code lost:
    
        if (N(r15) == false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x01b8, code lost:
    
        if (r10 != 2) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x01ba, code lost:
    
        if (r13 == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x01c0, code lost:
    
        if (r7 != Long.MIN_VALUE) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x01c2, code lost:
    
        if (r19 == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x01c4, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x01c6, code lost:
    
        r10 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x01c8, code lost:
    
        r3 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x01cc, code lost:
    
        if (r7 != 0) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x01ce, code lost:
    
        if (r3 != false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x01d1, code lost:
    
        if (r3 == false) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x01d4, code lost:
    
        r7 = -r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x01d5, code lost:
    
        r24.f37335h = r7;
        r24.f37330c += r9;
        r7 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x01de, code lost:
    
        r24.f37334g = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x01e1, code lost:
    
        if (r10 == 2) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x01e4, code lost:
    
        if (r10 == 4) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x01e7, code lost:
    
        if (r10 != 7) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x01e9, code lost:
    
        r24.f37336i = r9;
        r7 = 16;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0220 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0235 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 683
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.pal.zzabc.a():int");
    }

    public final String b() {
        int i2 = this.f37332e;
        int i3 = this.f37330c;
        int i4 = this.f37333f;
        StringBuilder sb = new StringBuilder(" at line ");
        sb.append(i2 + 1);
        sb.append(" column ");
        sb.append((i3 - i4) + 1);
        sb.append(" path ");
        StringBuilder sb2 = new StringBuilder("$");
        for (int i5 = 0; i5 < this.f37338k; i5++) {
            int i6 = this.f37337j[i5];
            if (i6 == 1 || i6 == 2) {
                int i7 = this.f37340m[i5];
                sb2.append('[');
                sb2.append(i7);
                sb2.append(']');
            } else if (i6 == 3 || i6 == 4 || i6 == 5) {
                sb2.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                String str = this.f37339l[i5];
                if (str != null) {
                    sb2.append(str);
                }
            }
        }
        sb.append(sb2.toString());
        return sb.toString();
    }

    public final String c() throws IOException {
        String str;
        int iA = this.f37334g;
        if (iA == 0) {
            iA = a();
        }
        if (iA == 10) {
            str = x();
        } else if (iA == 8) {
            str = s('\'');
        } else if (iA == 9) {
            str = s('\"');
        } else if (iA == 11) {
            str = null;
        } else if (iA == 15) {
            str = Long.toString(this.f37335h);
        } else {
            if (iA != 16) {
                throw new IllegalStateException("Expected a string but was " + ((Object) zzabd.a(e())) + b());
            }
            str = new String(this.f37329b, this.f37330c, this.f37336i);
            this.f37330c += this.f37336i;
        }
        this.f37334g = 0;
        int[] iArr = this.f37340m;
        int i2 = this.f37338k - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f37334g = 0;
        this.f37337j[0] = 8;
        this.f37338k = 1;
        this.f37328a.close();
    }

    public final int e() throws IOException {
        int iA = this.f37334g;
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

    public final int l(boolean z) throws IOException {
        int i2 = this.f37330c;
        int i3 = this.f37331d;
        while (true) {
            if (i2 == i3) {
                this.f37330c = i2;
                if (!D(1)) {
                    if (z) {
                        throw new EOFException("End of input".concat(b()));
                    }
                    return -1;
                }
                i2 = this.f37330c;
                i3 = this.f37331d;
            }
            int i4 = i2 + 1;
            char c2 = this.f37329b[i2];
            if (c2 == '\n') {
                this.f37332e++;
                this.f37333f = i4;
            } else if (c2 != ' ' && c2 != '\r' && c2 != '\t') {
                if (c2 != '/') {
                    if (c2 != '#') {
                        this.f37330c = i4;
                        return c2;
                    }
                    this.f37330c = i4;
                    r("Use JsonReader.setLenient(true) to accept malformed JSON");
                    throw null;
                }
                this.f37330c = i4;
                if (i4 == i3) {
                    this.f37330c = i2;
                    boolean zD = D(2);
                    this.f37330c++;
                    if (!zD) {
                        return 47;
                    }
                }
                r("Use JsonReader.setLenient(true) to accept malformed JSON");
                throw null;
            }
            i2 = i4;
        }
    }

    public final void r(String str) throws zzabf {
        throw new zzabf(str.concat(b()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x00fe, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
    
        r11.f37330c = r8;
        r8 = r8 - r3;
        r2 = r8 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
    
        if (r1 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max(r8 + r8, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
    
        r1.append(r5, r3, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004a, code lost:
    
        if (r11.f37330c != r11.f37331d) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0050, code lost:
    
        if (D(1) == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0053, code lost:
    
        r("Unterminated escape sequence");
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0056, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0057, code lost:
    
        r2 = r11.f37330c;
        r3 = r2 + 1;
        r11.f37330c = r3;
        r7 = r5[r2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005f, code lost:
    
        if (r7 == '\n') goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0063, code lost:
    
        if (r7 == '\"') goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
    
        if (r7 == '\'') goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006b, code lost:
    
        if (r7 == '/') goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006d, code lost:
    
        if (r7 == '\\') goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0071, code lost:
    
        if (r7 == 'b') goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0075, code lost:
    
        if (r7 == 'f') goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0079, code lost:
    
        if (r7 == 'n') goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007d, code lost:
    
        if (r7 == 'r') goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0081, code lost:
    
        if (r7 == 't') goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0085, code lost:
    
        if (r7 != 'u') goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x008c, code lost:
    
        if ((r2 + 5) <= r11.f37331d) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0092, code lost:
    
        if (D(4) == false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0095, code lost:
    
        r("Unterminated escape sequence");
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0098, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0099, code lost:
    
        r2 = r11.f37330c;
        r4 = r2 + 4;
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x009f, code lost:
    
        if (r2 >= r4) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00a1, code lost:
    
        r6 = r5[r2];
        r8 = (char) (r10 << 4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a8, code lost:
    
        if (r6 < '0') goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00ac, code lost:
    
        if (r6 > '9') goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00ae, code lost:
    
        r6 = r6 - '0';
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00b0, code lost:
    
        r10 = (char) (r6 + r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00b6, code lost:
    
        if (r6 < 'a') goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b8, code lost:
    
        if (r6 > 'f') goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ba, code lost:
    
        r6 = r6 - 'W';
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00bf, code lost:
    
        if (r6 < 'A') goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00c3, code lost:
    
        if (r6 > 'F') goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00c5, code lost:
    
        r6 = r6 - '7';
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00c8, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00de, code lost:
    
        r11.f37330c += 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00e4, code lost:
    
        r("Invalid escape sequence");
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00e9, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00ea, code lost:
    
        r10 = '\t';
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00ed, code lost:
    
        r10 = org.apache.commons.lang3.CharUtils.CR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00f0, code lost:
    
        r10 = '\f';
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00f3, code lost:
    
        r10 = '\b';
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00f6, code lost:
    
        r11.f37332e++;
        r11.f37333f = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00fd, code lost:
    
        r10 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0113, code lost:
    
        if (r1 != null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0115, code lost:
    
        r1 = r2 - r3;
        r1 = new java.lang.StringBuilder(java.lang.Math.max(r1 + r1, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0122, code lost:
    
        r1.append(r5, r3, r2 - r3);
        r11.f37330c = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String s(char r12) throws com.google.android.gms.internal.pal.zzabf {
        /*
            Method dump skipped, instructions count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.pal.zzabc.s(char):java.lang.String");
    }

    public final String toString() {
        return "zzabc".concat(b());
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0049, code lost:
    
        r("Use JsonReader.setLenient(true) to accept malformed JSON");
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x004e, code lost:
    
        throw null;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String x() throws com.google.android.gms.internal.pal.zzabf {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
            r3 = r0
        L3:
            r2 = r1
        L4:
            int r4 = r7.f37330c
            int r4 = r4 + r2
            int r5 = r7.f37331d
            char[] r6 = r7.f37329b
            if (r4 >= r5) goto L4f
            char r4 = r6[r4]
            r5 = 9
            if (r4 == r5) goto L5b
            r5 = 10
            if (r4 == r5) goto L5b
            r5 = 12
            if (r4 == r5) goto L5b
            r5 = 13
            if (r4 == r5) goto L5b
            r5 = 32
            if (r4 == r5) goto L5b
            r5 = 35
            if (r4 == r5) goto L49
            r5 = 44
            if (r4 == r5) goto L5b
            r5 = 47
            if (r4 == r5) goto L49
            r5 = 61
            if (r4 == r5) goto L49
            r5 = 123(0x7b, float:1.72E-43)
            if (r4 == r5) goto L5b
            r5 = 125(0x7d, float:1.75E-43)
            if (r4 == r5) goto L5b
            r5 = 58
            if (r4 == r5) goto L5b
            r5 = 59
            if (r4 == r5) goto L49
            switch(r4) {
                case 91: goto L5b;
                case 92: goto L49;
                case 93: goto L5b;
                default: goto L46;
            }
        L46:
            int r2 = r2 + 1
            goto L4
        L49:
            java.lang.String r1 = "Use JsonReader.setLenient(true) to accept malformed JSON"
            r7.r(r1)
            throw r0
        L4f:
            r4 = 1024(0x400, float:1.435E-42)
            if (r2 >= r4) goto L5d
            int r4 = r2 + 1
            boolean r4 = r7.D(r4)
            if (r4 != 0) goto L4
        L5b:
            r1 = r2
            goto L7b
        L5d:
            if (r3 != 0) goto L6a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r4 = 16
            int r4 = java.lang.Math.max(r2, r4)
            r3.<init>(r4)
        L6a:
            int r4 = r7.f37330c
            r3.append(r6, r4, r2)
            int r4 = r7.f37330c
            int r4 = r4 + r2
            r7.f37330c = r4
            r2 = 1
            boolean r2 = r7.D(r2)
            if (r2 != 0) goto L3
        L7b:
            if (r3 != 0) goto L85
            java.lang.String r0 = new java.lang.String
            int r2 = r7.f37330c
            r0.<init>(r6, r2, r1)
            goto L8e
        L85:
            int r0 = r7.f37330c
            r3.append(r6, r0, r1)
            java.lang.String r0 = r3.toString()
        L8e:
            int r2 = r7.f37330c
            int r2 = r2 + r1
            r7.f37330c = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.pal.zzabc.x():java.lang.String");
    }
}
