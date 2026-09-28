package com.facebook.react.uimanager;

import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.facebook.common.logging.FLog;
import com.facebook.react.R;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.MatrixMathHelper;
import com.facebook.react.uimanager.ReactAccessibilityDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.uimanager.drawable.OutlineDrawable;
import com.facebook.react.uimanager.events.PointerEventHelper;
import com.facebook.react.uimanager.style.BoxShadow;
import com.facebook.react.uimanager.style.OutlineStyle;
import com.facebook.react.uimanager.util.ReactFindViewUtil;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class BaseViewManager<T extends View, C extends LayoutShadowNode> extends ViewManager<T, C> implements View.OnLayoutChangeListener {
    private static final int PERSPECTIVE_ARRAY_INVERTED_CAMERA_DISTANCE_INDEX = 2;
    private static final String STATE_BUSY = "busy";
    private static final String STATE_CHECKED = "checked";
    private static final String STATE_EXPANDED = "expanded";
    private static final String STATE_MIXED = "mixed";
    private static final float CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER = (float) Math.sqrt(5.0d);
    private static final MatrixMathHelper.MatrixDecompositionContext sMatrixDecompositionContext = new MatrixMathHelper.MatrixDecompositionContext();
    private static final double[] sTransformDecompositionArray = new double[16];

    public static class LayerEffectsHelper {
        public static void a(View view, ReadableArray readableArray, Boolean bool) {
            Paint paint;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 31) {
                view.setRenderEffect(null);
            }
            if (readableArray == null) {
                paint = null;
            } else if (FilterHelper.g(readableArray)) {
                paint = new Paint();
                paint.setColorFilter(FilterHelper.h(readableArray));
            } else {
                if (i2 >= 31) {
                    view.setRenderEffect(FilterHelper.i(readableArray));
                }
                paint = null;
            }
            if (paint == null) {
                view.setLayerType((bool == null || !bool.booleanValue()) ? 0 : 2, null);
            } else {
                view.setLayerType(2, paint);
            }
        }
    }

    public BaseViewManager() {
        super(null);
    }

    private void logUnsupportedPropertyWarning(String str) {
        FLog.s("ReactNative", "%s doesn't support property '%s'", getName(), str);
    }

    private static float sanitizeFloatPropertyValue(float f2) {
        if (f2 >= -3.4028235E38f && f2 <= Float.MAX_VALUE) {
            return f2;
        }
        if (f2 < -3.4028235E38f || f2 == Float.NEGATIVE_INFINITY) {
            return -3.4028235E38f;
        }
        if (f2 > Float.MAX_VALUE || f2 == Float.POSITIVE_INFINITY) {
            return Float.MAX_VALUE;
        }
        if (Float.isNaN(f2)) {
            return 0.0f;
        }
        throw new IllegalStateException("Invalid float property value: " + f2);
    }

    private static void setPointerEventsFlag(@NonNull View view, PointerEventHelper.EVENT event, boolean z) {
        Integer num = (Integer) view.getTag(R.id.pointer_events);
        int iIntValue = num != null ? num.intValue() : 0;
        int iOrdinal = 1 << event.ordinal();
        view.setTag(R.id.pointer_events, Integer.valueOf(z ? iOrdinal | iIntValue : (~iOrdinal) & iIntValue));
    }

    private void updateViewAccessibility(@NonNull T t) {
        boolean zIsFocusable = t.isFocusable();
        int importantForAccessibility = t.getImportantForAccessibility();
        int i2 = ReactAccessibilityDelegate.s;
        if (ViewCompat.e(t) != null) {
            return;
        }
        if (t.getTag(R.id.accessibility_role) == null && t.getTag(R.id.accessibility_state) == null && t.getTag(R.id.accessibility_actions) == null && t.getTag(R.id.react_test_id) == null && t.getTag(R.id.accessibility_collection_item) == null && t.getTag(R.id.accessibility_links) == null && t.getTag(R.id.role) == null) {
            return;
        }
        ViewCompat.z(t, new ReactAccessibilityDelegate(importantForAccessibility, t, zIsFocusable));
    }

    private void updateViewContentDescription(@NonNull T t) {
        Dynamic dynamic;
        String str = (String) t.getTag(R.id.accessibility_label);
        ReadableMap readableMap = (ReadableMap) t.getTag(R.id.accessibility_state);
        ArrayList arrayList = new ArrayList();
        ReadableMap readableMap2 = (ReadableMap) t.getTag(R.id.accessibility_value);
        if (str != null) {
            arrayList.add(str);
        }
        if (readableMap != null) {
            ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
            while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                Dynamic dynamic2 = readableMap.getDynamic(strNextKey);
                if (strNextKey.equals(STATE_CHECKED) && dynamic2.getType() == ReadableType.String && dynamic2.asString().equals(STATE_MIXED)) {
                    arrayList.add(t.getContext().getString(R.string.state_mixed_description));
                } else if (strNextKey.equals(STATE_BUSY) && dynamic2.getType() == ReadableType.Boolean && dynamic2.asBoolean()) {
                    arrayList.add(t.getContext().getString(R.string.state_busy_description));
                }
            }
        }
        if (readableMap2 != null && readableMap2.hasKey("text") && (dynamic = readableMap2.getDynamic("text")) != null && dynamic.getType() == ReadableType.String) {
            arrayList.add(dynamic.asString());
        }
        if (arrayList.size() > 0) {
            t.setContentDescription(TextUtils.join(", ", arrayList));
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        Map<String, Object> exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new HashMap<>();
        }
        MapBuilder.Builder builderA = MapBuilder.a();
        builderA.b("topPointerCancel", MapBuilder.c("phasedRegistrationNames", MapBuilder.d("bubbled", "onPointerCancel", "captured", "onPointerCancelCapture")));
        builderA.b("topPointerDown", MapBuilder.c("phasedRegistrationNames", MapBuilder.d("bubbled", "onPointerDown", "captured", "onPointerDownCapture")));
        Boolean bool = Boolean.TRUE;
        builderA.b("topPointerEnter", MapBuilder.c("phasedRegistrationNames", MapBuilder.e("bubbled", "onPointerEnter", "captured", "onPointerEnterCapture", "skipBubbling", bool)));
        builderA.b("topPointerLeave", MapBuilder.c("phasedRegistrationNames", MapBuilder.e("bubbled", "onPointerLeave", "captured", "onPointerLeaveCapture", "skipBubbling", bool)));
        builderA.b("topPointerMove", MapBuilder.c("phasedRegistrationNames", MapBuilder.d("bubbled", "onPointerMove", "captured", "onPointerMoveCapture")));
        builderA.b("topPointerUp", MapBuilder.c("phasedRegistrationNames", MapBuilder.d("bubbled", "onPointerUp", "captured", "onPointerUpCapture")));
        builderA.b("topPointerOut", MapBuilder.c("phasedRegistrationNames", MapBuilder.d("bubbled", "onPointerOut", "captured", "onPointerOutCapture")));
        builderA.b("topPointerOver", MapBuilder.c("phasedRegistrationNames", MapBuilder.d("bubbled", "onPointerOver", "captured", "onPointerOverCapture")));
        builderA.b("topClick", MapBuilder.c("phasedRegistrationNames", MapBuilder.d("bubbled", "onClick", "captured", "onClickCapture")));
        exportedCustomDirectEventTypeConstants.putAll(builderA.a());
        return exportedCustomDirectEventTypeConstants;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @Nullable
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new HashMap<>();
        }
        MapBuilder.Builder builderA = MapBuilder.a();
        builderA.b("topAccessibilityAction", MapBuilder.c("registrationName", "onAccessibilityAction"));
        exportedCustomDirectEventTypeConstants.putAll(builderA.a());
        return exportedCustomDirectEventTypeConstants;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(@NonNull T t) {
        super.onAfterUpdateTransaction(t);
        updateViewAccessibility(t);
        Boolean bool = (Boolean) t.getTag(R.id.invalidate_transform);
        if (bool != null && bool.booleanValue()) {
            t.addOnLayoutChangeListener(this);
            setTransformProperty(t, (ReadableArray) t.getTag(R.id.transform), (ReadableArray) t.getTag(R.id.transform_origin));
            t.setTag(R.id.invalidate_transform, Boolean.FALSE);
        }
        LayerEffectsHelper.a(t, (ReadableArray) t.getTag(R.id.filter), (Boolean) t.getTag(R.id.use_hardware_layer));
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = i8 - i6;
        int i11 = i4 - i2;
        if (i5 - i3 == i9 - i7 && i11 == i10) {
            return;
        }
        ReadableArray readableArray = (ReadableArray) view.getTag(R.id.transform_origin);
        ReadableArray readableArray2 = (ReadableArray) view.getTag(R.id.transform);
        if (readableArray2 == null && readableArray == null) {
            return;
        }
        setTransformProperty(view, readableArray2, readableArray);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @Nullable
    public T prepareToRecycleView(@NonNull ThemedReactContext themedReactContext, T t) {
        t.setTag(null);
        t.setTag(R.id.pointer_events, null);
        t.setTag(R.id.react_test_id, null);
        t.setTag(R.id.view_tag_native_id, null);
        t.setTag(R.id.labelled_by, null);
        t.setTag(R.id.accessibility_label, null);
        t.setTag(R.id.accessibility_hint, null);
        t.setTag(R.id.accessibility_role, null);
        t.setTag(R.id.accessibility_state, null);
        t.setTag(R.id.accessibility_actions, null);
        t.setTag(R.id.accessibility_value, null);
        t.setTag(R.id.accessibility_state_expanded, null);
        t.setTag(R.id.view_clipped, null);
        setTransformProperty(t, null, null);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 28) {
            return null;
        }
        t.resetPivot();
        t.setTop(0);
        t.setBottom(0);
        t.setLeft(0);
        t.setRight(0);
        t.setElevation(0.0f);
        if (i2 >= 29) {
            t.setAnimationMatrix(null);
        }
        t.setTag(R.id.transform, null);
        t.setTag(R.id.transform_origin, null);
        t.setTag(R.id.invalidate_transform, null);
        t.removeOnLayoutChangeListener(this);
        t.setTag(R.id.use_hardware_layer, null);
        t.setTag(R.id.filter, null);
        t.setTag(R.id.mix_blend_mode, null);
        LayerEffectsHelper.a(t, null, null);
        if (i2 >= 28) {
            t.setOutlineAmbientShadowColor(-16777216);
            t.setOutlineSpotShadowColor(-16777216);
        }
        t.setNextFocusDownId(-1);
        t.setNextFocusForwardId(-1);
        t.setNextFocusRightId(-1);
        t.setNextFocusUpId(-1);
        t.setFocusable(false);
        t.setFocusableInTouchMode(false);
        t.setElevation(0.0f);
        t.setAlpha(1.0f);
        setPadding(t, 0, 0, 0, 0);
        t.setForeground(null);
        return t;
    }

    @ReactProp(name = "accessibilityActions")
    public void setAccessibilityActions(T t, ReadableArray readableArray) {
        if (readableArray == null) {
            return;
        }
        t.setTag(R.id.accessibility_actions, readableArray);
    }

    @ReactProp(name = "accessibilityCollection")
    public void setAccessibilityCollection(@NonNull T t, @Nullable ReadableMap readableMap) {
        t.setTag(R.id.accessibility_collection, readableMap);
    }

    @ReactProp(name = "accessibilityCollectionItem")
    public void setAccessibilityCollectionItem(@NonNull T t, @Nullable ReadableMap readableMap) {
        t.setTag(R.id.accessibility_collection_item, readableMap);
    }

    @ReactProp(name = "accessibilityHint")
    public void setAccessibilityHint(@NonNull T t, @Nullable String str) {
        t.setTag(R.id.accessibility_hint, str);
        updateViewContentDescription(t);
    }

    @ReactProp(name = "accessibilityLabel")
    public void setAccessibilityLabel(@NonNull T t, @Nullable String str) {
        t.setTag(R.id.accessibility_label, str);
        updateViewContentDescription(t);
    }

    @ReactProp(name = "accessibilityLabelledBy")
    public void setAccessibilityLabelledBy(@NonNull T t, @Nullable Dynamic dynamic) {
        if (dynamic.isNull()) {
            return;
        }
        if (dynamic.getType() == ReadableType.String) {
            t.setTag(R.id.labelled_by, dynamic.asString());
        } else if (dynamic.getType() == ReadableType.Array) {
            t.setTag(R.id.labelled_by, dynamic.asArray().getString(0));
        }
    }

    @ReactProp(name = "accessibilityLiveRegion")
    public void setAccessibilityLiveRegion(@NonNull T t, @Nullable String str) {
        if (str == null || str.equals("none")) {
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            t.setAccessibilityLiveRegion(0);
        } else if (str.equals("polite")) {
            WeakHashMap weakHashMap2 = ViewCompat.f3080a;
            t.setAccessibilityLiveRegion(1);
        } else if (str.equals("assertive")) {
            WeakHashMap weakHashMap3 = ViewCompat.f3080a;
            t.setAccessibilityLiveRegion(2);
        }
    }

    @ReactProp(name = "accessibilityRole")
    public void setAccessibilityRole(@NonNull T t, @Nullable String str) {
        if (str == null) {
            t.setTag(R.id.accessibility_role, null);
        } else {
            t.setTag(R.id.accessibility_role, ReactAccessibilityDelegate.AccessibilityRole.a(str));
        }
    }

    @ReactProp(name = "accessibilityValue")
    public void setAccessibilityValue(T t, ReadableMap readableMap) {
        if (readableMap == null) {
            t.setTag(R.id.accessibility_value, null);
            t.setContentDescription(null);
        } else {
            t.setTag(R.id.accessibility_value, readableMap);
            if (readableMap.hasKey("text")) {
                updateViewContentDescription(t);
            }
        }
    }

    @ReactProp(customType = "Color", defaultInt = 0, name = "backgroundColor")
    public void setBackgroundColor(@NonNull T t, @ColorInt int i2) {
        BackgroundStyleApplicator.i(t, Integer.valueOf(i2));
    }

    public void setBorderBottomLeftRadius(T t, float f2) {
        logUnsupportedPropertyWarning(Snapshot.BORDER_BOTTOM_LEFT_RADIUS);
    }

    public void setBorderBottomRightRadius(T t, float f2) {
        logUnsupportedPropertyWarning(Snapshot.BORDER_BOTTOM_RIGHT_RADIUS);
    }

    public void setBorderRadius(T t, float f2) {
        logUnsupportedPropertyWarning(Snapshot.BORDER_RADIUS);
    }

    public void setBorderTopLeftRadius(T t, float f2) {
        logUnsupportedPropertyWarning(Snapshot.BORDER_TOP_LEFT_RADIUS);
    }

    public void setBorderTopRightRadius(T t, float f2) {
        logUnsupportedPropertyWarning(Snapshot.BORDER_TOP_RIGHT_RADIUS);
    }

    @ReactProp(customType = "BoxShadow", name = "boxShadow")
    public void setBoxShadow(T view, @Nullable ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (readableArray == null) {
            BackgroundStyleApplicator.o(view, EmptyList.f53609a);
            return;
        }
        ArrayList arrayList = new ArrayList();
        int size = readableArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            ReadableMap map = readableArray.getMap(i2);
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            BoxShadow boxShadowA = BoxShadow.Companion.a(context, map);
            if (boxShadowA == null) {
                throw new IllegalStateException("Required value was null.");
            }
            arrayList.add(boxShadowA);
        }
        BackgroundStyleApplicator.o(view, arrayList);
    }

    @ReactProp(name = "onClick")
    public void setClick(@NonNull T t, boolean z) {
        setPointerEventsFlag(t, PointerEventHelper.EVENT.f19759c, z);
    }

    @ReactProp(name = "onClickCapture")
    public void setClickCapture(@NonNull T t, boolean z) {
        setPointerEventsFlag(t, PointerEventHelper.EVENT.f19760d, z);
    }

    @ReactProp(name = "elevation")
    public void setElevation(@NonNull T t, float f2) {
        ViewCompat.E(t, PixelUtil.b(f2));
    }

    @ReactProp(customType = "Filter", name = "filter")
    public void setFilter(@NonNull T t, @Nullable ReadableArray readableArray) {
        if (ViewUtil.b(t) == 2) {
            t.setTag(R.id.filter, readableArray);
        }
    }

    @ReactProp(name = "importantForAccessibility")
    public void setImportantForAccessibility(@NonNull T t, @Nullable String str) {
        if (str == null || str.equals("auto")) {
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            t.setImportantForAccessibility(0);
            return;
        }
        if (str.equals("yes")) {
            WeakHashMap weakHashMap2 = ViewCompat.f3080a;
            t.setImportantForAccessibility(1);
        } else if (str.equals("no")) {
            WeakHashMap weakHashMap3 = ViewCompat.f3080a;
            t.setImportantForAccessibility(2);
        } else if (str.equals("no-hide-descendants")) {
            WeakHashMap weakHashMap4 = ViewCompat.f3080a;
            t.setImportantForAccessibility(4);
        }
    }

    @ReactProp(name = "mixBlendMode")
    public void setMixBlendMode(@NonNull T t, @Nullable String str) {
        if (ViewUtil.b(t) == 2) {
            t.setTag(R.id.mix_blend_mode, BlendModeHelper.b(str));
            if (t.getParent() instanceof View) {
                ((View) t.getParent()).invalidate();
            }
        }
    }

    @ReactProp(name = "onMoveShouldSetResponder")
    public void setMoveShouldSetResponder(@NonNull T t, boolean z) {
    }

    @ReactProp(name = "onMoveShouldSetResponderCapture")
    public void setMoveShouldSetResponderCapture(@NonNull T t, boolean z) {
    }

    @ReactProp(name = "nativeID")
    public void setNativeId(@NonNull T t, @Nullable String str) {
        t.setTag(R.id.view_tag_native_id, str);
        ReactFindViewUtil.b(t);
    }

    @ReactProp(defaultFloat = 1.0f, name = "opacity")
    public void setOpacity(@NonNull T t, float f2) {
        t.setAlpha(f2);
    }

    @ReactProp(customType = "Color", name = "outlineColor")
    public void setOutlineColor(T view, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (ViewUtil.b(view) != 2) {
            return;
        }
        OutlineDrawable outlineDrawableF = BackgroundStyleApplicator.f(view);
        if (num != null) {
            outlineDrawableF.d(num.intValue());
        }
    }

    @ReactProp(name = "outlineOffset")
    public void setOutlineOffset(T view, float f2) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (ViewUtil.b(view) != 2) {
            return;
        }
        BackgroundStyleApplicator.f(view).e(PixelUtil.b(f2));
    }

    @ReactProp(name = "outlineStyle")
    public void setOutlineStyle(T view, @Nullable String str) {
        OutlineStyle outlineStyleA = str == null ? null : OutlineStyle.a(str);
        Intrinsics.checkNotNullParameter(view, "view");
        if (ViewUtil.b(view) != 2) {
            return;
        }
        OutlineDrawable outlineDrawableF = BackgroundStyleApplicator.f(view);
        if (outlineStyleA != null) {
            outlineDrawableF.f(outlineStyleA);
        }
    }

    @ReactProp(name = "outlineWidth")
    public void setOutlineWidth(T view, float f2) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (ViewUtil.b(view) != 2) {
            return;
        }
        BackgroundStyleApplicator.f(view).g(PixelUtil.b(f2));
    }

    @ReactProp(name = "onPointerEnter")
    public void setPointerEnter(@NonNull T t, boolean z) {
        setPointerEventsFlag(t, PointerEventHelper.EVENT.f19763g, z);
    }

    @ReactProp(name = "onPointerEnterCapture")
    public void setPointerEnterCapture(@NonNull T t, boolean z) {
        setPointerEventsFlag(t, PointerEventHelper.EVENT.f19764h, z);
    }

    @ReactProp(name = "onPointerLeave")
    public void setPointerLeave(@NonNull T t, boolean z) {
        setPointerEventsFlag(t, PointerEventHelper.EVENT.f19765i, z);
    }

    @ReactProp(name = "onPointerLeaveCapture")
    public void setPointerLeaveCapture(@NonNull T t, boolean z) {
        setPointerEventsFlag(t, PointerEventHelper.EVENT.f19766j, z);
    }

    @ReactProp(name = "onPointerMove")
    public void setPointerMove(@NonNull T t, boolean z) {
        setPointerEventsFlag(t, PointerEventHelper.EVENT.f19767k, z);
    }

    @ReactProp(name = "onPointerMoveCapture")
    public void setPointerMoveCapture(@NonNull T t, boolean z) {
        setPointerEventsFlag(t, PointerEventHelper.EVENT.f19768l, z);
    }

    @ReactProp(name = "onPointerOut")
    public void setPointerOut(@NonNull T t, boolean z) {
        setPointerEventsFlag(t, PointerEventHelper.EVENT.o, z);
    }

    @ReactProp(name = "onPointerOutCapture")
    public void setPointerOutCapture(@NonNull T t, boolean z) {
        setPointerEventsFlag(t, PointerEventHelper.EVENT.p, z);
    }

    @ReactProp(name = "onPointerOver")
    public void setPointerOver(@NonNull T t, boolean z) {
        setPointerEventsFlag(t, PointerEventHelper.EVENT.q, z);
    }

    @ReactProp(name = "onPointerOverCapture")
    public void setPointerOverCapture(@NonNull T t, boolean z) {
        setPointerEventsFlag(t, PointerEventHelper.EVENT.r, z);
    }

    @ReactProp(name = "renderToHardwareTextureAndroid")
    public void setRenderToHardwareTexture(@NonNull T t, boolean z) {
        t.setTag(R.id.use_hardware_layer, Boolean.valueOf(z));
    }

    @ReactProp(name = "onResponderEnd")
    public void setResponderEnd(@NonNull T t, boolean z) {
    }

    @ReactProp(name = "onResponderGrant")
    public void setResponderGrant(@NonNull T t, boolean z) {
    }

    @ReactProp(name = "onResponderMove")
    public void setResponderMove(@NonNull T t, boolean z) {
    }

    @ReactProp(name = "onResponderReject")
    public void setResponderReject(@NonNull T t, boolean z) {
    }

    @ReactProp(name = "onResponderRelease")
    public void setResponderRelease(@NonNull T t, boolean z) {
    }

    @ReactProp(name = "onResponderStart")
    public void setResponderStart(@NonNull T t, boolean z) {
    }

    @ReactProp(name = "onResponderTerminate")
    public void setResponderTerminate(@NonNull T t, boolean z) {
    }

    @ReactProp(name = "onResponderTerminationRequest")
    public void setResponderTerminationRequest(@NonNull T t, boolean z) {
    }

    @ReactProp(name = "role")
    public void setRole(@NonNull T t, @Nullable String str) {
        ReactAccessibilityDelegate.Role role = null;
        if (str == null) {
            t.setTag(R.id.role, null);
            return;
        }
        int i2 = R.id.role;
        ReactAccessibilityDelegate.Role[] roleArrValues = ReactAccessibilityDelegate.Role.values();
        int length = roleArrValues.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            ReactAccessibilityDelegate.Role role2 = roleArrValues[i3];
            if (role2.name().equalsIgnoreCase(str)) {
                role = role2;
                break;
            }
            i3++;
        }
        t.setTag(i2, role);
    }

    @ReactProp(name = "rotation")
    @Deprecated
    public void setRotation(@NonNull T t, float f2) {
        t.setRotation(f2);
    }

    @ReactProp(defaultFloat = 1.0f, name = "scaleX")
    @Deprecated
    public void setScaleX(@NonNull T t, float f2) {
        t.setScaleX(f2);
    }

    @ReactProp(defaultFloat = 1.0f, name = "scaleY")
    @Deprecated
    public void setScaleY(@NonNull T t, float f2) {
        t.setScaleY(f2);
    }

    @ReactProp(customType = "Color", defaultInt = -16777216, name = "shadowColor")
    public void setShadowColor(@NonNull T t, int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            t.setOutlineAmbientShadowColor(i2);
            t.setOutlineSpotShadowColor(i2);
        }
    }

    @ReactProp(name = "onShouldBlockNativeResponder")
    public void setShouldBlockNativeResponder(@NonNull T t, boolean z) {
    }

    @ReactProp(name = "onStartShouldSetResponder")
    public void setStartShouldSetResponder(@NonNull T t, boolean z) {
    }

    @ReactProp(name = "onStartShouldSetResponderCapture")
    public void setStartShouldSetResponderCapture(@NonNull T t, boolean z) {
    }

    @ReactProp(name = "testID")
    public void setTestId(@NonNull T t, @Nullable String str) {
        t.setTag(R.id.react_test_id, str);
        t.setTag(str);
    }

    @ReactProp(name = "onTouchCancel")
    public void setTouchCancel(@NonNull T t, boolean z) {
    }

    @ReactProp(name = "onTouchEnd")
    public void setTouchEnd(@NonNull T t, boolean z) {
    }

    @ReactProp(name = "onTouchMove")
    public void setTouchMove(@NonNull T t, boolean z) {
    }

    @ReactProp(name = "onTouchStart")
    public void setTouchStart(@NonNull T t, boolean z) {
    }

    @ReactProp(name = "transform")
    public void setTransform(@NonNull T t, @Nullable ReadableArray readableArray) {
        if (Objects.equals((ReadableArray) t.getTag(R.id.transform), readableArray)) {
            return;
        }
        t.setTag(R.id.transform, readableArray);
        t.setTag(R.id.invalidate_transform, Boolean.TRUE);
    }

    @ReactProp(name = "transformOrigin")
    public void setTransformOrigin(@NonNull T t, @Nullable ReadableArray readableArray) {
        if (Objects.equals((ReadableArray) t.getTag(R.id.transform_origin), readableArray)) {
            return;
        }
        t.setTag(R.id.transform_origin, readableArray);
        t.setTag(R.id.invalidate_transform, Boolean.TRUE);
    }

    public void setTransformProperty(@NonNull T t, @Nullable ReadableArray readableArray, @Nullable ReadableArray readableArray2) {
        if (readableArray == null) {
            t.setTranslationX(PixelUtil.b(0.0f));
            t.setTranslationY(PixelUtil.b(0.0f));
            t.setRotation(0.0f);
            t.setRotationX(0.0f);
            t.setRotationY(0.0f);
            t.setScaleX(1.0f);
            t.setScaleY(1.0f);
            t.setCameraDistance(0.0f);
            return;
        }
        boolean z = ViewUtil.b(t) == 2;
        MatrixMathHelper.MatrixDecompositionContext matrixDecompositionContext = sMatrixDecompositionContext;
        matrixDecompositionContext.a();
        double[] dArr = sTransformDecompositionArray;
        TransformHelper.c(readableArray, dArr, PixelUtil.a(t.getWidth()), PixelUtil.a(t.getHeight()), readableArray2, z);
        MatrixMathHelper.b(dArr, matrixDecompositionContext);
        t.setTranslationX(PixelUtil.b(sanitizeFloatPropertyValue((float) matrixDecompositionContext.f19401d[0])));
        t.setTranslationY(PixelUtil.b(sanitizeFloatPropertyValue((float) matrixDecompositionContext.f19401d[1])));
        t.setRotation(sanitizeFloatPropertyValue((float) matrixDecompositionContext.f19402e[2]));
        t.setRotationX(sanitizeFloatPropertyValue((float) matrixDecompositionContext.f19402e[0]));
        t.setRotationY(sanitizeFloatPropertyValue((float) matrixDecompositionContext.f19402e[1]));
        t.setScaleX(sanitizeFloatPropertyValue((float) matrixDecompositionContext.f19399b[0]));
        t.setScaleY(sanitizeFloatPropertyValue((float) matrixDecompositionContext.f19399b[1]));
        double[] dArr2 = matrixDecompositionContext.f19398a;
        if (dArr2.length > 2) {
            float f2 = (float) dArr2[2];
            if (f2 == 0.0f) {
                f2 = 7.8125E-4f;
            }
            float f3 = (-1.0f) / f2;
            float f4 = DisplayMetricsHolder.c().density;
            t.setCameraDistance(sanitizeFloatPropertyValue(f4 * f4 * f3 * CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER));
        }
    }

    @ReactProp(defaultFloat = 0.0f, name = "translateX")
    @Deprecated
    public void setTranslateX(@NonNull T t, float f2) {
        t.setTranslationX(PixelUtil.b(f2));
    }

    @ReactProp(defaultFloat = 0.0f, name = "translateY")
    @Deprecated
    public void setTranslateY(@NonNull T t, float f2) {
        t.setTranslationY(PixelUtil.b(f2));
    }

    @ReactProp(name = "accessibilityState")
    public void setViewState(@NonNull T t, @Nullable ReadableMap readableMap) {
        if (readableMap == null) {
            return;
        }
        if (readableMap.hasKey(STATE_EXPANDED)) {
            t.setTag(R.id.accessibility_state_expanded, Boolean.valueOf(readableMap.getBoolean(STATE_EXPANDED)));
        }
        if (readableMap.hasKey("selected")) {
            boolean zIsSelected = t.isSelected();
            boolean z = readableMap.getBoolean("selected");
            t.setSelected(z);
            if (t.isAccessibilityFocused() && zIsSelected && !z) {
                t.announceForAccessibility(t.getContext().getString(R.string.state_unselected_description));
            }
        } else {
            t.setSelected(false);
        }
        t.setTag(R.id.accessibility_state, readableMap);
        if (readableMap.hasKey("disabled") && !readableMap.getBoolean("disabled")) {
            t.setEnabled(true);
        }
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            if (strNextKey.equals(STATE_BUSY) || strNextKey.equals(STATE_EXPANDED) || (strNextKey.equals(STATE_CHECKED) && readableMap.getType(STATE_CHECKED) == ReadableType.String)) {
                updateViewContentDescription(t);
                return;
            } else if (t.isAccessibilityFocused()) {
                t.sendAccessibilityEvent(1);
            }
        }
    }

    @ReactProp(name = "zIndex")
    public void setZIndex(@NonNull T t, float f2) {
        ViewGroupManager.setViewZIndex(t, Math.round(f2));
        ViewParent parent = t.getParent();
        if (parent instanceof ReactZIndexedViewGroup) {
            ((ReactZIndexedViewGroup) parent).updateDrawingOrder();
        }
    }

    public BaseViewManager(@Nullable ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }
}
