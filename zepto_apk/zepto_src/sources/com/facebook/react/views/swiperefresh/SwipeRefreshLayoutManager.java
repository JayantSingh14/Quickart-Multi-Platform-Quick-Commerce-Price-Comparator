package com.facebook.react.views.swiperefresh;

import android.view.View;
import androidx.media3.exoplayer.analytics.d;
import com.BV.LinearGradient.LinearGradientManager;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerDelegate;
import com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface;
import com.zeptoconsumerapp.BuildConfig;
import in.juspay.hypersdk.analytics.LogConstants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ReactModule(name = SwipeRefreshLayoutManager.REACT_CLASS)
@Metadata
/* loaded from: classes.dex */
public class SwipeRefreshLayoutManager extends ViewGroupManager<ReactSwipeRefreshLayout> implements AndroidSwipeRefreshLayoutManagerInterface<ReactSwipeRefreshLayout> {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String REACT_CLASS = "AndroidSwipeRefreshLayout";

    @NotNull
    private final ViewManagerDelegate<ReactSwipeRefreshLayout> delegate = new AndroidSwipeRefreshLayoutManagerDelegate(this);

    @Metadata
    public static final class Companion {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addEventEmitters$lambda$0(ThemedReactContext themedReactContext, ReactSwipeRefreshLayout reactSwipeRefreshLayout) {
        EventDispatcher eventDispatcherB = UIManagerHelper.b(themedReactContext, reactSwipeRefreshLayout.getId());
        if (eventDispatcherB != null) {
            eventDispatcherB.g(new RefreshEvent(UIManagerHelper.e(reactSwipeRefreshLayout), reactSwipeRefreshLayout.getId()));
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public ViewManagerDelegate<ReactSwipeRefreshLayout> getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @NotNull
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new HashMap<>();
        }
        exportedCustomDirectEventTypeConstants.putAll(MapsKt.i(new Pair("topRefresh", MapsKt.i(new Pair("registrationName", "onRefresh")))));
        return exportedCustomDirectEventTypeConstants;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public Map<String, Object> getExportedViewConstants() {
        return MapsKt.i(new Pair("SIZE", MapsKt.i(new Pair("DEFAULT", 1), new Pair("LARGE", 0))));
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
        super.removeAllViews(view);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(@NotNull ThemedReactContext reactContext, @NotNull ReactSwipeRefreshLayout view) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(view, "view");
        view.setOnRefreshListener(new d(11, reactContext, view));
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public ReactSwipeRefreshLayout createViewInstance(@NotNull ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new ReactSwipeRefreshLayout(reactContext);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(@NotNull ReactSwipeRefreshLayout root, @NotNull String commandId, @Nullable ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(commandId, "commandId");
        if (!Intrinsics.b(commandId, "setNativeRefreshing") || readableArray == null) {
            return;
        }
        setRefreshing(root, readableArray.getBoolean(0));
    }

    @Override // com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface
    @ReactProp(customType = "ColorArray", name = LinearGradientManager.PROP_COLORS)
    public void setColors(@NotNull ReactSwipeRefreshLayout view, @Nullable ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (readableArray == null) {
            view.setColorSchemeColors(new int[0]);
            return;
        }
        int size = readableArray.size();
        int[] iArr = new int[size];
        int size2 = readableArray.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (readableArray.getType(i2) == ReadableType.Map) {
                Integer color = ColorPropConverter.getColor(readableArray.getMap(i2), view.getContext());
                Intrinsics.checkNotNullExpressionValue(color, "getColor(...)");
                iArr[i2] = color.intValue();
            } else {
                iArr[i2] = readableArray.getInt(i2);
            }
        }
        view.setColorSchemeColors(Arrays.copyOf(iArr, size));
    }

    @Override // com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface
    @ReactProp(defaultBoolean = BuildConfig.IS_HERMES_ENABLED, name = "enabled")
    public void setEnabled(@NotNull ReactSwipeRefreshLayout view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setEnabled(z);
    }

    @Override // com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface
    public void setNativeRefreshing(@NotNull ReactSwipeRefreshLayout view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        setRefreshing(view, z);
    }

    @Override // com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface
    @ReactProp(customType = "Color", name = "progressBackgroundColor")
    public void setProgressBackgroundColor(@NotNull ReactSwipeRefreshLayout view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setProgressBackgroundColorSchemeColor(num != null ? num.intValue() : 0);
    }

    @Override // com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface
    @ReactProp(defaultFloat = 0.0f, name = "progressViewOffset")
    public void setProgressViewOffset(@NotNull ReactSwipeRefreshLayout view, float f2) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setProgressViewOffset(f2);
    }

    @Override // com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface
    @ReactProp(name = "refreshing")
    public void setRefreshing(@NotNull ReactSwipeRefreshLayout view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setRefreshing(z);
    }

    public final void setSize(@NotNull ReactSwipeRefreshLayout view, int i2) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setSize(i2);
    }

    @Override // com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface
    public void setSize(@NotNull ReactSwipeRefreshLayout view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (str != null && !str.equals(LogConstants.DEFAULT_CHANNEL)) {
            if (str.equals("large")) {
                view.setSize(0);
                return;
            }
            throw new IllegalArgumentException("Size must be 'default' or 'large', received: ".concat(str));
        }
        view.setSize(1);
    }

    @ReactProp(name = "size")
    public final void setSize(@NotNull ReactSwipeRefreshLayout view, @NotNull Dynamic size) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(size, "size");
        if (size.isNull()) {
            view.setSize(1);
        } else if (size.getType() == ReadableType.Number) {
            view.setSize(size.asInt());
        } else {
            if (size.getType() != ReadableType.String) {
                throw new IllegalArgumentException("Size must be 'default' or 'large'");
            }
            setSize(view, size.asString());
        }
    }
}
