package com.google.ads.interactivemedia.v3.internal;

import android.os.RemoteException;
import android.util.Log;

/* loaded from: classes3.dex */
public final class zzod {
    final /* synthetic */ zzoe zza;
    private final byte[] zzb;
    private int zzc;
    private int zzd;

    public /* synthetic */ zzod(zzoe zzoeVar, byte[] bArr, zzoc zzocVar) {
        this.zza = zzoeVar;
        this.zzb = bArr;
    }

    public final zzod zza(int i2) {
        this.zzd = i2;
        return this;
    }

    public final zzod zzb(int i2) {
        this.zzc = i2;
        return this;
    }

    public final synchronized void zzc() {
        try {
            zzoe zzoeVar = this.zza;
            if (zzoeVar.zzb) {
                zzoeVar.zza.zzj(this.zzb);
                this.zza.zza.zzi(this.zzc);
                this.zza.zza.zzg(this.zzd);
                this.zza.zza.zzh(null);
                this.zza.zza.zzf();
            }
        } catch (RemoteException e2) {
            Log.d("GASS", "Clearcut log failed", e2);
        }
    }
}
