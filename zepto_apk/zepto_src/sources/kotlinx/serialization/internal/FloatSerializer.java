package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata
@PublishedApi
/* loaded from: classes.dex */
public final class FloatSerializer implements KSerializer<Float> {

    /* renamed from: a, reason: collision with root package name */
    public static final FloatSerializer f55822a = new FloatSerializer();

    /* renamed from: b, reason: collision with root package name */
    public static final PrimitiveSerialDescriptor f55823b = new PrimitiveSerialDescriptor("kotlin.Float", PrimitiveKind.FLOAT.f55736a);

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return f55823b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return Float.valueOf(decoder.s());
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        float fFloatValue = ((Number) obj).floatValue();
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        encoder.t(fFloatValue);
    }
}
