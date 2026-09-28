package com.swmansion.gesturehandler.core;

import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ManualGestureHandler extends GestureHandler<ManualGestureHandler> {
    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final void t(MotionEvent event, MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        if (this.f46719f == 0) {
            d();
        }
    }
}
