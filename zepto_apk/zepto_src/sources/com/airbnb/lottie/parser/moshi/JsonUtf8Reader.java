package com.airbnb.lottie.parser.moshi;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.EOFException;
import kotlin.text.Charsets;
import okio.Buffer;
import okio.ByteString;
import okio.RealBufferedSource;
import org.apache.commons.lang3.CharUtils;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes3.dex */
final class JsonUtf8Reader extends JsonReader {

    /* renamed from: l, reason: collision with root package name */
    public static final ByteString f14764l;

    /* renamed from: m, reason: collision with root package name */
    public static final ByteString f14765m;
    public static final ByteString n;

    /* renamed from: f, reason: collision with root package name */
    public final RealBufferedSource f14766f;

    /* renamed from: g, reason: collision with root package name */
    public final Buffer f14767g;

    /* renamed from: h, reason: collision with root package name */
    public int f14768h;

    /* renamed from: i, reason: collision with root package name */
    public long f14769i;

    /* renamed from: j, reason: collision with root package name */
    public int f14770j;

    /* renamed from: k, reason: collision with root package name */
    public String f14771k;

    static {
        ByteString byteString = ByteString.f56924d;
        f14764l = ByteString.Companion.c("'\\");
        f14765m = ByteString.Companion.c("\"\\");
        n = ByteString.Companion.c("{}[]:, \n\t\r\f/\\;#=");
        ByteString.Companion.c("\n\r");
        ByteString.Companion.c("*/");
    }

