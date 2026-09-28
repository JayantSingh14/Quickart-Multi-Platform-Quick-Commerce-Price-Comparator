package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorImpl;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata
@PublishedApi
/* loaded from: classes.dex */
public final class JsonElementSerializer implements KSerializer<JsonElement> {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonElementSerializer f55978a = new JsonElementSerializer();

    /* renamed from: b, reason: collision with root package name */
    public static final SerialDescriptorImpl f55979b = SerialDescriptorsKt.d("kotlinx.serialization.json.JsonElement", PolymorphicKind.SEALED.f55731a, new SerialDescriptor[0], JsonElementSerializer$descriptor$1.f55980c);

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return f55979b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return JsonElementSerializersKt.a(decoder).j();
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        JsonElement value = (JsonElement) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        JsonElementSerializersKt.b(encoder);
        if (value instanceof JsonPrimitive) {
            encoder.e(JsonPrimitiveSerializer.f56004a, value);
        } else if (value instanceof JsonObject) {
            encoder.e(JsonObjectSerializer.f55999a, value);
        } else if (value instanceof JsonArray) {
            encoder.e(JsonArraySerializer.f55949a, value);
        }
    }
}
