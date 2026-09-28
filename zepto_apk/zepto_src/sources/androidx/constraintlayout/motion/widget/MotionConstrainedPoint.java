package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.apache.commons.lang3.CharUtils;

/* loaded from: classes3.dex */
class MotionConstrainedPoint implements Comparable<MotionConstrainedPoint> {

    /* renamed from: c, reason: collision with root package name */
    public int f2143c;

    /* renamed from: a, reason: collision with root package name */
    public float f2141a = 0.0f;

    /* renamed from: b, reason: collision with root package name */
    public int f2142b = 0;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f2144d = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    public float f2145e = 1.0f;

    /* renamed from: f, reason: collision with root package name */
    public float f2146f = 0.0f;

    /* renamed from: g, reason: collision with root package name */
    public float f2147g = 0.0f;

    /* renamed from: h, reason: collision with root package name */
    public float f2148h = 0.0f;

    /* renamed from: i, reason: collision with root package name */
    public float f2149i = 1.0f;

    /* renamed from: j, reason: collision with root package name */
    public float f2150j = 1.0f;

    /* renamed from: k, reason: collision with root package name */
    public float f2151k = Float.NaN;

    /* renamed from: l, reason: collision with root package name */
    public float f2152l = Float.NaN;

    /* renamed from: m, reason: collision with root package name */
    public float f2153m = 0.0f;
    public float n = 0.0f;
    public float o = 0.0f;
    public float p = Float.NaN;
    public float q = Float.NaN;

