package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public final class zziy extends zzjv {
    private final long zzi;

    public zziy(zzih zzihVar, String str, String str2, zzaf zzafVar, long j2, int i2, int i3) {
        super(zzihVar, "Rx5KxmHu63h8QT7T4cYR2mu7F4LQnYkocG/Azb9HP8ZHyjUHnRxxCuB99BIp3kbl", "3fysZeGzwX+hqd2f4+qtlSho+oF+DeFl9kzKrTFOSWo=", zzafVar, i2, 25);
        this.zzi = j2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzjv
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        long jLongValue = ((Long) this.zzf.invoke(null, null)).longValue();
        synchronized (this.zze) {
            try {
                this.zze.zzt(jLongValue);
                long j2 = this.zzi;
                if (j2 != 0) {
                    this.zze.zzT(jLongValue - j2);
                    this.zze.zzU(this.zzi);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
