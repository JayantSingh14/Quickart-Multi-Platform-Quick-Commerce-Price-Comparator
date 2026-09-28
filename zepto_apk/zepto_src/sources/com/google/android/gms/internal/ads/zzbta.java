package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzbta extends zzbcb implements zzbtc {
    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void A1(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbtf zzbtfVar) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        zzbcd.c(parcelG, zzmVar);
        parcelG.writeString(str);
        zzbcd.e(parcelG, zzbtfVar);
        j1(28, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void D2(IObjectWrapper iObjectWrapper) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        j1(37, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void E8(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2, zzbtf zzbtfVar, zzbjn zzbjnVar, ArrayList arrayList) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        zzbcd.c(parcelG, zzmVar);
        parcelG.writeString(str);
        parcelG.writeString(str2);
        zzbcd.e(parcelG, zzbtfVar);
        zzbcd.c(parcelG, zzbjnVar);
        parcelG.writeStringList(arrayList);
        j1(14, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void K2(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2, zzbtf zzbtfVar) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        zzbcd.c(parcelG, zzrVar);
        zzbcd.c(parcelG, zzmVar);
        parcelG.writeString(str);
        parcelG.writeString(str2);
        zzbcd.e(parcelG, zzbtfVar);
        j1(35, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final zzbti O() {
        zzbti zzbtgVar;
        Parcel parcelZ0 = z0(36, g());
        IBinder strongBinder = parcelZ0.readStrongBinder();
        if (strongBinder == null) {
            zzbtgVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd");
            zzbtgVar = iInterfaceQueryLocalInterface instanceof zzbti ? (zzbti) iInterfaceQueryLocalInterface : new zzbtg(strongBinder);
        }
        parcelZ0.recycle();
        return zzbtgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void O2(IObjectWrapper iObjectWrapper, zzbpq zzbpqVar, ArrayList arrayList) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        zzbcd.e(parcelG, zzbpqVar);
        parcelG.writeTypedList(arrayList);
        j1(31, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void R0(IObjectWrapper iObjectWrapper) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        j1(21, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final zzbvn U() {
        Parcel parcelZ0 = z0(34, g());
        zzbvn zzbvnVar = (zzbvn) zzbcd.b(parcelZ0, zzbvn.CREATOR);
        parcelZ0.recycle();
        return zzbvnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void Y8(IObjectWrapper iObjectWrapper) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        j1(30, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void a4(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2, zzbtf zzbtfVar) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        zzbcd.c(parcelG, zzmVar);
        parcelG.writeString(str);
        parcelG.writeString(str2);
        zzbcd.e(parcelG, zzbtfVar);
        j1(7, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void b4(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2, zzbtf zzbtfVar) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        zzbcd.c(parcelG, zzrVar);
        zzbcd.c(parcelG, zzmVar);
        parcelG.writeString(str);
        parcelG.writeString(str2);
        zzbcd.e(parcelG, zzbtfVar);
        j1(6, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void cb(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbtf zzbtfVar) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        zzbcd.c(parcelG, zzmVar);
        parcelG.writeString(str);
        zzbcd.e(parcelG, zzbtfVar);
        j1(32, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final zzbtl e0() {
        zzbtl zzbtlVar;
        Parcel parcelZ0 = z0(16, g());
        IBinder strongBinder = parcelZ0.readStrongBinder();
        if (strongBinder == null) {
            zzbtlVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            zzbtlVar = iInterfaceQueryLocalInterface instanceof zzbtl ? (zzbtl) iInterfaceQueryLocalInterface : new zzbtl(strongBinder, "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
        }
        parcelZ0.recycle();
        return zzbtlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void e1() {
        j1(12, g());
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void g4(IObjectWrapper iObjectWrapper, zzbzx zzbzxVar, List list) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        zzbcd.e(parcelG, zzbzxVar);
        parcelG.writeStringList(list);
        j1(23, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void i8(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, zzbzx zzbzxVar, String str) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        zzbcd.c(parcelG, zzmVar);
        parcelG.writeString(null);
        zzbcd.e(parcelG, zzbzxVar);
        parcelG.writeString(str);
        j1(10, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void l7(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbtf zzbtfVar) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        zzbcd.c(parcelG, zzmVar);
        parcelG.writeString(str);
        zzbcd.e(parcelG, zzbtfVar);
        j1(38, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final zzbvn m() {
        Parcel parcelZ0 = z0(33, g());
        zzbvn zzbvnVar = (zzbvn) zzbcd.b(parcelZ0, zzbvn.CREATOR);
        parcelZ0.recycle();
        return zzbvnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void n4(IObjectWrapper iObjectWrapper) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        j1(39, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void r7(com.google.android.gms.ads.internal.client.zzm zzmVar, String str) {
        Parcel parcelG = g();
        zzbcd.c(parcelG, zzmVar);
        parcelG.writeString(str);
        j1(11, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final com.google.android.gms.ads.internal.client.zzed t() {
        Parcel parcelZ0 = z0(26, g());
        com.google.android.gms.ads.internal.client.zzed zzedVarXb = com.google.android.gms.ads.internal.client.zzec.Xb(parcelZ0.readStrongBinder());
        parcelZ0.recycle();
        return zzedVarXb;
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final zzbto v() {
        zzbto zzbtmVar;
        Parcel parcelZ0 = z0(27, g());
        IBinder strongBinder = parcelZ0.readStrongBinder();
        if (strongBinder == null) {
            zzbtmVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
            zzbtmVar = iInterfaceQueryLocalInterface instanceof zzbto ? (zzbto) iInterfaceQueryLocalInterface : new zzbtm(strongBinder);
        }
        parcelZ0.recycle();
        return zzbtmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void w0(boolean z) {
        Parcel parcelG = g();
        ClassLoader classLoader = zzbcd.f24690a;
        parcelG.writeInt(z ? 1 : 0);
        j1(25, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final boolean y() {
        Parcel parcelZ0 = z0(22, g());
        ClassLoader classLoader = zzbcd.f24690a;
        boolean z = parcelZ0.readInt() != 0;
        parcelZ0.recycle();
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final zzbtk zzO() {
        zzbtk zzbtkVar;
        Parcel parcelZ0 = z0(15, g());
        IBinder strongBinder = parcelZ0.readStrongBinder();
        if (strongBinder == null) {
            zzbtkVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            zzbtkVar = iInterfaceQueryLocalInterface instanceof zzbtk ? (zzbtk) iInterfaceQueryLocalInterface : new zzbtk(strongBinder, "com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
        }
        parcelZ0.recycle();
        return zzbtkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final IObjectWrapper zzf() {
        return android.support.v4.media.a.f(z0(2, g()));
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zzh() {
        j1(4, g());
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zzi() {
        j1(5, g());
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zzl() {
        j1(8, g());
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zzm() {
        j1(9, g());
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final boolean zzq() {
        Parcel parcelZ0 = z0(13, g());
        ClassLoader classLoader = zzbcd.f24690a;
        boolean z = parcelZ0.readInt() != 0;
        parcelZ0.recycle();
        return z;
    }
}
