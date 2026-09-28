package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
public final class LocalTimeFormat extends AbstractDateTimeFormat<LocalTime, IncompleteLocalTime> {

    /* renamed from: a, reason: collision with root package name */
    public final CachedFormatStructure f55455a;

    @Metadata
    public static final class Builder implements AbstractDateTimeFormatBuilder<TimeFieldContainer, Builder>, AbstractWithTimeBuilder {

        /* renamed from: a, reason: collision with root package name */
        public final AppendableFormatStructure f55456a;

        public Builder(AppendableFormatStructure actualBuilder) {
            Intrinsics.checkNotNullParameter(actualBuilder, "actualBuilder");
            this.f55456a = actualBuilder;
        }

        @Override // kotlinx.datetime.format.AbstractDateTimeFormatBuilder
        public final AppendableFormatStructure a() {
            return this.f55456a;
        }

        @Override // kotlinx.datetime.format.AbstractDateTimeFormatBuilder
        public final void b(String str, Function1 function1) {
            AbstractDateTimeFormatBuilder.DefaultImpls.b(this, str, function1);
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

        @Override // kotlinx.datetime.format.AbstractWithTimeBuilder
        public final void k(FormatStructure structure) {
            Intrinsics.checkNotNullParameter(structure, "structure");
            this.f55456a.a(structure);
        }

        @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithTime
        public final void l() {
            Padding padding = Padding.f55479b;
            Intrinsics.checkNotNullParameter(padding, "padding");
            k(new BasicFormatStructure(new MinuteDirective()));
        }

        @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithTime
        public final void m() {
            Padding padding = Padding.f55479b;
            Intrinsics.checkNotNullParameter(padding, "padding");
            k(new BasicFormatStructure(new SecondDirective()));
        }

        @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithTime
        public final void n() {
            Padding padding = Padding.f55479b;
            Intrinsics.checkNotNullParameter(padding, "padding");
            k(new BasicFormatStructure(new HourDirective()));
        }

        @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithTime
        public final void p(int i2, int i3) {
            AbstractWithTimeBuilder.DefaultImpls.a(this, i2, i3);
        }
    }

    @Metadata
    public static final class Companion {
    }

    public LocalTimeFormat(CachedFormatStructure actualFormat) {
        Intrinsics.checkNotNullParameter(actualFormat, "actualFormat");
        this.f55455a = actualFormat;
    }

    @Override // kotlinx.datetime.format.AbstractDateTimeFormat
    public final CachedFormatStructure a() {
        return this.f55455a;
    }

    @Override // kotlinx.datetime.format.AbstractDateTimeFormat
    public final Copyable b() {
        return LocalTimeFormatKt.f55458b;
    }

    @Override // kotlinx.datetime.format.AbstractDateTimeFormat
    public final Object c(Copyable copyable) {
        IncompleteLocalTime intermediate = (IncompleteLocalTime) copyable;
        Intrinsics.checkNotNullParameter(intermediate, "intermediate");
        return intermediate.d();
    }
}
