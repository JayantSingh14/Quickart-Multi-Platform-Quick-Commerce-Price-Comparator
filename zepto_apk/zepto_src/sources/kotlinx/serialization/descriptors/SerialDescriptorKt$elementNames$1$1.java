package kotlinx.serialization.descriptors;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.internal.EnumDescriptor;

@Metadata
/* loaded from: classes3.dex */
public final class SerialDescriptorKt$elementNames$1$1 implements Iterator<String>, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    public int f55759a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EnumDescriptor f55760b;

    public SerialDescriptorKt$elementNames$1$1(EnumDescriptor enumDescriptor) {
        this.f55760b = enumDescriptor;
        this.f55759a = enumDescriptor.f55873c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f55759a > 0;
    }

    @Override // java.util.Iterator
    public final String next() {
        EnumDescriptor enumDescriptor = this.f55760b;
        int i2 = this.f55759a;
        this.f55759a = i2 - 1;
        return enumDescriptor.f55875e[enumDescriptor.f55873c - i2];
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
