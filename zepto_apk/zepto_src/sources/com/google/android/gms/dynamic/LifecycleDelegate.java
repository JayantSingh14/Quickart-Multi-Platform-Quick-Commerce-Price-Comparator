package com.google.android.gms.dynamic;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes4.dex */
public interface LifecycleDelegate {
    void T();

    void U(Activity activity, Bundle bundle, Bundle bundle2);

    View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    void e();

    void i();

    void n(Bundle bundle);

    void onDestroy();

    void onLowMemory();

    void onPause();

    void onResume();

    void s(Bundle bundle);
}
