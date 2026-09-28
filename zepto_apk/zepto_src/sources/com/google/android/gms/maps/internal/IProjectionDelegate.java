package com.google.android.gms.maps.internal;

import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;

/* loaded from: classes4.dex */
public interface IProjectionDelegate extends IInterface {
    LatLng S9(ObjectWrapper objectWrapper);

    IObjectWrapper W2(LatLng latLng);

    VisibleRegion t3();
}
