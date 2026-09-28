package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.format.UtcOffsetFormat;

@Metadata
/* loaded from: classes3.dex */
public final class UtcOffsetFormatKt$ISO_OFFSET_BASIC$2 extends Lambda implements Function0<UtcOffsetFormat> {

    /* renamed from: c, reason: collision with root package name */
    public static final UtcOffsetFormatKt$ISO_OFFSET_BASIC$2 f55509c = new UtcOffsetFormatKt$ISO_OFFSET_BASIC$2(0);

    @Metadata
    /* renamed from: kotlinx.datetime.format.UtcOffsetFormatKt$ISO_OFFSET_BASIC$2$1, reason: invalid class name */
    final class AnonymousClass1 extends Lambda implements Function1<DateTimeFormatBuilder.WithUtcOffset, Unit> {

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass1 f55510c = new AnonymousClass1(1);

        @Metadata
        /* renamed from: kotlinx.datetime.format.UtcOffsetFormatKt$ISO_OFFSET_BASIC$2$1$1, reason: invalid class name and collision with other inner class name */
        final class C00711 extends Lambda implements Function1<DateTimeFormatBuilder.WithUtcOffset, Unit> {

            /* renamed from: c, reason: collision with root package name */
            public static final C00711 f55511c = new C00711(1);

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                DateTimeFormatBuilder.WithUtcOffset alternativeParsing = (DateTimeFormatBuilder.WithUtcOffset) obj;
                Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                alternativeParsing.h("z");
                return Unit.f53572a;
            }
        }

        @Metadata
        /* renamed from: kotlinx.datetime.format.UtcOffsetFormatKt$ISO_OFFSET_BASIC$2$1$2, reason: invalid class name */
        final class AnonymousClass2 extends Lambda implements Function1<DateTimeFormatBuilder.WithUtcOffset, Unit> {

            /* renamed from: c, reason: collision with root package name */
            public static final AnonymousClass2 f55512c = new AnonymousClass2(1);

            @Metadata
            /* renamed from: kotlinx.datetime.format.UtcOffsetFormatKt$ISO_OFFSET_BASIC$2$1$2$1, reason: invalid class name and collision with other inner class name */
            final class C00721 extends Lambda implements Function1<DateTimeFormatBuilder.WithUtcOffset, Unit> {

                /* renamed from: c, reason: collision with root package name */
                public static final C00721 f55513c = new C00721(1);

                @Metadata
                /* renamed from: kotlinx.datetime.format.UtcOffsetFormatKt$ISO_OFFSET_BASIC$2$1$2$1$1, reason: invalid class name and collision with other inner class name */
                final class C00731 extends Lambda implements Function1<DateTimeFormatBuilder.WithUtcOffset, Unit> {

                    /* renamed from: c, reason: collision with root package name */
                    public static final C00731 f55514c = new C00731(1);

                    @Metadata
                    /* renamed from: kotlinx.datetime.format.UtcOffsetFormatKt$ISO_OFFSET_BASIC$2$1$2$1$1$1, reason: invalid class name and collision with other inner class name */
                    final class C00741 extends Lambda implements Function1<DateTimeFormatBuilder.WithUtcOffset, Unit> {

                        /* renamed from: c, reason: collision with root package name */
                        public static final C00741 f55515c = new C00741(1);

                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            DateTimeFormatBuilder.WithUtcOffset optional = (DateTimeFormatBuilder.WithUtcOffset) obj;
                            Intrinsics.checkNotNullParameter(optional, "$this$optional");
                            DateTimeFormatBuilder.WithUtcOffset.DefaultImpls.c(optional);
                            return Unit.f53572a;
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        DateTimeFormatBuilder.WithUtcOffset optional = (DateTimeFormatBuilder.WithUtcOffset) obj;
                        Intrinsics.checkNotNullParameter(optional, "$this$optional");
                        DateTimeFormatBuilder.WithUtcOffset.DefaultImpls.b(optional);
                        DateTimeFormatBuilderKt.c(optional, "", C00741.f55515c);
                        return Unit.f53572a;
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    DateTimeFormatBuilder.WithUtcOffset optional = (DateTimeFormatBuilder.WithUtcOffset) obj;
                    Intrinsics.checkNotNullParameter(optional, "$this$optional");
                    DateTimeFormatBuilder.WithUtcOffset.DefaultImpls.a(optional);
                    DateTimeFormatBuilderKt.c(optional, "", C00731.f55514c);
                    return Unit.f53572a;
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                DateTimeFormatBuilder.WithUtcOffset alternativeParsing = (DateTimeFormatBuilder.WithUtcOffset) obj;
                Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                DateTimeFormatBuilderKt.c(alternativeParsing, "Z", C00721.f55513c);
                return Unit.f53572a;
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            DateTimeFormatBuilder.WithUtcOffset build = (DateTimeFormatBuilder.WithUtcOffset) obj;
            Intrinsics.checkNotNullParameter(build, "$this$build");
            DateTimeFormatBuilderKt.a(build, new Function1[]{C00711.f55511c}, AnonymousClass2.f55512c);
            return Unit.f53572a;
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return UtcOffsetFormat.Companion.a(AnonymousClass1.f55510c);
    }
}
