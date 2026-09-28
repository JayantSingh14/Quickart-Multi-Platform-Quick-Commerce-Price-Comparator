package com.google.android.material.color;

import android.app.Activity;
import android.app.Application;
import android.app.UiModeManager;
import android.app.UiModeManager$ContrastChangeListener;
import android.os.Bundle;
import androidx.annotation.RequiresApi;

/* loaded from: classes4.dex */
public class ColorContrast {

    @RequiresApi
    public static class ColorContrastActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {

        /* renamed from: com.google.android.material.color.ColorContrast$ColorContrastActivityLifecycleCallbacks$1, reason: invalid class name */
        class AnonymousClass1 implements UiModeManager$ContrastChangeListener {
            public final void onContrastChanged(float f2) {
                throw null;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            throw null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPreCreated(Activity activity, Bundle bundle) {
            ((UiModeManager) activity.getSystemService("uimode")).getClass();
            throw null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
        }
    }
}
