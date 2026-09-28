package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

/* loaded from: classes3.dex */
final class zzxn extends zzuu {
    final /* synthetic */ zzxo zza;
    private final zzuu zzb;
    private final zzuu zzc;
    private final zzwl zzd;

    public zzxn(zzxo zzxoVar, zztx zztxVar, Type type, zzuu zzuuVar, Type type2, zzuu zzuuVar2, zzwl zzwlVar) {
        this.zza = zzxoVar;
        this.zzb = new zzyh(zztxVar, zzuuVar, type);
        this.zzc = new zzyh(zztxVar, zzuuVar2, type2);
        this.zzd = zzwlVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ Object read(zzaaq zzaaqVar) throws IOException {
        int iZzr = zzaaqVar.zzr();
        if (iZzr == 9) {
            zzaaqVar.zzm();
            return null;
        }
        Map map = (Map) this.zzd.zza();
        if (iZzr != 1) {
            zzaaqVar.zzj();
            while (zzaaqVar.zzp()) {
                zzwa.zza.zza(zzaaqVar);
                Object obj = this.zzb.read(zzaaqVar);
                if (map.put(obj, this.zzc.read(zzaaqVar)) != null) {
                    throw new zzuk("duplicate key: ".concat(String.valueOf(obj)));
                }
            }
            zzaaqVar.zzl();
            return map;
        }
        zzaaqVar.zzi();
        while (zzaaqVar.zzp()) {
            zzaaqVar.zzi();
            Object obj2 = this.zzb.read(zzaaqVar);
            if (map.put(obj2, this.zzc.read(zzaaqVar)) != null) {
                throw new zzuk("duplicate key: ".concat(String.valueOf(obj2)));
            }
            zzaaqVar.zzk();
        }
        zzaaqVar.zzk();
        return map;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ void write(zzaas zzaasVar, Object obj) throws IOException {
        Map map = (Map) obj;
        if (map == null) {
            zzaasVar.zzg();
            return;
        }
        zzaasVar.zzc();
        for (Map.Entry entry : map.entrySet()) {
            zzaasVar.zzf(String.valueOf(entry.getKey()));
            this.zzc.write(zzaasVar, entry.getValue());
        }
        zzaasVar.zze();
    }
}
