package androidx.transition;

import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

@RequiresApi
/* loaded from: classes3.dex */
class ViewUtilsApi22 extends ViewUtilsApi21 {

    /* renamed from: g, reason: collision with root package name */
    public static boolean f12193g = true;

    @RequiresApi
    public static class Api29Impl {
        @DoNotInline
        public static void a(View view, int i2, int i3, int i4, int i5) {
            view.setLeftTopRightBottom(i2, i3, i4, i5);
        }
    }

    public void g(View view, int i2, int i3, int i4, int i5) {
        if (f12193g) {
            try {
                Api29Impl.a(view, i2, i3, i4, i5);
            } catch (NoSuchMethodError unused) {
                f12193g = false;
            }
        }
    }
}
