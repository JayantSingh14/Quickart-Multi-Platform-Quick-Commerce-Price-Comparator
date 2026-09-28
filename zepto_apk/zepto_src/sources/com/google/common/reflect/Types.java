package com.google.common.reflect;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.UnmodifiableListIterator;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.lang3.ClassUtils;

@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class Types {

    /* renamed from: a, reason: collision with root package name */
    public static final Joiner f43367a = new Joiner(", ").f();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class ClassOwnership {

        /* renamed from: a, reason: collision with root package name */
        public static final ClassOwnership f43369a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ ClassOwnership[] f43370b = {new ClassOwnership() { // from class: com.google.common.reflect.Types.ClassOwnership.1
            @Override // com.google.common.reflect.Types.ClassOwnership
            public final Class a(Class cls) {
                return cls.getEnclosingClass();
            }
        }, new ClassOwnership() { // from class: com.google.common.reflect.Types.ClassOwnership.2
            @Override // com.google.common.reflect.Types.ClassOwnership
            public final Class a(Class cls) {
                if (cls.isLocalClass()) {
                    return null;
                }
                return cls.getEnclosingClass();
            }
        }};

        /* JADX INFO: Fake field, exist only in values array */
        ClassOwnership EF4;

        /* renamed from: com.google.common.reflect.Types$ClassOwnership$1LocalClass, reason: invalid class name */
        class C1LocalClass<T> {
        }

        /* renamed from: com.google.common.reflect.Types$ClassOwnership$3, reason: invalid class name */
        class AnonymousClass3 extends C1LocalClass<String> {
        }

        static {
            ParameterizedType parameterizedType = (ParameterizedType) AnonymousClass3.class.getGenericSuperclass();
            Objects.requireNonNull(parameterizedType);
            for (ClassOwnership classOwnership : values()) {
                if (classOwnership.a(C1LocalClass.class) == parameterizedType.getOwnerType()) {
                    f43369a = classOwnership;
                    return;
                }
            }
            throw new AssertionError();
        }

        public static ClassOwnership valueOf(String str) {
            return (ClassOwnership) Enum.valueOf(ClassOwnership.class, str);
        }

        public static ClassOwnership[] values() {
            return (ClassOwnership[]) f43370b.clone();
        }

        public abstract Class a(Class cls);
    }

    public static final class GenericArrayTypeImpl implements GenericArrayType, Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final Type f43371a;

        public GenericArrayTypeImpl(Type type) {
            this.f43371a = JavaVersion.f43374c.d(type);
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof GenericArrayType)) {
                return false;
            }
            return com.google.common.base.Objects.a(this.f43371a, ((GenericArrayType) obj).getGenericComponentType());
        }

        @Override // java.lang.reflect.GenericArrayType
        public final Type getGenericComponentType() {
            return this.f43371a;
        }

        public final int hashCode() {
            return this.f43371a.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            Joiner joiner = Types.f43367a;
            Type type = this.f43371a;
            return android.support.v4.media.b.r(sb, type instanceof Class ? ((Class) type).getName() : type.toString(), "[]");
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class JavaVersion {

        /* renamed from: a, reason: collision with root package name */
        public static final AnonymousClass2 f43372a;

        /* renamed from: b, reason: collision with root package name */
        public static final AnonymousClass3 f43373b;

        /* renamed from: c, reason: collision with root package name */
        public static final JavaVersion f43374c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ JavaVersion[] f43375d;

        /* renamed from: com.google.common.reflect.Types$JavaVersion$2, reason: invalid class name */
        public enum AnonymousClass2 extends JavaVersion {
            public AnonymousClass2() {
                super("JAVA7", 1);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public final Type a(Type type) {
                if (!(type instanceof Class)) {
                    return new GenericArrayTypeImpl(type);
                }
                Joiner joiner = Types.f43367a;
                return Array.newInstance((Class<?>) type, 0).getClass();
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public final Type d(Type type) {
                type.getClass();
                return type;
            }
        }

        /* renamed from: com.google.common.reflect.Types$JavaVersion$3, reason: invalid class name */
        public enum AnonymousClass3 extends JavaVersion {
            public AnonymousClass3() {
                super("JAVA8", 2);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public final Type a(Type type) {
                return JavaVersion.f43372a.a(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public final String b(Type type) {
                try {
                    return (String) Type.class.getMethod("getTypeName", null).invoke(type, null);
                } catch (IllegalAccessException e2) {
                    throw new RuntimeException(e2);
                } catch (NoSuchMethodException unused) {
                    throw new AssertionError("Type.getTypeName should be available in Java 8");
                } catch (InvocationTargetException e3) {
                    throw new RuntimeException(e3);
                }
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            public final Type d(Type type) {
                type.getClass();
                return type;
            }
        }

        /* renamed from: com.google.common.reflect.Types$JavaVersion$5, reason: invalid class name */
        public class AnonymousClass5 extends TypeCapture<Map.Entry<String, int[][]>> {
        }

        /* renamed from: com.google.common.reflect.Types$JavaVersion$6, reason: invalid class name */
        public class AnonymousClass6 extends TypeCapture<int[]> {
        }

        static {
            JavaVersion javaVersion = new JavaVersion() { // from class: com.google.common.reflect.Types.JavaVersion.1
                @Override // com.google.common.reflect.Types.JavaVersion
                public final Type a(Type type) {
                    return new GenericArrayTypeImpl(type);
                }

                @Override // com.google.common.reflect.Types.JavaVersion
                public final Type d(Type type) {
                    type.getClass();
                    if (!(type instanceof Class)) {
                        return type;
                    }
                    Class cls = (Class) type;
                    return cls.isArray() ? new GenericArrayTypeImpl(cls.getComponentType()) : type;
                }
            };
            AnonymousClass2 anonymousClass2 = new AnonymousClass2();
            f43372a = anonymousClass2;
            AnonymousClass3 anonymousClass3 = new AnonymousClass3();
            f43373b = anonymousClass3;
            JavaVersion javaVersion2 = new JavaVersion() { // from class: com.google.common.reflect.Types.JavaVersion.4
                @Override // com.google.common.reflect.Types.JavaVersion
                public final Type a(Type type) {
                    return JavaVersion.f43372a.a(type);
                }

                @Override // com.google.common.reflect.Types.JavaVersion
                public final String b(Type type) {
                    return JavaVersion.f43373b.b(type);
                }

                @Override // com.google.common.reflect.Types.JavaVersion
                public final Type d(Type type) {
                    type.getClass();
                    return type;
                }
            };
            f43375d = new JavaVersion[]{javaVersion, anonymousClass2, anonymousClass3, javaVersion2};
            if (AnnotatedElement.class.isAssignableFrom(TypeVariable.class)) {
                Type genericSuperclass = AnonymousClass5.class.getGenericSuperclass();
                Preconditions.h(genericSuperclass instanceof ParameterizedType, "%s isn't parameterized", genericSuperclass);
                if (((ParameterizedType) genericSuperclass).getActualTypeArguments()[0].toString().contains("java.util.Map.java.util.Map")) {
                    f43374c = anonymousClass3;
                    return;
                } else {
                    f43374c = javaVersion2;
                    return;
                }
            }
            Type genericSuperclass2 = AnonymousClass6.class.getGenericSuperclass();
            Preconditions.h(genericSuperclass2 instanceof ParameterizedType, "%s isn't parameterized", genericSuperclass2);
            if (((ParameterizedType) genericSuperclass2).getActualTypeArguments()[0] instanceof Class) {
                f43374c = anonymousClass2;
            } else {
                f43374c = javaVersion;
            }
        }

        public static JavaVersion valueOf(String str) {
            return (JavaVersion) Enum.valueOf(JavaVersion.class, str);
        }

        public static JavaVersion[] values() {
            return (JavaVersion[]) f43375d.clone();
        }

        public abstract Type a(Type type);

        public String b(Type type) {
            Joiner joiner = Types.f43367a;
            return type instanceof Class ? ((Class) type).getName() : type.toString();
        }

        public final ImmutableList c(Type[] typeArr) {
            UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
            ImmutableList.Builder builder = new ImmutableList.Builder();
            for (Type type : typeArr) {
                builder.h(d(type));
            }
            return builder.j();
        }

        public abstract Type d(Type type);
    }

    public static final class NativeTypeVariableEquals<X> {

        /* renamed from: a, reason: collision with root package name */
        public static final boolean f43376a = !NativeTypeVariableEquals.class.getTypeParameters()[0].equals(Types.d(NativeTypeVariableEquals.class, "X", new Type[0]));
    }

    public static final class ParameterizedTypeImpl implements ParameterizedType, Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final Type f43377a;

        /* renamed from: b, reason: collision with root package name */
        public final ImmutableList f43378b;

        /* renamed from: c, reason: collision with root package name */
        public final Class f43379c;

        public ParameterizedTypeImpl(Type type, Class cls, Type[] typeArr) {
            cls.getClass();
            Preconditions.f(typeArr.length == cls.getTypeParameters().length);
            Types.b(typeArr, "type parameter");
            this.f43377a = type;
            this.f43379c = cls;
            this.f43378b = JavaVersion.f43374c.c(typeArr);
        }

        public final boolean equals(Object obj) {
            if (obj instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) obj;
                if (this.f43379c.equals(parameterizedType.getRawType())) {
                    if (com.google.common.base.Objects.a(this.f43377a, parameterizedType.getOwnerType())) {
                        ImmutableList immutableList = this.f43378b;
                        Joiner joiner = Types.f43367a;
                        if (Arrays.equals((Type[]) immutableList.toArray(new Type[0]), parameterizedType.getActualTypeArguments())) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type[] getActualTypeArguments() {
            ImmutableList immutableList = this.f43378b;
            Joiner joiner = Types.f43367a;
            return (Type[]) immutableList.toArray(new Type[0]);
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type getOwnerType() {
            return this.f43377a;
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type getRawType() {
            return this.f43379c;
        }

        public final int hashCode() {
            Type type = this.f43377a;
            return ((type == null ? 0 : type.hashCode()) ^ this.f43378b.hashCode()) ^ this.f43379c.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            Type type = this.f43377a;
            if (type != null) {
                JavaVersion javaVersion = JavaVersion.f43374c;
                javaVersion.getClass();
                if (!(javaVersion instanceof JavaVersion.AnonymousClass4)) {
                    sb.append(javaVersion.b(type));
                    sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                }
            }
            sb.append(this.f43379c.getName());
            sb.append('<');
            Joiner joiner = Types.f43367a;
            ImmutableList immutableList = this.f43378b;
            final JavaVersion javaVersion2 = JavaVersion.f43374c;
            Objects.requireNonNull(javaVersion2);
            sb.append(joiner.c(Iterables.i(immutableList, new Function() { // from class: com.google.common.reflect.b
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    return javaVersion2.b((Type) obj);
                }
            })));
            sb.append('>');
            return sb.toString();
        }
    }

    public static final class TypeVariableImpl<D extends GenericDeclaration> {

        /* renamed from: a, reason: collision with root package name */
        public final GenericDeclaration f43380a;

        /* renamed from: b, reason: collision with root package name */
        public final String f43381b;

        /* renamed from: c, reason: collision with root package name */
        public final ImmutableList f43382c;

        public TypeVariableImpl(GenericDeclaration genericDeclaration, String str, Type[] typeArr) {
            Types.b(typeArr, "bound for type variable");
            genericDeclaration.getClass();
            this.f43380a = genericDeclaration;
            str.getClass();
            this.f43381b = str;
            this.f43382c = ImmutableList.p(typeArr);
        }

        public final boolean equals(Object obj) {
            boolean z = NativeTypeVariableEquals.f43376a;
            GenericDeclaration genericDeclaration = this.f43380a;
            String str = this.f43381b;
            if (!z) {
                if (obj instanceof TypeVariable) {
                    TypeVariable typeVariable = (TypeVariable) obj;
                    if (str.equals(typeVariable.getName()) && genericDeclaration.equals(typeVariable.getGenericDeclaration())) {
                        return true;
                    }
                }
                return false;
            }
            if (obj != null && Proxy.isProxyClass(obj.getClass()) && (Proxy.getInvocationHandler(obj) instanceof TypeVariableInvocationHandler)) {
                TypeVariableImpl typeVariableImpl = ((TypeVariableInvocationHandler) Proxy.getInvocationHandler(obj)).f43384a;
                if (str.equals(typeVariableImpl.f43381b) && genericDeclaration.equals(typeVariableImpl.f43380a) && this.f43382c.equals(typeVariableImpl.f43382c)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return this.f43380a.hashCode() ^ this.f43381b.hashCode();
        }

        public final String toString() {
            return this.f43381b;
        }
    }

    public static final class TypeVariableInvocationHandler implements InvocationHandler {

        /* renamed from: b, reason: collision with root package name */
        public static final ImmutableMap f43383b;

        /* renamed from: a, reason: collision with root package name */
        public final TypeVariableImpl f43384a;

        static {
            ImmutableMap.Builder builder = new ImmutableMap.Builder();
            for (Method method : TypeVariableImpl.class.getMethods()) {
                if (method.getDeclaringClass().equals(TypeVariableImpl.class)) {
                    try {
                        method.setAccessible(true);
                    } catch (AccessControlException unused) {
                    }
                    builder.c(method.getName(), method);
                }
            }
            f43383b = builder.a(false);
        }

        public TypeVariableInvocationHandler(TypeVariableImpl typeVariableImpl) {
            this.f43384a = typeVariableImpl;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Method method2 = (Method) f43383b.get(name);
            if (method2 == null) {
                throw new UnsupportedOperationException(name);
            }
            try {
                return method2.invoke(this.f43384a, objArr);
            } catch (InvocationTargetException e2) {
                throw e2.getCause();
            }
        }
    }

    public static final class WildcardTypeImpl implements WildcardType, Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final ImmutableList f43385a;

        /* renamed from: b, reason: collision with root package name */
        public final ImmutableList f43386b;

        public WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            Types.b(typeArr, "lower bound for wildcard");
            Types.b(typeArr2, "upper bound for wildcard");
            JavaVersion javaVersion = JavaVersion.f43374c;
            this.f43385a = javaVersion.c(typeArr);
            this.f43386b = javaVersion.c(typeArr2);
        }

        public final boolean equals(Object obj) {
            if (obj instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) obj;
                if (this.f43385a.equals(Arrays.asList(wildcardType.getLowerBounds())) && this.f43386b.equals(Arrays.asList(wildcardType.getUpperBounds()))) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.lang.reflect.WildcardType
        public final Type[] getLowerBounds() {
            ImmutableList immutableList = this.f43385a;
            Joiner joiner = Types.f43367a;
            return (Type[]) immutableList.toArray(new Type[0]);
        }

        @Override // java.lang.reflect.WildcardType
        public final Type[] getUpperBounds() {
            ImmutableList immutableList = this.f43386b;
            Joiner joiner = Types.f43367a;
            return (Type[]) immutableList.toArray(new Type[0]);
        }

        public final int hashCode() {
            return this.f43385a.hashCode() ^ this.f43386b.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("?");
            UnmodifiableListIterator unmodifiableListIteratorListIterator = this.f43385a.listIterator(0);
            while (unmodifiableListIteratorListIterator.hasNext()) {
                Type type = (Type) unmodifiableListIteratorListIterator.next();
                sb.append(" super ");
                sb.append(JavaVersion.f43374c.b(type));
            }
            ImmutableList immutableList = this.f43386b;
            Joiner joiner = Types.f43367a;
            for (Type type2 : Iterables.b(immutableList, Predicates.h(Predicates.e(Object.class)))) {
                sb.append(" extends ");
                sb.append(JavaVersion.f43374c.b(type2));
            }
            return sb.toString();
        }
    }

    public static Type a(Type[] typeArr) {
        for (Type type : typeArr) {
            type.getClass();
            final AtomicReference atomicReference = new AtomicReference();
            new TypeVisitor() { // from class: com.google.common.reflect.Types.1
                @Override // com.google.common.reflect.TypeVisitor
                public final void b(Class cls) {
                    atomicReference.set(cls.getComponentType());
                }

                @Override // com.google.common.reflect.TypeVisitor
                public final void c(GenericArrayType genericArrayType) {
                    atomicReference.set(genericArrayType.getGenericComponentType());
                }

                @Override // com.google.common.reflect.TypeVisitor
                public final void e(TypeVariable typeVariable) {
                    atomicReference.set(Types.a(typeVariable.getBounds()));
                }

                @Override // com.google.common.reflect.TypeVisitor
                public final void f(WildcardType wildcardType) {
                    atomicReference.set(Types.a(wildcardType.getUpperBounds()));
                }
            }.a(type);
            Type type2 = (Type) atomicReference.get();
            if (type2 != null) {
                if (type2 instanceof Class) {
                    Class cls = (Class) type2;
                    if (cls.isPrimitive()) {
                        return cls;
                    }
                }
                return new WildcardTypeImpl(new Type[0], new Type[]{type2});
            }
        }
        return null;
    }

    public static void b(Type[] typeArr, String str) {
        for (Type type : typeArr) {
            if (type instanceof Class) {
                Preconditions.d((Class) type, str, "Primitive type '%s' used as %s", !r2.isPrimitive());
            }
        }
    }

    public static Type c(Type type) {
        if (!(type instanceof WildcardType)) {
            return JavaVersion.f43374c.a(type);
        }
        WildcardType wildcardType = (WildcardType) type;
        Type[] lowerBounds = wildcardType.getLowerBounds();
        Preconditions.g(lowerBounds.length <= 1, "Wildcard cannot have more than one lower bounds.");
        if (lowerBounds.length == 1) {
            return new WildcardTypeImpl(new Type[]{c(lowerBounds[0])}, new Type[]{Object.class});
        }
        Type[] upperBounds = wildcardType.getUpperBounds();
        Preconditions.g(upperBounds.length == 1, "Wildcard should have only one upper bound.");
        return new WildcardTypeImpl(new Type[0], new Type[]{c(upperBounds[0])});
    }

    public static TypeVariable d(GenericDeclaration genericDeclaration, String str, Type... typeArr) {
        if (typeArr.length == 0) {
            typeArr = new Type[]{Object.class};
        }
        TypeVariableInvocationHandler typeVariableInvocationHandler = new TypeVariableInvocationHandler(new TypeVariableImpl(genericDeclaration, str, typeArr));
        Preconditions.h(TypeVariable.class.isInterface(), "%s is not an interface", TypeVariable.class);
        return (TypeVariable) TypeVariable.class.cast(Proxy.newProxyInstance(TypeVariable.class.getClassLoader(), new Class[]{TypeVariable.class}, typeVariableInvocationHandler));
    }

    public static ParameterizedType e(Type type, Class cls, Type... typeArr) {
        if (type == null) {
            return new ParameterizedTypeImpl(ClassOwnership.f43369a.a(cls), cls, typeArr);
        }
        Preconditions.h(cls.getEnclosingClass() != null, "Owner type for unenclosed %s", cls);
        return new ParameterizedTypeImpl(type, cls, typeArr);
    }
}
