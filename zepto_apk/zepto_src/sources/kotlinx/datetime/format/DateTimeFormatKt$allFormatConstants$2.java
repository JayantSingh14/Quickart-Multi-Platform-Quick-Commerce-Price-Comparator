package kotlinx.datetime.format;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.format.DateTimeComponents;
import kotlinx.datetime.internal.format.CachedFormatStructure;

@Metadata
/* loaded from: classes3.dex */
public final class DateTimeFormatKt$allFormatConstants$2 extends Lambda implements Function0<List<? extends Pair<? extends String, ? extends CachedFormatStructure<?>>>> {

    /* renamed from: c, reason: collision with root package name */
    public static final DateTimeFormatKt$allFormatConstants$2 f55410c = new DateTimeFormatKt$allFormatConstants$2(0);

    public static final CachedFormatStructure a(DateTimeFormat dateTimeFormat) {
        Intrinsics.d(dateTimeFormat, "null cannot be cast to non-null type kotlinx.datetime.format.AbstractDateTimeFormat<*, *>");
        return ((AbstractDateTimeFormat) dateTimeFormat).a();
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Pair pair = new Pair("dateTimeComponents(DateTimeComponents.Formats.RFC_1123)", a(DateTimeComponents.Formats.f55386b));
        Pair pair2 = new Pair("dateTimeComponents(DateTimeComponents.Formats.ISO_DATE_TIME_OFFSET)", a(DateTimeComponents.Formats.f55385a));
        Pair pair3 = new Pair("date(LocalDateTime.Formats.ISO)", a(LocalDateTime.Formats.f55359a));
        DateTimeFormat dateTimeFormat = LocalDate.Formats.f55354a;
        return CollectionsKt.I(pair, pair2, pair3, new Pair("date(LocalDate.Formats.ISO)", a(LocalDateFormatKt.a())), new Pair("date(LocalDate.Formats.ISO_BASIC)", a(LocalDate.Formats.f55354a)), new Pair("time(LocalTime.Formats.ISO)", a((LocalTimeFormat) LocalTimeFormatKt.f55457a.getValue())), new Pair("offset(UtcOffset.Formats.ISO)", a((UtcOffsetFormat) UtcOffsetFormatKt.f55497a.getValue())), new Pair("offset(UtcOffset.Formats.ISO_BASIC)", a((UtcOffsetFormat) UtcOffsetFormatKt.f55498b.getValue())), new Pair("offset(UtcOffset.Formats.FOUR_DIGITS)", a((UtcOffsetFormat) UtcOffsetFormatKt.f55499c.getValue())));
    }
}
