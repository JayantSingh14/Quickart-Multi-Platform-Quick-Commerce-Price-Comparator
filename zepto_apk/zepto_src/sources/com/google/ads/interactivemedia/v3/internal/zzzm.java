package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;
import java.io.IOException;

/* loaded from: classes3.dex */
final class zzzm extends zzuu {
    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ Object read(zzaaq zzaaqVar) throws IOException {
        if (zzaaqVar.zzr() == 9) {
            zzaaqVar.zzm();
            return null;
        }
        try {
            int iZzb = zzaaqVar.zzb();
            if (iZzb > 255 || iZzb < -128) {
                throw new zzuk(b.h(iZzb, "Lossy conversion from ", " to byte; at path ", zzaaqVar.zzf()));
            }
            return Byte.valueOf((byte) iZzb);
        } catch (NumberFormatException e2) {
            throw new zzuk(e2);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ void write(zzaas zzaasVar, Object obj) throws IOException {
        if (((Number) obj) == null) {
            zzaasVar.zzg();
        } else {
            zzaasVar.zzi(r4.byteValue());
        }
    }
}
