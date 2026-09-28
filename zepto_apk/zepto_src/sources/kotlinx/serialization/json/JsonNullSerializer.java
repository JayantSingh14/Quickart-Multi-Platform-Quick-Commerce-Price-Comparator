package kotlinx.serialization.json;

import com.amazon.apay.hardened.external.model.APayConstants;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorImpl;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialDescriptorsKt$buildSerialDescriptor$1;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.internal.JsonDecodingException;

@Metadata
@PublishedApi
/* loaded from: classes.dex */
public final class JsonNullSerializer implements KSerializer<JsonNull> {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonNullSerializer f55994a = new JsonNullSerializer();

    /* renamed from: b, reason: collision with root package name */
    public static final SerialDescriptorImpl f55995b = SerialDescriptorsKt.d("kotlinx.serialization.json.JsonNull", SerialKind.ENUM.f55764a, new SerialDescriptor[0], SerialDescriptorsKt$buildSerialDescriptor$1.f55762c);

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return f55995b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonElementSerializersKt.a(decoder);
        if (!decoder.A()) {
            return JsonNull.INSTANCE;
        }
        Intrinsics.checkNotNullParameter("Expected 'null' literal", APayConstants.Error.MESSAGE);
        Intrinsics.checkNotNullParameter("Expected 'null' literal", APayConstants.Error.MESSAGE);
        throw new JsonDecodingException("Expected 'null' literal");
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        JsonNull value = (JsonNull) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        JsonElementSerializersKt.b(encoder);
        encoder.q();
    }
}
