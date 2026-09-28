package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes4.dex */
public final class zzcak extends zzbcb implements zzcam {
    public zzcak(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void a(com.google.android.gms.ads.internal.client.zze zzeVar) {
        Parcel parcelG = g();
        zzbcd.c(parcelG, zzeVar);
        j1(3, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zze() {
        j1(1, g());
    }

    @Override // com.google.android.gms.internal.ads.zzcam
    public final void zzf(int i2) {
        Parcel parcelG = g();
        parcelG.writeInt(i2);
        j1(2, parcelG);
    }
}
