package com.google.android.gms.internal.ads;

import android.os.Parcel;

/* loaded from: classes4.dex */
public final class zzbyl extends zzbcb implements zzbyn {
    @Override // com.google.android.gms.internal.ads.zzbyn
    public final void Ea(zzbza zzbzaVar, zzbyr zzbyrVar) {
        Parcel parcelG = g();
        zzbcd.c(parcelG, zzbzaVar);
        zzbcd.e(parcelG, zzbyrVar);
        j1(5, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbyn
    public final void I9(zzbza zzbzaVar, zzbyr zzbyrVar) {
        Parcel parcelG = g();
        zzbcd.c(parcelG, zzbzaVar);
        zzbcd.e(parcelG, zzbyrVar);
        j1(6, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbyn
    public final void Vb(String str, zzbyr zzbyrVar) {
        Parcel parcelG = g();
        parcelG.writeString(str);
        zzbcd.e(parcelG, zzbyrVar);
        j1(7, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbyn
    public final void r3(zzbza zzbzaVar, zzbyr zzbyrVar) {
        Parcel parcelG = g();
        zzbcd.c(parcelG, zzbzaVar);
        zzbcd.e(parcelG, zzbyrVar);
        j1(4, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbyn
    public final void zzi(String str) {
        Parcel parcelG = g();
        parcelG.writeString(str);
        j1(9, parcelG);
    }
}
