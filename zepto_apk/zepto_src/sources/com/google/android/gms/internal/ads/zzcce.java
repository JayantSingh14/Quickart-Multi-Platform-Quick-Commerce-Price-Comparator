package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;

/* loaded from: classes4.dex */
public final class zzcce extends zzbcb implements zzccg {
    @Override // com.google.android.gms.internal.ads.zzccg
    public final void G2(String str, String str2, Bundle bundle) {
        Parcel parcelG = g();
        parcelG.writeString(str);
        parcelG.writeString(str2);
        zzbcd.c(parcelG, bundle);
        j1(3, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzccg
    public final void b(String str) {
        Parcel parcelG = g();
        parcelG.writeString(str);
        j1(2, parcelG);
    }
}
