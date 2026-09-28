package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes4.dex */
public final class zzbwz extends zzbcb implements zzbxb {
    public zzbwz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzbxb
    public final IBinder ba(ObjectWrapper objectWrapper) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, objectWrapper);
        Parcel parcelZ0 = z0(1, parcelG);
        IBinder strongBinder = parcelZ0.readStrongBinder();
        parcelZ0.recycle();
        return strongBinder;
    }
}
