package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.progressindicator.DrawingDelegate;
import java.util.ArrayList;

/* loaded from: classes4.dex */
final class CircularIndeterminateAnimatorDelegate extends IndeterminateAnimatorDelegate<ObjectAnimator> {

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f40789k = {0, 1350, 2700, 4050};

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f40790l = {667, 2017, 3367, 4717};

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f40791m = {1000, 2350, 3700, 5050};
    public static final Property n = new AnonymousClass3(Float.class, "animationFraction");
    public static final Property o = new AnonymousClass4(Float.class, "completeEndFraction");

    /* renamed from: c, reason: collision with root package name */
    public ObjectAnimator f40792c;

    /* renamed from: d, reason: collision with root package name */
    public ObjectAnimator f40793d;

    /* renamed from: e, reason: collision with root package name */
    public final FastOutSlowInInterpolator f40794e;

    /* renamed from: f, reason: collision with root package name */
    public final CircularProgressIndicatorSpec f40795f;

    /* renamed from: g, reason: collision with root package name */
    public int f40796g;

    /* renamed from: h, reason: collision with root package name */
    public float f40797h;

    /* renamed from: i, reason: collision with root package name */
    public float f40798i;

    /* renamed from: j, reason: collision with root package name */
    public Animatable2Compat.AnimationCallback f40799j;

    /* renamed from: com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate$3, reason: invalid class name */
    public class AnonymousClass3 extends Property<CircularIndeterminateAnimatorDelegate, Float> {
        @Override // android.util.Property
        public final Float get(CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate) {
            return Float.valueOf(circularIndeterminateAnimatorDelegate.f40797h);
        }

        @Override // android.util.Property
        public final void set(CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate, Float f2) {
            FastOutSlowInInterpolator fastOutSlowInInterpolator;
            CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate2 = circularIndeterminateAnimatorDelegate;
            float fFloatValue = f2.floatValue();
            circularIndeterminateAnimatorDelegate2.f40797h = fFloatValue;
            int i2 = (int) (fFloatValue * 5400.0f);
            ArrayList arrayList = circularIndeterminateAnimatorDelegate2.f40827b;
            DrawingDelegate.ActiveIndicator activeIndicator = (DrawingDelegate.ActiveIndicator) arrayList.get(0);
            float f3 = circularIndeterminateAnimatorDelegate2.f40797h * 1520.0f;
            activeIndicator.f40822a = (-20.0f) + f3;
            activeIndicator.f40823b = f3;
            int i3 = 0;
            while (true) {
                fastOutSlowInInterpolator = circularIndeterminateAnimatorDelegate2.f40794e;
                if (i3 >= 4) {
                    break;
                }
                activeIndicator.f40823b = (fastOutSlowInInterpolator.getInterpolation(IndeterminateAnimatorDelegate.b(i2, CircularIndeterminateAnimatorDelegate.f40789k[i3], 667)) * 250.0f) + activeIndicator.f40823b;
                activeIndicator.f40822a = (fastOutSlowInInterpolator.getInterpolation(IndeterminateAnimatorDelegate.b(i2, CircularIndeterminateAnimatorDelegate.f40790l[i3], 667)) * 250.0f) + activeIndicator.f40822a;
                i3++;
            }
            float f4 = activeIndicator.f40822a;
            float f5 = activeIndicator.f40823b;
            activeIndicator.f40822a = (((f5 - f4) * circularIndeterminateAnimatorDelegate2.f40798i) + f4) / 360.0f;
            activeIndicator.f40823b = f5 / 360.0f;
            int i4 = 0;
            while (true) {
                if (i4 >= 4) {
                    break;
                }
                float fB = IndeterminateAnimatorDelegate.b(i2, CircularIndeterminateAnimatorDelegate.f40791m[i4], 333);
                if (fB >= 0.0f && fB <= 1.0f) {
                    int i5 = i4 + circularIndeterminateAnimatorDelegate2.f40796g;
                    int[] iArr = circularIndeterminateAnimatorDelegate2.f40795f.f40779c;
                    int length = i5 % iArr.length;
                    int length2 = (length + 1) % iArr.length;
                    int i6 = iArr[length];
                    int i7 = iArr[length2];
                    float interpolation = fastOutSlowInInterpolator.getInterpolation(fB);
                    DrawingDelegate.ActiveIndicator activeIndicator2 = (DrawingDelegate.ActiveIndicator) arrayList.get(0);
                    ArgbEvaluatorCompat argbEvaluatorCompat = ArgbEvaluatorCompat.f39821a;
                    Integer numValueOf = Integer.valueOf(i6);
                    Integer numValueOf2 = Integer.valueOf(i7);
                    argbEvaluatorCompat.getClass();
                    activeIndicator2.f40824c = ArgbEvaluatorCompat.a(interpolation, numValueOf, numValueOf2).intValue();
                    break;
                }
                i4++;
            }
            circularIndeterminateAnimatorDelegate2.f40826a.invalidateSelf();
        }
    }

