package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: classes3.dex */
final class zzts extends zzuu {
    public zzts(zztx zztxVar) {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ Object read(zzaaq zzaaqVar) throws IOException {
        if (zzaaqVar.zzr() != 9) {
            return Double.valueOf(zzaaqVar.zza());
        }
        zzaaqVar.zzm();
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ void write(zzaas zzaasVar, Object obj) throws IOException {
        Number number = (Number) obj;
        if (number == null) {
            zzaasVar.zzg();
            return;
        }
        double dDoubleValue = number.doubleValue();
        zztx.zzg(dDoubleValue);
        zzaasVar.zzh(dDoubleValue);
    }
}
