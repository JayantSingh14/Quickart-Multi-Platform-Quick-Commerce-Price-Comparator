package androidx.constraintlayout.motion.utils;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes3.dex */
public abstract class ViewTimeCycle extends TimeCycleSplineSet {

    public static class AlphaSet extends ViewTimeCycle {
        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public final boolean f(float f2, long j2, View view, KeyCache keyCache) {
            view.setAlpha(d(f2, j2, view, keyCache));
            return this.f1891h;
        }
    }

    public static class CustomSet extends ViewTimeCycle {

        /* renamed from: k, reason: collision with root package name */
        public String f2081k;

        /* renamed from: l, reason: collision with root package name */
        public SparseArray f2082l;

        /* renamed from: m, reason: collision with root package name */
        public SparseArray f2083m;
        public float[] n;

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public final void b(float f2, float f3, float f4, int i2, int i3) {
            throw new RuntimeException("Wrong call for custom attribute");
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public final void c(int i2) {
            SparseArray sparseArray = this.f2082l;
            int size = sparseArray.size();
            int iC = ((ConstraintAttribute) sparseArray.valueAt(0)).c();
            double[] dArr = new double[size];
            int i3 = iC + 2;
            this.n = new float[i3];
            this.f1890g = new float[iC];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, i3);
            for (int i4 = 0; i4 < size; i4++) {
                int iKeyAt = sparseArray.keyAt(i4);
                ConstraintAttribute constraintAttribute = (ConstraintAttribute) sparseArray.valueAt(i4);
                float[] fArr = (float[]) this.f2083m.valueAt(i4);
                dArr[i4] = iKeyAt * 0.01d;
                constraintAttribute.b(this.n);
                int i5 = 0;
                while (true) {
                    if (i5 < this.n.length) {
                        dArr2[i4][i5] = r10[i5];
                        i5++;
                    }
                }
                double[] dArr3 = dArr2[i4];
                dArr3[iC] = fArr[0];
                dArr3[iC + 1] = fArr[1];
            }
            this.f1884a = CurveFit.a(i2, dArr, dArr2);
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public final boolean f(float f2, long j2, View view, KeyCache keyCache) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            this.f1884a.c(f2, this.n);
            float[] fArr = this.n;
            float f3 = fArr[fArr.length - 2];
            float f4 = fArr[fArr.length - 1];
            long j3 = j2 - this.f1892i;
            if (Float.isNaN(this.f1893j)) {
                float fA = keyCache.a(view, this.f2081k);
                this.f1893j = fA;
                if (Float.isNaN(fA)) {
                    this.f1893j = 0.0f;
                }
            }
            float f5 = (float) ((((j3 * 1.0E-9d) * f3) + this.f1893j) % 1.0d);
            this.f1893j = f5;
            this.f1892i = j2;
            float fA2 = a(f5);
            this.f1891h = false;
            int i2 = 0;
            while (true) {
                float[] fArr2 = this.f1890g;
                if (i2 >= fArr2.length) {
                    break;
                }
                boolean z = this.f1891h;
                float f6 = this.n[i2];
                this.f1891h = z | (((double) f6) != 0.0d);
                fArr2[i2] = (f6 * fA2) + f4;
                i2++;
            }
            CustomSupport.b((ConstraintAttribute) this.f2082l.valueAt(0), view, this.f1890g);
            if (f3 != 0.0f) {
                this.f1891h = true;
            }
            return this.f1891h;
        }
    }

    public static class ElevationSet extends ViewTimeCycle {
        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public final boolean f(float f2, long j2, View view, KeyCache keyCache) {
            view.setElevation(d(f2, j2, view, keyCache));
            return this.f1891h;
        }
    }

    public static class PathRotate extends ViewTimeCycle {
        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public final boolean f(float f2, long j2, View view, KeyCache keyCache) {
            return this.f1891h;
        }
    }

    public static class ProgressSet extends ViewTimeCycle {

