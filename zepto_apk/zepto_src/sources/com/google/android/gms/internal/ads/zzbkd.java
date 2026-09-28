package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* loaded from: classes4.dex */
public final class zzbkd extends zzbcb implements zzbkf {
    public zzbkd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final IBinder B5(ObjectWrapper objectWrapper, ObjectWrapper objectWrapper2, ObjectWrapper objectWrapper3) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, objectWrapper);
        zzbcd.e(parcelG, objectWrapper2);
        zzbcd.e(parcelG, objectWrapper3);
        parcelG.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZ0 = z0(1, parcelG);
        IBinder strongBinder = parcelZ0.readStrongBinder();
        parcelZ0.recycle();
        return strongBinder;
    }
}
