package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public abstract class zzy extends com.google.android.gms.internal.maps.zzb implements zzz {
    public zzy() {
        super("com.google.android.gms.maps.internal.IOnGroundOverlayClickListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        com.google.android.gms.internal.maps.zzr zzpVar;
        if (i2 != 1) {
            return false;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        if (strongBinder == null) {
            zzpVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
            zzpVar = iInterfaceQueryLocalInterface instanceof com.google.android.gms.internal.maps.zzr ? (com.google.android.gms.internal.maps.zzr) iInterfaceQueryLocalInterface : new com.google.android.gms.internal.maps.zzp(strongBinder, "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
        }
        com.google.android.gms.internal.maps.zzc.b(parcel);
        H3(zzpVar);
        parcel2.writeNoException();
        return true;
    }
}
