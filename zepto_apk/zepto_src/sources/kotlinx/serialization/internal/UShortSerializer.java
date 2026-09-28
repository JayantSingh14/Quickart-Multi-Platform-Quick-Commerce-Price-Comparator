package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.ShortCompanionObject;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata
@PublishedApi
/* loaded from: classes.dex */
public final class UShortSerializer implements KSerializer<UShort> {

    /* renamed from: a, reason: collision with root package name */
    public static final UShortSerializer f55934a = new UShortSerializer();

    /* renamed from: b, reason: collision with root package name */
    public static final InlineClassDescriptor f55935b;

    static {
        Intrinsics.checkNotNullParameter(ShortCompanionObject.f53804a, "<this>");
        f55935b = InlineClassDescriptorKt.a("kotlin.UShort", ShortSerializer.f55900a);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return f55935b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return new UShort(decoder.p(f55935b).r());
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        short s = ((UShort) obj).f53568a;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        encoder.n(f55935b).r(s);
    }
}
