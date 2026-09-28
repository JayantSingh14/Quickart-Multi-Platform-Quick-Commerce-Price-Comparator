package kotlinx.datetime;

import j$.time.DateTimeException;
import j$.time.ZoneOffset;
import j$.time.format.DateTimeFormatter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class UtcOffsetJvmKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Lazy f55364a = LazyKt.b(UtcOffsetJvmKt$isoFormat$2.f55369c);

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f55365b = LazyKt.b(UtcOffsetJvmKt$isoBasicFormat$2.f55368c);

    /* renamed from: c, reason: collision with root package name */
    public static final Lazy f55366c = LazyKt.b(UtcOffsetJvmKt$fourDigitsFormat$2.f55367c);

    public static final UtcOffset a(String str, DateTimeFormatter dateTimeFormatter) {
        try {
            return new UtcOffset((ZoneOffset) dateTimeFormatter.parse(str, new a()));
        } catch (DateTimeException cause) {
            Intrinsics.checkNotNullParameter(cause, "cause");
            throw new DateTimeFormatException(cause);
        }
    }
}
