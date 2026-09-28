package androidx.transition;

import android.os.Build;
import android.view.ViewGroup;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
class ViewGroupUtils {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f12181a = true;

    /* renamed from: b, reason: collision with root package name */
    public static Method f12182b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f12183c;

    @RequiresApi
    public static class Api29Impl {
        @DoNotInline
        public static int a(ViewGroup viewGroup, int i2) {
            return viewGroup.getChildDrawingOrder(i2);
        }

        @DoNotInline
        public static void b(ViewGroup viewGroup, boolean z) {
            viewGroup.suppressLayout(z);
        }
    }

    public static void a(ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.b(viewGroup, z);
        } else if (f12181a) {
            try {
                Api29Impl.b(viewGroup, z);
            } catch (NoSuchMethodError unused) {
                f12181a = false;
            }
        }
    }
}
