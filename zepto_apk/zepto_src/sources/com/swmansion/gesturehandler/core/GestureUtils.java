package com.swmansion.gesturehandler.core;

import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class GestureUtils {
    public static double a(double d2) {
        return Math.cos(Math.toRadians(d2 / 2.0d));
    }

    public static float b(MotionEvent event, boolean z) {
        Intrinsics.checkNotNullParameter(event, "event");
        int actionIndex = event.getActionMasked() == 6 ? event.getActionIndex() : -1;
        if (!z) {
            int pointerCount = event.getPointerCount();
            int i2 = pointerCount - 1;
            if (i2 == actionIndex) {
                i2 = pointerCount - 2;
            }
            return event.getX(i2);
        }
        int pointerCount2 = event.getPointerCount();
        float x = 0.0f;
        int i3 = 0;
        for (int i4 = 0; i4 < pointerCount2; i4++) {
            if (i4 != actionIndex) {
                i3++;
                x = event.getX(i4) + x;
            }
        }
        return x / i3;
    }

    public static float c(MotionEvent event, boolean z) {
        Intrinsics.checkNotNullParameter(event, "event");
        int actionIndex = event.getActionMasked() == 6 ? event.getActionIndex() : -1;
        if (!z) {
            int pointerCount = event.getPointerCount();
            int i2 = pointerCount - 1;
            if (i2 == actionIndex) {
                i2 = pointerCount - 2;
            }
            return event.getY(i2);
        }
        int pointerCount2 = event.getPointerCount();
        float y = 0.0f;
        int i3 = 0;
        for (int i4 = 0; i4 < pointerCount2; i4++) {
            if (i4 != actionIndex) {
                i3++;
                y = event.getY(i4) + y;
            }
        }
        return y / i3;
    }
}
