package com.facebook.react.views.scroll;

import android.view.View;
import android.widget.OverScroller;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.RetryableMountingLayerException;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.LengthPercentageType;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.react.uimanager.style.BorderRadiusProp;
import com.facebook.react.uimanager.style.BorderStyle;
import com.facebook.react.uimanager.style.LogicalEdge;
import com.facebook.react.views.scroll.MaintainVisibleScrollPositionHelper;
import com.facebook.react.views.scroll.ReactScrollViewCommandHelper;
import com.facebook.react.views.scroll.ScrollEventType;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import com.zeptoconsumerapp.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import org.jetbrains.annotations.NotNull;

@ReactModule(name = ReactScrollViewManager.REACT_CLASS)
@Nullsafe
/* loaded from: classes.dex */
public class ReactScrollViewManager extends ViewGroupManager<ReactScrollView> implements ReactScrollViewCommandHelper.ScrollCommandHandler<ReactScrollView> {
    public static final String REACT_CLASS = "RCTScrollView";
    private static final int[] SPACING_TYPES = {8, 0, 2, 1, 3};

    @Nullable
    private FpsListener mFpsListener;

    public ReactScrollViewManager() {
        this(null);
    }

    public static Map<String, Object> createExportedCustomDirectEventTypeConstants() {
        MapBuilder.Builder builderA = MapBuilder.a();
        ScrollEventType scrollEventType = ScrollEventType.f20086d;
        ScrollEventType.f20083a.getClass();
        builderA.b(ScrollEventType.Companion.a(scrollEventType), MapBuilder.c("registrationName", "onScroll"));
        builderA.b(ScrollEventType.Companion.a(ScrollEventType.f20084b), MapBuilder.c("registrationName", "onScrollBeginDrag"));
        builderA.b(ScrollEventType.Companion.a(ScrollEventType.f20085c), MapBuilder.c("registrationName", "onScrollEndDrag"));
        builderA.b(ScrollEventType.Companion.a(ScrollEventType.f20087e), MapBuilder.c("registrationName", "onMomentumScrollBegin"));
        builderA.b(ScrollEventType.Companion.a(ScrollEventType.f20088f), MapBuilder.c("registrationName", "onMomentumScrollEnd"));
        return builderA.a();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Integer> getCommandsMap() {
        return MapsKt.e(new Pair("scrollTo", 1), new Pair("scrollToEnd", 2), new Pair("flashScrollIndicators", 3));
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new HashMap<>();
        }
        exportedCustomDirectEventTypeConstants.putAll(createExportedCustomDirectEventTypeConstants());
        return exportedCustomDirectEventTypeConstants;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
        super.removeAllViews(view);
    }

    @ReactPropGroup(customType = "Color", names = {"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor"})
    public void setBorderColor(ReactScrollView reactScrollView, int i2, @Nullable Integer num) {
        BackgroundStyleApplicator.k(reactScrollView, LogicalEdge.f19899b, num);
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {Snapshot.BORDER_RADIUS, Snapshot.BORDER_TOP_LEFT_RADIUS, Snapshot.BORDER_TOP_RIGHT_RADIUS, Snapshot.BORDER_BOTTOM_RIGHT_RADIUS, Snapshot.BORDER_BOTTOM_LEFT_RADIUS})
    public void setBorderRadius(ReactScrollView reactScrollView, int i2, float f2) {
        BackgroundStyleApplicator.l(reactScrollView, BorderRadiusProp.values()[i2], Float.isNaN(f2) ? null : new LengthPercentage(f2, LengthPercentageType.f19394a));
    }

