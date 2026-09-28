package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes4.dex */
public abstract class zzz extends com.google.android.gms.internal.common.zzb implements IGmsCallbacks {
    public zzz() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // com.google.android.gms.internal.common.zzb
    public final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            int i4 = parcel.readInt();
            IBinder strongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) com.google.android.gms.internal.common.zzc.b(parcel, Bundle.CREATOR);
            com.google.android.gms.internal.common.zzc.e(parcel);
            onPostInitComplete(i4, strongBinder, bundle);
        } else if (i2 == 2) {
            int i5 = parcel.readInt();
            Bundle bundle2 = (Bundle) com.google.android.gms.internal.common.zzc.b(parcel, Bundle.CREATOR);
            com.google.android.gms.internal.common.zzc.e(parcel);
            zzb(i5, bundle2);
        } else {
            if (i2 != 3) {
                return false;
            }
            int i6 = parcel.readInt();
            IBinder strongBinder2 = parcel.readStrongBinder();
            zzj zzjVar = (zzj) com.google.android.gms.internal.common.zzc.b(parcel, zzj.CREATOR);
            com.google.android.gms.internal.common.zzc.e(parcel);
            zzc(i6, strongBinder2, zzjVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
