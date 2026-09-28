package androidx.core.view.accessibility;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* loaded from: classes3.dex */
public class AccessibilityRecordCompat {
    public static void a(AccessibilityEvent accessibilityEvent, View view, int i2) {
        accessibilityEvent.setSource(view, i2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccessibilityRecordCompat)) {
            return false;
        }
        ((AccessibilityRecordCompat) obj).getClass();
        return true;
    }

    public final int hashCode() {
        return 0;
    }
}
