package androidx.transition;

import android.graphics.Canvas;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
class CanvasUtils {

    /* renamed from: a, reason: collision with root package name */
    public static Method f12010a;

    /* renamed from: b, reason: collision with root package name */
    public static Method f12011b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f12012c;

    @RequiresApi
    public static class Api29Impl {
        @DoNotInline
        public static void a(Canvas canvas) {
            canvas.disableZ();
        }

        @DoNotInline
        public static void b(Canvas canvas) {
            canvas.enableZ();
        }
    }

    public static void a(Canvas canvas, boolean z) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method method;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            if (z) {
                Api29Impl.b(canvas);
                return;
            } else {
                Api29Impl.a(canvas);
                return;
            }
        }
        if (i2 == 28) {
            throw new IllegalStateException("This method doesn't work on Pie!");
        }
        if (!f12012c) {
            try {
                Method declaredMethod = Canvas.class.getDeclaredMethod("insertReorderBarrier", null);
                f12010a = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = Canvas.class.getDeclaredMethod("insertInorderBarrier", null);
                f12011b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f12012c = true;
        }
        if (z) {
            try {
                Method method2 = f12010a;
                if (method2 != null) {
                    method2.invoke(canvas, null);
                }
            } catch (IllegalAccessException unused2) {
                return;
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        if (z || (method = f12011b) == null) {
            return;
        }
        method.invoke(canvas, null);
    }
}
