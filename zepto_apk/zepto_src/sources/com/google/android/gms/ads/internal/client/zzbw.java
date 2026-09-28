package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbcc;
import com.google.android.gms.internal.ads.zzbcd;
import com.google.android.gms.internal.ads.zzbee;
import com.google.android.gms.internal.ads.zzbeg;
import com.google.android.gms.internal.ads.zzbhd;
import com.google.android.gms.internal.ads.zzbhf;
import com.google.android.gms.internal.ads.zzbxh;
import com.google.android.gms.internal.ads.zzbxk;
import com.google.android.gms.internal.ads.zzbzq;
import com.google.android.gms.internal.ads.zzbzs;
import org.xbill.DNS.Type;

/* loaded from: classes4.dex */
public abstract class zzbw extends zzbcc implements zzbx {
    public zzbw() {
        super("com.google.android.gms.ads.internal.client.IAdManager");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        zzbk zzbiVar = null;
        zzcv zzctVar = null;
        zzbn zzblVar = null;
        zzdt zzdrVar = null;
        zzbeg zzbeeVar = null;
        zzbzs zzbzqVar = null;
        zzcs zzcsVar = null;
        zzbh zzbfVar = null;
        zzbhf zzbhdVar = null;
        zzco zzcmVar = null;
        switch (i2) {
            case 1:
                IObjectWrapper iObjectWrapperZzb = zzb();
                parcel2.writeNoException();
                zzbcd.e(parcel2, iObjectWrapperZzb);
                return true;
            case 2:
                zzc();
                parcel2.writeNoException();
                return true;
            case 3:
                boolean zZzd = zzd();
                parcel2.writeNoException();
                ClassLoader classLoader = zzbcd.f24690a;
                parcel2.writeInt(zZzd ? 1 : 0);
                return true;
            case 4:
                zzm zzmVar = (zzm) zzbcd.b(parcel, zzm.CREATOR);
                zzbcd.f(parcel);
                boolean zU0 = U0(zzmVar);
                parcel2.writeNoException();
                parcel2.writeInt(zU0 ? 1 : 0);
                return true;
            case 5:
                zzf();
                parcel2.writeNoException();
                return true;
            case 6:
                zzg();
                parcel2.writeNoException();
                return true;
            case 7:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    zzbiVar = iInterfaceQueryLocalInterface instanceof zzbk ? (zzbk) iInterfaceQueryLocalInterface : new zzbi(strongBinder);
                }
                zzbcd.f(parcel);
                Q4(zzbiVar);
                parcel2.writeNoException();
                return true;
            case 8:
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
                    zzcmVar = iInterfaceQueryLocalInterface2 instanceof zzco ? (zzco) iInterfaceQueryLocalInterface2 : new zzcm(strongBinder2);
                }
                zzbcd.f(parcel);
                J6(zzcmVar);
                parcel2.writeNoException();
                return true;
            case 9:
                zzl();
                parcel2.writeNoException();
                return true;
            case 10:
                parcel2.writeNoException();
                return true;
            case 11:
                zzm();
                parcel2.writeNoException();
                return true;
            case 12:
                zzr zzrVarZzn = zzn();
                parcel2.writeNoException();
                zzbcd.d(parcel2, zzrVarZzn);
                return true;
            case 13:
                zzr zzrVar = (zzr) zzbcd.b(parcel, zzr.CREATOR);
                zzbcd.f(parcel);
                w4(zzrVar);
                parcel2.writeNoException();
                return true;
            case 14:
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
                    if (iInterfaceQueryLocalInterface3 instanceof zzbxh) {
                    }
                }
                zzbcd.f(parcel);
                zzp();
                parcel2.writeNoException();
                return true;
            case 15:
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
                    if (iInterfaceQueryLocalInterface4 instanceof zzbxk) {
                    }
                }
                parcel.readString();
                zzbcd.f(parcel);
                zzq();
                parcel2.writeNoException();
                return true;
            case 16:
            case 17:
            case 27:
            case 28:
            default:
                return false;
            case 18:
                String strZzr = zzr();
                parcel2.writeNoException();
                parcel2.writeString(strZzr);
                return true;
            case 19:
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
                    zzbhdVar = iInterfaceQueryLocalInterface5 instanceof zzbhf ? (zzbhf) iInterfaceQueryLocalInterface5 : new zzbhd(strongBinder5, "com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
                }
                zzbcd.f(parcel);
                b2(zzbhdVar);
                parcel2.writeNoException();
                return true;
            case 20:
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 != null) {
                    IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdClickListener");
                    zzbfVar = iInterfaceQueryLocalInterface6 instanceof zzbh ? (zzbh) iInterfaceQueryLocalInterface6 : new zzbf(strongBinder6, "com.google.android.gms.ads.internal.client.IAdClickListener");
                }
                zzbcd.f(parcel);
                o8(zzbfVar);
                parcel2.writeNoException();
                return true;
            case 21:
                IBinder strongBinder7 = parcel.readStrongBinder();
                if (strongBinder7 != null) {
                    IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    zzcsVar = iInterfaceQueryLocalInterface7 instanceof zzcs ? (zzcs) iInterfaceQueryLocalInterface7 : new zzcs(strongBinder7);
                }
                zzbcd.f(parcel);
                z3(zzcsVar);
                parcel2.writeNoException();
                return true;
            case 22:
                boolean zA = zzbcd.a(parcel);
                zzbcd.f(parcel);
                C0(zA);
                parcel2.writeNoException();
                return true;
            case 23:
                boolean zT = t();
                parcel2.writeNoException();
                ClassLoader classLoader2 = zzbcd.f24690a;
                parcel2.writeInt(zT ? 1 : 0);
                return true;
            case 24:
                IBinder strongBinder8 = parcel.readStrongBinder();
                if (strongBinder8 != null) {
                    IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
                    zzbzqVar = iInterfaceQueryLocalInterface8 instanceof zzbzs ? (zzbzs) iInterfaceQueryLocalInterface8 : new zzbzq(strongBinder8);
                }
                zzbcd.f(parcel);
                z8(zzbzqVar);
                parcel2.writeNoException();
                return true;
            case 25:
                String string = parcel.readString();
                zzbcd.f(parcel);
                qa(string);
                parcel2.writeNoException();
                return true;
            case 26:
                zzed zzedVarW = w();
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzedVarW);
                return true;
            case 29:
                zzga zzgaVar = (zzga) zzbcd.b(parcel, zzga.CREATOR);
                zzbcd.f(parcel);
                eb(zzgaVar);
                parcel2.writeNoException();
                return true;
            case 30:
                zzbcd.f(parcel);
                m();
                parcel2.writeNoException();
                return true;
            case 31:
                String strC = c();
                parcel2.writeNoException();
                parcel2.writeString(strC);
                return true;
            case 32:
                zzco zzcoVarH = h();
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzcoVarH);
                return true;
            case 33:
                zzbk zzbkVarJ = j();
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzbkVarJ);
                return true;
            case 34:
                boolean zA2 = zzbcd.a(parcel);
                zzbcd.f(parcel);
                B7(zA2);
                parcel2.writeNoException();
                return true;
            case 35:
                String strZzs = zzs();
                parcel2.writeNoException();
                parcel2.writeString(strZzs);
                return true;
            case 36:
                IBinder strongBinder9 = parcel.readStrongBinder();
                if (strongBinder9 != null) {
                    IInterface iInterfaceQueryLocalInterface9 = strongBinder9.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdMetadataListener");
                    if (iInterfaceQueryLocalInterface9 instanceof zzcb) {
                    }
                }
                zzbcd.f(parcel);
                c3();
                parcel2.writeNoException();
                return true;
            case 37:
                Bundle bundleZzk = zzk();
                parcel2.writeNoException();
                zzbcd.d(parcel2, bundleZzk);
                return true;
            case Type.A6 /* 38 */:
                parcel.readString();
                zzbcd.f(parcel);
                x();
                parcel2.writeNoException();
                return true;
            case 39:
                zzx zzxVar = (zzx) zzbcd.b(parcel, zzx.CREATOR);
                zzbcd.f(parcel);
                d8(zzxVar);
                parcel2.writeNoException();
                return true;
            case 40:
                IBinder strongBinder10 = parcel.readStrongBinder();
                if (strongBinder10 != null) {
                    IInterface iInterfaceQueryLocalInterface10 = strongBinder10.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
                    zzbeeVar = iInterfaceQueryLocalInterface10 instanceof zzbeg ? (zzbeg) iInterfaceQueryLocalInterface10 : new zzbee(strongBinder10, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
                }
                zzbcd.f(parcel);
                z2(zzbeeVar);
                parcel2.writeNoException();
                return true;
            case 41:
                zzea zzeaVarF = f();
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzeaVarF);
                return true;
            case 42:
                IBinder strongBinder11 = parcel.readStrongBinder();
                if (strongBinder11 != null) {
                    IInterface iInterfaceQueryLocalInterface11 = strongBinder11.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
                    zzdrVar = iInterfaceQueryLocalInterface11 instanceof zzdt ? (zzdt) iInterfaceQueryLocalInterface11 : new zzdr(strongBinder11);
                }
                zzbcd.f(parcel);
                xa(zzdrVar);
                parcel2.writeNoException();
                return true;
            case 43:
                zzm zzmVar2 = (zzm) zzbcd.b(parcel, zzm.CREATOR);
                IBinder strongBinder12 = parcel.readStrongBinder();
                if (strongBinder12 != null) {
                    IInterface iInterfaceQueryLocalInterface12 = strongBinder12.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoadCallback");
                    zzblVar = iInterfaceQueryLocalInterface12 instanceof zzbn ? (zzbn) iInterfaceQueryLocalInterface12 : new zzbl(strongBinder12, "com.google.android.gms.ads.internal.client.IAdLoadCallback");
                }
                zzbcd.f(parcel);
                Ga(zzmVar2, zzblVar);
                parcel2.writeNoException();
                return true;
            case 44:
                IObjectWrapper iObjectWrapperG = IObjectWrapper.Stub.g(parcel.readStrongBinder());
                zzbcd.f(parcel);
                k6(iObjectWrapperG);
                parcel2.writeNoException();
                return true;
            case 45:
                IBinder strongBinder13 = parcel.readStrongBinder();
                if (strongBinder13 != null) {
                    IInterface iInterfaceQueryLocalInterface13 = strongBinder13.queryLocalInterface("com.google.android.gms.ads.internal.client.IFullScreenContentCallback");
                    zzctVar = iInterfaceQueryLocalInterface13 instanceof zzcv ? (zzcv) iInterfaceQueryLocalInterface13 : new zzct(strongBinder13, "com.google.android.gms.ads.internal.client.IFullScreenContentCallback");
                }
                zzbcd.f(parcel);
                t5(zzctVar);
                parcel2.writeNoException();
                return true;
            case 46:
                boolean zH = H();
                parcel2.writeNoException();
                ClassLoader classLoader3 = zzbcd.f24690a;
                parcel2.writeInt(zH ? 1 : 0);
                return true;
            case 47:
                long jL = L();
                parcel2.writeNoException();
                parcel2.writeLong(jL);
                return true;
            case Type.DNSKEY /* 48 */:
                long j2 = parcel.readLong();
                zzbcd.f(parcel);
                j2(j2);
                parcel2.writeNoException();
                return true;
        }
    }
}
