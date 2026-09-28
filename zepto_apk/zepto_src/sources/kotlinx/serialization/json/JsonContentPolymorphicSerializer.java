package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.internal.TreeJsonDecoderKt;

@Metadata
/* loaded from: classes3.dex */
public abstract class JsonContentPolymorphicSerializer<T> implements KSerializer<T> {
    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return null;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonDecoder jsonDecoderA = JsonElementSerializersKt.a(decoder);
        JsonElement element = jsonDecoderA.j();
        DeserializationStrategy deserializationStrategyE = e();
        Intrinsics.d(deserializationStrategyE, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.json.JsonContentPolymorphicSerializer>");
        KSerializer deserializer = (KSerializer) deserializationStrategyE;
        Json jsonD = jsonDecoderA.d();
        jsonD.getClass();
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(element, "element");
        return TreeJsonDecoderKt.a(jsonD, element, deserializer);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        encoder.a().c(null, value);
        throw null;
    }

    public abstract DeserializationStrategy e();
}
