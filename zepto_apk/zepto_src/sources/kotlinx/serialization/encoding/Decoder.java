package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.modules.SerializersModule;

@Metadata
/* loaded from: classes.dex */
public interface Decoder {

    @Metadata
    @SourceDebugExtension
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static Object a(Decoder decoder, DeserializationStrategy deserializer) {
            Intrinsics.checkNotNullParameter(deserializer, "deserializer");
            return deserializer.b(decoder);
        }
    }

    boolean A();

    byte D();

    SerializersModule a();

    CompositeDecoder b(SerialDescriptor serialDescriptor);

    int g(SerialDescriptor serialDescriptor);

    int k();

    long m();

    Decoder p(SerialDescriptor serialDescriptor);

    short r();

    float s();

    double t();

    boolean u();

    char v();

    Object w(DeserializationStrategy deserializationStrategy);

    String y();
}
