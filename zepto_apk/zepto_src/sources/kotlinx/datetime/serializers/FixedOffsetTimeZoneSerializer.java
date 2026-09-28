package kotlinx.datetime.serializers;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.FixedOffsetTimeZone;
import kotlinx.datetime.TimeZone;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PrimitiveSerialDescriptor;

@Metadata
/* loaded from: classes3.dex */
public final class FixedOffsetTimeZoneSerializer implements KSerializer<FixedOffsetTimeZone> {

    /* renamed from: a, reason: collision with root package name */
    public static final FixedOffsetTimeZoneSerializer f55659a = new FixedOffsetTimeZoneSerializer();

    /* renamed from: b, reason: collision with root package name */
    public static final PrimitiveSerialDescriptor f55660b = SerialDescriptorsKt.a("kotlinx.datetime.FixedOffsetTimeZone");

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return f55660b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) throws Exception {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        TimeZone.Companion companion = TimeZone.Companion;
        String strY = decoder.y();
        companion.getClass();
        TimeZone timeZoneA = TimeZone.Companion.a(strY);
        if (timeZoneA instanceof FixedOffsetTimeZone) {
            return (FixedOffsetTimeZone) timeZoneA;
        }
        throw new SerializationException("Timezone identifier '" + timeZoneA + "' does not correspond to a fixed-offset timezone");
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        FixedOffsetTimeZone value = (FixedOffsetTimeZone) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        String id = value.f55362a.getId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        encoder.F(id);
    }
}
