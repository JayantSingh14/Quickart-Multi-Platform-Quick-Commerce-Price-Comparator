package org.shadow.apache.commons.lang3.reflect;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.apache.commons.lang3.ClassUtils;
import org.shadow.apache.commons.lang3.ObjectUtils;
import org.shadow.apache.commons.lang3.Validate;
import org.shadow.apache.commons.lang3.builder.Builder;

/* loaded from: classes5.dex */
public class TypeUtils {

    /* renamed from: org.shadow.apache.commons.lang3.reflect.TypeUtils$1, reason: invalid class name */
    final class AnonymousClass1 implements Typed<Object> {
    }

    public static final class GenericArrayTypeImpl implements GenericArrayType {
        public final boolean equals(Object obj) {
            GenericArrayType genericArrayType;
            if (obj != this) {
                return (obj instanceof GenericArrayType) && (genericArrayType = (GenericArrayType) obj) != null && TypeUtils.d(null, genericArrayType.getGenericComponentType());
            }
            return true;
        }

        @Override // java.lang.reflect.GenericArrayType
        public final Type getGenericComponentType() {
            return null;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return TypeUtils.r(this);
        }
    }

    public static final class ParameterizedTypeImpl implements ParameterizedType {
        public final boolean equals(Object obj) {
            if (obj != this) {
                return (obj instanceof ParameterizedType) && TypeUtils.c(this, (ParameterizedType) obj);
            }
            return true;
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type[] getActualTypeArguments() {
            throw null;
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type getOwnerType() {
            return null;
        }

        @Override // java.lang.reflect.ParameterizedType
        public final Type getRawType() {
            return null;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return TypeUtils.r(this);
        }
    }

    public static class WildcardTypeBuilder implements Builder<WildcardType> {
    }

    public static final class WildcardTypeImpl implements WildcardType {

        /* renamed from: a, reason: collision with root package name */
        public static final Type[] f57762a = new Type[0];

        public final boolean equals(Object obj) {
            if (obj != this) {
                return (obj instanceof WildcardType) && TypeUtils.e(this, (WildcardType) obj);
            }
            return true;
        }

        @Override // java.lang.reflect.WildcardType
        public final Type[] getLowerBounds() {
            throw null;
        }

        @Override // java.lang.reflect.WildcardType
        public final Type[] getUpperBounds() {
            throw null;
        }

        public final int hashCode() {
            return Arrays.hashCode((Object[]) null) | ((Arrays.hashCode((Object[]) null) | 18688) << 8);
        }

        public final String toString() {
            return TypeUtils.r(this);
        }
    }

    public static void a(StringBuilder sb, String str, Type... typeArr) throws NegativeArraySizeException {
        Object[] objArr = new Object[0];
        Validate.a(typeArr, "The validated object is null", new Object[0]);
        int i2 = 0;
        while (true) {
            if (i2 >= typeArr.length) {
                if (typeArr.length == 0) {
                    throw new IllegalArgumentException("The validated array is empty");
                }
                if (typeArr.length > 0) {
                    sb.append(r(typeArr[0]));
                    for (int i3 = 1; i3 < typeArr.length; i3++) {
                        sb.append(str);
                        sb.append(r(typeArr[i3]));
                    }
                    return;
                }
                return;
            }
            if (typeArr[i2] == null) {
                Integer numValueOf = Integer.valueOf(i2);
                objArr.getClass().getComponentType();
                int length = Array.getLength(objArr);
                Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), length + 1);
                System.arraycopy(objArr, 0, objNewInstance, 0, length);
                Object[] objArr2 = (Object[]) objNewInstance;
                objArr2[objArr2.length - 1] = numValueOf;
                throw new IllegalArgumentException(String.format("The validated array contains null element at index: %d", objArr2));
            }
            i2++;
        }
    }

    public static String b(Class cls) throws NegativeArraySizeException {
        StringBuilder sb = new StringBuilder();
        if (cls.getEnclosingClass() != null) {
            sb.append(b(cls.getEnclosingClass()));
            sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
            sb.append(cls.getSimpleName());
        } else {
            sb.append(cls.getName());
        }
        if (cls.getTypeParameters().length > 0) {
            sb.append('<');
            a(sb, ", ", cls.getTypeParameters());
            sb.append('>');
        }
        return sb.toString();
    }

