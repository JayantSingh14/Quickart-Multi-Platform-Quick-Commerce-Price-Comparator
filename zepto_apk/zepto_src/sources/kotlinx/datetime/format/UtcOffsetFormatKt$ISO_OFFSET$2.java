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
public final class UtcOffsetFormatKt$ISO_OFFSET$2 extends Lambda implements Function0<UtcOffsetFormat> {

    /* renamed from: c, reason: collision with root package name */
    public static final UtcOffsetFormatKt$ISO_OFFSET$2 f55503c = new UtcOffsetFormatKt$ISO_OFFSET$2(0);

    @Metadata
    /* renamed from: kotlinx.datetime.format.UtcOffsetFormatKt$ISO_OFFSET$2$1, reason: invalid class name */
    final class AnonymousClass1 extends Lambda implements Function1<DateTimeFormatBuilder.WithUtcOffset, Unit> {

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass1 f55504c = new AnonymousClass1(1);

        @Metadata
        /* renamed from: kotlinx.datetime.format.UtcOffsetFormatKt$ISO_OFFSET$2$1$1, reason: invalid class name and collision with other inner class name */
        final class C00681 extends Lambda implements Function1<DateTimeFormatBuilder.WithUtcOffset, Unit> {

            /* renamed from: c, reason: collision with root package name */
            public static final C00681 f55505c = new C00681(1);

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                DateTimeFormatBuilder.WithUtcOffset alternativeParsing = (DateTimeFormatBuilder.WithUtcOffset) obj;
                Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                alternativeParsing.h("z");
                return Unit.f53572a;
            }
        }

        @Metadata
        /* renamed from: kotlinx.datetime.format.UtcOffsetFormatKt$ISO_OFFSET$2$1$2, reason: invalid class name */
        final class AnonymousClass2 extends Lambda implements Function1<DateTimeFormatBuilder.WithUtcOffset, Unit> {

            /* renamed from: c, reason: collision with root package name */
            public static final AnonymousClass2 f55506c = new AnonymousClass2(1);

            @Metadata
            /* renamed from: kotlinx.datetime.format.UtcOffsetFormatKt$ISO_OFFSET$2$1$2$1, reason: invalid class name and collision with other inner class name */
            final class C00691 extends Lambda implements Function1<DateTimeFormatBuilder.WithUtcOffset, Unit> {

                /* renamed from: c, reason: collision with root package name */
                public static final C00691 f55507c = new C00691(1);

                @Metadata
                /* renamed from: kotlinx.datetime.format.UtcOffsetFormatKt$ISO_OFFSET$2$1$2$1$1, reason: invalid class name and collision with other inner class name */
                final class C00701 extends Lambda implements Function1<DateTimeFormatBuilder.WithUtcOffset, Unit> {

                    /* renamed from: c, reason: collision with root package name */
                    public static final C00701 f55508c = new C00701(1);

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        DateTimeFormatBuilder.WithUtcOffset optional = (DateTimeFormatBuilder.WithUtcOffset) obj;
                        Intrinsics.checkNotNullParameter(optional, "$this$optional");
                        DateTimeFormatBuilderKt.b(optional, ':');
                        DateTimeFormatBuilder.WithUtcOffset.DefaultImpls.c(optional);
                        return Unit.f53572a;
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    DateTimeFormatBuilder.WithUtcOffset optional = (DateTimeFormatBuilder.WithUtcOffset) obj;
                    Intrinsics.checkNotNullParameter(optional, "$this$optional");
                    DateTimeFormatBuilder.WithUtcOffset.DefaultImpls.a(optional);
                    DateTimeFormatBuilderKt.b(optional, ':');
                    DateTimeFormatBuilder.WithUtcOffset.DefaultImpls.b(optional);
                    DateTimeFormatBuilderKt.c(optional, "", C00701.f55508c);
                    return Unit.f53572a;
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                DateTimeFormatBuilder.WithUtcOffset alternativeParsing = (DateTimeFormatBuilder.WithUtcOffset) obj;
                Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                DateTimeFormatBuilderKt.c(alternativeParsing, "Z", C00691.f55507c);
                return Unit.f53572a;
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            DateTimeFormatBuilder.WithUtcOffset build = (DateTimeFormatBuilder.WithUtcOffset) obj;
            Intrinsics.checkNotNullParameter(build, "$this$build");
            DateTimeFormatBuilderKt.a(build, new Function1[]{C00681.f55505c}, AnonymousClass2.f55506c);
            return Unit.f53572a;
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return UtcOffsetFormat.Companion.a(AnonymousClass1.f55504c);
    }
}
