package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
final class zzya extends zzxw {
    static final Map zza;
    private final Constructor zzb;
    private final Object[] zzc;
    private final Map zzd;

    static {
        HashMap map = new HashMap();
        map.put(Byte.TYPE, (byte) 0);
        map.put(Short.TYPE, (short) 0);
        map.put(Integer.TYPE, 0);
        map.put(Long.TYPE, 0L);
        map.put(Float.TYPE, Float.valueOf(0.0f));
        map.put(Double.TYPE, Double.valueOf(0.0d));
        map.put(Character.TYPE, (char) 0);
        map.put(Boolean.TYPE, Boolean.FALSE);
        zza = map;
    }

    public zzya(Class cls, zzxz zzxzVar, boolean z) throws SecurityException, zzud {
        super(zzxzVar);
        this.zzd = new HashMap();
        Constructor constructorZzg = zzaab.zzg(cls);
        this.zzb = constructorZzg;
        if (z) {
            zzyb.zzb(null, constructorZzg);
        } else {
            zzaab.zzi(constructorZzg);
        }
        String[] strArrZzl = zzaab.zzl(cls);
        for (int i2 = 0; i2 < strArrZzl.length; i2++) {
            this.zzd.put(strArrZzl[i2], Integer.valueOf(i2));
        }
        Class<?>[] parameterTypes = this.zzb.getParameterTypes();
        this.zzc = new Object[parameterTypes.length];
        for (int i3 = 0; i3 < parameterTypes.length; i3++) {
            this.zzc[i3] = zza.get(parameterTypes[i3]);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzxw
    public final /* bridge */ /* synthetic */ Object zza() {
        return (Object[]) this.zzc.clone();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzxw
    public final /* bridge */ /* synthetic */ void zzc(Object obj, zzaaq zzaaqVar, zzxx zzxxVar) throws zzug, IllegalAccessException, IOException {
        Object[] objArr = (Object[]) obj;
        Integer num = (Integer) this.zzd.get(zzxxVar.zzi);
        if (num != null) {
            zzxxVar.zza(zzaaqVar, num.intValue(), objArr);
        } else {
            Constructor constructor = this.zzb;
            throw new IllegalStateException(b.m("Could not find the index in the constructor '", zzaab.zzc(constructor), "' for field with name '", zzxxVar.zzi, "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters."));
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzxw
    /* renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final Object zzb(Object[] objArr) {
        try {
            return this.zzb.newInstance(objArr);
        } catch (IllegalAccessException e2) {
            throw zzaab.zzb(e2);
        } catch (IllegalArgumentException e3) {
            e = e3;
            throw new RuntimeException(e.p("Failed to invoke constructor '", zzaab.zzc(this.zzb), "' with args ", Arrays.toString(objArr)), e);
        } catch (InstantiationException e4) {
            e = e4;
            throw new RuntimeException(e.p("Failed to invoke constructor '", zzaab.zzc(this.zzb), "' with args ", Arrays.toString(objArr)), e);
        } catch (InvocationTargetException e5) {
            throw new RuntimeException(e.p("Failed to invoke constructor '", zzaab.zzc(this.zzb), "' with args ", Arrays.toString(objArr)), e5.getCause());
        }
    }
}
