package com.facebook.react.views.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.BackgroundStyleApplicator;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.style.BackgroundImageLayer;
import com.facebook.react.uimanager.style.BorderStyle;
import com.facebook.react.uimanager.style.LogicalEdge;
import java.util.ArrayList;
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
@ReactModule(name = ReactViewManager.REACT_CLASS)
@SourceDebugExtension
/* loaded from: classes.dex */
public class ReactViewManager extends ReactClippingViewManager<ReactViewGroup> {
    private static final int CMD_HOTSPOT_UPDATE = 1;
    private static final int CMD_SET_PRESSED = 2;

    @NotNull
    private static final String HOTSPOT_UPDATE_KEY = "hotspotUpdate";

    @NotNull
    public static final String REACT_CLASS = "RCTView";

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    private static final int[] SPACING_TYPES = {8, 0, 2, 1, 3, 4, 5, 9, 10, 11};

    @Metadata
    public static final class Companion {
    }

    @Metadata
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20241a;

        static {
            int[] iArr = new int[ReadableType.values().length];
            try {
                iArr[ReadableType.Map.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReadableType.Number.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ReadableType.Null.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f20241a = iArr;
        }
    }

    public ReactViewManager() {
        setupViewRecycling();
    }

    private final void handleHotspotUpdate(ReactViewGroup reactViewGroup, ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() != 2) {
            throw new JSApplicationIllegalArgumentException("Illegal number of arguments for 'updateHotspot' command");
        }
        reactViewGroup.drawableHotspotChanged(PixelUtil.b((float) readableArray.getDouble(0)), PixelUtil.b((float) readableArray.getDouble(1)));
    }

