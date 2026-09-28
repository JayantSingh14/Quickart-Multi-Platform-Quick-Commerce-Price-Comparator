package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes4.dex */
public abstract class zzbsy extends zzbcc implements zzbsz {
    public zzbsy() {
        super("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static zzbsz Xb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        return iInterfaceQueryLocalInterface instanceof zzbsz ? (zzbsz) iInterfaceQueryLocalInterface : new zzbsx(iBinder, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) throws RemoteException {
        if (i2 == 1) {
            String string = parcel.readString();
            zzbcd.f(parcel);
            zzbtc zzbtcVarB = ((zzbsv) this).b(string);
            parcel2.writeNoException();
            zzbcd.e(parcel2, zzbtcVarB);
            return true;
        }
        if (i2 == 2) {
            String string2 = parcel.readString();
            zzbcd.f(parcel);
            boolean zO = ((zzbsv) this).o(string2);
            parcel2.writeNoException();
            parcel2.writeInt(zO ? 1 : 0);
            return true;
        }
        if (i2 == 3) {
            String string3 = parcel.readString();
            zzbcd.f(parcel);
            zzbuy zzbuyVarQ = ((zzbsv) this).q(string3);
            parcel2.writeNoException();
            zzbcd.e(parcel2, zzbuyVarQ);
            return true;
        }
        if (i2 != 4) {
            return false;
        }
        String string4 = parcel.readString();
        zzbcd.f(parcel);
        boolean zY = ((zzbsv) this).Y(string4);
        parcel2.writeNoException();
        parcel2.writeInt(zY ? 1 : 0);
        return true;
    }
}
