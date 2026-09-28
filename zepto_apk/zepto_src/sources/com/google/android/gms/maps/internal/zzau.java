package com.google.android.gms.maps.internal;

import android.os.Parcel;

/* loaded from: classes4.dex */
public abstract class zzau extends com.google.android.gms.internal.maps.zzb implements zzav {
    public zzau() {
        super("com.google.android.gms.maps.internal.IOnMarkerClickListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 != 1) {
            return false;
        }
        com.google.android.gms.internal.maps.zzad zzadVarZ0 = com.google.android.gms.internal.maps.zzac.z0(parcel.readStrongBinder());
        com.google.android.gms.internal.maps.zzc.b(parcel);
        boolean zD = d(zzadVarZ0);
        parcel2.writeNoException();
        parcel2.writeInt(zD ? 1 : 0);
        return true;
    }
}
