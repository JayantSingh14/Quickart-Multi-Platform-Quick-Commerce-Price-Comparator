package kotlinx.serialization.descriptors;

import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.internal.SerialDescriptorForNullable;
import kotlinx.serialization.modules.SerialModuleImpl;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ContextAwareKt {
    public static final KClass a(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        if (serialDescriptor instanceof ContextDescriptor) {
            return ((ContextDescriptor) serialDescriptor).f55728b;
        }
        if (serialDescriptor instanceof SerialDescriptorForNullable) {
            return a(((SerialDescriptorForNullable) serialDescriptor).f55894a);
        }
        return null;
    }

    public static final SerialDescriptor b(SerialDescriptor descriptor, SerialModuleImpl serialModuleImpl) {
        KSerializer kSerializerA;
        Intrinsics.checkNotNullParameter(serialModuleImpl, "<this>");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        KClass kClassA = a(descriptor);
        if (kClassA == null || (kSerializerA = serialModuleImpl.a(kClassA, EmptyList.f53609a)) == null) {
            return null;
        }
        return kSerializerA.a();
    }

    public static final SerialDescriptor c(SerialDescriptorImpl serialDescriptorImpl, ClassReference context) {
        Intrinsics.checkNotNullParameter(serialDescriptorImpl, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return new ContextDescriptor(serialDescriptorImpl, context);
    }
}
