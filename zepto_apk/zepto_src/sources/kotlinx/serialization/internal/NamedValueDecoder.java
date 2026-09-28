package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.apache.commons.lang3.ClassUtils;

@Metadata
@InternalSerializationApi
/* loaded from: classes3.dex */
public abstract class NamedValueDecoder extends TaggedDecoder<String> {
    public String T(String parentName, String childName) {
        Intrinsics.checkNotNullParameter(parentName, "parentName");
        Intrinsics.checkNotNullParameter(childName, "childName");
        if (parentName.length() == 0) {
            return childName;
        }
        return parentName + ClassUtils.PACKAGE_SEPARATOR_CHAR + childName;
    }

    public String U(SerialDescriptor descriptor, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return descriptor.f(i2);
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public final String R(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        String nestedName = U(serialDescriptor, i2);
        Intrinsics.checkNotNullParameter(nestedName, "nestedName");
        String str = (String) CollectionsKt.G(this.f55904a);
        if (str == null) {
            str = "";
        }
        return T(str, nestedName);
    }
}
