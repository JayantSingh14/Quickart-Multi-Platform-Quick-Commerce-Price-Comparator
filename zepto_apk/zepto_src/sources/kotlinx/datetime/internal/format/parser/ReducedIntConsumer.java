package kotlinx.datetime.internal.format.parser;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ReducedIntConsumer<Receiver> extends NumberConsumer<Receiver> {
    @Override // kotlinx.datetime.internal.format.parser.NumberConsumer
    public final NumberConsumptionError a(Copyable copyable, String input, int i2, int i3) {
        Intrinsics.checkNotNullParameter(input, "input");
        while (i2 < i3) {
            input.charAt(i2);
            i2++;
        }
        throw null;
    }

    @Override // kotlinx.datetime.internal.format.parser.NumberConsumer
    public final Integer b() {
        return 0;
    }
}
