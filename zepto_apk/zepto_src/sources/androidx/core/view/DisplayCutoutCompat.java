package androidx.core.view;

import android.os.Build;
import android.view.DisplayCutout;
import androidx.annotation.RequiresApi;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class DisplayCutoutCompat {

    /* renamed from: a, reason: collision with root package name */
    public final DisplayCutout f3040a;

    @RequiresApi
    public static class Api28Impl {
        public static int a(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetBottom();
        }

        public static int b(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetLeft();
        }

        public static int c(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetRight();
        }

        public static int d(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetTop();
        }
    }

    @RequiresApi
    public static class Api29Impl {
    }

    @RequiresApi
    public static class Api30Impl {
    }

    @RequiresApi
    public static class Api31Impl {
    }

    @RequiresApi
    public static class Api33Impl {
    }

    public DisplayCutoutCompat(DisplayCutout displayCutout) {
        this.f3040a = displayCutout;
    }

    public static DisplayCutoutCompat e(DisplayCutout displayCutout) {
        if (displayCutout == null) {
            return null;
        }
        return new DisplayCutoutCompat(displayCutout);
    }

    public final int a() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.a(this.f3040a);
        }
        return 0;
    }

    public final int b() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.b(this.f3040a);
        }
        return 0;
    }

    public final int c() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.c(this.f3040a);
        }
        return 0;
    }

    public final int d() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.d(this.f3040a);
        }
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DisplayCutoutCompat.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.f3040a, ((DisplayCutoutCompat) obj).f3040a);
    }

    public final int hashCode() {
        DisplayCutout displayCutout = this.f3040a;
        if (displayCutout == null) {
            return 0;
        }
        return displayCutout.hashCode();
    }

    public final String toString() {
        return "DisplayCutoutCompat{" + this.f3040a + "}";
    }
}
