package com.facebook.react.devsupport.interfaces;

import android.app.Activity;
import android.util.Pair;
import android.view.View;
import com.facebook.react.bridge.JSExceptionHandler;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.SurfaceDelegate;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface DevSupportManager extends JSExceptionHandler {

    @Metadata
    /* loaded from: classes3.dex */
    public interface PackagerLocationCustomizer {
    }

    @Metadata
    /* loaded from: classes3.dex */
    public interface PausedInDebuggerOverlayCommandListener {
        void onResume();
    }

    void A();

    void B(ReactApplicationContext reactApplicationContext);

    void C(ReactContext reactContext);

    void D();

    void E(PackagerStatusCallback packagerStatusCallback);

    void a(String str, PausedInDebuggerOverlayCommandListener pausedInDebuggerOverlayCommandListener);

    void b();

    void c(boolean z);

    String d();

    String e();

    void f();

    boolean g();

    void h(boolean z);

    SurfaceDelegate i(String str);

    void j();

    Pair k(Pair pair);

    void l(boolean z);

    String m();

    void n(String str, DevOptionHandler devOptionHandler);

    void o(View view);

    View p();

    void q();

    RedBoxHandler r();

    void s();

    StackFrame[] t();

    ReactContext u();

    Activity v();

    void w();

    void x(boolean z);

    DeveloperSettings y();

    boolean z();
}
