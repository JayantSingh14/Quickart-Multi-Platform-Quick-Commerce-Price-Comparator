package kotlinx.datetime;

import j$.time.ZoneId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.serializers.FixedOffsetTimeZoneSerializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import org.jetbrains.annotations.NotNull;

@Metadata
@Serializable(with = FixedOffsetTimeZoneSerializer.class)
/* loaded from: classes3.dex */
public final class FixedOffsetTimeZone extends TimeZone {

    @NotNull
    public static final Companion Companion = new Companion();

    @Metadata
    public static final class Companion {
        @NotNull
        public final KSerializer<FixedOffsetTimeZone> serializer() {
            return FixedOffsetTimeZoneSerializer.f55659a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FixedOffsetTimeZone(UtcOffset offset, ZoneId zoneId) {
        super(zoneId);
        Intrinsics.checkNotNullParameter(offset, "offset");
        Intrinsics.checkNotNullParameter(zoneId, "zoneId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FixedOffsetTimeZone(UtcOffset offset) {
        this(offset, offset.f55363a);
        Intrinsics.checkNotNullParameter(offset, "offset");
    }
}
