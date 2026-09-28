package com.google.android.material.transition;

import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.media.b;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.PathParser;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.transition.ArcMotion;
import androidx.transition.PathMotion;
import androidx.transition.PatternPathMotion;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public final class MaterialContainerTransform extends Transition {
    public boolean F = false;
    public final int G = R.id.content;
    public final int H = -1;
    public final int I = -1;
    public final int J = 1375731712;
    public final boolean K;
    public final float L;
    public final float M;
    public static final String[] Q = {"materialContainerTransition:bounds", "materialContainerTransition:shapeAppearance"};
    public static final ProgressThresholdsGroup X = new ProgressThresholdsGroup(new ProgressThresholds(0.0f, 0.25f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.75f));
    public static final ProgressThresholdsGroup Y = new ProgressThresholdsGroup(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.3f, 0.9f));
    public static final ProgressThresholdsGroup Z = new ProgressThresholdsGroup(new ProgressThresholds(0.1f, 0.4f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 0.9f));
    public static final ProgressThresholdsGroup A0 = new ProgressThresholdsGroup(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.2f, 0.9f));

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface FadeMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface FitMode {
    }

    public static class ProgressThresholds {

        /* renamed from: a, reason: collision with root package name */
        public final float f41524a;

        /* renamed from: b, reason: collision with root package name */
        public final float f41525b;

        public ProgressThresholds(float f2, float f3) {
            this.f41524a = f2;
            this.f41525b = f3;
        }
    }

    public static class ProgressThresholdsGroup {

        /* renamed from: a, reason: collision with root package name */
        public final ProgressThresholds f41526a;

        /* renamed from: b, reason: collision with root package name */
        public final ProgressThresholds f41527b;

        /* renamed from: c, reason: collision with root package name */
        public final ProgressThresholds f41528c;

        /* renamed from: d, reason: collision with root package name */
        public final ProgressThresholds f41529d;

        public ProgressThresholdsGroup(ProgressThresholds progressThresholds, ProgressThresholds progressThresholds2, ProgressThresholds progressThresholds3, ProgressThresholds progressThresholds4) {
            this.f41526a = progressThresholds;
            this.f41527b = progressThresholds2;
            this.f41528c = progressThresholds3;
            this.f41529d = progressThresholds4;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface TransitionDirection {
    }

    public static final class TransitionDrawable extends Drawable {
        public final ProgressThresholdsGroup A;
        public final FadeModeEvaluator B;
        public final FitModeEvaluator C;
        public FadeModeResult D;
        public FitModeResult E;
        public RectF F;
        public float G;
        public float H;
        public float I;

        /* renamed from: a, reason: collision with root package name */
        public final View f41530a;

        /* renamed from: b, reason: collision with root package name */
        public final RectF f41531b;

        /* renamed from: c, reason: collision with root package name */
        public final ShapeAppearanceModel f41532c;

        /* renamed from: d, reason: collision with root package name */
        public final float f41533d;

        /* renamed from: e, reason: collision with root package name */
        public final View f41534e;

        /* renamed from: f, reason: collision with root package name */
        public final RectF f41535f;

        /* renamed from: g, reason: collision with root package name */
        public final ShapeAppearanceModel f41536g;

        /* renamed from: h, reason: collision with root package name */
        public final float f41537h;

        /* renamed from: i, reason: collision with root package name */
        public final Paint f41538i;

        /* renamed from: j, reason: collision with root package name */
        public final Paint f41539j;

        /* renamed from: k, reason: collision with root package name */
        public final Paint f41540k;

        /* renamed from: l, reason: collision with root package name */
        public final Paint f41541l;

        /* renamed from: m, reason: collision with root package name */
        public final Paint f41542m;
        public final MaskEvaluator n;
        public final PathMeasure o;
        public final float p;
        public final float[] q;
        public final boolean r;
        public final float s;
        public final float t;
        public final boolean u;
        public final MaterialShapeDrawable v;
        public final RectF w;
        public final RectF x;
        public final RectF y;
        public final RectF z;

        public TransitionDrawable(PathMotion pathMotion, View view, RectF rectF, ShapeAppearanceModel shapeAppearanceModel, float f2, View view2, RectF rectF2, ShapeAppearanceModel shapeAppearanceModel2, float f3, int i2, boolean z, boolean z2, FadeModeEvaluator fadeModeEvaluator, FitModeEvaluator fitModeEvaluator, ProgressThresholdsGroup progressThresholdsGroup) {
            Paint paint = new Paint();
            this.f41538i = paint;
            Paint paint2 = new Paint();
            this.f41539j = paint2;
            Paint paint3 = new Paint();
            this.f41540k = paint3;
            this.f41541l = new Paint();
            Paint paint4 = new Paint();
            this.f41542m = paint4;
            this.n = new MaskEvaluator();
            this.q = new float[]{rectF.centerX(), rectF.top};
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            this.v = materialShapeDrawable;
            Paint paint5 = new Paint();
            new Path();
            this.f41530a = view;
            this.f41531b = rectF;
            this.f41532c = shapeAppearanceModel;
            this.f41533d = f2;
            this.f41534e = view2;
            this.f41535f = rectF2;
            this.f41536g = shapeAppearanceModel2;
            this.f41537h = f3;
            this.r = z;
            this.u = z2;
            this.B = fadeModeEvaluator;
            this.C = fitModeEvaluator;
            this.A = progressThresholdsGroup;
            WindowManager windowManager = (WindowManager) view.getContext().getSystemService("window");
            windowManager.getDefaultDisplay().getMetrics(new DisplayMetrics());
            this.s = r9.widthPixels;
            this.t = r9.heightPixels;
            paint.setColor(0);
            paint2.setColor(0);
            paint3.setColor(0);
            materialShapeDrawable.m(ColorStateList.valueOf(0));
            materialShapeDrawable.r(2);
            materialShapeDrawable.w = false;
            materialShapeDrawable.p(-7829368);
            RectF rectF3 = new RectF(rectF);
            this.w = rectF3;
            this.x = new RectF(rectF3);
            RectF rectF4 = new RectF(rectF3);
            this.y = rectF4;
            this.z = new RectF(rectF4);
            PointF pointF = new PointF(rectF.centerX(), rectF.top);
            PointF pointF2 = new PointF(rectF2.centerX(), rectF2.top);
            PathMeasure pathMeasure = new PathMeasure(pathMotion.a(pointF.x, pointF.y, pointF2.x, pointF2.y), false);
            this.o = pathMeasure;
            this.p = pathMeasure.getLength();
            paint4.setStyle(Paint.Style.FILL);
            RectF rectF5 = TransitionUtils.f41550a;
            paint4.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, i2, i2, Shader.TileMode.CLAMP));
            paint5.setStyle(Paint.Style.STROKE);
            paint5.setStrokeWidth(10.0f);
            d(0.0f);
        }

        public final void a(Canvas canvas) {
            c(canvas, this.f41540k);
            Rect bounds = getBounds();
            RectF rectF = this.y;
            TransitionUtils.f(canvas, bounds, rectF.left, rectF.top, this.E.f41508b, this.D.f41489b, new CanvasCompat.CanvasOperation() { // from class: com.google.android.material.transition.MaterialContainerTransform.TransitionDrawable.2
                @Override // com.google.android.material.canvas.CanvasCompat.CanvasOperation
                public final void a(Canvas canvas2) {
                    TransitionDrawable.this.f41534e.draw(canvas2);
                }
            });
        }

        public final void b(Canvas canvas) {
            c(canvas, this.f41539j);
            Rect bounds = getBounds();
            RectF rectF = this.w;
            TransitionUtils.f(canvas, bounds, rectF.left, rectF.top, this.E.f41507a, this.D.f41488a, new CanvasCompat.CanvasOperation() { // from class: com.google.android.material.transition.MaterialContainerTransform.TransitionDrawable.1
                @Override // com.google.android.material.canvas.CanvasCompat.CanvasOperation
                public final void a(Canvas canvas2) {
                    TransitionDrawable.this.f41530a.draw(canvas2);
                }
            });
        }

        public final void c(Canvas canvas, Paint paint) {
            if (paint.getColor() == 0 || paint.getAlpha() <= 0) {
                return;
            }
            canvas.drawRect(getBounds(), paint);
        }

        /* JADX WARN: Removed duplicated region for block: B:45:0x0208  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0217  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void d(float r23) {
            /*
                Method dump skipped, instructions count: 546
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.transition.MaterialContainerTransform.TransitionDrawable.d(float):void");
        }

        @Override // android.graphics.drawable.Drawable
        public final void draw(Canvas canvas) {
            Paint paint = this.f41542m;
            if (paint.getAlpha() > 0) {
                canvas.drawRect(getBounds(), paint);
            }
            boolean z = this.u;
            MaskEvaluator maskEvaluator = this.n;
            if (z && this.G > 0.0f) {
                canvas.save();
                canvas.clipPath(maskEvaluator.f41513a, Region.Op.DIFFERENCE);
                if (Build.VERSION.SDK_INT > 28) {
                    ShapeAppearanceModel shapeAppearanceModel = maskEvaluator.f41517e;
                    boolean zF = shapeAppearanceModel.f(this.F);
                    Paint paint2 = this.f41541l;
                    if (zF) {
                        float fA = shapeAppearanceModel.f41011e.a(this.F);
                        canvas.drawRoundRect(this.F, fA, fA, paint2);
                    } else {
                        canvas.drawPath(maskEvaluator.f41513a, paint2);
                    }
                } else {
                    MaterialShapeDrawable materialShapeDrawable = this.v;
                    RectF rectF = this.F;
                    materialShapeDrawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                    materialShapeDrawable.l(this.G);
                    materialShapeDrawable.s((int) this.H);
                    materialShapeDrawable.setShapeAppearanceModel(maskEvaluator.f41517e);
                    materialShapeDrawable.draw(canvas);
                }
                canvas.restore();
            }
            canvas.clipPath(maskEvaluator.f41513a);
            c(canvas, this.f41538i);
            if (this.D.f41490c) {
                b(canvas);
                a(canvas);
            } else {
                a(canvas);
                b(canvas);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public final void setAlpha(int i2) {
            throw new UnsupportedOperationException("Setting alpha on is not supported");
        }

        @Override // android.graphics.drawable.Drawable
        public final void setColorFilter(ColorFilter colorFilter) {
            throw new UnsupportedOperationException("Setting a color filter is not supported");
        }
    }

    public MaterialContainerTransform() {
        this.K = Build.VERSION.SDK_INT >= 28;
        this.L = -1.0f;
        this.M = -1.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void P(TransitionValues transitionValues, int i2) throws Resources.NotFoundException {
        final RectF rectFB;
        ShapeAppearanceModel shapeAppearanceModelA;
        if (i2 != -1) {
            View view = transitionValues.f12164b;
            RectF rectF = TransitionUtils.f41550a;
            View viewFindViewById = view.findViewById(i2);
            if (viewFindViewById == null) {
                viewFindViewById = TransitionUtils.a(i2, view);
            }
            transitionValues.f12164b = viewFindViewById;
        } else if (transitionValues.f12164b.getTag(com.google.android.material.R.id.mtrl_motion_snapshot_view) instanceof View) {
            View view2 = (View) transitionValues.f12164b.getTag(com.google.android.material.R.id.mtrl_motion_snapshot_view);
            transitionValues.f12164b.setTag(com.google.android.material.R.id.mtrl_motion_snapshot_view, null);
            transitionValues.f12164b = view2;
        }
        View view3 = transitionValues.f12164b;
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        if (!view3.isLaidOut() && view3.getWidth() == 0 && view3.getHeight() == 0) {
            return;
        }
        if (view3.getParent() == null) {
            RectF rectF2 = TransitionUtils.f41550a;
            rectFB = new RectF(view3.getLeft(), view3.getTop(), view3.getRight(), view3.getBottom());
        } else {
            rectFB = TransitionUtils.b(view3);
        }
        HashMap map = transitionValues.f12163a;
        map.put("materialContainerTransition:bounds", rectFB);
        if (view3.getTag(com.google.android.material.R.id.mtrl_motion_snapshot_view) instanceof ShapeAppearanceModel) {
            shapeAppearanceModelA = (ShapeAppearanceModel) view3.getTag(com.google.android.material.R.id.mtrl_motion_snapshot_view);
        } else {
            Context context = view3.getContext();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{com.google.android.material.R.attr.transitionShapeAppearance});
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
            typedArrayObtainStyledAttributes.recycle();
            shapeAppearanceModelA = resourceId != -1 ? ShapeAppearanceModel.a(context, resourceId, 0).a() : view3 instanceof Shapeable ? ((Shapeable) view3).getShapeAppearanceModel() : new ShapeAppearanceModel.Builder().a();
        }
        map.put("materialContainerTransition:shapeAppearance", shapeAppearanceModelA.h(new ShapeAppearanceModel.CornerSizeUnaryOperator() { // from class: com.google.android.material.transition.a
            @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
            public final CornerSize b(CornerSize cornerSize) {
                RectF rectF3 = TransitionUtils.f41550a;
                RectF rectF4 = rectFB;
                return cornerSize instanceof RelativeCornerSize ? (RelativeCornerSize) cornerSize : new RelativeCornerSize(cornerSize.a(rectF4) / Math.min(rectF4.width(), rectF4.height()));
            }
        }));
    }

    @Override // androidx.transition.Transition
    public final void J(PathMotion pathMotion) {
        super.J(pathMotion);
        this.F = true;
    }

    @Override // androidx.transition.Transition
    public final void d(TransitionValues transitionValues) throws Resources.NotFoundException {
        P(transitionValues, this.I);
    }

    @Override // androidx.transition.Transition
    public final void g(TransitionValues transitionValues) throws Resources.NotFoundException {
        P(transitionValues, this.H);
    }

    @Override // androidx.transition.Transition
    public final Animator k(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) throws Resources.NotFoundException {
        View viewA;
        View view;
        RectF rectF;
        View view2;
        ProgressThresholdsGroup progressThresholdsGroup;
        int i2;
        int iC;
        PathMotion patternPathMotion = null;
        if (transitionValues != null && transitionValues2 != null) {
            HashMap map = transitionValues.f12163a;
            RectF rectF2 = (RectF) map.get("materialContainerTransition:bounds");
            ShapeAppearanceModel shapeAppearanceModel = (ShapeAppearanceModel) map.get("materialContainerTransition:shapeAppearance");
            if (rectF2 != null && shapeAppearanceModel != null) {
                HashMap map2 = transitionValues2.f12163a;
                RectF rectF3 = (RectF) map2.get("materialContainerTransition:bounds");
                ShapeAppearanceModel shapeAppearanceModel2 = (ShapeAppearanceModel) map2.get("materialContainerTransition:shapeAppearance");
                if (rectF3 == null || shapeAppearanceModel2 == null) {
                    Log.w("MaterialContainerTransform", "Skipping due to null end bounds. Ensure end view is laid out and measured.");
                    return null;
                }
                final View view3 = transitionValues.f12164b;
                final View view4 = transitionValues2.f12164b;
                View view5 = view4.getParent() != null ? view4 : view3;
                int id = view5.getId();
                int i3 = this.G;
                if (i3 == id) {
                    viewA = (View) view5.getParent();
                    view = view5;
                } else {
                    viewA = TransitionUtils.a(i3, view5);
                    view = null;
                }
                RectF rectFB = TransitionUtils.b(viewA);
                float f2 = -rectFB.left;
                float f3 = -rectFB.top;
                if (view != null) {
                    rectF = TransitionUtils.b(view);
                    rectF.offset(f2, f3);
                } else {
                    rectF = new RectF(0.0f, 0.0f, viewA.getWidth(), viewA.getHeight());
                }
                rectF2.offset(f2, f3);
                rectF3.offset(f2, f3);
                boolean z = rectF3.height() * rectF3.width() > rectF2.height() * rectF2.width();
                Context context = view5.getContext();
                int i4 = com.google.android.material.R.attr.motionEasingEmphasizedInterpolator;
                FastOutSlowInInterpolator fastOutSlowInInterpolator = AnimationUtils.f39817b;
                if (i4 != 0 && this.f12118d == null) {
                    I(MotionUtils.d(context, i4, fastOutSlowInInterpolator));
                }
                int i5 = z ? com.google.android.material.R.attr.motionDurationLong2 : com.google.android.material.R.attr.motionDurationMedium4;
                if (i5 != 0 && this.f12117c == -1 && (iC = MotionUtils.c(context, i5, -1)) != -1) {
                    G(iC);
                }
                if (!this.F && (i2 = com.google.android.material.R.attr.motionPath) != 0) {
                    TypedValue typedValue = new TypedValue();
                    if (context.getTheme().resolveAttribute(i2, typedValue, true)) {
                        int i6 = typedValue.type;
                        if (i6 == 16) {
                            int i7 = typedValue.data;
                            if (i7 != 0) {
                                if (i7 != 1) {
                                    throw new IllegalArgumentException(b.f(i7, "Invalid motion path type: "));
                                }
                                patternPathMotion = new MaterialArcMotion();
                            }
                        } else {
                            if (i6 != 3) {
                                throw new IllegalArgumentException("Motion path theme attribute must either be an enum value or path data string");
                            }
                            patternPathMotion = new PatternPathMotion(PathParser.d(String.valueOf(typedValue.string)));
                        }
                    }
                    if (patternPathMotion != null) {
                        J(patternPathMotion);
                    }
                }
                PathMotion pathMotion = this.x;
                float fJ = this.L;
                if (fJ == -1.0f) {
                    fJ = ViewCompat.j(view3);
                }
                float f4 = fJ;
                float fJ2 = this.M;
                if (fJ2 == -1.0f) {
                    fJ2 = ViewCompat.j(view4);
                }
                float f5 = fJ2;
                FadeModeEvaluator fadeModeEvaluator = z ? FadeModeEvaluators.f41486a : FadeModeEvaluators.f41487b;
                FitModeEvaluator fitModeEvaluator = FitModeEvaluators.f41505a;
                FitModeEvaluator fitModeEvaluator2 = FitModeEvaluators.f41506b;
                float fWidth = rectF2.width();
                float fHeight = rectF2.height();
                float fWidth2 = rectF3.width();
                float fHeight2 = rectF3.height();
                FitModeEvaluator fitModeEvaluator3 = (!z ? (fWidth2 * fHeight) / fWidth >= fHeight2 : (fHeight2 * fWidth) / fWidth2 >= fHeight) ? fitModeEvaluator2 : fitModeEvaluator;
                PathMotion pathMotion2 = this.x;
                if ((pathMotion2 instanceof ArcMotion) || (pathMotion2 instanceof MaterialArcMotion)) {
                    view2 = viewA;
                    ProgressThresholdsGroup progressThresholdsGroup2 = Z;
                    ProgressThresholdsGroup progressThresholdsGroup3 = A0;
                    if (!z) {
                        progressThresholdsGroup2 = progressThresholdsGroup3;
                    }
                    progressThresholdsGroup = new ProgressThresholdsGroup(progressThresholdsGroup2.f41526a, progressThresholdsGroup2.f41527b, progressThresholdsGroup2.f41528c, progressThresholdsGroup2.f41529d);
                } else {
                    ProgressThresholdsGroup progressThresholdsGroup4 = X;
                    ProgressThresholdsGroup progressThresholdsGroup5 = Y;
                    if (!z) {
                        progressThresholdsGroup4 = progressThresholdsGroup5;
                    }
                    view2 = viewA;
                    progressThresholdsGroup = new ProgressThresholdsGroup(progressThresholdsGroup4.f41526a, progressThresholdsGroup4.f41527b, progressThresholdsGroup4.f41528c, progressThresholdsGroup4.f41529d);
                }
                final TransitionDrawable transitionDrawable = new TransitionDrawable(pathMotion, view3, rectF2, shapeAppearanceModel, f4, view4, rectF3, shapeAppearanceModel2, f5, this.J, z, this.K, fadeModeEvaluator, fitModeEvaluator3, progressThresholdsGroup);
                transitionDrawable.setBounds(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.transition.MaterialContainerTransform.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        TransitionDrawable transitionDrawable2 = transitionDrawable;
                        if (transitionDrawable2.I != animatedFraction) {
                            transitionDrawable2.d(animatedFraction);
                        }
                    }
                });
                final View view6 = view2;
                a(new TransitionListenerAdapter() { // from class: com.google.android.material.transition.MaterialContainerTransform.2
                    @Override // com.google.android.material.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                    public final void h(Transition transition) {
                        ViewUtils.f(view6).a(transitionDrawable);
                        view3.setAlpha(0.0f);
                        view4.setAlpha(0.0f);
                    }

                    @Override // com.google.android.material.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                    public final void j(Transition transition) {
                        MaterialContainerTransform materialContainerTransform = MaterialContainerTransform.this;
                        materialContainerTransform.B(this);
                        materialContainerTransform.getClass();
                        view3.setAlpha(1.0f);
                        view4.setAlpha(1.0f);
                        ViewUtils.f(view6).b(transitionDrawable);
                    }
                });
                return valueAnimatorOfFloat;
            }
            Log.w("MaterialContainerTransform", "Skipping due to null start bounds. Ensure start view is laid out and measured.");
        }
        return null;
    }

    @Override // androidx.transition.Transition
    public final String[] q() {
        return Q;
    }
}
