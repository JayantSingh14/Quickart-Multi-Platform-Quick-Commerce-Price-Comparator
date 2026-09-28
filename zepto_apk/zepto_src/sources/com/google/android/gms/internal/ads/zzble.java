package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public abstract class zzble extends zzbcc implements zzblf {
    public zzble() {
        super("com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        zzbks zzbkqVar;
        if (i2 != 1) {
            return false;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        if (strongBinder == null) {
            zzbkqVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
            zzbkqVar = iInterfaceQueryLocalInterface instanceof zzbks ? (zzbks) iInterfaceQueryLocalInterface : new zzbkq(strongBinder);
        }
        zzbcd.f(parcel);
        Na(zzbkqVar);
        parcel2.writeNoException();
        return true;
    }
}
