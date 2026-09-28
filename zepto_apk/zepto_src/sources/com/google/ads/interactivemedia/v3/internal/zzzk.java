package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: classes3.dex */
final class zzzk extends zzuu {
    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ Object read(zzaaq zzaaqVar) throws IOException {
        int iZzr = zzaaqVar.zzr();
        if (iZzr != 9) {
            return iZzr == 6 ? Boolean.valueOf(Boolean.parseBoolean(zzaaqVar.zzh())) : Boolean.valueOf(zzaaqVar.zzq());
        }
        zzaaqVar.zzm();
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* synthetic */ void write(zzaas zzaasVar, Object obj) throws IOException {
        zzaasVar.zzj((Boolean) obj);
    }
}