        /* renamed from: k, reason: collision with root package name */
        public boolean f2084k;

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public final boolean f(float f2, long j2, View view, KeyCache keyCache) throws Exception {
            Method method;
            ProgressSet progressSet;
            float fD;
            if (view instanceof MotionLayout) {
                float fD2 = d(f2, j2, view, keyCache);
                progressSet = this;
                ((MotionLayout) view).setProgress(fD2);
            } else {
                if (this.f2084k) {
                    return false;
                }
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.f2084k = true;
                    method = null;
                }
                if (method != null) {
                    try {
                        fD = d(f2, j2, view, keyCache);
                        progressSet = this;
                    } catch (IllegalAccessException e2) {
                        e = e2;
                        progressSet = this;
                    } catch (InvocationTargetException e3) {
                        e = e3;
                        progressSet = this;
                    }
                    try {
                        method.invoke(view, Float.valueOf(fD));
                    } catch (IllegalAccessException e4) {
                        e = e4;
                        Log.e("ViewTimeCycle", "unable to setProgress", e);
                        return progressSet.f1891h;
                    } catch (InvocationTargetException e5) {
                        e = e5;
                        Log.e("ViewTimeCycle", "unable to setProgress", e);
                        return progressSet.f1891h;
                    }
                } else {
                    progressSet = this;
                }
            }
            return progressSet.f1891h;
        }
    }

    public static class RotationSet extends ViewTimeCycle {
        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public final boolean f(float f2, long j2, View view, KeyCache keyCache) {
            view.setRotation(d(f2, j2, view, keyCache));
            return this.f1891h;
        }
    }

    public static class RotationXset extends ViewTimeCycle {
        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public final boolean f(float f2, long j2, View view, KeyCache keyCache) {
            view.setRotationX(d(f2, j2, view, keyCache));
            return this.f1891h;
        }
    }

    public static class RotationYset extends ViewTimeCycle {
        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public final boolean f(float f2, long j2, View view, KeyCache keyCache) {
            view.setRotationY(d(f2, j2, view, keyCache));
            return this.f1891h;
        }
    }

    public static class ScaleXset extends ViewTimeCycle {
        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public final boolean f(float f2, long j2, View view, KeyCache keyCache) {
            view.setScaleX(d(f2, j2, view, keyCache));
            return this.f1891h;
        }
    }

    public static class ScaleYset extends ViewTimeCycle {
        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public final boolean f(float f2, long j2, View view, KeyCache keyCache) {
            view.setScaleY(d(f2, j2, view, keyCache));
            return this.f1891h;
        }
    }

    public static class TranslationXset extends ViewTimeCycle {
        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public final boolean f(float f2, long j2, View view, KeyCache keyCache) {
            view.setTranslationX(d(f2, j2, view, keyCache));
            return this.f1891h;
        }
    }

    public static class TranslationYset extends ViewTimeCycle {
        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public final boolean f(float f2, long j2, View view, KeyCache keyCache) {
            view.setTranslationY(d(f2, j2, view, keyCache));
            return this.f1891h;
        }
    }

    public static class TranslationZset extends ViewTimeCycle {
        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public final boolean f(float f2, long j2, View view, KeyCache keyCache) {
            view.setTranslationZ(d(f2, j2, view, keyCache));
            return this.f1891h;
        }
    }

    public static ViewTimeCycle e(long j2, String str) {
        ViewTimeCycle rotationXset;
        switch (str) {
            case "rotationX":
                rotationXset = new RotationXset();
                break;
            case "rotationY":
                rotationXset = new RotationYset();
                break;
            case "translationX":
                rotationXset = new TranslationXset();
                break;
            case "translationY":
                rotationXset = new TranslationYset();
                break;
            case "translationZ":
                rotationXset = new TranslationZset();
                break;
            case "progress":
                ProgressSet progressSet = new ProgressSet();
                progressSet.f2084k = false;
                rotationXset = progressSet;
                break;
            case "scaleX":
                rotationXset = new ScaleXset();
                break;
            case "scaleY":
                rotationXset = new ScaleYset();
                break;
            case "rotation":
                rotationXset = new RotationSet();
                break;
            case "elevation":
                rotationXset = new ElevationSet();
                break;
            case "transitionPathRotate":
                rotationXset = new PathRotate();
                break;
            case "alpha":
                rotationXset = new AlphaSet();
                break;
            default:
                return null;
        }
        rotationXset.f1892i = j2;
        return rotationXset;
    }

    public final float d(float f2, long j2, View view, KeyCache keyCache) {
        this.f1884a.c(f2, this.f1890g);
        float[] fArr = this.f1890g;
        boolean z = true;
        float f3 = fArr[1];
        if (f3 == 0.0f) {
            this.f1891h = false;
            return fArr[2];
        }
        if (Float.isNaN(this.f1893j)) {
            float fA = keyCache.a(view, this.f1889f);
            this.f1893j = fA;
            if (Float.isNaN(fA)) {
                this.f1893j = 0.0f;
            }
        }
        float f4 = (float) (((((j2 - this.f1892i) * 1.0E-9d) * f3) + this.f1893j) % 1.0d);
        this.f1893j = f4;
        String str = this.f1889f;
        HashMap map = keyCache.f1817a;
        if (map.containsKey(view)) {
            HashMap map2 = (HashMap) map.get(view);
            if (map2 == null) {
                map2 = new HashMap();
            }
            if (map2.containsKey(str)) {
                float[] fArrCopyOf = (float[]) map2.get(str);
                if (fArrCopyOf == null) {
                    fArrCopyOf = new float[0];
                }
                if (fArrCopyOf.length <= 0) {
                    fArrCopyOf = Arrays.copyOf(fArrCopyOf, 1);
                }
                fArrCopyOf[0] = f4;
                map2.put(str, fArrCopyOf);
            } else {
                map2.put(str, new float[]{f4});
                map.put(view, map2);
            }
        } else {
            HashMap map3 = new HashMap();
            map3.put(str, new float[]{f4});
            map.put(view, map3);
        }
        this.f1892i = j2;
        float f5 = this.f1890g[0];
        float fA2 = (a(this.f1893j) * f5) + this.f1890g[2];
        if (f5 == 0.0f && f3 == 0.0f) {
            z = false;
        }
        this.f1891h = z;
        return fA2;
    }

    public abstract boolean f(float f2, long j2, View view, KeyCache keyCache);
}
