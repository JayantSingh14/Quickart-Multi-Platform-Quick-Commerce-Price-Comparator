package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.descriptors.ContextAwareKt;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.modules.SerialModuleImpl;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class WriteModeKt {
    public static final SerialDescriptor a(SerialDescriptor serialDescriptor, SerialModuleImpl module) {
        SerialDescriptor serialDescriptorA;
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(module, "module");
        if (!Intrinsics.b(serialDescriptor.d(), SerialKind.CONTEXTUAL.f55763a)) {
            return serialDescriptor.isInline() ? a(serialDescriptor.h(0), module) : serialDescriptor;
        }
        SerialDescriptor serialDescriptorB = ContextAwareKt.b(serialDescriptor, module);
        return (serialDescriptorB == null || (serialDescriptorA = a(serialDescriptorB, module)) == null) ? serialDescriptor : serialDescriptorA;
    }

    public static final WriteMode b(SerialDescriptor desc, Json json) {
        Intrinsics.checkNotNullParameter(json, "<this>");
        Intrinsics.checkNotNullParameter(desc, "desc");
        SerialKind serialKindD = desc.d();
        if (serialKindD instanceof PolymorphicKind) {
            return WriteMode.f56111f;
        }
        if (Intrinsics.b(serialKindD, StructureKind.LIST.f55766a)) {
            return WriteMode.f56109d;
        }
        if (!Intrinsics.b(serialKindD, StructureKind.MAP.f55767a)) {
            return WriteMode.f56108c;
        }
        SerialDescriptor serialDescriptorA = a(desc.h(0), json.f55946b);
        SerialKind serialKindD2 = serialDescriptorA.d();
        if ((serialKindD2 instanceof PrimitiveKind) || Intrinsics.b(serialKindD2, SerialKind.ENUM.f55764a)) {
            return WriteMode.f56110e;
        }
        if (json.f55945a.f55969d) {
            return WriteMode.f56109d;
        }
        throw JsonExceptionsKt.b(serialDescriptorA);
    }
}
