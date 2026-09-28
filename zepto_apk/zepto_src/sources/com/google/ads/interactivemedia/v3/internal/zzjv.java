package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public abstract class zzjv implements Callable {
    protected final String zza = getClass().getSimpleName();
    protected final zzih zzb;
    protected final String zzc;
    protected final String zzd;
    protected final zzaf zze;
    protected Method zzf;
    protected final int zzg;
    protected final int zzh;

    public zzjv(zzih zzihVar, String str, String str2, zzaf zzafVar, int i2, int i3) {
        this.zzb = zzihVar;
        this.zzc = str;
        this.zzd = str2;
        this.zze = zzafVar;
        this.zzg = i2;
        this.zzh = i3;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() throws Exception {
        zzd();
        return null;
    }

    public abstract void zza() throws IllegalAccessException, InvocationTargetException;

    public Void zzd() throws Exception {
        int i2;
        try {
            long jNanoTime = System.nanoTime();
            Method methodZzj = this.zzb.zzj(this.zzc, this.zzd);
            this.zzf = methodZzj;
            if (methodZzj == null) {
                return null;
            }
            zza();
            zzgy zzgyVarZzd = this.zzb.zzd();
            if (zzgyVarZzd == null || (i2 = this.zzg) == Integer.MIN_VALUE) {
                return null;
            }
            zzgyVarZzd.zzc(this.zzh, i2, (System.nanoTime() - jNanoTime) / 1000, null, null);
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }
}
