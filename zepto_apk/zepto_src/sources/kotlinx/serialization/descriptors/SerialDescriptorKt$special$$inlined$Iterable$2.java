package kotlinx.serialization.descriptors;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.internal.EnumDescriptor;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class SerialDescriptorKt$special$$inlined$Iterable$2 implements Iterable<String>, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EnumDescriptor f55756a;

    public SerialDescriptorKt$special$$inlined$Iterable$2(EnumDescriptor enumDescriptor) {
        this.f55756a = enumDescriptor;
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        return new SerialDescriptorKt$elementNames$1$1(this.f55756a);
    }
}
