package com.swmansion.gesturehandler.react;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewParent;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.views.view.ReactViewGroup;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.core.GestureHandlerOrchestrator;
import com.swmansion.gesturehandler.core.NativeViewGestureHandler;
import com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager;
import com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class RNGestureHandlerRootView extends ReactViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public boolean f46851a;

    /* renamed from: b, reason: collision with root package name */
    public RNGestureHandlerRootHelper f46852b;

    @Metadata
    public static final class Companion {
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.View
    public final boolean dispatchGenericMotionEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.f46851a) {
            RNGestureHandlerRootHelper rNGestureHandlerRootHelper = this.f46852b;
            Intrinsics.c(rNGestureHandlerRootHelper);
            if (rNGestureHandlerRootHelper.a(event)) {
                return true;
            }
        }
        return super.dispatchGenericMotionEvent(event);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (this.f46851a) {
            RNGestureHandlerRootHelper rNGestureHandlerRootHelper = this.f46852b;
            Intrinsics.c(rNGestureHandlerRootHelper);
            if (rNGestureHandlerRootHelper.a(ev)) {
                return true;
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    public final void j(RNGestureHandlerButtonViewManager.ButtonViewGroup view) {
        Intrinsics.checkNotNullParameter(view, "view");
        RNGestureHandlerRootHelper rNGestureHandlerRootHelper = this.f46852b;
        if (rNGestureHandlerRootHelper != null) {
            Intrinsics.checkNotNullParameter(view, "view");
            GestureHandlerOrchestrator gestureHandlerOrchestrator = rNGestureHandlerRootHelper.f46846b;
            if (gestureHandlerOrchestrator != null) {
                Intrinsics.checkNotNullParameter(view, "view");
                ArrayList<GestureHandler> arrayListE = gestureHandlerOrchestrator.f46734b.e(view);
                if (arrayListE != null) {
                    for (GestureHandler gestureHandler : arrayListE) {
                        if (gestureHandler instanceof NativeViewGestureHandler) {
                            gestureHandlerOrchestrator.d(gestureHandler, view);
                            NativeViewGestureHandler nativeViewGestureHandler = (NativeViewGestureHandler) gestureHandler;
                            coil3.decode.a closure = new coil3.decode.a((NativeViewGestureHandler) gestureHandler, 7);
                            nativeViewGestureHandler.getClass();
                            Intrinsics.checkNotNullParameter(closure, "closure");
                            nativeViewGestureHandler.f46722i = true;
                            closure.invoke();
                            nativeViewGestureHandler.f46722i = false;
                        }
                    }
                }
            }
        }
    }

    @Override // com.facebook.react.views.view.ReactViewGroup, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        boolean z;
        super.onAttachedToWindow();
        UiThreadUtil.assertOnUiThread();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if ((parent instanceof RNGestureHandlerEnabledRootView) || (parent instanceof RNGestureHandlerRootView)) {
                z = true;
                break;
            } else {
                if (parent instanceof RootView) {
                    break;
                }
            }
        }
        z = false;
        this.f46851a = !z;
        if (z) {
            Log.i("ReactNative", "[GESTURE HANDLER] Gesture handler is already enabled for a parent view");
        }
        if (this.f46851a && this.f46852b == null) {
            Context context = getContext();
            Intrinsics.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
            this.f46852b = new RNGestureHandlerRootHelper((ReactContext) context, this);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        RNGestureHandlerRootHelper.RootViewGestureHandler rootViewGestureHandler;
        if (this.f46851a) {
            RNGestureHandlerRootHelper rNGestureHandlerRootHelper = this.f46852b;
            Intrinsics.c(rNGestureHandlerRootHelper);
            if (rNGestureHandlerRootHelper.f46846b != null && !rNGestureHandlerRootHelper.f46850f && (rootViewGestureHandler = rNGestureHandlerRootHelper.f46847c) != null && rootViewGestureHandler.f46719f == 2) {
                rootViewGestureHandler.a(false);
                rootViewGestureHandler.j();
            }
        }
        super.requestDisallowInterceptTouchEvent(z);
    }
}
