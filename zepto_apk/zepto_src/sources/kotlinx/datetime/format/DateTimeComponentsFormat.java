package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.format.AbstractDateTimeFormatBuilder;
import kotlinx.datetime.format.AbstractWithTimeBuilder;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.internal.format.AppendableFormatStructure;
import kotlinx.datetime.internal.format.BasicFormatStructure;
import kotlinx.datetime.internal.format.CachedFormatStructure;
import kotlinx.datetime.internal.format.FormatStructure;
import kotlinx.datetime.internal.format.SignedFormatStructure;
import kotlinx.datetime.internal.format.parser.Copyable;

@Metadata
/* loaded from: classes3.dex */
public final class DateTimeComponentsFormat extends AbstractDateTimeFormat<DateTimeComponents, DateTimeComponentsContents> {

    /* renamed from: a, reason: collision with root package name */
    public final CachedFormatStructure f55405a;

    @Metadata
    public static final class Builder implements AbstractDateTimeFormatBuilder<DateTimeComponentsContents, Builder>, AbstractWithDateTimeBuilder, AbstractWithOffsetBuilder, DateTimeFormatBuilder.WithDateTimeComponents {

        /* renamed from: a, reason: collision with root package name */
        public final AppendableFormatStructure f55406a;

        public Builder(AppendableFormatStructure actualBuilder) {
            Intrinsics.checkNotNullParameter(actualBuilder, "actualBuilder");
            this.f55406a = actualBuilder;
        }

        @Override // kotlinx.datetime.format.AbstractDateTimeFormatBuilder
        public final AppendableFormatStructure a() {
            return this.f55406a;
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

        @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithUtcOffset
        public final void e() {
            Padding padding = Padding.f55479b;
            Intrinsics.checkNotNullParameter(padding, "padding");
            x(new BasicFormatStructure(new UtcOffsetMinuteOfHourDirective()));
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

        @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithUtcOffset
        public final void o() {
            Padding padding = Padding.f55479b;
            Intrinsics.checkNotNullParameter(padding, "padding");
            x(new SignedFormatStructure(new BasicFormatStructure(new UtcOffsetWholeHoursDirective())));
        }

        @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithTime
        public final void p(int i2, int i3) {
            AbstractWithTimeBuilder.DefaultImpls.a(this, i2, i3);
        }

        @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithUtcOffset
        public final void q(UtcOffsetFormat format) {
            Intrinsics.checkNotNullParameter(format, "format");
            if (format != null) {
                x(format.f55495a);
            }
        }

        @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithUtcOffset
        public final void r() {
            Padding padding = Padding.f55479b;
            Intrinsics.checkNotNullParameter(padding, "padding");
            x(new BasicFormatStructure(new UtcOffsetSecondOfMinuteDirective()));
        }

        @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithDate
        public final void s(DayOfWeekNames names) {
            Intrinsics.checkNotNullParameter(names, "names");
            Intrinsics.checkNotNullParameter(names, "names");
            BasicFormatStructure structure = new BasicFormatStructure(new DayOfWeekDirective(names));
            Intrinsics.checkNotNullParameter(structure, "structure");
            w(structure);
        }

        @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithDate
        public final void t(Padding padding) {
            Intrinsics.checkNotNullParameter(padding, "padding");
            Intrinsics.checkNotNullParameter(padding, "padding");
            v(new BasicFormatStructure(new DayDirective(padding)));
        }

        @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithDate
        public final void u(MonthNames names) {
            Intrinsics.checkNotNullParameter(names, "names");
            Intrinsics.checkNotNullParameter(names, "names");
            BasicFormatStructure structure = new BasicFormatStructure(new MonthNameDirective(names));
            Intrinsics.checkNotNullParameter(structure, "structure");
            w(structure);
        }

        public final void v(FormatStructure structure) {
            Intrinsics.checkNotNullParameter(structure, "structure");
            w(structure);
        }

        public final void w(FormatStructure structure) {
            Intrinsics.checkNotNullParameter(structure, "structure");
            this.f55406a.a(structure);
        }

        public final void x(FormatStructure structure) {
            Intrinsics.checkNotNullParameter(structure, "structure");
            this.f55406a.a(structure);
        }
    }

    public DateTimeComponentsFormat(CachedFormatStructure actualFormat) {
        Intrinsics.checkNotNullParameter(actualFormat, "actualFormat");
        this.f55405a = actualFormat;
    }

    @Override // kotlinx.datetime.format.AbstractDateTimeFormat
    public final CachedFormatStructure a() {
        return this.f55405a;
    }

    @Override // kotlinx.datetime.format.AbstractDateTimeFormat
    public final Copyable b() {
        return DateTimeComponentsKt.f55407a;
    }

    @Override // kotlinx.datetime.format.AbstractDateTimeFormat
    public final Object c(Copyable copyable) {
        DateTimeComponentsContents intermediate = (DateTimeComponentsContents) copyable;
        Intrinsics.checkNotNullParameter(intermediate, "intermediate");
        return new DateTimeComponents(intermediate);
    }
}
