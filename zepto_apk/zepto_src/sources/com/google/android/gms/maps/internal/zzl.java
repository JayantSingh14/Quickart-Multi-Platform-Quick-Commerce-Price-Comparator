package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.media.a;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes4.dex */
public final class zzl extends com.google.android.gms.internal.maps.zza implements IMapViewDelegate {
    @Override // com.google.android.gms.maps.internal.IMapViewDelegate
    public final void W0(zzat zzatVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, zzatVar);
        j1(9, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IMapViewDelegate
    public final void e() {
        j1(13, z0());
    }

    @Override // com.google.android.gms.maps.internal.IMapViewDelegate
    public final IObjectWrapper getView() {
        return a.f(g(8, z0()));
    }

    @Override // com.google.android.gms.maps.internal.IMapViewDelegate
    public final void i() {
        j1(12, z0());
    }

    @Override // com.google.android.gms.maps.internal.IMapViewDelegate
    public final void n(Bundle bundle) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.c(parcelZ0, bundle);
        j1(2, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IMapViewDelegate
    public final void onDestroy() {
        j1(5, z0());
    }

    @Override // com.google.android.gms.maps.internal.IMapViewDelegate
    public final void onLowMemory() {
        j1(6, z0());
    }

    @Override // com.google.android.gms.maps.internal.IMapViewDelegate
    public final void onPause() {
        j1(4, z0());
    }

    @Override // com.google.android.gms.maps.internal.IMapViewDelegate
    public final void onResume() {
        j1(3, z0());
    }

    @Override // com.google.android.gms.maps.internal.IMapViewDelegate
    public final void s(Bundle bundle) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.c(parcelZ0, bundle);
        Parcel parcelG = g(7, parcelZ0);
        if (parcelG.readInt() != 0) {
            bundle.readFromParcel(parcelG);
        }
        parcelG.recycle();
    }
}
