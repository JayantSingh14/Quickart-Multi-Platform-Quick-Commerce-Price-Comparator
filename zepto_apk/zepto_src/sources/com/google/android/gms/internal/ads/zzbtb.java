package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import org.xbill.DNS.Type;

/* loaded from: classes4.dex */
public abstract class zzbtb extends zzbcc implements zzbtc {
    public zzbtb() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) throws RemoteException {
        zzbzx zzbzvVar;
        zzbkt zzbktVar;
        zzbtf zzbtdVar = null;
        zzbtf zzbtdVar2 = null;
        zzbtf zzbtdVar3 = null;
        zzbtf zzbtdVar4 = null;
        zzbpq zzbpoVar = null;
        zzbtf zzbtdVar5 = null;
        zzbksVar = null;
        zzbks zzbksVar = null;
        zzbtf zzbtdVar6 = null;
        zzbzx zzbzvVar2 = null;
        zzbtf zzbtdVar7 = null;
        zzbtf zzbtdVar8 = null;
        zzbtf zzbtdVar9 = null;
        switch (i2) {
            case 1:
                IObjectWrapper iObjectWrapperG = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzr zzrVar = (com.google.android.gms.ads.internal.client.zzr) zzbcd.b(parcel, com.google.android.gms.ads.internal.client.zzr.CREATOR);
                com.google.android.gms.ads.internal.client.zzm zzmVar = (com.google.android.gms.ads.internal.client.zzm) zzbcd.b(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                String string = parcel.readString();
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzbtdVar = iInterfaceQueryLocalInterface instanceof zzbtf ? (zzbtf) iInterfaceQueryLocalInterface : new zzbtd(strongBinder);
                }
                zzbtf zzbtfVar = zzbtdVar;
                zzbcd.f(parcel);
                ((zzbua) this).b4(iObjectWrapperG, zzrVar, zzmVar, string, null, zzbtfVar);
                parcel2.writeNoException();
                return true;
            case 2:
                IObjectWrapper iObjectWrapperZzf = ((zzbua) this).zzf();
                parcel2.writeNoException();
                zzbcd.e(parcel2, iObjectWrapperZzf);
                return true;
            case 3:
                IObjectWrapper iObjectWrapperG2 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzm zzmVar2 = (com.google.android.gms.ads.internal.client.zzm) zzbcd.b(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                String string2 = parcel.readString();
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzbtdVar9 = iInterfaceQueryLocalInterface2 instanceof zzbtf ? (zzbtf) iInterfaceQueryLocalInterface2 : new zzbtd(strongBinder2);
                }
                zzbtf zzbtfVar2 = zzbtdVar9;
                zzbcd.f(parcel);
                ((zzbua) this).a4(iObjectWrapperG2, zzmVar2, string2, null, zzbtfVar2);
                parcel2.writeNoException();
                return true;
            case 4:
                ((zzbua) this).zzh();
                parcel2.writeNoException();
                return true;
            case 5:
                ((zzbua) this).zzi();
                parcel2.writeNoException();
                return true;
            case 6:
                IObjectWrapper iObjectWrapperG3 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzr zzrVar2 = (com.google.android.gms.ads.internal.client.zzr) zzbcd.b(parcel, com.google.android.gms.ads.internal.client.zzr.CREATOR);
                com.google.android.gms.ads.internal.client.zzm zzmVar3 = (com.google.android.gms.ads.internal.client.zzm) zzbcd.b(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzbtdVar8 = iInterfaceQueryLocalInterface3 instanceof zzbtf ? (zzbtf) iInterfaceQueryLocalInterface3 : new zzbtd(strongBinder3);
                }
                zzbtf zzbtfVar3 = zzbtdVar8;
                zzbcd.f(parcel);
                ((zzbua) this).b4(iObjectWrapperG3, zzrVar2, zzmVar3, string3, string4, zzbtfVar3);
                parcel2.writeNoException();
                return true;
            case 7:
                IObjectWrapper iObjectWrapperG4 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzm zzmVar4 = (com.google.android.gms.ads.internal.client.zzm) zzbcd.b(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzbtdVar7 = iInterfaceQueryLocalInterface4 instanceof zzbtf ? (zzbtf) iInterfaceQueryLocalInterface4 : new zzbtd(strongBinder4);
                }
                zzbtf zzbtfVar4 = zzbtdVar7;
                zzbcd.f(parcel);
                ((zzbua) this).a4(iObjectWrapperG4, zzmVar4, string5, string6, zzbtfVar4);
                parcel2.writeNoException();
                return true;
            case 8:
                ((zzbua) this).zzl();
                parcel2.writeNoException();
                return true;
            case 9:
                ((zzbua) this).zzm();
                parcel2.writeNoException();
                return true;
            case 10:
                IObjectWrapper iObjectWrapperG5 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzm zzmVar5 = (com.google.android.gms.ads.internal.client.zzm) zzbcd.b(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                parcel.readString();
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    zzbzvVar2 = iInterfaceQueryLocalInterface5 instanceof zzbzx ? (zzbzx) iInterfaceQueryLocalInterface5 : new zzbzv(strongBinder5, "com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                }
                String string7 = parcel.readString();
                zzbcd.f(parcel);
                ((zzbua) this).i8(iObjectWrapperG5, zzmVar5, zzbzvVar2, string7);
                parcel2.writeNoException();
                return true;
            case 11:
                com.google.android.gms.ads.internal.client.zzm zzmVar6 = (com.google.android.gms.ads.internal.client.zzm) zzbcd.b(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                String string8 = parcel.readString();
                zzbcd.f(parcel);
                ((zzbua) this).bc(zzmVar6, string8);
                parcel2.writeNoException();
                return true;
            case 12:
                ((zzbua) this).e1();
                throw null;
            case 13:
                boolean zZzq = ((zzbua) this).zzq();
                parcel2.writeNoException();
                ClassLoader classLoader = zzbcd.f24690a;
                parcel2.writeInt(zZzq ? 1 : 0);
                return true;
            case 14:
                IObjectWrapper iObjectWrapperG6 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzm zzmVar7 = (com.google.android.gms.ads.internal.client.zzm) zzbcd.b(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                String string9 = parcel.readString();
                String string10 = parcel.readString();
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 != null) {
                    IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzbtdVar6 = iInterfaceQueryLocalInterface6 instanceof zzbtf ? (zzbtf) iInterfaceQueryLocalInterface6 : new zzbtd(strongBinder6);
                }
                zzbtf zzbtfVar5 = zzbtdVar6;
                zzbjn zzbjnVar = (zzbjn) zzbcd.b(parcel, zzbjn.CREATOR);
                ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
                zzbcd.f(parcel);
                ((zzbua) this).E8(iObjectWrapperG6, zzmVar7, string9, string10, zzbtfVar5, zzbjnVar, arrayListCreateStringArrayList);
                parcel2.writeNoException();
                return true;
            case 15:
                parcel2.writeNoException();
                ClassLoader classLoader2 = zzbcd.f24690a;
                parcel2.writeStrongBinder(null);
                return true;
            case 16:
                parcel2.writeNoException();
                ClassLoader classLoader3 = zzbcd.f24690a;
                parcel2.writeStrongBinder(null);
                return true;
            case 17:
                Bundle bundle = new Bundle();
                parcel2.writeNoException();
                zzbcd.d(parcel2, bundle);
                return true;
            case 18:
                Bundle bundle2 = new Bundle();
                parcel2.writeNoException();
                zzbcd.d(parcel2, bundle2);
                return true;
            case 19:
                Bundle bundle3 = new Bundle();
                parcel2.writeNoException();
                zzbcd.d(parcel2, bundle3);
                return true;
            case 20:
                com.google.android.gms.ads.internal.client.zzm zzmVar8 = (com.google.android.gms.ads.internal.client.zzm) zzbcd.b(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                String string11 = parcel.readString();
                parcel.readString();
                zzbcd.f(parcel);
                ((zzbua) this).bc(zzmVar8, string11);
                parcel2.writeNoException();
                return true;
            case 21:
                ((zzbua) this).R0(android.support.v4.media.a.g(parcel, parcel));
                parcel2.writeNoException();
                return true;
            case 22:
                parcel2.writeNoException();
                ClassLoader classLoader4 = zzbcd.f24690a;
                parcel2.writeInt(0);
                return true;
            case 23:
                IObjectWrapper iObjectWrapperG7 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                IBinder strongBinder7 = parcel.readStrongBinder();
                if (strongBinder7 != null) {
                    IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                    zzbzvVar = iInterfaceQueryLocalInterface7 instanceof zzbzx ? (zzbzx) iInterfaceQueryLocalInterface7 : new zzbzv(strongBinder7, "com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
                } else {
                    zzbzvVar = null;
                }
                ArrayList<String> arrayListCreateStringArrayList2 = parcel.createStringArrayList();
                zzbcd.f(parcel);
                ((zzbua) this).g4(iObjectWrapperG7, zzbzvVar, arrayListCreateStringArrayList2);
                throw null;
            case 24:
                zzbuc zzbucVar = ((zzbua) this).f25560b;
                if (zzbucVar != null && (zzbktVar = zzbucVar.f25565c) != null) {
                    zzbksVar = zzbktVar.f25285a;
                }
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzbksVar);
                return true;
            case 25:
                boolean zA = zzbcd.a(parcel);
                zzbcd.f(parcel);
                ((zzbua) this).w0(zA);
                parcel2.writeNoException();
                return true;
            case 26:
                com.google.android.gms.ads.internal.client.zzed zzedVarT = ((zzbua) this).t();
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzedVarT);
                return true;
            case 27:
                zzbto zzbtoVarV = ((zzbua) this).v();
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzbtoVarV);
                return true;
            case 28:
                IObjectWrapper iObjectWrapperG8 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzm zzmVar9 = (com.google.android.gms.ads.internal.client.zzm) zzbcd.b(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                String string12 = parcel.readString();
                IBinder strongBinder8 = parcel.readStrongBinder();
                if (strongBinder8 != null) {
                    IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzbtdVar5 = iInterfaceQueryLocalInterface8 instanceof zzbtf ? (zzbtf) iInterfaceQueryLocalInterface8 : new zzbtd(strongBinder8);
                }
                zzbcd.f(parcel);
                ((zzbua) this).A1(iObjectWrapperG8, zzmVar9, string12, zzbtdVar5);
                parcel2.writeNoException();
                return true;
            case 29:
            default:
                return false;
            case 30:
                ((zzbua) this).Y8(android.support.v4.media.a.g(parcel, parcel));
                throw null;
            case 31:
                IObjectWrapper iObjectWrapperG9 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                IBinder strongBinder9 = parcel.readStrongBinder();
                if (strongBinder9 != null) {
                    IInterface iInterfaceQueryLocalInterface9 = strongBinder9.queryLocalInterface("com.google.android.gms.ads.internal.initialization.IAdapterInitializationCallback");
                    zzbpoVar = iInterfaceQueryLocalInterface9 instanceof zzbpq ? (zzbpq) iInterfaceQueryLocalInterface9 : new zzbpo(strongBinder9, "com.google.android.gms.ads.internal.initialization.IAdapterInitializationCallback");
                }
                ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(zzbpw.CREATOR);
                zzbcd.f(parcel);
                ((zzbua) this).O2(iObjectWrapperG9, zzbpoVar, arrayListCreateTypedArrayList);
                parcel2.writeNoException();
                return true;
            case 32:
                IObjectWrapper iObjectWrapperG10 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzm zzmVar10 = (com.google.android.gms.ads.internal.client.zzm) zzbcd.b(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                String string13 = parcel.readString();
                IBinder strongBinder10 = parcel.readStrongBinder();
                if (strongBinder10 != null) {
                    IInterface iInterfaceQueryLocalInterface10 = strongBinder10.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzbtdVar4 = iInterfaceQueryLocalInterface10 instanceof zzbtf ? (zzbtf) iInterfaceQueryLocalInterface10 : new zzbtd(strongBinder10);
                }
                zzbcd.f(parcel);
                ((zzbua) this).cb(iObjectWrapperG10, zzmVar10, string13, zzbtdVar4);
                parcel2.writeNoException();
                return true;
            case 33:
                zzbvn zzbvnVarM = ((zzbua) this).m();
                parcel2.writeNoException();
                zzbcd.d(parcel2, zzbvnVarM);
                return true;
            case 34:
                zzbvn zzbvnVarU = ((zzbua) this).U();
                parcel2.writeNoException();
                zzbcd.d(parcel2, zzbvnVarU);
                return true;
            case 35:
                IObjectWrapper iObjectWrapperG11 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzr zzrVar3 = (com.google.android.gms.ads.internal.client.zzr) zzbcd.b(parcel, com.google.android.gms.ads.internal.client.zzr.CREATOR);
                com.google.android.gms.ads.internal.client.zzm zzmVar11 = (com.google.android.gms.ads.internal.client.zzm) zzbcd.b(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                String string14 = parcel.readString();
                String string15 = parcel.readString();
                IBinder strongBinder11 = parcel.readStrongBinder();
                if (strongBinder11 != null) {
                    IInterface iInterfaceQueryLocalInterface11 = strongBinder11.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzbtdVar3 = iInterfaceQueryLocalInterface11 instanceof zzbtf ? (zzbtf) iInterfaceQueryLocalInterface11 : new zzbtd(strongBinder11);
                }
                zzbtf zzbtfVar6 = zzbtdVar3;
                zzbcd.f(parcel);
                ((zzbua) this).K2(iObjectWrapperG11, zzrVar3, zzmVar11, string14, string15, zzbtfVar6);
                parcel2.writeNoException();
                return true;
            case 36:
                parcel2.writeNoException();
                ClassLoader classLoader5 = zzbcd.f24690a;
                parcel2.writeStrongBinder(null);
                return true;
            case 37:
                ((zzbua) this).D2(android.support.v4.media.a.g(parcel, parcel));
                parcel2.writeNoException();
                return true;
            case Type.A6 /* 38 */:
                IObjectWrapper iObjectWrapperG12 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzm zzmVar12 = (com.google.android.gms.ads.internal.client.zzm) zzbcd.b(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                String string16 = parcel.readString();
                IBinder strongBinder12 = parcel.readStrongBinder();
                if (strongBinder12 != null) {
                    IInterface iInterfaceQueryLocalInterface12 = strongBinder12.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzbtdVar2 = iInterfaceQueryLocalInterface12 instanceof zzbtf ? (zzbtf) iInterfaceQueryLocalInterface12 : new zzbtd(strongBinder12);
                }
                zzbcd.f(parcel);
                ((zzbua) this).l7(iObjectWrapperG12, zzmVar12, string16, zzbtdVar2);
                parcel2.writeNoException();
                return true;
            case 39:
                ((zzbua) this).n4(android.support.v4.media.a.g(parcel, parcel));
                throw null;
        }
    }
}
