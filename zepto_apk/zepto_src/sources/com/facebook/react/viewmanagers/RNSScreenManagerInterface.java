package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

/* loaded from: classes.dex */
public interface RNSScreenManagerInterface<T extends View> {
    void setActivityState(View view, float f2);

    void setCustomAnimationOnSwipe(View view, boolean z);

    void setFullScreenSwipeEnabled(View view, boolean z);

    void setFullScreenSwipeShadowEnabled(View view, boolean z);

    void setGestureEnabled(View view, boolean z);

    void setGestureResponseDistance(View view, ReadableMap readableMap);

    void setHideKeyboardOnSwipe(View view, boolean z);

    void setHomeIndicatorHidden(View view, boolean z);

    void setNativeBackButtonDismissalEnabled(View view, boolean z);

    void setNavigationBarColor(View view, Integer num);

    void setNavigationBarHidden(View view, boolean z);

    void setNavigationBarTranslucent(View view, boolean z);

    void setPreventNativeDismiss(View view, boolean z);

    void setReplaceAnimation(View view, String str);

    void setScreenOrientation(View view, String str);

    void setSheetAllowedDetents(View view, ReadableArray readableArray);

    void setSheetCornerRadius(View view, float f2);

    void setSheetElevation(View view, int i2);

    void setSheetExpandsWhenScrolledToEdge(View view, boolean z);

    void setSheetGrabberVisible(View view, boolean z);

    void setSheetInitialDetent(View view, int i2);

    void setSheetLargestUndimmedDetent(View view, int i2);

    void setStackAnimation(View view, String str);

    void setStackPresentation(View view, String str);

    void setStatusBarAnimation(View view, String str);

    void setStatusBarColor(View view, Integer num);

    void setStatusBarHidden(View view, boolean z);

    void setStatusBarStyle(View view, String str);

    void setStatusBarTranslucent(View view, boolean z);

    void setSwipeDirection(View view, String str);

    void setTransitionDuration(View view, int i2);
}
