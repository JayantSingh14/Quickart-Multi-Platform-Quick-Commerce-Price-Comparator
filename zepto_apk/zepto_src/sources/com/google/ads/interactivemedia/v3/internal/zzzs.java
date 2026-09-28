package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
final class zzzs extends zzuu {
    private final Map zza = new HashMap();
    private final Map zzb = new HashMap();
    private final Map zzc = new HashMap();

    public zzzs(Class cls) {
        try {
            for (Field field : (Field[]) AccessController.doPrivileged(new zzzr(this, cls))) {
                Enum r4 = (Enum) field.get(null);
                String strName = r4.name();
                String string = r4.toString();
                zzux zzuxVar = (zzux) field.getAnnotation(zzux.class);
                if (zzuxVar != null) {
                    strName = zzuxVar.zza();
                    for (String str : zzuxVar.zzb()) {
                        this.zza.put(str, r4);
                    }
                }
                this.zza.put(strName, r4);
                this.zzb.put(string, r4);
                this.zzc.put(r4, strName);
            }
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ Object read(zzaaq zzaaqVar) throws IOException {
        if (zzaaqVar.zzr() == 9) {
            zzaaqVar.zzm();
            return null;
        }
        String strZzh = zzaaqVar.zzh();
        Enum r0 = (Enum) this.zza.get(strZzh);
        return r0 != null ? r0 : (Enum) this.zzb.get(strZzh);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzuu
    public final /* bridge */ /* synthetic */ void write(zzaas zzaasVar, Object obj) throws IOException {
        Enum r3 = (Enum) obj;
        zzaasVar.zzl(r3 == null ? null : (String) this.zzc.get(r3));
    }
}
