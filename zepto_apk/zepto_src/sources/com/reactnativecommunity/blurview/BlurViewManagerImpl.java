package com.reactnativecommunity.blurview;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.uimanager.ThemedReactContext;
import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.NoOpController;
import eightbitlab.com.blurview.PreDrawBlurController;
import java.util.Objects;

/* loaded from: classes4.dex */
class BlurViewManagerImpl {
    public static BlurView a(ThemedReactContext themedReactContext) {
        BlurView blurView = new BlurView(themedReactContext);
        blurView.f48323a = new NoOpController();
        blurView.a(null, 0);
        Activity currentActivity = themedReactContext.f19479a.getCurrentActivity();
        Objects.requireNonNull(currentActivity);
        View decorView = currentActivity.getWindow().getDecorView();
        PreDrawBlurController preDrawBlurControllerB = blurView.b((ViewGroup) decorView.findViewById(android.R.id.content));
        preDrawBlurControllerB.f48337m = decorView.getBackground();
        preDrawBlurControllerB.f48325a = 10.0f;
        return blurView;
    }

    public static void b(BlurView blurView, boolean z) {
        blurView.f48323a.c(z);
        blurView.invalidate();
    }

    public static void c(BlurView blurView, boolean z) {
        blurView.f48323a.b(z);
    }

    public static void d(BlurView blurView, int i2) {
        blurView.f48324b = i2;
        blurView.f48323a.a(i2);
        blurView.invalidate();
    }

    public static void e(BlurView blurView, int i2) {
        blurView.f48323a.e(i2);
        blurView.invalidate();
    }
}
