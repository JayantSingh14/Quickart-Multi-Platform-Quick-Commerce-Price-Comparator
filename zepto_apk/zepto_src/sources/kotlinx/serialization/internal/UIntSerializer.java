package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.UInt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata
@PublishedApi
/* loaded from: classes.dex */
public final class UIntSerializer implements KSerializer<UInt> {

    /* renamed from: a, reason: collision with root package name */
    public static final UIntSerializer f55924a = new UIntSerializer();

    /* renamed from: b, reason: collision with root package name */
    public static final InlineClassDescriptor f55925b;

    static {
        Intrinsics.checkNotNullParameter(IntCompanionObject.f53794a, "<this>");
        f55925b = InlineClassDescriptorKt.a("kotlin.UInt", IntSerializer.f55831a);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return f55925b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return new UInt(decoder.p(f55925b).k());
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        int i2 = ((UInt) obj).f53557a;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        encoder.n(f55925b).A(i2);
    }
}
