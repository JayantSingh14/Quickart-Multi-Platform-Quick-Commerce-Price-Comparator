package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.TimeZones;

@Metadata
/* loaded from: classes3.dex */
public final class DateTimeComponents$Formats$RFC_1123$1 extends Lambda implements Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit> {

    /* renamed from: c, reason: collision with root package name */
    public static final DateTimeComponents$Formats$RFC_1123$1 f55393c = new DateTimeComponents$Formats$RFC_1123$1(1);

    @Metadata
    /* renamed from: kotlinx.datetime.format.DateTimeComponents$Formats$RFC_1123$1$1, reason: invalid class name */
    final class AnonymousClass1 extends Lambda implements Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit> {

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass1 f55394c = new AnonymousClass1(1);

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            DateTimeFormatBuilder.WithDateTimeComponents alternativeParsing = (DateTimeFormatBuilder.WithDateTimeComponents) obj;
            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
            return Unit.f53572a;
        }
    }

    @Metadata
    /* renamed from: kotlinx.datetime.format.DateTimeComponents$Formats$RFC_1123$1$2, reason: invalid class name */
    final class AnonymousClass2 extends Lambda implements Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit> {

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass2 f55395c = new AnonymousClass2(1);

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            DateTimeFormatBuilder.WithDateTimeComponents alternativeParsing = (DateTimeFormatBuilder.WithDateTimeComponents) obj;
            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
            alternativeParsing.s(DayOfWeekNames.f55413b);
            alternativeParsing.h(", ");
            return Unit.f53572a;
        }
    }

    @Metadata
    /* renamed from: kotlinx.datetime.format.DateTimeComponents$Formats$RFC_1123$1$3, reason: invalid class name */
    final class AnonymousClass3 extends Lambda implements Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit> {

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass3 f55396c = new AnonymousClass3(1);

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            DateTimeFormatBuilder.WithDateTimeComponents optional = (DateTimeFormatBuilder.WithDateTimeComponents) obj;
            Intrinsics.checkNotNullParameter(optional, "$this$optional");
            DateTimeFormatBuilderKt.b(optional, ':');
            DateTimeFormatBuilder.WithTime.DefaultImpls.c(optional);
            return Unit.f53572a;
        }
    }

    @Metadata
    /* renamed from: kotlinx.datetime.format.DateTimeComponents$Formats$RFC_1123$1$4, reason: invalid class name */
    final class AnonymousClass4 extends Lambda implements Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit> {

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass4 f55397c = new AnonymousClass4(1);

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            DateTimeFormatBuilder.WithDateTimeComponents alternativeParsing = (DateTimeFormatBuilder.WithDateTimeComponents) obj;
            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
            alternativeParsing.h("UT");
            return Unit.f53572a;
        }
    }

    @Metadata
    /* renamed from: kotlinx.datetime.format.DateTimeComponents$Formats$RFC_1123$1$5, reason: invalid class name */
    final class AnonymousClass5 extends Lambda implements Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit> {

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass5 f55398c = new AnonymousClass5(1);

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            DateTimeFormatBuilder.WithDateTimeComponents alternativeParsing = (DateTimeFormatBuilder.WithDateTimeComponents) obj;
            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
            alternativeParsing.h("Z");
            return Unit.f53572a;
        }
    }

    @Metadata
    /* renamed from: kotlinx.datetime.format.DateTimeComponents$Formats$RFC_1123$1$6, reason: invalid class name */
    final class AnonymousClass6 extends Lambda implements Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit> {

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass6 f55399c = new AnonymousClass6(1);

        @Metadata
        /* renamed from: kotlinx.datetime.format.DateTimeComponents$Formats$RFC_1123$1$6$1, reason: invalid class name */
        final class AnonymousClass1 extends Lambda implements Function1<DateTimeFormatBuilder.WithDateTimeComponents, Unit> {

            /* renamed from: c, reason: collision with root package name */
            public static final AnonymousClass1 f55400c = new AnonymousClass1(1);

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                DateTimeFormatBuilder.WithDateTimeComponents optional = (DateTimeFormatBuilder.WithDateTimeComponents) obj;
                Intrinsics.checkNotNullParameter(optional, "$this$optional");
                optional.q((UtcOffsetFormat) UtcOffsetFormatKt.f55499c.getValue());
                return Unit.f53572a;
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            DateTimeFormatBuilder.WithDateTimeComponents alternativeParsing = (DateTimeFormatBuilder.WithDateTimeComponents) obj;
            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
            DateTimeFormatBuilderKt.c(alternativeParsing, TimeZones.GMT_ID, AnonymousClass1.f55400c);
            return Unit.f53572a;
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        DateTimeFormatBuilder.WithDateTimeComponents Format = (DateTimeFormatBuilder.WithDateTimeComponents) obj;
        Intrinsics.checkNotNullParameter(Format, "$this$Format");
        DateTimeFormatBuilderKt.a(Format, new Function1[]{AnonymousClass1.f55394c}, AnonymousClass2.f55395c);
        Format.t(Padding.f55478a);
        DateTimeFormatBuilderKt.b(Format, ' ');
        Format.u(MonthNames.f55467b);
        DateTimeFormatBuilderKt.b(Format, ' ');
        DateTimeFormatBuilder.WithDate.DefaultImpls.a(Format);
        DateTimeFormatBuilderKt.b(Format, ' ');
        DateTimeFormatBuilder.WithTime.DefaultImpls.a(Format);
        DateTimeFormatBuilderKt.b(Format, ':');
        DateTimeFormatBuilder.WithTime.DefaultImpls.b(Format);
        DateTimeFormatBuilderKt.c(Format, "", AnonymousClass3.f55396c);
        Format.h(StringUtils.SPACE);
        DateTimeFormatBuilderKt.a(Format, new Function1[]{AnonymousClass4.f55397c, AnonymousClass5.f55398c}, AnonymousClass6.f55399c);
        return Unit.f53572a;
    }
}
