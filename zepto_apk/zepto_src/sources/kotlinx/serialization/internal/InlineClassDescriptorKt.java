package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata
/* loaded from: classes.dex */
public final class InlineClassDescriptorKt {
    /* JADX WARN: Type inference failed for: r1v0, types: [kotlinx.serialization.internal.InlineClassDescriptorKt$InlinePrimitiveDescriptor$1] */
    public static final InlineClassDescriptor a(String name, final KSerializer primitiveSerializer) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(primitiveSerializer, "primitiveSerializer");
        return new InlineClassDescriptor(name, new GeneratedSerializer<Object>() { // from class: kotlinx.serialization.internal.InlineClassDescriptorKt$InlinePrimitiveDescriptor$1
            @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
            public final SerialDescriptor a() {
                throw new IllegalStateException("unsupported");
            }

            @Override // kotlinx.serialization.DeserializationStrategy
            public final Object b(Decoder decoder) {
                Intrinsics.checkNotNullParameter(decoder, "decoder");
                throw new IllegalStateException("unsupported");
            }

            @Override // kotlinx.serialization.SerializationStrategy
            public final void c(Encoder encoder, Object obj) {
                Intrinsics.checkNotNullParameter(encoder, "encoder");
                throw new IllegalStateException("unsupported");
            }

            @Override // kotlinx.serialization.internal.GeneratedSerializer
            public final KSerializer[] d() {
                return new KSerializer[]{primitiveSerializer};
            }
        });
    }
}
