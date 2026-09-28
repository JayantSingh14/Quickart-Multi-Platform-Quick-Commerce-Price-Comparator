package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public final class zzjn extends zzjv {
    private final StackTraceElement[] zzi;

    public zzjn(zzih zzihVar, String str, String str2, zzaf zzafVar, int i2, int i3, StackTraceElement[] stackTraceElementArr) {
        super(zzihVar, "9douHjmTTjq3N4YYUdzzHaKyxIqsB5K92p8t26vKQB1HahpVak+32YHan4LmgLPE", "q6oLc2ULDKRAR1VDdX5lO9/kb0NHjx7PMACMr/7cZL8=", zzafVar, i2, 45);
        this.zzi = stackTraceElementArr;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzjv
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        StackTraceElement[] stackTraceElementArr = this.zzi;
        if (stackTraceElementArr != null) {
            zzhy zzhyVar = new zzhy((String) this.zzf.invoke(null, stackTraceElementArr));
            synchronized (this.zze) {
                try {
                    this.zze.zzF(zzhyVar.zza.longValue());
                    if (zzhyVar.zzb.booleanValue()) {
                        this.zze.zzac(true != zzhyVar.zzc.booleanValue() ? 2 : 1);
                    } else {
                        this.zze.zzac(3);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
