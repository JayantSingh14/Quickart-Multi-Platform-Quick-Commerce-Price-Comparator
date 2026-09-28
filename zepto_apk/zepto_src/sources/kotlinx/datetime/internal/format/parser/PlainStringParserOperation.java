package kotlinx.datetime.internal.format.parser;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.internal.UtilKt;
import kotlinx.datetime.internal.format.parser.ParseResult;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class PlainStringParserOperation<Output> implements ParserOperation<Output> {

    /* renamed from: a, reason: collision with root package name */
    public final String f55615a;

    public PlainStringParserOperation(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        this.f55615a = string;
        if (string.length() <= 0) {
            throw new IllegalArgumentException("Empty string is not allowed");
        }
        if (UtilKt.a(string.charAt(0))) {
            throw new IllegalArgumentException(b.D("String '", string, "' starts with a digit").toString());
        }
        if (UtilKt.a(string.charAt(string.length() - 1))) {
            throw new IllegalArgumentException(b.D("String '", string, "' ends with a digit").toString());
        }
    }

    @Override // kotlinx.datetime.internal.format.parser.ParserOperation
    public final Object a(Copyable copyable, final String input, final int i2) {
        Intrinsics.checkNotNullParameter(input, "input");
        String str = this.f55615a;
        if (str.length() + i2 > input.length()) {
            return ParseResult.Companion.a(i2, new Function0<String>() { // from class: kotlinx.datetime.internal.format.parser.PlainStringParserOperation$consume$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return e.t(new StringBuilder("Unexpected end of input: yet to parse '"), this.f55616c.f55615a, '\'');
                }
            });
        }
        int length = str.length();
        for (final int i3 = 0; i3 < length; i3++) {
            if (input.charAt(i2 + i3) != str.charAt(i3)) {
                return ParseResult.Companion.a(i2, new Function0<String>() { // from class: kotlinx.datetime.internal.format.parser.PlainStringParserOperation$consume$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        StringBuilder sb = new StringBuilder("Expected ");
                        sb.append(this.f55617c.f55615a);
                        sb.append(" but got ");
                        int i4 = i3;
                        int i5 = i2;
                        sb.append(input.subSequence(i5, i4 + i5 + 1).toString());
                        return sb.toString();
                    }
                });
            }
        }
        return Integer.valueOf(str.length() + i2);
    }

    public final String toString() {
        return e.t(new StringBuilder("'"), this.f55615a, '\'');
    }
}
