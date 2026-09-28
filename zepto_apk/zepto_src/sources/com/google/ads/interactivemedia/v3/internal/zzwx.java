package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* loaded from: classes3.dex */
final class zzwx implements zzuv {
    @Override // com.google.ads.interactivemedia.v3.internal.zzuv
    public final zzuu zza(zztx zztxVar, zzaao zzaaoVar) {
        Type genericComponentType;
        Type typeZzd = zzaaoVar.zzd();
        if (typeZzd instanceof GenericArrayType) {
            genericComponentType = ((GenericArrayType) typeZzd).getGenericComponentType();
        } else {
            if (!(typeZzd instanceof Class)) {
                return null;
            }
            Class cls = (Class) typeZzd;
            if (!cls.isArray()) {
                return null;
            }
            genericComponentType = cls.getComponentType();
        }
        return new zzwy(zztxVar, zztxVar.zza(zzaao.zzb(genericComponentType)), zzvc.zza(genericComponentType));
    }
}
