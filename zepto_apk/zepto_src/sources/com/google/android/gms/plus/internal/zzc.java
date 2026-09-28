package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;

/* loaded from: classes4.dex */
public abstract class zzc extends com.google.android.gms.internal.plus.zzb implements zzb {
    public zzc() {
        attachInterface(this, "com.google.android.gms.plus.internal.IPlusCallbacks");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.plus.zzb
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        switch (i2) {
            case 1:
                parcel.readInt();
                Parcelable.Creator creator = Bundle.CREATOR;
                parcel2.writeNoException();
                return true;
            case 2:
                parcel.readInt();
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
                parcel.readString();
                parcel2.writeNoException();
                return true;
            case 4:
                v1((DataHolder) com.google.android.gms.internal.plus.zzc.a(parcel, DataHolder.CREATOR), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 5:
                parcel.readInt();
                parcel2.writeNoException();
                return true;
            case 6:
                parcel.readString();
                parcel.readString();
                parcel2.writeNoException();
                return true;
            case 7:
                X8(parcel.readInt(), (Bundle) com.google.android.gms.internal.plus.zzc.a(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 9:
                parcel.readInt();
                parcel2.writeNoException();
                return true;
            case 10:
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
