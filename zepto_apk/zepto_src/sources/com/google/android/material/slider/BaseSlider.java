package com.google.android.material.slider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.gms.common.api.Api;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewOverlayImpl;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.slider.BaseOnChangeListener;
import com.google.android.material.slider.BaseOnSliderTouchListener;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.google.android.material.tooltip.TooltipDrawable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.WeakHashMap;
import org.xbill.DNS.KEYRecord;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends BaseOnChangeListener<S>, T extends BaseOnSliderTouchListener<S>> extends View {
    public static final int e1 = R.style.Widget_MaterialComponents_Slider;
    public static final int f1 = R.attr.motionDurationMedium4;
    public static final int g1 = R.attr.motionDurationShort3;
    public static final int h1 = R.attr.motionEasingEmphasizedInterpolator;
    public static final int i1 = R.attr.motionEasingEmphasizedAccelerateInterpolator;
    public int A;
    public MotionEvent A0;
    public int B;
    public LabelFormatter B0;
    public int C;
    public boolean C0;
    public int D;
    public float D0;
    public int E;
    public float E0;
    public int F;
    public ArrayList F0;
    public int G;
    public int G0;
    public int H;
    public int H0;
    public int I;
    public float I0;
    public int J;
    public float[] J0;
    public int K;
    public boolean K0;
    public int L;
    public int L0;
    public final int M;
    public int M0;
    public int N0;
    public boolean O0;
    public boolean P0;
    public float Q;
    public ColorStateList Q0;
    public ColorStateList R0;
    public ColorStateList S0;
    public ColorStateList T0;
    public ColorStateList U0;
    public final Path V0;
    public final RectF W0;
    public final RectF X0;
    public final MaterialShapeDrawable Y0;
    public Drawable Z0;

    /* renamed from: a, reason: collision with root package name */
    public final Paint f41126a;
    public List a1;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f41127b;
    public float b1;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f41128c;
    public int c1;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f41129d;
    public final a d1;

    /* renamed from: e, reason: collision with root package name */
    public final Paint f41130e;

    /* renamed from: f, reason: collision with root package name */
    public final Paint f41131f;

    /* renamed from: g, reason: collision with root package name */
    public final Paint f41132g;

    /* renamed from: h, reason: collision with root package name */
    public final AccessibilityHelper f41133h;

    /* renamed from: i, reason: collision with root package name */
    public final AccessibilityManager f41134i;

    /* renamed from: j, reason: collision with root package name */
    public AccessibilityEventSender f41135j;

    /* renamed from: k, reason: collision with root package name */
    public final int f41136k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f41137l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f41138m;
    public final ArrayList n;
    public boolean o;
    public ValueAnimator p;
    public ValueAnimator q;
    public final int r;
    public final int s;
    public final int t;
    public final int u;
    public final int v;
    public final int w;
    public final int x;
    public final int y;
    public final int z;

    /* renamed from: com.google.android.material.slider.BaseSlider$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f41141a;

        static {
            int[] iArr = new int[FullCornerDirection.values().length];
            f41141a = iArr;
            try {
                iArr[3] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41141a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41141a[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41141a[0] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public class AccessibilityEventSender implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public int f41142a = -1;

        public AccessibilityEventSender() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            BaseSlider.this.f41133h.o(this.f41142a, 4);
        }
    }

    public static class AccessibilityHelper extends ExploreByTouchHelper {
        public final BaseSlider n;
        public final Rect o;

        public AccessibilityHelper(BaseSlider baseSlider) {
            super(baseSlider);
            this.o = new Rect();
            this.n = baseSlider;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public final int e(float f2, float f3) {
            int i2 = 0;
            while (true) {
                BaseSlider baseSlider = this.n;
                if (i2 >= baseSlider.getValues().size()) {
                    return -1;
                }
                Rect rect = this.o;
                baseSlider.w(i2, rect);
                if (rect.contains((int) f2, (int) f3)) {
                    return i2;
                }
                i2++;
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public final void f(ArrayList arrayList) {
            for (int i2 = 0; i2 < this.n.getValues().size(); i2++) {
                arrayList.add(Integer.valueOf(i2));
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public final boolean j(int i2, int i3, Bundle bundle) {
            BaseSlider baseSlider = this.n;
            if (!baseSlider.isEnabled()) {
                return false;
            }
            if (i3 != 4096 && i3 != 8192) {
                if (i3 != 16908349 || bundle == null || !bundle.containsKey("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE")) {
                    return false;
                }
                float f2 = bundle.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE");
                int i4 = BaseSlider.e1;
                if (!baseSlider.u(f2, i2)) {
                    return false;
                }
                baseSlider.x();
                baseSlider.postInvalidate();
                g(i2);
                return true;
            }
            int i5 = BaseSlider.e1;
            float fRound = baseSlider.I0;
            if (fRound == 0.0f) {
                fRound = 1.0f;
            }
            if ((baseSlider.E0 - baseSlider.D0) / fRound > 20) {
                fRound *= Math.round(r1 / r4);
            }
            if (i3 == 8192) {
                fRound = -fRound;
            }
            if (baseSlider.l()) {
                fRound = -fRound;
            }
            if (!baseSlider.u(MathUtils.a(baseSlider.getValues().get(i2).floatValue() + fRound, baseSlider.getValueFrom(), baseSlider.getValueTo()), i2)) {
                return false;
            }
            baseSlider.x();
            baseSlider.postInvalidate();
            g(i2);
            return true;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public final void l(int i2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.p);
            BaseSlider baseSlider = this.n;
            List<Float> values = baseSlider.getValues();
            float fFloatValue = values.get(i2).floatValue();
            float valueFrom = baseSlider.getValueFrom();
            float valueTo = baseSlider.getValueTo();
            if (baseSlider.isEnabled()) {
                if (fFloatValue > valueFrom) {
                    accessibilityNodeInfoCompat.a(KEYRecord.Flags.FLAG2);
                }
                if (fFloatValue < valueTo) {
                    accessibilityNodeInfoCompat.a(4096);
                }
            }
            accessibilityNodeInfoCompat.f3185a.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.d(valueFrom, valueTo, fFloatValue, 1).f3202a);
            accessibilityNodeInfoCompat.m(SeekBar.class.getName());
            StringBuilder sb = new StringBuilder();
            if (baseSlider.getContentDescription() != null) {
                sb.append(baseSlider.getContentDescription());
                sb.append(",");
            }
            String strG = baseSlider.g(fFloatValue);
            String string = baseSlider.getContext().getString(R.string.material_slider_value);
            if (values.size() > 1) {
                string = i2 == baseSlider.getValues().size() - 1 ? baseSlider.getContext().getString(R.string.material_slider_range_end) : i2 == 0 ? baseSlider.getContext().getString(R.string.material_slider_range_start) : "";
            }
            Locale locale = Locale.US;
            sb.append(string + ", " + strG);
            accessibilityNodeInfoCompat.q(sb.toString());
            Rect rect = this.o;
            baseSlider.w(i2, rect);
            accessibilityNodeInfoCompat.l(rect);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class FullCornerDirection {

        /* renamed from: a, reason: collision with root package name */
        public static final FullCornerDirection f41144a;

        /* renamed from: b, reason: collision with root package name */
        public static final FullCornerDirection f41145b;

        /* renamed from: c, reason: collision with root package name */
        public static final FullCornerDirection f41146c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ FullCornerDirection[] f41147d;

        /* JADX INFO: Fake field, exist only in values array */
        FullCornerDirection EF0;

        static {
            FullCornerDirection fullCornerDirection = new FullCornerDirection("BOTH", 0);
            FullCornerDirection fullCornerDirection2 = new FullCornerDirection("LEFT", 1);
            f41144a = fullCornerDirection2;
            FullCornerDirection fullCornerDirection3 = new FullCornerDirection("RIGHT", 2);
            f41145b = fullCornerDirection3;
            FullCornerDirection fullCornerDirection4 = new FullCornerDirection("NONE", 3);
            f41146c = fullCornerDirection4;
            f41147d = new FullCornerDirection[]{fullCornerDirection, fullCornerDirection2, fullCornerDirection3, fullCornerDirection4};
        }

        public static FullCornerDirection valueOf(String str) {
            return (FullCornerDirection) Enum.valueOf(FullCornerDirection.class, str);
        }

        public static FullCornerDirection[] values() {
            return (FullCornerDirection[]) f41147d.clone();
        }
    }

    public static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new AnonymousClass1();

        /* renamed from: a, reason: collision with root package name */
        public float f41148a;

        /* renamed from: b, reason: collision with root package name */
        public float f41149b;

        /* renamed from: c, reason: collision with root package name */
        public ArrayList f41150c;

        /* renamed from: d, reason: collision with root package name */
        public float f41151d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f41152e;

        /* renamed from: com.google.android.material.slider.BaseSlider$SliderState$1, reason: invalid class name */
        public class AnonymousClass1 implements Parcelable.Creator<SliderState> {
            @Override // android.os.Parcelable.Creator
            public final SliderState createFromParcel(Parcel parcel) {
                SliderState sliderState = new SliderState(parcel);
                sliderState.f41148a = parcel.readFloat();
                sliderState.f41149b = parcel.readFloat();
                ArrayList arrayList = new ArrayList();
                sliderState.f41150c = arrayList;
                parcel.readList(arrayList, Float.class.getClassLoader());
                sliderState.f41151d = parcel.readFloat();
                sliderState.f41152e = parcel.createBooleanArray()[0];
                return sliderState;
            }

            @Override // android.os.Parcelable.Creator
            public final SliderState[] newArray(int i2) {
                return new SliderState[i2];
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeFloat(this.f41148a);
            parcel.writeFloat(this.f41149b);
            parcel.writeList(this.f41150c);
            parcel.writeFloat(this.f41151d);
            parcel.writeBooleanArray(new boolean[]{this.f41152e});
        }
    }

    public BaseSlider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.sliderStyle);
    }

    public final void A() {
        boolean z;
        int iMax = Math.max(this.z, Math.max(this.C + getPaddingBottom() + getPaddingTop(), getPaddingBottom() + getPaddingTop() + this.F));
        boolean z2 = false;
        if (iMax == this.A) {
            z = false;
        } else {
            this.A = iMax;
            z = true;
        }
        int iMax2 = Math.max(Math.max(Math.max((this.E / 2) - this.t, 0), Math.max((this.C - this.u) / 2, 0)), Math.max(Math.max(this.L0 - this.v, 0), Math.max(this.M0 - this.w, 0))) + this.s;
        if (this.D != iMax2) {
            this.D = iMax2;
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            if (isLaidOut()) {
                this.N0 = Math.max(getWidth() - (this.D * 2), 0);
                m();
            }
            z2 = true;
        }
        if (z) {
            requestLayout();
        } else if (z2) {
            postInvalidate();
        }
    }

    public final void B() {
        if (this.P0) {
            float f2 = this.D0;
            float f3 = this.E0;
            if (f2 >= f3) {
                throw new IllegalStateException("valueFrom(" + this.D0 + ") must be smaller than valueTo(" + this.E0 + ")");
            }
            if (f3 <= f2) {
                throw new IllegalStateException("valueTo(" + this.E0 + ") must be greater than valueFrom(" + this.D0 + ")");
            }
            if (this.I0 > 0.0f && !C(f3)) {
                throw new IllegalStateException("The stepSize(" + this.I0 + ") must be 0, or a factor of the valueFrom(" + this.D0 + ")-valueTo(" + this.E0 + ") range");
            }
            Iterator it = this.F0.iterator();
            while (it.hasNext()) {
                Float f4 = (Float) it.next();
                if (f4.floatValue() < this.D0 || f4.floatValue() > this.E0) {
                    throw new IllegalStateException("Slider value(" + f4 + ") must be greater or equal to valueFrom(" + this.D0 + "), and lower or equal to valueTo(" + this.E0 + ")");
                }
                if (this.I0 > 0.0f && !C(f4.floatValue())) {
                    float f5 = this.D0;
                    float f6 = this.I0;
                    throw new IllegalStateException("Value(" + f4 + ") must be equal to valueFrom(" + f5 + ") plus a multiple of stepSize(" + f6 + ") when using stepSize(" + f6 + ")");
                }
            }
            float minSeparation = getMinSeparation();
            if (minSeparation < 0.0f) {
                throw new IllegalStateException("minSeparation(" + minSeparation + ") must be greater or equal to 0");
            }
            float f7 = this.I0;
            if (f7 > 0.0f && minSeparation > 0.0f) {
                if (this.c1 != 1) {
                    throw new IllegalStateException("minSeparation(" + minSeparation + ") cannot be set as a dimension when using stepSize(" + this.I0 + ")");
                }
                if (minSeparation < f7 || !j(minSeparation)) {
                    float f8 = this.I0;
                    throw new IllegalStateException("minSeparation(" + minSeparation + ") must be greater or equal and a multiple of stepSize(" + f8 + ") when using stepSize(" + f8 + ")");
                }
            }
            float f9 = this.I0;
            if (f9 != 0.0f) {
                if (((int) f9) != f9) {
                    Log.w("BaseSlider", "Floating point value used for stepSize(" + f9 + "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.");
                }
                float f10 = this.D0;
                if (((int) f10) != f10) {
                    Log.w("BaseSlider", "Floating point value used for valueFrom(" + f10 + "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.");
                }
                float f11 = this.E0;
                if (((int) f11) != f11) {
                    Log.w("BaseSlider", "Floating point value used for valueTo(" + f11 + "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.");
                }
            }
            this.P0 = false;
        }
    }

    public final boolean C(float f2) {
        return j(new BigDecimal(Float.toString(f2)).subtract(new BigDecimal(Float.toString(this.D0)), MathContext.DECIMAL64).doubleValue());
    }

    public final float D(float f2) {
        return (p(f2) * this.N0) + this.D;
    }

    public final void a(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth == -1 && intrinsicHeight == -1) {
            drawable.setBounds(0, 0, this.E, this.F);
        } else {
            float fMax = Math.max(this.E, this.F) / Math.max(intrinsicWidth, intrinsicHeight);
            drawable.setBounds(0, 0, (int) (intrinsicWidth * fMax), (int) (intrinsicHeight * fMax));
        }
    }

    public final int b() {
        int i2 = this.A / 2;
        int i3 = this.B;
        return i2 + ((i3 == 1 || i3 == 3) ? ((TooltipDrawable) this.f41137l.get(0)).getIntrinsicHeight() : 0);
    }

    public final ValueAnimator c(boolean z) {
        int iC;
        TimeInterpolator timeInterpolatorD;
        float fFloatValue = z ? 0.0f : 1.0f;
        ValueAnimator valueAnimator = z ? this.q : this.p;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fFloatValue, z ? 1.0f : 0.0f);
        if (z) {
            iC = MotionUtils.c(getContext(), f1, 83);
            timeInterpolatorD = MotionUtils.d(getContext(), h1, AnimationUtils.f39820e);
        } else {
            iC = MotionUtils.c(getContext(), g1, WKSRecord.Service.UUCP_PATH);
            timeInterpolatorD = MotionUtils.d(getContext(), i1, AnimationUtils.f39818c);
        }
        valueAnimatorOfFloat.setDuration(iC);
        valueAnimatorOfFloat.setInterpolator(timeInterpolatorD);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.slider.BaseSlider.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                float fFloatValue2 = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                BaseSlider baseSlider = BaseSlider.this;
                Iterator it = baseSlider.f41137l.iterator();
                while (it.hasNext()) {
                    TooltipDrawable tooltipDrawable = (TooltipDrawable) it.next();
                    tooltipDrawable.Q = 1.2f;
                    tooltipDrawable.L = fFloatValue2;
                    tooltipDrawable.M = fFloatValue2;
                    tooltipDrawable.X = AnimationUtils.b(0.0f, 1.0f, 0.19f, 1.0f, fFloatValue2);
                    tooltipDrawable.invalidateSelf();
                }
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                baseSlider.postInvalidateOnAnimation();
            }
        });
        return valueAnimatorOfFloat;
    }

    public final void d(Canvas canvas, int i2, int i3, float f2, Drawable drawable) {
        canvas.save();
        canvas.translate((this.D + ((int) (p(f2) * i2))) - (drawable.getBounds().width() / 2.0f), i3 - (drawable.getBounds().height() / 2.0f));
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return this.f41133h.d(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        this.f41126a.setColor(i(this.U0));
        this.f41127b.setColor(i(this.T0));
        this.f41130e.setColor(i(this.S0));
        this.f41131f.setColor(i(this.R0));
        this.f41132g.setColor(i(this.T0));
        Iterator it = this.f41137l.iterator();
        while (it.hasNext()) {
            TooltipDrawable tooltipDrawable = (TooltipDrawable) it.next();
            if (tooltipDrawable.isStateful()) {
                tooltipDrawable.setState(getDrawableState());
            }
        }
        MaterialShapeDrawable materialShapeDrawable = this.Y0;
        if (materialShapeDrawable.isStateful()) {
            materialShapeDrawable.setState(getDrawableState());
        }
        Paint paint = this.f41129d;
        paint.setColor(i(this.Q0));
        paint.setAlpha(63);
    }

    public final void e() {
        if (!this.o) {
            this.o = true;
            ValueAnimator valueAnimatorC = c(true);
            this.p = valueAnimatorC;
            this.q = null;
            valueAnimatorC.start();
        }
        ArrayList arrayList = this.f41137l;
        Iterator it = arrayList.iterator();
        for (int i2 = 0; i2 < this.F0.size() && it.hasNext(); i2++) {
            if (i2 != this.H0) {
                s((TooltipDrawable) it.next(), ((Float) this.F0.get(i2)).floatValue());
            }
        }
        if (!it.hasNext()) {
            throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", Integer.valueOf(arrayList.size()), Integer.valueOf(this.F0.size())));
        }
        s((TooltipDrawable) it.next(), ((Float) this.F0.get(this.H0)).floatValue());
    }

    public final void f() {
        if (this.o) {
            this.o = false;
            ValueAnimator valueAnimatorC = c(false);
            this.q = valueAnimatorC;
            this.p = null;
            valueAnimatorC.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.slider.BaseSlider.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    BaseSlider baseSlider = BaseSlider.this;
                    ViewOverlayImpl viewOverlayImplF = ViewUtils.f(ViewUtils.e(baseSlider));
                    Iterator it = baseSlider.f41137l.iterator();
                    while (it.hasNext()) {
                        viewOverlayImplF.b((TooltipDrawable) it.next());
                    }
                }
            });
            this.q.start();
        }
    }

    public final String g(float f2) {
        if (this.B0 != null) {
            return this.B0.a(f2);
        }
        return String.format(((float) ((int) f2)) == f2 ? "%.0f" : "%.2f", Float.valueOf(f2));
    }

    @Override // android.view.View
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    @VisibleForTesting
    public final int getAccessibilityFocusedVirtualViewId() {
        return this.f41133h.f3332h;
    }

    public float getMinSeparation() {
        return 0.0f;
    }

    public int getThumbRadius() {
        return this.E / 2;
    }

    public float getValueFrom() {
        return this.D0;
    }

    public float getValueTo() {
        return this.E0;
    }

    @NonNull
    public List<Float> getValues() {
        return new ArrayList(this.F0);
    }

    public final float[] h() {
        float fFloatValue = ((Float) this.F0.get(0)).floatValue();
        float fFloatValue2 = ((Float) b.c(1, this.F0)).floatValue();
        if (this.F0.size() == 1) {
            fFloatValue = this.D0;
        }
        float fP = p(fFloatValue);
        float fP2 = p(fFloatValue2);
        return l() ? new float[]{fP2, fP} : new float[]{fP, fP2};
    }

    public final int i(ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    public final boolean j(double d2) {
        double dDoubleValue = new BigDecimal(Double.toString(d2)).divide(new BigDecimal(Float.toString(this.I0)), MathContext.DECIMAL64).doubleValue();
        return Math.abs(((double) Math.round(dDoubleValue)) - dDoubleValue) < 1.0E-4d;
    }

    public final boolean k(MotionEvent motionEvent) {
        if (motionEvent.getToolType(0) != 3) {
            for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                ViewGroup viewGroup = (ViewGroup) parent;
                if ((viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) && viewGroup.shouldDelayChildPressedState()) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean l() {
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        return getLayoutDirection() == 1;
    }

    public final void m() {
        if (this.I0 <= 0.0f) {
            return;
        }
        B();
        int iMin = Math.min((int) (((this.E0 - this.D0) / this.I0) + 1.0f), (this.N0 / this.x) + 1);
        float[] fArr = this.J0;
        if (fArr == null || fArr.length != iMin * 2) {
            this.J0 = new float[iMin * 2];
        }
        float f2 = this.N0 / (iMin - 1);
        for (int i2 = 0; i2 < iMin * 2; i2 += 2) {
            float[] fArr2 = this.J0;
            fArr2[i2] = ((i2 / 2.0f) * f2) + this.D;
            fArr2[i2 + 1] = b();
        }
    }

    public final boolean n(int i2) {
        int i3 = this.H0;
        long j2 = i3 + i2;
        long size = this.F0.size() - 1;
        if (j2 < 0) {
            j2 = 0;
        } else if (j2 > size) {
            j2 = size;
        }
        int i4 = (int) j2;
        this.H0 = i4;
        if (i4 == i3) {
            return false;
        }
        if (this.G0 != -1) {
            this.G0 = i4;
        }
        x();
        postInvalidate();
        return true;
    }

    public final void o(int i2) {
        if (l()) {
            i2 = i2 == Integer.MIN_VALUE ? Api.BaseClientBuilder.API_PRIORITY_OTHER : -i2;
        }
        n(i2);
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnScrollChangedListener(this.d1);
        Iterator it = this.f41137l.iterator();
        while (it.hasNext()) {
            TooltipDrawable tooltipDrawable = (TooltipDrawable) it.next();
            ViewGroup viewGroupE = ViewUtils.e(this);
            if (viewGroupE == null) {
                tooltipDrawable.getClass();
            } else {
                tooltipDrawable.getClass();
                int[] iArr = new int[2];
                viewGroupE.getLocationOnScreen(iArr);
                tooltipDrawable.K = iArr[0];
                viewGroupE.getWindowVisibleDisplayFrame(tooltipDrawable.D);
                viewGroupE.addOnLayoutChangeListener(tooltipDrawable.C);
            }
        }
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        AccessibilityEventSender accessibilityEventSender = this.f41135j;
        if (accessibilityEventSender != null) {
            removeCallbacks(accessibilityEventSender);
        }
        this.o = false;
        Iterator it = this.f41137l.iterator();
        while (it.hasNext()) {
            TooltipDrawable tooltipDrawable = (TooltipDrawable) it.next();
            ViewOverlayImpl viewOverlayImplF = ViewUtils.f(ViewUtils.e(this));
            if (viewOverlayImplF != null) {
                viewOverlayImplF.b(tooltipDrawable);
                ViewGroup viewGroupE = ViewUtils.e(this);
                if (viewGroupE == null) {
                    tooltipDrawable.getClass();
                } else {
                    viewGroupE.removeOnLayoutChangeListener(tooltipDrawable.C);
                }
            }
        }
        getViewTreeObserver().removeOnScrollChangedListener(this.d1);
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x018e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01ff  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onDraw(android.graphics.Canvas r21) {
        /*
            Method dump skipped, instructions count: 778
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.BaseSlider.onDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        AccessibilityHelper accessibilityHelper = this.f41133h;
        if (!z) {
            this.G0 = -1;
            accessibilityHelper.a(this.H0);
            return;
        }
        if (i2 == 1) {
            n(Api.BaseClientBuilder.API_PRIORITY_OTHER);
        } else if (i2 == 2) {
            n(Integer.MIN_VALUE);
        } else if (i2 == 17) {
            o(Api.BaseClientBuilder.API_PRIORITY_OTHER);
        } else if (i2 == 66) {
            o(Integer.MIN_VALUE);
        }
        accessibilityHelper.n(this.H0);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004d  */
    @Override // android.view.View, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onKeyDown(int r14, android.view.KeyEvent r15) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.BaseSlider.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        this.O0 = false;
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i3) {
        int i4 = this.A;
        int i5 = this.B;
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(i4 + ((i5 == 1 || i5 == 3) ? ((TooltipDrawable) this.f41137l.get(0)).getIntrinsicHeight() : 0), 1073741824));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.D0 = sliderState.f41148a;
        this.E0 = sliderState.f41149b;
        t(sliderState.f41150c);
        this.I0 = sliderState.f41151d;
        if (sliderState.f41152e) {
            requestFocus();
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.f41148a = this.D0;
        sliderState.f41149b = this.E0;
        sliderState.f41150c = new ArrayList(this.F0);
        sliderState.f41151d = this.I0;
        sliderState.f41152e = hasFocus();
        return sliderState;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.N0 = Math.max(i2 - (this.D * 2), 0);
        m();
        x();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006f  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            Method dump skipped, instructions count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.BaseSlider.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i2) {
        ViewOverlayImpl viewOverlayImplF;
        super.onVisibilityChanged(view, i2);
        if (i2 == 0 || (viewOverlayImplF = ViewUtils.f(ViewUtils.e(this))) == null) {
            return;
        }
        Iterator it = this.f41137l.iterator();
        while (it.hasNext()) {
            viewOverlayImplF.b((TooltipDrawable) it.next());
        }
    }

    public final float p(float f2) {
        float f3 = this.D0;
        float f4 = (f2 - f3) / (this.E0 - f3);
        return l() ? 1.0f - f4 : f4;
    }

    public final void q() {
        Iterator it = this.n.iterator();
        while (it.hasNext()) {
            ((BaseOnSliderTouchListener) it.next()).a(this);
        }
    }

    public boolean r() {
        if (this.G0 != -1) {
            return true;
        }
        float f2 = this.b1;
        if (l()) {
            f2 = 1.0f - f2;
        }
        float f3 = this.E0;
        float f4 = this.D0;
        float fA = android.support.v4.media.a.a(f3, f4, f2, f4);
        float fD = D(fA);
        this.G0 = 0;
        float fAbs = Math.abs(((Float) this.F0.get(0)).floatValue() - fA);
        for (int i2 = 1; i2 < this.F0.size(); i2++) {
            float fAbs2 = Math.abs(((Float) this.F0.get(i2)).floatValue() - fA);
            float fD2 = D(((Float) this.F0.get(i2)).floatValue());
            if (Float.compare(fAbs2, fAbs) > 0) {
                break;
            }
            boolean z = !l() ? fD2 - fD >= 0.0f : fD2 - fD <= 0.0f;
            if (Float.compare(fAbs2, fAbs) < 0) {
                this.G0 = i2;
            } else {
                if (Float.compare(fAbs2, fAbs) != 0) {
                    continue;
                } else {
                    if (Math.abs(fD2 - fD) < this.r) {
                        this.G0 = -1;
                        return false;
                    }
                    if (z) {
                        this.G0 = i2;
                    }
                }
            }
            fAbs = fAbs2;
        }
        return this.G0 != -1;
    }

    public final void s(TooltipDrawable tooltipDrawable, float f2) {
        String strG = g(f2);
        if (!TextUtils.equals(tooltipDrawable.y, strG)) {
            tooltipDrawable.y = strG;
            tooltipDrawable.B.f40644e = true;
            tooltipDrawable.invalidateSelf();
        }
        int iP = (this.D + ((int) (p(f2) * this.N0))) - (tooltipDrawable.getIntrinsicWidth() / 2);
        int iB = b() - ((this.F / 2) + this.M);
        tooltipDrawable.setBounds(iP, iB - tooltipDrawable.getIntrinsicHeight(), tooltipDrawable.getIntrinsicWidth() + iP, iB);
        Rect rect = new Rect(tooltipDrawable.getBounds());
        DescendantOffsetUtils.c(ViewUtils.e(this), this, rect);
        tooltipDrawable.setBounds(rect);
        ViewUtils.f(ViewUtils.e(this)).a(tooltipDrawable);
    }

    public void setActiveThumbIndex(int i2) {
        this.G0 = i2;
    }

    public void setCustomThumbDrawable(Drawable drawable) {
        Drawable drawableNewDrawable = drawable.mutate().getConstantState().newDrawable();
        a(drawableNewDrawable);
        this.Z0 = drawableNewDrawable;
        this.a1.clear();
        postInvalidate();
    }

    public void setCustomThumbDrawablesForValues(@NonNull @DrawableRes int... iArr) {
        Drawable[] drawableArr = new Drawable[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            drawableArr[i2] = getResources().getDrawable(iArr[i2]);
        }
        setCustomThumbDrawablesForValues(drawableArr);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        setLayerType(z ? 0 : 2, null);
    }

    public void setFocusedThumbIndex(int i2) {
        if (i2 < 0 || i2 >= this.F0.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        this.H0 = i2;
        this.f41133h.n(i2);
        postInvalidate();
    }

    public void setHaloRadius(int i2) {
        if (i2 == this.G) {
            return;
        }
        this.G = i2;
        Drawable background = getBackground();
        if ((getBackground() instanceof RippleDrawable) && (background instanceof RippleDrawable)) {
            ((RippleDrawable) background).setRadius(this.G);
        } else {
            postInvalidate();
        }
    }

    public void setHaloTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.Q0)) {
            return;
        }
        this.Q0 = colorStateList;
        Drawable background = getBackground();
        if ((getBackground() instanceof RippleDrawable) && (background instanceof RippleDrawable)) {
            ((RippleDrawable) background).setColor(colorStateList);
            return;
        }
        int i2 = i(colorStateList);
        Paint paint = this.f41129d;
        paint.setColor(i2);
        paint.setAlpha(63);
        invalidate();
    }

    public void setLabelBehavior(int i2) {
        if (this.B != i2) {
            this.B = i2;
            requestLayout();
        }
    }

    public void setSeparationUnit(int i2) {
        this.c1 = i2;
        this.P0 = true;
        postInvalidate();
    }

    public void setStepSize(float f2) {
        if (f2 >= 0.0f) {
            if (this.I0 != f2) {
                this.I0 = f2;
                this.P0 = true;
                postInvalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("The stepSize(" + f2 + ") must be 0, or a factor of the valueFrom(" + this.D0 + ")-valueTo(" + this.E0 + ") range");
    }

    public void setThumbElevation(float f2) {
        this.Y0.l(f2);
    }

    public void setThumbHeight(int i2) {
        if (i2 == this.F) {
            return;
        }
        this.F = i2;
        this.Y0.setBounds(0, 0, this.E, i2);
        Drawable drawable = this.Z0;
        if (drawable != null) {
            a(drawable);
        }
        Iterator it = this.a1.iterator();
        while (it.hasNext()) {
            a((Drawable) it.next());
        }
        A();
    }

    public void setThumbRadius(int i2) {
        int i3 = i2 * 2;
        setThumbWidth(i3);
        setThumbHeight(i3);
    }

    public void setThumbStrokeColor(ColorStateList colorStateList) {
        this.Y0.t(colorStateList);
        postInvalidate();
    }

    public void setThumbStrokeWidth(float f2) {
        this.Y0.u(f2);
        postInvalidate();
    }

    public void setThumbTrackGapSize(int i2) {
        if (this.H == i2) {
            return;
        }
        this.H = i2;
        invalidate();
    }

    public void setThumbWidth(int i2) {
        if (i2 == this.E) {
            return;
        }
        this.E = i2;
        ShapeAppearanceModel.Builder builder = new ShapeAppearanceModel.Builder();
        float f2 = this.E / 2.0f;
        CornerTreatment cornerTreatmentA = MaterialShapeUtils.a(0);
        builder.g(cornerTreatmentA);
        builder.j(cornerTreatmentA);
        builder.f41021c = cornerTreatmentA;
        float fB = ShapeAppearanceModel.Builder.b(cornerTreatmentA);
        if (fB != -1.0f) {
            builder.e(fB);
        }
        builder.f41022d = cornerTreatmentA;
        float fB2 = ShapeAppearanceModel.Builder.b(cornerTreatmentA);
        if (fB2 != -1.0f) {
            builder.d(fB2);
        }
        builder.c(f2);
        ShapeAppearanceModel shapeAppearanceModelA = builder.a();
        MaterialShapeDrawable materialShapeDrawable = this.Y0;
        materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModelA);
        materialShapeDrawable.setBounds(0, 0, this.E, this.F);
        Drawable drawable = this.Z0;
        if (drawable != null) {
            a(drawable);
        }
        Iterator it = this.a1.iterator();
        while (it.hasNext()) {
            a((Drawable) it.next());
        }
        A();
    }

    public void setTickActiveRadius(int i2) {
        if (this.L0 != i2) {
            this.L0 = i2;
            this.f41131f.setStrokeWidth(i2 * 2);
            A();
        }
    }

    public void setTickActiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.R0)) {
            return;
        }
        this.R0 = colorStateList;
        this.f41131f.setColor(i(colorStateList));
        invalidate();
    }

    public void setTickInactiveRadius(int i2) {
        if (this.M0 != i2) {
            this.M0 = i2;
            this.f41130e.setStrokeWidth(i2 * 2);
            A();
        }
    }

    public void setTickInactiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.S0)) {
            return;
        }
        this.S0 = colorStateList;
        this.f41130e.setColor(i(colorStateList));
        invalidate();
    }

    public void setTrackActiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.T0)) {
            return;
        }
        this.T0 = colorStateList;
        this.f41127b.setColor(i(colorStateList));
        this.f41132g.setColor(i(this.T0));
        invalidate();
    }

    public void setTrackHeight(int i2) {
        if (this.C != i2) {
            this.C = i2;
            this.f41126a.setStrokeWidth(i2);
            this.f41127b.setStrokeWidth(this.C);
            A();
        }
    }

    public void setTrackInactiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.U0)) {
            return;
        }
        this.U0 = colorStateList;
        this.f41126a.setColor(i(colorStateList));
        invalidate();
    }

    public void setTrackInsideCornerSize(int i2) {
        if (this.L == i2) {
            return;
        }
        this.L = i2;
        invalidate();
    }

    public void setTrackStopIndicatorSize(int i2) {
        if (this.K == i2) {
            return;
        }
        this.K = i2;
        this.f41132g.setStrokeWidth(i2);
        invalidate();
    }

    public void setValues(@NonNull Float... fArr) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, fArr);
        t(arrayList);
    }

    public final void t(ArrayList arrayList) {
        ViewGroup viewGroupE;
        int resourceId;
        ViewOverlayImpl viewOverlayImplF;
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("At least one value must be set");
        }
        Collections.sort(arrayList);
        if (this.F0.size() == arrayList.size() && this.F0.equals(arrayList)) {
            return;
        }
        this.F0 = arrayList;
        this.P0 = true;
        this.H0 = 0;
        x();
        ArrayList arrayList2 = this.f41137l;
        if (arrayList2.size() > this.F0.size()) {
            List<TooltipDrawable> listSubList = arrayList2.subList(this.F0.size(), arrayList2.size());
            for (TooltipDrawable tooltipDrawable : listSubList) {
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                if (isAttachedToWindow() && (viewOverlayImplF = ViewUtils.f(ViewUtils.e(this))) != null) {
                    viewOverlayImplF.b(tooltipDrawable);
                    ViewGroup viewGroupE2 = ViewUtils.e(this);
                    if (viewGroupE2 == null) {
                        tooltipDrawable.getClass();
                    } else {
                        viewGroupE2.removeOnLayoutChangeListener(tooltipDrawable.C);
                    }
                }
            }
            listSubList.clear();
        }
        while (arrayList2.size() < this.F0.size()) {
            Context context = getContext();
            int i2 = this.f41136k;
            TooltipDrawable tooltipDrawable2 = new TooltipDrawable(context, i2);
            TypedArray typedArrayD = ThemeEnforcement.d(tooltipDrawable2.z, null, R.styleable.Tooltip, 0, i2, new int[0]);
            Context context2 = tooltipDrawable2.z;
            tooltipDrawable2.J = context2.getResources().getDimensionPixelSize(R.dimen.mtrl_tooltip_arrowSize);
            boolean z = typedArrayD.getBoolean(R.styleable.Tooltip_showMarker, true);
            tooltipDrawable2.I = z;
            if (z) {
                ShapeAppearanceModel.Builder builderG = tooltipDrawable2.f40974a.f40989a.g();
                builderG.f41029k = tooltipDrawable2.z();
                tooltipDrawable2.setShapeAppearanceModel(builderG.a());
            } else {
                tooltipDrawable2.J = 0;
            }
            CharSequence text = typedArrayD.getText(R.styleable.Tooltip_android_text);
            boolean zEquals = TextUtils.equals(tooltipDrawable2.y, text);
            TextDrawableHelper textDrawableHelper = tooltipDrawable2.B;
            if (!zEquals) {
                tooltipDrawable2.y = text;
                textDrawableHelper.f40644e = true;
                tooltipDrawable2.invalidateSelf();
            }
            int i3 = R.styleable.Tooltip_android_textAppearance;
            TextAppearance textAppearance = (!typedArrayD.hasValue(i3) || (resourceId = typedArrayD.getResourceId(i3, 0)) == 0) ? null : new TextAppearance(context2, resourceId);
            if (textAppearance != null && typedArrayD.hasValue(R.styleable.Tooltip_android_textColor)) {
                textAppearance.f40877j = MaterialResources.a(context2, typedArrayD, R.styleable.Tooltip_android_textColor);
            }
            textDrawableHelper.c(textAppearance, context2);
            tooltipDrawable2.m(ColorStateList.valueOf(typedArrayD.getColor(R.styleable.Tooltip_backgroundTint, ColorUtils.h(ColorUtils.k(MaterialColors.d(context2, R.attr.colorOnBackground, TooltipDrawable.class.getCanonicalName()), 153), ColorUtils.k(MaterialColors.d(context2, android.R.attr.colorBackground, TooltipDrawable.class.getCanonicalName()), 229)))));
            tooltipDrawable2.t(ColorStateList.valueOf(MaterialColors.d(context2, R.attr.colorSurface, TooltipDrawable.class.getCanonicalName())));
            tooltipDrawable2.E = typedArrayD.getDimensionPixelSize(R.styleable.Tooltip_android_padding, 0);
            tooltipDrawable2.F = typedArrayD.getDimensionPixelSize(R.styleable.Tooltip_android_minWidth, 0);
            tooltipDrawable2.G = typedArrayD.getDimensionPixelSize(R.styleable.Tooltip_android_minHeight, 0);
            tooltipDrawable2.H = typedArrayD.getDimensionPixelSize(R.styleable.Tooltip_android_layout_margin, 0);
            typedArrayD.recycle();
            arrayList2.add(tooltipDrawable2);
            WeakHashMap weakHashMap2 = ViewCompat.f3080a;
            if (isAttachedToWindow() && (viewGroupE = ViewUtils.e(this)) != null) {
                int[] iArr = new int[2];
                viewGroupE.getLocationOnScreen(iArr);
                tooltipDrawable2.K = iArr[0];
                viewGroupE.getWindowVisibleDisplayFrame(tooltipDrawable2.D);
                viewGroupE.addOnLayoutChangeListener(tooltipDrawable2.C);
            }
        }
        int i4 = arrayList2.size() == 1 ? 0 : 1;
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            ((TooltipDrawable) it.next()).u(i4);
        }
        Iterator it2 = this.f41138m.iterator();
        while (it2.hasNext()) {
            BaseOnChangeListener baseOnChangeListener = (BaseOnChangeListener) it2.next();
            Iterator it3 = this.F0.iterator();
            while (it3.hasNext()) {
                baseOnChangeListener.a(this, ((Float) it3.next()).floatValue(), false);
            }
        }
        postInvalidate();
    }

    public final boolean u(float f2, int i2) {
        this.H0 = i2;
        if (Math.abs(f2 - ((Float) this.F0.get(i2)).floatValue()) < 1.0E-4d) {
            return false;
        }
        float minSeparation = getMinSeparation();
        if (this.c1 == 0) {
            if (minSeparation == 0.0f) {
                minSeparation = 0.0f;
            } else {
                float f3 = this.D0;
                minSeparation = android.support.v4.media.a.a(f3, this.E0, (minSeparation - this.D) / this.N0, f3);
            }
        }
        if (l()) {
            minSeparation = -minSeparation;
        }
        int i3 = i2 + 1;
        int i4 = i2 - 1;
        this.F0.set(i2, Float.valueOf(MathUtils.a(f2, i4 < 0 ? this.D0 : minSeparation + ((Float) this.F0.get(i4)).floatValue(), i3 >= this.F0.size() ? this.E0 : ((Float) this.F0.get(i3)).floatValue() - minSeparation)));
        Iterator it = this.f41138m.iterator();
        while (it.hasNext()) {
            ((BaseOnChangeListener) it.next()).a(this, ((Float) this.F0.get(i2)).floatValue(), true);
        }
        AccessibilityManager accessibilityManager = this.f41134i;
        if (accessibilityManager != null && accessibilityManager.isEnabled()) {
            AccessibilityEventSender accessibilityEventSender = this.f41135j;
            if (accessibilityEventSender == null) {
                this.f41135j = new AccessibilityEventSender();
            } else {
                removeCallbacks(accessibilityEventSender);
            }
            AccessibilityEventSender accessibilityEventSender2 = this.f41135j;
            accessibilityEventSender2.f41142a = i2;
            postDelayed(accessibilityEventSender2, 200L);
        }
        return true;
    }

    public final void v() {
        double dRound;
        float f2 = this.b1;
        float f3 = this.I0;
        if (f3 > 0.0f) {
            dRound = Math.round(f2 * r1) / ((int) ((this.E0 - this.D0) / f3));
        } else {
            dRound = f2;
        }
        if (l()) {
            dRound = 1.0d - dRound;
        }
        float f4 = this.E0;
        u((float) ((dRound * (f4 - r1)) + this.D0), this.G0);
    }

    public final void w(int i2, Rect rect) {
        int iP = this.D + ((int) (p(getValues().get(i2).floatValue()) * this.N0));
        int iB = b();
        int iMax = Math.max(this.E / 2, this.y / 2);
        int iMax2 = Math.max(this.F / 2, this.y / 2);
        rect.set(iP - iMax, iB - iMax2, iP + iMax, iB + iMax2);
    }

    public final void x() {
        if (!(getBackground() instanceof RippleDrawable) || getMeasuredWidth() <= 0) {
            return;
        }
        Drawable background = getBackground();
        if (background instanceof RippleDrawable) {
            int iP = (int) ((p(((Float) this.F0.get(this.H0)).floatValue()) * this.N0) + this.D);
            int iB = b();
            int i2 = this.G;
            background.setHotspotBounds(iP - i2, iB - i2, iP + i2, iB + i2);
        }
    }

    public final void y() {
        int i2 = this.B;
        if (i2 == 0 || i2 == 1) {
            if (this.G0 == -1 || !isEnabled()) {
                f();
                return;
            } else {
                e();
                return;
            }
        }
        if (i2 == 2) {
            f();
            return;
        }
        if (i2 != 3) {
            throw new IllegalArgumentException("Unexpected labelBehavior: " + this.B);
        }
        if (isEnabled()) {
            Rect rect = new Rect();
            ViewUtils.e(this).getHitRect(rect);
            if (getLocalVisibleRect(rect)) {
                e();
                return;
            }
        }
        f();
    }

    public final void z(Canvas canvas, Paint paint, RectF rectF, FullCornerDirection fullCornerDirection) {
        float f2;
        float f3 = this.C / 2.0f;
        int iOrdinal = fullCornerDirection.ordinal();
        if (iOrdinal == 1) {
            f2 = this.L;
        } else if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                f3 = this.L;
            }
            f2 = f3;
        } else {
            f2 = f3;
            f3 = this.L;
        }
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        Path path = this.V0;
        path.reset();
        if (rectF.width() >= f3 + f2) {
            path.addRoundRect(rectF, new float[]{f3, f3, f2, f2, f2, f2, f3, f3}, Path.Direction.CW);
            canvas.drawPath(path, paint);
            return;
        }
        float fMin = Math.min(f3, f2);
        float fMax = Math.max(f3, f2);
        canvas.save();
        path.addRoundRect(rectF, fMin, fMin, Path.Direction.CW);
        canvas.clipPath(path);
        int iOrdinal2 = fullCornerDirection.ordinal();
        RectF rectF2 = this.X0;
        if (iOrdinal2 == 1) {
            float f4 = rectF.left;
            rectF2.set(f4, rectF.top, (2.0f * fMax) + f4, rectF.bottom);
        } else if (iOrdinal2 != 2) {
            rectF2.set(rectF.centerX() - fMax, rectF.top, rectF.centerX() + fMax, rectF.bottom);
        } else {
            float f5 = rectF.right;
            rectF2.set(f5 - (2.0f * fMax), rectF.top, f5, rectF.bottom);
        }
        canvas.drawRoundRect(rectF2, fMax, fMax, paint);
        canvas.restore();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.google.android.material.slider.a] */
    public BaseSlider(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) throws Resources.NotFoundException {
        int i3 = e1;
        super(MaterialThemeOverlay.a(context, attributeSet, i2, i3), attributeSet, i2);
        this.f41137l = new ArrayList();
        this.f41138m = new ArrayList();
        this.n = new ArrayList();
        this.o = false;
        this.I = -1;
        this.J = -1;
        this.C0 = false;
        this.F0 = new ArrayList();
        this.G0 = -1;
        this.H0 = -1;
        this.I0 = 0.0f;
        this.K0 = true;
        this.O0 = false;
        this.V0 = new Path();
        this.W0 = new RectF();
        this.X0 = new RectF();
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.Y0 = materialShapeDrawable;
        this.a1 = Collections.EMPTY_LIST;
        this.c1 = 0;
        this.d1 = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.google.android.material.slider.a
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                int i4 = BaseSlider.e1;
                this.f41155a.y();
            }
        };
        Context context2 = getContext();
        this.f41126a = new Paint();
        this.f41127b = new Paint();
        Paint paint = new Paint(1);
        this.f41128c = paint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint2 = new Paint(1);
        this.f41129d = paint2;
        paint2.setStyle(style);
        Paint paint3 = new Paint();
        this.f41130e = paint3;
        Paint.Style style2 = Paint.Style.STROKE;
        paint3.setStyle(style2);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint3.setStrokeCap(cap);
        Paint paint4 = new Paint();
        this.f41131f = paint4;
        paint4.setStyle(style2);
        paint4.setStrokeCap(cap);
        Paint paint5 = new Paint();
        this.f41132g = paint5;
        paint5.setStyle(style);
        paint5.setStrokeCap(cap);
        Resources resources = context2.getResources();
        this.z = resources.getDimensionPixelSize(R.dimen.mtrl_slider_widget_height);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_side_padding);
        this.s = dimensionPixelOffset;
        this.D = dimensionPixelOffset;
        this.t = resources.getDimensionPixelSize(R.dimen.mtrl_slider_thumb_radius);
        this.u = resources.getDimensionPixelSize(R.dimen.mtrl_slider_track_height);
        this.v = resources.getDimensionPixelSize(R.dimen.mtrl_slider_tick_radius);
        this.w = resources.getDimensionPixelSize(R.dimen.mtrl_slider_tick_radius);
        this.x = resources.getDimensionPixelSize(R.dimen.mtrl_slider_tick_min_spacing);
        this.M = resources.getDimensionPixelSize(R.dimen.mtrl_slider_label_padding);
        int[] iArr = R.styleable.Slider;
        ThemeEnforcement.a(context2, attributeSet, i2, i3);
        ThemeEnforcement.b(context2, attributeSet, iArr, i2, i3, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, i2, i3);
        this.f41136k = typedArrayObtainStyledAttributes.getResourceId(R.styleable.Slider_labelStyle, R.style.Widget_MaterialComponents_Tooltip);
        this.D0 = typedArrayObtainStyledAttributes.getFloat(R.styleable.Slider_android_valueFrom, 0.0f);
        this.E0 = typedArrayObtainStyledAttributes.getFloat(R.styleable.Slider_android_valueTo, 1.0f);
        setValues(Float.valueOf(this.D0));
        this.I0 = typedArrayObtainStyledAttributes.getFloat(R.styleable.Slider_android_stepSize, 0.0f);
        this.y = (int) Math.ceil(typedArrayObtainStyledAttributes.getDimension(R.styleable.Slider_minTouchTargetSize, (float) Math.ceil(ViewUtils.d(48, getContext()))));
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(R.styleable.Slider_trackColor);
        int i4 = zHasValue ? R.styleable.Slider_trackColor : R.styleable.Slider_trackColorInactive;
        int i5 = zHasValue ? R.styleable.Slider_trackColor : R.styleable.Slider_trackColorActive;
        ColorStateList colorStateListA = MaterialResources.a(context2, typedArrayObtainStyledAttributes, i4);
        setTrackInactiveTintList(colorStateListA == null ? ResourcesCompat.b(context2.getResources(), R.color.material_slider_inactive_track_color, context2.getTheme()) : colorStateListA);
        ColorStateList colorStateListA2 = MaterialResources.a(context2, typedArrayObtainStyledAttributes, i5);
        setTrackActiveTintList(colorStateListA2 == null ? ResourcesCompat.b(context2.getResources(), R.color.material_slider_active_track_color, context2.getTheme()) : colorStateListA2);
        materialShapeDrawable.m(MaterialResources.a(context2, typedArrayObtainStyledAttributes, R.styleable.Slider_thumbColor));
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.Slider_thumbStrokeColor)) {
            setThumbStrokeColor(MaterialResources.a(context2, typedArrayObtainStyledAttributes, R.styleable.Slider_thumbStrokeColor));
        }
        setThumbStrokeWidth(typedArrayObtainStyledAttributes.getDimension(R.styleable.Slider_thumbStrokeWidth, 0.0f));
        ColorStateList colorStateListA3 = MaterialResources.a(context2, typedArrayObtainStyledAttributes, R.styleable.Slider_haloColor);
        setHaloTintList(colorStateListA3 == null ? ResourcesCompat.b(context2.getResources(), R.color.material_slider_halo_color, context2.getTheme()) : colorStateListA3);
        this.K0 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.Slider_tickVisible, true);
        boolean zHasValue2 = typedArrayObtainStyledAttributes.hasValue(R.styleable.Slider_tickColor);
        int i6 = zHasValue2 ? R.styleable.Slider_tickColor : R.styleable.Slider_tickColorInactive;
        int i7 = zHasValue2 ? R.styleable.Slider_tickColor : R.styleable.Slider_tickColorActive;
        ColorStateList colorStateListA4 = MaterialResources.a(context2, typedArrayObtainStyledAttributes, i6);
        setTickInactiveTintList(colorStateListA4 == null ? ResourcesCompat.b(context2.getResources(), R.color.material_slider_inactive_tick_marks_color, context2.getTheme()) : colorStateListA4);
        ColorStateList colorStateListA5 = MaterialResources.a(context2, typedArrayObtainStyledAttributes, i7);
        setTickActiveTintList(colorStateListA5 == null ? ResourcesCompat.b(context2.getResources(), R.color.material_slider_active_tick_marks_color, context2.getTheme()) : colorStateListA5);
        setThumbTrackGapSize(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_thumbTrackGapSize, 0));
        setTrackStopIndicatorSize(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_trackStopIndicatorSize, 0));
        setTrackInsideCornerSize(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_trackInsideCornerSize, 0));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_thumbRadius, 0) * 2;
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_thumbWidth, dimensionPixelSize);
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_thumbHeight, dimensionPixelSize);
        setThumbWidth(dimensionPixelSize2);
        setThumbHeight(dimensionPixelSize3);
        setHaloRadius(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_haloRadius, 0));
        setThumbElevation(typedArrayObtainStyledAttributes.getDimension(R.styleable.Slider_thumbElevation, 0.0f));
        setTrackHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_trackHeight, 0));
        setTickActiveRadius(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_tickRadiusActive, this.K / 2));
        setTickInactiveRadius(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_tickRadiusInactive, this.K / 2));
        setLabelBehavior(typedArrayObtainStyledAttributes.getInt(R.styleable.Slider_labelBehavior, 0));
        if (!typedArrayObtainStyledAttributes.getBoolean(R.styleable.Slider_android_enabled, true)) {
            setEnabled(false);
        }
        typedArrayObtainStyledAttributes.recycle();
        setFocusable(true);
        setClickable(true);
        materialShapeDrawable.r(2);
        this.r = ViewConfiguration.get(context2).getScaledTouchSlop();
        AccessibilityHelper accessibilityHelper = new AccessibilityHelper(this);
        this.f41133h = accessibilityHelper;
        ViewCompat.z(this, accessibilityHelper);
        this.f41134i = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    public void setValues(@NonNull List<Float> list) {
        t(new ArrayList(list));
    }

    public void setCustomThumbDrawablesForValues(@NonNull Drawable... drawableArr) {
        this.Z0 = null;
        this.a1 = new ArrayList();
        for (Drawable drawable : drawableArr) {
            List list = this.a1;
            Drawable drawableNewDrawable = drawable.mutate().getConstantState().newDrawable();
            a(drawableNewDrawable);
            list.add(drawableNewDrawable);
        }
        postInvalidate();
    }
}
