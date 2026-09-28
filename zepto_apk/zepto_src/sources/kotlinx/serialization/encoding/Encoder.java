package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.modules.SerializersModule;

@Metadata
/* loaded from: classes.dex */
public interface Encoder {

    @Metadata
    public static final class DefaultImpls {
    }

    void A(int i2);

    void F(String str);

    SerializersModule a();

    CompositeEncoder b(SerialDescriptor serialDescriptor);

    void e(SerializationStrategy serializationStrategy, Object obj);

    void f(double d2);

    void h(byte b2);

    CompositeEncoder k(SerialDescriptor serialDescriptor, int i2);

    void m(SerialDescriptor serialDescriptor, int i2);

    Encoder n(SerialDescriptor serialDescriptor);

    void o(long j2);

    void q();

    void r(short s);

    void s(boolean z);

    void t(float f2);

    void u(char c2);

    void v();
}
