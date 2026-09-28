package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* loaded from: classes4.dex */
public final class zzbor extends zzbcb implements zzbot {
    @Override // com.google.android.gms.internal.ads.zzbot
    public final zzboq S1(ObjectWrapper objectWrapper, zzbsv zzbsvVar, zzbok zzbokVar) {
        zzboq zzbooVar;
        Parcel parcelG = g();
        zzbcd.e(parcelG, objectWrapper);
        zzbcd.e(parcelG, zzbsvVar);
        parcelG.writeInt(ModuleDescriptor.MODULE_VERSION);
        zzbcd.e(parcelG, zzbokVar);
        Parcel parcelZ0 = z0(1, parcelG);
        IBinder strongBinder = parcelZ0.readStrongBinder();
        if (strongBinder == null) {
            zzbooVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.h5.client.IH5AdsManager");
            zzbooVar = iInterfaceQueryLocalInterface instanceof zzboq ? (zzboq) iInterfaceQueryLocalInterface : new zzboo(strongBinder);
        }
        parcelZ0.recycle();
        return zzbooVar;
    }
}
