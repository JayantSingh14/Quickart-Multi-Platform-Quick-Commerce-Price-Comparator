package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class zzxt extends zzuu {
    private static final zzuv zza = new zzxr(zzur.DOUBLE);
    private final zztx zzb;
    private final zzus zzc;

    public /* synthetic */ zzxt(zztx zztxVar, zzus zzusVar, zzxs zzxsVar) {
        this.zzb = zztxVar;
        this.zzc = zzusVar;
    }

    public static zzuv zza(zzus zzusVar) {
        return zzusVar == zzur.DOUBLE ? zza : new zzxr(zzusVar);
    }

    private final Object zzb(zzaaq zzaaqVar, int i2) throws IOException {
        int i3 = i2 - 1;
        if (i3 == 5) {
            return zzaaqVar.zzh();
        }
        if (i3 == 6) {
            return this.zzc.zza(zzaaqVar);
        }
        if (i3 == 7) {
            return Boolean.valueOf(zzaaqVar.zzq());
        }
        if (i3 != 8) {
            throw new IllegalStateException("Unexpected token: ".concat(zzaar.zza(i2)));
        }
        zzaaqVar.zzm();
        return null;
    }

    private static final Object zzc(zzaaq zzaaqVar, int i2) throws IOException {
        int i3 = i2 - 1;
        if (i3 == 0) {
            zzaaqVar.zzi();
            return new ArrayList();
        }
        if (i3 != 2) {
            return null;
        }
        zzaaqVar.zzj();
        return new zzwj();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final Object read(zzaaq zzaaqVar) throws IOException {
        int iZzr = zzaaqVar.zzr();
        Object objZzc = zzc(zzaaqVar, iZzr);
        if (objZzc == null) {
            return zzb(zzaaqVar, iZzr);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (zzaaqVar.zzp()) {
                String strZzg = objZzc instanceof Map ? zzaaqVar.zzg() : null;
                int iZzr2 = zzaaqVar.zzr();
                Object objZzc2 = zzc(zzaaqVar, iZzr2);
                Object objZzb = objZzc2 == null ? zzb(zzaaqVar, iZzr2) : objZzc2;
                if (objZzc instanceof List) {
                    ((List) objZzc).add(objZzb);
                } else {
                    ((Map) objZzc).put(strZzg, objZzb);
                }
                if (objZzc2 != null) {
                    arrayDeque.addLast(objZzc);
                    objZzc = objZzb;
                }
            } else {
                if (objZzc instanceof List) {
                    zzaaqVar.zzk();
                } else {
                    zzaaqVar.zzl();
                }
                if (arrayDeque.isEmpty()) {
                    return objZzc;
                }
                objZzc = arrayDeque.removeLast();
            }
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final void write(zzaas zzaasVar, Object obj) throws IOException {
        if (obj == null) {
            zzaasVar.zzg();
            return;
        }
        zzuu zzuuVarZza = this.zzb.zza(zzaao.zza(obj.getClass()));
        if (!(zzuuVarZza instanceof zzxt)) {
            zzuuVarZza.write(zzaasVar, obj);
        } else {
            zzaasVar.zzc();
            zzaasVar.zze();
        }
    }
}
