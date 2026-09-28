package kotlinx.datetime.internal.format.formatter;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ConditionalFormatter<T> implements FormatterStructure<T> {

    /* renamed from: a, reason: collision with root package name */
    public final List f55574a;

    public ConditionalFormatter(List formatters) {
        Intrinsics.checkNotNullParameter(formatters, "formatters");
        this.f55574a = formatters;
    }
}
