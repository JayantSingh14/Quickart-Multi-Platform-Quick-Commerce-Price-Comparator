package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public abstract class zzbef extends zzbcc implements zzbeg {
    public zzbef() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        zzbed zzbebVar;
        if (i2 == 1) {
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder == null) {
                zzbebVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
                zzbebVar = iInterfaceQueryLocalInterface instanceof zzbed ? (zzbed) iInterfaceQueryLocalInterface : new zzbeb(strongBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
            }
            zzbcd.f(parcel);
            gb(zzbebVar);
        } else if (i2 == 2) {
            parcel.readInt();
            zzbcd.f(parcel);
        } else {
            if (i2 != 3) {
                return false;
            }
            com.google.android.gms.ads.internal.client.zze zzeVar = (com.google.android.gms.ads.internal.client.zze) zzbcd.b(parcel, com.google.android.gms.ads.internal.client.zze.CREATOR);
            zzbcd.f(parcel);
            t0(zzeVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
