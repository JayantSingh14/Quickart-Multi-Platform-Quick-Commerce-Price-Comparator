package kotlinx.datetime;

import j$.time.DateTimeException;
import j$.time.chrono.ChronoLocalDate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.format.DateTimeFormat;
import kotlinx.datetime.format.LocalDateFormatKt;
import kotlinx.datetime.serializers.LocalDateIso8601Serializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import org.jetbrains.annotations.NotNull;

@Metadata
@Serializable(with = LocalDateIso8601Serializer.class)
/* loaded from: classes3.dex */
public final class LocalDate implements Comparable<LocalDate> {

    @NotNull
    public static final Companion Companion = new Companion();

    /* renamed from: a, reason: collision with root package name */
    public final j$.time.LocalDate f55353a;

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
        @NotNull
        public final KSerializer<LocalDate> serializer() {
            return LocalDateIso8601Serializer.f55667a;
        }
    }

    @Metadata
    public static final class Formats {

        /* renamed from: a, reason: collision with root package name */
        public static final DateTimeFormat f55354a = (DateTimeFormat) LocalDateFormatKt.f55441b.getValue();
    }

    static {
        j$.time.LocalDate MIN = j$.time.LocalDate.MIN;
        Intrinsics.checkNotNullExpressionValue(MIN, "MIN");
        new LocalDate(MIN);
        j$.time.LocalDate MAX = j$.time.LocalDate.MAX;
        Intrinsics.checkNotNullExpressionValue(MAX, "MAX");
        new LocalDate(MAX);
    }

    public LocalDate(j$.time.LocalDate value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f55353a = value;
    }

    @Override // java.lang.Comparable
    public final int compareTo(LocalDate localDate) {
        LocalDate other = localDate;
        Intrinsics.checkNotNullParameter(other, "other");
        return this.f55353a.compareTo((ChronoLocalDate) other.f55353a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalDate) {
            return Intrinsics.b(this.f55353a, ((LocalDate) obj).f55353a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f55353a.hashCode();
    }

    public final String toString() {
        String string = this.f55353a.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public LocalDate(int i2, int i3, int i4) {
        try {
            j$.time.LocalDate localDateOf = j$.time.LocalDate.of(i2, i3, i4);
            Intrinsics.c(localDateOf);
            this(localDateOf);
        } catch (DateTimeException e2) {
            throw new IllegalArgumentException(e2);
        }
    }
}
