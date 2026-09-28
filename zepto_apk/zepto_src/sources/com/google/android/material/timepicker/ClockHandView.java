package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.math.MathUtils;
import com.google.android.material.motion.MotionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
class ClockHandView extends View {
    public static final /* synthetic */ int v = 0;

    /* renamed from: a, reason: collision with root package name */
    public final int f41398a;

    /* renamed from: b, reason: collision with root package name */
    public final TimeInterpolator f41399b;

    /* renamed from: c, reason: collision with root package name */
    public final ValueAnimator f41400c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f41401d;

    /* renamed from: e, reason: collision with root package name */
    public float f41402e;

    /* renamed from: f, reason: collision with root package name */
    public float f41403f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f41404g;

    /* renamed from: h, reason: collision with root package name */
    public final int f41405h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f41406i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f41407j;

    /* renamed from: k, reason: collision with root package name */
    public final int f41408k;

    /* renamed from: l, reason: collision with root package name */
    public final float f41409l;

    /* renamed from: m, reason: collision with root package name */
    public final Paint f41410m;
    public final RectF n;
    public final int o;
    public float p;
    public boolean q;
    public OnActionUpListener r;
    public double s;
    public int t;
    public int u;

    /* renamed from: com.google.android.material.timepicker.ClockHandView$1, reason: invalid class name */
    class AnonymousClass1 extends AnimatorListenerAdapter {
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    public interface OnActionUpListener {
    }

    public interface OnRotateListener {
        void b(float f2, boolean z);
    }