    public JsonUtf8Reader(RealBufferedSource realBufferedSource) {
        this.f14748b = new int[32];
        this.f14749c = new String[32];
        this.f14750d = new int[32];
        this.f14768h = 0;
        this.f14766f = realBufferedSource;
        this.f14767g = realBufferedSource.f56985b;
        s(6);
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public final void A() throws JsonEncodingException, EOFException {
        int iO = this.f14768h;
        if (iO == 0) {
            iO = O();
        }
        if (iO == 14) {
            long jC = this.f14766f.c(n);
            Buffer buffer = this.f14767g;
            if (jC == -1) {
                jC = buffer.f56914b;
            }
            buffer.j1(jC);
        } else if (iO == 13) {
            n0(f14765m);
        } else if (iO == 12) {
            n0(f14764l);
        } else if (iO != 15) {
            throw new JsonDataException("Expected a name but was " + r() + " at path " + j());
        }
        this.f14768h = 0;
        this.f14749c[this.f14747a - 1] = "null";
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public final void E() throws JsonEncodingException, EOFException {
        int i2 = 0;
        do {
            int iO = this.f14768h;
            if (iO == 0) {
                iO = O();
            }
            if (iO == 3) {
                s(1);
            } else if (iO == 1) {
                s(3);
            } else {
                if (iO == 4) {
                    i2--;
                    if (i2 < 0) {
                        throw new JsonDataException("Expected a value but was " + r() + " at path " + j());
                    }
                    this.f14747a--;
                } else if (iO == 2) {
                    i2--;
                    if (i2 < 0) {
                        throw new JsonDataException("Expected a value but was " + r() + " at path " + j());
                    }
                    this.f14747a--;
                } else {
                    Buffer buffer = this.f14767g;
                    if (iO == 14 || iO == 10) {
                        long jC = this.f14766f.c(n);
                        if (jC == -1) {
                            jC = buffer.f56914b;
                        }
                        buffer.j1(jC);
                    } else if (iO == 9 || iO == 13) {
                        n0(f14765m);
                    } else if (iO == 8 || iO == 12) {
                        n0(f14764l);
                    } else if (iO == 17) {
                        buffer.j1(this.f14770j);
                    } else if (iO == 18) {
                        throw new JsonDataException("Expected a value but was " + r() + " at path " + j());
                    }
                }
                this.f14768h = 0;
            }
            i2++;
            this.f14768h = 0;
        } while (i2 != 0);
        int[] iArr = this.f14750d;
        int i3 = this.f14747a - 1;
        iArr[i3] = iArr[i3] + 1;
        this.f14749c[i3] = "null";
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public final String K0() throws JsonEncodingException, EOFException {
        String strT0;
        int iO = this.f14768h;
        if (iO == 0) {
            iO = O();
        }
        if (iO == 10) {
            strT0 = k0();
        } else if (iO == 9) {
            strT0 = j0(f14765m);
        } else if (iO == 8) {
            strT0 = j0(f14764l);
        } else if (iO == 11) {
            strT0 = this.f14771k;
            this.f14771k = null;
        } else if (iO == 16) {
            strT0 = Long.toString(this.f14769i);
        } else {
            if (iO != 17) {
                throw new JsonDataException("Expected a string but was " + r() + " at path " + j());
            }
            long j2 = this.f14770j;
            Buffer buffer = this.f14767g;
            buffer.getClass();
            strT0 = buffer.T0(j2, Charsets.UTF_8);
        }
        this.f14768h = 0;
        int[] iArr = this.f14750d;
        int i2 = this.f14747a - 1;
        iArr[i2] = iArr[i2] + 1;
        return strT0;
    }

    public final void N() throws JsonEncodingException {
        D("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:135:0x0195, code lost:
    
        if (V(r10) != false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0197, code lost:
    
        if (r1 != 2) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0199, code lost:
    
        if (r4 == false) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x019f, code lost:
    
        if (r12 != Long.MIN_VALUE) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x01a1, code lost:
    
        if (r9 == false) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x01a5, code lost:
    
        if (r12 != r17) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x01a7, code lost:
    
        if (r9 != false) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x01a9, code lost:
    
        if (r9 == false) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x01ac, code lost:
    
        r12 = -r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x01ad, code lost:
    
        r22.f14769i = r12;
        r7.j1(r2);
        r9 = 16;
        r22.f14768h = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x01b8, code lost:
    
        if (r1 == 2) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x01bb, code lost:
    
        if (r1 == 4) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x01be, code lost:
    
        if (r1 != 7) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x01c0, code lost:
    
        r22.f14770j = r2;
        r9 = 17;
        r22.f14768h = 17;
     */
    /* JADX WARN: Removed duplicated region for block: B:172:0x01ed A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0115 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int O() throws com.airbnb.lottie.parser.moshi.JsonEncodingException, java.io.EOFException {
        /*
            Method dump skipped, instructions count: 652
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.JsonUtf8Reader.O():int");
    }

    public final int T(String str, JsonReader.Options options) {
        int length = options.f14751a.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(options.f14751a[i2])) {
                this.f14768h = 0;
                this.f14749c[this.f14747a - 1] = str;
                return i2;
            }
        }
        return -1;
    }

    public final boolean V(int i2) throws JsonEncodingException {
        if (i2 == 9 || i2 == 10 || i2 == 12 || i2 == 13 || i2 == 32) {
            return false;
        }
        if (i2 != 35) {
            if (i2 == 44) {
                return false;
            }
            if (i2 != 47 && i2 != 61) {
                if (i2 == 123 || i2 == 125 || i2 == 58) {
                    return false;
                }
                if (i2 != 59) {
                    switch (i2) {
                        case WKSRecord.Service.MIT_DOV /* 91 */:
                        case WKSRecord.Service.DCP /* 93 */:
                            return false;
                        case 92:
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

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public final String X() throws JsonEncodingException, EOFException {
        String strJ0;
        int iO = this.f14768h;
        if (iO == 0) {
            iO = O();
        }
        if (iO == 14) {
            strJ0 = k0();
        } else if (iO == 13) {
            strJ0 = j0(f14765m);
        } else if (iO == 12) {
            strJ0 = j0(f14764l);
        } else {
            if (iO != 15) {
                throw new JsonDataException("Expected a name but was " + r() + " at path " + j());
            }
            strJ0 = this.f14771k;
        }
        this.f14768h = 0;
        this.f14749c[this.f14747a - 1] = strJ0;
        return strJ0;
    }

    public final int Z(boolean z) throws JsonEncodingException, EOFException {
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            RealBufferedSource realBufferedSource = this.f14766f;
            if (!realBufferedSource.h0(i3)) {
                if (z) {
                    throw new EOFException("End of input");
                }
                return -1;
            }
            long j2 = i2;
            Buffer buffer = this.f14767g;
            byte bX = buffer.x(j2);
            if (bX != 10 && bX != 32 && bX != 13 && bX != 9) {
                buffer.j1(j2);
                if (bX == 47) {
                    if (realBufferedSource.h0(2L)) {
                        N();
                        throw null;
                    }
                } else if (bX == 35) {
                    N();
                    throw null;
                }
                return bX;
            }
            i2 = i3;
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public final void a() throws JsonEncodingException, EOFException {
        int iO = this.f14768h;
        if (iO == 0) {
            iO = O();
        }
        if (iO == 3) {
            s(1);
            this.f14750d[this.f14747a - 1] = 0;
            this.f14768h = 0;
        } else {
            throw new JsonDataException("Expected BEGIN_ARRAY but was " + r() + " at path " + j());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public final void b() throws JsonEncodingException, EOFException {
        int iO = this.f14768h;
        if (iO == 0) {
            iO = O();
        }
        if (iO != 4) {
            throw new JsonDataException("Expected END_ARRAY but was " + r() + " at path " + j());
        }
        int i2 = this.f14747a;
        this.f14747a = i2 - 1;
        int[] iArr = this.f14750d;
        int i3 = i2 - 2;
        iArr[i3] = iArr[i3] + 1;
        this.f14768h = 0;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public final boolean c() throws JsonEncodingException, EOFException {
        int iO = this.f14768h;
        if (iO == 0) {
            iO = O();
        }
        return (iO == 2 || iO == 4 || iO == 18) ? false : true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f14768h = 0;
        this.f14748b[0] = 8;
        this.f14747a = 1;
        this.f14767g.a();
        this.f14766f.close();
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public final boolean e() throws JsonEncodingException, EOFException {
        int iO = this.f14768h;
        if (iO == 0) {
            iO = O();
        }
        if (iO == 5) {
            this.f14768h = 0;
            int[] iArr = this.f14750d;
            int i2 = this.f14747a - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        }
        if (iO == 6) {
            this.f14768h = 0;
            int[] iArr2 = this.f14750d;
            int i3 = this.f14747a - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        }
        throw new JsonDataException("Expected a boolean but was " + r() + " at path " + j());
    }

    public final String j0(ByteString byteString) throws JsonEncodingException {
        StringBuilder sb = null;
        while (true) {
            long jC = this.f14766f.c(byteString);
            if (jC == -1) {
                D("Unterminated string");
                throw null;
            }
            Buffer buffer = this.f14767g;
            if (buffer.x(jC) != 92) {
                if (sb == null) {
                    String strT0 = buffer.T0(jC, Charsets.UTF_8);
                    buffer.k0();
                    return strT0;
                }
                sb.append(buffer.T0(jC, Charsets.UTF_8));
                buffer.k0();
                return sb.toString();
            }
            if (sb == null) {
                sb = new StringBuilder();
            }
            sb.append(buffer.T0(jC, Charsets.UTF_8));
            buffer.k0();
            sb.append(l0());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public final void k() throws JsonEncodingException, EOFException {
        int iO = this.f14768h;
        if (iO == 0) {
            iO = O();
        }
        if (iO == 1) {
            s(3);
            this.f14768h = 0;
        } else {
            throw new JsonDataException("Expected BEGIN_OBJECT but was " + r() + " at path " + j());
        }
    }

    public final String k0() {
        long jC = this.f14766f.c(n);
        Buffer buffer = this.f14767g;
        if (jC == -1) {
            return buffer.A1();
        }
        buffer.getClass();
        return buffer.T0(jC, Charsets.UTF_8);
    }

    public final char l0() throws JsonEncodingException, EOFException {
        int i2;
        RealBufferedSource realBufferedSource = this.f14766f;
        if (!realBufferedSource.h0(1L)) {
            D("Unterminated escape sequence");
            throw null;
        }
        Buffer buffer = this.f14767g;
        byte bK0 = buffer.k0();
        if (bK0 == 10 || bK0 == 34 || bK0 == 39 || bK0 == 47 || bK0 == 92) {
            return (char) bK0;
        }
        if (bK0 == 98) {
            return '\b';
        }
        if (bK0 == 102) {
            return '\f';
        }
        if (bK0 == 110) {
            return '\n';
        }
        if (bK0 == 114) {
            return CharUtils.CR;
        }
        if (bK0 == 116) {
            return '\t';
        }
        if (bK0 != 117) {
            D("Invalid escape sequence: \\" + ((char) bK0));
            throw null;
        }
        if (!realBufferedSource.h0(4L)) {
            throw new EOFException("Unterminated escape sequence at path " + j());
        }
        char c2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            byte bX = buffer.x(i3);
            char c3 = (char) (c2 << 4);
            if (bX >= 48 && bX <= 57) {
                i2 = bX - 48;
            } else if (bX >= 97 && bX <= 102) {
                i2 = bX - 87;
            } else {
                if (bX < 65 || bX > 70) {
                    D("\\u".concat(buffer.T0(4L, Charsets.UTF_8)));
                    throw null;
                }
                i2 = bX - 55;
            }
            c2 = (char) (i2 + c3);
        }
        buffer.j1(4L);
        return c2;
    }

    public final void n0(ByteString byteString) throws JsonEncodingException, EOFException {
        while (true) {
            long jC = this.f14766f.c(byteString);
            if (jC == -1) {
                D("Unterminated string");
                throw null;
            }
            Buffer buffer = this.f14767g;
            if (buffer.x(jC) != 92) {
                buffer.j1(jC + 1);
                return;
            } else {
                buffer.j1(jC + 1);
                l0();
            }
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public final double nextDouble() throws JsonEncodingException, NumberFormatException, EOFException {
        int iO = this.f14768h;
        if (iO == 0) {
            iO = O();
        }
        if (iO == 16) {
            this.f14768h = 0;
            int[] iArr = this.f14750d;
            int i2 = this.f14747a - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.f14769i;
        }
        if (iO == 17) {
            long j2 = this.f14770j;
            Buffer buffer = this.f14767g;
            buffer.getClass();
            this.f14771k = buffer.T0(j2, Charsets.UTF_8);
        } else if (iO == 9) {
            this.f14771k = j0(f14765m);
        } else if (iO == 8) {
            this.f14771k = j0(f14764l);
        } else if (iO == 10) {
            this.f14771k = k0();
        } else if (iO != 11) {
            throw new JsonDataException("Expected a double but was " + r() + " at path " + j());
        }
        this.f14768h = 11;
        try {
            double d2 = Double.parseDouble(this.f14771k);
            if (Double.isNaN(d2) || Double.isInfinite(d2)) {
                throw new JsonEncodingException("JSON forbids NaN and infinities: " + d2 + " at path " + j());
            }
            this.f14771k = null;
            this.f14768h = 0;
            int[] iArr2 = this.f14750d;
            int i3 = this.f14747a - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return d2;
        } catch (NumberFormatException unused) {
            throw new JsonDataException("Expected a double but was " + this.f14771k + " at path " + j());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public final int nextInt() throws JsonEncodingException, NumberFormatException, EOFException {
        int iO = this.f14768h;
        if (iO == 0) {
            iO = O();
        }
        if (iO == 16) {
            long j2 = this.f14769i;
            int i2 = (int) j2;
            if (j2 == i2) {
                this.f14768h = 0;
                int[] iArr = this.f14750d;
                int i3 = this.f14747a - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
            throw new JsonDataException("Expected an int but was " + this.f14769i + " at path " + j());
        }
        if (iO == 17) {
            long j3 = this.f14770j;
            Buffer buffer = this.f14767g;
            buffer.getClass();
            this.f14771k = buffer.T0(j3, Charsets.UTF_8);
        } else if (iO == 9 || iO == 8) {
            String strJ0 = iO == 9 ? j0(f14765m) : j0(f14764l);
            this.f14771k = strJ0;
            try {
                int i4 = Integer.parseInt(strJ0);
                this.f14768h = 0;
                int[] iArr2 = this.f14750d;
                int i5 = this.f14747a - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return i4;
            } catch (NumberFormatException unused) {
            }
        } else if (iO != 11) {
            throw new JsonDataException("Expected an int but was " + r() + " at path " + j());
        }
        this.f14768h = 11;
        try {
            double d2 = Double.parseDouble(this.f14771k);
            int i6 = (int) d2;
            if (i6 != d2) {
                throw new JsonDataException("Expected an int but was " + this.f14771k + " at path " + j());
            }
            this.f14771k = null;
            this.f14768h = 0;
            int[] iArr3 = this.f14750d;
            int i7 = this.f14747a - 1;
            iArr3[i7] = iArr3[i7] + 1;
            return i6;
        } catch (NumberFormatException unused2) {
            throw new JsonDataException("Expected an int but was " + this.f14771k + " at path " + j());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public final JsonReader.Token r() throws JsonEncodingException, EOFException {
        int iO = this.f14768h;
        if (iO == 0) {
            iO = O();
        }
        switch (iO) {
            case 1:
                return JsonReader.Token.f14755c;
            case 2:
                return JsonReader.Token.f14756d;
            case 3:
                return JsonReader.Token.f14753a;
            case 4:
                return JsonReader.Token.f14754b;
            case 5:
            case 6:
                return JsonReader.Token.f14760h;
            case 7:
                return JsonReader.Token.f14761i;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonReader.Token.f14758f;
            case 12:
            case 13:
            case 14:
            case 15:
                return JsonReader.Token.f14757e;
            case 16:
            case 17:
                return JsonReader.Token.f14759g;
            case 18:
                return JsonReader.Token.f14762j;
            default:
                throw new AssertionError();
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public final void t() throws JsonEncodingException, EOFException {
        int iO = this.f14768h;
        if (iO == 0) {
            iO = O();
        }
        if (iO != 2) {
            throw new JsonDataException("Expected END_OBJECT but was " + r() + " at path " + j());
        }
        int i2 = this.f14747a;
        int i3 = i2 - 1;
        this.f14747a = i3;
        this.f14749c[i3] = null;
        int[] iArr = this.f14750d;
        int i4 = i2 - 2;
        iArr[i4] = iArr[i4] + 1;
        this.f14768h = 0;
    }

    public final String toString() {
        return "JsonReader(" + this.f14766f + ")";
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public final int x(JsonReader.Options options) throws JsonEncodingException, EOFException {
        int iO = this.f14768h;
        if (iO == 0) {
            iO = O();
        }
        if (iO < 12 || iO > 15) {
            return -1;
        }
        if (iO == 15) {
            return T(this.f14771k, options);
        }
        int iR1 = this.f14766f.R1(options.f14752b);
        if (iR1 != -1) {
            this.f14768h = 0;
            this.f14749c[this.f14747a - 1] = options.f14751a[iR1];
            return iR1;
        }
        String str = this.f14749c[this.f14747a - 1];
        String strX = X();
        int iT = T(strX, options);
        if (iT == -1) {
            this.f14768h = 15;
            this.f14771k = strX;
            this.f14749c[this.f14747a - 1] = str;
        }
        return iT;
    }
}
