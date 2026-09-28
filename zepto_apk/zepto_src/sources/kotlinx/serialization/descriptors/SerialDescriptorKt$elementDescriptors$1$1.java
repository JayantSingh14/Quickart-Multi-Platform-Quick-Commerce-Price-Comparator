package kotlinx.serialization.descriptors;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata
/* loaded from: classes3.dex */
public final class SerialDescriptorKt$elementDescriptors$1$1 implements Iterator<SerialDescriptor>, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    public int f55757a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SerialDescriptor f55758b;

    public SerialDescriptorKt$elementDescriptors$1$1(SerialDescriptor serialDescriptor) {
        this.f55758b = serialDescriptor;
        this.f55757a = serialDescriptor.e();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f55757a > 0;
    }

    @Override // java.util.Iterator
    public final SerialDescriptor next() {
        SerialDescriptor serialDescriptor = this.f55758b;
        int iE = serialDescriptor.e();
        int i2 = this.f55757a;
        this.f55757a = i2 - 1;
        return serialDescriptor.h(iE - i2);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
