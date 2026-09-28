package com.facebook.react.views.scroll;

import android.view.View;
import android.widget.OverScroller;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.RetryableMountingLayerException;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.LengthPercentage;
import com.facebook.react.uimanager.LengthPercentageType;
import com.facebook.react.uimanager.PixelUtil;
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
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import com.zeptoconsumerapp.BuildConfig;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

@ReactModule(name = ReactHorizontalScrollViewManager.REACT_CLASS)
@Nullsafe
/* loaded from: classes.dex */
public class ReactHorizontalScrollViewManager extends ViewGroupManager<ReactHorizontalScrollView> implements ReactScrollViewCommandHelper.ScrollCommandHandler<ReactHorizontalScrollView> {
    public static final String REACT_CLASS = "AndroidHorizontalScrollView";
    private static final int[] SPACING_TYPES = {8, 0, 2, 1, 3};

    @Nullable
    private FpsListener mFpsListener;

    public ReactHorizontalScrollViewManager() {
        this(null);
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
    public void setBorderColor(ReactHorizontalScrollView reactHorizontalScrollView, int i2, @Nullable Integer num) {
        BackgroundStyleApplicator.k(reactHorizontalScrollView, LogicalEdge.f19899b, num);
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {Snapshot.BORDER_RADIUS, Snapshot.BORDER_TOP_LEFT_RADIUS, Snapshot.BORDER_TOP_RIGHT_RADIUS, Snapshot.BORDER_BOTTOM_RIGHT_RADIUS, Snapshot.BORDER_BOTTOM_LEFT_RADIUS})
    public void setBorderRadius(ReactHorizontalScrollView reactHorizontalScrollView, int i2, float f2) {
        BackgroundStyleApplicator.l(reactHorizontalScrollView, BorderRadiusProp.values()[i2], Float.isNaN(f2) ? null : new LengthPercentage(f2, LengthPercentageType.f19394a));
    }

    @ReactProp(name = "borderStyle")
    public void setBorderStyle(ReactHorizontalScrollView reactHorizontalScrollView, @Nullable String str) {
        BackgroundStyleApplicator.m(reactHorizontalScrollView, str == null ? null : BorderStyle.a(str));
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth"})
    public void setBorderWidth(ReactHorizontalScrollView reactHorizontalScrollView, int i2, float f2) {
        BackgroundStyleApplicator.n(reactHorizontalScrollView, LogicalEdge.values()[i2], Float.valueOf(f2));
    }

    @ReactProp(customType = "Color", defaultInt = 0, name = "endFillColor")
    public void setBottomFillColor(ReactHorizontalScrollView reactHorizontalScrollView, int i2) {
        reactHorizontalScrollView.setEndFillColor(i2);
    }

    @ReactProp(name = "contentOffset")
    public void setContentOffset(ReactHorizontalScrollView reactHorizontalScrollView, ReadableMap readableMap) {
        if (readableMap != null) {
            reactHorizontalScrollView.scrollTo((int) PixelUtil.b((float) (readableMap.hasKey("x") ? readableMap.getDouble("x") : 0.0d)), (int) PixelUtil.b((float) (readableMap.hasKey("y") ? readableMap.getDouble("y") : 0.0d)));
        } else {
            reactHorizontalScrollView.scrollTo(0, 0);
        }
    }

    @ReactProp(name = "decelerationRate")
    public void setDecelerationRate(ReactHorizontalScrollView reactHorizontalScrollView, float f2) {
        reactHorizontalScrollView.setDecelerationRate(f2);
    }

    @ReactProp(name = "disableIntervalMomentum")
    public void setDisableIntervalMomentum(ReactHorizontalScrollView reactHorizontalScrollView, boolean z) {
        reactHorizontalScrollView.setDisableIntervalMomentum(z);
    }

    @ReactProp(name = "fadingEdgeLength")
    public void setFadingEdgeLength(ReactHorizontalScrollView reactHorizontalScrollView, int i2) {
        if (i2 > 0) {
            reactHorizontalScrollView.setHorizontalFadingEdgeEnabled(true);
            reactHorizontalScrollView.setFadingEdgeLength(i2);
        } else {
            reactHorizontalScrollView.setHorizontalFadingEdgeEnabled(false);
            reactHorizontalScrollView.setFadingEdgeLength(0);
        }
    }

    @ReactProp(name = "horizontal")
    public void setHorizontal(ReactHorizontalScrollView reactHorizontalScrollView, boolean z) {
    }

    @ReactProp(name = "maintainVisibleContentPosition")
    public void setMaintainVisibleContentPosition(ReactHorizontalScrollView reactHorizontalScrollView, ReadableMap readableMap) {
        if (readableMap != null) {
            reactHorizontalScrollView.setMaintainVisibleContentPosition(MaintainVisibleScrollPositionHelper.Config.a(readableMap));
        } else {
            reactHorizontalScrollView.setMaintainVisibleContentPosition(null);
        }
    }

    @ReactProp(name = "nestedScrollEnabled")
    public void setNestedScrollEnabled(ReactHorizontalScrollView reactHorizontalScrollView, boolean z) {
        ViewCompat.G(reactHorizontalScrollView, z);
    }

    @ReactProp(name = "overScrollMode")
    public void setOverScrollMode(ReactHorizontalScrollView reactHorizontalScrollView, @Nullable String str) {
        reactHorizontalScrollView.setOverScrollMode(ReactScrollViewHelper.g(str));
    }

    @ReactProp(name = "overflow")
    public void setOverflow(ReactHorizontalScrollView reactHorizontalScrollView, @Nullable String str) {
        reactHorizontalScrollView.setOverflow(str);
    }

    @ReactProp(name = "pagingEnabled")
    public void setPagingEnabled(ReactHorizontalScrollView reactHorizontalScrollView, boolean z) {
        reactHorizontalScrollView.setPagingEnabled(z);
    }

    @ReactProp(name = "persistentScrollbar")
    public void setPersistentScrollbar(ReactHorizontalScrollView reactHorizontalScrollView, boolean z) {
        reactHorizontalScrollView.setScrollbarFadingEnabled(!z);
    }

    @ReactProp(name = "pointerEvents")
    public void setPointerEvents(ReactHorizontalScrollView reactHorizontalScrollView, @Nullable String str) {
        PointerEvents.f19424a.getClass();
        reactHorizontalScrollView.setPointerEvents(PointerEvents.Companion.a(str));
    }

    @ReactProp(name = "removeClippedSubviews")
    public void setRemoveClippedSubviews(ReactHorizontalScrollView reactHorizontalScrollView, boolean z) {
        reactHorizontalScrollView.setRemoveClippedSubviews(z);
    }

    @ReactProp(defaultBoolean = BuildConfig.IS_HERMES_ENABLED, name = "scrollEnabled")
    public void setScrollEnabled(ReactHorizontalScrollView reactHorizontalScrollView, boolean z) {
        reactHorizontalScrollView.setScrollEnabled(z);
    }

    @ReactProp(name = "scrollEventThrottle")
    public void setScrollEventThrottle(ReactHorizontalScrollView reactHorizontalScrollView, int i2) {
        reactHorizontalScrollView.setScrollEventThrottle(i2);
    }

    @ReactProp(name = "scrollPerfTag")
    public void setScrollPerfTag(ReactHorizontalScrollView reactHorizontalScrollView, @Nullable String str) {
        reactHorizontalScrollView.setScrollPerfTag(str);
    }

    @ReactProp(name = "sendMomentumEvents")
    public void setSendMomentumEvents(ReactHorizontalScrollView reactHorizontalScrollView, boolean z) {
        reactHorizontalScrollView.setSendMomentumEvents(z);
    }

    @ReactProp(defaultBoolean = BuildConfig.IS_HERMES_ENABLED, name = "showsHorizontalScrollIndicator")
    public void setShowsHorizontalScrollIndicator(ReactHorizontalScrollView reactHorizontalScrollView, boolean z) {
        reactHorizontalScrollView.setHorizontalScrollBarEnabled(z);
    }

    @ReactProp(name = "snapToAlignment")
    public void setSnapToAlignment(ReactHorizontalScrollView reactHorizontalScrollView, @Nullable String str) {
        reactHorizontalScrollView.setSnapToAlignment(ReactScrollViewHelper.h(str));
    }

    @ReactProp(name = "snapToEnd")
    public void setSnapToEnd(ReactHorizontalScrollView reactHorizontalScrollView, boolean z) {
        reactHorizontalScrollView.setSnapToEnd(z);
    }

    @ReactProp(name = "snapToInterval")
    public void setSnapToInterval(ReactHorizontalScrollView reactHorizontalScrollView, float f2) {
        reactHorizontalScrollView.setSnapInterval((int) (f2 * DisplayMetricsHolder.d().density));
    }

    @ReactProp(name = "snapToOffsets")
    public void setSnapToOffsets(ReactHorizontalScrollView reactHorizontalScrollView, @Nullable ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() == 0) {
            reactHorizontalScrollView.setSnapOffsets(null);
            return;
        }
        float f2 = DisplayMetricsHolder.d().density;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            arrayList.add(Integer.valueOf((int) (readableArray.getDouble(i2) * f2)));
        }
        reactHorizontalScrollView.setSnapOffsets(arrayList);
    }

