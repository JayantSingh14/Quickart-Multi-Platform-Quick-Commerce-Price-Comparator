package com.facebook.react;

import android.os.Bundle;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.interfaces.fabric.ReactSurface;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18747a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f18748b;

    public /* synthetic */ d(Object obj, int i2) {
        this.f18747a = i2;
        this.f18748b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ReactRootView reactRootView;
        switch (this.f18747a) {
            case 0:
                ReactActivityDelegate reactActivityDelegate = (ReactActivityDelegate) this.f18748b;
                Bundle bundleA = reactActivityDelegate.a();
                boolean zEnableBridgelessArchitecture = ReactNativeFeatureFlags.f18968a.enableBridgelessArchitecture();
                ReactActivity reactActivity = reactActivityDelegate.f18436a;
                String str = reactActivityDelegate.f18437b;
                if (zEnableBridgelessArchitecture) {
                    Assertions.c(reactActivity);
                    reactActivityDelegate.f18440e = new ReactDelegate(reactActivity, ((ReactApplication) reactActivity.getApplication()).b(), str, bundleA);
                } else {
                    Assertions.c(reactActivity);
                    Assertions.c(reactActivity);
                    reactActivityDelegate.f18440e = new ReactDelegate(reactActivity, ((ReactApplication) reactActivity.getApplication()).a(), str, bundleA, reactActivityDelegate.b()) { // from class: com.facebook.react.ReactActivityDelegate.1
                        public AnonymousClass1(ReactActivity reactActivity2, ReactNativeHost reactNativeHost, String str2, Bundle bundleA2, boolean z) {
                            super(reactActivity2, reactNativeHost, str2, bundleA2, z);
                        }

                        @Override // com.facebook.react.ReactDelegate
                        public final ReactRootView a() {
                            ReactActivityDelegate.this.getClass();
                            return super.a();
                        }
                    };
                }
                if (str2 != null) {
                    reactActivityDelegate.f18440e.b(str2);
                    Assertions.c(reactActivity2);
                    ReactDelegate reactDelegate = reactActivityDelegate.f18440e;
                    reactDelegate.getClass();
                    if (ReactNativeFeatureFlags.f18968a.enableBridgelessArchitecture()) {
                        ReactSurface reactSurface = reactDelegate.f18452h;
                        reactRootView = reactSurface != null ? (ReactRootView) reactSurface.getView() : null;
                    } else {
                        reactRootView = reactDelegate.f18446b;
                    }
                    reactActivity2.setContentView(reactRootView);
                    break;
                }
                break;
            default:
                ReactInstanceManager reactInstanceManager = (ReactInstanceManager) this.f18748b;
                ReactInstanceManager.ReactContextInitParams reactContextInitParams = reactInstanceManager.f18456c;
                if (reactContextInitParams != null) {
                    reactInstanceManager.m(reactContextInitParams);
                    reactInstanceManager.f18456c = null;
                    break;
                }
                break;
        }
    }
}
