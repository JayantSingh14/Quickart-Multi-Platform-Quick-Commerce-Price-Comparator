package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes3.dex */
public abstract class zzkl extends zzkf implements zzkm {
    public zzkl() {
        super("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzkf
    public final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        switch (i2) {
            case 1:
                String strZzj = zzj();
                parcel2.writeNoException();
                parcel2.writeString(strZzj);
                return true;
            case 2:
                String string = parcel.readString();
                String string2 = parcel.readString();
                zzkg.zzb(parcel);
                zzn(string, string2);
                parcel2.writeNoException();
                return true;
            case 3:
                IObjectWrapper iObjectWrapperG = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzkg.zzb(parcel);
                boolean zZzp = zzp(iObjectWrapperG);
                parcel2.writeNoException();
                parcel2.writeInt(zZzp ? 1 : 0);
                return true;
            case 4:
                IObjectWrapper iObjectWrapperG2 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzkg.zzb(parcel);
                boolean zZzq = zzq(iObjectWrapperG2);
                parcel2.writeNoException();
                parcel2.writeInt(zZzq ? 1 : 0);
                return true;
            case 5:
                String string3 = parcel.readString();
                zzkg.zzb(parcel);
                zzo(string3);
                parcel2.writeNoException();
                return true;
            case 6:
                IObjectWrapper iObjectWrapperG3 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperG4 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzkg.zzb(parcel);
                IObjectWrapper iObjectWrapperZzd = zzd(iObjectWrapperG3, iObjectWrapperG4);
                parcel2.writeNoException();
                zzkg.zzd(parcel2, iObjectWrapperZzd);
                return true;
            case 7:
                IObjectWrapper iObjectWrapperG5 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzkg.zzb(parcel);
                String strZzf = zzf(iObjectWrapperG5);
                parcel2.writeNoException();
                parcel2.writeString(strZzf);
                return true;
            case 8:
                IObjectWrapper iObjectWrapperG6 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                String string4 = parcel.readString();
                zzkg.zzb(parcel);
                String strZze = zze(iObjectWrapperG6, string4);
                parcel2.writeNoException();
                parcel2.writeString(strZze);
                return true;
            case 9:
                IObjectWrapper iObjectWrapperG7 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzkg.zzb(parcel);
                zzl(iObjectWrapperG7);
                parcel2.writeNoException();
                return true;
            case 10:
                IObjectWrapper iObjectWrapperG8 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperG9 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzkg.zzb(parcel);
                IObjectWrapper iObjectWrapperZzc = zzc(iObjectWrapperG8, iObjectWrapperG9);
                parcel2.writeNoException();
                zzkg.zzd(parcel2, iObjectWrapperZzc);
                return true;
            case 11:
                parcel.readString();
                int i4 = zzkg.zza;
                parcel.readInt();
                zzkg.zzb(parcel);
                parcel2.writeNoException();
                parcel2.writeInt(0);
                return true;
            case 12:
                IObjectWrapper iObjectWrapperG10 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                byte[] bArrCreateByteArray = parcel.createByteArray();
                zzkg.zzb(parcel);
                String strZzg = zzg(iObjectWrapperG10, bArrCreateByteArray);
                parcel2.writeNoException();
                parcel2.writeString(strZzg);
                return true;
            case 13:
                IObjectWrapper iObjectWrapperG11 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzkg.zzb(parcel);
                String strZzi = zzi(iObjectWrapperG11);
                parcel2.writeNoException();
                parcel2.writeString(strZzi);
                return true;
            case 14:
                IObjectWrapper iObjectWrapperG12 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperG13 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperG14 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzkg.zzb(parcel);
                String strZzk = zzk(iObjectWrapperG12, iObjectWrapperG13, iObjectWrapperG14);
                parcel2.writeNoException();
                parcel2.writeString(strZzk);
                return true;
            case 15:
                IObjectWrapper iObjectWrapperG15 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzkg.zzb(parcel);
                zzm(iObjectWrapperG15);
                parcel2.writeNoException();
                return true;
            case 16:
            default:
                return false;
            case 17:
                IObjectWrapper iObjectWrapperG16 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperG17 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperG18 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperG19 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzkg.zzb(parcel);
                String strZzh = zzh(iObjectWrapperG16, iObjectWrapperG17, iObjectWrapperG18, iObjectWrapperG19);
                parcel2.writeNoException();
                parcel2.writeString(strZzh);
                return true;
            case 18:
                boolean zZzr = zzr();
                parcel2.writeNoException();
                int i5 = zzkg.zza;
                parcel2.writeInt(zZzr ? 1 : 0);
                return true;
            case 19:
                boolean zZzs = zzs();
                parcel2.writeNoException();
                int i6 = zzkg.zza;
                parcel2.writeInt(zZzs ? 1 : 0);
                return true;
            case 20:
                int iZzb = zzb();
                parcel2.writeNoException();
                parcel2.writeInt(iZzb);
                return true;
        }
    }
}
