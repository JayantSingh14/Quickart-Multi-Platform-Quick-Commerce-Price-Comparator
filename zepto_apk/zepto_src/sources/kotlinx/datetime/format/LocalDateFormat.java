package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.format.AbstractDateTimeFormatBuilder;
import kotlinx.datetime.internal.format.AppendableFormatStructure;
import kotlinx.datetime.internal.format.BasicFormatStructure;
import kotlinx.datetime.internal.format.CachedFormatStructure;
import kotlinx.datetime.internal.format.FormatStructure;
import kotlinx.datetime.internal.format.parser.Copyable;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class LocalDateFormat extends AbstractDateTimeFormat<LocalDate, IncompleteLocalDate> {

    /* renamed from: a, reason: collision with root package name */
    public final CachedFormatStructure f55438a;

    @Metadata
    public static final class Builder implements AbstractDateTimeFormatBuilder<DateFieldContainer, Builder>, AbstractWithDateBuilder {

        /* renamed from: a, reason: collision with root package name */
        public final AppendableFormatStructure f55439a;

        public Builder(AppendableFormatStructure actualBuilder) {
            Intrinsics.checkNotNullParameter(actualBuilder, "actualBuilder");
            this.f55439a = actualBuilder;
        }

        @Override // kotlinx.datetime.format.AbstractDateTimeFormatBuilder
        public final AppendableFormatStructure a() {
            return this.f55439a;
        }

        @Override // kotlinx.datetime.format.AbstractDateTimeFormatBuilder
        public final void b(String str, Function1 function1) {
            AbstractDateTimeFormatBuilder.DefaultImpls.b(this, str, function1);
        }

        @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithDate
        public final void c() {
            Padding padding = Padding.f55479b;
            Intrinsics.checkNotNullParameter(padding, "padding");
            v(new BasicFormatStructure(new MonthDirective()));
        }

        @Override // kotlinx.datetime.format.AbstractDateTimeFormatBuilder
        public final void d(Function1[] function1Arr, Function1 function1) {
            AbstractDateTimeFormatBuilder.DefaultImpls.a(this, function1Arr, function1);
        }

        @Override // kotlinx.datetime.format.AbstractDateTimeFormatBuilder
        public final AbstractDateTimeFormatBuilder g() {
            return new Builder(new AppendableFormatStructure());
        }

        @Override // kotlinx.datetime.format.DateTimeFormatBuilder
        public final void h(String str) {
            AbstractDateTimeFormatBuilder.DefaultImpls.d(this, str);
        }

        @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithDate
        public final void j() {
            Padding padding = Padding.f55479b;
            Intrinsics.checkNotNullParameter(padding, "padding");
            v(new BasicFormatStructure(new YearDirective(false)));
        }

        @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithDate
        public final void t(Padding padding) {
            Padding padding2 = Padding.f55479b;
            Intrinsics.checkNotNullParameter(padding2, "padding");
            v(new BasicFormatStructure(new DayDirective(padding2)));
        }

        public final void v(FormatStructure structure) {
            Intrinsics.checkNotNullParameter(structure, "structure");
            this.f55439a.a(structure);
        }
    }

    @Metadata
    public static final class Companion {
    }

    public LocalDateFormat(CachedFormatStructure actualFormat) {
        Intrinsics.checkNotNullParameter(actualFormat, "actualFormat");
        this.f55438a = actualFormat;
    }

    @Override // kotlinx.datetime.format.AbstractDateTimeFormat
    public final CachedFormatStructure a() {
        return this.f55438a;
    }

    @Override // kotlinx.datetime.format.AbstractDateTimeFormat
    public final Copyable b() {
        return LocalDateFormatKt.f55442c;
    }

    @Override // kotlinx.datetime.format.AbstractDateTimeFormat
    public final Object c(Copyable copyable) {
        IncompleteLocalDate intermediate = (IncompleteLocalDate) copyable;
        Intrinsics.checkNotNullParameter(intermediate, "intermediate");
        return intermediate.b();
    }
}
