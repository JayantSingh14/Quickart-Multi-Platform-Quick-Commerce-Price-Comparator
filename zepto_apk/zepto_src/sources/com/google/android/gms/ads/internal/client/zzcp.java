package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbcb;
import com.google.android.gms.internal.ads.zzbcd;
import com.google.android.gms.internal.ads.zzbka;
import com.google.android.gms.internal.ads.zzbkb;
import com.google.android.gms.internal.ads.zzbkc;
import com.google.android.gms.internal.ads.zzbkg;
import com.google.android.gms.internal.ads.zzbkh;
import com.google.android.gms.internal.ads.zzbki;
import com.google.android.gms.internal.ads.zzbon;
import com.google.android.gms.internal.ads.zzboo;
import com.google.android.gms.internal.ads.zzbop;
import com.google.android.gms.internal.ads.zzboq;
import com.google.android.gms.internal.ads.zzbsz;
import com.google.android.gms.internal.ads.zzbwp;
import com.google.android.gms.internal.ads.zzbwq;
import com.google.android.gms.internal.ads.zzbwr;
import com.google.android.gms.internal.ads.zzbww;
import com.google.android.gms.internal.ads.zzbwx;
import com.google.android.gms.internal.ads.zzbwy;
import com.google.android.gms.internal.ads.zzcad;
import com.google.android.gms.internal.ads.zzcae;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzcch;
import com.google.android.gms.internal.ads.zzcci;
import com.google.android.gms.internal.ads.zzccj;

