package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;

/* loaded from: classes4.dex */
public final class zzgnf extends zzbcb implements zzgnh {
    @Override // com.google.android.gms.internal.ads.zzgnh
    public final void Sa(Bundle bundle, zzgnj zzgnjVar) {
        Parcel parcelG = g();
        zzbcd.c(parcelG, bundle);
        zzbcd.e(parcelG, zzgnjVar);
        w1(3, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzgnh
    public final void T4(String str, Bundle bundle, zzgnj zzgnjVar) {
        Parcel parcelG = g();
        parcelG.writeString(str);
        zzbcd.c(parcelG, bundle);
        zzbcd.e(parcelG, zzgnjVar);
        w1(1, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzgnh
    public final void m2(Bundle bundle, zzgnj zzgnjVar) {
        Parcel parcelG = g();
        zzbcd.c(parcelG, bundle);
        zzbcd.e(parcelG, zzgnjVar);
        w1(2, parcelG);
    }
}
