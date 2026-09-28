package com.swmansion.gesturehandler.react;

import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.ThemedReactContext;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.core.GestureHandlerOrchestrator;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class RNGestureHandlerRootHelper {

    /* renamed from: a, reason: collision with root package name */
    public final ReactContext f46845a;

    /* renamed from: b, reason: collision with root package name */
    public final GestureHandlerOrchestrator f46846b;

    /* renamed from: c, reason: collision with root package name */
    public final RootViewGestureHandler f46847c;

    /* renamed from: d, reason: collision with root package name */
    public final ViewGroup f46848d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f46849e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f46850f;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public final class RootViewGestureHandler extends GestureHandler<RootViewGestureHandler> {
        public RootViewGestureHandler() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.swmansion.gesturehandler.core.GestureHandler
        public final void s() {
            RNGestureHandlerRootHelper rNGestureHandlerRootHelper = RNGestureHandlerRootHelper.this;
            rNGestureHandlerRootHelper.f46849e = true;
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
            motionEventObtain.setAction(3);
            ViewGroup viewGroup = rNGestureHandlerRootHelper.f46848d;
            if (viewGroup instanceof RootView) {
                ((RootView) viewGroup).a(viewGroup, motionEventObtain);
            }
            motionEventObtain.recycle();
        }

        @Override // com.swmansion.gesturehandler.core.GestureHandler
        public final void t(MotionEvent event, MotionEvent sourceEvent) {
            GestureHandlerOrchestrator gestureHandlerOrchestrator;
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
            if (this.f46719f == 0) {
                RNGestureHandlerRootHelper rNGestureHandlerRootHelper = RNGestureHandlerRootHelper.this;
                if (!rNGestureHandlerRootHelper.f46849e || (gestureHandlerOrchestrator = this.A) == null || ((arrayList = gestureHandlerOrchestrator.f46737e) != null && arrayList.isEmpty())) {
                    d();
                    rNGestureHandlerRootHelper.f46849e = false;
                } else {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (((GestureHandler) it.next()).f46719f == 4) {
                            break;
                        }
                    }
                    d();
                    rNGestureHandlerRootHelper.f46849e = false;
                }
            }
            if (event.getActionMasked() == 1) {
                j();
            }
        }
    }

    public RNGestureHandlerRootHelper(ReactContext context, RNGestureHandlerRootView wrappedView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(wrappedView, "wrappedView");
        this.f46845a = context;
        UiThreadUtil.assertOnUiThread();
        int id = wrappedView.getId();
        if (id < 1) {
            throw new IllegalStateException(("Expect view tag to be set for " + wrappedView).toString());
        }
        NativeModule nativeModule = ((ThemedReactContext) context).f19479a.getNativeModule((Class<NativeModule>) RNGestureHandlerModule.class);
        Intrinsics.c(nativeModule);
        RNGestureHandlerModule rNGestureHandlerModule = (RNGestureHandlerModule) nativeModule;
        RNGestureHandlerRegistry registry = rNGestureHandlerModule.getRegistry();
        UiThreadUtil.assertOnUiThread();
        ViewParent parent = wrappedView;
        while (parent != null && !(parent instanceof RootView)) {
            parent = parent.getParent();
        }
        if (parent == null) {
            throw new IllegalStateException(("View " + wrappedView + " has not been mounted under ReactRootView").toString());
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        this.f46848d = viewGroup;
        Log.i("ReactNative", "[GESTURE HANDLER] Initialize gesture handler for root view " + viewGroup);
        GestureHandlerOrchestrator gestureHandlerOrchestrator = new GestureHandlerOrchestrator(wrappedView, registry, new RNViewConfigurationHelper());
        gestureHandlerOrchestrator.f46736d = 0.1f;
        this.f46846b = gestureHandlerOrchestrator;
        RootViewGestureHandler rootViewGestureHandler = new RootViewGestureHandler();
        rootViewGestureHandler.f46717d = -id;
        this.f46847c = rootViewGestureHandler;
        registry.f(rootViewGestureHandler);
        registry.a(rootViewGestureHandler.f46717d, id, 3);
        rNGestureHandlerModule.registerRootHelper(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 569
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.react.RNGestureHandlerRootHelper.a(android.view.MotionEvent):boolean");
    }

    public final void b() {
        Log.i("ReactNative", "[GESTURE HANDLER] Tearing down gesture handler registered for root view " + this.f46848d);
        NativeModule nativeModule = ((ThemedReactContext) this.f46845a).f19479a.getNativeModule((Class<NativeModule>) RNGestureHandlerModule.class);
        Intrinsics.c(nativeModule);
        RNGestureHandlerModule rNGestureHandlerModule = (RNGestureHandlerModule) nativeModule;
        RNGestureHandlerRegistry registry = rNGestureHandlerModule.getRegistry();
        RootViewGestureHandler rootViewGestureHandler = this.f46847c;
        Intrinsics.c(rootViewGestureHandler);
        registry.c(rootViewGestureHandler.f46717d);
        rNGestureHandlerModule.unregisterRootHelper(this);
    }
}
