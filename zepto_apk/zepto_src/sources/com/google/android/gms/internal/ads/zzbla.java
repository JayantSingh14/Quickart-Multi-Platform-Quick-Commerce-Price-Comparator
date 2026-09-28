package com.google.android.gms.internal.ads;

import android.os.Parcel;

/* loaded from: classes4.dex */
public final class zzbla extends zzbcb implements zzblc {
    @Override // com.google.android.gms.internal.ads.zzblc
    public final void K7(zzbks zzbksVar, String str) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, zzbksVar);
        parcelG.writeString(str);
        j1(1, parcelG);
    }
}
