package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.datetime.format.DateTimeFormatBuilder;

@Metadata
/* loaded from: classes3.dex */
final class UtcOffsetFormatKt$isoOffset$2 extends Lambda implements Function1<DateTimeFormatBuilder.WithUtcOffset, Unit> {

    @Metadata
    /* renamed from: kotlinx.datetime.format.UtcOffsetFormatKt$isoOffset$2$1, reason: invalid class name */
    final class AnonymousClass1 extends Lambda implements Function1<DateTimeFormatBuilder.WithUtcOffset, Unit> {
        static {
            new AnonymousClass1(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            DateTimeFormatBuilder.WithUtcOffset alternativeParsing = (DateTimeFormatBuilder.WithUtcOffset) obj;
            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
            DateTimeFormatBuilderKt.b(alternativeParsing, 'z');
            return Unit.f53572a;
        }
    }

    @Metadata
    /* renamed from: kotlinx.datetime.format.UtcOffsetFormatKt$isoOffset$2$2, reason: invalid class name */
    final class AnonymousClass2 extends Lambda implements Function1<DateTimeFormatBuilder.WithUtcOffset, Unit> {
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            DateTimeFormatBuilder.WithUtcOffset alternativeParsing = (DateTimeFormatBuilder.WithUtcOffset) obj;
            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
            throw null;
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        DateTimeFormatBuilder.WithUtcOffset optional = (DateTimeFormatBuilder.WithUtcOffset) obj;
        Intrinsics.checkNotNullParameter(optional, "$this$optional");
        throw null;
    }
}
