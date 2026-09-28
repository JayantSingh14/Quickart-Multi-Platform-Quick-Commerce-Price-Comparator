package kotlinx.datetime;

import j$.time.DateTimeException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.serializers.InstantIso8601Serializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import org.jetbrains.annotations.NotNull;

@Metadata
@Serializable(with = InstantIso8601Serializer.class)
@SourceDebugExtension
/* loaded from: classes.dex */
public final class Instant implements Comparable<Instant> {

    @NotNull
    public static final Companion Companion = new Companion();

    /* renamed from: b, reason: collision with root package name */
    public static final Instant f55350b;

    /* renamed from: c, reason: collision with root package name */
    public static final Instant f55351c;

    /* renamed from: a, reason: collision with root package name */
    public final j$.time.Instant f55352a;

    @Metadata
    public static final class Companion {
        public static Instant a(int i2, long j2) throws Exception {
            try {
                j$.time.Instant instantOfEpochSecond = j$.time.Instant.ofEpochSecond(j2, i2);
                Intrinsics.checkNotNullExpressionValue(instantOfEpochSecond, "ofEpochSecond(...)");
                return new Instant(instantOfEpochSecond);
            } catch (Exception e2) {
                if ((e2 instanceof ArithmeticException) || (e2 instanceof DateTimeException)) {
                    return j2 > 0 ? Instant.f55351c : Instant.f55350b;
                }
                throw e2;
            }
        }

        @NotNull
        public final KSerializer<Instant> serializer() {
            return InstantIso8601Serializer.f55663a;
        }
    }

    static {
        j$.time.Instant instantOfEpochSecond = j$.time.Instant.ofEpochSecond(-3217862419201L, 999999999L);
        Intrinsics.checkNotNullExpressionValue(instantOfEpochSecond, "ofEpochSecond(...)");
        new Instant(instantOfEpochSecond);
        j$.time.Instant instantOfEpochSecond2 = j$.time.Instant.ofEpochSecond(3093527980800L, 0L);
        Intrinsics.checkNotNullExpressionValue(instantOfEpochSecond2, "ofEpochSecond(...)");
        new Instant(instantOfEpochSecond2);
        j$.time.Instant MIN = j$.time.Instant.MIN;
        Intrinsics.checkNotNullExpressionValue(MIN, "MIN");
        f55350b = new Instant(MIN);
        j$.time.Instant MAX = j$.time.Instant.MAX;
        Intrinsics.checkNotNullExpressionValue(MAX, "MAX");
        f55351c = new Instant(MAX);
    }

    public Instant(j$.time.Instant value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f55352a = value;
    }

    public final long a() {
        j$.time.Instant instant = this.f55352a;
        try {
            return instant.toEpochMilli();
        } catch (ArithmeticException unused) {
            return instant.isAfter(j$.time.Instant.EPOCH) ? Long.MAX_VALUE : Long.MIN_VALUE;
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Instant instant) {
        Instant other = instant;
        Intrinsics.checkNotNullParameter(other, "other");
        return this.f55352a.compareTo(other.f55352a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Instant) {
            return Intrinsics.b(this.f55352a, ((Instant) obj).f55352a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f55352a.hashCode();
    }

    public final String toString() {
        String string = this.f55352a.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
