package kotlinx.datetime.internal.format.parser;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.parser.ParseResult;

@Metadata
/* loaded from: classes3.dex */
public final class SignParser<Output> implements ParserOperation<Output> {

    /* renamed from: a, reason: collision with root package name */
    public final Function2 f55621a;

    /* renamed from: b, reason: collision with root package name */
    public final String f55622b;

    public SignParser(Function2 isNegativeSetter, String whatThisExpects) {
        Intrinsics.checkNotNullParameter(isNegativeSetter, "isNegativeSetter");
        Intrinsics.checkNotNullParameter(whatThisExpects, "whatThisExpects");
        this.f55621a = isNegativeSetter;
        this.f55622b = whatThisExpects;
    }

    @Override // kotlinx.datetime.internal.format.parser.ParserOperation
    public final Object a(Copyable copyable, String input, int i2) {
        Intrinsics.checkNotNullParameter(input, "input");
        if (i2 >= input.length()) {
            return Integer.valueOf(i2);
        }
        final char cCharAt = input.charAt(i2);
        Function2 function2 = this.f55621a;
        if (cCharAt == '-') {
            function2.invoke(copyable, Boolean.TRUE);
            return Integer.valueOf(i2 + 1);
        }
        if (cCharAt != '+') {
            return ParseResult.Companion.a(i2, new Function0<String>() { // from class: kotlinx.datetime.internal.format.parser.SignParser$consume$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return "Expected " + this.f55623c.f55622b + " but got " + cCharAt;
                }
            });
        }
        function2.invoke(copyable, Boolean.FALSE);
        return Integer.valueOf(i2 + 1);
    }

    public final String toString() {
        return this.f55622b;
    }
}
