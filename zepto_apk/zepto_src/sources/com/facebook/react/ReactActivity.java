package com.facebook.react;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.tracing.Trace;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.devsupport.DoubleTapReloadRecognizer;
import com.facebook.react.devsupport.ReleaseDevSupportManager;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.modules.appearance.AppearanceModule;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class ReactActivity extends AppCompatActivity implements DefaultHardwareBackBtnHandler, PermissionAwareActivity {

    /* renamed from: i, reason: collision with root package name */
    public final ReactActivityDelegate f18435i = l();

    @Override // com.facebook.react.modules.core.PermissionAwareActivity
    public final void d(String[] strArr, int i2, PermissionListener permissionListener) {
        ReactActivityDelegate reactActivityDelegate = this.f18435i;
        reactActivityDelegate.f18438c = permissionListener;
        ReactActivity reactActivity = reactActivityDelegate.f18436a;
        Assertions.c(reactActivity);
        reactActivity.requestPermissions(strArr, i2);
    }

    @Override // com.facebook.react.modules.core.DefaultHardwareBackBtnHandler
    public final void j() {
        super.onBackPressed();
    }

    public ReactActivityDelegate l() {
        return new ReactActivityDelegate(this, m());
    }

    public String m() {
        return null;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        this.f18435i.f18440e.c(i2, i3, intent, true);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        ReactDelegate reactDelegate = this.f18435i.f18440e;
        reactDelegate.getClass();
        if (ReactNativeFeatureFlags.f18968a.enableBridgelessArchitecture()) {
            reactDelegate.f18451g.onBackPressed();
            return;
        }
        if (!reactDelegate.f18450f.h()) {
            super.onBackPressed();
            return;
        }
        ReactInstanceManager reactInstanceManagerF = reactDelegate.f18450f.f();
        reactInstanceManagerF.getClass();
        UiThreadUtil.assertOnUiThread();
        ReactApplicationContext reactApplicationContext = reactInstanceManagerF.n;
        if (reactApplicationContext == null) {
            FLog.q("ReactInstanceManager", "Instance detached from instance manager");
            reactInstanceManagerF.i();
        } else {
            DeviceEventManagerModule deviceEventManagerModule = (DeviceEventManagerModule) reactApplicationContext.getNativeModule(DeviceEventManagerModule.class);
            if (deviceEventManagerModule != null) {
                deviceEventManagerModule.emitHardwareBackPressed();
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        AppearanceModule appearanceModule;
        super.onConfigurationChanged(configuration);
        ReactDelegate reactDelegate = this.f18435i.f18440e;
        reactDelegate.getClass();
        boolean zEnableBridgelessArchitecture = ReactNativeFeatureFlags.f18968a.enableBridgelessArchitecture();
        FragmentActivity fragmentActivity = reactDelegate.f18445a;
        if (zEnableBridgelessArchitecture) {
            Assertions.c(fragmentActivity);
            reactDelegate.f18451g.i(fragmentActivity);
            return;
        }
        ReactNativeHost reactNativeHost = reactDelegate.f18450f;
        if (reactNativeHost.h()) {
            ReactInstanceManager reactInstanceManagerF = reactNativeHost.f();
            Assertions.c(fragmentActivity);
            reactInstanceManagerF.getClass();
            UiThreadUtil.assertOnUiThread();
            ReactContext reactContextF = reactInstanceManagerF.f();
            if (reactContextF == null || (appearanceModule = (AppearanceModule) reactContextF.getNativeModule(AppearanceModule.class)) == null) {
                return;
            }
            appearanceModule.onConfigurationChanged(fragmentActivity);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ReactActivityDelegate reactActivityDelegate = this.f18435i;
        reactActivityDelegate.getClass();
        d block = new d(reactActivityDelegate, 0);
        Intrinsics.checkNotNullParameter("ReactActivityDelegate.onCreate::init", "sectionName");
        Intrinsics.checkNotNullParameter(block, "block");
        Intrinsics.checkNotNullParameter("ReactActivityDelegate.onCreate::init", "sectionName");
        Trace.b("ReactActivityDelegate.onCreate::init");
        try {
            block.run();
        } finally {
            android.os.Trace.endSection();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        this.f18435i.f18440e.d();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        ReactHost reactHost;
        ReactDelegate reactDelegate = this.f18435i.f18440e;
        reactDelegate.getClass();
        if (i2 == 90) {
            if (ReactNativeFeatureFlags.f18968a.enableBridgelessArchitecture() && (reactHost = reactDelegate.f18451g) != null) {
                reactHost.b();
                keyEvent.startTracking();
                return true;
            }
            reactDelegate.f18450f.h();
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyLongPress(int i2, KeyEvent keyEvent) {
        ReactHost reactHost;
        ReactDelegate reactDelegate = this.f18435i.f18440e;
        reactDelegate.getClass();
        if (i2 == 90) {
            if (!ReactNativeFeatureFlags.f18968a.enableBridgelessArchitecture() || (reactHost = reactDelegate.f18451g) == null) {
                reactDelegate.f18450f.h();
            } else {
                DevSupportManager devSupportManagerB = reactHost.b();
                if (!(devSupportManagerB instanceof ReleaseDevSupportManager)) {
                    devSupportManagerB.A();
                    return true;
                }
            }
        }
        return super.onKeyLongPress(i2, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i2, KeyEvent keyEvent) {
        DevSupportManager devSupportManagerB;
        ReactHost reactHost;
        ReactDelegate reactDelegate = this.f18435i.f18440e;
        reactDelegate.getClass();
        if (!ReactNativeFeatureFlags.f18968a.enableBridgelessArchitecture() || (reactHost = reactDelegate.f18451g) == null) {
            ReactNativeHost reactNativeHost = reactDelegate.f18450f;
            devSupportManagerB = (!reactNativeHost.h() || reactNativeHost.f() == null) ? null : reactNativeHost.f().f18463j;
        } else {
            reactHost.b();
            devSupportManagerB = reactHost.b();
        }
        if (devSupportManagerB != null && !(devSupportManagerB instanceof ReleaseDevSupportManager)) {
            if (i2 == 82) {
                devSupportManagerB.A();
                return true;
            }
            DoubleTapReloadRecognizer doubleTapReloadRecognizer = reactDelegate.f18449e;
            Assertions.c(doubleTapReloadRecognizer);
            if (doubleTapReloadRecognizer.a(i2, reactDelegate.f18445a.getCurrentFocus())) {
                devSupportManagerB.w();
                return true;
            }
        }
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        DeviceEventManagerModule deviceEventManagerModule;
        ReactDelegate reactDelegate = this.f18435i.f18440e;
        reactDelegate.getClass();
        if (ReactNativeFeatureFlags.f18968a.enableBridgelessArchitecture()) {
            reactDelegate.f18451g.onNewIntent(intent);
            return;
        }
        ReactNativeHost reactNativeHost = reactDelegate.f18450f;
        if (!reactNativeHost.h()) {
            super.onNewIntent(intent);
            return;
        }
        ReactInstanceManager reactInstanceManagerF = reactNativeHost.f();
        reactInstanceManagerF.getClass();
        UiThreadUtil.assertOnUiThread();
        ReactContext reactContextF = reactInstanceManagerF.f();
        if (reactContextF == null) {
            FLog.q("ReactInstanceManager", "Instance detached from instance manager");
            return;
        }
        String action = intent.getAction();
        Uri data = intent.getData();
        if (data != null && (("android.intent.action.VIEW".equals(action) || "android.nfc.action.NDEF_DISCOVERED".equals(action)) && (deviceEventManagerModule = (DeviceEventManagerModule) reactContextF.getNativeModule(DeviceEventManagerModule.class)) != null)) {
            deviceEventManagerModule.emitNewIntentReceived(data);
        }
        reactContextF.onNewIntent(reactInstanceManagerF.q, intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        this.f18435i.f18440e.e();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        ReactActivityDelegate reactActivityDelegate = this.f18435i;
        reactActivityDelegate.getClass();
        reactActivityDelegate.f18439d = new e(reactActivityDelegate, i2, strArr, iArr);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ReactActivityDelegate reactActivityDelegate = this.f18435i;
        reactActivityDelegate.f18440e.f();
        e eVar = reactActivityDelegate.f18439d;
        if (eVar != null) {
            eVar.invoke(new Object[0]);
            reactActivityDelegate.f18439d = null;
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onUserLeaveHint() {
        ReactInstanceManager reactInstanceManagerF;
        FragmentActivity fragmentActivity;
        super.onUserLeaveHint();
        ReactDelegate reactDelegate = this.f18435i.f18440e;
        if (reactDelegate != null) {
            boolean zEnableBridgelessArchitecture = ReactNativeFeatureFlags.f18968a.enableBridgelessArchitecture();
            FragmentActivity fragmentActivity2 = reactDelegate.f18445a;
            if (zEnableBridgelessArchitecture) {
                reactDelegate.f18451g.c(fragmentActivity2);
                return;
            }
            ReactNativeHost reactNativeHost = reactDelegate.f18450f;
            if (reactNativeHost.h() && (fragmentActivity = (reactInstanceManagerF = reactNativeHost.f()).q) != null && fragmentActivity2 == fragmentActivity) {
                UiThreadUtil.assertOnUiThread();
                ReactContext reactContextF = reactInstanceManagerF.f();
                if (reactContextF != null) {
                    reactContextF.onUserLeaveHint(fragmentActivity2);
                }
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        ReactDelegate reactDelegate = this.f18435i.f18440e;
        reactDelegate.getClass();
        if (ReactNativeFeatureFlags.f18968a.enableBridgelessArchitecture()) {
            reactDelegate.f18451g.onWindowFocusChange(z);
            return;
        }
        ReactNativeHost reactNativeHost = reactDelegate.f18450f;
        if (reactNativeHost.h()) {
            ReactInstanceManager reactInstanceManagerF = reactNativeHost.f();
            reactInstanceManagerF.getClass();
            UiThreadUtil.assertOnUiThread();
            ReactContext reactContextF = reactInstanceManagerF.f();
            if (reactContextF != null) {
                reactContextF.onWindowFocusChange(z);
            }
        }
    }
}
