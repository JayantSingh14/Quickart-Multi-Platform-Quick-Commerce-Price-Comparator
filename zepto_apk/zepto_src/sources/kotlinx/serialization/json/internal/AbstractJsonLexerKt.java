package kotlinx.serialization.json.internal;

import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class AbstractJsonLexerKt {
    public static final byte a(char c2) {
        if (c2 < '~') {
            return CharMappings.f56030b[c2];
        }
        return (byte) 0;
    }

    public static final String b(byte b2) {
        return b2 == 1 ? "quotation mark '\"'" : b2 == 2 ? "string escape sequence '\\'" : b2 == 4 ? "comma ','" : b2 == 5 ? "colon ':'" : b2 == 6 ? "start of the object '{'" : b2 == 7 ? "end of the object '}'" : b2 == 8 ? "start of the array '['" : b2 == 9 ? "end of the array ']'" : b2 == 10 ? "end of the input" : b2 == 127 ? "invalid token" : "valid token";
    }
}
