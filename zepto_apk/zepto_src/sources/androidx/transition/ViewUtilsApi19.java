package androidx.transition;

import android.util.Log;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;

/* loaded from: classes3.dex */
class ViewUtilsApi19 {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f12187a = true;

    /* renamed from: b, reason: collision with root package name */
    public static Field f12188b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f12189c;

    @RequiresApi
    public static class Api29Impl {
        @DoNotInline
        public static float a(View view) {
            return view.getTransitionAlpha();
        }

        @DoNotInline
        public static void b(View view, float f2) {
            view.setTransitionAlpha(f2);
        }
    }

    public float a(View view) {
        if (f12187a) {
            try {
                return Api29Impl.a(view);
            } catch (NoSuchMethodError unused) {
                f12187a = false;
            }
        }
        return view.getAlpha();
    }

    public void b(View view, float f2) {
        if (f12187a) {
            try {
                Api29Impl.b(view, f2);
                return;
            } catch (NoSuchMethodError unused) {
                f12187a = false;
            }
        }
        view.setAlpha(f2);
    }

    public void c(View view, int i2) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (!f12189c) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f12188b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsApi19", "fetchViewFlagsField: ");
            }
            f12189c = true;
        }
        Field field = f12188b;
        if (field != null) {
            try {
                f12188b.setInt(view, i2 | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }
}
