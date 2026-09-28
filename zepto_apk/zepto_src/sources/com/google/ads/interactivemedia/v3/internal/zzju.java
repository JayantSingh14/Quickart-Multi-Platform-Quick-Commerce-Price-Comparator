package com.google.ads.interactivemedia.v3.internal;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class zzju {
    protected static final String zza = "zzju";
    private final zzih zzb;
    private final String zzc;
    private final String zzd;
    private final Class[] zzf;
    private volatile Method zze = null;
    private final CountDownLatch zzg = new CountDownLatch(1);

    public zzju(zzih zzihVar, String str, String str2, Class... clsArr) {
        this.zzb = zzihVar;
        this.zzc = str;
        this.zzd = str2;
        this.zzf = clsArr;
        zzihVar.zzk().submit(new zzjt(this));
    }

    public static /* bridge */ /* synthetic */ void zzb(zzju zzjuVar) {
        try {
            zzih zzihVar = zzjuVar.zzb;
            Class<?> clsLoadClass = zzihVar.zzi().loadClass(zzjuVar.zzc(zzihVar.zzu(), zzjuVar.zzc));
            if (clsLoadClass != null) {
                zzjuVar.zze = clsLoadClass.getMethod(zzjuVar.zzc(zzjuVar.zzb.zzu(), zzjuVar.zzd), zzjuVar.zzf);
            }
        } catch (zzhl | UnsupportedEncodingException | ClassNotFoundException | NoSuchMethodException | NullPointerException unused) {
        } catch (Throwable th) {
            zzjuVar.zzg.countDown();
            throw th;
        }
        zzjuVar.zzg.countDown();
    }

    private final String zzc(byte[] bArr, String str) throws zzhl, UnsupportedEncodingException {
        return new String(this.zzb.zze().zzb(bArr, str), "UTF-8");
    }

    public final Method zza() {
        if (this.zze != null) {
            return this.zze;
        }
        try {
            if (this.zzg.await(2L, TimeUnit.SECONDS)) {
                return this.zze;
            }
            return null;
        } catch (InterruptedException unused) {
            return null;
        }
    }
}
