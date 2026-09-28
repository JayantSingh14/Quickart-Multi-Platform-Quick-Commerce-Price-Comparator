package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* loaded from: classes3.dex */
final class zzyi extends zzuu {
    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ Object read(zzaaq zzaaqVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        zzaaqVar.zzi();
        while (zzaaqVar.zzp()) {
            try {
                arrayList.add(Integer.valueOf(zzaaqVar.zzb()));
            } catch (NumberFormatException e2) {
                throw new zzuk(e2);
            }
        }
        zzaaqVar.zzk();
        int size = arrayList.size();
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
        for (int i2 = 0; i2 < size; i2++) {
            atomicIntegerArray.set(i2, ((Integer) arrayList.get(i2)).intValue());
        }
        return atomicIntegerArray;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ void write(zzaas zzaasVar, Object obj) throws IOException {
        zzaasVar.zzb();
        int length = ((AtomicIntegerArray) obj).length();
        for (int i2 = 0; i2 < length; i2++) {
            zzaasVar.zzi(r6.get(i2));
        }
        zzaasVar.zzd();
    }
}
