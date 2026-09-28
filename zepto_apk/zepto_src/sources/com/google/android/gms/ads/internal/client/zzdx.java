package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbcb;
import com.google.android.gms.internal.ads.zzbcd;
import com.google.android.gms.internal.ads.zzbsv;

/* loaded from: classes4.dex */
public final class zzdx extends zzbcb implements IInterface {
    public final zzdw V2(ObjectWrapper objectWrapper, zzbsv zzbsvVar) {
        zzdw zzduVar;
        Parcel parcelG = g();
        zzbcd.e(parcelG, objectWrapper);
        zzbcd.e(parcelG, zzbsvVar);
        parcelG.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZ0 = z0(1, parcelG);
        IBinder strongBinder = parcelZ0.readStrongBinder();
        if (strongBinder == null) {
            zzduVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOutOfContextTester");
            zzduVar = iInterfaceQueryLocalInterface instanceof zzdw ? (zzdw) iInterfaceQueryLocalInterface : new zzdu(strongBinder);
        }
        parcelZ0.recycle();
        return zzduVar;
    }
}
