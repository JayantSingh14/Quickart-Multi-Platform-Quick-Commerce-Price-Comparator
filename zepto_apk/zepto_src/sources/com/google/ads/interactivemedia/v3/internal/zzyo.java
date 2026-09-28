package com.google.ads.interactivemedia.v3.internal;

import androidx.fragment.app.e;
import java.io.IOException;
import java.math.BigDecimal;

/* loaded from: classes3.dex */
final class zzyo extends zzuu {
    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ Object read(zzaaq zzaaqVar) throws IOException {
        if (zzaaqVar.zzr() == 9) {
            zzaaqVar.zzm();
            return null;
        }
        String strZzh = zzaaqVar.zzh();
        try {
            return zzwk.zza(strZzh);
        } catch (NumberFormatException e2) {
            throw new zzuk(e.p("Failed parsing '", strZzh, "' as BigDecimal; at path ", zzaaqVar.zzf()), e2);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* synthetic */ void write(zzaas zzaasVar, Object obj) throws IOException {
        zzaasVar.zzk((BigDecimal) obj);
    }
}
