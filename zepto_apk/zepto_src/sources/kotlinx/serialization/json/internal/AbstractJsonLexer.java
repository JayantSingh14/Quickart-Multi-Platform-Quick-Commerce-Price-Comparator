package kotlinx.serialization.json.internal;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.lang3.StringUtils;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class AbstractJsonLexer {

    /* renamed from: a, reason: collision with root package name */
    public int f56006a;

    /* renamed from: c, reason: collision with root package name */
    public String f56008c;

    /* renamed from: b, reason: collision with root package name */
    public final JsonPath f56007b = new JsonPath();

    /* renamed from: d, reason: collision with root package name */
    public final StringBuilder f56009d = new StringBuilder();

    public static /* synthetic */ void p(AbstractJsonLexer abstractJsonLexer, String str, int i2, String str2, int i3) {
        if ((i3 & 2) != 0) {
            i2 = abstractJsonLexer.f56006a;
        }
        if ((i3 & 4) != 0) {
            str2 = "";
        }
        abstractJsonLexer.o(i2, str, str2);
        throw null;
    }

    public final boolean A(boolean z) {
        int iW = w(x());
        int length = s().length() - iW;
        if (length >= 4 && iW != -1) {
            int i2 = 0;
            while (true) {
                if (i2 < 4) {
                    if ("null".charAt(i2) != s().charAt(iW + i2)) {
                        break;
                    }
                    i2++;
                } else if (length <= 4 || AbstractJsonLexerKt.a(s().charAt(iW + 4)) != 0) {
                    if (!z) {
                        return true;
                    }
                    this.f56006a = iW + 4;
                    return true;
                }
            }
        }
        return false;
    }

    public final void B(char c2) {
        int i2 = this.f56006a;
        if (i2 > 0 && c2 == '\"') {
            try {
                this.f56006a = i2 - 1;
                String strK = k();
                this.f56006a = i2;
                if (Intrinsics.b(strK, "null")) {
                    o(this.f56006a - 1, "Expected string literal but 'null' literal was found", "Use 'coerceInputValues = true' in 'Json {}' builder to coerce nulls if property has a default value.");
                    throw null;
                }
            } catch (Throwable th) {
                this.f56006a = i2;
                throw th;
            }
        }
        q(AbstractJsonLexerKt.a(c2), true);
        throw null;
    }

    public final int a(CharSequence charSequence, int i2) {
        int i3 = i2 + 4;
        if (i3 < charSequence.length()) {
            this.f56009d.append((char) (r(charSequence, i2 + 3) + (r(charSequence, i2) << 12) + (r(charSequence, i2 + 1) << 8) + (r(charSequence, i2 + 2) << 4)));
            return i3;
        }
        this.f56006a = i2;
        n();
        if (this.f56006a + 4 < charSequence.length()) {
            return a(charSequence, this.f56006a);
        }
        p(this, "Unexpected EOF during unicode escape", 0, null, 6);
        throw null;
    }

    public void b(int i2, int i3) {
        this.f56009d.append(s(), i2, i3);
    }

    public abstract boolean c();

    public final void d(int i2, String str) {
        if (s().length() - i2 < str.length()) {
            p(this, "Unexpected end of boolean literal", 0, null, 6);
            throw null;
        }
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (str.charAt(i3) != (s().charAt(i2 + i3) | ' ')) {
                p(this, "Expected valid boolean literal prefix, but had '" + k() + '\'', 0, null, 6);
                throw null;
            }
        }
        this.f56006a = str.length() + i2;
    }

    public abstract String e();

    public abstract byte f();

    public final byte g(byte b2) {
        byte bF = f();
        if (bF == b2) {
            return bF;
        }
        q(b2, true);
        throw null;
    }

    public void h(char c2) {
        n();
        CharSequence charSequenceS = s();
        int i2 = this.f56006a;
        while (true) {
            int iW = w(i2);
            if (iW == -1) {
                this.f56006a = iW;
                B(c2);
                throw null;
            }
            int i3 = iW + 1;
            char cCharAt = charSequenceS.charAt(iW);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.f56006a = i3;
                if (cCharAt == c2) {
                    return;
                }
                B(c2);
                throw null;
            }
            i2 = i3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01b3, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x01b4, code lost:
    
        p(r22, "Numeric value overflow", 0, null, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01ba, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01c0, code lost:
    
        throw new kotlin.NoWhenBranchMatchedException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01c1, code lost:
    
        if (r13 == false) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01c3, code lost:
    
        return r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x01c8, code lost:
    
        if (r14 == Long.MIN_VALUE) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01cb, code lost:
    
        return -r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01cc, code lost:
    
        p(r22, "Numeric value overflow", 0, null, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01d2, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x01d3, code lost:
    
        p(r22, "Expected numeric literal", 0, null, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x01d8, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0111, code lost:
    
        r12 = r6;
        p(r22, "Unexpected symbol '" + r8 + "' in numeric literal", 0, r12, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x012a, code lost:
    
        throw r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x012b, code lost:
    
        r20 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0133, code lost:
    
        if (r11 == r1) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0135, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0137, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0138, code lost:
    
        if (r1 == r11) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x013a, code lost:
    
        if (r13 == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x013e, code lost:
    
        if (r1 == (r11 - 1)) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0146, code lost:
    
        if (r19 == false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0148, code lost:
    
        if (r2 == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0154, code lost:
    
        if (s().charAt(r11) != '\"') goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0156, code lost:
    
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0159, code lost:
    
        p(r22, "Expected closing quotation mark", 0, null, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0161, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0162, code lost:
    
        p(r22, "EOF", 0, null, 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0168, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0169, code lost:
    
        r22.f56006a = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x016b, code lost:
    
        if (r21 == false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x016d, code lost:
    
        r1 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0170, code lost:
    
        if (r20 != false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0172, code lost:
    
        r5 = java.lang.Math.pow(10.0d, -r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x017c, code lost:
    
        if (r20 != true) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x017e, code lost:
    
        r5 = java.lang.Math.pow(10.0d, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0183, code lost:
    
        r1 = r1 * r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0188, code lost:
    
        if (r1 > 9.223372036854776E18d) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x018e, code lost:
    
        if (r1 < (-9.223372036854776E18d)) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0196, code lost:
    
        if (java.lang.Math.floor(r1) != r1) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0198, code lost:
    
        r14 = (long) r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x019a, code lost:
    
        p(r22, "Can't convert " + r1 + " to Long", 0, null, 6);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v12, types: [java.lang.String, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.String, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long i() {
        /*
            Method dump skipped, instructions count: 479
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.AbstractJsonLexer.i():long");
    }

    public final String j() {
        String str = this.f56008c;
        if (str == null) {
            return e();
        }
        Intrinsics.c(str);
        this.f56008c = null;
        return str;
    }

    public final String k() {
        String str = this.f56008c;
        if (str != null) {
            Intrinsics.c(str);
            this.f56008c = null;
            return str;
        }
        int iX = x();
        if (iX >= s().length() || iX == -1) {
            p(this, "EOF", iX, null, 4);
            throw null;
        }
        byte bA = AbstractJsonLexerKt.a(s().charAt(iX));
        if (bA == 1) {
            return j();
        }
        if (bA != 0) {
            p(this, "Expected beginning of the string, but got " + s().charAt(iX), 0, null, 6);
            throw null;
        }
        boolean z = false;
        while (AbstractJsonLexerKt.a(s().charAt(iX)) == 0) {
            iX++;
            if (iX >= s().length()) {
                b(this.f56006a, iX);
                int iW = w(iX);
                if (iW == -1) {
                    this.f56006a = iX;
                    return m(0, 0);
                }
                iX = iW;
                z = true;
            }
        }
        String strY = !z ? y(this.f56006a, iX) : m(this.f56006a, iX);
        this.f56006a = iX;
        return strY;
    }

    public final String l() {
        String strK = k();
        if (!Intrinsics.b(strK, "null") || s().charAt(this.f56006a - 1) == '\"') {
            return strK;
        }
        p(this, "Unexpected 'null' value instead of string literal", 0, null, 6);
        throw null;
    }

    public final String m(int i2, int i3) {
        b(i2, i3);
        StringBuilder sb = this.f56009d;
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        sb.setLength(0);
        return string;
    }

    public void n() {
    }

    public final void o(int i2, String message, String hint) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(hint, "hint");
        String strConcat = hint.length() == 0 ? "" : StringUtils.LF.concat(hint);
        StringBuilder sbX = b.x(message, " at path: ");
        sbX.append(this.f56007b.a());
        sbX.append(strConcat);
        throw JsonExceptionsKt.d(sbX.toString(), s(), i2);
    }

    public final void q(byte b2, boolean z) {
        String strB = AbstractJsonLexerKt.b(b2);
        int i2 = z ? this.f56006a - 1 : this.f56006a;
        p(this, b.m("Expected ", strB, ", but had '", (this.f56006a == s().length() || i2 < 0) ? "EOF" : String.valueOf(s().charAt(i2)), "' instead"), i2, null, 4);
        throw null;
    }

    public final int r(CharSequence charSequence, int i2) {
        char cCharAt = charSequence.charAt(i2);
        if ('0' <= cCharAt && cCharAt < ':') {
            return cCharAt - '0';
        }
        if ('a' <= cCharAt && cCharAt < 'g') {
            return cCharAt - 'W';
        }
        if ('A' <= cCharAt && cCharAt < 'G') {
            return cCharAt - '7';
        }
        p(this, "Invalid toHexChar char '" + cCharAt + "' in unicode escape", 0, null, 6);
        throw null;
    }

    public abstract CharSequence s();

    public abstract String t(String str, boolean z);

    public final String toString() {
        StringBuilder sb = new StringBuilder("JsonReader(source='");
        sb.append((Object) s());
        sb.append("', currentPosition=");
        return b.n(sb, this.f56006a, ')');
    }

    public final byte u() {
        CharSequence charSequenceS = s();
        int i2 = this.f56006a;
        while (true) {
            int iW = w(i2);
            if (iW == -1) {
                this.f56006a = iW;
                return (byte) 10;
            }
            char cCharAt = charSequenceS.charAt(iW);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.f56006a = iW;
                return AbstractJsonLexerKt.a(cCharAt);
            }
            i2 = iW + 1;
        }
    }

    public final String v(boolean z) {
        String strJ;
        byte bU = u();
        if (z) {
            if (bU != 1 && bU != 0) {
                return null;
            }
            strJ = k();
        } else {
            if (bU != 1) {
                return null;
            }
            strJ = j();
        }
        this.f56008c = strJ;
        return strJ;
    }

    public abstract int w(int i2);

    public int x() {
        int iW;
        char cCharAt;
        int i2 = this.f56006a;
        while (true) {
            iW = w(i2);
            if (iW == -1 || !((cCharAt = s().charAt(iW)) == ' ' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t')) {
                break;
            }
            i2 = iW + 1;
        }
        this.f56006a = iW;
        return iW;
    }

    public String y(int i2, int i3) {
        return s().subSequence(i2, i3).toString();
    }

    public abstract boolean z();
}
