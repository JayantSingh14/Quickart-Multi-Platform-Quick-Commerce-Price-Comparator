package io.ktor.util.reflect;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KClass;

@Metadata
/* loaded from: classes.dex */
public final class TypeInfo {

    /* renamed from: a, reason: collision with root package name */
    public final KClass f50602a;

    /* renamed from: b, reason: collision with root package name */
    public final Type f50603b;

    /* renamed from: c, reason: collision with root package name */
    public final TypeReference f50604c;

    public TypeInfo(KClass type, Type reifiedType, TypeReference typeReference) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(reifiedType, "reifiedType");
        this.f50602a = type;
        this.f50603b = reifiedType;
        this.f50604c = typeReference;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TypeInfo)) {
            return false;
        }
        TypeInfo typeInfo = (TypeInfo) obj;
        return this.f50602a.equals(typeInfo.f50602a) && this.f50603b.equals(typeInfo.f50603b) && Intrinsics.b(this.f50604c, typeInfo.f50604c);
    }

    public final int hashCode() {
        int iHashCode = (this.f50603b.hashCode() + (this.f50602a.hashCode() * 31)) * 31;
        TypeReference typeReference = this.f50604c;
        return iHashCode + (typeReference == null ? 0 : typeReference.hashCode());
    }

    public final String toString() {
        return "TypeInfo(type=" + this.f50602a + ", reifiedType=" + this.f50603b + ", kotlinType=" + this.f50604c + ')';
    }
}
