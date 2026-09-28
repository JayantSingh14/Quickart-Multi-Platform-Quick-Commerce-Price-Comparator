package com.swmansion.rnscreens.bottomsheet;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.facebook.react.uimanager.ThemedReactContext;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.swmansion.rnscreens.Screen;
import com.swmansion.rnscreens.ScreenStackFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class DimmingViewManager {

    /* renamed from: a, reason: collision with root package name */
    public final DimmingView f47089a;

    /* renamed from: b, reason: collision with root package name */
    public final float f47090b;

    /* renamed from: c, reason: collision with root package name */
    public BottomSheetBehavior.BottomSheetCallback f47091c;

    @Metadata
    public static final class AnimateDimmingViewCallback extends BottomSheetBehavior.BottomSheetCallback {

        /* renamed from: a, reason: collision with root package name */
        public final Screen f47092a;

        /* renamed from: b, reason: collision with root package name */
        public final View f47093b;

        /* renamed from: c, reason: collision with root package name */
        public float f47094c;

        /* renamed from: d, reason: collision with root package name */
        public float f47095d;

        /* renamed from: e, reason: collision with root package name */
        public float f47096e;

        /* renamed from: f, reason: collision with root package name */
        public final ValueAnimator f47097f;

        public AnimateDimmingViewCallback(Screen screen, View viewToAnimate, float f2) {
            Intrinsics.checkNotNullParameter(screen, "screen");
            Intrinsics.checkNotNullParameter(viewToAnimate, "viewToAnimate");
            this.f47092a = screen;
            this.f47093b = viewToAnimate;
            this.f47094c = a(screen.getSheetLargestUndimmedDetentIndex());
            float fA = a(RangesKt.b(screen.getSheetLargestUndimmedDetentIndex() + 1, screen.getSheetDetents().size() - 1));
            this.f47095d = fA;
            this.f47096e = fA - this.f47094c;
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, f2);
            valueAnimatorOfFloat.setDuration(1L);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.swmansion.rnscreens.bottomsheet.b
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    View view = this.f47110a.f47093b;
                    Object animatedValue = it.getAnimatedValue();
                    Intrinsics.d(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                    view.setAlpha(((Float) animatedValue).floatValue());
                }
            });
            this.f47097f = valueAnimatorOfFloat;
        }

        public final float a(int i2) {
            Screen screen = this.f47092a;
            int size = screen.getSheetDetents().size();
            if (size == 1) {
                return (i2 == -1 || i2 != 0) ? -1.0f : 1.0f;
            }
            if (size == 2) {
                if (i2 == -1) {
                    return -1.0f;
                }
                if (i2 != 0) {
                    return i2 != 1 ? -1.0f : 1.0f;
                }
                return 0.0f;
            }
            if (size != 3 || i2 == -1) {
                return -1.0f;
            }
            if (i2 == 0) {
                return 0.0f;
            }
            if (i2 != 1) {
                return i2 != 2 ? -1.0f : 1.0f;
            }
            BottomSheetBehavior<Screen> sheetBehavior = screen.getSheetBehavior();
            Intrinsics.c(sheetBehavior);
            return sheetBehavior.F;
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onSlide(View bottomSheet, float f2) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            float f3 = this.f47094c;
            if (f3 >= f2 || f2 >= this.f47095d) {
                return;
            }
            this.f47097f.setCurrentFraction((f2 - f3) / this.f47096e);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public final void onStateChanged(View bottomSheet, int i2) {
            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
            if (i2 == 1 || i2 == 2) {
                Screen screen = this.f47092a;
                this.f47094c = a(screen.getSheetLargestUndimmedDetentIndex());
                float fA = a(RangesKt.b(screen.getSheetLargestUndimmedDetentIndex() + 1, screen.getSheetDetents().size() - 1));
                this.f47095d = fA;
                this.f47096e = fA - this.f47094c;
            }
        }
    }

    public DimmingViewManager(ThemedReactContext reactContext, final Screen screen) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(screen, "screen");
        DimmingView dimmingView = new DimmingView(reactContext, this.f47090b);
        dimmingView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        dimmingView.setOnClickListener(new View.OnClickListener() { // from class: com.swmansion.rnscreens.bottomsheet.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Screen screen2 = screen;
                if (screen2.getSheetClosesOnTouchOutside()) {
                    Fragment fragment = screen2.getFragment();
                    Intrinsics.d(fragment, "null cannot be cast to non-null type com.swmansion.rnscreens.ScreenStackFragment");
                    ((ScreenStackFragment) fragment).E();
                }
            }
        });
        this.f47089a = dimmingView;
        this.f47090b = 0.3f;
    }

    public final void a(Screen screen, BottomSheetBehavior behavior) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        Intrinsics.checkNotNullParameter(behavior, "behavior");
        AnimateDimmingViewCallback animateDimmingViewCallback = new AnimateDimmingViewCallback(screen, this.f47089a, this.f47090b);
        this.f47091c = animateDimmingViewCallback;
        behavior.y(animateDimmingViewCallback);
    }
}
