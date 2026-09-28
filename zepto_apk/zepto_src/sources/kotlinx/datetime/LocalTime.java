package kotlinx.datetime;

import j$.time.DateTimeException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.serializers.LocalTimeIso8601Serializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import org.jetbrains.annotations.NotNull;

@Metadata
@Serializable(with = LocalTimeIso8601Serializer.class)
/* loaded from: classes3.dex */
public final class LocalTime implements Comparable<LocalTime> {

    @NotNull
    public static final Companion Companion = new Companion();

    /* renamed from: a, reason: collision with root package name */
    public final j$.time.LocalTime f55360a;

    @Metadata
    @SourceDebugExtension
    public static final class Companion {
        @NotNull
        public final KSerializer<LocalTime> serializer() {
            return LocalTimeIso8601Serializer.f55675a;
        }
    }

    @Metadata
    public static final class Formats {
    }

    static {
        j$.time.LocalTime MIN = j$.time.LocalTime.MIN;
        Intrinsics.checkNotNullExpressionValue(MIN, "MIN");
        new LocalTime(MIN);
        j$.time.LocalTime MAX = j$.time.LocalTime.MAX;
        Intrinsics.checkNotNullExpressionValue(MAX, "MAX");
        new LocalTime(MAX);
    }

    public LocalTime(j$.time.LocalTime value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f55360a = value;
    }

    @Override // java.lang.Comparable
    public final int compareTo(LocalTime localTime) {
        LocalTime other = localTime;
        Intrinsics.checkNotNullParameter(other, "other");
        return this.f55360a.compareTo(other.f55360a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalTime) {
            return Intrinsics.b(this.f55360a, ((LocalTime) obj).f55360a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f55360a.hashCode();
    }

    public final String toString() {
        String string = this.f55360a.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public LocalTime(int i2, int i3, int i4, int i5) {
        try {
            j$.time.LocalTime localTimeOf = j$.time.LocalTime.of(i2, i3, i4, i5);
            Intrinsics.c(localTimeOf);
            this(localTimeOf);
        } catch (DateTimeException e2) {
            throw new IllegalArgumentException(e2);
        }
    }
}
