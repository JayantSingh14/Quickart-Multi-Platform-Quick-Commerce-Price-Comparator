package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.media.b;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public class KeyTrigger extends Key {
    public float w;

    /* renamed from: e, reason: collision with root package name */
    public float f2131e = 0.1f;

    /* renamed from: f, reason: collision with root package name */
    public int f2132f = -1;

    /* renamed from: g, reason: collision with root package name */
    public int f2133g = -1;

    /* renamed from: h, reason: collision with root package name */
    public int f2134h = -1;

    /* renamed from: i, reason: collision with root package name */
    public RectF f2135i = new RectF();

    /* renamed from: j, reason: collision with root package name */
    public RectF f2136j = new RectF();

    /* renamed from: k, reason: collision with root package name */
    public HashMap f2137k = new HashMap();

    /* renamed from: l, reason: collision with root package name */
    public String f2138l = null;

    /* renamed from: m, reason: collision with root package name */
    public int f2139m = -1;
    public String n = null;
    public String o = null;
    public int p = -1;
    public int q = -1;
    public View r = null;
    public boolean s = true;
    public boolean t = true;
    public boolean u = true;
    public float v = Float.NaN;
    public boolean x = false;

    public static class Loader {

        /* renamed from: a, reason: collision with root package name */
        public static final SparseIntArray f2140a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f2140a = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyTrigger_framePosition, 8);
            sparseIntArray.append(R.styleable.KeyTrigger_onCross, 4);
            sparseIntArray.append(R.styleable.KeyTrigger_onNegativeCross, 1);
            sparseIntArray.append(R.styleable.KeyTrigger_onPositiveCross, 2);
            sparseIntArray.append(R.styleable.KeyTrigger_motionTarget, 7);
            sparseIntArray.append(R.styleable.KeyTrigger_triggerId, 6);
            sparseIntArray.append(R.styleable.KeyTrigger_triggerSlack, 5);
            sparseIntArray.append(R.styleable.KeyTrigger_motion_triggerOnCollision, 9);
            sparseIntArray.append(R.styleable.KeyTrigger_motion_postLayoutCollision, 10);
            sparseIntArray.append(R.styleable.KeyTrigger_triggerReceiver, 11);
            sparseIntArray.append(R.styleable.KeyTrigger_viewTransitionOnCross, 12);
            sparseIntArray.append(R.styleable.KeyTrigger_viewTransitionOnNegativeCross, 13);
            sparseIntArray.append(R.styleable.KeyTrigger_viewTransitionOnPositiveCross, 14);
        }
    }

    public KeyTrigger() {
        this.f2088d = new HashMap();
    }

    public static void j(RectF rectF, View view, boolean z) {
        rectF.top = view.getTop();
        rectF.bottom = view.getBottom();
        rectF.left = view.getLeft();
        rectF.right = view.getRight();
        if (z) {
            view.getMatrix().mapRect(rectF);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public final void a(HashMap map) {
        throw null;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* renamed from: b */
    public final Key clone() {
        KeyTrigger keyTrigger = new KeyTrigger();
        super.c(this);
        keyTrigger.f2138l = this.f2138l;
        keyTrigger.f2139m = this.f2139m;
        keyTrigger.n = this.n;
        keyTrigger.o = this.o;
        keyTrigger.p = this.p;
        keyTrigger.q = this.q;
        keyTrigger.r = this.r;
        keyTrigger.f2131e = this.f2131e;
        keyTrigger.s = this.s;
        keyTrigger.t = this.t;
        keyTrigger.u = this.u;
        keyTrigger.v = this.v;
        keyTrigger.w = this.w;
        keyTrigger.x = this.x;
        keyTrigger.f2135i = this.f2135i;
        keyTrigger.f2136j = this.f2136j;
        keyTrigger.f2137k = this.f2137k;
        return keyTrigger;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public final void d(HashSet hashSet) {
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public final void e(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.KeyTrigger);
        SparseIntArray sparseIntArray = Loader.f2140a;
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i2);
            SparseIntArray sparseIntArray2 = Loader.f2140a;
            switch (sparseIntArray2.get(index)) {
                case 1:
                    this.n = typedArrayObtainStyledAttributes.getString(index);
                    break;
                case 2:
                    this.o = typedArrayObtainStyledAttributes.getString(index);
                    break;
                case 3:
                default:
                    Log.e("KeyTrigger", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray2.get(index));
                    break;
                case 4:
                    this.f2138l = typedArrayObtainStyledAttributes.getString(index);
                    break;
                case 5:
                    this.f2131e = typedArrayObtainStyledAttributes.getFloat(index, this.f2131e);
                    break;
                case 6:
                    this.p = typedArrayObtainStyledAttributes.getResourceId(index, this.p);
                    break;
                case 7:
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
                case 8:
                    int integer = typedArrayObtainStyledAttributes.getInteger(index, this.f2085a);
                    this.f2085a = integer;
                    this.v = (integer + 0.5f) / 100.0f;
                    break;
                case 9:
                    this.q = typedArrayObtainStyledAttributes.getResourceId(index, this.q);
                    break;
                case 10:
                    this.x = typedArrayObtainStyledAttributes.getBoolean(index, this.x);
                    break;
                case 11:
                    this.f2139m = typedArrayObtainStyledAttributes.getResourceId(index, this.f2139m);
                    break;
                case 12:
                    this.f2134h = typedArrayObtainStyledAttributes.getResourceId(index, this.f2134h);
                    break;
                case 13:
                    this.f2132f = typedArrayObtainStyledAttributes.getResourceId(index, this.f2132f);
                    break;
                case 14:
                    this.f2133g = typedArrayObtainStyledAttributes.getResourceId(index, this.f2133g);
                    break;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(android.view.View r11, float r12) {
        /*
            Method dump skipped, instructions count: 362
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyTrigger.h(android.view.View, float):void");
    }

    public final void i(View view, String str) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method method;
        if (str == null) {
            return;
        }
        if (!str.startsWith(CLConstants.DOT_SALT_DELIMETER)) {
            if (this.f2137k.containsKey(str)) {
                method = (Method) this.f2137k.get(str);
                if (method == null) {
                    return;
                }
            } else {
                method = null;
            }
            if (method == null) {
                try {
                    method = view.getClass().getMethod(str, null);
                    this.f2137k.put(str, method);
                } catch (NoSuchMethodException unused) {
                    this.f2137k.put(str, null);
                    Log.e("KeyTrigger", "Could not find method \"" + str + "\"on class " + view.getClass().getSimpleName() + StringUtils.SPACE + Debug.d(view));
                    return;
                }
            }
            try {
                method.invoke(view, null);
                return;
            } catch (Exception unused2) {
                Log.e("KeyTrigger", "Exception in call \"" + this.f2138l + "\"on class " + view.getClass().getSimpleName() + StringUtils.SPACE + Debug.d(view));
                return;
            }
        }
        boolean z = str.length() == 1;
        if (!z) {
            str = str.substring(1).toLowerCase(Locale.ROOT);
        }
        for (String str2 : this.f2088d.keySet()) {
            String lowerCase = str2.toLowerCase(Locale.ROOT);
            if (z || lowerCase.matches(str)) {
                ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.f2088d.get(str2);
                if (constraintAttribute != null) {
                    Class<?> cls = view.getClass();
                    boolean z2 = constraintAttribute.f2371a;
                    String str3 = constraintAttribute.f2372b;
                    String strC = !z2 ? b.C("set", str3) : str3;
                    try {
                        int iOrdinal = constraintAttribute.f2373c.ordinal();
                        Class cls2 = Integer.TYPE;
                        Class cls3 = Float.TYPE;
                        switch (iOrdinal) {
                            case 0:
                            case 7:
                                cls.getMethod(strC, cls2).invoke(view, Integer.valueOf(constraintAttribute.f2374d));
                                break;
                            case 1:
                                cls.getMethod(strC, cls3).invoke(view, Float.valueOf(constraintAttribute.f2375e));
                                break;
                            case 2:
                                cls.getMethod(strC, cls2).invoke(view, Integer.valueOf(constraintAttribute.f2378h));
                                break;
                            case 3:
                                Method method2 = cls.getMethod(strC, Drawable.class);
                                ColorDrawable colorDrawable = new ColorDrawable();
                                colorDrawable.setColor(constraintAttribute.f2378h);
                                method2.invoke(view, colorDrawable);
                                break;
                            case 4:
                                cls.getMethod(strC, CharSequence.class).invoke(view, constraintAttribute.f2376f);
                                break;
                            case 5:
                                cls.getMethod(strC, Boolean.TYPE).invoke(view, Boolean.valueOf(constraintAttribute.f2377g));
                                break;
                            case 6:
                                cls.getMethod(strC, cls3).invoke(view, Float.valueOf(constraintAttribute.f2375e));
                                break;
                        }
                    } catch (IllegalAccessException e2) {
                        StringBuilder sbY = b.y(" Custom Attribute \"", str3, "\" not found on ");
                        sbY.append(cls.getName());
                        Log.e("TransitionLayout", sbY.toString(), e2);
                    } catch (NoSuchMethodException e3) {
                        Log.e("TransitionLayout", cls.getName() + " must have a method " + strC, e3);
                    } catch (InvocationTargetException e4) {
                        StringBuilder sbY2 = b.y(" Custom Attribute \"", str3, "\" not found on ");
                        sbY2.append(cls.getName());
                        Log.e("TransitionLayout", sbY2.toString(), e4);
                    }
                }
            }
        }
    }
}
