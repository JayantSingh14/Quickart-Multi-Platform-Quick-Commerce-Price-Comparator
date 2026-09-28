package kotlinx.serialization.internal;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.apache.commons.lang3.ClassUtils;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class Platform_commonKt {

    /* renamed from: a, reason: collision with root package name */
    public static final SerialDescriptor[] f55870a = new SerialDescriptor[0];

    public static final Set a(SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        if (serialDescriptor instanceof CachedNames) {
            return ((CachedNames) serialDescriptor).a();
        }
        HashSet hashSet = new HashSet(serialDescriptor.e());
        int iE = serialDescriptor.e();
        for (int i2 = 0; i2 < iE; i2++) {
            hashSet.add(serialDescriptor.f(i2));
        }
        return hashSet;
    }

    public static final SerialDescriptor[] b(List list) {
        SerialDescriptor[] serialDescriptorArr;
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            list = null;
        }
        return (list == null || (serialDescriptorArr = (SerialDescriptor[]) list.toArray(new SerialDescriptor[0])) == null) ? f55870a : serialDescriptorArr;
    }

    public static final KClass c(KType kType) {
        Intrinsics.checkNotNullParameter(kType, "<this>");
        KClassifier kClassifierF = kType.f();
        if (kClassifierF instanceof KClass) {
            return (KClass) kClassifierF;
        }
        if (!(kClassifierF instanceof KTypeParameter)) {
            throw new IllegalArgumentException("Only KClass supported as classifier, got " + kClassifierF);
        }
        throw new IllegalArgumentException("Captured type parameter " + kClassifierF + " from generic non-reified function. Such functionality cannot be supported because " + kClassifierF + " is erased, either specify serializer explicitly or make calling function inline with reified " + kClassifierF + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    public static final void d(KClass kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        String className = kClass.i();
        if (className == null) {
            className = "<local class name not available>";
        }
        Intrinsics.checkNotNullParameter(className, "className");
        throw new SerializationException("Serializer for class '" + className + "' is not found.\nPlease ensure that class is marked as '@Serializable' and that the serialization compiler plugin is applied.\n");
    }
}
