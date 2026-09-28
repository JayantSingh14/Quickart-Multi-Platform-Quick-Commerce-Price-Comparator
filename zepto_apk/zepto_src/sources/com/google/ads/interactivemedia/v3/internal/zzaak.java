package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/* loaded from: classes3.dex */
final class zzaak extends zzuu {
    static final zzuv zza = new zzaai();
    private final zzuu zzb;

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ Object read(zzaaq zzaaqVar) throws IOException {
        Date date = (Date) this.zzb.read(zzaaqVar);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* synthetic */ void write(zzaas zzaasVar, Object obj) throws IOException {
        this.zzb.write(zzaasVar, (Timestamp) obj);
    }
}
