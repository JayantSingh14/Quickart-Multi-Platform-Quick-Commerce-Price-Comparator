package com.google.ads.interactivemedia.v3.internal;

import java.util.Date;

/* loaded from: classes3.dex */
final class zzxb implements zzuv {
    public final String toString() {
        return "DefaultDateTypeAdapter#DEFAULT_STYLE_FACTORY";
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuv
    public final zzuu zza(zztx zztxVar, zzaao zzaaoVar) {
        if (zzaaoVar.zzc() == Date.class) {
            return new zzxf(zzxd.zza, 2, 2, null);
        }
        return null;
    }
}
