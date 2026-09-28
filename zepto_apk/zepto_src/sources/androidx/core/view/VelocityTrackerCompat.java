package androidx.core.view;

import android.view.VelocityTracker;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public final class VelocityTrackerCompat {

    /* renamed from: a, reason: collision with root package name */
    public static final Map f3074a = Collections.synchronizedMap(new WeakHashMap());

    @RequiresApi
    public static class Api34Impl {
        public static float a(VelocityTracker velocityTracker, int i2) {
            return velocityTracker.getAxisVelocity(i2);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface VelocityTrackableMotionEventAxis {
    }
}
