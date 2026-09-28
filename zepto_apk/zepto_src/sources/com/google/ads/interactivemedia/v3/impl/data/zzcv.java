package com.google.ads.interactivemedia.v3.impl.data;

import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.internal.zzaaq;
import com.google.ads.interactivemedia.v3.internal.zzaas;
import com.google.ads.interactivemedia.v3.internal.zzuu;
import java.io.IOException;

/* loaded from: classes3.dex */
final class zzcv extends zzuu {
    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    @Nullable
    public zzcw read(zzaaq zzaaqVar) throws IOException {
        if (zzaaqVar.zzr() != 9) {
            return new zzcw(zzaaqVar.zzh());
        }
        zzaaqVar.zzm();
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public void write(zzaas zzaasVar, zzcw zzcwVar) throws IOException {
        if (zzcwVar == null) {
            zzaasVar.zzg();
        } else {
            zzaasVar.zzl(zzcwVar.getName());
        }
    }
}
