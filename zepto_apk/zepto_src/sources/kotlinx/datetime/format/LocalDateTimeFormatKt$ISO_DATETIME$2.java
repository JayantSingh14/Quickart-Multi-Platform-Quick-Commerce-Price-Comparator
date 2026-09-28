package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.datetime.format.AbstractDateTimeFormatBuilder;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.format.LocalDateTimeFormat;
import kotlinx.datetime.internal.format.AppendableFormatStructure;

@Metadata
/* loaded from: classes3.dex */
public final class LocalDateTimeFormatKt$ISO_DATETIME$2 extends Lambda implements Function0<LocalDateTimeFormat> {

    /* renamed from: c, reason: collision with root package name */
    public static final LocalDateTimeFormatKt$ISO_DATETIME$2 f55451c = new LocalDateTimeFormatKt$ISO_DATETIME$2(0);

    @Metadata
    /* renamed from: kotlinx.datetime.format.LocalDateTimeFormatKt$ISO_DATETIME$2$1, reason: invalid class name */
    final class AnonymousClass1 extends Lambda implements Function1<DateTimeFormatBuilder.WithDateTime, Unit> {

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass1 f55452c = new AnonymousClass1(1);

        @Metadata
        /* renamed from: kotlinx.datetime.format.LocalDateTimeFormatKt$ISO_DATETIME$2$1$1, reason: invalid class name and collision with other inner class name */
        final class C00651 extends Lambda implements Function1<DateTimeFormatBuilder.WithDateTime, Unit> {

            /* renamed from: c, reason: collision with root package name */
            public static final C00651 f55453c = new C00651(1);

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                DateTimeFormatBuilder.WithDateTime alternativeParsing = (DateTimeFormatBuilder.WithDateTime) obj;
                Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                DateTimeFormatBuilderKt.b(alternativeParsing, 't');
                return Unit.f53572a;
            }
        }

        @Metadata
        /* renamed from: kotlinx.datetime.format.LocalDateTimeFormatKt$ISO_DATETIME$2$1$2, reason: invalid class name */
        final class AnonymousClass2 extends Lambda implements Function1<DateTimeFormatBuilder.WithDateTime, Unit> {

            /* renamed from: c, reason: collision with root package name */
            public static final AnonymousClass2 f55454c = new AnonymousClass2(1);

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                DateTimeFormatBuilder.WithDateTime alternativeParsing = (DateTimeFormatBuilder.WithDateTime) obj;
                Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                DateTimeFormatBuilderKt.b(alternativeParsing, 'T');
                return Unit.f53572a;
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            DateTimeFormatBuilder.WithDateTime build = (DateTimeFormatBuilder.WithDateTime) obj;
            Intrinsics.checkNotNullParameter(build, "$this$build");
            build.f(LocalDateFormatKt.a());
            DateTimeFormatBuilderKt.a(build, new Function1[]{C00651.f55453c}, AnonymousClass2.f55454c);
            build.i((LocalTimeFormat) LocalTimeFormatKt.f55457a.getValue());
            return Unit.f53572a;
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        AnonymousClass1 block = AnonymousClass1.f55452c;
        Intrinsics.checkNotNullParameter(block, "block");
        LocalDateTimeFormat.Builder builder = new LocalDateTimeFormat.Builder(new AppendableFormatStructure());
        block.invoke(builder);
        return new LocalDateTimeFormat(AbstractDateTimeFormatBuilder.DefaultImpls.c(builder));
    }
}
