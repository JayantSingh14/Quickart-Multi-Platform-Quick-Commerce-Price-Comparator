package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public abstract class zzbym extends zzbcc implements zzbyn {
    public zzbym() {
        super("com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) throws RemoteException {
        zzbyr zzbypVar = null;
        zzbys zzbysVar = null;
        zzbyr zzbypVar2 = null;
        zzbyr zzbypVar3 = null;
        zzbyr zzbypVar4 = null;
        switch (i2) {
            case 1:
                zzbcd.f(parcel);
                parcel2.writeNoException();
                parcel2.writeInt(0);
                return true;
            case 2:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
                    if (iInterfaceQueryLocalInterface instanceof zzbyo) {
                    }
                }
                zzbcd.f(parcel);
                parcel2.writeNoException();
                return true;
            case 3:
            default:
                return false;
            case 4:
                zzbza zzbzaVar = (zzbza) zzbcd.b(parcel, zzbza.CREATOR);
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    zzbypVar = iInterfaceQueryLocalInterface2 instanceof zzbyr ? (zzbyr) iInterfaceQueryLocalInterface2 : new zzbyp(strongBinder2);
                }
                zzbcd.f(parcel);
                ((zzefw) this).r3(zzbzaVar, zzbypVar);
                parcel2.writeNoException();
                return true;
            case 5:
                zzbza zzbzaVar2 = (zzbza) zzbcd.b(parcel, zzbza.CREATOR);
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    zzbypVar4 = iInterfaceQueryLocalInterface3 instanceof zzbyr ? (zzbyr) iInterfaceQueryLocalInterface3 : new zzbyp(strongBinder3);
                }
                zzbcd.f(parcel);
                ((zzefw) this).Ea(zzbzaVar2, zzbypVar4);
                parcel2.writeNoException();
                return true;
            case 6:
                zzbza zzbzaVar3 = (zzbza) zzbcd.b(parcel, zzbza.CREATOR);
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    zzbypVar3 = iInterfaceQueryLocalInterface4 instanceof zzbyr ? (zzbyr) iInterfaceQueryLocalInterface4 : new zzbyp(strongBinder4);
                }
                zzbcd.f(parcel);
                ((zzefw) this).I9(zzbzaVar3, zzbypVar3);
                parcel2.writeNoException();
                return true;
            case 7:
                String string = parcel.readString();
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    zzbypVar2 = iInterfaceQueryLocalInterface5 instanceof zzbyr ? (zzbyr) iInterfaceQueryLocalInterface5 : new zzbyp(strongBinder5);
                }
                zzbcd.f(parcel);
                ((zzefw) this).Vb(string, zzbypVar2);
                parcel2.writeNoException();
                return true;
            case 8:
                zzbyj zzbyjVar = (zzbyj) zzbcd.b(parcel, zzbyj.CREATOR);
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 != null) {
                    IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.request.ITrustlessTokenListener");
                    zzbysVar = iInterfaceQueryLocalInterface6 instanceof zzbys ? (zzbys) iInterfaceQueryLocalInterface6 : new zzbys(strongBinder6, "com.google.android.gms.ads.internal.request.ITrustlessTokenListener");
                }
                zzbcd.f(parcel);
                zzefw zzefwVar = (zzefw) this;
                if (((Boolean) zzbiz.f25224a.c()).booleanValue()) {
                    zzefwVar.f29247d.e();
                    String str = zzbyjVar.f25705a;
                    ListenableFuture listenableFuture = zzgyq.f33377b;
                    zzeff zzeffVar = new zzeff(zzefwVar, zzbysVar, zzbyjVar);
                    ((zzgyq) listenableFuture).q(new zzgyk(listenableFuture, zzeffVar), zzcdo.f25988g);
                } else {
                    try {
                        Parcel parcelG = zzbysVar.g();
                        parcelG.writeString("");
                        zzbcd.c(parcelG, zzbyjVar);
                        zzbysVar.j1(1, parcelG);
                    } catch (RemoteException e2) {
                        com.google.android.gms.ads.internal.util.zze.l("Service can't call client", e2);
                    }
                }
                parcel2.writeNoException();
                return true;
            case 9:
                String string2 = parcel.readString();
                zzbcd.f(parcel);
                ((zzefw) this).zzi(string2);
                parcel2.writeNoException();
                return true;
        }
    }
}
