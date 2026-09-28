package com.horcrux.svg;

import android.graphics.Rect;
import android.util.SparseArray;
import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface;
import com.facebook.react.views.view.ReactViewGroup;
import com.facebook.react.views.view.ReactViewManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
class SvgViewManager extends ReactViewManager implements RNSVGSvgViewAndroidManagerInterface<SvgView> {
    public static final String REACT_CLASS = "RNSVGSvgViewAndroid";
    private final ViewManagerDelegate<SvgView> mDelegate = new RNSVGSvgViewAndroidManagerDelegate(this);
    private static final SparseArray<SvgView> mTagToSvgView = new SparseArray<>();
    private static final SparseArray<Runnable> mTagToRunnable = new SparseArray<>();

    /* renamed from: com.horcrux.svg.SvgViewManager$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f45859a;

        static {
            int[] iArr = new int[ReadableType.values().length];
            f45859a = iArr;
            try {
                iArr[ReadableType.Map.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f45859a[ReadableType.Number.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f45859a[ReadableType.Null.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Nullable
    public static SvgView getSvgViewByTag(int i2) {
        return mTagToSvgView.get(i2);
    }

    public static void runWhenViewIsAvailable(int i2, Runnable runnable) {
        mTagToRunnable.put(i2, runnable);
    }

    public static void setSvgView(int i2, SvgView svgView) {
        mTagToSvgView.put(i2, svgView);
        SparseArray<Runnable> sparseArray = mTagToRunnable;
        Runnable runnable = sparseArray.get(i2);
        if (runnable != null) {
            runnable.run();
            sparseArray.delete(i2);
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ViewManagerDelegate getDelegate() {
        return this.mDelegate;
    }

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewManagerWithChildren
    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager
    @Nonnull
    public ReactViewGroup createViewInstance(ThemedReactContext themedReactContext) {
        return new SvgView(themedReactContext);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(@Nonnull ReactViewGroup reactViewGroup) {
        super.onDropViewInstance((SvgViewManager) reactViewGroup);
        mTagToSvgView.remove(reactViewGroup.getId());
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setAccessible(SvgView svgView, boolean z) {
        super.setAccessible((ReactViewGroup) svgView, z);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    @ReactProp(name = "align")
    public void setAlign(SvgView svgView, String str) {
        svgView.setAlign(str);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setBackfaceVisibility(SvgView svgView, @Nullable String str) {
        super.setBackfaceVisibility((ReactViewGroup) svgView, str);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    @ReactProp(name = "bbHeight")
    public void setBbHeight(SvgView svgView, Dynamic dynamic) {
        svgView.setBbHeight(dynamic);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    @ReactProp(name = "bbWidth")
    public void setBbWidth(SvgView svgView, Dynamic dynamic) {
        svgView.setBbWidth(dynamic);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setBorderBlockColor(SvgView svgView, @Nullable Integer num) {
        super.setBorderColor(svgView, 9, num);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setBorderBlockEndColor(SvgView svgView, @Nullable Integer num) {
        super.setBorderColor(svgView, 10, num);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setBorderBlockStartColor(SvgView svgView, @Nullable Integer num) {
        super.setBorderColor(svgView, 11, num);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setBorderBottomColor(SvgView svgView, @Nullable Integer num) {
        super.setBorderColor(svgView, 4, num);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setBorderBottomEndRadius(SvgView svgView, Dynamic dynamic) {
        super.setBorderRadius(svgView, 8, dynamic);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setBorderBottomLeftRadius(SvgView svgView, Dynamic dynamic) {
        super.setBorderRadius(svgView, 4, dynamic);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setBorderBottomRightRadius(SvgView svgView, Dynamic dynamic) {
        super.setBorderRadius(svgView, 3, dynamic);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setBorderBottomStartRadius(SvgView svgView, Dynamic dynamic) {
        super.setBorderRadius(svgView, 7, dynamic);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setBorderColor(SvgView svgView, @Nullable Integer num) {
        super.setBorderColor(svgView, 0, num);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setBorderEndColor(SvgView svgView, @Nullable Integer num) {
        super.setBorderColor(svgView, 6, num);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setBorderEndEndRadius(SvgView svgView, Dynamic dynamic) {
        super.setBorderRadius(svgView, 9, dynamic);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setBorderEndStartRadius(SvgView svgView, Dynamic dynamic) {
        super.setBorderRadius(svgView, 10, dynamic);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setBorderLeftColor(SvgView svgView, @Nullable Integer num) {
        super.setBorderColor(svgView, 1, num);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setBorderRadius(SvgView svgView, Dynamic dynamic) {
        super.setBorderRadius(svgView, 0, dynamic);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setBorderRightColor(SvgView svgView, @Nullable Integer num) {
        super.setBorderColor(svgView, 2, num);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setBorderStartColor(SvgView svgView, @Nullable Integer num) {
        super.setBorderColor(svgView, 5, num);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setBorderStartEndRadius(SvgView svgView, Dynamic dynamic) {
        super.setBorderRadius(svgView, 11, dynamic);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setBorderStartStartRadius(SvgView svgView, Dynamic dynamic) {
        super.setBorderRadius(svgView, 12, dynamic);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setBorderStyle(SvgView svgView, @Nullable String str) {
        super.setBorderStyle((ReactViewGroup) svgView, str);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setBorderTopColor(SvgView svgView, @Nullable Integer num) {
        super.setBorderColor(svgView, 3, num);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setBorderTopEndRadius(SvgView svgView, Dynamic dynamic) {
        super.setBorderRadius(svgView, 6, dynamic);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setBorderTopLeftRadius(SvgView svgView, Dynamic dynamic) {
        super.setBorderRadius(svgView, 1, dynamic);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setBorderTopRightRadius(SvgView svgView, Dynamic dynamic) {
        super.setBorderRadius(svgView, 2, dynamic);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setBorderTopStartRadius(SvgView svgView, Dynamic dynamic) {
        super.setBorderRadius(svgView, 5, dynamic);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    @ReactProp(customType = "Color", name = "color")
    public void setColor(SvgView svgView, Integer num) {
        svgView.setCurrentColor(num);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setFocusable(SvgView svgView, boolean z) {
        super.setFocusable((ReactViewGroup) svgView, z);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setHasTVPreferredFocus(SvgView svgView, boolean z) {
        super.setTVPreferredFocus(svgView, z);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setHitSlop(SvgView svgView, Dynamic dynamic) {
        int i2 = AnonymousClass1.f45859a[dynamic.getType().ordinal()];
        if (i2 == 1) {
            ReadableMap readableMapAsMap = dynamic.asMap();
            svgView.setHitSlopRect(new Rect(readableMapAsMap.hasKey("left") ? (int) PixelUtil.b((float) readableMapAsMap.getDouble("left")) : 0, readableMapAsMap.hasKey("top") ? (int) PixelUtil.b((float) readableMapAsMap.getDouble("top")) : 0, readableMapAsMap.hasKey("right") ? (int) PixelUtil.b((float) readableMapAsMap.getDouble("right")) : 0, readableMapAsMap.hasKey("bottom") ? (int) PixelUtil.b((float) readableMapAsMap.getDouble("bottom")) : 0));
        } else {
            if (i2 == 2) {
                int iB = (int) PixelUtil.b((float) dynamic.asDouble());
                svgView.setHitSlopRect(new Rect(iB, iB, iB, iB));
                return;
            }
            if (i2 != 3) {
                FLog.q("ReactNative", "Invalid type for 'hitSlop' value " + dynamic.getType());
            }
            svgView.setHitSlopRect(null);
        }
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    @ReactProp(name = "meetOrSlice")
    public void setMeetOrSlice(SvgView svgView, int i2) {
        svgView.setMeetOrSlice(i2);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    @ReactProp(name = "minX")
    public void setMinX(SvgView svgView, float f2) {
        svgView.setMinX(f2);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    @ReactProp(name = "minY")
    public void setMinY(SvgView svgView, float f2) {
        svgView.setMinY(f2);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setNativeBackgroundAndroid(SvgView svgView, @Nullable ReadableMap readableMap) {
        super.setNativeBackground(svgView, readableMap);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setNativeForegroundAndroid(SvgView svgView, @Nullable ReadableMap readableMap) {
        super.setNativeForeground(svgView, readableMap);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setNeedsOffscreenAlphaCompositing(SvgView svgView, boolean z) {
        super.setNeedsOffscreenAlphaCompositing((ReactViewGroup) svgView, z);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setNextFocusDown(SvgView svgView, int i2) {
        super.nextFocusDown(svgView, i2);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setNextFocusForward(SvgView svgView, int i2) {
        super.nextFocusForward(svgView, i2);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setNextFocusLeft(SvgView svgView, int i2) {
        super.nextFocusLeft(svgView, i2);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setNextFocusRight(SvgView svgView, int i2) {
        super.nextFocusRight(svgView, i2);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setNextFocusUp(SvgView svgView, int i2) {
        super.nextFocusUp(svgView, i2);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    @ReactProp(name = "pointerEvents")
    public void setPointerEvents(SvgView svgView, @Nullable String str) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<? super Object> superclass = svgView.getClass().getSuperclass();
            if (superclass != null) {
                Method declaredMethod = superclass.getDeclaredMethod("setPointerEvents", PointerEvents.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(svgView, PointerEvents.valueOf(str.toUpperCase(Locale.US).replace("-", Attributes.PREDEFINED_ATTRIBUTE_PREFIX)));
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    public void setRemoveClippedSubviews(SvgView svgView, boolean z) {
        super.setRemoveClippedSubviews((SvgViewManager) svgView, z);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    @ReactProp(name = "vbHeight")
    public void setVbHeight(SvgView svgView, float f2) {
        svgView.setVbHeight(f2);
    }

    @Override // com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface
    @ReactProp(name = "vbWidth")
    public void setVbWidth(SvgView svgView, float f2) {
        svgView.setVbWidth(f2);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void updateExtraData(ReactViewGroup reactViewGroup, Object obj) {
        super.updateExtraData((SvgViewManager) reactViewGroup, obj);
        reactViewGroup.invalidate();
    }
}
