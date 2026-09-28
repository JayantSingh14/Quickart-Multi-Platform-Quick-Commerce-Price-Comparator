package com.google.ads.interactivemedia.v3.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public abstract class zzlr extends zzkf implements zzls {
    public zzlr() {
        super("com.google.android.gms.ads.signalsdk.ISignalSdkCallback");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzkf
    public final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            Bundle bundle = (Bundle) zzkg.zza(parcel, Bundle.CREATOR);
            zzkg.zzb(parcel);
            zzc(bundle);
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
