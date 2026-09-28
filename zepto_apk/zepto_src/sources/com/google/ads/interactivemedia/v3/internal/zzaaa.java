package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
final class zzaaa extends zzzw {
    private final Method zza;
    private final Method zzb;
    private final Method zzc;
    private final Method zzd;

    private zzaaa() throws NoSuchMethodException, ClassNotFoundException {
        super(null);
        this.zza = Class.class.getMethod("isRecord", null);
        this.zzb = Class.class.getMethod("getRecordComponents", null);
        Class<?> cls = Class.forName("java.lang.reflect.RecordComponent");
        this.zzc = cls.getMethod("getName", null);
        this.zzd = cls.getMethod("getType", null);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzzw
    public final Constructor zza(Class cls) {
        try {
            Object[] objArr = (Object[]) this.zzb.invoke(cls, null);
            Class<?>[] clsArr = new Class[objArr.length];
            for (int i2 = 0; i2 < objArr.length; i2++) {
                clsArr[i2] = (Class) this.zzd.invoke(objArr[i2], null);
            }
            return cls.getDeclaredConstructor(clsArr);
        } catch (ReflectiveOperationException e2) {
            throw zzaab.zza(e2);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzzw
    public final Method zzb(Class cls, Field field) {
        try {
            return cls.getMethod(field.getName(), null);
        } catch (ReflectiveOperationException e2) {
            throw zzaab.zza(e2);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzzw
    public final boolean zzc(Class cls) {
        try {
            return ((Boolean) this.zza.invoke(cls, null)).booleanValue();
        } catch (ReflectiveOperationException e2) {
            throw zzaab.zza(e2);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzzw
    public final String[] zzd(Class cls) {
        try {
            Object[] objArr = (Object[]) this.zzb.invoke(cls, null);
            String[] strArr = new String[objArr.length];
            for (int i2 = 0; i2 < objArr.length; i2++) {
                strArr[i2] = (String) this.zzc.invoke(objArr[i2], null);
            }
            return strArr;
        } catch (ReflectiveOperationException e2) {
            throw zzaab.zza(e2);
        }
    }

    public /* synthetic */ zzaaa(zzzz zzzzVar) throws ClassNotFoundException {
        super(null);
        this.zza = Class.class.getMethod("isRecord", null);
        this.zzb = Class.class.getMethod("getRecordComponents", null);
        Class<?> cls = Class.forName("java.lang.reflect.RecordComponent");
        this.zzc = cls.getMethod("getName", null);
        this.zzd = cls.getMethod("getType", null);
    }
}
