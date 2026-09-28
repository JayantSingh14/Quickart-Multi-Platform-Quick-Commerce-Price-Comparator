package com.google.ads.interactivemedia.v3.internal;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/* loaded from: classes3.dex */
public final class zziz extends zzjv {
    public zziz(zzih zzihVar, String str, String str2, zzaf zzafVar, int i2, int i3) {
        super(zzihVar, "FLgp79R6LGLnWDio6G1XBjsjORgKSjLkdakyn5bigQludVyQtVZMhDAlppvakfKf", "oPDFFWKd1EuWWR8iem/Fb2LK/5grpy+LhaDBlMcgIHs=", zzafVar, i2, 24);
    }

    private final void zzc() throws ExecutionException, InterruptedException, TimeoutException {
        AdvertisingIdClient advertisingIdClientZzh = this.zzb.zzh();
        if (advertisingIdClientZzh == null) {
            return;
        }
        try {
            AdvertisingIdClient.Info infoF = advertisingIdClientZzh.f();
            String strZza = infoF.f21070a;
            int i2 = zzik.zza;
            if (strZza != null && strZza.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
                UUID uuidFromString = UUID.fromString(strZza);
                byte[] bArr = new byte[16];
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
                byteBufferWrap.putLong(uuidFromString.getMostSignificantBits());
                byteBufferWrap.putLong(uuidFromString.getLeastSignificantBits());
                strZza = zzfo.zza(bArr, true);
            }
            if (strZza != null) {
                synchronized (this.zze) {
                    this.zze.zzs(strZza);
                    this.zze.zzr(infoF.f21071b);
                    this.zze.zzab(6);
                }
            }
        } catch (IOException unused) {
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzjv, java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzd();
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzjv
    public final void zza() throws ExecutionException, IllegalAccessException, InterruptedException, TimeoutException, InvocationTargetException {
        if (this.zzb.zzq()) {
            zzc();
            return;
        }
        synchronized (this.zze) {
            this.zze.zzs((String) this.zzf.invoke(null, this.zzb.zzb()));
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzjv
    public final Void zzd() throws Exception {
        if (this.zzb.zzr()) {
            super.zzd();
            return null;
        }
        if (this.zzb.zzq()) {
            zzc();
        }
        return null;
    }
}
