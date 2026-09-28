package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.PrimitiveArrayDescriptor;

@Metadata
@ExperimentalSerializationApi
/* loaded from: classes.dex */
public abstract class AbstractEncoder implements Encoder, CompositeEncoder {
    @Override // kotlinx.serialization.encoding.Encoder
    public void A(int i2) {
        H(Integer.valueOf(i2));
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void B(SerialDescriptor descriptor, int i2, SerializationStrategy serializer, Object obj) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        G(descriptor, i2);
        e(serializer, obj);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void C(SerialDescriptor descriptor, int i2, short s) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        G(descriptor, i2);
        r(s);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public boolean D(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor, int i2) {
        CompositeEncoder.DefaultImpls.a(pluginGeneratedSerialDescriptor);
        return true;
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void E(SerialDescriptor descriptor, int i2, long j2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        G(descriptor, i2);
        o(j2);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void F(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        H(value);
    }

    public void G(SerialDescriptor descriptor, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }

    public void H(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        throw new SerializationException("Non-serializable " + Reflection.a(value.getClass()) + " is not supported by " + Reflection.a(getClass()) + " encoder");
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public CompositeEncoder b(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this;
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public void c(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void e(SerializationStrategy serializer, Object obj) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        serializer.c(this, obj);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void f(double d2) {
        H(Double.valueOf(d2));
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void g(PrimitiveArrayDescriptor descriptor, int i2, char c2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        G(descriptor, i2);
        u(c2);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void h(byte b2) {
        H(Byte.valueOf(b2));
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void i(PrimitiveArrayDescriptor descriptor, int i2, byte b2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        G(descriptor, i2);
        h(b2);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void j(PrimitiveArrayDescriptor descriptor, int i2, float f2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        G(descriptor, i2);
        t(f2);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final CompositeEncoder k(SerialDescriptor descriptor, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return b(descriptor);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final Encoder l(PrimitiveArrayDescriptor descriptor, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        G(descriptor, i2);
        return n(descriptor.h(i2));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void m(SerialDescriptor enumDescriptor, int i2) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        H(Integer.valueOf(i2));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public Encoder n(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void o(long j2) {
        H(Long.valueOf(j2));
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void p(PrimitiveArrayDescriptor descriptor, int i2, double d2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        G(descriptor, i2);
        f(d2);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void q() {
        throw new SerializationException("'null' is not supported by default");
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void r(short s) {
        H(Short.valueOf(s));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void s(boolean z) {
        H(Boolean.valueOf(z));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void t(float f2) {
        H(Float.valueOf(f2));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void u(char c2) {
        H(Character.valueOf(c2));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void v() {
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void w(SerialDescriptor descriptor, int i2, int i3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        G(descriptor, i2);
        A(i3);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void x(SerialDescriptor descriptor, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        G(descriptor, i2);
        s(z);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void y(SerialDescriptor descriptor, int i2, String value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        G(descriptor, i2);
        F(value);
    }
}
