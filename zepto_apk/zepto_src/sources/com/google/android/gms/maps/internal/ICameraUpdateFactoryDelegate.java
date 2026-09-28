package com.google.android.gms.maps.internal;

import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/* loaded from: classes4.dex */
public interface ICameraUpdateFactoryDelegate extends IInterface {
    IObjectWrapper M4(CameraPosition cameraPosition);

    IObjectWrapper W3(LatLngBounds latLngBounds);

    IObjectWrapper k7(LatLngBounds latLngBounds, int i2, int i3);

    IObjectWrapper r2(LatLng latLng);
}
