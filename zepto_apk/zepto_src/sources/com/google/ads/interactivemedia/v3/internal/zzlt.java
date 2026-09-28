package com.google.ads.interactivemedia.v3.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public final class zzlt extends zzke implements zzlv {
    public zzlt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.signalsdk.ISignalSdkService");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzlv
    public final void zze(zzlw zzlwVar, zzlq zzlqVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzkg.zzc(parcelZza, zzlwVar);
        zzkg.zzd(parcelZza, zzlqVar);
        zzw(2, parcelZza);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzlv
    public final void zzf(Bundle bundle, zzls zzlsVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzkg.zzc(parcelZza, bundle);
        zzkg.zzd(parcelZza, zzlsVar);
        zzw(1, parcelZza);
    }
}
