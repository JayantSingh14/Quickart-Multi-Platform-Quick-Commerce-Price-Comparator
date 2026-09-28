package com.google.android.gms.internal.ads;

import android.os.Parcel;

/* loaded from: classes4.dex */
public final class zzbee extends zzbcb implements zzbeg {
    @Override // com.google.android.gms.internal.ads.zzbeg
    public final void gb(zzbed zzbedVar) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, zzbedVar);
        j1(1, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbeg
    public final void l(int i2) {
        Parcel parcelG = g();
        parcelG.writeInt(i2);
        j1(2, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbeg
    public final void t0(com.google.android.gms.ads.internal.client.zze zzeVar) {
        Parcel parcelG = g();
        zzbcd.c(parcelG, zzeVar);
        j1(3, parcelG);
    }
}
