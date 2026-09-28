package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public abstract class zzbi extends com.google.android.gms.internal.maps.zzb implements zzbj {
    public zzbi() {
        super("com.google.android.gms.maps.internal.IOnPolylineClickListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        com.google.android.gms.internal.maps.zzaj zzahVar;
        if (i2 != 1) {
            return false;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        if (strongBinder == null) {
            zzahVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IPolylineDelegate");
            zzahVar = iInterfaceQueryLocalInterface instanceof com.google.android.gms.internal.maps.zzaj ? (com.google.android.gms.internal.maps.zzaj) iInterfaceQueryLocalInterface : new com.google.android.gms.internal.maps.zzah(strongBinder, "com.google.android.gms.maps.model.internal.IPolylineDelegate");
        }
        com.google.android.gms.internal.maps.zzc.b(parcel);
        Y7(zzahVar);
        parcel2.writeNoException();
        return true;
    }
}
