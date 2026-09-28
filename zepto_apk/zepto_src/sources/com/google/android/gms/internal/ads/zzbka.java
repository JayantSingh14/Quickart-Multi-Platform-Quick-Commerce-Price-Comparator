package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes4.dex */
public final class zzbka extends zzbcb implements zzbkc {
    public zzbka(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    @Override // com.google.android.gms.internal.ads.zzbkc
    public final void H0(IObjectWrapper iObjectWrapper) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        j1(3, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbkc
    public final void P6(IObjectWrapper iObjectWrapper, String str) {
        Parcel parcelG = g();
        parcelG.writeString(str);
        zzbcd.e(parcelG, iObjectWrapper);
        j1(1, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbkc
    public final void Tb(zzbjv zzbjvVar) {
        Parcel parcelG = g();
        ClassLoader classLoader = zzbcd.f24690a;
        parcelG.writeStrongBinder(null);
        j1(8, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbkc
    public final void U2(IObjectWrapper iObjectWrapper) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        j1(7, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbkc
    public final void Z(IObjectWrapper iObjectWrapper) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        j1(6, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbkc
    public final void ha(IObjectWrapper iObjectWrapper) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        j1(9, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbkc
    public final IObjectWrapper o(String str) {
        Parcel parcelG = g();
        parcelG.writeString(str);
        return android.support.v4.media.a.f(z0(2, parcelG));
    }

    @Override // com.google.android.gms.internal.ads.zzbkc
    public final void v0(IObjectWrapper iObjectWrapper, int i2) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        parcelG.writeInt(i2);
        j1(5, parcelG);
    }
}
