package kotlinx.serialization.internal;

import androidx.fragment.app.e;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorKt;
import kotlinx.serialization.descriptors.SerialDescriptorKt$elementNames$1$1;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialDescriptorsKt$buildSerialDescriptor$1;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import org.apache.commons.lang3.ClassUtils;

@Metadata
@PublishedApi
@SourceDebugExtension
/* loaded from: classes.dex */
public final class EnumDescriptor extends PluginGeneratedSerialDescriptor {

    /* renamed from: l, reason: collision with root package name */
    public final SerialKind.ENUM f55810l;

    /* renamed from: m, reason: collision with root package name */
    public final Lazy f55811m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnumDescriptor(final String name, final int i2) {
        super(name, null, i2);
        Intrinsics.checkNotNullParameter(name, "name");
        this.f55810l = SerialKind.ENUM.f55764a;
        this.f55811m = LazyKt.b(new Function0<SerialDescriptor[]>() { // from class: kotlinx.serialization.internal.EnumDescriptor$elementDescriptors$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i3 = i2;
                SerialDescriptor[] serialDescriptorArr = new SerialDescriptor[i3];
                for (int i4 = 0; i4 < i3; i4++) {
                    serialDescriptorArr[i4] = SerialDescriptorsKt.d(name + ClassUtils.PACKAGE_SEPARATOR_CHAR + this.f55875e[i4], StructureKind.OBJECT.f55768a, new SerialDescriptor[0], SerialDescriptorsKt$buildSerialDescriptor$1.f55762c);
                }
                return serialDescriptorArr;
            }
        });
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor, kotlinx.serialization.descriptors.SerialDescriptor
    public final SerialKind d() {
        return this.f55810l;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SerialDescriptor)) {
            return false;
        }
        SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
        if (serialDescriptor.d() != SerialKind.ENUM.f55764a) {
            return false;
        }
        return Intrinsics.b(this.f55871a, serialDescriptor.i()) && Intrinsics.b(Platform_commonKt.a(this), Platform_commonKt.a(serialDescriptor));
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor, kotlinx.serialization.descriptors.SerialDescriptor
    public final SerialDescriptor h(int i2) {
        return ((SerialDescriptor[]) this.f55811m.getValue())[i2];
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public final int hashCode() {
        int iHashCode = this.f55871a.hashCode();
        Iterator<String> it = SerialDescriptorKt.a(this).iterator();
        int iHashCode2 = 1;
        while (true) {
            SerialDescriptorKt$elementNames$1$1 serialDescriptorKt$elementNames$1$1 = (SerialDescriptorKt$elementNames$1$1) it;
            if (!serialDescriptorKt$elementNames$1$1.hasNext()) {
                return (iHashCode * 31) + iHashCode2;
            }
            int i2 = iHashCode2 * 31;
            String str = (String) serialDescriptorKt$elementNames$1$1.next();
            iHashCode2 = i2 + (str != null ? str.hashCode() : 0);
        }
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public final String toString() {
        return CollectionsKt.E(SerialDescriptorKt.a(this), ", ", e.t(new StringBuilder(), this.f55871a, '('), ")", null, 56);
    }
}
