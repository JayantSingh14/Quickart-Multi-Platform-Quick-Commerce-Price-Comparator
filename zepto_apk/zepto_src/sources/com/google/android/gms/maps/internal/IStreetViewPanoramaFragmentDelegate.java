package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes4.dex */
public interface IStreetViewPanoramaFragmentDelegate extends IInterface {
    void T();

    void X4(ObjectWrapper objectWrapper, Bundle bundle);

    IObjectWrapper b1(ObjectWrapper objectWrapper, ObjectWrapper objectWrapper2, Bundle bundle);

    void e();

    void i();

    void l1(zzbt zzbtVar);

    void n(Bundle bundle);

    void onDestroy();

    void onLowMemory();

    void onPause();

    void onResume();

    void s(Bundle bundle);
}
