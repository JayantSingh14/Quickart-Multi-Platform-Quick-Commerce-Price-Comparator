package com.google.ads.interactivemedia.v3.internal;

import androidx.fragment.app.e;
import java.io.IOException;

/* loaded from: classes3.dex */
final class zzzi extends zzuu {
    final /* synthetic */ Class zza;
    final /* synthetic */ zzzj zzb;

    public zzzi(zzzj zzzjVar, Class cls) {
        this.zza = cls;
        this.zzb = zzzjVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final Object read(zzaaq zzaaqVar) throws IOException {
        Object obj = this.zzb.zzb.read(zzaaqVar);
        if (obj == null || this.zza.isInstance(obj)) {
            return obj;
        }
        Class cls = this.zza;
        Class<?> cls2 = obj.getClass();
        String name = cls.getName();
        String name2 = cls2.getName();
        String strZzf = zzaaqVar.zzf();
        StringBuilder sbV = e.v("Expected a ", name, " but was ", name2, "; at path ");
        sbV.append(strZzf);
        throw new zzuk(sbV.toString());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final void write(zzaas zzaasVar, Object obj) throws IOException {
        this.zzb.zzb.write(zzaasVar, obj);
    }
}
