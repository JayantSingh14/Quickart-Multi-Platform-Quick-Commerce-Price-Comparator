package kotlinx.serialization.internal;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleKt;

@Metadata
@InternalSerializationApi
@SourceDebugExtension
/* loaded from: classes3.dex */
public abstract class TaggedEncoder<Tag> implements Encoder, CompositeEncoder {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f55909a = new ArrayList();

    @Override // kotlinx.serialization.encoding.Encoder
    public final void A(int i2) {
        N(i2, V());
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void B(SerialDescriptor descriptor, int i2, SerializationStrategy serializer, Object obj) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        this.f55909a.add(U(descriptor, i2));
        e(serializer, obj);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void C(SerialDescriptor descriptor, int i2, short s) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Q(U(descriptor, i2), s);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public boolean D(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor, int i2) {
        CompositeEncoder.DefaultImpls.a(pluginGeneratedSerialDescriptor);
        return true;
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void E(SerialDescriptor descriptor, int i2, long j2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        O(j2, U(descriptor, i2));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void F(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        R(V(), value);
    }

    public void G(Object obj, boolean z) {
        S(obj, Boolean.valueOf(z));
    }

    public void H(Object obj, byte b2) {
        S(obj, Byte.valueOf(b2));
    }

    public void I(Object obj, char c2) {
        S(obj, Character.valueOf(c2));
    }

    public void J(Object obj, double d2) {
        S(obj, Double.valueOf(d2));
    }

    public void K(Object obj, SerialDescriptor enumDescriptor, int i2) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        S(obj, Integer.valueOf(i2));
    }

    public void L(Object obj, float f2) {
        S(obj, Float.valueOf(f2));
    }

    public Encoder M(Object obj, SerialDescriptor inlineDescriptor) {
        Intrinsics.checkNotNullParameter(inlineDescriptor, "inlineDescriptor");
        this.f55909a.add(obj);
        return this;
    }

    public void N(int i2, Object obj) {
        S(obj, Integer.valueOf(i2));
    }

    public void O(long j2, Object obj) {
        S(obj, Long.valueOf(j2));
    }

    public void P(Object obj) {
        throw new SerializationException("null is not supported");
    }

    public void Q(Object obj, short s) {
        S(obj, Short.valueOf(s));
    }

    public void R(Object obj, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        S(obj, value);
    }

    public void S(Object obj, Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        throw new SerializationException("Non-serializable " + Reflection.a(value.getClass()) + " is not supported by " + Reflection.a(getClass()) + " encoder");
    }

    public void T(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }

    public abstract String U(SerialDescriptor serialDescriptor, int i2);

    public final Object V() {
        ArrayList arrayList = this.f55909a;
        if (arrayList.isEmpty()) {
            throw new SerializationException("No tag in stack for requested element");
        }
        return arrayList.remove(CollectionsKt.B(arrayList));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public SerializersModule a() {
        return SerializersModuleKt.f56126a;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public CompositeEncoder b(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this;
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void c(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (!this.f55909a.isEmpty()) {
            V();
        }
        T(descriptor);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void e(SerializationStrategy serializer, Object obj) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        serializer.c(this, obj);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void f(double d2) {
        J(V(), d2);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void g(PrimitiveArrayDescriptor descriptor, int i2, char c2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        I(U(descriptor, i2), c2);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void h(byte b2) {
        H(V(), b2);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void i(PrimitiveArrayDescriptor descriptor, int i2, byte b2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        H(U(descriptor, i2), b2);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void j(PrimitiveArrayDescriptor descriptor, int i2, float f2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        L(U(descriptor, i2), f2);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final CompositeEncoder k(SerialDescriptor descriptor, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return b(descriptor);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final Encoder l(PrimitiveArrayDescriptor descriptor, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return M(U(descriptor, i2), descriptor.h(i2));
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void m(SerialDescriptor enumDescriptor, int i2) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        K(V(), enumDescriptor, i2);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public Encoder n(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return M(V(), descriptor);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void o(long j2) {
        O(j2, V());
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void p(PrimitiveArrayDescriptor descriptor, int i2, double d2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        J(U(descriptor, i2), d2);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void q() {
        P(V());
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void r(short s) {
        Q(V(), s);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void s(boolean z) {
        G(V(), z);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void t(float f2) {
        L(V(), f2);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public final void u(char c2) {
        I(V(), c2);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public void v() {
        CollectionsKt.F(this.f55909a);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void w(SerialDescriptor descriptor, int i2, int i3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        N(i3, U(descriptor, i2));
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void x(SerialDescriptor descriptor, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        G(U(descriptor, i2), z);
    }

    @Override // kotlinx.serialization.encoding.CompositeEncoder
    public final void y(SerialDescriptor descriptor, int i2, String value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        R(U(descriptor, i2), value);
    }
}
