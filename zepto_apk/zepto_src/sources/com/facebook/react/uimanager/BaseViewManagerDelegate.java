package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public abstract class BaseViewManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode>> implements ViewManagerDelegate<T> {

    /* renamed from: a, reason: collision with root package name */
    public final BaseViewManager f19368a;

    public BaseViewManagerDelegate(BaseViewManager mViewManager) {
        Intrinsics.checkNotNullParameter(mViewManager, "mViewManager");
        this.f19368a = mViewManager;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    @Override // com.facebook.react.uimanager.ViewManagerDelegate
    public void a(View view, String str, Object obj) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (str != null) {
            int iHashCode = str.hashCode();
            BaseViewManager baseViewManager = this.f19368a;
            switch (iHashCode) {
                case -2018402664:
                    if (str.equals("mixBlendMode")) {
                        baseViewManager.setMixBlendMode(view, (String) obj);
                        break;
                    }
                    break;
                case -1898517556:
                    if (str.equals("onPointerEnterCapture")) {
                        Boolean bool = (Boolean) obj;
                        baseViewManager.setPointerEnterCapture(view, bool != null ? bool.booleanValue() : false);
                        break;
                    }
                    break;
                case -1721943862:
                    if (str.equals("translateX")) {
                        Double d2 = (Double) obj;
                        baseViewManager.setTranslateX(view, d2 != null ? (float) d2.doubleValue() : 0.0f);
                        break;
                    }
                    break;
                case -1721943861:
                    if (str.equals("translateY")) {
                        Double d3 = (Double) obj;
                        baseViewManager.setTranslateY(view, d3 != null ? (float) d3.doubleValue() : 0.0f);
                        break;
                    }
                    break;
                case -1589741021:
                    if (str.equals("shadowColor")) {
                        Integer color = obj == null ? 0 : ColorPropConverter.getColor(obj, view.getContext());
                        Intrinsics.c(color);
                        baseViewManager.setShadowColor(view, color.intValue());
                        break;
                    }
                    break;
                case -1489432511:
                    if (str.equals("outlineColor")) {
                        baseViewManager.setOutlineColor(view, (Integer) obj);
                        break;
                    }
                    break;
                case -1474494833:
                    if (str.equals("outlineStyle")) {
                        baseViewManager.setOutlineStyle(view, (String) obj);
                        break;
                    }
                    break;
                case -1471148380:
                    if (str.equals("outlineWidth")) {
                        Double d4 = (Double) obj;
                        baseViewManager.setOutlineWidth(view, d4 != null ? (float) d4.doubleValue() : Float.NaN);
                        break;
                    }
                    break;
                case -1351902487:
                    if (str.equals("onClick")) {
                        Boolean bool2 = (Boolean) obj;
                        baseViewManager.setClick(view, bool2 != null ? bool2.booleanValue() : false);
                        break;
                    }
                    break;
                case -1274492040:
                    if (str.equals("filter")) {
                        baseViewManager.setFilter(view, (ReadableArray) obj);
                        break;
                    }
                    break;
                case -1267206133:
                    if (str.equals("opacity")) {
                        Double d5 = (Double) obj;
                        baseViewManager.setOpacity(view, d5 != null ? (float) d5.doubleValue() : 1.0f);
                        break;
                    }
                    break;
                case -1247970794:
                    if (str.equals("onPointerOutCapture")) {
                        Boolean bool3 = (Boolean) obj;
                        baseViewManager.setPointerOutCapture(view, bool3 != null ? bool3.booleanValue() : false);
                        break;
                    }
                    break;
                case -1228066334:
                    if (str.equals(Snapshot.BORDER_TOP_LEFT_RADIUS)) {
                        Double d6 = (Double) obj;
                        baseViewManager.setBorderTopLeftRadius(view, d6 != null ? (float) d6.doubleValue() : Float.NaN);
                        break;
                    }
                    break;
                case -1219666915:
                    if (str.equals("onClickCapture")) {
                        Boolean bool4 = (Boolean) obj;
                        baseViewManager.setClickCapture(view, bool4 != null ? bool4.booleanValue() : false);
                        break;
                    }
                    break;
                case -1036769289:
                    if (str.equals("onPointerMoveCapture")) {
                        Boolean bool5 = (Boolean) obj;
                        baseViewManager.setPointerMoveCapture(view, bool5 != null ? bool5.booleanValue() : false);
                        break;
                    }
                    break;
                case -908189618:
                    if (str.equals("scaleX")) {
                        Double d7 = (Double) obj;
                        baseViewManager.setScaleX(view, d7 != null ? (float) d7.doubleValue() : 1.0f);
                        break;
                    }
                    break;
                case -908189617:
                    if (str.equals("scaleY")) {
                        Double d8 = (Double) obj;
                        baseViewManager.setScaleY(view, d8 != null ? (float) d8.doubleValue() : 1.0f);
                        break;
                    }
                    break;
                case -877170387:
                    if (str.equals("testID")) {
                        baseViewManager.setTestId(view, (String) obj);
                        break;
                    }
                    break;
                case -781597262:
                    if (str.equals("transformOrigin")) {
                        baseViewManager.setTransformOrigin(view, (ReadableArray) obj);
                        break;
                    }
                    break;
                case -731417480:
                    if (str.equals("zIndex")) {
                        Double d9 = (Double) obj;
                        baseViewManager.setZIndex(view, d9 != null ? (float) d9.doubleValue() : 0.0f);
                        break;
                    }
                    break;
                case -112141555:
                    if (str.equals("onPointerLeaveCapture")) {
                        Boolean bool6 = (Boolean) obj;
                        baseViewManager.setPointerLeaveCapture(view, bool6 != null ? bool6.booleanValue() : false);
                        break;
                    }
                    break;
                case -101663499:
                    if (str.equals("accessibilityHint")) {
                        baseViewManager.setAccessibilityHint(view, (String) obj);
                        break;
                    }
                    break;
                case -101359900:
                    if (str.equals("accessibilityRole")) {
                        baseViewManager.setAccessibilityRole(view, (String) obj);
                        break;
                    }
                    break;
                case -80891667:
                    if (str.equals("renderToHardwareTextureAndroid")) {
                        Boolean bool7 = (Boolean) obj;
                        baseViewManager.setRenderToHardwareTexture(view, bool7 != null ? bool7.booleanValue() : false);
                        break;
                    }
                    break;
                case -40300674:
                    if (str.equals("rotation")) {
                        Double d10 = (Double) obj;
                        baseViewManager.setRotation(view, d10 != null ? (float) d10.doubleValue() : 0.0f);
                        break;
                    }
                    break;
                case -4379043:
                    if (str.equals("elevation")) {
                        Double d11 = (Double) obj;
                        baseViewManager.setElevation(view, d11 != null ? (float) d11.doubleValue() : 0.0f);
                        break;
                    }
                    break;
                case 3506294:
                    if (str.equals("role")) {
                        baseViewManager.setRole(view, (String) obj);
                        break;
                    }
                    break;
                case 17941018:
                    if (str.equals("onPointerEnter")) {
                        Boolean bool8 = (Boolean) obj;
                        baseViewManager.setPointerEnter(view, bool8 != null ? bool8.booleanValue() : false);
                        break;
                    }
                    break;
                case 24119801:
                    if (str.equals("onPointerLeave")) {
                        Boolean bool9 = (Boolean) obj;
                        baseViewManager.setPointerLeave(view, bool9 != null ? bool9.booleanValue() : false);
                        break;
                    }
                    break;
                case 36255470:
                    if (str.equals("accessibilityLiveRegion")) {
                        baseViewManager.setAccessibilityLiveRegion(view, (String) obj);
                        break;
                    }
                    break;
                case 132353428:
                    if (str.equals("onPointerOverCapture")) {
                        Boolean bool10 = (Boolean) obj;
                        baseViewManager.setPointerOverCapture(view, bool10 != null ? bool10.booleanValue() : false);
                        break;
                    }
                    break;
                case 317346576:
                    if (str.equals("onPointerOut")) {
                        Boolean bool11 = (Boolean) obj;
                        baseViewManager.setPointerOut(view, bool11 != null ? bool11.booleanValue() : false);
                        break;
                    }
                    break;
                case 333432965:
                    if (str.equals(Snapshot.BORDER_TOP_RIGHT_RADIUS)) {
                        Double d12 = (Double) obj;
                        baseViewManager.setBorderTopRightRadius(view, d12 != null ? (float) d12.doubleValue() : Float.NaN);
                        break;
                    }
                    break;
                case 581268560:
                    if (str.equals(Snapshot.BORDER_BOTTOM_LEFT_RADIUS)) {
                        Double d13 = (Double) obj;
                        baseViewManager.setBorderBottomLeftRadius(view, d13 != null ? (float) d13.doubleValue() : Float.NaN);
                        break;
                    }
                    break;
                case 588239831:
                    if (str.equals(Snapshot.BORDER_BOTTOM_RIGHT_RADIUS)) {
                        Double d14 = (Double) obj;
                        baseViewManager.setBorderBottomRightRadius(view, d14 != null ? (float) d14.doubleValue() : Float.NaN);
                        break;
                    }
                    break;
                case 743055051:
                    if (str.equals("boxShadow")) {
                        baseViewManager.setBoxShadow(view, (ReadableArray) obj);
                        break;
                    }
                    break;
                case 746986311:
                    if (str.equals("importantForAccessibility")) {
                        baseViewManager.setImportantForAccessibility(view, (String) obj);
                        break;
                    }
                    break;
                case 1052666732:
                    if (str.equals("transform")) {
                        baseViewManager.setTransform(view, (ReadableArray) obj);
                        break;
                    }
                    break;
                case 1146842694:
                    if (str.equals("accessibilityLabel")) {
                        baseViewManager.setAccessibilityLabel(view, (String) obj);
                        break;
                    }
                    break;
                case 1153872867:
                    if (str.equals("accessibilityState")) {
                        baseViewManager.setViewState(view, (ReadableMap) obj);
                        break;
                    }
                    break;
                case 1156088003:
                    if (str.equals("accessibilityValue")) {
                        baseViewManager.setAccessibilityValue(view, (ReadableMap) obj);
                        break;
                    }
                    break;
                case 1247744079:
                    if (str.equals("onPointerMove")) {
                        Boolean bool12 = (Boolean) obj;
                        baseViewManager.setPointerMove(view, bool12 != null ? bool12.booleanValue() : false);
                        break;
                    }
                    break;
                case 1247809874:
                    if (str.equals("onPointerOver")) {
                        Boolean bool13 = (Boolean) obj;
                        baseViewManager.setPointerOver(view, bool13 != null ? bool13.booleanValue() : false);
                        break;
                    }
                    break;
                case 1287124693:
                    if (str.equals("backgroundColor")) {
                        Integer color2 = obj == null ? 0 : ColorPropConverter.getColor(obj, view.getContext());
                        Intrinsics.c(color2);
                        baseViewManager.setBackgroundColor(view, color2.intValue());
                        break;
                    }
                    break;
                case 1349188574:
                    if (str.equals(Snapshot.BORDER_RADIUS)) {
                        Double d15 = (Double) obj;
                        baseViewManager.setBorderRadius(view, d15 != null ? (float) d15.doubleValue() : Float.NaN);
                        break;
                    }
                    break;
                case 1407295349:
                    if (str.equals("outlineOffset")) {
                        Double d16 = (Double) obj;
                        baseViewManager.setOutlineOffset(view, d16 != null ? (float) d16.doubleValue() : Float.NaN);
                        break;
                    }
                    break;
                case 1505602511:
                    if (str.equals("accessibilityActions")) {
                        baseViewManager.setAccessibilityActions(view, (ReadableArray) obj);
                        break;
                    }
                    break;
                case 1761903244:
                    if (str.equals("accessibilityCollection")) {
                        baseViewManager.setAccessibilityCollection(view, (ReadableMap) obj);
                        break;
                    }
                    break;
                case 1865277756:
                    if (str.equals("accessibilityLabelledBy")) {
                        baseViewManager.setAccessibilityLabelledBy(view, new DynamicFromObject(obj));
                        break;
                    }
                    break;
                case 1993034687:
                    if (str.equals("accessibilityCollectionItem")) {
                        baseViewManager.setAccessibilityCollectionItem(view, (ReadableMap) obj);
                        break;
                    }
                    break;
                case 2045685618:
                    if (str.equals("nativeID")) {
                        baseViewManager.setNativeId(view, (String) obj);
                        break;
                    }
                    break;
            }
        }
    }

    @Override // com.facebook.react.uimanager.ViewManagerDelegate
    public void b(View view, String str, ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(view, "view");
    }
}
