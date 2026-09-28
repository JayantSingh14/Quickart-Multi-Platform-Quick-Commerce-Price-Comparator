package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes4.dex */
public final class zzcad extends zzbcb implements zzcaf {
    public zzcad(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final void I5(com.google.android.gms.ads.internal.client.zzm zzmVar, zzcam zzcamVar) {
        Parcel parcelG = g();
        zzbcd.c(parcelG, zzmVar);
        zzbcd.e(parcelG, zzcamVar);
        j1(1, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final void N(IObjectWrapper iObjectWrapper) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        j1(5, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final void a5(com.google.android.gms.ads.internal.client.zzm zzmVar, zzcam zzcamVar) {
        Parcel parcelG = g();
        zzbcd.c(parcelG, zzmVar);
        zzbcd.e(parcelG, zzcamVar);
        j1(14, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final void q5(zzcai zzcaiVar) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, zzcaiVar);
        j1(2, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzcaf
    public final com.google.android.gms.ads.internal.client.zzea zzm() {
        Parcel parcelZ0 = z0(12, g());
        com.google.android.gms.ads.internal.client.zzea zzeaVarXb = com.google.android.gms.ads.internal.client.zzdz.Xb(parcelZ0.readStrongBinder());
        parcelZ0.recycle();
        return zzeaVarXb;
    }
}
