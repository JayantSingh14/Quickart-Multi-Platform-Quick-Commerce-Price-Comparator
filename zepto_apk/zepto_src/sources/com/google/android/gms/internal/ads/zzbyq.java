package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;

/* loaded from: classes4.dex */
public abstract class zzbyq extends zzbcc implements zzbyr {
    public zzbyq() {
        super("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 == 1) {
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zzbcd.b(parcel, ParcelFileDescriptor.CREATOR);
            zzbcd.f(parcel);
            la(parcelFileDescriptor);
        } else if (i2 == 2) {
            com.google.android.gms.ads.internal.util.zzba zzbaVar = (com.google.android.gms.ads.internal.util.zzba) zzbcd.b(parcel, com.google.android.gms.ads.internal.util.zzba.CREATOR);
            zzbcd.f(parcel);
            N7(zzbaVar);
        } else {
            if (i2 != 3) {
                return false;
            }
            ParcelFileDescriptor parcelFileDescriptor2 = (ParcelFileDescriptor) zzbcd.b(parcel, ParcelFileDescriptor.CREATOR);
            zzbza zzbzaVar = (zzbza) zzbcd.b(parcel, zzbza.CREATOR);
            zzbcd.f(parcel);
            f8(parcelFileDescriptor2, zzbzaVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
