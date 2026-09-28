package kotlinx.datetime.format;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class DateTimeFormatBuilderKt {
    public static final void a(DateTimeFormatBuilder dateTimeFormatBuilder, Function1[] alternativeFormats, Function1 primaryFormat) {
        Intrinsics.checkNotNullParameter(dateTimeFormatBuilder, "<this>");
        Intrinsics.checkNotNullParameter(alternativeFormats, "alternativeFormats");
        Intrinsics.checkNotNullParameter(primaryFormat, "primaryFormat");
        if (!(dateTimeFormatBuilder instanceof AbstractDateTimeFormatBuilder)) {
            throw new IllegalStateException("impossible");
        }
        Function1[] function1Arr = (Function1[]) Arrays.copyOf(alternativeFormats, alternativeFormats.length);
        TypeIntrinsics.b(1, primaryFormat);
        ((AbstractDateTimeFormatBuilder) dateTimeFormatBuilder).d(function1Arr, primaryFormat);
    }

    public static final void b(DateTimeFormatBuilder dateTimeFormatBuilder, char c2) {
        Intrinsics.checkNotNullParameter(dateTimeFormatBuilder, "<this>");
        dateTimeFormatBuilder.h(String.valueOf(c2));
    }

    public static final void c(DateTimeFormatBuilder dateTimeFormatBuilder, String ifZero, Function1 format) {
        Intrinsics.checkNotNullParameter(dateTimeFormatBuilder, "<this>");
        Intrinsics.checkNotNullParameter(ifZero, "ifZero");
        Intrinsics.checkNotNullParameter(format, "format");
        if (!(dateTimeFormatBuilder instanceof AbstractDateTimeFormatBuilder)) {
            throw new IllegalStateException("impossible");
        }
        TypeIntrinsics.b(1, format);
        ((AbstractDateTimeFormatBuilder) dateTimeFormatBuilder).b(ifZero, format);
    }
}
