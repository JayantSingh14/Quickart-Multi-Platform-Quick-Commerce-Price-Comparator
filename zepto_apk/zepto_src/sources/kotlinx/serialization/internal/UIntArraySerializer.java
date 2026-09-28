package kotlinx.serialization.internal;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata
@ExperimentalSerializationApi
@ExperimentalUnsignedTypes
@PublishedApi
/* loaded from: classes.dex */
public final class UIntArraySerializer extends PrimitiveArraySerializer<UInt, UIntArray, UIntArrayBuilder> implements KSerializer<UIntArray> {

    /* renamed from: c, reason: collision with root package name */
    public static final UIntArraySerializer f55923c;

    static {
        Intrinsics.checkNotNullParameter(UInt.f53556b, "<this>");
        f55923c = new UIntArraySerializer(UIntSerializer.f55924a);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final int h(Object obj) {
        int[] collectionSize = ((UIntArray) obj).f53558a;
        Intrinsics.checkNotNullParameter(collectionSize, "$this$collectionSize");
        return collectionSize.length;
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void j(CompositeDecoder decoder, int i2, Object obj) {
        UIntArrayBuilder builder = (UIntArrayBuilder) obj;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(builder, "builder");
        int iK = decoder.C(this.f55888b, i2).k();
        UInt.Companion companion = UInt.f53556b;
        builder.e(iK);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object k(Object obj) {
        int[] toBuilder = ((UIntArray) obj).f53558a;
        Intrinsics.checkNotNullParameter(toBuilder, "$this$toBuilder");
        return new UIntArrayBuilder(toBuilder);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final Object n() {
        int[] storage = new int[0];
        Intrinsics.checkNotNullParameter(storage, "storage");
        return new UIntArray(storage);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final void o(CompositeEncoder encoder, Object obj, int i2) {
        int[] content = ((UIntArray) obj).f53558a;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(content, "content");
        for (int i3 = 0; i3 < i2; i3++) {
            Encoder encoderL = encoder.l(this.f55888b, i3);
            int i4 = content[i3];
            UInt.Companion companion = UInt.f53556b;
            encoderL.A(i4);
        }
    }
}