    @ReactProp(name = "borderStyle")
    public void setBorderStyle(ReactScrollView reactScrollView, @Nullable String str) {
        BackgroundStyleApplicator.m(reactScrollView, str == null ? null : BorderStyle.a(str));
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth"})
    public void setBorderWidth(ReactScrollView reactScrollView, int i2, float f2) {
        BackgroundStyleApplicator.n(reactScrollView, LogicalEdge.values()[i2], Float.valueOf(f2));
    }

    @ReactProp(customType = "Color", defaultInt = 0, name = "endFillColor")
    public void setBottomFillColor(ReactScrollView reactScrollView, int i2) {
        reactScrollView.setEndFillColor(i2);
    }

    @ReactProp(customType = "Point", name = "contentOffset")
    public void setContentOffset(ReactScrollView reactScrollView, ReadableMap readableMap) {
        reactScrollView.setContentOffset(readableMap);
    }

    @ReactProp(name = "decelerationRate")
    public void setDecelerationRate(ReactScrollView reactScrollView, float f2) {
        reactScrollView.setDecelerationRate(f2);
    }

    @ReactProp(name = "disableIntervalMomentum")
    public void setDisableIntervalMomentum(ReactScrollView reactScrollView, boolean z) {
        reactScrollView.setDisableIntervalMomentum(z);
    }

    @ReactProp(name = "fadingEdgeLength")
    public void setFadingEdgeLength(ReactScrollView reactScrollView, int i2) {
        if (i2 > 0) {
            reactScrollView.setVerticalFadingEdgeEnabled(true);
            reactScrollView.setFadingEdgeLength(i2);
        } else {
            reactScrollView.setVerticalFadingEdgeEnabled(false);
            reactScrollView.setFadingEdgeLength(0);
        }
    }

    @ReactProp(name = "horizontal")
    public void setHorizontal(ReactScrollView reactScrollView, boolean z) {
    }

    @ReactProp(name = "isInvertedVirtualizedList")
    public void setIsInvertedVirtualizedList(ReactScrollView reactScrollView, boolean z) {
        if (z) {
            reactScrollView.setVerticalScrollbarPosition(1);
        } else {
            reactScrollView.setVerticalScrollbarPosition(0);
        }
    }

    @ReactProp(name = "maintainVisibleContentPosition")
    public void setMaintainVisibleContentPosition(ReactScrollView reactScrollView, ReadableMap readableMap) {
        if (readableMap != null) {
            reactScrollView.setMaintainVisibleContentPosition(MaintainVisibleScrollPositionHelper.Config.a(readableMap));
        } else {
            reactScrollView.setMaintainVisibleContentPosition(null);
        }
    }

    @ReactProp(name = "nestedScrollEnabled")
    public void setNestedScrollEnabled(ReactScrollView reactScrollView, boolean z) {
        ViewCompat.G(reactScrollView, z);
    }

    @ReactProp(name = "overScrollMode")
    public void setOverScrollMode(ReactScrollView reactScrollView, @Nullable String str) {
        reactScrollView.setOverScrollMode(ReactScrollViewHelper.g(str));
    }

    @ReactProp(name = "overflow")
    public void setOverflow(ReactScrollView reactScrollView, @Nullable String str) {
        reactScrollView.setOverflow(str);
    }

    @ReactProp(name = "pagingEnabled")
    public void setPagingEnabled(ReactScrollView reactScrollView, boolean z) {
        reactScrollView.setPagingEnabled(z);
    }

    @ReactProp(name = "persistentScrollbar")
    public void setPersistentScrollbar(ReactScrollView reactScrollView, boolean z) {
        reactScrollView.setScrollbarFadingEnabled(!z);
    }

    @ReactProp(name = "pointerEvents")
    public void setPointerEvents(ReactScrollView reactScrollView, @Nullable String str) {
        PointerEvents.f19424a.getClass();
        reactScrollView.setPointerEvents(PointerEvents.Companion.a(str));
    }

    @ReactProp(name = "removeClippedSubviews")
    public void setRemoveClippedSubviews(ReactScrollView reactScrollView, boolean z) {
        reactScrollView.setRemoveClippedSubviews(z);
    }

    @ReactProp(defaultBoolean = BuildConfig.IS_HERMES_ENABLED, name = "scrollEnabled")
    public void setScrollEnabled(ReactScrollView reactScrollView, boolean z) {
        reactScrollView.setScrollEnabled(z);
        reactScrollView.setFocusable(z);
    }

    @ReactProp(name = "scrollEventThrottle")
    public void setScrollEventThrottle(ReactScrollView reactScrollView, int i2) {
        reactScrollView.setScrollEventThrottle(i2);
    }

    @ReactProp(name = "scrollPerfTag")
    public void setScrollPerfTag(ReactScrollView reactScrollView, @Nullable String str) {
        reactScrollView.setScrollPerfTag(str);
    }

    @ReactProp(name = "sendMomentumEvents")
    public void setSendMomentumEvents(ReactScrollView reactScrollView, boolean z) {
        reactScrollView.setSendMomentumEvents(z);
    }

    @ReactProp(defaultBoolean = BuildConfig.IS_HERMES_ENABLED, name = "showsVerticalScrollIndicator")
    public void setShowsVerticalScrollIndicator(ReactScrollView reactScrollView, boolean z) {
        reactScrollView.setVerticalScrollBarEnabled(z);
    }

    @ReactProp(name = "snapToAlignment")
    public void setSnapToAlignment(ReactScrollView reactScrollView, @Nullable String str) {
        reactScrollView.setSnapToAlignment(ReactScrollViewHelper.h(str));
    }

    @ReactProp(name = "snapToEnd")
    public void setSnapToEnd(ReactScrollView reactScrollView, boolean z) {
        reactScrollView.setSnapToEnd(z);
    }

    @ReactProp(name = "snapToInterval")
    public void setSnapToInterval(ReactScrollView reactScrollView, float f2) {
        reactScrollView.setSnapInterval((int) (f2 * DisplayMetricsHolder.d().density));
    }

    @ReactProp(name = "snapToOffsets")
    public void setSnapToOffsets(ReactScrollView reactScrollView, @Nullable ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() == 0) {
            reactScrollView.setSnapOffsets(null);
            return;
        }
        float f2 = DisplayMetricsHolder.d().density;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            arrayList.add(Integer.valueOf((int) (readableArray.getDouble(i2) * f2)));
        }
        reactScrollView.setSnapOffsets(arrayList);
    }

    @ReactProp(name = "snapToStart")
    public void setSnapToStart(ReactScrollView reactScrollView, boolean z) {
        reactScrollView.setSnapToStart(z);
    }

    public ReactScrollViewManager(@Nullable FpsListener fpsListener) {
        this.mFpsListener = fpsListener;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ReactScrollView createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactScrollView(themedReactContext, this.mFpsListener);
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewCommandHelper.ScrollCommandHandler
    public void flashScrollIndicators(ReactScrollView reactScrollView) {
        reactScrollView.d();
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewCommandHelper.ScrollCommandHandler
    public void scrollTo(ReactScrollView reactScrollView, ReactScrollViewCommandHelper.ScrollToCommandData scrollToCommandData) {
        OverScroller overScroller = reactScrollView.f20038b;
        if (overScroller != null && !overScroller.isFinished()) {
            overScroller.abortAnimation();
        }
        boolean z = scrollToCommandData.f20057c;
        int i2 = scrollToCommandData.f20056b;
        int i3 = scrollToCommandData.f20055a;
        if (z) {
            reactScrollView.b(i3, i2);
        } else {
            reactScrollView.scrollTo(i3, i2);
        }
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewCommandHelper.ScrollCommandHandler
    public void scrollToEnd(ReactScrollView reactScrollView, ReactScrollViewCommandHelper.ScrollToEndCommandData scrollToEndCommandData) {
        View childAt = reactScrollView.getChildAt(0);
        if (childAt == null) {
            throw new RetryableMountingLayerException("scrollToEnd called on ScrollView without child");
        }
        int paddingBottom = reactScrollView.getPaddingBottom() + childAt.getHeight();
        OverScroller overScroller = reactScrollView.f20038b;
        if (overScroller != null && !overScroller.isFinished()) {
            overScroller.abortAnimation();
        }
        if (scrollToEndCommandData.f20058a) {
            reactScrollView.b(reactScrollView.getScrollX(), paddingBottom);
        } else {
            reactScrollView.scrollTo(reactScrollView.getScrollX(), paddingBottom);
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @Nullable
    public Object updateState(ReactScrollView reactScrollView, ReactStylesDiffMap reactStylesDiffMap, StateWrapper stateWrapper) {
        reactScrollView.setStateWrapper(stateWrapper);
        return null;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(ReactScrollView reactScrollView, int i2, @Nullable ReadableArray readableArray) {
        ReactScrollViewCommandHelper.a(this, reactScrollView, i2, readableArray);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(ReactScrollView reactScrollView, String str, @Nullable ReadableArray readableArray) {
        ReactScrollViewCommandHelper.b(this, reactScrollView, str, readableArray);
    }
}
