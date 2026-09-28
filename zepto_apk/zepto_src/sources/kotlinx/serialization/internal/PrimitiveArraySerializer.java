package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PrimitiveArrayBuilder;

@Metadata
@PublishedApi
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class PrimitiveArraySerializer<Element, Array, Builder extends PrimitiveArrayBuilder<Array>> extends CollectionLikeSerializer<Element, Array, Builder> {

    /* renamed from: b, reason: collision with root package name */
    public final PrimitiveArrayDescriptor f55888b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrimitiveArraySerializer(KSerializer primitiveSerializer) {
        super(primitiveSerializer);
        Intrinsics.checkNotNullParameter(primitiveSerializer, "primitiveSerializer");
        this.f55888b = new PrimitiveArrayDescriptor(primitiveSerializer.a());
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return this.f55888b;
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer, kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return i(decoder);
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        int iH = h(obj);
        PrimitiveArrayDescriptor primitiveArrayDescriptor = this.f55888b;
        CompositeEncoder compositeEncoderK = encoder.k(primitiveArrayDescriptor, iH);
        o(compositeEncoderK, obj, iH);
        compositeEncoderK.c(primitiveArrayDescriptor);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object e() {
        return (PrimitiveArrayBuilder) k(n());
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final int f(Object obj) {
        PrimitiveArrayBuilder primitiveArrayBuilder = (PrimitiveArrayBuilder) obj;
        Intrinsics.checkNotNullParameter(primitiveArrayBuilder, "<this>");
        return primitiveArrayBuilder.d();
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Iterator g(Object obj) {
        throw new IllegalStateException("This method lead to boxing and must not be used, use writeContents instead");
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object l(Object obj) {
        PrimitiveArrayBuilder primitiveArrayBuilder = (PrimitiveArrayBuilder) obj;
        Intrinsics.checkNotNullParameter(primitiveArrayBuilder, "<this>");
        return primitiveArrayBuilder.a();
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer
    public final void m(int i2, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter((PrimitiveArrayBuilder) obj, "<this>");
        throw new IllegalStateException("This method lead to boxing and must not be used, use Builder.append instead");
    }

    public abstract Object n();

    public abstract void o(CompositeEncoder compositeEncoder, Object obj, int i2);
}
