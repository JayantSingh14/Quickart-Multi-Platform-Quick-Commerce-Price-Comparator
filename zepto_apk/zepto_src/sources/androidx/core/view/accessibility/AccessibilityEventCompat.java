package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public final class AccessibilityEventCompat {

    @RequiresApi
    public static class Api34Impl {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface ContentChangeType {
    }

    public static void a(AccessibilityEvent accessibilityEvent) {
        accessibilityEvent.setContentChangeTypes(0);
    }
}
