package com.google.android.gms.maps.internal;

import android.os.Parcel;

/* loaded from: classes4.dex */
public abstract class zzac extends com.google.android.gms.internal.maps.zzb implements zzad {
    public zzac() {
        super("com.google.android.gms.maps.internal.IOnInfoWindowClickListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 != 1) {
            return false;
        }
        com.google.android.gms.internal.maps.zzad zzadVarZ0 = com.google.android.gms.internal.maps.zzac.z0(parcel.readStrongBinder());
        com.google.android.gms.internal.maps.zzc.b(parcel);
        d(zzadVarZ0);
        parcel2.writeNoException();
        return true;
    }
}
