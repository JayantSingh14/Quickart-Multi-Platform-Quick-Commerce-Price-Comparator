package com.rnmaps.maps;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes.dex */
public class MapOverlayManager extends ViewGroupManager<MapOverlay> {
    public MapOverlayManager(ReactApplicationContext reactApplicationContext) {
        ((WindowManager) reactApplicationContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(new DisplayMetrics());
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.c("onPress", MapBuilder.c("registrationName", "onPress"));
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "AIRMapOverlay";
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
        super.removeAllViews(view);
    }

    @ReactProp(name = "bearing")
    public void setBearing(MapOverlay mapOverlay, float f2) {
        mapOverlay.setBearing(f2);
    }

    @ReactProp(name = "bounds")
    public void setBounds(MapOverlay mapOverlay, ReadableArray readableArray) {
        mapOverlay.setBounds(readableArray);
    }

    @ReactProp(name = "image")
    public void setImage(MapOverlay mapOverlay, @Nullable String str) throws NumberFormatException {
        mapOverlay.setImage(str);
    }

    @ReactProp(defaultBoolean = false, name = "tappable")
    public void setTappable(MapOverlay mapOverlay, boolean z) {
        mapOverlay.setTappable(z);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public MapOverlay createViewInstance(ThemedReactContext themedReactContext) {
        return new MapOverlay(themedReactContext);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(defaultFloat = 1.0f, name = "opacity")
    public void setOpacity(MapOverlay mapOverlay, float f2) {
        mapOverlay.setTransparency(1.0f - f2);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    @ReactProp(defaultFloat = 1.0f, name = "zIndex")
    public void setZIndex(MapOverlay mapOverlay, float f2) {
        mapOverlay.setZIndex(f2);
    }
}
