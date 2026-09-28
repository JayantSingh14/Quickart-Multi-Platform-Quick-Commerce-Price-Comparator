package com.google.android.gms.internal.ads;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes4.dex */
public abstract class zzfwd extends zzbcc implements zzfwe {
    public zzfwd() {
        super("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        switch (i2) {
            case 2:
                IObjectWrapper.Stub.g(parcel.readStrongBinder());
                parcel.readString();
                zzbcd.f(parcel);
                break;
            case 3:
                break;
            case 4:
                parcel.createIntArray();
                zzbcd.f(parcel);
                break;
            case 5:
                parcel.createByteArray();
                zzbcd.f(parcel);
                break;
            case 6:
                parcel.readInt();
                zzbcd.f(parcel);
                break;
            case 7:
                parcel.readInt();
                zzbcd.f(parcel);
                break;
            case 8:
                IObjectWrapper.Stub.g(parcel.readStrongBinder());
                parcel.readString();
                parcel.readString();
                zzbcd.f(parcel);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
