package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes4.dex */
public abstract class zzbzo extends zzbcc implements zzbzp {
    public zzbzo() {
        super("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        com.google.android.gms.ads.internal.client.zzcb zzbzVar;
        Bundle bundle;
        zzcir zzcirVar;
        zzdte zzdteVar;
        if (i2 == 1) {
            zzbzt zzbztVar = (zzbzt) zzbcd.b(parcel, zzbzt.CREATOR);
            zzbcd.f(parcel);
            ((zzfho) this).Xb(zzbztVar);
            parcel2.writeNoException();
            return true;
        }
        if (i2 == 2) {
            ((zzfho) this).zzc();
            parcel2.writeNoException();
            return true;
        }
        IInterface zzbzqVar = null;
        if (i2 == 3) {
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder != null) {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
                zzbzqVar = iInterfaceQueryLocalInterface instanceof zzbzs ? (zzbzs) iInterfaceQueryLocalInterface : new zzbzq(strongBinder);
            }
            zzbcd.f(parcel);
            Preconditions.checkMainThread("setRewardedVideoAdListener can only be called from the UI thread.");
            ((zzfho) this).f31137b.f31080e.set(zzbzqVar);
            parcel2.writeNoException();
            return true;
        }
        if (i2 == 34) {
            boolean zA = zzbcd.a(parcel);
            zzbcd.f(parcel);
            zzfho zzfhoVar = (zzfho) this;
            synchronized (zzfhoVar) {
                Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
                zzfhoVar.f31140e = zA;
            }
            parcel2.writeNoException();
            return true;
        }
        int i3 = 0;
        switch (i2) {
            case 5:
                Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
                boolean zZb = ((zzfho) this).Zb();
                parcel2.writeNoException();
                ClassLoader classLoader = zzbcd.f24690a;
                parcel2.writeInt(zZb ? 1 : 0);
                return true;
            case 6:
                ((zzfho) this).zzi(null);
                parcel2.writeNoException();
                return true;
            case 7:
                ((zzfho) this).ua(null);
                parcel2.writeNoException();
                return true;
            case 8:
                ((zzfho) this).Yb(null);
                parcel2.writeNoException();
                return true;
            case 9:
                ((zzfho) this).zzi(android.support.v4.media.a.g(parcel, parcel));
                parcel2.writeNoException();
                return true;
            case 10:
                ((zzfho) this).ua(android.support.v4.media.a.g(parcel, parcel));
                parcel2.writeNoException();
                return true;
            case 11:
                ((zzfho) this).Yb(android.support.v4.media.a.g(parcel, parcel));
                parcel2.writeNoException();
                return true;
            case 12:
                String strZzl = ((zzfho) this).zzl();
                parcel2.writeNoException();
                parcel2.writeString(strZzl);
                return true;
            case 13:
                String string = parcel.readString();
                zzbcd.f(parcel);
                zzfho zzfhoVar2 = (zzfho) this;
                synchronized (zzfhoVar2) {
                    Preconditions.checkMainThread("setUserId must be called on the main UI thread.");
                    zzfhoVar2.f31138c.f31195a = string;
                }
                parcel2.writeNoException();
                return true;
            case 14:
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 == null) {
                    zzbzVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdMetadataListener");
                    zzbzVar = iInterfaceQueryLocalInterface2 instanceof com.google.android.gms.ads.internal.client.zzcb ? (com.google.android.gms.ads.internal.client.zzcb) iInterfaceQueryLocalInterface2 : new com.google.android.gms.ads.internal.client.zzbz(strongBinder2, "com.google.android.gms.ads.internal.client.IAdMetadataListener");
                }
                zzbcd.f(parcel);
                zzfho zzfhoVar3 = (zzfho) this;
                Preconditions.checkMainThread("setAdMetadataListener can only be called from the UI thread.");
                zzfgv zzfgvVar = zzfhoVar3.f31137b;
                if (zzbzVar == null) {
                    zzfgvVar.f31077b.set(null);
                } else {
                    zzfgvVar.f31077b.set(new zzfhn(zzfhoVar3, zzbzVar));
                }
                parcel2.writeNoException();
                return true;
            case 15:
                Preconditions.checkMainThread("getAdMetadata can only be called from the UI thread.");
                zzdte zzdteVar2 = ((zzfho) this).f31139d;
                if (zzdteVar2 != null) {
                    zzdce zzdceVar = zzdteVar2.q;
                    synchronized (zzdceVar) {
                        bundle = new Bundle(zzdceVar.f27604b);
                    }
                } else {
                    bundle = new Bundle();
                }
                parcel2.writeNoException();
                zzbcd.d(parcel2, bundle);
                return true;
            case 16:
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener");
                    zzbzqVar = iInterfaceQueryLocalInterface3 instanceof zzbzn ? (zzbzn) iInterfaceQueryLocalInterface3 : new zzbzn(strongBinder3, "com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener");
                }
                zzbcd.f(parcel);
                Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setRewardedAdSkuListener");
                ((zzfho) this).f31137b.f31082g.set(zzbzqVar);
                parcel2.writeNoException();
                return true;
            case 17:
                parcel.readString();
                zzbcd.f(parcel);
                parcel2.writeNoException();
                return true;
            case 18:
                ((zzfho) this).zzp(android.support.v4.media.a.g(parcel, parcel));
                parcel2.writeNoException();
                return true;
            case 19:
                String string2 = parcel.readString();
                zzbcd.f(parcel);
                zzfho zzfhoVar4 = (zzfho) this;
                synchronized (zzfhoVar4) {
                    Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setCustomData");
                    zzfhoVar4.f31138c.f31196b = string2;
                }
                parcel2.writeNoException();
                return true;
            case 20:
                zzdte zzdteVar3 = ((zzfho) this).f31139d;
                if (zzdteVar3 != null && (zzcirVar = (zzcir) zzdteVar3.f28519m.get()) != null && !zzcirVar.B()) {
                    i3 = 1;
                }
                parcel2.writeNoException();
                ClassLoader classLoader2 = zzbcd.f24690a;
                parcel2.writeInt(i3);
                return true;
            case 21:
                zzfho zzfhoVar5 = (zzfho) this;
                synchronized (zzfhoVar5) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.s7)).booleanValue() && (zzdteVar = zzfhoVar5.f31139d) != null) {
                        zzbzqVar = zzdteVar.f27232f;
                    }
                }
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzbzqVar);
                return true;
            default:
                return false;
        }
    }
}
