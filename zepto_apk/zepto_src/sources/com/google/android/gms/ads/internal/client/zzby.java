package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbcb;
import com.google.android.gms.internal.ads.zzbcd;
import com.google.android.gms.internal.ads.zzbsz;

/* loaded from: classes4.dex */
public final class zzby extends zzbcb implements IInterface {
    public zzby(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManagerCreator");
    }

    public final IBinder V2(ObjectWrapper objectWrapper, zzr zzrVar, String str, zzbsz zzbszVar, int i2) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, objectWrapper);
        zzbcd.c(parcelG, zzrVar);
        parcelG.writeString(str);
        zzbcd.e(parcelG, zzbszVar);
        parcelG.writeInt(ModuleDescriptor.MODULE_VERSION);
        parcelG.writeInt(i2);
        Parcel parcelZ0 = z0(2, parcelG);
        IBinder strongBinder = parcelZ0.readStrongBinder();
        parcelZ0.recycle();
        return strongBinder;
    }
}
