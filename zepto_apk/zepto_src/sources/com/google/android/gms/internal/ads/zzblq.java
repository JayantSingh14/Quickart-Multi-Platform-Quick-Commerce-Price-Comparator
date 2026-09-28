package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzblq extends zzbcb implements zzbls {
    @Override // com.google.android.gms.internal.ads.zzbls
    public final void H4(Bundle bundle) {
        Parcel parcelG = g();
        zzbcd.c(parcelG, bundle);
        j1(33, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final List I() {
        Parcel parcelZ0 = z0(23, g());
        ArrayList arrayList = parcelZ0.readArrayList(zzbcd.f24690a);
        parcelZ0.recycle();
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final IObjectWrapper c() {
        return android.support.v4.media.a.f(z0(18, g()));
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final IObjectWrapper h() {
        return android.support.v4.media.a.f(z0(19, g()));
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final com.google.android.gms.ads.internal.client.zzea m() {
        Parcel parcelZ0 = z0(31, g());
        com.google.android.gms.ads.internal.client.zzea zzeaVarXb = com.google.android.gms.ads.internal.client.zzdz.Xb(parcelZ0.readStrongBinder());
        parcelZ0.recycle();
        return zzeaVarXb;
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final String zze() {
        Parcel parcelZ0 = z0(2, g());
        String string = parcelZ0.readString();
        parcelZ0.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final List zzf() {
        Parcel parcelZ0 = z0(3, g());
        ArrayList arrayList = parcelZ0.readArrayList(zzbcd.f24690a);
        parcelZ0.recycle();
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final String zzg() {
        Parcel parcelZ0 = z0(4, g());
        String string = parcelZ0.readString();
        parcelZ0.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final zzbjy zzh() {
        zzbjy zzbjwVar;
        Parcel parcelZ0 = z0(5, g());
        IBinder strongBinder = parcelZ0.readStrongBinder();
        if (strongBinder == null) {
            zzbjwVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            zzbjwVar = iInterfaceQueryLocalInterface instanceof zzbjy ? (zzbjy) iInterfaceQueryLocalInterface : new zzbjw(strongBinder);
        }
        parcelZ0.recycle();
        return zzbjwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final String zzi() {
        Parcel parcelZ0 = z0(6, g());
        String string = parcelZ0.readString();
        parcelZ0.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final String zzj() {
        Parcel parcelZ0 = z0(7, g());
        String string = parcelZ0.readString();
        parcelZ0.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final double zzk() {
        Parcel parcelZ0 = z0(8, g());
        double d2 = parcelZ0.readDouble();
        parcelZ0.recycle();
        return d2;
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final String zzl() {
        Parcel parcelZ0 = z0(9, g());
        String string = parcelZ0.readString();
        parcelZ0.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final String zzm() {
        Parcel parcelZ0 = z0(10, g());
        String string = parcelZ0.readString();
        parcelZ0.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final com.google.android.gms.ads.internal.client.zzed zzn() {
        Parcel parcelZ0 = z0(11, g());
        com.google.android.gms.ads.internal.client.zzed zzedVarXb = com.google.android.gms.ads.internal.client.zzec.Xb(parcelZ0.readStrongBinder());
        parcelZ0.recycle();
        return zzedVarXb;
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final zzbjr zzq() {
        zzbjr zzbjpVar;
        Parcel parcelZ0 = z0(14, g());
        IBinder strongBinder = parcelZ0.readStrongBinder();
        if (strongBinder == null) {
            zzbjpVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
            zzbjpVar = iInterfaceQueryLocalInterface instanceof zzbjr ? (zzbjr) iInterfaceQueryLocalInterface : new zzbjp(strongBinder);
        }
        parcelZ0.recycle();
        return zzbjpVar;
    }
}
