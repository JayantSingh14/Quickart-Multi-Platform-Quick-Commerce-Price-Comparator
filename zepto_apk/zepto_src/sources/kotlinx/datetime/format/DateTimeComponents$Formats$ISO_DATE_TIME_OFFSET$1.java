package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import org.apache.commons.lang3.ClassUtils;

@Metadata
/* loaded from: classes3.dex */
public final class DateTimeComponents$Formats$ISO_DATE_TIME_OFFSET$1 extends Lambda implements Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit> {

    /* renamed from: c, reason: collision with root package name */
    public static final DateTimeComponents$Formats$ISO_DATE_TIME_OFFSET$1 f55387c = new DateTimeComponents$Formats$ISO_DATE_TIME_OFFSET$1(1);

    @Metadata
    /* renamed from: kotlinx.datetime.format.DateTimeComponents$Formats$ISO_DATE_TIME_OFFSET$1$1, reason: invalid class name */
    final class AnonymousClass1 extends Lambda implements Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit> {

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass1 f55388c = new AnonymousClass1(1);

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            DateTimeFormatBuilder.WithDateTimeComponents alternativeParsing = (DateTimeFormatBuilder.WithDateTimeComponents) obj;
            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
            DateTimeFormatBuilderKt.b(alternativeParsing, 't');
            return Unit.f53572a;
        }
    }

    @Metadata
    /* renamed from: kotlinx.datetime.format.DateTimeComponents$Formats$ISO_DATE_TIME_OFFSET$1$2, reason: invalid class name */
    final class AnonymousClass2 extends Lambda implements Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit> {

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass2 f55389c = new AnonymousClass2(1);

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            DateTimeFormatBuilder.WithDateTimeComponents alternativeParsing = (DateTimeFormatBuilder.WithDateTimeComponents) obj;
            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
            DateTimeFormatBuilderKt.b(alternativeParsing, 'T');
            return Unit.f53572a;
        }
    }

    @Metadata
    /* renamed from: kotlinx.datetime.format.DateTimeComponents$Formats$ISO_DATE_TIME_OFFSET$1$3, reason: invalid class name */
    final class AnonymousClass3 extends Lambda implements Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit> {

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass3 f55390c = new AnonymousClass3(1);

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            DateTimeFormatBuilder.WithDateTimeComponents optional = (DateTimeFormatBuilder.WithDateTimeComponents) obj;
            Intrinsics.checkNotNullParameter(optional, "$this$optional");
            DateTimeFormatBuilderKt.b(optional, ClassUtils.PACKAGE_SEPARATOR_CHAR);
            optional.p(1, 9);
            return Unit.f53572a;
        }
    }

    @Metadata
    /* renamed from: kotlinx.datetime.format.DateTimeComponents$Formats$ISO_DATE_TIME_OFFSET$1$4, reason: invalid class name */
    final class AnonymousClass4 extends Lambda implements Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit> {

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass4 f55391c = new AnonymousClass4(1);

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            DateTimeFormatBuilder.WithDateTimeComponents alternativeParsing = (DateTimeFormatBuilder.WithDateTimeComponents) obj;
            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
            DateTimeFormatBuilder.WithUtcOffset.DefaultImpls.a(alternativeParsing);
            return Unit.f53572a;
        }
    }

    @Metadata
    /* renamed from: kotlinx.datetime.format.DateTimeComponents$Formats$ISO_DATE_TIME_OFFSET$1$5, reason: invalid class name */
    final class AnonymousClass5 extends Lambda implements Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit> {

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass5 f55392c = new AnonymousClass5(1);

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            DateTimeFormatBuilder.WithDateTimeComponents alternativeParsing = (DateTimeFormatBuilder.WithDateTimeComponents) obj;
            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
            alternativeParsing.q((UtcOffsetFormat) UtcOffsetFormatKt.f55497a.getValue());
            return Unit.f53572a;
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        DateTimeFormatBuilder.WithDateTimeComponents Format = (DateTimeFormatBuilder.WithDateTimeComponents) obj;
        Intrinsics.checkNotNullParameter(Format, "$this$Format");
        Format.f(LocalDateFormatKt.a());
        DateTimeFormatBuilderKt.a(Format, new Function1[]{AnonymousClass1.f55388c}, AnonymousClass2.f55389c);
        DateTimeFormatBuilder.WithTime.DefaultImpls.a(Format);
        DateTimeFormatBuilderKt.b(Format, ':');
        DateTimeFormatBuilder.WithTime.DefaultImpls.b(Format);
        DateTimeFormatBuilderKt.b(Format, ':');
        DateTimeFormatBuilder.WithTime.DefaultImpls.c(Format);
        DateTimeFormatBuilderKt.c(Format, "", AnonymousClass3.f55390c);
        DateTimeFormatBuilderKt.a(Format, new Function1[]{AnonymousClass4.f55391c}, AnonymousClass5.f55392c);
        return Unit.f53572a;
    }
}
