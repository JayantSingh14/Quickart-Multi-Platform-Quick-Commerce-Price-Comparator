package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes3.dex */
final class zzwz extends zzuu {
    private final zzuu zza;
    private final zzwl zzb;

    public zzwz(zztx zztxVar, Type type, zzuu zzuuVar, zzwl zzwlVar) {
        this.zza = new zzyh(zztxVar, zzuuVar, type);
        this.zzb = zzwlVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ Object read(zzaaq zzaaqVar) throws IOException {
        if (zzaaqVar.zzr() == 9) {
            zzaaqVar.zzm();
            return null;
        }
        Collection collection = (Collection) this.zzb.zza();
        zzaaqVar.zzi();
        while (zzaaqVar.zzp()) {
            collection.add(this.zza.read(zzaaqVar));
        }
        zzaaqVar.zzk();
        return collection;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ void write(zzaas zzaasVar, Object obj) throws IOException {
        Collection collection = (Collection) obj;
        if (collection == null) {
            zzaasVar.zzg();
            return;
        }
        zzaasVar.zzb();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            this.zza.write(zzaasVar, it.next());
        }
        zzaasVar.zzd();
    }
}
