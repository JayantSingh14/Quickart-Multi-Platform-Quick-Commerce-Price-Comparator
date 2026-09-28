package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes4.dex */
public interface IMapViewDelegate extends IInterface {
    void W0(zzat zzatVar);

    void e();

    IObjectWrapper getView();

    void i();

    void n(Bundle bundle);

    void onDestroy();

    void onLowMemory();

    void onPause();

    void onResume();

    void s(Bundle bundle);
}
