package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class zzbtn extends zzbcc implements zzbto {
    public zzbtn() {
        super("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        switch (i2) {
            case 2:
                String strZze = zze();
                parcel2.writeNoException();
                parcel2.writeString(strZze);
                return true;
            case 3:
                List listZzf = zzf();
                parcel2.writeNoException();
                parcel2.writeList(listZzf);
                return true;
            case 4:
                String strZzg = zzg();
                parcel2.writeNoException();
                parcel2.writeString(strZzg);
                return true;
            case 5:
                zzbjy zzbjyVarZzh = zzh();
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzbjyVarZzh);
                return true;
            case 6:
                String strZzi = zzi();
                parcel2.writeNoException();
                parcel2.writeString(strZzi);
                return true;
            case 7:
                String strZzj = zzj();
                parcel2.writeNoException();
                parcel2.writeString(strZzj);
                return true;
            case 8:
                double dZzk = zzk();
                parcel2.writeNoException();
                parcel2.writeDouble(dZzk);
                return true;
            case 9:
                String strZzl = zzl();
                parcel2.writeNoException();
                parcel2.writeString(strZzl);
                return true;
            case 10:
                String strZzm = zzm();
                parcel2.writeNoException();
                parcel2.writeString(strZzm);
                return true;
            case 11:
                com.google.android.gms.ads.internal.client.zzed zzedVarZzn = zzn();
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzedVarZzn);
                return true;
            case 12:
                parcel2.writeNoException();
                ClassLoader classLoader = zzbcd.f24690a;
                parcel2.writeStrongBinder(null);
                return true;
            case 13:
                IObjectWrapper iObjectWrapperZzp = zzp();
                parcel2.writeNoException();
                zzbcd.e(parcel2, iObjectWrapperZzp);
                return true;
            case 14:
                IObjectWrapper iObjectWrapperZzq = zzq();
                parcel2.writeNoException();
                zzbcd.e(parcel2, iObjectWrapperZzq);
                return true;
            case 15:
                IObjectWrapper iObjectWrapperZzr = zzr();
                parcel2.writeNoException();
                zzbcd.e(parcel2, iObjectWrapperZzr);
                return true;
            case 16:
                Bundle bundleBb = bb();
                parcel2.writeNoException();
                zzbcd.d(parcel2, bundleBb);
                return true;
            case 17:
                boolean zF = f();
                parcel2.writeNoException();
                ClassLoader classLoader2 = zzbcd.f24690a;
                parcel2.writeInt(zF ? 1 : 0);
                return true;
            case 18:
                boolean zP0 = p0();
                parcel2.writeNoException();
                ClassLoader classLoader3 = zzbcd.f24690a;
                parcel2.writeInt(zP0 ? 1 : 0);
                return true;
            case 19:
                h();
                parcel2.writeNoException();
                return true;
            case 20:
                IObjectWrapper iObjectWrapperG = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbcd.f(parcel);
                R0(iObjectWrapperG);
                parcel2.writeNoException();
                return true;
            case 21:
                IObjectWrapper iObjectWrapperG2 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperG3 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperG4 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbcd.f(parcel);
                i2(iObjectWrapperG2, iObjectWrapperG3, iObjectWrapperG4);
                parcel2.writeNoException();
                return true;
            case 22:
                IObjectWrapper iObjectWrapperG5 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbcd.f(parcel);
                s8(iObjectWrapperG5);
                parcel2.writeNoException();
                return true;
            case 23:
                float fI = I();
                parcel2.writeNoException();
                parcel2.writeFloat(fI);
                return true;
            case 24:
                float fH = H();
                parcel2.writeNoException();
                parcel2.writeFloat(fH);
                return true;
            case 25:
                float fT = t();
                parcel2.writeNoException();
                parcel2.writeFloat(fT);
                return true;
            case 26:
                v();
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
