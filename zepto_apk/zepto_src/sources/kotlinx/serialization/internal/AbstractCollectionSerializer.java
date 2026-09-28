package kotlinx.serialization.internal;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;

@Metadata
@InternalSerializationApi
/* loaded from: classes.dex */
public abstract class AbstractCollectionSerializer<Element, Collection, Builder> implements KSerializer<Collection> {
    @Override // kotlinx.serialization.DeserializationStrategy
    public Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return i(decoder);
    }

    public abstract Object e();

    public abstract int f(Object obj);

    public abstract Iterator g(Object obj);

    public abstract int h(Object obj);

    public final Object i(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Object objE = e();
        int iF = f(objE);
        CompositeDecoder compositeDecoderB = decoder.b(a());
        while (true) {
            int iO = compositeDecoderB.o(a());
            if (iO == -1) {
                compositeDecoderB.c(a());
                return l(objE);
            }
            j(compositeDecoderB, iO + iF, objE);
        }
    }

    public abstract void j(CompositeDecoder compositeDecoder, int i2, Object obj);

    public abstract Object k(Object obj);

    public abstract Object l(Object obj);
}
