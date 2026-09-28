package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata
@PublishedApi
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class CollectionLikeSerializer<Element, Collection, Builder> extends AbstractCollectionSerializer<Element, Collection, Builder> {

    /* renamed from: a, reason: collision with root package name */
    public final KSerializer f55793a;

    public CollectionLikeSerializer(KSerializer kSerializer) {
        this.f55793a = kSerializer;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void c(Encoder encoder, Object obj) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        int iH = h(obj);
        SerialDescriptor serialDescriptorA = a();
        CompositeEncoder compositeEncoderK = encoder.k(serialDescriptorA, iH);
        Iterator itG = g(obj);
        for (int i2 = 0; i2 < iH; i2++) {
            compositeEncoderK.B(a(), i2, this.f55793a, itG.next());
        }
        compositeEncoderK.c(serialDescriptorA);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public void j(CompositeDecoder decoder, int i2, Object obj) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        m(i2, obj, decoder.x(a(), i2, this.f55793a, null));
    }

    public abstract void m(int i2, Object obj, Object obj2);
}
