package androidx.transition;

import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;

/* loaded from: classes3.dex */
class ViewUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final ViewUtilsApi23 f12184a;

    /* renamed from: b, reason: collision with root package name */
    public static final Property f12185b;

    /* renamed from: c, reason: collision with root package name */
    public static final Property f12186c;

    /* renamed from: androidx.transition.ViewUtils$1, reason: invalid class name */
    public class AnonymousClass1 extends Property<View, Float> {
        @Override // android.util.Property
        public final Float get(View view) {
            return Float.valueOf(ViewUtils.f12184a.a(view));
        }

        @Override // android.util.Property
        public final void set(View view, Float f2) {
            ViewUtils.b(view, f2.floatValue());
        }
    }

    /* renamed from: androidx.transition.ViewUtils$2, reason: invalid class name */
    public class AnonymousClass2 extends Property<View, Rect> {
        @Override // android.util.Property
        public final Rect get(View view) {
            return view.getClipBounds();
        }

        @Override // android.util.Property
        public final void set(View view, Rect rect) {
            view.setClipBounds(rect);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            f12184a = new ViewUtilsApi29();
        } else {
            f12184a = new ViewUtilsApi23();
        }
        f12185b = new AnonymousClass1(Float.class, "translationAlpha");
        f12186c = new AnonymousClass2(Rect.class, "clipBounds");
    }

    public static void a(View view, int i2, int i3, int i4, int i5) {
        f12184a.g(view, i2, i3, i4, i5);
    }

    public static void b(View view, float f2) {
        f12184a.b(view, f2);
    }

    public static void c(View view, int i2) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        f12184a.c(view, i2);
    }
}
