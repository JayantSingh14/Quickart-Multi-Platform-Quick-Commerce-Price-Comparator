package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.commons.lang3.CharUtils;

/* loaded from: classes3.dex */
public class KeyCycle extends Key {

    /* renamed from: e, reason: collision with root package name */
    public int f2099e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f2100f = -1;

    /* renamed from: g, reason: collision with root package name */
    public String f2101g = null;

    /* renamed from: h, reason: collision with root package name */
    public float f2102h = Float.NaN;

    /* renamed from: i, reason: collision with root package name */
    public float f2103i = 0.0f;

    /* renamed from: j, reason: collision with root package name */
    public float f2104j = 0.0f;

    /* renamed from: k, reason: collision with root package name */
    public float f2105k = Float.NaN;

    /* renamed from: l, reason: collision with root package name */
    public int f2106l = -1;

    /* renamed from: m, reason: collision with root package name */
    public float f2107m = Float.NaN;
    public float n = Float.NaN;
    public float o = Float.NaN;
    public float p = Float.NaN;
    public float q = Float.NaN;
    public float r = Float.NaN;
    public float s = Float.NaN;
    public float t = Float.NaN;
    public float u = Float.NaN;
    public float v = Float.NaN;
    public float w = Float.NaN;

    public static class Loader {

