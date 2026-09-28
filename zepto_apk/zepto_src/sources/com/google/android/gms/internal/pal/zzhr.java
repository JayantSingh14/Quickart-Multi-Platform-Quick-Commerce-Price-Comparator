package com.google.android.gms.internal.pal;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes4.dex */
public abstract class zzhr extends zzfk implements zzhs {
    public zzhr() {
        super("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
    }

    @Override // com.google.android.gms.internal.pal.zzfk
    public final boolean g(int i2, Parcel parcel, Parcel parcel2) {
        switch (i2) {
            case 2:
                IObjectWrapper.Stub.g(parcel.readStrongBinder());
                parcel.readString();
                zzfl.a(parcel);
                break;
            case 3:
                break;
            case 4:
                parcel.createIntArray();
                zzfl.a(parcel);
                break;
            case 5:
                parcel.createByteArray();
                zzfl.a(parcel);
                break;
            case 6:
                parcel.readInt();
                zzfl.a(parcel);
                break;
            case 7:
                parcel.readInt();
                zzfl.a(parcel);
                break;
            case 8:
                IObjectWrapper.Stub.g(parcel.readStrongBinder());
                parcel.readString();
                parcel.readString();
                zzfl.a(parcel);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
