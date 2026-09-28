package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes4.dex */
public final class zzbzq extends zzbcb implements zzbzs {
    public zzbzq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbzs
    public final void Ua(zzbzj zzbzjVar) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, zzbzjVar);
        j1(5, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbzs
    public final void r(int i2) {
        Parcel parcelG = g();
        parcelG.writeInt(i2);
        j1(7, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbzs
    public final void zze() {
        j1(1, g());
    }

    @Override // com.google.android.gms.internal.ads.zzbzs
    public final void zzf() {
        j1(2, g());
    }

    @Override // com.google.android.gms.internal.ads.zzbzs
    public final void zzg() {
        j1(3, g());
    }

    @Override // com.google.android.gms.internal.ads.zzbzs
    public final void zzh() {
        j1(4, g());
    }

    @Override // com.google.android.gms.internal.ads.zzbzs
    public final void zzj() {
        j1(6, g());
    }

    @Override // com.google.android.gms.internal.ads.zzbzs
    public final void zzl() {
        j1(8, g());
    }
}
