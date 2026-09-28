package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.format.AbstractDateTimeFormatBuilder;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.format.LocalDateFormat;
import kotlinx.datetime.internal.format.AppendableFormatStructure;
import org.apache.commons.codec.language.Soundex;

@Metadata
/* loaded from: classes3.dex */
public final class LocalDateFormatKt$ISO_DATE$2 extends Lambda implements Function0<DateTimeFormat<LocalDate>> {

    /* renamed from: c, reason: collision with root package name */
    public static final LocalDateFormatKt$ISO_DATE$2 f55443c = new LocalDateFormatKt$ISO_DATE$2(0);

    @Metadata
    /* renamed from: kotlinx.datetime.format.LocalDateFormatKt$ISO_DATE$2$1, reason: invalid class name */
    final class AnonymousClass1 extends Lambda implements Function1<DateTimeFormatBuilder.WithDate, Unit> {

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass1 f55444c = new AnonymousClass1(1);

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            DateTimeFormatBuilder.WithDate build = (DateTimeFormatBuilder.WithDate) obj;
            Intrinsics.checkNotNullParameter(build, "$this$build");
            DateTimeFormatBuilder.WithDate.DefaultImpls.a(build);
            DateTimeFormatBuilderKt.b(build, Soundex.SILENT_MARKER);
            Padding padding = Padding.f55478a;
            build.c();
            DateTimeFormatBuilderKt.b(build, Soundex.SILENT_MARKER);
            build.t(Padding.f55479b);
            return Unit.f53572a;
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        AnonymousClass1 block = AnonymousClass1.f55444c;
        Intrinsics.checkNotNullParameter(block, "block");
        LocalDateFormat.Builder builder = new LocalDateFormat.Builder(new AppendableFormatStructure());
        block.invoke(builder);
        return new LocalDateFormat(AbstractDateTimeFormatBuilder.DefaultImpls.c(builder));
    }
}
