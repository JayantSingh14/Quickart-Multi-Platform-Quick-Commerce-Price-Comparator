package kotlinx.serialization.descriptors;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.internal.EnumDescriptor;

@Metadata
/* loaded from: classes3.dex */
public final class SerialDescriptorKt {
    public static final SerialDescriptorKt$special$$inlined$Iterable$2 a(EnumDescriptor enumDescriptor) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "<this>");
        return new SerialDescriptorKt$special$$inlined$Iterable$2(enumDescriptor);
    }
}
