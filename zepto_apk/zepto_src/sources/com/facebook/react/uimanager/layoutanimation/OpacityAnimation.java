package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
class OpacityAnimation extends Animation {

    /* renamed from: a, reason: collision with root package name */
    public final View f19819a;

    /* renamed from: b, reason: collision with root package name */
    public final float f19820b;

    /* renamed from: c, reason: collision with root package name */
    public final float f19821c;

    public static class OpacityAnimationListener implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        public final View f19822a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f19823b = false;

        public OpacityAnimationListener(View view) {
            this.f19822a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation animation) {
            if (this.f19823b) {
                this.f19822a.setLayerType(0, null);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation animation) {
            View view = this.f19822a;
            if (view.hasOverlappingRendering() && view.getLayerType() == 0) {
                this.f19823b = true;
                view.setLayerType(2, null);
            }
        }
    }

    public OpacityAnimation(View view, float f2, float f3) {
        this.f19819a = view;
        this.f19820b = f2;
        this.f19821c = f3 - f2;
        setAnimationListener(new OpacityAnimationListener(view));
    }

    @Override // android.view.animation.Animation
    public final void applyTransformation(float f2, Transformation transformation) {
        this.f19819a.setAlpha((this.f19821c * f2) + this.f19820b);
    }

    @Override // android.view.animation.Animation
    public final boolean willChangeBounds() {
        return false;
    }
}
