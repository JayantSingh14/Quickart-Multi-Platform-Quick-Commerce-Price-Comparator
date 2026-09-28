package com.swmansion.rnscreens.stack.views;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactPointerEventsView;
import com.facebook.react.uimanager.ThemedReactContext;
import com.swmansion.rnscreens.PointerEventsBoxNoneImpl;
import com.swmansion.rnscreens.Screen;
import com.swmansion.rnscreens.Screen$updateScreenSizePaper$1;
import com.swmansion.rnscreens.ScreenContainer;
import com.swmansion.rnscreens.ScreenFooter;
import com.swmansion.rnscreens.ScreenStack;
import com.swmansion.rnscreens.ScreenStackFragment;
import com.swmansion.rnscreens.bottomsheet.SheetUtilsKt;
import com.swmansion.rnscreens.stack.anim.ScreensAnimation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class ScreensCoordinatorLayout extends CoordinatorLayout implements ReactPointerEventsView {
    public final ScreenStackFragment x;
    public final PointerEventsBoxNoneImpl y;
    public final ScreensCoordinatorLayout$animationListener$1 z;

    /* JADX WARN: Type inference failed for: r4v1, types: [com.swmansion.rnscreens.stack.views.ScreensCoordinatorLayout$animationListener$1] */
    public ScreensCoordinatorLayout(Context context, ScreenStackFragment fragment) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        PointerEventsBoxNoneImpl pointerEventsImpl = new PointerEventsBoxNoneImpl();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(pointerEventsImpl, "pointerEventsImpl");
        super(context, null);
        this.x = fragment;
        this.y = pointerEventsImpl;
        this.z = new Animation.AnimationListener() { // from class: com.swmansion.rnscreens.stack.views.ScreensCoordinatorLayout$animationListener$1
            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                ScreenStackFragment fragment$react_native_screens_release = this.f47141a.getFragment$react_native_screens_release();
                fragment$react_native_screens_release.B(true);
                View view = fragment$react_native_screens_release.getView();
                ViewParent parent = view != null ? view.getParent() : null;
                if (parent instanceof ScreenStack) {
                    ScreenStack screenStack = (ScreenStack) parent;
                    if (!screenStack.n) {
                        screenStack.k();
                    }
                }
                Screen screenK = fragment$react_native_screens_release.k();
                if (screenK.f46946k) {
                    screenK.f46946k = false;
                    Screen.b(screenK);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationRepeat(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationStart(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.f47141a.getFragment$react_native_screens_release().B(false);
            }
        };
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void clearFocus() {
        if (getVisibility() != 4) {
            super.clearFocus();
        }
    }

    @NotNull
    public final ScreenStackFragment getFragment$react_native_screens_release() {
        return this.x;
    }

    @Override // com.facebook.react.uimanager.ReactPointerEventsView
    @NotNull
    public PointerEvents getPointerEvents() {
        return this.y.f46935a;
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        WindowInsets windowInsetsOnApplyWindowInsets = super.onApplyWindowInsets(windowInsets);
        Intrinsics.checkNotNullExpressionValue(windowInsetsOnApplyWindowInsets, "onApplyWindowInsets(...)");
        return windowInsetsOnApplyWindowInsets;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        ScreenStackFragment screenStackFragment = this.x;
        if (SheetUtilsKt.c(screenStackFragment.k())) {
            Screen screenK = screenStackFragment.k();
            if (SheetUtilsKt.c(screenK) && (screenK.f46938c instanceof ScreenStack)) {
                if (z) {
                    int width = screenK.getWidth();
                    int height = screenK.getHeight();
                    screenK.getTop();
                    ThemedReactContext themedReactContext = screenK.f46936a;
                    themedReactContext.runOnNativeModulesQueueThread(new Screen$updateScreenSizePaper$1(screenK, width, height, themedReactContext.getExceptionHandler()));
                }
                ScreenFooter screenFooter = screenK.u;
                if (screenFooter != null) {
                    screenK.getLeft();
                    screenK.getTop();
                    screenK.getRight();
                    screenK.getBottom();
                    ScreenContainer screenContainer = screenK.f46938c;
                    Intrinsics.c(screenContainer);
                    screenFooter.m(screenContainer.getHeight());
                }
                if (screenK.t) {
                    screenK.t = false;
                    Fragment fragment = screenK.getFragment();
                    if (fragment != null) {
                        fragment.startPostponedEnterTransition();
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public final void startAnimation(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        ScreenStackFragment screenStackFragment = this.x;
        ScreensAnimation screensAnimation = new ScreensAnimation(screenStackFragment);
        screensAnimation.setDuration(animation.getDuration());
        boolean z = animation instanceof AnimationSet;
        ScreensCoordinatorLayout$animationListener$1 screensCoordinatorLayout$animationListener$1 = this.z;
        if (z && !screenStackFragment.isRemoving()) {
            AnimationSet animationSet = (AnimationSet) animation;
            animationSet.addAnimation(screensAnimation);
            animationSet.setAnimationListener(screensCoordinatorLayout$animationListener$1);
            super.startAnimation(animationSet);
            return;
        }
        AnimationSet animationSet2 = new AnimationSet(true);
        animationSet2.addAnimation(animation);
        animationSet2.addAnimation(screensAnimation);
        animationSet2.setAnimationListener(screensCoordinatorLayout$animationListener$1);
        super.startAnimation(animationSet2);
    }
}
