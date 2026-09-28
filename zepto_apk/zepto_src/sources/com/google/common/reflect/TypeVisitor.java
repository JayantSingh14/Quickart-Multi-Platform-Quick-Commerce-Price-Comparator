package com.google.common.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.HashSet;

@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
abstract class TypeVisitor {

    /* renamed from: a, reason: collision with root package name */
    public final HashSet f43366a = new HashSet();

    public final void a(Type... typeArr) {
        for (Type type : typeArr) {
            if (type != null) {
                HashSet hashSet = this.f43366a;
                if (hashSet.add(type)) {
                    try {
                        if (type instanceof TypeVariable) {
                            e((TypeVariable) type);
                        } else if (type instanceof WildcardType) {
                            f((WildcardType) type);
                        } else if (type instanceof ParameterizedType) {
                            d((ParameterizedType) type);
                        } else if (type instanceof Class) {
                            b((Class) type);
                        } else {
                            if (!(type instanceof GenericArrayType)) {
                                throw new AssertionError("Unknown type: " + type);
                            }
                            c((GenericArrayType) type);
                        }
                    } catch (Throwable th) {
                        hashSet.remove(type);
                        throw th;
                    }
                } else {
                    continue;
                }
            }
        }
    }

    public void b(Class cls) {
    }

    public void c(GenericArrayType genericArrayType) {
    }

    public void d(ParameterizedType parameterizedType) {
    }

    public void e(TypeVariable typeVariable) {
    }

    public void f(WildcardType wildcardType) {
    }
}