    public ClockHandView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialClockStyle);
    }

    public final int a(float f2, float f3) {
        int degrees = (int) Math.toDegrees(Math.atan2(f3 - (getHeight() / 2), f2 - (getWidth() / 2)));
        int i2 = degrees + 90;
        return i2 < 0 ? degrees + 450 : i2;
    }

    public final int b(int i2) {
        return i2 == 2 ? Math.round(this.t * 0.66f) : this.t;
    }

    public final void c(float f2, boolean z) {
        ValueAnimator valueAnimator = this.f41400c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z) {
            d(f2, false);
            return;
        }
        float f3 = this.p;
        if (Math.abs(f3 - f2) > 180.0f) {
            if (f3 > 180.0f && f2 < 180.0f) {
                f2 += 360.0f;
            }
            if (f3 < 180.0f && f2 > 180.0f) {
                f3 += 360.0f;
            }
        }
        Pair pair = new Pair(Float.valueOf(f3), Float.valueOf(f2));
        valueAnimator.setFloatValues(((Float) pair.first).floatValue(), ((Float) pair.second).floatValue());
        valueAnimator.setDuration(this.f41398a);
        valueAnimator.setInterpolator(this.f41399b);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.timepicker.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                int i2 = ClockHandView.v;
                ClockHandView clockHandView = this.f41453a;
                clockHandView.getClass();
                clockHandView.d(((Float) valueAnimator2.getAnimatedValue()).floatValue(), true);
            }
        });
        valueAnimator.addListener(new AnonymousClass1());
        valueAnimator.start();
    }

    public final void d(float f2, boolean z) {
        float f3 = f2 % 360.0f;
        this.p = f3;
        this.s = Math.toRadians(f3 - 90.0f);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float fB = b(this.u);
        float fCos = (((float) Math.cos(this.s)) * fB) + width;
        float fSin = (fB * ((float) Math.sin(this.s))) + height;
        float f4 = this.f41408k;
        this.n.set(fCos - f4, fSin - f4, fCos + f4, fSin + f4);
        Iterator it = this.f41407j.iterator();
        while (it.hasNext()) {
            ((OnRotateListener) it.next()).b(f3, z);
        }
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f2 = width;
        float fB = b(this.u);
        float fCos = (((float) Math.cos(this.s)) * fB) + f2;
        float f3 = height;
        float fSin = (fB * ((float) Math.sin(this.s))) + f3;
        Paint paint = this.f41410m;
        paint.setStrokeWidth(0.0f);
        canvas.drawCircle(fCos, fSin, this.f41408k, paint);
        double dSin = Math.sin(this.s);
        paint.setStrokeWidth(this.o);
        canvas.drawLine(f2, f3, width + ((int) (Math.cos(this.s) * d)), height + ((int) (d * dSin)), paint);
        canvas.drawCircle(f2, f3, this.f41409l, paint);
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.f41400c.isRunning()) {
            return;
        }
        c(this.p, false);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        OnActionUpListener onActionUpListener;
        int actionMasked = motionEvent.getActionMasked();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 2) {
                int i2 = (int) (x - this.f41402e);
                int i3 = (int) (y - this.f41403f);
                this.f41404g = (i3 * i3) + (i2 * i2) > this.f41405h;
                z2 = this.q;
                z = actionMasked == 1;
                if (this.f41406i) {
                    this.u = MathUtils.a((float) (getWidth() / 2), (float) (getHeight() / 2), x, y) > ((float) b(2)) + ViewUtils.d(12, getContext()) ? 1 : 2;
                }
                z3 = false;
            } else {
                z = false;
                z3 = false;
                z2 = false;
            }
        } else {
            this.f41402e = x;
            this.f41403f = y;
            this.f41404g = true;
            this.q = false;
            z = false;
            z2 = false;
            z3 = true;
        }
        boolean z5 = this.q;
        float fA = a(x, y);
        boolean z6 = this.p != fA;
        if (z3 && z6) {
            z4 = true;
        } else if (z6 || z2) {
            c(fA, z && this.f41401d);
            z4 = true;
        } else {
            z4 = false;
        }
        boolean z7 = z4 | z5;
        this.q = z7;
        if (z7 && z && (onActionUpListener = this.r) != null) {
            float fA2 = a(x, y);
            boolean z8 = this.f41404g;
            TimePickerClockPresenter timePickerClockPresenter = (TimePickerClockPresenter) onActionUpListener;
            timePickerClockPresenter.f41429e = true;
            TimeModel timeModel = timePickerClockPresenter.f41426b;
            int i4 = timeModel.f41419e;
            int i5 = timeModel.f41418d;
            int i6 = timeModel.f41420f;
            TimePickerView timePickerView = timePickerClockPresenter.f41425a;
            if (i6 == 10) {
                timePickerView.s.c(timePickerClockPresenter.f41428d, false);
                AccessibilityManager accessibilityManager = (AccessibilityManager) timePickerView.getContext().getSystemService(AccessibilityManager.class);
                if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
                    timePickerClockPresenter.d(12, true);
                }
            } else {
                int iRound = Math.round(fA2);
                if (!z8) {
                    timeModel.f41419e = (((iRound + 15) / 30) * 5) % 60;
                    timePickerClockPresenter.f41427c = r12 * 6;
                }
                timePickerView.s.c(timePickerClockPresenter.f41427c, z8);
            }
            timePickerClockPresenter.f41429e = false;
            timePickerClockPresenter.e();
            if (timeModel.f41419e != i4 || timeModel.f41418d != i5) {
                timePickerView.performHapticFeedback(4);
            }
        }
        return true;
    }

    public ClockHandView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f41400c = new ValueAnimator();
        this.f41407j = new ArrayList();
        Paint paint = new Paint();
        this.f41410m = paint;
        this.n = new RectF();
        this.u = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClockHandView, i2, R.style.Widget_MaterialComponents_TimePicker_Clock);
        this.f41398a = MotionUtils.c(context, R.attr.motionDurationLong2, 200);
        this.f41399b = MotionUtils.d(context, R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.f39817b);
        this.t = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ClockHandView_materialCircleRadius, 0);
        this.f41408k = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ClockHandView_selectorSize, 0);
        this.o = getResources().getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.f41409l = r7.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.ClockHandView_clockHandColor, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        c(0.0f, false);
        this.f41405h = ViewConfiguration.get(context).getScaledTouchSlop();
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        setImportantForAccessibility(2);
        typedArrayObtainStyledAttributes.recycle();
    }
}
