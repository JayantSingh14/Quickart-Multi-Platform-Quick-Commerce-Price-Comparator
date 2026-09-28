package com.swmansion.reanimated.keyboard;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.media3.exoplayer.audio.h;
import com.facebook.react.bridge.ReactApplicationContext;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class WindowsInsetsManager {
    private final Keyboard mKeyboard;
    private final NotifyAboutKeyboardChangeFunction mNotifyAboutKeyboardChange;
    private final WeakReference<ReactApplicationContext> mReactContext;
    private boolean mIsStatusBarTranslucent = false;
    private boolean mIsNavigationBarTranslucent = false;
    private final String MissingContextErrorMsg = "Unable to get reference to react activity";

    public WindowsInsetsManager(WeakReference<ReactApplicationContext> weakReference, Keyboard keyboard, NotifyAboutKeyboardChangeFunction notifyAboutKeyboardChangeFunction) {
        this.mReactContext = weakReference;
        this.mKeyboard = keyboard;
        this.mNotifyAboutKeyboardChange = notifyAboutKeyboardChangeFunction;
    }

    private Activity getCurrentActivity() {
        return this.mReactContext.get().getCurrentActivity();
    }

    private FrameLayout.LayoutParams getLayoutParams(int i2, int i3) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (this.mIsStatusBarTranslucent) {
            i2 = 0;
        }
        if (this.mIsNavigationBarTranslucent) {
            i3 = 0;
        }
        layoutParams.setMargins(0, i2, 0, i3);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateInsets$1(int i2, int i3) {
        FrameLayout.LayoutParams layoutParams = getLayoutParams(i2, i3);
        int i4 = R.id.action_bar_root;
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            Log.e("Reanimated", "Unable to get reference to react activity");
        } else {
            currentActivity.getWindow().getDecorView().findViewById(i4).setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateWindowDecor$0(boolean z) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            Log.e("Reanimated", "Unable to get reference to react activity");
        } else {
            WindowCompat.b(currentActivity.getWindow(), z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public WindowInsetsCompat onApplyWindowInsetsListener(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompatT = ViewCompat.t(view, windowInsetsCompat);
        if (this.mKeyboard.getState() == KeyboardState.OPEN) {
            this.mKeyboard.updateHeight(windowInsetsCompat, this.mIsNavigationBarTranslucent);
            this.mNotifyAboutKeyboardChange.call();
        }
        setWindowInsets(windowInsetsCompatT);
        return windowInsetsCompatT;
    }

    private void setWindowInsets(WindowInsetsCompat windowInsetsCompat) {
        updateInsets(windowInsetsCompat.d(519).f2809b, windowInsetsCompat.d(519).f2811d);
    }

    private void updateInsets(int i2, int i3) {
        new Handler(Looper.getMainLooper()).post(new com.swmansion.reanimated.a(this, i2, i3, 2));
    }

    private void updateWindowDecor(boolean z) {
        new Handler(Looper.getMainLooper()).post(new h(this, z, 1));
    }

    public void startObservingChanges(KeyboardAnimationCallback keyboardAnimationCallback, boolean z, boolean z2) {
        this.mIsStatusBarTranslucent = z;
        this.mIsNavigationBarTranslucent = z2;
        updateWindowDecor(false);
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            Log.e("Reanimated", "Unable to get reference to react activity");
            return;
        }
        View decorView = currentActivity.getWindow().getDecorView();
        ViewCompat.H(decorView, new com.facebook.react.views.safeareaview.a(this, 1));
        ViewCompat.O(decorView, keyboardAnimationCallback);
    }

    public void stopObservingChanges() {
        updateWindowDecor((this.mIsStatusBarTranslucent || this.mIsNavigationBarTranslucent) ? false : true);
        updateInsets(0, 0);
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            Log.e("Reanimated", "Unable to get reference to react activity");
            return;
        }
        View decorView = currentActivity.getWindow().getDecorView();
        ViewCompat.O(decorView, null);
        ViewCompat.H(decorView, null);
    }
}
