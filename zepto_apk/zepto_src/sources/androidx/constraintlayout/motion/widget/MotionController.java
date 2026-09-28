package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.support.v4.media.b;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.constraintlayout.core.motion.utils.ArcCurveFit;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.motion.utils.CustomSupport;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.motion.utils.ViewTimeCycle;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* loaded from: classes3.dex */
public class MotionController {
    public KeyTrigger[] A;

    /* renamed from: b, reason: collision with root package name */
    public final View f2155b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2156c;

    /* renamed from: j, reason: collision with root package name */
    public CurveFit[] f2163j;

    /* renamed from: k, reason: collision with root package name */
    public ArcCurveFit f2164k;
    public int[] o;
    public double[] p;
    public double[] q;
    public String[] r;
    public int[] s;
    public HashMap x;
    public HashMap y;
    public HashMap z;

    /* renamed from: a, reason: collision with root package name */
    public final Rect f2154a = new Rect();

    /* renamed from: d, reason: collision with root package name */
    public boolean f2157d = false;

    /* renamed from: e, reason: collision with root package name */
    public int f2158e = -1;

    /* renamed from: f, reason: collision with root package name */
    public final MotionPaths f2159f = new MotionPaths();

    /* renamed from: g, reason: collision with root package name */
    public final MotionPaths f2160g = new MotionPaths();

    /* renamed from: h, reason: collision with root package name */
    public final MotionConstrainedPoint f2161h = new MotionConstrainedPoint();

    /* renamed from: i, reason: collision with root package name */
    public final MotionConstrainedPoint f2162i = new MotionConstrainedPoint();

    /* renamed from: l, reason: collision with root package name */
    public float f2165l = Float.NaN;

    /* renamed from: m, reason: collision with root package name */
    public float f2166m = 0.0f;
    public float n = 1.0f;
    public final float[] t = new float[4];
    public final ArrayList u = new ArrayList();
    public final float[] v = new float[1];
    public final ArrayList w = new ArrayList();
    public int B = -1;
    public int C = -1;
    public View D = null;
    public int E = -1;
    public float F = Float.NaN;
    public Interpolator G = null;
    public boolean H = false;

