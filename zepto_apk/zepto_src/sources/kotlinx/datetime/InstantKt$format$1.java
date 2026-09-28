package kotlinx.datetime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.datetime.Instant;
import kotlinx.datetime.format.DateTimeComponents;

@Metadata
/* loaded from: classes3.dex */
final class InstantKt$format$1 extends Lambda implements Function1<DateTimeComponents, Unit> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        DateTimeComponents format = (DateTimeComponents) obj;
        Intrinsics.checkNotNullParameter(format, "$this$format");
        format.getClass();
        Intrinsics.checkNotNullParameter(null, "instant");
        Intrinsics.checkNotNullParameter(null, "utcOffset");
        Instant.Companion companion = Instant.Companion;
        throw null;
    }
}
