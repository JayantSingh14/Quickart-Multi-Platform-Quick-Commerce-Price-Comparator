package kotlinx.serialization.encoding;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.internal.PrimitiveArrayDescriptor;

@Metadata
@ExperimentalSerializationApi
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class AbstractDecoder implements Decoder, CompositeDecoder {
    @Override // kotlinx.serialization.encoding.Decoder
    public boolean A() {
        return true;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final short B(SerialDescriptor descriptor, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return r();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final Decoder C(PrimitiveArrayDescriptor descriptor, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return p(descriptor.h(i2));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public byte D() {
        E();
        throw null;
    }

    public final void E() {
        throw new SerializationException(Reflection.a(getClass()) + " can't retrieve untyped values");
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public CompositeDecoder b(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public void c(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final float e(PrimitiveArrayDescriptor descriptor, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return s();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final char f(PrimitiveArrayDescriptor descriptor, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return v();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public int g(SerialDescriptor enumDescriptor) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        E();
        throw null;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final long h(SerialDescriptor descriptor, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return m();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final byte i(PrimitiveArrayDescriptor descriptor, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return D();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public int k() {
        E();
        throw null;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final int l(SerialDescriptor descriptor, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return k();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public long m() {
        E();
        throw null;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final String n(SerialDescriptor descriptor, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return y();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public Decoder p(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final double q(PrimitiveArrayDescriptor descriptor, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return t();
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public short r() {
        E();
        throw null;
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public float s() {
        E();
        throw null;
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public double t() {
        E();
        throw null;
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public boolean u() {
        E();
        throw null;
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public char v() {
        E();
        throw null;
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public Object w(DeserializationStrategy deserializationStrategy) {
        return Decoder.DefaultImpls.a(this, deserializationStrategy);
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public Object x(SerialDescriptor descriptor, int i2, DeserializationStrategy deserializer, Object obj) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        return w(deserializer);
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public String y() {
        E();
        throw null;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final boolean z(SerialDescriptor descriptor, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return u();
    }
}
