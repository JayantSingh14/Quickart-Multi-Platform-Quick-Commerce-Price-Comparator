package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public abstract class zzlp extends zzkf implements zzlq {
    public zzlp() {
        super("com.google.android.gms.ads.signalsdk.INetworkRequestCallback");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzkf
    public final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            zzly zzlyVar = (zzly) zzkg.zza(parcel, zzly.CREATOR);
            zzkg.zzb(parcel);
            zzc(zzlyVar);
        } else {
            if (i2 != 2) {
                return false;
            }
            int i4 = parcel.readInt();
            zzkg.zzb(parcel);
            zzb(i4);
        }
        return true;
    }
}
