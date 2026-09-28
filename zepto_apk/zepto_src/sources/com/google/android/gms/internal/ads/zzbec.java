package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes4.dex */
public abstract class zzbec extends zzbcc implements zzbed {
    public zzbec() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        zzcze zzczeVar;
        zzcze zzczeVar2;
        zzbek zzbeiVar = null;
        String strC = null;
        switch (i2) {
            case 2:
                parcel2.writeNoException();
                zzbcd.e(parcel2, ((zzcsx) this).f27077b);
                return true;
            case 3:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdPresentationCallback");
                    if (iInterfaceQueryLocalInterface instanceof zzbeh) {
                    }
                }
                zzbcd.f(parcel);
                parcel2.writeNoException();
                return true;
            case 4:
                IObjectWrapper iObjectWrapperG = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback");
                    zzbeiVar = iInterfaceQueryLocalInterface2 instanceof zzbek ? (zzbek) iInterfaceQueryLocalInterface2 : new zzbei(strongBinder2, "com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback");
                }
                zzbcd.f(parcel);
                ((zzcsx) this).K5(iObjectWrapperG, zzbeiVar);
                parcel2.writeNoException();
                return true;
            case 5:
                com.google.android.gms.ads.internal.client.zzea zzeaVarZzg = ((zzcsx) this).zzg();
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzeaVarZzg);
                return true;
            case 6:
                boolean zA = zzbcd.a(parcel);
                zzbcd.f(parcel);
                ((zzcsx) this).f27079d = zA;
                parcel2.writeNoException();
                return true;
            case 7:
                com.google.android.gms.ads.internal.client.zzdt zzdtVarXb = com.google.android.gms.ads.internal.client.zzds.Xb(parcel.readStrongBinder());
                zzbcd.f(parcel);
                zzcsx zzcsxVar = (zzcsx) this;
                Preconditions.checkMainThread("setOnPaidEventListener must be called on the main UI thread.");
                zzfdr zzfdrVar = zzcsxVar.f27078c;
                if (zzfdrVar != null) {
                    try {
                        if (!zzdtVarXb.zzf()) {
                            zzcsxVar.f27080e.b();
                        }
                    } catch (RemoteException e2) {
                        int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                        com.google.android.gms.ads.internal.util.client.zzo.b("Error in making CSI ping for reporting paid event callback", e2);
                    }
                    zzfdrVar.f30901g.set(zzdtVarXb);
                }
                parcel2.writeNoException();
                return true;
            case 8:
                try {
                    strC = ((zzcsx) this).f27077b.c();
                } catch (RemoteException e3) {
                    int i4 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
                }
                parcel2.writeNoException();
                parcel2.writeString(strC);
                return true;
            case 9:
                zzcsw zzcswVar = ((zzcsx) this).f27076a;
                long j2 = (zzcswVar == null || (zzczeVar = zzcswVar.f27236j) == null) ? 0L : zzczeVar.f27458a.get();
                parcel2.writeNoException();
                parcel2.writeLong(j2);
                return true;
            case 10:
                long j3 = parcel.readLong();
                zzbcd.f(parcel);
                zzcsw zzcswVar2 = ((zzcsx) this).f27076a;
                if (zzcswVar2 != null && (zzczeVar2 = zzcswVar2.f27236j) != null) {
                    zzczeVar2.a(j3);
                }
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
