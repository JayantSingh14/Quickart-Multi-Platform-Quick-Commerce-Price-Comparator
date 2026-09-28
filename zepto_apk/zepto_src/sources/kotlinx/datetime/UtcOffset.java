package kotlinx.datetime;

import j$.time.ZoneOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.serializers.UtcOffsetSerializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import org.jetbrains.annotations.NotNull;

@Metadata
@Serializable(with = UtcOffsetSerializer.class)
/* loaded from: classes3.dex */
public final class UtcOffset {

    @NotNull
    public static final Companion Companion = new Companion();

    /* renamed from: a, reason: collision with root package name */
    public final ZoneOffset f55363a;

    @Metadata
    public static final class Companion {
        @NotNull
        public final KSerializer<UtcOffset> serializer() {
            return UtcOffsetSerializer.f55688a;
        }
    }

    @Metadata
    public static final class Formats {
    }

    static {
        ZoneOffset UTC = ZoneOffset.UTC;
        Intrinsics.checkNotNullExpressionValue(UTC, "UTC");
        new UtcOffset(UTC);
    }

    public UtcOffset(ZoneOffset zoneOffset) {
        Intrinsics.checkNotNullParameter(zoneOffset, "zoneOffset");
        this.f55363a = zoneOffset;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof UtcOffset) {
            return Intrinsics.b(this.f55363a, ((UtcOffset) obj).f55363a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f55363a.hashCode();
    }

    public final String toString() {
        String string = this.f55363a.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
