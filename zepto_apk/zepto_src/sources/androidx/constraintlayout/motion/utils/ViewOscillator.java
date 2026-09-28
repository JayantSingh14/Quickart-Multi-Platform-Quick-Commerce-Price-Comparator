package androidx.constraintlayout.motion.utils;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.commons.lang3.CharUtils;

/* loaded from: classes3.dex */
public abstract class ViewOscillator extends KeyCycleOscillator {

    public static class AlphaSet extends ViewOscillator {
        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public final void h(View view, float f2) {
            view.setAlpha(a(f2));
        }
    }

    public static class CustomSet extends ViewOscillator {

        /* renamed from: g, reason: collision with root package name */
        public final float[] f2075g = new float[1];

        /* renamed from: h, reason: collision with root package name */
        public ConstraintAttribute f2076h;

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        public final void c(ConstraintAttribute constraintAttribute) {
            this.f2076h = constraintAttribute;
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public final void h(View view, float f2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            float fA = a(f2);
            float[] fArr = this.f2075g;
            fArr[0] = fA;
            CustomSupport.b(this.f2076h, view, fArr);
        }
    }

    public static class ElevationSet extends ViewOscillator {
        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public final void h(View view, float f2) {
            view.setElevation(a(f2));
        }
    }

    public static class PathRotateSet extends ViewOscillator {
        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public final void h(View view, float f2) {
        }
    }

    public static class ProgressSet extends ViewOscillator {

        /* renamed from: g, reason: collision with root package name */
        public boolean f2077g;

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public final void h(View view, float f2) throws Exception {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(a(f2));
                return;
            }
            if (this.f2077g) {
                return;
            }
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.f2077g = true;
                method = null;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(a(f2)));
                } catch (IllegalAccessException e2) {
                    Log.e("ViewOscillator", "unable to setProgress", e2);
                } catch (InvocationTargetException e3) {
                    Log.e("ViewOscillator", "unable to setProgress", e3);
                }
            }
        }
    }

    public static class RotationSet extends ViewOscillator {
        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public final void h(View view, float f2) {
            view.setRotation(a(f2));
        }
    }

    public static class RotationXset extends ViewOscillator {
        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public final void h(View view, float f2) {
            view.setRotationX(a(f2));
        }
    }

    public static class RotationYset extends ViewOscillator {
        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public final void h(View view, float f2) {
            view.setRotationY(a(f2));
        }
    }

    public static class ScaleXset extends ViewOscillator {
        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public final void h(View view, float f2) {
            view.setScaleX(a(f2));
        }
    }

    public static class ScaleYset extends ViewOscillator {
        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public final void h(View view, float f2) {
            view.setScaleY(a(f2));
        }
    }

    public static class TranslationXset extends ViewOscillator {
        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public final void h(View view, float f2) {
            view.setTranslationX(a(f2));
        }
    }

    public static class TranslationYset extends ViewOscillator {
        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public final void h(View view, float f2) {
            view.setTranslationY(a(f2));
        }
    }

    public static class TranslationZset extends ViewOscillator {
        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public final void h(View view, float f2) {
            view.setTranslationZ(a(f2));
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static ViewOscillator g(String str) {
        if (str.startsWith("CUSTOM")) {
            return new CustomSet();
        }
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
            case -40300674:
                if (str.equals("rotation")) {
                    c2 = '\t';
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c2 = 11;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c2 = CharUtils.CR;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return new RotationXset();
            case 1:
                return new RotationYset();
            case 2:
                return new TranslationXset();
            case 3:
                return new TranslationYset();
            case 4:
                return new TranslationZset();
            case 5:
                ProgressSet progressSet = new ProgressSet();
                progressSet.f2077g = false;
                return progressSet;
            case 6:
                return new ScaleXset();
            case 7:
                return new ScaleYset();
            case '\b':
                return new AlphaSet();
            case '\t':
                return new RotationSet();
            case '\n':
                return new ElevationSet();
            case 11:
                return new PathRotateSet();
            case '\f':
                return new AlphaSet();
            case '\r':
                return new AlphaSet();
            default:
                return null;
        }
    }

    public abstract void h(View view, float f2);
}
