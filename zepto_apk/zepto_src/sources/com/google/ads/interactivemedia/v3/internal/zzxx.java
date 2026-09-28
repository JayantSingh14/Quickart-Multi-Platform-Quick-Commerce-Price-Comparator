package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.lang.reflect.Field;

/* loaded from: classes3.dex */
abstract class zzxx {
    final String zzg;
    final Field zzh;
    final String zzi;

    public zzxx(String str, Field field) {
        this.zzg = str;
        this.zzh = field;
        this.zzi = field.getName();
    }

    public abstract void zza(zzaaq zzaaqVar, int i2, Object[] objArr) throws zzug, IOException;

    public abstract void zzb(zzaaq zzaaqVar, Object obj) throws IllegalAccessException, IOException;

    public abstract void zzc(zzaas zzaasVar, Object obj) throws IllegalAccessException, IOException;
}
