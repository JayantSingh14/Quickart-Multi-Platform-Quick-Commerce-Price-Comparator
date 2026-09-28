package com.google.common.reflect;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;
import com.google.common.collect.UnmodifiableListIterator;
import com.google.common.reflect.Invokable;
import com.google.common.reflect.TypeResolver;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class TypeToken<T> extends TypeCapture<T> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Type f43352a;

    /* renamed from: b, reason: collision with root package name */
    public transient TypeResolver f43353b;

    /* renamed from: com.google.common.reflect.TypeToken$1, reason: invalid class name */
    class AnonymousClass1 extends Invokable.MethodInvokable<Object> {
        @Override // com.google.common.reflect.Invokable
        public final TypeToken a() {
            return null;
        }

        @Override // com.google.common.reflect.Invokable
        public final String toString() {
            throw null;
        }
    }

    /* renamed from: com.google.common.reflect.TypeToken$2, reason: invalid class name */
    class AnonymousClass2 extends Invokable.ConstructorInvokable<Object> {
        @Override // com.google.common.reflect.Invokable
        public final TypeToken a() {
            return null;
        }

        @Override // com.google.common.reflect.Invokable
        public final String toString() {
            new Joiner(", ");
            throw null;
        }
    }

    /* renamed from: com.google.common.reflect.TypeToken$3, reason: invalid class name */
    class AnonymousClass3 extends TypeVisitor {
        @Override // com.google.common.reflect.TypeVisitor
        public final void c(GenericArrayType genericArrayType) {
            a(genericArrayType.getGenericComponentType());
        }

        @Override // com.google.common.reflect.TypeVisitor
        public final void d(ParameterizedType parameterizedType) {
            a(parameterizedType.getActualTypeArguments());
            a(parameterizedType.getOwnerType());
        }

        @Override // com.google.common.reflect.TypeVisitor
        public final void e(TypeVariable typeVariable) {
            throw null;
        }

        @Override // com.google.common.reflect.TypeVisitor
        public final void f(WildcardType wildcardType) {
            a(wildcardType.getLowerBounds());
            a(wildcardType.getUpperBounds());
        }
    }

    public static class Bounds {
    }

    public final class ClassSet extends TypeToken<T>.TypeSet {

        /* renamed from: c, reason: collision with root package name */
        public transient ImmutableSet f43355c;

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection
        /* renamed from: B */
        public final Set t() {
            ImmutableSet immutableSet = this.f43355c;
            if (immutableSet != null) {
                return immutableSet;
            }
            FluentIterable fluentIterableD = FluentIterable.d(new TypeCollector.AnonymousClass3().b(ImmutableList.t(null)));
            ImmutableSet immutableSetG = FluentIterable.d(Iterables.b(fluentIterableD.f(), TypeFilter.f43361a)).g();
            this.f43355c = immutableSetG;
            return immutableSetG;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public final Set C() {
            throw null;
        }
    }

    public final class InterfaceSet extends TypeToken<T>.TypeSet {

        /* renamed from: c, reason: collision with root package name */
        public transient ImmutableSet f43356c;

        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection
        /* renamed from: B */
        public final Set t() {
            ImmutableSet immutableSet = this.f43356c;
            if (immutableSet != null) {
                return immutableSet;
            }
            FluentIterable fluentIterableD = FluentIterable.d(null);
            ImmutableSet immutableSetG = FluentIterable.d(Iterables.b(fluentIterableD.f(), TypeFilter.f43362b)).g();
            this.f43356c = immutableSetG;
            return immutableSetG;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public final Set C() {
            throw null;
        }
    }

    public static final class SimpleTypeToken<T> extends TypeToken<T> {
    }

    public static abstract class TypeCollector<K> {

        /* renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f43357a = new AnonymousClass1();

        /* renamed from: b, reason: collision with root package name */
        public static final AnonymousClass2 f43358b = new AnonymousClass2();

        /* renamed from: com.google.common.reflect.TypeToken$TypeCollector$1, reason: invalid class name */
        public class AnonymousClass1 extends TypeCollector<TypeToken<?>> {
            @Override // com.google.common.reflect.TypeToken.TypeCollector
            public final Iterable c(Object obj) {
                TypeToken typeToken = (TypeToken) obj;
                Type type = typeToken.f43352a;
                if (type instanceof TypeVariable) {
                    return TypeToken.a(((TypeVariable) type).getBounds());
                }
                if (type instanceof WildcardType) {
                    return TypeToken.a(((WildcardType) type).getUpperBounds());
                }
                UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
                ImmutableList.Builder builder = new ImmutableList.Builder();
                for (Type type2 : typeToken.b().getGenericInterfaces()) {
                    builder.h(typeToken.e(type2));
                }
                return builder.j();
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            public final Class d(Object obj) {
                return ((TypeToken) obj).b();
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            public final Object e(Object obj) {
                TypeToken typeToken = (TypeToken) obj;
                Type type = typeToken.f43352a;
                if (type instanceof TypeVariable) {
                    SimpleTypeToken simpleTypeToken = new SimpleTypeToken(((TypeVariable) type).getBounds()[0]);
                    if (simpleTypeToken.b().isInterface()) {
                        return null;
                    }
                    return simpleTypeToken;
                }
                if (type instanceof WildcardType) {
                    SimpleTypeToken simpleTypeToken2 = new SimpleTypeToken(((WildcardType) type).getUpperBounds()[0]);
                    if (simpleTypeToken2.b().isInterface()) {
                        return null;
                    }
                    return simpleTypeToken2;
                }
                Type genericSuperclass = typeToken.b().getGenericSuperclass();
                if (genericSuperclass == null) {
                    return null;
                }
                return typeToken.e(genericSuperclass);
            }
        }

        /* renamed from: com.google.common.reflect.TypeToken$TypeCollector$2, reason: invalid class name */
        public class AnonymousClass2 extends TypeCollector<Class<?>> {
            @Override // com.google.common.reflect.TypeToken.TypeCollector
            public final Iterable c(Object obj) {
                return Arrays.asList(((Class) obj).getInterfaces());
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            public final Class d(Object obj) {
                return (Class) obj;
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            public final Object e(Object obj) {
                return ((Class) obj).getSuperclass();
            }
        }

        /* renamed from: com.google.common.reflect.TypeToken$TypeCollector$3, reason: invalid class name */
        class AnonymousClass3 extends ForwardingTypeCollector<Object> {
            @Override // com.google.common.reflect.TypeToken.TypeCollector
            public final ImmutableList b(Iterable iterable) {
                UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
                ImmutableList.Builder builder = new ImmutableList.Builder();
                UnmodifiableListIterator unmodifiableListIteratorListIterator = ((ImmutableList) iterable).listIterator(0);
                while (unmodifiableListIteratorListIterator.hasNext()) {
                    Object next = unmodifiableListIteratorListIterator.next();
                    if (!((TypeToken) next).b().isInterface()) {
                        builder.h(next);
                    }
                }
                return super.b(builder.j());
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector.ForwardingTypeCollector, com.google.common.reflect.TypeToken.TypeCollector
            public final Iterable c(Object obj) {
                return ImmutableSet.s();
            }
        }

        public static class ForwardingTypeCollector<K> extends TypeCollector<K> {
            @Override // com.google.common.reflect.TypeToken.TypeCollector
            public Iterable c(Object obj) {
                return TypeCollector.f43357a.c(obj);
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            public final Class d(Object obj) {
                return ((TypeToken) obj).b();
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            public final Object e(Object obj) {
                return TypeCollector.f43357a.e(obj);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int a(Object obj, HashMap map) {
            Integer num = (Integer) map.get(obj);
            if (num != null) {
                return num.intValue();
            }
            boolean zIsInterface = d(obj).isInterface();
            Iterator<T> it = c(obj).iterator();
            int iMax = zIsInterface;
            while (it.hasNext()) {
                iMax = Math.max(iMax, a(it.next(), map));
            }
            Object objE = e(obj);
            int iMax2 = iMax;
            if (objE != null) {
                iMax2 = Math.max(iMax, a(objE, map));
            }
            int i2 = iMax2 + 1;
            map.put(obj, Integer.valueOf(i2));
            return i2;
        }

        public ImmutableList b(Iterable iterable) {
            final HashMap map = new HashMap();
            Iterator<T> it = iterable.iterator();
            while (it.hasNext()) {
                a(it.next(), map);
            }
            final Ordering orderingG = Ordering.c().g();
            return ImmutableList.y(new Ordering<Object>() { // from class: com.google.common.reflect.TypeToken.TypeCollector.4
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    HashMap map2 = map;
                    Object obj3 = map2.get(obj);
                    Objects.requireNonNull(obj3);
                    Object obj4 = map2.get(obj2);
                    Objects.requireNonNull(obj4);
                    return orderingG.compare(obj3, obj4);
                }
            }, map.keySet());
        }

        public abstract Iterable c(Object obj);

        public abstract Class d(Object obj);

        public abstract Object e(Object obj);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class TypeFilter implements Predicate<TypeToken<?>> {

        /* renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f43361a;

        /* renamed from: b, reason: collision with root package name */
        public static final AnonymousClass2 f43362b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ TypeFilter[] f43363c;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.common.reflect.TypeToken$TypeFilter$1] */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.google.common.reflect.TypeToken$TypeFilter$2] */
        static {
            ?? r0 = new TypeFilter() { // from class: com.google.common.reflect.TypeToken.TypeFilter.1
                @Override // com.google.common.base.Predicate
                public final boolean apply(Object obj) {
                    Type type = ((TypeToken) obj).f43352a;
                    return ((type instanceof TypeVariable) || (type instanceof WildcardType)) ? false : true;
                }
            };
            f43361a = r0;
            ?? r1 = new TypeFilter() { // from class: com.google.common.reflect.TypeToken.TypeFilter.2
                @Override // com.google.common.base.Predicate
                public final boolean apply(Object obj) {
                    return ((TypeToken) obj).b().isInterface();
                }
            };
            f43362b = r1;
            f43363c = new TypeFilter[]{r0, r1};
        }

        public static TypeFilter valueOf(String str) {
            return (TypeFilter) Enum.valueOf(TypeFilter.class, str);
        }

        public static TypeFilter[] values() {
            return (TypeFilter[]) f43363c.clone();
        }
    }

    public class TypeSet extends ForwardingSet<TypeToken<? super T>> implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public transient ImmutableSet f43364a;

        public TypeSet() {
        }

        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection
        /* renamed from: B */
        public Set t() {
            ImmutableSet immutableSet = this.f43364a;
            if (immutableSet != null) {
                return immutableSet;
            }
            FluentIterable fluentIterableD = FluentIterable.d(TypeCollector.f43357a.b(ImmutableList.t(TypeToken.this)));
            ImmutableSet immutableSetG = FluentIterable.d(Iterables.b(fluentIterableD.f(), TypeFilter.f43361a)).g();
            this.f43364a = immutableSetG;
            return immutableSetG;
        }

        public Set C() {
            return ImmutableSet.o(TypeCollector.f43358b.b(TypeToken.this.c()));
        }
    }

    public TypeToken(Type type) {
        type.getClass();
        this.f43352a = type;
    }

    public static ImmutableList a(Type[] typeArr) {
        UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (Type type : typeArr) {
            SimpleTypeToken simpleTypeToken = new SimpleTypeToken(type);
            if (simpleTypeToken.b().isInterface()) {
                builder.h(simpleTypeToken);
            }
        }
        return builder.j();
    }

    public static TypeToken d(Class cls) {
        return new SimpleTypeToken(cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Class b() {
        return (Class) c().iterator().next();
    }

    public final ImmutableSet c() {
        int i2 = ImmutableSet.f42719c;
        final ImmutableSet.Builder builder = new ImmutableSet.Builder();
        new TypeVisitor() { // from class: com.google.common.reflect.TypeToken.4
            @Override // com.google.common.reflect.TypeVisitor
            public final void b(Class cls) {
                builder.c(cls);
            }

            @Override // com.google.common.reflect.TypeVisitor
            public final void c(GenericArrayType genericArrayType) {
                Class clsB = new SimpleTypeToken(genericArrayType.getGenericComponentType()).b();
                Joiner joiner = Types.f43367a;
                builder.c(Array.newInstance((Class<?>) clsB, 0).getClass());
            }

            @Override // com.google.common.reflect.TypeVisitor
            public final void d(ParameterizedType parameterizedType) {
                builder.c((Class) parameterizedType.getRawType());
            }

            @Override // com.google.common.reflect.TypeVisitor
            public final void e(TypeVariable typeVariable) {
                a(typeVariable.getBounds());
            }

            @Override // com.google.common.reflect.TypeVisitor
            public final void f(WildcardType wildcardType) {
                a(wildcardType.getUpperBounds());
            }
        }.a(this.f43352a);
        return builder.k();
    }

    public final TypeToken e(Type type) {
        TypeResolver typeResolver = this.f43353b;
        if (typeResolver == null) {
            TypeResolver typeResolver2 = new TypeResolver();
            Type type2 = this.f43352a;
            type2.getClass();
            TypeResolver.TypeMappingIntrospector typeMappingIntrospector = new TypeResolver.TypeMappingIntrospector();
            typeMappingIntrospector.a(type2);
            ImmutableMap immutableMapA = ImmutableMap.a(typeMappingIntrospector.f43347b);
            TypeResolver.TypeTable typeTable = typeResolver2.f43346a;
            typeTable.getClass();
            ImmutableMap.Builder builder = new ImmutableMap.Builder();
            builder.e(typeTable.f43348a);
            Iterator it = immutableMapA.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                TypeResolver.TypeVariableKey typeVariableKey = (TypeResolver.TypeVariableKey) entry.getKey();
                Type type3 = (Type) entry.getValue();
                typeVariableKey.getClass();
                Preconditions.h(!(type3 instanceof TypeVariable ? typeVariableKey.a((TypeVariable) type3) : false), "Type variable %s bound to itself", typeVariableKey);
                builder.c(typeVariableKey, type3);
            }
            TypeResolver typeResolver3 = new TypeResolver(new TypeResolver.TypeTable(builder.a(true)));
            this.f43353b = typeResolver3;
            typeResolver = typeResolver3;
        }
        SimpleTypeToken simpleTypeToken = new SimpleTypeToken(typeResolver.a(type));
        simpleTypeToken.f43353b = this.f43353b;
        return simpleTypeToken;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof TypeToken) {
            return this.f43352a.equals(((TypeToken) obj).f43352a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f43352a.hashCode();
    }

    public final String toString() {
        Joiner joiner = Types.f43367a;
        Type type = this.f43352a;
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }
}
