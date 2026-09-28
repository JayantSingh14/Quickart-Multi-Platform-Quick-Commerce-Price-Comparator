package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.util.Preconditions;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ImageMatrixProperty;
import com.google.android.material.animation.MatrixEvaluator;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.StateListAnimator;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.ripple.RippleDrawableCompat;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
class FloatingActionButtonImpl {
    public static final FastOutLinearInInterpolator D = AnimationUtils.f39818c;
    public static final int E = R.attr.motionDurationLong2;
    public static final int F = R.attr.motionEasingEmphasizedInterpolator;
    public static final int G = R.attr.motionDurationMedium1;
    public static final int H = R.attr.motionEasingEmphasizedAccelerateInterpolator;
    public static final int[] I = {android.R.attr.state_pressed, android.R.attr.state_enabled};
    public static final int[] J = {android.R.attr.state_hovered, android.R.attr.state_focused, android.R.attr.state_enabled};
    public static final int[] K = {android.R.attr.state_focused, android.R.attr.state_enabled};
    public static final int[] L = {android.R.attr.state_hovered, android.R.attr.state_enabled};
    public static final int[] M = {android.R.attr.state_enabled};
    public static final int[] N = new int[0];
    public ViewTreeObserver.OnPreDrawListener C;

    /* renamed from: a, reason: collision with root package name */
    public ShapeAppearanceModel f40487a;

    /* renamed from: b, reason: collision with root package name */
    public MaterialShapeDrawable f40488b;

    /* renamed from: c, reason: collision with root package name */
    public Drawable f40489c;

    /* renamed from: d, reason: collision with root package name */
    public BorderDrawable f40490d;

    /* renamed from: e, reason: collision with root package name */
    public LayerDrawable f40491e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f40492f;

    /* renamed from: h, reason: collision with root package name */
    public float f40494h;

    /* renamed from: i, reason: collision with root package name */
    public float f40495i;

    /* renamed from: j, reason: collision with root package name */
    public float f40496j;

    /* renamed from: k, reason: collision with root package name */
    public int f40497k;

    /* renamed from: l, reason: collision with root package name */
    public final StateListAnimator f40498l;

    /* renamed from: m, reason: collision with root package name */
    public Animator f40499m;
    public MotionSpec n;
    public MotionSpec o;
    public float p;
    public int r;
    public ArrayList t;
    public ArrayList u;
    public ArrayList v;
    public final FloatingActionButton w;
    public final ShadowViewDelegate x;

    /* renamed from: g, reason: collision with root package name */
    public boolean f40493g = true;
    public float q = 1.0f;
    public int s = 0;
    public final Rect y = new Rect();
    public final RectF z = new RectF();
    public final RectF A = new RectF();
    public final Matrix B = new Matrix();

    /* renamed from: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$5, reason: invalid class name */
    class AnonymousClass5 implements TypeEvaluator<Float> {

        /* renamed from: a, reason: collision with root package name */
        public FloatEvaluator f40517a;

        @Override // android.animation.TypeEvaluator
        public final Float evaluate(float f2, Float f3, Float f4) {
            float fFloatValue = this.f40517a.evaluate(f2, (Number) f3, (Number) f4).floatValue();
            if (fFloatValue < 0.1f) {
                fFloatValue = 0.0f;
            }
            return Float.valueOf(fFloatValue);
        }
    }

    public class DisabledElevationAnimation extends ShadowAnimatorImpl {
        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public final float a() {
            return 0.0f;
        }
    }

    public class ElevateToHoveredFocusedTranslationZAnimation extends ShadowAnimatorImpl {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ FloatingActionButtonImplLollipop f40519e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ElevateToHoveredFocusedTranslationZAnimation(FloatingActionButtonImplLollipop floatingActionButtonImplLollipop) {
            super(floatingActionButtonImplLollipop);
            this.f40519e = floatingActionButtonImplLollipop;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public final float a() {
            FloatingActionButtonImplLollipop floatingActionButtonImplLollipop = this.f40519e;
            return floatingActionButtonImplLollipop.f40494h + floatingActionButtonImplLollipop.f40495i;
        }
    }

