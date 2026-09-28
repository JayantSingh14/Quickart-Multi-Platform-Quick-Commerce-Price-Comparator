package androidx.appcompat.widget;

import android.R;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RestrictTo
/* loaded from: classes.dex */
public class DrawableUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f1008a = {R.attr.state_checked};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f1009b = new int[0];

    /* renamed from: c, reason: collision with root package name */
    public static final Rect f1010c = new Rect();

    /* loaded from: classes3.dex */
    public static class Api18Impl {

        /* renamed from: a, reason: collision with root package name */
        public static final boolean f1011a;

        /* renamed from: b, reason: collision with root package name */
        public static final Method f1012b;

        /* renamed from: c, reason: collision with root package name */
        public static final Field f1013c;

        /* renamed from: d, reason: collision with root package name */
        public static final Field f1014d;

        /* renamed from: e, reason: collision with root package name */
        public static final Field f1015e;

        /* renamed from: f, reason: collision with root package name */
        public static final Field f1016f;

        /* JADX WARN: Removed duplicated region for block: B:25:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0057  */
        static {
            /*
                r0 = 1
                r1 = 0
                r2 = 0
                java.lang.String r3 = "android.graphics.Insets"
                java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.NoSuchFieldException -> L3d java.lang.ClassNotFoundException -> L40 java.lang.NoSuchMethodException -> L43
                java.lang.Class<android.graphics.drawable.Drawable> r4 = android.graphics.drawable.Drawable.class
                java.lang.String r5 = "getOpticalInsets"
                java.lang.reflect.Method r4 = r4.getMethod(r5, r1)     // Catch: java.lang.NoSuchFieldException -> L3d java.lang.ClassNotFoundException -> L40 java.lang.NoSuchMethodException -> L43
                java.lang.String r5 = "left"
                java.lang.reflect.Field r5 = r3.getField(r5)     // Catch: java.lang.NoSuchFieldException -> L34 java.lang.ClassNotFoundException -> L37 java.lang.NoSuchMethodException -> L3a
                java.lang.String r6 = "top"
                java.lang.reflect.Field r6 = r3.getField(r6)     // Catch: java.lang.NoSuchFieldException -> L2d java.lang.ClassNotFoundException -> L30 java.lang.NoSuchMethodException -> L32
                java.lang.String r7 = "right"
                java.lang.reflect.Field r7 = r3.getField(r7)     // Catch: java.lang.Throwable -> L2b
                java.lang.String r8 = "bottom"
                java.lang.reflect.Field r3 = r3.getField(r8)     // Catch: java.lang.Throwable -> L46
                r8 = r0
                goto L48
            L2b:
                r7 = r1
                goto L46
            L2d:
                r6 = r1
            L2e:
                r7 = r6
                goto L46
            L30:
                r6 = r1
                goto L2e
            L32:
                r6 = r1
                goto L2e
            L34:
                r5 = r1
            L35:
                r6 = r5
                goto L2e
            L37:
                r5 = r1
            L38:
                r6 = r5
                goto L2e
            L3a:
                r5 = r1
            L3b:
                r6 = r5
                goto L2e
            L3d:
                r4 = r1
                r5 = r4
                goto L35
            L40:
                r4 = r1
                r5 = r4
                goto L38
            L43:
                r4 = r1
                r5 = r4
                goto L3b
            L46:
                r3 = r1
                r8 = r2
            L48:
                if (r8 == 0) goto L57
                androidx.appcompat.widget.DrawableUtils.Api18Impl.f1012b = r4
                androidx.appcompat.widget.DrawableUtils.Api18Impl.f1013c = r5
                androidx.appcompat.widget.DrawableUtils.Api18Impl.f1014d = r6
                androidx.appcompat.widget.DrawableUtils.Api18Impl.f1015e = r7
                androidx.appcompat.widget.DrawableUtils.Api18Impl.f1016f = r3
                androidx.appcompat.widget.DrawableUtils.Api18Impl.f1011a = r0
                goto L63
            L57:
                androidx.appcompat.widget.DrawableUtils.Api18Impl.f1012b = r1
                androidx.appcompat.widget.DrawableUtils.Api18Impl.f1013c = r1
                androidx.appcompat.widget.DrawableUtils.Api18Impl.f1014d = r1
                androidx.appcompat.widget.DrawableUtils.Api18Impl.f1015e = r1
                androidx.appcompat.widget.DrawableUtils.Api18Impl.f1016f = r1
                androidx.appcompat.widget.DrawableUtils.Api18Impl.f1011a = r2
            L63:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.DrawableUtils.Api18Impl.<clinit>():void");
        }

        public static Rect a(Drawable drawable) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (Build.VERSION.SDK_INT < 29 && f1011a) {
                try {
                    Object objInvoke = f1012b.invoke(drawable, null);
                    if (objInvoke != null) {
                        return new Rect(f1013c.getInt(objInvoke), f1014d.getInt(objInvoke), f1015e.getInt(objInvoke), f1016f.getInt(objInvoke));
                    }
                } catch (IllegalAccessException | InvocationTargetException unused) {
                }
            }
            return DrawableUtils.f1010c;
        }
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Api29Impl {
        @DoNotInline
        public static Insets a(Drawable drawable) {
            return drawable.getOpticalInsets();
        }
    }

    public static void a(Drawable drawable) {
        String name = drawable.getClass().getName();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 29 || i2 >= 31 || !"android.graphics.drawable.ColorStateListDrawable".equals(name)) {
            return;
        }
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(f1008a);
        } else {
            drawable.setState(f1009b);
        }
        drawable.setState(state);
    }

    public static Rect b(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 29) {
            return Api18Impl.a(DrawableCompat.o(drawable));
        }
        Insets insetsA = Api29Impl.a(drawable);
        return new Rect(insetsA.left, insetsA.top, insetsA.right, insetsA.bottom);
    }

    public static PorterDuff.Mode c(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
