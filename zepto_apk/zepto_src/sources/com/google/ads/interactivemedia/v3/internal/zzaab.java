package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* loaded from: classes3.dex */
public final class zzaab {
    private static final zzzw zza;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        zzzw zzzyVar;
        Object[] objArr = 0;
        try {
            zzzyVar = new zzaaa(null);
        } catch (ReflectiveOperationException unused) {
            zzzyVar = new zzzy(objArr == true ? 1 : 0);
        }
        zza = zzzyVar;
    }

    public static /* bridge */ /* synthetic */ RuntimeException zza(ReflectiveOperationException reflectiveOperationException) {
        throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.10.1). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", reflectiveOperationException);
    }

    public static RuntimeException zzb(IllegalAccessException illegalAccessException) {
        throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.10.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", illegalAccessException);
    }

    public static String zzc(Constructor constructor) {
        StringBuilder sb = new StringBuilder(constructor.getDeclaringClass().getName());
        zzn(constructor, sb);
        return sb.toString();
    }

    public static String zzd(Field field) {
        return b.l(field.getDeclaringClass().getName(), "#", field.getName());
    }

    public static String zze(AccessibleObject accessibleObject, boolean z) {
        String strD;
        if (accessibleObject instanceof Field) {
            strD = b.D("field '", zzd((Field) accessibleObject), "'");
        } else if (accessibleObject instanceof Method) {
            Method method = (Method) accessibleObject;
            StringBuilder sb = new StringBuilder(method.getName());
            zzn(method, sb);
            strD = b.m("method '", method.getDeclaringClass().getName(), "#", sb.toString(), "'");
        } else {
            strD = accessibleObject instanceof Constructor ? b.D("constructor '", zzc((Constructor) accessibleObject), "'") : "<unknown AccessibleObject> ".concat(String.valueOf(accessibleObject.toString()));
        }
        if (!z || !Character.isLowerCase(strD.charAt(0))) {
            return strD;
        }
        return Character.toUpperCase(strD.charAt(0)) + strD.substring(1);
    }

    public static String zzf(Constructor constructor) throws SecurityException {
        try {
            constructor.setAccessible(true);
            return null;
        } catch (Exception e2) {
            return b.m("Failed making constructor '", zzc(constructor), "' accessible; either increase its visibility or write a custom InstanceCreator or TypeAdapter for its declaring type: ", e2.getMessage(), zzm(e2));
        }
    }

    public static Constructor zzg(Class cls) {
        return zza.zza(cls);
    }

    public static Method zzh(Class cls, Field field) {
        return zza.zzb(cls, field);
    }

    public static void zzi(AccessibleObject accessibleObject) throws SecurityException, zzud {
        try {
            accessibleObject.setAccessible(true);
        } catch (Exception e2) {
            throw new zzud(e.p("Failed making ", zze(accessibleObject, false), " accessible; either increase its visibility or write a custom TypeAdapter for its declaring type.", zzm(e2)), e2);
        }
    }

    public static boolean zzj(Class cls) {
        if (Modifier.isStatic(cls.getModifiers())) {
            return false;
        }
        return cls.isAnonymousClass() || cls.isLocalClass();
    }

    public static boolean zzk(Class cls) {
        return zza.zzc(cls);
    }

    public static String[] zzl(Class cls) {
        return zza.zzd(cls);
    }

    private static String zzm(Exception exc) {
        if (!exc.getClass().getName().equals("java.lang.reflect.InaccessibleObjectException")) {
            return "";
        }
        String message = exc.getMessage();
        return "\nSee ".concat("https://github.com/google/gson/blob/main/Troubleshooting.md#".concat((message == null || !message.contains("to module com.google.gson")) ? "reflection-inaccessible" : "reflection-inaccessible-to-module-gson"));
    }

    private static void zzn(AccessibleObject accessibleObject, StringBuilder sb) {
        sb.append('(');
        Class<?>[] parameterTypes = accessibleObject instanceof Method ? ((Method) accessibleObject).getParameterTypes() : ((Constructor) accessibleObject).getParameterTypes();
        for (int i2 = 0; i2 < parameterTypes.length; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(parameterTypes[i2].getSimpleName());
        }
        sb.append(')');
    }
}
