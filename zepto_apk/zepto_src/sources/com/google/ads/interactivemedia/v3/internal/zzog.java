package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes3.dex */
public abstract class zzog extends zzkf implements zzoh {
    public zzog() {
        super("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzkf
    public final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        switch (i2) {
            case 2:
                IObjectWrapper.Stub.g(parcel.readStrongBinder());
                parcel.readString();
                zzkg.zzb(parcel);
                break;
            case 3:
                break;
            case 4:
                parcel.createIntArray();
                zzkg.zzb(parcel);
                break;
            case 5:
                parcel.createByteArray();
                zzkg.zzb(parcel);
                break;
            case 6:
                parcel.readInt();
                zzkg.zzb(parcel);
                break;
            case 7:
                parcel.readInt();
                zzkg.zzb(parcel);
                break;
            case 8:
                IObjectWrapper.Stub.g(parcel.readStrongBinder());
                parcel.readString();
                parcel.readString();
                zzkg.zzb(parcel);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
