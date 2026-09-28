package androidx.transition;

import android.graphics.Matrix;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

@RequiresApi
/* loaded from: classes3.dex */
class ViewUtilsApi21 extends ViewUtilsApi19 {

    /* renamed from: d, reason: collision with root package name */
    public static boolean f12190d = true;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f12191e = true;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f12192f = true;

    @RequiresApi
    public static class Api29Impl {
        @DoNotInline
        public static void a(View view, Matrix matrix) {
            view.setAnimationMatrix(matrix);
        }

        @DoNotInline
        public static void b(View view, Matrix matrix) {
            view.transformMatrixToGlobal(matrix);
        }

        @DoNotInline
        public static void c(View view, Matrix matrix) {
            view.transformMatrixToLocal(matrix);
        }
    }

    public void d(View view, Matrix matrix) {
        if (f12190d) {
            try {
                Api29Impl.a(view, matrix);
            } catch (NoSuchMethodError unused) {
                f12190d = false;
            }
        }
    }

    public void e(View view, Matrix matrix) {
        if (f12191e) {
            try {
                Api29Impl.b(view, matrix);
            } catch (NoSuchMethodError unused) {
                f12191e = false;
            }
        }
    }

    public void f(View view, Matrix matrix) {
        if (f12192f) {
            try {
                Api29Impl.c(view, matrix);
            } catch (NoSuchMethodError unused) {
                f12192f = false;
            }
        }
    }
}
