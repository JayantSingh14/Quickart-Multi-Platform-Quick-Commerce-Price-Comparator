package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zzc;

/* loaded from: classes4.dex */
public interface IFragmentWrapper extends IInterface {

    public static abstract class Stub extends com.google.android.gms.internal.common.zzb implements IFragmentWrapper {
        public Stub() {
            super("com.google.android.gms.dynamic.IFragmentWrapper");
        }

        @Override // com.google.android.gms.internal.common.zzb
        public final boolean zza(int i2, Parcel parcel, Parcel parcel2, int i3) {
            switch (i2) {
                case 2:
                    ObjectWrapper objectWrapperZzb = zzb();
                    parcel2.writeNoException();
                    zzc.d(parcel2, objectWrapperZzb);
                    return true;
                case 3:
                    Bundle bundleZzc = zzc();
                    parcel2.writeNoException();
                    int i4 = zzc.f36491a;
                    if (bundleZzc == null) {
                        parcel2.writeInt(0);
                    } else {
                        parcel2.writeInt(1);
                        bundleZzc.writeToParcel(parcel2, 1);
                    }
                    return true;
                case 4:
                    int iZzd = zzd();
                    parcel2.writeNoException();
                    parcel2.writeInt(iZzd);
                    return true;
                case 5:
                    IFragmentWrapper iFragmentWrapperZze = zze();
                    parcel2.writeNoException();
                    zzc.d(parcel2, iFragmentWrapperZze);
                    return true;
                case 6:
                    ObjectWrapper objectWrapperZzf = zzf();
                    parcel2.writeNoException();
                    zzc.d(parcel2, objectWrapperZzf);
                    return true;
                case 7:
                    boolean zZzg = zzg();
                    parcel2.writeNoException();
                    int i5 = zzc.f36491a;
                    parcel2.writeInt(zZzg ? 1 : 0);
                    return true;
                case 8:
                    String strZzh = zzh();
                    parcel2.writeNoException();
                    parcel2.writeString(strZzh);
                    return true;
                case 9:
                    IFragmentWrapper iFragmentWrapperZzi = zzi();
                    parcel2.writeNoException();
                    zzc.d(parcel2, iFragmentWrapperZzi);
                    return true;
                case 10:
                    int iZzj = zzj();
                    parcel2.writeNoException();
                    parcel2.writeInt(iZzj);
                    return true;
                case 11:
                    boolean zZzk = zzk();
                    parcel2.writeNoException();
                    int i6 = zzc.f36491a;
                    parcel2.writeInt(zZzk ? 1 : 0);
                    return true;
                case 12:
                    ObjectWrapper objectWrapperZzl = zzl();
                    parcel2.writeNoException();
                    zzc.d(parcel2, objectWrapperZzl);
                    return true;
                case 13:
                    boolean zZzm = zzm();
                    parcel2.writeNoException();
                    int i7 = zzc.f36491a;
                    parcel2.writeInt(zZzm ? 1 : 0);
                    return true;
                case 14:
                    boolean zZzn = zzn();
                    parcel2.writeNoException();
                    int i8 = zzc.f36491a;
                    parcel2.writeInt(zZzn ? 1 : 0);
                    return true;
                case 15:
                    boolean zZzo = zzo();
                    parcel2.writeNoException();
                    int i9 = zzc.f36491a;
                    parcel2.writeInt(zZzo ? 1 : 0);
                    return true;
                case 16:
                    boolean zZzp = zzp();
                    parcel2.writeNoException();
                    int i10 = zzc.f36491a;
                    parcel2.writeInt(zZzp ? 1 : 0);
                    return true;
                case 17:
                    boolean zZzq = zzq();
                    parcel2.writeNoException();
                    int i11 = zzc.f36491a;
                    parcel2.writeInt(zZzq ? 1 : 0);
                    return true;
                case 18:
                    boolean zZzr = zzr();
                    parcel2.writeNoException();
                    int i12 = zzc.f36491a;
                    parcel2.writeInt(zZzr ? 1 : 0);
                    return true;
                case 19:
                    boolean zZzs = zzs();
                    parcel2.writeNoException();
                    int i13 = zzc.f36491a;
                    parcel2.writeInt(zZzs ? 1 : 0);
                    return true;
                case 20:
                    IObjectWrapper iObjectWrapperG = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                    zzc.e(parcel);
                    S(iObjectWrapperG);
                    parcel2.writeNoException();
                    return true;
                case 21:
                    boolean zA = zzc.a(parcel);
                    zzc.e(parcel);
                    g0(zA);
                    parcel2.writeNoException();
                    return true;
                case 22:
                    boolean zA2 = zzc.a(parcel);
                    zzc.e(parcel);
                    n2(zA2);
                    parcel2.writeNoException();
                    return true;
                case 23:
                    boolean zA3 = zzc.a(parcel);
                    zzc.e(parcel);
                    P(zA3);
                    parcel2.writeNoException();
                    return true;
                case 24:
                    boolean zA4 = zzc.a(parcel);
                    zzc.e(parcel);
                    L0(zA4);
                    parcel2.writeNoException();
                    return true;
                case 25:
                    Intent intent = (Intent) zzc.b(parcel, Intent.CREATOR);
                    zzc.e(parcel);
                    Ba(intent);
                    parcel2.writeNoException();
                    return true;
                case 26:
                    Intent intent2 = (Intent) zzc.b(parcel, Intent.CREATOR);
                    int i14 = parcel.readInt();
                    zzc.e(parcel);
                    x3(intent2, i14);
                    parcel2.writeNoException();
                    return true;
                case 27:
                    IObjectWrapper iObjectWrapperG2 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                    zzc.e(parcel);
                    l6(iObjectWrapperG2);
                    parcel2.writeNoException();
                    return true;
                default:
                    return false;
            }
        }
    }

    void Ba(Intent intent);

    void L0(boolean z);

    void P(boolean z);

    void S(IObjectWrapper iObjectWrapper);

    void g0(boolean z);

    void l6(IObjectWrapper iObjectWrapper);

    void n2(boolean z);

    void x3(Intent intent, int i2);

    ObjectWrapper zzb();

    Bundle zzc();

    int zzd();

    IFragmentWrapper zze();

    ObjectWrapper zzf();

    boolean zzg();

    String zzh();

    IFragmentWrapper zzi();

    int zzj();

    boolean zzk();

    ObjectWrapper zzl();

    boolean zzm();

    boolean zzn();

    boolean zzo();

    boolean zzp();

    boolean zzq();

    boolean zzr();

    boolean zzs();
}
