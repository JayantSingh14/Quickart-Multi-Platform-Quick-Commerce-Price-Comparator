package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.v4.media.a;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbcb;
import com.google.android.gms.internal.ads.zzbcd;
import com.google.android.gms.internal.ads.zzbeg;

/* loaded from: classes4.dex */
public final class zzbv extends zzbcb implements zzbx {
    public zzbv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void B7(boolean z) {
        Parcel parcelG = g();
        ClassLoader classLoader = zzbcd.f24690a;
        parcelG.writeInt(z ? 1 : 0);
        j1(34, parcelG);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void C0(boolean z) {
        Parcel parcelG = g();
        ClassLoader classLoader = zzbcd.f24690a;
        parcelG.writeInt(z ? 1 : 0);
        j1(22, parcelG);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void Ga(zzm zzmVar, zzbn zzbnVar) {
        Parcel parcelG = g();
        zzbcd.c(parcelG, zzmVar);
        zzbcd.e(parcelG, zzbnVar);
        j1(43, parcelG);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void J6(zzco zzcoVar) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, zzcoVar);
        j1(8, parcelG);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final long L() {
        Parcel parcelZ0 = z0(47, g());
        long j2 = parcelZ0.readLong();
        parcelZ0.recycle();
        return j2;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void Q4(zzbk zzbkVar) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, zzbkVar);
        j1(7, parcelG);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final boolean U0(zzm zzmVar) {
        Parcel parcelG = g();
        zzbcd.c(parcelG, zzmVar);
        Parcel parcelZ0 = z0(4, parcelG);
        boolean z = parcelZ0.readInt() != 0;
        parcelZ0.recycle();
        return z;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final String c() {
        Parcel parcelZ0 = z0(31, g());
        String string = parcelZ0.readString();
        parcelZ0.recycle();
        return string;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void eb(zzga zzgaVar) {
        Parcel parcelG = g();
        zzbcd.c(parcelG, zzgaVar);
        j1(29, parcelG);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final zzea f() {
        zzea zzdyVar;
        Parcel parcelZ0 = z0(41, g());
        IBinder strongBinder = parcelZ0.readStrongBinder();
        if (strongBinder == null) {
            zzdyVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
            zzdyVar = iInterfaceQueryLocalInterface instanceof zzea ? (zzea) iInterfaceQueryLocalInterface : new zzdy(strongBinder);
        }
        parcelZ0.recycle();
        return zzdyVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final zzco h() {
        zzco zzcmVar;
        Parcel parcelZ0 = z0(32, g());
        IBinder strongBinder = parcelZ0.readStrongBinder();
        if (strongBinder == null) {
            zzcmVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
            zzcmVar = iInterfaceQueryLocalInterface instanceof zzco ? (zzco) iInterfaceQueryLocalInterface : new zzcm(strongBinder);
        }
        parcelZ0.recycle();
        return zzcmVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final zzbk j() {
        zzbk zzbiVar;
        Parcel parcelZ0 = z0(33, g());
        IBinder strongBinder = parcelZ0.readStrongBinder();
        if (strongBinder == null) {
            zzbiVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
            zzbiVar = iInterfaceQueryLocalInterface instanceof zzbk ? (zzbk) iInterfaceQueryLocalInterface : new zzbi(strongBinder);
        }
        parcelZ0.recycle();
        return zzbiVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void j2(long j2) {
        Parcel parcelG = g();
        parcelG.writeLong(j2);
        j1(48, parcelG);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void k6(IObjectWrapper iObjectWrapper) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        j1(44, parcelG);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void o8(zzbh zzbhVar) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, zzbhVar);
        j1(20, parcelG);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void t5(zzcv zzcvVar) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, zzcvVar);
        j1(45, parcelG);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final zzed w() {
        zzed zzebVar;
        Parcel parcelZ0 = z0(26, g());
        IBinder strongBinder = parcelZ0.readStrongBinder();
        if (strongBinder == null) {
            zzebVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
            zzebVar = iInterfaceQueryLocalInterface instanceof zzed ? (zzed) iInterfaceQueryLocalInterface : new zzeb(strongBinder);
        }
        parcelZ0.recycle();
        return zzebVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void w4(zzr zzrVar) {
        Parcel parcelG = g();
        zzbcd.c(parcelG, zzrVar);
        j1(13, parcelG);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void xa(zzdt zzdtVar) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, zzdtVar);
        j1(42, parcelG);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void z2(zzbeg zzbegVar) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, zzbegVar);
        j1(40, parcelG);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final IObjectWrapper zzb() {
        return a.f(z0(1, g()));
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzc() {
        j1(2, g());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzf() {
        j1(5, g());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzg() {
        j1(6, g());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final zzr zzn() {
        Parcel parcelZ0 = z0(12, g());
        zzr zzrVar = (zzr) zzbcd.b(parcelZ0, zzr.CREATOR);
        parcelZ0.recycle();
        return zzrVar;
    }
}
