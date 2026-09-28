package com.google.android.gms.maps.internal;

import android.os.Parcel;
import com.google.android.gms.maps.model.PointOfInterest;

/* loaded from: classes4.dex */
public abstract class zzbe extends com.google.android.gms.internal.maps.zzb implements zzbf {
    public zzbe() {
        super("com.google.android.gms.maps.internal.IOnPoiClickListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 != 1) {
            return false;
        }
        PointOfInterest pointOfInterest = (PointOfInterest) com.google.android.gms.internal.maps.zzc.a(parcel, PointOfInterest.CREATOR);
        com.google.android.gms.internal.maps.zzc.b(parcel);
        R1(pointOfInterest);
        parcel2.writeNoException();
        return true;
    }
}
