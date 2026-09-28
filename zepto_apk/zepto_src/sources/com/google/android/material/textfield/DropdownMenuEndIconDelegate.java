package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.motion.MotionUtils;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
class DropdownMenuEndIconDelegate extends EndIconDelegate {

    /* renamed from: e, reason: collision with root package name */
    public final int f41274e;

    /* renamed from: f, reason: collision with root package name */
    public final int f41275f;

    /* renamed from: g, reason: collision with root package name */
    public final TimeInterpolator f41276g;

    /* renamed from: h, reason: collision with root package name */
    public AutoCompleteTextView f41277h;

    /* renamed from: i, reason: collision with root package name */
    public final a f41278i;

    /* renamed from: j, reason: collision with root package name */
    public final b f41279j;

    /* renamed from: k, reason: collision with root package name */
    public final g f41280k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f41281l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f41282m;
    public boolean n;
    public long o;
    public AccessibilityManager p;
    public ValueAnimator q;
    public ValueAnimator r;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.material.textfield.g] */
    public DropdownMenuEndIconDelegate(EndCompoundLayout endCompoundLayout) {
        super(endCompoundLayout);
        this.f41278i = new a(this, 1);
        this.f41279j = new b(this, 1);
        this.f41280k = new AccessibilityManagerCompat.TouchExplorationStateChangeListener() { // from class: com.google.android.material.textfield.g
            @Override // androidx.core.view.accessibility.AccessibilityManagerCompat.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z) {
                DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = this.f41385a;
                AutoCompleteTextView autoCompleteTextView = dropdownMenuEndIconDelegate.f41277h;
                if (autoCompleteTextView == null || EditTextUtils.a(autoCompleteTextView)) {
                    return;
                }
                int i2 = z ? 2 : 1;
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                dropdownMenuEndIconDelegate.f41307d.setImportantForAccessibility(i2);
            }
        };
        this.o = Long.MAX_VALUE;
        this.f41275f = MotionUtils.c(endCompoundLayout.getContext(), R.attr.motionDurationShort3, 67);
        this.f41274e = MotionUtils.c(endCompoundLayout.getContext(), R.attr.motionDurationShort3, 50);
        this.f41276g = MotionUtils.d(endCompoundLayout.getContext(), R.attr.motionEasingLinearInterpolator, AnimationUtils.f39816a);
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void a() {
        if (this.p.isTouchExplorationEnabled() && EditTextUtils.a(this.f41277h) && !this.f41307d.hasFocus()) {
            this.f41277h.dismissDropDown();
        }
        this.f41277h.post(new d(this, 1));
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final int c() {
        return R.string.exposed_dropdown_menu_content_description;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final int d() {
        return R.drawable.mtrl_dropdown_arrow;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final View.OnFocusChangeListener e() {
        return this.f41279j;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final View.OnClickListener f() {
        return this.f41278i;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final AccessibilityManagerCompat.TouchExplorationStateChangeListener h() {
        return this.f41280k;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final boolean i(int i2) {
        return i2 != 0;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final boolean j() {
        return this.f41281l;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final boolean l() {
        return this.n;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void m(EditText editText) {
        if (!(editText instanceof AutoCompleteTextView)) {
            throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
        }
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
        this.f41277h = autoCompleteTextView;
        autoCompleteTextView.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.material.textfield.e
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = this.f41383a;
                dropdownMenuEndIconDelegate.getClass();
                if (motionEvent.getAction() == 1) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - dropdownMenuEndIconDelegate.o;
                    if (jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300) {
                        dropdownMenuEndIconDelegate.f41282m = false;
                    }
                    dropdownMenuEndIconDelegate.u();
                    dropdownMenuEndIconDelegate.f41282m = true;
                    dropdownMenuEndIconDelegate.o = System.currentTimeMillis();
                }
                return false;
            }
        });
        this.f41277h.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: com.google.android.material.textfield.f
            @Override // android.widget.AutoCompleteTextView.OnDismissListener
            public final void onDismiss() {
                DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = this.f41384a;
                dropdownMenuEndIconDelegate.f41282m = true;
                dropdownMenuEndIconDelegate.o = System.currentTimeMillis();
                dropdownMenuEndIconDelegate.t(false);
            }
        });
        this.f41277h.setThreshold(0);
        TextInputLayout textInputLayout = this.f41304a;
        textInputLayout.setErrorIconDrawable((Drawable) null);
        if (!EditTextUtils.a(editText) && this.p.isTouchExplorationEnabled()) {
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            this.f41307d.setImportantForAccessibility(2);
        }
        textInputLayout.setEndIconVisible(true);
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void n(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (!EditTextUtils.a(this.f41277h)) {
            accessibilityNodeInfoCompat.m(Spinner.class.getName());
        }
        if (Build.VERSION.SDK_INT >= 26 ? accessibilityNodeInfoCompat.f3185a.isShowingHintText() : accessibilityNodeInfoCompat.f(4)) {
            accessibilityNodeInfoCompat.s(null);
        }
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void o(AccessibilityEvent accessibilityEvent) {
        if (!this.p.isEnabled() || EditTextUtils.a(this.f41277h)) {
            return;
        }
        boolean z = (accessibilityEvent.getEventType() == 32768 || accessibilityEvent.getEventType() == 8) && this.n && !this.f41277h.isPopupShowing();
        if (accessibilityEvent.getEventType() == 1 || z) {
            u();
            this.f41282m = true;
            this.o = System.currentTimeMillis();
        }
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void r() {
        int i2 = 2;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.f41276g;
        valueAnimatorOfFloat.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat.setDuration(this.f41275f);
        valueAnimatorOfFloat.addUpdateListener(new c(this, i2));
        this.r = valueAnimatorOfFloat;
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat2.setDuration(this.f41274e);
        valueAnimatorOfFloat2.addUpdateListener(new c(this, i2));
        this.q = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = DropdownMenuEndIconDelegate.this;
                dropdownMenuEndIconDelegate.q();
                dropdownMenuEndIconDelegate.r.start();
            }
        });
        this.p = (AccessibilityManager) this.f41306c.getSystemService("accessibility");
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void s() {
        AutoCompleteTextView autoCompleteTextView = this.f41277h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            this.f41277h.setOnDismissListener(null);
        }
    }

    public final void t(boolean z) {
        if (this.n != z) {
            this.n = z;
            this.r.cancel();
            this.q.start();
        }
    }

    public final void u() {
        if (this.f41277h == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.o;
        if (jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300) {
            this.f41282m = false;
        }
        if (this.f41282m) {
            this.f41282m = false;
            return;
        }
        t(!this.n);
        if (!this.n) {
            this.f41277h.dismissDropDown();
        } else {
            this.f41277h.requestFocus();
            this.f41277h.showDropDown();
        }
    }
}