    @ReactProp(name = "snapToStart")
    public void setSnapToStart(ReactHorizontalScrollView reactHorizontalScrollView, boolean z) {
        reactHorizontalScrollView.setSnapToStart(z);
    }

    public ReactHorizontalScrollViewManager(@Nullable FpsListener fpsListener) {
        this.mFpsListener = fpsListener;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ReactHorizontalScrollView createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactHorizontalScrollView(themedReactContext, this.mFpsListener);
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewCommandHelper.ScrollCommandHandler
    public void flashScrollIndicators(ReactHorizontalScrollView reactHorizontalScrollView) {
        reactHorizontalScrollView.e();
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewCommandHelper.ScrollCommandHandler
    public void scrollTo(ReactHorizontalScrollView reactHorizontalScrollView, ReactScrollViewCommandHelper.ScrollToCommandData scrollToCommandData) {
        OverScroller overScroller = reactHorizontalScrollView.f20022c;
        if (overScroller != null && !overScroller.isFinished()) {
            overScroller.abortAnimation();
        }
        boolean z = scrollToCommandData.f20057c;
        int i2 = scrollToCommandData.f20056b;
        int i3 = scrollToCommandData.f20055a;
        if (z) {
            reactHorizontalScrollView.b(i3, i2);
        } else {
            reactHorizontalScrollView.scrollTo(i3, i2);
        }
    }

    @Override // com.facebook.react.views.scroll.ReactScrollViewCommandHelper.ScrollCommandHandler
    public void scrollToEnd(ReactHorizontalScrollView reactHorizontalScrollView, ReactScrollViewCommandHelper.ScrollToEndCommandData scrollToEndCommandData) {
        View childAt = reactHorizontalScrollView.getChildAt(0);
        if (childAt == null) {
            throw new RetryableMountingLayerException("scrollToEnd called on HorizontalScrollView without child");
        }
        int paddingRight = reactHorizontalScrollView.getPaddingRight() + childAt.getWidth();
        OverScroller overScroller = reactHorizontalScrollView.f20022c;
        if (overScroller != null && !overScroller.isFinished()) {
            overScroller.abortAnimation();
        }
        if (scrollToEndCommandData.f20058a) {
            reactHorizontalScrollView.b(paddingRight, reactHorizontalScrollView.getScrollY());
        } else {
            reactHorizontalScrollView.scrollTo(paddingRight, reactHorizontalScrollView.getScrollY());
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @Nullable
    public Object updateState(ReactHorizontalScrollView reactHorizontalScrollView, ReactStylesDiffMap reactStylesDiffMap, StateWrapper stateWrapper) {
        reactHorizontalScrollView.setStateWrapper(stateWrapper);
        return null;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(ReactHorizontalScrollView reactHorizontalScrollView, int i2, @Nullable ReadableArray readableArray) {
        ReactScrollViewCommandHelper.a(this, reactHorizontalScrollView, i2, readableArray);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(ReactHorizontalScrollView reactHorizontalScrollView, String str, @Nullable ReadableArray readableArray) {
        ReactScrollViewCommandHelper.b(this, reactHorizontalScrollView, str, readableArray);
    }
}
