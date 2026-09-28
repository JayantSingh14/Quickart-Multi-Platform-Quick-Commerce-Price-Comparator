package com.google.gson.stream;

import android.support.v4.media.b;
import com.google.gson.JsonPrimitive;
import com.google.gson.Strictness;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.TroubleshootingGuide;
import com.google.gson.internal.bind.JsonTreeReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.ClassUtils;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes.dex */
public class JsonReader implements Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final Reader f45462a;

    /* renamed from: i, reason: collision with root package name */
    public long f45470i;

    /* renamed from: j, reason: collision with root package name */
    public int f45471j;

    /* renamed from: k, reason: collision with root package name */
    public String f45472k;

    /* renamed from: l, reason: collision with root package name */
    public int[] f45473l;
    public String[] n;
    public int[] o;

    /* renamed from: b, reason: collision with root package name */
    public Strictness f45463b = Strictness.f45266b;

    /* renamed from: c, reason: collision with root package name */
    public final char[] f45464c = new char[1024];

    /* renamed from: d, reason: collision with root package name */
    public int f45465d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f45466e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f45467f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f45468g = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f45469h = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f45474m = 1;

    /* renamed from: com.google.gson.stream.JsonReader$1, reason: invalid class name */
    public class AnonymousClass1 extends JsonReaderInternalAccess {
        @Override // com.google.gson.internal.JsonReaderInternalAccess
        public final void a(JsonReader jsonReader) throws IOException {
            if (jsonReader instanceof JsonTreeReader) {
                JsonTreeReader jsonTreeReader = (JsonTreeReader) jsonReader;
                jsonTreeReader.y0(JsonToken.f45479e);
                Map.Entry entry = (Map.Entry) ((Iterator) jsonTreeReader.c1()).next();
                jsonTreeReader.l1(entry.getValue());
                jsonTreeReader.l1(new JsonPrimitive((String) entry.getKey()));
                return;
            }
            int iC = jsonReader.f45469h;
            if (iC == 0) {
                iC = jsonReader.c();
            }
            if (iC == 13) {
                jsonReader.f45469h = 9;
            } else if (iC == 12) {
                jsonReader.f45469h = 8;
            } else {
                if (iC != 14) {
                    throw jsonReader.v0("a name");
                }
                jsonReader.f45469h = 10;
            }
        }
    }

    static {
        JsonReaderInternalAccess.f45306a = new AnonymousClass1();
    }

    public JsonReader(Reader reader) {
        int[] iArr = new int[32];
        this.f45473l = iArr;
        iArr[0] = 6;
        this.n = new String[32];
        this.o = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.f45462a = reader;
    }

    public final boolean A(char c2) throws MalformedJsonException {
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

    final String D() {
        StringBuilder sbT = b.t(this.f45467f + 1, (this.f45465d - this.f45468g) + 1, " at line ", " column ", " path ");
        sbT.append(j());
        return sbT.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void E() throws IOException {
        int i2 = 0;
        do {
            int iC = this.f45469h;
            if (iC == 0) {
                iC = c();
            }
            switch (iC) {
                case 1:
                    k0(3);
                    i2++;
                    this.f45469h = 0;
                    break;
                case 2:
                    if (i2 == 0) {
                        this.n[this.f45474m - 1] = null;
                    }
                    this.f45474m--;
                    i2--;
                    this.f45469h = 0;
                    break;
                case 3:
                    k0(1);
                    i2++;
                    this.f45469h = 0;
                    break;
                case 4:
                    this.f45474m--;
                    i2--;
                    this.f45469h = 0;
                    break;
                case 5:
                case 6:
                case 7:
                case 11:
                case 15:
                default:
                    this.f45469h = 0;
                    break;
                case 8:
                    r0('\'');
                    this.f45469h = 0;
                    break;
                case 9:
                    r0('\"');
                    this.f45469h = 0;
                    break;
                case 10:
                    t0();
                    this.f45469h = 0;
                    break;
                case 12:
                    r0('\'');
                    if (i2 == 0) {
                        this.n[this.f45474m - 1] = "<skipped>";
                    }
                    this.f45469h = 0;
                    break;
                case 13:
                    r0('\"');
                    if (i2 == 0) {
                        this.n[this.f45474m - 1] = "<skipped>";
                    }
                    this.f45469h = 0;
                    break;
                case 14:
                    t0();
                    if (i2 == 0) {
                        this.n[this.f45474m - 1] = "<skipped>";
                    }
                    this.f45469h = 0;
                    break;
                case 16:
                    this.f45465d += this.f45471j;
                    this.f45469h = 0;
                    break;
                case 17:
                    break;
            }
            return;
        } while (i2 > 0);
        int[] iArr = this.o;
        int i3 = this.f45474m - 1;
        iArr[i3] = iArr[i3] + 1;
    }

    public String K0() throws IOException {
        String str;
        int iC = this.f45469h;
        if (iC == 0) {
            iC = c();
        }
        if (iC == 10) {
            str = Z();
        } else if (iC == 8) {
            str = V('\'');
        } else if (iC == 9) {
            str = V('\"');
        } else if (iC == 11) {
            str = this.f45472k;
            this.f45472k = null;
        } else if (iC == 15) {
            str = Long.toString(this.f45470i);
        } else {
            if (iC != 16) {
                throw v0("a string");
            }
            str = new String(this.f45464c, this.f45465d, this.f45471j);
            this.f45465d += this.f45471j;
        }
        this.f45469h = 0;
        int[] iArr = this.o;
        int i2 = this.f45474m - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public boolean N() throws IOException {
        int iC = this.f45469h;
        if (iC == 0) {
            iC = c();
        }
        if (iC == 5) {
            this.f45469h = 0;
            int[] iArr = this.o;
            int i2 = this.f45474m - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        }
        if (iC != 6) {
            throw v0("a boolean");
        }
        this.f45469h = 0;
        int[] iArr2 = this.o;
        int i3 = this.f45474m - 1;
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
    public final int O(boolean r10) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.O(boolean):int");
    }

    public void T() throws IOException {
        int iC = this.f45469h;
        if (iC == 0) {
            iC = c();
        }
        if (iC != 7) {
            throw v0("null");
        }
        this.f45469h = 0;
        int[] iArr = this.o;
        int i2 = this.f45474m - 1;
        iArr[i2] = iArr[i2] + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x003e, code lost:
    
        r11.f45465d = r8;
        r8 = r8 - r3;
        r2 = r8 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0043, code lost:
    
        if (r1 != null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max(r8 * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006c, code lost:
    
        if (r1 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006e, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007c, code lost:
    
        r1.append(r5, r3, r2 - r3);
        r11.f45465d = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String V(char r12) throws com.google.gson.stream.MalformedJsonException {
        /*
            r11 = this;
            r0 = 0
            r1 = r0
        L2:
            int r2 = r11.f45465d
            int r3 = r11.f45466e
        L6:
            r4 = r3
            r3 = r2
        L8:
            char[] r5 = r11.f45464c
            r6 = 1
            r7 = 16
            if (r2 >= r4) goto L6c
            int r8 = r2 + 1
            char r2 = r5[r2]
            com.google.gson.Strictness r9 = r11.f45463b
            com.google.gson.Strictness r10 = com.google.gson.Strictness.f45267c
            if (r9 != r10) goto L24
            r9 = 32
            if (r2 < r9) goto L1e
            goto L24
        L1e:
            java.lang.String r12 = "Unescaped control characters (\\u0000-\\u001F) are not allowed in strict mode"
            r11.u0(r12)
            throw r0
        L24:
            if (r2 != r12) goto L3a
            r11.f45465d = r8
            int r8 = r8 - r3
            int r8 = r8 - r6
            if (r1 != 0) goto L32
            java.lang.String r12 = new java.lang.String
            r12.<init>(r5, r3, r8)
            return r12
        L32:
            r1.append(r5, r3, r8)
            java.lang.String r12 = r1.toString()
            return r12
        L3a:
            r9 = 92
            if (r2 != r9) goto L5f
            r11.f45465d = r8
            int r8 = r8 - r3
            int r2 = r8 + (-1)
            if (r1 != 0) goto L50
            int r8 = r8 * 2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r4 = java.lang.Math.max(r8, r7)
            r1.<init>(r4)
        L50:
            r1.append(r5, r3, r2)
            char r2 = r11.l0()
            r1.append(r2)
            int r2 = r11.f45465d
            int r3 = r11.f45466e
            goto L6
        L5f:
            r5 = 10
            if (r2 != r5) goto L6a
            int r2 = r11.f45467f
            int r2 = r2 + r6
            r11.f45467f = r2
            r11.f45468g = r8
        L6a:
            r2 = r8
            goto L8
        L6c:
            if (r1 != 0) goto L7c
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r7)
            r4.<init>(r1)
            r1 = r4
        L7c:
            int r4 = r2 - r3
            r1.append(r5, r3, r4)
            r11.f45465d = r2
            boolean r2 = r11.l(r6)
            if (r2 == 0) goto L8b
            goto L2
        L8b:
            java.lang.String r12 = "Unterminated string"
            r11.u0(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.V(char):java.lang.String");
    }

    public String X() throws IOException {
        String strV;
        int iC = this.f45469h;
        if (iC == 0) {
            iC = c();
        }
        if (iC == 14) {
            strV = Z();
        } else if (iC == 12) {
            strV = V('\'');
        } else {
            if (iC != 13) {
                throw v0("a name");
            }
            strV = V('\"');
        }
        this.f45469h = 0;
        this.n[this.f45474m - 1] = strV;
        return strV;
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
    public final java.lang.String Z() throws com.google.gson.stream.MalformedJsonException {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = r1
        L3:
            int r3 = r7.f45465d
            int r4 = r3 + r2
            int r5 = r7.f45466e
            char[] r6 = r7.f45464c
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
            int r3 = r7.f45465d
            r0.append(r6, r3, r2)
            int r3 = r7.f45465d
            int r3 = r3 + r2
            r7.f45465d = r3
            r2 = 1
            boolean r2 = r7.l(r2)
            if (r2 != 0) goto L2
        L7a:
            if (r0 != 0) goto L84
            java.lang.String r0 = new java.lang.String
            int r2 = r7.f45465d
            r0.<init>(r6, r2, r1)
            goto L8d
        L84:
            int r2 = r7.f45465d
            r0.append(r6, r2, r1)
            java.lang.String r0 = r0.toString()
        L8d:
            int r2 = r7.f45465d
            int r2 = r2 + r1
            r7.f45465d = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.Z():java.lang.String");
    }

    public void a() throws IOException {
        int iC = this.f45469h;
        if (iC == 0) {
            iC = c();
        }
        if (iC != 3) {
            throw v0("BEGIN_ARRAY");
        }
        k0(1);
        this.o[this.f45474m - 1] = 0;
        this.f45469h = 0;
    }

    public final void b() throws MalformedJsonException {
        if (this.f45463b == Strictness.f45265a) {
            return;
        }
        u0("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:169:0x021c, code lost:
    
        if (A(r7) != false) goto L125;
     */
    /* JADX WARN: Removed duplicated region for block: B:119:0x018c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0274 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int c() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 796
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.c():int");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f45469h = 0;
        this.f45473l[0] = 8;
        this.f45474m = 1;
        this.f45462a.close();
    }

    public void e() throws IOException {
        int iC = this.f45469h;
        if (iC == 0) {
            iC = c();
        }
        if (iC != 4) {
            throw v0("END_ARRAY");
        }
        int i2 = this.f45474m;
        this.f45474m = i2 - 1;
        int[] iArr = this.o;
        int i3 = i2 - 2;
        iArr[i3] = iArr[i3] + 1;
        this.f45469h = 0;
    }

    public String j() {
        return r(false);
    }

    public JsonToken j0() throws IOException {
        int iC = this.f45469h;
        if (iC == 0) {
            iC = c();
        }
        switch (iC) {
            case 1:
                return JsonToken.f45477c;
            case 2:
                return JsonToken.f45478d;
            case 3:
                return JsonToken.f45475a;
            case 4:
                return JsonToken.f45476b;
            case 5:
            case 6:
                return JsonToken.f45482h;
            case 7:
                return JsonToken.f45483i;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.f45480f;
            case 12:
            case 13:
            case 14:
                return JsonToken.f45479e;
            case 15:
            case 16:
                return JsonToken.f45481g;
            case 17:
                return JsonToken.f45484j;
            default:
                throw new AssertionError();
        }
    }

    public void k() throws IOException {
        int iC = this.f45469h;
        if (iC == 0) {
            iC = c();
        }
        if (iC != 1) {
            throw v0("BEGIN_OBJECT");
        }
        k0(3);
        this.f45469h = 0;
    }

    public final void k0(int i2) {
        int i3 = this.f45474m;
        int[] iArr = this.f45473l;
        if (i3 == iArr.length) {
            int i4 = i3 * 2;
            this.f45473l = Arrays.copyOf(iArr, i4);
            this.o = Arrays.copyOf(this.o, i4);
            this.n = (String[]) Arrays.copyOf(this.n, i4);
        }
        int[] iArr2 = this.f45473l;
        int i5 = this.f45474m;
        this.f45474m = i5 + 1;
        iArr2[i5] = i2;
    }

    public final boolean l(int i2) throws IOException {
        int i3;
        int i4;
        int i5 = this.f45468g;
        int i6 = this.f45465d;
        this.f45468g = i5 - i6;
        int i7 = this.f45466e;
        char[] cArr = this.f45464c;
        if (i7 != i6) {
            int i8 = i7 - i6;
            this.f45466e = i8;
            System.arraycopy(cArr, i6, cArr, 0, i8);
        } else {
            this.f45466e = 0;
        }
        this.f45465d = 0;
        do {
            int i9 = this.f45466e;
            int i10 = this.f45462a.read(cArr, i9, cArr.length - i9);
            if (i10 == -1) {
                return false;
            }
            i3 = this.f45466e + i10;
            this.f45466e = i3;
            if (this.f45467f == 0 && (i4 = this.f45468g) == 0 && i3 > 0 && cArr[0] == 65279) {
                this.f45465d++;
                this.f45468g = i4 + 1;
                i2++;
            }
        } while (i3 < i2);
        return true;
    }

    public final char l0() throws MalformedJsonException {
        int i2;
        if (this.f45465d == this.f45466e && !l(1)) {
            u0("Unterminated escape sequence");
            throw null;
        }
        int i3 = this.f45465d;
        int i4 = i3 + 1;
        this.f45465d = i4;
        char[] cArr = this.f45464c;
        char c2 = cArr[i3];
        Strictness strictness = Strictness.f45267c;
        if (c2 != '\n') {
            if (c2 != '\"') {
                if (c2 != '\'') {
                    if (c2 != '/' && c2 != '\\') {
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
                            u0("Invalid escape sequence");
                            throw null;
                        }
                        if (i3 + 5 > this.f45466e && !l(4)) {
                            u0("Unterminated escape sequence");
                            throw null;
                        }
                        int i5 = this.f45465d;
                        int i6 = i5 + 4;
                        int i7 = 0;
                        while (i5 < i6) {
                            char c3 = cArr[i5];
                            int i8 = i7 << 4;
                            if (c3 >= '0' && c3 <= '9') {
                                i2 = c3 - '0';
                            } else if (c3 >= 'a' && c3 <= 'f') {
                                i2 = c3 - 'W';
                            } else {
                                if (c3 < 'A' || c3 > 'F') {
                                    u0("Malformed Unicode escape \\u".concat(new String(cArr, this.f45465d, 4)));
                                    throw null;
                                }
                                i2 = c3 - '7';
                            }
                            i7 = i2 + i8;
                            i5++;
                        }
                        this.f45465d += 4;
                        return (char) i7;
                    }
                }
            }
            return c2;
        }
        if (this.f45463b == strictness) {
            u0("Cannot escape a newline character in strict mode");
            throw null;
        }
        this.f45467f++;
        this.f45468g = i4;
        if (this.f45463b == strictness) {
            u0("Invalid escaped character \"'\" in strict mode");
            throw null;
        }
        return c2;
    }

    public final void n0(Strictness strictness) {
        Objects.requireNonNull(strictness);
        this.f45463b = strictness;
    }

    public double nextDouble() throws IOException, NumberFormatException {
        int iC = this.f45469h;
        if (iC == 0) {
            iC = c();
        }
        if (iC == 15) {
            this.f45469h = 0;
            int[] iArr = this.o;
            int i2 = this.f45474m - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.f45470i;
        }
        if (iC == 16) {
            this.f45472k = new String(this.f45464c, this.f45465d, this.f45471j);
            this.f45465d += this.f45471j;
        } else if (iC == 8 || iC == 9) {
            this.f45472k = V(iC == 8 ? '\'' : '\"');
        } else if (iC == 10) {
            this.f45472k = Z();
        } else if (iC != 11) {
            throw v0("a double");
        }
        this.f45469h = 11;
        double d2 = Double.parseDouble(this.f45472k);
        if (this.f45463b != Strictness.f45265a && (Double.isNaN(d2) || Double.isInfinite(d2))) {
            u0("JSON forbids NaN and infinities: " + d2);
            throw null;
        }
        this.f45472k = null;
        this.f45469h = 0;
        int[] iArr2 = this.o;
        int i3 = this.f45474m - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return d2;
    }

    public int nextInt() throws IOException, NumberFormatException {
        int iC = this.f45469h;
        if (iC == 0) {
            iC = c();
        }
        if (iC == 15) {
            long j2 = this.f45470i;
            int i2 = (int) j2;
            if (j2 != i2) {
                throw new NumberFormatException("Expected an int but was " + this.f45470i + D());
            }
            this.f45469h = 0;
            int[] iArr = this.o;
            int i3 = this.f45474m - 1;
            iArr[i3] = iArr[i3] + 1;
            return i2;
        }
        if (iC == 16) {
            this.f45472k = new String(this.f45464c, this.f45465d, this.f45471j);
            this.f45465d += this.f45471j;
        } else {
            if (iC != 8 && iC != 9 && iC != 10) {
                throw v0("an int");
            }
            if (iC == 10) {
                this.f45472k = Z();
            } else {
                this.f45472k = V(iC == 8 ? '\'' : '\"');
            }
            try {
                int i4 = Integer.parseInt(this.f45472k);
                this.f45469h = 0;
                int[] iArr2 = this.o;
                int i5 = this.f45474m - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return i4;
            } catch (NumberFormatException unused) {
            }
        }
        this.f45469h = 11;
        double d2 = Double.parseDouble(this.f45472k);
        int i6 = (int) d2;
        if (i6 != d2) {
            throw new NumberFormatException("Expected an int but was " + this.f45472k + D());
        }
        this.f45472k = null;
        this.f45469h = 0;
        int[] iArr3 = this.o;
        int i7 = this.f45474m - 1;
        iArr3[i7] = iArr3[i7] + 1;
        return i6;
    }

    public long nextLong() throws IOException, NumberFormatException {
        int iC = this.f45469h;
        if (iC == 0) {
            iC = c();
        }
        if (iC == 15) {
            this.f45469h = 0;
            int[] iArr = this.o;
            int i2 = this.f45474m - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.f45470i;
        }
        if (iC == 16) {
            this.f45472k = new String(this.f45464c, this.f45465d, this.f45471j);
            this.f45465d += this.f45471j;
        } else {
            if (iC != 8 && iC != 9 && iC != 10) {
                throw v0("a long");
            }
            if (iC == 10) {
                this.f45472k = Z();
            } else {
                this.f45472k = V(iC == 8 ? '\'' : '\"');
            }
            try {
                long j2 = Long.parseLong(this.f45472k);
                this.f45469h = 0;
                int[] iArr2 = this.o;
                int i3 = this.f45474m - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return j2;
            } catch (NumberFormatException unused) {
            }
        }
        this.f45469h = 11;
        double d2 = Double.parseDouble(this.f45472k);
        long j3 = (long) d2;
        if (j3 != d2) {
            throw new NumberFormatException("Expected a long but was " + this.f45472k + D());
        }
        this.f45472k = null;
        this.f45469h = 0;
        int[] iArr3 = this.o;
        int i4 = this.f45474m - 1;
        iArr3[i4] = iArr3[i4] + 1;
        return j3;
    }

    public final String r(boolean z) {
        StringBuilder sb = new StringBuilder("$");
        int i2 = 0;
        while (true) {
            int i3 = this.f45474m;
            if (i2 >= i3) {
                return sb.toString();
            }
            int i4 = this.f45473l[i2];
            switch (i4) {
                case 1:
                case 2:
                    int i5 = this.o[i2];
                    if (z && i5 > 0 && i2 == i3 - 1) {
                        i5--;
                    }
                    sb.append('[');
                    sb.append(i5);
                    sb.append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                    String str = this.n[i2];
                    if (str == null) {
                        break;
                    } else {
                        sb.append(str);
                        break;
                    }
                case 6:
                case 7:
                case 8:
                    break;
                default:
                    throw new AssertionError(b.f(i4, "Unknown scope value: "));
            }
            i2++;
        }
    }

    public final void r0(char c2) throws MalformedJsonException {
        do {
            int i2 = this.f45465d;
            int i3 = this.f45466e;
            while (i2 < i3) {
                int i4 = i2 + 1;
                char c3 = this.f45464c[i2];
                if (c3 == c2) {
                    this.f45465d = i4;
                    return;
                }
                if (c3 == '\\') {
                    this.f45465d = i4;
                    l0();
                    i2 = this.f45465d;
                    i3 = this.f45466e;
                } else {
                    if (c3 == '\n') {
                        this.f45467f++;
                        this.f45468g = i4;
                    }
                    i2 = i4;
                }
            }
            this.f45465d = i2;
        } while (l(1));
        u0("Unterminated string");
        throw null;
    }

    public String s() {
        return r(true);
    }

    public final void s0() {
        char c2;
        do {
            if (this.f45465d >= this.f45466e && !l(1)) {
                return;
            }
            int i2 = this.f45465d;
            int i3 = i2 + 1;
            this.f45465d = i3;
            c2 = this.f45464c[i2];
            if (c2 == '\n') {
                this.f45467f++;
                this.f45468g = i3;
                return;
            }
        } while (c2 != '\r');
    }

    public void t() throws IOException {
        int iC = this.f45469h;
        if (iC == 0) {
            iC = c();
        }
        if (iC != 2) {
            throw v0("END_OBJECT");
        }
        int i2 = this.f45474m;
        int i3 = i2 - 1;
        this.f45474m = i3;
        this.n[i3] = null;
        int[] iArr = this.o;
        int i4 = i2 - 2;
        iArr[i4] = iArr[i4] + 1;
        this.f45469h = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
    
        b();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t0() throws com.google.gson.stream.MalformedJsonException {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.f45465d
            int r2 = r1 + r0
            int r3 = r4.f45466e
            if (r2 >= r3) goto L51
            char[] r2 = r4.f45464c
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L4b
            r2 = 10
            if (r1 == r2) goto L4b
            r2 = 12
            if (r1 == r2) goto L4b
            r2 = 13
            if (r1 == r2) goto L4b
            r2 = 32
            if (r1 == r2) goto L4b
            r2 = 35
            if (r1 == r2) goto L48
            r2 = 44
            if (r1 == r2) goto L4b
            r2 = 47
            if (r1 == r2) goto L48
            r2 = 61
            if (r1 == r2) goto L48
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L4b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L4b
            r2 = 58
            if (r1 == r2) goto L4b
            r2 = 59
            if (r1 == r2) goto L48
            switch(r1) {
                case 91: goto L4b;
                case 92: goto L48;
                case 93: goto L4b;
                default: goto L45;
            }
        L45:
            int r0 = r0 + 1
            goto L1
        L48:
            r4.b()
        L4b:
            int r1 = r4.f45465d
            int r1 = r1 + r0
            r4.f45465d = r1
            return
        L51:
            int r1 = r1 + r0
            r4.f45465d = r1
            r0 = 1
            boolean r0 = r4.l(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.t0():void");
    }

    public String toString() {
        return getClass().getSimpleName() + D();
    }

    public final void u0(String str) throws MalformedJsonException {
        StringBuilder sbW = b.w(str);
        sbW.append(D());
        sbW.append("\nSee ");
        sbW.append(TroubleshootingGuide.a("malformed-json"));
        throw new MalformedJsonException(sbW.toString());
    }

    public final IllegalStateException v0(String str) {
        String str2 = j0() == JsonToken.f45483i ? "adapter-not-null-safe" : "unexpected-json-structure";
        StringBuilder sbY = b.y("Expected ", str, " but was ");
        sbY.append(j0());
        sbY.append(D());
        sbY.append("\nSee ");
        sbY.append(TroubleshootingGuide.a(str2));
        return new IllegalStateException(sbY.toString());
    }

    public boolean x() throws IOException {
        int iC = this.f45469h;
        if (iC == 0) {
            iC = c();
        }
        return (iC == 2 || iC == 4 || iC == 17) ? false : true;
    }
}
