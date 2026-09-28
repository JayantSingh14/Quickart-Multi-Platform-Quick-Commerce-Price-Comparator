package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public abstract class zzbli extends zzbcc implements zzblj {
    public zzbli() {
        super("com.google.android.gms.ads.internal.formats.client.IOnPublisherAdViewLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        com.google.android.gms.ads.internal.client.zzbx zzbvVar;
        if (i2 != 1) {
            return false;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        if (strongBinder == null) {
            zzbvVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzbvVar = iInterfaceQueryLocalInterface instanceof com.google.android.gms.ads.internal.client.zzbx ? (com.google.android.gms.ads.internal.client.zzbx) iInterfaceQueryLocalInterface : new com.google.android.gms.ads.internal.client.zzbv(strongBinder);
        }
        ((zzbma) this).Y1(zzbvVar, android.support.v4.media.a.g(parcel, parcel));
        parcel2.writeNoException();
        return true;
    }
}
