package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.GoogleMapOptions;

/* loaded from: classes4.dex */
public interface IMapFragmentDelegate extends IInterface {
    void T();

    void V1(ObjectWrapper objectWrapper, GoogleMapOptions googleMapOptions, Bundle bundle);

    void W0(zzat zzatVar);

    IObjectWrapper b1(ObjectWrapper objectWrapper, ObjectWrapper objectWrapper2, Bundle bundle);

    void e();

    void i();

    void n(Bundle bundle);

    void onDestroy();

    void onLowMemory();

    void onPause();

    void onResume();

    void s(Bundle bundle);
}
