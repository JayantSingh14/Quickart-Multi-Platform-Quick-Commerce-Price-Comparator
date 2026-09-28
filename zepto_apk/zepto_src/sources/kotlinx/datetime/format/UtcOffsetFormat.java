package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.UtcOffset;
import kotlinx.datetime.format.AbstractDateTimeFormatBuilder;
import kotlinx.datetime.internal.format.AppendableFormatStructure;
import kotlinx.datetime.internal.format.BasicFormatStructure;
import kotlinx.datetime.internal.format.CachedFormatStructure;
import kotlinx.datetime.internal.format.FormatStructure;
import kotlinx.datetime.internal.format.SignedFormatStructure;
import kotlinx.datetime.internal.format.parser.Copyable;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class UtcOffsetFormat extends AbstractDateTimeFormat<UtcOffset, IncompleteUtcOffset> {

    /* renamed from: a, reason: collision with root package name */
    public final CachedFormatStructure f55495a;

    @Metadata
    public static final class Builder implements AbstractDateTimeFormatBuilder<UtcOffsetFieldContainer, Builder>, AbstractWithOffsetBuilder {

        /* renamed from: a, reason: collision with root package name */
        public final AppendableFormatStructure f55496a;

        public Builder(AppendableFormatStructure actualBuilder) {
            Intrinsics.checkNotNullParameter(actualBuilder, "actualBuilder");
            this.f55496a = actualBuilder;
        }

        @Override // kotlinx.datetime.format.AbstractDateTimeFormatBuilder
        public final AppendableFormatStructure a() {
            return this.f55496a;
        }

        @Override // kotlinx.datetime.format.AbstractDateTimeFormatBuilder
        public final void b(String str, Function1 function1) {
            AbstractDateTimeFormatBuilder.DefaultImpls.b(this, str, function1);
        }

        @Override // kotlinx.datetime.format.AbstractDateTimeFormatBuilder
        public final void d(Function1[] function1Arr, Function1 function1) {
            AbstractDateTimeFormatBuilder.DefaultImpls.a(this, function1Arr, function1);
        }

        @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithUtcOffset
        public final void e() {
            Padding padding = Padding.f55479b;
            Intrinsics.checkNotNullParameter(padding, "padding");
            v(new BasicFormatStructure(new UtcOffsetMinuteOfHourDirective()));
        }

        @Override // kotlinx.datetime.format.AbstractDateTimeFormatBuilder
        public final AbstractDateTimeFormatBuilder g() {
            return new Builder(new AppendableFormatStructure());
        }

        @Override // kotlinx.datetime.format.DateTimeFormatBuilder
        public final void h(String str) {
            AbstractDateTimeFormatBuilder.DefaultImpls.d(this, str);
        }

        @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithUtcOffset
        public final void o() {
            Padding padding = Padding.f55479b;
            Intrinsics.checkNotNullParameter(padding, "padding");
            v(new SignedFormatStructure(new BasicFormatStructure(new UtcOffsetWholeHoursDirective())));
        }

        @Override // kotlinx.datetime.format.DateTimeFormatBuilder.WithUtcOffset
        public final void r() {
            Padding padding = Padding.f55479b;
            Intrinsics.checkNotNullParameter(padding, "padding");
            v(new BasicFormatStructure(new UtcOffsetSecondOfMinuteDirective()));
        }

        public final void v(FormatStructure structure) {
            Intrinsics.checkNotNullParameter(structure, "structure");
            this.f55496a.a(structure);
        }
    }

    @Metadata
    public static final class Companion {
        public static UtcOffsetFormat a(Function1 block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder(new AppendableFormatStructure());
            block.invoke(builder);
            return new UtcOffsetFormat(AbstractDateTimeFormatBuilder.DefaultImpls.c(builder));
        }
    }

    public UtcOffsetFormat(CachedFormatStructure actualFormat) {
        Intrinsics.checkNotNullParameter(actualFormat, "actualFormat");
        this.f55495a = actualFormat;
    }

    @Override // kotlinx.datetime.format.AbstractDateTimeFormat
    public final CachedFormatStructure a() {
        return this.f55495a;
    }

    @Override // kotlinx.datetime.format.AbstractDateTimeFormat
    public final Copyable b() {
        return UtcOffsetFormatKt.f55500d;
    }

    @Override // kotlinx.datetime.format.AbstractDateTimeFormat
    public final Object c(Copyable copyable) {
        IncompleteUtcOffset intermediate = (IncompleteUtcOffset) copyable;
        Intrinsics.checkNotNullParameter(intermediate, "intermediate");
        return intermediate.a();
    }
}
