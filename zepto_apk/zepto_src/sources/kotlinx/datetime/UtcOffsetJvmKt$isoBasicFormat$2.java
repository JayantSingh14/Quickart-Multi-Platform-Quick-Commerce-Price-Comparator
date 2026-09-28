package kotlinx.datetime;

import j$.time.format.DateTimeFormatter;
import j$.time.format.DateTimeFormatterBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
public final class UtcOffsetJvmKt$isoBasicFormat$2 extends Lambda implements Function0<DateTimeFormatter> {

    /* renamed from: c, reason: collision with root package name */
    public static final UtcOffsetJvmKt$isoBasicFormat$2 f55368c = new UtcOffsetJvmKt$isoBasicFormat$2(0);

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return new DateTimeFormatterBuilder().parseCaseInsensitive().appendOffset("+HHmmss", "Z").toFormatter();
    }
}
