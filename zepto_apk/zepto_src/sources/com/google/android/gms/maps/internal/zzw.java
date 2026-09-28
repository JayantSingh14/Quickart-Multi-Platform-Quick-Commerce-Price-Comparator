package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public abstract class zzw extends com.google.android.gms.internal.maps.zzb implements zzx {
    public zzw() {
        super("com.google.android.gms.maps.internal.IOnCircleClickListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        com.google.android.gms.internal.maps.zzl zzjVar;
        if (i2 != 1) {
            return false;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        if (strongBinder == null) {
            zzjVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ICircleDelegate");
            zzjVar = iInterfaceQueryLocalInterface instanceof com.google.android.gms.internal.maps.zzl ? (com.google.android.gms.internal.maps.zzl) iInterfaceQueryLocalInterface : new com.google.android.gms.internal.maps.zzj(strongBinder, "com.google.android.gms.maps.model.internal.ICircleDelegate");
        }
        com.google.android.gms.internal.maps.zzc.b(parcel);
        Fa(zzjVar);
        parcel2.writeNoException();
        return true;
    }
}
