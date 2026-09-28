package kotlinx.datetime;

import j$.time.chrono.ChronoLocalDateTime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.format.LocalDateTimeFormat;
import kotlinx.datetime.format.LocalDateTimeFormatKt;
import kotlinx.datetime.serializers.LocalDateTimeIso8601Serializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import org.jetbrains.annotations.NotNull;

@Metadata
@Serializable(with = LocalDateTimeIso8601Serializer.class)
/* loaded from: classes3.dex */
public final class LocalDateTime implements Comparable<LocalDateTime> {

    @NotNull
    public static final Companion Companion = new Companion();

    /* renamed from: a, reason: collision with root package name */
    public final j$.time.LocalDateTime f55358a;

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
        @NotNull
        public final KSerializer<LocalDateTime> serializer() {
            return LocalDateTimeIso8601Serializer.f55671a;
        }
    }

    @Metadata
    public static final class Formats {

        /* renamed from: a, reason: collision with root package name */
        public static final LocalDateTimeFormat f55359a = (LocalDateTimeFormat) LocalDateTimeFormatKt.f55449a.getValue();
    }

    static {
        j$.time.LocalDateTime MIN = j$.time.LocalDateTime.MIN;
        Intrinsics.checkNotNullExpressionValue(MIN, "MIN");
        new LocalDateTime(MIN);
        j$.time.LocalDateTime MAX = j$.time.LocalDateTime.MAX;
        Intrinsics.checkNotNullExpressionValue(MAX, "MAX");
        new LocalDateTime(MAX);
    }

    public LocalDateTime(j$.time.LocalDateTime value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f55358a = value;
    }

    @Override // java.lang.Comparable
    public final int compareTo(LocalDateTime localDateTime) {
        LocalDateTime other = localDateTime;
        Intrinsics.checkNotNullParameter(other, "other");
        return this.f55358a.compareTo((ChronoLocalDateTime<?>) other.f55358a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalDateTime) {
            return Intrinsics.b(this.f55358a, ((LocalDateTime) obj).f55358a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f55358a.hashCode();
    }

    public final String toString() {
        String string = this.f55358a.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
