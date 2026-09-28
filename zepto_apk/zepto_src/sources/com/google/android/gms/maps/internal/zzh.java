package com.google.android.gms.maps.internal;

import android.os.Parcel;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes4.dex */
public abstract class zzh extends com.google.android.gms.internal.maps.zzb implements zzi {
    public zzh() {
        super("com.google.android.gms.maps.internal.IInfoWindowAdapter");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        if (i2 == 1) {
            com.google.android.gms.internal.maps.zzad zzadVarZ0 = com.google.android.gms.internal.maps.zzac.z0(parcel.readStrongBinder());
            com.google.android.gms.internal.maps.zzc.b(parcel);
            ObjectWrapper objectWrapperQ0 = q0(zzadVarZ0);
            parcel2.writeNoException();
            com.google.android.gms.internal.maps.zzc.d(parcel2, objectWrapperQ0);
            return true;
        }
        if (i2 != 2) {
            return false;
        }
        com.google.android.gms.internal.maps.zzad zzadVarZ02 = com.google.android.gms.internal.maps.zzac.z0(parcel.readStrongBinder());
        com.google.android.gms.internal.maps.zzc.b(parcel);
        ObjectWrapper objectWrapperD = d(zzadVarZ02);
        parcel2.writeNoException();
        com.google.android.gms.internal.maps.zzc.d(parcel2, objectWrapperD);
        return true;
    }
}
