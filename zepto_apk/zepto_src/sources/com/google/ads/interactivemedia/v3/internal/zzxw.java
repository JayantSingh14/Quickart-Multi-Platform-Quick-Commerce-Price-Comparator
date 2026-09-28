package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class zzxw<T, A> extends zzuu<T> {
    private final zzxz zza;

    public zzxw(zzxz zzxzVar) {
        this.zza = zzxzVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final T read(zzaaq zzaaqVar) throws IOException {
        if (zzaaqVar.zzr() == 9) {
            zzaaqVar.zzm();
            return null;
        }
        Object objZza = zza();
        Map map = this.zza.zzb;
        try {
            zzaaqVar.zzj();
            while (zzaaqVar.zzp()) {
                zzxx zzxxVar = (zzxx) map.get(zzaaqVar.zzg());
                if (zzxxVar == null) {
                    zzaaqVar.zzo();
                } else {
                    zzc(objZza, zzaaqVar, zzxxVar);
                }
            }
            zzaaqVar.zzl();
            return (T) zzb(objZza);
        } catch (IllegalAccessException e2) {
            throw zzaab.zzb(e2);
        } catch (IllegalStateException e3) {
            throw new zzuk(e3);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final void write(zzaas zzaasVar, T t) throws IOException {
        if (t == null) {
            zzaasVar.zzg();
            return;
        }
        zzaasVar.zzc();
        try {
            Iterator it = this.zza.zzc.iterator();
            while (it.hasNext()) {
                ((zzxx) it.next()).zzc(zzaasVar, t);
            }
            zzaasVar.zze();
        } catch (IllegalAccessException e2) {
            throw zzaab.zzb(e2);
        }
    }

    public abstract Object zza();

    public abstract Object zzb(Object obj);

    public abstract void zzc(Object obj, zzaaq zzaaqVar, zzxx zzxxVar) throws IllegalAccessException, IOException;
}