    private final void handleSetPressed(ReactViewGroup reactViewGroup, ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() != 1) {
            throw new JSApplicationIllegalArgumentException("Illegal number of arguments for 'setPressed' command");
        }
        reactViewGroup.setPressed(readableArray.getBoolean(0));
    }

    private final int px(ReadableMap readableMap, String str) {
        if (readableMap.hasKey(str)) {
            return (int) PixelUtil.b((float) readableMap.getDouble(str));
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setFocusable$lambda$2(ReactViewGroup reactViewGroup, View view) {
        Context context = reactViewGroup.getContext();
        Intrinsics.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        EventDispatcher eventDispatcherB = UIManagerHelper.b((ReactContext) context, reactViewGroup.getId());
        if (eventDispatcherB != null) {
            eventDispatcherB.g(new ViewGroupClickEvent(UIManagerHelper.d(reactViewGroup.getContext()), reactViewGroup.getId()));
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public Map<String, Integer> getCommandsMap() {
        return MapsKt.i(new Pair(HOTSPOT_UPDATE_KEY, 1), new Pair("setPressed", 2));
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return REACT_CLASS;
    }

    @ReactProp(defaultInt = -1, name = "nextFocusDown")
    public void nextFocusDown(@NotNull ReactViewGroup view, int i2) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNextFocusDownId(i2);
    }

    @ReactProp(defaultInt = -1, name = "nextFocusForward")
    public void nextFocusForward(@NotNull ReactViewGroup view, int i2) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNextFocusForwardId(i2);
    }

    @ReactProp(defaultInt = -1, name = "nextFocusLeft")
    public void nextFocusLeft(@NotNull ReactViewGroup view, int i2) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNextFocusLeftId(i2);
    }

    @ReactProp(defaultInt = -1, name = "nextFocusRight")
    public void nextFocusRight(@NotNull ReactViewGroup view, int i2) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNextFocusRightId(i2);
    }

    @ReactProp(defaultInt = -1, name = "nextFocusUp")
    public void nextFocusUp(@NotNull ReactViewGroup view, int i2) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNextFocusUpId(i2);
    }

    @ReactProp(name = "accessible")
    public void setAccessible(@NotNull ReactViewGroup view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setFocusable(z);
    }

    @ReactProp(name = "backfaceVisibility")
    public void setBackfaceVisibility(@NotNull ReactViewGroup view, @NotNull String backfaceVisibility) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(backfaceVisibility, "backfaceVisibility");
        view.setBackfaceVisibility(backfaceVisibility);
    }

    @ReactProp(customType = "BackgroundImage", name = "experimental_backgroundImage")
    public void setBackgroundImage(@NotNull ReactViewGroup view, @Nullable ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (ViewUtil.b(view) == 2) {
            if (readableArray == null || readableArray.size() <= 0) {
                BackgroundStyleApplicator.j(view, null);
                return;
            }
            ArrayList arrayList = new ArrayList(readableArray.size());
            int size = readableArray.size();
            for (int i2 = 0; i2 < size; i2++) {
                ReadableMap map = readableArray.getMap(i2);
                Context context = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                arrayList.add(new BackgroundImageLayer(context, map));
            }
            BackgroundStyleApplicator.j(view, arrayList);
        }
    }

    @ReactPropGroup(customType = "Color", names = {"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor", "borderStartColor", "borderEndColor", "borderBlockColor", "borderBlockEndColor", "borderBlockStartColor"})
    public void setBorderColor(@NotNull ReactViewGroup view, int i2, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        LogicalEdge.Companion companion = LogicalEdge.f19898a;
        int i3 = SPACING_TYPES[i2];
        companion.getClass();
        BackgroundStyleApplicator.k(view, LogicalEdge.Companion.a(i3), num);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x009d  */
    @com.facebook.react.uimanager.annotations.ReactPropGroup(names = {com.swmansion.reanimated.layoutReanimation.Snapshot.BORDER_RADIUS, com.swmansion.reanimated.layoutReanimation.Snapshot.BORDER_TOP_LEFT_RADIUS, com.swmansion.reanimated.layoutReanimation.Snapshot.BORDER_TOP_RIGHT_RADIUS, com.swmansion.reanimated.layoutReanimation.Snapshot.BORDER_BOTTOM_RIGHT_RADIUS, com.swmansion.reanimated.layoutReanimation.Snapshot.BORDER_BOTTOM_LEFT_RADIUS, "borderTopStartRadius", "borderTopEndRadius", "borderBottomStartRadius", "borderBottomEndRadius", "borderEndEndRadius", "borderEndStartRadius", "borderStartEndRadius", "borderStartStartRadius"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setBorderRadius(@org.jetbrains.annotations.NotNull com.facebook.react.views.view.ReactViewGroup r8, int r9, @org.jetbrains.annotations.NotNull com.facebook.react.bridge.Dynamic r10) {
        /*
            r7 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "rawBorderRadius"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "dynamic"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            com.facebook.react.bridge.ReadableType r0 = r10.getType()
            int[] r1 = com.facebook.react.uimanager.LengthPercentage.Companion.WhenMappings.f19393a
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 2
            r2 = 0
            r3 = 1
            if (r0 == r3) goto L7b
            java.lang.String r4 = "ReactNative"
            if (r0 == r1) goto L3b
            com.facebook.react.bridge.ReadableType r10 = r10.getType()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "Unsupported type for radius property: "
            r0.<init>(r3)
            r0.append(r10)
            java.lang.String r10 = r0.toString()
            com.facebook.common.logging.FLog.q(r4, r10)
        L39:
            r3 = r2
            goto L8e
        L3b:
            java.lang.String r10 = r10.asString()
            java.lang.String r0 = "%"
            r5 = 0
            boolean r0 = kotlin.text.StringsKt.r(r10, r0, r5)
            if (r0 == 0) goto L71
            int r0 = r10.length()     // Catch: java.lang.NumberFormatException -> L67
            int r0 = r0 - r3
            java.lang.String r0 = r10.substring(r5, r0)     // Catch: java.lang.NumberFormatException -> L67
            java.lang.String r3 = "substring(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)     // Catch: java.lang.NumberFormatException -> L67
            float r0 = java.lang.Float.parseFloat(r0)     // Catch: java.lang.NumberFormatException -> L67
            r3 = 0
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 < 0) goto L39
            com.facebook.react.uimanager.LengthPercentage r3 = new com.facebook.react.uimanager.LengthPercentage     // Catch: java.lang.NumberFormatException -> L67
            com.facebook.react.uimanager.LengthPercentageType r5 = com.facebook.react.uimanager.LengthPercentageType.f19395b     // Catch: java.lang.NumberFormatException -> L67
            r3.<init>(r0, r5)     // Catch: java.lang.NumberFormatException -> L67
            goto L8e
        L67:
            java.lang.String r0 = "Invalid percentage format: "
            java.lang.String r10 = r0.concat(r10)
            com.facebook.common.logging.FLog.q(r4, r10)
            goto L39
        L71:
            java.lang.String r0 = "Invalid string value: "
            java.lang.String r10 = r0.concat(r10)
            com.facebook.common.logging.FLog.q(r4, r10)
            goto L39
        L7b:
            double r3 = r10.asDouble()
            r5 = 0
            int r10 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r10 < 0) goto L39
            com.facebook.react.uimanager.LengthPercentage r10 = new com.facebook.react.uimanager.LengthPercentage
            float r0 = (float) r3
            com.facebook.react.uimanager.LengthPercentageType r3 = com.facebook.react.uimanager.LengthPercentageType.f19394a
            r10.<init>(r0, r3)
            r3 = r10
        L8e:
            int r10 = com.facebook.react.uimanager.common.ViewUtil.b(r8)
            if (r10 == r1) goto L9d
            if (r3 == 0) goto L9d
            com.facebook.react.uimanager.LengthPercentageType r10 = com.facebook.react.uimanager.LengthPercentageType.f19395b
            com.facebook.react.uimanager.LengthPercentageType r0 = r3.f19392b
            if (r0 != r10) goto L9d
            goto L9e
        L9d:
            r2 = r3
        L9e:
            com.facebook.react.uimanager.style.BorderRadiusProp[] r10 = com.facebook.react.uimanager.style.BorderRadiusProp.values()
            r9 = r10[r9]
            com.facebook.react.uimanager.BackgroundStyleApplicator.l(r8, r9, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.view.ReactViewManager.setBorderRadius(com.facebook.react.views.view.ReactViewGroup, int, com.facebook.react.bridge.Dynamic):void");
    }

    @ReactProp(name = "borderStyle")
    public void setBorderStyle(@NotNull ReactViewGroup view, @Nullable String str) {
        BorderStyle borderStyleA;
        Intrinsics.checkNotNullParameter(view, "view");
        if (str == null) {
            borderStyleA = null;
        } else {
            BorderStyle.f19856a.getClass();
            borderStyleA = BorderStyle.Companion.a(str);
        }
        BackgroundStyleApplicator.m(view, borderStyleA);
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth", "borderStartWidth", "borderEndWidth"})
    public void setBorderWidth(@NotNull ReactViewGroup view, int i2, float f2) {
        Intrinsics.checkNotNullParameter(view, "view");
        BackgroundStyleApplicator.n(view, LogicalEdge.values()[i2], Float.valueOf(f2));
    }

    @ReactProp(name = "collapsable")
    public void setCollapsable(@NotNull ReactViewGroup view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @ReactProp(name = "collapsableChildren")
    public void setCollapsableChildren(@NotNull ReactViewGroup view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @ReactProp(name = "focusable")
    public void setFocusable(@NotNull final ReactViewGroup view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (z) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.react.views.view.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ReactViewManager.setFocusable$lambda$2(view, view2);
                }
            });
            view.setFocusable(true);
        } else {
            view.setOnClickListener(null);
            view.setClickable(false);
        }
    }

    @ReactProp(name = "hitSlop")
    public void setHitSlop(@NotNull ReactViewGroup view, @NotNull Dynamic hitSlop) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(hitSlop, "hitSlop");
        int i2 = WhenMappings.f20241a[hitSlop.getType().ordinal()];
        if (i2 == 1) {
            ReadableMap readableMapAsMap = hitSlop.asMap();
            view.setHitSlopRect(new Rect(px(readableMapAsMap, "left"), px(readableMapAsMap, "top"), px(readableMapAsMap, "right"), px(readableMapAsMap, "bottom")));
            return;
        }
        if (i2 == 2) {
            int iB = (int) PixelUtil.b((float) hitSlop.asDouble());
            view.setHitSlopRect(new Rect(iB, iB, iB, iB));
        } else {
            if (i2 == 3) {
                view.setHitSlopRect(null);
                return;
            }
            FLog.q("ReactNative", "Invalid type for 'hitSlop' value " + hitSlop.getType());
            view.setHitSlopRect(null);
        }
    }

    @ReactProp(name = "nativeBackgroundAndroid")
    public void setNativeBackground(@NotNull ReactViewGroup view, @Nullable ReadableMap readableMap) {
        Drawable drawableA;
        Intrinsics.checkNotNullParameter(view, "view");
        if (readableMap != null) {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            drawableA = ReactDrawableHelper.a(context, readableMap);
        } else {
            drawableA = null;
        }
        BackgroundStyleApplicator.p(view, drawableA);
    }

    @ReactProp(name = "nativeForegroundAndroid")
    public void setNativeForeground(@NotNull ReactViewGroup view, @Nullable ReadableMap readableMap) {
        Drawable drawableA;
        Intrinsics.checkNotNullParameter(view, "view");
        if (readableMap != null) {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            drawableA = ReactDrawableHelper.a(context, readableMap);
        } else {
            drawableA = null;
        }
        view.setForeground(drawableA);
    }

    @ReactProp(name = "needsOffscreenAlphaCompositing")
    public void setNeedsOffscreenAlphaCompositing(@NotNull ReactViewGroup view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setNeedsOffscreenAlphaCompositing(z);
    }

    @ReactProp(name = "overflow")
    public void setOverflow(@NotNull ReactViewGroup view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setOverflow(str);
    }

    @ReactProp(name = "pointerEvents")
    public void setPointerEvents(@NotNull ReactViewGroup view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        PointerEvents.f19424a.getClass();
        view.setPointerEvents(PointerEvents.Companion.a(str));
    }

    @ReactProp(name = "hasTVPreferredFocus")
    public void setTVPreferredFocus(@NotNull ReactViewGroup view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (z) {
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.requestFocus();
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public ReactViewGroup createViewInstance(@NotNull ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ReactViewGroup(context);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @NotNull
    public ReactViewGroup prepareToRecycleView(@NotNull ThemedReactContext reactContext, @NotNull ReactViewGroup view) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(view, "view");
        ReactViewGroup reactViewGroup = (ReactViewGroup) super.prepareToRecycleView(reactContext, (ThemedReactContext) view);
        if (reactViewGroup != null) {
            reactViewGroup.recycleView();
        }
        return view;
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    public void setOpacity(@NotNull ReactViewGroup view, float f2) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setOpacityIfPossible(f2);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager
    public void setTransformProperty(@NotNull ReactViewGroup view, @Nullable ReadableArray readableArray, @Nullable ReadableArray readableArray2) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.setTransformProperty((ReactViewManager) view, readableArray, readableArray2);
        view.setBackfaceVisibilityDependantOpacity();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @Deprecated
    public void receiveCommand(@NotNull ReactViewGroup root, int i2, @Nullable ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(root, "root");
        if (i2 == 1) {
            handleHotspotUpdate(root, readableArray);
        } else {
            if (i2 != 2) {
                return;
            }
            handleSetPressed(root, readableArray);
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(@NotNull ReactViewGroup root, @NotNull String commandId, @Nullable ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(commandId, "commandId");
        if (Intrinsics.b(commandId, HOTSPOT_UPDATE_KEY)) {
            handleHotspotUpdate(root, readableArray);
        } else if (Intrinsics.b(commandId, "setPressed")) {
            handleSetPressed(root, readableArray);
        }
    }

    @Deprecated
    public void setBorderRadius(@NotNull ReactViewGroup view, int i2, float f2) {
        Intrinsics.checkNotNullParameter(view, "view");
        setBorderRadius(view, i2, new DynamicFromObject(Float.valueOf(f2)));
    }
}
