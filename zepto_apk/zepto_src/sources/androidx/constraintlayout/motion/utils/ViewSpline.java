package androidx.constraintlayout.motion.utils;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.commons.lang3.CharUtils;

/* loaded from: classes3.dex */
public abstract class ViewSpline extends SplineSet {

    public static class AlphaSet extends ViewSpline {
        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public final void e(View view, float f2) {
            view.setAlpha(a(f2));
        }
    }

    public static class CustomSet extends ViewSpline {

        /* renamed from: f, reason: collision with root package name */
        public SparseArray f2078f;

        /* renamed from: g, reason: collision with root package name */
        public float[] f2079g;

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public final void b(float f2, int i2) {
            throw new RuntimeException("call of custom attribute setPoint");
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public final void c(int i2) {
            SparseArray sparseArray = this.f2078f;
            int size = sparseArray.size();
            int iC = ((ConstraintAttribute) sparseArray.valueAt(0)).c();
            double[] dArr = new double[size];
            this.f2079g = new float[iC];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, iC);
            for (int i3 = 0; i3 < size; i3++) {
                int iKeyAt = sparseArray.keyAt(i3);
                ConstraintAttribute constraintAttribute = (ConstraintAttribute) sparseArray.valueAt(i3);
                dArr[i3] = iKeyAt * 0.01d;
                constraintAttribute.b(this.f2079g);
                int i4 = 0;
                while (true) {
                    if (i4 < this.f2079g.length) {
                        dArr2[i3][i4] = r7[i4];
                        i4++;
                    }
                }
            }
            this.f1854a = CurveFit.a(i2, dArr, dArr2);
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public final void e(View view, float f2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            this.f1854a.c(f2, this.f2079g);
            CustomSupport.b((ConstraintAttribute) this.f2078f.valueAt(0), view, this.f2079g);
        }
    }

    public static class ElevationSet extends ViewSpline {
        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public final void e(View view, float f2) {
            view.setElevation(a(f2));
        }
    }

    public static class PathRotate extends ViewSpline {
        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public final void e(View view, float f2) {
        }
    }

    public static class PivotXset extends ViewSpline {
        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public final void e(View view, float f2) {
            view.setPivotX(a(f2));
        }
    }

    public static class PivotYset extends ViewSpline {
        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public final void e(View view, float f2) {
            view.setPivotY(a(f2));
        }
    }

    public static class ProgressSet extends ViewSpline {

        /* renamed from: f, reason: collision with root package name */
        public boolean f2080f;

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public final void e(View view, float f2) throws Exception {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(a(f2));
                return;
            }
            if (this.f2080f) {
                return;
            }
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.f2080f = true;
                method = null;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(a(f2)));
                } catch (IllegalAccessException e2) {
                    Log.e("ViewSpline", "unable to setProgress", e2);
                } catch (InvocationTargetException e3) {
                    Log.e("ViewSpline", "unable to setProgress", e3);
                }
            }
        }
    }

    public static class RotationSet extends ViewSpline {
        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public final void e(View view, float f2) {
            view.setRotation(a(f2));
        }
    }

    public static class RotationXset extends ViewSpline {
        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public final void e(View view, float f2) {
            view.setRotationX(a(f2));
        }
    }

    public static class RotationYset extends ViewSpline {
        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public final void e(View view, float f2) {
            view.setRotationY(a(f2));
        }
    }

    public static class ScaleXset extends ViewSpline {
        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public final void e(View view, float f2) {
            view.setScaleX(a(f2));
        }
    }

    public static class ScaleYset extends ViewSpline {
        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public final void e(View view, float f2) {
            view.setScaleY(a(f2));
        }
    }

    public static class TranslationXset extends ViewSpline {
        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public final void e(View view, float f2) {
            view.setTranslationX(a(f2));
        }
    }

    public static class TranslationYset extends ViewSpline {
        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public final void e(View view, float f2) {
            view.setTranslationY(a(f2));
        }
    }

    public static class TranslationZset extends ViewSpline {
        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public final void e(View view, float f2) {
            view.setTranslationZ(a(f2));
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static ViewSpline d(String str) {
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals(ReactProgressBarViewManager.PROP_PROGRESS)) {
                    c2 = 5;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c2 = 6;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c2 = 7;
                    break;
                }
                break;
            case -797520672:
                if (str.equals("waveVariesBy")) {
                    c2 = '\b';
                    break;
                }
                break;
            case -760884510:
                if (str.equals("transformPivotX")) {
                    c2 = '\t';
                    break;
                }
                break;
            case -760884509:
                if (str.equals("transformPivotY")) {
                    c2 = '\n';
                    break;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c2 = 11;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c2 = CharUtils.CR;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c2 = 14;
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c2 = 15;
                    break;
                }
                break;
        }
        switch (c2) {
            case 5:
                ProgressSet progressSet = new ProgressSet();
                progressSet.f2080f = false;
                break;
        }
        return new AlphaSet();
    }

    public abstract void e(View view, float f2);
}
