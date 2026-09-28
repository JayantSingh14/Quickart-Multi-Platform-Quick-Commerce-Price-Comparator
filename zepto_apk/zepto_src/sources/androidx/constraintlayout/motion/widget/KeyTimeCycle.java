package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.media.b;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.utils.ViewTimeCycle;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class KeyTimeCycle extends Key {

    /* renamed from: e, reason: collision with root package name */
    public int f2121e = -1;

    /* renamed from: f, reason: collision with root package name */
    public float f2122f = Float.NaN;

    /* renamed from: g, reason: collision with root package name */
    public float f2123g = Float.NaN;

    /* renamed from: h, reason: collision with root package name */
    public float f2124h = Float.NaN;

    /* renamed from: i, reason: collision with root package name */
    public float f2125i = Float.NaN;

    /* renamed from: j, reason: collision with root package name */
    public float f2126j = Float.NaN;

    /* renamed from: k, reason: collision with root package name */
    public float f2127k = Float.NaN;

    /* renamed from: l, reason: collision with root package name */
    public float f2128l = Float.NaN;

    /* renamed from: m, reason: collision with root package name */
    public float f2129m = Float.NaN;
    public float n = Float.NaN;
    public float o = Float.NaN;
    public float p = Float.NaN;
    public float q = Float.NaN;
    public int r = 0;
    public float s = Float.NaN;
    public float t = 0.0f;

    public static class Loader {

        /* renamed from: a, reason: collision with root package name */
        public static final SparseIntArray f2130a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f2130a = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyTimeCycle_android_alpha, 1);
            sparseIntArray.append(R.styleable.KeyTimeCycle_android_elevation, 2);
            sparseIntArray.append(R.styleable.KeyTimeCycle_android_rotation, 4);
            sparseIntArray.append(R.styleable.KeyTimeCycle_android_rotationX, 5);
            sparseIntArray.append(R.styleable.KeyTimeCycle_android_rotationY, 6);
            sparseIntArray.append(R.styleable.KeyTimeCycle_android_scaleX, 7);
            sparseIntArray.append(R.styleable.KeyTimeCycle_transitionPathRotate, 8);
            sparseIntArray.append(R.styleable.KeyTimeCycle_transitionEasing, 9);
            sparseIntArray.append(R.styleable.KeyTimeCycle_motionTarget, 10);
            sparseIntArray.append(R.styleable.KeyTimeCycle_framePosition, 12);
            sparseIntArray.append(R.styleable.KeyTimeCycle_curveFit, 13);
            sparseIntArray.append(R.styleable.KeyTimeCycle_android_scaleY, 14);
            sparseIntArray.append(R.styleable.KeyTimeCycle_android_translationX, 15);
            sparseIntArray.append(R.styleable.KeyTimeCycle_android_translationY, 16);
            sparseIntArray.append(R.styleable.KeyTimeCycle_android_translationZ, 17);
            sparseIntArray.append(R.styleable.KeyTimeCycle_motionProgress, 18);
            sparseIntArray.append(R.styleable.KeyTimeCycle_wavePeriod, 20);
            sparseIntArray.append(R.styleable.KeyTimeCycle_waveOffset, 21);
            sparseIntArray.append(R.styleable.KeyTimeCycle_waveShape, 19);
        }
    }

    public KeyTimeCycle() {
        this.f2088d = new HashMap();
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public final void a(HashMap map) {
        throw null;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* renamed from: b */
    public final Key clone() {
        KeyTimeCycle keyTimeCycle = new KeyTimeCycle();
        super.c(this);
        keyTimeCycle.f2121e = this.f2121e;
        keyTimeCycle.r = this.r;
        keyTimeCycle.s = this.s;
        keyTimeCycle.t = this.t;
        keyTimeCycle.q = this.q;
        keyTimeCycle.f2122f = this.f2122f;
        keyTimeCycle.f2123g = this.f2123g;
        keyTimeCycle.f2124h = this.f2124h;
        keyTimeCycle.f2127k = this.f2127k;
        keyTimeCycle.f2125i = this.f2125i;
        keyTimeCycle.f2126j = this.f2126j;
        keyTimeCycle.f2128l = this.f2128l;
        keyTimeCycle.f2129m = this.f2129m;
        keyTimeCycle.n = this.n;
        keyTimeCycle.o = this.o;
        keyTimeCycle.p = this.p;
        return keyTimeCycle;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public final void d(HashSet hashSet) {
        if (!Float.isNaN(this.f2122f)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f2123g)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f2124h)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f2125i)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f2126j)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.n)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.o)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.p)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.f2127k)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f2128l)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f2129m)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.q)) {
            hashSet.add(ReactProgressBarViewManager.PROP_PROGRESS);
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
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.KeyTimeCycle);
        SparseIntArray sparseIntArray = Loader.f2130a;
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i2);
            SparseIntArray sparseIntArray2 = Loader.f2130a;
            switch (sparseIntArray2.get(index)) {
                case 1:
                    this.f2122f = typedArrayObtainStyledAttributes.getFloat(index, this.f2122f);
                    break;
                case 2:
                    this.f2123g = typedArrayObtainStyledAttributes.getDimension(index, this.f2123g);
                    break;
                case 3:
                case 11:
                default:
                    Log.e("KeyTimeCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray2.get(index));
                    break;
                case 4:
                    this.f2124h = typedArrayObtainStyledAttributes.getFloat(index, this.f2124h);
                    break;
                case 5:
                    this.f2125i = typedArrayObtainStyledAttributes.getFloat(index, this.f2125i);
                    break;
                case 6:
                    this.f2126j = typedArrayObtainStyledAttributes.getFloat(index, this.f2126j);
                    break;
                case 7:
                    this.f2128l = typedArrayObtainStyledAttributes.getFloat(index, this.f2128l);
                    break;
                case 8:
                    this.f2127k = typedArrayObtainStyledAttributes.getFloat(index, this.f2127k);
                    break;
                case 9:
                    typedArrayObtainStyledAttributes.getString(index);
                    break;
                case 10:
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
                case 12:
                    this.f2085a = typedArrayObtainStyledAttributes.getInt(index, this.f2085a);
                    break;
                case 13:
                    this.f2121e = typedArrayObtainStyledAttributes.getInteger(index, this.f2121e);
                    break;
                case 14:
                    this.f2129m = typedArrayObtainStyledAttributes.getFloat(index, this.f2129m);
                    break;
                case 15:
                    this.n = typedArrayObtainStyledAttributes.getDimension(index, this.n);
                    break;
                case 16:
                    this.o = typedArrayObtainStyledAttributes.getDimension(index, this.o);
                    break;
                case 17:
                    this.p = typedArrayObtainStyledAttributes.getDimension(index, this.p);
                    break;
                case 18:
                    this.q = typedArrayObtainStyledAttributes.getFloat(index, this.q);
                    break;
                case 19:
                    if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                        typedArrayObtainStyledAttributes.getString(index);
                        this.r = 7;
                        break;
                    } else {
                        this.r = typedArrayObtainStyledAttributes.getInt(index, this.r);
                        break;
                    }
                case 20:
                    this.s = typedArrayObtainStyledAttributes.getFloat(index, this.s);
                    break;
                case 21:
                    if (typedArrayObtainStyledAttributes.peekValue(index).type == 5) {
                        this.t = typedArrayObtainStyledAttributes.getDimension(index, this.t);
                        break;
                    } else {
                        this.t = typedArrayObtainStyledAttributes.getFloat(index, this.t);
                        break;
                    }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public final void f(HashMap map) {
        if (this.f2121e == -1) {
            return;
        }
        if (!Float.isNaN(this.f2122f)) {
            map.put("alpha", Integer.valueOf(this.f2121e));
        }
        if (!Float.isNaN(this.f2123g)) {
            map.put("elevation", Integer.valueOf(this.f2121e));
        }
        if (!Float.isNaN(this.f2124h)) {
            map.put("rotation", Integer.valueOf(this.f2121e));
        }
        if (!Float.isNaN(this.f2125i)) {
            map.put("rotationX", Integer.valueOf(this.f2121e));
        }
        if (!Float.isNaN(this.f2126j)) {
            map.put("rotationY", Integer.valueOf(this.f2121e));
        }
        if (!Float.isNaN(this.n)) {
            map.put("translationX", Integer.valueOf(this.f2121e));
        }
        if (!Float.isNaN(this.o)) {
            map.put("translationY", Integer.valueOf(this.f2121e));
        }
        if (!Float.isNaN(this.p)) {
            map.put("translationZ", Integer.valueOf(this.f2121e));
        }
        if (!Float.isNaN(this.f2127k)) {
            map.put("transitionPathRotate", Integer.valueOf(this.f2121e));
        }
        if (!Float.isNaN(this.f2128l)) {
            map.put("scaleX", Integer.valueOf(this.f2121e));
        }
        if (!Float.isNaN(this.f2128l)) {
            map.put("scaleY", Integer.valueOf(this.f2121e));
        }
        if (!Float.isNaN(this.q)) {
            map.put(ReactProgressBarViewManager.PROP_PROGRESS, Integer.valueOf(this.f2121e));
        }
        if (this.f2088d.size() > 0) {
            Iterator it = this.f2088d.keySet().iterator();
            while (it.hasNext()) {
                map.put(b.C("CUSTOM,", (String) it.next()), Integer.valueOf(this.f2121e));
            }
        }
    }

    public final void h(HashMap map) {
        for (String str : map.keySet()) {
            ViewTimeCycle viewTimeCycle = (ViewTimeCycle) map.get(str);
            if (viewTimeCycle != null) {
                if (!str.startsWith("CUSTOM")) {
                    switch (str) {
                        case "rotationX":
                            if (Float.isNaN(this.f2125i)) {
                                break;
                            } else {
                                viewTimeCycle.b(this.f2125i, this.s, this.t, this.f2085a, this.r);
                                break;
                            }
                        case "rotationY":
                            if (Float.isNaN(this.f2126j)) {
                                break;
                            } else {
                                viewTimeCycle.b(this.f2126j, this.s, this.t, this.f2085a, this.r);
                                break;
                            }
                        case "translationX":
                            if (Float.isNaN(this.n)) {
                                break;
                            } else {
                                viewTimeCycle.b(this.n, this.s, this.t, this.f2085a, this.r);
                                break;
                            }
                        case "translationY":
                            if (Float.isNaN(this.o)) {
                                break;
                            } else {
                                viewTimeCycle.b(this.o, this.s, this.t, this.f2085a, this.r);
                                break;
                            }
                        case "translationZ":
                            if (Float.isNaN(this.p)) {
                                break;
                            } else {
                                viewTimeCycle.b(this.p, this.s, this.t, this.f2085a, this.r);
                                break;
                            }
                        case "progress":
                            if (Float.isNaN(this.q)) {
                                break;
                            } else {
                                viewTimeCycle.b(this.q, this.s, this.t, this.f2085a, this.r);
                                break;
                            }
                        case "scaleX":
                            if (Float.isNaN(this.f2128l)) {
                                break;
                            } else {
                                viewTimeCycle.b(this.f2128l, this.s, this.t, this.f2085a, this.r);
                                break;
                            }
                        case "scaleY":
                            if (Float.isNaN(this.f2129m)) {
                                break;
                            } else {
                                viewTimeCycle.b(this.f2129m, this.s, this.t, this.f2085a, this.r);
                                break;
                            }
                        case "rotation":
                            if (Float.isNaN(this.f2124h)) {
                                break;
                            } else {
                                viewTimeCycle.b(this.f2124h, this.s, this.t, this.f2085a, this.r);
                                break;
                            }
                        case "elevation":
                            if (Float.isNaN(this.f2123g)) {
                                break;
                            } else {
                                viewTimeCycle.b(this.f2123g, this.s, this.t, this.f2085a, this.r);
                                break;
                            }
                        case "transitionPathRotate":
                            if (Float.isNaN(this.f2127k)) {
                                break;
                            } else {
                                viewTimeCycle.b(this.f2127k, this.s, this.t, this.f2085a, this.r);
                                break;
                            }
                        case "alpha":
                            if (Float.isNaN(this.f2122f)) {
                                break;
                            } else {
                                viewTimeCycle.b(this.f2122f, this.s, this.t, this.f2085a, this.r);
                                break;
                            }
                        default:
                            Log.e("KeyTimeCycles", "UNKNOWN addValues \"" + str + "\"");
                            break;
                    }
                } else {
                    ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.f2088d.get(str.substring(7));
                    if (constraintAttribute != null) {
                        ViewTimeCycle.CustomSet customSet = (ViewTimeCycle.CustomSet) viewTimeCycle;
                        int i2 = this.f2085a;
                        float f2 = this.s;
                        int i3 = this.r;
                        float f3 = this.t;
                        customSet.f2082l.append(i2, constraintAttribute);
                        customSet.f2083m.append(i2, new float[]{f2, f3});
                        customSet.f1885b = Math.max(customSet.f1885b, i3);
                    }
                }
            }
        }
    }
}
