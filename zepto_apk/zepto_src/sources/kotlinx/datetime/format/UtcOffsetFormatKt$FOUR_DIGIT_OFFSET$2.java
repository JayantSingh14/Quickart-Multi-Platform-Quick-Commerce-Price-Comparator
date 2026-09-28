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
public final class UtcOffsetFormatKt$FOUR_DIGIT_OFFSET$2 extends Lambda implements Function0<UtcOffsetFormat> {

    /* renamed from: c, reason: collision with root package name */
    public static final UtcOffsetFormatKt$FOUR_DIGIT_OFFSET$2 f55501c = new UtcOffsetFormatKt$FOUR_DIGIT_OFFSET$2(0);

    @Metadata
    /* renamed from: kotlinx.datetime.format.UtcOffsetFormatKt$FOUR_DIGIT_OFFSET$2$1, reason: invalid class name */
    final class AnonymousClass1 extends Lambda implements Function1<DateTimeFormatBuilder.WithUtcOffset, Unit> {

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass1 f55502c = new AnonymousClass1(1);

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            DateTimeFormatBuilder.WithUtcOffset build = (DateTimeFormatBuilder.WithUtcOffset) obj;
            Intrinsics.checkNotNullParameter(build, "$this$build");
            DateTimeFormatBuilder.WithUtcOffset.DefaultImpls.a(build);
            DateTimeFormatBuilder.WithUtcOffset.DefaultImpls.b(build);
            return Unit.f53572a;
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return UtcOffsetFormat.Companion.a(AnonymousClass1.f55502c);
    }
}
