package com.google.android.gms.internal.ads;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes4.dex */
public abstract class zzbzw extends zzbcc implements zzbzx {
    public zzbzw() {
        super("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        switch (i2) {
            case 1:
                IObjectWrapper iObjectWrapperG = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbcd.f(parcel);
                y7(iObjectWrapperG);
                break;
            case 2:
                IObjectWrapper iObjectWrapperG2 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                int i3 = parcel.readInt();
                zzbcd.f(parcel);
                v0(iObjectWrapperG2, i3);
                break;
            case 3:
                IObjectWrapper iObjectWrapperG3 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbcd.f(parcel);
                Z(iObjectWrapperG3);
                break;
            case 4:
                IObjectWrapper iObjectWrapperG4 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbcd.f(parcel);
                X0(iObjectWrapperG4);
                break;
            case 5:
                IObjectWrapper iObjectWrapperG5 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbcd.f(parcel);
                zzi(iObjectWrapperG5);
                break;
            case 6:
                IObjectWrapper iObjectWrapperG6 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbcd.f(parcel);
                ua(iObjectWrapperG6);
                break;
            case 7:
                IObjectWrapper iObjectWrapperG7 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbzy zzbzyVar = (zzbzy) zzbcd.b(parcel, zzbzy.CREATOR);
                zzbcd.f(parcel);
                pa(iObjectWrapperG7, zzbzyVar);
                break;
            case 8:
                IObjectWrapper iObjectWrapperG8 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbcd.f(parcel);
                zzl(iObjectWrapperG8);
                break;
            case 9:
                IObjectWrapper iObjectWrapperG9 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                int i4 = parcel.readInt();
                zzbcd.f(parcel);
                C8(iObjectWrapperG9, i4);
                break;
            case 10:
                IObjectWrapper iObjectWrapperG10 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbcd.f(parcel);
                J(iObjectWrapperG10);
                break;
            case 11:
                IObjectWrapper iObjectWrapperG11 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbcd.f(parcel);
                c2(iObjectWrapperG11);
                break;
            case 12:
                zzbcd.f(parcel);
                break;
            case 13:
                IObjectWrapper iObjectWrapperG12 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbcd.f(parcel);
                zzp(iObjectWrapperG12);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
