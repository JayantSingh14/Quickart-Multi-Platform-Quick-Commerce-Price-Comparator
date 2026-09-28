package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.PrimitiveArrayDescriptor;
import kotlinx.serialization.modules.SerializersModule;

@Metadata
/* loaded from: classes.dex */
public interface CompositeDecoder {

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {
    }

    @Metadata
    public static final class DefaultImpls {
    }

    short B(SerialDescriptor serialDescriptor, int i2);

    Decoder C(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i2);

    SerializersModule a();

    void c(SerialDescriptor serialDescriptor);

    float e(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i2);

    char f(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i2);

    long h(SerialDescriptor serialDescriptor, int i2);

    byte i(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i2);

    int l(SerialDescriptor serialDescriptor, int i2);

    String n(SerialDescriptor serialDescriptor, int i2);

    int o(SerialDescriptor serialDescriptor);

    double q(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i2);

    Object x(SerialDescriptor serialDescriptor, int i2, DeserializationStrategy deserializationStrategy, Object obj);

    boolean z(SerialDescriptor serialDescriptor, int i2);
}
