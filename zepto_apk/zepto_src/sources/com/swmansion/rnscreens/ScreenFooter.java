package com.swmansion.rnscreens;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.view.ReactViewGroup;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.math.MathUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata
@SuppressLint({"ViewConstructor"})
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ScreenFooter extends ReactViewGroup {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f46999h = 0;

    /* renamed from: a, reason: collision with root package name */
    public final ThemedReactContext f47000a;

    /* renamed from: b, reason: collision with root package name */
    public int f47001b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f47002c;

    /* renamed from: d, reason: collision with root package name */
    public float f47003d;

    /* renamed from: e, reason: collision with root package name */
    public int f47004e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f47005f;

    /* renamed from: g, reason: collision with root package name */
    public final ScreenFooter$footerCallback$1 f47006g;

    @Metadata
    /* loaded from: classes4.dex */
    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r3v5, types: [com.swmansion.rnscreens.ScreenFooter$footerCallback$1] */
    public ScreenFooter(ThemedReactContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.f47000a = reactContext;
        WindowInsetsAnimationCompat.Callback callback = new WindowInsetsAnimationCompat.Callback() { // from class: com.swmansion.rnscreens.ScreenFooter$insetsAnimation$1
            {
                super(0);
            }

            @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
            public final void onEnd(WindowInsetsAnimationCompat animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.f47008a.f47002c = false;
            }

            @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
            public final WindowInsetsCompat onProgress(WindowInsetsCompat insets, List runningAnimations) {
                Intrinsics.checkNotNullParameter(insets, "insets");
                Intrinsics.checkNotNullParameter(runningAnimations, "runningAnimations");
                int i2 = insets.d(8).f2811d - insets.d(2).f2811d;
                ScreenFooter screenFooter = this.f47008a;
                screenFooter.f47004e = i2;
                screenFooter.l(screenFooter.f47001b, screenFooter.getReactHeight(), ScreenFooter.k(screenFooter, screenFooter.f47003d), screenFooter.f47004e);
                return insets;
            }

            @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
            public final WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat animation, WindowInsetsAnimationCompat.BoundsCompat bounds) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                Intrinsics.checkNotNullParameter(bounds, "bounds");
                this.f47008a.f47002c = true;
                WindowInsetsAnimationCompat.BoundsCompat boundsCompatOnStart = super.onStart(animation, bounds);
                Intrinsics.checkNotNullExpressionValue(boundsCompatOnStart, "onStart(...)");
                return boundsCompatOnStart;
            }
        };
        Activity currentActivity = reactContext.getCurrentActivity();
        if (currentActivity == null) {
            throw new IllegalStateException("[RNScreens] Context detached from activity while creating ScreenFooter");
        }
        View decorView = currentActivity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        ViewCompat.O(decorView, callback);
        this.f47006g = new BottomSheetBehavior.BottomSheetCallback() { // from class: com.swmansion.rnscreens.ScreenFooter$footerCallback$1
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public final void onSlide(View bottomSheet, float f2) {
                Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                float fMax = Math.max(f2, 0.0f);
                ScreenFooter screenFooter = this.f47007a;
                screenFooter.f47003d = fMax;
                if (screenFooter.f47002c) {
                    return;
                }
                screenFooter.l(screenFooter.f47001b, screenFooter.getReactHeight(), ScreenFooter.k(screenFooter, screenFooter.f47003d), screenFooter.f47004e);
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public final void onStateChanged(View bottomSheet, int i2) {
                Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                if (i2 == 3 || i2 == 4 || i2 == 5 || i2 == 6) {
                    ScreenFooter screenFooter = this.f47007a;
                    if (i2 == 3 || i2 == 4 || i2 == 6) {
                        screenFooter.l(screenFooter.f47001b, screenFooter.getReactHeight(), screenFooter.o(i2), screenFooter.f47004e);
                    }
                    int i3 = ScreenFooter.f46999h;
                    screenFooter.getClass();
                }
            }
        };
    }

    private final boolean getHasReceivedInitialLayoutFromParent() {
        return this.f47001b > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getReactHeight() {
        return getMeasuredHeight();
    }

    private final int getReactWidth() {
        return getMeasuredWidth();
    }

    private final Screen getScreenParent() {
        ViewParent parent = getParent();
        if (parent instanceof Screen) {
            return (Screen) parent;
        }
        return null;
    }

    private final BottomSheetBehavior<Screen> getSheetBehavior() {
        Screen screenParent = getScreenParent();
        if (screenParent != null) {
            return screenParent.getSheetBehavior();
        }
        throw new IllegalArgumentException("Required value was null.");
    }

    public static final int k(ScreenFooter screenFooter, float f2) {
        Screen screenParent = screenFooter.getScreenParent();
        return screenParent != null ? screenParent.getTop() : (int) MathUtils.c(screenFooter.o(4), screenFooter.o(3), f2);
    }

    @NotNull
    public final ReactContext getReactContext() {
        return this.f47000a;
    }

    public final void l(int i2, int i3, int i4, int i5) {
        int iMax = ((i2 - i3) - i4) - Math.max(i5, 0);
        int reactHeight = getReactHeight();
        setTop(Math.max(iMax, 0));
        setBottom(getTop() + reactHeight);
    }

    public final void m(int i2) {
        this.f47001b = i2;
        int reactHeight = getReactHeight();
        BottomSheetBehavior<Screen> sheetBehavior = getSheetBehavior();
        if (sheetBehavior == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        l(i2, reactHeight, o(sheetBehavior.getState()), 0);
    }

    public final void n(BottomSheetBehavior behavior) {
        Intrinsics.checkNotNullParameter(behavior, "behavior");
        if (this.f47005f) {
            return;
        }
        behavior.y(this.f47006g);
        this.f47005f = true;
    }

    public final int o(int i2) {
        BottomSheetBehavior<Screen> sheetBehavior = getSheetBehavior();
        if (sheetBehavior == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        if (i2 == 3) {
            return sheetBehavior.H();
        }
        if (i2 == 4) {
            return this.f47001b - sheetBehavior.J();
        }
        if (i2 == 5) {
            return this.f47001b;
        }
        if (i2 != 6) {
            throw new IllegalArgumentException("[RNScreens] use of stable-state method for unstable state");
        }
        return (int) ((1 - sheetBehavior.I()) * this.f47001b);
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        BottomSheetBehavior<Screen> sheetBehavior = getSheetBehavior();
        if (sheetBehavior != null) {
            n(sheetBehavior);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BottomSheetBehavior<Screen> behavior = getSheetBehavior();
        if (behavior != null) {
            Intrinsics.checkNotNullParameter(behavior, "behavior");
            if (this.f47005f) {
                behavior.M(this.f47006g);
                this.f47005f = false;
            }
        }
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (getHasReceivedInitialLayoutFromParent()) {
            int i6 = this.f47001b;
            int i7 = i5 - i3;
            BottomSheetBehavior<Screen> sheetBehavior = getSheetBehavior();
            if (sheetBehavior == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            l(i6, i7, o(sheetBehavior.getState()), this.f47004e);
        }
    }
}
