package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes4.dex */
public abstract class zzbte extends zzbcc implements zzbtf {
    public zzbte() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    public static zzbtf Xb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
        return iInterfaceQueryLocalInterface instanceof zzbtf ? (zzbtf) iInterfaceQueryLocalInterface : new zzbtd(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        zzcac zzcaaVar;
        switch (i2) {
            case 1:
                zze();
                break;
            case 2:
                zzf();
                break;
            case 3:
                int i3 = parcel.readInt();
                zzbcd.f(parcel);
                zzg(i3);
                break;
            case 4:
                zzh();
                break;
            case 5:
                zzi();
                break;
            case 6:
                zzj();
                break;
            case 7:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    boolean z = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata") instanceof zzbtj;
                }
                zzbcd.f(parcel);
                break;
            case 8:
                zzk();
                break;
            case 9:
                String string = parcel.readString();
                String string2 = parcel.readString();
                zzbcd.f(parcel);
                V5(string, string2);
                break;
            case 10:
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
                    if (iInterfaceQueryLocalInterface instanceof zzbks) {
                    }
                }
                parcel.readString();
                zzbcd.f(parcel);
                break;
            case 11:
                Z0();
                break;
            case 12:
                parcel.readString();
                zzbcd.f(parcel);
                break;
            case 13:
                zzo();
                break;
            case 14:
                zzbzy zzbzyVar = (zzbzy) zzbcd.b(parcel, zzbzy.CREATOR);
                zzbcd.f(parcel);
                v8(zzbzyVar);
                break;
            case 15:
                B();
                break;
            case 16:
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 == null) {
                    zzcaaVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
                    zzcaaVar = iInterfaceQueryLocalInterface2 instanceof zzcac ? (zzcac) iInterfaceQueryLocalInterface2 : new zzcaa(strongBinder3);
                }
                zzbcd.f(parcel);
                hb(zzcaaVar);
                break;
            case 17:
                int i4 = parcel.readInt();
                zzbcd.f(parcel);
                K(i4);
                break;
            case 18:
                D4();
                break;
            case 19:
                zzbcd.f(parcel);
                break;
            case 20:
                p0();
                break;
            case 21:
                String string3 = parcel.readString();
                zzbcd.f(parcel);
                Y0(string3);
                break;
            case 22:
                int i5 = parcel.readInt();
                String string4 = parcel.readString();
                zzbcd.f(parcel);
                Qb(i5, string4);
                break;
            case 23:
                com.google.android.gms.ads.internal.client.zze zzeVar = (com.google.android.gms.ads.internal.client.zze) zzbcd.b(parcel, com.google.android.gms.ads.internal.client.zze.CREATOR);
                zzbcd.f(parcel);
                H1(zzeVar);
                break;
            case 24:
                com.google.android.gms.ads.internal.client.zze zzeVar2 = (com.google.android.gms.ads.internal.client.zze) zzbcd.b(parcel, com.google.android.gms.ads.internal.client.zze.CREATOR);
                zzbcd.f(parcel);
                o2(zzeVar2);
                break;
            case 25:
                m0();
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
