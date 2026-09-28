package com.google.android.gms.internal.ads;

import android.os.Parcel;

/* loaded from: classes4.dex */
public final class zzbqf extends zzbcb implements zzbqh {
    @Override // com.google.android.gms.internal.ads.zzbqh
    public final void a(com.google.android.gms.ads.internal.client.zze zzeVar) {
        Parcel parcelG = g();
        zzbcd.c(parcelG, zzeVar);
        j1(3, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbqh
    public final void tb(zzbqb zzbqbVar) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, zzbqbVar);
        j1(1, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbqh
    public final void zzf(int i2) {
        Parcel parcelG = g();
        parcelG.writeInt(i2);
        j1(2, parcelG);
    }
}
