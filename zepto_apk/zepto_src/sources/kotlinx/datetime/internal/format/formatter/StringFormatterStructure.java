package kotlinx.datetime.internal.format.formatter;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class StringFormatterStructure<T> implements FormatterStructure<T> {
    public StringFormatterStructure(Function1 string) {
        Intrinsics.checkNotNullParameter(string, "string");
    }
}
