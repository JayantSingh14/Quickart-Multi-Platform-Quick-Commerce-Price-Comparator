package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

@Metadata
@PublishedApi
/* loaded from: classes.dex */
public final class FloatArraySerializer extends PrimitiveArraySerializer<Float, float[], FloatArrayBuilder> implements KSerializer<float[]> {

    /* renamed from: c, reason: collision with root package name */
    public static final FloatArraySerializer f55821c;

    static {
        Intrinsics.checkNotNullParameter(FloatCompanionObject.f53793a, "<this>");
        f55821c = new FloatArraySerializer(FloatSerializer.f55822a);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final int h(Object obj) {
        float[] fArr = (float[]) obj;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return fArr.length;
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void j(CompositeDecoder decoder, int i2, Object obj) {
        FloatArrayBuilder builder = (FloatArrayBuilder) obj;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.e(decoder.e(this.f55888b, i2));
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object k(Object obj) {
        float[] fArr = (float[]) obj;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return new FloatArrayBuilder(fArr);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final Object n() {
        return new float[0];
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final void o(CompositeEncoder encoder, Object obj, int i2) {
        float[] content = (float[]) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(content, "content");
        for (int i3 = 0; i3 < i2; i3++) {
            encoder.j(this.f55888b, i3, content[i3]);
        }
    }
}
