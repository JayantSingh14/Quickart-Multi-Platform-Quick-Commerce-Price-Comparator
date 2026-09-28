package org.apache.commons.lang3.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.apache.commons.lang3.ClassUtils;

/* loaded from: classes5.dex */
abstract class MemberUtils {
    private static final int ACCESS_TEST = 7;
    private static final Class<?>[] ORDERED_PRIMITIVE_TYPES = {Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE};

    public static final class Executable {
        private final boolean isVarArgs;
        private final Class<?>[] parameterTypes;

        private Executable(Method method) {
            this.parameterTypes = method.getParameterTypes();
            this.isVarArgs = method.isVarArgs();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Executable of(Method method) {
            return new Executable(method);
        }

        public Class<?>[] getParameterTypes() {
            return this.parameterTypes;
        }

        public boolean isVarArgs() {
            return this.isVarArgs;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Executable of(Constructor<?> constructor) {
            return new Executable(constructor);
        }

        private Executable(Constructor<?> constructor) {
            this.parameterTypes = constructor.getParameterTypes();
            this.isVarArgs = constructor.isVarArgs();
        }
    }

    public static int compareConstructorFit(Constructor<?> constructor, Constructor<?> constructor2, Class<?>[] clsArr) {
        return compareParameterTypes(Executable.of(constructor), Executable.of(constructor2), clsArr);
    }

    public static int compareMethodFit(Method method, Method method2, Class<?>[] clsArr) {
        return compareParameterTypes(Executable.of(method), Executable.of(method2), clsArr);
    }

    private static int compareParameterTypes(Executable executable, Executable executable2, Class<?>[] clsArr) {
        float totalTransformationCost = getTotalTransformationCost(clsArr, executable);
        float totalTransformationCost2 = getTotalTransformationCost(clsArr, executable2);
        if (totalTransformationCost < totalTransformationCost2) {
            return -1;
        }
        return totalTransformationCost2 < totalTransformationCost ? 1 : 0;
    }

    private static float getObjectTransformationCost(Class<?> cls, Class<?> cls2) {
        if (cls2.isPrimitive()) {
            return getPrimitivePromotionCost(cls, cls2);
        }
        float f2 = 0.0f;
        while (true) {
            if (cls != null && !cls2.equals(cls)) {
                if (cls2.isInterface() && ClassUtils.isAssignable(cls, cls2)) {
                    f2 += 0.25f;
                    break;
                }
                f2 += 1.0f;
                cls = cls.getSuperclass();
            } else {
                break;
            }
        }
        return cls == null ? f2 + 1.5f : f2;
    }

    private static float getPrimitivePromotionCost(Class<?> cls, Class<?> cls2) {
        float f2;
        if (cls.isPrimitive()) {
            f2 = 0.0f;
        } else {
            cls = ClassUtils.wrapperToPrimitive(cls);
            f2 = 0.1f;
        }
        int i2 = 0;
        while (cls != cls2) {
            Class<?>[] clsArr = ORDERED_PRIMITIVE_TYPES;
            if (i2 >= clsArr.length) {
                break;
            }
            if (cls == clsArr[i2]) {
                f2 += 0.1f;
                if (i2 < clsArr.length - 1) {
                    cls = clsArr[i2 + 1];
                }
            }
            i2++;
        }
        return f2;
    }

    private static float getTotalTransformationCost(Class<?>[] clsArr, Executable executable) {
        float objectTransformationCost;
        Class<?>[] parameterTypes = executable.getParameterTypes();
        boolean zIsVarArgs = executable.isVarArgs();
        int length = parameterTypes.length;
        if (zIsVarArgs) {
            length--;
        }
        long j2 = length;
        if (clsArr.length < j2) {
            return Float.MAX_VALUE;
        }
        boolean z = false;
        float objectTransformationCost2 = 0.0f;
        for (int i2 = 0; i2 < j2; i2++) {
            objectTransformationCost2 += getObjectTransformationCost(clsArr[i2], parameterTypes[i2]);
        }
        if (zIsVarArgs) {
            boolean z2 = clsArr.length < parameterTypes.length;
            if (clsArr.length == parameterTypes.length && clsArr[clsArr.length - 1].isArray()) {
                z = true;
            }
            Class<?> componentType = parameterTypes[parameterTypes.length - 1].getComponentType();
            if (z2) {
                objectTransformationCost = getObjectTransformationCost(componentType, Object.class);
            } else if (z) {
                objectTransformationCost = getObjectTransformationCost(clsArr[clsArr.length - 1].getComponentType(), componentType);
            } else {
                for (int length2 = parameterTypes.length - 1; length2 < clsArr.length; length2++) {
                    objectTransformationCost2 += getObjectTransformationCost(clsArr[length2], componentType) + 0.001f;
                }
            }
            return objectTransformationCost + 0.001f + objectTransformationCost2;
        }
        return objectTransformationCost2;
    }

    public static boolean isAccessible(Member member) {
        return (member == null || !Modifier.isPublic(member.getModifiers()) || member.isSynthetic()) ? false : true;
    }

    public static boolean isMatchingConstructor(Constructor<?> constructor, Class<?>[] clsArr) {
        return isMatchingExecutable(Executable.of(constructor), clsArr);
    }

    private static boolean isMatchingExecutable(Executable executable, Class<?>[] clsArr) {
        Class<?>[] parameterTypes = executable.getParameterTypes();
        if (ClassUtils.isAssignable(clsArr, parameterTypes, true)) {
            return true;
        }
        if (!executable.isVarArgs()) {
            return false;
        }
        int i2 = 0;
        while (i2 < parameterTypes.length - 1 && i2 < clsArr.length) {
            if (!ClassUtils.isAssignable(clsArr[i2], parameterTypes[i2], true)) {
                return false;
            }
            i2++;
        }
        Class<?> componentType = parameterTypes[parameterTypes.length - 1].getComponentType();
        while (i2 < clsArr.length) {
            if (!ClassUtils.isAssignable(clsArr[i2], componentType, true)) {
                return false;
            }
            i2++;
        }
        return true;
    }

    public static boolean isMatchingMethod(Method method, Class<?>[] clsArr) {
        return isMatchingExecutable(Executable.of(method), clsArr);
    }

    public static boolean isPackageAccess(int i2) {
        return (i2 & 7) == 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean setAccessibleWorkaround(AccessibleObject accessibleObject) throws SecurityException {
        if (accessibleObject != 0 && !accessibleObject.isAccessible()) {
            Member member = (Member) accessibleObject;
            if (!accessibleObject.isAccessible() && Modifier.isPublic(member.getModifiers()) && isPackageAccess(member.getDeclaringClass().getModifiers())) {
                try {
                    accessibleObject.setAccessible(true);
                    return true;
                } catch (SecurityException unused) {
                }
            }
        }
        return false;
    }
}
