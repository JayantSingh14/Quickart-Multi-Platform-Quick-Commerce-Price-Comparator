package retrofit2;

import androidx.fragment.app.e;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
final class Utils {

    /* renamed from: a, reason: collision with root package name */
    public static final Type[] f58241a = new Type[0];

    /* renamed from: b, reason: collision with root package name */
    public static boolean f58242b = true;

    /* loaded from: classes5.dex */
    public static final class GenericArrayTypeImpl implements GenericArrayType {

        /* renamed from: a, reason: collision with root package name */
        public final Type f58243a;

        public GenericArrayTypeImpl(Type type) {
            this.f58243a = type;
        }

        public final boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && Utils.b(this, (GenericArrayType) obj);
        }

        @Override // java.lang.reflect.GenericArrayType
        public final Type getGenericComponentType() {
            return this.f58243a;
        }

        public final int hashCode() {
            return this.f58243a.hashCode();
        }

        public final String toString() {
            return android.support.v4.media.b.r(new StringBuilder(), Utils.o(this.f58243a), "[]");
        }
    }

    /* loaded from: classes5.dex */
    public static final class ParameterizedTypeImpl implements ParameterizedType {

        /* renamed from: a, reason: collision with root package name */
        public final Type f58244a;

        /* renamed from: b, reason: collision with root package name */
        public final Type f58245b;

        /* renamed from: c, reason: collision with root package name */
        public final Type[] f58246c;

        public ParameterizedTypeImpl(Type type, Type type2, Type... typeArr) {
            if (type2 instanceof Class) {
                if ((type == null) != (((Class) type2).getEnclosingClass() == null)) {
                    throw new IllegalArgumentException();
                }
            }
            for (Type type3 : typeArr) {
                Objects.requireNonNull(type3, "typeArgument == null");
                Utils.a(type3);
            }
            this.f58244a = type;
            this.f58245b = type2;
            this.f58246c = (Type[]) typeArr.clone();
        }

        public final boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && Utils.b(this, (ParameterizedType) obj);
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type[] getActualTypeArguments() {
            return (Type[]) this.f58246c.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type getOwnerType() {
            return this.f58244a;
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type getRawType() {
            return this.f58245b;
        }

        public final int hashCode() {
            int iHashCode = Arrays.hashCode(this.f58246c) ^ this.f58245b.hashCode();
            Type type = this.f58244a;
            return iHashCode ^ (type != null ? type.hashCode() : 0);
        }

        public final String toString() {
            Type[] typeArr = this.f58246c;
            int length = typeArr.length;
            Type type = this.f58245b;
            if (length == 0) {
                return Utils.o(type);
            }
            StringBuilder sb = new StringBuilder((typeArr.length + 1) * 30);
            sb.append(Utils.o(type));
            sb.append("<");
            sb.append(Utils.o(typeArr[0]));
            for (int i2 = 1; i2 < typeArr.length; i2++) {
                sb.append(", ");
                sb.append(Utils.o(typeArr[i2]));
            }
            sb.append(">");
            return sb.toString();
        }
    }

    /* loaded from: classes5.dex */
    public static final class WildcardTypeImpl implements WildcardType {

        /* renamed from: a, reason: collision with root package name */
        public final Type f58247a;

        /* renamed from: b, reason: collision with root package name */
        public final Type f58248b;

        public WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            if (typeArr2.length > 1) {
                throw new IllegalArgumentException();
            }
            if (typeArr.length != 1) {
                throw new IllegalArgumentException();
            }
            if (typeArr2.length != 1) {
                typeArr[0].getClass();
                Utils.a(typeArr[0]);
                this.f58248b = null;
                this.f58247a = typeArr[0];
                return;
            }
            typeArr2[0].getClass();
            Utils.a(typeArr2[0]);
            if (typeArr[0] != Object.class) {
                throw new IllegalArgumentException();
            }
            this.f58248b = typeArr2[0];
            this.f58247a = Object.class;
        }

        public final boolean equals(Object obj) {
            return (obj instanceof WildcardType) && Utils.b(this, (WildcardType) obj);
        }

        @Override // java.lang.reflect.WildcardType
        public final Type[] getLowerBounds() {
            Type type = this.f58248b;
            return type != null ? new Type[]{type} : Utils.f58241a;
        }

        @Override // java.lang.reflect.WildcardType
        public final Type[] getUpperBounds() {
            return new Type[]{this.f58247a};
        }

        public final int hashCode() {
            Type type = this.f58248b;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.f58247a.hashCode() + 31);
        }

        public final String toString() {
            Type type = this.f58248b;
            if (type != null) {
                return "? super " + Utils.o(type);
            }
            Type type2 = this.f58247a;
            if (type2 == Object.class) {
                return "?";
            }
            return "? extends " + Utils.o(type2);
        }
    }

    public static void a(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException();
        }
    }

    public static boolean b(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            Type ownerType = parameterizedType.getOwnerType();
            Type ownerType2 = parameterizedType2.getOwnerType();
            return (ownerType == ownerType2 || (ownerType != null && ownerType.equals(ownerType2))) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return b(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            }
            return false;
        }
        if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
        }
        if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        }
        TypeVariable typeVariable = (TypeVariable) type;
        TypeVariable typeVariable2 = (TypeVariable) type2;
        return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
    }

    public static Type c(Type type, Class cls, Class cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i2 = 0; i2 < length; i2++) {
                Class<?> cls3 = interfaces[i2];
                if (cls3 == cls2) {
                    return cls.getGenericInterfaces()[i2];
                }
                if (cls2.isAssignableFrom(cls3)) {
                    return c(cls.getGenericInterfaces()[i2], interfaces[i2], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<?> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return c(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    public static Type d(int i2, ParameterizedType parameterizedType) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (i2 >= 0 && i2 < actualTypeArguments.length) {
            Type type = actualTypeArguments[i2];
            return type instanceof WildcardType ? ((WildcardType) type).getUpperBounds()[0] : type;
        }
        StringBuilder sbU = android.support.v4.media.b.u(i2, "Index ", " not in range [0,");
        sbU.append(actualTypeArguments.length);
        sbU.append(") for ");
        sbU.append(parameterizedType);
        throw new IllegalArgumentException(sbU.toString());
    }

    public static Class e(Type type) {
        Objects.requireNonNull(type, "type == null");
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType instanceof Class) {
                return (Class) rawType;
            }
            throw new IllegalArgumentException();
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance((Class<?>) e(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return e(((WildcardType) type).getUpperBounds()[0]);
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + type.getClass().getName());
    }

    public static Type f(Type type, Class cls) {
        if (Map.class.isAssignableFrom(cls)) {
            return m(type, cls, c(type, cls, Map.class));
        }
        throw new IllegalArgumentException();
    }

    public static boolean g(Type type) {
        if (type instanceof Class) {
            return false;
        }
        if (type instanceof ParameterizedType) {
            for (Type type2 : ((ParameterizedType) type).getActualTypeArguments()) {
                if (g(type2)) {
                    return true;
                }
            }
            return false;
        }
        if (type instanceof GenericArrayType) {
            return g(((GenericArrayType) type).getGenericComponentType());
        }
        if ((type instanceof TypeVariable) || (type instanceof WildcardType)) {
            return true;
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
    }

    public static boolean h(Annotation[] annotationArr, Class cls) {
        for (Annotation annotation : annotationArr) {
            if (cls.isInstance(annotation)) {
                return true;
            }
        }
        return false;
    }

    public static boolean i(Type type) {
        return f58242b && type == Unit.class;
    }

    public static IllegalArgumentException j(Method method, Exception exc, String str, Object... objArr) {
        StringBuilder sbX = android.support.v4.media.b.x(String.format(str, objArr), "\n    for method ");
        sbX.append(method.getDeclaringClass().getSimpleName());
        sbX.append(CLConstants.DOT_SALT_DELIMETER);
        sbX.append(method.getName());
        return new IllegalArgumentException(sbX.toString(), exc);
    }

    public static IllegalArgumentException k(Method method, int i2, String str, Object... objArr) {
        return j(method, null, e.D(str, " (", Platform.f58182b.a(method, i2), ")"), objArr);
    }

    public static IllegalArgumentException l(Method method, Exception exc, int i2, String str, Object... objArr) {
        return j(method, exc, e.D(str, " (", Platform.f58182b.a(method, i2), ")"), objArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.reflect.Type m(java.lang.reflect.Type r8, java.lang.Class r9, java.lang.reflect.Type r10) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.Utils.m(java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type):java.lang.reflect.Type");
    }

    public static void n(Throwable th) {
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof LinkageError) {
            throw ((LinkageError) th);
        }
    }

    public static String o(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }
}
