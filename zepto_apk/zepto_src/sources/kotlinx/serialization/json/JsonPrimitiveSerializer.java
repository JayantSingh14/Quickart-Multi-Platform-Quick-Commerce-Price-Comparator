package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorImpl;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialDescriptorsKt$buildSerialDescriptor$1;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.internal.JsonExceptionsKt;

@Metadata
@PublishedApi
/* loaded from: classes.dex */
public final class JsonPrimitiveSerializer implements KSerializer<JsonPrimitive> {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonPrimitiveSerializer f56004a = new JsonPrimitiveSerializer();

    /* renamed from: b, reason: collision with root package name */
    public static final SerialDescriptorImpl f56005b = SerialDescriptorsKt.d("kotlinx.serialization.json.JsonPrimitive", PrimitiveKind.STRING.f55740a, new SerialDescriptor[0], SerialDescriptorsKt$buildSerialDescriptor$1.f55762c);

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return f56005b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonElement jsonElementJ = JsonElementSerializersKt.a(decoder).j();
        if (jsonElementJ instanceof JsonPrimitive) {
            return (JsonPrimitive) jsonElementJ;
        }
        throw JsonExceptionsKt.d("Unexpected JSON element, expected JsonPrimitive, had " + Reflection.a(jsonElementJ.getClass()), jsonElementJ.toString(), -1);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        JsonPrimitive value = (JsonPrimitive) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        JsonElementSerializersKt.b(encoder);
        if (value instanceof JsonNull) {
            encoder.e(JsonNullSerializer.f55994a, JsonNull.INSTANCE);
        } else {
            encoder.e(JsonLiteralSerializer.f55990a, (JsonLiteral) value);
        }
    }
}