/* loaded from: classes4.dex */
public final class zzcp extends zzbcb implements zzcr {
    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbt D8(IObjectWrapper iObjectWrapper, String str, zzbsz zzbszVar, int i2) {
        zzbt zzbrVar;
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        parcelG.writeString(str);
        zzbcd.e(parcelG, zzbszVar);
        parcelG.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZ0 = z0(3, parcelG);
        IBinder strongBinder = parcelZ0.readStrongBinder();
        if (strongBinder == null) {
            zzbrVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            zzbrVar = iInterfaceQueryLocalInterface instanceof zzbt ? (zzbt) iInterfaceQueryLocalInterface : new zzbr(strongBinder);
        }
        parcelZ0.recycle();
        return zzbrVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbx F2(IObjectWrapper iObjectWrapper, zzr zzrVar, String str, zzbsz zzbszVar, int i2) {
        zzbx zzbvVar;
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        zzbcd.c(parcelG, zzrVar);
        parcelG.writeString(str);
        zzbcd.e(parcelG, zzbszVar);
        parcelG.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZ0 = z0(2, parcelG);
        IBinder strongBinder = parcelZ0.readStrongBinder();
        if (strongBinder == null) {
            zzbvVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzbvVar = iInterfaceQueryLocalInterface instanceof zzbx ? (zzbx) iInterfaceQueryLocalInterface : new zzbv(strongBinder);
        }
        parcelZ0.recycle();
        return zzbvVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbwr G6(IObjectWrapper iObjectWrapper, zzbsz zzbszVar, int i2) {
        zzbwr zzbwpVar;
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        zzbcd.e(parcelG, zzbszVar);
        parcelG.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZ0 = z0(15, parcelG);
        IBinder strongBinder = parcelZ0.readStrongBinder();
        int i3 = zzbwq.f25657a;
        if (strongBinder == null) {
            zzbwpVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.offline.IOfflineUtils");
            zzbwpVar = iInterfaceQueryLocalInterface instanceof zzbwr ? (zzbwr) iInterfaceQueryLocalInterface : new zzbwp(strongBinder);
        }
        parcelZ0.recycle();
        return zzbwpVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbx H5(IObjectWrapper iObjectWrapper, zzr zzrVar, String str, int i2) {
        zzbx zzbvVar;
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        zzbcd.c(parcelG, zzrVar);
        parcelG.writeString(str);
        parcelG.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZ0 = z0(10, parcelG);
        IBinder strongBinder = parcelZ0.readStrongBinder();
        if (strongBinder == null) {
            zzbvVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzbvVar = iInterfaceQueryLocalInterface instanceof zzbx ? (zzbx) iInterfaceQueryLocalInterface : new zzbv(strongBinder);
        }
        parcelZ0.recycle();
        return zzbvVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbkc Q6(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        zzbkc zzbkaVar;
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        zzbcd.e(parcelG, iObjectWrapper2);
        Parcel parcelZ0 = z0(5, parcelG);
        IBinder strongBinder = parcelZ0.readStrongBinder();
        int i2 = zzbkb.f25281a;
        if (strongBinder == null) {
            zzbkaVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
            zzbkaVar = iInterfaceQueryLocalInterface instanceof zzbkc ? (zzbkc) iInterfaceQueryLocalInterface : new zzbka(strongBinder);
        }
        parcelZ0.recycle();
        return zzbkaVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzcaf Y2(IObjectWrapper iObjectWrapper, String str, zzbsz zzbszVar, int i2) {
        zzcaf zzcadVar;
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        parcelG.writeString(str);
        zzbcd.e(parcelG, zzbszVar);
        parcelG.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZ0 = z0(12, parcelG);
        IBinder strongBinder = parcelZ0.readStrongBinder();
        int i3 = zzcae.f25787a;
        if (strongBinder == null) {
            zzcadVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
            zzcadVar = iInterfaceQueryLocalInterface instanceof zzcaf ? (zzcaf) iInterfaceQueryLocalInterface : new zzcad(strongBinder);
        }
        parcelZ0.recycle();
        return zzcadVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbwy Z(IObjectWrapper iObjectWrapper) {
        zzbwy zzbwwVar;
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        Parcel parcelZ0 = z0(8, parcelG);
        IBinder strongBinder = parcelZ0.readStrongBinder();
        int i2 = zzbwx.f25659a;
        if (strongBinder == null) {
            zzbwwVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            zzbwwVar = iInterfaceQueryLocalInterface instanceof zzbwy ? (zzbwy) iInterfaceQueryLocalInterface : new zzbww(strongBinder);
        }
        parcelZ0.recycle();
        return zzbwwVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzdb e6(IObjectWrapper iObjectWrapper, int i2) {
        zzdb zzczVar;
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        parcelG.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZ0 = z0(9, parcelG);
        IBinder strongBinder = parcelZ0.readStrongBinder();
        if (strongBinder == null) {
            zzczVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            zzczVar = iInterfaceQueryLocalInterface instanceof zzdb ? (zzdb) iInterfaceQueryLocalInterface : new zzcz(strongBinder);
        }
        parcelZ0.recycle();
        return zzczVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzboq j3(IObjectWrapper iObjectWrapper, zzbsz zzbszVar, int i2, zzbon zzbonVar) {
        zzboq zzbooVar;
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        zzbcd.e(parcelG, zzbszVar);
        parcelG.writeInt(ModuleDescriptor.MODULE_VERSION);
        zzbcd.e(parcelG, zzbonVar);
        Parcel parcelZ0 = z0(16, parcelG);
        IBinder strongBinder = parcelZ0.readStrongBinder();
        int i3 = zzbop.f25390a;
        if (strongBinder == null) {
            zzbooVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.h5.client.IH5AdsManager");
            zzbooVar = iInterfaceQueryLocalInterface instanceof zzboq ? (zzboq) iInterfaceQueryLocalInterface : new zzboo(strongBinder);
        }
        parcelZ0.recycle();
        return zzbooVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzck ja(IObjectWrapper iObjectWrapper, zzbsz zzbszVar, int i2) {
        zzck zzciVar;
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        zzbcd.e(parcelG, zzbszVar);
        parcelG.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZ0 = z0(18, parcelG);
        IBinder strongBinder = parcelZ0.readStrongBinder();
        if (strongBinder == null) {
            zzciVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdPreloader");
            zzciVar = iInterfaceQueryLocalInterface instanceof zzck ? (zzck) iInterfaceQueryLocalInterface : new zzci(strongBinder);
        }
        parcelZ0.recycle();
        return zzciVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbx m3(IObjectWrapper iObjectWrapper, zzr zzrVar, String str, zzbsz zzbszVar, int i2) {
        zzbx zzbvVar;
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        zzbcd.c(parcelG, zzrVar);
        parcelG.writeString(str);
        zzbcd.e(parcelG, zzbszVar);
        parcelG.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZ0 = z0(1, parcelG);
        IBinder strongBinder = parcelZ0.readStrongBinder();
        if (strongBinder == null) {
            zzbvVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzbvVar = iInterfaceQueryLocalInterface instanceof zzbx ? (zzbx) iInterfaceQueryLocalInterface : new zzbv(strongBinder);
        }
        parcelZ0.recycle();
        return zzbvVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzdw n5(IObjectWrapper iObjectWrapper, zzbsz zzbszVar, int i2) {
        zzdw zzduVar;
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        zzbcd.e(parcelG, zzbszVar);
        parcelG.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZ0 = z0(17, parcelG);
        IBinder strongBinder = parcelZ0.readStrongBinder();
        if (strongBinder == null) {
            zzduVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOutOfContextTester");
            zzduVar = iInterfaceQueryLocalInterface instanceof zzdw ? (zzdw) iInterfaceQueryLocalInterface : new zzdu(strongBinder);
        }
        parcelZ0.recycle();
        return zzduVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzccj n7(IObjectWrapper iObjectWrapper, zzbsz zzbszVar, int i2) {
        zzccj zzcchVar;
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        zzbcd.e(parcelG, zzbszVar);
        parcelG.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZ0 = z0(14, parcelG);
        IBinder strongBinder = parcelZ0.readStrongBinder();
        int i3 = zzcci.f25883a;
        if (strongBinder == null) {
            zzcchVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalGenerator");
            zzcchVar = iInterfaceQueryLocalInterface instanceof zzccj ? (zzccj) iInterfaceQueryLocalInterface : new zzcch(strongBinder);
        }
        parcelZ0.recycle();
        return zzcchVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbx r6(IObjectWrapper iObjectWrapper, zzr zzrVar, String str, zzbsz zzbszVar, int i2) {
        zzbx zzbvVar;
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        zzbcd.c(parcelG, zzrVar);
        parcelG.writeString(str);
        zzbcd.e(parcelG, zzbszVar);
        parcelG.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZ0 = z0(13, parcelG);
        IBinder strongBinder = parcelZ0.readStrongBinder();
        if (strongBinder == null) {
            zzbvVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzbvVar = iInterfaceQueryLocalInterface instanceof zzbx ? (zzbx) iInterfaceQueryLocalInterface : new zzbv(strongBinder);
        }
        parcelZ0.recycle();
        return zzbvVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbki zzk(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        zzbki zzbkgVar;
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        zzbcd.e(parcelG, iObjectWrapper2);
        zzbcd.e(parcelG, iObjectWrapper3);
        Parcel parcelZ0 = z0(11, parcelG);
        IBinder strongBinder = parcelZ0.readStrongBinder();
        int i2 = zzbkh.f25283a;
        if (strongBinder == null) {
            zzbkgVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
            zzbkgVar = iInterfaceQueryLocalInterface instanceof zzbki ? (zzbki) iInterfaceQueryLocalInterface : new zzbkg(strongBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
        }
        parcelZ0.recycle();
        return zzbkgVar;
    }
}
