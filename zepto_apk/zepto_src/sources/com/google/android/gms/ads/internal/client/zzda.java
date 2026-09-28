package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbcc;
import com.google.android.gms.internal.ads.zzbcd;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzbpt;
import com.google.android.gms.internal.ads.zzbsy;
import com.google.android.gms.internal.ads.zzbsz;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class zzda extends zzbcc implements zzdb {
    public zzda() {
        super("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        zzbpt zzbprVar = null;
        zzdn zzdlVar = null;
        switch (i2) {
            case 1:
                zze();
                parcel2.writeNoException();
                return true;
            case 2:
                float f2 = parcel.readFloat();
                zzbcd.f(parcel);
                o0(f2);
                parcel2.writeNoException();
                return true;
            case 3:
                String string = parcel.readString();
                zzbcd.f(parcel);
                ra(string);
                parcel2.writeNoException();
                return true;
            case 4:
                boolean zA = zzbcd.a(parcel);
                zzbcd.f(parcel);
                B0(zA);
                parcel2.writeNoException();
                return true;
            case 5:
                IObjectWrapper iObjectWrapperG = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                String string2 = parcel.readString();
                zzbcd.f(parcel);
                H2(iObjectWrapperG, string2);
                parcel2.writeNoException();
                return true;
            case 6:
                String string3 = parcel.readString();
                IObjectWrapper iObjectWrapperG2 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbcd.f(parcel);
                T1(iObjectWrapperG2, string3);
                parcel2.writeNoException();
                return true;
            case 7:
                float fZzk = zzk();
                parcel2.writeNoException();
                parcel2.writeFloat(fZzk);
                return true;
            case 8:
                boolean zZzl = zzl();
                parcel2.writeNoException();
                ClassLoader classLoader = zzbcd.f24690a;
                parcel2.writeInt(zZzl ? 1 : 0);
                return true;
            case 9:
                String strZzm = zzm();
                parcel2.writeNoException();
                parcel2.writeString(strZzm);
                return true;
            case 10:
                String string4 = parcel.readString();
                zzbcd.f(parcel);
                u0(string4);
                parcel2.writeNoException();
                return true;
            case 11:
                zzbsz zzbszVarXb = zzbsy.Xb(parcel.readStrongBinder());
                zzbcd.f(parcel);
                d5(zzbszVarXb);
                parcel2.writeNoException();
                return true;
            case 12:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.initialization.IInitializationCallback");
                    zzbprVar = iInterfaceQueryLocalInterface instanceof zzbpt ? (zzbpt) iInterfaceQueryLocalInterface : new zzbpr(strongBinder, "com.google.android.gms.ads.internal.initialization.IInitializationCallback");
                }
                zzbcd.f(parcel);
                v2(zzbprVar);
                parcel2.writeNoException();
                return true;
            case 13:
                List listZzq = zzq();
                parcel2.writeNoException();
                parcel2.writeTypedList(listZzq);
                return true;
            case 14:
                zzfv zzfvVar = (zzfv) zzbcd.b(parcel, zzfv.CREATOR);
                zzbcd.f(parcel);
                I2(zzfvVar);
                parcel2.writeNoException();
                return true;
            case 15:
                zzs();
                parcel2.writeNoException();
                return true;
            case 16:
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnAdInspectorClosedListener");
                    zzdlVar = iInterfaceQueryLocalInterface2 instanceof zzdn ? (zzdn) iInterfaceQueryLocalInterface2 : new zzdl(strongBinder2, "com.google.android.gms.ads.internal.client.IOnAdInspectorClosedListener");
                }
                zzbcd.f(parcel);
                t2(zzdlVar);
                parcel2.writeNoException();
                return true;
            case 17:
                boolean zA2 = zzbcd.a(parcel);
                zzbcd.f(parcel);
                g0(zA2);
                parcel2.writeNoException();
                return true;
            case 18:
                String string5 = parcel.readString();
                zzbcd.f(parcel);
                Y0(string5);
                parcel2.writeNoException();
                return true;
            case 19:
                j();
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
