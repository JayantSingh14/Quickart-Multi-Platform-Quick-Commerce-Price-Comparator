package kotlinx.datetime.internal.format.parser;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.parser.NumberConsumptionError;

@Metadata
/* loaded from: classes3.dex */
public final class ConstantNumberConsumer<Receiver> extends NumberConsumer<Receiver> {

    /* renamed from: c, reason: collision with root package name */
    public final String f55582c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstantNumberConsumer(String expected) {
        super(Integer.valueOf(expected.length()), "the predefined string ".concat(expected));
        Intrinsics.checkNotNullParameter(expected, "expected");
        this.f55582c = expected;
    }

    @Override // kotlinx.datetime.internal.format.parser.NumberConsumer
    public final NumberConsumptionError a(Copyable copyable, String input, int i2, int i3) {
        Intrinsics.checkNotNullParameter(input, "input");
        String string = input.subSequence(i2, i3).toString();
        String str = this.f55582c;
        if (Intrinsics.b(string, str)) {
            return null;
        }
        return new NumberConsumptionError.WrongConstant(str);
    }
}
