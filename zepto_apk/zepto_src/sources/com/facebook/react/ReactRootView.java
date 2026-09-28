package com.facebook.react;

import android.app.Activity;
import android.content.Context;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import android.util.AttributeSet;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.infer.annotation.ThreadConfined;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.modules.appregistry.AppRegistry;
import com.facebook.react.modules.deviceinfo.DeviceInfoModule;
import com.facebook.react.uimanager.BlendModeHelper;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.JSPointerDispatcher;
import com.facebook.react.uimanager.JSTouchDispatcher;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactClippingProhibitedView;
import com.facebook.react.uimanager.ReactRoot;
import com.facebook.react.uimanager.ReactRootViewTagGenerator;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.RootViewUtil;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import in.juspay.hyper.constants.Labels;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public class ReactRootView extends FrameLayout implements RootView, ReactRoot {

    /* renamed from: a, reason: collision with root package name */
    public ReactInstanceManager f18497a;

    /* renamed from: b, reason: collision with root package name */
    public String f18498b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f18499c;

    /* renamed from: d, reason: collision with root package name */
    public CustomGlobalLayoutListener f18500d;

    /* renamed from: e, reason: collision with root package name */
    public ReactRootViewEventListener f18501e;

    /* renamed from: f, reason: collision with root package name */
    public int f18502f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f18503g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f18504h;

    /* renamed from: i, reason: collision with root package name */
    public JSTouchDispatcher f18505i;

    /* renamed from: j, reason: collision with root package name */
    public JSPointerDispatcher f18506j;

    /* renamed from: k, reason: collision with root package name */
    public final ReactAndroidHWInputDeviceHelper f18507k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f18508l;

    /* renamed from: m, reason: collision with root package name */
    public int f18509m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public final AtomicInteger t;

    public class CustomGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        public final Rect f18512a;

        /* renamed from: b, reason: collision with root package name */
        public final int f18513b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f18514c = false;

        /* renamed from: d, reason: collision with root package name */
        public int f18515d = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f18516e = 0;

        public CustomGlobalLayoutListener() {
            DisplayMetricsHolder.f(ReactRootView.this.getContext().getApplicationContext());
            this.f18512a = new Rect();
            this.f18513b = (int) PixelUtil.b(60.0f);
        }

        public static WritableMap a(double d2, double d3, double d4, double d5) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            WritableMap writableMapCreateMap2 = Arguments.createMap();
            writableMapCreateMap2.putDouble(Snapshot.HEIGHT, d5);
            writableMapCreateMap2.putDouble("screenX", d3);
            writableMapCreateMap2.putDouble(Snapshot.WIDTH, d4);
            writableMapCreateMap2.putDouble("screenY", d2);
            writableMapCreateMap.putMap("endCoordinates", writableMapCreateMap2);
            writableMapCreateMap.putString("easing", Labels.System.KEYBOARD);
            writableMapCreateMap.putDouble("duration", 0.0d);
            return writableMapCreateMap;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            WindowInsets rootWindowInsets;
            DisplayCutout displayCutout;
            DeviceInfoModule deviceInfoModule;
            String str;
            double d2;
            double d3;
            boolean zIsVisible;
            ReactRootView reactRootView = ReactRootView.this;
            if (reactRootView.i() && reactRootView.l()) {
                int i2 = Build.VERSION.SDK_INT;
                boolean z = true;
                Rect rect = this.f18512a;
                if (i2 >= 30) {
                    reactRootView.getRootView().getWindowVisibleDisplayFrame(rect);
                    WindowInsets rootWindowInsets2 = reactRootView.getRootView().getRootWindowInsets();
                    if (rootWindowInsets2 != null && (zIsVisible = rootWindowInsets2.isVisible(WindowInsets.Type.ime())) != this.f18514c) {
                        this.f18514c = zIsVisible;
                        if (zIsVisible) {
                            int i3 = rootWindowInsets2.getInsets(WindowInsets.Type.ime()).bottom - rootWindowInsets2.getInsets(WindowInsets.Type.systemBars()).bottom;
                            ViewGroup.LayoutParams layoutParams = reactRootView.getRootView().getLayoutParams();
                            Assertions.a(layoutParams instanceof WindowManager.LayoutParams);
                            reactRootView.m("keyboardDidShow", a(PixelUtil.a(((WindowManager.LayoutParams) layoutParams).softInputMode == 48 ? rect.bottom - i3 : rect.bottom), PixelUtil.a(rect.left), PixelUtil.a(rect.width()), PixelUtil.a(i3)));
                        } else {
                            reactRootView.m("keyboardDidHide", a(PixelUtil.a(rect.height()), 0.0d, PixelUtil.a(rect.width()), 0.0d));
                        }
                    }
                } else {
                    reactRootView.getRootView().getWindowVisibleDisplayFrame(rect);
                    int safeInsetTop = (i2 < 28 || (rootWindowInsets = reactRootView.getRootView().getRootWindowInsets()) == null || (displayCutout = rootWindowInsets.getDisplayCutout()) == null) ? 0 : displayCutout.getSafeInsetTop();
                    int i4 = (DisplayMetricsHolder.d().heightPixels - rect.bottom) + safeInsetTop;
                    int i5 = this.f18515d;
                    int i6 = this.f18513b;
                    if (i5 != i4 && i4 > i6) {
                        this.f18515d = i4;
                        this.f18514c = true;
                        reactRootView.m("keyboardDidShow", a(PixelUtil.a(r9), PixelUtil.a(rect.left), PixelUtil.a(rect.width()), PixelUtil.a(this.f18515d)));
                    } else if (i5 != 0 && i4 <= i6) {
                        this.f18515d = 0;
                        this.f18514c = false;
                        reactRootView.m("keyboardDidHide", a(PixelUtil.a(rect.height()), 0.0d, PixelUtil.a(rect.width()), 0.0d));
                    }
                }
                int rotation = ((WindowManager) reactRootView.getContext().getSystemService("window")).getDefaultDisplay().getRotation();
                if (this.f18516e != rotation) {
                    this.f18516e = rotation;
                    DisplayMetricsHolder.e(reactRootView.getContext().getApplicationContext());
                    if (rotation != 0) {
                        if (rotation == 1) {
                            str = "landscape-primary";
                            d3 = -90.0d;
                        } else if (rotation == 2) {
                            str = "portrait-secondary";
                            d2 = 180.0d;
                        } else if (rotation == 3) {
                            str = "landscape-secondary";
                            d3 = 90.0d;
                        }
                        WritableMap writableMapCreateMap = Arguments.createMap();
                        writableMapCreateMap.putString(CLConstants.FIELD_PAY_INFO_NAME, str);
                        writableMapCreateMap.putDouble("rotationDegrees", d3);
                        writableMapCreateMap.putBoolean("isLandscape", z);
                        reactRootView.m("namedOrientationDidChange", writableMapCreateMap);
                    } else {
                        str = "portrait-primary";
                        d2 = 0.0d;
                    }
                    z = false;
                    d3 = d2;
                    WritableMap writableMapCreateMap2 = Arguments.createMap();
                    writableMapCreateMap2.putString(CLConstants.FIELD_PAY_INFO_NAME, str);
                    writableMapCreateMap2.putDouble("rotationDegrees", d3);
                    writableMapCreateMap2.putBoolean("isLandscape", z);
                    reactRootView.m("namedOrientationDidChange", writableMapCreateMap2);
                }
                ReactContext currentReactContext = reactRootView.getCurrentReactContext();
                if (currentReactContext == null || (deviceInfoModule = (DeviceInfoModule) currentReactContext.getNativeModule(DeviceInfoModule.class)) == null) {
                    return;
                }
                deviceInfoModule.emitUpdateDimensionsEvent();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface ReactRootViewEventListener {
        void a();
    }

    public ReactRootView(Activity activity) {
        super(activity);
        this.f18502f = 0;
        this.f18507k = new ReactAndroidHWInputDeviceHelper(this);
        this.f18508l = false;
        this.f18509m = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.n = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.o = 0;
        this.p = 0;
        this.q = Integer.MIN_VALUE;
        this.r = Integer.MIN_VALUE;
        this.s = 1;
        this.t = new AtomicInteger(0);
        setRootViewTag(ReactRootViewTagGenerator.a());
        setClipChildren(false);
    }

    private CustomGlobalLayoutListener getCustomGlobalLayoutListener() {
        if (this.f18500d == null) {
            this.f18500d = new CustomGlobalLayoutListener();
        }
        return this.f18500d;
    }

    @Override // com.facebook.react.uimanager.RootView
    public void a(View view, MotionEvent motionEvent) {
        EventDispatcher eventDispatcherA;
        JSPointerDispatcher jSPointerDispatcher;
        if (k() && (eventDispatcherA = UIManagerHelper.a(getCurrentReactContext(), getUIManagerType())) != null) {
            this.f18505i.c(motionEvent, eventDispatcherA);
            if (view == null || (jSPointerDispatcher = this.f18506j) == null) {
                return;
            }
            jSPointerDispatcher.g(view, motionEvent, eventDispatcherA);
        }
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    public final void b() {
        Intrinsics.checkNotNullParameter("ReactRootView.runApplication", "sectionName");
        Trace.beginSection(androidx.tracing.Trace.g("ReactRootView.runApplication"));
        try {
            if (j() && l()) {
                ReactContext currentReactContext = getCurrentReactContext();
                if (currentReactContext == null) {
                    Trace.endSection();
                    return;
                }
                CatalystInstance catalystInstance = currentReactContext.getCatalystInstance();
                String jSModuleName = getJSModuleName();
                if (this.f18508l) {
                    o(this.f18509m, this.n, true);
                }
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putDouble("rootTag", getRootViewTag());
                Bundle appProperties = getAppProperties();
                if (appProperties != null) {
                    writableNativeMap.putMap("initialProps", Arguments.fromBundle(appProperties));
                }
                this.f18504h = true;
                ((AppRegistry) catalystInstance.getJSModule(AppRegistry.class)).runApplication(jSModuleName, writableNativeMap);
                Trace.endSection();
            }
        } finally {
            Trace.endSection();
        }
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    public final void c() {
        this.f18505i = new JSTouchDispatcher(this);
        if (ReactFeatureFlags.dispatchPointerEvents) {
            this.f18506j = new JSPointerDispatcher(this);
        }
        ReactRootViewEventListener reactRootViewEventListener = this.f18501e;
        if (reactRootViewEventListener != null) {
            reactRootViewEventListener.a();
        }
    }

    @Override // com.facebook.react.uimanager.RootView
    public void d(ViewGroup viewGroup, MotionEvent motionEvent) {
        if (k() && UIManagerHelper.a(getCurrentReactContext(), getUIManagerType()) != null) {
            this.f18505i.f19384c = false;
            JSPointerDispatcher jSPointerDispatcher = this.f18506j;
            if (jSPointerDispatcher != null) {
                jSPointerDispatcher.f();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        } catch (StackOverflowError e2) {
            h(e2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!i() || !l()) {
            FLog.q("ReactRootView", "Unable to handle key event as the catalyst instance has not been attached");
            return super.dispatchKeyEvent(keyEvent);
        }
        ReactAndroidHWInputDeviceHelper reactAndroidHWInputDeviceHelper = this.f18507k;
        reactAndroidHWInputDeviceHelper.getClass();
        int keyCode = keyEvent.getKeyCode();
        int action = keyEvent.getAction();
        if (action == 1 || action == 0) {
            HashMap map = ReactAndroidHWInputDeviceHelper.f18442c;
            if (map.containsKey(Integer.valueOf(keyCode))) {
                reactAndroidHWInputDeviceHelper.a(reactAndroidHWInputDeviceHelper.f18443a, action, (String) map.get(Integer.valueOf(keyCode)));
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j2) {
        Canvas canvas2;
        BlendMode blendModeD;
        if (Build.VERSION.SDK_INT >= 29 && ViewUtil.b(this) == 2 && BlendModeHelper.a(this)) {
            blendModeD = androidx.appcompat.widget.a.d(view.getTag(R.id.mix_blend_mode));
            if (blendModeD != null) {
                Paint paint = new Paint();
                paint.setBlendMode(blendModeD);
                canvas2 = canvas;
                canvas2.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), paint);
            } else {
                canvas2 = canvas;
            }
        } else {
            canvas2 = canvas;
            blendModeD = null;
        }
        boolean zDrawChild = super.drawChild(canvas2, view, j2);
        if (blendModeD != null) {
            canvas2.restore();
        }
        return zDrawChild;
    }

    public final void e() {
        Intrinsics.checkNotNullParameter("attachToReactInstanceManager", "sectionName");
        Trace.beginSection(androidx.tracing.Trace.g("attachToReactInstanceManager"));
        ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_ATTACH_TO_REACT_INSTANCE_MANAGER_START);
        if (getId() != -1) {
            ReactSoftExceptionLogger.logSoftException("ReactRootView", new IllegalViewOperationException("Trying to attach a ReactRootView with an explicit id already set to [" + getId() + "]. React Native uses the id field to track react tags and will overwrite this field. If that is fine, explicitly overwrite the id field to View.NO_ID."));
        }
        try {
            if (this.f18503g) {
                return;
            }
            this.f18503g = true;
            ReactInstanceManager reactInstanceManager = this.f18497a;
            Assertions.c(reactInstanceManager);
            reactInstanceManager.a(this);
            getViewTreeObserver().addOnGlobalLayoutListener(getCustomGlobalLayoutListener());
        } finally {
            ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_ATTACH_TO_REACT_INSTANCE_MANAGER_END);
            Trace.endSection();
        }
    }

    public void f(MotionEvent motionEvent, boolean z) {
        if (!i() || !l()) {
            FLog.q("ReactRootView", "Unable to dispatch touch to JS as the catalyst instance has not been attached");
            return;
        }
        if (this.f18506j == null) {
            if (ReactFeatureFlags.dispatchPointerEvents) {
                FLog.q("ReactRootView", "Unable to dispatch pointer events to JS before the dispatcher is available");
            }
        } else {
            EventDispatcher eventDispatcherA = UIManagerHelper.a(getCurrentReactContext(), getUIManagerType());
            if (eventDispatcherA != null) {
                this.f18506j.d(motionEvent, eventDispatcherA, z);
            }
        }
    }

    public final void finalize() throws Throwable {
        super.finalize();
        Assertions.b(!this.f18503g, "The application this ReactRootView was rendering was not unmounted before the ReactRootView was garbage collected. This usually means that your application is leaking large amounts of memory. To solve this, make sure to call ReactRootView#unmountReactApplication in the onDestroy() of your hosting Activity or in the onDestroyView() of your hosting Fragment.");
    }

    public void g(MotionEvent motionEvent) {
        if (!i() || !l()) {
            FLog.q("ReactRootView", "Unable to dispatch touch to JS as the catalyst instance has not been attached");
            return;
        }
        if (this.f18505i == null) {
            FLog.q("ReactRootView", "Unable to dispatch touch to JS before the dispatcher is available");
            return;
        }
        EventDispatcher eventDispatcherA = UIManagerHelper.a(getCurrentReactContext(), getUIManagerType());
        if (eventDispatcherA != null) {
            this.f18505i.b(motionEvent, eventDispatcherA, getCurrentReactContext());
        }
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    @Nullable
    public Bundle getAppProperties() {
        return this.f18499c;
    }

    @Nullable
    public ReactContext getCurrentReactContext() {
        ReactInstanceManager reactInstanceManager = this.f18497a;
        if (reactInstanceManager == null) {
            return null;
        }
        return reactInstanceManager.f();
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    public int getHeightMeasureSpec() {
        return this.n;
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    public String getJSModuleName() {
        String str = this.f18498b;
        Assertions.c(str);
        return str;
    }

    @Nullable
    public ReactInstanceManager getReactInstanceManager() {
        return this.f18497a;
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    public ViewGroup getRootViewGroup() {
        return this;
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    public int getRootViewTag() {
        return this.f18502f;
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    public AtomicInteger getState() {
        return this.t;
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    @Nullable
    public String getSurfaceID() {
        Bundle appProperties = getAppProperties();
        if (appProperties != null) {
            return appProperties.getString("surfaceID");
        }
        return null;
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    public int getUIManagerType() {
        return this.s;
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    public int getWidthMeasureSpec() {
        return this.f18509m;
    }

    public void h(StackOverflowError stackOverflowError) {
        if (!i()) {
            throw new RuntimeException(stackOverflowError);
        }
        getCurrentReactContext().handleException(new IllegalViewOperationException(stackOverflowError.getMessage(), this, stackOverflowError));
    }

    public boolean i() {
        ReactInstanceManager reactInstanceManager = this.f18497a;
        return (reactInstanceManager == null || reactInstanceManager.f() == null) ? false : true;
    }

    public boolean j() {
        return this.f18497a != null;
    }

    public final boolean k() {
        if (!i() || !l()) {
            FLog.q("ReactRootView", "Unable to dispatch touch to JS as the catalyst instance has not been attached");
            return false;
        }
        if (this.f18505i == null) {
            FLog.q("ReactRootView", "Unable to dispatch touch to JS before the dispatcher is available");
            return false;
        }
        if (!ReactFeatureFlags.dispatchPointerEvents || this.f18506j != null) {
            return true;
        }
        FLog.q("ReactRootView", "Unable to dispatch pointer events to JS before the dispatcher is available");
        return false;
    }

    public boolean l() {
        return this.f18503g;
    }

    public final void m(String str, WritableMap writableMap) {
        if (j()) {
            getCurrentReactContext().emitDeviceEvent(str, writableMap);
        }
    }

    public final void n() {
        ReactApplicationContext reactApplicationContext;
        UiThreadUtil.assertOnUiThread();
        ReactInstanceManager reactInstanceManager = this.f18497a;
        if (reactInstanceManager != null && this.f18503g) {
            UiThreadUtil.assertOnUiThread();
            if (reactInstanceManager.f18454a.remove(this) && (reactApplicationContext = reactInstanceManager.n) != null && reactApplicationContext.hasActiveReactInstance()) {
                ReactInstanceManager.e(this, reactApplicationContext);
            }
            this.f18503g = false;
        }
        this.f18497a = null;
        this.f18504h = false;
    }

    public final void o(int i2, int i3, boolean z) {
        UIManager uIManagerF;
        int i4;
        int i5;
        int i6;
        ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_UPDATE_LAYOUT_SPECS_START);
        if (!j()) {
            ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_UPDATE_LAYOUT_SPECS_END);
            FLog.q("ReactRootView", "Unable to update root layout specs for uninitialized ReactInstanceManager");
            return;
        }
        boolean z2 = getUIManagerType() == 2;
        if (z2 && ((i6 = this.f18502f) == 0 || i6 == -1)) {
            ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_UPDATE_LAYOUT_SPECS_END);
            FLog.g("ReactRootView", "Unable to update root layout specs for ReactRootView: no rootViewTag set yet");
            return;
        }
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext != null && (uIManagerF = UIManagerHelper.f(currentReactContext, getUIManagerType(), true)) != null) {
            if (z2) {
                Point pointB = RootViewUtil.b(this);
                int i7 = pointB.x;
                i5 = pointB.y;
                i4 = i7;
            } else {
                i4 = 0;
                i5 = 0;
            }
            if (z || i4 != this.q || i5 != this.r) {
                uIManagerF.updateRootLayoutSpecs(getRootViewTag(), i2, i3, i4, i5);
            }
            this.q = i4;
            this.r = i5;
        }
        ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_UPDATE_LAYOUT_SPECS_END);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (l()) {
            getViewTreeObserver().removeOnGlobalLayoutListener(getCustomGlobalLayoutListener());
            getViewTreeObserver().addOnGlobalLayoutListener(getCustomGlobalLayoutListener());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (l()) {
            getViewTreeObserver().removeOnGlobalLayoutListener(getCustomGlobalLayoutListener());
        }
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean z, int i2, Rect rect) {
        if (!i() || !l()) {
            FLog.q("ReactRootView", "Unable to handle focus changed event as the catalyst instance has not been attached");
            super.onFocusChanged(z, i2, rect);
            return;
        }
        ReactAndroidHWInputDeviceHelper reactAndroidHWInputDeviceHelper = this.f18507k;
        int i3 = reactAndroidHWInputDeviceHelper.f18443a;
        if (i3 != -1) {
            reactAndroidHWInputDeviceHelper.a(i3, -1, "blur");
        }
        reactAndroidHWInputDeviceHelper.f18443a = -1;
        super.onFocusChanged(z, i2, rect);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        f(motionEvent, false);
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptHoverEvent(MotionEvent motionEvent) {
        f(motionEvent, true);
        return super.onInterceptHoverEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        g(motionEvent);
        f(motionEvent, true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.f18508l && getUIManagerType() == 2) {
            o(this.f18509m, this.n, false);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int iMax;
        int iMax2;
        Intrinsics.checkNotNullParameter("ReactRootView.onMeasure", "sectionName");
        Trace.beginSection(androidx.tracing.Trace.g("ReactRootView.onMeasure"));
        ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_ON_MEASURE_START);
        try {
            boolean z = (i2 == this.f18509m && i3 == this.n) ? false : true;
            this.f18509m = i2;
            this.n = i3;
            int mode = View.MeasureSpec.getMode(i2);
            if (mode == Integer.MIN_VALUE || mode == 0) {
                iMax = 0;
                for (int i4 = 0; i4 < getChildCount(); i4++) {
                    View childAt = getChildAt(i4);
                    iMax = Math.max(iMax, childAt.getLeft() + childAt.getMeasuredWidth() + childAt.getPaddingLeft() + childAt.getPaddingRight());
                }
            } else {
                iMax = View.MeasureSpec.getSize(i2);
            }
            int mode2 = View.MeasureSpec.getMode(i3);
            if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
                iMax2 = 0;
                for (int i5 = 0; i5 < getChildCount(); i5++) {
                    View childAt2 = getChildAt(i5);
                    iMax2 = Math.max(iMax2, childAt2.getTop() + childAt2.getMeasuredHeight() + childAt2.getPaddingTop() + childAt2.getPaddingBottom());
                }
            } else {
                iMax2 = View.MeasureSpec.getSize(i3);
            }
            setMeasuredDimension(iMax, iMax2);
            this.f18508l = true;
            if (j() && !l()) {
                e();
            } else if (z || this.o != iMax || this.p != iMax2) {
                o(this.f18509m, this.n, true);
            }
            this.o = iMax;
            this.p = iMax2;
            ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_ON_MEASURE_END);
            Trace.endSection();
        } catch (Throwable th) {
            ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_ON_MEASURE_END);
            Trace.endSection();
            throw th;
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        g(motionEvent);
        f(motionEvent, false);
        super.onTouchEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(final View view) {
        super.onViewAdded(view);
        if (view instanceof ReactClippingProhibitedView) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.ReactRootView.1
                @Override // java.lang.Runnable
                public final void run() {
                    View view2 = view;
                    if (view2.isShown()) {
                        return;
                    }
                    ReactSoftExceptionLogger.logSoftException("ReactRootView", new ReactNoCrashSoftException("A view was illegally added as a child of a ReactRootView. This View should not be a direct child of a ReactRootView, because it is not visible and will never be reachable. Child: " + view2.getClass().getCanonicalName().toString() + " child ID: " + view2.getId()));
                }
            });
        }
        if (this.f18504h) {
            this.f18504h = false;
            ReactMarker.logMarker(ReactMarkerConstants.CONTENT_APPEARED, getJSModuleName(), this.f18502f);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        if (!i() || !l()) {
            FLog.q("ReactRootView", "Unable to handle child focus changed event as the catalyst instance has not been attached");
            super.requestChildFocus(view, view2);
            return;
        }
        ReactAndroidHWInputDeviceHelper reactAndroidHWInputDeviceHelper = this.f18507k;
        if (reactAndroidHWInputDeviceHelper.f18443a != view2.getId()) {
            int i2 = reactAndroidHWInputDeviceHelper.f18443a;
            if (i2 != -1) {
                reactAndroidHWInputDeviceHelper.a(i2, -1, "blur");
            }
            reactAndroidHWInputDeviceHelper.f18443a = view2.getId();
            reactAndroidHWInputDeviceHelper.a(view2.getId(), -1, "focus");
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    @ThreadConfined
    public void setAppProperties(@Nullable Bundle bundle) {
        UiThreadUtil.assertOnUiThread();
        this.f18499c = bundle;
        int i2 = this.f18502f;
        if (i2 == 0 || i2 == -1) {
            return;
        }
        b();
    }

    public void setEventListener(@Nullable ReactRootViewEventListener reactRootViewEventListener) {
        this.f18501e = reactRootViewEventListener;
    }

    public void setIsFabric(boolean z) {
        this.s = z ? 2 : 1;
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    public void setRootViewTag(int i2) {
        this.f18502f = i2;
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    public void setShouldLogContentAppeared(boolean z) {
        this.f18504h = z;
    }

    public ReactRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18502f = 0;
        this.f18507k = new ReactAndroidHWInputDeviceHelper(this);
        this.f18508l = false;
        this.f18509m = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.n = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.o = 0;
        this.p = 0;
        this.q = Integer.MIN_VALUE;
        this.r = Integer.MIN_VALUE;
        this.s = 1;
        this.t = new AtomicInteger(0);
        setRootViewTag(ReactRootViewTagGenerator.a());
        setClipChildren(false);
    }

    public ReactRootView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f18502f = 0;
        this.f18507k = new ReactAndroidHWInputDeviceHelper(this);
        this.f18508l = false;
        this.f18509m = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.n = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.o = 0;
        this.p = 0;
        this.q = Integer.MIN_VALUE;
        this.r = Integer.MIN_VALUE;
        this.s = 1;
        this.t = new AtomicInteger(0);
        setRootViewTag(ReactRootViewTagGenerator.a());
        setClipChildren(false);
    }
}
