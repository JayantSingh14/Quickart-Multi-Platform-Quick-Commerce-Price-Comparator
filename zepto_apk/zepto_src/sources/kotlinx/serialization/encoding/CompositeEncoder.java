package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.PrimitiveArrayDescriptor;

@Metadata
/* loaded from: classes.dex */
public interface CompositeEncoder {

    @Metadata
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static void a(PluginGeneratedSerialDescriptor descriptor) {
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        }
    }

    void B(SerialDescriptor serialDescriptor, int i2, SerializationStrategy serializationStrategy, Object obj);

    void C(SerialDescriptor serialDescriptor, int i2, short s);

    boolean D(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor, int i2);

    void E(SerialDescriptor serialDescriptor, int i2, long j2);

    void c(SerialDescriptor serialDescriptor);

    void g(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i2, char c2);

    void i(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i2, byte b2);

    void j(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i2, float f2);

    Encoder l(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i2);

    void p(PrimitiveArrayDescriptor primitiveArrayDescriptor, int i2, double d2);

    void w(SerialDescriptor serialDescriptor, int i2, int i3);

    void x(SerialDescriptor serialDescriptor, int i2, boolean z);

    void y(SerialDescriptor serialDescriptor, int i2, String str);
}
