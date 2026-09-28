package androidx.constraintlayout.motion.utils;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.media.b;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class CustomSupport {

    /* renamed from: androidx.constraintlayout.motion.utils.CustomSupport$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2071a;

        static {
            int[] iArr = new int[ConstraintAttribute.AttributeType.values().length];
            f2071a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2071a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2071a[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2071a[2] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2071a[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2071a[5] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2071a[6] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static int a(int i2) {
        int i3 = (i2 & (~(i2 >> 31))) - 255;
        return (i3 & (i3 >> 31)) + 255;
    }

    public static void b(ConstraintAttribute constraintAttribute, View view, float[] fArr) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Class<?> cls = view.getClass();
        String str = "set" + constraintAttribute.f2372b;
        try {
            int iOrdinal = constraintAttribute.f2373c.ordinal();
            Class cls2 = Integer.TYPE;
            Class cls3 = Float.TYPE;
            boolean z = true;
            switch (iOrdinal) {
                case 0:
                    cls.getMethod(str, cls2).invoke(view, Integer.valueOf((int) fArr[0]));
                    return;
                case 1:
                    cls.getMethod(str, cls3).invoke(view, Float.valueOf(fArr[0]));
                    return;
                case 2:
                    cls.getMethod(str, cls2).invoke(view, Integer.valueOf((a((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (a((int) (fArr[3] * 255.0f)) << 24) | (a((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | a((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f))));
                    return;
                case 3:
                    Method method = cls.getMethod(str, Drawable.class);
                    int iA = (a((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (a((int) (fArr[3] * 255.0f)) << 24) | (a((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | a((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f));
                    ColorDrawable colorDrawable = new ColorDrawable();
                    colorDrawable.setColor(iA);
                    method.invoke(view, colorDrawable);
                    return;
                case 4:
                    throw new RuntimeException("unable to interpolate strings " + constraintAttribute.f2372b);
                case 5:
                    Method method2 = cls.getMethod(str, Boolean.TYPE);
                    if (fArr[0] <= 0.5f) {
                        z = false;
                    }
                    method2.invoke(view, Boolean.valueOf(z));
                    return;
                case 6:
                    cls.getMethod(str, cls3).invoke(view, Float.valueOf(fArr[0]));
                    return;
                default:
                    return;
            }
        } catch (IllegalAccessException e2) {
            StringBuilder sbY = b.y("Cannot access method ", str, " on View \"");
            sbY.append(Debug.d(view));
            sbY.append("\"");
            Log.e("CustomSupport", sbY.toString(), e2);
        } catch (NoSuchMethodException e3) {
            StringBuilder sbY2 = b.y("No method ", str, " on View \"");
            sbY2.append(Debug.d(view));
            sbY2.append("\"");
            Log.e("CustomSupport", sbY2.toString(), e3);
        } catch (InvocationTargetException e4) {
            StringBuilder sbY3 = b.y("Cannot invoke method ", str, " on View \"");
            sbY3.append(Debug.d(view));
            sbY3.append("\"");
            Log.e("CustomSupport", sbY3.toString(), e4);
        }
    }
}
