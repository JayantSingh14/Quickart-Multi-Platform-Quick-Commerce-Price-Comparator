package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* loaded from: classes4.dex */
public final class zzcck extends zzbcb implements zzccm {
    @Override // com.google.android.gms.internal.ads.zzccm
    public final zzccj K0(ObjectWrapper objectWrapper, zzbsv zzbsvVar) {
        zzccj zzcchVar;
        Parcel parcelG = g();
        zzbcd.e(parcelG, objectWrapper);
        zzbcd.e(parcelG, zzbsvVar);
        parcelG.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZ0 = z0(2, parcelG);
        IBinder strongBinder = parcelZ0.readStrongBinder();
        if (strongBinder == null) {
            zzcchVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalGenerator");
            zzcchVar = iInterfaceQueryLocalInterface instanceof zzccj ? (zzccj) iInterfaceQueryLocalInterface : new zzcch(strongBinder);
        }
        parcelZ0.recycle();
        return zzcchVar;
    }
}
