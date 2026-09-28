package com.google.android.gms.internal.ads;

import android.os.Parcel;

/* loaded from: classes4.dex */
public final class zzcag extends zzbcb implements zzcai {
    @Override // com.google.android.gms.internal.ads.zzcai
    public final void L5(com.google.android.gms.ads.internal.client.zze zzeVar) {
        Parcel parcelG = g();
        zzbcd.c(parcelG, zzeVar);
        j1(5, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzcai
    public final void e7(zzcac zzcacVar) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, zzcacVar);
        j1(3, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzcai
    public final void zze() {
        j1(1, g());
    }

    @Override // com.google.android.gms.internal.ads.zzcai
    public final void zzf() {
        j1(2, g());
    }

    @Override // com.google.android.gms.internal.ads.zzcai
    public final void zzh(int i2) {
        Parcel parcelG = g();
        parcelG.writeInt(i2);
        j1(4, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzcai
    public final void zzj() {
        j1(6, g());
    }

    @Override // com.google.android.gms.internal.ads.zzcai
    public final void zzk() {
        j1(7, g());
    }
}
