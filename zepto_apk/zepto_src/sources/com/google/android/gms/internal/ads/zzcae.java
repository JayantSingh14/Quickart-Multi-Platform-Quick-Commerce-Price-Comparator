package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes4.dex */
public abstract class zzcae extends zzbcc implements zzcaf {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f25787a = 0;

    public zzcae() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        zzcam zzcakVar = null;
        zzcam zzcakVar2 = null;
        com.google.android.gms.ads.internal.client.zzdq zzdoVar = null;
        zzcan zzcanVar = null;
        zzcai zzcagVar = null;
        switch (i2) {
            case 1:
                com.google.android.gms.ads.internal.client.zzm zzmVar = (com.google.android.gms.ads.internal.client.zzm) zzbcd.b(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
                    zzcakVar = iInterfaceQueryLocalInterface instanceof zzcam ? (zzcam) iInterfaceQueryLocalInterface : new zzcak(strongBinder);
                }
                zzbcd.f(parcel);
                I5(zzmVar, zzcakVar);
                parcel2.writeNoException();
                return true;
            case 2:
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
                    zzcagVar = iInterfaceQueryLocalInterface2 instanceof zzcai ? (zzcai) iInterfaceQueryLocalInterface2 : new zzcag(strongBinder2, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
                }
                zzbcd.f(parcel);
                q5(zzcagVar);
                parcel2.writeNoException();
                return true;
            case 3:
                boolean zZzi = zzi();
                parcel2.writeNoException();
                ClassLoader classLoader = zzbcd.f24690a;
                parcel2.writeInt(zZzi ? 1 : 0);
                return true;
            case 4:
                String strZzj = zzj();
                parcel2.writeNoException();
                parcel2.writeString(strZzj);
                return true;
            case 5:
                IObjectWrapper iObjectWrapperG = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbcd.f(parcel);
                N(iObjectWrapperG);
                parcel2.writeNoException();
                return true;
            case 6:
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener");
                    zzcanVar = iInterfaceQueryLocalInterface3 instanceof zzcan ? (zzcan) iInterfaceQueryLocalInterface3 : new zzcan(strongBinder3, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener");
                }
                zzbcd.f(parcel);
                O3(zzcanVar);
                parcel2.writeNoException();
                return true;
            case 7:
                zzcat zzcatVar = (zzcat) zzbcd.b(parcel, zzcat.CREATOR);
                zzbcd.f(parcel);
                v6(zzcatVar);
                parcel2.writeNoException();
                return true;
            case 8:
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnAdMetadataChangedListener");
                    zzdoVar = iInterfaceQueryLocalInterface4 instanceof com.google.android.gms.ads.internal.client.zzdq ? (com.google.android.gms.ads.internal.client.zzdq) iInterfaceQueryLocalInterface4 : new com.google.android.gms.ads.internal.client.zzdo(strongBinder4, "com.google.android.gms.ads.internal.client.IOnAdMetadataChangedListener");
                }
                zzbcd.f(parcel);
                b9(zzdoVar);
                parcel2.writeNoException();
                return true;
            case 9:
                Bundle bundleZzg = zzg();
                parcel2.writeNoException();
                zzbcd.d(parcel2, bundleZzg);
                return true;
            case 10:
                IObjectWrapper iObjectWrapperG2 = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                ClassLoader classLoader2 = zzbcd.f24690a;
                boolean z = parcel.readInt() != 0;
                zzbcd.f(parcel);
                V6(iObjectWrapperG2, z);
                parcel2.writeNoException();
                return true;
            case 11:
                zzcac zzcacVarZzl = zzl();
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzcacVarZzl);
                return true;
            case 12:
                com.google.android.gms.ads.internal.client.zzea zzeaVarZzm = zzm();
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzeaVarZzm);
                return true;
            case 13:
                com.google.android.gms.ads.internal.client.zzdt zzdtVarXb = com.google.android.gms.ads.internal.client.zzds.Xb(parcel.readStrongBinder());
                zzbcd.f(parcel);
                Ta(zzdtVarXb);
                parcel2.writeNoException();
                return true;
            case 14:
                com.google.android.gms.ads.internal.client.zzm zzmVar2 = (com.google.android.gms.ads.internal.client.zzm) zzbcd.b(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
                    zzcakVar2 = iInterfaceQueryLocalInterface5 instanceof zzcam ? (zzcam) iInterfaceQueryLocalInterface5 : new zzcak(strongBinder5);
                }
                zzbcd.f(parcel);
                a5(zzmVar2, zzcakVar2);
                parcel2.writeNoException();
                return true;
            case 15:
                boolean zA = zzbcd.a(parcel);
                zzbcd.f(parcel);
                f0(zA);
                parcel2.writeNoException();
                return true;
            case 16:
                String strZzn = zzn();
                parcel2.writeNoException();
                parcel2.writeString(strZzn);
                return true;
            case 17:
                long jZzq = zzq();
                parcel2.writeNoException();
                parcel2.writeLong(jZzq);
                return true;
            case 18:
                long j2 = parcel.readLong();
                zzbcd.f(parcel);
                fa(j2);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