    public static boolean c(ParameterizedType parameterizedType, Type type) {
        if (!(type instanceof ParameterizedType)) {
            return false;
        }
        ParameterizedType parameterizedType2 = (ParameterizedType) type;
        if (d(parameterizedType.getRawType(), parameterizedType2.getRawType()) && d(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType())) {
            return f(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
        }
        return false;
    }

    public static boolean d(Type type, Type type2) {
        if (ObjectUtils.a(type, type2)) {
            return true;
        }
        if (type instanceof ParameterizedType) {
            return c((ParameterizedType) type, type2);
        }
        if (type instanceof GenericArrayType) {
            return (type2 instanceof GenericArrayType) && d(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
        }
        if (type instanceof WildcardType) {
            return e((WildcardType) type, type2);
        }
        return false;
    }

    public static boolean e(WildcardType wildcardType, Type type) {
        if (!(type instanceof WildcardType)) {
            return true;
        }
        WildcardType wildcardType2 = (WildcardType) type;
        return f(i(wildcardType), i(wildcardType2)) && f(j(wildcardType), j(wildcardType2));
    }

    public static boolean f(Type[] typeArr, Type[] typeArr2) {
        if (typeArr.length != typeArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < typeArr.length; i2++) {
            if (!d(typeArr[i2], typeArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    public static Type g(Class cls, Class cls2) {
        Class clsK;
        if (cls2.isInterface()) {
            Type type = null;
            for (Type type2 : cls.getGenericInterfaces()) {
                if (type2 instanceof ParameterizedType) {
                    clsK = k((ParameterizedType) type2);
                } else {
                    if (!(type2 instanceof Class)) {
                        throw new IllegalStateException(e.q("Unexpected generic interface type found: ", type2));
                    }
                    clsK = (Class) type2;
                }
                if (n(clsK, cls2) && o(type, clsK)) {
                    type = type2;
                }
            }
            if (type != null) {
                return type;
            }
        }
        return cls.getGenericSuperclass();
    }

    public static Type[] h(TypeVariable typeVariable) {
        Validate.a(typeVariable, "typeVariable is null", new Object[0]);
        Type[] bounds = typeVariable.getBounds();
        return bounds.length == 0 ? new Type[]{Object.class} : q(bounds);
    }

    public static Type[] i(WildcardType wildcardType) {
        Validate.a(wildcardType, "wildcardType is null", new Object[0]);
        Type[] lowerBounds = wildcardType.getLowerBounds();
        return lowerBounds.length == 0 ? new Type[]{null} : lowerBounds;
    }

    public static Type[] j(WildcardType wildcardType) {
        Validate.a(wildcardType, "wildcardType is null", new Object[0]);
        Type[] upperBounds = wildcardType.getUpperBounds();
        return upperBounds.length == 0 ? new Type[]{Object.class} : q(upperBounds);
    }

    public static Class k(ParameterizedType parameterizedType) {
        Type rawType = parameterizedType.getRawType();
        if (rawType instanceof Class) {
            return (Class) rawType;
        }
        throw new IllegalStateException(e.q("Wait... What!? Type of rawType: ", rawType));
    }

    public static Map l(ParameterizedType parameterizedType, Class cls, Map map) {
        Map map2;
        Class clsK = k(parameterizedType);
        if (!n(clsK, cls)) {
            return null;
        }
        Type ownerType = parameterizedType.getOwnerType();
        if (ownerType instanceof ParameterizedType) {
            ParameterizedType parameterizedType2 = (ParameterizedType) ownerType;
            map2 = l(parameterizedType2, k(parameterizedType2), map);
        } else {
            map2 = map == null ? new HashMap() : new HashMap(map);
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        TypeVariable[] typeParameters = clsK.getTypeParameters();
        for (int i2 = 0; i2 < typeParameters.length; i2++) {
            Type type = actualTypeArguments[i2];
            TypeVariable typeVariable = typeParameters[i2];
            if (map2.containsKey(type)) {
                type = (Type) map2.get(type);
            }
            map2.put(typeVariable, type);
        }
        return cls.equals(clsK) ? map2 : m(g(clsK, cls), cls, map2);
    }

    public static Map m(Type type, Class cls, Map map) {
        if (type instanceof Class) {
            Class cls2 = (Class) type;
            if (!n(cls2, cls)) {
                return null;
            }
            if (cls2.isPrimitive()) {
                if (cls.isPrimitive()) {
                    return new HashMap();
                }
                HashMap map2 = org.shadow.apache.commons.lang3.ClassUtils.f57702a;
                if (cls2.isPrimitive()) {
                    cls2 = (Class) org.shadow.apache.commons.lang3.ClassUtils.f57702a.get(cls2);
                }
            }
            HashMap map3 = map == null ? new HashMap() : new HashMap(map);
            return cls.equals(cls2) ? map3 : m(g(cls2, cls), cls, map3);
        }
        if (type instanceof ParameterizedType) {
            return l((ParameterizedType) type, cls, map);
        }
        if (type instanceof GenericArrayType) {
            Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
            if (cls.isArray()) {
                cls = cls.getComponentType();
            }
            return m(genericComponentType, cls, map);
        }
        int i2 = 0;
        if (type instanceof WildcardType) {
            Type[] typeArrJ = j((WildcardType) type);
            int length = typeArrJ.length;
            while (i2 < length) {
                Type type2 = typeArrJ[i2];
                if (n(type2, cls)) {
                    return m(type2, cls, map);
                }
                i2++;
            }
            return null;
        }
        if (!(type instanceof TypeVariable)) {
            throw new IllegalStateException(e.q("found an unhandled type: ", type));
        }
        Type[] typeArrH = h((TypeVariable) type);
        int length2 = typeArrH.length;
        while (i2 < length2) {
            Type type3 = typeArrH[i2];
            if (n(type3, cls)) {
                return m(type3, cls, map);
            }
            i2++;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004c A[PHI: r8
      0x004c: PHI (r8v33 java.lang.Class<?>) = (r8v10 java.lang.Class<?>), (r8v10 java.lang.Class<?>), (r8v36 java.lang.Class<?>) binds: [B:18:0x0032, B:20:0x0038, B:24:0x0048] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0064 A[PHI: r8
      0x0064: PHI (r8v11 java.lang.Class<?>) = (r8v10 java.lang.Class<?>), (r8v33 java.lang.Class<?>), (r8v33 java.lang.Class<?>), (r8v35 java.lang.Class<?>) binds: [B:16:0x002c, B:27:0x0050, B:29:0x0056, B:31:0x0060] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean n(java.lang.reflect.Type r8, java.lang.Class r9) {
        /*
            Method dump skipped, instructions count: 410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.shadow.apache.commons.lang3.reflect.TypeUtils.n(java.lang.reflect.Type, java.lang.Class):boolean");
    }

    public static boolean o(Type type, Type type2) {
        Type type3;
        Type type4;
        if (type2 == null || (type2 instanceof Class)) {
            return n(type, (Class) type2);
        }
        if (type2 instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type2;
            if (type == null || parameterizedType.equals(type)) {
                return true;
            }
            Class clsK = k(parameterizedType);
            Map mapM = m(type, clsK, null);
            if (mapM != null) {
                if (mapM.isEmpty()) {
                    return true;
                }
                Map mapL = l(parameterizedType, clsK, null);
                for (TypeVariable typeVariable : mapL.keySet()) {
                    TypeVariable typeVariable2 = typeVariable;
                    while (true) {
                        type3 = (Type) mapL.get(typeVariable2);
                        if (!(type3 instanceof TypeVariable) || type3.equals(typeVariable2)) {
                            break;
                        }
                        typeVariable2 = (TypeVariable) type3;
                    }
                    while (true) {
                        type4 = (Type) mapM.get(typeVariable);
                        if (!(type4 instanceof TypeVariable) || type4.equals(typeVariable)) {
                            break;
                        }
                        typeVariable = (TypeVariable) type4;
                    }
                    if (type4 == null || type3.equals(type4) || ((type3 instanceof WildcardType) && o(type4, type3))) {
                    }
                }
                return true;
            }
        } else if (type2 instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) type2;
            if (type == null || genericArrayType.equals(type)) {
                return true;
            }
            Type genericComponentType = genericArrayType.getGenericComponentType();
            if (type instanceof Class) {
                Class cls = (Class) type;
                if (cls.isArray() && o(cls.getComponentType(), genericComponentType)) {
                    return true;
                }
            } else {
                if (type instanceof GenericArrayType) {
                    return o(((GenericArrayType) type).getGenericComponentType(), genericComponentType);
                }
                if (type instanceof WildcardType) {
                    for (Type type5 : j((WildcardType) type)) {
                        if (o(type5, genericArrayType)) {
                            return true;
                        }
                    }
                } else {
                    if (!(type instanceof TypeVariable)) {
                        if (type instanceof ParameterizedType) {
                            return false;
                        }
                        throw new IllegalStateException(e.q("found an unhandled type: ", type));
                    }
                    for (Type type6 : h((TypeVariable) type)) {
                        if (o(type6, genericArrayType)) {
                            return true;
                        }
                    }
                }
            }
        } else {
            if (!(type2 instanceof WildcardType)) {
                if (type2 instanceof TypeVariable) {
                    return p(type, (TypeVariable) type2);
                }
                throw new IllegalStateException(e.q("found an unhandled type: ", type2));
            }
            WildcardType wildcardType = (WildcardType) type2;
            if (type == null || wildcardType.equals(type)) {
                return true;
            }
            Type[] typeArrJ = j(wildcardType);
            Type[] typeArrI = i(wildcardType);
            if (type instanceof WildcardType) {
                WildcardType wildcardType2 = (WildcardType) type;
                Type[] typeArrJ2 = j(wildcardType2);
                Type[] typeArrI2 = i(wildcardType2);
                int length = typeArrJ.length;
                int i2 = 0;
                loop5: while (true) {
                    if (i2 >= length) {
                        for (Type type7 : typeArrI) {
                            boolean z = type7 instanceof TypeVariable;
                            for (Type type8 : typeArrI2) {
                                if (o(type7, type8)) {
                                }
                            }
                        }
                        return true;
                    }
                    Type type9 = typeArrJ[i2];
                    boolean z2 = type9 instanceof TypeVariable;
                    for (Type type10 : typeArrJ2) {
                        if (!o(type10, type9)) {
                            break loop5;
                        }
                    }
                    i2++;
                }
            } else {
                int length2 = typeArrJ.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length2) {
                        for (Type type11 : typeArrI) {
                            boolean z3 = type11 instanceof TypeVariable;
                            if (o(type11, type)) {
                            }
                        }
                        return true;
                    }
                    Type type12 = typeArrJ[i3];
                    boolean z4 = type12 instanceof TypeVariable;
                    if (!o(type, type12)) {
                        break;
                    }
                    i3++;
                }
            }
        }
        return false;
    }

    public static boolean p(Type type, TypeVariable typeVariable) {
        if (type == null) {
            return true;
        }
        if (typeVariable == null) {
            return false;
        }
        if (typeVariable.equals(type)) {
            return true;
        }
        if (type instanceof TypeVariable) {
            for (Type type2 : h((TypeVariable) type)) {
                if (p(type2, typeVariable)) {
                    return true;
                }
            }
        }
        if ((type instanceof Class) || (type instanceof ParameterizedType) || (type instanceof GenericArrayType) || (type instanceof WildcardType)) {
            return false;
        }
        throw new IllegalStateException(e.q("found an unhandled type: ", type));
    }

    public static Type[] q(Type[] typeArr) {
        int i2;
        if (typeArr.length < 2) {
            return typeArr;
        }
        HashSet hashSet = new HashSet(typeArr.length);
        for (Type type : typeArr) {
            int length = typeArr.length;
            while (true) {
                if (i2 >= length) {
                    hashSet.add(type);
                    break;
                }
                Type type2 = typeArr[i2];
                i2 = (type == type2 || !o(type2, type)) ? i2 + 1 : 0;
            }
        }
        return (Type[]) hashSet.toArray(new Type[hashSet.size()]);
    }

    public static String r(Type type) throws NegativeArraySizeException {
        Validate.a(type, "The validated object is null", new Object[0]);
        if (type instanceof Class) {
            return b((Class) type);
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            StringBuilder sb = new StringBuilder();
            Type ownerType = parameterizedType.getOwnerType();
            Class cls = (Class) parameterizedType.getRawType();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            if (ownerType == null) {
                sb.append(cls.getName());
            } else {
                if (ownerType instanceof Class) {
                    sb.append(((Class) ownerType).getName());
                } else {
                    sb.append(ownerType.toString());
                }
                sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                sb.append(cls.getSimpleName());
            }
            sb.append('<');
            a(sb, ", ", actualTypeArguments);
            sb.append('>');
            return sb.toString();
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            StringBuilder sb2 = new StringBuilder();
            sb2.append('?');
            Type[] lowerBounds = wildcardType.getLowerBounds();
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (lowerBounds.length > 1 || (lowerBounds.length == 1 && lowerBounds[0] != null)) {
                sb2.append(" super ");
                a(sb2, " & ", lowerBounds);
            } else if (upperBounds.length > 1 || (upperBounds.length == 1 && !Object.class.equals(upperBounds[0]))) {
                sb2.append(" extends ");
                a(sb2, " & ", upperBounds);
            }
            return sb2.toString();
        }
        if (!(type instanceof TypeVariable)) {
            if (type instanceof GenericArrayType) {
                return b.k(r(((GenericArrayType) type).getGenericComponentType()), "[]");
            }
            throw new IllegalArgumentException(type.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(type)));
        }
        TypeVariable typeVariable = (TypeVariable) type;
        StringBuilder sb3 = new StringBuilder(typeVariable.getName());
        Type[] bounds = typeVariable.getBounds();
        if (bounds.length > 0 && (bounds.length != 1 || !Object.class.equals(bounds[0]))) {
            sb3.append(" extends ");
            a(sb3, " & ", typeVariable.getBounds());
        }
        return sb3.toString();
    }
}
