package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Property;
import android.view.View;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.MotionSpec;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.util.ArrayList;

/* loaded from: classes4.dex */
abstract class BaseMotionStrategy implements MotionStrategy {

    /* renamed from: a, reason: collision with root package name */
    public final Context f40430a;

    /* renamed from: b, reason: collision with root package name */
    public final ExtendedFloatingActionButton f40431b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f40432c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final AnimatorTracker f40433d;

    /* renamed from: e, reason: collision with root package name */
    public MotionSpec f40434e;

    /* renamed from: f, reason: collision with root package name */
    public MotionSpec f40435f;

    public BaseMotionStrategy(ExtendedFloatingActionButton extendedFloatingActionButton, AnimatorTracker animatorTracker) {
        this.f40431b = extendedFloatingActionButton;
        this.f40430a = extendedFloatingActionButton.getContext();
        this.f40433d = animatorTracker;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public void a() {
        this.f40433d.f40429a = null;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public void d() {
        this.f40433d.f40429a = null;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public AnimatorSet f() {
        MotionSpec motionSpec = this.f40435f;
        if (motionSpec == null) {
            if (this.f40434e == null) {
                this.f40434e = MotionSpec.b(e(), this.f40430a);
            }
            motionSpec = this.f40434e;
            motionSpec.getClass();
        }
        return g(motionSpec);
    }

    public final AnimatorSet g(MotionSpec motionSpec) {
        ArrayList arrayList = new ArrayList();
        boolean zG = motionSpec.g("opacity");
        ExtendedFloatingActionButton extendedFloatingActionButton = this.f40431b;
        if (zG) {
            arrayList.add(motionSpec.d("opacity", extendedFloatingActionButton, View.ALPHA));
        }
        if (motionSpec.g("scale")) {
            arrayList.add(motionSpec.d("scale", extendedFloatingActionButton, View.SCALE_Y));
            arrayList.add(motionSpec.d("scale", extendedFloatingActionButton, View.SCALE_X));
        }
        if (motionSpec.g(Snapshot.WIDTH)) {
            arrayList.add(motionSpec.d(Snapshot.WIDTH, extendedFloatingActionButton, ExtendedFloatingActionButton.K));
        }
        if (motionSpec.g(Snapshot.HEIGHT)) {
            arrayList.add(motionSpec.d(Snapshot.HEIGHT, extendedFloatingActionButton, ExtendedFloatingActionButton.L));
        }
        if (motionSpec.g("paddingStart")) {
            arrayList.add(motionSpec.d("paddingStart", extendedFloatingActionButton, ExtendedFloatingActionButton.M));
        }
        if (motionSpec.g("paddingEnd")) {
            arrayList.add(motionSpec.d("paddingEnd", extendedFloatingActionButton, ExtendedFloatingActionButton.Q));
        }
        if (motionSpec.g("labelOpacity")) {
            arrayList.add(motionSpec.d("labelOpacity", extendedFloatingActionButton, new Property<ExtendedFloatingActionButton, Float>() { // from class: com.google.android.material.floatingactionbutton.BaseMotionStrategy.1
                @Override // android.util.Property
                public final Float get(ExtendedFloatingActionButton extendedFloatingActionButton2) {
                    ExtendedFloatingActionButton extendedFloatingActionButton3 = extendedFloatingActionButton2;
                    return Float.valueOf(AnimationUtils.a(0.0f, 1.0f, (Color.alpha(extendedFloatingActionButton3.getCurrentTextColor()) / 255.0f) / Color.alpha(extendedFloatingActionButton3.G.getColorForState(extendedFloatingActionButton3.getDrawableState(), BaseMotionStrategy.this.f40431b.G.getDefaultColor()))));
                }

                @Override // android.util.Property
                public final void set(ExtendedFloatingActionButton extendedFloatingActionButton2, Float f2) {
                    ExtendedFloatingActionButton extendedFloatingActionButton3 = extendedFloatingActionButton2;
                    Float f3 = f2;
                    int colorForState = extendedFloatingActionButton3.G.getColorForState(extendedFloatingActionButton3.getDrawableState(), BaseMotionStrategy.this.f40431b.G.getDefaultColor());
                    ColorStateList colorStateListValueOf = ColorStateList.valueOf(Color.argb((int) (AnimationUtils.a(0.0f, Color.alpha(colorForState) / 255.0f, f3.floatValue()) * 255.0f), Color.red(colorForState), Color.green(colorForState), Color.blue(colorForState)));
                    if (f3.floatValue() == 1.0f) {
                        extendedFloatingActionButton3.f(extendedFloatingActionButton3.G);
                    } else {
                        extendedFloatingActionButton3.f(colorStateListValueOf);
                    }
                }
            }));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.a(animatorSet, arrayList);
        return animatorSet;
    }

    @Override // com.google.android.material.floatingactionbutton.MotionStrategy
    public void onAnimationStart(Animator animator) {
        AnimatorTracker animatorTracker = this.f40433d;
        Animator animator2 = animatorTracker.f40429a;
        if (animator2 != null) {
            animator2.cancel();
        }
        animatorTracker.f40429a = animator;
    }
}
