package com.google.ads.interactivemedia.v3.internal;

import java.sql.Timestamp;
import java.util.Date;

/* loaded from: classes3.dex */
final class zzaai implements zzuv {
    @Override // com.google.ads.interactivemedia.v3.internal.zzuv
    public final zzuu zza(zztx zztxVar, zzaao zzaaoVar) {
        if (zzaaoVar.zzc() == Timestamp.class) {
            return new zzaak(zztxVar.zza(zzaao.zza(Date.class)), null);
        }
        return null;
    }
}
