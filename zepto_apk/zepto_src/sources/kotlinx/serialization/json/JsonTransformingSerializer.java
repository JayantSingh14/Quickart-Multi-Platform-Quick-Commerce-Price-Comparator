package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.internal.TreeJsonDecoderKt;
import kotlinx.serialization.json.internal.TreeJsonEncoderKt;

@Metadata
/* loaded from: classes3.dex */
public abstract class JsonTransformingSerializer<T> implements KSerializer<T> {
    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        throw null;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonDecoder jsonDecoderA = JsonElementSerializersKt.a(decoder);
        JsonElement element = jsonDecoderA.j();
        Json jsonD = jsonDecoderA.d();
        Intrinsics.checkNotNullParameter(element, "element");
        jsonD.getClass();
        Intrinsics.checkNotNullParameter(null, "deserializer");
        Intrinsics.checkNotNullParameter(element, "element");
        TreeJsonDecoderKt.a(jsonD, element, null);
        throw null;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        TreeJsonEncoderKt.a(JsonElementSerializersKt.b(encoder).d(), value);
        throw null;
    }
}
