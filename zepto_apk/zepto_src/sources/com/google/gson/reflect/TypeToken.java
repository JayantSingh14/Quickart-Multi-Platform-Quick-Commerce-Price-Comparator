package com.google.gson.reflect;

import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.TroubleshootingGuide;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class TypeToken<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Class f45459a;

    /* renamed from: b, reason: collision with root package name */
    public final Type f45460b;

    /* renamed from: c, reason: collision with root package name */
    public final int f45461c;

    public TypeToken() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
            if (parameterizedType.getRawType() == TypeToken.class) {
                Type typeA = C$Gson$Types.a(parameterizedType.getActualTypeArguments()[0]);
                if (!Objects.equals(System.getProperty("gson.allowCapturingTypeVariables"), "true")) {
                    b(typeA);
                }
                this.f45460b = typeA;
                this.f45459a = C$Gson$Types.e(typeA);
                this.f45461c = typeA.hashCode();
                return;
            }
        } else if (genericSuperclass == TypeToken.class) {
            throw new IllegalStateException("TypeToken must be created with a type argument: new TypeToken<...>() {}; When using code shrinkers (ProGuard, R8, ...) make sure that generic signatures are preserved.\nSee " + TroubleshootingGuide.a("type-token-raw"));
        }
        throw new IllegalStateException("Must only create direct subclasses of TypeToken");
    }

    public static TypeToken a(Type... typeArr) {
        TypeVariable[] typeParameters = List.class.getTypeParameters();
        int length = typeParameters.length;
        int length2 = typeArr.length;
        if (length2 != length) {
            throw new IllegalArgumentException(List.class.getName() + " requires " + length + " type arguments, but got " + length2);
        }
        if (typeArr.length == 0) {
            return new TypeToken(List.class);
        }
        if (!Modifier.isStatic(List.class.getModifiers()) && List.class.getDeclaringClass() != null) {
            throw new IllegalArgumentException("Raw type " + List.class.getName() + " is not supported because it requires specifying an owner type");
        }
        for (int i2 = 0; i2 < length; i2++) {
            Type type = typeArr[i2];
            Objects.requireNonNull(type, "Type argument must not be null");
            Class<?> clsE = C$Gson$Types.e(type);
            TypeVariable typeVariable = typeParameters[i2];
            for (Type type2 : typeVariable.getBounds()) {
                if (!C$Gson$Types.e(type2).isAssignableFrom(clsE)) {
                    throw new IllegalArgumentException("Type argument " + type + " does not satisfy bounds for type variable " + typeVariable + " declared by " + List.class);
                }
            }
        }
        return new TypeToken(C$Gson$Types.f(typeArr));
    }

    public static void b(Type type) {
        if (type instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) type;
            throw new IllegalArgumentException("TypeToken type argument must not contain a type variable; captured type variable " + typeVariable.getName() + " declared by " + typeVariable.getGenericDeclaration() + "\nSee " + TroubleshootingGuide.a("typetoken-type-variable"));
        }
        if (type instanceof GenericArrayType) {
            b(((GenericArrayType) type).getGenericComponentType());
            return;
        }
        int i2 = 0;
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type ownerType = parameterizedType.getOwnerType();
            if (ownerType != null) {
                b(ownerType);
            }
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            int length = actualTypeArguments.length;
            while (i2 < length) {
                b(actualTypeArguments[i2]);
                i2++;
            }
            return;
        }
        if (!(type instanceof WildcardType)) {
            if (type == null) {
                throw new IllegalArgumentException("TypeToken captured `null` as type argument; probably a compiler / runtime bug");
            }
            return;
        }
        WildcardType wildcardType = (WildcardType) type;
        for (Type type2 : wildcardType.getLowerBounds()) {
            b(type2);
        }
        Type[] upperBounds = wildcardType.getUpperBounds();
        int length2 = upperBounds.length;
        while (i2 < length2) {
            b(upperBounds[i2]);
            i2++;
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof TypeToken) {
            return C$Gson$Types.c(this.f45460b, ((TypeToken) obj).f45460b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f45461c;
    }

    public final String toString() {
        return C$Gson$Types.h(this.f45460b);
    }

    public TypeToken(Type type) {
        Objects.requireNonNull(type);
        Type typeA = C$Gson$Types.a(type);
        this.f45460b = typeA;
        this.f45459a = C$Gson$Types.e(typeA);
        this.f45461c = typeA.hashCode();
    }
}
