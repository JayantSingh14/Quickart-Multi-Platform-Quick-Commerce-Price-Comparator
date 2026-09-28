package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.progressindicator.DrawingDelegate;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
final class LinearIndeterminateContiguousAnimatorDelegate extends IndeterminateAnimatorDelegate<ObjectAnimator> {

    /* renamed from: i, reason: collision with root package name */
    public static final Property f40835i = new AnonymousClass2(Float.class, "animationFraction");

    /* renamed from: c, reason: collision with root package name */
    public ObjectAnimator f40836c;

    /* renamed from: d, reason: collision with root package name */
    public final FastOutSlowInInterpolator f40837d;

    /* renamed from: e, reason: collision with root package name */
    public final LinearProgressIndicatorSpec f40838e;

    /* renamed from: f, reason: collision with root package name */
    public int f40839f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f40840g;

    /* renamed from: h, reason: collision with root package name */
    public float f40841h;

    /* renamed from: com.google.android.material.progressindicator.LinearIndeterminateContiguousAnimatorDelegate$2, reason: invalid class name */
    public class AnonymousClass2 extends Property<LinearIndeterminateContiguousAnimatorDelegate, Float> {
        @Override // android.util.Property
        public final Float get(LinearIndeterminateContiguousAnimatorDelegate linearIndeterminateContiguousAnimatorDelegate) {
            return Float.valueOf(linearIndeterminateContiguousAnimatorDelegate.f40841h);
        }

        @Override // android.util.Property
        public final void set(LinearIndeterminateContiguousAnimatorDelegate linearIndeterminateContiguousAnimatorDelegate, Float f2) {
            LinearIndeterminateContiguousAnimatorDelegate linearIndeterminateContiguousAnimatorDelegate2 = linearIndeterminateContiguousAnimatorDelegate;
            float fFloatValue = f2.floatValue();
            linearIndeterminateContiguousAnimatorDelegate2.f40841h = fFloatValue;
            ArrayList arrayList = linearIndeterminateContiguousAnimatorDelegate2.f40827b;
            ((DrawingDelegate.ActiveIndicator) arrayList.get(0)).f40822a = 0.0f;
            float fB = IndeterminateAnimatorDelegate.b((int) (fFloatValue * 333.0f), 0, 667);
            DrawingDelegate.ActiveIndicator activeIndicator = (DrawingDelegate.ActiveIndicator) arrayList.get(0);
            DrawingDelegate.ActiveIndicator activeIndicator2 = (DrawingDelegate.ActiveIndicator) arrayList.get(1);
            FastOutSlowInInterpolator fastOutSlowInInterpolator = linearIndeterminateContiguousAnimatorDelegate2.f40837d;
            float interpolation = fastOutSlowInInterpolator.getInterpolation(fB);
            activeIndicator2.f40822a = interpolation;
            activeIndicator.f40823b = interpolation;
            DrawingDelegate.ActiveIndicator activeIndicator3 = (DrawingDelegate.ActiveIndicator) arrayList.get(1);
            DrawingDelegate.ActiveIndicator activeIndicator4 = (DrawingDelegate.ActiveIndicator) arrayList.get(2);
            float interpolation2 = fastOutSlowInInterpolator.getInterpolation(fB + 0.49925038f);
            activeIndicator4.f40822a = interpolation2;
            activeIndicator3.f40823b = interpolation2;
            ((DrawingDelegate.ActiveIndicator) arrayList.get(2)).f40823b = 1.0f;
            if (linearIndeterminateContiguousAnimatorDelegate2.f40840g && ((DrawingDelegate.ActiveIndicator) arrayList.get(1)).f40823b < 1.0f) {
                ((DrawingDelegate.ActiveIndicator) arrayList.get(2)).f40824c = ((DrawingDelegate.ActiveIndicator) arrayList.get(1)).f40824c;
                ((DrawingDelegate.ActiveIndicator) arrayList.get(1)).f40824c = ((DrawingDelegate.ActiveIndicator) arrayList.get(0)).f40824c;
                ((DrawingDelegate.ActiveIndicator) arrayList.get(0)).f40824c = linearIndeterminateContiguousAnimatorDelegate2.f40838e.f40779c[linearIndeterminateContiguousAnimatorDelegate2.f40839f];
                linearIndeterminateContiguousAnimatorDelegate2.f40840g = false;
            }
            linearIndeterminateContiguousAnimatorDelegate2.f40826a.invalidateSelf();
        }
    }

    public LinearIndeterminateContiguousAnimatorDelegate(LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(3);
        this.f40839f = 1;
        this.f40838e = linearProgressIndicatorSpec;
        this.f40837d = new FastOutSlowInInterpolator();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public final void a() {
        ObjectAnimator objectAnimator = this.f40836c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public final void c() {
        h();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public final void d(Animatable2Compat.AnimationCallback animationCallback) {
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public final void e() {
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public final void f() {
        if (this.f40836c == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<LinearIndeterminateContiguousAnimatorDelegate, Float>) f40835i, 0.0f, 1.0f);
            this.f40836c = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(333L);
            this.f40836c.setInterpolator(null);
            this.f40836c.setRepeatCount(-1);
            this.f40836c.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.LinearIndeterminateContiguousAnimatorDelegate.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    LinearIndeterminateContiguousAnimatorDelegate linearIndeterminateContiguousAnimatorDelegate = LinearIndeterminateContiguousAnimatorDelegate.this;
                    linearIndeterminateContiguousAnimatorDelegate.f40839f = (linearIndeterminateContiguousAnimatorDelegate.f40839f + 1) % linearIndeterminateContiguousAnimatorDelegate.f40838e.f40779c.length;
                    linearIndeterminateContiguousAnimatorDelegate.f40840g = true;
                }
            });
        }
        h();
        this.f40836c.start();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public final void g() {
    }

    public final void h() {
        this.f40840g = true;
        this.f40839f = 1;
        Iterator it = this.f40827b.iterator();
        while (it.hasNext()) {
            DrawingDelegate.ActiveIndicator activeIndicator = (DrawingDelegate.ActiveIndicator) it.next();
            LinearProgressIndicatorSpec linearProgressIndicatorSpec = this.f40838e;
            activeIndicator.f40824c = linearProgressIndicatorSpec.f40779c[0];
            activeIndicator.f40825d = linearProgressIndicatorSpec.f40783g / 2;
        }
    }
}
