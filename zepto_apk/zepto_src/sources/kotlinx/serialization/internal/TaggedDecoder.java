package kotlinx.serialization.internal;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleKt;

@Metadata
@InternalSerializationApi
@SourceDebugExtension
/* loaded from: classes3.dex */
public abstract class TaggedDecoder<Tag> implements Decoder, CompositeDecoder {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f55904a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public boolean f55905b;

    @Override // kotlinx.serialization.encoding.Decoder
    public boolean A() {
        Object objG = CollectionsKt.G(this.f55904a);
        if (objG == null) {
            return false;
        }
        return N(objG);
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final short B(SerialDescriptor descriptor, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return O(R(descriptor, i2));
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final Decoder C(PrimitiveArrayDescriptor descriptor, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return K(R(descriptor, i2), descriptor.h(i2));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final byte D() {
        return F(S());
    }

    public boolean E(Object obj) {
        Q();
        throw null;
    }

    public byte F(Object obj) {
        Q();
        throw null;
    }

    public char G(Object obj) {
        Q();
        throw null;
    }

    public double H(Object obj) {
        Q();
        throw null;
    }

    public int I(Object obj, SerialDescriptor enumDescriptor) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        Q();
        throw null;
    }

    public float J(Object obj) {
        Q();
        throw null;
    }

    public Decoder K(Object obj, SerialDescriptor inlineDescriptor) {
        Intrinsics.checkNotNullParameter(inlineDescriptor, "inlineDescriptor");
        this.f55904a.add(obj);
        return this;
    }

    public int L(Object obj) {
        Q();
        throw null;
    }

    public long M(Object obj) {
        Q();
        throw null;
    }

    public boolean N(Object obj) {
        return true;
    }

    public short O(Object obj) {
        Q();
        throw null;
    }

    public String P(Object obj) {
        Q();
        throw null;
    }

    public final void Q() {
        throw new SerializationException(Reflection.a(getClass()) + " can't retrieve untyped values");
    }

    public abstract String R(SerialDescriptor serialDescriptor, int i2);

    public final Object S() {
        ArrayList arrayList = this.f55904a;
        Object objRemove = arrayList.remove(CollectionsKt.B(arrayList));
        this.f55905b = true;
        return objRemove;
    }

    @Override // kotlinx.serialization.encoding.Decoder, kotlinx.serialization.encoding.CompositeDecoder
    public SerializersModule a() {
        return SerializersModuleKt.f56126a;
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
        return J(R(descriptor, i2));
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final char f(PrimitiveArrayDescriptor descriptor, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return G(R(descriptor, i2));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final int g(SerialDescriptor enumDescriptor) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        return I(S(), enumDescriptor);
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final long h(SerialDescriptor descriptor, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return M(R(descriptor, i2));
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final byte i(PrimitiveArrayDescriptor descriptor, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return F(R(descriptor, i2));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final int k() {
        return L(S());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final int l(SerialDescriptor descriptor, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return L(R(descriptor, i2));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final long m() {
        return M(S());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final String n(SerialDescriptor descriptor, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return P(R(descriptor, i2));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public Decoder p(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return K(S(), descriptor);
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final double q(PrimitiveArrayDescriptor descriptor, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return H(R(descriptor, i2));
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final short r() {
        return O(S());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final float s() {
        return J(S());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final double t() {
        return H(S());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final boolean u() {
        return E(S());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final char v() {
        return G(S());
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public Object w(DeserializationStrategy deserializationStrategy) {
        return Decoder.DefaultImpls.a(this, deserializationStrategy);
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final Object x(SerialDescriptor descriptor, int i2, final DeserializationStrategy deserializer, final Object obj) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        String strR = R(descriptor, i2);
        Function0<Object> function0 = new Function0<Object>() { // from class: kotlinx.serialization.internal.TaggedDecoder$decodeSerializableElement$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                TaggedDecoder taggedDecoder = this.f55906c;
                taggedDecoder.getClass();
                DeserializationStrategy deserializer2 = deserializer;
                Intrinsics.checkNotNullParameter(deserializer2, "deserializer");
                return taggedDecoder.w(deserializer2);
            }
        };
        this.f55904a.add(strR);
        Object objInvoke = function0.invoke();
        if (!this.f55905b) {
            S();
        }
        this.f55905b = false;
        return objInvoke;
    }

    @Override // kotlinx.serialization.encoding.Decoder
    public final String y() {
        return P(S());
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final boolean z(SerialDescriptor descriptor, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return E(R(descriptor, i2));
    }
}