    public class ElevateToPressedTranslationZAnimation extends ShadowAnimatorImpl {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ FloatingActionButtonImplLollipop f40520e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ElevateToPressedTranslationZAnimation(FloatingActionButtonImplLollipop floatingActionButtonImplLollipop) {
            super(floatingActionButtonImplLollipop);
            this.f40520e = floatingActionButtonImplLollipop;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public final float a() {
            FloatingActionButtonImplLollipop floatingActionButtonImplLollipop = this.f40520e;
            return floatingActionButtonImplLollipop.f40494h + floatingActionButtonImplLollipop.f40496j;
        }
    }

    public interface InternalTransformationCallback {
        void a();

        void b();
    }

    public interface InternalVisibilityChangedListener {
    }

    public class ResetElevationAnimation extends ShadowAnimatorImpl {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ FloatingActionButtonImplLollipop f40521e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResetElevationAnimation(FloatingActionButtonImplLollipop floatingActionButtonImplLollipop) {
            super(floatingActionButtonImplLollipop);
            this.f40521e = floatingActionButtonImplLollipop;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public final float a() {
            return this.f40521e.f40494h;
        }
    }

    public abstract class ShadowAnimatorImpl extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public boolean f40522a;

        /* renamed from: b, reason: collision with root package name */
        public float f40523b;

        /* renamed from: c, reason: collision with root package name */
        public float f40524c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ FloatingActionButtonImplLollipop f40525d;

        public ShadowAnimatorImpl(FloatingActionButtonImplLollipop floatingActionButtonImplLollipop) {
            this.f40525d = floatingActionButtonImplLollipop;
        }

        public abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            float f2 = (int) this.f40524c;
            MaterialShapeDrawable materialShapeDrawable = this.f40525d.f40488b;
            if (materialShapeDrawable != null) {
                materialShapeDrawable.l(f2);
            }
            this.f40522a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            boolean z = this.f40522a;
            FloatingActionButtonImplLollipop floatingActionButtonImplLollipop = this.f40525d;
            if (!z) {
                MaterialShapeDrawable materialShapeDrawable = floatingActionButtonImplLollipop.f40488b;
                this.f40523b = materialShapeDrawable == null ? 0.0f : materialShapeDrawable.f40974a.f41001m;
                this.f40524c = a();
                this.f40522a = true;
            }
            float f2 = this.f40523b;
            float animatedFraction = (int) ((valueAnimator.getAnimatedFraction() * (this.f40524c - f2)) + f2);
            MaterialShapeDrawable materialShapeDrawable2 = floatingActionButtonImplLollipop.f40488b;
            if (materialShapeDrawable2 != null) {
                materialShapeDrawable2.l(animatedFraction);
            }
        }
    }

    public FloatingActionButtonImpl(FloatingActionButton floatingActionButton, ShadowViewDelegate shadowViewDelegate) {
        this.w = floatingActionButton;
        this.x = shadowViewDelegate;
        StateListAnimator stateListAnimator = new StateListAnimator();
        this.f40498l = stateListAnimator;
        FloatingActionButtonImplLollipop floatingActionButtonImplLollipop = (FloatingActionButtonImplLollipop) this;
        stateListAnimator.a(I, d(new ElevateToPressedTranslationZAnimation(floatingActionButtonImplLollipop)));
        stateListAnimator.a(J, d(new ElevateToHoveredFocusedTranslationZAnimation(floatingActionButtonImplLollipop)));
        stateListAnimator.a(K, d(new ElevateToHoveredFocusedTranslationZAnimation(floatingActionButtonImplLollipop)));
        stateListAnimator.a(L, d(new ElevateToHoveredFocusedTranslationZAnimation(floatingActionButtonImplLollipop)));
        stateListAnimator.a(M, d(new ResetElevationAnimation(floatingActionButtonImplLollipop)));
        stateListAnimator.a(N, d(new DisabledElevationAnimation(floatingActionButtonImplLollipop)));
        this.p = floatingActionButton.getRotation();
    }

