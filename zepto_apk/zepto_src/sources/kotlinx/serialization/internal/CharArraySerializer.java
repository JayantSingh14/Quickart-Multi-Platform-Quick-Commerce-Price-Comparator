package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;

@Metadata
@PublishedApi
/* loaded from: classes.dex */
public final class CharArraySerializer extends PrimitiveArraySerializer<Character, char[], CharArrayBuilder> implements KSerializer<char[]> {

    /* renamed from: c, reason: collision with root package name */
    public static final CharArraySerializer f55784c;

    static {
        Intrinsics.checkNotNullParameter(CharCompanionObject.f53784a, "<this>");
        f55784c = new CharArraySerializer(CharSerializer.f55785a);
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final int h(Object obj) {
        char[] cArr = (char[]) obj;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return cArr.length;
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.internal.AbstractCollectionSerializer
    public final void j(CompositeDecoder decoder, int i2, Object obj) {
        CharArrayBuilder builder = (CharArrayBuilder) obj;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.e(decoder.f(this.f55888b, i2));
    }

    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public final Object k(Object obj) {
        char[] cArr = (char[]) obj;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return new CharArrayBuilder(cArr);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final Object n() {
        return new char[0];
    }

    @Override // kotlinx.serialization.internal.PrimitiveArraySerializer
    public final void o(CompositeEncoder encoder, Object obj, int i2) {
        char[] content = (char[]) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(content, "content");
        for (int i3 = 0; i3 < i2; i3++) {
            encoder.g(this.f55888b, i3, content[i3]);
        }
    }
}
