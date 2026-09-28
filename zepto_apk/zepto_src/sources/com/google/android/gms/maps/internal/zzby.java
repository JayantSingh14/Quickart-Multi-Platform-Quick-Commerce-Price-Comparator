package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.media.a;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes4.dex */
public final class zzby extends com.google.android.gms.internal.maps.zza implements IStreetViewPanoramaFragmentDelegate {
    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final void T() {
        j1(7, z0());
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final void X4(ObjectWrapper objectWrapper, Bundle bundle) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, objectWrapper);
        parcelZ0.writeInt(0);
        com.google.android.gms.internal.maps.zzc.c(parcelZ0, bundle);
        j1(2, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final IObjectWrapper b1(ObjectWrapper objectWrapper, ObjectWrapper objectWrapper2, Bundle bundle) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, objectWrapper);
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, objectWrapper2);
        com.google.android.gms.internal.maps.zzc.c(parcelZ0, bundle);
        return a.f(g(4, parcelZ0));
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final void e() {
        j1(14, z0());
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final void i() {
        j1(13, z0());
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final void l1(zzbt zzbtVar) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, zzbtVar);
        j1(12, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final void n(Bundle bundle) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.c(parcelZ0, bundle);
        j1(3, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final void onDestroy() {
        j1(8, z0());
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final void onLowMemory() {
        j1(9, z0());
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final void onPause() {
        j1(6, z0());
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final void onResume() {
        j1(5, z0());
    }

    @Override // com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate
    public final void s(Bundle bundle) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.c(parcelZ0, bundle);
        Parcel parcelG = g(10, parcelZ0);
        if (parcelG.readInt() != 0) {
            bundle.readFromParcel(parcelG);
        }
        parcelG.recycle();
    }
}
