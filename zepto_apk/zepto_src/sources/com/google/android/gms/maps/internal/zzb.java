package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.support.v4.media.a;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/* loaded from: classes4.dex */
public final class zzb extends com.google.android.gms.internal.maps.zza implements ICameraUpdateFactoryDelegate {
    @Override // com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate
    public final IObjectWrapper M4(CameraPosition cameraPosition) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.c(parcelZ0, cameraPosition);
        return a.f(g(7, parcelZ0));
    }

    @Override // com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate
    public final IObjectWrapper W3(LatLngBounds latLngBounds) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.c(parcelZ0, latLngBounds);
        parcelZ0.writeInt(0);
        return a.f(g(10, parcelZ0));
    }

    @Override // com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate
    public final IObjectWrapper k7(LatLngBounds latLngBounds, int i2, int i3) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.c(parcelZ0, latLngBounds);
        parcelZ0.writeInt(i2);
        parcelZ0.writeInt(i3);
        parcelZ0.writeInt(0);
        return a.f(g(11, parcelZ0));
    }

    @Override // com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate
    public final IObjectWrapper r2(LatLng latLng) {
        Parcel parcelZ0 = z0();
        com.google.android.gms.internal.maps.zzc.c(parcelZ0, latLng);
        parcelZ0.writeFloat(10.0f);
        return a.f(g(9, parcelZ0));
    }
}
