package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: classes3.dex */
final class zztt extends zzuu {
    public zztt(zztx zztxVar) {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ Object read(zzaaq zzaaqVar) throws IOException {
        if (zzaaqVar.zzr() != 9) {
            return Float.valueOf((float) zzaaqVar.zza());
        }
        zzaaqVar.zzm();
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ void write(zzaas zzaasVar, Object obj) throws IOException {
        Number numberValueOf = (Number) obj;
        if (numberValueOf == null) {
            zzaasVar.zzg();
            return;
        }
        float fFloatValue = numberValueOf.floatValue();
        zztx.zzg(fFloatValue);
        if (!(numberValueOf instanceof Float)) {
            numberValueOf = Float.valueOf(fFloatValue);
        }
        zzaasVar.zzk(numberValueOf);
    }
}
