package com.swmansion.rnscreens.bottomsheet;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.views.view.ReactViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@Metadata
@SuppressLint({"ViewConstructor"})
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class BottomSheetDialogRootView extends ReactViewGroup implements RootView {

    @Metadata
    public static final class Companion {
    }

    @Override // com.facebook.react.uimanager.RootView
    public final void a(View view, MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        throw null;
    }

    @Override // com.facebook.react.uimanager.RootView
    public final void d(ViewGroup view, MotionEvent event) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(event, "event");
        throw null;
    }

    @Nullable
    public final ReactContext getReactContext() {
        return null;
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.View
    public final boolean onHoverEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return super.onHoverEvent(event);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptHoverEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return super.onHoverEvent(event);
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        throw null;
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (z) {
            getChildCount();
            getChildAt(0).layout(i2, i3, i4, i5);
        }
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.View
    public final boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
    }
}
