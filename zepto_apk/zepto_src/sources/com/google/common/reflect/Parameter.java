package com.google.common.reflect;

import com.google.common.base.Optional;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class Parameter implements AnnotatedElement {
    public final boolean equals(Object obj) {
        if (!(obj instanceof Parameter)) {
            return false;
        }
        ((Parameter) obj).getClass();
        throw null;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation getAnnotation(Class cls) {
        cls.getClass();
        throw null;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation[] getAnnotations() {
        throw null;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation[] getAnnotationsByType(Class cls) {
        return getDeclaredAnnotationsByType(cls);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation getDeclaredAnnotation(Class cls) {
        cls.getClass();
        Iterator it = FluentIterable.d(null).b(cls).f().iterator();
        return (Annotation) (it.hasNext() ? Optional.d(it.next()) : Optional.a()).f();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation[] getDeclaredAnnotations() {
        throw null;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation[] getDeclaredAnnotationsByType(Class cls) {
        Iterable iterableF = FluentIterable.d(null).b(cls).f();
        return (Annotation[]) (iterableF instanceof Collection ? (Collection) iterableF : Lists.a(iterableF.iterator())).toArray((Object[]) Array.newInstance((Class<?>) cls, 0));
    }

    public final int hashCode() {
        return 0;
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final boolean isAnnotationPresent(Class cls) {
        cls.getClass();
        throw null;
    }

    public final String toString() {
        return "null arg0";
    }
}