    public static boolean c(float f2, float f3) {
        return (Float.isNaN(f2) || Float.isNaN(f3)) ? Float.isNaN(f2) != Float.isNaN(f3) : Math.abs(f2 - f3) > 1.0E-6f;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void a(HashMap map, int i2) {
        for (String str : map.keySet()) {
            ViewSpline viewSpline = (ViewSpline) map.get(str);
            if (viewSpline != null) {
                str.getClass();
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
                    case -760884510:
                        if (str.equals("transformPivotX")) {
                            c2 = '\b';
                            break;
                        }
                        break;
                    case -760884509:
                        if (str.equals("transformPivotY")) {
                            c2 = '\t';
                            break;
                        }
                        break;
                    case -40300674:
                        if (str.equals("rotation")) {
                            c2 = '\n';
                            break;
                        }
                        break;
                    case -4379043:
                        if (str.equals("elevation")) {
                            c2 = 11;
                            break;
                        }
                        break;
                    case 37232917:
                        if (str.equals("transitionPathRotate")) {
                            c2 = '\f';
                            break;
                        }
                        break;
                    case 92909918:
                        if (str.equals("alpha")) {
                            c2 = CharUtils.CR;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        viewSpline.b(Float.isNaN(this.f2148h) ? 0.0f : this.f2148h, i2);
                        break;
                    case 1:
                        viewSpline.b(Float.isNaN(this.f2141a) ? 0.0f : this.f2141a, i2);
                        break;
                    case 2:
                        viewSpline.b(Float.isNaN(this.f2153m) ? 0.0f : this.f2153m, i2);
                        break;
                    case 3:
                        viewSpline.b(Float.isNaN(this.n) ? 0.0f : this.n, i2);
                        break;
                    case 4:
                        viewSpline.b(Float.isNaN(this.o) ? 0.0f : this.o, i2);
                        break;
                    case 5:
                        viewSpline.b(Float.isNaN(this.q) ? 0.0f : this.q, i2);
                        break;
                    case 6:
                        viewSpline.b(Float.isNaN(this.f2149i) ? 1.0f : this.f2149i, i2);
                        break;
                    case 7:
                        viewSpline.b(Float.isNaN(this.f2150j) ? 1.0f : this.f2150j, i2);
                        break;
                    case '\b':
                        viewSpline.b(Float.isNaN(this.f2151k) ? 0.0f : this.f2151k, i2);
                        break;
                    case '\t':
                        viewSpline.b(Float.isNaN(this.f2152l) ? 0.0f : this.f2152l, i2);
                        break;
                    case '\n':
                        viewSpline.b(Float.isNaN(this.f2147g) ? 0.0f : this.f2147g, i2);
                        break;
                    case 11:
                        viewSpline.b(Float.isNaN(this.f2146f) ? 0.0f : this.f2146f, i2);
                        break;
                    case '\f':
                        viewSpline.b(Float.isNaN(this.p) ? 0.0f : this.p, i2);
                        break;
                    case '\r':
                        viewSpline.b(Float.isNaN(this.f2145e) ? 1.0f : this.f2145e, i2);
                        break;
                    default:
                        if (str.startsWith("CUSTOM")) {
                            String str2 = str.split(",")[1];
                            LinkedHashMap linkedHashMap = this.f2144d;
                            if (linkedHashMap.containsKey(str2)) {
                                ConstraintAttribute constraintAttribute = (ConstraintAttribute) linkedHashMap.get(str2);
                                if (viewSpline instanceof ViewSpline.CustomSet) {
                                    ((ViewSpline.CustomSet) viewSpline).f2078f.append(i2, constraintAttribute);
                                    break;
                                } else {
                                    Log.e("MotionPaths", str + " ViewSpline not a CustomSet frame = " + i2 + ", value" + constraintAttribute.a() + viewSpline);
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            Log.e("MotionPaths", "UNKNOWN spline ".concat(str));
                            break;
                        }
                }
            }
        }
    }

    public final void b(View view) {
        this.f2143c = view.getVisibility();
        this.f2145e = view.getVisibility() != 0 ? 0.0f : view.getAlpha();
        this.f2146f = view.getElevation();
        this.f2147g = view.getRotation();
        this.f2148h = view.getRotationX();
        this.f2141a = view.getRotationY();
        this.f2149i = view.getScaleX();
        this.f2150j = view.getScaleY();
        this.f2151k = view.getPivotX();
        this.f2152l = view.getPivotY();
        this.f2153m = view.getTranslationX();
        this.n = view.getTranslationY();
        this.o = view.getTranslationZ();
    }

    @Override // java.lang.Comparable
    public final int compareTo(MotionConstrainedPoint motionConstrainedPoint) {
        motionConstrainedPoint.getClass();
        return Float.compare(0.0f, 0.0f);
    }

    public final void d(Rect rect, ConstraintSet constraintSet, int i2, int i3) {
        rect.width();
        rect.height();
        ConstraintSet.Constraint constraintI = constraintSet.i(i3);
        ConstraintSet.PropertySet propertySet = constraintI.f2461c;
        int i4 = propertySet.f2507c;
        this.f2142b = i4;
        int i5 = propertySet.f2506b;
        this.f2143c = i5;
        this.f2145e = (i5 == 0 || i4 != 0) ? propertySet.f2508d : 0.0f;
        ConstraintSet.Transform transform = constraintI.f2464f;
        boolean z = transform.f2522m;
        this.f2146f = transform.n;
        this.f2147g = transform.f2511b;
        this.f2148h = transform.f2512c;
        this.f2141a = transform.f2513d;
        this.f2149i = transform.f2514e;
        this.f2150j = transform.f2515f;
        this.f2151k = transform.f2516g;
        this.f2152l = transform.f2517h;
        this.f2153m = transform.f2519j;
        this.n = transform.f2520k;
        this.o = transform.f2521l;
        ConstraintSet.Motion motion = constraintI.f2462d;
        Easing.c(motion.f2495d);
        this.p = motion.f2499h;
        this.q = constraintI.f2461c.f2509e;
        for (String str : constraintI.f2465g.keySet()) {
            ConstraintAttribute constraintAttribute = (ConstraintAttribute) constraintI.f2465g.get(str);
            int iOrdinal = constraintAttribute.f2373c.ordinal();
            if (iOrdinal != 4 && iOrdinal != 5 && iOrdinal != 7) {
                this.f2144d.put(str, constraintAttribute);
            }
        }
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        return;
                    }
                }
            }
            float f2 = this.f2147g + 90.0f;
            this.f2147g = f2;
            if (f2 > 180.0f) {
                this.f2147g = f2 - 360.0f;
                return;
            }
            return;
        }
        this.f2147g -= 90.0f;
    }
}
