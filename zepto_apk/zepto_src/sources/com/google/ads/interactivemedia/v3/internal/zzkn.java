package com.google.ads.interactivemedia.v3.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes3.dex */
public final class zzkn extends zzke implements IInterface {
    public zzkn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.adshield.internal.IAdShieldCreator");
    }

    public final IBinder zze(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, byte[] bArr) throws RemoteException {
        Parcel parcelZza = zza();
        zzkg.zzd(parcelZza, iObjectWrapper);
        zzkg.zzd(parcelZza, iObjectWrapper2);
        parcelZza.writeByteArray(bArr);
        Parcel parcelZzu = zzu(3, parcelZza);
        IBinder strongBinder = parcelZzu.readStrongBinder();
        parcelZzu.recycle();
        return strongBinder;
    }
}
