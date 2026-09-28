package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class zzwy extends zzuu {
    public static final zzuv zza = new zzwx();
    private final Class zzb;
    private final zzuu zzc;

    public zzwy(zztx zztxVar, zzuu zzuuVar, Class cls) {
        this.zzc = new zzyh(zztxVar, zzuuVar, cls);
        this.zzb = cls;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final Object read(zzaaq zzaaqVar) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        if (zzaaqVar.zzr() == 9) {
            zzaaqVar.zzm();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        zzaaqVar.zzi();
        while (zzaaqVar.zzp()) {
            arrayList.add(this.zzc.read(zzaaqVar));
        }
        zzaaqVar.zzk();
        int size = arrayList.size();
        if (!this.zzb.isPrimitive()) {
            return arrayList.toArray((Object[]) Array.newInstance((Class<?>) this.zzb, size));
        }
        Object objNewInstance = Array.newInstance((Class<?>) this.zzb, size);
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(objNewInstance, i2, arrayList.get(i2));
        }
        return objNewInstance;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final void write(zzaas zzaasVar, Object obj) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (obj == null) {
            zzaasVar.zzg();
            return;
        }
        zzaasVar.zzb();
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            this.zzc.write(zzaasVar, Array.get(obj, i2));
        }
        zzaasVar.zzd();
    }
}
