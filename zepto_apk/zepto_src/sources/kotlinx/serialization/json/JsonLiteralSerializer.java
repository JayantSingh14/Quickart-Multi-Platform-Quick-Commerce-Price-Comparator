package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlin.text.UStringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PrimitiveSerialDescriptor;
import kotlinx.serialization.internal.ULongSerializer;
import kotlinx.serialization.json.internal.JsonExceptionsKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
final class JsonLiteralSerializer implements KSerializer<JsonLiteral> {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonLiteralSerializer f55990a = new JsonLiteralSerializer();

    /* renamed from: b, reason: collision with root package name */
    public static final PrimitiveSerialDescriptor f55991b = SerialDescriptorsKt.a("kotlinx.serialization.json.JsonLiteral");

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return f55991b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonElement jsonElementJ = JsonElementSerializersKt.a(decoder).j();
        if (jsonElementJ instanceof JsonLiteral) {
            return (JsonLiteral) jsonElementJ;
        }
        throw JsonExceptionsKt.d("Unexpected JSON element, expected JsonLiteral, had " + Reflection.a(jsonElementJ.getClass()), jsonElementJ.toString(), -1);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        JsonLiteral value = (JsonLiteral) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        JsonElementSerializersKt.b(encoder);
        boolean z = value.f55987a;
        String str = value.f55989c;
        if (z) {
            encoder.F(str);
            return;
        }
        SerialDescriptor serialDescriptor = value.f55988b;
        if (serialDescriptor != null) {
            encoder.n(serialDescriptor).F(str);
            return;
        }
        Long lA0 = StringsKt.a0(str);
        if (lA0 != null) {
            encoder.o(lA0.longValue());
            return;
        }
        ULong uLongE = UStringsKt.e(str);
        if (uLongE != null) {
            Intrinsics.checkNotNullParameter(ULong.f53561b, "<this>");
            encoder.n(ULongSerializer.f55930b).o(uLongE.f53562a);
            return;
        }
        Double dY = StringsKt.Y(str);
        if (dY != null) {
            encoder.f(dY.doubleValue());
            return;
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        Boolean bool = str.equals("true") ? Boolean.TRUE : str.equals("false") ? Boolean.FALSE : null;
        if (bool != null) {
            encoder.s(bool.booleanValue());
        } else {
            encoder.F(str);
        }
    }
}
