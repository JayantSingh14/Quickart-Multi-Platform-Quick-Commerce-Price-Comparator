package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class UnsafeAllocator {

    /* renamed from: a, reason: collision with root package name */
    public static final UnsafeAllocator f45336a;

    static {
        UnsafeAllocator unsafeAllocator;
        try {
            try {
                try {
                    Class<?> cls = Class.forName("sun.misc.Unsafe");
                    Field declaredField = cls.getDeclaredField("theUnsafe");
                    declaredField.setAccessible(true);
                    final Object obj = declaredField.get(null);
                    final Method method = cls.getMethod("allocateInstance", Class.class);
                    unsafeAllocator = new UnsafeAllocator() { // from class: com.google.gson.internal.UnsafeAllocator.1
                        @Override // com.google.gson.internal.UnsafeAllocator
                        public final Object a(Class cls2) {
                            String strA = ConstructorConstructor.a(cls2);
                            if (strA != null) {
                                throw new AssertionError("UnsafeAllocator is used for non-instantiable type: ".concat(strA));
                            }
                            return method.invoke(obj, cls2);
                        }
                    };
                } catch (Exception unused) {
                    unsafeAllocator = new UnsafeAllocator() { // from class: com.google.gson.internal.UnsafeAllocator.4
                        @Override // com.google.gson.internal.UnsafeAllocator
                        public final Object a(Class cls2) {
                            throw new UnsupportedOperationException("Cannot allocate " + cls2 + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
                        }
                    };
                }
            } catch (Exception unused2) {
                final Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                declaredMethod.setAccessible(true);
                unsafeAllocator = new UnsafeAllocator() { // from class: com.google.gson.internal.UnsafeAllocator.3
                    @Override // com.google.gson.internal.UnsafeAllocator
                    public final Object a(Class cls2) {
                        String strA = ConstructorConstructor.a(cls2);
                        if (strA != null) {
                            throw new AssertionError("UnsafeAllocator is used for non-instantiable type: ".concat(strA));
                        }
                        return declaredMethod.invoke(null, cls2, Object.class);
                    }
                };
            }
        } catch (Exception unused3) {
            Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
            declaredMethod2.setAccessible(true);
            final int iIntValue = ((Integer) declaredMethod2.invoke(null, Object.class)).intValue();
            final Method declaredMethod3 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
            declaredMethod3.setAccessible(true);
            unsafeAllocator = new UnsafeAllocator() { // from class: com.google.gson.internal.UnsafeAllocator.2
                @Override // com.google.gson.internal.UnsafeAllocator
                public final Object a(Class cls2) {
                    String strA = ConstructorConstructor.a(cls2);
                    if (strA != null) {
                        throw new AssertionError("UnsafeAllocator is used for non-instantiable type: ".concat(strA));
                    }
                    return declaredMethod3.invoke(null, cls2, Integer.valueOf(iIntValue));
                }
            };
        }
        f45336a = unsafeAllocator;
    }

    public abstract Object a(Class cls);
}
