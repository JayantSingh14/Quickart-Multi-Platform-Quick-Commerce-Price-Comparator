package kotlin.text;

import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class CharsKt extends CharsKt__CharKt {
    private CharsKt() {
    }

    public static boolean a(char c2, char c3, boolean z) {
        if (c2 == c3) {
            return true;
        }
        if (!z) {
            return false;
        }
        char upperCase = Character.toUpperCase(c2);
        char upperCase2 = Character.toUpperCase(c3);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public static boolean b(char c2) {
        return Character.isWhitespace(c2) || Character.isSpaceChar(c2);
    }
}
