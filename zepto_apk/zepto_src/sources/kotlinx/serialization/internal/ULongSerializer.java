package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata
@PublishedApi
/* loaded from: classes.dex */
public final class ULongSerializer implements KSerializer<ULong> {

    /* renamed from: a, reason: collision with root package name */
    public static final ULongSerializer f55929a = new ULongSerializer();

    /* renamed from: b, reason: collision with root package name */
    public static final InlineClassDescriptor f55930b;

    static {
        Intrinsics.checkNotNullParameter(LongCompanionObject.f53795a, "<this>");
        f55930b = InlineClassDescriptorKt.a("kotlin.ULong", LongSerializer.f55842a);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return f55930b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return new ULong(decoder.p(f55930b).m());
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        long j2 = ((ULong) obj).f53562a;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        encoder.n(f55930b).o(j2);
    }
}
