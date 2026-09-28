package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public abstract class zzaa extends com.google.android.gms.internal.maps.zzb implements zzab {
    public zzaa() {
        super("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        com.google.android.gms.internal.maps.zzu zzsVar;
        if (i2 == 1) {
            zzb();
        } else {
            if (i2 != 2) {
                return false;
            }
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder == null) {
                zzsVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
                zzsVar = iInterfaceQueryLocalInterface instanceof com.google.android.gms.internal.maps.zzu ? (com.google.android.gms.internal.maps.zzu) iInterfaceQueryLocalInterface : new com.google.android.gms.internal.maps.zzs(strongBinder, "com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
            }
            com.google.android.gms.internal.maps.zzc.b(parcel);
            R5(zzsVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
