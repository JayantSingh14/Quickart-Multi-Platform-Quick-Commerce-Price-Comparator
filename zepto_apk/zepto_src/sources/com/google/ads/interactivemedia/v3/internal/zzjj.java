package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public final class zzjj extends zzjv {
    public zzjj(zzih zzihVar, String str, String str2, zzaf zzafVar, int i2, int i3) {
        super(zzihVar, "WfvM4SeNDVyFarUKUVpVTE2MRQkjnaN4GpgwC5lMrmyQkCennlTSSkgCAZvzOVXK", "Kq6mcF8LH4HqXGyg5/DR3VvLtDExNTPXoCRIPhkdOGM=", zzafVar, i2, 3);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzjv
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        Boolean bool = (Boolean) zzkq.zzc().zza(zzlg.zzcD);
        bool.booleanValue();
        zzhn zzhnVar = new zzhn((String) this.zzf.invoke(null, this.zzb.zzb(), bool));
        synchronized (this.zze) {
            this.zze.zzj(zzhnVar.zza);
            this.zze.zzC(zzhnVar.zzb);
        }
    }
}
