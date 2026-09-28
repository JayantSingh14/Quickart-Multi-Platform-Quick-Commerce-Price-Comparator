package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* loaded from: classes4.dex */
public final class zzbws extends zzbcb implements zzbwu {
    @Override // com.google.android.gms.internal.ads.zzbwu
    public final zzbwr K0(ObjectWrapper objectWrapper, zzbsv zzbsvVar) {
        zzbwr zzbwpVar;
        Parcel parcelG = g();
        zzbcd.e(parcelG, objectWrapper);
        zzbcd.e(parcelG, zzbsvVar);
        parcelG.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZ0 = z0(1, parcelG);
        IBinder strongBinder = parcelZ0.readStrongBinder();
        if (strongBinder == null) {
            zzbwpVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.offline.IOfflineUtils");
            zzbwpVar = iInterfaceQueryLocalInterface instanceof zzbwr ? (zzbwr) iInterfaceQueryLocalInterface : new zzbwp(strongBinder);
        }
        parcelZ0.recycle();
        return zzbwpVar;
    }
}
