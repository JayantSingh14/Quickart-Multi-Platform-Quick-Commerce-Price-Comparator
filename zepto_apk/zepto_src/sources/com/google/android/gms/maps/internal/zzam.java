package com.google.android.gms.maps.internal;

import android.os.Parcel;
import com.google.android.gms.maps.model.LatLng;

/* loaded from: classes4.dex */
public abstract class zzam extends com.google.android.gms.internal.maps.zzb implements zzan {
    public zzam() {
        super("com.google.android.gms.maps.internal.IOnMapClickListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 != 1) {
            return false;
        }
        LatLng latLng = (LatLng) com.google.android.gms.internal.maps.zzc.a(parcel, LatLng.CREATOR);
        com.google.android.gms.internal.maps.zzc.b(parcel);
        D0(latLng);
        parcel2.writeNoException();
        return true;
    }
}
