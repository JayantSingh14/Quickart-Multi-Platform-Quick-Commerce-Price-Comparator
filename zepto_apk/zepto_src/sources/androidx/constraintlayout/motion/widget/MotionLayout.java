package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v4.media.b;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.ArcCurveFit;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.VelocityMatrix;
import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Flow;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.core.widgets.Placeholder;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.helper.widget.MotionEffect;
import androidx.constraintlayout.motion.utils.StopLogic;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.motion.widget.TouchResponse;
import androidx.constraintlayout.utils.widget.MotionTelltales;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayoutStates;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.widget.NestedScrollView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class MotionLayout extends ConstraintLayout implements NestedScrollingParent3 {
    public static boolean o1;
    public final HashMap A;
    public final DecelerateInterpolator A0;
    public long B;
    public DesignTool B0;
    public float C;
    public int C0;
    public float D;
    public int D0;
    public float E;
    public boolean E0;
    public long F;
    public float F0;
    public float G;
    public float G0;
    public boolean H;
    public long H0;
    public boolean I;
    public float I0;
    public TransitionListener J;
    public boolean J0;
    public int K;
    public ArrayList K0;
    public DevModeDraw L;
    public ArrayList L0;
    public boolean M;
    public ArrayList M0;
    public CopyOnWriteArrayList N0;
    public int O0;
    public long P0;
    public final StopLogic Q;
    public float Q0;
    public int R0;
    public float S0;
    public boolean T0;
    public int U0;
    public int V0;
    public int W0;
    public int X0;
    public int Y0;
    public int Z0;
    public float a1;
    public final KeyCache b1;
    public boolean c1;
    public StateCache d1;
    public a e1;
    public final Rect f1;
    public boolean g1;
    public TransitionState h1;
    public final Model i1;
    public boolean j1;
    public final RectF k1;
    public View l1;
    public Matrix m1;
    public final ArrayList n1;
    public MotionScene q;
    public MotionInterpolator r;
    public Interpolator s;
    public float t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public boolean z;

    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    public class DecelerateInterpolator extends MotionInterpolator {

        /* renamed from: a, reason: collision with root package name */
        public float f2174a = 0.0f;

        /* renamed from: b, reason: collision with root package name */
        public float f2175b = 0.0f;

        /* renamed from: c, reason: collision with root package name */
        public float f2176c;

        public DecelerateInterpolator() {
        }

        @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
        public final float a() {
            return MotionLayout.this.t;
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f2) {
            float f3 = this.f2174a;
            MotionLayout motionLayout = MotionLayout.this;
            if (f3 > 0.0f) {
                float f4 = this.f2176c;
                if (f3 / f4 < f2) {
                    f2 = f3 / f4;
                }
                motionLayout.t = f3 - (f4 * f2);
                return ((f3 * f2) - (((f4 * f2) * f2) / 2.0f)) + this.f2175b;
            }
            float f5 = this.f2176c;
            if ((-f3) / f5 < f2) {
                f2 = (-f3) / f5;
            }
            motionLayout.t = (f5 * f2) + f3;
            return (((f5 * f2) * f2) / 2.0f) + (f3 * f2) + this.f2175b;
        }
    }

    public class DevModeDraw {

        /* renamed from: a, reason: collision with root package name */
        public float[] f2178a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f2179b;

        /* renamed from: c, reason: collision with root package name */
        public final float[] f2180c;

        /* renamed from: d, reason: collision with root package name */
        public Path f2181d;

        /* renamed from: e, reason: collision with root package name */
        public final Paint f2182e;

        /* renamed from: f, reason: collision with root package name */
        public final Paint f2183f;

        /* renamed from: g, reason: collision with root package name */
        public final Paint f2184g;

        /* renamed from: h, reason: collision with root package name */
        public final Paint f2185h;

        /* renamed from: i, reason: collision with root package name */
        public final Paint f2186i;

        /* renamed from: j, reason: collision with root package name */
        public final float[] f2187j;

        /* renamed from: k, reason: collision with root package name */
        public int f2188k;

        /* renamed from: l, reason: collision with root package name */
        public final Rect f2189l = new Rect();

        /* renamed from: m, reason: collision with root package name */
        public final int f2190m = 1;

        public DevModeDraw() {
            Paint paint = new Paint();
            this.f2182e = paint;
            paint.setAntiAlias(true);
            paint.setColor(-21965);
            paint.setStrokeWidth(2.0f);
            Paint.Style style = Paint.Style.STROKE;
            paint.setStyle(style);
            Paint paint2 = new Paint();
            this.f2183f = paint2;
            paint2.setAntiAlias(true);
            paint2.setColor(-2067046);
            paint2.setStrokeWidth(2.0f);
            paint2.setStyle(style);
            Paint paint3 = new Paint();
            this.f2184g = paint3;
            paint3.setAntiAlias(true);
            paint3.setColor(-13391360);
            paint3.setStrokeWidth(2.0f);
            paint3.setStyle(style);
            Paint paint4 = new Paint();
            this.f2185h = paint4;
            paint4.setAntiAlias(true);
            paint4.setColor(-13391360);
            paint4.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.f2187j = new float[8];
            Paint paint5 = new Paint();
            this.f2186i = paint5;
            paint5.setAntiAlias(true);
            paint3.setPathEffect(new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f));
            this.f2180c = new float[100];
            this.f2179b = new int[50];
        }

        public final void a(Canvas canvas, int i2, int i3, MotionController motionController) {
            Canvas canvas2;
            int width;
            int height;
            boolean z;
            float f2;
            int[] iArr = this.f2179b;
            boolean z2 = false;
            int i4 = 4;
            if (i2 == 4) {
                int i5 = 0;
                boolean z3 = false;
                boolean z4 = false;
                while (i5 < this.f2188k) {
                    int i6 = iArr[i5];
                    boolean z5 = z3;
                    if (i6 == 1) {
                        z5 = true;
                    }
                    if (i6 == 0) {
                        z4 = true;
                    }
                    i5++;
                    z3 = z5;
                    z4 = z4;
                }
                if (z3) {
                    float[] fArr = this.f2178a;
                    canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.f2184g);
                }
                if (z4) {
                    b(canvas);
                }
            }
            if (i2 == 2) {
                float[] fArr2 = this.f2178a;
                canvas2 = canvas;
                canvas2.drawLine(fArr2[0], fArr2[1], fArr2[fArr2.length - 2], fArr2[fArr2.length - 1], this.f2184g);
            } else {
                canvas2 = canvas;
            }
            if (i2 == 3) {
                b(canvas);
            }
            canvas2.drawLines(this.f2178a, this.f2182e);
            View view = motionController.f2155b;
            if (view != null) {
                width = view.getWidth();
                height = motionController.f2155b.getHeight();
            } else {
                width = 0;
                height = 0;
            }
            int i7 = 1;
            while (i7 < i3 - 1) {
                if (i2 == i4 && iArr[i7 - 1] == 0) {
                    z = z2;
                } else {
                    int i8 = i7 * 2;
                    float[] fArr3 = this.f2180c;
                    float f3 = fArr3[i8];
                    float f4 = fArr3[i8 + 1];
                    this.f2181d.reset();
                    z = z2;
                    this.f2181d.moveTo(f3, f4 + 10.0f);
                    this.f2181d.lineTo(f3 + 10.0f, f4);
                    this.f2181d.lineTo(f3, f4 - 10.0f);
                    this.f2181d.lineTo(f3 - 10.0f, f4);
                    this.f2181d.close();
                    int i9 = i7 - 1;
                    Paint paint = this.f2186i;
                    if (i2 == i4) {
                        int i10 = iArr[i9];
                        if (i10 == 1) {
                            d(canvas2, f3 - 0.0f, f4 - 0.0f);
                        } else if (i10 == 0) {
                            c(canvas2, f3 - 0.0f, f4 - 0.0f);
                        } else {
                            if (i10 == 2) {
                                f2 = f4;
                                e(canvas2, f3 - 0.0f, f2 - 0.0f, width, height);
                            }
                            canvas2.drawPath(this.f2181d, paint);
                        }
                        f2 = f4;
                        canvas2.drawPath(this.f2181d, paint);
                    } else {
                        f2 = f4;
                    }
                    if (i2 == 2) {
                        d(canvas2, f3 - 0.0f, f2 - 0.0f);
                    }
                    if (i2 == 3) {
                        c(canvas2, f3 - 0.0f, f2 - 0.0f);
                    }
                    if (i2 == 6) {
                        e(canvas2, f3 - 0.0f, f2 - 0.0f, width, height);
                    }
                    canvas2.drawPath(this.f2181d, paint);
                }
                i7++;
                z2 = z;
                i4 = 4;
            }
            boolean z6 = z2;
            float[] fArr4 = this.f2178a;
            if (fArr4.length > 1) {
                float f5 = fArr4[z6 ? 1 : 0];
                float f6 = fArr4[1];
                Paint paint2 = this.f2183f;
                canvas2.drawCircle(f5, f6, 8.0f, paint2);
                float[] fArr5 = this.f2178a;
                canvas2.drawCircle(fArr5[fArr5.length - 2], fArr5[fArr5.length - 1], 8.0f, paint2);
            }
        }

        public final void b(Canvas canvas) {
            float[] fArr = this.f2178a;
            float f2 = fArr[0];
            float f3 = fArr[1];
            float f4 = fArr[fArr.length - 2];
            float f5 = fArr[fArr.length - 1];
            float fMin = Math.min(f2, f4);
            float fMax = Math.max(f3, f5);
            float fMax2 = Math.max(f2, f4);
            float fMax3 = Math.max(f3, f5);
            Paint paint = this.f2184g;
            canvas.drawLine(fMin, fMax, fMax2, fMax3, paint);
            canvas.drawLine(Math.min(f2, f4), Math.min(f3, f5), Math.min(f2, f4), Math.max(f3, f5), paint);
        }

        public final void c(Canvas canvas, float f2, float f3) {
            float[] fArr = this.f2178a;
            float f4 = fArr[0];
            float f5 = fArr[1];
            float f6 = fArr[fArr.length - 2];
            float f7 = fArr[fArr.length - 1];
            float fMin = Math.min(f4, f6);
            float fMax = Math.max(f5, f7);
            float fMin2 = f2 - Math.min(f4, f6);
            float fMax2 = Math.max(f5, f7) - f3;
            String str = "" + (((int) (((fMin2 * 100.0f) / Math.abs(f6 - f4)) + 0.5d)) / 100.0f);
            Paint paint = this.f2185h;
            paint.getTextBounds(str, 0, str.length(), this.f2189l);
            Rect rect = this.f2189l;
            canvas.drawText(str, ((fMin2 / 2.0f) - (rect.width() / 2)) + fMin, f3 - 20.0f, paint);
            float fMin3 = Math.min(f4, f6);
            Paint paint2 = this.f2184g;
            canvas.drawLine(f2, f3, fMin3, f3, paint2);
            String str2 = "" + (((int) (((fMax2 * 100.0f) / Math.abs(f7 - f5)) + 0.5d)) / 100.0f);
            paint.getTextBounds(str2, 0, str2.length(), this.f2189l);
            canvas.drawText(str2, f2 + 5.0f, fMax - ((fMax2 / 2.0f) - (rect.height() / 2)), paint);
            canvas.drawLine(f2, f3, f2, Math.max(f5, f7), paint2);
        }

        public final void d(Canvas canvas, float f2, float f3) {
            float[] fArr = this.f2178a;
            float f4 = fArr[0];
            float f5 = fArr[1];
            float f6 = fArr[fArr.length - 2];
            float f7 = fArr[fArr.length - 1];
            float fHypot = (float) Math.hypot(f4 - f6, f5 - f7);
            float f8 = f6 - f4;
            float f9 = f7 - f5;
            float f10 = (((f3 - f5) * f9) + ((f2 - f4) * f8)) / (fHypot * fHypot);
            float f11 = (f8 * f10) + f4;
            float f12 = (f10 * f9) + f5;
            Path path = new Path();
            path.moveTo(f2, f3);
            path.lineTo(f11, f12);
            float fHypot2 = (float) Math.hypot(f11 - f2, f12 - f3);
            String str = "" + (((int) ((fHypot2 * 100.0f) / fHypot)) / 100.0f);
            Paint paint = this.f2185h;
            paint.getTextBounds(str, 0, str.length(), this.f2189l);
            canvas.drawTextOnPath(str, path, (fHypot2 / 2.0f) - (this.f2189l.width() / 2), -20.0f, paint);
            canvas.drawLine(f2, f3, f11, f12, this.f2184g);
        }

        public final void e(Canvas canvas, float f2, float f3, int i2, int i3) {
            StringBuilder sb = new StringBuilder("");
            MotionLayout motionLayout = MotionLayout.this;
            sb.append(((int) ((((f2 - (i2 / 2)) * 100.0f) / (motionLayout.getWidth() - i2)) + 0.5d)) / 100.0f);
            String string = sb.toString();
            Paint paint = this.f2185h;
            paint.getTextBounds(string, 0, string.length(), this.f2189l);
            Rect rect = this.f2189l;
            canvas.drawText(string, ((f2 / 2.0f) - (rect.width() / 2)) + 0.0f, f3 - 20.0f, paint);
            float fMin = Math.min(0.0f, 1.0f);
            Paint paint2 = this.f2184g;
            canvas.drawLine(f2, f3, fMin, f3, paint2);
            String str = "" + (((int) ((((f3 - (i3 / 2)) * 100.0f) / (motionLayout.getHeight() - i3)) + 0.5d)) / 100.0f);
            paint.getTextBounds(str, 0, str.length(), this.f2189l);
            canvas.drawText(str, f2 + 5.0f, 0.0f - ((f3 / 2.0f) - (rect.height() / 2)), paint);
            canvas.drawLine(f2, f3, f2, Math.max(0.0f, 1.0f), paint2);
        }
    }

    public class Model {

        /* renamed from: a, reason: collision with root package name */
        public ConstraintWidgetContainer f2191a = new ConstraintWidgetContainer();

        /* renamed from: b, reason: collision with root package name */
        public ConstraintWidgetContainer f2192b = new ConstraintWidgetContainer();

        /* renamed from: c, reason: collision with root package name */
        public ConstraintSet f2193c = null;

        /* renamed from: d, reason: collision with root package name */
        public ConstraintSet f2194d = null;

        /* renamed from: e, reason: collision with root package name */
        public int f2195e;

        /* renamed from: f, reason: collision with root package name */
        public int f2196f;

        public Model() {
        }

        public static void c(ConstraintWidgetContainer constraintWidgetContainer, ConstraintWidgetContainer constraintWidgetContainer2) {
            ArrayList arrayList = constraintWidgetContainer.u0;
            HashMap map = new HashMap();
            map.put(constraintWidgetContainer, constraintWidgetContainer2);
            constraintWidgetContainer2.u0.clear();
            constraintWidgetContainer2.j(constraintWidgetContainer, map);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ConstraintWidget constraintWidget = (ConstraintWidget) it.next();
                ConstraintWidget barrier = constraintWidget instanceof Barrier ? new Barrier() : constraintWidget instanceof Guideline ? new Guideline() : constraintWidget instanceof Flow ? new Flow() : constraintWidget instanceof Placeholder ? new Placeholder() : constraintWidget instanceof Helper ? new HelperWidget() : new ConstraintWidget();
                constraintWidgetContainer2.a(barrier);
                map.put(constraintWidget, barrier);
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ConstraintWidget constraintWidget2 = (ConstraintWidget) it2.next();
                ((ConstraintWidget) map.get(constraintWidget2)).j(constraintWidget2, map);
            }
        }

        public static ConstraintWidget d(ConstraintWidgetContainer constraintWidgetContainer, View view) {
            if (constraintWidgetContainer.h0 == view) {
                return constraintWidgetContainer;
            }
            ArrayList arrayList = constraintWidgetContainer.u0;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ConstraintWidget constraintWidget = (ConstraintWidget) arrayList.get(i2);
                if (constraintWidget.h0 == view) {
                    return constraintWidget;
                }
            }
            return null;
        }

        public final void a() throws Resources.NotFoundException {
            int i2;
            SparseArray sparseArray;
            int[] iArr;
            int i3;
            View view;
            Interpolator interpolatorLoadInterpolator;
            MotionLayout motionLayout = MotionLayout.this;
            int childCount = motionLayout.getChildCount();
            motionLayout.A.clear();
            SparseArray sparseArray2 = new SparseArray();
            int[] iArr2 = new int[childCount];
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = motionLayout.getChildAt(i4);
                MotionController motionController = new MotionController(childAt);
                int id = childAt.getId();
                iArr2[i4] = id;
                sparseArray2.put(id, motionController);
                motionLayout.A.put(childAt, motionController);
            }
            int i5 = 0;
            while (i5 < childCount) {
                View childAt2 = motionLayout.getChildAt(i5);
                MotionController motionController2 = (MotionController) motionLayout.A.get(childAt2);
                if (motionController2 == null) {
                    i2 = childCount;
                    sparseArray = sparseArray2;
                    iArr = iArr2;
                    i3 = i5;
                } else {
                    ConstraintSet constraintSet = this.f2193c;
                    MotionConstrainedPoint motionConstrainedPoint = motionController2.f2161h;
                    MotionPaths motionPaths = motionController2.f2159f;
                    if (constraintSet != null) {
                        ConstraintWidget constraintWidgetD = d(this.f2191a, childAt2);
                        if (constraintWidgetD != null) {
                            Rect rectQ = MotionLayout.q(motionLayout, constraintWidgetD);
                            ConstraintSet constraintSet2 = this.f2193c;
                            iArr = iArr2;
                            int width = motionLayout.getWidth();
                            i3 = i5;
                            int height = motionLayout.getHeight();
                            sparseArray = sparseArray2;
                            int i6 = constraintSet2.f2455d;
                            i2 = childCount;
                            if (i6 != 0) {
                                MotionController.k(rectQ, motionController2.f2154a, i6, width, height);
                            }
                            motionPaths.f2212c = 0.0f;
                            motionPaths.f2213d = 0.0f;
                            motionController2.j(motionPaths);
                            view = childAt2;
                            motionPaths.d(rectQ.left, rectQ.top, rectQ.width(), rectQ.height());
                            ConstraintSet.Constraint constraintI = constraintSet2.i(motionController2.f2156c);
                            motionPaths.a(constraintI);
                            ConstraintSet.Motion motion = constraintI.f2462d;
                            motionController2.f2165l = motion.f2498g;
                            motionConstrainedPoint.d(rectQ, constraintSet2, i6, motionController2.f2156c);
                            motionController2.C = constraintI.f2464f.f2518i;
                            motionController2.E = motion.f2501j;
                            motionController2.F = motion.f2500i;
                            Context context = motionController2.f2155b.getContext();
                            int i7 = motion.f2503l;
                            String str = motion.f2502k;
                            int i8 = motion.f2504m;
                            if (i7 == -2) {
                                interpolatorLoadInterpolator = AnimationUtils.loadInterpolator(context, i8);
                            } else if (i7 != -1) {
                                interpolatorLoadInterpolator = i7 != 0 ? i7 != 1 ? i7 != 2 ? i7 != 4 ? i7 != 5 ? null : new OvershootInterpolator() : new BounceInterpolator() : new android.view.animation.DecelerateInterpolator() : new AccelerateInterpolator() : new AccelerateDecelerateInterpolator();
                            } else {
                                final Easing easingC = Easing.c(str);
                                interpolatorLoadInterpolator = new Interpolator() { // from class: androidx.constraintlayout.motion.widget.MotionController.1
                                    public AnonymousClass1() {
                                    }

                                    @Override // android.animation.TimeInterpolator
                                    public final float getInterpolation(float f2) {
                                        return (float) easing.a(f2);
                                    }
                                };
                            }
                            motionController2.G = interpolatorLoadInterpolator;
                        } else {
                            i2 = childCount;
                            sparseArray = sparseArray2;
                            iArr = iArr2;
                            i3 = i5;
                            view = childAt2;
                            if (motionLayout.K != 0) {
                                Log.e("MotionLayout", Debug.b() + "no widget for  " + Debug.d(view) + " (" + view.getClass().getName() + ")");
                            }
                        }
                    } else {
                        i2 = childCount;
                        sparseArray = sparseArray2;
                        iArr = iArr2;
                        i3 = i5;
                        view = childAt2;
                    }
                    if (this.f2194d != null) {
                        View view2 = view;
                        ConstraintWidget constraintWidgetD2 = d(this.f2192b, view2);
                        if (constraintWidgetD2 != null) {
                            Rect rectQ2 = MotionLayout.q(motionLayout, constraintWidgetD2);
                            ConstraintSet constraintSet3 = this.f2194d;
                            int width2 = motionLayout.getWidth();
                            int height2 = motionLayout.getHeight();
                            int i9 = constraintSet3.f2455d;
                            if (i9 != 0) {
                                MotionController.k(rectQ2, motionController2.f2154a, i9, width2, height2);
                                rectQ2 = motionController2.f2154a;
                            }
                            MotionPaths motionPaths2 = motionController2.f2160g;
                            motionPaths2.f2212c = 1.0f;
                            motionPaths2.f2213d = 1.0f;
                            motionController2.j(motionPaths2);
                            motionPaths2.d(rectQ2.left, rectQ2.top, rectQ2.width(), rectQ2.height());
                            motionPaths2.a(constraintSet3.i(motionController2.f2156c));
                            motionController2.f2162i.d(rectQ2, constraintSet3, i9, motionController2.f2156c);
                        } else if (motionLayout.K != 0) {
                            Log.e("MotionLayout", Debug.b() + "no widget for  " + Debug.d(view2) + " (" + view2.getClass().getName() + ")");
                        }
                    }
                }
                i5 = i3 + 1;
                iArr2 = iArr;
                sparseArray2 = sparseArray;
                childCount = i2;
            }
            int[] iArr3 = iArr2;
            int i10 = childCount;
            int i11 = 0;
            while (true) {
                SparseArray sparseArray3 = sparseArray2;
                if (i11 >= i10) {
                    return;
                }
                sparseArray2 = sparseArray3;
                MotionController motionController3 = (MotionController) sparseArray2.get(iArr3[i11]);
                int i12 = motionController3.f2159f.f2220k;
                if (i12 != -1) {
                    MotionController motionController4 = (MotionController) sparseArray2.get(i12);
                    motionController3.f2159f.g(motionController4, motionController4.f2159f);
                    motionController3.f2160g.g(motionController4, motionController4.f2160g);
                }
                i11++;
            }
        }

        public final void b(int i2, int i3) {
            MotionLayout motionLayout = MotionLayout.this;
            int optimizationLevel = motionLayout.getOptimizationLevel();
            if (motionLayout.v == motionLayout.getStartState()) {
                ConstraintWidgetContainer constraintWidgetContainer = this.f2192b;
                ConstraintSet constraintSet = this.f2194d;
                motionLayout.l(constraintWidgetContainer, optimizationLevel, (constraintSet == null || constraintSet.f2455d == 0) ? i2 : i3, (constraintSet == null || constraintSet.f2455d == 0) ? i3 : i2);
                ConstraintSet constraintSet2 = this.f2193c;
                if (constraintSet2 != null) {
                    ConstraintWidgetContainer constraintWidgetContainer2 = this.f2191a;
                    int i4 = constraintSet2.f2455d;
                    int i5 = i4 == 0 ? i2 : i3;
                    if (i4 == 0) {
                        i2 = i3;
                    }
                    motionLayout.l(constraintWidgetContainer2, optimizationLevel, i5, i2);
                    return;
                }
                return;
            }
            ConstraintSet constraintSet3 = this.f2193c;
            if (constraintSet3 != null) {
                ConstraintWidgetContainer constraintWidgetContainer3 = this.f2191a;
                int i6 = constraintSet3.f2455d;
                motionLayout.l(constraintWidgetContainer3, optimizationLevel, i6 == 0 ? i2 : i3, i6 == 0 ? i3 : i2);
            }
            ConstraintWidgetContainer constraintWidgetContainer4 = this.f2192b;
            ConstraintSet constraintSet4 = this.f2194d;
            int i7 = (constraintSet4 == null || constraintSet4.f2455d == 0) ? i2 : i3;
            if (constraintSet4 == null || constraintSet4.f2455d == 0) {
                i2 = i3;
            }
            motionLayout.l(constraintWidgetContainer4, optimizationLevel, i7, i2);
        }

        public final void e(ConstraintSet constraintSet, ConstraintSet constraintSet2) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
            this.f2193c = constraintSet;
            this.f2194d = constraintSet2;
            this.f2191a = new ConstraintWidgetContainer();
            ConstraintWidgetContainer constraintWidgetContainer = new ConstraintWidgetContainer();
            this.f2192b = constraintWidgetContainer;
            ConstraintWidgetContainer constraintWidgetContainer2 = this.f2191a;
            boolean z = MotionLayout.o1;
            MotionLayout motionLayout = MotionLayout.this;
            ConstraintWidgetContainer constraintWidgetContainer3 = motionLayout.f2399c;
            BasicMeasure.Measurer measurer = constraintWidgetContainer3.y0;
            constraintWidgetContainer2.y0 = measurer;
            constraintWidgetContainer2.w0.f2004f = measurer;
            BasicMeasure.Measurer measurer2 = constraintWidgetContainer3.y0;
            constraintWidgetContainer.y0 = measurer2;
            constraintWidgetContainer.w0.f2004f = measurer2;
            constraintWidgetContainer2.u0.clear();
            this.f2192b.u0.clear();
            c(motionLayout.f2399c, this.f2191a);
            c(motionLayout.f2399c, this.f2192b);
            if (motionLayout.E > 0.5d) {
                if (constraintSet != null) {
                    g(this.f2191a, constraintSet);
                }
                g(this.f2192b, constraintSet2);
            } else {
                g(this.f2192b, constraintSet2);
                if (constraintSet != null) {
                    g(this.f2191a, constraintSet);
                }
            }
            this.f2191a.z0 = motionLayout.f();
            ConstraintWidgetContainer constraintWidgetContainer4 = this.f2191a;
            constraintWidgetContainer4.v0.c(constraintWidgetContainer4);
            this.f2192b.z0 = motionLayout.f();
            ConstraintWidgetContainer constraintWidgetContainer5 = this.f2192b;
            constraintWidgetContainer5.v0.c(constraintWidgetContainer5);
            ViewGroup.LayoutParams layoutParams = motionLayout.getLayoutParams();
            if (layoutParams != null) {
                int i2 = layoutParams.width;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.f1965b;
                if (i2 == -2) {
                    this.f2191a.Q(dimensionBehaviour);
                    this.f2192b.Q(dimensionBehaviour);
                }
                if (layoutParams.height == -2) {
                    this.f2191a.R(dimensionBehaviour);
                    this.f2192b.R(dimensionBehaviour);
                }
            }
        }

        public final void f() throws Resources.NotFoundException {
            ConstraintWidgetContainer constraintWidgetContainer;
            boolean z;
            HashMap map;
            MotionLayout motionLayout = MotionLayout.this;
            int i2 = motionLayout.x;
            int i3 = motionLayout.y;
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            motionLayout.Y0 = mode;
            motionLayout.Z0 = mode2;
            b(i2, i3);
            int i4 = 0;
            if (!(motionLayout.getParent() instanceof MotionLayout) || mode != 1073741824 || mode2 != 1073741824) {
                b(i2, i3);
                motionLayout.U0 = this.f2191a.u();
                motionLayout.V0 = this.f2191a.o();
                motionLayout.W0 = this.f2192b.u();
                int iO = this.f2192b.o();
                motionLayout.X0 = iO;
                motionLayout.T0 = (motionLayout.U0 == motionLayout.W0 && motionLayout.V0 == iO) ? false : true;
            }
            int i5 = motionLayout.U0;
            int i6 = motionLayout.V0;
            int i7 = motionLayout.Y0;
            if (i7 == Integer.MIN_VALUE || i7 == 0) {
                i5 = (int) ((motionLayout.a1 * (motionLayout.W0 - i5)) + i5);
            }
            int i8 = motionLayout.Z0;
            if (i8 == Integer.MIN_VALUE || i8 == 0) {
                i6 = (int) ((motionLayout.a1 * (motionLayout.X0 - i6)) + i6);
            }
            ConstraintWidgetContainer constraintWidgetContainer2 = this.f2191a;
            if (constraintWidgetContainer2.I0 || this.f2192b.I0) {
                constraintWidgetContainer = constraintWidgetContainer2;
                z = true;
            } else {
                constraintWidgetContainer = constraintWidgetContainer2;
                z = false;
            }
            motionLayout.h(i2, i3, i5, i6, z, constraintWidgetContainer.J0 || this.f2192b.J0);
            int childCount = motionLayout.getChildCount();
            motionLayout.i1.a();
            motionLayout.I = true;
            SparseArray sparseArray = new SparseArray();
            int i9 = 0;
            while (true) {
                map = motionLayout.A;
                if (i9 >= childCount) {
                    break;
                }
                View childAt = motionLayout.getChildAt(i9);
                sparseArray.put(childAt.getId(), (MotionController) map.get(childAt));
                i9++;
            }
            int width = motionLayout.getWidth();
            int height = motionLayout.getHeight();
            MotionScene.Transition transition = motionLayout.q.f2225c;
            int i10 = transition != null ? transition.p : -1;
            if (i10 != -1) {
                for (int i11 = 0; i11 < childCount; i11++) {
                    MotionController motionController = (MotionController) map.get(motionLayout.getChildAt(i11));
                    if (motionController != null) {
                        motionController.B = i10;
                    }
                }
            }
            SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
            int[] iArr = new int[map.size()];
            int i12 = 0;
            for (int i13 = 0; i13 < childCount; i13++) {
                MotionController motionController2 = (MotionController) map.get(motionLayout.getChildAt(i13));
                int i14 = motionController2.f2159f.f2220k;
                if (i14 != -1) {
                    sparseBooleanArray.put(i14, true);
                    iArr[i12] = motionController2.f2159f.f2220k;
                    i12++;
                }
            }
            if (motionLayout.M0 != null) {
                for (int i15 = 0; i15 < i12; i15++) {
                    MotionController motionController3 = (MotionController) map.get(motionLayout.findViewById(iArr[i15]));
                    if (motionController3 != null) {
                        motionLayout.q.f(motionController3);
                    }
                }
                Iterator it = motionLayout.M0.iterator();
                while (it.hasNext()) {
                    ((MotionHelper) it.next()).r(motionLayout, map);
                }
                for (int i16 = 0; i16 < i12; i16++) {
                    MotionController motionController4 = (MotionController) map.get(motionLayout.findViewById(iArr[i16]));
                    if (motionController4 != null) {
                        motionController4.l(width, height, motionLayout.getNanoTime());
                    }
                }
            } else {
                for (int i17 = 0; i17 < i12; i17++) {
                    MotionController motionController5 = (MotionController) map.get(motionLayout.findViewById(iArr[i17]));
                    if (motionController5 != null) {
                        motionLayout.q.f(motionController5);
                        motionController5.l(width, height, motionLayout.getNanoTime());
                    }
                }
            }
            for (int i18 = 0; i18 < childCount; i18++) {
                View childAt2 = motionLayout.getChildAt(i18);
                MotionController motionController6 = (MotionController) map.get(childAt2);
                if (!sparseBooleanArray.get(childAt2.getId()) && motionController6 != null) {
                    motionLayout.q.f(motionController6);
                    motionController6.l(width, height, motionLayout.getNanoTime());
                }
            }
            MotionScene.Transition transition2 = motionLayout.q.f2225c;
            float f2 = transition2 != null ? transition2.f2245i : 0.0f;
            if (f2 != 0.0f) {
                boolean z2 = ((double) f2) < 0.0d;
                float fAbs = Math.abs(f2);
                float fMax = -3.4028235E38f;
                float fMin = Float.MAX_VALUE;
                float fMax2 = -3.4028235E38f;
                float fMin2 = Float.MAX_VALUE;
                for (int i19 = 0; i19 < childCount; i19++) {
                    MotionController motionController7 = (MotionController) map.get(motionLayout.getChildAt(i19));
                    if (!Float.isNaN(motionController7.f2165l)) {
                        for (int i20 = 0; i20 < childCount; i20++) {
                            MotionController motionController8 = (MotionController) map.get(motionLayout.getChildAt(i20));
                            if (!Float.isNaN(motionController8.f2165l)) {
                                fMin = Math.min(fMin, motionController8.f2165l);
                                fMax = Math.max(fMax, motionController8.f2165l);
                            }
                        }
                        while (i4 < childCount) {
                            MotionController motionController9 = (MotionController) map.get(motionLayout.getChildAt(i4));
                            if (!Float.isNaN(motionController9.f2165l)) {
                                motionController9.n = 1.0f / (1.0f - fAbs);
                                if (z2) {
                                    motionController9.f2166m = fAbs - (((fMax - motionController9.f2165l) / (fMax - fMin)) * fAbs);
                                } else {
                                    motionController9.f2166m = fAbs - (((motionController9.f2165l - fMin) * fAbs) / (fMax - fMin));
                                }
                            }
                            i4++;
                        }
                        return;
                    }
                    MotionPaths motionPaths = motionController7.f2160g;
                    float f3 = motionPaths.f2214e;
                    float f4 = motionPaths.f2215f;
                    float f5 = z2 ? f4 - f3 : f4 + f3;
                    fMin2 = Math.min(fMin2, f5);
                    fMax2 = Math.max(fMax2, f5);
                }
                while (i4 < childCount) {
                    MotionController motionController10 = (MotionController) map.get(motionLayout.getChildAt(i4));
                    MotionPaths motionPaths2 = motionController10.f2160g;
                    float f6 = motionPaths2.f2214e;
                    float f7 = motionPaths2.f2215f;
                    float f8 = z2 ? f7 - f6 : f7 + f6;
                    motionController10.n = 1.0f / (1.0f - fAbs);
                    motionController10.f2166m = fAbs - (((f8 - fMin2) * fAbs) / (fMax2 - fMin2));
                    i4++;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void g(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
            ConstraintSet.Constraint constraint;
            ConstraintSet.Constraint constraint2;
            SparseArray sparseArray = new SparseArray();
            Constraints.LayoutParams layoutParams = new Constraints.LayoutParams();
            sparseArray.clear();
            sparseArray.put(0, constraintWidgetContainer);
            MotionLayout motionLayout = MotionLayout.this;
            sparseArray.put(motionLayout.getId(), constraintWidgetContainer);
            if (constraintSet != null && constraintSet.f2455d != 0) {
                ConstraintWidgetContainer constraintWidgetContainer2 = this.f2192b;
                int optimizationLevel = motionLayout.getOptimizationLevel();
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(motionLayout.getHeight(), 1073741824);
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(motionLayout.getWidth(), 1073741824);
                boolean z = MotionLayout.o1;
                motionLayout.l(constraintWidgetContainer2, optimizationLevel, iMakeMeasureSpec, iMakeMeasureSpec2);
            }
            Iterator it = constraintWidgetContainer.u0.iterator();
            while (it.hasNext()) {
                ConstraintWidget constraintWidget = (ConstraintWidget) it.next();
                constraintWidget.j0 = true;
                sparseArray.put(constraintWidget.h0.getId(), constraintWidget);
            }
            Iterator it2 = constraintWidgetContainer.u0.iterator();
            while (it2.hasNext()) {
                ConstraintWidget constraintWidget2 = (ConstraintWidget) it2.next();
                View view = constraintWidget2.h0;
                int id = view.getId();
                HashMap map = constraintSet.f2458g;
                if (map.containsKey(Integer.valueOf(id)) && (constraint2 = (ConstraintSet.Constraint) map.get(Integer.valueOf(id))) != null) {
                    constraint2.b(layoutParams);
                }
                constraintWidget2.S(constraintSet.i(view.getId()).f2463e.f2481c);
                constraintWidget2.P(constraintSet.i(view.getId()).f2463e.f2482d);
                if (view instanceof ConstraintHelper) {
                    ConstraintHelper constraintHelper = (ConstraintHelper) view;
                    int id2 = constraintHelper.getId();
                    HashMap map2 = constraintSet.f2458g;
                    if (map2.containsKey(Integer.valueOf(id2)) && (constraint = (ConstraintSet.Constraint) map2.get(Integer.valueOf(id2))) != null && (constraintWidget2 instanceof HelperWidget)) {
                        constraintHelper.l(constraint, (HelperWidget) constraintWidget2, layoutParams, sparseArray);
                    }
                    if (view instanceof androidx.constraintlayout.widget.Barrier) {
                        ((androidx.constraintlayout.widget.Barrier) view).q();
                    }
                }
                layoutParams.resolveLayoutDirection(motionLayout.getLayoutDirection());
                boolean z2 = MotionLayout.o1;
                motionLayout.a(false, view, constraintWidget2, layoutParams, sparseArray);
                if (constraintSet.i(view.getId()).f2461c.f2507c == 1) {
                    constraintWidget2.i0 = view.getVisibility();
                } else {
                    constraintWidget2.i0 = constraintSet.i(view.getId()).f2461c.f2506b;
                }
            }
            Iterator it3 = constraintWidgetContainer.u0.iterator();
            while (it3.hasNext()) {
                ConstraintWidget constraintWidget3 = (ConstraintWidget) it3.next();
                if (constraintWidget3 instanceof VirtualLayout) {
                    ConstraintHelper constraintHelper2 = (ConstraintHelper) constraintWidget3.h0;
                    Helper helper = (Helper) constraintWidget3;
                    constraintHelper2.p(helper, sparseArray);
                    VirtualLayout virtualLayout = (VirtualLayout) helper;
                    for (int i2 = 0; i2 < virtualLayout.v0; i2++) {
                        ConstraintWidget constraintWidget4 = virtualLayout.u0[i2];
                        if (constraintWidget4 != null) {
                            constraintWidget4.G = true;
                        }
                    }
                }
            }
        }
    }

    public interface MotionTracker {
    }

    public static class MyTracker implements MotionTracker {

        /* renamed from: b, reason: collision with root package name */
        public static final MyTracker f2198b = new MyTracker();

        /* renamed from: a, reason: collision with root package name */
        public VelocityTracker f2199a;
    }

    public class StateCache {

        /* renamed from: a, reason: collision with root package name */
        public float f2200a = Float.NaN;

        /* renamed from: b, reason: collision with root package name */
        public float f2201b = Float.NaN;

        /* renamed from: c, reason: collision with root package name */
        public int f2202c = -1;

        /* renamed from: d, reason: collision with root package name */
        public int f2203d = -1;

        public StateCache() {
        }

        public final void a() throws Exception {
            int i2 = this.f2202c;
            MotionLayout motionLayout = MotionLayout.this;
            if (i2 != -1 || this.f2203d != -1) {
                if (i2 == -1) {
                    int i3 = this.f2203d;
                    if (motionLayout.isAttachedToWindow()) {
                        motionLayout.I(i3, -1);
                    } else {
                        if (motionLayout.d1 == null) {
                            motionLayout.d1 = motionLayout.new StateCache();
                        }
                        motionLayout.d1.f2203d = i3;
                    }
                } else {
                    int i4 = this.f2203d;
                    if (i4 == -1) {
                        motionLayout.E(i2);
                    } else {
                        motionLayout.F(i2, i4);
                    }
                }
                motionLayout.setState(TransitionState.f2206b);
            }
            if (Float.isNaN(this.f2201b)) {
                if (Float.isNaN(this.f2200a)) {
                    return;
                }
                motionLayout.setProgress(this.f2200a);
                return;
            }
            float f2 = this.f2200a;
            float f3 = this.f2201b;
            if (motionLayout.isAttachedToWindow()) {
                motionLayout.setProgress(f2);
                motionLayout.setState(TransitionState.f2207c);
                motionLayout.t = f3;
                if (f3 != 0.0f) {
                    motionLayout.r(f3 > 0.0f ? 1.0f : 0.0f);
                } else if (f2 != 0.0f && f2 != 1.0f) {
                    motionLayout.r(f2 > 0.5f ? 1.0f : 0.0f);
                }
            } else {
                if (motionLayout.d1 == null) {
                    motionLayout.d1 = motionLayout.new StateCache();
                }
                StateCache stateCache = motionLayout.d1;
                stateCache.f2200a = f2;
                stateCache.f2201b = f3;
            }
            this.f2200a = Float.NaN;
            this.f2201b = Float.NaN;
            this.f2202c = -1;
            this.f2203d = -1;
        }
    }

    public interface TransitionListener {
        void a(int i2);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class TransitionState {

        /* renamed from: a, reason: collision with root package name */
        public static final TransitionState f2205a;

        /* renamed from: b, reason: collision with root package name */
        public static final TransitionState f2206b;

        /* renamed from: c, reason: collision with root package name */
        public static final TransitionState f2207c;

        /* renamed from: d, reason: collision with root package name */
        public static final TransitionState f2208d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ TransitionState[] f2209e;

        static {
            TransitionState transitionState = new TransitionState("UNDEFINED", 0);
            f2205a = transitionState;
            TransitionState transitionState2 = new TransitionState("SETUP", 1);
            f2206b = transitionState2;
            TransitionState transitionState3 = new TransitionState("MOVING", 2);
            f2207c = transitionState3;
            TransitionState transitionState4 = new TransitionState("FINISHED", 3);
            f2208d = transitionState4;
            f2209e = new TransitionState[]{transitionState, transitionState2, transitionState3, transitionState4};
        }

        public static TransitionState valueOf(String str) {
            return (TransitionState) Enum.valueOf(TransitionState.class, str);
        }

        public static TransitionState[] values() {
            return (TransitionState[]) f2209e.clone();
        }
    }

    public MotionLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        this.s = null;
        this.t = 0.0f;
        this.u = -1;
        this.v = -1;
        this.w = -1;
        this.x = 0;
        this.y = 0;
        this.z = true;
        this.A = new HashMap();
        this.B = 0L;
        this.C = 1.0f;
        this.D = 0.0f;
        this.E = 0.0f;
        this.G = 0.0f;
        this.I = false;
        this.K = 0;
        this.M = false;
        this.Q = new StopLogic();
        this.A0 = new DecelerateInterpolator();
        this.E0 = false;
        this.J0 = false;
        this.K0 = null;
        this.L0 = null;
        this.M0 = null;
        this.N0 = null;
        this.O0 = 0;
        this.P0 = -1L;
        this.Q0 = 0.0f;
        this.R0 = 0;
        this.S0 = 0.0f;
        this.T0 = false;
        this.b1 = new KeyCache();
        this.c1 = false;
        this.e1 = null;
        new HashMap();
        this.f1 = new Rect();
        this.g1 = false;
        this.h1 = TransitionState.f2205a;
        this.i1 = new Model();
        this.j1 = false;
        this.k1 = new RectF();
        this.l1 = null;
        this.m1 = null;
        this.n1 = new ArrayList();
        A(attributeSet);
    }

    public static Rect q(MotionLayout motionLayout, ConstraintWidget constraintWidget) {
        int iW = constraintWidget.w();
        Rect rect = motionLayout.f1;
        rect.top = iW;
        rect.left = constraintWidget.v();
        rect.right = constraintWidget.u() + rect.left;
        rect.bottom = constraintWidget.o() + rect.top;
        return rect;
    }

    public final void A(AttributeSet attributeSet) throws Resources.NotFoundException {
        MotionScene motionScene;
        o1 = isInEditMode();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MotionLayout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            boolean z = true;
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.MotionLayout_layoutDescription) {
                    this.q = new MotionScene(getContext(), this, typedArrayObtainStyledAttributes.getResourceId(index, -1));
                } else if (index == R.styleable.MotionLayout_currentState) {
                    this.v = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                } else if (index == R.styleable.MotionLayout_motionProgress) {
                    this.G = typedArrayObtainStyledAttributes.getFloat(index, 0.0f);
                    this.I = true;
                } else if (index == R.styleable.MotionLayout_applyMotionScene) {
                    z = typedArrayObtainStyledAttributes.getBoolean(index, z);
                } else if (index == R.styleable.MotionLayout_showPaths) {
                    if (this.K == 0) {
                        this.K = typedArrayObtainStyledAttributes.getBoolean(index, false) ? 2 : 0;
                    }
                } else if (index == R.styleable.MotionLayout_motionDebug) {
                    this.K = typedArrayObtainStyledAttributes.getInt(index, 0);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            if (this.q == null) {
                Log.e("MotionLayout", "WARNING NO app:layoutDescription tag");
            }
            if (!z) {
                this.q = null;
            }
        }
        if (this.K != 0) {
            MotionScene motionScene2 = this.q;
            if (motionScene2 == null) {
                Log.e("MotionLayout", "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            } else {
                int iH = motionScene2.h();
                MotionScene motionScene3 = this.q;
                ConstraintSet constraintSetB = motionScene3.b(motionScene3.h());
                String strC = Debug.c(iH, getContext());
                int childCount = getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = getChildAt(i3);
                    int id = childAt.getId();
                    if (id == -1) {
                        StringBuilder sbY = b.y("CHECK: ", strC, " ALL VIEWS SHOULD HAVE ID's ");
                        sbY.append(childAt.getClass().getName());
                        sbY.append(" does not!");
                        Log.w("MotionLayout", sbY.toString());
                    }
                    if (constraintSetB.j(id) == null) {
                        StringBuilder sbY2 = b.y("CHECK: ", strC, " NO CONSTRAINTS for ");
                        sbY2.append(Debug.d(childAt));
                        Log.w("MotionLayout", sbY2.toString());
                    }
                }
                Integer[] numArr = (Integer[]) constraintSetB.f2458g.keySet().toArray(new Integer[0]);
                int length = numArr.length;
                int[] iArr = new int[length];
                for (int i4 = 0; i4 < length; i4++) {
                    iArr[i4] = numArr[i4].intValue();
                }
                for (int i5 = 0; i5 < length; i5++) {
                    int i6 = iArr[i5];
                    String strC2 = Debug.c(i6, getContext());
                    if (findViewById(iArr[i5]) == null) {
                        Log.w("MotionLayout", "CHECK: " + strC + " NO View matches id " + strC2);
                    }
                    if (constraintSetB.i(i6).f2463e.f2482d == -1) {
                        Log.w("MotionLayout", b.m("CHECK: ", strC, "(", strC2, ") no LAYOUT_HEIGHT"));
                    }
                    if (constraintSetB.i(i6).f2463e.f2481c == -1) {
                        Log.w("MotionLayout", b.m("CHECK: ", strC, "(", strC2, ") no LAYOUT_HEIGHT"));
                    }
                }
                SparseIntArray sparseIntArray = new SparseIntArray();
                SparseIntArray sparseIntArray2 = new SparseIntArray();
                Iterator it = this.q.f2226d.iterator();
                while (it.hasNext()) {
                    MotionScene.Transition transition = (MotionScene.Transition) it.next();
                    if (transition == this.q.f2225c) {
                        Log.v("MotionLayout", "CHECK: CURRENT");
                    }
                    if (transition.f2240d == transition.f2239c) {
                        Log.e("MotionLayout", "CHECK: start and end constraint set should not be the same!");
                    }
                    int i7 = transition.f2240d;
                    int i8 = transition.f2239c;
                    String strC3 = Debug.c(i7, getContext());
                    String strC4 = Debug.c(i8, getContext());
                    if (sparseIntArray.get(i7) == i8) {
                        Log.e("MotionLayout", "CHECK: two transitions with the same start and end " + strC3 + "->" + strC4);
                    }
                    if (sparseIntArray2.get(i8) == i7) {
                        Log.e("MotionLayout", "CHECK: you can't have reverse transitions" + strC3 + "->" + strC4);
                    }
                    sparseIntArray.put(i7, i8);
                    sparseIntArray2.put(i8, i7);
                    if (this.q.b(i7) == null) {
                        Log.e("MotionLayout", " no such constraintSetStart " + strC3);
                    }
                    if (this.q.b(i8) == null) {
                        Log.e("MotionLayout", " no such constraintSetEnd " + strC3);
                    }
                }
            }
        }
        if (this.v != -1 || (motionScene = this.q) == null) {
            return;
        }
        this.v = motionScene.h();
        this.u = this.q.h();
        MotionScene.Transition transition2 = this.q.f2225c;
        this.w = transition2 != null ? transition2.f2239c : -1;
    }

    public final void B() {
        MotionScene.Transition transition;
        TouchResponse touchResponse;
        View viewFindViewById;
        MotionScene motionScene = this.q;
        if (motionScene == null) {
            return;
        }
        if (motionScene.a(this.v, this)) {
            requestLayout();
            return;
        }
        int i2 = this.v;
        if (i2 != -1) {
            MotionScene motionScene2 = this.q;
            ArrayList arrayList = motionScene2.f2226d;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                MotionScene.Transition transition2 = (MotionScene.Transition) it.next();
                if (transition2.f2249m.size() > 0) {
                    Iterator it2 = transition2.f2249m.iterator();
                    while (it2.hasNext()) {
                        ((MotionScene.Transition.TransitionOnClick) it2.next()).b(this);
                    }
                }
            }
            ArrayList arrayList2 = motionScene2.f2228f;
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                MotionScene.Transition transition3 = (MotionScene.Transition) it3.next();
                if (transition3.f2249m.size() > 0) {
                    Iterator it4 = transition3.f2249m.iterator();
                    while (it4.hasNext()) {
                        ((MotionScene.Transition.TransitionOnClick) it4.next()).b(this);
                    }
                }
            }
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                MotionScene.Transition transition4 = (MotionScene.Transition) it5.next();
                if (transition4.f2249m.size() > 0) {
                    Iterator it6 = transition4.f2249m.iterator();
                    while (it6.hasNext()) {
                        ((MotionScene.Transition.TransitionOnClick) it6.next()).a(this, i2, transition4);
                    }
                }
            }
            Iterator it7 = arrayList2.iterator();
            while (it7.hasNext()) {
                MotionScene.Transition transition5 = (MotionScene.Transition) it7.next();
                if (transition5.f2249m.size() > 0) {
                    Iterator it8 = transition5.f2249m.iterator();
                    while (it8.hasNext()) {
                        ((MotionScene.Transition.TransitionOnClick) it8.next()).a(this, i2, transition5);
                    }
                }
            }
        }
        if (!this.q.o() || (transition = this.q.f2225c) == null || (touchResponse = transition.f2248l) == null) {
            return;
        }
        int i3 = touchResponse.f2256d;
        if (i3 != -1) {
            MotionLayout motionLayout = touchResponse.r;
            viewFindViewById = motionLayout.findViewById(i3);
            if (viewFindViewById == null) {
                Log.e("TouchResponse", "cannot find TouchAnchorId @id/" + Debug.c(touchResponse.f2256d, motionLayout.getContext()));
            }
        } else {
            viewFindViewById = null;
        }
        if (viewFindViewById instanceof NestedScrollView) {
            NestedScrollView nestedScrollView = (NestedScrollView) viewFindViewById;
            nestedScrollView.setOnTouchListener(new TouchResponse.AnonymousClass1());
            nestedScrollView.setOnScrollChangeListener(new TouchResponse.AnonymousClass2());
        }
    }

    public final void C() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        if (this.J == null && ((copyOnWriteArrayList = this.N0) == null || copyOnWriteArrayList.isEmpty())) {
            return;
        }
        ArrayList arrayList = this.n1;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            TransitionListener transitionListener = this.J;
            if (transitionListener != null) {
                transitionListener.a(num.intValue());
            }
            CopyOnWriteArrayList copyOnWriteArrayList2 = this.N0;
            if (copyOnWriteArrayList2 != null) {
                Iterator it2 = copyOnWriteArrayList2.iterator();
                while (it2.hasNext()) {
                    ((TransitionListener) it2.next()).a(num.intValue());
                }
            }
        }
        arrayList.clear();
    }

    public final void D() throws Resources.NotFoundException {
        this.i1.f();
        invalidate();
    }

    public final void E(int i2) throws Exception {
        setState(TransitionState.f2206b);
        this.v = i2;
        this.u = -1;
        this.w = -1;
        ConstraintLayoutStates constraintLayoutStates = this.f2407k;
        if (constraintLayoutStates != null) {
            float f2 = -1;
            constraintLayoutStates.b(i2, f2, f2);
        } else {
            MotionScene motionScene = this.q;
            if (motionScene != null) {
                motionScene.b(i2).c(this);
            }
        }
    }

    public final void F(int i2, int i3) throws Exception {
        if (!isAttachedToWindow()) {
            if (this.d1 == null) {
                this.d1 = new StateCache();
            }
            StateCache stateCache = this.d1;
            stateCache.f2202c = i2;
            stateCache.f2203d = i3;
            return;
        }
        MotionScene motionScene = this.q;
        if (motionScene != null) {
            this.u = i2;
            this.w = i3;
            motionScene.n(i2, i3);
            this.i1.e(this.q.b(i2), this.q.b(i3));
            D();
            this.E = 0.0f;
            r(0.0f);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void G(int r14, float r15, float r16) {
        /*
            Method dump skipped, instructions count: 351
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.G(int, float, float):void");
    }

    public final void H(int i2, int i3) {
        if (isAttachedToWindow()) {
            I(i2, i3);
            return;
        }
        if (this.d1 == null) {
            this.d1 = new StateCache();
        }
        this.d1.f2203d = i2;
    }

    public final void I(int i2, int i3) throws Exception {
        StateSet stateSet;
        float f2;
        int iA;
        MotionScene motionScene = this.q;
        if (motionScene != null && (stateSet = motionScene.f2224b) != null && (iA = stateSet.a(-1, this.v, f2, i2)) != -1) {
            i2 = iA;
        }
        int i4 = this.v;
        if (i4 == i2) {
            return;
        }
        if (this.u == i2) {
            r(0.0f);
            if (i3 > 0) {
                this.C = i3 / 1000.0f;
                return;
            }
            return;
        }
        if (this.w == i2) {
            r(1.0f);
            if (i3 > 0) {
                this.C = i3 / 1000.0f;
                return;
            }
            return;
        }
        this.w = i2;
        if (i4 != -1) {
            F(i4, i2);
            r(1.0f);
            this.E = 0.0f;
            r(1.0f);
            this.e1 = null;
            if (i3 > 0) {
                this.C = i3 / 1000.0f;
                return;
            }
            return;
        }
        this.M = false;
        this.G = 1.0f;
        this.D = 0.0f;
        this.E = 0.0f;
        this.F = getNanoTime();
        this.B = getNanoTime();
        this.H = false;
        this.r = null;
        if (i3 == -1) {
            this.C = this.q.c() / 1000.0f;
        }
        this.u = -1;
        this.q.n(-1, this.w);
        SparseArray sparseArray = new SparseArray();
        if (i3 == 0) {
            this.C = this.q.c() / 1000.0f;
        } else if (i3 > 0) {
            this.C = i3 / 1000.0f;
        }
        int childCount = getChildCount();
        HashMap map = this.A;
        map.clear();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            map.put(childAt, new MotionController(childAt));
            sparseArray.put(childAt.getId(), (MotionController) map.get(childAt));
        }
        this.I = true;
        ConstraintSet constraintSetB = this.q.b(i2);
        Model model = this.i1;
        model.e(null, constraintSetB);
        D();
        model.a();
        int childCount2 = getChildCount();
        for (int i6 = 0; i6 < childCount2; i6++) {
            View childAt2 = getChildAt(i6);
            MotionController motionController = (MotionController) map.get(childAt2);
            if (motionController != null) {
                MotionPaths motionPaths = motionController.f2159f;
                motionPaths.f2212c = 0.0f;
                motionPaths.f2213d = 0.0f;
                motionPaths.d(childAt2.getX(), childAt2.getY(), childAt2.getWidth(), childAt2.getHeight());
                MotionConstrainedPoint motionConstrainedPoint = motionController.f2161h;
                motionConstrainedPoint.getClass();
                childAt2.getX();
                childAt2.getY();
                childAt2.getWidth();
                childAt2.getHeight();
                motionConstrainedPoint.b(childAt2);
            }
        }
        int width = getWidth();
        int height = getHeight();
        if (this.M0 != null) {
            for (int i7 = 0; i7 < childCount; i7++) {
                MotionController motionController2 = (MotionController) map.get(getChildAt(i7));
                if (motionController2 != null) {
                    this.q.f(motionController2);
                }
            }
            Iterator it = this.M0.iterator();
            while (it.hasNext()) {
                ((MotionHelper) it.next()).r(this, map);
            }
            for (int i8 = 0; i8 < childCount; i8++) {
                MotionController motionController3 = (MotionController) map.get(getChildAt(i8));
                if (motionController3 != null) {
                    motionController3.l(width, height, getNanoTime());
                }
            }
        } else {
            for (int i9 = 0; i9 < childCount; i9++) {
                MotionController motionController4 = (MotionController) map.get(getChildAt(i9));
                if (motionController4 != null) {
                    this.q.f(motionController4);
                    motionController4.l(width, height, getNanoTime());
                }
            }
        }
        MotionScene.Transition transition = this.q.f2225c;
        float f3 = transition != null ? transition.f2245i : 0.0f;
        if (f3 != 0.0f) {
            float fMin = Float.MAX_VALUE;
            float fMax = -3.4028235E38f;
            for (int i10 = 0; i10 < childCount; i10++) {
                MotionPaths motionPaths2 = ((MotionController) map.get(getChildAt(i10))).f2160g;
                float f4 = motionPaths2.f2215f + motionPaths2.f2214e;
                fMin = Math.min(fMin, f4);
                fMax = Math.max(fMax, f4);
            }
            for (int i11 = 0; i11 < childCount; i11++) {
                MotionController motionController5 = (MotionController) map.get(getChildAt(i11));
                MotionPaths motionPaths3 = motionController5.f2160g;
                float f5 = motionPaths3.f2214e;
                float f6 = motionPaths3.f2215f;
                motionController5.n = 1.0f / (1.0f - f3);
                motionController5.f2166m = f3 - ((((f5 + f6) - fMin) * f3) / (fMax - fMin));
            }
        }
        this.D = 0.0f;
        this.E = 0.0f;
        this.I = true;
        invalidate();
    }

    public final void J(int i2, ConstraintSet constraintSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        MotionScene motionScene = this.q;
        if (motionScene != null) {
            motionScene.f2229g.put(i2, constraintSet);
        }
        this.i1.e(this.q.b(this.u), this.q.b(this.w));
        D();
        if (this.v == i2) {
            constraintSet.c(this);
        }
    }

    public final void K(int i2, View... viewArr) {
        String str;
        MotionScene motionScene = this.q;
        if (motionScene == null) {
            Log.e("MotionLayout", " no motionScene");
            return;
        }
        ViewTransitionController viewTransitionController = motionScene.q;
        viewTransitionController.getClass();
        ArrayList arrayList = new ArrayList();
        Iterator it = viewTransitionController.f2294b.iterator();
        ViewTransition viewTransition = null;
        while (true) {
            boolean zHasNext = it.hasNext();
            str = viewTransitionController.f2296d;
            if (!zHasNext) {
                break;
            }
            ViewTransition viewTransition2 = (ViewTransition) it.next();
            if (viewTransition2.f2266a == i2) {
                for (View view : viewArr) {
                    if (viewTransition2.b(view)) {
                        arrayList.add(view);
                    }
                }
                if (arrayList.isEmpty()) {
                    viewTransition = viewTransition2;
                } else {
                    View[] viewArr2 = (View[]) arrayList.toArray(new View[0]);
                    MotionLayout motionLayout = viewTransitionController.f2293a;
                    int currentState = motionLayout.getCurrentState();
                    if (viewTransition2.f2270e != 2) {
                        if (currentState == -1) {
                            Log.w(str, "No support for ViewTransition within transition yet. Currently: " + motionLayout.toString());
                        } else {
                            MotionScene motionScene2 = motionLayout.q;
                            ConstraintSet constraintSetB = motionScene2 == null ? null : motionScene2.b(currentState);
                            if (constraintSetB != null) {
                                viewTransition = viewTransition2;
                                viewTransition.a(viewTransitionController, viewTransitionController.f2293a, currentState, constraintSetB, viewArr2);
                            }
                        }
                        viewTransition = viewTransition2;
                    } else {
                        viewTransition = viewTransition2;
                        viewTransition.a(viewTransitionController, viewTransitionController.f2293a, currentState, null, viewArr2);
                    }
                    arrayList.clear();
                }
            }
        }
        if (viewTransition == null) {
            Log.e(str, " Could not find ViewTransition");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x0320 A[PHI: r4
      0x0320: PHI (r4v23 float) = (r4v22 float), (r4v27 float) binds: [B:123:0x02fc, B:128:0x0309] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void dispatchDraw(android.graphics.Canvas r38) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 1361
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.dispatchDraw(android.graphics.Canvas):void");
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public final void g(int i2) {
        this.f2407k = null;
    }

    @IdRes
    public int[] getConstraintSetIds() {
        MotionScene motionScene = this.q;
        if (motionScene == null) {
            return null;
        }
        SparseArray sparseArray = motionScene.f2229g;
        int size = sparseArray.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = sparseArray.keyAt(i2);
        }
        return iArr;
    }

    public int getCurrentState() {
        return this.v;
    }

    public ArrayList<MotionScene.Transition> getDefinedTransitions() {
        MotionScene motionScene = this.q;
        if (motionScene == null) {
            return null;
        }
        return motionScene.f2226d;
    }

    public DesignTool getDesignTool() {
        if (this.B0 == null) {
            this.B0 = new DesignTool();
        }
        return this.B0;
    }

    public int getEndState() {
        return this.w;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.E;
    }

    public MotionScene getScene() {
        return this.q;
    }

    public int getStartState() {
        return this.u;
    }

    public float getTargetPosition() {
        return this.G;
    }

    public Bundle getTransitionState() {
        if (this.d1 == null) {
            this.d1 = new StateCache();
        }
        StateCache stateCache = this.d1;
        MotionLayout motionLayout = MotionLayout.this;
        stateCache.f2203d = motionLayout.w;
        stateCache.f2202c = motionLayout.u;
        stateCache.f2201b = motionLayout.getVelocity();
        stateCache.f2200a = motionLayout.getProgress();
        StateCache stateCache2 = this.d1;
        stateCache2.getClass();
        Bundle bundle = new Bundle();
        bundle.putFloat("motion.progress", stateCache2.f2200a);
        bundle.putFloat("motion.velocity", stateCache2.f2201b);
        bundle.putInt("motion.StartState", stateCache2.f2202c);
        bundle.putInt("motion.EndState", stateCache2.f2203d);
        return bundle;
    }

    public long getTransitionTimeMs() {
        if (this.q != null) {
            this.C = r0.c() / 1000.0f;
        }
        return (long) (this.C * 1000.0f);
    }

    public float getVelocity() {
        return this.t;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void i(int i2, View view) {
        TouchResponse touchResponse;
        int i3;
        MotionScene motionScene = this.q;
        if (motionScene != null) {
            float f2 = this.I0;
            if (f2 == 0.0f) {
                return;
            }
            float f3 = this.F0 / f2;
            float f4 = this.G0 / f2;
            MotionScene.Transition transition = motionScene.f2225c;
            if (transition == null || (touchResponse = transition.f2248l) == null) {
                return;
            }
            touchResponse.f2265m = false;
            MotionLayout motionLayout = touchResponse.r;
            float progress = motionLayout.getProgress();
            touchResponse.r.w(touchResponse.f2256d, progress, touchResponse.f2260h, touchResponse.f2259g, touchResponse.n);
            float f5 = touchResponse.f2263k;
            float[] fArr = touchResponse.n;
            float f6 = f5 != 0.0f ? (f3 * f5) / fArr[0] : (f4 * touchResponse.f2264l) / fArr[1];
            if (!Float.isNaN(f6)) {
                progress += f6 / 3.0f;
            }
            if (progress == 0.0f || progress == 1.0f || (i3 = touchResponse.f2255c) == 3) {
                return;
            }
            motionLayout.G(i3, ((double) progress) >= 0.5d ? 1.0f : 0.0f, f6);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void j(View view, View view2, int i2, int i3) {
        this.H0 = getNanoTime();
        this.I0 = 0.0f;
        this.F0 = 0.0f;
        this.G0 = 0.0f;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void k(View view, int i2, int i3, int[] iArr, int i4) throws Exception {
        MotionScene.Transition transition;
        boolean z;
        float f2;
        TouchResponse touchResponse;
        float f3;
        TouchResponse touchResponse2;
        TouchResponse touchResponse3;
        TouchResponse touchResponse4;
        int i5;
        MotionScene motionScene = this.q;
        if (motionScene == null || (transition = motionScene.f2225c) == null || (z = transition.o)) {
            return;
        }
        int i6 = -1;
        if (z || (touchResponse4 = transition.f2248l) == null || (i5 = touchResponse4.f2257e) == -1 || view.getId() == i5) {
            MotionScene.Transition transition2 = motionScene.f2225c;
            if ((transition2 == null || (touchResponse3 = transition2.f2248l) == null) ? false : touchResponse3.u) {
                TouchResponse touchResponse5 = transition.f2248l;
                if (touchResponse5 != null && (touchResponse5.w & 4) != 0) {
                    i6 = i3;
                }
                float f4 = this.D;
                if ((f4 == 1.0f || f4 == 0.0f) && view.canScrollVertically(i6)) {
                    return;
                }
            }
            TouchResponse touchResponse6 = transition.f2248l;
            if (touchResponse6 == null || (touchResponse6.w & 1) == 0) {
                f2 = 0.0f;
            } else {
                float f5 = i2;
                float f6 = i3;
                MotionScene.Transition transition3 = motionScene.f2225c;
                if (transition3 == null || (touchResponse2 = transition3.f2248l) == null) {
                    f2 = 0.0f;
                    f3 = 0.0f;
                } else {
                    f2 = 0.0f;
                    touchResponse2.r.w(touchResponse2.f2256d, touchResponse2.r.getProgress(), touchResponse2.f2260h, touchResponse2.f2259g, touchResponse2.n);
                    float f7 = touchResponse2.f2263k;
                    float[] fArr = touchResponse2.n;
                    if (f7 != 0.0f) {
                        if (fArr[0] == 0.0f) {
                            fArr[0] = 1.0E-7f;
                        }
                        f3 = (f5 * f7) / fArr[0];
                    } else {
                        if (fArr[1] == 0.0f) {
                            fArr[1] = 1.0E-7f;
                        }
                        f3 = (f6 * touchResponse2.f2264l) / fArr[1];
                    }
                }
                float f8 = this.E;
                if ((f8 <= f2 && f3 < f2) || (f8 >= 1.0f && f3 > f2)) {
                    view.setNestedScrollingEnabled(false);
                    final ViewGroup viewGroup = (ViewGroup) view;
                    view.post(new Runnable() { // from class: androidx.constraintlayout.motion.widget.MotionLayout.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            viewGroup.setNestedScrollingEnabled(true);
                        }
                    });
                    return;
                }
            }
            float f9 = this.D;
            long nanoTime = getNanoTime();
            float f10 = i2;
            this.F0 = f10;
            float f11 = i3;
            this.G0 = f11;
            this.I0 = (float) ((nanoTime - this.H0) * 1.0E-9d);
            this.H0 = nanoTime;
            MotionScene.Transition transition4 = motionScene.f2225c;
            if (transition4 != null && (touchResponse = transition4.f2248l) != null) {
                MotionLayout motionLayout = touchResponse.r;
                float progress = motionLayout.getProgress();
                if (!touchResponse.f2265m) {
                    touchResponse.f2265m = true;
                    motionLayout.setProgress(progress);
                }
                touchResponse.r.w(touchResponse.f2256d, progress, touchResponse.f2260h, touchResponse.f2259g, touchResponse.n);
                float f12 = touchResponse.f2263k;
                float[] fArr2 = touchResponse.n;
                if (Math.abs((touchResponse.f2264l * fArr2[1]) + (f12 * fArr2[0])) < 0.01d) {
                    fArr2[0] = 0.01f;
                    fArr2[1] = 0.01f;
                }
                float f13 = touchResponse.f2263k;
                float fMax = Math.max(Math.min(progress + (f13 != f2 ? (f10 * f13) / fArr2[0] : (f11 * touchResponse.f2264l) / fArr2[1]), 1.0f), f2);
                if (fMax != motionLayout.getProgress()) {
                    motionLayout.setProgress(fMax);
                }
            }
            if (f9 != this.D) {
                iArr[0] = i2;
                iArr[1] = i3;
            }
            t(false);
            if (iArr[0] == 0 && iArr[1] == 0) {
                return;
            }
            this.E0 = true;
        }
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public final void m(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        if (this.E0 || i2 != 0 || i3 != 0) {
            iArr[0] = iArr[0] + i4;
            iArr[1] = iArr[1] + i5;
        }
        this.E0 = false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void n(View view, int i2, int i3, int i4, int i5, int i6) {
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean o(View view, View view2, int i2, int i3) {
        MotionScene.Transition transition;
        TouchResponse touchResponse;
        MotionScene motionScene = this.q;
        return (motionScene == null || (transition = motionScene.f2225c) == null || (touchResponse = transition.f2248l) == null || (touchResponse.w & 2) != 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() throws Exception {
        MotionScene.Transition transition;
        int i2;
        super.onAttachedToWindow();
        Display display = getDisplay();
        if (display != null) {
            display.getRotation();
        }
        MotionScene motionScene = this.q;
        if (motionScene != null && (i2 = this.v) != -1) {
            ConstraintSet constraintSetB = motionScene.b(i2);
            MotionScene motionScene2 = this.q;
            int i3 = 0;
            loop0: while (true) {
                SparseArray sparseArray = motionScene2.f2229g;
                if (i3 >= sparseArray.size()) {
                    break;
                }
                int iKeyAt = sparseArray.keyAt(i3);
                SparseIntArray sparseIntArray = motionScene2.f2231i;
                int i4 = sparseIntArray.get(iKeyAt);
                int size = sparseIntArray.size();
                while (i4 > 0) {
                    if (i4 == iKeyAt) {
                        break loop0;
                    }
                    int i5 = size - 1;
                    if (size < 0) {
                        break loop0;
                    }
                    i4 = sparseIntArray.get(i4);
                    size = i5;
                }
                motionScene2.m(iKeyAt, this);
                i3++;
            }
            Log.e("MotionScene", "Cannot be derived from yourself");
            ArrayList arrayList = this.M0;
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((MotionHelper) it.next()).getClass();
                }
            }
            if (constraintSetB != null) {
                constraintSetB.c(this);
            }
            this.u = this.v;
        }
        B();
        StateCache stateCache = this.d1;
        if (stateCache != null) {
            if (this.g1) {
                post(new Runnable() { // from class: androidx.constraintlayout.motion.widget.MotionLayout.4
                    @Override // java.lang.Runnable
                    public final void run() throws Exception {
                        MotionLayout.this.d1.a();
                    }
                });
                return;
            } else {
                stateCache.a();
                return;
            }
        }
        MotionScene motionScene3 = this.q;
        if (motionScene3 == null || (transition = motionScene3.f2225c) == null || transition.n != 4) {
            return;
        }
        r(1.0f);
        this.e1 = null;
        setState(TransitionState.f2206b);
        setState(TransitionState.f2207c);
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x00f6  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 428
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) throws Throwable {
        MotionLayout motionLayout;
        this.c1 = true;
        try {
            if (this.q == null) {
                super.onLayout(z, i2, i3, i4, i5);
                this.c1 = false;
                return;
            }
            motionLayout = this;
            int i6 = i4 - i2;
            int i7 = i5 - i3;
            try {
                if (motionLayout.C0 != i6 || motionLayout.D0 != i7) {
                    D();
                    t(true);
                }
                motionLayout.C0 = i6;
                motionLayout.D0 = i7;
                motionLayout.c1 = false;
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                motionLayout.c1 = false;
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            motionLayout = this;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int i2, int i3) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        boolean z;
        if (this.q == null) {
            super.onMeasure(i2, i3);
            return;
        }
        boolean z2 = true;
        boolean z3 = (this.x == i2 && this.y == i3) ? false : true;
        if (this.j1) {
            this.j1 = false;
            B();
            C();
            z3 = true;
        }
        if (this.f2404h) {
            z3 = true;
        }
        this.x = i2;
        this.y = i3;
        int iH = this.q.h();
        MotionScene.Transition transition = this.q.f2225c;
        int i4 = transition == null ? -1 : transition.f2239c;
        ConstraintWidgetContainer constraintWidgetContainer = this.f2399c;
        Model model = this.i1;
        if ((!z3 && iH == model.f2195e && i4 == model.f2196f) || this.u == -1) {
            if (z3) {
                super.onMeasure(i2, i3);
            }
            z = true;
        } else {
            super.onMeasure(i2, i3);
            model.e(this.q.b(iH), this.q.b(i4));
            model.f();
            model.f2195e = iH;
            model.f2196f = i4;
            z = false;
        }
        if (this.T0 || z) {
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            int iU = constraintWidgetContainer.u() + getPaddingRight() + getPaddingLeft();
            int iO = constraintWidgetContainer.o() + paddingBottom;
            int i5 = this.Y0;
            if (i5 == Integer.MIN_VALUE || i5 == 0) {
                iU = (int) ((this.a1 * (this.W0 - r1)) + this.U0);
                requestLayout();
            }
            int i6 = this.Z0;
            if (i6 == Integer.MIN_VALUE || i6 == 0) {
                iO = (int) ((this.a1 * (this.X0 - r2)) + this.V0);
                requestLayout();
            }
            setMeasuredDimension(iU, iO);
        }
        float fSignum = Math.signum(this.G - this.E);
        long nanoTime = getNanoTime();
        MotionInterpolator motionInterpolator = this.r;
        float interpolation = this.E + (!(motionInterpolator instanceof StopLogic) ? (((nanoTime - this.F) * fSignum) * 1.0E-9f) / this.C : 0.0f);
        if (this.H) {
            interpolation = this.G;
        }
        if ((fSignum <= 0.0f || interpolation < this.G) && (fSignum > 0.0f || interpolation > this.G)) {
            z2 = false;
        } else {
            interpolation = this.G;
        }
        if (motionInterpolator != null && !z2) {
            interpolation = this.M ? motionInterpolator.getInterpolation((nanoTime - this.B) * 1.0E-9f) : motionInterpolator.getInterpolation(interpolation);
        }
        if ((fSignum > 0.0f && interpolation >= this.G) || (fSignum <= 0.0f && interpolation <= this.G)) {
            interpolation = this.G;
        }
        this.a1 = interpolation;
        int childCount = getChildCount();
        long nanoTime2 = getNanoTime();
        Interpolator interpolator = this.s;
        if (interpolator != null) {
            interpolation = interpolator.getInterpolation(interpolation);
        }
        float f2 = interpolation;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            MotionController motionController = (MotionController) this.A.get(childAt);
            if (motionController != null) {
                motionController.i(f2, nanoTime2, childAt, this.b1);
            }
        }
        if (this.T0) {
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f2, float f3, boolean z) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i2) {
        TouchResponse touchResponse;
        MotionScene motionScene = this.q;
        if (motionScene != null) {
            boolean zF = f();
            motionScene.p = zF;
            MotionScene.Transition transition = motionScene.f2225c;
            if (transition == null || (touchResponse = transition.f2248l) == null) {
                return;
            }
            touchResponse.c(zF);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x04ce  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x04f2  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0510  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x051f  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0581  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x058f  */
    /* JADX WARN: Type inference failed for: r18v15 */
    /* JADX WARN: Type inference failed for: r18v24 */
    /* JADX WARN: Type inference failed for: r18v25 */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r37) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 2046
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.N0 == null) {
                this.N0 = new CopyOnWriteArrayList();
            }
            this.N0.add(motionHelper);
            if (motionHelper.f2168j) {
                if (this.K0 == null) {
                    this.K0 = new ArrayList();
                }
                this.K0.add(motionHelper);
            }
            if (motionHelper.f2169k) {
                if (this.L0 == null) {
                    this.L0 = new ArrayList();
                }
                this.L0.add(motionHelper);
            }
            if (motionHelper instanceof MotionEffect) {
                if (this.M0 == null) {
                    this.M0 = new ArrayList();
                }
                this.M0.add(motionHelper);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList arrayList = this.K0;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList arrayList2 = this.L0;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    public final void r(float f2) throws Exception {
        if (this.q == null) {
            return;
        }
        float f3 = this.E;
        float f4 = this.D;
        if (f3 != f4 && this.H) {
            this.E = f4;
        }
        float f5 = this.E;
        if (f5 == f2) {
            return;
        }
        this.M = false;
        this.G = f2;
        this.C = r0.c() / 1000.0f;
        setProgress(this.G);
        this.r = null;
        this.s = this.q.e();
        this.H = false;
        this.B = getNanoTime();
        this.I = true;
        this.D = f5;
        this.E = f5;
        invalidate();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public final void requestLayout() {
        MotionScene motionScene;
        MotionScene.Transition transition;
        if (!this.T0 && this.v == -1 && (motionScene = this.q) != null && (transition = motionScene.f2225c) != null) {
            int i2 = transition.q;
            if (i2 == 0) {
                return;
            }
            if (i2 == 2) {
                int childCount = getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    ((MotionController) this.A.get(getChildAt(i3))).f2157d = true;
                }
                return;
            }
        }
        super.requestLayout();
    }

    public final void s(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            MotionController motionController = (MotionController) this.A.get(getChildAt(i2));
            if (motionController != null && "button".equals(Debug.d(motionController.f2155b)) && motionController.A != null) {
                int i3 = 0;
                while (true) {
                    KeyTrigger[] keyTriggerArr = motionController.A;
                    if (i3 < keyTriggerArr.length) {
                        keyTriggerArr[i3].h(motionController.f2155b, z ? -100.0f : 100.0f);
                        i3++;
                    }
                }
            }
        }
    }

    public void setDebugMode(int i2) {
        this.K = i2;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean z) {
        this.g1 = z;
    }

    public void setInteractionEnabled(boolean z) {
        this.z = z;
    }

    public void setInterpolatedProgress(float f2) throws Exception {
        if (this.q != null) {
            setState(TransitionState.f2207c);
            Interpolator interpolatorE = this.q.e();
            if (interpolatorE != null) {
                setProgress(interpolatorE.getInterpolation(f2));
                return;
            }
        }
        setProgress(f2);
    }

    public void setOnHide(float f2) {
        ArrayList arrayList = this.L0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((MotionHelper) this.L0.get(i2)).setProgress(f2);
            }
        }
    }

    public void setOnShow(float f2) {
        ArrayList arrayList = this.K0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((MotionHelper) this.K0.get(i2)).setProgress(f2);
            }
        }
    }

    public void setProgress(float f2) throws Exception {
        if (f2 < 0.0f || f2 > 1.0f) {
            Log.w("MotionLayout", "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if (!isAttachedToWindow()) {
            if (this.d1 == null) {
                this.d1 = new StateCache();
            }
            this.d1.f2200a = f2;
            return;
        }
        TransitionState transitionState = TransitionState.f2208d;
        TransitionState transitionState2 = TransitionState.f2207c;
        if (f2 <= 0.0f) {
            if (this.E == 1.0f && this.v == this.w) {
                setState(transitionState2);
            }
            this.v = this.u;
            if (this.E == 0.0f) {
                setState(transitionState);
            }
        } else if (f2 >= 1.0f) {
            if (this.E == 0.0f && this.v == this.u) {
                setState(transitionState2);
            }
            this.v = this.w;
            if (this.E == 1.0f) {
                setState(transitionState);
            }
        } else {
            this.v = -1;
            setState(transitionState2);
        }
        if (this.q == null) {
            return;
        }
        this.H = true;
        this.G = f2;
        this.D = f2;
        this.F = -1L;
        this.B = -1L;
        this.r = null;
        this.I = true;
        invalidate();
    }

    public void setScene(MotionScene motionScene) throws Resources.NotFoundException {
        TouchResponse touchResponse;
        this.q = motionScene;
        boolean zF = f();
        motionScene.p = zF;
        MotionScene.Transition transition = motionScene.f2225c;
        if (transition != null && (touchResponse = transition.f2248l) != null) {
            touchResponse.c(zF);
        }
        D();
    }

    public void setStartState(int i2) {
        if (isAttachedToWindow()) {
            this.v = i2;
            return;
        }
        if (this.d1 == null) {
            this.d1 = new StateCache();
        }
        StateCache stateCache = this.d1;
        stateCache.f2202c = i2;
        stateCache.f2203d = i2;
    }

    public void setState(TransitionState transitionState) throws Exception {
        TransitionState transitionState2 = TransitionState.f2208d;
        if (transitionState == transitionState2 && this.v == -1) {
            return;
        }
        TransitionState transitionState3 = this.h1;
        this.h1 = transitionState;
        TransitionState transitionState4 = TransitionState.f2207c;
        if (transitionState3 == transitionState4 && transitionState == transitionState4) {
            u();
        }
        int iOrdinal = transitionState3.ordinal();
        if (iOrdinal != 0 && iOrdinal != 1) {
            if (iOrdinal == 2 && transitionState == transitionState2) {
                v();
                return;
            }
            return;
        }
        if (transitionState == transitionState4) {
            u();
        }
        if (transitionState == transitionState2) {
            v();
        }
    }

    public void setTransition(int i2) throws Exception {
        if (this.q != null) {
            MotionScene.Transition transitionX = x(i2);
            this.u = transitionX.f2240d;
            this.w = transitionX.f2239c;
            if (!isAttachedToWindow()) {
                if (this.d1 == null) {
                    this.d1 = new StateCache();
                }
                StateCache stateCache = this.d1;
                stateCache.f2202c = this.u;
                stateCache.f2203d = this.w;
                return;
            }
            int i3 = this.v;
            float f2 = i3 == this.u ? 0.0f : i3 == this.w ? 1.0f : Float.NaN;
            MotionScene motionScene = this.q;
            motionScene.f2225c = transitionX;
            TouchResponse touchResponse = transitionX.f2248l;
            if (touchResponse != null) {
                touchResponse.c(motionScene.p);
            }
            this.i1.e(this.q.b(this.u), this.q.b(this.w));
            D();
            if (this.E != f2) {
                if (f2 == 0.0f) {
                    s(true);
                    this.q.b(this.u).c(this);
                } else if (f2 == 1.0f) {
                    s(false);
                    this.q.b(this.w).c(this);
                }
            }
            this.E = Float.isNaN(f2) ? 0.0f : f2;
            if (!Float.isNaN(f2)) {
                setProgress(f2);
                return;
            }
            Log.v("MotionLayout", Debug.b() + " transitionToStart ");
            r(0.0f);
        }
    }

    public void setTransitionDuration(int i2) {
        MotionScene motionScene = this.q;
        if (motionScene == null) {
            Log.e("MotionLayout", "MotionScene not defined");
            return;
        }
        MotionScene.Transition transition = motionScene.f2225c;
        if (transition != null) {
            transition.f2244h = Math.max(i2, 8);
        } else {
            motionScene.f2232j = i2;
        }
    }

    public void setTransitionListener(TransitionListener transitionListener) {
        this.J = transitionListener;
    }

    public void setTransitionState(Bundle bundle) throws Exception {
        if (this.d1 == null) {
            this.d1 = new StateCache();
        }
        StateCache stateCache = this.d1;
        stateCache.getClass();
        stateCache.f2200a = bundle.getFloat("motion.progress");
        stateCache.f2201b = bundle.getFloat("motion.velocity");
        stateCache.f2202c = bundle.getInt("motion.StartState");
        stateCache.f2203d = bundle.getInt("motion.EndState");
        if (isAttachedToWindow()) {
            this.d1.a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00e0 A[PHI: r3
      0x00e0: PHI (r3v13 float) = (r3v12 float), (r3v14 float), (r3v14 float) binds: [B:49:0x00ae, B:60:0x00d4, B:62:0x00d8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0169  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(boolean r22) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 612
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.t(boolean):void");
    }

    @Override // android.view.View
    public final String toString() {
        Context context = getContext();
        return Debug.c(this.u, context) + "->" + Debug.c(this.w, context) + " (pos:" + this.E + " Dpos/Dt:" + this.t;
    }

    public final void u() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        CopyOnWriteArrayList copyOnWriteArrayList2;
        if ((this.J == null && ((copyOnWriteArrayList2 = this.N0) == null || copyOnWriteArrayList2.isEmpty())) || this.S0 == this.D) {
            return;
        }
        if (this.R0 != -1 && (copyOnWriteArrayList = this.N0) != null) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ((TransitionListener) it.next()).getClass();
            }
        }
        this.R0 = -1;
        this.S0 = this.D;
        CopyOnWriteArrayList copyOnWriteArrayList3 = this.N0;
        if (copyOnWriteArrayList3 != null) {
            Iterator it2 = copyOnWriteArrayList3.iterator();
            while (it2.hasNext()) {
                ((TransitionListener) it2.next()).getClass();
            }
        }
    }

    public final void v() throws Exception {
        CopyOnWriteArrayList copyOnWriteArrayList;
        if ((this.J != null || ((copyOnWriteArrayList = this.N0) != null && !copyOnWriteArrayList.isEmpty())) && this.R0 == -1) {
            this.R0 = this.v;
            ArrayList arrayList = this.n1;
            int iIntValue = !arrayList.isEmpty() ? ((Integer) b.c(1, arrayList)).intValue() : -1;
            int i2 = this.v;
            if (iIntValue != i2 && i2 != -1) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        C();
        a aVar = this.e1;
        if (aVar != null) {
            aVar.run();
            this.e1 = null;
        }
    }

    public final void w(int i2, float f2, float f3, float f4, float[] fArr) {
        View viewC = c(i2);
        MotionController motionController = (MotionController) this.A.get(viewC);
        if (motionController == null) {
            b.A("WARNING could not find view id ", viewC == null ? b.f(i2, "") : viewC.getContext().getResources().getResourceName(i2), "MotionLayout");
        } else {
            motionController.d(f2, f3, f4, fArr);
            viewC.getY();
        }
    }

    public final MotionScene.Transition x(int i2) {
        Iterator it = this.q.f2226d.iterator();
        while (it.hasNext()) {
            MotionScene.Transition transition = (MotionScene.Transition) it.next();
            if (transition.f2237a == i2) {
                return transition;
            }
        }
        return null;
    }

    public final void y(MotionTelltales motionTelltales, float f2, float f3, float[] fArr, int i2) {
        float[] fArr2;
        float f4;
        char c2;
        char c3;
        ViewOscillator viewOscillator;
        float[] fArr3;
        SplineSet splineSet;
        float[] fArr4;
        ViewOscillator viewOscillator2;
        double[] dArr;
        float fA = this.t;
        float f5 = this.E;
        if (this.r != null) {
            float fSignum = Math.signum(this.G - f5);
            float interpolation = this.r.getInterpolation(this.E + 1.0E-5f);
            float interpolation2 = this.r.getInterpolation(this.E);
            fA = (((interpolation - interpolation2) / 1.0E-5f) * fSignum) / this.C;
            f5 = interpolation2;
        }
        MotionInterpolator motionInterpolator = this.r;
        if (motionInterpolator != null) {
            fA = motionInterpolator.a();
        }
        float f6 = fA;
        MotionController motionController = (MotionController) this.A.get(motionTelltales);
        if ((i2 & 1) == 0) {
            int width = motionTelltales.getWidth();
            int height = motionTelltales.getHeight();
            float[] fArr5 = motionController.v;
            float fB = motionController.b(fArr5, f5);
            HashMap map = motionController.y;
            SplineSet splineSet2 = map == null ? null : (SplineSet) map.get("translationX");
            HashMap map2 = motionController.y;
            SplineSet splineSet3 = map2 == null ? null : (SplineSet) map2.get("translationY");
            HashMap map3 = motionController.y;
            SplineSet splineSet4 = map3 == null ? null : (SplineSet) map3.get("rotation");
            c2 = 1;
            HashMap map4 = motionController.y;
            c3 = 0;
            SplineSet splineSet5 = map4 == null ? null : (SplineSet) map4.get("scaleX");
            HashMap map5 = motionController.y;
            f4 = f6;
            SplineSet splineSet6 = map5 == null ? null : (SplineSet) map5.get("scaleY");
            HashMap map6 = motionController.z;
            ViewOscillator viewOscillator3 = map6 == null ? null : (ViewOscillator) map6.get("translationX");
            HashMap map7 = motionController.z;
            ViewOscillator viewOscillator4 = map7 == null ? null : (ViewOscillator) map7.get("translationY");
            HashMap map8 = motionController.z;
            ViewOscillator viewOscillator5 = map8 == null ? null : (ViewOscillator) map8.get("rotation");
            HashMap map9 = motionController.z;
            ViewOscillator viewOscillator6 = map9 == null ? null : (ViewOscillator) map9.get("scaleX");
            HashMap map10 = motionController.z;
            ViewOscillator viewOscillator7 = map10 == null ? null : (ViewOscillator) map10.get("scaleY");
            VelocityMatrix velocityMatrix = new VelocityMatrix();
            velocityMatrix.f1898e = 0.0f;
            velocityMatrix.f1897d = 0.0f;
            velocityMatrix.f1896c = 0.0f;
            velocityMatrix.f1895b = 0.0f;
            velocityMatrix.f1894a = 0.0f;
            if (splineSet4 != null) {
                viewOscillator = viewOscillator7;
                velocityMatrix.f1898e = (float) splineSet4.f1854a.e(fB);
                velocityMatrix.f1899f = splineSet4.a(fB);
            } else {
                viewOscillator = viewOscillator7;
            }
            if (splineSet2 != null) {
                fArr3 = fArr5;
                splineSet = splineSet2;
                velocityMatrix.f1896c = (float) splineSet2.f1854a.e(fB);
            } else {
                fArr3 = fArr5;
                splineSet = splineSet2;
            }
            if (splineSet3 != null) {
                fArr4 = fArr3;
                velocityMatrix.f1897d = (float) splineSet3.f1854a.e(fB);
            } else {
                fArr4 = fArr3;
            }
            if (splineSet5 != null) {
                velocityMatrix.f1894a = (float) splineSet5.f1854a.e(fB);
            }
            if (splineSet6 != null) {
                velocityMatrix.f1895b = (float) splineSet6.f1854a.e(fB);
            }
            if (viewOscillator5 != null) {
                velocityMatrix.f1898e = viewOscillator5.b(fB);
            }
            if (viewOscillator3 != null) {
                velocityMatrix.f1896c = viewOscillator3.b(fB);
            }
            if (viewOscillator4 != null) {
                velocityMatrix.f1897d = viewOscillator4.b(fB);
            }
            if (viewOscillator6 != null) {
                velocityMatrix.f1894a = viewOscillator6.b(fB);
            }
            if (viewOscillator != null) {
                viewOscillator2 = viewOscillator;
                velocityMatrix.f1895b = viewOscillator2.b(fB);
            } else {
                viewOscillator2 = viewOscillator;
            }
            ArcCurveFit arcCurveFit = motionController.f2164k;
            if (arcCurveFit != null) {
                double[] dArr2 = motionController.p;
                if (dArr2.length > 0) {
                    double d2 = fB;
                    arcCurveFit.d(dArr2, d2);
                    motionController.f2164k.f(motionController.q, d2);
                    int[] iArr = motionController.o;
                    double[] dArr3 = motionController.q;
                    double[] dArr4 = motionController.p;
                    motionController.f2159f.getClass();
                    MotionPaths.e(f2, f3, fArr, iArr, dArr3, dArr4);
                }
                velocityMatrix.a(f2, f3, width, height, fArr);
            } else if (motionController.f2163j != null) {
                double dB = motionController.b(fArr4, fB);
                motionController.f2163j[0].f(motionController.q, dB);
                motionController.f2163j[0].d(motionController.p, dB);
                float f7 = fArr4[0];
                int i3 = 0;
                while (true) {
                    dArr = motionController.q;
                    if (i3 >= dArr.length) {
                        break;
                    }
                    dArr[i3] = dArr[i3] * f7;
                    i3++;
                }
                int[] iArr2 = motionController.o;
                double[] dArr5 = motionController.p;
                motionController.f2159f.getClass();
                MotionPaths.e(f2, f3, fArr, iArr2, dArr, dArr5);
                velocityMatrix.a(f2, f3, width, height, fArr);
            } else {
                MotionPaths motionPaths = motionController.f2160g;
                float f8 = motionPaths.f2214e;
                MotionPaths motionPaths2 = motionController.f2159f;
                float f9 = f8 - motionPaths2.f2214e;
                float f10 = motionPaths.f2215f - motionPaths2.f2215f;
                float f11 = motionPaths.f2216g - motionPaths2.f2216g;
                float f12 = f10 + (motionPaths.f2217h - motionPaths2.f2217h);
                fArr[0] = ((f9 + f11) * f2) + ((1.0f - f2) * f9);
                fArr[1] = (f12 * f3) + ((1.0f - f3) * f10);
                velocityMatrix.f1898e = 0.0f;
                velocityMatrix.f1897d = 0.0f;
                velocityMatrix.f1896c = 0.0f;
                velocityMatrix.f1895b = 0.0f;
                velocityMatrix.f1894a = 0.0f;
                if (splineSet4 != null) {
                    velocityMatrix.f1898e = (float) splineSet4.f1854a.e(fB);
                    velocityMatrix.f1899f = splineSet4.a(fB);
                }
                if (splineSet != null) {
                    velocityMatrix.f1896c = (float) splineSet.f1854a.e(fB);
                }
                if (splineSet3 != null) {
                    velocityMatrix.f1897d = (float) splineSet3.f1854a.e(fB);
                }
                if (splineSet5 != null) {
                    velocityMatrix.f1894a = (float) splineSet5.f1854a.e(fB);
                }
                if (splineSet6 != null) {
                    velocityMatrix.f1895b = (float) splineSet6.f1854a.e(fB);
                }
                if (viewOscillator5 != null) {
                    velocityMatrix.f1898e = viewOscillator5.b(fB);
                }
                if (viewOscillator3 != null) {
                    velocityMatrix.f1896c = viewOscillator3.b(fB);
                }
                if (viewOscillator4 != null) {
                    velocityMatrix.f1897d = viewOscillator4.b(fB);
                }
                if (viewOscillator6 != null) {
                    velocityMatrix.f1894a = viewOscillator6.b(fB);
                }
                if (viewOscillator2 != null) {
                    velocityMatrix.f1895b = viewOscillator2.b(fB);
                }
                fArr2 = fArr;
                velocityMatrix.a(f2, f3, width, height, fArr2);
            }
            fArr2 = fArr;
        } else {
            fArr2 = fArr;
            f4 = f6;
            c2 = 1;
            c3 = 0;
            motionController.d(f5, f2, f3, fArr2);
        }
        if (i2 < 2) {
            fArr2[c3] = fArr2[c3] * f4;
            fArr2[c2] = fArr2[c2] * f4;
        }
    }

    public final boolean z(float f2, float f3, View view, MotionEvent motionEvent) {
        boolean z;
        boolean zOnTouchEvent;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                if (z((r3.getLeft() + f2) - view.getScrollX(), (r3.getTop() + f3) - view.getScrollY(), viewGroup.getChildAt(childCount), motionEvent)) {
                    z = true;
                    break;
                }
            }
            z = false;
        } else {
            z = false;
        }
        if (!z) {
            RectF rectF = this.k1;
            rectF.set(f2, f3, (view.getRight() + f2) - view.getLeft(), (view.getBottom() + f3) - view.getTop());
            if (motionEvent.getAction() != 0 || rectF.contains(motionEvent.getX(), motionEvent.getY())) {
                float f4 = -f2;
                float f5 = -f3;
                Matrix matrix = view.getMatrix();
                if (matrix.isIdentity()) {
                    motionEvent.offsetLocation(f4, f5);
                    zOnTouchEvent = view.onTouchEvent(motionEvent);
                    motionEvent.offsetLocation(-f4, -f5);
                } else {
                    MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                    motionEventObtain.offsetLocation(f4, f5);
                    if (this.m1 == null) {
                        this.m1 = new Matrix();
                    }
                    matrix.invert(this.m1);
                    motionEventObtain.transform(this.m1);
                    zOnTouchEvent = view.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                }
                if (zOnTouchEvent) {
                    return true;
                }
            }
        }
        return z;
    }

    public void setTransition(MotionScene.Transition transition) throws Exception {
        TouchResponse touchResponse;
        MotionScene motionScene = this.q;
        motionScene.f2225c = transition;
        if (transition != null && (touchResponse = transition.f2248l) != null) {
            touchResponse.c(motionScene.p);
        }
        setState(TransitionState.f2206b);
        int i2 = this.v;
        MotionScene.Transition transition2 = this.q.f2225c;
        if (i2 == (transition2 == null ? -1 : transition2.f2239c)) {
            this.E = 1.0f;
            this.D = 1.0f;
            this.G = 1.0f;
        } else {
            this.E = 0.0f;
            this.D = 0.0f;
            this.G = 0.0f;
        }
        this.F = (transition.r & 1) != 0 ? -1L : getNanoTime();
        int iH = this.q.h();
        MotionScene motionScene2 = this.q;
        MotionScene.Transition transition3 = motionScene2.f2225c;
        int i3 = transition3 != null ? transition3.f2239c : -1;
        if (iH == this.u && i3 == this.w) {
            return;
        }
        this.u = iH;
        this.w = i3;
        motionScene2.n(iH, i3);
        ConstraintSet constraintSetB = this.q.b(this.u);
        ConstraintSet constraintSetB2 = this.q.b(this.w);
        Model model = this.i1;
        model.e(constraintSetB, constraintSetB2);
        int i4 = this.u;
        int i5 = this.w;
        model.f2195e = i4;
        model.f2196f = i5;
        model.f();
        D();
    }

    public MotionLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) throws Resources.NotFoundException {
        super(context, attributeSet, i2);
        this.s = null;
        this.t = 0.0f;
        this.u = -1;
        this.v = -1;
        this.w = -1;
        this.x = 0;
        this.y = 0;
        this.z = true;
        this.A = new HashMap();
        this.B = 0L;
        this.C = 1.0f;
        this.D = 0.0f;
        this.E = 0.0f;
        this.G = 0.0f;
        this.I = false;
        this.K = 0;
        this.M = false;
        this.Q = new StopLogic();
        this.A0 = new DecelerateInterpolator();
        this.E0 = false;
        this.J0 = false;
        this.K0 = null;
        this.L0 = null;
        this.M0 = null;
        this.N0 = null;
        this.O0 = 0;
        this.P0 = -1L;
        this.Q0 = 0.0f;
        this.R0 = 0;
        this.S0 = 0.0f;
        this.T0 = false;
        this.b1 = new KeyCache();
        this.c1 = false;
        this.e1 = null;
        new HashMap();
        this.f1 = new Rect();
        this.g1 = false;
        this.h1 = TransitionState.f2205a;
        this.i1 = new Model();
        this.j1 = false;
        this.k1 = new RectF();
        this.l1 = null;
        this.m1 = null;
        this.n1 = new ArrayList();
        A(attributeSet);
    }
}
