package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.NamedUnsignedIntFieldFormatDirective;

@Metadata
/* loaded from: classes3.dex */
final class MonthNameDirective extends NamedUnsignedIntFieldFormatDirective<DateFieldContainer> {

    /* renamed from: d, reason: collision with root package name */
    public final MonthNames f55466d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MonthNameDirective(MonthNames names) {
        super(DateFields.f55374b, names.f55468a, "monthName");
        Intrinsics.checkNotNullParameter(names, "names");
        this.f55466d = names;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof MonthNameDirective) && Intrinsics.b(this.f55466d.f55468a, ((MonthNameDirective) obj).f55466d.f55468a);
    }

    public final int hashCode() {
        return this.f55466d.f55468a.hashCode();
    }
}
