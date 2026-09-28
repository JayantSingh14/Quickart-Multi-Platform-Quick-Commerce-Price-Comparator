package kotlinx.serialization.internal;

import android.support.v4.media.b;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata
@InternalSerializationApi
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class MapLikeSerializer<Key, Value, Collection, Builder extends Map<Key, Value>> extends AbstractCollectionSerializer<Map.Entry<? extends Key, ? extends Value>, Collection, Builder> {

    /* renamed from: a, reason: collision with root package name */
    public final KSerializer f55852a;

    /* renamed from: b, reason: collision with root package name */
    public final KSerializer f55853b;

    public MapLikeSerializer(KSerializer kSerializer, KSerializer kSerializer2) {
        this.f55852a = kSerializer;
        this.f55853b = kSerializer2;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        int iH = h(obj);
        SerialDescriptor serialDescriptorA = a();
        CompositeEncoder compositeEncoderK = encoder.k(serialDescriptorA, iH);
        Iterator itG = g(obj);
        int i2 = 0;
        while (itG.hasNext()) {
            Map.Entry entry = (Map.Entry) itG.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            int i3 = i2 + 1;
            compositeEncoderK.B(a(), i2, this.f55852a, key);
            i2 += 2;
            compositeEncoderK.B(a(), i3, this.f55853b, value);
        }
        compositeEncoderK.c(serialDescriptorA);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void j(CompositeDecoder decoder, int i2, Object obj) {
        Map builder = (Map) obj;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(builder, "builder");
        Object objX = decoder.x(a(), i2, this.f55852a, null);
        int iO = decoder.o(a());
        if (iO != i2 + 1) {
            throw new IllegalArgumentException(b.d(i2, iO, "Value must follow key in a map, index for key: ", ", returned index for value: ").toString());
        }
        boolean zContainsKey = builder.containsKey(objX);
        KSerializer kSerializer = this.f55853b;
        builder.put(objX, (!zContainsKey || (kSerializer.a().d() instanceof PrimitiveKind)) ? decoder.x(a(), iO, kSerializer, null) : decoder.x(a(), iO, kSerializer, MapsKt.d(objX, builder)));
    }
}
