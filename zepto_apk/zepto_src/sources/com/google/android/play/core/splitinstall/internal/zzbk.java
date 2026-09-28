package com.google.android.play.core.splitinstall.internal;

import android.content.res.AssetManager;
import androidx.fragment.app.e;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzbk {
    public static zzbi a(Class cls, String str, Object obj) {
        return new zzbi(obj, e(obj, str), Array.newInstance((Class<?>) cls, 0).getClass());
    }

    public static Object b() throws NoSuchMethodException, SecurityException {
        try {
            Constructor declaredConstructor = AssetManager.class.getDeclaredConstructor(null);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor.newInstance(null);
        } catch (Exception e2) {
            throw new zzbl("Failed to invoke default constructor on class ".concat(AssetManager.class.getName()), e2);
        }
    }

    public static Object c(Object obj, String str, Class cls, Class cls2, Object obj2) {
        try {
            return cls.cast(f(obj.getClass(), str, cls2).invoke(obj, obj2));
        } catch (Exception e2) {
            throw new zzbl("Failed to invoke method " + str + " on an object of type " + obj.getClass(), e2);
        }
    }

    public static Object d(Object obj, String str, Class cls, List list, File file, Class cls2, List list2) {
        try {
            return Object[].class.cast(f(obj.getClass(), str, cls, File.class, cls2).invoke(obj, list, file, list2));
        } catch (Exception e2) {
            throw new zzbl("Failed to invoke method " + str + " on an object of type " + obj.getClass(), e2);
        }
    }

    public static Field e(Object obj, String str) throws NoSuchFieldException, SecurityException {
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        throw new zzbl(e.p("Failed to find a field named ", str, " on an object of instance ", obj.getClass().getName()));
    }

    public static Method f(Class cls, String str, Class... clsArr) throws NoSuchMethodException, SecurityException {
        for (Class superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Method declaredMethod = superclass.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
            }
        }
        throw new zzbl(String.format("Could not find a method named %s with parameters %s in type %s", str, Arrays.asList(clsArr), cls));
    }
}
