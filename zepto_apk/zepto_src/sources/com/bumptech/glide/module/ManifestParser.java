package com.bumptech.glide.module;

import android.support.v4.media.b;
import java.lang.reflect.InvocationTargetException;

@Deprecated
/* loaded from: classes3.dex */
public final class ManifestParser {
    public static GlideModule a(String str) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<?> cls = Class.forName(str);
            try {
                Object objNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
                if (objNewInstance instanceof GlideModule) {
                    return (GlideModule) objNewInstance;
                }
                throw new RuntimeException(b.j(objNewInstance, "Expected instanceof GlideModule, but found: "));
            } catch (IllegalAccessException e2) {
                b(cls, e2);
                throw null;
            } catch (InstantiationException e3) {
                b(cls, e3);
                throw null;
            } catch (NoSuchMethodException e4) {
                b(cls, e4);
                throw null;
            } catch (InvocationTargetException e5) {
                b(cls, e5);
                throw null;
            }
        } catch (ClassNotFoundException e6) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e6);
        }
    }

    public static void b(Class cls, ReflectiveOperationException reflectiveOperationException) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, reflectiveOperationException);
    }
}
