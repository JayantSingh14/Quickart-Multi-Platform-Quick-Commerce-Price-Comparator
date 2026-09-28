package kotlinx.datetime.internal.format.formatter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class SpacePaddedFormatter<T> implements FormatterStructure<T> {

    /* renamed from: a, reason: collision with root package name */
    public final FormatterStructure f55580a;

    public SpacePaddedFormatter(FormatterStructure formatter) {
        Intrinsics.checkNotNullParameter(formatter, "formatter");
        this.f55580a = formatter;
    }
}
