package com.facebook.react.uimanager.events;

import android.view.MotionEvent;
import android.view.ViewGroup;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.RootViewUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class NativeGestureUtil {
    public static final void a(ViewGroup view, MotionEvent event) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(event, "event");
        RootView rootViewA = RootViewUtil.a(view);
        if (rootViewA != null) {
            rootViewA.d(view, event);
        }
    }

    public static final void b(ViewGroup view, MotionEvent event) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(event, "event");
        RootView rootViewA = RootViewUtil.a(view);
        if (rootViewA != null) {
            rootViewA.a(view, event);
        }
    }
}
