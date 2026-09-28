package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: classes3.dex */
final class zzzo extends zzuu {
    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ Object read(zzaaq zzaaqVar) throws IOException {
        if (zzaaqVar.zzr() == 9) {
            zzaaqVar.zzm();
            return null;
        }
        try {
            return Integer.valueOf(zzaaqVar.zzb());
        } catch (NumberFormatException e2) {
            throw new zzuk(e2);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ void write(zzaas zzaasVar, Object obj) throws IOException {
        if (((Number) obj) == null) {
            zzaasVar.zzg();
        } else {
            zzaasVar.zzi(r4.intValue());
        }
    }
}
