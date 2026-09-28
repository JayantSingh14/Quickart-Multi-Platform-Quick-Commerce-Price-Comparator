package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@VisibleForTesting
/* loaded from: classes3.dex */
final class zzmx implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {

    @VisibleForTesting
    protected final zznj zza;
    private final String zzb;
    private final String zzc;
    private final LinkedBlockingQueue zzd;
    private final HandlerThread zze;
    private final zzmo zzf;
    private final long zzg;
    private final int zzh;

    public zzmx(Context context, int i2, int i3, String str, String str2, String str3, zzmo zzmoVar) {
        this.zzb = str;
        this.zzh = i3;
        this.zzc = str2;
        this.zzf = zzmoVar;
        HandlerThread handlerThread = new HandlerThread("GassDGClient");
        this.zze = handlerThread;
        handlerThread.start();
        this.zzg = System.currentTimeMillis();
        zznj zznjVar = new zznj(context, handlerThread.getLooper(), this, this, 19621000);
        this.zza = zznjVar;
        this.zzd = new LinkedBlockingQueue();
        zznjVar.checkAvailabilityAndConnect();
    }

    @VisibleForTesting
    public static zznv zza() {
        return new zznv(null, 1);
    }

    private final void zze(int i2, long j2, Exception exc) {
        this.zzf.zzc(i2, System.currentTimeMillis() - j2, exc);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzno zznoVarZzd = zzd();
        if (zznoVarZzd != null) {
            try {
                zznv zznvVarZzf = zznoVarZzd.zzf(new zznt(1, this.zzh, this.zzb, this.zzc));
                zze(5011, this.zzg, null);
                this.zzd.put(zznvVarZzf);
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) throws InterruptedException {
        try {
            zze(4012, this.zzg, null);
            this.zzd.put(zza());
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i2) throws InterruptedException {
        try {
            zze(4011, this.zzg, null);
            this.zzd.put(zza());
        } catch (InterruptedException unused) {
        }
    }

    public final zznv zzb(int i2) {
        zznv zznvVar;
        try {
            zznvVar = (zznv) this.zzd.poll(50000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            zze(2009, this.zzg, e2);
            zznvVar = null;
        }
        zze(3004, this.zzg, null);
        if (zznvVar != null) {
            if (zznvVar.zzc == 7) {
                zzmo.zzg(3);
            } else {
                zzmo.zzg(2);
            }
        }
        return zznvVar == null ? zza() : zznvVar;
    }

    public final void zzc() {
        zznj zznjVar = this.zza;
        if (zznjVar != null) {
            if (zznjVar.isConnected() || this.zza.isConnecting()) {
                this.zza.disconnect();
            }
        }
    }

    public final zzno zzd() {
        try {
            return this.zza.zzp();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }
}
