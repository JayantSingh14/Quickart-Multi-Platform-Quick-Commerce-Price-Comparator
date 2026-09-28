package com.google.ads.interactivemedia.v3.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes3.dex */
public final class zzof extends zzke implements zzoh {
    public zzof(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.clearcut.IGassClearcut");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzoh
    public final void zze(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        Parcel parcelZza = zza();
        zzkg.zzd(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeString(null);
        zzv(8, parcelZza);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzoh
    public final void zzf() throws RemoteException {
        zzv(3, zza());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzoh
    public final void zzg(int i2) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i2);
        zzv(7, parcelZza);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzoh
    public final void zzh(int[] iArr) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeIntArray(null);
        zzv(4, parcelZza);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzoh
    public final void zzi(int i2) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i2);
        zzv(6, parcelZza);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzoh
    public final void zzj(byte[] bArr) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeByteArray(bArr);
        zzv(5, parcelZza);
    }
}
