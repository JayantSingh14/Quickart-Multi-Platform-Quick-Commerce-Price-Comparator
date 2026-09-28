package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata
@PublishedApi
/* loaded from: classes3.dex */
public final class NullableSerializer<T> implements KSerializer<T> {

    /* renamed from: a, reason: collision with root package name */
    public final KSerializer f55859a;

    /* renamed from: b, reason: collision with root package name */
    public final SerialDescriptorForNullable f55860b;

    public NullableSerializer(KSerializer serializer) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        this.f55859a = serializer;
        this.f55860b = new SerialDescriptorForNullable(serializer.a());
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return this.f55860b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        if (decoder.A()) {
            return decoder.w(this.f55859a);
        }
        return null;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        if (obj == null) {
            encoder.q();
        } else {
            encoder.v();
            encoder.e(this.f55859a, obj);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && NullableSerializer.class == obj.getClass() && Intrinsics.b(this.f55859a, ((NullableSerializer) obj).f55859a);
    }

    public final int hashCode() {
        return this.f55859a.hashCode();
    }
}
