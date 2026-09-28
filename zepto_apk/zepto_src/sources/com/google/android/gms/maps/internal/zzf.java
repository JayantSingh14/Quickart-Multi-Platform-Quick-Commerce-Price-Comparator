package com.google.android.gms.maps.internal;

import android.os.IInterface;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.GoogleMapOptions;

/* loaded from: classes4.dex */
public interface zzf extends IInterface {
    void C7(ObjectWrapper objectWrapper, int i2);

    IStreetViewPanoramaViewDelegate F7(ObjectWrapper objectWrapper);

    void G0(ObjectWrapper objectWrapper);

    void O0(ObjectWrapper objectWrapper);

    IStreetViewPanoramaFragmentDelegate Z6(ObjectWrapper objectWrapper);

    IMapViewDelegate e8(ObjectWrapper objectWrapper, GoogleMapOptions googleMapOptions);

    IMapFragmentDelegate m8(ObjectWrapper objectWrapper);

    int zzd();

    ICameraUpdateFactoryDelegate zze();

    com.google.android.gms.internal.maps.zzi zzj();
}