    /* renamed from: com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate$4, reason: invalid class name */
    public class AnonymousClass4 extends Property<CircularIndeterminateAnimatorDelegate, Float> {
        @Override // android.util.Property
        public final Float get(CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate) {
            return Float.valueOf(circularIndeterminateAnimatorDelegate.f40798i);
        }

        @Override // android.util.Property
        public final void set(CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate, Float f2) {
            circularIndeterminateAnimatorDelegate.f40798i = f2.floatValue();
        }
    }

    public CircularIndeterminateAnimatorDelegate(CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(1);
        this.f40796g = 0;
        this.f40799j = null;
        this.f40795f = circularProgressIndicatorSpec;
        this.f40794e = new FastOutSlowInInterpolator();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public final void a() {
        ObjectAnimator objectAnimator = this.f40792c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public final void c() {
        this.f40796g = 0;
        ((DrawingDelegate.ActiveIndicator) this.f40827b.get(0)).f40824c = this.f40795f.f40779c[0];
        this.f40798i = 0.0f;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public final void d(Animatable2Compat.AnimationCallback animationCallback) {
        this.f40799j = animationCallback;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public final void e() {
        ObjectAnimator objectAnimator = this.f40793d;
        if (objectAnimator == null || objectAnimator.isRunning()) {
            return;
        }
        if (this.f40826a.isVisible()) {
            this.f40793d.start();
        } else {
            a();
        }
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public final void f() {
        if (this.f40792c == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<CircularIndeterminateAnimatorDelegate, Float>) n, 0.0f, 1.0f);
            this.f40792c = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(5400L);
            this.f40792c.setInterpolator(null);
            this.f40792c.setRepeatCount(-1);
            this.f40792c.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate = CircularIndeterminateAnimatorDelegate.this;
                    circularIndeterminateAnimatorDelegate.f40796g = (circularIndeterminateAnimatorDelegate.f40796g + 4) % circularIndeterminateAnimatorDelegate.f40795f.f40779c.length;
                }
            });
        }
        if (this.f40793d == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, (Property<CircularIndeterminateAnimatorDelegate, Float>) o, 0.0f, 1.0f);
            this.f40793d = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(333L);
            this.f40793d.setInterpolator(this.f40794e);
            this.f40793d.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    CircularIndeterminateAnimatorDelegate circularIndeterminateAnimatorDelegate = CircularIndeterminateAnimatorDelegate.this;
                    circularIndeterminateAnimatorDelegate.a();
                    Animatable2Compat.AnimationCallback animationCallback = circularIndeterminateAnimatorDelegate.f40799j;
                    if (animationCallback != null) {
                        animationCallback.a(circularIndeterminateAnimatorDelegate.f40826a);
                    }
                }
            });
        }
        this.f40796g = 0;
        ((DrawingDelegate.ActiveIndicator) this.f40827b.get(0)).f40824c = this.f40795f.f40779c[0];
        this.f40798i = 0.0f;
        this.f40792c.start();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public final void g() {
        this.f40799j = null;
    }
}
