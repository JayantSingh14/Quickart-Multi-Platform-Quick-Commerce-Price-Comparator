package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class StringJsonLexer extends AbstractJsonLexer {

    /* renamed from: e, reason: collision with root package name */
    public final String f56104e;

    public StringJsonLexer(String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.f56104e = source;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final boolean c() {
        int i2 = this.f56006a;
        if (i2 == -1) {
            return false;
        }
        while (true) {
            String str = this.f56104e;
            if (i2 >= str.length()) {
                this.f56006a = i2;
                return false;
            }
            char cCharAt = str.charAt(i2);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.f56006a = i2;
                return !(cCharAt == '}' || cCharAt == ']' || cCharAt == ':' || cCharAt == ',');
            }
            i2++;
        }
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final String e() {
        h('\"');
        int i2 = this.f56006a;
        String source = this.f56104e;
        int iW = StringsKt.w(source, '\"', i2, 4);
        if (iW == -1) {
            k();
            q((byte) 1, false);
            throw null;
        }
        int i3 = i2;
        while (i3 < iW) {
            if (source.charAt(i3) == '\\') {
                int iW2 = this.f56006a;
                Intrinsics.checkNotNullParameter(source, "source");
                char cCharAt = source.charAt(i3);
                boolean z = false;
                while (cCharAt != '\"') {
                    if (cCharAt == '\\') {
                        b(iW2, i3);
                        int iW3 = w(i3 + 1);
                        if (iW3 == -1) {
                            AbstractJsonLexer.p(this, "Expected escape sequence to continue, got EOF", 0, null, 6);
                            throw null;
                        }
                        int iA = iW3 + 1;
                        char cCharAt2 = s().charAt(iW3);
                        if (cCharAt2 == 'u') {
                            iA = a(s(), iA);
                        } else {
                            char c2 = cCharAt2 < 'u' ? CharMappings.f56029a[cCharAt2] : (char) 0;
                            if (c2 == 0) {
                                AbstractJsonLexer.p(this, "Invalid escaped char '" + cCharAt2 + '\'', 0, null, 6);
                                throw null;
                            }
                            this.f56009d.append(c2);
                        }
                        iW2 = w(iA);
                        if (iW2 == -1) {
                            AbstractJsonLexer.p(this, "Unexpected EOF", iW2, null, 4);
                            throw null;
                        }
                    } else {
                        i3++;
                        if (i3 >= source.length()) {
                            b(iW2, i3);
                            iW2 = w(i3);
                            if (iW2 == -1) {
                                AbstractJsonLexer.p(this, "Unexpected EOF", iW2, null, 4);
                                throw null;
                            }
                        } else {
                            continue;
                            cCharAt = source.charAt(i3);
                        }
                    }
                    i3 = iW2;
                    z = true;
                    cCharAt = source.charAt(i3);
                }
                String strY = !z ? y(iW2, i3) : m(iW2, i3);
                this.f56006a = i3 + 1;
                return strY;
            }
            i3++;
        }
        this.f56006a = iW + 1;
        String strSubstring = source.substring(i2, iW);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final byte f() {
        byte bA;
        do {
            int i2 = this.f56006a;
            if (i2 == -1) {
                return (byte) 10;
            }
            String str = this.f56104e;
            if (i2 >= str.length()) {
                return (byte) 10;
            }
            int i3 = this.f56006a;
            this.f56006a = i3 + 1;
            bA = AbstractJsonLexerKt.a(str.charAt(i3));
        } while (bA == 3);
        return bA;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final void h(char c2) {
        if (this.f56006a == -1) {
            B(c2);
            throw null;
        }
        while (true) {
            int i2 = this.f56006a;
            String str = this.f56104e;
            if (i2 >= str.length()) {
                this.f56006a = -1;
                B(c2);
                throw null;
            }
            int i3 = this.f56006a;
            this.f56006a = i3 + 1;
            char cCharAt = str.charAt(i3);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                if (cCharAt == c2) {
                    return;
                }
                B(c2);
                throw null;
            }
        }
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final CharSequence s() {
        return this.f56104e;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final String t(String keyToMatch, boolean z) {
        Intrinsics.checkNotNullParameter(keyToMatch, "keyToMatch");
        int i2 = this.f56006a;
        try {
            if (f() != 6) {
                return null;
            }
            if (!Intrinsics.b(v(z), keyToMatch)) {
                return null;
            }
            this.f56008c = null;
            if (f() != 5) {
                return null;
            }
            return v(z);
        } finally {
            this.f56006a = i2;
            this.f56008c = null;
        }
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final int w(int i2) {
        if (i2 < this.f56104e.length()) {
            return i2;
        }
        return -1;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final int x() {
        char cCharAt;
        int i2 = this.f56006a;
        if (i2 == -1) {
            return i2;
        }
        while (true) {
            String str = this.f56104e;
            if (i2 >= str.length() || !((cCharAt = str.charAt(i2)) == ' ' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t')) {
                break;
            }
            i2++;
        }
        this.f56006a = i2;
        return i2;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonLexer
    public final boolean z() {
        int iX = x();
        String str = this.f56104e;
        if (iX == str.length() || iX == -1 || str.charAt(iX) != ',') {
            return false;
        }
        this.f56006a++;
        return true;
    }
}
