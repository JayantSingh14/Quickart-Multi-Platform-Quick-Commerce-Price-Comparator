package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.ClassUtils;
import org.xbill.DNS.Type;

/* loaded from: classes.dex */
public class RNSVGSvgViewAndroidManagerDelegate<T extends View, U extends BaseViewManager<T, ? extends LayoutShadowNode> & RNSVGSvgViewAndroidManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public final void a(View view, String str, Object obj) {
        str.getClass();
        BaseViewManager baseViewManager = this.f19368a;
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2064426617:
                if (str.equals("bbHeight")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1989576717:
                if (str.equals("borderRightColor")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1697814026:
                if (str.equals("backfaceVisibility")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1567958285:
                if (str.equals("vbHeight")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1470826662:
                if (str.equals("borderTopColor")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1308858324:
                if (str.equals("borderBottomColor")) {
                    c2 = 5;
                    break;
                }
                break;
            case -1228066334:
                if (str.equals(Snapshot.BORDER_TOP_LEFT_RADIUS)) {
                    c2 = 6;
                    break;
                }
                break;
            case -1141400650:
                if (str.equals("accessible")) {
                    c2 = 7;
                    break;
                }
                break;
            case -1122140597:
                if (str.equals("borderTopStartRadius")) {
                    c2 = '\b';
                    break;
                }
                break;
            case -867333731:
                if (str.equals("borderBottomStartRadius")) {
                    c2 = '\t';
                    break;
                }
                break;
            case -679581037:
                if (str.equals("hasTVPreferredFocus")) {
                    c2 = '\n';
                    break;
                }
                break;
            case -631506969:
                if (str.equals("nextFocusDown")) {
                    c2 = 11;
                    break;
                }
                break;
            case -631278772:
                if (str.equals("nextFocusLeft")) {
                    c2 = '\f';
                    break;
                }
                break;
            case -483490364:
                if (str.equals("borderTopEndRadius")) {
                    c2 = CharUtils.CR;
                    break;
                }
                break;
            case -329721498:
                if (str.equals("bbWidth")) {
                    c2 = 14;
                    break;
                }
                break;
            case -293492298:
                if (str.equals("pointerEvents")) {
                    c2 = 15;
                    break;
                }
                break;
            case -252105751:
                if (str.equals("removeClippedSubviews")) {
                    c2 = 16;
                    break;
                }
                break;
            case -242276144:
                if (str.equals("borderLeftColor")) {
                    c2 = 17;
                    break;
                }
                break;
            case -223134121:
                if (str.equals("borderStartEndRadius")) {
                    c2 = 18;
                    break;
                }
                break;
            case -148030058:
                if (str.equals("borderBottomEndRadius")) {
                    c2 = 19;
                    break;
                }
                break;
            case -109689771:
                if (str.equals("nativeForegroundAndroid")) {
                    c2 = 20;
                    break;
                }
                break;
            case -27894242:
                if (str.equals("borderStartStartRadius")) {
                    c2 = 21;
                    break;
                }
                break;
            case 3351622:
                if (str.equals("minX")) {
                    c2 = 22;
                    break;
                }
                break;
            case 3351623:
                if (str.equals("minY")) {
                    c2 = 23;
                    break;
                }
                break;
            case 92903173:
                if (str.equals("align")) {
                    c2 = 24;
                    break;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    c2 = 25;
                    break;
                }
                break;
            case 240482938:
                if (str.equals("vbWidth")) {
                    c2 = 26;
                    break;
                }
                break;
            case 306963138:
                if (str.equals("borderBlockStartColor")) {
                    c2 = 27;
                    break;
                }
                break;
            case 333432965:
                if (str.equals(Snapshot.BORDER_TOP_RIGHT_RADIUS)) {
                    c2 = 28;
                    break;
                }
                break;
            case 503397728:
                if (str.equals("nextFocusForward")) {
                    c2 = 29;
                    break;
                }
                break;
            case 581268560:
                if (str.equals(Snapshot.BORDER_BOTTOM_LEFT_RADIUS)) {
                    c2 = 30;
                    break;
                }
                break;
            case 588239831:
                if (str.equals(Snapshot.BORDER_BOTTOM_RIGHT_RADIUS)) {
                    c2 = 31;
                    break;
                }
                break;
            case 660795168:
                if (str.equals("nextFocusUp")) {
                    c2 = ' ';
                    break;
                }
                break;
            case 684610594:
                if (str.equals("borderBlockColor")) {
                    c2 = '!';
                    break;
                }
                break;
            case 722830999:
                if (str.equals("borderColor")) {
                    c2 = '\"';
                    break;
                }
                break;
            case 737768677:
                if (str.equals("borderStyle")) {
                    c2 = '#';
                    break;
                }
                break;
            case 762983977:
                if (str.equals("borderBlockEndColor")) {
                    c2 = '$';
                    break;
                }
                break;
            case 910681861:
                if (str.equals("borderEndStartRadius")) {
                    c2 = '%';
                    break;
                }
                break;
            case 926871597:
                if (str.equals("hitSlop")) {
                    c2 = '&';
                    break;
                }
                break;
            case 1220735892:
                if (str.equals("borderEndColor")) {
                    c2 = '\'';
                    break;
                }
                break;
            case 1349188574:
                if (str.equals(Snapshot.BORDER_RADIUS)) {
                    c2 = '(';
                    break;
                }
                break;
            case 1629011506:
                if (str.equals("focusable")) {
                    c2 = ')';
                    break;
                }
                break;
            case 1667773924:
                if (str.equals("needsOffscreenAlphaCompositing")) {
                    c2 = '*';
                    break;
                }
                break;
            case 1735382270:
                if (str.equals("borderEndEndRadius")) {
                    c2 = '+';
                    break;
                }
                break;
            case 1747724810:
                if (str.equals("nativeBackgroundAndroid")) {
                    c2 = ',';
                    break;
                }
                break;
            case 1908075304:
                if (str.equals("meetOrSlice")) {
                    c2 = Soundex.SILENT_MARKER;
                    break;
                }
                break;
            case 1910855543:
                if (str.equals("nextFocusRight")) {
                    c2 = ClassUtils.PACKAGE_SEPARATOR_CHAR;
                    break;
                }
                break;
            case 2119889261:
                if (str.equals("borderStartColor")) {
                    c2 = '/';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setBbHeight(view, new DynamicFromObject(obj));
                break;
            case 1:
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setBorderRightColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 2:
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setBackfaceVisibility(view, obj != null ? (String) obj : null);
                break;
            case 3:
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setVbHeight(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 4:
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setBorderTopColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 5:
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setBorderBottomColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 6:
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setBorderTopLeftRadius(view, new DynamicFromObject(obj));
                break;
            case 7:
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setAccessible(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '\b':
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setBorderTopStartRadius(view, new DynamicFromObject(obj));
                break;
            case '\t':
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setBorderBottomStartRadius(view, new DynamicFromObject(obj));
                break;
            case '\n':
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setHasTVPreferredFocus(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 11:
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setNextFocusDown(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case '\f':
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setNextFocusLeft(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case '\r':
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setBorderTopEndRadius(view, new DynamicFromObject(obj));
                break;
            case 14:
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setBbWidth(view, new DynamicFromObject(obj));
                break;
            case 15:
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setPointerEvents(view, obj != null ? (String) obj : null);
                break;
            case 16:
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setRemoveClippedSubviews(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case 17:
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setBorderLeftColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 18:
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setBorderStartEndRadius(view, new DynamicFromObject(obj));
                break;
            case 19:
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setBorderBottomEndRadius(view, new DynamicFromObject(obj));
                break;
            case 20:
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setNativeForegroundAndroid(view, (ReadableMap) obj);
                break;
            case 21:
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setBorderStartStartRadius(view, new DynamicFromObject(obj));
                break;
            case 22:
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setMinX(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 23:
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setMinY(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 24:
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setAlign(view, obj != null ? (String) obj : null);
                break;
            case 25:
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 26:
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setVbWidth(view, obj != null ? ((Double) obj).floatValue() : 0.0f);
                break;
            case 27:
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setBorderBlockStartColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case 28:
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setBorderTopRightRadius(view, new DynamicFromObject(obj));
                break;
            case 29:
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setNextFocusForward(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case 30:
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setBorderBottomLeftRadius(view, new DynamicFromObject(obj));
                break;
            case 31:
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setBorderBottomRightRadius(view, new DynamicFromObject(obj));
                break;
            case ' ':
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setNextFocusUp(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case '!':
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setBorderBlockColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case '\"':
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setBorderColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case '#':
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setBorderStyle(view, obj != null ? (String) obj : null);
                break;
            case '$':
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setBorderBlockEndColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case '%':
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setBorderEndStartRadius(view, new DynamicFromObject(obj));
                break;
            case Type.A6 /* 38 */:
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setHitSlop(view, new DynamicFromObject(obj));
                break;
            case '\'':
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setBorderEndColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            case '(':
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setBorderRadius(view, new DynamicFromObject(obj));
                break;
            case ')':
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setFocusable(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '*':
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setNeedsOffscreenAlphaCompositing(view, obj != null ? ((Boolean) obj).booleanValue() : false);
                break;
            case '+':
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setBorderEndEndRadius(view, new DynamicFromObject(obj));
                break;
            case ',':
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setNativeBackgroundAndroid(view, (ReadableMap) obj);
                break;
            case '-':
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setMeetOrSlice(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case '.':
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setNextFocusRight(view, obj != null ? ((Double) obj).intValue() : 0);
                break;
            case '/':
                ((RNSVGSvgViewAndroidManagerInterface) baseViewManager).setBorderStartColor(view, ColorPropConverter.getColor(obj, view.getContext()));
                break;
            default:
                super.a(view, str, obj);
                break;
        }
    }
}
