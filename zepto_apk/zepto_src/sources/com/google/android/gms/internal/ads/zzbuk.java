package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes4.dex */
public final class zzbuk extends zzbcb implements zzbum {
    public zzbuk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbum
    public final void a(com.google.android.gms.ads.internal.client.zze zzeVar) {
        Parcel parcelG = g();
        zzbcd.c(parcelG, zzeVar);
        j1(3, parcelG);
    }
}
