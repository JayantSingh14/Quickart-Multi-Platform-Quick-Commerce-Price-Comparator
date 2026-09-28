package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.os.Build;
import android.os.LocaleList;
import android.view.accessibility.AccessibilityWindowInfo;
import androidx.annotation.RequiresApi;
import androidx.core.os.LocaleListCompat;

/* loaded from: classes3.dex */
public class AccessibilityWindowInfoCompat {

    /* renamed from: a, reason: collision with root package name */
    public final AccessibilityWindowInfo f3205a;

    @RequiresApi
    public static class Api21Impl {
    }

    @RequiresApi
    public static class Api24Impl {
    }

    @RequiresApi
    public static class Api26Impl {
    }

    @RequiresApi
    public static class Api30Impl {
        public static AccessibilityWindowInfo a() {
            return new AccessibilityWindowInfo();
        }
    }

    @RequiresApi
    public static class Api33Impl {
    }

    @RequiresApi
    public static class Api34Impl {
        public static LocaleList a(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getLocales();
        }

        public static long b(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getTransitionTimeMillis();
        }
    }

    public AccessibilityWindowInfoCompat() {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f3205a = Api30Impl.a();
        } else {
            this.f3205a = null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccessibilityWindowInfoCompat)) {
            return false;
        }
        AccessibilityWindowInfo accessibilityWindowInfo = ((AccessibilityWindowInfoCompat) obj).f3205a;
        AccessibilityWindowInfo accessibilityWindowInfo2 = this.f3205a;
        return accessibilityWindowInfo2 == null ? accessibilityWindowInfo == null : accessibilityWindowInfo2.equals(accessibilityWindowInfo);
    }

    public final int hashCode() {
        AccessibilityWindowInfo accessibilityWindowInfo = this.f3205a;
        if (accessibilityWindowInfo == null) {
            return 0;
        }
        return accessibilityWindowInfo.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AccessibilityWindowInfo[id=");
        Rect rect = new Rect();
        AccessibilityWindowInfo accessibilityWindowInfo = this.f3205a;
        accessibilityWindowInfo.getBoundsInScreen(rect);
        sb.append(accessibilityWindowInfo.getId());
        sb.append(", type=");
        int type = accessibilityWindowInfo.getType();
        sb.append(type != 1 ? type != 2 ? type != 3 ? type != 4 ? "<UNKNOWN>" : "TYPE_ACCESSIBILITY_OVERLAY" : "TYPE_SYSTEM" : "TYPE_INPUT_METHOD" : "TYPE_APPLICATION");
        sb.append(", layer=");
        sb.append(accessibilityWindowInfo.getLayer());
        sb.append(", bounds=");
        sb.append(rect);
        sb.append(", focused=");
        sb.append(accessibilityWindowInfo.isFocused());
        sb.append(", active=");
        sb.append(accessibilityWindowInfo.isActive());
        sb.append(", hasParent=");
        AccessibilityWindowInfo parent = accessibilityWindowInfo.getParent();
        sb.append((parent != null ? new AccessibilityWindowInfoCompat(parent) : null) != null);
        sb.append(", hasChildren=");
        sb.append(accessibilityWindowInfo.getChildCount() > 0);
        sb.append(", transitionTime=");
        int i2 = Build.VERSION.SDK_INT;
        sb.append(i2 >= 34 ? Api34Impl.b(accessibilityWindowInfo) : 0L);
        sb.append(", locales=");
        sb.append(i2 >= 34 ? LocaleListCompat.f(Api34Impl.a(accessibilityWindowInfo)) : LocaleListCompat.f2881b);
        sb.append(']');
        return sb.toString();
    }

    public AccessibilityWindowInfoCompat(AccessibilityWindowInfo accessibilityWindowInfo) {
        this.f3205a = accessibilityWindowInfo;
    }
}
