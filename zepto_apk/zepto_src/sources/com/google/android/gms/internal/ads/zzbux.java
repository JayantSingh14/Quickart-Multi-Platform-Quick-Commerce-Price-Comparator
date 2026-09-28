package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes4.dex */
public abstract class zzbux extends zzbcc implements zzbuy {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f25576a = 0;

    public zzbux() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11, types: [com.google.android.gms.internal.ads.zzbup] */
    /* JADX WARN: Type inference failed for: r4v43, types: [com.google.android.gms.internal.ads.zzbuj] */
    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) throws RemoteException {
        zzbvb zzbuzVar;
        zzbun zzbunVar;
        zzbuh zzbuhVar;
        zzbvb zzbvbVar = null;
        zzbuh zzbuhVar2 = null;
        zzbus zzbuqVar = null;
        zzbum zzbukVar = null;
        zzbuv zzbutVar = null;
        zzbus zzbuqVar2 = null;
        zzbuv zzbutVar2 = null;
        zzbun zzbunVar2 = null;
        zzbum zzbukVar2 = null;
        if (i2 == 1) {
            IObjectWrapper iObjectWrapperG = IObjectWrapper.Stub.g(parcel.readStrongBinder());
            String string = parcel.readString();
            Parcelable.Creator creator = Bundle.CREATOR;
            Bundle bundle = (Bundle) zzbcd.b(parcel, creator);
            Bundle bundle2 = (Bundle) zzbcd.b(parcel, creator);
            com.google.android.gms.ads.internal.client.zzr zzrVar = (com.google.android.gms.ads.internal.client.zzr) zzbcd.b(parcel, com.google.android.gms.ads.internal.client.zzr.CREATOR);
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder == null) {
                zzbuzVar = zzbvbVar;
            } else {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
                if (iInterfaceQueryLocalInterface instanceof zzbvb) {
                    zzbvbVar = (zzbvb) iInterfaceQueryLocalInterface;
                    zzbuzVar = zzbvbVar;
                } else {
                    zzbuzVar = new zzbuz(strongBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
                }
            }
            zzbcd.f(parcel);
            ((zzbvl) this).A3(iObjectWrapperG, string, bundle, bundle2, zzrVar, zzbuzVar);
            parcel2.writeNoException();
            return true;
        }
        if (i2 == 2) {
            zzbvn zzbvnVarZzf = ((zzbvl) this).zzf();
            parcel2.writeNoException();
            zzbcd.d(parcel2, zzbvnVarZzf);
            return true;
        }
        if (i2 == 3) {
            zzbvn zzbvnVarZzg = ((zzbvl) this).zzg();
            parcel2.writeNoException();
            zzbcd.d(parcel2, zzbvnVarZzg);
            return true;
        }
        if (i2 == 5) {
            com.google.android.gms.ads.internal.client.zzed zzedVarZzh = ((zzbvl) this).zzh();
            parcel2.writeNoException();
            zzbcd.e(parcel2, zzedVarZzh);
            return true;
        }
        if (i2 == 10) {
            IObjectWrapper.Stub.g(parcel.readStrongBinder());
            zzbcd.f(parcel);
            parcel2.writeNoException();
            return true;
        }
        if (i2 == 11) {
            parcel.createStringArray();
            zzbcd.f(parcel);
            parcel2.writeNoException();
            return true;
        }
        switch (i2) {
            case 13:
                String string2 = parcel.readString();
                String string3 = parcel.readString();
                com.google.android.gms.ads.internal.client.zzm zzmVar = (com.google.android.gms.ads.internal.client.zzm) zzbcd.b(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                IObjectWrapper iObjectWrapperG2 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                    zzbukVar2 = iInterfaceQueryLocalInterface2 instanceof zzbum ? (zzbum) iInterfaceQueryLocalInterface2 : new zzbuk(strongBinder2);
                }
                zzbum zzbumVar = zzbukVar2;
                zzbtf zzbtfVarXb = zzbte.Xb(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzr zzrVar2 = (com.google.android.gms.ads.internal.client.zzr) zzbcd.b(parcel, com.google.android.gms.ads.internal.client.zzr.CREATOR);
                zzbcd.f(parcel);
                ((zzbvl) this).S3(string2, string3, zzmVar, iObjectWrapperG2, zzbumVar, zzbtfVarXb, zzrVar2);
                parcel2.writeNoException();
                return true;
            case 14:
                String string4 = parcel.readString();
                String string5 = parcel.readString();
                com.google.android.gms.ads.internal.client.zzm zzmVar2 = (com.google.android.gms.ads.internal.client.zzm) zzbcd.b(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                IObjectWrapper iObjectWrapperG3 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 == null) {
                    zzbunVar = zzbunVar2;
                } else {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
                    if (iInterfaceQueryLocalInterface3 instanceof zzbup) {
                        zzbunVar2 = (zzbup) iInterfaceQueryLocalInterface3;
                        zzbunVar = zzbunVar2;
                    } else {
                        zzbunVar = new zzbun(strongBinder3, "com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
                    }
                }
                zzbtf zzbtfVarXb2 = zzbte.Xb(parcel.readStrongBinder());
                zzbcd.f(parcel);
                ((zzbvl) this).f3(string4, string5, zzmVar2, iObjectWrapperG3, zzbunVar, zzbtfVarXb2);
                parcel2.writeNoException();
                return true;
            case 15:
                IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbcd.f(parcel);
                parcel2.writeNoException();
                parcel2.writeInt(0);
                return true;
            case 16:
                String string6 = parcel.readString();
                String string7 = parcel.readString();
                com.google.android.gms.ads.internal.client.zzm zzmVar3 = (com.google.android.gms.ads.internal.client.zzm) zzbcd.b(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                IObjectWrapper iObjectWrapperG4 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                    zzbutVar2 = iInterfaceQueryLocalInterface4 instanceof zzbuv ? (zzbuv) iInterfaceQueryLocalInterface4 : new zzbut(strongBinder4);
                }
                zzbuv zzbuvVar = zzbutVar2;
                zzbtf zzbtfVarXb3 = zzbte.Xb(parcel.readStrongBinder());
                zzbcd.f(parcel);
                ((zzbvl) this).n3(string6, string7, zzmVar3, iObjectWrapperG4, zzbuvVar, zzbtfVarXb3);
                parcel2.writeNoException();
                return true;
            case 17:
                IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbcd.f(parcel);
                parcel2.writeNoException();
                parcel2.writeInt(0);
                return true;
            case 18:
                String string8 = parcel.readString();
                String string9 = parcel.readString();
                com.google.android.gms.ads.internal.client.zzm zzmVar4 = (com.google.android.gms.ads.internal.client.zzm) zzbcd.b(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                IObjectWrapper iObjectWrapperG5 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
                    zzbuqVar2 = iInterfaceQueryLocalInterface5 instanceof zzbus ? (zzbus) iInterfaceQueryLocalInterface5 : new zzbuq(strongBinder5);
                }
                zzbus zzbusVar = zzbuqVar2;
                zzbtf zzbtfVarXb4 = zzbte.Xb(parcel.readStrongBinder());
                zzbcd.f(parcel);
                ((zzbvl) this).B1(string8, string9, zzmVar4, iObjectWrapperG5, zzbusVar, zzbtfVarXb4, null);
                parcel2.writeNoException();
                return true;
            case 19:
                parcel.readString();
                zzbcd.f(parcel);
                parcel2.writeNoException();
                return true;
            case 20:
                String string10 = parcel.readString();
                String string11 = parcel.readString();
                com.google.android.gms.ads.internal.client.zzm zzmVar5 = (com.google.android.gms.ads.internal.client.zzm) zzbcd.b(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                IObjectWrapper iObjectWrapperG6 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 != null) {
                    IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                    zzbutVar = iInterfaceQueryLocalInterface6 instanceof zzbuv ? (zzbuv) iInterfaceQueryLocalInterface6 : new zzbut(strongBinder6);
                }
                zzbuv zzbuvVar2 = zzbutVar;
                zzbtf zzbtfVarXb5 = zzbte.Xb(parcel.readStrongBinder());
                zzbcd.f(parcel);
                ((zzbvl) this).Pa(string10, string11, zzmVar5, iObjectWrapperG6, zzbuvVar2, zzbtfVarXb5);
                parcel2.writeNoException();
                return true;
            case 21:
                String string12 = parcel.readString();
                String string13 = parcel.readString();
                com.google.android.gms.ads.internal.client.zzm zzmVar6 = (com.google.android.gms.ads.internal.client.zzm) zzbcd.b(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                IObjectWrapper iObjectWrapperG7 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                IBinder strongBinder7 = parcel.readStrongBinder();
                if (strongBinder7 != null) {
                    IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                    zzbukVar = iInterfaceQueryLocalInterface7 instanceof zzbum ? (zzbum) iInterfaceQueryLocalInterface7 : new zzbuk(strongBinder7);
                }
                zzbum zzbumVar2 = zzbukVar;
                zzbtf zzbtfVarXb6 = zzbte.Xb(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzr zzrVar3 = (com.google.android.gms.ads.internal.client.zzr) zzbcd.b(parcel, com.google.android.gms.ads.internal.client.zzr.CREATOR);
                zzbcd.f(parcel);
                ((zzbvl) this).k8(string12, string13, zzmVar6, iObjectWrapperG7, zzbumVar2, zzbtfVarXb6, zzrVar3);
                parcel2.writeNoException();
                return true;
            case 22:
                String string14 = parcel.readString();
                String string15 = parcel.readString();
                com.google.android.gms.ads.internal.client.zzm zzmVar7 = (com.google.android.gms.ads.internal.client.zzm) zzbcd.b(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                IObjectWrapper iObjectWrapperG8 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                IBinder strongBinder8 = parcel.readStrongBinder();
                if (strongBinder8 != null) {
                    IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
                    zzbuqVar = iInterfaceQueryLocalInterface8 instanceof zzbus ? (zzbus) iInterfaceQueryLocalInterface8 : new zzbuq(strongBinder8);
                }
                zzbus zzbusVar2 = zzbuqVar;
                zzbtf zzbtfVarXb7 = zzbte.Xb(parcel.readStrongBinder());
                zzbjn zzbjnVar = (zzbjn) zzbcd.b(parcel, zzbjn.CREATOR);
                zzbcd.f(parcel);
                ((zzbvl) this).B1(string14, string15, zzmVar7, iObjectWrapperG8, zzbusVar2, zzbtfVarXb7, zzbjnVar);
                parcel2.writeNoException();
                return true;
            case 23:
                String string16 = parcel.readString();
                String string17 = parcel.readString();
                com.google.android.gms.ads.internal.client.zzm zzmVar8 = (com.google.android.gms.ads.internal.client.zzm) zzbcd.b(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                IObjectWrapper iObjectWrapperG9 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                IBinder strongBinder9 = parcel.readStrongBinder();
                if (strongBinder9 == null) {
                    zzbuhVar = zzbuhVar2;
                } else {
                    IInterface iInterfaceQueryLocalInterface9 = strongBinder9.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IAppOpenCallback");
                    if (iInterfaceQueryLocalInterface9 instanceof zzbuj) {
                        zzbuhVar2 = (zzbuj) iInterfaceQueryLocalInterface9;
                        zzbuhVar = zzbuhVar2;
                    } else {
                        zzbuhVar = new zzbuh(strongBinder9, "com.google.android.gms.ads.internal.mediation.client.rtb.IAppOpenCallback");
                    }
                }
                zzbtf zzbtfVarXb8 = zzbte.Xb(parcel.readStrongBinder());
                zzbcd.f(parcel);
                ((zzbvl) this).z4(string16, string17, zzmVar8, iObjectWrapperG9, zzbuhVar, zzbtfVarXb8);
                parcel2.writeNoException();
                return true;
            case 24:
                IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbcd.f(parcel);
                parcel2.writeNoException();
                parcel2.writeInt(0);
                return true;
            default:
                return false;
        }
    }
}
