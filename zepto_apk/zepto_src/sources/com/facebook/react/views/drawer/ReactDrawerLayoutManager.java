package com.facebook.react.views.drawer;

import android.support.v4.media.b;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.facebook.common.logging.FLog;
import com.facebook.react.R;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactAccessibilityDelegate;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerDelegate;
import com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerInterface;
import com.facebook.react.views.drawer.events.DrawerClosedEvent;
import com.facebook.react.views.drawer.events.DrawerOpenedEvent;
import com.facebook.react.views.drawer.events.DrawerSlideEvent;
import com.facebook.react.views.drawer.events.DrawerStateChangedEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@ReactModule(name = ReactDrawerLayoutManager.REACT_CLASS)
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ReactDrawerLayoutManager extends ViewGroupManager<ReactDrawerLayout> implements AndroidDrawerLayoutManagerInterface<ReactDrawerLayout> {
    public static final int CLOSE_DRAWER = 2;

    @NotNull
    public static final String COMMAND_CLOSE_DRAWER = "closeDrawer";

    @NotNull
    public static final String COMMAND_OPEN_DRAWER = "openDrawer";

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    private static final String DRAWER_POSITION = "DrawerPosition";

    @NotNull
    private static final String DRAWER_POSITION_LEFT = "Left";

    @NotNull
    private static final String DRAWER_POSITION_RIGHT = "Right";
    public static final int OPEN_DRAWER = 1;

    @NotNull
    public static final String REACT_CLASS = "AndroidDrawerLayout";

    @NotNull
    private final ViewManagerDelegate<ReactDrawerLayout> delegate = new AndroidDrawerLayoutManagerDelegate(this);

    @Metadata
    public static final class Companion {
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static final class DrawerEventEmitter implements DrawerLayout.DrawerListener {

        /* renamed from: a, reason: collision with root package name */
        public final ReactDrawerLayout f19934a;

        /* renamed from: b, reason: collision with root package name */
        public final EventDispatcher f19935b;

        public DrawerEventEmitter(ReactDrawerLayout drawerLayout, EventDispatcher eventDispatcher) {
            Intrinsics.checkNotNullParameter(drawerLayout, "drawerLayout");
            Intrinsics.checkNotNullParameter(eventDispatcher, "eventDispatcher");
            this.f19934a = drawerLayout;
            this.f19935b = eventDispatcher;
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public final void a(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ReactDrawerLayout reactDrawerLayout = this.f19934a;
            this.f19935b.g(new DrawerOpenedEvent(UIManagerHelper.e(reactDrawerLayout), reactDrawerLayout.getId()));
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public final void b(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ReactDrawerLayout reactDrawerLayout = this.f19934a;
            this.f19935b.g(new DrawerClosedEvent(UIManagerHelper.e(reactDrawerLayout), reactDrawerLayout.getId()));
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public final void c(int i2) {
            ReactDrawerLayout reactDrawerLayout = this.f19934a;
            this.f19935b.g(new DrawerStateChangedEvent(UIManagerHelper.e(reactDrawerLayout), reactDrawerLayout.getId(), i2));
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public final void d(View view, float f2) {
            Intrinsics.checkNotNullParameter(view, "view");
            ReactDrawerLayout reactDrawerLayout = this.f19934a;
            this.f19935b.g(new DrawerSlideEvent(f2, UIManagerHelper.e(reactDrawerLayout), reactDrawerLayout.getId()));
        }
    }

    private final void setDrawerPositionInternal(ReactDrawerLayout reactDrawerLayout, String str) {
        if (Intrinsics.b(str, "left")) {
            reactDrawerLayout.setDrawerPosition$ReactAndroid_release(8388611);
            return;
        }
        if (Intrinsics.b(str, "right")) {
            reactDrawerLayout.setDrawerPosition$ReactAndroid_release(8388613);
            return;
        }
        FLog.q("ReactNative", "drawerPosition must be 'left' or 'right', received" + str);
        reactDrawerLayout.setDrawerPosition$ReactAndroid_release(8388611);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public Map<String, Integer> getCommandsMap() {
        return MapsKt.h(new Pair(COMMAND_OPEN_DRAWER, 1), new Pair(COMMAND_CLOSE_DRAWER, 2));
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public ViewManagerDelegate<ReactDrawerLayout> getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @NotNull
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new LinkedHashMap<>();
        }
        exportedCustomDirectEventTypeConstants.put("topDrawerSlide", MapsKt.g(new Pair("registrationName", "onDrawerSlide")));
        exportedCustomDirectEventTypeConstants.put("topDrawerOpen", MapsKt.g(new Pair("registrationName", "onDrawerOpen")));
        exportedCustomDirectEventTypeConstants.put("topDrawerClose", MapsKt.g(new Pair("registrationName", "onDrawerClose")));
        exportedCustomDirectEventTypeConstants.put("topDrawerStateChanged", MapsKt.g(new Pair("registrationName", "onDrawerStateChanged")));
        return exportedCustomDirectEventTypeConstants;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public Map<String, Object> getExportedViewConstants() {
        return MapsKt.g(new Pair(DRAWER_POSITION, MapsKt.h(new Pair(DRAWER_POSITION_LEFT, 8388611), new Pair(DRAWER_POSITION_RIGHT, 8388613))));
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewManagerWithChildren
    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
        super.removeAllViews(view);
    }

    @Override // com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerInterface
    @ReactProp(customType = "Color", name = "drawerBackgroundColor")
    public void setDrawerBackgroundColor(@NotNull ReactDrawerLayout view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerInterface
    @ReactProp(name = "keyboardDismissMode")
    public void setKeyboardDismissMode(@NotNull ReactDrawerLayout view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerInterface
    @ReactProp(customType = "Color", name = "statusBarBackgroundColor")
    public void setStatusBarBackgroundColor(@NotNull ReactDrawerLayout view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(@NotNull ThemedReactContext reactContext, @NotNull ReactDrawerLayout view) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(view, "view");
        EventDispatcher eventDispatcherB = UIManagerHelper.b(reactContext, view.getId());
        if (eventDispatcherB == null) {
            return;
        }
        view.a(new DrawerEventEmitter(view, eventDispatcherB));
    }

    @Override // com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerInterface
    public void closeDrawer(@NotNull ReactDrawerLayout view) {
        Intrinsics.checkNotNullParameter(view, "view");
        int i2 = view.I;
        View viewE = view.e(i2);
        if (viewE != null) {
            view.c(viewE, true);
        } else {
            throw new IllegalArgumentException("No drawer view found with gravity " + DrawerLayout.j(i2));
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public ReactDrawerLayout createViewInstance(@NotNull ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "context");
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        ReactDrawerLayout reactDrawerLayout = new ReactDrawerLayout(reactContext, null);
        reactDrawerLayout.I = 8388611;
        reactDrawerLayout.J = -1;
        ViewCompat.z(reactDrawerLayout, new AccessibilityDelegateCompat() { // from class: com.facebook.react.views.drawer.ReactDrawerLayout.1
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public final void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
                Intrinsics.checkNotNullParameter(host, "host");
                Intrinsics.checkNotNullParameter(event, "event");
                super.onInitializeAccessibilityEvent(host, event);
                Object tag = host.getTag(R.id.accessibility_role);
                if (tag instanceof ReactAccessibilityDelegate.AccessibilityRole) {
                    event.setClassName(ReactAccessibilityDelegate.AccessibilityRole.c((ReactAccessibilityDelegate.AccessibilityRole) tag));
                }
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public final void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
                Intrinsics.checkNotNullParameter(host, "host");
                Intrinsics.checkNotNullParameter(info, "info");
                super.onInitializeAccessibilityNodeInfo(host, info);
                ReactAccessibilityDelegate.AccessibilityRole accessibilityRoleB = ReactAccessibilityDelegate.AccessibilityRole.b(host);
                if (accessibilityRoleB != null) {
                    info.m(ReactAccessibilityDelegate.AccessibilityRole.c(accessibilityRoleB));
                }
            }
        });
        return reactDrawerLayout;
    }

    @Override // com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerInterface
    public void openDrawer(@NotNull ReactDrawerLayout view) {
        Intrinsics.checkNotNullParameter(view, "view");
        int i2 = view.I;
        View viewE = view.e(i2);
        if (viewE != null) {
            view.o(viewE);
        } else {
            throw new IllegalArgumentException("No drawer view found with gravity " + DrawerLayout.j(i2));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
    
        if (r5.equals("unlocked") != false) goto L25;
     */
    @Override // com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerInterface
    @com.facebook.react.uimanager.annotations.ReactProp(name = "drawerLockMode")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setDrawerLockMode(@org.jetbrains.annotations.NotNull com.facebook.react.views.drawer.ReactDrawerLayout r4, @org.jetbrains.annotations.Nullable java.lang.String r5) {
        /*
            r3 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = 0
            if (r5 == 0) goto L4f
            int r1 = r5.hashCode()
            r2 = -1292600945(0xffffffffb2f4798f, float:-2.8460617E-8)
            if (r1 == r2) goto L33
            r2 = -210949405(0xfffffffff36d2ae3, float:-1.8790347E31)
            if (r1 == r2) goto L2a
            r2 = 168848173(0xa106b2d, float:6.953505E-33)
            if (r1 == r2) goto L1c
            goto L3b
        L1c:
            java.lang.String r1 = "locked-open"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L25
            goto L3b
        L25:
            r5 = 2
            r4.setDrawerLockMode(r5)
            return
        L2a:
            java.lang.String r1 = "unlocked"
            boolean r1 = r5.equals(r1)
            if (r1 == 0) goto L3b
            goto L4f
        L33:
            java.lang.String r1 = "locked-closed"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L4a
        L3b:
            java.lang.String r1 = "Unknown drawerLockMode "
            java.lang.String r5 = r1.concat(r5)
            java.lang.String r1 = "ReactNative"
            com.facebook.common.logging.FLog.q(r1, r5)
            r4.setDrawerLockMode(r0)
            return
        L4a:
            r5 = 1
            r4.setDrawerLockMode(r5)
            return
        L4f:
            r4.setDrawerLockMode(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.drawer.ReactDrawerLayoutManager.setDrawerLockMode(com.facebook.react.views.drawer.ReactDrawerLayout, java.lang.String):void");
    }

    @Override // com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerInterface
    public void setDrawerPosition(@NotNull ReactDrawerLayout view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (str == null) {
            view.setDrawerPosition$ReactAndroid_release(8388611);
        } else {
            setDrawerPositionInternal(view, str);
        }
    }

    @ReactProp(defaultFloat = Float.NaN, name = "drawerWidth")
    public final void setDrawerWidth(@NotNull ReactDrawerLayout view, float f2) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setDrawerWidth$ReactAndroid_release(Float.isNaN(f2) ? -1 : Math.round(PixelUtil.b(f2)));
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    public void setElevation(@NotNull ReactDrawerLayout view, float f2) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setDrawerElevation(PixelUtil.b(f2));
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(@NotNull ReactDrawerLayout parent, @NotNull View child, int i2) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        if (getChildCount((ReactDrawerLayoutManager) parent) >= 2) {
            throw new JSApplicationIllegalArgumentException("The Drawer cannot have more than two children");
        }
        if (i2 != 0 && i2 != 1) {
            throw new JSApplicationIllegalArgumentException(b.g(i2, "The only valid indices for drawer's child are 0 or 1. Got ", " instead."));
        }
        parent.addView(child, i2);
        parent.u();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @Deprecated
    public void receiveCommand(@NotNull ReactDrawerLayout root, int i2, @Nullable ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(root, "root");
        if (i2 == 1) {
            int i3 = root.I;
            View viewE = root.e(i3);
            if (viewE == null) {
                throw new IllegalArgumentException("No drawer view found with gravity " + DrawerLayout.j(i3));
            }
            root.o(viewE);
            return;
        }
        if (i2 != 2) {
            return;
        }
        int i4 = root.I;
        View viewE2 = root.e(i4);
        if (viewE2 == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + DrawerLayout.j(i4));
        }
        root.c(viewE2, true);
    }

    @ReactProp(name = "drawerPosition")
    public final void setDrawerPosition(@NotNull ReactDrawerLayout view, @NotNull Dynamic drawerPosition) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(drawerPosition, "drawerPosition");
        if (drawerPosition.isNull()) {
            view.setDrawerPosition$ReactAndroid_release(8388611);
            return;
        }
        if (drawerPosition.getType() == ReadableType.Number) {
            int iAsInt = drawerPosition.asInt();
            if (8388611 != iAsInt && 8388613 != iAsInt) {
                FLog.q("ReactNative", "Unknown drawerPosition " + iAsInt);
                view.setDrawerPosition$ReactAndroid_release(8388611);
                return;
            }
            view.setDrawerPosition$ReactAndroid_release(iAsInt);
            return;
        }
        if (drawerPosition.getType() == ReadableType.String) {
            setDrawerPositionInternal(view, drawerPosition.asString());
        } else {
            FLog.q("ReactNative", "drawerPosition must be a string or int");
            view.setDrawerPosition$ReactAndroid_release(8388611);
        }
    }

    @Override // com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerInterface
    public void setDrawerWidth(@NotNull ReactDrawerLayout view, @Nullable Float f2) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setDrawerWidth$ReactAndroid_release(f2 != null ? Math.round(PixelUtil.b(f2.floatValue())) : -1);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(@NotNull ReactDrawerLayout root, @NotNull String commandId, @Nullable ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(commandId, "commandId");
        if (Intrinsics.b(commandId, COMMAND_OPEN_DRAWER)) {
            int i2 = root.I;
            View viewE = root.e(i2);
            if (viewE != null) {
                root.o(viewE);
                return;
            } else {
                throw new IllegalArgumentException("No drawer view found with gravity " + DrawerLayout.j(i2));
            }
        }
        if (Intrinsics.b(commandId, COMMAND_CLOSE_DRAWER)) {
            int i3 = root.I;
            View viewE2 = root.e(i3);
            if (viewE2 != null) {
                root.c(viewE2, true);
            } else {
                throw new IllegalArgumentException("No drawer view found with gravity " + DrawerLayout.j(i3));
            }
        }
    }
}
