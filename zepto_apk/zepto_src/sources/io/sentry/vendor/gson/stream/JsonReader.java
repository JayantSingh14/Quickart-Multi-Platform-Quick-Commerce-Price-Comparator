package io.sentry.vendor.gson.stream;

import android.support.v4.media.b;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.ApiStatus;
import org.xbill.DNS.WKSRecord;

@ApiStatus.Internal
/* loaded from: classes.dex */
public class JsonReader implements Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final Reader f53146a;

    /* renamed from: i, reason: collision with root package name */
    public long f53154i;

    /* renamed from: j, reason: collision with root package name */
    public int f53155j;

    /* renamed from: k, reason: collision with root package name */
    public String f53156k;

    /* renamed from: l, reason: collision with root package name */
    public int[] f53157l;
    public String[] n;
    public int[] o;

    /* renamed from: b, reason: collision with root package name */
    public boolean f53147b = false;

    /* renamed from: c, reason: collision with root package name */
    public final char[] f53148c = new char[1024];

    /* renamed from: d, reason: collision with root package name */
    public int f53149d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f53150e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f53151f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f53152g = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f53153h = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f53158m = 1;

    public JsonReader(Reader reader) {
        int[] iArr = new int[32];
        this.f53157l = iArr;
        iArr[0] = 6;
        this.n = new String[32];
        this.o = new int[32];
        this.f53146a = reader;
    }

    public final boolean A() throws IOException {
        int iC = this.f53153h;
        if (iC == 0) {
            iC = c();
        }
        if (iC == 5) {
            this.f53153h = 0;
            int[] iArr = this.o;
            int i2 = this.f53158m - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        }
        if (iC != 6) {
            throw new IllegalStateException("Expected a boolean but was " + peek() + x());
        }
        this.f53153h = 0;
        int[] iArr2 = this.o;
        int i3 = this.f53158m - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0074, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int D(boolean r10) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.vendor.gson.stream.JsonReader.D(boolean):int");
    }

    public final String K0() throws IOException {
        String str;
        int iC = this.f53153h;
        if (iC == 0) {
            iC = c();
        }
        if (iC == 10) {
            str = T();
        } else if (iC == 8) {
            str = O('\'');
        } else if (iC == 9) {
            str = O('\"');
        } else if (iC == 11) {
            str = this.f53156k;
            this.f53156k = null;
        } else if (iC == 15) {
            str = Long.toString(this.f53154i);
        } else {
            if (iC != 16) {
                throw new IllegalStateException("Expected a string but was " + peek() + x());
            }
            str = new String(this.f53148c, this.f53149d, this.f53155j);
            this.f53149d += this.f53155j;
        }
        this.f53153h = 0;
        int[] iArr = this.o;
        int i2 = this.f53158m - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public final void N() throws IOException {
        int iC = this.f53153h;
        if (iC == 0) {
            iC = c();
        }
        if (iC != 7) {
            throw new IllegalStateException("Expected null but was " + peek() + x());
        }
        this.f53153h = 0;
        int[] iArr = this.o;
        int i2 = this.f53158m - 1;
        iArr[i2] = iArr[i2] + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002d, code lost:
    
        r10.f53149d = r8;
        r8 = r8 - r3;
        r2 = r8 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
    
        if (r1 != null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0034, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max(r8 * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005b, code lost:
    
        if (r1 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005d, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006b, code lost:
    
        r1.append(r5, r3, r2 - r3);
        r10.f53149d = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String O(char r11) throws io.sentry.vendor.gson.stream.MalformedJsonException {
        /*
            r10 = this;
            r0 = 0
            r1 = r0
        L2:
            int r2 = r10.f53149d
            int r3 = r10.f53150e
        L6:
            r4 = r3
            r3 = r2
        L8:
            char[] r5 = r10.f53148c
            r6 = 1
            r7 = 16
            if (r2 >= r4) goto L5b
            int r8 = r2 + 1
            char r2 = r5[r2]
            if (r2 != r11) goto L29
            r10.f53149d = r8
            int r8 = r8 - r3
            int r8 = r8 - r6
            if (r1 != 0) goto L21
            java.lang.String r11 = new java.lang.String
            r11.<init>(r5, r3, r8)
            return r11
        L21:
            r1.append(r5, r3, r8)
            java.lang.String r11 = r1.toString()
            return r11
        L29:
            r9 = 92
            if (r2 != r9) goto L4e
            r10.f53149d = r8
            int r8 = r8 - r3
            int r2 = r8 + (-1)
            if (r1 != 0) goto L3f
            int r8 = r8 * 2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r4 = java.lang.Math.max(r8, r7)
            r1.<init>(r4)
        L3f:
            r1.append(r5, r3, r2)
            char r2 = r10.Z()
            r1.append(r2)
            int r2 = r10.f53149d
            int r3 = r10.f53150e
            goto L6
        L4e:
            r5 = 10
            if (r2 != r5) goto L59
            int r2 = r10.f53151f
            int r2 = r2 + r6
            r10.f53151f = r2
            r10.f53152g = r8
        L59:
            r2 = r8
            goto L8
        L5b:
            if (r1 != 0) goto L6b
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r7)
            r4.<init>(r1)
            r1 = r4
        L6b:
            int r4 = r2 - r3
            r1.append(r5, r3, r4)
            r10.f53149d = r2
            boolean r2 = r10.l(r6)
            if (r2 == 0) goto L79
            goto L2
        L79:
            java.lang.String r11 = "Unterminated string"
            r10.l0(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.vendor.gson.stream.JsonReader.O(char):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
    
        b();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String T() throws io.sentry.vendor.gson.stream.MalformedJsonException {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = r1
        L3:
            int r3 = r7.f53149d
            int r4 = r3 + r2
            int r5 = r7.f53150e
            char[] r6 = r7.f53148c
            if (r4 >= r5) goto L4e
            int r3 = r3 + r2
            char r3 = r6[r3]
            r4 = 9
            if (r3 == r4) goto L5a
            r4 = 10
            if (r3 == r4) goto L5a
            r4 = 12
            if (r3 == r4) goto L5a
            r4 = 13
            if (r3 == r4) goto L5a
            r4 = 32
            if (r3 == r4) goto L5a
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5a
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5a
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5a
            r4 = 58
            if (r3 == r4) goto L5a
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5a;
                case 92: goto L4a;
                case 93: goto L5a;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r7.b()
            goto L5a
        L4e:
            int r3 = r6.length
            if (r2 >= r3) goto L5c
            int r3 = r2 + 1
            boolean r3 = r7.l(r3)
            if (r3 == 0) goto L5a
            goto L3
        L5a:
            r1 = r2
            goto L7a
        L5c:
            if (r0 != 0) goto L69
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L69:
            int r3 = r7.f53149d
            r0.append(r6, r3, r2)
            int r3 = r7.f53149d
            int r3 = r3 + r2
            r7.f53149d = r3
            r2 = 1
            boolean r2 = r7.l(r2)
            if (r2 != 0) goto L2
        L7a:
            if (r0 != 0) goto L84
            java.lang.String r0 = new java.lang.String
            int r2 = r7.f53149d
            r0.<init>(r6, r2, r1)
            goto L8d
        L84:
            int r2 = r7.f53149d
            r0.append(r6, r2, r1)
            java.lang.String r0 = r0.toString()
        L8d:
            int r2 = r7.f53149d
            int r2 = r2 + r1
            r7.f53149d = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.vendor.gson.stream.JsonReader.T():java.lang.String");
    }

    public final void V(int i2) {
        int i3 = this.f53158m;
        int[] iArr = this.f53157l;
        if (i3 == iArr.length) {
            int i4 = i3 * 2;
            this.f53157l = Arrays.copyOf(iArr, i4);
            this.o = Arrays.copyOf(this.o, i4);
            this.n = (String[]) Arrays.copyOf(this.n, i4);
        }
        int[] iArr2 = this.f53157l;
        int i5 = this.f53158m;
        this.f53158m = i5 + 1;
        iArr2[i5] = i2;
    }

    public final String X() throws IOException {
        String strO;
        int iC = this.f53153h;
        if (iC == 0) {
            iC = c();
        }
        if (iC == 14) {
            strO = T();
        } else if (iC == 12) {
            strO = O('\'');
        } else {
            if (iC != 13) {
                throw new IllegalStateException("Expected a name but was " + peek() + x());
            }
            strO = O('\"');
        }
        this.f53153h = 0;
        this.n[this.f53158m - 1] = strO;
        return strO;
    }

    public final char Z() throws MalformedJsonException {
        int i2;
        if (this.f53149d == this.f53150e && !l(1)) {
            l0("Unterminated escape sequence");
            throw null;
        }
        int i3 = this.f53149d;
        int i4 = i3 + 1;
        this.f53149d = i4;
        char[] cArr = this.f53148c;
        char c2 = cArr[i3];
        if (c2 == '\n') {
            this.f53151f++;
            this.f53152g = i4;
            return c2;
        }
        if (c2 == '\"' || c2 == '\'' || c2 == '/' || c2 == '\\') {
            return c2;
        }
        if (c2 == 'b') {
            return '\b';
        }
        if (c2 == 'f') {
            return '\f';
        }
        if (c2 == 'n') {
            return '\n';
        }
        if (c2 == 'r') {
            return CharUtils.CR;
        }
        if (c2 == 't') {
            return '\t';
        }
        if (c2 != 'u') {
            l0("Invalid escape sequence");
            throw null;
        }
        if (i3 + 5 > this.f53150e && !l(4)) {
            l0("Unterminated escape sequence");
            throw null;
        }
        int i5 = this.f53149d;
        int i6 = i5 + 4;
        char c3 = 0;
        while (i5 < i6) {
            char c4 = cArr[i5];
            char c5 = (char) (c3 << 4);
            if (c4 >= '0' && c4 <= '9') {
                i2 = c4 - '0';
            } else if (c4 >= 'a' && c4 <= 'f') {
                i2 = c4 - 'W';
            } else {
                if (c4 < 'A' || c4 > 'F') {
                    throw new NumberFormatException("\\u".concat(new String(cArr, this.f53149d, 4)));
                }
                i2 = c4 - '7';
            }
            c3 = (char) (i2 + c5);
            i5++;
        }
        this.f53149d += 4;
        return c3;
    }

    public final void a() throws IOException {
        int iC = this.f53153h;
        if (iC == 0) {
            iC = c();
        }
        if (iC == 3) {
            V(1);
            this.o[this.f53158m - 1] = 0;
            this.f53153h = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + peek() + x());
        }
    }

    public final void b() throws MalformedJsonException {
        if (this.f53147b) {
            return;
        }
        l0("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:168:0x0215, code lost:
    
        if (s(r1) != false) goto L121;
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x017d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x027c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:209:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int c() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 809
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.vendor.gson.stream.JsonReader.c():int");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f53153h = 0;
        this.f53157l[0] = 8;
        this.f53158m = 1;
        this.f53146a.close();
    }

    public final void e() throws IOException {
        int iC = this.f53153h;
        if (iC == 0) {
            iC = c();
        }
        if (iC != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + peek() + x());
        }
        int i2 = this.f53158m;
        this.f53158m = i2 - 1;
        int[] iArr = this.o;
        int i3 = i2 - 2;
        iArr[i3] = iArr[i3] + 1;
        this.f53153h = 0;
    }

    public final void j0(char c2) throws MalformedJsonException {
        do {
            int i2 = this.f53149d;
            int i3 = this.f53150e;
            while (i2 < i3) {
                int i4 = i2 + 1;
                char c3 = this.f53148c[i2];
                if (c3 == c2) {
                    this.f53149d = i4;
                    return;
                }
                if (c3 == '\\') {
                    this.f53149d = i4;
                    Z();
                    i2 = this.f53149d;
                    i3 = this.f53150e;
                } else {
                    if (c3 == '\n') {
                        this.f53151f++;
                        this.f53152g = i4;
                    }
                    i2 = i4;
                }
            }
            this.f53149d = i2;
        } while (l(1));
        l0("Unterminated string");
        throw null;
    }

    public final void k() throws IOException {
        int iC = this.f53153h;
        if (iC == 0) {
            iC = c();
        }
        if (iC == 1) {
            V(3);
            this.f53153h = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + peek() + x());
        }
    }

    public final void k0() {
        char c2;
        do {
            if (this.f53149d >= this.f53150e && !l(1)) {
                return;
            }
            int i2 = this.f53149d;
            int i3 = i2 + 1;
            this.f53149d = i3;
            c2 = this.f53148c[i2];
            if (c2 == '\n') {
                this.f53151f++;
                this.f53152g = i3;
                return;
            }
        } while (c2 != '\r');
    }

    public final boolean l(int i2) throws IOException {
        int i3;
        int i4;
        int i5 = this.f53152g;
        int i6 = this.f53149d;
        this.f53152g = i5 - i6;
        int i7 = this.f53150e;
        char[] cArr = this.f53148c;
        if (i7 != i6) {
            int i8 = i7 - i6;
            this.f53150e = i8;
            System.arraycopy(cArr, i6, cArr, 0, i8);
        } else {
            this.f53150e = 0;
        }
        this.f53149d = 0;
        do {
            int i9 = this.f53150e;
            int i10 = this.f53146a.read(cArr, i9, cArr.length - i9);
            if (i10 == -1) {
                return false;
            }
            i3 = this.f53150e + i10;
            this.f53150e = i3;
            if (this.f53151f == 0 && (i4 = this.f53152g) == 0 && i3 > 0 && cArr[0] == 65279) {
                this.f53149d++;
                this.f53152g = i4 + 1;
                i2++;
            }
        } while (i3 < i2);
        return true;
    }

    public final void l0(String str) throws MalformedJsonException {
        StringBuilder sbW = b.w(str);
        sbW.append(x());
        throw new MalformedJsonException(sbW.toString());
    }

    public final double nextDouble() throws IOException, NumberFormatException {
        int iC = this.f53153h;
        if (iC == 0) {
            iC = c();
        }
        if (iC == 15) {
            this.f53153h = 0;
            int[] iArr = this.o;
            int i2 = this.f53158m - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.f53154i;
        }
        if (iC == 16) {
            this.f53156k = new String(this.f53148c, this.f53149d, this.f53155j);
            this.f53149d += this.f53155j;
        } else if (iC == 8 || iC == 9) {
            this.f53156k = O(iC == 8 ? '\'' : '\"');
        } else if (iC == 10) {
            this.f53156k = T();
        } else if (iC != 11) {
            throw new IllegalStateException("Expected a double but was " + peek() + x());
        }
        this.f53153h = 11;
        double d2 = Double.parseDouble(this.f53156k);
        if (!this.f53147b && (Double.isNaN(d2) || Double.isInfinite(d2))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + d2 + x());
        }
        this.f53156k = null;
        this.f53153h = 0;
        int[] iArr2 = this.o;
        int i3 = this.f53158m - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return d2;
    }

    public final int nextInt() throws IOException, NumberFormatException {
        int iC = this.f53153h;
        if (iC == 0) {
            iC = c();
        }
        if (iC == 15) {
            long j2 = this.f53154i;
            int i2 = (int) j2;
            if (j2 != i2) {
                throw new NumberFormatException("Expected an int but was " + this.f53154i + x());
            }
            this.f53153h = 0;
            int[] iArr = this.o;
            int i3 = this.f53158m - 1;
            iArr[i3] = iArr[i3] + 1;
            return i2;
        }
        if (iC == 16) {
            this.f53156k = new String(this.f53148c, this.f53149d, this.f53155j);
            this.f53149d += this.f53155j;
        } else {
            if (iC != 8 && iC != 9 && iC != 10) {
                throw new IllegalStateException("Expected an int but was " + peek() + x());
            }
            if (iC == 10) {
                this.f53156k = T();
            } else {
                this.f53156k = O(iC == 8 ? '\'' : '\"');
            }
            try {
                int i4 = Integer.parseInt(this.f53156k);
                this.f53153h = 0;
                int[] iArr2 = this.o;
                int i5 = this.f53158m - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return i4;
            } catch (NumberFormatException unused) {
            }
        }
        this.f53153h = 11;
        double d2 = Double.parseDouble(this.f53156k);
        int i6 = (int) d2;
        if (i6 != d2) {
            throw new NumberFormatException("Expected an int but was " + this.f53156k + x());
        }
        this.f53156k = null;
        this.f53153h = 0;
        int[] iArr3 = this.o;
        int i7 = this.f53158m - 1;
        iArr3[i7] = iArr3[i7] + 1;
        return i6;
    }

    public final long nextLong() throws IOException, NumberFormatException {
        int iC = this.f53153h;
        if (iC == 0) {
            iC = c();
        }
        if (iC == 15) {
            this.f53153h = 0;
            int[] iArr = this.o;
            int i2 = this.f53158m - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.f53154i;
        }
        if (iC == 16) {
            this.f53156k = new String(this.f53148c, this.f53149d, this.f53155j);
            this.f53149d += this.f53155j;
        } else {
            if (iC != 8 && iC != 9 && iC != 10) {
                throw new IllegalStateException("Expected a long but was " + peek() + x());
            }
            if (iC == 10) {
                this.f53156k = T();
            } else {
                this.f53156k = O(iC == 8 ? '\'' : '\"');
            }
            try {
                long j2 = Long.parseLong(this.f53156k);
                this.f53153h = 0;
                int[] iArr2 = this.o;
                int i3 = this.f53158m - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return j2;
            } catch (NumberFormatException unused) {
            }
        }
        this.f53153h = 11;
        double d2 = Double.parseDouble(this.f53156k);
        long j3 = (long) d2;
        if (j3 != d2) {
            throw new NumberFormatException("Expected a long but was " + this.f53156k + x());
        }
        this.f53156k = null;
        this.f53153h = 0;
        int[] iArr3 = this.o;
        int i4 = this.f53158m - 1;
        iArr3[i4] = iArr3[i4] + 1;
        return j3;
    }

    public final JsonToken peek() throws IOException {
        int iC = this.f53153h;
        if (iC == 0) {
            iC = c();
        }
        switch (iC) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final boolean r() throws IOException {
        int iC = this.f53153h;
        if (iC == 0) {
            iC = c();
        }
        return (iC == 2 || iC == 4) ? false : true;
    }

    public final boolean s(char c2) throws MalformedJsonException {
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
        b();
        return false;
    }

    public final void t() throws IOException {
        int iC = this.f53153h;
        if (iC == 0) {
            iC = c();
        }
        if (iC != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + peek() + x());
        }
        int i2 = this.f53158m;
        int i3 = i2 - 1;
        this.f53158m = i3;
        this.n[i3] = null;
        int[] iArr = this.o;
        int i4 = i2 - 2;
        iArr[i4] = iArr[i4] + 1;
        this.f53153h = 0;
    }

    public final String toString() {
        return getClass().getSimpleName() + x();
    }

    public final String x() {
        StringBuilder sbT = b.t(this.f53151f + 1, (this.f53149d - this.f53152g) + 1, " at line ", " column ", " path ");
        StringBuilder sb = new StringBuilder("$");
        int i2 = this.f53158m;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.f53157l[i3];
            if (i4 == 1 || i4 == 2) {
                sb.append('[');
                sb.append(this.o[i3]);
                sb.append(']');
            } else if (i4 == 3 || i4 == 4 || i4 == 5) {
                sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                String str = this.n[i3];
                if (str != null) {
                    sb.append(str);
                }
            }
        }
        sbT.append(sb.toString());
        return sbT.toString();
    }
}
