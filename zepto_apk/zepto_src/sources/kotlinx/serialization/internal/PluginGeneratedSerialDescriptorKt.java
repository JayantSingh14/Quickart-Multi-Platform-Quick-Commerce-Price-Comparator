package kotlinx.serialization.internal;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorKt$elementDescriptors$1$1;
import kotlinx.serialization.descriptors.SerialDescriptorKt$special$$inlined$Iterable$1;
import kotlinx.serialization.descriptors.SerialKind;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class PluginGeneratedSerialDescriptorKt {
    public static final int a(SerialDescriptor serialDescriptor, SerialDescriptor[] typeParams) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(typeParams, "typeParams");
        int iHashCode = (serialDescriptor.i().hashCode() * 31) + Arrays.hashCode(typeParams);
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        SerialDescriptorKt$special$$inlined$Iterable$1 serialDescriptorKt$special$$inlined$Iterable$1 = new SerialDescriptorKt$special$$inlined$Iterable$1(serialDescriptor);
        Iterator<SerialDescriptor> it = serialDescriptorKt$special$$inlined$Iterable$1.iterator();
        int iHashCode2 = 1;
        int i2 = 1;
        while (true) {
            SerialDescriptorKt$elementDescriptors$1$1 serialDescriptorKt$elementDescriptors$1$1 = (SerialDescriptorKt$elementDescriptors$1$1) it;
            int iHashCode3 = 0;
            if (!serialDescriptorKt$elementDescriptors$1$1.hasNext()) {
                break;
            }
            int i3 = i2 * 31;
            String strI = ((SerialDescriptor) serialDescriptorKt$elementDescriptors$1$1.next()).i();
            if (strI != null) {
                iHashCode3 = strI.hashCode();
            }
            i2 = i3 + iHashCode3;
        }
        Iterator<SerialDescriptor> it2 = serialDescriptorKt$special$$inlined$Iterable$1.iterator();
        while (true) {
            SerialDescriptorKt$elementDescriptors$1$1 serialDescriptorKt$elementDescriptors$1$12 = (SerialDescriptorKt$elementDescriptors$1$1) it2;
            if (!serialDescriptorKt$elementDescriptors$1$12.hasNext()) {
                return (((iHashCode * 31) + i2) * 31) + iHashCode2;
            }
            int i4 = iHashCode2 * 31;
            SerialKind serialKindD = ((SerialDescriptor) serialDescriptorKt$elementDescriptors$1$12.next()).d();
            iHashCode2 = i4 + (serialKindD != null ? serialKindD.hashCode() : 0);
        }
    }
}
