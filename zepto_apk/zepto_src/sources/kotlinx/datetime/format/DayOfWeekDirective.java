package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.NamedUnsignedIntFieldFormatDirective;

@Metadata
/* loaded from: classes3.dex */
final class DayOfWeekDirective extends NamedUnsignedIntFieldFormatDirective<DateFieldContainer> {

    /* renamed from: d, reason: collision with root package name */
    public final DayOfWeekNames f55412d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DayOfWeekDirective(DayOfWeekNames names) {
        super(DateFields.f55376d, names.f55414a, "dayOfWeekName");
        Intrinsics.checkNotNullParameter(names, "names");
        this.f55412d = names;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof DayOfWeekDirective) && Intrinsics.b(this.f55412d.f55414a, ((DayOfWeekDirective) obj).f55412d.f55414a);
    }

    public final int hashCode() {
        return this.f55412d.f55414a.hashCode();
    }
}
