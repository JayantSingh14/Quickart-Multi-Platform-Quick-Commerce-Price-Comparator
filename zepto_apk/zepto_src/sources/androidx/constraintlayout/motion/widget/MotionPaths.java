package androidx.constraintlayout.motion.widget;

import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.util.LinkedHashMap;

/* loaded from: classes3.dex */
class MotionPaths implements Comparable<MotionPaths> {
    public static final String[] r = {"position", "x", "y", Snapshot.WIDTH, Snapshot.HEIGHT, "pathRotate"};

    /* renamed from: a, reason: collision with root package name */
    public Easing f2210a;

    /* renamed from: c, reason: collision with root package name */
    public float f2212c;

    /* renamed from: d, reason: collision with root package name */
    public float f2213d;

    /* renamed from: e, reason: collision with root package name */
    public float f2214e;

    /* renamed from: f, reason: collision with root package name */
    public float f2215f;

    /* renamed from: g, reason: collision with root package name */
    public float f2216g;

    /* renamed from: h, reason: collision with root package name */
    public float f2217h;

    /* renamed from: b, reason: collision with root package name */
    public int f2211b = 0;

    /* renamed from: i, reason: collision with root package name */
    public float f2218i = Float.NaN;

    /* renamed from: j, reason: collision with root package name */
    public int f2219j = -1;

    /* renamed from: k, reason: collision with root package name */
    public int f2220k = -1;

    /* renamed from: l, reason: collision with root package name */
    public float f2221l = Float.NaN;

    /* renamed from: m, reason: collision with root package name */
    public MotionController f2222m = null;
    public LinkedHashMap n = new LinkedHashMap();
    public int o = 0;
    public double[] p = new double[18];
    public double[] q = new double[18];

    public static boolean b(float f2, float f3) {
        return (Float.isNaN(f2) || Float.isNaN(f3)) ? Float.isNaN(f2) != Float.isNaN(f3) : Math.abs(f2 - f3) > 1.0E-6f;
    }

    public static void e(float f2, float f3, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f8 = (float) dArr[i2];
            double d2 = dArr2[i2];
            int i3 = iArr[i2];
            if (i3 == 1) {
                f4 = f8;
            } else if (i3 == 2) {
                f6 = f8;
            } else if (i3 == 3) {
                f5 = f8;
            } else if (i3 == 4) {
                f7 = f8;
            }
        }
        float f9 = f4 - ((0.0f * f5) / 2.0f);
        float f10 = f6 - ((0.0f * f7) / 2.0f);
        fArr[0] = (((f5 * 1.0f) + f9) * f2) + ((1.0f - f2) * f9) + 0.0f;
        fArr[1] = (((f7 * 1.0f) + f10) * f3) + ((1.0f - f3) * f10) + 0.0f;
    }

    public final void a(ConstraintSet.Constraint constraint) {
        int iOrdinal;
        this.f2210a = Easing.c(constraint.f2462d.f2495d);
        ConstraintSet.Motion motion = constraint.f2462d;
        this.f2219j = motion.f2496e;
        this.f2220k = motion.f2493b;
        this.f2218i = motion.f2499h;
        this.f2211b = motion.f2497f;
        float f2 = constraint.f2461c.f2509e;
        this.f2221l = constraint.f2463e.C;
        for (String str : constraint.f2465g.keySet()) {
            ConstraintAttribute constraintAttribute = (ConstraintAttribute) constraint.f2465g.get(str);
            if (constraintAttribute != null && (iOrdinal = constraintAttribute.f2373c.ordinal()) != 4 && iOrdinal != 5 && iOrdinal != 7) {
                this.n.put(str, constraintAttribute);
            }
        }
    }

    public final void c(double d2, int[] iArr, double[] dArr, float[] fArr, int i2) {
        float fSin = this.f2214e;
        float fCos = this.f2215f;
        float f2 = this.f2216g;
        float f3 = this.f2217h;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            float f4 = (float) dArr[i3];
            int i4 = iArr[i3];
            if (i4 == 1) {
                fSin = f4;
            } else if (i4 == 2) {
                fCos = f4;
            } else if (i4 == 3) {
                f2 = f4;
            } else if (i4 == 4) {
                f3 = f4;
            }
        }
        MotionController motionController = this.f2222m;
        if (motionController != null) {
            float[] fArr2 = new float[2];
            motionController.c(d2, fArr2, new float[2]);
            float f5 = fArr2[0];
            float f6 = fArr2[1];
            double d3 = f5;
            double d4 = fSin;
            double d5 = fCos;
            fSin = (float) (((Math.sin(d5) * d4) + d3) - (f2 / 2.0f));
            fCos = (float) ((f6 - (Math.cos(d5) * d4)) - (f3 / 2.0f));
        }
        fArr[i2] = (f2 / 2.0f) + fSin + 0.0f;
        fArr[i2 + 1] = (f3 / 2.0f) + fCos + 0.0f;
    }

    @Override // java.lang.Comparable
    public final int compareTo(MotionPaths motionPaths) {
        return Float.compare(this.f2213d, motionPaths.f2213d);
    }

    public final void d(float f2, float f3, float f4, float f5) {
        this.f2214e = f2;
        this.f2215f = f3;
        this.f2216g = f4;
        this.f2217h = f5;
    }

    public final void g(MotionController motionController, MotionPaths motionPaths) {
        double d2 = (((this.f2216g / 2.0f) + this.f2214e) - motionPaths.f2214e) - (motionPaths.f2216g / 2.0f);
        double d3 = (((this.f2217h / 2.0f) + this.f2215f) - motionPaths.f2215f) - (motionPaths.f2217h / 2.0f);
        this.f2222m = motionController;
        this.f2214e = (float) Math.hypot(d3, d2);
        if (Float.isNaN(this.f2221l)) {
            this.f2215f = (float) (Math.atan2(d3, d2) + 1.5707963267948966d);
        } else {
            this.f2215f = (float) Math.toRadians(this.f2221l);
        }
    }
}
