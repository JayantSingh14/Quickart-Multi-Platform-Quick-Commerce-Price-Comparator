package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes3.dex */
public final class zzxi implements zzuv {
    private static final zzuv zza;
    private static final zzuv zzb;
    private final zzvw zzc;
    private final ConcurrentMap zzd = new ConcurrentHashMap();

    static {
        zzxg zzxgVar = null;
        zza = new zzxh(zzxgVar);
        zzb = new zzxh(zzxgVar);
    }

    public zzxi(zzvw zzvwVar) {
        this.zzc = zzvwVar;
    }

    private final zzuv zzd(Class cls, zzuv zzuvVar) {
        zzuv zzuvVar2 = (zzuv) this.zzd.putIfAbsent(cls, zzuvVar);
        return zzuvVar2 != null ? zzuvVar2 : zzuvVar;
    }

    private static zzuw zze(Class cls) {
        return (zzuw) cls.getAnnotation(zzuw.class);
    }

    private static Object zzf(zzvw zzvwVar, Class cls) {
        return zzvwVar.zza(zzaao.zza(cls)).zza();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuv
    public final zzuu zza(zztx zztxVar, zzaao zzaaoVar) {
        zzuw zzuwVarZze = zze(zzaaoVar.zzc());
        if (zzuwVarZze == null) {
            return null;
        }
        return zzb(this.zzc, zztxVar, zzaaoVar, zzuwVarZze, true);
    }

    public final zzuu zzb(zzvw zzvwVar, zztx zztxVar, zzaao zzaaoVar, zzuw zzuwVar, boolean z) {
        zzuj zzujVar;
        zzuu zzuuVarZza;
        Object objZzf = zzf(zzvwVar, zzuwVar.zza());
        boolean z2 = objZzf instanceof zzuu;
        boolean zZzb = zzuwVar.zzb();
        if (z2) {
            zzuuVarZza = (zzuu) objZzf;
        } else if (objZzf instanceof zzuv) {
            zzuv zzuvVarZzd = (zzuv) objZzf;
            if (z) {
                zzuvVarZzd = zzd(zzaaoVar.zzc(), zzuvVarZzd);
            }
            zzuuVarZza = zzuvVarZzd.zza(zztxVar, zzaaoVar);
        } else {
            if (objZzf instanceof zzuj) {
                zzujVar = (zzuj) objZzf;
            } else {
                if (!(objZzf instanceof zzub)) {
                    throw new IllegalArgumentException(b.m("Invalid attempt to bind an instance of ", objZzf.getClass().getName(), " as a @JsonAdapter for ", zzaaoVar.toString(), ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer."));
                }
                zzujVar = null;
            }
            zzyg zzygVar = new zzyg(zzujVar, objZzf instanceof zzub ? (zzub) objZzf : null, zztxVar, zzaaoVar, z ? zza : zzb, zZzb);
            zZzb = false;
            zzuuVarZza = zzygVar;
        }
        return (zzuuVarZza == null || !zZzb) ? zzuuVarZza : zzuuVarZza.nullSafe();
    }

    public final boolean zzc(zzaao zzaaoVar, zzuv zzuvVar) {
        Objects.requireNonNull(zzaaoVar);
        Objects.requireNonNull(zzuvVar);
        if (zzuvVar == zza) {
            return true;
        }
        Class clsZzc = zzaaoVar.zzc();
        zzuv zzuvVar2 = (zzuv) this.zzd.get(clsZzc);
        if (zzuvVar2 != null) {
            return zzuvVar2 == zzuvVar;
        }
        zzuw zzuwVarZze = zze(clsZzc);
        if (zzuwVarZze == null) {
            return false;
        }
        Class clsZza = zzuwVarZze.zza();
        return zzuv.class.isAssignableFrom(clsZza) && zzd(clsZzc, (zzuv) zzf(this.zzc, clsZza)) == zzuvVar;
    }
}
