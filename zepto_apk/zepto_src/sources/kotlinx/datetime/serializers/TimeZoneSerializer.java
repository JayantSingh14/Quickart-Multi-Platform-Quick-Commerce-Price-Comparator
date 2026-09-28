package kotlinx.datetime.serializers;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.TimeZone;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PrimitiveSerialDescriptor;

@Metadata
/* loaded from: classes3.dex */
public final class TimeZoneSerializer implements KSerializer<TimeZone> {

    /* renamed from: a, reason: collision with root package name */
    public static final TimeZoneSerializer f55686a = new TimeZoneSerializer();

    /* renamed from: b, reason: collision with root package name */
    public static final PrimitiveSerialDescriptor f55687b = SerialDescriptorsKt.a("kotlinx.datetime.TimeZone");

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return f55687b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        TimeZone.Companion companion = TimeZone.Companion;
        String strY = decoder.y();
        companion.getClass();
        return TimeZone.Companion.a(strY);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        TimeZone value = (TimeZone) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        String id = value.f55362a.getId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        encoder.F(id);
    }
}
