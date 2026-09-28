package kotlinx.serialization.descriptors;

import android.support.v4.media.b;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.internal.PrimitiveSerialDescriptor;
import kotlinx.serialization.internal.PrimitivesKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class SerialDescriptorsKt {
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.util.Map] */
    public static final PrimitiveSerialDescriptor a(String serialName) {
        PrimitiveKind.STRING kind = PrimitiveKind.STRING.f55740a;
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(kind, "kind");
        if (StringsKt.z(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        Object obj = PrimitivesKt.f55891a;
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Iterator it = PrimitivesKt.f55891a.keySet().iterator();
        while (it.hasNext()) {
            String strI = ((KClass) it.next()).i();
            Intrinsics.c(strI);
            String strA = PrimitivesKt.a(strI);
            if (serialName.equalsIgnoreCase("kotlin." + strA) || serialName.equalsIgnoreCase(strA)) {
                StringBuilder sbY = b.y("\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name ", serialName, " there already exist ");
                sbY.append(PrimitivesKt.a(strA));
                sbY.append("Serializer.\n                Please refer to SerialDescriptor documentation for additional information.\n            ");
                throw new IllegalArgumentException(StringsKt.e0(sbY.toString()));
            }
        }
        return new PrimitiveSerialDescriptor(serialName, kind);
    }

    public static final SerialDescriptorImpl b(String serialName, SerialDescriptor[] typeParameters, Function1 builderAction) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(typeParameters, "typeParameters");
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        if (StringsKt.z(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        ClassSerialDescriptorBuilder classSerialDescriptorBuilder = new ClassSerialDescriptorBuilder(serialName);
        builderAction.invoke(classSerialDescriptorBuilder);
        return new SerialDescriptorImpl(serialName, StructureKind.CLASS.f55765a, classSerialDescriptorBuilder.f55722c.size(), ArraysKt.F(typeParameters), classSerialDescriptorBuilder);
    }

    public static final SerialDescriptorImpl d(String serialName, SerialKind kind, SerialDescriptor[] typeParameters, Function1 builder) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(typeParameters, "typeParameters");
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (StringsKt.z(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        if (kind.equals(StructureKind.CLASS.f55765a)) {
            throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
        }
        ClassSerialDescriptorBuilder classSerialDescriptorBuilder = new ClassSerialDescriptorBuilder(serialName);
        builder.invoke(classSerialDescriptorBuilder);
        return new SerialDescriptorImpl(serialName, kind, classSerialDescriptorBuilder.f55722c.size(), ArraysKt.F(typeParameters), classSerialDescriptorBuilder);
    }
}
