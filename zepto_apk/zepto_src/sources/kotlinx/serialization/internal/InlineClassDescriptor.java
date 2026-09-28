package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata
@PublishedApi
@SourceDebugExtension
/* loaded from: classes.dex */
public final class InlineClassDescriptor extends PluginGeneratedSerialDescriptor {

    /* renamed from: l, reason: collision with root package name */
    public final boolean f55826l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InlineClassDescriptor(String name, InlineClassDescriptorKt$InlinePrimitiveDescriptor$1 generatedSerializer) {
        super(name, generatedSerializer, 1);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(generatedSerializer, "generatedSerializer");
        this.f55826l = true;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, kotlin.Lazy] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InlineClassDescriptor) {
            SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
            if (Intrinsics.b(this.f55871a, serialDescriptor.i())) {
                InlineClassDescriptor inlineClassDescriptor = (InlineClassDescriptor) obj;
                if (inlineClassDescriptor.f55826l && Arrays.equals((SerialDescriptor[]) this.f55880j.getValue(), (SerialDescriptor[]) inlineClassDescriptor.f55880j.getValue())) {
                    int iE = serialDescriptor.e();
                    int i2 = this.f55873c;
                    if (i2 == iE) {
                        for (int i3 = 0; i3 < i2; i3++) {
                            if (Intrinsics.b(h(i3).i(), serialDescriptor.h(i3).i()) && Intrinsics.b(h(i3).d(), serialDescriptor.h(i3).d())) {
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public final int hashCode() {
        return super.hashCode() * 31;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor, kotlinx.serialization.descriptors.SerialDescriptor
    public final boolean isInline() {
        return this.f55826l;
    }
}
