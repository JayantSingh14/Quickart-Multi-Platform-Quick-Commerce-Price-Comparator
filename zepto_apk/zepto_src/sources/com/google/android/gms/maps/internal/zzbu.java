package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.support.v4.media.a;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;

/* loaded from: classes4.dex */
public final class zzbu extends com.google.android.gms.internal.maps.zza implements IProjectionDelegate {
    @Override // com.google.android.gms.maps.internal.IProjectionDelegate
    public final LatLng S9(ObjectWrapper objectWrapper) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.d(parcelZ0, objectWrapper);
        Parcel parcelG = g(1, parcelZ0);
        LatLng latLng = (LatLng) com.google.android.gms.internal.maps.zzc.a(parcelG, LatLng.CREATOR);
        parcelG.recycle();
        return latLng;
    }

    @Override // com.google.android.gms.maps.internal.IProjectionDelegate
    public final IObjectWrapper W2(LatLng latLng) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.c(parcelZ0, latLng);
        return a.f(g(2, parcelZ0));
    }

    @Override // com.google.android.gms.maps.internal.IProjectionDelegate
    public final VisibleRegion t3() {
        Parcel parcelG = g(3, z0());
        VisibleRegion visibleRegion = (VisibleRegion) com.google.android.gms.internal.maps.zzc.a(parcelG, VisibleRegion.CREATOR);
        parcelG.recycle();
        return visibleRegion;
    }
}
