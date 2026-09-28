package com.swmansion.rnscreens.bottomsheet;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactCompoundViewGroup;
import com.facebook.react.uimanager.ReactPointerEventsView;
import com.facebook.react.uimanager.ThemedReactContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
public final class DimmingView extends ViewGroup implements ReactCompoundViewGroup, ReactPointerEventsView {

    /* renamed from: a, reason: collision with root package name */
    public final DimmingViewPointerEventsProxy f47088a;

    @Metadata
    public static final class Companion {
    }

    public DimmingView(ThemedReactContext context, float f2) {
        Intrinsics.checkNotNullParameter(context, "context");
        DimmingViewPointerEventsProxy pointerEventsProxy = new DimmingViewPointerEventsProxy();
        pointerEventsProxy.f47099a = null;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pointerEventsProxy, "pointerEventsProxy");
        super(context);
        this.f47088a = pointerEventsProxy;
        pointerEventsProxy.f47099a = new DimmingViewPointerEventsImpl(this);
        setBackgroundColor(-16777216);
        setAlpha(f2);
    }

    public final boolean getBlockGestures$react_native_screens_release() {
        return !(Math.abs(getAlpha() - 0.0f) <= 1.0E-4f);
    }

    @Override // com.facebook.react.uimanager.ReactPointerEventsView
    @NotNull
    public PointerEvents getPointerEvents() {
        return this.f47088a.getPointerEvents();
    }

    @Override // com.facebook.react.uimanager.ReactCompoundViewGroup
    public final boolean interceptsTouchEvent(float f2, float f3) {
        return getBlockGestures$react_native_screens_release();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f47088a.f47099a = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (getBlockGestures$react_native_screens_release()) {
            callOnClick();
        }
        return getBlockGestures$react_native_screens_release();
    }

    @Override // com.facebook.react.uimanager.ReactCompoundView
    public final int reactTagForTouch(float f2, float f3) {
        throw new IllegalStateException("[RNScreens] DimmingView should never be asked for the view tag!");
    }
}
