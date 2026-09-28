package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLongArray;

/* loaded from: classes3.dex */
final class zztv extends zzuu {
    final /* synthetic */ zzuu zza;

    public zztv(zzuu zzuuVar) {
        this.zza = zzuuVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ Object read(zzaaq zzaaqVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        zzaaqVar.zzi();
        while (zzaaqVar.zzp()) {
            arrayList.add(Long.valueOf(((Number) this.zza.read(zzaaqVar)).longValue()));
        }
        zzaaqVar.zzk();
        int size = arrayList.size();
        AtomicLongArray atomicLongArray = new AtomicLongArray(size);
        for (int i2 = 0; i2 < size; i2++) {
            atomicLongArray.set(i2, ((Long) arrayList.get(i2)).longValue());
        }
        return atomicLongArray;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ void write(zzaas zzaasVar, Object obj) throws IOException {
        AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
        zzaasVar.zzb();
        int length = atomicLongArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            this.zza.write(zzaasVar, Long.valueOf(atomicLongArray.get(i2)));
        }
        zzaasVar.zzd();
    }
}
