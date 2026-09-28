package kotlin.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@ExperimentalStdlibApi
/* loaded from: classes3.dex */
final class GenericArrayTypeImpl implements GenericArrayType, TypeImpl {
    public final boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && Intrinsics.b(null, ((GenericArrayType) obj).getGenericComponentType());
    }

    @Override // java.lang.reflect.GenericArrayType
    public final Type getGenericComponentType() {
        return null;
    }

    @Override // java.lang.reflect.Type
    public final String getTypeName() {
        return TypesJVMKt.a(null) + "[]";
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return getTypeName();
    }
}
