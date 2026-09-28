package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: classes3.dex */
final class zzut extends zzuu {
    final /* synthetic */ zzuu zza;

    public zzut(zzuu zzuuVar) {
        this.zza = zzuuVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final Object read(zzaaq zzaaqVar) throws IOException {
        if (zzaaqVar.zzr() != 9) {
            return this.zza.read(zzaaqVar);
        }
        zzaaqVar.zzm();
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final void write(zzaas zzaasVar, Object obj) throws IOException {
        if (obj == null) {
            zzaasVar.zzg();
        } else {
            this.zza.write(zzaasVar, obj);
        }
    }
}
