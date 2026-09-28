package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializerKt;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata
@InternalSerializationApi
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class AbstractPolymorphicSerializer<T> implements KSerializer<T> {
    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptorA = a();
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptorA);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Object objX = null;
        while (true) {
            int iO = compositeDecoderB.o(a());
            if (iO == -1) {
                if (objX != null) {
                    compositeDecoderB.c(serialDescriptorA);
                    return objX;
                }
                throw new IllegalArgumentException(("Polymorphic value has not been read for class " + ((String) objectRef.f53801a)).toString());
            }
            if (iO == 0) {
                objectRef.f53801a = compositeDecoderB.n(a(), iO);
            } else {
                if (iO != 1) {
                    StringBuilder sb = new StringBuilder("Invalid index in polymorphic deserialization of ");
                    String str = (String) objectRef.f53801a;
                    if (str == null) {
                        str = "unknown class";
                    }
                    sb.append(str);
                    sb.append("\n Expected 0, 1 or DECODE_DONE(-1), but found ");
                    sb.append(iO);
                    throw new SerializationException(sb.toString());
                }
                Object obj = objectRef.f53801a;
                if (obj == null) {
                    throw new IllegalArgumentException("Cannot read polymorphic value before its type token");
                }
                objectRef.f53801a = obj;
                objX = compositeDecoderB.x(a(), iO, PolymorphicSerializerKt.a(this, compositeDecoderB, (String) obj), null);
            }
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerializationStrategy serializationStrategyB = PolymorphicSerializerKt.b(this, encoder, value);
        SerialDescriptor serialDescriptorA = a();
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptorA);
        compositeEncoderB.y(a(), 0, serializationStrategyB.a().i());
        compositeEncoderB.B(a(), 1, serializationStrategyB, value);
        compositeEncoderB.c(serialDescriptorA);
    }

    public DeserializationStrategy e(CompositeDecoder decoder, String str) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return decoder.a().b(str, g());
    }

    public SerializationStrategy f(Encoder encoder, Object value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        return encoder.a().c(g(), value);
    }

    public abstract KClass g();
}
