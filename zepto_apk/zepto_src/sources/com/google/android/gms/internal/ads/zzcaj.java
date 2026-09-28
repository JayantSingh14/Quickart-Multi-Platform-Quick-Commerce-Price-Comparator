package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* loaded from: classes4.dex */
public final class zzcaj extends zzbcb implements IInterface {
    public final IBinder V2(ObjectWrapper objectWrapper, String str, zzbsv zzbsvVar) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, objectWrapper);
        parcelG.writeString(str);
        zzbcd.e(parcelG, zzbsvVar);
        parcelG.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZ0 = z0(1, parcelG);
        IBinder strongBinder = parcelZ0.readStrongBinder();
        parcelZ0.recycle();
        return strongBinder;
    }
}
