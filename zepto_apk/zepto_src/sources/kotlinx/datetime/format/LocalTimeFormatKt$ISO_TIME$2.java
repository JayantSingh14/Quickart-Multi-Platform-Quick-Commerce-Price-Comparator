package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.datetime.format.AbstractDateTimeFormatBuilder;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.format.LocalTimeFormat;
import kotlinx.datetime.internal.format.AppendableFormatStructure;
import org.apache.commons.lang3.ClassUtils;

@Metadata
/* loaded from: classes3.dex */
public final class LocalTimeFormatKt$ISO_TIME$2 extends Lambda implements Function0<LocalTimeFormat> {

    /* renamed from: c, reason: collision with root package name */
    public static final LocalTimeFormatKt$ISO_TIME$2 f55459c = new LocalTimeFormatKt$ISO_TIME$2(0);

    @Metadata
    /* renamed from: kotlinx.datetime.format.LocalTimeFormatKt$ISO_TIME$2$1, reason: invalid class name */
    final class AnonymousClass1 extends Lambda implements Function1<DateTimeFormatBuilder.WithTime, Unit> {

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass1 f55460c = new AnonymousClass1(1);

        @Metadata
        /* renamed from: kotlinx.datetime.format.LocalTimeFormatKt$ISO_TIME$2$1$1, reason: invalid class name and collision with other inner class name */
        final class C00661 extends Lambda implements Function1<DateTimeFormatBuilder.WithTime, Unit> {

            /* renamed from: c, reason: collision with root package name */
            public static final C00661 f55461c = new C00661(1);

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                DateTimeFormatBuilder.WithTime alternativeParsing = (DateTimeFormatBuilder.WithTime) obj;
                Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                return Unit.f53572a;
            }
        }

        @Metadata
        /* renamed from: kotlinx.datetime.format.LocalTimeFormatKt$ISO_TIME$2$1$2, reason: invalid class name */
        final class AnonymousClass2 extends Lambda implements Function1<DateTimeFormatBuilder.WithTime, Unit> {

            /* renamed from: c, reason: collision with root package name */
            public static final AnonymousClass2 f55462c = new AnonymousClass2(1);

            @Metadata
            /* renamed from: kotlinx.datetime.format.LocalTimeFormatKt$ISO_TIME$2$1$2$1, reason: invalid class name and collision with other inner class name */
            final class C00671 extends Lambda implements Function1<DateTimeFormatBuilder.WithTime, Unit> {

                /* renamed from: c, reason: collision with root package name */
                public static final C00671 f55463c = new C00671(1);

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    DateTimeFormatBuilder.WithTime optional = (DateTimeFormatBuilder.WithTime) obj;
                    Intrinsics.checkNotNullParameter(optional, "$this$optional");
                    DateTimeFormatBuilderKt.b(optional, ClassUtils.PACKAGE_SEPARATOR_CHAR);
                    optional.p(1, 9);
                    return Unit.f53572a;
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                DateTimeFormatBuilder.WithTime alternativeParsing = (DateTimeFormatBuilder.WithTime) obj;
                Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                DateTimeFormatBuilderKt.b(alternativeParsing, ':');
                DateTimeFormatBuilder.WithTime.DefaultImpls.c(alternativeParsing);
                DateTimeFormatBuilderKt.c(alternativeParsing, "", C00671.f55463c);
                return Unit.f53572a;
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            DateTimeFormatBuilder.WithTime build = (DateTimeFormatBuilder.WithTime) obj;
            Intrinsics.checkNotNullParameter(build, "$this$build");
            DateTimeFormatBuilder.WithTime.DefaultImpls.a(build);
            DateTimeFormatBuilderKt.b(build, ':');
            DateTimeFormatBuilder.WithTime.DefaultImpls.b(build);
            DateTimeFormatBuilderKt.a(build, new Function1[]{C00661.f55461c}, AnonymousClass2.f55462c);
            return Unit.f53572a;
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        AnonymousClass1 block = AnonymousClass1.f55460c;
        Intrinsics.checkNotNullParameter(block, "block");
        LocalTimeFormat.Builder builder = new LocalTimeFormat.Builder(new AppendableFormatStructure());
        block.invoke(builder);
        return new LocalTimeFormat(AbstractDateTimeFormatBuilder.DefaultImpls.c(builder));
    }
}
