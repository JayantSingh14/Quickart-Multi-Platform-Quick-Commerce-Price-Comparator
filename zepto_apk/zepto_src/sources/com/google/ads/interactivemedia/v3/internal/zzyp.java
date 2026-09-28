package com.google.ads.interactivemedia.v3.internal;

import androidx.fragment.app.e;
import java.io.IOException;
import java.math.BigInteger;

/* loaded from: classes3.dex */
final class zzyp extends zzuu {
    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ Object read(zzaaq zzaaqVar) throws IOException {
        if (zzaaqVar.zzr() == 9) {
            zzaaqVar.zzm();
            return null;
        }
        String strZzh = zzaaqVar.zzh();
        try {
            return zzwk.zzb(strZzh);
        } catch (NumberFormatException e2) {
            throw new zzuk(e.p("Failed parsing '", strZzh, "' as BigInteger; at path ", zzaaqVar.zzf()), e2);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* synthetic */ void write(zzaas zzaasVar, Object obj) throws IOException {
        zzaasVar.zzk((BigInteger) obj);
    }
}