        /* renamed from: a, reason: collision with root package name */
        public static final SparseIntArray f2108a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f2108a = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyCycle_motionTarget, 1);
            sparseIntArray.append(R.styleable.KeyCycle_framePosition, 2);
            sparseIntArray.append(R.styleable.KeyCycle_transitionEasing, 3);
            sparseIntArray.append(R.styleable.KeyCycle_curveFit, 4);
            sparseIntArray.append(R.styleable.KeyCycle_waveShape, 5);
            sparseIntArray.append(R.styleable.KeyCycle_wavePeriod, 6);
            sparseIntArray.append(R.styleable.KeyCycle_waveOffset, 7);
            sparseIntArray.append(R.styleable.KeyCycle_waveVariesBy, 8);
            sparseIntArray.append(R.styleable.KeyCycle_android_alpha, 9);
            sparseIntArray.append(R.styleable.KeyCycle_android_elevation, 10);
            sparseIntArray.append(R.styleable.KeyCycle_android_rotation, 11);
            sparseIntArray.append(R.styleable.KeyCycle_android_rotationX, 12);
            sparseIntArray.append(R.styleable.KeyCycle_android_rotationY, 13);
            sparseIntArray.append(R.styleable.KeyCycle_transitionPathRotate, 14);
            sparseIntArray.append(R.styleable.KeyCycle_android_scaleX, 15);
            sparseIntArray.append(R.styleable.KeyCycle_android_scaleY, 16);
            sparseIntArray.append(R.styleable.KeyCycle_android_translationX, 17);
            sparseIntArray.append(R.styleable.KeyCycle_android_translationY, 18);
            sparseIntArray.append(R.styleable.KeyCycle_android_translationZ, 19);
            sparseIntArray.append(R.styleable.KeyCycle_motionProgress, 20);
            sparseIntArray.append(R.styleable.KeyCycle_wavePhase, 21);
        }
    }

    public KeyCycle() {
        this.f2088d = new HashMap();
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public final void a(HashMap map) {
        throw null;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* renamed from: b */
    public final Key clone() {
        KeyCycle keyCycle = new KeyCycle();
        super.c(this);
        keyCycle.f2099e = this.f2099e;
        keyCycle.f2100f = this.f2100f;
        keyCycle.f2101g = this.f2101g;
        keyCycle.f2102h = this.f2102h;
        keyCycle.f2103i = this.f2103i;
        keyCycle.f2104j = this.f2104j;
        keyCycle.f2105k = this.f2105k;
        keyCycle.f2106l = this.f2106l;
        keyCycle.f2107m = this.f2107m;
        keyCycle.n = this.n;
        keyCycle.o = this.o;
        keyCycle.p = this.p;
        keyCycle.q = this.q;
        keyCycle.r = this.r;
        keyCycle.s = this.s;
        keyCycle.t = this.t;
        keyCycle.u = this.u;
        keyCycle.v = this.v;
        keyCycle.w = this.w;
        return keyCycle;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public final void d(HashSet hashSet) {
        if (!Float.isNaN(this.f2107m)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.n)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.o)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.q)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.r)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.s)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.t)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.p)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.u)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.v)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.w)) {
            hashSet.add("translationZ");
        }
        if (this.f2088d.size() > 0) {
            Iterator it = this.f2088d.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + ((String) it.next()));
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public final void e(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.KeyCycle);
        SparseIntArray sparseIntArray = Loader.f2108a;
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i2);
            SparseIntArray sparseIntArray2 = Loader.f2108a;
            switch (sparseIntArray2.get(index)) {
                case 1:
                    if (MotionLayout.o1) {
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f2086b);
                        this.f2086b = resourceId;
                        if (resourceId == -1) {
                            this.f2087c = typedArrayObtainStyledAttributes.getString(index);
                            break;
                        } else {
                            break;
                        }
                    } else if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                        this.f2087c = typedArrayObtainStyledAttributes.getString(index);
                        break;
                    } else {
                        this.f2086b = typedArrayObtainStyledAttributes.getResourceId(index, this.f2086b);
                        break;
                    }
                case 2:
                    this.f2085a = typedArrayObtainStyledAttributes.getInt(index, this.f2085a);
                    break;
                case 3:
                    typedArrayObtainStyledAttributes.getString(index);
                    break;
                case 4:
                    this.f2099e = typedArrayObtainStyledAttributes.getInteger(index, this.f2099e);
                    break;
                case 5:
                    if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                        this.f2101g = typedArrayObtainStyledAttributes.getString(index);
                        this.f2100f = 7;
                        break;
                    } else {
                        this.f2100f = typedArrayObtainStyledAttributes.getInt(index, this.f2100f);
                        break;
                    }
                case 6:
                    this.f2102h = typedArrayObtainStyledAttributes.getFloat(index, this.f2102h);
                    break;
                case 7:
                    if (typedArrayObtainStyledAttributes.peekValue(index).type == 5) {
                        this.f2103i = typedArrayObtainStyledAttributes.getDimension(index, this.f2103i);
                        break;
                    } else {
                        this.f2103i = typedArrayObtainStyledAttributes.getFloat(index, this.f2103i);
                        break;
                    }
                case 8:
                    this.f2106l = typedArrayObtainStyledAttributes.getInt(index, this.f2106l);
                    break;
                case 9:
                    this.f2107m = typedArrayObtainStyledAttributes.getFloat(index, this.f2107m);
                    break;
                case 10:
                    this.n = typedArrayObtainStyledAttributes.getDimension(index, this.n);
                    break;
                case 11:
                    this.o = typedArrayObtainStyledAttributes.getFloat(index, this.o);
                    break;
                case 12:
                    this.q = typedArrayObtainStyledAttributes.getFloat(index, this.q);
                    break;
                case 13:
                    this.r = typedArrayObtainStyledAttributes.getFloat(index, this.r);
                    break;
                case 14:
                    this.p = typedArrayObtainStyledAttributes.getFloat(index, this.p);
                    break;
                case 15:
                    this.s = typedArrayObtainStyledAttributes.getFloat(index, this.s);
                    break;
                case 16:
                    this.t = typedArrayObtainStyledAttributes.getFloat(index, this.t);
                    break;
                case 17:
                    this.u = typedArrayObtainStyledAttributes.getDimension(index, this.u);
                    break;
                case 18:
                    this.v = typedArrayObtainStyledAttributes.getDimension(index, this.v);
                    break;
                case 19:
                    this.w = typedArrayObtainStyledAttributes.getDimension(index, this.w);
                    break;
                case 20:
                    this.f2105k = typedArrayObtainStyledAttributes.getFloat(index, this.f2105k);
                    break;
                case 21:
                    this.f2104j = typedArrayObtainStyledAttributes.getFloat(index, this.f2104j) / 360.0f;
                    break;
                default:
                    Log.e("KeyCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray2.get(index));
                    break;
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void h(HashMap map) {
        ViewOscillator viewOscillator;
        float f2;
        ViewOscillator viewOscillator2;
        for (String str : map.keySet()) {
            if (str.startsWith("CUSTOM")) {
                ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.f2088d.get(str.substring(7));
                if (constraintAttribute != null) {
                    if (constraintAttribute.f2373c == ConstraintAttribute.AttributeType.f2380b && (viewOscillator = (ViewOscillator) map.get(str)) != null) {
                        viewOscillator.e(this.f2085a, this.f2100f, this.f2101g, this.f2106l, this.f2102h, this.f2103i, this.f2104j, constraintAttribute.a(), constraintAttribute);
                    }
                }
            } else {
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
                    case -40300674:
                        if (str.equals("rotation")) {
                            c2 = '\b';
                            break;
                        }
                        break;
                    case -4379043:
                        if (str.equals("elevation")) {
                            c2 = '\t';
                            break;
                        }
                        break;
                    case 37232917:
                        if (str.equals("transitionPathRotate")) {
                            c2 = '\n';
                            break;
                        }
                        break;
                    case 92909918:
                        if (str.equals("alpha")) {
                            c2 = 11;
                            break;
                        }
                        break;
                    case 156108012:
                        if (str.equals("waveOffset")) {
                            c2 = '\f';
                            break;
                        }
                        break;
                    case 1530034690:
                        if (str.equals("wavePhase")) {
                            c2 = CharUtils.CR;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        f2 = this.q;
                        break;
                    case 1:
                        f2 = this.r;
                        break;
                    case 2:
                        f2 = this.u;
                        break;
                    case 3:
                        f2 = this.v;
                        break;
                    case 4:
                        f2 = this.w;
                        break;
                    case 5:
                        f2 = this.f2105k;
                        break;
                    case 6:
                        f2 = this.s;
                        break;
                    case 7:
                        f2 = this.t;
                        break;
                    case '\b':
                        f2 = this.o;
                        break;
                    case '\t':
                        f2 = this.n;
                        break;
                    case '\n':
                        f2 = this.p;
                        break;
                    case 11:
                        f2 = this.f2107m;
                        break;
                    case '\f':
                        f2 = this.f2103i;
                        break;
                    case '\r':
                        f2 = this.f2104j;
                        break;
                    default:
                        if (!str.startsWith("CUSTOM")) {
                            Log.v("WARNING! KeyCycle", "  UNKNOWN  ".concat(str));
                        }
                        f2 = Float.NaN;
                        break;
                }
                float f3 = f2;
                if (!Float.isNaN(f3) && (viewOscillator2 = (ViewOscillator) map.get(str)) != null) {
                    viewOscillator2.d(this.f2085a, this.f2100f, this.f2101g, this.f2106l, this.f2102h, this.f2103i, this.f2104j, f3);
                }
            }
        }
    }
}