    public MotionController(View view) {
        this.f2155b = view;
        this.f2156c = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ((ConstraintLayout.LayoutParams) layoutParams).getClass();
        }
    }

    public static void k(Rect rect, Rect rect2, int i2, int i3, int i4) {
        if (i2 == 1) {
            int i5 = rect.left + rect.right;
            rect2.left = ((rect.top + rect.bottom) - rect.width()) / 2;
            rect2.top = i4 - ((rect.height() + i5) / 2);
            rect2.right = rect.width() + rect2.left;
            rect2.bottom = rect.height() + rect2.top;
            return;
        }
        if (i2 == 2) {
            int i6 = rect.left + rect.right;
            rect2.left = i3 - ((rect.width() + (rect.top + rect.bottom)) / 2);
            rect2.top = (i6 - rect.height()) / 2;
            rect2.right = rect.width() + rect2.left;
            rect2.bottom = rect.height() + rect2.top;
            return;
        }
        if (i2 == 3) {
            int i7 = rect.left + rect.right;
            rect2.left = ((rect.height() / 2) + rect.top) - (i7 / 2);
            rect2.top = i4 - ((rect.height() + i7) / 2);
            rect2.right = rect.width() + rect2.left;
            rect2.bottom = rect.height() + rect2.top;
            return;
        }
        if (i2 != 4) {
            return;
        }
        int i8 = rect.left + rect.right;
        rect2.left = i3 - ((rect.width() + (rect.bottom + rect.top)) / 2);
        rect2.top = (i8 - rect.height()) / 2;
        rect2.right = rect.width() + rect2.left;
        rect2.bottom = rect.height() + rect2.top;
    }

    public final void a(Key key) {
        this.w.add(key);
    }

    public final float b(float[] fArr, float f2) {
        float f3 = 0.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f4 = this.n;
            if (f4 != 1.0d) {
                float f5 = this.f2166m;
                if (f2 < f5) {
                    f2 = 0.0f;
                }
                if (f2 > f5 && f2 < 1.0d) {
                    f2 = Math.min((f2 - f5) * f4, 1.0f);
                }
            }
        }
        Easing easing = this.f2159f.f2210a;
        Iterator it = this.u.iterator();
        float f6 = Float.NaN;
        while (it.hasNext()) {
            MotionPaths motionPaths = (MotionPaths) it.next();
            Easing easing2 = motionPaths.f2210a;
            if (easing2 != null) {
                float f7 = motionPaths.f2212c;
                if (f7 < f2) {
                    easing = easing2;
                    f3 = f7;
                } else if (Float.isNaN(f6)) {
                    f6 = motionPaths.f2212c;
                }
            }
        }
        if (easing != null) {
            float f8 = (Float.isNaN(f6) ? 1.0f : f6) - f3;
            double d2 = (f2 - f3) / f8;
            f2 = (((float) easing.a(d2)) * f8) + f3;
            if (fArr != null) {
                fArr[0] = (float) easing.b(d2);
            }
        }
        return f2;
    }

    public final void c(double d2, float[] fArr, float[] fArr2) {
        float f2;
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.f2163j[0].d(dArr, d2);
        this.f2163j[0].f(dArr2, d2);
        float f3 = 0.0f;
        Arrays.fill(fArr2, 0.0f);
        int[] iArr = this.o;
        MotionPaths motionPaths = this.f2159f;
        float f4 = motionPaths.f2214e;
        float f5 = motionPaths.f2215f;
        float f6 = motionPaths.f2216g;
        float f7 = motionPaths.f2217h;
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f11 = (float) dArr[i2];
            float f12 = (float) dArr2[i2];
            int i3 = iArr[i2];
            if (i3 == 1) {
                f4 = f11;
                f3 = f12;
            } else if (i3 == 2) {
                f5 = f11;
                f10 = f12;
            } else if (i3 == 3) {
                f6 = f11;
                f8 = f12;
            } else if (i3 == 4) {
                f7 = f11;
                f9 = f12;
            }
        }
        float f13 = (f8 / 2.0f) + f3;
        float fSin = (f9 / 2.0f) + f10;
        MotionController motionController = motionPaths.f2222m;
        if (motionController != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            motionController.c(d2, fArr3, fArr4);
            float f14 = fArr3[0];
            float f15 = fArr3[1];
            float f16 = fArr4[0];
            float f17 = fArr4[1];
            double d3 = f4;
            double d4 = f5;
            float fSin2 = (float) (((Math.sin(d4) * d3) + f14) - (f6 / 2.0f));
            float fCos = (float) ((f15 - (Math.cos(d4) * d3)) - (f7 / 2.0f));
            double d5 = f3;
            f2 = 2.0f;
            double d6 = f10;
            float fCos2 = (float) ((Math.cos(d4) * d6) + (Math.sin(d4) * d5) + f16);
            fSin = (float) ((Math.sin(d4) * d6) + (f17 - (Math.cos(d4) * d5)));
            f5 = fCos;
            f4 = fSin2;
            f13 = fCos2;
        } else {
            f2 = 2.0f;
        }
        fArr[0] = (f6 / f2) + f4 + 0.0f;
        fArr[1] = (f7 / f2) + f5 + 0.0f;
        fArr2[0] = f13;
        fArr2[1] = fSin;
    }

    public final void d(float f2, float f3, float f4, float[] fArr) {
        double[] dArr;
        float[] fArr2 = this.v;
        float fB = b(fArr2, f2);
        CurveFit[] curveFitArr = this.f2163j;
        int i2 = 0;
        if (curveFitArr == null) {
            MotionPaths motionPaths = this.f2160g;
            float f5 = motionPaths.f2214e;
            MotionPaths motionPaths2 = this.f2159f;
            float f6 = f5 - motionPaths2.f2214e;
            float f7 = motionPaths.f2215f - motionPaths2.f2215f;
            float f8 = motionPaths.f2216g - motionPaths2.f2216g;
            float f9 = (motionPaths.f2217h - motionPaths2.f2217h) + f7;
            fArr[0] = ((f8 + f6) * f3) + ((1.0f - f3) * f6);
            fArr[1] = (f9 * f4) + ((1.0f - f4) * f7);
            return;
        }
        double d2 = fB;
        curveFitArr[0].f(this.q, d2);
        this.f2163j[0].d(this.p, d2);
        float f10 = fArr2[0];
        while (true) {
            dArr = this.q;
            if (i2 >= dArr.length) {
                break;
            }
            dArr[i2] = dArr[i2] * f10;
            i2++;
        }
        ArcCurveFit arcCurveFit = this.f2164k;
        if (arcCurveFit == null) {
            int[] iArr = this.o;
            double[] dArr2 = this.p;
            this.f2159f.getClass();
            MotionPaths.e(f3, f4, fArr, iArr, dArr, dArr2);
            return;
        }
        double[] dArr3 = this.p;
        if (dArr3.length > 0) {
            arcCurveFit.d(dArr3, d2);
            this.f2164k.f(this.q, d2);
            int[] iArr2 = this.o;
            double[] dArr4 = this.q;
            double[] dArr5 = this.p;
            this.f2159f.getClass();
            MotionPaths.e(f3, f4, fArr, iArr2, dArr4, dArr5);
        }
    }

    public final float e() {
        return this.f2160g.f2214e;
    }

    public final float f() {
        return this.f2160g.f2215f;
    }

    public final float g() {
        return this.f2159f.f2214e;
    }

    public final float h() {
        return this.f2159f.f2215f;
    }

    public final boolean i(float f2, long j2, View view, KeyCache keyCache) {
        boolean zF;
        View view2;
        boolean z;
        float f3;
        ViewTimeCycle.PathRotate pathRotate;
        float f4;
        boolean z2;
        float f5;
        float f6;
        float f7;
        boolean z3;
        View view3 = view;
        ViewTimeCycle.PathRotate pathRotate2 = null;
        float fB = b(null, f2);
        int i2 = this.E;
        if (i2 != -1) {
            float f8 = 1.0f / i2;
            float fFloor = ((float) Math.floor(fB / f8)) * f8;
            float f9 = (fB % f8) / f8;
            if (!Float.isNaN(this.F)) {
                f9 = (f9 + this.F) % 1.0f;
            }
            Interpolator interpolator = this.G;
            fB = ((interpolator != null ? interpolator.getInterpolation(f9) : ((double) f9) > 0.5d ? 1.0f : 0.0f) * f8) + fFloor;
        }
        HashMap map = this.y;
        if (map != null) {
            Iterator it = map.values().iterator();
            while (it.hasNext()) {
                ((ViewSpline) it.next()).e(view3, fB);
            }
        }
        HashMap map2 = this.x;
        if (map2 != null) {
            ViewTimeCycle.PathRotate pathRotate3 = null;
            zF = false;
            for (ViewTimeCycle viewTimeCycle : map2.values()) {
                if (viewTimeCycle instanceof ViewTimeCycle.PathRotate) {
                    pathRotate3 = (ViewTimeCycle.PathRotate) viewTimeCycle;
                } else {
                    zF |= viewTimeCycle.f(fB, j2, view3, keyCache);
                    view3 = view;
                }
            }
            pathRotate2 = pathRotate3;
        } else {
            zF = false;
        }
        CurveFit[] curveFitArr = this.f2163j;
        MotionPaths motionPaths = this.f2159f;
        if (curveFitArr != null) {
            double d2 = fB;
            curveFitArr[0].d(this.p, d2);
            this.f2163j[0].f(this.q, d2);
            ArcCurveFit arcCurveFit = this.f2164k;
            if (arcCurveFit != null) {
                double[] dArr = this.p;
                f3 = 0.0f;
                if (dArr.length > 0) {
                    arcCurveFit.d(dArr, d2);
                    this.f2164k.f(this.q, d2);
                }
            } else {
                f3 = 0.0f;
            }
            if (this.H) {
                view2 = view;
                pathRotate = pathRotate2;
                f4 = 1.0f;
                z2 = zF;
                f5 = 2.0f;
            } else {
                int[] iArr = this.o;
                double[] dArr2 = this.p;
                f5 = 2.0f;
                double[] dArr3 = this.q;
                f4 = 1.0f;
                boolean z4 = this.f2157d;
                float fSin = motionPaths.f2214e;
                float fCos = motionPaths.f2215f;
                float f10 = motionPaths.f2216g;
                int i3 = 1;
                float f11 = motionPaths.f2217h;
                pathRotate = pathRotate2;
                if (iArr.length != 0) {
                    f6 = f10;
                    if (motionPaths.p.length <= iArr[iArr.length - 1]) {
                        int i4 = iArr[iArr.length - 1] + 1;
                        motionPaths.p = new double[i4];
                        motionPaths.q = new double[i4];
                    }
                } else {
                    f6 = f10;
                }
                Arrays.fill(motionPaths.p, Double.NaN);
                for (int i5 = 0; i5 < iArr.length; i5++) {
                    double[] dArr4 = motionPaths.p;
                    int i6 = iArr[i5];
                    dArr4[i6] = dArr2[i5];
                    motionPaths.q[i6] = dArr3[i5];
                }
                float f12 = Float.NaN;
                float f13 = f3;
                float f14 = f13;
                float f15 = f14;
                int i7 = 0;
                float f16 = f6;
                float f17 = f15;
                while (true) {
                    double[] dArr5 = motionPaths.p;
                    f7 = f11;
                    if (i7 >= dArr5.length) {
                        break;
                    }
                    if (Double.isNaN(dArr5[i7])) {
                        z3 = zF;
                    } else {
                        float f18 = (float) (Double.isNaN(motionPaths.p[i7]) ? 0.0d : motionPaths.p[i7] + 0.0d);
                        z3 = zF;
                        float f19 = (float) motionPaths.q[i7];
                        if (i7 == i3) {
                            fSin = f18;
                            f13 = f19;
                        } else if (i7 == 2) {
                            fCos = f18;
                            f14 = f19;
                        } else if (i7 == 3) {
                            f16 = f18;
                            f17 = f19;
                        } else if (i7 == 4) {
                            f11 = f18;
                            f15 = f19;
                            i7++;
                            zF = z3;
                            i3 = 1;
                        } else if (i7 == 5) {
                            f12 = f18;
                        }
                    }
                    f11 = f7;
                    i7++;
                    zF = z3;
                    i3 = 1;
                }
                z2 = zF;
                MotionController motionController = motionPaths.f2222m;
                if (motionController != null) {
                    float[] fArr = new float[2];
                    float[] fArr2 = new float[2];
                    motionController.c(d2, fArr, fArr2);
                    float f20 = fArr[0];
                    float f21 = fArr[1];
                    float f22 = fArr2[0];
                    float f23 = fArr2[1];
                    double d3 = fSin;
                    double d4 = fCos;
                    fSin = (float) (((Math.sin(d4) * d3) + f20) - (f16 / 2.0f));
                    fCos = (float) ((f21 - (Math.cos(d4) * d3)) - (f7 / 2.0f));
                    double d5 = f13;
                    double d6 = f14;
                    float fCos2 = (float) ((Math.cos(d4) * d3 * d6) + (Math.sin(d4) * d5) + f22);
                    float fSin2 = (float) ((Math.sin(d4) * d3 * d6) + (f23 - (Math.cos(d4) * d5)));
                    if (dArr3.length >= 2) {
                        dArr3[0] = fCos2;
                        dArr3[1] = fSin2;
                    }
                    if (Float.isNaN(f12)) {
                        view2 = view;
                    } else {
                        view2 = view;
                        view2.setRotation((float) (Math.toDegrees(Math.atan2(fSin2, fCos2)) + f12));
                    }
                } else {
                    view2 = view;
                    if (!Float.isNaN(f12)) {
                        view2.setRotation(f12 + ((float) Math.toDegrees(Math.atan2((f15 / 2.0f) + f14, (f17 / 2.0f) + f13))) + f3);
                    }
                }
                if (view2 instanceof FloatLayout) {
                    ((FloatLayout) view2).a(fSin, fCos, fSin + f16, fCos + f7);
                } else {
                    float f24 = fSin + 0.5f;
                    int i8 = (int) f24;
                    float f25 = fCos + 0.5f;
                    int i9 = (int) f25;
                    int i10 = (int) (f24 + f16);
                    int i11 = (int) (f25 + f7);
                    int i12 = i10 - i8;
                    int i13 = i11 - i9;
                    if (i12 != view2.getMeasuredWidth() || i13 != view2.getMeasuredHeight() || z4) {
                        view2.measure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), View.MeasureSpec.makeMeasureSpec(i13, 1073741824));
                    }
                    view2.layout(i8, i9, i10, i11);
                }
                this.f2157d = false;
            }
            if (this.C != -1) {
                if (this.D == null) {
                    this.D = ((View) view2.getParent()).findViewById(this.C);
                }
                if (this.D != null) {
                    float bottom = (this.D.getBottom() + r1.getTop()) / f5;
                    float right = (this.D.getRight() + this.D.getLeft()) / f5;
                    if (view2.getRight() - view2.getLeft() > 0 && view2.getBottom() - view2.getTop() > 0) {
                        view2.setPivotX(right - view2.getLeft());
                        view2.setPivotY(bottom - view2.getTop());
                    }
                }
            }
            HashMap map3 = this.y;
            if (map3 != null) {
                for (SplineSet splineSet : map3.values()) {
                    if (splineSet instanceof ViewSpline.PathRotate) {
                        double[] dArr6 = this.q;
                        if (dArr6.length > 1) {
                            view2.setRotation(((ViewSpline.PathRotate) splineSet).a(fB) + ((float) Math.toDegrees(Math.atan2(dArr6[1], dArr6[0]))));
                        }
                    }
                }
            }
            if (pathRotate != null) {
                double[] dArr7 = this.q;
                double d7 = dArr7[0];
                double d8 = dArr7[1];
                ViewTimeCycle.PathRotate pathRotate4 = pathRotate;
                view2.setRotation(pathRotate4.d(fB, j2, view2, keyCache) + ((float) Math.toDegrees(Math.atan2(d8, d7))));
                z = z2 | pathRotate4.f1891h;
            } else {
                z = z2;
            }
            int i14 = 1;
            while (true) {
                CurveFit[] curveFitArr2 = this.f2163j;
                if (i14 >= curveFitArr2.length) {
                    break;
                }
                CurveFit curveFit = curveFitArr2[i14];
                float[] fArr3 = this.t;
                curveFit.c(d2, fArr3);
                CustomSupport.b((ConstraintAttribute) motionPaths.n.get(this.r[i14 - 1]), view2, fArr3);
                i14++;
            }
            MotionConstrainedPoint motionConstrainedPoint = this.f2161h;
            if (motionConstrainedPoint.f2142b == 0) {
                if (fB <= f3) {
                    view2.setVisibility(motionConstrainedPoint.f2143c);
                } else {
                    MotionConstrainedPoint motionConstrainedPoint2 = this.f2162i;
                    if (fB >= f4) {
                        view2.setVisibility(motionConstrainedPoint2.f2143c);
                    } else if (motionConstrainedPoint2.f2143c != motionConstrainedPoint.f2143c) {
                        view2.setVisibility(0);
                    }
                }
            }
            if (this.A != null) {
                int i15 = 0;
                while (true) {
                    KeyTrigger[] keyTriggerArr = this.A;
                    if (i15 >= keyTriggerArr.length) {
                        break;
                    }
                    keyTriggerArr[i15].h(view2, fB);
                    i15++;
                }
            }
        } else {
            view2 = view;
            boolean z5 = zF;
            float f26 = motionPaths.f2214e;
            MotionPaths motionPaths2 = this.f2160g;
            float fA = android.support.v4.media.a.a(motionPaths2.f2214e, f26, fB, f26);
            float f27 = motionPaths.f2215f;
            float fA2 = android.support.v4.media.a.a(motionPaths2.f2215f, f27, fB, f27);
            float f28 = motionPaths.f2216g;
            float f29 = motionPaths2.f2216g;
            float fA3 = android.support.v4.media.a.a(f29, f28, fB, f28);
            float f30 = motionPaths.f2217h;
            float f31 = motionPaths2.f2217h;
            float f32 = fA + 0.5f;
            int i16 = (int) f32;
            float f33 = fA2 + 0.5f;
            int i17 = (int) f33;
            int i18 = (int) (f32 + fA3);
            int iA = (int) (f33 + android.support.v4.media.a.a(f31, f30, fB, f30));
            int i19 = i18 - i16;
            int i20 = iA - i17;
            if (f29 != f28 || f31 != f30 || this.f2157d) {
                view2.measure(View.MeasureSpec.makeMeasureSpec(i19, 1073741824), View.MeasureSpec.makeMeasureSpec(i20, 1073741824));
                this.f2157d = false;
            }
            view2.layout(i16, i17, i18, iA);
            z = z5;
        }
        HashMap map4 = this.z;
        if (map4 != null) {
            for (ViewOscillator viewOscillator : map4.values()) {
                if (viewOscillator instanceof ViewOscillator.PathRotateSet) {
                    double[] dArr8 = this.q;
                    view2.setRotation(((ViewOscillator.PathRotateSet) viewOscillator).a(fB) + ((float) Math.toDegrees(Math.atan2(dArr8[1], dArr8[0]))));
                } else {
                    viewOscillator.h(view2, fB);
                }
            }
        }
        return z;
    }

    public final void j(MotionPaths motionPaths) {
        motionPaths.d((int) this.f2155b.getX(), (int) this.f2155b.getY(), this.f2155b.getWidth(), this.f2155b.getHeight());
    }

    public final void l(int i2, int i3, long j2) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        String[] strArr;
        Iterator it;
        MotionPaths motionPaths;
        MotionPaths motionPaths2;
        char c2;
        int i4;
        double[] dArr;
        ConstraintAttribute constraintAttribute;
        ViewTimeCycle viewTimeCycleE;
        ConstraintAttribute constraintAttribute2;
        Integer num;
        Iterator it2;
        ArrayList arrayList4;
        ViewSpline viewSplineD;
        ConstraintAttribute constraintAttribute3;
        ArrayList arrayList5;
        MotionConstrainedPoint motionConstrainedPoint;
        float fMin;
        float fA;
        float f2 = Float.NaN;
        ArrayList arrayList6 = this.u;
        int i5 = 0;
        new HashSet();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashMap map = new HashMap();
        int i6 = this.B;
        MotionPaths motionPaths3 = this.f2159f;
        int i7 = -1;
        if (i6 != -1) {
            motionPaths3.f2219j = i6;
        }
        MotionConstrainedPoint motionConstrainedPoint2 = this.f2161h;
        float f3 = motionConstrainedPoint2.f2145e;
        MotionConstrainedPoint motionConstrainedPoint3 = this.f2162i;
        if (MotionConstrainedPoint.c(f3, motionConstrainedPoint3.f2145e)) {
            hashSet2.add("alpha");
        }
        if (MotionConstrainedPoint.c(motionConstrainedPoint2.f2146f, motionConstrainedPoint3.f2146f)) {
            hashSet2.add("elevation");
        }
        int i8 = motionConstrainedPoint2.f2143c;
        int i9 = motionConstrainedPoint3.f2143c;
        if (i8 != i9 && motionConstrainedPoint2.f2142b == 0 && (i8 == 0 || i9 == 0)) {
            hashSet2.add("alpha");
        }
        if (MotionConstrainedPoint.c(motionConstrainedPoint2.f2147g, motionConstrainedPoint3.f2147g)) {
            hashSet2.add("rotation");
        }
        if (!Float.isNaN(motionConstrainedPoint2.p) || !Float.isNaN(motionConstrainedPoint3.p)) {
            hashSet2.add("transitionPathRotate");
        }
        if (!Float.isNaN(motionConstrainedPoint2.q) || !Float.isNaN(motionConstrainedPoint3.q)) {
            hashSet2.add(ReactProgressBarViewManager.PROP_PROGRESS);
        }
        if (MotionConstrainedPoint.c(motionConstrainedPoint2.f2148h, motionConstrainedPoint3.f2148h)) {
            hashSet2.add("rotationX");
        }
        if (MotionConstrainedPoint.c(motionConstrainedPoint2.f2141a, motionConstrainedPoint3.f2141a)) {
            hashSet2.add("rotationY");
        }
        if (MotionConstrainedPoint.c(motionConstrainedPoint2.f2151k, motionConstrainedPoint3.f2151k)) {
            hashSet2.add("transformPivotX");
        }
        if (MotionConstrainedPoint.c(motionConstrainedPoint2.f2152l, motionConstrainedPoint3.f2152l)) {
            hashSet2.add("transformPivotY");
        }
        if (MotionConstrainedPoint.c(motionConstrainedPoint2.f2149i, motionConstrainedPoint3.f2149i)) {
            hashSet2.add("scaleX");
        }
        if (MotionConstrainedPoint.c(motionConstrainedPoint2.f2150j, motionConstrainedPoint3.f2150j)) {
            hashSet2.add("scaleY");
        }
        if (MotionConstrainedPoint.c(motionConstrainedPoint2.f2153m, motionConstrainedPoint3.f2153m)) {
            hashSet2.add("translationX");
        }
        if (MotionConstrainedPoint.c(motionConstrainedPoint2.n, motionConstrainedPoint3.n)) {
            hashSet2.add("translationY");
        }
        if (MotionConstrainedPoint.c(motionConstrainedPoint2.o, motionConstrainedPoint3.o)) {
            hashSet2.add("translationZ");
        }
        ArrayList arrayList7 = this.w;
        MotionPaths motionPaths4 = this.f2160g;
        if (arrayList7 != null) {
            Iterator it3 = arrayList7.iterator();
            ArrayList arrayList8 = null;
            while (it3.hasNext()) {
                Key key = (Key) it3.next();
                if (key instanceof KeyPosition) {
                    KeyPosition keyPosition = (KeyPosition) key;
                    MotionPaths motionPaths5 = new MotionPaths();
                    motionPaths5.f2211b = i5;
                    motionPaths5.f2218i = f2;
                    motionPaths5.f2219j = i7;
                    motionPaths5.f2220k = i7;
                    motionPaths5.f2221l = f2;
                    motionPaths5.f2222m = null;
                    motionPaths5.n = new LinkedHashMap();
                    motionPaths5.o = i5;
                    motionPaths5.p = new double[18];
                    motionPaths5.q = new double[18];
                    if (motionPaths3.f2220k != i7) {
                        float f4 = keyPosition.f2085a / 100.0f;
                        motionPaths5.f2212c = f4;
                        motionPaths5.f2211b = keyPosition.f2113h;
                        motionPaths5.o = keyPosition.o;
                        float f5 = Float.isNaN(keyPosition.f2114i) ? f4 : keyPosition.f2114i;
                        float f6 = Float.isNaN(keyPosition.f2115j) ? f4 : keyPosition.f2115j;
                        arrayList5 = arrayList7;
                        float f7 = motionPaths4.f2216g - motionPaths3.f2216g;
                        float f8 = motionPaths4.f2217h;
                        float f9 = motionPaths3.f2217h;
                        motionPaths5.f2213d = motionPaths5.f2212c;
                        motionPaths5.f2216g = (int) ((f7 * f5) + r1);
                        motionPaths5.f2217h = (int) (((f8 - f9) * f6) + f9);
                        motionConstrainedPoint = motionConstrainedPoint3;
                        if (keyPosition.o != 2) {
                            float f10 = Float.isNaN(keyPosition.f2116k) ? f4 : keyPosition.f2116k;
                            float f11 = motionPaths4.f2214e;
                            float f12 = motionPaths3.f2214e;
                            motionPaths5.f2214e = android.support.v4.media.a.a(f11, f12, f10, f12);
                            if (!Float.isNaN(keyPosition.f2117l)) {
                                f4 = keyPosition.f2117l;
                            }
                            float f13 = motionPaths4.f2215f;
                            float f14 = motionPaths3.f2215f;
                            motionPaths5.f2215f = android.support.v4.media.a.a(f13, f14, f4, f14);
                        } else {
                            if (Float.isNaN(keyPosition.f2116k)) {
                                float f15 = motionPaths4.f2214e;
                                float f16 = motionPaths3.f2214e;
                                fMin = android.support.v4.media.a.a(f15, f16, f4, f16);
                            } else {
                                fMin = keyPosition.f2116k * Math.min(f6, f5);
                            }
                            motionPaths5.f2214e = fMin;
                            if (Float.isNaN(keyPosition.f2117l)) {
                                float f17 = motionPaths4.f2215f;
                                float f18 = motionPaths3.f2215f;
                                fA = android.support.v4.media.a.a(f17, f18, f4, f18);
                            } else {
                                fA = keyPosition.f2117l;
                            }
                            motionPaths5.f2215f = fA;
                        }
                        motionPaths5.f2220k = motionPaths3.f2220k;
                        motionPaths5.f2210a = Easing.c(keyPosition.f2111f);
                        motionPaths5.f2219j = keyPosition.f2112g;
                    } else {
                        arrayList5 = arrayList7;
                        motionConstrainedPoint = motionConstrainedPoint3;
                        int i10 = keyPosition.o;
                        if (i10 == 1) {
                            float f19 = keyPosition.f2085a / 100.0f;
                            motionPaths5.f2212c = f19;
                            motionPaths5.f2211b = keyPosition.f2113h;
                            float f20 = Float.isNaN(keyPosition.f2114i) ? f19 : keyPosition.f2114i;
                            float f21 = Float.isNaN(keyPosition.f2115j) ? f19 : keyPosition.f2115j;
                            float f22 = motionPaths4.f2216g - motionPaths3.f2216g;
                            float f23 = f19;
                            float f24 = motionPaths4.f2217h - motionPaths3.f2217h;
                            motionPaths5.f2213d = motionPaths5.f2212c;
                            if (!Float.isNaN(keyPosition.f2116k)) {
                                f23 = keyPosition.f2116k;
                            }
                            float f25 = (motionPaths3.f2216g / 2.0f) + motionPaths3.f2214e;
                            float f26 = motionPaths3.f2215f;
                            float f27 = motionPaths3.f2217h;
                            float f28 = ((motionPaths4.f2216g / 2.0f) + motionPaths4.f2214e) - f25;
                            float f29 = ((motionPaths4.f2217h / 2.0f) + motionPaths4.f2215f) - ((f27 / 2.0f) + f26);
                            float f30 = f28 * f23;
                            float f31 = (f22 * f20) / 2.0f;
                            motionPaths5.f2214e = (int) ((r1 + f30) - f31);
                            float f32 = f23 * f29;
                            float f33 = (f24 * f21) / 2.0f;
                            motionPaths5.f2215f = (int) ((f26 + f32) - f33);
                            motionPaths5.f2216g = (int) (r1 + r5);
                            motionPaths5.f2217h = (int) (f27 + r8);
                            float f34 = Float.isNaN(keyPosition.f2117l) ? 0.0f : keyPosition.f2117l;
                            float f35 = (-f29) * f34;
                            float f36 = f28 * f34;
                            motionPaths5.o = 1;
                            float f37 = (int) ((motionPaths3.f2214e + f30) - f31);
                            float f38 = (int) ((motionPaths3.f2215f + f32) - f33);
                            motionPaths5.f2214e = f37 + f35;
                            motionPaths5.f2215f = f38 + f36;
                            motionPaths5.f2220k = motionPaths5.f2220k;
                            motionPaths5.f2210a = Easing.c(keyPosition.f2111f);
                            motionPaths5.f2219j = keyPosition.f2112g;
                        } else if (i10 == 2) {
                            float f39 = keyPosition.f2085a / 100.0f;
                            motionPaths5.f2212c = f39;
                            motionPaths5.f2211b = keyPosition.f2113h;
                            float f40 = Float.isNaN(keyPosition.f2114i) ? f39 : keyPosition.f2114i;
                            float f41 = Float.isNaN(keyPosition.f2115j) ? f39 : keyPosition.f2115j;
                            float f42 = motionPaths4.f2216g;
                            float f43 = motionPaths3.f2216g;
                            float f44 = f42 - f43;
                            float f45 = motionPaths4.f2217h;
                            float f46 = motionPaths3.f2217h;
                            float f47 = f45 - f46;
                            motionPaths5.f2213d = motionPaths5.f2212c;
                            float f48 = (f43 / 2.0f) + motionPaths3.f2214e;
                            float f49 = motionPaths3.f2215f;
                            float f50 = (f42 / 2.0f) + motionPaths4.f2214e;
                            float f51 = ((f45 / 2.0f) + motionPaths4.f2215f) - ((f46 / 2.0f) + f49);
                            float f52 = f44 * f40;
                            motionPaths5.f2214e = (int) ((((f50 - f48) * f39) + r1) - (f52 / 2.0f));
                            float f53 = f47 * f41;
                            motionPaths5.f2215f = (int) (((f51 * f39) + f49) - (f53 / 2.0f));
                            motionPaths5.f2216g = (int) (f43 + f52);
                            motionPaths5.f2217h = (int) (f46 + f53);
                            motionPaths5.o = 2;
                            if (!Float.isNaN(keyPosition.f2116k)) {
                                motionPaths5.f2214e = (int) (keyPosition.f2116k * (i2 - ((int) motionPaths5.f2216g)));
                            }
                            if (!Float.isNaN(keyPosition.f2117l)) {
                                motionPaths5.f2215f = (int) (keyPosition.f2117l * (i3 - ((int) motionPaths5.f2217h)));
                            }
                            motionPaths5.f2220k = motionPaths5.f2220k;
                            motionPaths5.f2210a = Easing.c(keyPosition.f2111f);
                            motionPaths5.f2219j = keyPosition.f2112g;
                        } else if (i10 != 3) {
                            float f54 = keyPosition.f2085a / 100.0f;
                            motionPaths5.f2212c = f54;
                            motionPaths5.f2211b = keyPosition.f2113h;
                            float f55 = Float.isNaN(keyPosition.f2114i) ? f54 : keyPosition.f2114i;
                            float f56 = Float.isNaN(keyPosition.f2115j) ? f54 : keyPosition.f2115j;
                            float f57 = motionPaths4.f2216g;
                            float f58 = motionPaths3.f2216g;
                            float f59 = f57 - f58;
                            float f60 = motionPaths4.f2217h;
                            float f61 = motionPaths3.f2217h;
                            float f62 = f60 - f61;
                            motionPaths5.f2213d = motionPaths5.f2212c;
                            float f63 = (f58 / 2.0f) + motionPaths3.f2214e;
                            float f64 = motionPaths3.f2215f;
                            float f65 = ((f57 / 2.0f) + motionPaths4.f2214e) - f63;
                            float f66 = ((f60 / 2.0f) + motionPaths4.f2215f) - ((f61 / 2.0f) + f64);
                            float f67 = (f59 * f55) / 2.0f;
                            motionPaths5.f2214e = (int) (((f65 * f54) + r1) - f67);
                            float f68 = (f62 * f56) / 2.0f;
                            motionPaths5.f2215f = (int) (((f66 * f54) + f64) - f68);
                            motionPaths5.f2216g = (int) (f58 + r30);
                            motionPaths5.f2217h = (int) (f61 + r33);
                            float f69 = Float.isNaN(keyPosition.f2116k) ? f54 : keyPosition.f2116k;
                            float f70 = Float.isNaN(keyPosition.n) ? 0.0f : keyPosition.n;
                            float f71 = f69;
                            float f72 = Float.isNaN(keyPosition.f2117l) ? f54 : keyPosition.f2117l;
                            float f73 = Float.isNaN(keyPosition.f2118m) ? 0.0f : keyPosition.f2118m;
                            motionPaths5.o = 0;
                            motionPaths5.f2214e = (int) (((f73 * f66) + ((f71 * f65) + motionPaths3.f2214e)) - f67);
                            motionPaths5.f2215f = (int) (((f66 * f72) + ((f65 * f70) + motionPaths3.f2215f)) - f68);
                            motionPaths5.f2210a = Easing.c(keyPosition.f2111f);
                            motionPaths5.f2219j = keyPosition.f2112g;
                        } else {
                            float f74 = keyPosition.f2085a / 100.0f;
                            motionPaths5.f2212c = f74;
                            motionPaths5.f2211b = keyPosition.f2113h;
                            float f75 = Float.isNaN(keyPosition.f2114i) ? f74 : keyPosition.f2114i;
                            float f76 = Float.isNaN(keyPosition.f2115j) ? f74 : keyPosition.f2115j;
                            float f77 = motionPaths4.f2216g;
                            float f78 = motionPaths3.f2216g;
                            float f79 = f77 - f78;
                            float f80 = motionPaths4.f2217h;
                            float f81 = motionPaths3.f2217h;
                            float f82 = f80 - f81;
                            motionPaths5.f2213d = motionPaths5.f2212c;
                            float f83 = (f78 / 2.0f) + motionPaths3.f2214e;
                            float f84 = (f81 / 2.0f) + motionPaths3.f2215f;
                            float f85 = (f77 / 2.0f) + motionPaths4.f2214e;
                            float f86 = (f80 / 2.0f) + motionPaths4.f2215f;
                            if (f83 > f85) {
                                f83 = f85;
                                f85 = f83;
                            }
                            if (f84 <= f86) {
                                f84 = f86;
                                f86 = f84;
                            }
                            float f87 = f85 - f83;
                            float f88 = f84 - f86;
                            float f89 = (f79 * f75) / 2.0f;
                            motionPaths5.f2214e = (int) (((f87 * f74) + r1) - f89);
                            float f90 = (f82 * f76) / 2.0f;
                            motionPaths5.f2215f = (int) (((f88 * f74) + r1) - f90);
                            motionPaths5.f2216g = (int) (f78 + r30);
                            motionPaths5.f2217h = (int) (f81 + r33);
                            float f91 = Float.isNaN(keyPosition.f2116k) ? f74 : keyPosition.f2116k;
                            float f92 = Float.isNaN(keyPosition.n) ? 0.0f : keyPosition.n;
                            float f93 = f91;
                            float f94 = Float.isNaN(keyPosition.f2117l) ? f74 : keyPosition.f2117l;
                            float f95 = Float.isNaN(keyPosition.f2118m) ? 0.0f : keyPosition.f2118m;
                            motionPaths5.o = 0;
                            motionPaths5.f2214e = (int) (((f95 * f88) + ((f93 * f87) + motionPaths3.f2214e)) - f89);
                            motionPaths5.f2215f = (int) (((f88 * f94) + ((f87 * f92) + motionPaths3.f2215f)) - f90);
                            motionPaths5.f2210a = Easing.c(keyPosition.f2111f);
                            motionPaths5.f2219j = keyPosition.f2112g;
                        }
                    }
                    if (Collections.binarySearch(arrayList6, motionPaths5) == 0) {
                        Log.e("MotionController", " KeyPath position \"" + motionPaths5.f2213d + "\" outside of range");
                    }
                    arrayList6.add((-r1) - 1, motionPaths5);
                    int i11 = keyPosition.f2120e;
                    if (i11 != -1) {
                        this.f2158e = i11;
                    }
                } else {
                    arrayList5 = arrayList7;
                    motionConstrainedPoint = motionConstrainedPoint3;
                    if (key instanceof KeyCycle) {
                        key.d(hashSet3);
                    } else if (key instanceof KeyTimeCycle) {
                        key.d(hashSet);
                    } else if (key instanceof KeyTrigger) {
                        if (arrayList8 == null) {
                            arrayList8 = new ArrayList();
                        }
                        ArrayList arrayList9 = arrayList8;
                        arrayList9.add((KeyTrigger) key);
                        arrayList8 = arrayList9;
                    } else {
                        key.f(map);
                        key.d(hashSet2);
                    }
                }
                arrayList7 = arrayList5;
                motionConstrainedPoint3 = motionConstrainedPoint;
                i7 = -1;
                f2 = Float.NaN;
                i5 = 0;
            }
            arrayList = arrayList7;
            arrayList2 = arrayList8;
        } else {
            arrayList = arrayList7;
            arrayList2 = null;
        }
        MotionConstrainedPoint motionConstrainedPoint4 = motionConstrainedPoint3;
        if (arrayList2 != null) {
            this.A = (KeyTrigger[]) arrayList2.toArray(new KeyTrigger[0]);
        }
        if (hashSet2.isEmpty()) {
            arrayList3 = arrayList6;
        } else {
            this.y = new HashMap();
            Iterator it4 = hashSet2.iterator();
            while (it4.hasNext()) {
                String str = (String) it4.next();
                if (str.startsWith("CUSTOM,")) {
                    SparseArray sparseArray = new SparseArray();
                    String str2 = str.split(",")[1];
                    Iterator it5 = arrayList.iterator();
                    while (it5.hasNext()) {
                        Iterator it6 = it4;
                        Key key2 = (Key) it5.next();
                        ArrayList arrayList10 = arrayList6;
                        HashMap map2 = key2.f2088d;
                        if (map2 != null && (constraintAttribute3 = (ConstraintAttribute) map2.get(str2)) != null) {
                            sparseArray.append(key2.f2085a, constraintAttribute3);
                        }
                        it4 = it6;
                        arrayList6 = arrayList10;
                    }
                    it2 = it4;
                    arrayList4 = arrayList6;
                    ViewSpline.CustomSet customSet = new ViewSpline.CustomSet();
                    String str3 = str.split(",")[1];
                    customSet.f2078f = sparseArray;
                    viewSplineD = customSet;
                } else {
                    it2 = it4;
                    arrayList4 = arrayList6;
                    viewSplineD = ViewSpline.d(str);
                }
                if (viewSplineD != null) {
                    viewSplineD.f1858e = str;
                    this.y.put(str, viewSplineD);
                }
                it4 = it2;
                arrayList6 = arrayList4;
            }
            arrayList3 = arrayList6;
            if (arrayList != null) {
                Iterator it7 = arrayList.iterator();
                while (it7.hasNext()) {
                    Key key3 = (Key) it7.next();
                    if (key3 instanceof KeyAttributes) {
                        key3.a(this.y);
                    }
                }
            }
            motionConstrainedPoint2.a(this.y, 0);
            motionConstrainedPoint4.a(this.y, 100);
            for (String str4 : this.y.keySet()) {
                int iIntValue = (!map.containsKey(str4) || (num = (Integer) map.get(str4)) == null) ? 0 : num.intValue();
                SplineSet splineSet = (SplineSet) this.y.get(str4);
                if (splineSet != null) {
                    splineSet.c(iIntValue);
                }
            }
        }
        if (!hashSet.isEmpty()) {
            if (this.x == null) {
                this.x = new HashMap();
            }
            Iterator it8 = hashSet.iterator();
            while (it8.hasNext()) {
                String str5 = (String) it8.next();
                if (!this.x.containsKey(str5)) {
                    if (str5.startsWith("CUSTOM,")) {
                        SparseArray sparseArray2 = new SparseArray();
                        String str6 = str5.split(",")[1];
                        Iterator it9 = arrayList.iterator();
                        while (it9.hasNext()) {
                            Key key4 = (Key) it9.next();
                            HashMap map3 = key4.f2088d;
                            if (map3 != null && (constraintAttribute2 = (ConstraintAttribute) map3.get(str6)) != null) {
                                sparseArray2.append(key4.f2085a, constraintAttribute2);
                            }
                        }
                        ViewTimeCycle.CustomSet customSet2 = new ViewTimeCycle.CustomSet();
                        customSet2.f2083m = new SparseArray();
                        customSet2.f2081k = str5.split(",")[1];
                        customSet2.f2082l = sparseArray2;
                        viewTimeCycleE = customSet2;
                    } else {
                        viewTimeCycleE = ViewTimeCycle.e(j2, str5);
                    }
                    if (viewTimeCycleE != null) {
                        viewTimeCycleE.f1889f = str5;
                        this.x.put(str5, viewTimeCycleE);
                    }
                }
            }
            if (arrayList != null) {
                Iterator it10 = arrayList.iterator();
                while (it10.hasNext()) {
                    Key key5 = (Key) it10.next();
                    if (key5 instanceof KeyTimeCycle) {
                        ((KeyTimeCycle) key5).h(this.x);
                    }
                }
            }
            for (String str7 : this.x.keySet()) {
                ((ViewTimeCycle) this.x.get(str7)).c(map.containsKey(str7) ? ((Integer) map.get(str7)).intValue() : 0);
            }
        }
        int size = arrayList3.size();
        int i12 = size + 2;
        MotionPaths[] motionPathsArr = new MotionPaths[i12];
        motionPathsArr[0] = motionPaths3;
        motionPathsArr[size + 1] = motionPaths4;
        if (arrayList3.size() > 0 && this.f2158e == -1) {
            this.f2158e = 0;
        }
        Iterator it11 = arrayList3.iterator();
        int i13 = 1;
        while (it11.hasNext()) {
            motionPathsArr[i13] = (MotionPaths) it11.next();
            i13++;
        }
        HashSet hashSet4 = new HashSet();
        for (String str8 : motionPaths4.n.keySet()) {
            if (motionPaths3.n.containsKey(str8)) {
                if (!hashSet2.contains("CUSTOM," + str8)) {
                    hashSet4.add(str8);
                }
            }
        }
        String[] strArr2 = (String[]) hashSet4.toArray(new String[0]);
        this.r = strArr2;
        this.s = new int[strArr2.length];
        int i14 = 0;
        while (true) {
            strArr = this.r;
            if (i14 >= strArr.length) {
                break;
            }
            String str9 = strArr[i14];
            this.s[i14] = 0;
            int i15 = 0;
            while (true) {
                if (i15 >= i12) {
                    break;
                }
                if (motionPathsArr[i15].n.containsKey(str9) && (constraintAttribute = (ConstraintAttribute) motionPathsArr[i15].n.get(str9)) != null) {
                    int[] iArr = this.s;
                    iArr[i14] = constraintAttribute.c() + iArr[i14];
                    break;
                }
                i15++;
            }
            i14++;
        }
        boolean z = motionPathsArr[0].f2219j != -1;
        int length = 18 + strArr.length;
        boolean[] zArr = new boolean[length];
        for (int i16 = 1; i16 < i12; i16++) {
            MotionPaths motionPaths6 = motionPathsArr[i16];
            MotionPaths motionPaths7 = motionPathsArr[i16 - 1];
            boolean zB = MotionPaths.b(motionPaths6.f2214e, motionPaths7.f2214e);
            boolean zB2 = MotionPaths.b(motionPaths6.f2215f, motionPaths7.f2215f);
            zArr[0] = zArr[0] | MotionPaths.b(motionPaths6.f2213d, motionPaths7.f2213d);
            boolean z2 = zB | zB2 | z;
            zArr[1] = zArr[1] | z2;
            zArr[2] = z2 | zArr[2];
            zArr[3] = zArr[3] | MotionPaths.b(motionPaths6.f2216g, motionPaths7.f2216g);
            zArr[4] = MotionPaths.b(motionPaths6.f2217h, motionPaths7.f2217h) | zArr[4];
        }
        int i17 = 0;
        for (int i18 = 1; i18 < length; i18++) {
            if (zArr[i18]) {
                i17++;
            }
        }
        this.o = new int[i17];
        int iMax = Math.max(2, i17);
        this.p = new double[iMax];
        this.q = new double[iMax];
        int i19 = 0;
        for (int i20 = 1; i20 < length; i20++) {
            if (zArr[i20]) {
                this.o[i19] = i20;
                i19++;
            }
        }
        int[] iArr2 = {i12, this.o.length};
        Class cls = Double.TYPE;
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) cls, iArr2);
        double[] dArr3 = new double[i12];
        int i21 = 0;
        while (i21 < i12) {
            MotionPaths motionPaths8 = motionPathsArr[i21];
            double[] dArr4 = dArr2[i21];
            int[] iArr3 = this.o;
            MotionPaths[] motionPathsArr2 = motionPathsArr;
            int i22 = i21;
            float[] fArr = {motionPaths8.f2213d, motionPaths8.f2214e, motionPaths8.f2215f, motionPaths8.f2216g, motionPaths8.f2217h, motionPaths8.f2218i};
            int i23 = 0;
            for (int i24 : iArr3) {
                if (i24 < 6) {
                    dArr4[i23] = fArr[r11];
                    i23++;
                }
            }
            dArr3[i22] = motionPathsArr2[i22].f2212c;
            i21 = i22 + 1;
            motionPathsArr = motionPathsArr2;
        }
        MotionPaths[] motionPathsArr3 = motionPathsArr;
        int i25 = 0;
        while (true) {
            int[] iArr4 = this.o;
            if (i25 >= iArr4.length) {
                break;
            }
            if (iArr4[i25] < 6) {
                String strR = b.r(new StringBuilder(), MotionPaths.r[this.o[i25]], " [");
                for (int i26 = 0; i26 < i12; i26++) {
                    StringBuilder sbW = b.w(strR);
                    sbW.append(dArr2[i26][i25]);
                    strR = sbW.toString();
                }
            }
            i25++;
        }
        this.f2163j = new CurveFit[this.r.length + 1];
        int i27 = 0;
        while (true) {
            String[] strArr3 = this.r;
            if (i27 >= strArr3.length) {
                break;
            }
            String str10 = strArr3[i27];
            int i28 = 0;
            int i29 = 0;
            double[] dArr5 = null;
            double[][] dArr6 = null;
            while (i28 < i12) {
                if (motionPathsArr3[i28].n.containsKey(str10)) {
                    if (dArr6 == null) {
                        dArr5 = new double[i12];
                        ConstraintAttribute constraintAttribute4 = (ConstraintAttribute) motionPathsArr3[i28].n.get(str10);
                        dArr6 = (double[][]) Array.newInstance((Class<?>) cls, i12, constraintAttribute4 == null ? 0 : constraintAttribute4.c());
                    }
                    MotionPaths motionPaths9 = motionPathsArr3[i28];
                    dArr5[i29] = motionPaths9.f2212c;
                    double[] dArr7 = dArr6[i29];
                    ConstraintAttribute constraintAttribute5 = (ConstraintAttribute) motionPaths9.n.get(str10);
                    if (constraintAttribute5 == null) {
                        i4 = i27;
                        dArr = dArr3;
                    } else {
                        i4 = i27;
                        if (constraintAttribute5.c() == 1) {
                            dArr = dArr3;
                            dArr7[0] = constraintAttribute5.a();
                        } else {
                            dArr = dArr3;
                            int iC = constraintAttribute5.c();
                            float[] fArr2 = new float[iC];
                            constraintAttribute5.b(fArr2);
                            int i30 = 0;
                            int i31 = 0;
                            while (i30 < iC) {
                                dArr7[i31] = fArr2[i30];
                                i30++;
                                iC = iC;
                                i31++;
                                fArr2 = fArr2;
                            }
                        }
                    }
                    i29++;
                } else {
                    i4 = i27;
                    dArr = dArr3;
                }
                i28++;
                dArr3 = dArr;
                i27 = i4;
            }
            int i32 = i27 + 1;
            this.f2163j[i32] = CurveFit.a(this.f2158e, Arrays.copyOf(dArr5, i29), (double[][]) Arrays.copyOf(dArr6, i29));
            i27 = i32;
            dArr3 = dArr3;
        }
        this.f2163j[0] = CurveFit.a(this.f2158e, dArr3, dArr2);
        if (motionPathsArr3[0].f2219j != -1) {
            int[] iArr5 = new int[i12];
            double[] dArr8 = new double[i12];
            double[][] dArr9 = (double[][]) Array.newInstance((Class<?>) cls, i12, 2);
            for (int i33 = 0; i33 < i12; i33++) {
                iArr5[i33] = motionPathsArr3[i33].f2219j;
                dArr8[i33] = r6.f2212c;
                double[] dArr10 = dArr9[i33];
                dArr10[0] = r6.f2214e;
                dArr10[1] = r6.f2215f;
            }
            this.f2164k = new ArcCurveFit(iArr5, dArr8, dArr9);
        }
        this.z = new HashMap();
        if (arrayList != null) {
            Iterator it12 = hashSet3.iterator();
            float f96 = Float.NaN;
            while (it12.hasNext()) {
                String str11 = (String) it12.next();
                ViewOscillator viewOscillatorG = ViewOscillator.g(str11);
                if (viewOscillatorG != null) {
                    if (viewOscillatorG.f1822e == 1 && Float.isNaN(f96)) {
                        float[] fArr3 = new float[2];
                        float f97 = 1.0f / 99;
                        double d2 = 0.0d;
                        float fHypot = 0.0f;
                        double d3 = 0.0d;
                        int i34 = 0;
                        while (i34 < 100) {
                            float f98 = i34 * f97;
                            double d4 = d2;
                            double dA = f98;
                            Easing easing = motionPaths3.f2210a;
                            Iterator it13 = arrayList3.iterator();
                            float f99 = Float.NaN;
                            float f100 = 0.0f;
                            while (it13.hasNext()) {
                                MotionPaths motionPaths10 = (MotionPaths) it13.next();
                                Iterator it14 = it12;
                                Easing easing2 = motionPaths10.f2210a;
                                if (easing2 != null) {
                                    float f101 = motionPaths10.f2212c;
                                    if (f101 < f98) {
                                        f100 = f101;
                                        easing = easing2;
                                    } else if (Float.isNaN(f99)) {
                                        f99 = motionPaths10.f2212c;
                                    }
                                }
                                it12 = it14;
                            }
                            Iterator it15 = it12;
                            if (easing != null) {
                                if (Float.isNaN(f99)) {
                                    f99 = 1.0f;
                                }
                                dA = (((float) easing.a((f98 - f100) / r17)) * (f99 - f100)) + f100;
                            }
                            this.f2163j[0].d(this.p, dA);
                            float[] fArr4 = fArr3;
                            this.f2159f.c(dA, this.o, this.p, fArr4, 0);
                            if (i34 > 0) {
                                c2 = 0;
                                motionPaths2 = motionPaths3;
                                fHypot += (float) Math.hypot(d4 - fArr4[1], d3 - fArr4[0]);
                            } else {
                                motionPaths2 = motionPaths3;
                                c2 = 0;
                            }
                            d3 = fArr4[c2];
                            d2 = fArr4[1];
                            i34++;
                            it12 = it15;
                            motionPaths3 = motionPaths2;
                            fArr3 = fArr4;
                        }
                        it = it12;
                        motionPaths = motionPaths3;
                        f96 = fHypot;
                    } else {
                        it = it12;
                        motionPaths = motionPaths3;
                    }
                    viewOscillatorG.f1819b = str11;
                    this.z.put(str11, viewOscillatorG);
                    it12 = it;
                    motionPaths3 = motionPaths;
                }
            }
            Iterator it16 = arrayList.iterator();
            while (it16.hasNext()) {
                Key key6 = (Key) it16.next();
                if (key6 instanceof KeyCycle) {
                    ((KeyCycle) key6).h(this.z);
                }
            }
            Iterator it17 = this.z.values().iterator();
            while (it17.hasNext()) {
                ((ViewOscillator) it17.next()).f();
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(" start: x: ");
        MotionPaths motionPaths = this.f2159f;
        sb.append(motionPaths.f2214e);
        sb.append(" y: ");
        sb.append(motionPaths.f2215f);
        sb.append(" end: x: ");
        MotionPaths motionPaths2 = this.f2160g;
        sb.append(motionPaths2.f2214e);
        sb.append(" y: ");
        sb.append(motionPaths2.f2215f);
        return sb.toString();
    }
}