    public static ValueAnimator d(ShadowAnimatorImpl shadowAnimatorImpl) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(D);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(shadowAnimatorImpl);
        valueAnimator.addUpdateListener(shadowAnimatorImpl);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    public final void a(float f2, Matrix matrix) {
        matrix.reset();
        if (this.w.getDrawable() == null || this.r == 0) {
            return;
        }
        RectF rectF = this.z;
        RectF rectF2 = this.A;
        rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        float f3 = this.r;
        rectF2.set(0.0f, 0.0f, f3, f3);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        float f4 = this.r / 2.0f;
        matrix.postScale(f2, f2, f4, f4);
    }

    public final AnimatorSet b(MotionSpec motionSpec, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        Property property = View.ALPHA;
        float[] fArr = {f2};
        FloatingActionButton floatingActionButton = this.w;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) property, fArr);
        motionSpec.f("opacity").a(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.SCALE_X, f3);
        motionSpec.f("scale").a(objectAnimatorOfFloat2);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 == 26) {
            AnonymousClass5 anonymousClass5 = new AnonymousClass5();
            anonymousClass5.f40517a = new FloatEvaluator();
            objectAnimatorOfFloat2.setEvaluator(anonymousClass5);
        }
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.SCALE_Y, f3);
        motionSpec.f("scale").a(objectAnimatorOfFloat3);
        if (i2 == 26) {
            AnonymousClass5 anonymousClass52 = new AnonymousClass5();
            anonymousClass52.f40517a = new FloatEvaluator();
            objectAnimatorOfFloat3.setEvaluator(anonymousClass52);
        }
        arrayList.add(objectAnimatorOfFloat3);
        Matrix matrix = this.B;
        a(f4, matrix);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(floatingActionButton, new ImageMatrixProperty(), new MatrixEvaluator() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.3
            @Override // com.google.android.material.animation.MatrixEvaluator, android.animation.TypeEvaluator
            /* renamed from: a */
            public final Matrix evaluate(float f5, Matrix matrix2, Matrix matrix3) {
                FloatingActionButtonImpl.this.q = f5;
                return super.evaluate(f5, matrix2, matrix3);
            }
        }, new Matrix(matrix));
        motionSpec.f("iconScale").a(objectAnimatorOfObject);
        arrayList.add(objectAnimatorOfObject);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.a(animatorSet, arrayList);
        return animatorSet;
    }

    public final AnimatorSet c(final float f2, final float f3, final float f4, int i2, int i3) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        FloatingActionButton floatingActionButton = this.w;
        final float alpha = floatingActionButton.getAlpha();
        final float scaleX = floatingActionButton.getScaleX();
        final float scaleY = floatingActionButton.getScaleY();
        final float f5 = this.q;
        final Matrix matrix = new Matrix(this.B);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                floatingActionButtonImpl.w.setAlpha(AnimationUtils.b(alpha, f2, 0.0f, 0.2f, fFloatValue));
                FloatingActionButton floatingActionButton2 = floatingActionButtonImpl.w;
                float f6 = scaleX;
                float f7 = f3;
                floatingActionButton2.setScaleX(AnimationUtils.a(f6, f7, fFloatValue));
                floatingActionButtonImpl.w.setScaleY(AnimationUtils.a(scaleY, f7, fFloatValue));
                float f8 = f5;
                float f9 = f4;
                floatingActionButtonImpl.q = AnimationUtils.a(f8, f9, fFloatValue);
                float fA = AnimationUtils.a(f8, f9, fFloatValue);
                Matrix matrix2 = matrix;
                floatingActionButtonImpl.a(fA, matrix2);
                floatingActionButtonImpl.w.setImageMatrix(matrix2);
            }
        });
        arrayList.add(valueAnimatorOfFloat);
        AnimatorSetCompat.a(animatorSet, arrayList);
        animatorSet.setDuration(MotionUtils.c(floatingActionButton.getContext(), i2, floatingActionButton.getContext().getResources().getInteger(R.integer.material_motion_duration_long_1)));
        animatorSet.setInterpolator(MotionUtils.d(floatingActionButton.getContext(), i3, AnimationUtils.f39817b));
        return animatorSet;
    }

    public MaterialShapeDrawable e() {
        ShapeAppearanceModel shapeAppearanceModel = this.f40487a;
        shapeAppearanceModel.getClass();
        return new MaterialShapeDrawable(shapeAppearanceModel);
    }

    public float f() {
        return this.f40494h;
    }

    public void g(Rect rect) {
        int iMax = this.f40492f ? Math.max((this.f40497k - this.w.getSizeDimension()) / 2, 0) : 0;
        int iMax2 = Math.max(iMax, (int) Math.ceil(this.f40493g ? f() + this.f40496j : 0.0f));
        int iMax3 = Math.max(iMax, (int) Math.ceil(r0 * 1.5f));
        rect.set(iMax2, iMax3, iMax2, iMax3);
    }

    public void h(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        MaterialShapeDrawable materialShapeDrawableE = e();
        this.f40488b = materialShapeDrawableE;
        materialShapeDrawableE.setTintList(colorStateList);
        if (mode != null) {
            this.f40488b.setTintMode(mode);
        }
        this.f40488b.p(-12303292);
        this.f40488b.k(this.w.getContext());
        RippleDrawableCompat rippleDrawableCompat = new RippleDrawableCompat(this.f40488b.f40974a.f40989a);
        rippleDrawableCompat.setTintList(RippleUtils.c(colorStateList2));
        this.f40489c = rippleDrawableCompat;
        MaterialShapeDrawable materialShapeDrawable = this.f40488b;
        materialShapeDrawable.getClass();
        this.f40491e = new LayerDrawable(new Drawable[]{materialShapeDrawable, rippleDrawableCompat});
    }

    public void i() {
        StateListAnimator stateListAnimator = this.f40498l;
        ValueAnimator valueAnimator = stateListAnimator.f40622c;
        if (valueAnimator != null) {
            valueAnimator.end();
            stateListAnimator.f40622c = null;
        }
    }

    public void j() {
    }

    public void k(int[] iArr) {
        this.f40498l.b(iArr);
    }

    public void l(float f2, float f3, float f4) {
        i();
        r();
        MaterialShapeDrawable materialShapeDrawable = this.f40488b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.l(f2);
        }
    }

    public final void m() {
        ArrayList arrayList = this.v;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((InternalTransformationCallback) it.next()).a();
            }
        }
    }

    public void n(ColorStateList colorStateList) {
        Drawable drawable = this.f40489c;
        if (drawable != null) {
            drawable.setTintList(RippleUtils.c(colorStateList));
        }
    }

    public final void o(ShapeAppearanceModel shapeAppearanceModel) {
        this.f40487a = shapeAppearanceModel;
        MaterialShapeDrawable materialShapeDrawable = this.f40488b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
        Object obj = this.f40489c;
        if (obj instanceof Shapeable) {
            ((Shapeable) obj).setShapeAppearanceModel(shapeAppearanceModel);
        }
        BorderDrawable borderDrawable = this.f40490d;
        if (borderDrawable != null) {
            borderDrawable.o = shapeAppearanceModel;
            borderDrawable.invalidateSelf();
        }
    }

    public boolean p() {
        return true;
    }

    public void q() {
        MaterialShapeDrawable materialShapeDrawable = this.f40488b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.q((int) this.p);
        }
    }

    public final void r() {
        Rect rect = this.y;
        g(rect);
        Preconditions.c(this.f40491e, "Didn't initialize content background");
        boolean zP = p();
        ShadowViewDelegate shadowViewDelegate = this.x;
        if (zP) {
            ((FloatingActionButton.ShadowDelegateImpl) shadowViewDelegate).a(new InsetDrawable((Drawable) this.f40491e, rect.left, rect.top, rect.right, rect.bottom));
        } else {
            ((FloatingActionButton.ShadowDelegateImpl) shadowViewDelegate).a(this.f40491e);
        }
        int i2 = rect.left;
        int i3 = rect.top;
        int i4 = rect.right;
        int i5 = rect.bottom;
        FloatingActionButton floatingActionButton = FloatingActionButton.this;
        floatingActionButton.f40478l.set(i2, i3, i4, i5);
        int i6 = floatingActionButton.f40475i;
        floatingActionButton.setPadding(i2 + i6, i3 + i6, i4 + i6, i5 + i6);
    }
}
