package kotlinx.serialization.internal;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata
@PublishedApi
@SourceDebugExtension
/* loaded from: classes3.dex */
public abstract class KeyValueSerializer<K, V, R> implements KSerializer<R> {

    /* renamed from: a, reason: collision with root package name */
    public final KSerializer f55834a;

    /* renamed from: b, reason: collision with root package name */
    public final KSerializer f55835b;

    public KeyValueSerializer(KSerializer kSerializer, KSerializer kSerializer2) {
        this.f55834a = kSerializer;
        this.f55835b = kSerializer2;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptorA = a();
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptorA);
        Object obj = TuplesKt.f55915a;
        Object objX = obj;
        Object objX2 = objX;
        while (true) {
            int iO = compositeDecoderB.o(a());
            if (iO == -1) {
                if (objX == obj) {
                    throw new SerializationException("Element 'key' is missing");
                }
                if (objX2 == obj) {
                    throw new SerializationException("Element 'value' is missing");
                }
                Object objG = g(objX, objX2);
                compositeDecoderB.c(serialDescriptorA);
                return objG;
            }
            if (iO == 0) {
                objX = compositeDecoderB.x(a(), 0, this.f55834a, null);
            } else {
                if (iO != 1) {
                    throw new SerializationException(b.f(iO, "Invalid index: "));
                }
                objX2 = compositeDecoderB.x(a(), 1, this.f55835b, null);
            }
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        CompositeEncoder compositeEncoderB = encoder.b(a());
        compositeEncoderB.B(a(), 0, this.f55834a, e(obj));
        compositeEncoderB.B(a(), 1, this.f55835b, f(obj));
        compositeEncoderB.c(a());
    }

    public abstract Object e(Object obj);

    public abstract Object f(Object obj);

    public abstract Object g(Object obj, Object obj2);
}
