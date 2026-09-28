package com.google.common.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;

@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class Invokable<T, R> implements AnnotatedElement, Member {

    public static class ConstructorInvokable<T> extends Invokable<T, T> {
    }

    public static class MethodInvokable<T> extends Invokable<T, Object> {
    }

    static {
        try {
            Class.forName("java.lang.reflect.AnnotatedType");
        } catch (ClassNotFoundException unused) {
        }
    }

    public TypeToken a() {
        throw null;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof Invokable) && a().equals(((Invokable) obj).a())) {
            throw null;
        }
        return false;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation getAnnotation(Class cls) {
        throw null;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation[] getAnnotations() {
        throw null;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation[] getDeclaredAnnotations() {
        throw null;
    }

    @Override // java.lang.reflect.Member
    public final Class getDeclaringClass() {
        throw null;
    }

    @Override // java.lang.reflect.Member
    public final int getModifiers() {
        throw null;
    }

    @Override // java.lang.reflect.Member
    public final String getName() {
        throw null;
    }

    public final int hashCode() {
        throw null;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final boolean isAnnotationPresent(Class cls) {
        throw null;
    }

    @Override // java.lang.reflect.Member
    public final boolean isSynthetic() {
        throw null;
    }

    public String toString() {
        throw null;
    }
}
