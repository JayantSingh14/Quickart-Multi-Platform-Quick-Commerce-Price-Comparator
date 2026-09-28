package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata
@PublishedApi
/* loaded from: classes.dex */
public final class UByteSerializer implements KSerializer<UByte> {

    /* renamed from: a, reason: collision with root package name */
    public static final UByteSerializer f55919a = new UByteSerializer();

    /* renamed from: b, reason: collision with root package name */
    public static final InlineClassDescriptor f55920b;

    static {
        Intrinsics.checkNotNullParameter(ByteCompanionObject.f53782a, "<this>");
        f55920b = InlineClassDescriptorKt.a("kotlin.UByte", ByteSerializer.f55778a);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return f55920b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return new UByte(decoder.p(f55920b).D());
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        byte b2 = ((UByte) obj).f53552a;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        encoder.n(f55920b).h(b2);
    }
}
