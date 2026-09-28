package com.swmansion.gesturehandler.core;

import android.view.MotionEvent;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface OnTouchEventListener {
    void a(GestureHandler gestureHandler, int i2, int i3);

    void b(GestureHandler gestureHandler);

    void c(GestureHandler gestureHandler, MotionEvent motionEvent);
}
