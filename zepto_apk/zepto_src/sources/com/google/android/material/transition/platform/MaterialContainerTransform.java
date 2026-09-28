package com.google.android.material.transition.platform;

import android.R;
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
import android.transition.PathMotion;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import java.util.WeakHashMap;

@RequiresApi
/* loaded from: classes4.dex */
public final class MaterialContainerTransform extends Transition {

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f41589j = {"materialContainerTransition:bounds", "materialContainerTransition:shapeAppearance"};

    /* renamed from: k, reason: collision with root package name */
    public static final ProgressThresholdsGroup f41590k = new ProgressThresholdsGroup(new ProgressThresholds(0.0f, 0.25f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.75f));

    /* renamed from: l, reason: collision with root package name */
    public static final ProgressThresholdsGroup f41591l = new ProgressThresholdsGroup(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.3f, 0.9f));

    /* renamed from: m, reason: collision with root package name */
    public static final ProgressThresholdsGroup f41592m = new ProgressThresholdsGroup(new ProgressThresholds(0.1f, 0.4f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 0.9f));
    public static final ProgressThresholdsGroup n = new ProgressThresholdsGroup(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.2f, 0.9f));

    /* renamed from: a, reason: collision with root package name */
    public boolean f41593a = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f41594b = false;

    /* renamed from: c, reason: collision with root package name */
    public final int f41595c = R.id.content;

    /* renamed from: d, reason: collision with root package name */
    public final int f41596d = -1;

    /* renamed from: e, reason: collision with root package name */
    public final int f41597e = -1;

    /* renamed from: f, reason: collision with root package name */
    public final int f41598f = 1375731712;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f41599g;

    /* renamed from: h, reason: collision with root package name */
    public final float f41600h;

    /* renamed from: i, reason: collision with root package name */
    public final float f41601i;

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
        public final float f41608a;

        /* renamed from: b, reason: collision with root package name */
        public final float f41609b;

        public ProgressThresholds(float f2, float f3) {
            this.f41608a = f2;
            this.f41609b = f3;
        }
    }

    public static class ProgressThresholdsGroup {

        /* renamed from: a, reason: collision with root package name */
        public final ProgressThresholds f41610a;

        /* renamed from: b, reason: collision with root package name */
        public final ProgressThresholds f41611b;

        /* renamed from: c, reason: collision with root package name */
        public final ProgressThresholds f41612c;

        /* renamed from: d, reason: collision with root package name */
        public final ProgressThresholds f41613d;

        public ProgressThresholdsGroup(ProgressThresholds progressThresholds, ProgressThresholds progressThresholds2, ProgressThresholds progressThresholds3, ProgressThresholds progressThresholds4) {
            this.f41610a = progressThresholds;
            this.f41611b = progressThresholds2;
            this.f41612c = progressThresholds3;
            this.f41613d = progressThresholds4;
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
        public final View f41614a;

        /* renamed from: b, reason: collision with root package name */
        public final RectF f41615b;

        /* renamed from: c, reason: collision with root package name */
        public final ShapeAppearanceModel f41616c;

        /* renamed from: d, reason: collision with root package name */
        public final float f41617d;

        /* renamed from: e, reason: collision with root package name */
        public final View f41618e;

        /* renamed from: f, reason: collision with root package name */
        public final RectF f41619f;

        /* renamed from: g, reason: collision with root package name */
        public final ShapeAppearanceModel f41620g;

        /* renamed from: h, reason: collision with root package name */
        public final float f41621h;

        /* renamed from: i, reason: collision with root package name */
        public final Paint f41622i;

        /* renamed from: j, reason: collision with root package name */
        public final Paint f41623j;

        /* renamed from: k, reason: collision with root package name */
        public final Paint f41624k;

        /* renamed from: l, reason: collision with root package name */
        public final Paint f41625l;

        /* renamed from: m, reason: collision with root package name */
        public final Paint f41626m;
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
            this.f41622i = paint;
            Paint paint2 = new Paint();
            this.f41623j = paint2;
            Paint paint3 = new Paint();
            this.f41624k = paint3;
            this.f41625l = new Paint();
            Paint paint4 = new Paint();
            this.f41626m = paint4;
            this.n = new MaskEvaluator();
            this.q = new float[]{rectF.centerX(), rectF.top};
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            this.v = materialShapeDrawable;
            Paint paint5 = new Paint();
            new Path();
            this.f41614a = view;
            this.f41615b = rectF;
            this.f41616c = shapeAppearanceModel;
            this.f41617d = f2;
            this.f41618e = view2;
            this.f41619f = rectF2;
            this.f41620g = shapeAppearanceModel2;
            this.f41621h = f3;
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
            PathMeasure pathMeasure = new PathMeasure(pathMotion.getPath(pointF.x, pointF.y, pointF2.x, pointF2.y), false);
            this.o = pathMeasure;
            this.p = pathMeasure.getLength();
            paint4.setStyle(Paint.Style.FILL);
            RectF rectF5 = TransitionUtils.f41653a;
            paint4.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, i2, i2, Shader.TileMode.CLAMP));
            paint5.setStyle(Paint.Style.STROKE);
            paint5.setStrokeWidth(10.0f);
            d(0.0f);
        }

        public final void a(Canvas canvas) {
            c(canvas, this.f41624k);
            Rect bounds = getBounds();
            RectF rectF = this.y;
            TransitionUtils.f(canvas, bounds, rectF.left, rectF.top, this.E.f41579b, this.D.f41560b, new CanvasCompat.CanvasOperation() { // from class: com.google.android.material.transition.platform.MaterialContainerTransform.TransitionDrawable.2
                @Override // com.google.android.material.canvas.CanvasCompat.CanvasOperation
                public final void a(Canvas canvas2) {
                    TransitionDrawable.this.f41618e.draw(canvas2);
                }
            });
        }

        public final void b(Canvas canvas) {
            c(canvas, this.f41623j);
            Rect bounds = getBounds();
            RectF rectF = this.w;
            TransitionUtils.f(canvas, bounds, rectF.left, rectF.top, this.E.f41578a, this.D.f41559a, new CanvasCompat.CanvasOperation() { // from class: com.google.android.material.transition.platform.MaterialContainerTransform.TransitionDrawable.1
                @Override // com.google.android.material.canvas.CanvasCompat.CanvasOperation
                public final void a(Canvas canvas2) {
                    TransitionDrawable.this.f41614a.draw(canvas2);
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.transition.platform.MaterialContainerTransform.TransitionDrawable.d(float):void");
        }

        @Override // android.graphics.drawable.Drawable
        public final void draw(Canvas canvas) {
            Paint paint = this.f41626m;
            if (paint.getAlpha() > 0) {
                canvas.drawRect(getBounds(), paint);
            }
            boolean z = this.u;
            MaskEvaluator maskEvaluator = this.n;
            if (z && this.G > 0.0f) {
                canvas.save();
                canvas.clipPath(maskEvaluator.f41584a, Region.Op.DIFFERENCE);
                if (Build.VERSION.SDK_INT > 28) {
                    ShapeAppearanceModel shapeAppearanceModel = maskEvaluator.f41588e;
                    boolean zF = shapeAppearanceModel.f(this.F);
                    Paint paint2 = this.f41625l;
                    if (zF) {
                        float fA = shapeAppearanceModel.f41011e.a(this.F);
                        canvas.drawRoundRect(this.F, fA, fA, paint2);
                    } else {
                        canvas.drawPath(maskEvaluator.f41584a, paint2);
                    }
                } else {
                    MaterialShapeDrawable materialShapeDrawable = this.v;
                    RectF rectF = this.F;
                    materialShapeDrawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                    materialShapeDrawable.l(this.G);
                    materialShapeDrawable.s((int) this.H);
                    materialShapeDrawable.setShapeAppearanceModel(maskEvaluator.f41588e);
                    materialShapeDrawable.draw(canvas);
                }
                canvas.restore();
            }
            canvas.clipPath(maskEvaluator.f41584a);
            c(canvas, this.f41622i);
            if (this.D.f41561c) {
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
        this.f41599g = Build.VERSION.SDK_INT >= 28;
        this.f41600h = -1.0f;
        this.f41601i = -1.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(TransitionValues transitionValues, int i2) throws Resources.NotFoundException {
        final RectF rectFB;
        ShapeAppearanceModel shapeAppearanceModelA;
        if (i2 != -1) {
            View view = transitionValues.view;
            RectF rectF = TransitionUtils.f41653a;
            View viewFindViewById = view.findViewById(i2);
            if (viewFindViewById == null) {
                viewFindViewById = TransitionUtils.a(i2, view);
            }
            transitionValues.view = viewFindViewById;
        } else if (transitionValues.view.getTag(com.google.android.material.R.id.mtrl_motion_snapshot_view) instanceof View) {
            View view2 = (View) transitionValues.view.getTag(com.google.android.material.R.id.mtrl_motion_snapshot_view);
            transitionValues.view.setTag(com.google.android.material.R.id.mtrl_motion_snapshot_view, null);
            transitionValues.view = view2;
        }
        View view3 = transitionValues.view;
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        if (!view3.isLaidOut() && view3.getWidth() == 0 && view3.getHeight() == 0) {
            return;
        }
        if (view3.getParent() == null) {
            RectF rectF2 = TransitionUtils.f41653a;
            rectFB = new RectF(view3.getLeft(), view3.getTop(), view3.getRight(), view3.getBottom());
        } else {
            rectFB = TransitionUtils.b(view3);
        }
        transitionValues.values.put("materialContainerTransition:bounds", rectFB);
        Map map = transitionValues.values;
        if (view3.getTag(com.google.android.material.R.id.mtrl_motion_snapshot_view) instanceof ShapeAppearanceModel) {
            shapeAppearanceModelA = (ShapeAppearanceModel) view3.getTag(com.google.android.material.R.id.mtrl_motion_snapshot_view);
        } else {
            Context context = view3.getContext();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{com.google.android.material.R.attr.transitionShapeAppearance});
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
            typedArrayObtainStyledAttributes.recycle();
            shapeAppearanceModelA = resourceId != -1 ? ShapeAppearanceModel.a(context, resourceId, 0).a() : view3 instanceof Shapeable ? ((Shapeable) view3).getShapeAppearanceModel() : new ShapeAppearanceModel.Builder().a();
        }
        map.put("materialContainerTransition:shapeAppearance", shapeAppearanceModelA.h(new ShapeAppearanceModel.CornerSizeUnaryOperator() { // from class: com.google.android.material.transition.platform.a
            @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
            public final CornerSize b(CornerSize cornerSize) {
                RectF rectF3 = TransitionUtils.f41653a;
                RectF rectF4 = rectFB;
                return cornerSize instanceof RelativeCornerSize ? (RelativeCornerSize) cornerSize : new RelativeCornerSize(cornerSize.a(rectF4) / Math.min(rectF4.width(), rectF4.height()));
            }
        }));
    }

    @Override // android.transition.Transition
    public final void captureEndValues(TransitionValues transitionValues) throws Resources.NotFoundException {
        a(transitionValues, this.f41597e);
    }

    @Override // android.transition.Transition
    public final void captureStartValues(TransitionValues transitionValues) throws Resources.NotFoundException {
        a(transitionValues, this.f41596d);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r3v1 com.google.android.material.transition.platform.MaterialContainerTransform$TransitionDrawable, still in use, count: 2, list:
          (r3v1 com.google.android.material.transition.platform.MaterialContainerTransform$TransitionDrawable) from 0x01ac: MOVE (r23v6 com.google.android.material.transition.platform.MaterialContainerTransform$TransitionDrawable) = (r3v1 com.google.android.material.transition.platform.MaterialContainerTransform$TransitionDrawable) (LINE:429)
          (r3v1 com.google.android.material.transition.platform.MaterialContainerTransform$TransitionDrawable) from 0x01bf: MOVE (r23v8 com.google.android.material.transition.platform.MaterialContainerTransform$TransitionDrawable) = (r3v1 com.google.android.material.transition.platform.MaterialContainerTransform$TransitionDrawable) (LINE:448)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:91)
        	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:57)
        	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:463)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:97)
        */
    @Override // android.transition.Transition
    public final android.animation.Animator createAnimator(android.view.ViewGroup r23, android.transition.TransitionValues r24, android.transition.TransitionValues r25) {
        /*
            Method dump skipped, instructions count: 574
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.transition.platform.MaterialContainerTransform.createAnimator(android.view.ViewGroup, android.transition.TransitionValues, android.transition.TransitionValues):android.animation.Animator");
    }

    @Override // android.transition.Transition
    public final String[] getTransitionProperties() {
        return f41589j;
    }

    @Override // android.transition.Transition
    public final void setPathMotion(PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        this.f41594b = true;
    }
}
