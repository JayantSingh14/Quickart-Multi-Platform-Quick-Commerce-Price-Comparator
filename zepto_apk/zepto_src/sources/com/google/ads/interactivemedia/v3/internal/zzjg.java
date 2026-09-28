package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public final class zzjg extends zzjv {
    private final zzhk zzi;
    private final long zzj;
    private final long zzk;

    public zzjg(zzih zzihVar, String str, String str2, zzaf zzafVar, int i2, int i3, zzhk zzhkVar, long j2, long j3) {
        super(zzihVar, "gAg/p/cQzJRjYz9LhE8cRk72DVV1Cpozf/TbzvACqLcTgM3sRjMEb3DCmwYhMmhP", "avDZD6/xoSbFYvWCy23XLncB75oD5DxKdrTKFY2O0hY=", zzafVar, i2, 11);
        this.zzi = zzhkVar;
        this.zzj = j2;
        this.zzk = j3;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzjv
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        zzhk zzhkVar = this.zzi;
        if (zzhkVar != null) {
            zzhi zzhiVar = new zzhi((String) this.zzf.invoke(null, zzhkVar.zzb(), Long.valueOf(this.zzj), Long.valueOf(this.zzk)));
            synchronized (this.zze) {
                try {
                    this.zze.zzz(zzhiVar.zza.longValue());
                    if (zzhiVar.zzb.longValue() >= 0) {
                        this.zze.zzQ(zzhiVar.zzb.longValue());
                    }
                    if (zzhiVar.zzc.longValue() >= 0) {
                        this.zze.zzf(zzhiVar.zzc.longValue());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
