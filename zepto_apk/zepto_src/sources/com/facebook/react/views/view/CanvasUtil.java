package com.facebook.react.views.view;

import android.graphics.Canvas;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class CanvasUtil {

    /* renamed from: a, reason: collision with root package name */
    public static Method f20233a;

    /* renamed from: b, reason: collision with root package name */
    public static Method f20234b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f20235c;

    public static final void a(Canvas canvas, boolean z) {
        Method method;
        Method method2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            if (z) {
                canvas.enableZ();
                return;
            } else {
                canvas.disableZ();
                return;
            }
        }
        if (!f20235c) {
            try {
                if (i2 == 28) {
                    Method declaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Object[].class);
                    Object objInvoke = declaredMethod.invoke(Canvas.class, "insertReorderBarrier", new Class[0]);
                    Intrinsics.d(objInvoke, "null cannot be cast to non-null type java.lang.reflect.Method");
                    f20233a = (Method) objInvoke;
                    Object objInvoke2 = declaredMethod.invoke(Canvas.class, "insertInorderBarrier", new Class[0]);
                    Intrinsics.d(objInvoke2, "null cannot be cast to non-null type java.lang.reflect.Method");
                    f20234b = (Method) objInvoke2;
                } else {
                    f20233a = Canvas.class.getDeclaredMethod("insertReorderBarrier", null);
                    f20234b = Canvas.class.getDeclaredMethod("insertInorderBarrier", null);
                }
                method2 = f20233a;
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
            if (method2 != null && f20234b != null) {
                method2.setAccessible(true);
                Method method3 = f20234b;
                if (method3 != null) {
                    method3.setAccessible(true);
                }
                f20235c = true;
            }
        }
        if (z) {
            try {
                Method method4 = f20233a;
                if (method4 != null) {
                    method4.invoke(canvas, null);
                }
            } catch (IllegalAccessException | InvocationTargetException unused2) {
                return;
            }
        }
        if (z || (method = f20234b) == null) {
            return;
        }
        method.invoke(canvas, null);
    }
}
