package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;
import java.io.IOException;

/* loaded from: classes3.dex */
final class zzzn extends zzuu {
    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ Object read(zzaaq zzaaqVar) throws IOException {
        if (zzaaqVar.zzr() == 9) {
            zzaaqVar.zzm();
            return null;
        }
        try {
            int iZzb = zzaaqVar.zzb();
            if (iZzb > 65535 || iZzb < -32768) {
                throw new zzuk(b.h(iZzb, "Lossy conversion from ", " to short; at path ", zzaaqVar.zzf()));
            }
            return Short.valueOf((short) iZzb);
        } catch (NumberFormatException e2) {
            throw new zzuk(e2);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ void write(zzaas zzaasVar, Object obj) throws IOException {
        if (((Number) obj) == null) {
            zzaasVar.zzg();
        } else {
            zzaasVar.zzi(r4.shortValue());
        }
    }
}
