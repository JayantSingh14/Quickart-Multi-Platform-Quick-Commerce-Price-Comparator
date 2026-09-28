package com.google.ads.interactivemedia.v3.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public final class zzno extends zzke implements IInterface {
    public zzno(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    public final zznm zze(zznk zznkVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzkg.zzc(parcelZza, zznkVar);
        Parcel parcelZzu = zzu(1, parcelZza);
        zznm zznmVar = (zznm) zzkg.zza(parcelZzu, zznm.CREATOR);
        parcelZzu.recycle();
        return zznmVar;
    }

    public final zznv zzf(zznt zzntVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzkg.zzc(parcelZza, zzntVar);
        Parcel parcelZzu = zzu(3, parcelZza);
        zznv zznvVar = (zznv) zzkg.zza(parcelZzu, zznv.CREATOR);
        parcelZzu.recycle();
        return zznvVar;
    }
}
