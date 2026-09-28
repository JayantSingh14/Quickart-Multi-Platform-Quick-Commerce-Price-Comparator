package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public abstract class zzbg extends com.google.android.gms.internal.maps.zzb implements zzbh {
    public zzbg() {
        super("com.google.android.gms.maps.internal.IOnPolygonClickListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        com.google.android.gms.internal.maps.zzag zzaeVar;
        if (i2 != 1) {
            return false;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        if (strongBinder == null) {
            zzaeVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IPolygonDelegate");
            zzaeVar = iInterfaceQueryLocalInterface instanceof com.google.android.gms.internal.maps.zzag ? (com.google.android.gms.internal.maps.zzag) iInterfaceQueryLocalInterface : new com.google.android.gms.internal.maps.zzae(strongBinder, "com.google.android.gms.maps.model.internal.IPolygonDelegate");
        }
        com.google.android.gms.internal.maps.zzc.b(parcel);
        H9(zzaeVar);
        parcel2.writeNoException();
        return true;
    }
}
