package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public abstract class zzak extends com.google.android.gms.internal.maps.zzb implements zzal {
    public zzak() {
        super("com.google.android.gms.maps.internal.IOnMapCapabilitiesChangedListener");
    }

    @Override // com.google.android.gms.internal.maps.zzb
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        com.google.android.gms.internal.maps.zzaa zzyVar;
        if (i2 != 1) {
            return false;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        if (strongBinder != null) {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IMapCapabilitiesDelegate");
            zzyVar = iInterfaceQueryLocalInterface instanceof com.google.android.gms.internal.maps.zzaa ? (com.google.android.gms.internal.maps.zzaa) iInterfaceQueryLocalInterface : new com.google.android.gms.internal.maps.zzy(strongBinder, "com.google.android.gms.maps.model.internal.IMapCapabilitiesDelegate");
        } else {
            zzyVar = null;
        }
        com.google.android.gms.internal.maps.zzc.b(parcel);
        C5(zzyVar);
        throw null;
    }
}
