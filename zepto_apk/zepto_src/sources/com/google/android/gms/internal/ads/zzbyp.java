package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;

/* loaded from: classes4.dex */
public final class zzbyp extends zzbcb implements zzbyr {
    public zzbyp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbyr
    public final void N7(com.google.android.gms.ads.internal.util.zzba zzbaVar) {
        Parcel parcelG = g();
        zzbcd.c(parcelG, zzbaVar);
        j1(2, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbyr
    public final void f8(ParcelFileDescriptor parcelFileDescriptor, zzbza zzbzaVar) {
        Parcel parcelG = g();
        zzbcd.c(parcelG, parcelFileDescriptor);
        zzbcd.c(parcelG, zzbzaVar);
        j1(3, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbyr
    public final void la(ParcelFileDescriptor parcelFileDescriptor) {
        Parcel parcelG = g();
        zzbcd.c(parcelG, parcelFileDescriptor);
        j1(1, parcelG);
    }
}
