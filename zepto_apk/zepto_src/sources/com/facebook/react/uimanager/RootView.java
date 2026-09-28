package com.facebook.react.uimanager;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface RootView {
    void a(View view, MotionEvent motionEvent);

    void d(ViewGroup viewGroup, MotionEvent motionEvent);
}
