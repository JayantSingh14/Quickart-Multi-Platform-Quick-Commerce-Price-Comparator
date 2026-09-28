package kotlinx.datetime;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.serializers.DateBasedDateTimeUnitSerializer;
import kotlinx.datetime.serializers.DateTimeUnitSerializer;
import kotlinx.datetime.serializers.DayBasedDateTimeUnitSerializer;
import kotlinx.datetime.serializers.MonthBasedDateTimeUnitSerializer;
import kotlinx.datetime.serializers.TimeBasedDateTimeUnitSerializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import org.apache.commons.codec.language.Soundex;
import org.jetbrains.annotations.NotNull;

@Metadata
@Serializable(with = DateTimeUnitSerializer.class)
/* loaded from: classes3.dex */
public abstract class DateTimeUnit {

    @NotNull
    public static final Companion Companion = new Companion();

    /* renamed from: a, reason: collision with root package name */
    public static final DayBased f55343a;

    @Metadata
    public static final class Companion {
        @NotNull
        public final KSerializer<DateTimeUnit> serializer() {
            return DateTimeUnitSerializer.f55651a;
        }
    }

    @Metadata
    @Serializable(with = DateBasedDateTimeUnitSerializer.class)
    public static abstract class DateBased extends DateTimeUnit {

        @NotNull
        public static final Companion Companion = new Companion();

        @Metadata
        public static final class Companion {
            @NotNull
            public final KSerializer<DateBased> serializer() {
                return DateBasedDateTimeUnitSerializer.f55640a;
            }
        }
    }

    @Metadata
    @Serializable(with = DayBasedDateTimeUnitSerializer.class)
    @SourceDebugExtension
    public static final class DayBased extends DateBased {

        @NotNull
        public static final Companion Companion = new Companion();

        /* renamed from: b, reason: collision with root package name */
        public final int f55344b;

        @Metadata
        public static final class Companion {
            @NotNull
            public final KSerializer<DayBased> serializer() {
                return DayBasedDateTimeUnitSerializer.f55654a;
            }
        }

        public DayBased(int i2) {
            this.f55344b = i2;
            if (i2 <= 0) {
                throw new IllegalArgumentException(b.g(i2, "Unit duration must be positive, but was ", " days.").toString());
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DayBased) {
                return this.f55344b == ((DayBased) obj).f55344b;
            }
            return false;
        }

        public final int hashCode() {
            return this.f55344b ^ 65536;
        }

        public final String toString() {
            int i2 = this.f55344b;
            return i2 % 7 == 0 ? DateTimeUnit.a(i2 / 7, "WEEK") : DateTimeUnit.a(i2, "DAY");
        }
    }

    @Metadata
    @Serializable(with = MonthBasedDateTimeUnitSerializer.class)
    @SourceDebugExtension
    public static final class MonthBased extends DateBased {

        @NotNull
        public static final Companion Companion = new Companion();

        /* renamed from: b, reason: collision with root package name */
        public final int f55345b;

        @Metadata
        public static final class Companion {
            @NotNull
            public final KSerializer<MonthBased> serializer() {
                return MonthBasedDateTimeUnitSerializer.f55677a;
            }
        }

        public MonthBased(int i2) {
            this.f55345b = i2;
            if (i2 <= 0) {
                throw new IllegalArgumentException(b.g(i2, "Unit duration must be positive, but was ", " months.").toString());
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MonthBased) {
                return this.f55345b == ((MonthBased) obj).f55345b;
            }
            return false;
        }

        public final int hashCode() {
            return this.f55345b ^ 131072;
        }

        public final String toString() {
            int i2 = this.f55345b;
            return i2 % 1200 == 0 ? DateTimeUnit.a(i2 / 1200, "CENTURY") : i2 % 12 == 0 ? DateTimeUnit.a(i2 / 12, "YEAR") : i2 % 3 == 0 ? DateTimeUnit.a(i2 / 3, "QUARTER") : DateTimeUnit.a(i2, "MONTH");
        }
    }

    @Metadata
    @Serializable(with = TimeBasedDateTimeUnitSerializer.class)
    @SourceDebugExtension
    public static final class TimeBased extends DateTimeUnit {

        @NotNull
        public static final Companion Companion = new Companion();

        /* renamed from: b, reason: collision with root package name */
        public final long f55346b;

        /* renamed from: c, reason: collision with root package name */
        public final String f55347c;

        /* renamed from: d, reason: collision with root package name */
        public final long f55348d;

        @Metadata
        public static final class Companion {
            @NotNull
            public final KSerializer<TimeBased> serializer() {
                return TimeBasedDateTimeUnitSerializer.f55682a;
            }
        }

        public TimeBased(long j2) {
            this.f55346b = j2;
            if (j2 <= 0) {
                throw new IllegalArgumentException(("Unit duration must be positive, but was " + j2 + " ns.").toString());
            }
            if (j2 % 3600000000000L == 0) {
                this.f55347c = "HOUR";
                this.f55348d = j2 / 3600000000000L;
                return;
            }
            if (j2 % 60000000000L == 0) {
                this.f55347c = "MINUTE";
                this.f55348d = j2 / 60000000000L;
                return;
            }
            long j3 = 1000000000;
            if (j2 % j3 == 0) {
                this.f55347c = "SECOND";
                this.f55348d = j2 / j3;
                return;
            }
            long j4 = 1000000;
            if (j2 % j4 == 0) {
                this.f55347c = "MILLISECOND";
                this.f55348d = j2 / j4;
                return;
            }
            long j5 = 1000;
            if (j2 % j5 == 0) {
                this.f55347c = "MICROSECOND";
                this.f55348d = j2 / j5;
            } else {
                this.f55347c = "NANOSECOND";
                this.f55348d = j2;
            }
        }

        public final TimeBased b(int i2) {
            return new TimeBased(Math.multiplyExact(this.f55346b, i2));
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TimeBased) {
                return this.f55346b == ((TimeBased) obj).f55346b;
            }
            return false;
        }

        public final int hashCode() {
            long j2 = this.f55346b;
            return ((int) (j2 >> 32)) ^ ((int) j2);
        }

        public final String toString() {
            String unit = this.f55347c;
            Intrinsics.checkNotNullParameter(unit, "unit");
            long j2 = this.f55348d;
            if (j2 == 1) {
                return unit;
            }
            return j2 + Soundex.SILENT_MARKER + unit;
        }
    }

    static {
        new TimeBased(1L).b(1000).b(1000).b(1000).b(60).b(60);
        f55343a = new DayBased(1);
        new DayBased(Math.multiplyExact(1, 7));
        new MonthBased(1);
        new MonthBased(Math.multiplyExact(1, 3));
        int iMultiplyExact = Math.multiplyExact(1, 12);
        new MonthBased(iMultiplyExact);
        new MonthBased(Math.multiplyExact(iMultiplyExact, 100));
    }

    public static String a(int i2, String unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (i2 == 1) {
            return unit;
        }
        return i2 + Soundex.SILENT_MARKER + unit;
    }
}
