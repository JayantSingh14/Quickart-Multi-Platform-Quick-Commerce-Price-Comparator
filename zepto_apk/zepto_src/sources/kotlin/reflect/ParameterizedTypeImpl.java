package kotlin.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@ExperimentalStdlibApi
@SourceDebugExtension
/* loaded from: classes3.dex */
final class ParameterizedTypeImpl implements ParameterizedType, TypeImpl {

    /* renamed from: a, reason: collision with root package name */
    public final Class f53882a;

    /* renamed from: b, reason: collision with root package name */
    public final Type f53883b;

    /* renamed from: c, reason: collision with root package name */
    public final Type[] f53884c;

    public ParameterizedTypeImpl(Class rawType, Type type, ArrayList typeArguments) {
        Intrinsics.checkNotNullParameter(rawType, "rawType");
        Intrinsics.checkNotNullParameter(typeArguments, "typeArguments");
        this.f53882a = rawType;
        this.f53883b = type;
        this.f53884c = (Type[]) typeArguments.toArray(new Type[0]);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ParameterizedType)) {
            return false;
        }
        ParameterizedType parameterizedType = (ParameterizedType) obj;
        if (Intrinsics.b(this.f53882a, parameterizedType.getRawType()) && Intrinsics.b(this.f53883b, parameterizedType.getOwnerType())) {
            return Arrays.equals(this.f53884c, parameterizedType.getActualTypeArguments());
        }
        return false;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type[] getActualTypeArguments() {
        return this.f53884c;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getOwnerType() {
        return this.f53883b;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getRawType() {
        return this.f53882a;
    }

    @Override // java.lang.reflect.Type
    public final String getTypeName() {
        StringBuilder sb = new StringBuilder();
        Class cls = this.f53882a;
        Type type = this.f53883b;
        if (type != null) {
            sb.append(TypesJVMKt.a(type));
            sb.append("$");
            sb.append(cls.getSimpleName());
        } else {
            sb.append(TypesJVMKt.a(cls));
        }
        Type[] typeArr = this.f53884c;
        if (typeArr.length != 0) {
            ArraysKt___ArraysKt.b(typeArr, sb, ", ", "<", ">", ParameterizedTypeImpl$getTypeName$1$1.f53885b);
        }
        return sb.toString();
    }

    public final int hashCode() {
        int iHashCode = this.f53882a.hashCode();
        Type type = this.f53883b;
        return (iHashCode ^ (type != null ? type.hashCode() : 0)) ^ Arrays.hashCode(this.f53884c);
    }

    public final String toString() {
        return getTypeName();
    }
}
