package com.google.common.reflect;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.reflect.Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class TypeResolver {

    /* renamed from: a, reason: collision with root package name */
    public final TypeTable f43346a;

    /* renamed from: com.google.common.reflect.TypeResolver$1, reason: invalid class name */
    class AnonymousClass1 extends TypeVisitor {
        @Override // com.google.common.reflect.TypeVisitor
        public final void b(Class cls) {
            throw new IllegalArgumentException("No type mapping from " + cls + " to null");
        }

        @Override // com.google.common.reflect.TypeVisitor
        public final void c(GenericArrayType genericArrayType) {
            Joiner joiner = Types.f43367a;
            throw null;
        }

        @Override // com.google.common.reflect.TypeVisitor
        public final void d(ParameterizedType parameterizedType) {
            try {
                parameterizedType.getOwnerType();
                throw null;
            } catch (ClassCastException unused) {
                throw new IllegalArgumentException("null is not a ParameterizedType");
            }
        }

        @Override // com.google.common.reflect.TypeVisitor
        public final void e(TypeVariable typeVariable) {
            new TypeVariableKey(typeVariable);
            throw null;
        }

        @Override // com.google.common.reflect.TypeVisitor
        public final void f(WildcardType wildcardType) {
        }
    }

    public static final class TypeMappingIntrospector extends TypeVisitor {

        /* renamed from: b, reason: collision with root package name */
        public final HashMap f43347b = new HashMap();

        @Override // com.google.common.reflect.TypeVisitor
        public final void b(Class cls) {
            a(cls.getGenericSuperclass());
            a(cls.getGenericInterfaces());
        }

        @Override // com.google.common.reflect.TypeVisitor
        public final void d(ParameterizedType parameterizedType) {
            Class cls = (Class) parameterizedType.getRawType();
            TypeVariable[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Preconditions.n(typeParameters.length == actualTypeArguments.length);
            for (int i2 = 0; i2 < typeParameters.length; i2++) {
                TypeVariableKey typeVariableKey = new TypeVariableKey(typeParameters[i2]);
                Type type = actualTypeArguments[i2];
                HashMap map = this.f43347b;
                if (!map.containsKey(typeVariableKey)) {
                    Type type2 = type;
                    while (true) {
                        if (type2 == null) {
                            map.put(typeVariableKey, type);
                            break;
                        }
                        boolean z = type2 instanceof TypeVariable;
                        TypeVariableKey typeVariableKey2 = null;
                        if (z ? typeVariableKey.a((TypeVariable) type2) : false) {
                            while (type != null) {
                                type = (Type) map.remove(type instanceof TypeVariable ? new TypeVariableKey((TypeVariable) type) : null);
                            }
                        } else {
                            if (z) {
                                typeVariableKey2 = new TypeVariableKey((TypeVariable) type2);
                            }
                            type2 = (Type) map.get(typeVariableKey2);
                        }
                    }
                }
            }
            a(cls);
            a(parameterizedType.getOwnerType());
        }

        @Override // com.google.common.reflect.TypeVisitor
        public final void e(TypeVariable typeVariable) {
            a(typeVariable.getBounds());
        }

        @Override // com.google.common.reflect.TypeVisitor
        public final void f(WildcardType wildcardType) {
            a(wildcardType.getUpperBounds());
        }
    }

    public static final class TypeVariableKey {

        /* renamed from: a, reason: collision with root package name */
        public final TypeVariable f43351a;

        public TypeVariableKey(TypeVariable typeVariable) {
            typeVariable.getClass();
            this.f43351a = typeVariable;
        }

        public final boolean a(TypeVariable typeVariable) {
            TypeVariable typeVariable2 = this.f43351a;
            return typeVariable2.getGenericDeclaration().equals(typeVariable.getGenericDeclaration()) && typeVariable2.getName().equals(typeVariable.getName());
        }

        public final boolean equals(Object obj) {
            if (obj instanceof TypeVariableKey) {
                return a(((TypeVariableKey) obj).f43351a);
            }
            return false;
        }

        public final int hashCode() {
            TypeVariable typeVariable = this.f43351a;
            return Arrays.hashCode(new Object[]{typeVariable.getGenericDeclaration(), typeVariable.getName()});
        }

        public final String toString() {
            return this.f43351a.toString();
        }
    }

    public static class WildcardCapturer {

        /* renamed from: com.google.common.reflect.TypeResolver$WildcardCapturer$1, reason: invalid class name */
        class AnonymousClass1 extends WildcardCapturer {
        }

        static {
            new AtomicInteger();
        }
    }

    public TypeResolver() {
        this.f43346a = new TypeTable();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.google.common.reflect.TypeResolver$TypeTable$1] */
    public final Type a(Type type) {
        type.getClass();
        if (type instanceof TypeVariable) {
            final TypeVariable typeVariable = (TypeVariable) type;
            final TypeTable typeTable = this.f43346a;
            typeTable.getClass();
            return typeTable.a(typeVariable, new TypeTable() { // from class: com.google.common.reflect.TypeResolver.TypeTable.1
                @Override // com.google.common.reflect.TypeResolver.TypeTable
                public final Type a(TypeVariable typeVariable2, AnonymousClass1 anonymousClass1) {
                    return typeVariable2.getGenericDeclaration().equals(typeVariable.getGenericDeclaration()) ? typeVariable2 : typeTable.a(typeVariable2, anonymousClass1);
                }
            });
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type ownerType = parameterizedType.getOwnerType();
            return Types.e(ownerType == null ? null : a(ownerType), (Class) a(parameterizedType.getRawType()), b(parameterizedType.getActualTypeArguments()));
        }
        if (type instanceof GenericArrayType) {
            return Types.c(a(((GenericArrayType) type).getGenericComponentType()));
        }
        if (!(type instanceof WildcardType)) {
            return type;
        }
        WildcardType wildcardType = (WildcardType) type;
        return new Types.WildcardTypeImpl(b(wildcardType.getLowerBounds()), b(wildcardType.getUpperBounds()));
    }

    public final Type[] b(Type[] typeArr) {
        Type[] typeArr2 = new Type[typeArr.length];
        for (int i2 = 0; i2 < typeArr.length; i2++) {
            typeArr2[i2] = a(typeArr[i2]);
        }
        return typeArr2;
    }

    public static class TypeTable {

        /* renamed from: a, reason: collision with root package name */
        public final ImmutableMap f43348a;

        public TypeTable() {
            this.f43348a = ImmutableMap.j();
        }

        public Type a(TypeVariable typeVariable, AnonymousClass1 anonymousClass1) {
            Type type = (Type) this.f43348a.get(new TypeVariableKey(typeVariable));
            if (type != null) {
                return new TypeResolver(anonymousClass1).a(type);
            }
            Type[] bounds = typeVariable.getBounds();
            if (bounds.length != 0) {
                Type[] typeArrB = new TypeResolver(anonymousClass1).b(bounds);
                if (!Types.NativeTypeVariableEquals.f43376a || !Arrays.equals(bounds, typeArrB)) {
                    return Types.d(typeVariable.getGenericDeclaration(), typeVariable.getName(), typeArrB);
                }
            }
            return typeVariable;
        }

        public TypeTable(ImmutableMap immutableMap) {
            this.f43348a = immutableMap;
        }
    }

    public TypeResolver(TypeTable typeTable) {
        this.f43346a = typeTable;
    }
}
