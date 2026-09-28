package io.ktor.util.reflect;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeReference;

@Metadata
/* loaded from: classes.dex */
public final class TypeInfoJvmKt {
    public static final TypeInfo a(Type reifiedType, ClassReference kClass, TypeReference typeReference) {
        Intrinsics.checkNotNullParameter(reifiedType, "reifiedType");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        return new TypeInfo(kClass, reifiedType, typeReference);
    }
}
