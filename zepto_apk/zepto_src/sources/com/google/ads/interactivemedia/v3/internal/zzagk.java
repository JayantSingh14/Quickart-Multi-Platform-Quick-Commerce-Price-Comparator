package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;

/* loaded from: classes3.dex */
public final class zzagk {
    private static final ThreadLocal zza = new ThreadLocal();
    private int zzb = 17;

    public static int zza(Object obj, String... strArr) {
        Objects.requireNonNull(obj, "object");
        zzagk zzagkVar = new zzagk();
        Class<?> superclass = obj.getClass();
        zze(obj, superclass, zzagkVar, false, strArr);
        while (superclass.getSuperclass() != null) {
            superclass = superclass.getSuperclass();
            zze(obj, superclass, zzagkVar, false, strArr);
        }
        return zzagkVar.zzb;
    }

    public static Set zzb() {
        return (Set) zza.get();
    }

    private static void zze(Object obj, Class cls, zzagk zzagkVar, boolean z, String[] strArr) {
        Set setZzb = zzb();
        if (setZzb == null || !setZzb.contains(new zzagm(obj))) {
            try {
                Set setZzb2 = zzb();
                if (setZzb2 == null) {
                    setZzb2 = new HashSet();
                    zza.set(setZzb2);
                }
                setZzb2.add(new zzagm(obj));
                Field[] declaredFields = cls.getDeclaredFields();
                Arrays.sort(declaredFields, Comparator.comparing(new Function() { // from class: com.google.ads.interactivemedia.v3.internal.zzagj
                    @Override // java.util.function.Function
                    public final Object apply(Object obj2) {
                        return ((Field) obj2).getName();
                    }
                }));
                AccessibleObject.setAccessible(declaredFields, true);
                for (Field field : declaredFields) {
                    if (!zzagd.zza(strArr, field.getName()) && !field.getName().contains("$") && !Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers()) && !field.isAnnotationPresent(zzagl.class)) {
                        zzagkVar.zzd(zzagn.zza(field, obj));
                    }
                }
                zzf(obj);
            } catch (Throwable th) {
                zzf(obj);
                throw th;
            }
        }
    }

    private static void zzf(Object obj) {
        Set setZzb = zzb();
        if (setZzb != null) {
            setZzb.remove(new zzagm(obj));
            if (setZzb.isEmpty()) {
                zza.remove();
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof zzagk) && this.zzb == ((zzagk) obj).zzb;
    }

    public final int hashCode() {
        return this.zzb;
    }

    public final zzagk zzc(long j2) {
        this.zzb = (this.zzb * 37) + ((int) (j2 ^ (j2 >> 32)));
        return this;
    }

    public final zzagk zzd(Object obj) {
        if (obj == null) {
            this.zzb *= 37;
            return this;
        }
        if (!zzagf.zza(obj)) {
            this.zzb = obj.hashCode() + (this.zzb * 37);
            return this;
        }
        int i2 = 0;
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length = jArr.length;
            while (i2 < length) {
                zzc(jArr[i2]);
                i2++;
            }
        } else if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            int length2 = iArr.length;
            while (i2 < length2) {
                this.zzb = (this.zzb * 37) + iArr[i2];
                i2++;
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            int length3 = sArr.length;
            while (i2 < length3) {
                this.zzb = (this.zzb * 37) + sArr[i2];
                i2++;
            }
        } else if (obj instanceof char[]) {
            char[] cArr = (char[]) obj;
            int length4 = cArr.length;
            while (i2 < length4) {
                this.zzb = (this.zzb * 37) + cArr[i2];
                i2++;
            }
        } else if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            int length5 = bArr.length;
            while (i2 < length5) {
                this.zzb = (this.zzb * 37) + bArr[i2];
                i2++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length6 = dArr.length;
            while (i2 < length6) {
                zzc(Double.doubleToLongBits(dArr[i2]));
                i2++;
            }
        } else if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            int length7 = fArr.length;
            while (i2 < length7) {
                this.zzb = Float.floatToIntBits(fArr[i2]) + (this.zzb * 37);
                i2++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length8 = zArr.length;
            while (i2 < length8) {
                this.zzb = (this.zzb * 37) + (!zArr[i2] ? 1 : 0);
                i2++;
            }
        } else {
            Object[] objArr = (Object[]) obj;
            int length9 = objArr.length;
            while (i2 < length9) {
                zzd(objArr[i2]);
                i2++;
            }
        }
        return this;
    }
}
