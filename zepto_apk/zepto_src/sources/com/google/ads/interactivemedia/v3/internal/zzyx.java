package com.google.ads.interactivemedia.v3.internal;

import androidx.fragment.app.e;
import java.io.IOException;
import java.util.UUID;

/* loaded from: classes3.dex */
final class zzyx extends zzuu {
    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ Object read(zzaaq zzaaqVar) throws IOException {
        if (zzaaqVar.zzr() == 9) {
            zzaaqVar.zzm();
            return null;
        }
        String strZzh = zzaaqVar.zzh();
        try {
            return UUID.fromString(strZzh);
        } catch (IllegalArgumentException e2) {
            throw new zzuk(e.p("Failed parsing '", strZzh, "' as UUID; at path ", zzaaqVar.zzf()), e2);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ void write(zzaas zzaasVar, Object obj) throws IOException {
        UUID uuid = (UUID) obj;
        zzaasVar.zzl(uuid == null ? null : uuid.toString());
    }
}
