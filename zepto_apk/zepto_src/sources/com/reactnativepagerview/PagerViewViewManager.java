package com.reactnativepagerview;

import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.media3.common.util.e;
import androidx.viewpager2.widget.ViewPager2;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.reactnativepagerview.event.PageScrollEvent;
import com.reactnativepagerview.event.PageScrollStateChangedEvent;
import com.reactnativepagerview.event.PageSelectedEvent;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class PagerViewViewManager extends ViewGroupManager<NestedScrollableHost> {

    @NotNull
    private static final String COMMAND_SET_PAGE = "setPage";

    @NotNull
    private static final String COMMAND_SET_PAGE_WITHOUT_ANIMATION = "setPageWithoutAnimation";

    @NotNull
    private static final String COMMAND_SET_SCROLL_ENABLED = "setScrollEnabledImperatively";

    @NotNull
    public static final Companion Companion = new Companion();
    private EventDispatcher eventDispatcher;

    @Metadata
    public static final class Companion {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createViewInstance$lambda$0(ViewPager2 viewPager2, final PagerViewViewManager pagerViewViewManager, final NestedScrollableHost nestedScrollableHost) {
        viewPager2.b(new ViewPager2.OnPageChangeCallback() { // from class: com.reactnativepagerview.PagerViewViewManager$createViewInstance$1$1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public final void a(int i2) {
                String str;
                if (i2 == 0) {
                    str = "idle";
                } else if (i2 == 1) {
                    str = "dragging";
                } else {
                    if (i2 != 2) {
                        throw new IllegalStateException("Unsupported pageScrollState");
                    }
                    str = "settling";
                }
                EventDispatcher eventDispatcher = this.f46398a.eventDispatcher;
                if (eventDispatcher != null) {
                    eventDispatcher.g(new PageScrollStateChangedEvent(nestedScrollableHost.getId(), str));
                } else {
                    Intrinsics.h("eventDispatcher");
                    throw null;
                }
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public final void b(float f2, int i2, int i3) {
                EventDispatcher eventDispatcher = this.f46398a.eventDispatcher;
                if (eventDispatcher != null) {
                    eventDispatcher.g(new PageScrollEvent(f2, nestedScrollableHost.getId(), i2));
                } else {
                    Intrinsics.h("eventDispatcher");
                    throw null;
                }
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public final void c(int i2) {
                EventDispatcher eventDispatcher = this.f46398a.eventDispatcher;
                if (eventDispatcher != null) {
                    eventDispatcher.g(new PageSelectedEvent(nestedScrollableHost.getId(), i2));
                } else {
                    Intrinsics.h("eventDispatcher");
                    throw null;
                }
            }
        });
        EventDispatcher eventDispatcher = pagerViewViewManager.eventDispatcher;
        if (eventDispatcher != null) {
            eventDispatcher.g(new PageSelectedEvent(nestedScrollableHost.getId(), viewPager2.getCurrentItem()));
        } else {
            Intrinsics.h("eventDispatcher");
            throw null;
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @NotNull
    public Map<String, Map<String, String>> getExportedCustomDirectEventTypeConstants() {
        HashMap mapE = MapBuilder.e("topPageScroll", MapBuilder.c("registrationName", "onPageScroll"), "topPageScrollStateChanged", MapBuilder.c("registrationName", "onPageScrollStateChanged"), "topPageSelected", MapBuilder.c("registrationName", "onPageSelected"));
        Intrinsics.checkNotNullExpressionValue(mapE, "of(...)");
        return mapE;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return "RNCViewPager";
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewManagerWithChildren
    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    @ReactProp(defaultInt = -1, name = "offscreenPageLimit")
    public final void set(@NotNull NestedScrollableHost host, int i2) {
        Intrinsics.checkNotNullParameter(host, "host");
        PagerViewViewManagerImpl.k(host, i2);
    }

    @ReactProp(defaultInt = 0, name = "initialPage")
    public final void setInitialPage(@NotNull NestedScrollableHost host, int i2) {
        Intrinsics.checkNotNullParameter(host, "host");
        PagerViewViewManagerImpl.i(host, i2);
    }

    @ReactProp(name = "layoutDirection")
    public final void setLayoutDirection(@NotNull NestedScrollableHost host, @NotNull String value) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(value, "value");
        PagerViewViewManagerImpl.j(host, value);
    }

    @ReactProp(name = "orientation")
    public final void setOrientation(@NotNull NestedScrollableHost host, @NotNull String value) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(value, "value");
        PagerViewViewManagerImpl.l(host, value);
    }

    @ReactProp(name = "overScrollMode")
    public final void setOverScrollMode(@NotNull NestedScrollableHost host, @NotNull String value) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(value, "value");
        PagerViewViewManagerImpl.m(host, value);
    }

    @ReactProp(defaultInt = 0, name = "pageMargin")
    public final void setPageMargin(@NotNull NestedScrollableHost host, int i2) {
        Intrinsics.checkNotNullParameter(host, "host");
        PagerViewViewManagerImpl.n(host, i2);
    }

    @ReactProp(defaultBoolean = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED, name = "scrollEnabled")
    public final void setScrollEnabled(@NotNull NestedScrollableHost host, boolean z) {
        Intrinsics.checkNotNullParameter(host, "host");
        PagerViewViewManagerImpl.o(host, z);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public NestedScrollableHost createViewInstance(@NotNull ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "reactContext");
        Intrinsics.checkNotNullParameter(context, "context");
        NestedScrollableHost nestedScrollableHost = new NestedScrollableHost(context);
        nestedScrollableHost.f46394c = ViewConfiguration.get(nestedScrollableHost.getContext()).getScaledTouchSlop();
        nestedScrollableHost.setId(View.generateViewId());
        nestedScrollableHost.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        nestedScrollableHost.setSaveEnabled(false);
        ViewPager2 viewPager2 = new ViewPager2(context);
        viewPager2.setAdapter(new ViewPagerAdapter());
        viewPager2.setSaveEnabled(false);
        NativeModule nativeModule = context.f19479a.getNativeModule((Class<NativeModule>) UIManagerModule.class);
        Intrinsics.c(nativeModule);
        this.eventDispatcher = ((UIManagerModule) nativeModule).getEventDispatcher();
        viewPager2.post(new e(viewPager2, this, nestedScrollableHost, 15));
        nestedScrollableHost.addView(viewPager2);
        return nestedScrollableHost;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003e, code lost:
    
        if (r7.equals(com.reactnativepagerview.PagerViewViewManager.COMMAND_SET_PAGE) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0057, code lost:
    
        if (r7.equals(com.reactnativepagerview.PagerViewViewManager.COMMAND_SET_PAGE_WITHOUT_ANIMATION) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0059, code lost:
    
        r8 = r8.getInt(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005d, code lost:
    
        if (r0 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0063, code lost:
    
        if (r0.intValue() <= 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0065, code lost:
    
        if (r8 < 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006b, code lost:
    
        if (r8 >= r0.intValue()) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006d, code lost:
    
        com.reactnativepagerview.PagerViewViewManagerImpl.h(r6, r8, r7.equals(com.reactnativepagerview.PagerViewViewManager.COMMAND_SET_PAGE));
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:?, code lost:
    
        return;
     */
    @Override // com.facebook.react.uimanager.ViewManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void receiveCommand(@org.jetbrains.annotations.NotNull com.reactnativepagerview.NestedScrollableHost r6, @org.jetbrains.annotations.NotNull java.lang.String r7, @org.jetbrains.annotations.Nullable com.facebook.react.bridge.ReadableArray r8) {
        /*
            r5 = this;
            java.lang.String r0 = "root"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "commandId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            super.receiveCommand(r6, r7, r8)
            androidx.viewpager2.widget.ViewPager2 r6 = com.reactnativepagerview.PagerViewViewManagerImpl.d(r6)
            com.facebook.infer.annotation.Assertions.c(r8)
            androidx.recyclerview.widget.RecyclerView$Adapter r0 = r6.getAdapter()
            if (r0 == 0) goto L23
            int r0 = r0.d()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L24
        L23:
            r0 = 0
        L24:
            int r1 = r7.hashCode()
            r2 = -445763635(0xffffffffe56e2fcd, float:-7.030031E22)
            r3 = 0
            java.lang.String r4 = "setPage"
            if (r1 == r2) goto L51
            r2 = 1747675147(0x682b680b, float:3.2377757E24)
            if (r1 == r2) goto L41
            r2 = 1984860689(0x764e9211, float:1.0474372E33)
            if (r1 != r2) goto L75
            boolean r1 = r7.equals(r4)
            if (r1 == 0) goto L75
            goto L59
        L41:
            java.lang.String r0 = "setScrollEnabledImperatively"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L75
            boolean r7 = r8.getBoolean(r3)
            r6.setUserInputEnabled(r7)
            return
        L51:
            java.lang.String r1 = "setPageWithoutAnimation"
            boolean r1 = r7.equals(r1)
            if (r1 == 0) goto L75
        L59:
            int r8 = r8.getInt(r3)
            if (r0 == 0) goto L74
            int r1 = r0.intValue()
            if (r1 <= 0) goto L74
            if (r8 < 0) goto L74
            int r0 = r0.intValue()
            if (r8 >= r0) goto L74
            boolean r7 = r7.equals(r4)
            com.reactnativepagerview.PagerViewViewManagerImpl.h(r6, r8, r7)
        L74:
            return
        L75:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "PagerViewViewManager"
            java.lang.Object[] r7 = new java.lang.Object[]{r7, r8}
            r8 = 2
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r7, r8)
            java.lang.String r8 = "Unsupported command %d received by %s."
            java.lang.String r7 = java.lang.String.format(r8, r7)
            java.lang.String r8 = "format(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativepagerview.PagerViewViewManager.receiveCommand(com.reactnativepagerview.NestedScrollableHost, java.lang.String, com.facebook.react.bridge.ReadableArray):void");
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public void removeAllViews(@NotNull NestedScrollableHost parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        PagerViewViewManagerImpl.e(parent);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeView(@NotNull NestedScrollableHost parent, @NotNull View view) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(view, "view");
        PagerViewViewManagerImpl.f(parent, view);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(@NotNull NestedScrollableHost host, @NotNull View child, int i2) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(child, "child");
        PagerViewViewManagerImpl.a(host, child, i2);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    @NotNull
    public View getChildAt(@NotNull NestedScrollableHost parent, int i2) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return PagerViewViewManagerImpl.b(parent, i2);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public int getChildCount(@NotNull NestedScrollableHost parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return PagerViewViewManagerImpl.c(parent);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(@NotNull NestedScrollableHost parent, int i2) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        PagerViewViewManagerImpl.g(parent, i2);
    }
}
