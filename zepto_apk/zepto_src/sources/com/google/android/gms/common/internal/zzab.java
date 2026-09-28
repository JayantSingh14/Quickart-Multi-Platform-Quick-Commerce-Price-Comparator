package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes4.dex */
public final class zzab extends com.google.android.gms.internal.common.zza implements zzad {
    public zzab(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // com.google.android.gms.common.internal.zzad
    public final boolean zze(com.google.android.gms.common.zzt zztVar, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.common.zzc.c(parcelZza, zztVar);
        com.google.android.gms.internal.common.zzc.d(parcelZza, iObjectWrapper);
        Parcel parcelZzB = zzB(5, parcelZza);
        boolean zA = com.google.android.gms.internal.common.zzc.a(parcelZzB);
        parcelZzB.recycle();
        return zA;
    }

    @Override // com.google.android.gms.common.internal.zzad
    public final com.google.android.gms.common.zzr zzf(com.google.android.gms.common.zzp zzpVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.common.zzc.c(parcelZza, zzpVar);
        Parcel parcelZzB = zzB(6, parcelZza);
        com.google.android.gms.common.zzr zzrVar = (com.google.android.gms.common.zzr) com.google.android.gms.internal.common.zzc.b(parcelZzB, com.google.android.gms.common.zzr.CREATOR);
        parcelZzB.recycle();
        return zzrVar;
    }

    @Override // com.google.android.gms.common.internal.zzad
    public final boolean zzg() throws RemoteException {
        Parcel parcelZzB = zzB(7, zza());
        boolean zA = com.google.android.gms.internal.common.zzc.a(parcelZzB);
        parcelZzB.recycle();
        return zA;
    }

    @Override // com.google.android.gms.common.internal.zzad
    public final com.google.android.gms.common.zzr zzh(com.google.android.gms.common.zzp zzpVar) throws RemoteException {
        Parcel parcelZza = zza();
        com.google.android.gms.internal.common.zzc.c(parcelZza, zzpVar);
        Parcel parcelZzB = zzB(8, parcelZza);
        com.google.android.gms.common.zzr zzrVar = (com.google.android.gms.common.zzr) com.google.android.gms.internal.common.zzc.b(parcelZzB, com.google.android.gms.common.zzr.CREATOR);
        parcelZzB.recycle();
        return zzrVar;
    }

    @Override // com.google.android.gms.common.internal.zzad
    public final boolean zzi() throws RemoteException {
        Parcel parcelZzB = zzB(9, zza());
        boolean zA = com.google.android.gms.internal.common.zzc.a(parcelZzB);
        parcelZzB.recycle();
        return zA;
    }
}
