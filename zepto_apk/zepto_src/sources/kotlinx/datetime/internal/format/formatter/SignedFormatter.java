package kotlinx.datetime.internal.format.formatter;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class SignedFormatter<T> implements FormatterStructure<T> {

    /* renamed from: a, reason: collision with root package name */
    public final FormatterStructure f55577a;

    /* renamed from: b, reason: collision with root package name */
    public final Function1 f55578b;

    public SignedFormatter(FormatterStructure formatter, Function1 allSubFormatsNegative) {
        Intrinsics.checkNotNullParameter(formatter, "formatter");
        Intrinsics.checkNotNullParameter(allSubFormatsNegative, "allSubFormatsNegative");
        this.f55577a = formatter;
        this.f55578b = allSubFormatsNegative;
    }
}
