package com.facebook.react.uimanager;

import android.widget.ImageView;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.events.TouchEventType;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

@Nullsafe
/* loaded from: classes.dex */
class UIManagerModuleConstants {
    public static HashMap a() {
        MapBuilder.Builder builderA = MapBuilder.a();
        builderA.b("topChange", MapBuilder.c("phasedRegistrationNames", MapBuilder.d("bubbled", "onChange", "captured", "onChangeCapture")));
        builderA.b("topSelect", MapBuilder.c("phasedRegistrationNames", MapBuilder.d("bubbled", "onSelect", "captured", "onSelectCapture")));
        TouchEventType type = TouchEventType.f19779c;
        TouchEventType.f19778b.getClass();
        Intrinsics.checkNotNullParameter(type, "type");
        builderA.b("topTouchStart", MapBuilder.c("phasedRegistrationNames", MapBuilder.d("bubbled", "onTouchStart", "captured", "onTouchStartCapture")));
        TouchEventType type2 = TouchEventType.f19781e;
        Intrinsics.checkNotNullParameter(type2, "type");
        builderA.b("topTouchMove", MapBuilder.c("phasedRegistrationNames", MapBuilder.d("bubbled", "onTouchMove", "captured", "onTouchMoveCapture")));
        TouchEventType type3 = TouchEventType.f19780d;
        Intrinsics.checkNotNullParameter(type3, "type");
        builderA.b("topTouchEnd", MapBuilder.c("phasedRegistrationNames", MapBuilder.d("bubbled", "onTouchEnd", "captured", "onTouchEndCapture")));
        TouchEventType type4 = TouchEventType.f19782f;
        Intrinsics.checkNotNullParameter(type4, "type");
        builderA.b("topTouchCancel", MapBuilder.c("phasedRegistrationNames", MapBuilder.d("bubbled", "onTouchCancel", "captured", "onTouchCancelCapture")));
        return builderA.a();
    }

    public static HashMap b() {
        HashMap map = new HashMap();
        map.put("UIView", MapBuilder.c("ContentMode", MapBuilder.e("ScaleAspectFit", Integer.valueOf(ImageView.ScaleType.FIT_CENTER.ordinal()), "ScaleAspectFill", Integer.valueOf(ImageView.ScaleType.CENTER_CROP.ordinal()), "ScaleAspectCenter", Integer.valueOf(ImageView.ScaleType.CENTER_INSIDE.ordinal()))));
        PointerEvents.Companion companion = PointerEvents.f19424a;
        map.put("StyleConstants", MapBuilder.c("PointerEventsValues", MapBuilder.b("none", 0, "boxNone", 1, "boxOnly", 2, "unspecified", 3)));
        map.put("AccessibilityEventTypes", MapBuilder.e("typeWindowStateChanged", 32, "typeViewFocused", 8, "typeViewClicked", 1));
        return map;
    }

    public static HashMap c() {
        MapBuilder.Builder builderA = MapBuilder.a();
        builderA.b("topContentSizeChange", MapBuilder.c("registrationName", "onContentSizeChange"));
        builderA.b("topLayout", MapBuilder.c("registrationName", "onLayout"));
        builderA.b("topLoadingError", MapBuilder.c("registrationName", "onLoadingError"));
        builderA.b("topLoadingFinish", MapBuilder.c("registrationName", "onLoadingFinish"));
        builderA.b("topLoadingStart", MapBuilder.c("registrationName", "onLoadingStart"));
        builderA.b("topSelectionChange", MapBuilder.c("registrationName", "onSelectionChange"));
        builderA.b("topMessage", MapBuilder.c("registrationName", "onMessage"));
        builderA.b("topScrollBeginDrag", MapBuilder.c("registrationName", "onScrollBeginDrag"));
        builderA.b("topScrollEndDrag", MapBuilder.c("registrationName", "onScrollEndDrag"));
        builderA.b("topScroll", MapBuilder.c("registrationName", "onScroll"));
        builderA.b("topMomentumScrollBegin", MapBuilder.c("registrationName", "onMomentumScrollBegin"));
        builderA.b("topMomentumScrollEnd", MapBuilder.c("registrationName", "onMomentumScrollEnd"));
        return builderA.a();
    }
}
