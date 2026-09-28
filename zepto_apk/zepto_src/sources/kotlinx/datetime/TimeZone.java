package kotlinx.datetime;

import j$.time.DateTimeException;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.serializers.TimeZoneSerializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import org.jetbrains.annotations.NotNull;

@Metadata
@Serializable(with = TimeZoneSerializer.class)
/* loaded from: classes3.dex */
public class TimeZone {

    @NotNull
    public static final Companion Companion = new Companion();

    /* renamed from: a, reason: collision with root package name */
    public final ZoneId f55362a;

    @Metadata
    public static final class Companion {
        public static TimeZone a(String zoneId) throws Exception {
            Intrinsics.checkNotNullParameter(zoneId, "zoneId");
            try {
                ZoneId zoneIdOf = ZoneId.of(zoneId);
                Intrinsics.checkNotNullExpressionValue(zoneIdOf, "of(...)");
                return b(zoneIdOf);
            } catch (Exception cause) {
                if (!(cause instanceof DateTimeException)) {
                    throw cause;
                }
                Intrinsics.checkNotNullParameter(cause, "cause");
                throw new IllegalTimeZoneException(cause);
            }
        }

        public static TimeZone b(ZoneId zoneId) {
            boolean zIsFixedOffset;
            Intrinsics.checkNotNullParameter(zoneId, "zoneId");
            if (zoneId instanceof ZoneOffset) {
                return new FixedOffsetTimeZone(new UtcOffset((ZoneOffset) zoneId));
            }
            try {
                zIsFixedOffset = zoneId.getRules().isFixedOffset();
            } catch (ArrayIndexOutOfBoundsException unused) {
                zIsFixedOffset = false;
            }
            if (!zIsFixedOffset) {
                return new TimeZone(zoneId);
            }
            ZoneId zoneIdNormalized = zoneId.normalized();
            Intrinsics.d(zoneIdNormalized, "null cannot be cast to non-null type java.time.ZoneOffset");
            return new FixedOffsetTimeZone(new UtcOffset((ZoneOffset) zoneIdNormalized), zoneId);
        }

        @NotNull
        public final KSerializer<TimeZone> serializer() {
            return TimeZoneSerializer.f55686a;
        }
    }

    static {
        ZoneOffset UTC = ZoneOffset.UTC;
        Intrinsics.checkNotNullExpressionValue(UTC, "UTC");
        UtcOffset utcOffset = new UtcOffset(UTC);
        Intrinsics.checkNotNullParameter(utcOffset, "<this>");
        new FixedOffsetTimeZone(utcOffset);
    }

    public TimeZone(ZoneId zoneId) {
        Intrinsics.checkNotNullParameter(zoneId, "zoneId");
        this.f55362a = zoneId;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TimeZone) {
            return Intrinsics.b(this.f55362a, ((TimeZone) obj).f55362a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f55362a.hashCode();
    }

    public final String toString() {
        String string = this.f55362a.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
