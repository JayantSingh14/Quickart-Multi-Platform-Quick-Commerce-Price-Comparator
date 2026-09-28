package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.media.b;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.commons.lang3.CharUtils;

/* loaded from: classes3.dex */
public class KeyAttributes extends Key {

    /* renamed from: e, reason: collision with root package name */
    public int f2089e = -1;

    /* renamed from: f, reason: collision with root package name */
    public float f2090f = Float.NaN;

    /* renamed from: g, reason: collision with root package name */
    public float f2091g = Float.NaN;

    /* renamed from: h, reason: collision with root package name */
    public float f2092h = Float.NaN;

    /* renamed from: i, reason: collision with root package name */
    public float f2093i = Float.NaN;

    /* renamed from: j, reason: collision with root package name */
    public float f2094j = Float.NaN;

    /* renamed from: k, reason: collision with root package name */
    public float f2095k = Float.NaN;

    /* renamed from: l, reason: collision with root package name */
    public float f2096l = Float.NaN;

    /* renamed from: m, reason: collision with root package name */
    public float f2097m = Float.NaN;
    public float n = Float.NaN;
    public float o = Float.NaN;
    public float p = Float.NaN;
    public float q = Float.NaN;
    public float r = Float.NaN;
    public float s = Float.NaN;

    public static class Loader {

