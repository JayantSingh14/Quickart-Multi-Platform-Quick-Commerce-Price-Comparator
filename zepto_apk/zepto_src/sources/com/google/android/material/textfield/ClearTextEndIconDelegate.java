package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.motion.MotionUtils;

/* loaded from: classes4.dex */
class ClearTextEndIconDelegate extends EndIconDelegate {

    /* renamed from: e, reason: collision with root package name */
    public final int f41263e;

    /* renamed from: f, reason: collision with root package name */
    public final int f41264f;

    /* renamed from: g, reason: collision with root package name */
    public final TimeInterpolator f41265g;

    /* renamed from: h, reason: collision with root package name */
    public final TimeInterpolator f41266h;

    /* renamed from: i, reason: collision with root package name */
    public EditText f41267i;

    /* renamed from: j, reason: collision with root package name */
    public final a f41268j;

    /* renamed from: k, reason: collision with root package name */
    public final b f41269k;

    /* renamed from: l, reason: collision with root package name */
    public AnimatorSet f41270l;

    /* renamed from: m, reason: collision with root package name */
    public ValueAnimator f41271m;

    public ClearTextEndIconDelegate(EndCompoundLayout endCompoundLayout) {
        super(endCompoundLayout);
        this.f41268j = new a(this, 0);
        this.f41269k = new b(this, 0);
        this.f41263e = MotionUtils.c(endCompoundLayout.getContext(), R.attr.motionDurationShort3, 100);
        this.f41264f = MotionUtils.c(endCompoundLayout.getContext(), R.attr.motionDurationShort3, 150);
        this.f41265g = MotionUtils.d(endCompoundLayout.getContext(), R.attr.motionEasingLinearInterpolator, AnimationUtils.f39816a);
        this.f41266h = MotionUtils.d(endCompoundLayout.getContext(), R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.f39819d);
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void a() {
        if (this.f41305b.p != null) {
            return;
        }
        t(u());
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final int c() {
        return R.string.clear_text_end_icon_content_description;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final int d() {
        return R.drawable.mtrl_ic_cancel;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final View.OnFocusChangeListener e() {
        return this.f41269k;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final View.OnClickListener f() {
        return this.f41268j;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final View.OnFocusChangeListener g() {
        return this.f41269k;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void m(EditText editText) {
        this.f41267i = editText;
        this.f41304a.setEndIconVisible(u());
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void p(boolean z) {
        if (this.f41305b.p == null) {
            return;
        }
        t(z);
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void r() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(this.f41266h);
        valueAnimatorOfFloat.setDuration(this.f41264f);
        valueAnimatorOfFloat.addUpdateListener(new c(this, 1));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.f41265g;
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        int i2 = this.f41263e;
        valueAnimatorOfFloat2.setDuration(i2);
        valueAnimatorOfFloat2.addUpdateListener(new c(this, 0));
        AnimatorSet animatorSet = new AnimatorSet();
        this.f41270l = animatorSet;
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        this.f41270l.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) throws Resources.NotFoundException {
                ClearTextEndIconDelegate.this.f41305b.h(true);
            }
        });
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat3.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat3.setDuration(i2);
        valueAnimatorOfFloat3.addUpdateListener(new c(this, 0));
        this.f41271m = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) throws Resources.NotFoundException {
                ClearTextEndIconDelegate.this.f41305b.h(false);
            }
        });
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void s() {
        EditText editText = this.f41267i;
        if (editText != null) {
            editText.post(new d(this, 0));
        }
    }

    public final void t(boolean z) {
        boolean z2 = this.f41305b.d() == z;
        if (z && !this.f41270l.isRunning()) {
            this.f41271m.cancel();
            this.f41270l.start();
            if (z2) {
                this.f41270l.end();
                return;
            }
            return;
        }
        if (z) {
            return;
        }
        this.f41270l.cancel();
        this.f41271m.start();
        if (z2) {
            this.f41271m.end();
        }
    }

    public final boolean u() {
        EditText editText = this.f41267i;
        if (editText != null) {
            return (editText.hasFocus() || this.f41307d.hasFocus()) && this.f41267i.getText().length() > 0;
        }
        return false;
    }
}
