package com.rnmaps.maps;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes.dex */
public class MapCalloutManager extends ViewGroupManager<MapCallout> {
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.c("onPress", MapBuilder.c("registrationName", "onPress"));
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "AIRMapCallout";
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
        super.removeAllViews(view);
    }

    @ReactProp(defaultBoolean = false, name = "tooltip")
    public void setTooltip(MapCallout mapCallout, boolean z) {
        mapCallout.setTooltip(z);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.ViewManager
    public LayoutShadowNode createShadowNodeInstance() {
        return new SizeReportingShadowNode();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public MapCallout createViewInstance(ThemedReactContext themedReactContext) {
        MapCallout mapCallout = new MapCallout(themedReactContext);
        mapCallout.f46482a = false;
        return mapCallout;
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void updateExtraData(MapCallout mapCallout, Object obj) {
        Map map = (Map) obj;
        float fFloatValue = ((Float) map.get(Snapshot.WIDTH)).floatValue();
        float fFloatValue2 = ((Float) map.get(Snapshot.HEIGHT)).floatValue();
        mapCallout.f46483b = (int) fFloatValue;
        mapCallout.f46484c = (int) fFloatValue2;
    }
}
