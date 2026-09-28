package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes4.dex */
public abstract class zzbkb extends zzbcc implements zzbkc {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f25281a = 0;

    public zzbkb() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        zzbjv zzbjtVar;
        switch (i2) {
            case 1:
                String string = parcel.readString();
                IObjectWrapper iObjectWrapperG = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbcd.f(parcel);
                P6(iObjectWrapperG, string);
                parcel2.writeNoException();
                return true;
            case 2:
                String string2 = parcel.readString();
                zzbcd.f(parcel);
                IObjectWrapper iObjectWrapperO = o(string2);
                parcel2.writeNoException();
                zzbcd.e(parcel2, iObjectWrapperO);
                return true;
            case 3:
                IObjectWrapper iObjectWrapperG2 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbcd.f(parcel);
                H0(iObjectWrapperG2);
                parcel2.writeNoException();
                return true;
            case 4:
                zze();
                parcel2.writeNoException();
                return true;
            case 5:
                IObjectWrapper.Stub.g(parcel.readStrongBinder());
                parcel.readInt();
                zzbcd.f(parcel);
                parcel2.writeNoException();
                return true;
            case 6:
                IObjectWrapper iObjectWrapperG3 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbcd.f(parcel);
                Z(iObjectWrapperG3);
                parcel2.writeNoException();
                return true;
            case 7:
                IObjectWrapper iObjectWrapperG4 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbcd.f(parcel);
                U2(iObjectWrapperG4);
                parcel2.writeNoException();
                return true;
            case 8:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    zzbjtVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IMediaContent");
                    zzbjtVar = iInterfaceQueryLocalInterface instanceof zzbjv ? (zzbjv) iInterfaceQueryLocalInterface : new zzbjt(strongBinder, "com.google.android.gms.ads.internal.formats.client.IMediaContent");
                }
                zzbcd.f(parcel);
                Tb(zzbjtVar);
                parcel2.writeNoException();
                return true;
            case 9:
                IObjectWrapper iObjectWrapperG5 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbcd.f(parcel);
                ha(iObjectWrapperG5);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
