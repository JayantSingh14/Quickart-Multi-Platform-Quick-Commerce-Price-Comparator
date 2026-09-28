package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.LocalTime;
import kotlinx.datetime.format.AbstractDateTimeFormatBuilder;
import kotlinx.datetime.format.AbstractWithTimeBuilder;
import kotlinx.datetime.internal.format.AppendableFormatStructure;
import kotlinx.datetime.internal.format.BasicFormatStructure;
import kotlinx.datetime.internal.format.CachedFormatStructure;
import kotlinx.datetime.internal.format.FormatStructure;
import kotlinx.datetime.internal.format.parser.Copyable;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class LocalDateTimeFormat extends AbstractDateTimeFormat<LocalDateTime, IncompleteLocalDateTime> {

    /* renamed from: a, reason: collision with root package name */
    public final CachedFormatStructure f55447a;

    @Metadata
    public static final class Builder implements AbstractDateTimeFormatBuilder<DateTimeFieldContainer, Builder>, AbstractWithDateTimeBuilder {

        /* renamed from: a, reason: collision with root package name */
        public final AppendableFormatStructure f55448a;

        public Builder(AppendableFormatStructure actualBuilder) {
            Intrinsics.checkNotNullParameter(actualBuilder, "actualBuilder");
            this.f55448a = actualBuilder;
        }

        @Override // kotlinx.datetime.format.AbstractDateTimeFormatBuilder
        public final AppendableFormatStructure a() {
            return this.f55448a;
        }

        @Override // kotlinx.datetime.format.AbstractDateTimeFormatBuilder
        public final void b(String str, Function1 function1) {
            AbstractDateTimeFormatBuilder.DefaultImpls.b(this, str, function1);
        }

        @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithDate
        public final void c() {
            Padding padding = Padding.f55479b;
            Intrinsics.checkNotNullParameter(padding, "padding");
            Intrinsics.checkNotNullParameter(padding, "padding");
            v(new BasicFormatStructure(new MonthDirective()));
        }

        @Override // kotlinx.datetime.format.AbstractDateTimeFormatBuilder
        public final void d(Function1[] function1Arr, Function1 function1) {
            AbstractDateTimeFormatBuilder.DefaultImpls.a(this, function1Arr, function1);
        }

        @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithDate
        public final void f(DateTimeFormat format) {
            Intrinsics.checkNotNullParameter(format, "format");
            Intrinsics.checkNotNullParameter(format, "format");
            if (format instanceof LocalDateFormat) {
                v(((LocalDateFormat) format).f55438a);
            }
        }

        @Override // kotlinx.datetime.format.AbstractDateTimeFormatBuilder
        public final AbstractDateTimeFormatBuilder g() {
            return new Builder(new AppendableFormatStructure());
        }

        @Override // kotlinx.datetime.format.DateTimeFormatBuilder
        public final void h(String str) {
            AbstractDateTimeFormatBuilder.DefaultImpls.d(this, str);
        }

        @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithTime
        public final void i(LocalTimeFormat format) {
            Intrinsics.checkNotNullParameter(format, "format");
            Intrinsics.checkNotNullParameter(format, "format");
            if (format != null) {
                k(format.f55455a);
            }
        }

        @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithDate
        public final void j() {
            Padding padding = Padding.f55479b;
            Intrinsics.checkNotNullParameter(padding, "padding");
            Intrinsics.checkNotNullParameter(padding, "padding");
            v(new BasicFormatStructure(new YearDirective(false)));
        }

        @Override // kotlinx.datetime.format.AbstractWithTimeBuilder
        public final void k(FormatStructure structure) {
            Intrinsics.checkNotNullParameter(structure, "structure");
            w(structure);
        }

        @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithTime
        public final void l() {
            Padding padding = Padding.f55479b;
            Intrinsics.checkNotNullParameter(padding, "padding");
            Intrinsics.checkNotNullParameter(padding, "padding");
            k(new BasicFormatStructure(new MinuteDirective()));
        }

        @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithTime
        public final void m() {
            Padding padding = Padding.f55479b;
            Intrinsics.checkNotNullParameter(padding, "padding");
            Intrinsics.checkNotNullParameter(padding, "padding");
            k(new BasicFormatStructure(new SecondDirective()));
        }

        @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithTime
        public final void n() {
            Padding padding = Padding.f55479b;
            Intrinsics.checkNotNullParameter(padding, "padding");
            Intrinsics.checkNotNullParameter(padding, "padding");
            k(new BasicFormatStructure(new HourDirective()));
        }

        @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithTime
        public final void p(int i2, int i3) {
            AbstractWithTimeBuilder.DefaultImpls.a(this, i2, i3);
        }

        @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithDate
        public final void t(Padding padding) {
            Padding padding2 = Padding.f55479b;
            Intrinsics.checkNotNullParameter(padding2, "padding");
            Intrinsics.checkNotNullParameter(padding2, "padding");
            v(new BasicFormatStructure(new DayDirective(padding2)));
        }

        public final void v(FormatStructure structure) {
            Intrinsics.checkNotNullParameter(structure, "structure");
            w(structure);
        }

        public final void w(FormatStructure structure) {
            Intrinsics.checkNotNullParameter(structure, "structure");
            this.f55448a.a(structure);
        }
    }

    @Metadata
    public static final class Companion {
    }

    public LocalDateTimeFormat(CachedFormatStructure actualFormat) {
        Intrinsics.checkNotNullParameter(actualFormat, "actualFormat");
        this.f55447a = actualFormat;
    }

    @Override // kotlinx.datetime.format.AbstractDateTimeFormat
    public final CachedFormatStructure a() {
        return this.f55447a;
    }

    @Override // kotlinx.datetime.format.AbstractDateTimeFormat
    public final Copyable b() {
        return LocalDateTimeFormatKt.f55450b;
    }

    @Override // kotlinx.datetime.format.AbstractDateTimeFormat
    public final Object c(Copyable copyable) throws Exception {
        IncompleteLocalDateTime intermediate = (IncompleteLocalDateTime) copyable;
        Intrinsics.checkNotNullParameter(intermediate, "intermediate");
        intermediate.getClass();
        LocalDate date = intermediate.f55426a.b();
        LocalTime time = intermediate.f55427b.d();
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(time, "time");
        j$.time.LocalDateTime localDateTimeOf = j$.time.LocalDateTime.of(date.f55353a, time.f55360a);
        Intrinsics.checkNotNullExpressionValue(localDateTimeOf, "of(...)");
        return new LocalDateTime(localDateTimeOf);
    }
}