        /* renamed from: a, reason: collision with root package name */
        public static final SparseIntArray f2098a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f2098a = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyAttribute_android_alpha, 1);
            sparseIntArray.append(R.styleable.KeyAttribute_android_elevation, 2);
            sparseIntArray.append(R.styleable.KeyAttribute_android_rotation, 4);
            sparseIntArray.append(R.styleable.KeyAttribute_android_rotationX, 5);
            sparseIntArray.append(R.styleable.KeyAttribute_android_rotationY, 6);
            sparseIntArray.append(R.styleable.KeyAttribute_android_transformPivotX, 19);
            sparseIntArray.append(R.styleable.KeyAttribute_android_transformPivotY, 20);
            sparseIntArray.append(R.styleable.KeyAttribute_android_scaleX, 7);
            sparseIntArray.append(R.styleable.KeyAttribute_transitionPathRotate, 8);
            sparseIntArray.append(R.styleable.KeyAttribute_transitionEasing, 9);
            sparseIntArray.append(R.styleable.KeyAttribute_motionTarget, 10);
            sparseIntArray.append(R.styleable.KeyAttribute_framePosition, 12);
            sparseIntArray.append(R.styleable.KeyAttribute_curveFit, 13);
            sparseIntArray.append(R.styleable.KeyAttribute_android_scaleY, 14);
            sparseIntArray.append(R.styleable.KeyAttribute_android_translationX, 15);
            sparseIntArray.append(R.styleable.KeyAttribute_android_translationY, 16);
            sparseIntArray.append(R.styleable.KeyAttribute_android_translationZ, 17);
            sparseIntArray.append(R.styleable.KeyAttribute_motionProgress, 18);
        }
    }

    public KeyAttributes() {
        this.f2088d = new HashMap();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.constraintlayout.motion.widget.Key
    public final void a(HashMap map) {
        for (String str : map.keySet()) {
            SplineSet splineSet = (SplineSet) map.get(str);
            if (splineSet != null) {
                if (!str.startsWith("CUSTOM")) {
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
                            if (Float.isNaN(this.f2093i)) {
                                break;
                            } else {
                                splineSet.b(this.f2093i, this.f2085a);
                                break;
                            }
                        case 1:
                            if (Float.isNaN(this.f2094j)) {
                                break;
                            } else {
                                splineSet.b(this.f2094j, this.f2085a);
                                break;
                            }
                        case 2:
                            if (Float.isNaN(this.p)) {
                                break;
                            } else {
                                splineSet.b(this.p, this.f2085a);
                                break;
                            }
                        case 3:
                            if (Float.isNaN(this.q)) {
                                break;
                            } else {
                                splineSet.b(this.q, this.f2085a);
                                break;
                            }
                        case 4:
                            if (Float.isNaN(this.r)) {
                                break;
                            } else {
                                splineSet.b(this.r, this.f2085a);
                                break;
                            }
                        case 5:
                            if (Float.isNaN(this.s)) {
                                break;
                            } else {
                                splineSet.b(this.s, this.f2085a);
                                break;
                            }
                        case 6:
                            if (Float.isNaN(this.n)) {
                                break;
                            } else {
                                splineSet.b(this.n, this.f2085a);
                                break;
                            }
                        case 7:
                            if (Float.isNaN(this.o)) {
                                break;
                            } else {
                                splineSet.b(this.o, this.f2085a);
                                break;
                            }
                        case '\b':
                            if (Float.isNaN(this.f2093i)) {
                                break;
                            } else {
                                splineSet.b(this.f2095k, this.f2085a);
                                break;
                            }
                        case '\t':
                            if (Float.isNaN(this.f2094j)) {
                                break;
                            } else {
                                splineSet.b(this.f2096l, this.f2085a);
                                break;
                            }
                        case '\n':
                            if (Float.isNaN(this.f2092h)) {
                                break;
                            } else {
                                splineSet.b(this.f2092h, this.f2085a);
                                break;
                            }
                        case 11:
                            if (Float.isNaN(this.f2091g)) {
                                break;
                            } else {
                                splineSet.b(this.f2091g, this.f2085a);
                                break;
                            }
                        case '\f':
                            if (Float.isNaN(this.f2097m)) {
                                break;
                            } else {
                                splineSet.b(this.f2097m, this.f2085a);
                                break;
                            }
                        case '\r':
                            if (Float.isNaN(this.f2090f)) {
                                break;
                            } else {
                                splineSet.b(this.f2090f, this.f2085a);
                                break;
                            }
                    }
                } else {
                    ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.f2088d.get(str.substring(7));
                    if (constraintAttribute != null) {
                        ((ViewSpline.CustomSet) splineSet).f2078f.append(this.f2085a, constraintAttribute);
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* renamed from: b */
    public final Key clone() {
        KeyAttributes keyAttributes = new KeyAttributes();
        super.c(this);
        keyAttributes.f2089e = this.f2089e;
        keyAttributes.f2090f = this.f2090f;
        keyAttributes.f2091g = this.f2091g;
        keyAttributes.f2092h = this.f2092h;
        keyAttributes.f2093i = this.f2093i;
        keyAttributes.f2094j = this.f2094j;
        keyAttributes.f2095k = this.f2095k;
        keyAttributes.f2096l = this.f2096l;
        keyAttributes.f2097m = this.f2097m;
        keyAttributes.n = this.n;
        keyAttributes.o = this.o;
        keyAttributes.p = this.p;
        keyAttributes.q = this.q;
        keyAttributes.r = this.r;
        keyAttributes.s = this.s;
        return keyAttributes;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public final void d(HashSet hashSet) {
        if (!Float.isNaN(this.f2090f)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f2091g)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f2092h)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f2093i)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f2094j)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f2095k)) {
            hashSet.add("transformPivotX");
        }
        if (!Float.isNaN(this.f2096l)) {
            hashSet.add("transformPivotY");
        }
        if (!Float.isNaN(this.p)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.q)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.r)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.f2097m)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.n)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.o)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.s)) {
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
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.KeyAttribute);
        SparseIntArray sparseIntArray = Loader.f2098a;
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i2);
            SparseIntArray sparseIntArray2 = Loader.f2098a;
            switch (sparseIntArray2.get(index)) {
                case 1:
                    this.f2090f = typedArrayObtainStyledAttributes.getFloat(index, this.f2090f);
                    break;
                case 2:
                    this.f2091g = typedArrayObtainStyledAttributes.getDimension(index, this.f2091g);
                    break;
                case 3:
                case 11:
                default:
                    Log.e("KeyAttribute", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray2.get(index));
                    break;
                case 4:
                    this.f2092h = typedArrayObtainStyledAttributes.getFloat(index, this.f2092h);
                    break;
                case 5:
                    this.f2093i = typedArrayObtainStyledAttributes.getFloat(index, this.f2093i);
                    break;
                case 6:
                    this.f2094j = typedArrayObtainStyledAttributes.getFloat(index, this.f2094j);
                    break;
                case 7:
                    this.n = typedArrayObtainStyledAttributes.getFloat(index, this.n);
                    break;
                case 8:
                    this.f2097m = typedArrayObtainStyledAttributes.getFloat(index, this.f2097m);
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
                    this.f2089e = typedArrayObtainStyledAttributes.getInteger(index, this.f2089e);
                    break;
                case 14:
                    this.o = typedArrayObtainStyledAttributes.getFloat(index, this.o);
                    break;
                case 15:
                    this.p = typedArrayObtainStyledAttributes.getDimension(index, this.p);
                    break;
                case 16:
                    this.q = typedArrayObtainStyledAttributes.getDimension(index, this.q);
                    break;
                case 17:
                    this.r = typedArrayObtainStyledAttributes.getDimension(index, this.r);
                    break;
                case 18:
                    this.s = typedArrayObtainStyledAttributes.getFloat(index, this.s);
                    break;
                case 19:
                    this.f2095k = typedArrayObtainStyledAttributes.getDimension(index, this.f2095k);
                    break;
                case 20:
                    this.f2096l = typedArrayObtainStyledAttributes.getDimension(index, this.f2096l);
                    break;
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public final void f(HashMap map) {
        if (this.f2089e == -1) {
            return;
        }
        if (!Float.isNaN(this.f2090f)) {
            map.put("alpha", Integer.valueOf(this.f2089e));
        }
        if (!Float.isNaN(this.f2091g)) {
            map.put("elevation", Integer.valueOf(this.f2089e));
        }
        if (!Float.isNaN(this.f2092h)) {
            map.put("rotation", Integer.valueOf(this.f2089e));
        }
        if (!Float.isNaN(this.f2093i)) {
            map.put("rotationX", Integer.valueOf(this.f2089e));
        }
        if (!Float.isNaN(this.f2094j)) {
            map.put("rotationY", Integer.valueOf(this.f2089e));
        }
        if (!Float.isNaN(this.f2095k)) {
            map.put("transformPivotX", Integer.valueOf(this.f2089e));
        }
        if (!Float.isNaN(this.f2096l)) {
            map.put("transformPivotY", Integer.valueOf(this.f2089e));
        }
        if (!Float.isNaN(this.p)) {
            map.put("translationX", Integer.valueOf(this.f2089e));
        }
        if (!Float.isNaN(this.q)) {
            map.put("translationY", Integer.valueOf(this.f2089e));
        }
        if (!Float.isNaN(this.r)) {
            map.put("translationZ", Integer.valueOf(this.f2089e));
        }
        if (!Float.isNaN(this.f2097m)) {
            map.put("transitionPathRotate", Integer.valueOf(this.f2089e));
        }
        if (!Float.isNaN(this.n)) {
            map.put("scaleX", Integer.valueOf(this.f2089e));
        }
        if (!Float.isNaN(this.o)) {
            map.put("scaleY", Integer.valueOf(this.f2089e));
        }
        if (!Float.isNaN(this.s)) {
            map.put(ReactProgressBarViewManager.PROP_PROGRESS, Integer.valueOf(this.f2089e));
        }
        if (this.f2088d.size() > 0) {
            Iterator it = this.f2088d.keySet().iterator();
            while (it.hasNext()) {
                map.put(b.C("CUSTOM,", (String) it.next()), Integer.valueOf(this.f2089e));
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void h(Object obj, String str) {
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1913008125:
                if (str.equals("motionProgress")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1249320806:
                if (str.equals("rotationX")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c2 = 5;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c2 = 6;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c2 = 7;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
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
            case 579057826:
                if (str.equals("curveFit")) {
                    c2 = 15;
                    break;
                }
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    c2 = 16;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                this.s = Key.g((Number) obj);
                break;
            case 1:
                obj.toString();
                break;
            case 2:
                this.f2093i = Key.g((Number) obj);
                break;
            case 3:
                this.f2094j = Key.g((Number) obj);
                break;
            case 4:
                this.p = Key.g((Number) obj);
                break;
            case 5:
                this.q = Key.g((Number) obj);
                break;
            case 6:
                this.r = Key.g((Number) obj);
                break;
            case 7:
                this.n = Key.g((Number) obj);
                break;
            case '\b':
                this.o = Key.g((Number) obj);
                break;
            case '\t':
                this.f2095k = Key.g((Number) obj);
                break;
            case '\n':
                this.f2096l = Key.g((Number) obj);
                break;
            case 11:
                this.f2092h = Key.g((Number) obj);
                break;
            case '\f':
                this.f2091g = Key.g((Number) obj);
                break;
            case '\r':
                this.f2097m = Key.g((Number) obj);
                break;
            case 14:
                this.f2090f = Key.g((Number) obj);
                break;
            case 15:
                Number number = (Number) obj;
                this.f2089e = number instanceof Integer ? ((Integer) number).intValue() : Integer.parseInt(number.toString());
                break;
            case 16:
                if (!(obj instanceof Boolean)) {
                    Boolean.parseBoolean(obj.toString());
                    break;
                }
                break;
        }
    }
}
