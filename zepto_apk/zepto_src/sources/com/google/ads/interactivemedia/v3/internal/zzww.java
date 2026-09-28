package com.google.ads.interactivemedia.v3.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public abstract class zzww {
    public static final zzww zzc;

    static {
        zzww zzwvVar;
        try {
            try {
                try {
                    Class<?> cls = Class.forName("sun.misc.Unsafe");
                    Field declaredField = cls.getDeclaredField("theUnsafe");
                    declaredField.setAccessible(true);
                    zzwvVar = new zzws(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
                } catch (Exception unused) {
                    zzwvVar = new zzwv();
                }
            } catch (Exception unused2) {
                Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                declaredMethod.setAccessible(true);
                zzwvVar = new zzwu(declaredMethod);
            }
        } catch (Exception unused3) {
            Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
            declaredMethod2.setAccessible(true);
            int iIntValue = ((Integer) declaredMethod2.invoke(null, Object.class)).intValue();
            Method declaredMethod3 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
            declaredMethod3.setAccessible(true);
            zzwvVar = new zzwt(declaredMethod3, iIntValue);
        }
        zzc = zzwvVar;
    }

    public static /* bridge */ /* synthetic */ void zzb(Class cls) {
        String strZzb = zzvw.zzb(cls);
        if (strZzb != null) {
            throw new AssertionError("UnsafeAllocator is used for non-instantiable type: ".concat(strZzb));
        }
    }

    public abstract Object zza(Class cls) throws Exception;
}
