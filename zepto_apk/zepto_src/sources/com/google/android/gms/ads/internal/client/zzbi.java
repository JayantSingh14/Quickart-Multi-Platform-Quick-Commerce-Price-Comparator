package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzbcb;
import com.google.android.gms.internal.ads.zzbcd;

/* loaded from: classes4.dex */
public final class zzbi extends zzbcb implements zzbk {
    public zzbi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdListener");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void l(int i2) {
        Parcel parcelG = g();
        parcelG.writeInt(i2);
        j1(2, parcelG);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void t0(zze zzeVar) {
        Parcel parcelG = g();
        zzbcd.c(parcelG, zzeVar);
        j1(8, parcelG);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzb() {
        j1(1, g());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zze() {
        j1(3, g());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzf() {
        j1(4, g());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzg() {
        j1(5, g());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzh() {
        j1(6, g());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzi() {
        j1(9, g());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzj() {
        j1(7, g());
    }
}
