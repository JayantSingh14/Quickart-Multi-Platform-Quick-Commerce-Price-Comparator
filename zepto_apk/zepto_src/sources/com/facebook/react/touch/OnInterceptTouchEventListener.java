package com.facebook.react.touch;

import android.view.MotionEvent;
import com.facebook.react.views.view.ReactViewGroup;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface OnInterceptTouchEventListener {
    boolean a(ReactViewGroup reactViewGroup, MotionEvent motionEvent);
}
