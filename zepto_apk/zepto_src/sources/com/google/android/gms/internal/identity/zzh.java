package com.google.android.gms.internal.identity;

import android.os.Bundle;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public final class zzh extends zza implements IInterface {
    public final void g(zzg zzgVar, Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken("com.google.android.gms.identity.intents.internal.IAddressService");
        int i2 = zzc.f36617a;
        if (zzgVar == null) {
            parcelObtain.writeStrongBinder(null);
        } else {
            parcelObtain.writeStrongBinder(zzgVar.asBinder());
        }
        parcelObtain.writeInt(0);
        parcelObtain.writeInt(1);
        bundle.writeToParcel(parcelObtain, 0);
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            this.f36616a.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }
}
