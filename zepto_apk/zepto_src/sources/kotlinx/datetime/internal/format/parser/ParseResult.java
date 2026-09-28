package kotlinx.datetime.internal.format.parser;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@JvmInline
/* loaded from: classes3.dex */
public final class ParseResult {

    @Metadata
    public static final class Companion {
        public static ParseError a(int i2, Function0 message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new ParseError(i2, message);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ParseResult)) {
            return false;
        }
        ((ParseResult) obj).getClass();
        return Intrinsics.b(null, null);
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "ParseResult(value=null)";
    }
}
