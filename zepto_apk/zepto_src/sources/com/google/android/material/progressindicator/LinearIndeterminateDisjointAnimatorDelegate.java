package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.math.MathUtils;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.R;
import com.google.android.material.progressindicator.DrawingDelegate;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
final class LinearIndeterminateDisjointAnimatorDelegate extends IndeterminateAnimatorDelegate<ObjectAnimator> {

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f40843k = {533, 567, 850, 750};

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f40844l = {1267, 1000, 333, 0};

    /* renamed from: m, reason: collision with root package name */
    public static final Property f40845m = new AnonymousClass3(Float.class, "animationFraction");

    /* renamed from: c, reason: collision with root package name */
    public ObjectAnimator f40846c;

    /* renamed from: d, reason: collision with root package name */
    public ObjectAnimator f40847d;

    /* renamed from: e, reason: collision with root package name */
    public final Interpolator[] f40848e;

    /* renamed from: f, reason: collision with root package name */
    public final LinearProgressIndicatorSpec f40849f;

    /* renamed from: g, reason: collision with root package name */
    public int f40850g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f40851h;

    /* renamed from: i, reason: collision with root package name */
    public float f40852i;

    /* renamed from: j, reason: collision with root package name */
    public Animatable2Compat.AnimationCallback f40853j;

    /* renamed from: com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate$3, reason: invalid class name */
    public class AnonymousClass3 extends Property<LinearIndeterminateDisjointAnimatorDelegate, Float> {
        @Override // android.util.Property
        public final Float get(LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate) {
            return Float.valueOf(linearIndeterminateDisjointAnimatorDelegate.f40852i);
        }

        @Override // android.util.Property
        public final void set(LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate, Float f2) {
            ArrayList arrayList;
            LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate2 = linearIndeterminateDisjointAnimatorDelegate;
            float fFloatValue = f2.floatValue();
            linearIndeterminateDisjointAnimatorDelegate2.f40852i = fFloatValue;
            int i2 = (int) (fFloatValue * 1800.0f);
            int i3 = 0;
            while (true) {
                arrayList = linearIndeterminateDisjointAnimatorDelegate2.f40827b;
                if (i3 >= arrayList.size()) {
                    break;
                }
                DrawingDelegate.ActiveIndicator activeIndicator = (DrawingDelegate.ActiveIndicator) arrayList.get(i3);
                int[] iArr = LinearIndeterminateDisjointAnimatorDelegate.f40844l;
                int i4 = i3 * 2;
                int i5 = iArr[i4];
                int[] iArr2 = LinearIndeterminateDisjointAnimatorDelegate.f40843k;
                float fB = IndeterminateAnimatorDelegate.b(i2, i5, iArr2[i4]);
                Interpolator[] interpolatorArr = linearIndeterminateDisjointAnimatorDelegate2.f40848e;
                activeIndicator.f40822a = MathUtils.a(interpolatorArr[i4].getInterpolation(fB), 0.0f, 1.0f);
                int i6 = i4 + 1;
                activeIndicator.f40823b = MathUtils.a(interpolatorArr[i6].getInterpolation(IndeterminateAnimatorDelegate.b(i2, iArr[i6], iArr2[i6])), 0.0f, 1.0f);
                i3++;
            }
            if (linearIndeterminateDisjointAnimatorDelegate2.f40851h) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((DrawingDelegate.ActiveIndicator) it.next()).f40824c = linearIndeterminateDisjointAnimatorDelegate2.f40849f.f40779c[linearIndeterminateDisjointAnimatorDelegate2.f40850g];
                }
                linearIndeterminateDisjointAnimatorDelegate2.f40851h = false;
            }
            linearIndeterminateDisjointAnimatorDelegate2.f40826a.invalidateSelf();
        }
    }

    public LinearIndeterminateDisjointAnimatorDelegate(Context context, LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(2);
        this.f40850g = 0;
        this.f40853j = null;
        this.f40849f = linearProgressIndicatorSpec;
        this.f40848e = new Interpolator[]{AnimationUtils.loadInterpolator(context, R.anim.linear_indeterminate_line1_head_interpolator), AnimationUtils.loadInterpolator(context, R.anim.linear_indeterminate_line1_tail_interpolator), AnimationUtils.loadInterpolator(context, R.anim.linear_indeterminate_line2_head_interpolator), AnimationUtils.loadInterpolator(context, R.anim.linear_indeterminate_line2_tail_interpolator)};
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public final void a() {
        ObjectAnimator objectAnimator = this.f40846c;
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
        this.f40853j = animationCallback;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public final void e() {
        ObjectAnimator objectAnimator = this.f40847d;
        if (objectAnimator == null || objectAnimator.isRunning()) {
            return;
        }
        a();
        if (this.f40826a.isVisible()) {
            this.f40847d.setFloatValues(this.f40852i, 1.0f);
            this.f40847d.setDuration((long) ((1.0f - this.f40852i) * 1800.0f));
            this.f40847d.start();
        }
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public final void f() {
        ObjectAnimator objectAnimator = this.f40846c;
        Property property = f40845m;
        if (objectAnimator == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<LinearIndeterminateDisjointAnimatorDelegate, Float>) property, 0.0f, 1.0f);
            this.f40846c = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(1800L);
            this.f40846c.setInterpolator(null);
            this.f40846c.setRepeatCount(-1);
            this.f40846c.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationRepeat(Animator animator) {
                    super.onAnimationRepeat(animator);
                    LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate = LinearIndeterminateDisjointAnimatorDelegate.this;
                    linearIndeterminateDisjointAnimatorDelegate.f40850g = (linearIndeterminateDisjointAnimatorDelegate.f40850g + 1) % linearIndeterminateDisjointAnimatorDelegate.f40849f.f40779c.length;
                    linearIndeterminateDisjointAnimatorDelegate.f40851h = true;
                }
            });
        }
        if (this.f40847d == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, (Property<LinearIndeterminateDisjointAnimatorDelegate, Float>) property, 1.0f);
            this.f40847d = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(1800L);
            this.f40847d.setInterpolator(null);
            this.f40847d.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate = LinearIndeterminateDisjointAnimatorDelegate.this;
                    linearIndeterminateDisjointAnimatorDelegate.a();
                    Animatable2Compat.AnimationCallback animationCallback = linearIndeterminateDisjointAnimatorDelegate.f40853j;
                    if (animationCallback != null) {
                        animationCallback.a(linearIndeterminateDisjointAnimatorDelegate.f40826a);
                    }
                }
            });
        }
        h();
        this.f40846c.start();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public final void g() {
        this.f40853j = null;
    }

    public final void h() {
        this.f40850g = 0;
        Iterator it = this.f40827b.iterator();
        while (it.hasNext()) {
            ((DrawingDelegate.ActiveIndicator) it.next()).f40824c = this.f40849f.f40779c[0];
        }
    }
}
