package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.internal.ads.zzbcc;
import com.google.android.gms.internal.ads.zzbcd;
import com.google.android.gms.internal.ads.zzbjn;
import com.google.android.gms.internal.ads.zzbku;
import com.google.android.gms.internal.ads.zzbkw;
import com.google.android.gms.internal.ads.zzbkx;
import com.google.android.gms.internal.ads.zzbkz;
import com.google.android.gms.internal.ads.zzbla;
import com.google.android.gms.internal.ads.zzblc;
import com.google.android.gms.internal.ads.zzbld;
import com.google.android.gms.internal.ads.zzblf;
import com.google.android.gms.internal.ads.zzblh;
import com.google.android.gms.internal.ads.zzblj;
import com.google.android.gms.internal.ads.zzblk;
import com.google.android.gms.internal.ads.zzblm;
import com.google.android.gms.internal.ads.zzbpy;
import com.google.android.gms.internal.ads.zzbqf;
import com.google.android.gms.internal.ads.zzbqh;

/* loaded from: classes4.dex */
public abstract class zzbs extends zzbcc implements zzbt {
    public zzbs() {
        super("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    @Override // com.google.android.gms.internal.ads.zzbcc
    public final boolean Wb(int i2, Parcel parcel, Parcel parcel2) {
        zzblf zzbldVar;
        zzbk zzbiVar = null;
        zzbqh zzbqfVar = null;
        zzblm zzblkVar = null;
        zzblj zzblhVar = null;
        zzcs zzcsVar = null;
        zzblc zzblaVar = null;
        zzbkz zzbkxVar = null;
        zzbkw zzbkuVar = null;
        switch (i2) {
            case 1:
                zzbq zzbqVarZze = zze();
                parcel2.writeNoException();
                zzbcd.e(parcel2, zzbqVarZze);
                return true;
            case 2:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    zzbiVar = iInterfaceQueryLocalInterface instanceof zzbk ? (zzbk) iInterfaceQueryLocalInterface : new zzbi(strongBinder);
                }
                zzbcd.f(parcel);
                S8(zzbiVar);
                parcel2.writeNoException();
                return true;
            case 3:
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
                    zzbkuVar = iInterfaceQueryLocalInterface2 instanceof zzbkw ? (zzbkw) iInterfaceQueryLocalInterface2 : new zzbku(strongBinder2, "com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
                }
                zzbcd.f(parcel);
                U6(zzbkuVar);
                parcel2.writeNoException();
                return true;
            case 4:
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
                    zzbkxVar = iInterfaceQueryLocalInterface3 instanceof zzbkz ? (zzbkz) iInterfaceQueryLocalInterface3 : new zzbkx(strongBinder3, "com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
                }
                zzbcd.f(parcel);
                l5(zzbkxVar);
                parcel2.writeNoException();
                return true;
            case 5:
                String string = parcel.readString();
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 == null) {
                    zzbldVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
                    zzbldVar = iInterfaceQueryLocalInterface4 instanceof zzblf ? (zzblf) iInterfaceQueryLocalInterface4 : new zzbld(strongBinder4, "com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
                }
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
                    zzblaVar = iInterfaceQueryLocalInterface5 instanceof zzblc ? (zzblc) iInterfaceQueryLocalInterface5 : new zzbla(strongBinder5, "com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
                }
                zzbcd.f(parcel);
                i3(string, zzbldVar, zzblaVar);
                parcel2.writeNoException();
                return true;
            case 6:
                zzbjn zzbjnVar = (zzbjn) zzbcd.b(parcel, zzbjn.CREATOR);
                zzbcd.f(parcel);
                P8(zzbjnVar);
                parcel2.writeNoException();
                return true;
            case 7:
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 != null) {
                    IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    zzcsVar = iInterfaceQueryLocalInterface6 instanceof zzcs ? (zzcs) iInterfaceQueryLocalInterface6 : new zzcs(strongBinder6);
                }
                zzbcd.f(parcel);
                A8(zzcsVar);
                parcel2.writeNoException();
                return true;
            case 8:
                IBinder strongBinder7 = parcel.readStrongBinder();
                if (strongBinder7 != null) {
                    IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnPublisherAdViewLoadedListener");
                    zzblhVar = iInterfaceQueryLocalInterface7 instanceof zzblj ? (zzblj) iInterfaceQueryLocalInterface7 : new zzblh(strongBinder7, "com.google.android.gms.ads.internal.formats.client.IOnPublisherAdViewLoadedListener");
                }
                zzr zzrVar = (zzr) zzbcd.b(parcel, zzr.CREATOR);
                zzbcd.f(parcel);
                jb(zzblhVar, zzrVar);
                parcel2.writeNoException();
                return true;
            case 9:
                PublisherAdViewOptions publisherAdViewOptions = (PublisherAdViewOptions) zzbcd.b(parcel, PublisherAdViewOptions.CREATOR);
                zzbcd.f(parcel);
                f4(publisherAdViewOptions);
                parcel2.writeNoException();
                return true;
            case 10:
                IBinder strongBinder8 = parcel.readStrongBinder();
                if (strongBinder8 != null) {
                    IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
                    zzblkVar = iInterfaceQueryLocalInterface8 instanceof zzblm ? (zzblm) iInterfaceQueryLocalInterface8 : new zzblk(strongBinder8, "com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
                }
                zzbcd.f(parcel);
                ob(zzblkVar);
                parcel2.writeNoException();
                return true;
            case 11:
            case 12:
            default:
                return false;
            case 13:
                zzbpy zzbpyVar = (zzbpy) zzbcd.b(parcel, zzbpy.CREATOR);
                zzbcd.f(parcel);
                Ob(zzbpyVar);
                parcel2.writeNoException();
                return true;
            case 14:
                IBinder strongBinder9 = parcel.readStrongBinder();
                if (strongBinder9 != null) {
                    IInterface iInterfaceQueryLocalInterface9 = strongBinder9.queryLocalInterface("com.google.android.gms.ads.internal.instream.client.IInstreamAdLoadCallback");
                    zzbqfVar = iInterfaceQueryLocalInterface9 instanceof zzbqh ? (zzbqh) iInterfaceQueryLocalInterface9 : new zzbqf(strongBinder9, "com.google.android.gms.ads.internal.instream.client.IInstreamAdLoadCallback");
                }
                zzbcd.f(parcel);
                y1(zzbqfVar);
                parcel2.writeNoException();
                return true;
            case 15:
                AdManagerAdViewOptions adManagerAdViewOptions = (AdManagerAdViewOptions) zzbcd.b(parcel, AdManagerAdViewOptions.CREATOR);
                zzbcd.f(parcel);
                F8(adManagerAdViewOptions);
                parcel2.writeNoException();
                return true;
        }
    }
}
