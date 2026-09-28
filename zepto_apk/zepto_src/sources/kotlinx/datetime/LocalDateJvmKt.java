package kotlinx.datetime;

import j$.time.DateTimeException;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@JvmName
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class LocalDateJvmKt {

    /* renamed from: a, reason: collision with root package name */
    public static final long f55355a = j$.time.LocalDate.MIN.toEpochDay();

    /* renamed from: b, reason: collision with root package name */
    public static final long f55356b = j$.time.LocalDate.MAX.toEpochDay();

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f55357c = 0;

    public static final j$.time.LocalDate a(long j2) {
        if (j2 <= f55356b && f55355a <= j2) {
            j$.time.LocalDate localDateOfEpochDay = j$.time.LocalDate.ofEpochDay(j2);
            Intrinsics.checkNotNullExpressionValue(localDateOfEpochDay, "ofEpochDay(...)");
            return localDateOfEpochDay;
        }
        throw new DateTimeException("The resulting day " + j2 + " is out of supported LocalDate range.");
    }
}
