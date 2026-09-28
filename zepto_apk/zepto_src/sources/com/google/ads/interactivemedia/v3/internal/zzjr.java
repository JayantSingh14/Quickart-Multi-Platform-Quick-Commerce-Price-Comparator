package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public final class zzjr extends zzjv {
    public zzjr(zzih zzihVar, String str, String str2, zzaf zzafVar, int i2, int i3) {
        super(zzihVar, "5HcA415u1KU8m2yVlDZBhQQK+0IFNRmmWPxuAq0DnfPzSdJ/uWlnYMD1kKfkH6cZ", "u7Ufq5yuXkEXg69T8jpWuOOX55Q9g2DSVI1gtbNUvY8=", zzafVar, i2, 48);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzjv
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzag(3);
        boolean zBooleanValue = ((Boolean) this.zzf.invoke(null, this.zzb.zzb())).booleanValue();
        synchronized (this.zze) {
            try {
                if (zBooleanValue) {
                    this.zze.zzag(2);
                } else {
                    this.zze.zzag(1);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
