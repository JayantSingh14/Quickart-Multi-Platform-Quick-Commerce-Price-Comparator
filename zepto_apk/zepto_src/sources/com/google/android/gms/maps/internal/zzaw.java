package com.google.android.gms.maps.internal;

import android.os.Parcel;

/* loaded from: classes4.dex */
public abstract class zzaw extends com.google.android.gms.internal.maps.zzb implements zzax {
    public zzaw() {
        super("com.google.android.gms.maps.internal.IOnMarkerDragListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 == 1) {
            com.google.android.gms.internal.maps.zzad zzadVarZ0 = com.google.android.gms.internal.maps.zzac.z0(parcel.readStrongBinder());
            com.google.android.gms.internal.maps.zzc.b(parcel);
            sa(zzadVarZ0);
        } else if (i2 == 2) {
            com.google.android.gms.internal.maps.zzad zzadVarZ02 = com.google.android.gms.internal.maps.zzac.z0(parcel.readStrongBinder());
            com.google.android.gms.internal.maps.zzc.b(parcel);
            d(zzadVarZ02);
        } else {
            if (i2 != 3) {
                return false;
            }
            com.google.android.gms.internal.maps.zzad zzadVarZ03 = com.google.android.gms.internal.maps.zzac.z0(parcel.readStrongBinder());
            com.google.android.gms.internal.maps.zzc.b(parcel);
            q0(zzadVarZ03);
        }
        parcel2.writeNoException();
        return true;
    }
}
