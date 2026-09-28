package com.facebook.react;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.runtime.ReactSurfaceImpl;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public interface ReactHost {
    ReactSurfaceImpl a(FragmentActivity fragmentActivity, String str, Bundle bundle);

    DevSupportManager b();

    void c(FragmentActivity fragmentActivity);

    void d(FragmentActivity fragmentActivity);

    void e(ReactInstanceEventListener reactInstanceEventListener);

    void f(FragmentActivity fragmentActivity, int i2, int i3, Intent intent);

    void g(FragmentActivity fragmentActivity);

    void h(FragmentActivity fragmentActivity, DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler);

    void i(FragmentActivity fragmentActivity);

    boolean onBackPressed();

    void onNewIntent(Intent intent);

    void onWindowFocusChange(boolean z);
}
